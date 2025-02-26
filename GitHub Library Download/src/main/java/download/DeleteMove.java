package download;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


public class DeleteMove {

	public static void main(String name ,String path,String library) {
		// TODO 自動產生的方法 Stub
		  Path path2 = Paths.get(name); // 指定檔案路徑 ZIP
	        try {
	            Files.delete(path2);  // 刪除檔案
	            System.out.println("檔案已刪除");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	         MoveDirectoryContents(path,library); // 搬遷
	/*        
	        Path pathlibrary = Paths.get(GitHubRepositoryDownloader.name+"\\"+GitHubRepositoryDownloader.library+"-main"); // 指定檔案路徑 刪除
	        try {
	            Files.delete(pathlibrary);  // 刪除檔案
	            System.out.println("檔案已刪除");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        */
	}
	
	public static void	MoveDirectoryContents (String path,String library)
	{
		
		Path sourceDir = Paths.get(path+"\\"+library+"-main"); // 源資料夾路徑
        Path targetDir = Paths.get(path); // 目標資料夾路徑

        try {
            // 確保目標資料夾存在
            if (!Files.exists(targetDir)) {
                Files.createDirectories(targetDir);
            }

            // 遍歷源資料夾內容並移動每個檔案
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path targetFile = targetDir.resolve(sourceDir.relativize(file));  // 計算目標檔案路徑
                    Files.createDirectories(targetFile.getParent());  // 確保目標檔案的父資料夾存在
                    Files.move(file, targetFile, StandardCopyOption.REPLACE_EXISTING);  // 移動檔案
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    // 刪除空的源資料夾
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("資料夾內容已成功移動");

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}

}
