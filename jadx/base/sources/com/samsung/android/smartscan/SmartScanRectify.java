package com.samsung.android.smartscan;

import android.graphics.Bitmap;
import android.util.Log;
import camera.samsung.smartscan.SmartScanRectify;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.smartscan.TaskManager.TaskManager;
import com.samsung.android.smartscan.TaskManager.Tasks.AbstractTask;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SmartScanRectify {
    public static final int EXECUTE_MODE_RECTIFY = 0;
    public static final int EXECUTE_MODE_SHADOW_REMOVAL = 1;
    public static final int IMAGE_FORMAT_RGB = 0;
    private static volatile SmartScanRectify SmartScanJni = null;
    private static final String TAG = "SmartScanRectify";
    public static final String aarVersion = "2.7.1";
    static String activatedAARVer = null;
    static boolean existNativeWrapper = true;
    private static AtomicBoolean initDone = new AtomicBoolean(false);
    private static OnSmartScanEventListener smartScanEventListener = null;
    private static AbstractTask.TaskListener taskListener;
    public static TaskManager taskManager;
    private final Lock lock = new ReentrantLock();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DetectResult {
        public float[] coord;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnSmartScanEventListener {
        void onFinishDeInit(boolean z);

        void onFinishExecute(boolean z);

        void onFinishInit(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SSImage {
        public byte[] ImageData;
        public int height;
        public int width;
    }

    static {
        AbstractTask.TaskListener taskListener2 = new AbstractTask.TaskListener() { // from class: com.samsung.android.smartscan.SmartScanRectify.1
            @Override // com.samsung.android.smartscan.TaskManager.Tasks.AbstractTask.TaskListener
            public void onExecuteTask(AbstractTask.TaskType taskType) {
                if (taskType == AbstractTask.TaskType.Init) {
                    boolean zInit = SmartScanRectify.init();
                    synchronized (SmartScanRectify.initDone) {
                        SmartScanRectify.initDone.set(true);
                        SmartScanRectify.initDone.notify();
                    }
                    Log.d(SmartScanRectify.TAG, "InitDone = " + SmartScanRectify.initDone.get());
                    if (SmartScanRectify.smartScanEventListener != null) {
                        SmartScanRectify.smartScanEventListener.onFinishInit(zInit);
                        return;
                    }
                    return;
                }
                if (taskType == AbstractTask.TaskType.Deinit) {
                    synchronized (SmartScanRectify.initDone) {
                        SmartScanRectify.initDone.set(false);
                        SmartScanRectify.initDone.notify();
                    }
                    Log.d(SmartScanRectify.TAG, "InitDone = " + SmartScanRectify.initDone.get());
                    boolean zDeinit = SmartScanRectify.deinit();
                    if (SmartScanRectify.smartScanEventListener != null) {
                        SmartScanRectify.smartScanEventListener.onFinishDeInit(zDeinit);
                    }
                }
            }
        };
        taskListener = taskListener2;
        taskManager = new TaskManager(taskListener2);
        activatedAARVer = aarVersion;
        try {
            try {
                System.loadLibrary("DocRectifyWrapper.camera.samsung");
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                activatedAARVer = "0.0";
            }
        } catch (UnsatisfiedLinkError unused) {
            System.loadLibrary("Rectify.camera.samsung");
            activatedAARVer = camera.samsung.smartscan.SmartScanRectify.aarVersion;
            existNativeWrapper = false;
        }
        AbstractC4539a.m3209s(new StringBuilder("AAR("), activatedAARVer, ") has been activated", TAG);
    }

    private static int RectifyForCamera(Bitmap bitmap, float[] fArr, int i, Bitmap bitmap2) {
        return -1;
    }

    private boolean calledByCameraApp() {
        return Thread.currentThread().getStackTrace()[3].getFileName().contains("com.sec.android.app.camera");
    }

    private static void convert2_5_xSSImageToSSImage(SmartScanRectify.SSImage sSImage, SSImage sSImage2) {
        sSImage2.height = sSImage.height;
        sSImage2.width = sSImage.width;
        sSImage2.ImageData = sSImage.ImageData;
    }

    private static void convertSSImageTo2_5_xSSImage(SSImage sSImage, SmartScanRectify.SSImage sSImage2) {
        sSImage2.height = sSImage.height;
        sSImage2.width = sSImage.width;
        sSImage2.ImageData = sSImage.ImageData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native synchronized boolean deinit();

    public static boolean deinitialize() {
        if (!existNativeWrapper) {
            return true;
        }
        taskManager.requestNewTask(AbstractTask.TaskType.Deinit);
        return true;
    }

    public static int execute(byte[] bArr, int i, int i2, int i4, float[] fArr, SSImage sSImage, int i5) {
        int iRectify;
        if (!waitAndGetInitStatus()) {
            return -1;
        }
        if (existNativeWrapper) {
            iRectify = rectify(bArr, i, i2, i4, fArr, sSImage, i5);
        } else {
            SmartScanRectify.SSImage sSImage2 = new SmartScanRectify.SSImage();
            convertSSImageTo2_5_xSSImage(sSImage, sSImage2);
            iRectify = camera.samsung.smartscan.SmartScanRectify.rectify(bArr, i, i2, i4, fArr, sSImage2, i5);
            convert2_5_xSSImageToSSImage(sSImage2, sSImage);
        }
        AbstractC4539a.m3209s(new StringBuilder("rectify("), activatedAARVer, ") has been executed", TAG);
        return iRectify;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native synchronized boolean init();

    public static boolean initialize() {
        if (!existNativeWrapper) {
            return true;
        }
        taskManager.requestNewTask(AbstractTask.TaskType.Init);
        return true;
    }

    private static native synchronized int rectify(Bitmap bitmap, float[] fArr, SSImage sSImage, int i);

    private static native synchronized int rectify(Bitmap bitmap, float[] fArr, SSImage sSImage, int i, int i2);

    private static native synchronized int rectify(byte[] bArr, int i, int i2, int i4, float[] fArr, SSImage sSImage, int i5);

    private static boolean waitAndGetInitStatus() {
        if (!initDone.get()) {
            synchronized (initDone) {
                try {
                    try {
                        Log.d(TAG, "Wait init for 3 sec");
                        initDone.wait(AiSTTListView.USER_SCROLL_INTERVAL);
                    } catch (InterruptedException unused) {
                        return false;
                    }
                } finally {
                }
            }
        }
        return initDone.get();
    }

    public void setOnSmartScanEventListener(OnSmartScanEventListener onSmartScanEventListener) {
        smartScanEventListener = onSmartScanEventListener;
    }

    public static int execute(Bitmap bitmap, float[] fArr, SSImage sSImage, int i) {
        int iRectify = -1;
        if (waitAndGetInitStatus()) {
            if (existNativeWrapper) {
                iRectify = rectify(bitmap, fArr, sSImage, i);
            } else {
                Log.e(TAG, "rectify function is not exist");
            }
            AbstractC4539a.m3209s(new StringBuilder("rectify("), activatedAARVer, ") has been executed", TAG);
        }
        return iRectify;
    }

    public static int execute(Bitmap bitmap, float[] fArr, SSImage sSImage, int i, int i2) {
        int iRectify = -1;
        if (waitAndGetInitStatus()) {
            if (existNativeWrapper) {
                iRectify = rectify(bitmap, fArr, sSImage, i, i2);
            } else {
                Log.e(TAG, "rectify function is not exist");
            }
            AbstractC4539a.m3209s(new StringBuilder("rectify("), activatedAARVer, ") has been executed", TAG);
        }
        return iRectify;
    }
}
