package com.samsung.android.scloud.lib.setting;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.scloud.lib.setting.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7225g implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4858a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AtomicReference f4859b;

    public /* synthetic */ C7225g(AtomicReference atomicReference, int i) {
        this.f4858a = i;
        this.f4859b = atomicReference;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4858a) {
            case 0:
                SyncSettingProviderClient.lambda$requestSync$0(this.f4859b, (String) obj);
                break;
            default:
                SyncSettingProviderClient.lambda$requestFastSync$1(this.f4859b, (String) obj);
                break;
        }
    }
}
