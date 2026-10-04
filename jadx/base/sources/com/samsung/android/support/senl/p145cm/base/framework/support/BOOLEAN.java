package com.samsung.android.support.senl.p145cm.base.framework.support;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\u000b¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/BOOLEAN;", "", "value", "", "<init>", "(Z)V", "setValue", "", "b", "booleanValue", "isTrue", "()Z", "isFalse", "compareTo", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BOOLEAN {
    private boolean value;

    public BOOLEAN(boolean z) {
        this.value = z;
    }

    /* JADX INFO: renamed from: booleanValue, reason: from getter */
    public final boolean getValue() {
        return this.value;
    }

    public final boolean compareTo(@NotNull BOOLEAN b) {
        Intrinsics.checkNotNullParameter(b, "b");
        return this.value == b.getValue();
    }

    public final boolean isFalse() {
        return !this.value;
    }

    public final boolean isTrue() {
        return this.value;
    }

    public final void setValue(boolean b) {
        this.value = b;
    }
}
