package com.samsung.android.sdk.pass;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.util.Log;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import com.samsung.android.sdk.SsdkVendorCheck;

/* JADX INFO: loaded from: classes7.dex */
public class Spass implements SsdkInterface {
    public static final int DEVICE_FINGERPRINT = 0;
    public static final int DEVICE_FINGERPRINT_AVAILABLE_PASSWORD = 4;
    public static final int DEVICE_FINGERPRINT_CUSTOMIZED_DIALOG = 2;
    public static final int DEVICE_FINGERPRINT_FINGER_INDEX = 1;
    public static final int DEVICE_FINGERPRINT_GESTURE = 5;
    public static final int DEVICE_FINGERPRINT_UNIQUE_ID = 3;

    /* JADX INFO: renamed from: a */
    static boolean f4883a;

    /* JADX INFO: renamed from: b */
    private static boolean f4884b;

    /* JADX INFO: renamed from: c */
    private static boolean f4885c;

    /* JADX INFO: renamed from: d */
    private static boolean f4886d;

    /* JADX INFO: renamed from: e */
    private static boolean f4887e;

    /* JADX INFO: renamed from: f */
    private static boolean f4888f;

    /* JADX INFO: renamed from: g */
    private Context f4889g;

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        return 14;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return "1.2.8";
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context) throws SsdkUnsupportedException {
        FingerprintManager fingerprintManager;
        if (this.f4889g != null) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context passed is null.");
        }
        if (!SsdkVendorCheck.isSamsungDevice()) {
            throw new SsdkUnsupportedException("This is not Samsung device.", 0);
        }
        try {
            f4883a = context.getPackageManager().hasSystemFeature("android.hardware.fingerprint");
            boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("com.sec.feature.fingerprint_manager_service");
            f4884b = zHasSystemFeature;
            if (!zHasSystemFeature) {
                throw new SsdkUnsupportedException("This device does not provide FingerprintService.", 1);
            }
            SpassFingerprint spassFingerprint = new SpassFingerprint(context);
            f4886d = SpassFingerprint.m5804a();
            f4885c = spassFingerprint.m5819b();
            f4887e = spassFingerprint.m5820c();
            if (f4883a && (fingerprintManager = (FingerprintManager) context.getSystemService("fingerprint")) != null && fingerprintManager.isHardwareDetected()) {
                try {
                    f4888f = ((Boolean) fingerprintManager.getClass().getMethod("semHasFeature", Integer.TYPE).invoke(fingerprintManager, Integer.valueOf(fingerprintManager.getClass().getField("SEM_FEATURE_NAVIGATION").getInt(null)))).booleanValue();
                } catch (Exception e) {
                    Log.i(SpassFingerprint.TAG, "isFeatureEnabled : " + e.toString());
                }
            }
            this.f4889g = context;
            Log.i(SpassFingerprint.TAG, "initialize : BP=" + f4887e + ",CD=" + f4886d + ",ID=" + f4885c + ",GT=" + f4888f);
            SpassFingerprint.m5800a(context, (String) null);
        } catch (NullPointerException unused) {
            throw new IllegalArgumentException("context is not valid.");
        }
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int i) {
        if (this.f4889g == null) {
            throw new IllegalStateException("initialize() is not Called first.");
        }
        if (i == 0) {
            return f4884b;
        }
        if (i == 1 || i == 2) {
            return f4886d;
        }
        if (i == 3) {
            return f4885c;
        }
        if (i == 4) {
            return f4887e;
        }
        if (i == 5) {
            return f4888f;
        }
        throw new IllegalArgumentException("type passed is not valid");
    }
}
