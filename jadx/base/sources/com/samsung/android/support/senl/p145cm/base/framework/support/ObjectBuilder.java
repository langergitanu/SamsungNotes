package com.samsung.android.support.senl.p145cm.base.framework.support;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\r\u001a\u00028\u0000H$¢\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\u0007\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/support/ObjectBuilder;", "T", "", "<init>", "()V", "mObject", "Ljava/lang/Object;", "instance", "getInstance", "()Ljava/lang/Object;", "isValid", "", "()Z", "build", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class ObjectBuilder<T> {

    @Nullable
    private T mObject;

    public abstract T build();

    public final T getInstance() {
        if (this.mObject == null) {
            this.mObject = build();
        }
        T t = this.mObject;
        Intrinsics.checkNotNull(t);
        return t;
    }

    public final boolean isValid() {
        return this.mObject != null;
    }

    public final void release() {
        this.mObject = null;
    }
}
