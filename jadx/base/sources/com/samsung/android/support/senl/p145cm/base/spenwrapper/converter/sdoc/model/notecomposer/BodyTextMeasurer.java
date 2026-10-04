package com.samsung.android.support.senl.p145cm.base.spenwrapper.converter.sdoc.model.notecomposer;

import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/spenwrapper/converter/sdoc/model/notecomposer/BodyTextMeasurer;", "", "mBodyTextContext", "Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;", "wNote", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "<init>", "(Lcom/samsung/android/sdk/composer/text/SpenBodyTextContext;Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;)V", "measureHeight", "", "getNeedNewLineCount", "targetHeight", "", "release", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BodyTextMeasurer {

    @Nullable
    private SpenBodyTextContext mBodyTextContext;

    public BodyTextMeasurer(@Nullable SpenBodyTextContext spenBodyTextContext, @NotNull SpenWNote wNote) {
        Intrinsics.checkNotNullParameter(wNote, "wNote");
        this.mBodyTextContext = spenBodyTextContext;
        if (spenBodyTextContext != null) {
            spenBodyTextContext.setDocument(wNote);
        }
        wNote.getBodyText().setText("");
    }

    public final int getNeedNewLineCount(float targetHeight) {
        SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
        if (spenBodyTextContext != null) {
            if (spenBodyTextContext != null) {
                spenBodyTextContext.measureText();
            }
            SpenBodyTextContext spenBodyTextContext2 = this.mBodyTextContext;
            if (spenBodyTextContext2 != null) {
                return spenBodyTextContext2.getLineCountFromTextBottom(targetHeight, true);
            }
        }
        return 0;
    }

    public final int measureHeight() {
        SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
        if (spenBodyTextContext != null) {
            if (spenBodyTextContext != null) {
                spenBodyTextContext.measureText();
            }
            SpenBodyTextContext spenBodyTextContext2 = this.mBodyTextContext;
            if (spenBodyTextContext2 != null) {
                return spenBodyTextContext2.getMeasuredHeight();
            }
        }
        return 0;
    }

    public final void release() {
        SpenBodyTextContext spenBodyTextContext = this.mBodyTextContext;
        if (spenBodyTextContext != null) {
            spenBodyTextContext.close();
        }
        this.mBodyTextContext = null;
    }
}
