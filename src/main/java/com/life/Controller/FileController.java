package com.life.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

import java.util.List;

/*
 *@Author: life-0
 *@ClassName: FileController
 *@Date: 2022/1/13 17:24
 *TODO @Description:

 */
@Controller
public class FileController {


    @GetMapping("/toUpDown")
    public String toUpDown() {
        return "/interface/uploadAndDownload";
    }

    //多文件上传
    @RequestMapping(value = "/uploadMore", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles ("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size (); ++i) {
            file = files.get (i);
            String filePath = "D://Recruiter//temp//";
            if (!file.isEmpty ()) {
                try {
                    byte[] bytes = file.getBytes ();
                    stream = new BufferedOutputStream (new FileOutputStream (
                            new File (filePath + file.getOriginalFilename ())));//设置文件路径及名字
                    stream.write (bytes);// 写入
                    stream.close ();
                } catch (Exception e) {
                    stream = null;
                    return "第 " + i + " 个文件上传失败  ==> "
                            + e.getMessage ();
                }
            } else {
                return "第 " + i
                        + " 个文件上传失败因为文件为空";
            }
        }
        return "上传成功";
    }

    //文件下载相关代码
    @PostMapping("/download")
    @ResponseBody
    public String downloadFile(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println ("filePath:" + filePath);
        String fileName = "Java开发_卓越1.pdf";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "D://Recruiter//temp//";
            File file = new File (realPath, fileName);
            if (file.exists ()) {
                response.setContentType ("application/force-download");// 设置强制下载不打开
                response.addHeader ("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream (file);
                    bis = new BufferedInputStream (fis);
                    OutputStream os = response.getOutputStream ();
                    int i = bis.read (buffer);
                    while (i != -1) {
                        os.write (buffer, 0, i);
                        i = bis.read (buffer);
                    }
                    System.out.println ("success");
                } catch (Exception e) {
                    e.printStackTrace ();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close ();
                        } catch (IOException e) {
                            e.printStackTrace ();
                        }
                    }
                }
            }
        }
        return null;
    }



}
