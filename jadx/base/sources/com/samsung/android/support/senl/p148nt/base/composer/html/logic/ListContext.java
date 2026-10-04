package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListContext;", "", "counter", "", "fixed", "", "<init>", "(IZ)V", "getCounter", "()I", "setCounter", "(I)V", "getFixed", "()Z", "setFixed", "(Z)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
final class ListContext {
    private int counter;
    private boolean fixed;

    /* JADX WARN: Multi-variable type inference failed */
    public ListContext() {
        this(0, 0 == true ? 1 : 0, 3, null);
    }

    public final int getCounter() {
        return this.counter;
    }

    public final boolean getFixed() {
        return this.fixed;
    }

    public final void setCounter(int i) {
        this.counter = i;
    }

    public final void setFixed(boolean z) {
        this.fixed = z;
    }

    public ListContext(int i, boolean z) {
        this.counter = i;
        this.fixed = z;
    }

    public /* synthetic */ ListContext(int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? false : z);
    }
}
