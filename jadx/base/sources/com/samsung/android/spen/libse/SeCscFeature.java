package com.samsung.android.spen.libse;

import com.samsung.android.feature.SemCscFeature;
import com.samsung.android.spen.libinterface.CscFeatureInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeCscFeature implements CscFeatureInterface {
    @Override // com.samsung.android.spen.libinterface.CscFeatureInterface
    public boolean getBoolean(String str, boolean z) {
        return SemCscFeature.getInstance().getBoolean(str, z);
    }
}
