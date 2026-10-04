package com.samsung.android.support.senl.p148nt.base.composer.drag;

import android.graphics.PointF;
import android.view.View;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J \u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001aH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/drag/DragAutoScroll;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "scrollYAreaOne", "", "scrollYAreaTwo", "scrollBottomAreaOne", "scrollBottomAreaTwo", "scrollXAreaOne", "scrollXAreaTwo", "scrollRightAreaOne", "scrollRightAreaTwo", "onDragStarted", "", "view", "Landroid/view/View;", "autoScroll", "touchX", "", "touchY", "curPan", "Landroid/graphics/PointF;", "canScroll", "", "setPan", "pan", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class DragAutoScroll {
    public static final boolean DEBUG = true;
    public static final int SCROLL_AREA_ONE = 50;
    public static final int SCROLL_AREA_TWO = 25;
    private double scrollBottomAreaOne;
    private double scrollBottomAreaTwo;
    private double scrollRightAreaOne;
    private double scrollRightAreaTwo;
    private double scrollXAreaOne;
    private double scrollXAreaTwo;
    private double scrollYAreaOne;
    private double scrollYAreaTwo;

    @NotNull
    private final String tag;

    public DragAutoScroll(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    public final void autoScroll(float touchX, float touchY, @Nullable PointF curPan) {
        if (curPan != null && canScroll()) {
            PointF pointF = new PointF(curPan.x, curPan.y);
            double d = touchY;
            if (this.scrollBottomAreaOne < d) {
                if (this.scrollBottomAreaTwo < d) {
                    curPan.y += 50.0f;
                } else {
                    curPan.y += 25.0f;
                }
            } else if (this.scrollYAreaOne > d) {
                if (this.scrollYAreaTwo > d) {
                    curPan.y -= 50.0f;
                } else {
                    curPan.y -= 25.0f;
                }
            }
            double d2 = touchX;
            if (this.scrollRightAreaOne < d2) {
                if (this.scrollRightAreaTwo < d2) {
                    curPan.x += 50.0f;
                } else {
                    curPan.x += 25.0f;
                }
            } else if (this.scrollXAreaOne > d2) {
                if (this.scrollXAreaTwo > d2) {
                    curPan.x -= 50.0f;
                } else {
                    curPan.x -= 25.0f;
                }
            }
            if (pointF.x == curPan.x && pointF.y == curPan.y) {
                return;
            }
            Logger.m8697d(this.tag, "autoScroll# setPan : " + curPan);
            setPan(curPan);
        }
    }

    public abstract boolean canScroll();

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public final void onDragStarted(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.scrollYAreaOne = ((double) view.getHeight()) * 0.1d;
        this.scrollYAreaTwo = ((double) view.getHeight()) * 0.05d;
        this.scrollBottomAreaOne = ((double) view.getBottom()) - this.scrollYAreaOne;
        this.scrollBottomAreaTwo = ((double) view.getBottom()) - this.scrollYAreaTwo;
        this.scrollXAreaOne = ((double) view.getWidth()) * 0.1d;
        this.scrollXAreaTwo = ((double) view.getWidth()) * 0.05d;
        this.scrollRightAreaOne = ((double) view.getRight()) - this.scrollXAreaOne;
        this.scrollRightAreaTwo = ((double) view.getRight()) - this.scrollXAreaTwo;
    }

    public abstract void setPan(@NotNull PointF pan);
}
