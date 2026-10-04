package com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import org.jsoup.helper.StringUtil;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ShareToast implements IModelToast {
    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast.IModelToast
    public void showError(final Context context, C14518a c14518a) {
        final String[] strArr = {""};
        int i = c14518a.f10350b;
        if (i == 1) {
            strArr[0] = "Can't upload shared notes. Clear some space in Samsung Cloud, then try again";
        } else if (i != 2 && i != 4 && i != 16 && i != 4096) {
            strArr[0] = "Unknown error code!";
        }
        if (StringUtil.isBlank(strArr[0])) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.toast.ShareToast.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, strArr[0], 1).show();
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast.IModelToast
    public void showInfo(final Context context, final String str) {
        if (StringUtil.isBlank(str)) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.toast.ShareToast.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, str, 0).show();
            }
        });
    }
}
