package com.samsung.android.sdk.pass;

import android.app.Activity;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.core.p139ai.sdkcommon.ExtensionConst;
import com.samsung.android.fingerprint.FingerprintEvent;
import com.samsung.android.fingerprint.FingerprintIdentifyDialog;
import com.samsung.android.fingerprint.FingerprintManager;
import com.samsung.android.fingerprint.IFingerprintClient;
import com.samsung.android.sdk.pass.support.IFingerprintManagerProxy;
import com.samsung.android.sdk.pass.support.SdkSupporter;
import com.samsung.android.sdk.pass.support.p141v1.FingerprintManagerProxyFactory;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechRecognitionConst;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: loaded from: classes7.dex */
public class SpassFingerprint {
    public static final String ACTION_FINGERPRINT_ADDED = "com.samsung.android.intent.action.FINGERPRINT_ADDED";
    public static final String ACTION_FINGERPRINT_REMOVED = "com.samsung.android.intent.action.FINGERPRINT_REMOVED";
    public static final String ACTION_FINGERPRINT_RESET = "com.samsung.android.intent.action.FINGERPRINT_RESET";
    public static final int SENSOR_POSITION_HOMEKEY = 1;
    public static final int SENSOR_POSITION_REAR = 3;
    public static final int STATUS_AUTHENTIFICATION_FAILED = 16;
    public static final int STATUS_AUTHENTIFICATION_PASSWORD_SUCCESS = 100;
    public static final int STATUS_AUTHENTIFICATION_SUCCESS = 0;
    public static final int STATUS_BUTTON_PRESSED = 9;
    public static final int STATUS_OPERATION_DENIED = 51;
    public static final int STATUS_QUALITY_FAILED = 12;
    public static final int STATUS_SENSOR_FAILED = 7;
    public static final int STATUS_TIMEOUT_FAILED = 4;
    public static final int STATUS_USER_CANCELLED = 8;
    public static final int STATUS_USER_CANCELLED_BY_TOUCH_OUTSIDE = 13;
    public static final String TAG = "SpassFingerprintSDK";

    /* JADX INFO: renamed from: o */
    private static int f4890o;

    /* JADX INFO: renamed from: p */
    private static boolean f4891p;

    /* JADX INFO: renamed from: q */
    private static boolean f4892q;

    /* JADX INFO: renamed from: r */
    private static boolean f4893r;

    /* JADX INFO: renamed from: s */
    private static boolean f4894s;

    /* JADX INFO: renamed from: a */
    private IFingerprintManagerProxy f4895a;

    /* JADX INFO: renamed from: b */
    private Context f4896b;

    /* JADX INFO: renamed from: x */
    private Handler f4913x;

    /* JADX INFO: renamed from: c */
    private int f4897c = -1;

    /* JADX INFO: renamed from: d */
    private String f4898d = null;

    /* JADX INFO: renamed from: e */
    private Drawable f4899e = null;

    /* JADX INFO: renamed from: f */
    private ArrayList f4900f = null;

    /* JADX INFO: renamed from: g */
    private String f4901g = null;

    /* JADX INFO: renamed from: h */
    private int f4902h = -1;

    /* JADX INFO: renamed from: i */
    private String f4903i = null;

    /* JADX INFO: renamed from: j */
    private int f4904j = -1;

    /* JADX INFO: renamed from: k */
    private boolean f4905k = false;

    /* JADX INFO: renamed from: l */
    private String f4906l = null;

    /* JADX INFO: renamed from: m */
    private String f4907m = null;

    /* JADX INFO: renamed from: n */
    private boolean f4908n = false;

    /* JADX INFO: renamed from: t */
    private Dialog f4909t = null;

    /* JADX INFO: renamed from: u */
    private IFingerprintClient f4910u = null;

    /* JADX INFO: renamed from: v */
    private C7428a f4911v = null;

    /* JADX INFO: renamed from: w */
    private IBinder f4912w = null;

    /* JADX INFO: renamed from: y */
    private Object f4914y = new Object();

    public static class ClientSpecBuilder {

        /* JADX INFO: renamed from: a */
        private Bundle f4915a;

