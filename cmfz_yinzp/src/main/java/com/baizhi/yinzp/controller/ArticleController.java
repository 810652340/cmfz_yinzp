package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Article;
import com.baizhi.yinzp.service.ArticleService;
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
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/10/30.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
//    查询所有的文件
    @RequestMapping("/all")
    @ResponseBody
    public List<Article> queryAll(){
        List<Article> articles = articleService.queryAll();
        for (Article article : articles) {
            System.out.println(article);
        }
        System.out.println("nikanshanmeloifjoewf"+articles);
        return articles;
    }
//    添加一张图片
    @ResponseBody
    @RequestMapping("/save")
    public Map<String,Object> saveOne(MultipartFile multipartFile,HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String s = multipartFile.getOriginalFilename();
            String realPath = request.getRealPath("/back/uplod/");
//        获取新的名字
            String newFileName = UUID.randomUUID().toString() +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                    "." +
                    FilenameUtils.getExtension(s);
            response.setHeader("contentType","image/jpg");
            multipartFile.transferTo(new File(realPath, newFileName));
            map.put("error",0);
            map.put("url","/cmfz_yinzp/back/uplod/"+newFileName);
            System.out.println(realPath+""+newFileName);
        }catch (Exception e){
            e.printStackTrace();
            map.put("error", 1);
            map.put("url", e.getMessage());
        }
        return map;
    }
    @RequestMapping("/add")
    @ResponseBody
    public Map<String, Object> add(String guruid,Article article,MultipartFile multipartFile,HttpServletResponse response,HttpServletRequest request) throws IOException {
        System.out.println(article);
        System.out.println(guruid+article);
        Map<String,Object> map =new  HashMap<String,Object>();
        try {

            article.setId(UUID.randomUUID().toString());
//        获取文件名
            System.out.println("这是测试数据");
            String s = multipartFile.getOriginalFilename();
            String realPath = request.getRealPath("//back//uplod//");
//        获取新的名字
            String newFileName = UUID.randomUUID().toString() +
                    new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                    "." +
                    FilenameUtils.getExtension(s);

            multipartFile.transferTo(new File(realPath, newFileName));
            article.setExt("不懂");
            article.setLink("不懂");
            article.setIllustration(newFileName);
            article.setGuruid(guruid);
            article.setCreateDate(new Date());
            articleService.save(article);
            map.put("success", true);
            map.put("message","添加文章成功~~~");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", false);
            map.put("message", e.getMessage());
        }
        return map;
    }
    @RequestMapping("/update")
    public void update(@RequestBody Article article){
        articleService.update(article);
    }
}
