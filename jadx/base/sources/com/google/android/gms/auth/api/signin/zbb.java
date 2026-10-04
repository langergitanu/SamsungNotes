package com.google.android.gms.auth.api.signin;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zbb implements PendingResultUtil.ResultConverter {
    private zbb() {
    }

    @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
    @Nullable
    public final /* synthetic */ Object convert(Result result) {
        return ((GoogleSignInResult) result).getSignInAccount();
    }

    public /* synthetic */ zbb(zba zbaVar) {
    }
}
