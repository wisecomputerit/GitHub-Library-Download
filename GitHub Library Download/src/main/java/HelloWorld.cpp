#include <jni.h>
#include <iostream>
#include <fstream>  // For file handling
#include "HelloWorld.h"  // Include the generated JNI header file

// Implement the native method
JNIEXPORT void JNICALL Java_HelloWorld_printHello(JNIEnv *env, jobject obj) {
    // The message to write to the file
    const char* message = "Hello from C!";

    // Create and open the file "Hello from C!.txt"
    std::ofstream outFile("Hello from C!.txt");

    // Check if the file was successfully opened
    if (outFile.is_open()) {
        // Write the message to the file
        outFile << message << std::endl;

        // Close the file after writing
        outFile.close();

        std::cout << "Message written to 'Hello from C!.txt'" << std::endl;
    } else {
        // Error handling if the file could not be opened
        std::cout << "Error: Could not open the file for writing." << std::endl;
    }
}
