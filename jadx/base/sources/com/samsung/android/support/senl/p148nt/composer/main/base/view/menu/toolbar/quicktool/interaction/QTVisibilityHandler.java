package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.interaction;

import android.view.MotionEvent;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import com.samsung.android.view.animation.SineInOut90;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/interaction/QTVisibilityHandler;", "", "tool", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickTool;)V", "wasPrimaryStylusButtonPressedInHover", "", "wasPrimaryStylusButtonPressedOutHover", "wasScreenTouchedAfterPressing", "isHideAnimationRunning", "consumeTouchOutside", "countMoveEvent", "", "onHover", "event", "Landroid/view/MotionEvent;", "onTouch", "onTouchComposer", "hasTouchPosition", "runPreTouchAnimation", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/QuickToolContainer;", "isHideAnimation", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTVisibilityHandler {
    private boolean consumeTouchOutside;
    private int countMoveEvent;
    private boolean isHideAnimationRunning;

    @NotNull
    private final QuickTool tool;
    private boolean wasPrimaryStylusButtonPressedInHover;
    private boolean wasPrimaryStylusButtonPressedOutHover;
    private boolean wasScreenTouchedAfterPressing;

    public QTVisibilityHandler(@NotNull QuickTool tool) {
        Intrinsics.checkNotNullParameter(tool, "tool");
        this.tool = tool;
    }

    private final boolean hasTouchPosition(MotionEvent event) {
        QuickToolContainer child = this.tool.getChild();
        if (child == null) {
            return false;
        }
        child.getLocationOnScreen(new int[2]);
        float fConvertDpToPixel = this.tool.isFavoritePenListShow() ? ResourceUtils.convertDpToPixel(child.getContext(), 732.0f) : 0.0f;
        float rawX = event.getRawX() - ((child.getWidth() / 2) + r3[0]);
        float rawY = event.getRawY() - ((child.getHeight() / 2) + r3[1]);
        float f = this.tool.isRightDocking() ? rawX - fConvertDpToPixel : rawX + fConvertDpToPixel;
        return ((float) Math.sqrt((double) ((rawY * rawY) + (f * f)))) < ResourceUtils.convertDpToPixel(child.getContext(), this.tool.isFavoritePenListShow() ? 874.0f : this.tool.isColorPickerViewMode() ? 188.0f : 142.0f);
    }

    private final void runPreTouchAnimation(QuickToolContainer quickToolContainer, boolean z) {
        if (z) {
            quickToolContainer.clearAnimation();
            quickToolContainer.animate().alpha(0.0f).setDuration(300L).setInterpolator(new SineInOut90());
        } else {
            quickToolContainer.clearAnimation();
            quickToolContainer.animate().alpha(1.0f).setDuration(300L).setInterpolator(new SineInOut90());
        }
    }

    public final boolean onHover(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean zIsButtonPressed = event.isButtonPressed(32);
        int action = event.getAction();
        if (action != 7) {
            if (action == 9) {
                this.wasPrimaryStylusButtonPressedInHover = zIsButtonPressed;
                this.wasPrimaryStylusButtonPressedOutHover = zIsButtonPressed;
                this.wasScreenTouchedAfterPressing = this.wasScreenTouchedAfterPressing && zIsButtonPressed;
            } else if (action == 10) {
                this.wasScreenTouchedAfterPressing = false;
            }
        } else if (zIsButtonPressed) {
            this.wasPrimaryStylusButtonPressedInHover = true;
        } else if (this.wasPrimaryStylusButtonPressedOutHover) {
            this.wasPrimaryStylusButtonPressedInHover = false;
            this.wasPrimaryStylusButtonPressedOutHover = false;
            if (!this.wasScreenTouchedAfterPressing) {
                return QuickTool.show$default(this.tool, event.getRawX(), event.getRawY(), false, 4, null);
            }
            this.wasScreenTouchedAfterPressing = false;
        } else if (this.wasPrimaryStylusButtonPressedInHover) {
            this.wasPrimaryStylusButtonPressedInHover = false;
            if (!this.wasScreenTouchedAfterPressing) {
                return this.tool.toggle(event.getRawX(), event.getRawY());
            }
            this.wasScreenTouchedAfterPressing = false;
        }
        return false;
    }

    public final boolean onTouch(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.wasScreenTouchedAfterPressing = this.wasPrimaryStylusButtonPressedInHover || this.wasPrimaryStylusButtonPressedOutHover;
        if (event.getAction() == 0) {
            boolean zHide = this.tool.hide();
            this.consumeTouchOutside = zHide;
            this.countMoveEvent = 0;
            if (zHide) {
                QuickToolSA.INSTANCE.logFirstBehavior(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING);
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchComposer(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 1) {
            if (this.consumeTouchOutside && this.countMoveEvent < 10) {
                this.tool.requestCancelTouch();
            }
            if (this.isHideAnimationRunning) {
                QuickToolContainer child = this.tool.getChild();
                if (child != null) {
                    runPreTouchAnimation(child, false);
                }
                this.isHideAnimationRunning = false;
            }
        } else if (actionMasked == 2) {
            this.countMoveEvent++;
            if (this.tool.isShowing() && hasTouchPosition(event) && !this.isHideAnimationRunning) {
                QuickToolContainer child2 = this.tool.getChild();
                if (child2 != null) {
                    runPreTouchAnimation(child2, true);
                }
                this.isHideAnimationRunning = true;
            }
        } else if (actionMasked != 3) {
            switch (actionMasked) {
            }
        }
        return false;
    }
}
