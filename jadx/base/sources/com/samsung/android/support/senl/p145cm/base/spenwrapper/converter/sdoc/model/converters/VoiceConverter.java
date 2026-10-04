package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters;

import android.graphics.RectF;
import android.text.TextUtils;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentVoice;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.SpenObjectConstructor;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/VoiceConverter;", "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/AbsContentConverter;", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenContentVoice;", "<init>", "()V", "convertContent", "", "src", ActionHandler.PARAMS, "Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/converters/IConvertParams;", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceConverter extends AbsContentConverter<SpenContentVoice> {
    private static final int HEIGHT_DP = 48;

    @NotNull
    private static final String KEY_VOICE_BOOKMARK_IDENTIFIER = "NOTES_APP_BOOKMARK_VOICE_IDENTIFIER";

    @NotNull
    private static final String TAG = "SDocXConverter$VoiceConverter";

    @Override // com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.converters.AbsContentConverter
    public boolean convertContent(@Nullable SpenContentVoice src, @NotNull IConvertParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        LoggerBase.Companion companion = LoggerBase.INSTANCE;
        companion.m7137i(TAG, "convert content");
        String attachedFile = src != null ? src.getAttachedFile() : null;
        if (TextUtils.isEmpty(attachedFile)) {
            companion.m7138w(TAG, "can't add ContentVoice : not file");
            return false;
        }
        INoteComposer composer = params.getComposer();
        float dpi = composer.getDPI() * 48;
        SpenObjectVoice spenObjectVoiceMakeObjectVoice = SpenObjectConstructor.makeObjectVoice();
        spenObjectVoiceMakeObjectVoice.attachFile(attachedFile);
        spenObjectVoiceMakeObjectVoice.setTitle(src != null ? src.getText() : null);
        spenObjectVoiceMakeObjectVoice.setState(src != null ? src.getState() : 0);
        spenObjectVoiceMakeObjectVoice.setPlayTime(src != null ? src.getPlayTime() : null);
        spenObjectVoiceMakeObjectVoice.setRecorded(src != null ? src.isRecorded() : false);
        spenObjectVoiceMakeObjectVoice.setRect(new RectF(0.0f, 0.0f, composer.getObjectMaxWidth(), dpi), true);
        File file = new File(attachedFile);
        if (file.exists()) {
            spenObjectVoiceMakeObjectVoice.setExtraDataString(KEY_VOICE_BOOKMARK_IDENTIFIER, file.getName());
        }
        composer.appendObject(spenObjectVoiceMakeObjectVoice);
        return true;
    }
}
