package com.baizhi.yinzp.controller;

import com.baizhi.yinzp.entity.Chapter;
import com.baizhi.yinzp.service.ChapterService;
import it.sauronsoftware.jave.EncoderException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Administrator on 2017/10/29.
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
//    添加一个音频
    @RequestMapping("/add")
    public void save(String albumId,Chapter chapter, MultipartFile multipartFile, HttpServletResponse response, HttpServletRequest request, String id) throws EncoderException, IOException {
        chapter.setId(UUID.randomUUID().toString());
//        获取文件名
        String filename = multipartFile.getOriginalFilename();
//        创建新的名字
        String realPath = request.getRealPath("//back//album");
        String newFileName = UUID.randomUUID().toString() +
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +
                "." +
                FilenameUtils.getExtension(filename);
        chapter.setDownloadUrl(realPath);
        long size = multipartFile.getSize();
        chapter.setTitle(filename);
        chapter.setSize(size);
        chapter.setOldName(filename);
        chapter.setNewName(newFileName);
        chapter.setDuration(3.5);
        chapter.setAlbumId(albumId);
        chapterService.save(chapter);
        multipartFile.transferTo(new File(realPath, newFileName));
    }
    @RequestMapping("/down")
    public void down(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getRealPath("/back/album/");
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        response.setHeader("Content-Disposition",   "attachment;filename=" + fileName);
        response.setContentType("audio/mp3");
        ServletOutputStream os = response.getOutputStream();
        int len = 0;
        byte[] b = new byte[1024];
        while (true) {
            len = fis.read(b);
            if (len == -1) break;
            os.write(b, 0, len);
        }
        IOUtils.closeQuietly(fis);
    }
}
