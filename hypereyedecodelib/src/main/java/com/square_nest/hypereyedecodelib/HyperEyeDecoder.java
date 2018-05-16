package com.square_nest.hypereyedecodelib;

public abstract class HyperEyeDecoder {

    static
    {
        System.loadLibrary("JustCapture");
    }

    public static native long HEDecodeNV21(byte[] array ,int length, int width, int height, int crop_x, int crop_y, int crop_w, int crop_h);

    public static native long HEDecodeBGR(byte[] array ,int length, int width, int height, int crop_x, int crop_y, int crop_w, int crop_h);

}
