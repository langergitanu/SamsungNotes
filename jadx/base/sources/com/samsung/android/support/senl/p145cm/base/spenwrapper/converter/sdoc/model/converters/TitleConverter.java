package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentText;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/TitleConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentText;", "<init>", "()V", "convertContent", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TitleConverter extends AbsContentConverter<SpenContentText> {

    @NotNull
    private static final String TAG = "SDocXConverter$TitleConverter";

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public boolean convertContent(@Nullable SpenContentText src, @NotNull IConvertParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        String text = src != null ? src.getText() : null;
        if (text == null || text.length() == 0) {
            LoggerBase.INSTANCE.m7137i(TAG, "empty title, skip add Title");
            return false;
        }
        SpenObjectTextBox title = params.getComposer().getNote().getTitle();
        if (title == null) {
            LoggerBase.INSTANCE.m7133e(TAG, "failed to get title.");
            return false;
        }
        title.setText(text);
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "add Title : " + companion.getEncode(text));
        return true;
    }
}
