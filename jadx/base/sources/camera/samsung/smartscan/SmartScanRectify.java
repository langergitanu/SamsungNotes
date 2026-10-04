package camera.samsung.smartscan;

import android.graphics.Bitmap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class SmartScanRectify {
    public static final int IMAGE_FORMAT_ARGB_8888 = 2;
    public static final int IMAGE_FORMAT_BGR = 0;
    public static final int IMAGE_FORMAT_YUV = 1;
    private static volatile SmartScanRectify SmartScanJni = null;
    private static final String TAG = "SmartScanRectify";
    public static final String aarVersion = "2.5.0";
    private static boolean supportingNewAPI = true;
    private final Lock lock = new ReentrantLock();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DetectResult {
        public float[] coord;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SSImage {
        public byte[] ImageData;
        public int height;
        public int width;
    }

    static {
        try {
            System.loadLibrary("Rectify.camera.samsung");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    public static native synchronized String getVersion();

    public static native synchronized int rectify(Bitmap bitmap, float[] fArr, SSImage sSImage);

    public static native synchronized int rectify(Bitmap bitmap, float[] fArr, SSImage sSImage, int i);

    public static native synchronized int rectify(byte[] bArr, int i, int i2, int i4, float[] fArr, SSImage sSImage);

    public static native synchronized int rectify(byte[] bArr, int i, int i2, int i4, float[] fArr, SSImage sSImage, int i5);
}
