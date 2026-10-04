package com.samsung.android.spen.libse;

import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.spen.libinterface.FloatingFeatureInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeFloatingFeature implements FloatingFeatureInterface {
    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public boolean getBoolean(String str) {
        return SemFloatingFeature.getInstance().getBoolean(str);
    }

    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public int getInt(String str, int i) {
        return SemFloatingFeature.getInstance().getInt(str);
    }

    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public String getString(String str) {
        return SemFloatingFeature.getInstance().getString(str);
    }

    @Override // com.samsung.android.spen.libinterface.FloatingFeatureInterface
    public int getInt(String str) {
        return SemFloatingFeature.getInstance().getInt(str);
    }
}
