package com.samsung.android.spen.libse;

import android.content.Context;
import android.graphics.Rect;
import com.samsung.android.infoextraction.SemInfoExtractionManager;
import com.samsung.android.spen.libinterface.HermesServiceManagerInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeHermesServiceManager implements HermesServiceManagerInterface {
    private SemInfoExtractionManager mInfoExtractionManager;

    public SeHermesServiceManager(Context context) {
        this.mInfoExtractionManager = null;
        if (isPenFeatureModel(context)) {
            this.mInfoExtractionManager = new SemInfoExtractionManager(context);
        }
    }

    private boolean isPenFeatureModel(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.sec.feature.spen_usp");
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.samsung.android.spen.libinterface.HermesServiceManagerInterface
    public void dismissHermes() {
    }

    @Override // com.samsung.android.spen.libinterface.HermesServiceManagerInterface
    public void showHermes(String str, Rect rect) {
    }
}
