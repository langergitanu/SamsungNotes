package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdoc;

import android.content.Context;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.document.data.MemoMetaDataItem;
import com.samsung.android.support.senl.document.exception.InsufficientStorageException;
import com.samsung.android.support.senl.document.memoconverter.JSONConverter;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IJsonConverter;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0016B\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdoc/JsonConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IJsonConverter$ConverterParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/IJsonConverter;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getMContext", "()Landroid/content/Context;", "setMContext", "makeParams", "path", "", "password", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "release", "", "getMemoMetaData", "Lcom/samsung/android/support/senl/document/data/MemoMetaDataItem;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class JsonConverterWrapper extends AbsConverterWrapper<IJsonConverter.ConverterParams> implements IJsonConverter {

    @NotNull
    private static final String TAG = "JsonConverterWrapper";

    @Nullable
    private Context mContext;

    public JsonConverterWrapper(@Nullable Context context) {
        this.mContext = context;
    }

    @Nullable
    public final Context getMContext() {
        return this.mContext;
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IJsonConverter
    @Nullable
    public MemoMetaDataItem getMemoMetaData(@Nullable IJsonConverter.ConverterParams params) {
        String dirPath;
        if (params != null) {
            try {
                dirPath = params.getDirPath();
            } catch (IOException e) {
                AbstractC0000a.m23t("failed converting ", e.getMessage(), LoggerBase.INSTANCE, TAG);
                return null;
            } catch (JSONException e2) {
                AbstractC0000a.m23t("failed converting ", e2.getMessage(), LoggerBase.INSTANCE, TAG);
                return null;
            }
        } else {
            dirPath = null;
        }
        return JSONConverter.getMemoMetaData(dirPath, params != null ? params.getExtDirPath() : null, params != null ? params.getCategoryName() : null);
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
    public ConverterResult convert(@NotNull IJsonConverter.ConverterParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONConverter.convertToSDoc(this.mContext, params.getDirPath(), params.getExtDirPath(), params.getCategoryUUID());
            return null;
        } catch (InsufficientStorageException e) {
            LoggerBase.INSTANCE.m7133e("JsonConverterWrapper, failed converting", e.getMessage());
            return null;
        } catch (IOException e2) {
            LoggerBase.INSTANCE.m7133e("JsonConverterWrapper, failed converting", e2.getMessage());
            return null;
        } catch (JSONException e3) {
            LoggerBase.INSTANCE.m7133e("JsonConverterWrapper, failed converting", e3.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper, com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @NotNull
    public IJsonConverter.ConverterParams makeParams(@Nullable String path, @Nullable String password) {
        return new IJsonConverter.ConverterParams();
    }
}
