package com.life.Controller.file;


import com.life.POJO.file.UploadFileResponse;
import com.life.Service.file.FileService;
import com.life.api.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/*
 *@Author: life-0
 *@ClassName: FileController
 *@Date: 2022/5/2 15:05
 *TODO @Description:

 */

import java.util.stream.Collectors;

@RestController
@RequestMapping("/file")
public class FileOperateController {

    private static final Logger logger = LoggerFactory.getLogger (FileOperateController.class);

    @Autowired
    private FileService fileService;

    @PostMapping("/uploadFile")
    public Result<?> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id, @RequestParam(value = "path", required = false) String path) {
        String fileName = fileService.storeFile (file, id, path);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath ().path ("/downloadFile/").path (fileName).toUriString ();

        return Result.OK (new UploadFileResponse (fileName, fileDownloadUri, file.getContentType (), file.getSize ()));
    }


//    @PostMapping("/uploadMultipleFiles")
//    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
//        return Arrays.stream (files)
//                .map (this::uploadFile)
//                .collect (Collectors.toList ());
//    }

    @PostMapping("/downloadFile")
    public ResponseEntity<Resource> downloadFile(@RequestParam("fileName") String fileName, @RequestParam("id") Integer id, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileService.loadFileAsResource (fileName, id);
        System.out.println ("fileName: " + fileName);
        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext ().getMimeType (resource.getFile ().getAbsolutePath ());
        } catch (IOException ex) {
            logger.info ("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok ().contentType (MediaType.parseMediaType (contentType))
                .header (HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename () + "\"")
                .body (resource);
    }

    @PostMapping("/loadMultiFiles")
    public ResponseEntity<Resource> loadMultiFiles(@RequestParam("path") String path, @RequestParam("type") Boolean type) throws IOException {
        Resource resource = fileService.loadMultiSystemFileAsResource (path, type);
        String contentType = "application/octet-stream";
        return ResponseEntity.ok ().contentType (MediaType.parseMediaType (contentType))
                .header (HttpHeaders.CONTENT_DISPOSITION, "files")
                .body (resource);

    }
}