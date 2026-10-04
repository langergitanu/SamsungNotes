package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.exception.InsufficientStorageException;
import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.document.memoconverter.TMemo1Converter;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ITMemoConverter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p023E2.C0083a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001cB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0013H\u0016J\"\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdoc/TMemoConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ITMemoConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ITMemoConverter;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "makeParams", "path", "", "password", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "convertToSdoc", "", "filePath", "progressListener", "Lcom/samsung/android/support/senl/document/memoconverter/ProgressListener;", "release", "getMetaData", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "Lkotlin/collections/ArrayList;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class TMemoConverterWrapper extends AbsConverterWrapper<ITMemoConverter.ConverterParams> implements ITMemoConverter {

    @NotNull
    private static final String TAG = "TMemoConverterWrapper";

    @Nullable
    private Context mContext;

    public TMemoConverterWrapper(@Nullable Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(List list, int i, int i2, ArrayList arrayList) {
        LoggerBase.INSTANCE.m7132d(TAG, AbstractC1038a.m1214o(i, i2, "convert current/total ", "/"));
        if (i == i2) {
            Intrinsics.checkNotNull(arrayList);
            list.addAll(arrayList);
        }
    }

    @VisibleForTesting
    public void convertToSdoc(@Nullable String filePath, @Nullable ProgressListener progressListener) {
        TMemo1Converter.convertToSDoc(this.mContext, filePath, progressListener);
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ITMemoConverter
    @NotNull
    public ArrayList<MemoMetaDataItem> getMetaData(@Nullable String filePath) {
        try {
            ArrayList<MemoMetaDataItem> memoMetaDataArray = TMemo1Converter.getMemoMetaDataArray(this.mContext, filePath);
            Intrinsics.checkNotNullExpressionValue(memoMetaDataArray, "getMemoMetaDataArray(...)");
            return memoMetaDataArray;
        } catch (IOException e) {
            LoggerBase.INSTANCE.m7133e("TMemoConverterWrapper, failed to get meta data", e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public void release() {
        this.mContext = null;
    }

    public final void setMContext(@Nullable Context context) {
        this.mContext = context;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ConverterResult convert(@NotNull ITMemoConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "convert filePath " + companion.getEncode(params.getFilePath()));
        ArrayList arrayList = new ArrayList();
        try {
            convertToSdoc(params.getFilePath(), new C0083a(arrayList, 1));
            if (!arrayList.isEmpty()) {
                return new ConverterResult(null, arrayList);
            }
        } catch (InsufficientStorageException e) {
            AbstractC0000a.m23t("failed converting ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        } catch (IOException e2) {
            AbstractC0000a.m23t("failed converting ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ITMemoConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        return new ITMemoConverter.ConverterParams().setFilePath(path);
    }
}
