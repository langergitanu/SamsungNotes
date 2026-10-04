package com.microsoft.identity.common.internal.p131ui.webview.certbasedauth;

import android.app.Activity;
import android.app.Dialog;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public abstract class SmartcardDialog {
    protected final Activity mActivity;
    protected Dialog mDialog = null;

    public SmartcardDialog(@NonNull Activity activity) {
        this.mActivity = activity;
    }

    public abstract void createDialog();

    public void dismiss() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog.2
            @Override // java.lang.Runnable
            public void run() {
                SmartcardDialog.this.mDialog.dismiss();
            }
        });
    }

    public abstract void onUnexpectedUnplug();

    public void show() {
        this.mActivity.runOnUiThread(new Runnable() { // from class: com.microsoft.identity.common.internal.ui.webview.certbasedauth.SmartcardDialog.1
            @Override // java.lang.Runnable
            public void run() {
                SmartcardDialog.this.mDialog.show();
            }
        });
    }
}
