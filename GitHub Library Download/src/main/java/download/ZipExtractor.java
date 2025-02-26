package download;

import java.io.*;
import java.util.zip.*;

public class ZipExtractor {

    // 解压缩 ZIP 文件的方法
    public static void unzip(String zipFilePath, String destDir) throws IOException {
        // 创建目标文件夹，如果不存在
        File destDirFile = new File(destDir);
        if (!destDirFile.exists()) {
            destDirFile.mkdirs(); // 如果目标目录不存在，创建该目录
        }

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry entry;
            // 逐个处理 ZIP 文件中的条目
            while ((entry = zis.getNextEntry()) != null) {
                // 创建文件
                File file = new File(destDir + File.separator + entry.getName());

                // 如果条目是目录，则创建目录
                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    // 否则是文件，创建文件并写入内容
                    try (FileOutputStream fos = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = zis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    }
                }
                zis.closeEntry();  // 关闭当前条目
            }
        }
    }

    public static void main(String name) {
        // 要解压的 ZIP 文件路径
        String zipFilePath = name;  // 替换为你的 ZIP 文件路径
        // 解压后的目标目录
     // 使用 replace 方法去掉 ".zip" 扩展名
        String newFilePath = zipFilePath.replace(".zip", "");
        
        String destDir = newFilePath;  // 替换为你希望解压到的目录

        try {
            // 调用解压方法
            unzip(zipFilePath, destDir);
            System.out.println("ZIP 文件解压成功！");
        } catch (IOException e) {
            System.err.println("解压缩文件时出错：" + e.getMessage());
        }
    }
}
