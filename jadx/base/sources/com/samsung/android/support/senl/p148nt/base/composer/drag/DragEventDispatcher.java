package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.graphics.PointF;
import android.view.DragEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u0006\u0010\u0018\u001a\u00020\u000fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;", "", "<init>", "()V", "movingView", "Landroid/view/View;", "dropAreaView", "yInMemo", "", "Ljava/lang/Integer;", "memoPos", "Landroid/graphics/PointF;", "dragEventListener", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher$DragEventListener;", "setTarget", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "dispatchDragEvent", "", "view", "event", "Landroid/view/DragEvent;", "checkOutOfBound", TypedValues.Cycle.S_WAVE_OFFSET, "clear", "DragEventListener", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class DragEventDispatcher {

    @Nullable
    private DragEventListener dragEventListener;

    @Nullable
    private View dropAreaView;

    @Nullable
    private PointF memoPos;

    @Nullable
    private View movingView;

    @Nullable
    private Integer yInMemo;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher$DragEventListener;", "", "onDrag", "", "view", "Landroid/view/View;", "event", "Landroid/view/DragEvent;", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/graphics/PointF;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface DragEventListener {
        boolean onDrag(@NotNull View view, @NotNull DragEvent event, @NotNull PointF offset);
    }

    private final boolean checkOutOfBound(DragEvent event, View view, PointF offset) {
        float x = event.getX() + offset.x;
        float y2 = event.getY() + offset.y;
        return x < 0.0f || x > ((float) view.getWidth()) || y2 < 0.0f || y2 > ((float) view.getHeight());
    }

    public final void clear() {
        this.movingView = null;
        this.dropAreaView = null;
        this.yInMemo = null;
        this.memoPos = null;
        this.dragEventListener = null;
    }

    public final boolean dispatchDragEvent(@NotNull View view, @NotNull DragEvent event) {
        View view2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.dragEventListener == null) {
            return false;
        }
        if (this.yInMemo == null && (view2 = this.movingView) != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int[] iArr2 = new int[2];
            View view3 = this.dropAreaView;
            Intrinsics.checkNotNull(view3);
            view3.getLocationInWindow(iArr2);
            this.yInMemo = Integer.valueOf(iArr2[1] - iArr[1]);
        }
        if (event.getAction() == 1) {
            View view4 = this.movingView;
            if (view4 != null) {
                float f = -view4.getTranslationX();
                float translationY = view4.getTranslationY();
                Intrinsics.checkNotNull(this.yInMemo);
                this.memoPos = new PointF(f, (translationY + r4.intValue()) * (-1));
            }
        } else if (this.movingView != null && (event.getAction() == 2 || event.getAction() == 3)) {
            View view5 = this.movingView;
            Intrinsics.checkNotNull(view5);
            PointF pointF = this.memoPos;
            Intrinsics.checkNotNull(pointF);
            if (checkOutOfBound(event, view5, pointF)) {
                return false;
            }
        }
        DragEventListener dragEventListener = this.dragEventListener;
        Intrinsics.checkNotNull(dragEventListener);
        PointF pointF2 = this.memoPos;
        Intrinsics.checkNotNull(pointF2);
        return dragEventListener.onDrag(view, event, pointF2);
    }

    public final void setTarget(@NotNull View movingView, @NotNull View dropAreaView, @NotNull DragEventListener listener) {
        Intrinsics.checkNotNullParameter(movingView, "movingView");
        Intrinsics.checkNotNullParameter(dropAreaView, "dropAreaView");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.movingView = movingView;
        this.dropAreaView = dropAreaView;
        this.dragEventListener = listener;
    }
}
