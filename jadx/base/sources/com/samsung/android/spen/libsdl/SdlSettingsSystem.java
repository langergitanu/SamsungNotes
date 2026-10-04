package com.samsung.android.spen.libsdl;

import android.content.ContentResolver;
import com.samsung.android.spen.libinterface.SettingsSystemInterface;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SdlSettingsSystem implements SettingsSystemInterface {
    public static final String PEN_HOVERING = "pen_hovering";
    public static final String PEN_HOVERING_INFORMATION_PREVIEW = "pen_hovering_information_preview";
    public static final int USER_OWNER = 0;

    @Override // com.samsung.android.spen.libinterface.SettingsSystemInterface
    public int getIntForUser(ContentResolver contentResolver, String str, int i, int i2) throws ClassNotFoundException {
        Class<?> cls = Class.forName("android.provider.Settings$System");
        Class cls2 = Integer.TYPE;
        return ((Integer) cls.getMethod("getIntForUser", ContentResolver.class, String.class, cls2, cls2).invoke(null, contentResolver, str, 0, Integer.valueOf(i2))).intValue();
    }
}
