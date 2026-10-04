package com.samsung.android.spen.libwrapper.utils;

import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ReflectUtils {
    private static final String TAG = "ReflectUtils";

    public static Class classForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException | LinkageError e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("Cannot load class: ", str, " : ");
            sbM15l.append(e.getMessage());
            Log.d(TAG, sbM15l.toString());
            return null;
        }
    }

    public static Constructor getConstructor(Class cls, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getConstructor(clsArr);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Cannot load constructor : " + e.getMessage());
            return null;
        }
    }

    public static Field getField(Class cls, String str) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException | SecurityException e) {
            Log.d(TAG, "Cannot load field: " + e.getMessage());
            return null;
        }
    }

    public static Method getMethod(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Cannot load method: " + e.getMessage());
            return null;
        }
    }
}
