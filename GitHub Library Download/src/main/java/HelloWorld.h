#include <jni.h>

#ifndef _Included_HelloWorld
#define _Included_HelloWorld
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     HelloWorld
 * Method:    printHello
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_HelloWorld_printHello(JNIEnv *, jobject);
#ifdef __cplusplus
}
#endif
#endif
