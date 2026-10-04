package com.samsung.android.spen.libse;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import com.samsung.android.spen.libinterface.TypefaceInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeTypeface implements TypefaceInterface {
    @Override // com.samsung.android.spen.libinterface.TypefaceInterface
    public String getFontPathOfCurrentFontStyle(Context context, int i) {
        try {
            return Typeface.semGetFontPathOfCurrentFontStyle(context, i);
        } catch (Error | Exception e) {
            Log.e("SpenUtilText", "Exception is occurred with reflection of getFontPathFlipFont.");
            throw e;
        }
    }
}
