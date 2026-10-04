package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandleWebCard {
    public CharSequence handleWeb(SpenObjectWeb spenObjectWeb, StringBuilder sb, CharSequence charSequence) {
        String strHandleWeb = handleWeb(spenObjectWeb);
        sb.append(strHandleWeb);
        return charSequence != null ? TextUtils.concat(charSequence, strHandleWeb) : charSequence;
    }

    public String handleWeb(SpenObjectWeb spenObjectWeb) {
        return spenObjectWeb.getUri() + '\n';
    }
}
