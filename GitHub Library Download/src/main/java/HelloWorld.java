import java.io.File;

import javax.swing.JOptionPane;

public class HelloWorld {

    // Declare the native method
    public native void printHello();  // This method will be implemented in C++
// System.load("C:\\Users\\zxc78\\eclipse-workspace\\word\\src\\main\\java\\hello.dll");  // Use double backslashes for Windows paths
    static String name;

    public static void main(String[] args) {
    	

  	  // 獲取桌面路徑
    	 String desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
    	 // 獲取當前使用者的名稱
         String userName = System.getProperty("user.name");

         // 打印使用者名稱
         System.out.println("當前使用者名稱是: " + userName);
        // 打印桌面路徑
        System.out.println("桌面路徑是: " + desktopPath);
    	
        // Get the current working directory
        String currentDirectory = System.getProperty("user.dir");
        
        // Store the directory path for later use
        name = currentDirectory;

        // Print the current directory
        System.out.println("Current working directory: " + currentDirectory);

        // Load the DLL dynamically from the current directory
        System.load(name + "\\src\\main\\java\\hello.dll"); // Use double backslashes for Windows paths

        // Create an instance of HelloWorld and call the native method when button is pressed
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.printHello(); // Call the C++ function through JNI
        // Show a message dialog after calling the native method
        JOptionPane.showMessageDialog(null, "Hello from C++ via JNI!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}
