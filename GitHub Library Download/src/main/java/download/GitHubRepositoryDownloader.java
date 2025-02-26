package download;

import java.io.*;

import javax.swing.JOptionPane;



public class GitHubRepositoryDownloader {
	
	//C:\Users\zxc78\OneDrive\Desktop
 //	static  String library ="RGB";
	
	// 原始 URL
	//static  String baseURL = "https://github.com/SuWeizhe1124/RGB";
	// 拼接路径
  //  static  String fullURL = baseURL + "/archive/refs/heads/main.zip";
    
	//static String URL=fullURL;
	
	//https://github.com/SuWeizhe1124/RGB/archive/refs/heads/main.zip



    // 打印桌面路徑

	static String fileName="";// 存放exe 路徑 CassettePicturesEXE
	

    public static void main(String URL,String library) {// 下載檔案 並將來源庫 分成兩個的圖片送到 CassettePictures   CassettePicturesData
    	
  
    	download(URL,library,"螢幕擷取畫面 2024-03-31 065804.png","螢幕擷取畫面 2024-03-31 065804.png");
    	
    	                                                             //CassettePictures           //CassettePicturesData
    //	download("https://github.com/SuWeizhe1124/ecpay","ecpay","螢幕擷取畫面 2024-03-31 065804.png","螢幕擷取畫面 2024-03-31 065804.png");
    }

    public static void download(String baseURL ,String library,String CassettePictures,String CassettePicturesData ) {
    	
    	String  fullURL = baseURL + "/archive/refs/heads/main.zip";
    	String    URL=fullURL;
      
        String repoURL = URL; // GitHub repository URL
        
         String name=fileName+library+".zip";
     	 String Path=fileName+library;

     	
     			
     		
     	 
        String saveDir = name;  // Save path for the ZIP file

        
     
 
         

    	
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Use curl command to download the file
        String command = "curl -L -o " + saveDir + " " + repoURL;

        try {
            Process process = Runtime.getRuntime().exec(command);
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("Repository downloaded successfully!");
                
                JOptionPane.showMessageDialog(null, "Repository downloaded successfully!");
            } else {
                System.err.println("Error downloading repository.");
                
                JOptionPane.showMessageDialog(null, "Error downloading repository.");
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error executing the download command: " + e.getMessage());
        }
        
        ZipExtractor.main(name);
        
        DeleteMove.main(name,Path,library);
        
        MoveFolder.main(Path);
    	//--------------CassettePictures------------------------//
        
    	/*
       String [] fileCassettePictures= {Path+"\\"+CassettePictures,"CassettePictures\\"+CassettePictures};
    	ImageMover.main(fileCassettePictures[0], fileCassettePictures[1]);
    	
    	//---------------CassettePicturesData-----------------------//
        String [] fileCassettePicturesData= {Path+"\\"+CassettePicturesData,"CassettePicturesData\\"+CassettePicturesData};
    	
        ImageMover.main(fileCassettePicturesData[0], fileCassettePicturesData[1]);
        */
    	
    }
    
}
