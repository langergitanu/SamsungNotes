package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0017\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\r\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000eR\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;", "T", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConvertParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocPathConvertParams;", "clazz", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "value", "", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)Ljava/lang/Object;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsPathConvertParams<T> extends AbsConvertParams<T> implements ISDocPathConvertParams {

    @Nullable
    private String filePath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsPathConvertParams(@NotNull Class<T> clazz) {
        super(clazz);
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocPathConvertParams
    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final T setFilePath(@Nullable String filePath) {
        this.filePath = filePath;
        return getMBuilderClass().cast(this);
    }
}
