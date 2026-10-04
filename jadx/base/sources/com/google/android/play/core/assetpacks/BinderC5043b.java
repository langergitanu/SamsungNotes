package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.play.core.internal.AbstractBinderC5238v;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5203by;
import com.google.android.play.core.internal.InterfaceC5241y;
import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.b */
/* JADX INFO: loaded from: classes5.dex */
final class BinderC5043b extends AbstractBinderC5238v {

    /* JADX INFO: renamed from: a */
    private final C5157af f2594a = new C5157af("AssetPackExtractionService");

    /* JADX INFO: renamed from: b */
    private final Context f2595b;

    /* JADX INFO: renamed from: c */
    private final AssetPackExtractionService f2596c;

    /* JADX INFO: renamed from: d */
    private final C5045bb f2597d;

    public BinderC5043b(Context context, AssetPackExtractionService assetPackExtractionService, C5045bb c5045bb) {
        this.f2595b = context;
        this.f2596c = assetPackExtractionService;
        this.f2597d = c5045bb;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5239w
    /* JADX INFO: renamed from: a */
    public final void mo3678a(Bundle bundle, InterfaceC5241y interfaceC5241y) {
        String[] packagesForUid;
        this.f2594a.m3875a("updateServiceState AIDL call", new Object[0]);
        if (C5203by.m3973a(this.f2595b) && (packagesForUid = this.f2595b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) != null && Arrays.asList(packagesForUid).contains("com.android.vending")) {
            interfaceC5241y.mo4029a(this.f2596c.m3619a(bundle), new Bundle());
        } else {
            interfaceC5241y.mo4028a(new Bundle());
            this.f2596c.m3620a();
        }
    }

    @Override // com.google.android.play.core.internal.InterfaceC5239w
    /* JADX INFO: renamed from: a */
    public final void mo3679a(InterfaceC5241y interfaceC5241y) {
        this.f2597d.m3717f();
        interfaceC5241y.mo4030b(new Bundle());
    }
}
