package com.samsung.android.spen.libsdl;

import android.content.Context;
import android.util.Log;
import com.samsung.android.spen.libinterface.TypefaceInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlTypeface implements TypefaceInterface {
    @Override // com.samsung.android.spen.libinterface.TypefaceInterface
    public String getFontPathOfCurrentFontStyle(Context context, int i) throws Throwable {
        try {
            return (String) Class.forName("android.graphics.Typeface").getMethod("getFontPathFlipFont", Context.class, Integer.TYPE).invoke(null, context, Integer.valueOf(i));
        } catch (ClassNotFoundException e) {
            throw e;
        } catch (Exception e2) {
            e = e2;
            Log.e("SpenUtilText", "Exception is occurred with reflection of getFontPathFlipFont.");
            throw e;
        } catch (NoSuchMethodError e3) {
            Log.e("SpenUtilText", "NoSuchMethodError is occurred with reflection of getFontPathFlipFont.");
            throw e3;
        } catch (Error e5) {
            e = e5;
            Log.e("SpenUtilText", "Exception is occurred with reflection of getFontPathFlipFont.");
            throw e;
        }
    }
}
