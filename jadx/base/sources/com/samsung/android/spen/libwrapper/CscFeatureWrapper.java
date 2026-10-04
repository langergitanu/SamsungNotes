package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.CscFeatureInterface;
import com.samsung.android.spen.libsdl.SdlCscFeature;
import com.samsung.android.spen.libse.SeCscFeature;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class CscFeatureWrapper {
    private CscFeatureInterface instance;

    private CscFeatureWrapper(CscFeatureInterface cscFeatureInterface) throws PlatformException {
        try {
            this.instance = cscFeatureInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static CscFeatureWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new CscFeatureWrapper(new SeCscFeature());
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new CscFeatureWrapper(new SdlCscFeature());
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public boolean getBoolean(String str, boolean z) throws PlatformException {
        try {
            return this.instance.getBoolean(str, z);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
