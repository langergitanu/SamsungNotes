package com.samsung.android.spen.libwrapper;

import android.content.Context;
import com.samsung.android.spen.libinterface.PackageManagerInterface;
import com.samsung.android.spen.libsdl.SdlPackageManager;
import com.samsung.android.spen.libse.SePackageManager;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PackageManagerWrapper {
    private PackageManagerInterface instance;

    private PackageManagerWrapper(PackageManagerInterface packageManagerInterface) throws PlatformException {
        try {
            this.instance = packageManagerInterface;
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }

    public static PackageManagerWrapper create(Context context) throws PlatformException {
        if (!PlatformUtils.isSamsungDevice(context)) {
            throw new PlatformException();
        }
        if (PlatformUtils.isSemDevice(context)) {
            try {
                return new PackageManagerWrapper(new SePackageManager(context.getPackageManager()));
            } catch (Error | Exception e) {
                throw new PlatformException(PlatformException.f5434SE, e);
            }
        }
        try {
            return new PackageManagerWrapper(new SdlPackageManager(context.getPackageManager()));
        } catch (Error | Exception e2) {
            throw new PlatformException(PlatformException.SDL, e2);
        }
    }

    public int getSystemFeatureLevel(String str) throws PlatformException {
        try {
            return this.instance.getSystemFeatureLevel(str);
        } catch (Error | Exception e) {
            throw new PlatformException(e);
        }
    }
}
