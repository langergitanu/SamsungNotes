package com.samsung.android.sdk.pen.worddoc;

import android.graphics.RectF;
import androidx.annotation.ColorInt;
import com.samsung.android.sdk.pen.SpenError;
import com.samsung.android.sdk.pen.document.SpenAlreadyClosedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\u0019\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082 J\u0011\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\fH\u0082 J\u0019\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0082 J\u0011\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\fH\u0082 R$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8W@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "Lcom/samsung/android/sdk/pen/worddoc/SpenCustomObject;", "<init>", "()V", "rect", "Landroid/graphics/RectF;", "collapseRect", "getCollapseRect", "()Landroid/graphics/RectF;", "setCollapseRect", "(Landroid/graphics/RectF;)V", "color", "", "backgroundColor", "getBackgroundColor", "()I", "setBackgroundColor", "(I)V", "throwUncheckedException", "", "errno", "equals", "", "o", "", "StickyNote_setCollapseRect", "handle", "StickyNote_getCollapseRect", "StickyNote_setBackgroundColor", "nativeHandle", "StickyNote_getBackgroundColor", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenStickyNote extends SpenCustomObject {
    public static final int TYPE_STICKY_NOTE = 1;

    private final native int StickyNote_getBackgroundColor(int handle);

    private final native RectF StickyNote_getCollapseRect(int handle);

    private final native boolean StickyNote_setBackgroundColor(int nativeHandle, int color);

    private final native boolean StickyNote_setCollapseRect(int handle, RectF rect);

    private final void throwUncheckedException(int errno) {
        if (errno != 19) {
            SpenError.ThrowUncheckedException(errno);
            return;
        }
        throw new SpenAlreadyClosedException("SpenStickyNote(" + this + ") is already closed");
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenCustomObject
    public boolean equals(@Nullable Object o) {
        return (o instanceof SpenStickyNote) && getMHandle() == ((SpenStickyNote) o).getMHandle();
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenCustomObject
    @ColorInt
    public int getBackgroundColor() {
        return StickyNote_getBackgroundColor(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenCustomObject
    @NotNull
    public RectF getCollapseRect() {
        return StickyNote_getCollapseRect(getMHandle());
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenCustomObject
    public void setBackgroundColor(int i) {
        if (StickyNote_setBackgroundColor(getMHandle(), i)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenCustomObject
    public void setCollapseRect(@NotNull RectF rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (StickyNote_setCollapseRect(getMHandle(), rect)) {
            return;
        }
        throwUncheckedException(SpenError.getError());
    }
}
