package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\u0006\u001a\u0004\u0018\u00018\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0014\u0010\r\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "T", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "<init>", "()V", "makeParams", "path", "", "password", "(Ljava/lang/String;Ljava/lang/String;)Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;", "getStatus", "", "resultType", "getResultType", "()I", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsConverterWrapper<T extends ISDocConvertParams> implements IDocumentConverter<T> {
    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getResultType() {
        return 8;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getStatus(@Nullable String path) {
        return 0;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public abstract T makeParams(@Nullable String path, @Nullable String password);
}
