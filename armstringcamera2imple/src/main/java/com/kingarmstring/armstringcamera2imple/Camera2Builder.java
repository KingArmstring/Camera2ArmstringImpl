package com.kingarmstring.armstringcamera2imple;

import android.content.Context;
import android.view.TextureView;

public class Camera2Builder {

    private Context cameraConsumer;
    private TextureView cameraView;
    private String imageFileName;

    public Camera2Builder setCameraConsumer(Context cameraConsumer) {
        this.cameraConsumer = cameraConsumer;
        return this;
    }

    public Camera2Builder setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
        return this;
    }

    public Camera2Builder setCameraView(TextureView cameraView) {
        this.cameraView = cameraView;
        return this;
    }

    public PictureCameraImpl build() {
        return new PictureCameraImpl(cameraConsumer, cameraView, imageFileName);
    }
}
