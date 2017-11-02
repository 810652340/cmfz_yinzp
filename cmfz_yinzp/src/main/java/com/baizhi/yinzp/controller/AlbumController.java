package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Album;
import com.baizhi.yinzp.service.AlbumService;
import com.baizhi.yinzp.service.ChapterService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/27.
 */
@Controller
@RequestMapping("/album")
public class AlbumController{
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterService chapterService;
//    查看所有的专辑
    @RequestMapping("/all")
    @ResponseBody
    public List<Album> queryAll(){
        System.out.println("正在进入===========================================");
        List<Album> albums = albumService.queryAll();
        return albums;
    }
    @RequestMapping("/add")
//    添加一张专辑
    public void save(Album album, MultipartFile multipartFile, HttpServletResponse response, HttpServletRequest request) throws IOException {
        album.setId(UUID.randomUUID().toString());
//        获取文件名
        String filename = multipartFile.getOriginalFilename();
//        获取路径
        String realPath = request.getRealPath("//back//album");
//        创建新的名字
        String newFileName = UUID.randomUUID().toString() +
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                "." +
                FilenameUtils.getExtension(filename);
        album.setOldName(filename);
        album.setThumbnail(realPath);
        album.setNewName(newFileName);
        album.setCreateDate(new Date());
        multipartFile.transferTo(new File(realPath, newFileName));
        albumService.save(album);

    }
//    删除一张专辑
    @RequestMapping("/del")
    public void del(String id){
        chapterService.delAll();
        albumService.del(id);
    }
}
