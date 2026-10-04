package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.content.Intent;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class EdpNotificationHelper {
    private static final String TAG = "EdpNotificationHelper";
    private final EdpNotification mEdpNotification = new EdpNotification();

    public void cancelAllEdpNotification() {
        this.mEdpNotification.cancelAllEdpNotification();
    }

    public void notifyEdpFtu() {
        this.mEdpNotification.notifyEdpFtu();
    }

    public void notifyEdpKeyError() {
        this.mEdpNotification.notifyEdpKeyError();
    }

    public void notifyEdpNotSupportedRemmendedAppUpdate() {
        this.mEdpNotification.notifyEdpNotSupportedRemmendedAppUpdate();
    }

    public void setAction(Intent intent) {
        this.mEdpNotification.setAction(intent);
    }
}
