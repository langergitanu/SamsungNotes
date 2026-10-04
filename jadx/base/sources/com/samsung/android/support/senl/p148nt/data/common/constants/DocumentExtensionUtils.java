package com.samsung.android.support.senl.p148nt.data.common.constants;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentExtensionUtils {
    @DocumentExtension
    public static String getExtension(@NonNull String str) {
        return str.toLowerCase().endsWith(".sdoc") ? ".sdoc" : ".sdocx";
    }

    public static boolean isSdoc(String str) {
        return str != null && str.toLowerCase().endsWith(".sdoc");
    }

    public static boolean isSdocx(String str) {
        return str != null && str.toLowerCase().endsWith(".sdocx");
    }
}
