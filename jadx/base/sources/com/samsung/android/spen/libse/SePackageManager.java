package com.samsung.android.spen.libse;

import android.content.pm.PackageManager;
import com.samsung.android.spen.libinterface.PackageManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SePackageManager implements PackageManagerInterface {
    private PackageManager mPackageManager;

    public SePackageManager(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    @Override // com.samsung.android.spen.libinterface.PackageManagerInterface
    public int getSystemFeatureLevel(String str) {
        return this.mPackageManager.semGetSystemFeatureLevel(str);
    }
}
