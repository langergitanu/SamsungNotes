package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.exception.InsufficientStorageException;
import com.samsung.android.support.senl.document.memoconverter.LMemoConverter;
import com.samsung.android.support.senl.document.memoconverter.ProgressListener;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.DocumentConstructor;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ILMemoConverter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import p001A.AbstractC0000a;
import p023E2.C0083a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0017J\b\u0010\u0016\u001a\u00020\u0012H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdoc/LMemoConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ILMemoConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ILMemoConverter;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mConverter", "Lcom/samsung/android/support/senl/document/memoconverter/LMemoConverter;", "makeParams", "path", "", "password", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "convertToSdoc", "", "filePath", "progressListener", "Lcom/samsung/android/support/senl/document/memoconverter/ProgressListener;", "release", "getMemoCount", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class LMemoConverterWrapper extends AbsConverterWrapper<ILMemoConverter.ConverterParams> implements ILMemoConverter {

    @NotNull
    private static final String TAG = "LMemoConverterWrapper";

    @Nullable
    private LMemoConverter mConverter;

    public LMemoConverterWrapper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mConverter = DocumentConstructor.makeLMemoConverter(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(List list, int i, int i2, ArrayList arrayList) {
        LoggerBase.INSTANCE.m7132d(TAG, AbstractC1038a.m1214o(i, i2, "convert doneCnt/totalCnt ", "/"));
        if (i == i2) {
            Intrinsics.checkNotNull(arrayList);
            list.addAll(arrayList);
        }
    }

    @VisibleForTesting
    public void convertToSdoc(@Nullable String filePath, @Nullable ProgressListener progressListener) {
        LMemoConverter lMemoConverter = this.mConverter;
        if (lMemoConverter != null) {
            lMemoConverter.convertToSDoc(filePath, progressListener);
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ILMemoConverter
    public int getMemoCount(@Nullable String filePath) {
        return LMemoConverter.getMemoCount(filePath);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    public void release() {
        this.mConverter = null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ConverterResult convert(@NotNull ILMemoConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7132d(TAG, "convert filePath " + companion.getEncode(params.getFilePath()));
        ArrayList arrayList = new ArrayList();
        try {
            convertToSdoc(params.getFilePath(), new C0083a(arrayList, 0));
            if (!arrayList.isEmpty()) {
                return new ConverterResult(null, arrayList);
            }
        } catch (InsufficientStorageException e) {
            AbstractC0000a.m23t("failed converting ", e.getMessage(), LoggerBase.INSTANCE, TAG);
        } catch (IOException e2) {
            AbstractC0000a.m23t("failed converting ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
        } catch (JSONException e3) {
            AbstractC0000a.m23t("failed converting ", e3.getMessage(), LoggerBase.INSTANCE, TAG);
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ILMemoConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        return new ILMemoConverter.ConverterParams().setFilePath(path);
    }
}
