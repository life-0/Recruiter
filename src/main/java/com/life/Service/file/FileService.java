package com.life.Service.file;


import com.life.POJO.file.FileException;
import com.life.POJO.file.FileProperties;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
/*
 *@Author: life-0
 *@ClassName: FileService
 *@Date: 2022/5/2 15:06
 *TODO @Description:

 */


@Service
public class FileService {

    private final Path fileStorageLocation; // 文件在本地存储的地址

    @Autowired
    public FileService(FileProperties fileProperties) {
        this.fileStorageLocation = Paths.get (fileProperties.getUploadDir ()).toAbsolutePath ().normalize ();
        try {
            Files.createDirectories (this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileException ("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    /**
     * 存储文件到系统
     *
     * @param file 文件
     * @return 文件名
     */
    public String storeFile(MultipartFile file, Integer id) {
        // Normalize file name
//        String fileName = StringUtils.cleanPath (file.getOriginalFilename ());
        String newFileName = file.getOriginalFilename ().replace (file.getOriginalFilename (), id + "-" + file.getOriginalFilename ());

//        try {
//            // Check if the file's name contains invalid characters
//            if (fileName.contains ("..")) {
//                throw new FileException ("Sorry! Filename contains invalid path sequence " + fileName);
//            }
//
//            // Copy file to the target location (Replacing existing file with the same name)
//            Path targetLocation = this.fileStorageLocation.resolve (fileName);
//            Files.copy (file.getInputStream (), targetLocation, StandardCopyOption.REPLACE_EXISTING);
//
//            return fileName;
//        } catch (IOException ex) {
//            throw new FileException ("Could not store file " + fileName + ". Please try again!", ex);
//        }
        try {
            // Check if the file's name contains invalid characters
            if (newFileName.contains ("..")) {
                throw new FileException ("Sorry! Filename contains invalid path sequence " + newFileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve (newFileName);
            Files.copy (file.getInputStream (), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return newFileName;
        } catch (IOException ex) {
            throw new FileException ("Could not store file " + newFileName + ". Please try again!", ex);
        }
    }

    /**
     * 加载文件
     *
     * @param fileName 文件名
     * @return 文件
     */
    public Resource loadFileAsResource(String fileName, Integer id) {
        // 格式化文件名 以 id-fileName形式查找
        String normalizeFileName = id + "-" + fileName;
//        try {
//            Path filePath = this.fileStorageLocation.resolve (fileName).normalize ();
//            Resource resource = new UrlResource (filePath.toUri ());
//
//            if (resource.exists ()) {
//                return resource;
//            } else {
//                throw new FileException ("File not found " + fileName);
//            }
//        } catch (MalformedURLException ex) {
//            throw new FileException ("File not found " + fileName, ex);
//        }
        try {
            Path filePath = this.fileStorageLocation.resolve (normalizeFileName).normalize ();
            Resource resource = new UrlResource (filePath.toUri ());
            if (resource.exists ()) {
                return resource;
            } else {
                throw new FileException ("File not found " + normalizeFileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileException ("File not found " + normalizeFileName, ex);
        }
    }
}