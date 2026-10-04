package com.samsung.android.spen.libsdl;

import com.samsung.android.spen.libinterface.FloatingFeatureInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlFloatingFeature implements FloatingFeatureInterface {
    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public boolean getBoolean(String str) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = Class.forName("com.samsung.android.feature.FloatingFeature").getMethod("getInstance", null).invoke(null, null);
        return ((Boolean) objInvoke.getClass().getMethod("getEnableStatus", String.class).invoke(objInvoke, str)).booleanValue();
    }

    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public int getInt(String str, int i) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName("com.samsung.android.feature.FloatingFeature");
        Method method = cls.getMethod("getInstance", null);
        Class<?>[] clsArr = {String.class, Integer.TYPE};
        return ((Integer) cls.getMethod("getInteger", clsArr).invoke(method.invoke(cls, null), new String(str), new Integer(i))).intValue();
    }

    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public String getString(String str) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = Class.forName("com.samsung.android.feature.FloatingFeature").getMethod("getInstance", null).invoke(null, null);
        return (String) objInvoke.getClass().getMethod("getString", String.class).invoke(objInvoke, str);
    }

    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public int getInt(String str) {
        return getInt(str, 0);
    }
}
