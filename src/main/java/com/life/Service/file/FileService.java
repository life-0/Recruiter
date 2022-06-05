package com.life.Service.file;


import com.life.POJO.file.FileException;
import com.life.POJO.file.FileProperties;
import com.life.POJO.user.JobHuntingInfo;
import com.life.POJO.user.UserInfo;
import com.life.Service.user.JobHuntingInfoServiceImpl;

import com.life.Service.user.UserInfoServiceImpl;
import com.life.Utils.SearchFiles;
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
import java.util.List;
import java.util.Objects;
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
    private JobHuntingInfoServiceImpl jobHuntingInfoService;
    @Autowired
    private UserInfoServiceImpl userInfoService;

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
    public String storeFile(MultipartFile file, Integer id, String path) {
        // Normalize file name
//        String fileName = StringUtils.cleanPath (file.getOriginalFilename ());
        String fileName = Objects.requireNonNull (file.getOriginalFilename ()).replace (file.getOriginalFilename (),
                id + "-" + file.getOriginalFilename ());

        //check path
        if (path != null) {
            if (path.charAt (path.length () - 1) != '/') {
                path = path + '/';
            }
            if (path.contains ("userAvatar")) {
                //将文件名装入个人信息表中
                userInfoService.updateUserInfo (new UserInfo ()
                        .setId (id).setImgPath (path + file.getOriginalFilename ()));
            } else if (path.contains ("userPDF")) {
                //将文件名装入求职信息表中
                jobHuntingInfoService.updateJobHuntingInfo (new JobHuntingInfo ()
                        .setId (id).setAppendix (path + file.getOriginalFilename ()));
            }
        }

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains ("..")) {
                throw new FileException ("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            StringBuilder normalizeFileName = new StringBuilder (fileName);
            normalizeFileName.insert (0, this.fileStorageLocation.toAbsolutePath () + path);
//            Path targetLocation = this.fileStorageLocation.resolve (fileName);
            Path targetLocation = Paths.get (normalizeFileName.toString ()).toAbsolutePath ().normalize ();
            // Find if a file exists and delete it before saving
            List<File> files = SearchFiles.searchFile (new File (this.fileStorageLocation + path), id + "-");
            for (File delFile : files) {delFile.delete ();}
            Files.copy (file.getInputStream (), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileException ("Could not store file " + fileName + ". Please try again!", ex);
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
        StringBuilder normalizeFileName = new StringBuilder (fileName);
        normalizeFileName.insert (normalizeFileName.lastIndexOf ("/") + 1, id + "-");
        normalizeFileName.insert (0, this.fileStorageLocation.toAbsolutePath ());
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
//            Path filePath = this.fileStorageLocation.resolve (normalizeFileName.toString ()).normalize ();
            Path filePath = Paths.get (normalizeFileName.toString ()).toAbsolutePath ().normalize ();
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