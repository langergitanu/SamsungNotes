package com.samsung.android.support.senl.ntnl.coedit;

import android.content.Context;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.ntnl.common.exception.NtnlException;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class CoeditNativeLibrary {
    private static boolean sInitialized = false;

    private static native void Coedit_initParameters(String str, String str2, String str3);

    public static void initialize(Context context, String str) {
        if (sInitialized) {
            return;
        }
        loadLibrary();
        initializeParameters(context, str);
        sInitialized = true;
    }

    private static void initializeParameters(Context context, String str) {
        File filesDir = context.getFilesDir();
        if (filesDir == null || !(filesDir.exists() || filesDir.mkdir())) {
            throw new NtnlException("Cannot get the file path");
        }
        try {
            Coedit_initParameters(String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode), str, filesDir.getAbsolutePath());
        } catch (Exception e) {
            throw new NtnlException(AbstractC2322a.m1619i(e, new StringBuilder("Failed to get version info. ")));
        }
    }

    private static void loadLibrary() {
        try {
            System.loadLibrary("SamsungNotesCoedit");
        } catch (Throwable th) {
            throw new NtnlException(th.getMessage());
        }
    }
}
