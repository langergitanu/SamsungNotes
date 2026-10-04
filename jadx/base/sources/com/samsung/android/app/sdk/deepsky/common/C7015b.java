package com.samsung.android.app.sdk.deepsky.common;

import android.app.appsearch.AppSearchBatchResult;
import android.app.appsearch.BatchResultCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.common.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7015b implements BatchResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4723a;

    public /* synthetic */ C7015b(int i) {
        this.f4723a = i;
    }

    public final void onResult(AppSearchBatchResult appSearchBatchResult) {
        switch (this.f4723a) {
            case 0:
                Intrinsics.checkNotNullParameter(appSearchBatchResult, "it");
                break;
            case 1:
                Intrinsics.checkNotNullParameter(appSearchBatchResult, "it");
                break;
            default:
                Intrinsics.checkNotNullParameter(appSearchBatchResult, "it");
                break;
        }
    }
}
