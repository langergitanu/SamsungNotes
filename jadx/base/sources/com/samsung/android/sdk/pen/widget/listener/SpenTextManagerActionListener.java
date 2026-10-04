package com.samsung.android.sdk.pen.widget.listener;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenSpellCorrectionSpan;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J4\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016JD\u0010\u0012\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J4\u0010\u0017\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00142\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0012\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/listener/SpenTextManagerActionListener;", "", "<init>", "()V", "onItemClicked", "", "objectShape", "Lcom/samsung/android/sdk/pen/document/SpenObjectShape;", "type", "", "paragraphIndex", "onHyperTextClicked", "hypertext", "", "hypertextType", "datetimeType", "span", "Lcom/samsung/android/sdk/pen/document/textspan/SpenHyperTextSpan;", "onHyperTextClickedWithRectAndPoint", "rect", "Landroid/graphics/RectF;", "touchPoint", "Landroid/graphics/PointF;", "onSpellCorrectionTextClicked", "Lcom/samsung/android/sdk/pen/document/textspan/SpenSpellCorrectionSpan;", "rectList", "", "onMaxSelectionTextLengthReached", "onHashTagAdded", "text", "onSelectionAreaLongPressed", "onCommitContent", "inputContentInfo", "Landroidx/core/view/inputmethod/InputContentInfoCompat;", "onBeforeTextChangedByKeyBoard", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenTextManagerActionListener {
    public static final int TYPE_BULLET = 2;
    public static final int TYPE_TEXT_OVER_QUE = 1;

    public void onHyperTextClicked(@NotNull String hypertext, int hypertextType, int datetimeType, @Nullable SpenObjectShape objectShape, @Nullable SpenHyperTextSpan span) {
        Intrinsics.checkNotNullParameter(hypertext, "hypertext");
    }

    public void onHyperTextClickedWithRectAndPoint(@NotNull String hypertext, int hypertextType, int datetimeType, @Nullable SpenObjectShape objectShape, @Nullable SpenHyperTextSpan span, @NotNull RectF rect, @NotNull PointF touchPoint) {
        Intrinsics.checkNotNullParameter(hypertext, "hypertext");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(touchPoint, "touchPoint");
    }

    public void onSpellCorrectionTextClicked(@Nullable SpenObjectShape objectShape, @Nullable SpenSpellCorrectionSpan span, @NotNull RectF rect, @Nullable List<RectF> rectList) {
        Intrinsics.checkNotNullParameter(rect, "rect");
    }

    public void onBeforeTextChangedByKeyBoard() {
    }

    public void onMaxSelectionTextLengthReached() {
    }

    public void onSelectionAreaLongPressed() {
    }

    public void onCommitContent(@Nullable InputContentInfoCompat inputContentInfo) {
    }

    public void onHashTagAdded(@Nullable String text) {
    }

    public void onItemClicked(@Nullable SpenObjectShape objectShape, int type, int paragraphIndex) {
    }
}
