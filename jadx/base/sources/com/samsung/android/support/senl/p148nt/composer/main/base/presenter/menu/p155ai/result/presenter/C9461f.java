package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.chunking.Chunk;
import java.util.function.Function;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9461f implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6879a;

    public /* synthetic */ C9461f(int i) {
        this.f6879a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f6879a) {
            case 0:
                return ((SpenWNote) obj).getBodyText();
            case 1:
                return Integer.valueOf(((SpenObjectSpan) obj).getTextIndex());
            case 2:
                return SpellingCorrection.lambda$makeResult$0((SpenObjectSpan) obj);
            default:
                return ((Chunk) obj).getText();
        }
    }
}
