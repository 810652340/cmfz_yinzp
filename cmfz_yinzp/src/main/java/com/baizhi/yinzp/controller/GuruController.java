package com.baizhi.yinzp.controller;
import com.baizhi.yinzp.entity.Guru;
import com.baizhi.yinzp.service.GuruService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/29.
 */
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService guruService;
    @RequestMapping("/all")
    @ResponseBody
    public Map<String,Object> queryAll(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Guru> gurus = guruService.queryAll();
        System.out.println(gurus);
        Integer integer=10;
        System.out.println("这是个笑话");
        map.put("total",integer);
        map.put("rows",gurus);
        return map;
    }
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> save(Guru guru,MultipartFile multipartFile, HttpServletResponse response, HttpServletRequest request){
        Map<String,Object> map =new  HashMap<String,Object>();
        try {

            guru.setId(UUID.randomUUID().toString());
//        获取文件名
            System.out.println("这是测试数据");
            String s = multipartFile.getOriginalFilename();
            guru.setHeadpic(s);
            String realPath = request.getRealPath("//back//uplod//");
//        获取新的名字
            String newFileName = UUID.randomUUID().toString() +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                    "." +
                    FilenameUtils.getExtension(s);
            multipartFile.transferTo(new File(realPath, newFileName));
            guru.setHeadpic(newFileName);
            guruService.save(guru);
            map.put("success", true);
            map.put("message","保存用户成功~~~");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
    //    修改用户的状态和用户的描述
    @RequestMapping("/update")
    public void update(@RequestBody Guru guru){
        System.out.println("guru = [" + guru + "]");
        guruService.update(guru);
    }
    @RequestMapping("/one")
    @ResponseBody
    public List<Guru> queryAllOne(){
        List<Guru> gurus = guruService.queryOne();
        return gurus;
    }
}
