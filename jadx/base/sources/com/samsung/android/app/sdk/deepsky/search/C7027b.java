package com.samsung.android.app.sdk.deepsky.search;

import com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator;
import java.util.function.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.search.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7027b implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4734a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function1 f4735b;

    public /* synthetic */ C7027b(Function1 function1, int i) {
        this.f4734a = i;
        this.f4735b = function1;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4734a) {
            case 0:
                GraphqlQueryExecutorImpl.execute$lambda$4(this.f4735b, obj);
                break;
            default:
                VexFwkImageTranslator.showInstallPopupAsync$lambda$15(this.f4735b, obj);
                break;
        }
    }
}
