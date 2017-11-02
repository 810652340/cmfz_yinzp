package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Admini;
import com.baizhi.yinzp.service.AdminiService;
import com.baizhi.yinzp.util.VerifyCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/25.
 */
@Controller
@RequestMapping("/admini")
public class AdminiController {
    @Autowired
    private AdminiService adminiService;
    @RequestMapping("/code")
    public void getImageCode(HttpSession session, HttpServletResponse response) throws Exception{
        String generateVerifyCode = VerifyCodeUtil.generateVerifyCode(4);

        session.setAttribute("code",generateVerifyCode);
        BufferedImage image = VerifyCodeUtil.getImage(110, 40, generateVerifyCode);
        ImageIO.write(image, "png", response.getOutputStream());
    }
    @RequestMapping("/login")
    public String login(Admini admini,String enCode,HttpSession session){
        System.out.println("==="+admini);
        Admini lg = adminiService.queryByName(admini.getName());
        String attribute = (String) session.getAttribute("code");

        System.out.println("截止"+enCode);
        System.out.print("作用于"+attribute);
        System.out.println("这是lg的"+lg);
        if(enCode.equalsIgnoreCase(attribute)){
            if (lg.getName().equals(admini.getName())&&lg.getPassword().equals(admini.getPassword())){
                session.setAttribute("name",lg);
                return "redirect:/back/page/main.jsp";
            }else{
                return "redirect:/back/page/login.jsp";
            }
        }else {
            return "redirect:/back/page/login.jsp";
        }
    }
    @RequestMapping("/update")
    public void update(Admini admini,HttpSession session){
        Admini name = (Admini)session.getAttribute("name");
        admini.setId(name.getId());
        System.out.println("admini = [" + admini + "]");
        adminiService.update(admini);
    }
}
