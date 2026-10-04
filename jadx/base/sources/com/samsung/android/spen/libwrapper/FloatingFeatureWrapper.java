package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.FloatingFeatureInterface;
import com.samsung.android.spen.libsdl.SdlFloatingFeature;
import com.samsung.android.spen.libse.SeFloatingFeature;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FloatingFeatureWrapper {
    private FloatingFeatureInterface instance;

    private FloatingFeatureWrapper(FloatingFeatureInterface floatingFeatureInterface) throws PlatformException {
        try {
            this.instance = floatingFeatureInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static FloatingFeatureWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new FloatingFeatureWrapper(new SeFloatingFeature());
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new FloatingFeatureWrapper(new SdlFloatingFeature());
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public boolean getBoolean(String str) throws PlatformException {
        try {
            return this.instance.getBoolean(str);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getInt(String str, int i) throws PlatformException {
        try {
            return this.instance.getInt(str, i);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public String getString(String str) throws PlatformException {
        try {
            return this.instance.getString(str);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public int getInt(String str) throws PlatformException {
        try {
            return this.instance.getInt(str);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
