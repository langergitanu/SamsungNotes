package com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncToast implements IModelToast {
    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast.IModelToast
    public void showError(final Context context, C14518a c14518a) {
        final String string = c14518a.f10350b != 101 ? "Unknown error code!" : context.getResources().getString(C8003R.string.settings_cannot_sync_in_wifi_only);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.toast.SyncToast.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, string, 1).show();
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.app.sync.p150ui.toast.IModelToast
    public void showInfo(final Context context, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.ui.toast.SyncToast.2
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, str, 0).show();
            }
        });
    }
}
