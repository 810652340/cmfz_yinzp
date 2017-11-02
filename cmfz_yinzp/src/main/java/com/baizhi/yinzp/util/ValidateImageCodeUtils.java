package com.baizhi.yinzp.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Random;

public class ValidateImageCodeUtils {
    /**
     * ��֤���Ѷȼ��� Simple-���� Medium-���ֺ�Сд��ĸ Hard-���ֺʹ�Сд��ĸ
     */
    public enum SecurityCodeLevel {
        Simple, Medium, Hard
    };
    /**
     * ����Ĭ����֤�룬4λ�е��Ѷ�
     *
     * @return
     */
    public static String getSecurityCode() {
        return getSecurityCode(4, SecurityCodeLevel.Medium, false);
    }
    /**
     * �������Ⱥ��Ѷ��������֤��
     *
     * @param length
     * @param level
     * @param isCanRepeat
     * @return
     */
    public static String getSecurityCode(int length, SecurityCodeLevel level, boolean isCanRepeat) {
        // �����ȡlen���ַ�
        int len = length;
        // �ַ����ϣ�--��ȥ�׻���������0,1,��ĸl,o,O��
        char[] codes = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
        };
        // ���ݲ�ͬ�ѶȽ�ȡ�ַ���
        if (level == SecurityCodeLevel.Simple) {
            codes = Arrays.copyOfRange(codes, 0, 10);
        } else if (level == SecurityCodeLevel.Medium) {
            codes = Arrays.copyOfRange(codes, 0, 36);
        }
        // �ַ����ͳ���
        int n = codes.length;
        // �׳�����ʱ�쳣
        if (len > n && isCanRepeat == false) {
            throw new RuntimeException(String.format("����SecurityCode.getSecurityCode(%1$s,%2$s,%3$s)�����쳣��" + "��isCanRepeatΪ%3$sʱ���������%1$s���ܴ���%4$s", len, level, isCanRepeat, n));
        }
        // ��ų�ȡ�������ַ�
        char[] result = new char[len];
        // �ж��ܷ�����ظ��ַ�
        if (isCanRepeat) {
            for (int i = 0; i < result.length; i++) {
                // ����0 and n-1
                int r = (int) (Math.random() * n);
                // ��result�еĵ�i��Ԫ������Ϊcode[r]��ŵ���ֵ
                result[i] = codes[r];
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                // ����0 and n-1
                int r = (int) (Math.random() * n);
                // ��result�еĵ�i��Ԫ������Ϊcode[r]��ŵ���ֵ
                result[i] = codes[r];
                // ����ȷ�������ٴγ�ȡ���Ǹ��ַ������������������һ���ַ���дcode[r],����n-1
                codes[r] = codes[n - 1];
                n--;
            }
        }
        return String.valueOf(result);
    }
	/**
     * ������֤��ͼƬ

     * @param securityCode

     * @return

     */
    public static BufferedImage createImage(String securityCode){

        int codeLength = securityCode.length();//��֤�볤��

        int fontSize = 18;//�����С

        int fontWidth = fontSize+1;

        //ͼƬ���

        int width = codeLength*fontWidth+6;
        int height = fontSize*2+1;
        //ͼƬ

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = image.createGraphics();

        g.setColor(Color.WHITE);//���ñ���ɫ

        g.fillRect(0, 0, width, height);//��䱳��

        g.setColor(Color.LIGHT_GRAY);//���ñ߿���ɫ

        g.setFont(new Font("Arial", Font.BOLD, height-2));//�߿�������ʽ

        g.drawRect(0, 0, width-1, height-1);//���Ʊ߿�

        //�������

        Random rand = new Random();

        g.setColor(Color.LIGHT_GRAY);

        for (int i = 0; i < codeLength*6; i++) {

            int x = rand.nextInt(width);

            int y = rand.nextInt(height);

            g.drawRect(x, y, 1, 1);//����1*1��С�ľ���

        }

        //������֤��

        int codeY = height-10;

        g.setColor(new Color(19,148,246));

        g.setFont(new Font("Georgia", Font.BOLD, fontSize));
        for(int i=0;i<codeLength;i++){
        	double deg=new Random().nextDouble()*20;
        	g.rotate(Math.toRadians(deg), i*16+13,codeY-7.5);
            g.drawString(String.valueOf(securityCode.charAt(i)), i*16+5, codeY);
            g.rotate(Math.toRadians(-deg), i*16+13,codeY-7.5);
        }
       
        g.dispose();//�ر���Դ

        return image;

    }
    
    
}
