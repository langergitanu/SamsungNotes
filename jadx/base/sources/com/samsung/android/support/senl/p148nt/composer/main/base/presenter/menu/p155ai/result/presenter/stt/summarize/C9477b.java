package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize;

import com.samsung.android.support.senl.p148nt.stt.base.model.AiTextDataTask;
import com.samsung.android.support.senl.p148nt.stt.base.model.TextData;
import java.util.function.IntUnaryOperator;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.stt.summarize.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9477b implements IntUnaryOperator {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6905a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TextData f6906b;

    public /* synthetic */ C9477b(TextData textData, int i) {
        this.f6905a = i;
        this.f6906b = textData;
    }

    @Override // java.util.function.IntUnaryOperator
    public final int applyAsInt(int i) {
        switch (this.f6905a) {
            case 0:
                return ParagraphSttTask.lambda$call$0(this.f6906b, i);
            default:
                return AiTextDataTask.start$lambda$3$lambda$0(this.f6906b, i);
        }
    }
}
