package com.google.android.play.core.internal;

import com.google.android.play.core.tasks.C5345i;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ai */
/* JADX INFO: loaded from: classes5.dex */
final class C5160ai extends AbstractRunnableC5158ag {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ AbstractRunnableC5158ag f2936a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5167ap f2937b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5160ai(C5167ap c5167ap, C5345i c5345i, AbstractRunnableC5158ag abstractRunnableC5158ag) {
        super(c5345i);
        this.f2937b = c5167ap;
        this.f2936a = abstractRunnableC5158ag;
    }

    @Override // com.google.android.play.core.internal.AbstractRunnableC5158ag
    /* JADX INFO: renamed from: a */
    public final void mo3595a() {
        C5167ap.m3884a(this.f2937b, this.f2936a);
    }
}
