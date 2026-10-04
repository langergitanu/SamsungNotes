package com.samsung.android.spen.libse;

import android.content.Context;
import android.os.SemSystemProperties;
import com.samsung.android.spen.libinterface.SystemPropertiesInterface;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SeSystemProperties implements SystemPropertiesInterface {
    private Context mContext;

    public SeSystemProperties(Context context) {
        this.mContext = context;
    }

    @Override // com.samsung.android.spen.libinterface.SystemPropertiesInterface
    public String get(String str) throws NoSuchMethodException, ClassNotFoundException {
        String str2;
        Context context = this.mContext;
        if (context == null) {
            return CoverStickerConstants.Category.NONE.NAME;
        }
        Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
        Method method = clsLoadClass.getMethod("get", String.class);
        return (method == null || (str2 = (String) method.invoke(clsLoadClass, new String(str))) == null || str2.isEmpty()) ? CoverStickerConstants.Category.NONE.NAME : str2;
    }

    @Override // com.samsung.android.spen.libinterface.SystemPropertiesInterface
    public String getSalesCode() {
        String salesCode = SemSystemProperties.getSalesCode();
        return (salesCode == null || salesCode.isEmpty()) ? CoverStickerConstants.Category.NONE.NAME : salesCode;
    }
}
