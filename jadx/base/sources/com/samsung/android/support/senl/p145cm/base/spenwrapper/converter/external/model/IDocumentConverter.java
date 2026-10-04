package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model;

import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.IConvertStatus;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J#\u0010\b\u001a\u0004\u0018\u00018\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H&R\u0012\u0010\u0011\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IDocumentConverter;", "T", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/IConvertStatus;", "getStatus", "", "path", "", "makeParams", "password", "(Ljava/lang/String;Ljava/lang/String;)Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;)Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", "release", "", "resultType", "getResultType", "()I", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IDocumentConverter<T extends ISDocConvertParams> extends IConvertStatus {
    @Nullable
    ConverterResult convert(@NotNull T params);

    int getResultType();

    int getStatus(@Nullable String path);

    @Nullable
    T makeParams(@Nullable String path, @Nullable String password);

    void release();
}
