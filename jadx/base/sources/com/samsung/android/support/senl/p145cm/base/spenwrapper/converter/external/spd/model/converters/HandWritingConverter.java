package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/HandWritingConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/AbsObjectConverter;", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "<init>", "()V", "convertObject", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/external/spd/model/converters/IConvertParams;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HandWritingConverter extends AbsObjectConverter<SpenObjectBase> {

    @NotNull
    private static final String TAG = "SPDToSDocXConverter$HandWritingConverter";

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.external.spd.model.converters.AbsObjectConverter
    public boolean convertObject(@NotNull SpenObjectBase src, @Nullable IConvertParams params) {
        INoteComposer noteComposer;
        Intrinsics.checkNotNullParameter(src, "src");
        int backgroundColorPage = (params == null || (noteComposer = params.getNoteComposer()) == null) ? 0 : noteComposer.getBackgroundColorPage();
        SpenObjectStroke spenObjectStroke = (SpenObjectStroke) src;
        int color = spenObjectStroke.getColor();
        LoggerBase.INSTANCE.m7137i(TAG, AbstractC1038a.m1214o(backgroundColorPage, color, "convert object ", " - "));
        spenObjectStroke.setColor((backgroundColorPage & 16777215) | (color & (-16777216)));
        return true;
    }
}
