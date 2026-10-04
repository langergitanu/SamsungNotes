package com.samsung.android.spen.libsdl;

import com.samsung.android.spen.libinterface.DisplayAdaptiveSyncManagerInterface;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlDisplayAdaptiveSyncManager implements DisplayAdaptiveSyncManagerInterface {
    @Override // com.samsung.android.spen.libinterface.DisplayAdaptiveSyncManagerInterface
    public int setAdaptiveSync(boolean z) throws NoSuchMethodException {
        Method declaredMethod = Class.forName("com.samsung.android.displayquality.SemDisplayAdaptiveSyncManager").getDeclaredMethod("setAdaptiveSync", Boolean.TYPE);
        if (declaredMethod == null) {
            return -1;
        }
        declaredMethod.setAccessible(true);
        return ((Integer) declaredMethod.invoke(null, Boolean.valueOf(z))).intValue();
    }
}
