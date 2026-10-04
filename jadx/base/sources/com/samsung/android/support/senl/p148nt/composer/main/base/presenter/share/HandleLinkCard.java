package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.document.SpenObjectLink;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HandleLinkCard {
    public CharSequence handleLink(SpenObjectLink spenObjectLink, StringBuilder sb, CharSequence charSequence) {
        String strHandleLink = handleLink(spenObjectLink);
        sb.append(strHandleLink);
        return charSequence != null ? TextUtils.concat(charSequence, strHandleLink) : charSequence;
    }

    public String handleLink(SpenObjectLink spenObjectLink) {
        String option = spenObjectLink.getOption();
        if (TextUtils.isEmpty(option) || !option.startsWith("http")) {
            option = spenObjectLink.getTitle();
        }
        return option + '\n';
    }
}
