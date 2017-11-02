package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Banner;
import com.baizhi.yinzp.service.BannerService;
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
 * Created by Administrator on 2017/10/26.
 */
@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @RequestMapping("/add")
//    上传一张图片
    @ResponseBody
    public Map<String,Object> add(Banner banner, MultipartFile multipartFile, HttpServletResponse response, HttpServletRequest request) throws IOException {
       Map<String,Object> map =new  HashMap<String,Object>();
        try {

        banner.setId(UUID.randomUUID().toString());
//        获取文件名
        System.out.println("这是测试数据");
        String s = multipartFile.getOriginalFilename();
        banner.setOldName(s);
        String realPath = request.getRealPath("//back//uplod//");
        banner.setThumbnail(realPath);
        banner.setDescs(banner.getDescs());
        banner.setStatus(banner.getStatus());
        banner.setBir(new Date());
//        获取新的名字
        String newFileName = UUID.randomUUID().toString() +
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                "." +
                FilenameUtils.getExtension(s);
        banner.setName(newFileName);
        multipartFile.transferTo(new File(realPath, newFileName));
        bannerService.save(banner);
        map.put("success", true);
        map.put("message","保存用户成功~~~");
       }catch (Exception e){
           e.printStackTrace();
           map.put("success", false);
           map.put("message", e.getMessage());
       }
       return map;
    }
//    显示所有图片
    @RequestMapping("/all")
    @ResponseBody
    public Map<String,Object> queryAll(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Banner> banners = bannerService.queryAll();
        Integer integer = bannerService.queryNum();
        map.put("total",integer);
        map.put("rows",banners);
        return map;
    }
//    修改用户的状态和用户的描述
    @RequestMapping("/update")
    public void update(@RequestBody Banner banner){
        System.out.println("banner = [" + banner + "]");
        bannerService.update(banner);
    }

}
