package com.samsung.android.imagetranslation.util;

import android.database.CursorWindow;
import android.graphics.Typeface;
import android.hardware.biometrics.BiometricPrompt$AuthenticationCallback;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.SessionConfiguration;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.WrappedKeyEntry;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.view.textclassifier.TextClassification;
import android.widget.Magnifier;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import java.util.ArrayList;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.util.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract /* synthetic */ class AbstractC7150s {
    /* JADX INFO: renamed from: A */
    public static /* synthetic */ void m5493A() {
    }

    /* JADX INFO: renamed from: c */
    public static /* synthetic */ CursorWindow m5499c() {
        return new CursorWindow("NotesCursor", 4194304L);
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ CursorWindow m5500d(long j) {
        return new CursorWindow("NotesCursor", j);
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ BiometricPrompt$AuthenticationCallback m5504h(Object obj) {
        return (BiometricPrompt$AuthenticationCallback) obj;
    }

    /* JADX INFO: renamed from: l */
    public static /* synthetic */ SessionConfiguration m5508l(ArrayList arrayList, CameraFragment.HandlerExecutor handlerExecutor, CameraCaptureSession.StateCallback stateCallback) {
        return new SessionConfiguration(0, arrayList, handlerExecutor, stateCallback);
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ WrappedKeyEntry m5509m(byte[] bArr, String str, KeyGenParameterSpec keyGenParameterSpec) {
        return new WrappedKeyEntry(bArr, str, "RSA/ECB/OAEPPadding", keyGenParameterSpec);
    }

    /* JADX INFO: renamed from: n */
    public static /* synthetic */ TypefaceSpan m5510n(Typeface typeface) {
        return new TypefaceSpan(typeface);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ TextClassification.Request.Builder m5511o(int i, String str) {
        return new TextClassification.Request.Builder(str, 0, i);
    }

    /* JADX INFO: renamed from: p */
    public static /* synthetic */ Magnifier m5512p(View view) {
        return new Magnifier(view);
    }

    /* JADX INFO: renamed from: r */
    public static /* synthetic */ void m5514r() {
    }
}
