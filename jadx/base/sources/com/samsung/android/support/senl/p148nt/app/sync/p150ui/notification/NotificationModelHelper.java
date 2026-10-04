package com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification;

import android.content.Context;
import com.samsung.android.app.notes.sync.infos.ModelType;
import p096Y.InterfaceC0343b;
import p260z0.AbstractC14519b;
import p260z0.C14518a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotificationModelHelper implements InterfaceC0343b {
    @Override // p096Y.InterfaceC0343b
    public void remove(Context context, ModelType modelType, int i) {
        IModelNotification iModelNotificationCreate = NotificationModelFactory.create(modelType);
        if (iModelNotificationCreate != null) {
            iModelNotificationCreate.remove(context, i);
        }
    }

    public void showError(Context context, C14518a c14518a) {
        IModelNotification iModelNotificationCreate = NotificationModelFactory.create(c14518a.f10349a);
        if (iModelNotificationCreate != null) {
            iModelNotificationCreate.showError(context, c14518a);
        }
    }

    public void showInfo(Context context, AbstractC14519b abstractC14519b) {
        IModelNotification iModelNotificationCreate = NotificationModelFactory.create(abstractC14519b.f10349a);
        if (iModelNotificationCreate != null) {
            iModelNotificationCreate.showInfo(context, abstractC14519b);
        }
    }
}
