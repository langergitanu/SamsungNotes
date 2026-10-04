package com.samsung.android.support.senl.p148nt.stt.base.audio;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ResampleJNI {
    public static final int SOUNDALIVE_BITWIDTH_16 = 0;
    public static final int SOUNDALIVE_BITWIDTH_24 = 1;
    public static final int SOUNDALIVE_BITWIDTH_32 = 2;
    public static final int SOUNDALIVE_BITWIDTH_FLOAT = 3;
    public static final int Soundalive_SRC_16000k = 3;
    public static final int Soundalive_SRC_24000k = 5;
    public static final int Soundalive_SRC_32000k = 6;
    public static final int Soundalive_SRC_44100k = 7;
    public static final int Soundalive_SRC_48000k = 8;
    public static final int Soundalive_SRC_8000k = 0;

    static {
        System.loadLibrary("ResampleWrapper");
        System.loadLibrary("_SoundAlive_SRC384_ver320");
    }

    public native void create(long j);

    public native void destroy(long j);

    public native int exe(short[] sArr, short[] sArr2, int i, long j);

    public native int init(int i, int i2, int i4, int i5, long j);
}
