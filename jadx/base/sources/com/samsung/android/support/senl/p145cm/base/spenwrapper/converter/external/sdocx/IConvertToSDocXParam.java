package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.sdocx;

import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.model.ISDocConvertParams;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/sdocx/IConvertToSDocXParam;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/model/ISDocConvertParams;", "dstPath", "", "getDstPath", "()Ljava/lang/String;", "setDstPath", "(Ljava/lang/String;)V", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "getWNote", "()Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "setWNote", "(Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IConvertToSDocXParam extends ISDocConvertParams {
    @Nullable
    String getDstPath();

    @Nullable
    SpenWNote getWNote();

    void setDstPath(@Nullable String str);

    void setWNote(@Nullable SpenWNote spenWNote);
}
