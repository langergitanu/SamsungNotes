package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnSuccessListener;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.g */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class C5124g implements OnSuccessListener {

    /* JADX INFO: renamed from: a */
    private final C5045bb f2876a;

    private C5124g(C5045bb c5045bb) {
        this.f2876a = c5045bb;
    }

    /* JADX INFO: renamed from: a */
    public static OnSuccessListener m3835a(C5045bb c5045bb) {
        return new C5124g(c5045bb);
    }

    @Override // com.google.android.play.core.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.f2876a.m3697a((List<String>) obj);
    }
}
