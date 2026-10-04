package com.sun.imageio.plugins.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class I18N extends I18NImpl {
    private static final String resource_name = "iio-plugin.properties";

    public static String getString(String str) {
        return I18NImpl.getString("com.sun.imageio.plugins.common.I18N", resource_name, str);
    }
}
