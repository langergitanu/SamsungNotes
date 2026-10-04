package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx;

import android.content.Context;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.memoconverter.core.ConverterUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Constants;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IWrappingConverter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016J$\u0010\u0006\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/WrappingConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IWrappingConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/common/ISDocXConverter;", "<init>", "()V", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "", "context", "Landroid/content/Context;", "inFile", "", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "cancel", "release", "makeParams", "path", "password", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class WrappingConverter extends AbsConverterWrapper<IWrappingConverter.ConverterParams> implements ISDocXConverter {
    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void cancel() {
        LoggerBase.INSTANCE.m7137i("SENL$WrappingConverter", "requested cancel!");
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @NotNull
    public ConverterResult convert(@NotNull IWrappingConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return new ConverterResult(params.getFilePath());
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public IWrappingConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        IWrappingConverter.ConverterParams filePath = new IWrappingConverter.ConverterParams().setFilePath(path);
        if (filePath != null) {
            return filePath.setPassword(password);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.common.ISDocXConverter
    public void convert(@Nullable Context context, @Nullable String inFile, @NotNull SpenWNote wNote) {
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        wNote.getTitle().setText(ConverterUtils.getTitle(inFile));
        wNote.attachFile(Constants.SNote.WNOTE_LOCKED_FILE_KEY, inFile);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public void release() {
    }
}
