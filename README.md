# Camera2ArmstringImpl

Using Camera2ArmstringImpl you can take an image with camera2 api using only 4 lines of code:

##Adding dependencies:
In project level build.gradle file add maven { url 'https://jitpack.io' } as the following
```
  allprojects {
    repositories {
        .
        .
        .
        .
        maven { url 'https://jitpack.io' }
    }
}  
```
In app level build.gradle file add:
```
implementation 'com.github.KingArmstring:Camera2ArmstringImpl:1.0'
```
1. Create activity for example CameraActivity
2. Define an instance of the class PictureCameraImpl
```
    private PictureCameraImpl pictureCamera;
```
3. Create an XML element of TextureView
```
    <TextureView
        android:id="@+id/texture"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_above="@+id/btn_takepicture"
        android:layout_alignParentTop="true"/>
```
4. Refrence the element from the CameraActivity (yourActivity you created in step 1)
```
    TextureView textureView = findViewById(R.id.textureTest);
```
5. Initialize the PictureCameraImple in the CameraActivity and start the camera in the <b>onCreate()</b>
```
    pictureCamera = new PictureCameraImpl(this, textureView, filePath);//
    pictureCamera.start();
```
remember that filePath is the path of the image you will shot, if you want it to be in the root of your device storage 
```
    String filePath = Environment.getExternalStorageDirectory()+"/picc.jpg";
```
6. Call the method startBackgroundThread() in the onResume() method of your activity
```
    pictureCamera.startBackgroundThread();
```
7. Call the method stopBackgroundThread() in the onPause() method of your activity
```
    pictureCamera.stopBackgroundThread();
```
8. add a button of your choice and call the method takePicture() in its click handler
```
    btnTakePicture.setOnClickListener((v) -> pictureCamera.takePicture());
```

###Make sure not to forget adding the camera permission to the manifest and take it from the user programatically. If you don't know how to do that please check this link https://developer.android.com/training/permissions/requesting

