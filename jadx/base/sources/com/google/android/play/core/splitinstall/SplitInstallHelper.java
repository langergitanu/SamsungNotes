package com.google.android.play.core.splitinstall;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import com.google.android.play.core.internal.C5157af;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class SplitInstallHelper {

    /* JADX INFO: renamed from: a */
    private static final C5157af f3059a = new C5157af("SplitInstallHelper");

    private SplitInstallHelper() {
    }

    public static void loadLibrary(@NonNull Context context, @NonNull String str) {
        synchronized (C5309k.class) {
            try {
                System.loadLibrary(str);
            } catch (UnsatisfiedLinkError e) {
                String str2 = context.getApplicationInfo().nativeLibraryDir;
                String strMapLibraryName = System.mapLibraryName(str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(strMapLibraryName).length());
                sb.append(str2);
                sb.append("/");
                sb.append(strMapLibraryName);
                String string = sb.toString();
                if (!new File(string).exists()) {
                    throw e;
                }
                System.load(string);
            }
        }
    }

    public static void updateAppInfo(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        C5157af c5157af = f3059a;
        c5157af.m3878c("Calling dispatchPackageBroadcast", new Object[0]);
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method method = cls.getMethod("currentActivityThread", null);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mAppThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(objInvoke);
            obj.getClass().getMethod("dispatchPackageBroadcast", Integer.TYPE, String[].class).invoke(obj, 3, new String[]{context.getPackageName()});
            c5157af.m3878c("Called dispatchPackageBroadcast", new Object[0]);
        } catch (Exception e) {
            f3059a.m3876a(e, "Update app info with dispatchPackageBroadcast failed!", new Object[0]);
        }
    }
}
