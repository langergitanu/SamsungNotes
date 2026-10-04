package com.samsung.android.app.notes.sync.importing.services;

import android.content.Intent;
import android.content.ServiceConnection;
import com.samsung.android.app.notes.sync.importing.core.ImportLogic;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.services.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6778b implements ImportLogic.ImportHandler.SelfBindContract {
    @Override // com.samsung.android.app.notes.sync.importing.core.ImportLogic.ImportHandler.SelfBindContract
    public final void selfBind(ServiceConnection serviceConnection) {
        BaseUtils.getApplicationContext().bindService(new Intent(BaseUtils.getApplicationContext(), (Class<?>) ImportService.class), serviceConnection, 1);
    }
}
