package com.samsung.android.sdk.pdf.debug;

import android.graphics.RectF;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pdf/debug/SpenPdfInferenceResult;", "", "<init>", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "rect", "Landroid/graphics/RectF;", "getRect", "()Landroid/graphics/RectF;", "setRect", "(Landroid/graphics/RectF;)V", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPdfInferenceResult {
    private int index;

    @Nullable
    private RectF rect;

    public final int getIndex() {
        return this.index;
    }

    @Nullable
    public final RectF getRect() {
        return this.rect;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final void setRect(@Nullable RectF rectF) {
        this.rect = rectF;
    }
}