        public ClientSpecBuilder(String str) {
            Bundle bundle;
            int i;
            Bundle bundle2 = new Bundle();
            this.f4915a = bundle2;
            bundle2.putString(SpeechRecognitionConst.Key.INFO_SDK_VERSION, "Pass-v1.2.8");
            if ("samsung-hidden-pay".equals(str)) {
                this.f4915a.putBoolean("useManualTimeout", true);
                this.f4915a.putBoolean("privileged", true);
                bundle = this.f4915a;
                i = -2147483646;
            } else {
                if (!"samsung-hidden-common".equals(str)) {
                    return;
                }
                this.f4915a.putBoolean("useManualTimeout", true);
                this.f4915a.putBoolean("privileged", true);
                bundle = this.f4915a;
                i = 2;
            }
            bundle.putInt("privileged_attr", i);
        }

        public Bundle build() {
            return this.f4915a;
        }

        public ClientSpecBuilder setAllowFingers(int[] iArr) {
            if (iArr != null && iArr.length > 0) {
                this.f4915a.putIntArray("request_template_index_list", iArr);
            }
            return this;
        }

        public ClientSpecBuilder setExtraSpec(Bundle bundle) {
            this.f4915a.putAll(bundle);
            return this;
        }

        public ClientSpecBuilder setPrivilegedAttr(int i) {
            this.f4915a.putBoolean("privileged", true);
            this.f4915a.putInt("privileged_attr", i);
            return this;
        }
    }

    public interface IdentifyListener {
        void onCompleted();

        void onFinished(int i);

        void onReady();

        void onStarted();
    }

    public interface RegisterListener {
        void onFinished();
    }

    /* JADX INFO: renamed from: com.samsung.android.sdk.pass.SpassFingerprint$a */
    public class C7428a extends IFingerprintClient.Stub {

        /* JADX INFO: renamed from: a */
        private IdentifyListener f4916a;

        /* JADX INFO: renamed from: b */
        private int f4917b;

        private C7428a(IdentifyListener identifyListener) {
            this.f4917b = SpassFingerprint.f4891p ? 16 : 13;
            this.f4916a = identifyListener;
        }

        public final void onFingerprintEvent(FingerprintEvent fingerprintEvent) {
            String str;
            if (fingerprintEvent == null) {
                str = "onFingerprintEvent: null event will be ignored!";
            } else {
                try {
                    Log.d(SpassFingerprint.TAG, "evt : " + fingerprintEvent.eventId + SQLKeyword.COMMA + fingerprintEvent.eventResult + SQLKeyword.COMMA + fingerprintEvent.eventStatus);
                    IdentifyListener identifyListener = this.f4916a;
                    if (identifyListener != null && SpassFingerprint.this.f4913x != null) {
                        if (fingerprintEvent.eventId == this.f4917b) {
                            Log.d(SpassFingerprint.TAG, "onFingerprintEvent : completed = " + this.f4917b);
                            SpassFingerprint.this.f4910u = null;
                            SpassFingerprint.this.m5812f();
                        }
                        SpassFingerprint.this.f4913x.post(new RunnableC7434e(this, fingerprintEvent, identifyListener));
                        return;
                    }
                    return;
                } catch (Exception e) {
                    str = "onFingerprintEvent: Error : " + e;
                }
            }
            Log.w(SpassFingerprint.TAG, str);
        }

        public /* synthetic */ C7428a(SpassFingerprint spassFingerprint, IdentifyListener identifyListener, byte b) {
            this(identifyListener);
        }

