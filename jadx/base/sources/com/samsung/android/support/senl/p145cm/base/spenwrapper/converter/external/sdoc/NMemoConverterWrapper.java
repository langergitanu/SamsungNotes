package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc;

import android.content.Context;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.memoconverter.NMemoConverter;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.INMemoConverter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdoc/NMemoConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/INMemoConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/INMemoConverter;", "mContext", "Landroid/content/Context;", "dbFileName", "", "attachedFileName", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mConverter", "Lcom/samsung/android/support/senl/document/memoconverter/NMemoConverter;", "makeParams", "path", "password", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "release", "", "memoMetaData", "", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "getMemoMetaData", "()Ljava/util/List;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NMemoConverterWrapper extends AbsConverterWrapper<INMemoConverter.ConverterParams> implements INMemoConverter {

    @NotNull
    private static final String TAG = "NMemoConverterWrapper";

    @NotNull
    private final Context mContext;

    @Nullable
    private NMemoConverter mConverter;

    public NMemoConverterWrapper(@NotNull Context mContext, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        this.mConverter = DocumentConstructor.makeNMemoConverter(mContext, str, str2);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.INMemoConverter
    @Nullable
    public List<MemoMetaDataItem> getMemoMetaData() {
        NMemoConverter nMemoConverter = this.mConverter;
        if (nMemoConverter != null) {
            return nMemoConverter.getMemoMetaData();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public void release() {
        this.mConverter = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ConverterResult convert(@NotNull INMemoConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "convert filePath " + companion.getEncode(params.getFilePath()));
        try {
            return new ConverterResult(NMemoConverter.convertToSDocFile(this.mContext, params.getFilePath()));
        } catch (Exception e) {
            AbstractC0000a.m23t("failed converting ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public INMemoConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        return new INMemoConverter.ConverterParams().setFilePath(path);
    }
}
