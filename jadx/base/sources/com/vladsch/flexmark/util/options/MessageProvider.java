package com.vladsch.flexmark.util.options;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import java.text.MessageFormat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public interface MessageProvider {
    public static final MessageProvider DEFAULT = new C8416h(19);

    /* JADX INFO: Access modifiers changed from: private */
    static /* synthetic */ String lambda$static$0(String str, String str2, Object[] objArr) {
        return (objArr.length <= 0 || str2.indexOf(123) < 0) ? str2 : MessageFormat.format(str2, objArr);
    }

    String message(String str, String str2, Object... objArr);
}
