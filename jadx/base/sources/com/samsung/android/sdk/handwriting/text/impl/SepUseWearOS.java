package com.samsung.android.sdk.handwriting.text.impl;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.handwriting.text.interfaces.SepUseInterface;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SepUseWearOS implements SepUseInterface {
    private static final String TAG = "SepUseWearOS";

    @Override // com.samsung.android.sdk.handwriting.text.interfaces.SepUseInterface
    public boolean isSamsungKeyboardPackage(Context context) {
        String packageName = context.getPackageName();
        Log.i(TAG, "[isSamsungKeyboardPackage] pkgName : " + packageName);
        return DirectWriteConstant.SAMSUNG_HONEYBOARD_PKG_NAME.compareTo(packageName) == 0 || DirectWriteConstant.DEFAULT_SAMSUNGKEYBOARD_PKG_NAME.compareTo(packageName) == 0 || "com.sec.android.inputmethod.iwnnime.japan".compareTo(packageName) == 0 || "com.sec.android.inputmethod.beta".compareTo(packageName) == 0;
    }
}
