package org.apache.commons.lang3.text;

import java.util.function.Supplier;

/* JADX INFO: renamed from: org.apache.commons.lang3.text.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13904a implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9935a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ StrBuilder f9936b;

    public /* synthetic */ C13904a(StrBuilder strBuilder, int i) {
        this.f9935a = i;
        this.f9936b = strBuilder;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f9935a) {
            case 0:
                return this.f9936b.lambda$minimizeCapacity$1();
            default:
                return this.f9936b.getNullText();
        }
    }
}
