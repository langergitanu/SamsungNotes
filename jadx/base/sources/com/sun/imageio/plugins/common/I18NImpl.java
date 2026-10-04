package com.sun.imageio.plugins.common;

import java.util.PropertyResourceBundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class I18NImpl {
    public static final String getString(String str, String str2, String str3) {
        try {
            return (String) new PropertyResourceBundle(Class.forName(str).getResourceAsStream(str2)).handleGetObject(str3);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
