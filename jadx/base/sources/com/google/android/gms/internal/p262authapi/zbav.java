package com.google.android.gms.internal.p262authapi;

import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zbav extends zbak {
    final /* synthetic */ TaskCompletionSource zba;

    public zbav(zbaw zbawVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p262authapi.zbal
    public final void zbb(Status status, SavePasswordResult savePasswordResult) {
        TaskUtil.setResultOrApiException(status, savePasswordResult, this.zba);
    }
}
