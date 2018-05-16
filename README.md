HyperEyeReader Core Library
===
### Reference Application

A project named  [HyperEyeReaderExample for Android](https://github.com/Winkk/HyperEyeReaderExample-Android) in Winkk repository demonstrates how does HyperEyeReader technology work and can be used as a reference. 

### Requirements 
* You should have Android Studio 3.1 installed.
* Minimal API: 21 (Android 5.0).

### Structure
HyperEyeFramework is the project with Android Library module hypereyedecodelib. The output is a library with *.aar extension.
The functions which is used to recognize HyperEye codes are stored in the HyperEyeDecoder abstract class and named HEDecodeNV21 and HEDecodeBGR.
The functions are static and native (implemented as JNI part).

### Methods

```
public abstract class HyperEyeDecoder {
    public static native long HEDecodeNV21(byte[] array ,int length, int width, int height, int crop_x, int crop_y, int crop_w, int crop_h);
    public static native long HEDecodeBGR(byte[] array ,int length, int width, int height, int crop_x, int crop_y, int crop_w, int crop_h);
}
```

#### HEDecodeNV21

The function which is used to recognize HyperEye codes from Java.
	`array` is raw binary data from camera in NV21 format;
	`length` is number of bytes in array;
	`width`, height is frame pixel size;
	`crop_x`, `crop_y`, `crop_w`, `crop_h` sets an area of image in pixels where HyperEye pictures are searched in. `crop_x`, `crop_y` defines top-left corner; `crop_w`,`crop_h` defines width and height of the area.
	The return value is HyperEye recognized object code or zero if HyperEye object is not recognized on the frame.

#### HEDecodeBGR

The function which is used to recognize HyperEye codes from Java.
	`array` is raw binary data from camera in BGR format;
	`length` is number of bytes in array;
	`width`, height is frame pixel size;
	`crop_x`, `crop_y`, `crop_w`, `crop_h` sets an area of image in pixels where HyperEye pictures are searched in. `crop_x`, `crop_y` defines top-left corner; `crop_w`,`crop_h` defines width and height of the area.
	The return value is HyperEye recognized object code or zero if HyperEye object is not recognized on the frame.
	
### Import

Abstract class HyperEyeDecoder is located in the com.square_nest.hypereyedecodelib package.
Import of the class:

```
import com.square_nest.hypereyedecodelib.HyperEyeDecoder;
```

### Usage

To use HyperEye SDK, firstly, compile hypereyedecodelib module.
You can find compiled library within the specified location:
```
HyperEyeFramework\hypereyedecodelib\build\outputs\aar\
```
There will be file with *.aar extension.
Now, to use the compiled library in your project follow instructions:
Note: Steps 1 – 3 can be done automatically in Android Studio (described below)

    1. Near with your project modules create folder `hypereyedecodelib`.
    2. Add compiled aar-file to the created folder. Name this file `hypereyedecodelib.aar` .
    3. Add file `build.gradle` to the created folder. Fill this file with next content:
	
	```
	configurations.maybeCreate("default")
    artifacts.add("default", file('hypereyedecodelib.aar'))
	```
	
	4. Open file in your project called `settings.gradle` .
	   Add to the include-line new string ':hypereyedecodelib'.
	   If there is already stored some value, separate added string with semicolon.
	   
	   For example, file settings.gradle have the line:
	   
	   ```
	   include ':app'
	   ```
	   
	   After adding string it should become:
	   
	   ```
	   include ':app', ':hypereyedecodelib'
	   ```
	   
    5. Open `build.gradle` file of the module `app`. Add to the dependencies block the line:
	   
	   ```
	   implementation project(":hypereyedecodelib")
	   ```
	   
       If there is no dependencies block, then add this block too:
	   
	   ```
	   dependencies {
           implementation project(":hypereyedecodelib")
	   }
	   ```
	   
   6. Synchronize project with `gradle-files`. (In Android Studio there is the button `Sync Project with Gradle Files`).
   
Steps 1 – 3 can be done automatically in Android Studio.
Choose in the menu `File -> New -> New Module…`
In the opened dialog choose `Import .JAR/.AAR Package and choose compiled aar-library`.
Android Studio will copy the library and add the files you need.
