package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u000f\u001a\u0004\u0018\u00018\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0010R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConvertParams;", "T", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;", "mBuilderClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getMBuilderClass", "()Ljava/lang/Class;", "setMBuilderClass", "value", "", "password", "getPassword", "()Ljava/lang/String;", "setPassword", "(Ljava/lang/String;)Ljava/lang/Object;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsConvertParams<T> implements ISDocConvertParams {

    @NotNull
    private Class<T> mBuilderClass;

    @Nullable
    private String password;

    public AbsConvertParams(@NotNull Class<T> mBuilderClass) {
        Intrinsics.checkNotNullParameter(mBuilderClass, "mBuilderClass");
        this.mBuilderClass = mBuilderClass;
    }

    @NotNull
    public final Class<T> getMBuilderClass() {
        return this.mBuilderClass;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams
    @Nullable
    public final String getPassword() {
        return this.password;
    }

    public final void setMBuilderClass(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.mBuilderClass = cls;
    }

    @Nullable
    public final T setPassword(@Nullable String password) {
        this.password = password;
        return this.mBuilderClass.cast(this);
    }
}
