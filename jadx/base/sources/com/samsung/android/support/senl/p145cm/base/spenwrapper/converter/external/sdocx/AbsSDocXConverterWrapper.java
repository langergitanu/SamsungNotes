package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx;

import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsConverterWrapper;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.AbsPathConvertParams;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ConverterResult;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/AbsSDocXConverterWrapper;", "T", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsConverterWrapper;", "<init>", "()V", "mSrcPath", "", "mPassWord", "getMPassWord", "()Ljava/lang/String;", "setMPassWord", "(Ljava/lang/String;)V", MarkdownConverter.PREFIX_NAME, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", ActionHandler.PARAMS, "(Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/AbsPathConvertParams;)Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ConverterResult;", "verifySourcePath", "", "path", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsSDocXConverterWrapper<T extends AbsPathConvertParams<?>> extends AbsConverterWrapper<T> {

    @Nullable
    private String mPassWord;

    @Nullable
    private String mSrcPath;

    @Nullable
    public final String getMPassWord() {
        return this.mPassWord;
    }

    public final void setMPassWord(@Nullable String str) {
        this.mPassWord = str;
    }

    public final boolean verifySourcePath(@Nullable String path) {
        String str = this.mSrcPath;
        return str != null && Intrinsics.areEqual(str, path);
    }

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.IDocumentConverter
    @Nullable
    public ConverterResult convert(@NotNull T params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.mSrcPath = params.getFilePath();
        this.mPassWord = params.getPassword();
        return new ConverterResult(this.mSrcPath);
    }
}
