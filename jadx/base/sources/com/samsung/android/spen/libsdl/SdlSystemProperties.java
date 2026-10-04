package com.samsung.android.spen.libsdl;

import android.content.Context;
import com.samsung.android.spen.libinterface.SystemPropertiesInterface;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlSystemProperties implements SystemPropertiesInterface {
    private Context mContext;

    public SdlSystemProperties(Context context) {
        this.mContext = context;
    }

    @Override // com.samsung.android.spen.libinterface.SystemPropertiesInterface
    public String get(String str) {
        Context context = this.mContext;
        return (String) (context != null ? Class.forName("android.os.SystemProperties", true, context.getClassLoader()) : Class.forName("android.os.SystemProperties", true, null)).getMethod("get", String.class).invoke(null, new String(str));
    }

    @Override // com.samsung.android.spen.libinterface.SystemPropertiesInterface
    public String getSalesCode() throws ClassNotFoundException {
        Class<?> clsLoadClass = this.mContext.getClassLoader().loadClass("android.os.SystemProperties");
        String str = (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, new String("ro.csc.sales_code"));
        return (str == null || str.isEmpty()) ? CoverStickerConstants.Category.NONE.NAME : str;
    }
}
