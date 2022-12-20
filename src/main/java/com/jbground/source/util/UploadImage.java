package com.jbground.source.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by jsjeong on 2022. 12. 20.
 * <pre>
 *  설정한 경로로 이미지 업로드 기능
 * </pre>
 */
public class UploadImage {

    public String uploadImage(String uploadPath, String imageUrl) throws IOException {

        String str[] = imageUrl.replace("http://", "").split("/");
        int lenth = str.length;
        String fileName = str[lenth - 1];
        String dbSavePath = uploadPath + fileName;

        InputStream inStream = null;
        OutputStream outStream = null;
        try {

            URL target = new URL(imageUrl);
            inStream = target.openStream();
            byte[] bytes = IOUtils.toByteArray(inStream);
            Path path = Paths.get(dbSavePath);

            File file = Files.write(path, bytes).toFile();
            FileItem fileItem = new DiskFileItem("mainFile", Files.probeContentType(file.toPath()), false, file.getName(), (int) file.length(), file.getParentFile());


            outStream = fileItem.getOutputStream();
            outStream.write(bytes);

            inStream.close();
            outStream.close();

        } catch (Exception e) {
            throw new IOException(e);
        } finally {
            if (inStream != null) {
                inStream.close();
            }
            if (outStream != null) {
                outStream.close();
            }
        }
        return dbSavePath;
    }

    public String mkDir(String path) {
        //api/KCPG05/
        String uploadPath = path;
        String upDir = path;

        File dir = new File(uploadPath);

        if (!dir.exists()) {
            dir.mkdirs();
        }

        return upDir;
    }
}
