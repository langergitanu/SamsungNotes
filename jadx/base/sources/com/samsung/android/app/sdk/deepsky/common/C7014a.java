package com.samsung.android.app.sdk.deepsky.common;

import android.app.appsearch.AppSearchResult;
import android.app.appsearch.AppSearchSession;
import android.app.appsearch.PutDocumentsRequest;
import android.app.appsearch.SearchSpec;
import android.app.appsearch.SetSchemaRequest;
import java.util.concurrent.ExecutorService;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.common.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7014a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4719a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ExecutorService f4720b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4721c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4722d;

    public /* synthetic */ C7014a(AppSearchImpl appSearchImpl, AppSearchSession appSearchSession, ExecutorService executorService) {
        this.f4719a = 2;
        this.f4721c = appSearchImpl;
        this.f4722d = appSearchSession;
        this.f4720b = executorService;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4719a) {
            case 0:
                AppSearchImpl.putDocument$lambda$3((SetSchemaRequest) this.f4721c, this.f4720b, (PutDocumentsRequest) this.f4722d, (AppSearchResult) obj);
                break;
            case 1:
                AppSearchImpl.removeOldDocument$lambda$9((SearchSpec) this.f4721c, this.f4720b, (AppSearchImpl) this.f4722d, (AppSearchResult) obj);
                break;
            default:
                AppSearchImpl.removeOldDocument$lambda$9$lambda$8$lambda$7((AppSearchImpl) this.f4721c, (AppSearchSession) this.f4722d, this.f4720b, (AppSearchResult) obj);
                break;
        }
    }

    public /* synthetic */ C7014a(Object obj, ExecutorService executorService, Object obj2, int i) {
        this.f4719a = i;
        this.f4721c = obj;
        this.f4720b = executorService;
        this.f4722d = obj2;
    }
}
