package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc;

import android.content.Context;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.memoconverter.ScrapBookConverter;
import com.samsung.android.support.senl.p145cm.base.common.util.BaseImageUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IScrapbookConverter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdoc/ScrapbookConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IScrapbookConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IScrapbookConverter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mConverter", "Lcom/samsung/android/support/senl/document/memoconverter/ScrapBookConverter;", "getStatus", "", "path", "", "makeParams", "password", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "release", "", "getMetaData", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ScrapbookConverterWrapper extends AbsConverterWrapper<IScrapbookConverter.ConverterParams> implements IScrapbookConverter {

    @NotNull
    private static final String TAG = "ScrapbookConverterWrapper";

    @Nullable
    private ScrapBookConverter mConverter;

    public ScrapbookConverterWrapper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mConverter = DocumentConstructor.makeScrapBookConverter(context, BaseImageUtils.getMaxTextureSize());
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IScrapbookConverter
    @Nullable
    public MemoMetaDataItem getMetaData(@NotNull IScrapbookConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ScrapBookConverter scrapBookConverter = this.mConverter;
        if (scrapBookConverter != null) {
            return scrapBookConverter.getMetaData(params.getJSONObject(), params.getFilePath(), params.getCategoryId());
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public int getStatus(@Nullable String path) {
        ScrapBookConverter scrapBookConverter = this.mConverter;
        if ((scrapBookConverter != null ? scrapBookConverter.getMemoCount(path) : 0) > 1) {
            return 4;
        }
        return super.getStatus(path);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public void release() {
        this.mConverter = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ConverterResult convert(@NotNull IScrapbookConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "convert filePath " + companion.getEncode(params.getFilePath()));
        try {
            ScrapBookConverter scrapBookConverter = this.mConverter;
            return new ConverterResult(scrapBookConverter != null ? scrapBookConverter.convertToSDocFile(params.getFilePath()) : null, null);
        } catch (Exception e) {
            AbstractC0000a.m23t("failed converting ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public IScrapbookConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        return new IScrapbookConverter.ConverterParams().setFilePath(path);
    }
}
