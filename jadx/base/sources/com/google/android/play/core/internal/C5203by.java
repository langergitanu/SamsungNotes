package com.google.android.play.core.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.google.android.play.core.splitcompat.C5271p;

/* JADX INFO: renamed from: com.google.android.play.core.internal.by */
/* JADX INFO: loaded from: classes5.dex */
public final class C5203by {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2970a = new C5157af("PhoneskyVerificationUtils");

    /* JADX INFO: renamed from: a */
    public static boolean m3973a(Context context) {
        Signature[] signatureArr;
        try {
            signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (signatureArr == null || (signatureArr.length) == 0) {
            f2970a.m3879d("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
            return false;
        }
        for (Signature signature : signatureArr) {
            String strM4097a = C5271p.m4097a(signature.toByteArray());
            if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(strM4097a)) {
                return true;
            }
            String str = Build.TAGS;
            if ((str.contains("dev-keys") || str.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(strM4097a)) {
                return true;
            }
        }
        return false;
    }
}
