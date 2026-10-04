package com.samsung.android.support.senl.p148nt.base.composer.clipboard;

import android.text.Spanned;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class HtmlUtils {
    private static String convertTagPToBr(String str) {
        if (str.length() <= 0) {
            return str;
        }
        if (AbstractC0000a.m4a(1, str) == '\n') {
            str = AbstractC2322a.m1614d(1, 0, str);
        }
        return str.replaceFirst("<p dir=ltr>", "").replaceFirst("<p dir=\"ltr\">", "").replaceAll("<p dir=ltr>", "<br><br>").replaceAll("<p dir=\"ltr\">", "<br><br>").replaceAll("</p>", "");
    }

    public static String toHtml(Spanned spanned) {
        return convertTagPToBr(CharUtils.toHtml(spanned));
    }
}
