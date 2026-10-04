package com.google.android.gms.internal.p262authapi;

import com.google.android.gms.auth.api.identity.BeginSignInResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zbbc extends zbab {
    final /* synthetic */ TaskCompletionSource zba;

    public zbbc(zbbg zbbgVar, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p262authapi.zbac
    public final void zbb(Status status, BeginSignInResult beginSignInResult) {
        TaskUtil.setResultOrApiException(status, beginSignInResult, this.zba);
    }
}
