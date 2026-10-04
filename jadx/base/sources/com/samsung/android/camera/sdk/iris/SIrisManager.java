package com.samsung.android.camera.sdk.iris;

import android.app.ActivityManagerNative;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.security.keystore.AndroidKeyStoreProvider;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import com.samsung.android.camera.iris.IIrisService;
import com.samsung.android.camera.iris.IIrisServiceReceiver;
import com.samsung.android.camera.iris.Iris;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;
import java.security.Signature;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SIrisManager {
    public static final int IRIS_ACQUIRED_CHANGE_YOUR_POSITION = 12;
    public static final int IRIS_ACQUIRED_EYE_NOT_PRESENT = 10;
    public static final int IRIS_ACQUIRED_GOOD = 0;
    public static final int IRIS_ACQUIRED_INSUFFICIENT = 2;
    public static final int IRIS_ACQUIRED_MOVE_CLOSER = 3;
    public static final int IRIS_ACQUIRED_MOVE_DOWN = 8;
    public static final int IRIS_ACQUIRED_MOVE_FARTHER = 4;
    public static final int IRIS_ACQUIRED_MOVE_LEFT = 5;
    public static final int IRIS_ACQUIRED_MOVE_RIGHT = 6;
    public static final int IRIS_ACQUIRED_MOVE_SOMEWHERE_DARKER = 11;
    public static final int IRIS_ACQUIRED_MOVE_UP = 7;
    public static final int IRIS_ACQUIRED_OPEN_EYES_WIDER = 9;
    public static final int IRIS_ACQUIRED_PARTIAL = 1;
    public static final int IRIS_AUTH_TYPE_NONE = 0;
    public static final int IRIS_AUTH_TYPE_PREVIEW_CALLBACK = 1;
    public static final int IRIS_AUTH_TYPE_UI_WITH_PREVIEW = 2;
    public static final int IRIS_DISABLE_PREVIEW_CALLBACK = 7;
    public static final int IRIS_ENABLE_PREVIEW_CALLBACK = 6;
    public static final int IRIS_ERROR_AUTH_VIEW_SIZE = 10;
    public static final int IRIS_ERROR_AUTH_WINDOW_TOKEN = 11;
    public static final int IRIS_ERROR_CANCELED = 4;
    public static final int IRIS_ERROR_EVICTED = 13;
    public static final int IRIS_ERROR_EVICTED_DUE_TO_VIDEO_CALL = 14;
    public static final int IRIS_ERROR_EYE_SAFETY_TIMEOUT = 9;
    public static final int IRIS_ERROR_FLIP_OFF = 17;
    public static final int IRIS_ERROR_HW_UNAVAILABLE = 0;
    public static final int IRIS_ERROR_LOCKOUT = 6;
    public static final int IRIS_ERROR_LOCKOUT_PERMANENT = 16;
    public static final int IRIS_ERROR_NEED_SET_LOCK_TYPE = 18;
    public static final int IRIS_ERROR_NO_EYE_DETECTED = 15;
    public static final int IRIS_ERROR_OPEN_IR_CAMERA_FAIL = 8;
    public static final int IRIS_ERROR_PROXIMITY_TIMEOUT = 12;
    public static final int IRIS_ERROR_START_IR_CAMERA_PREVIEW_FAIL = 7;
    public static final int IRIS_ERROR_TIMEOUT = 2;
    public static final int IRIS_ERROR_UNABLE_TO_PROCESS = 1;
    public static final int IRIS_INVISIBLE_PREVIEW = 4;
    public static final int IRIS_REQUEST_GET_UNIQUE_ID = 7;
    public static final int IRIS_VISIBLE_PREVIEW = 5;
    private static final String MANAGE_IRIS = "com.samsung.android.camera.iris.permission.MANAGE_IRIS";
    private static final int MSG_ACQUIRED = 101;
    private static final int MSG_AUTHENTICATION_FAILED = 103;
    private static final int MSG_AUTHENTICATION_SUCCEEDED = 102;
    private static final int MSG_AUTHENTICATION_SUCCEEDED_FIDO_RESULT_DATA = 107;
    private static final int MSG_ERROR = 104;
    private static final int MSG_IR_IMAGE = 106;
    static final int SDK_VERSION = 16777229;
    private static final String SYSTEM_FEATURE_IRIS = "com.samsung.android.camera.iris";
    private static final String TAG = "SIrisManager";
    private static final String USE_IRIS = "com.samsung.android.camera.iris.permission.USE_IRIS";
    private static SIrisManager mSIrisManager;
    private AuthenticationCallback mAuthenticationCallback;
    private Context mContext;
    private CryptoObject mCryptoObject;
    private Handler mHandler;
    private Iris mRemovalIris;
    private IIrisService mService;
    private View mView;
    private IBinder mToken = new Binder();
    private long mAuthBegin = 0;
    private GetterHandler mGetterHandler = new GetterHandler();
    private IIrisServiceReceiver mServiceReceiver = new IIrisServiceReceiver.Stub() { // from class: com.samsung.android.camera.sdk.iris.SIrisManager.2
        public void onAcquired(long j, int i) {
            SIrisManager.this.mHandler.obtainMessage(101, i, 0, Long.valueOf(j)).sendToTarget();
        }

        public void onAuthenticationFailed(long j) {
            SIrisManager.this.mHandler.obtainMessage(103).sendToTarget();
        }

        public void onAuthenticationSucceeded(long j, Iris iris, byte[] bArr) {
            SIrisManager.this.mHandler.obtainMessage(107, bArr).sendToTarget();
            SIrisManager.this.mHandler.obtainMessage(102, iris).sendToTarget();
        }

        public void onEnrollResult(long j, int i, int i2, int i4) {
        }

        public void onError(long j, int i) {
            SIrisManager.this.mHandler.obtainMessage(104, i, 0, Long.valueOf(j)).sendToTarget();
        }

        public void onIRImage(long j, byte[] bArr, int i, int i2) {
            SIrisManager.this.mHandler.obtainMessage(106, i, i2, bArr).sendToTarget();
        }

        public void onRemoved(long j, int i, int i2) {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        }

        public void onIRImage(byte[] bArr, int i, int i2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AuthenticationResult {
        private CryptoObject mCryptoObject;
        private Iris mIris;

        public AuthenticationResult(CryptoObject cryptoObject, Iris iris) {
            this.mCryptoObject = cryptoObject;
            this.mIris = iris;
        }

        public CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }

        public Iris getIris() {
            return this.mIris;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class GetterHandler extends Handler {
        private static final int IMAGE_GETTER_CALLBACK = 1;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            ((Runnable) message.obj).run();
        }

        public void postDelayedGetterCallback(Runnable runnable, long j) {
            runnable.getClass();
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = runnable;
            sendMessageDelayed(messageObtain, j);
        }

        public void postGetterCallback(Runnable runnable) {
            postDelayedGetterCallback(runnable, 0L);
        }

        public void removeAllGetterCallbacks() {
            removeMessages(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnAuthenticationCancelListener implements CancellationSignal.OnCancelListener {
        private CryptoObject mCrypto;

        public OnAuthenticationCancelListener(CryptoObject cryptoObject) {
            this.mCrypto = cryptoObject;
        }

        @Override // android.os.CancellationSignal.OnCancelListener
        public void onCancel() {
            SIrisManager.this.cancelAuthentication(this.mCrypto);
        }
    }

    public SIrisManager(Context context, IIrisService iIrisService) {
        this.mContext = context;
        this.mService = iIrisService;
        if (iIrisService == null) {
            Log.v(TAG, "SIrisManagerService was null");
        }
        this.mHandler = new MyHandler(context);
    }

    private static String byteArrayToHex(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(String.format("%02x", Integer.valueOf(b & 255)));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAuthentication(CryptoObject cryptoObject) {
        IIrisService iIrisService;
        Log.e(TAG, "cancelAuthentication");
        if (ensureServiceConnected() && (iIrisService = this.mService) != null) {
            try {
                iIrisService.cancelAuthentication(this.mToken, this.mContext.getOpPackageName());
            } catch (RemoteException unused) {
                Log.w(TAG, "Remote exception while canceling authentication");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAuthViewWindowToken(final CryptoObject cryptoObject, final CancellationSignal cancellationSignal, final int i, final AuthenticationCallback authenticationCallback, final Handler handler, final int i2, final Bundle bundle, final View view, final long j, final byte[] bArr) {
        if (this.mGetterHandler == null) {
            this.mGetterHandler = new GetterHandler();
        }
        if (view.getWindowToken() == null) {
            if (System.currentTimeMillis() - this.mAuthBegin < AiSTTListView.USER_SCROLL_INTERVAL) {
                this.mGetterHandler.postGetterCallback(new Runnable() { // from class: com.samsung.android.camera.sdk.iris.SIrisManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SIrisManager.this.checkAuthViewWindowToken(cryptoObject, cancellationSignal, i, authenticationCallback, handler, i2, bundle, view, j, bArr);
                    }
                });
                return;
            } else {
                Log.e(TAG, "checkAuthViewWindowToken is null");
                this.mGetterHandler.removeAllGetterCallbacks();
                return;
            }
        }
        this.mGetterHandler.removeAllGetterCallbacks();
        try {
            IBinder windowToken = view.getWindowToken();
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            if (this.mToken == null) {
                Log.e(TAG, "mToken null");
            }
            Size minimumIrisViewSize = getMinimumIrisViewSize();
            if ((view.getWidth() < minimumIrisViewSize.getWidth() || view.getHeight() < minimumIrisViewSize.getHeight()) && authenticationCallback != null) {
                Log.e(TAG, "Invalid irisView size. IrisView's proper size:" + minimumIrisViewSize.getWidth() + "x" + minimumIrisViewSize.getHeight() + ", but app's size:" + view.getWidth() + "x" + view.getHeight());
            }
            this.mService.authenticate(this.mToken, windowToken, iArr[0], iArr[1], view.getWidth(), view.getHeight(), j, i2, this.mServiceReceiver, i, this.mContext.getOpPackageName(), bundle, bArr);
        } catch (RemoteException unused) {
            Log.w(TAG, "Remote exception while authenticating");
            if (authenticationCallback != null) {
                authenticationCallback.onAuthenticationError(1, getErrorString(1));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001f A[Catch: all -> 0x0011, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:13:0x001b, B:15:0x001f, B:16:0x0025, B:10:0x0014, B:12:0x0018), top: B:24:0x0001, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean ensureServiceConnected() {
        IIrisService iIrisService = this.mService;
        if (iIrisService != null) {
            try {
                iIrisService.isHardwareDetected(0L, this.mContext.getOpPackageName());
            } catch (RemoteException e) {
                if (e instanceof DeadObjectException) {
                    this.mService = null;
                }
            }
            if (this.mService == null) {
                startIrisService();
                waitForService();
            }
        } else {
            if (this.mService == null) {
            }
        }
        return this.mService == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAcquiredString(int i) {
        Resources resourcesForApplication;
        try {
            resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication("com.samsung.android.server.iris");
        } catch (Exception e) {
            Log.e(TAG, "getAcquiredString, Exception = " + e);
            resourcesForApplication = null;
        }
        if (resourcesForApplication == null) {
            Log.e(TAG, "mRes is null");
            return null;
        }
        try {
            if (i == 3) {
                return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_acquired_move_closer", "string", "com.samsung.android.server.iris"));
            }
            if (i == 4) {
                return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_acquired_move_farther", "string", "com.samsung.android.server.iris"));
            }
            if (i == 9) {
                return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_acquired_open_wider", "string", "com.samsung.android.server.iris"));
            }
            if (i == 11) {
                return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_acquired_move_somewhere_darker", "string", "com.samsung.android.server.iris"));
            }
            if (i != 12) {
                return null;
            }
            return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_acquired_change_your_position", "string", "com.samsung.android.server.iris"));
        } catch (Resources.NotFoundException e2) {
            Log.d(TAG, "getAcquiredString, NotFoundException = " + e2);
            return null;
        }
    }

    private int getCurrentUserId() {
        try {
            return ActivityManagerNative.getDefault().getCurrentUser().id;
        } catch (RemoteException unused) {
            Log.w(TAG, "Failed to get current user id\n");
            return -10000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorString(int i) {
        Resources resourcesForApplication;
        try {
            resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication("com.samsung.android.server.iris");
        } catch (Exception e) {
            Log.e(TAG, "getErrorString, Exception = " + e);
            resourcesForApplication = null;
        }
        if (resourcesForApplication == null) {
            Log.e(TAG, "mRes is null");
            return null;
        }
        try {
            switch (i) {
                case 0:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_sensor_no_response", "string", "com.samsung.android.server.iris"));
                case 1:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_unable_to_process", "string", "com.samsung.android.server.iris"));
                case 2:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_timeout", "string", "com.samsung.android.server.iris"));
                case 3:
                case 5:
                case 11:
                case 16:
                default:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_unable_to_process", "string", "com.samsung.android.server.iris"));
                case 4:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_canceled", "string", "com.samsung.android.server.iris"));
                case 6:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_lockout", "string", "com.samsung.android.server.iris"));
                case 7:
                case 8:
                    return "";
                case 9:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_eye_safety_timeout", "string", "com.samsung.android.server.iris"));
                case 10:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_auth_view_size", "string", "com.samsung.android.server.iris"));
                case 12:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_proximity_timeout", "string", "com.samsung.android.server.iris"));
                case 13:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_evicted", "string", "com.samsung.android.server.iris"));
                case 14:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_video_call_interrupt", "string", "com.samsung.android.server.iris"));
                case 15:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_no_eye_detected", "string", "com.samsung.android.server.iris"));
                case 17:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_flip_off", "string", "com.samsung.android.server.iris"));
                case 18:
                    return resourcesForApplication.getString(resourcesForApplication.getIdentifier("iris_error_need_set_lock_type", "string", "com.samsung.android.server.iris"));
            }
        } catch (Resources.NotFoundException e2) {
            Log.d(TAG, "getErrorString, NotFoundException = " + e2);
            return null;
        }
    }

    public static synchronized SIrisManager getSIrisManager(Context context) {
        try {
            if (!context.getPackageManager().hasSystemFeature(SYSTEM_FEATURE_IRIS)) {
                return null;
            }
            if (mSIrisManager == null) {
                mSIrisManager = new SIrisManager(context);
            }
            return mSIrisManager;
        } catch (Throwable th) {
            throw th;
        }
    }

    private byte[] requestGetUniqueID(int i, String str) {
        int iRequest;
        if (!ensureServiceConnected()) {
            return null;
        }
        byte[] bArr = new byte[256];
        IIrisService iIrisService = this.mService;
        if (iIrisService != null) {
            try {
                iRequest = iIrisService.request(this.mToken, 7, str.getBytes(), bArr, i, UserHandle.myUserId(), this.mServiceReceiver);
            } catch (RemoteException unused) {
                Log.v(TAG, "Remote exception in request()");
                iRequest = 0;
            }
        } else {
            iRequest = 0;
        }
        if (iRequest <= 0) {
            return null;
        }
        return Arrays.copyOf(bArr, iRequest);
    }

    private void startIrisService() {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.samsung.android.server.iris", "com.samsung.android.server.iris.IrisService"));
            this.mContext.startServiceAsUser(intent, UserHandle.CURRENT_OR_SELF);
        } catch (Exception e) {
            Log.e(TAG, "Starting startIrisService failed: " + e);
        }
    }

    private void useHandler(Handler handler) {
        if (handler != null) {
            this.mHandler = new MyHandler(handler.getLooper());
        } else if (this.mHandler.getLooper() != this.mContext.getMainLooper()) {
            this.mHandler = new MyHandler(this.mContext.getMainLooper());
        }
    }

    private void waitForService() {
        for (int i = 1; i <= 20; i++) {
            IIrisService iIrisServiceAsInterface = IIrisService.Stub.asInterface(ServiceManager.getService("samsung.iris"));
            this.mService = iIrisServiceAsInterface;
            if (iIrisServiceAsInterface != null) {
                Log.v(TAG, "Service connected!");
                return;
            }
            try {
                Thread.sleep(50L);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void authenticate(CryptoObject cryptoObject, CancellationSignal cancellationSignal, int i, AuthenticationCallback authenticationCallback, Handler handler, View view) {
        authenticate(cryptoObject, cancellationSignal, i, authenticationCallback, handler, UserHandle.myUserId(), null, view);
    }

    public void enableIRImageCallback(boolean z) {
        IIrisService iIrisService;
        if (ensureServiceConnected() && (iIrisService = this.mService) != null) {
            try {
                if (z) {
                    iIrisService.enableIRImageCallback(UserHandle.myUserId(), this.mContext.getOpPackageName(), 6);
                } else {
                    iIrisService.enableIRImageCallback(UserHandle.myUserId(), this.mContext.getOpPackageName(), 7);
                }
            } catch (RemoteException unused) {
                Log.v(TAG, "Remote exception in enableIRImageCallback");
            }
        }
    }

    public SparseArray getEnrolledIrisUniqueID() {
        List enrolledIrises;
        if (!ensureServiceConnected()) {
            return null;
        }
        SparseArray sparseArray = new SparseArray();
        IIrisService iIrisService = this.mService;
        if (iIrisService != null) {
            try {
                enrolledIrises = iIrisService.getEnrolledIrises(UserHandle.myUserId(), this.mContext.getOpPackageName());
            } catch (RemoteException unused) {
                Log.v(TAG, "Remote exception in getEnrolledIrises");
                enrolledIrises = null;
            }
        } else {
            enrolledIrises = null;
        }
        if (enrolledIrises.size() <= 0 || this.mContext == null) {
            return null;
        }
        Iterator it = enrolledIrises.iterator();
        int i = 1;
        while (it.hasNext()) {
            sparseArray.put(i, byteArrayToHex(requestGetUniqueID(((Iris) it.next()).getIrisId(), this.mContext.getOpPackageName())));
            i++;
        }
        return sparseArray;
    }

    public Size getMinimumIrisViewSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int iRound = Math.round(displayMetrics.density);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        int i4 = i < i2 ? i / iRound : i2 / iRound;
        return new Size(i4 * iRound, ((int) (i4 / 1.7777778f)) * iRound);
    }

    public boolean hasDisabledIrises() {
        if (ensureServiceConnected()) {
            try {
                if (this.mService != null) {
                    try {
                        try {
                            Class.forName("com.samsung.android.camera.iris.IIrisService").getMethod("hasDisabledIrises", Integer.TYPE, String.class);
                            return this.mService.hasDisabledIrises(UserHandle.myUserId(), this.mContext.getOpPackageName());
                        } catch (NoSuchMethodException unused) {
                            Log.v(TAG, "No Such Method of checking disabled irises");
                        }
                    } catch (ClassNotFoundException unused2) {
                        Log.v(TAG, "Class not founded");
                    }
                }
            } catch (RemoteException unused3) {
                Log.v(TAG, "Remote exception in getEnrolledFaces");
            }
        }
        return false;
    }

    public boolean hasEnrolledIrises() {
        IIrisService iIrisService;
        if (ensureServiceConnected() && (iIrisService = this.mService) != null) {
            try {
                return iIrisService.hasEnrolledIrises(UserHandle.myUserId(), this.mContext.getOpPackageName());
            } catch (RemoteException unused) {
                Log.v(TAG, "Remote exception in getEnrolledIrises");
            }
        }
        return false;
    }

    public boolean isHardwareDetected() {
        Log.w(TAG, "isIrisHardwareDetected()");
        Context context = this.mContext;
        if (context != null) {
            return context.getPackageManager().hasSystemFeature(SYSTEM_FEATURE_IRIS);
        }
        return false;
    }

    public void setIrisViewType(int i) {
        IIrisService iIrisService;
        if (ensureServiceConnected() && (iIrisService = this.mService) != null) {
            try {
                iIrisService.setIrisViewType(UserHandle.myUserId(), this.mContext.getOpPackageName(), i);
            } catch (RemoteException unused) {
                Log.v(TAG, "Remote exception in setIrisViewType");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class MyHandler extends Handler {
        private void sendAcquiredResult(long j, int i) {
            String acquiredString = SIrisManager.this.getAcquiredString(i);
            if (SIrisManager.this.mAuthenticationCallback == null || acquiredString == null) {
                return;
            }
            SIrisManager.this.mAuthenticationCallback.onAuthenticationHelp(i, acquiredString);
        }

        private void sendAuthenticatedFailed() {
            if (SIrisManager.this.mAuthenticationCallback != null) {
                SIrisManager.this.mAuthenticationCallback.onAuthenticationFailed();
            }
        }

        private void sendAuthenticatedSucceeded(Iris iris) {
            Log.w(SIrisManager.TAG, "sendAuthenticatedSucceeded, ir : " + iris);
            if (SIrisManager.this.mAuthenticationCallback != null) {
                SIrisManager.this.mAuthenticationCallback.onAuthenticationSucceeded(new AuthenticationResult(SIrisManager.this.mCryptoObject, iris));
            }
        }

        private void sendAuthenticatedSucceededFidoResultData(byte[] bArr) {
            Log.w(SIrisManager.TAG, "sendAuthenticatedSucceededFidoResultData, fidoResultData : " + Arrays.toString(bArr));
            if (SIrisManager.this.mCryptoObject != null) {
                SIrisManager.this.mCryptoObject.setFidoResultData(bArr);
            }
        }

        private void sendErrorResult(long j, int i) {
            Log.w(SIrisManager.TAG, "sendErrorResult, errMsgId : " + i);
            if (i == 4 || SIrisManager.this.mAuthenticationCallback == null) {
                return;
            }
            if (!SIrisManager.this.mContext.getOpPackageName().equals("com.samsung.android.server.iris") && !SIrisManager.this.mContext.getOpPackageName().equals("com.android.settings")) {
                SIrisManager.this.mContext.getOpPackageName().equals("com.android.systemui");
            }
            SIrisManager.this.mAuthenticationCallback.onAuthenticationError(i, SIrisManager.this.getErrorString(i));
        }

        private void sendIRImage(byte[] bArr, int i, int i2) {
            Log.w(SIrisManager.TAG, "sendIRImage, width : " + i + " height : " + i2);
            if (SIrisManager.this.mAuthenticationCallback != null) {
                SIrisManager.this.mAuthenticationCallback.onIRImage(bArr, i, i2);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 101:
                    sendAcquiredResult(((Long) message.obj).longValue(), message.arg1);
                    break;
                case 102:
                    sendAuthenticatedSucceeded((Iris) message.obj);
                    break;
                case 103:
                    sendAuthenticatedFailed();
                    break;
                case 104:
                    sendErrorResult(((Long) message.obj).longValue(), message.arg1);
                    break;
                case 106:
                    sendIRImage((byte[]) message.obj, message.arg1, message.arg2);
                    break;
                case 107:
                    sendAuthenticatedSucceededFidoResultData((byte[]) message.obj);
                    break;
            }
        }

        private MyHandler(Context context) {
            super(context.getMainLooper());
        }

        private MyHandler(Looper looper) {
            super(looper);
        }
    }

    private void authenticate(CryptoObject cryptoObject, CancellationSignal cancellationSignal, int i, AuthenticationCallback authenticationCallback, Handler handler, int i2, Bundle bundle, View view) {
        if (authenticationCallback == null) {
            throw new IllegalArgumentException("Must supply an authentication callback");
        }
        if (cancellationSignal != null) {
            if (cancellationSignal.isCanceled()) {
                Log.w(TAG, "authentication already canceled");
                return;
            }
            cancellationSignal.setOnCancelListener(new OnAuthenticationCancelListener(cryptoObject));
        }
        if (ensureServiceConnected() && this.mService != null) {
            try {
                useHandler(handler);
                this.mAuthenticationCallback = authenticationCallback;
                this.mCryptoObject = cryptoObject;
                long opId = cryptoObject != null ? cryptoObject.getOpId() : 0L;
                byte[] fidoRequestData = cryptoObject != null ? this.mCryptoObject.getFidoRequestData() : null;
                if (view == null) {
                    this.mService.authenticate(this.mToken, (IBinder) null, 0, 0, 0, 0, opId, i2, this.mServiceReceiver, i, this.mContext.getOpPackageName(), bundle, fidoRequestData);
                } else {
                    this.mAuthBegin = System.currentTimeMillis();
                    checkAuthViewWindowToken(cryptoObject, cancellationSignal, i, authenticationCallback, handler, i2, bundle, view, opId, fidoRequestData);
                }
            } catch (RemoteException unused) {
                Log.w(TAG, "Remote exception while authenticating");
                authenticationCallback.onAuthenticationError(1, getErrorString(1));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class CryptoObject {
        private final Object mCrypto;
        private final byte[] mFidoRequestData;
        private byte[] mFidoResultData = null;

        public CryptoObject(Signature signature, byte[] bArr) {
            this.mCrypto = signature;
            this.mFidoRequestData = bArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFidoResultData(byte[] bArr) {
            this.mFidoResultData = bArr;
        }

        public Cipher getCipher() {
            Object obj = this.mCrypto;
            if (obj instanceof Cipher) {
                return (Cipher) obj;
            }
            return null;
        }

        public byte[] getFidoRequestData() {
            return this.mFidoRequestData;
        }

        public byte[] getFidoResultData() {
            return this.mFidoResultData;
        }

        public Mac getMac() {
            Object obj = this.mCrypto;
            if (obj instanceof Mac) {
                return (Mac) obj;
            }
            return null;
        }

        public long getOpId() {
            Object obj = this.mCrypto;
            if (obj != null) {
                return AndroidKeyStoreProvider.getKeyStoreOperationHandle(obj);
            }
            return 0L;
        }

        public Signature getSignature() {
            Object obj = this.mCrypto;
            if (obj instanceof Signature) {
                return (Signature) obj;
            }
            return null;
        }

        public CryptoObject(Cipher cipher, byte[] bArr) {
            this.mCrypto = cipher;
            this.mFidoRequestData = bArr;
        }

        public CryptoObject(Mac mac, byte[] bArr) {
            this.mCrypto = mac;
            this.mFidoRequestData = bArr;
        }
    }

    public SIrisManager(Context context) {
        this.mContext = context;
        this.mHandler = new MyHandler(context);
    }
}