        /* JADX INFO: renamed from: a */
        public final void m5822a(IdentifyListener identifyListener) {
            this.f4916a = identifyListener;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.sdk.pass.SpassFingerprint$b */
    public class C7429b implements FingerprintIdentifyDialog.FingerprintListener {

        /* JADX INFO: renamed from: a */
        private IdentifyListener f4919a;

        /* JADX INFO: renamed from: b */
        private FingerprintEvent f4920b;

        private C7429b(IdentifyListener identifyListener) {
            this.f4919a = identifyListener;
        }

        public final void onEvent(FingerprintEvent fingerprintEvent) {
            try {
                if (fingerprintEvent.eventId == 13 || SpassFingerprint.this.f4913x == null) {
                    this.f4920b = fingerprintEvent;
                } else {
                    SpassFingerprint.this.f4913x.post(new RunnableC7435f(this, fingerprintEvent));
                }
            } catch (Exception e) {
                Log.w(SpassFingerprint.TAG, "onFingerprintEvent: Error : " + e);
            }
        }

        public /* synthetic */ C7429b(SpassFingerprint spassFingerprint, IdentifyListener identifyListener, byte b) {
            this(identifyListener);
        }

        /* JADX INFO: renamed from: a */
        public final void m5825a() {
            FingerprintEvent fingerprintEvent = this.f4920b;
            IdentifyListener identifyListener = this.f4919a;
            if (fingerprintEvent == null || identifyListener == null || SpassFingerprint.this.f4913x == null) {
                return;
            }
            SpassFingerprint.this.f4913x.post(new RunnableC7436g(this, fingerprintEvent, identifyListener));
            this.f4919a = null;
            this.f4920b = null;
        }
    }

    public SpassFingerprint(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null.");
        }
        this.f4896b = context;
        if (!f4892q) {
            f4893r = context.getPackageManager().hasSystemFeature("com.sec.feature.fingerprint_manager_service");
            f4894s = m5815g();
            f4892q = true;
        }
        if (f4893r) {
            this.f4895a = FingerprintManagerProxyFactory.create(this.f4896b);
            this.f4913x = new Handler(context.getMainLooper());
            if (this.f4895a != null) {
                try {
                    if (this.f4895a.getSensorType() == FingerprintManager.class.getField("SENSOR_TYPE_TOUCH").getInt(null)) {
                        f4891p = true;
                    }
                } catch (Exception e) {
                    Log.i(TAG, "SpassFingerprint : " + e.toString());
                }
                f4890o = this.f4895a.getVersion();
            }
        }
        StringBuilder sb = new StringBuilder("SpassFingerprint : 1.2.8, ");
        sb.append(f4890o);
        sb.append(SQLKeyword.COMMA);
        AbstractC0000a.m27x(sb, f4891p, TAG);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ int m5798a(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 4;
        if (i != 4) {
            i2 = 51;
            if (i != 51) {
                i2 = 100;
                if (i != 100) {
                    i2 = 8;
                    if (i != 8) {
                        i2 = 9;
                        if (i != 9) {
                            switch (i) {
                                case 11:
                                    return 16;
                                case 12:
                                    return 12;
                                case 13:
                                    return 13;
                                default:
                                    return 7;
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m5812f() {
        this.f4895a.unregisterClient(this.f4912w);
        this.f4912w = null;
        resetListener();
    }

    public void cancelIdentify() {
        m5811e();
        IBinder iBinder = this.f4912w;
        if (iBinder == null && this.f4910u == null && this.f4909t == null) {
            throw new IllegalStateException("No Identify request.");
        }
        if (iBinder != null) {
            this.f4895a.cancel(iBinder);
        } else {
            if (this.f4910u == null && this.f4909t == null) {
                return;
            }
            this.f4895a.notifyAppActivityState(4, null);
            this.f4910u = null;
            this.f4909t = null;
        }
    }

    public void changeStandbyString(String str) {
        m5811e();
        if (m5820c()) {
            throw new IllegalStateException("setStandbyString is not supported.");
        }
        if (str == null) {
            throw new IllegalArgumentException("the standby text passed is null.");
        }
        if (str.length() > 100) {
            throw new IllegalArgumentException("the standby text passed is longer than 100 characters.");
        }
        this.f4907m = str;
    }

    public boolean checkBackupPassword(String str) {
        m5811e();
        if (str != null) {
            return this.f4895a.verifyPassword(str);
        }
        throw new IllegalArgumentException("password passed is null.");
    }

    public String getGuideForPoorQuality() {
        m5811e();
        String str = this.f4898d;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("FingerprintGuide is Invalid. This API must be called inside IdentifyListener.onFinished() with STATUS_QUALITY_FAILED only.");
    }

    public Drawable getGuideImageForPoorQuality() {
        m5811e();
        Drawable drawable = this.f4899e;
        if (drawable != null) {
            return drawable;
        }
        throw new IllegalStateException("FingerprintGuideImage is Invalid. This API must be called inside IdentifyListener.onFinished() with STATUS_QUALITY_FAILED only.");
    }

    public int getIdentifiedFingerprintIndex() {
        m5811e();
        int i = this.f4897c;
        if (i != -1) {
            return i;
        }
        throw new IllegalStateException("FingerprintIndex is Invalid. This API must be called inside IdentifyListener.onFinished() only.");
    }

    public SparseArray getRegisteredFingerprintName() {
        m5811e();
        SparseArray sparseArray = new SparseArray();
        int enrolledFingers = this.f4895a.getEnrolledFingers();
        if (enrolledFingers <= 0) {
            return null;
        }
        for (int i = 1; i <= 10; i++) {
            if (((1 << i) & enrolledFingers) != 0) {
                sparseArray.put(i, this.f4895a.getIndexName(i));
            }
        }
        return sparseArray;
    }

    public SparseArray getRegisteredFingerprintUniqueID() {
        m5811e();
        if (!m5819b()) {
            throw new IllegalStateException("getRegisteredFingerprintUniqueID is not supported.");
        }
        SparseArray sparseArray = new SparseArray();
        int enrolledFingers = this.f4895a.getEnrolledFingers();
        if (enrolledFingers <= 0) {
            return null;
        }
        for (int i = 1; i <= 10; i++) {
            if (((1 << i) & enrolledFingers) != 0) {
                sparseArray.put(i, this.f4895a.getFingerprintId(i));
            }
        }
        return sparseArray;
    }

    public int getSensorPosition() {
        try {
            m5811e();
            return this.f4895a.getSensorPosition();
        } catch (UnsupportedOperationException e) {
            Log.w(TAG, "getSensorPosition : " + e.getMessage());
            return 0;
        } catch (Exception e2) {
            Log.w(TAG, "getSensorPosition : failed ", e2);
            return 0;
        }
    }

    public boolean hasDisabledFingerprint() {
        android.hardware.fingerprint.FingerprintManager fingerprintManager;
        m5811e();
        if (!Spass.f4883a || this.f4895a.getEnrolledFingers() != 0 || (fingerprintManager = (android.hardware.fingerprint.FingerprintManager) this.f4896b.getSystemService("fingerprint")) == null) {
            return false;
        }
        try {
            return ((Boolean) fingerprintManager.getClass().getMethod("semHasDisabledFingerprints", null).invoke(fingerprintManager, null)).booleanValue();
        } catch (Exception e) {
            Log.i(TAG, "hasDisabledFingerprint : " + e.toString());
            return false;
        }
    }

    public boolean hasRegisteredFinger() {
        m5811e();
        return this.f4895a.getEnrolledFingers() != 0;
    }

    public boolean isSensorReady() {
        try {
            m5811e();
            return this.f4895a.isSensorReady();
        } catch (UnsupportedOperationException e) {
            Log.w(TAG, "isSensorReady : " + e.getMessage());
            return false;
        } catch (Exception e2) {
            Log.w(TAG, "isSensorReady : failed ", e2);
            return false;
        }
    }

    public boolean isTouchType() {
        return f4891p;
    }

    public void registerFinger(Context context, RegisterListener registerListener) {
        m5811e();
        if (context == null) {
            throw new IllegalArgumentException("activityContext passed is null.");
        }
        if (registerListener == null) {
            throw new IllegalArgumentException("listener passed is null.");
        }
        if (this.f4895a.isEnrolling()) {
            this.f4895a.notifyEnrollEnd();
        }
        try {
            context.getPackageManager();
            try {
                if (!this.f4895a.isSensorReady()) {
                    throw new IllegalStateException("An error has occurred with the fingerprint sensor.");
                }
                this.f4895a.startEnrollActivity(context, new C7431b(registerListener), toString());
            } catch (UndeclaredThrowableException unused) {
                throw new IllegalArgumentException("activityContext is invalid");
            }
        } catch (NullPointerException unused2) {
            throw new IllegalArgumentException("activityContext is invalid");
        }
    }

    public void resetListener() {
        C7428a c7428a = this.f4911v;
        if (c7428a != null) {
            c7428a.m5822a((IdentifyListener) null);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        m5811e();
        if (!m5804a()) {
            throw new IllegalStateException("setCanceledOnTouchOutside is not supported.");
        }
        this.f4905k = z;
    }

    public void setDialogBgTransparency(int i) {
        m5811e();
        if (!m5804a()) {
            throw new IllegalStateException("setDialogBGTransparency is not supported.");
        }
        if (i < 0 || i > 255) {
            throw new IllegalArgumentException("the transparency passed is not valid.");
        }
        this.f4904j = i;
    }

    public void setDialogButton(String str) {
        m5811e();
        if (m5820c()) {
            throw new IllegalStateException("setDialogButton is not supported.");
        }
        if (str == null) {
            throw new IllegalArgumentException("the buttonText passed is null.");
        }
        if (str.length() > 32) {
            throw new IllegalArgumentException("the title text passed is longer than 32 characters.");
        }
        this.f4906l = str;
    }

    public void setDialogIcon(String str) {
        m5811e();
        if (!m5804a()) {
            throw new IllegalStateException("setDialogIcon is not supported.");
        }
        if (str == null) {
            throw new IllegalArgumentException("the iconName passed is null.");
        }
        if (!m5805a(str)) {
            throw new IllegalArgumentException("the iconName passed is not valid.");
        }
        this.f4903i = str;
    }

    public void setDialogTitle(String str, int i) {
        m5811e();
        if (!m5804a()) {
            throw new IllegalStateException("setDialogTitle is not supported.");
        }
        if (str == null) {
            throw new IllegalArgumentException("the titletext passed is null.");
        }
        if (str.length() > 256) {
            throw new IllegalArgumentException("the title text passed is longer than 256 characters.");
        }
        if ((i >>> 24) != 0) {
            throw new IllegalArgumentException("alpha value is not supported in the titleColor.");
        }
        this.f4901g = str;
        this.f4902h = i - 16777216;
    }

    public void setIntendedFingerprintIndex(ArrayList arrayList) {
        m5811e();
        if (arrayList == null) {
            Log.w(TAG, "requestedIndex is null. Identify is carried out for all indexes.");
            return;
        }
        if (!m5804a()) {
            throw new IllegalStateException("setIntendedFingerprintIndex is not supported.");
        }
        this.f4900f = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            this.f4900f.add((Integer) arrayList.get(i));
        }
    }

    public void startIdentify(IdentifyListener identifyListener) {
        startIdentify(identifyListener, null);
    }

    public void startIdentifyWithDialog(Context context, IdentifyListener identifyListener, boolean z) {
        int[] iArr;
        m5811e();
        if (context == null) {
            throw new IllegalArgumentException("activityContext passed is null.");
        }
        if (identifyListener == null) {
            throw new IllegalArgumentException("listener passed is null.");
        }
        try {
            context.getPackageManager();
            if (!(context instanceof Activity)) {
                Log.w(TAG, "startIdentifyWithDialog : No Actvity Context");
            }
            byte b = 0;
            if (!m5804a()) {
                C7429b c7429b = new C7429b(this, identifyListener, b);
                Dialog dialogShowIdentifyDialog = this.f4895a.showIdentifyDialog(context, c7429b, null, z);
                this.f4909t = dialogShowIdentifyDialog;
                if (dialogShowIdentifyDialog == null) {
                    throw new IllegalStateException("Identify operation is failed.");
                }
                dialogShowIdentifyDialog.setOnDismissListener(new DialogInterfaceOnDismissListenerC7430a(c7429b));
                this.f4909t.show();
                return;
            }
            ArrayList arrayList = this.f4900f;
            if (arrayList == null || arrayList.size() <= 0) {
                iArr = null;
            } else {
                iArr = new int[this.f4900f.size()];
                for (int i = 0; i < this.f4900f.size(); i++) {
                    iArr[i] = ((Integer) this.f4900f.get(i)).intValue();
                }
            }
            this.f4910u = new C7428a(this, identifyListener, b);
            try {
                Bundle bundle = new Bundle();
                bundle.putBoolean("password", z);
                bundle.putString("packageName", context.getPackageName());
                bundle.putString(SpeechRecognitionConst.Key.INFO_SDK_VERSION, "Pass-v1.2.8");
                bundle.putBoolean("demandExtraEvent", true);
                if (iArr != null) {
                    bundle.putIntArray("request_template_index_list", iArr);
                }
                String str = this.f4901g;
                if (str != null) {
                    bundle.putString("titletext", str);
                }
                int i2 = this.f4902h;
                if (i2 != -1) {
                    bundle.putInt("titlecolor", i2);
                }
                String str2 = this.f4903i;
                if (str2 != null) {
                    bundle.putString("iconname", str2);
                }
                int i4 = this.f4904j;
                if (i4 != -1) {
                    bundle.putInt("transparency", i4);
                }
                boolean z2 = this.f4905k;
                if (z2) {
                    bundle.putBoolean("touchoutside", z2);
                }
                String str3 = this.f4906l;
                if (str3 != null) {
                    bundle.putString("button_name", str3);
                }
                String str4 = this.f4907m;
                if (str4 != null) {
                    bundle.putString("standby_string", str4);
                }
                if (this.f4895a.identifyWithDialog(context, this.f4910u, bundle) != 0) {
                    throw new IllegalStateException("Identify operation is failed.");
                }
                this.f4900f = null;
                this.f4901g = null;
                this.f4902h = -1;
                this.f4904j = -1;
                this.f4903i = null;
                this.f4905k = false;
                this.f4907m = null;
                this.f4906l = null;
            } catch (Throwable th) {
                this.f4900f = null;
                this.f4901g = null;
                this.f4902h = -1;
                this.f4904j = -1;
                this.f4903i = null;
                this.f4905k = false;
                this.f4907m = null;
                this.f4906l = null;
                throw th;
            }
        } catch (NullPointerException unused) {
            throw new IllegalArgumentException("activityContext is invalid");
        }
    }

    public void updateActiveUser() {
        Log.v(TAG, "updateActiveUser : waiting for active user");
        if (Spass.f4883a && Build.VERSION.SDK_INT == 26) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            HandlerThread handlerThread = new HandlerThread("SpassSdk-updateActiveUser");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            handler.post(new RunnableC7432c(this, handler));
            synchronized (this.f4914y) {
                try {
                    this.f4914y.wait(1000L);
                } catch (InterruptedException unused) {
                }
            }
            handlerThread.quitSafely();
            Log.v(TAG, "updateActiveUser : t = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    /* JADX INFO: renamed from: e */
    private synchronized void m5811e() {
        if (!f4893r) {
            throw new UnsupportedOperationException("Fingerprint Service is not supported in the platform.");
        }
        if (this.f4895a == null) {
            Log.i(TAG, "ensureServiceSupported : proxy is null, retry to create proxy");
            IFingerprintManagerProxy iFingerprintManagerProxyCreate = FingerprintManagerProxyFactory.create(this.f4896b);
            this.f4895a = iFingerprintManagerProxyCreate;
            if (iFingerprintManagerProxyCreate == null) {
                throw new UnsupportedOperationException("Fingerprint Service is not running on the device.");
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private static boolean m5815g() {
        boolean zBooleanValue;
        if (f4892q) {
            return f4894s;
        }
        try {
            Class<?> cls = Class.forName("com.samsung.android.feature.FloatingFeature");
            zBooleanValue = ((Boolean) cls.getMethod("getEnableStatus", String.class).invoke(cls.getMethod("getInstance", null).invoke(null, null), "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")).booleanValue();
        } catch (Exception e) {
            Log.d(TAG, "Survey Mode : " + e.toString());
            try {
                Class<?> cls2 = Class.forName("com.samsung.android.feature.SemFloatingFeature");
                zBooleanValue = ((Boolean) cls2.getMethod("getBoolean", String.class).invoke(cls2.getMethod("getInstance", null).invoke(null, null), "SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")).booleanValue();
            } catch (Exception e2) {
                Log.d(TAG, "Survey Mode : " + e2.toString());
                zBooleanValue = false;
            }
        }
        AbstractC4539a.m3208r("Survey Mode : ", TAG, zBooleanValue);
        return zBooleanValue;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m5819b() {
        m5811e();
        try {
            Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("isSupportFingerprintIds", null);
            return this.f4895a.isSupportFingerprintIds();
        } catch (Exception e) {
            Log.w(TAG, e);
            return m5804a();
        }
    }

    /* JADX INFO: renamed from: c */
    public final boolean m5820c() {
        m5811e();
        try {
            Class.forName(SdkSupporter.CLASSNAME_FINGERPRINT_MANAGER).getMethod("isSupportBackupPassword", null);
            return this.f4895a.isSupportBackupPassword();
        } catch (Exception e) {
            Log.w(TAG, e);
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void startIdentify(IdentifyListener identifyListener, ClientSpecBuilder clientSpecBuilder) {
        m5811e();
        if (identifyListener == null) {
            throw new IllegalArgumentException("listener passed is null.");
        }
        Object[] objArr = 0;
        if (this.f4911v == null) {
            this.f4911v = new C7428a(this, identifyListener, objArr == true ? 1 : 0);
        }
        if (clientSpecBuilder == null) {
            clientSpecBuilder = new ClientSpecBuilder("samsung-hidden-common");
        }
        ArrayList arrayList = this.f4900f;
        if (arrayList != null && arrayList.size() > 0) {
            int[] iArr = new int[this.f4900f.size()];
            for (int i = 0; i < this.f4900f.size(); i++) {
                iArr[i] = ((Integer) this.f4900f.get(i)).intValue();
            }
            this.f4900f = null;
            clientSpecBuilder.setAllowFingers(iArr);
        }
        Bundle bundleBuild = clientSpecBuilder.build();
        bundleBuild.putString("appName", this.f4896b.getPackageName());
        IBinder iBinderRegisterClient = this.f4895a.registerClient(this.f4911v, bundleBuild);
        this.f4912w = iBinderRegisterClient;
        if (iBinderRegisterClient == null) {
            throw new IllegalStateException("failed because registerClient returned null.");
        }
        int iIdentify = this.f4895a.identify(iBinderRegisterClient, null);
        if (iIdentify == 0) {
            this.f4911v.m5822a(identifyListener);
            return;
        }
        m5812f();
        AbstractC2322a.m1631u(iIdentify, "startIdentify : failed, ", TAG);
        if (iIdentify == -2) {
            throw new IllegalStateException("Identify request is denied because a previous request is still in progress.");
        }
        if (iIdentify != 51) {
            throw new IllegalStateException("Identify operation is failed.");
        }
        throw new SpassInvalidStateException("Identify request is denied because 5 identify attempts are failed.", 1);
    }

    /* JADX INFO: renamed from: a */
    public static void m5800a(Context context, String str) {
        if (m5815g()) {
            if (context.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
                Log.d(TAG, "insertLog :  No permission");
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", SpassFingerprint.class.getPackage().getName());
            contentValues.put(ExtensionConst.KEY_PARAM_FEATURE, String.valueOf(context.getPackageName()).concat("#14"));
            if (str != null) {
                contentValues.put("extra", str);
            }
            Intent intent = new Intent();
            intent.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent.putExtra("data", contentValues);
            intent.setPackage("com.samsung.android.providers.context");
            context.sendBroadcast(intent);
            Log.i(TAG, "insertLog : " + contentValues.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5804a() {
        return f4890o >= 16843008;
    }

    /* JADX INFO: renamed from: a */
    private boolean m5805a(String str) {
        String packageName = this.f4896b.getPackageName();
        try {
            Resources resourcesForApplication = this.f4896b.getPackageManager().getResourcesForApplication(packageName);
            if (resourcesForApplication == null) {
                return false;
            }
            try {
                int identifier = resourcesForApplication.getIdentifier(str, "drawable", packageName);
                if (identifier != 0 && identifier != -1) {
                    return BitmapFactory.decodeResource(resourcesForApplication, identifier) != null;
                }
            } catch (Resources.NotFoundException unused) {
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
