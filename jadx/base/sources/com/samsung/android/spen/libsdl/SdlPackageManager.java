package com.samsung.android.spen.libsdl;

import android.content.pm.PackageManager;
import com.samsung.android.spen.libinterface.PackageManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlPackageManager implements PackageManagerInterface {
    private PackageManager mPackageManager;

    public SdlPackageManager(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    @Override // com.samsung.android.spen.libinterface.PackageManagerInterface
    public int getSystemFeatureLevel(String str) throws NoSuchMethodException {
        return ((Integer) PackageManager.class.getMethod("getSystemFeatureLevel", String.class).invoke(this.mPackageManager, new String(str))).intValue();
    }
}
