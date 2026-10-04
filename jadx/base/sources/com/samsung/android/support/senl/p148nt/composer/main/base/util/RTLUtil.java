package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RTLUtil {
    public static String supportRTL(String str) {
        return LocaleUtils.isRTLMode() ? AbstractC0541b.m772n(UnicodeUtils.RLM, str) : str;
    }
}
