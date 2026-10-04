package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.debug;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class VmlDebug {
    public static String VDEBUG_TAG = "VML";
    public static boolean enabled = false;

    public static boolean isEnabled() {
        return enabled;
    }

    public static final void message(String str) {
        if (enabled) {
            System.out.println("[" + VDEBUG_TAG + "] : " + str);
        }
    }

    public static void setEnabled(boolean z) {
        enabled = z;
    }

    public static final void message(String str, String str2) {
        if (enabled) {
            System.out.println("[" + str + "] : " + str2);
        }
    }
}
