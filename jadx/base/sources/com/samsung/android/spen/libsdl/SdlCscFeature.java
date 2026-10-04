package com.samsung.android.spen.libsdl;

import com.samsung.android.spen.libinterface.CscFeatureInterface;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlCscFeature implements CscFeatureInterface {
    @Override // com.samsung.android.spen.libinterface.CscFeatureInterface
    public boolean getBoolean(String str, boolean z) throws IllegalAccessException, InvocationTargetException {
        Object objInvoke = Class.forName("com.sec.android.app.CscFeature").getMethod("getInstance", null).invoke(null, null);
        return ((Boolean) objInvoke.getClass().getMethod("getEnableStatus", String.class, Boolean.TYPE).invoke(objInvoke, str, Boolean.FALSE)).booleanValue();
    }
}
