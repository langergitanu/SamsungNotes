package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000f*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u000fB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/AbsObjectConverter;", "T", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "", "<init>", "()V", MarkdownConverter.PREFIX_NAME, "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IConvertParams;", "convertObject", "(Lcom/samsung/android/sdk/pen/document/SpenObjectBase;Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IConvertParams;)Z", "release", "", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsObjectConverter<T extends SpenObjectBase> {

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$AbsObjectConverter";

    public final boolean convert(@NotNull SpenObjectBase src, @Nullable IConvertParams params) {
        Intrinsics.checkNotNullParameter(src, "src");
        try {
            convertObject(src, params);
            return true;
        } catch (Exception e) {
            AbstractC0000a.m23t("conversion type error : ", e.getMessage(), LoggerBase.INSTANCE, TAG);
            return false;
        }
    }

    public abstract boolean convertObject(@NotNull T src, @Nullable IConvertParams params);

    public final void release() {
    }
}
