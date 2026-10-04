package com.google.android.material.oneui.floatingdock.behavior;

import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.material.oneui.floatingdock.FloatingDockLogTag;
import com.google.android.material.oneui.floatingdock.IFloatingPaneCallback;
import com.google.android.material.oneui.floatingdock.util.FloatingPaneCallbackNotifier;
import com.google.firebase.messaging.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010a\u001a\u00020\bH\u0017J\u001a\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u001a\u0010h\u001a\u0004\u0018\u00010i2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\b\u0010j\u001a\u00020\bH\u0017J\u0018\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020*2\u0006\u0010n\u001a\u00020lH\u0016J\b\u0010o\u001a\u00020\bH&J\u001a\u0010p\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u001a\u0010q\u001a\u0004\u0018\u00010i2\u0006\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020gH\u0016J\u001a\u0010r\u001a\u00020l2\u0006\u0010s\u001a\u00020g2\b\b\u0002\u0010t\u001a\u00020*H\u0016J\u0010\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020gH\u0016J\u0010\u0010x\u001a\u00020*2\u0006\u0010y\u001a\u00020lH\u0016J\b\u0010z\u001a\u00020*H\u0016J\u0010\u0010{\u001a\u00020*2\u0006\u0010d\u001a\u00020eH\u0016J\u0010\u0010|\u001a\u00020v2\u0006\u0010w\u001a\u00020gH\u0016J\u0010\u0010}\u001a\u00020v2\u0006\u0010w\u001a\u00020gH\u0016J\u0018\u0010~\u001a\u00020v2\u0006\u0010m\u001a\u00020*2\u0006\u0010s\u001a\u00020gH\u0016J\u001a\u0010\u007f\u001a\u00020*2\u0006\u0010s\u001a\u00020g2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016J\u0011\u0010\u0082\u0001\u001a\u00020v2\u0006\u0010w\u001a\u00020gH&J\u001b\u0010\u0083\u0001\u001a\u00020v2\u0007\u0010\u0084\u0001\u001a\u00020g2\u0007\u0010\u0085\u0001\u001a\u00020\bH\u0016J\u0011\u0010\u0086\u0001\u001a\u00020v2\u0006\u0010s\u001a\u00020gH\u0016J\u0011\u0010\u0087\u0001\u001a\u00020*2\u0006\u0010s\u001a\u00020gH\u0016J\u001b\u0010\u0088\u0001\u001a\u00020v2\u0006\u0010s\u001a\u00020g2\b\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\fR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\fR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0018\u0010\n\"\u0004\b\u0019\u0010\fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR\u001e\u0010 \u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b!\u0010\n\"\u0004\b\"\u0010\fR\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020*@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001c\u00105\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R\u001c\u00108\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R\u001a\u0010;\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010/\"\u0004\b=\u00101R\u001a\u0010>\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010/\"\u0004\b@\u00101R\u001a\u0010A\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010/\"\u0004\bC\u00101R\u001a\u0010D\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010/\"\u0004\bF\u00101R\u001a\u0010G\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010/\"\u0004\bI\u00101R\u001c\u0010J\u001a\u00020\b8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010/\"\u0004\bL\u00101R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010N\u001a\u0004\bM\u0010/R\u001a\u0010O\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010R\"\u0004\bW\u0010TR\u001c\u0010X\u001a\u00020\b8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010/\"\u0004\bZ\u00101R\u001c\u0010[\u001a\u00020\b8VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010/\"\u0004\b]\u00101R\u001c\u0010^\u001a\u0004\u0018\u00010$X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010&\"\u0004\b`\u0010(\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0089\u0001"}, m13886d2 = {"Lcom/google/android/material/oneui/floatingdock/behavior/CommonBehavior;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "mode", "Lcom/google/android/material/oneui/floatingdock/FloatingPane$FloatingPaneMode;", "callbackNotifier", "Lcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;", "(ILcom/google/android/material/oneui/floatingdock/util/FloatingPaneCallbackNotifier;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "customBackground", "", "getCustomBackground", "()Ljava/lang/Integer;", "setCustomBackground", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "customHeight", "getCustomHeight", "setCustomHeight", "customMaxHeight", "getCustomMaxHeight", "setCustomMaxHeight", "customMaxWidth", "getCustomMaxWidth", "setCustomMaxWidth", "customMinHeight", "getCustomMinHeight", "setCustomMinHeight", "customMinWidth", "getCustomMinWidth", "setCustomMinWidth", "customMinimizeWidth", "getCustomMinimizeWidth", "setCustomMinimizeWidth", "customWidth", "getCustomWidth", "setCustomWidth", "hideAnimationListener", "Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;", "getHideAnimationListener", "()Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;", "setHideAnimationListener", "(Lcom/google/android/material/oneui/floatingdock/IFloatingPaneCallback$AnimationListener;)V", "<set-?>", "", "isMinimized", "()Z", "maxHeight", "getMaxHeight", "()I", "setMaxHeight", "(I)V", "maxWidth", "getMaxWidth", "setMaxWidth", "minHeight", "getMinHeight", "setMinHeight", "minWidth", "getMinWidth", "setMinWidth", "minimizeHeight", "getMinimizeHeight", "setMinimizeHeight", "minimizeMaxHeight", "getMinimizeMaxHeight", "setMinimizeMaxHeight", "minimizeMaxWidth", "getMinimizeMaxWidth", "setMinimizeMaxWidth", "minimizeMinHeight", "getMinimizeMinHeight", "setMinimizeMinHeight", "minimizeMinWidth", "getMinimizeMinWidth", "setMinimizeMinWidth", "minimizeWidth", "getMinimizeWidth", "setMinimizeWidth", "getMode-91QzYFA", "I", "posXRatio", "", "getPosXRatio", "()F", "setPosXRatio", "(F)V", "posYRatio", "getPosYRatio", "setPosYRatio", "requestedHeight", "getRequestedHeight", "setRequestedHeight", "requestedWidth", "getRequestedWidth", "setRequestedWidth", "showAnimationListener", "getShowAnimationListener", "setShowAnimationListener", "getBackgroundResId", "getHideAnimation", "Landroid/animation/AnimatorSet;", "context", "Landroid/content/Context;", "target", "Landroid/view/View;", "getHideSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "getMenuLayoutResId", "getMinimizeRect", "Landroid/graphics/Rect;", "minimize", Constants.MessagePayloadKeys.FROM, "getResizePinDirectionFlags", "getShowAnimation", "getShowSpringAnimation", "getTargetModeBounds", "view", "moveValidArea", "initBehavior", "", "parent", "isMinimizableRect", "newRect", "isSupportMinimize", "isSupported", "loadState", "saveState", "setMinimize", "shouldInterceptTouch", "event", "Landroid/view/MotionEvent;", "updateBehavior", "updateDivider", "divider", "dividerSize", "updateLayoutParams", "updateMinimize", "updateState", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public abstract class CommonBehavior implements FloatingDockLogTag {

    @NotNull
    private final FloatingPaneCallbackNotifier callbackNotifier;

    @DrawableRes
    @Nullable
    private Integer customBackground;

    @Nullable
    private Integer customHeight;

    @Nullable
    private Integer customMaxHeight;

    @Nullable
    private Integer customMaxWidth;

    @Nullable
    private Integer customMinHeight;

    @Nullable
    private Integer customMinWidth;

    @Nullable
    private Integer customMinimizeWidth;

    @Nullable
    private Integer customWidth;

    @Nullable
    private IFloatingPaneCallback.AnimationListener hideAnimationListener;
    private boolean isMinimized;
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;
    private int minimizeHeight;
    private int minimizeMaxHeight;
    private int minimizeMaxWidth;
    private int minimizeMinHeight;
    private int minimizeMinWidth;
    private int minimizeWidth;
    private final int mode;
    private float posXRatio;
    private float posYRatio;
    private int requestedHeight;
    private int requestedWidth;

    @Nullable
    private IFloatingPaneCallback.AnimationListener showAnimationListener;

    public /* synthetic */ CommonBehavior(int i, FloatingPaneCallbackNotifier floatingPaneCallbackNotifier, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, floatingPaneCallbackNotifier);
    }

    public static /* synthetic */ Rect getTargetModeBounds$default(CommonBehavior commonBehavior, View view, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getTargetModeBounds");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return commonBehavior.getTargetModeBounds(view, z);
    }

    @DrawableRes
    public int getBackgroundResId() {
        return -1;
    }

    @Nullable
    public final Integer getCustomBackground() {
        return this.customBackground;
    }

    @Nullable
    public Integer getCustomHeight() {
        return this.customHeight;
    }

    @Nullable
    public Integer getCustomMaxHeight() {
        return this.customMaxHeight;
    }

    @Nullable
    public Integer getCustomMaxWidth() {
        return this.customMaxWidth;
    }

    @Nullable
    public Integer getCustomMinHeight() {
        return this.customMinHeight;
    }

    @Nullable
    public Integer getCustomMinWidth() {
        return this.customMinWidth;
    }

    @Nullable
    public Integer getCustomMinimizeWidth() {
        return this.customMinimizeWidth;
    }

    @Nullable
    public Integer getCustomWidth() {
        return this.customWidth;
    }

    @Nullable
    public AnimatorSet getHideAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        return null;
    }

    @Nullable
    public IFloatingPaneCallback.AnimationListener getHideAnimationListener() {
        return this.hideAnimationListener;
    }

    @Nullable
    public SpringAnimation getHideSpringAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        return null;
    }

    public final int getMaxHeight() {
        Integer customMaxHeight = getCustomMaxHeight();
        return customMaxHeight != null ? customMaxHeight.intValue() : this.maxHeight;
    }

    public final int getMaxWidth() {
        Integer customMaxWidth = getCustomMaxWidth();
        return customMaxWidth != null ? customMaxWidth.intValue() : this.maxWidth;
    }

    @LayoutRes
    public int getMenuLayoutResId() {
        return -1;
    }

    public final int getMinHeight() {
        Integer customMinHeight = getCustomMinHeight();
        return customMinHeight != null ? customMinHeight.intValue() : this.minHeight;
    }

    public final int getMinWidth() {
        Integer customMinWidth = getCustomMinWidth();
        return customMinWidth != null ? customMinWidth.intValue() : this.minWidth;
    }

    public final int getMinimizeHeight() {
        return this.minimizeHeight;
    }

    public final int getMinimizeMaxHeight() {
        return this.minimizeMaxHeight;
    }

    public final int getMinimizeMaxWidth() {
        return this.minimizeMaxWidth;
    }

    public final int getMinimizeMinHeight() {
        return this.minimizeMinHeight;
    }

    public final int getMinimizeMinWidth() {
        return this.minimizeMinWidth;
    }

    @NotNull
    public Rect getMinimizeRect(boolean minimize, @NotNull Rect from) {
        Intrinsics.checkNotNullParameter(from, "from");
        return new Rect();
    }

    public final int getMinimizeWidth() {
        Integer customMinimizeWidth = getCustomMinimizeWidth();
        int iIntValue = customMinimizeWidth != null ? customMinimizeWidth.intValue() : this.minimizeWidth;
        int i = this.minimizeMinWidth;
        if (i >= 0 && iIntValue < i) {
            iIntValue = i;
        }
        int i2 = this.minimizeMaxWidth;
        return (i2 < 0 || i2 >= iIntValue) ? iIntValue : i2;
    }

    /* JADX INFO: renamed from: getMode-91QzYFA, reason: not valid java name and from getter */
    public final int getMode() {
        return this.mode;
    }

    public final float getPosXRatio() {
        return this.posXRatio;
    }

    public final float getPosYRatio() {
        return this.posYRatio;
    }

    public int getRequestedHeight() {
        Integer customHeight = getCustomHeight();
        int iIntValue = customHeight != null ? customHeight.intValue() : this.requestedHeight;
        if (getMinHeight() >= 0 && iIntValue < getMinHeight()) {
            iIntValue = getMinHeight();
        }
        int maxHeight = getMaxHeight();
        return (maxHeight < 0 || maxHeight >= iIntValue) ? iIntValue : getMaxHeight();
    }

    public int getRequestedWidth() {
        Integer customWidth = getCustomWidth();
        int iIntValue = customWidth != null ? customWidth.intValue() : this.requestedWidth;
        if (getMinWidth() >= 0 && iIntValue < getMinWidth()) {
            iIntValue = getMinWidth();
        }
        int maxWidth = getMaxWidth();
        return (maxWidth < 0 || maxWidth >= iIntValue) ? iIntValue : getMaxWidth();
    }

    public abstract int getResizePinDirectionFlags();

    @Nullable
    public AnimatorSet getShowAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        return null;
    }

    @Nullable
    public IFloatingPaneCallback.AnimationListener getShowAnimationListener() {
        return this.showAnimationListener;
    }

    @Nullable
    public SpringAnimation getShowSpringAnimation(@NotNull Context context, @NotNull View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        return null;
    }

    @NotNull
    public Rect getTargetModeBounds(@NotNull View view, boolean moveValidArea) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new Rect();
    }

    public void initBehavior(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        updateBehavior(parent);
    }

    public boolean isMinimizableRect(@NotNull Rect newRect) {
        Intrinsics.checkNotNullParameter(newRect, "newRect");
        return false;
    }

    /* JADX INFO: renamed from: isMinimized, reason: from getter */
    public final boolean getIsMinimized() {
        return this.isMinimized;
    }

    public boolean isSupportMinimize() {
        return false;
    }

    public boolean isSupported(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return true;
    }

    public void loadState(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public void saveState(@NotNull View parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    public final void setCustomBackground(@Nullable Integer num) {
        this.customBackground = num;
    }

    public void setCustomHeight(@Nullable Integer num) {
        this.customHeight = num;
    }

    public void setCustomMaxHeight(@Nullable Integer num) {
        this.customMaxHeight = num;
    }

    public void setCustomMaxWidth(@Nullable Integer num) {
        this.customMaxWidth = num;
    }

    public void setCustomMinHeight(@Nullable Integer num) {
        this.customMinHeight = num;
    }

    public void setCustomMinWidth(@Nullable Integer num) {
        this.customMinWidth = num;
    }

    public void setCustomMinimizeWidth(@Nullable Integer num) {
        this.customMinimizeWidth = num;
    }

    public void setCustomWidth(@Nullable Integer num) {
        this.customWidth = num;
    }

    public void setHideAnimationListener(@Nullable IFloatingPaneCallback.AnimationListener animationListener) {
        this.hideAnimationListener = animationListener;
    }

    public final void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public final void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public final void setMinHeight(int i) {
        this.minHeight = i;
    }

    public final void setMinWidth(int i) {
        this.minWidth = i;
    }

    public void setMinimize(boolean minimize, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (this.isMinimized == minimize) {
            return;
        }
        this.isMinimized = minimize;
        this.callbackNotifier.onMinimizedChanged(this.mode, minimize);
    }

    public final void setMinimizeHeight(int i) {
        this.minimizeHeight = i;
    }

    public final void setMinimizeMaxHeight(int i) {
        this.minimizeMaxHeight = i;
    }

    public final void setMinimizeMaxWidth(int i) {
        this.minimizeMaxWidth = i;
    }

    public final void setMinimizeMinHeight(int i) {
        this.minimizeMinHeight = i;
    }

    public final void setMinimizeMinWidth(int i) {
        this.minimizeMinWidth = i;
    }

    public final void setMinimizeWidth(int i) {
        this.minimizeWidth = i;
    }

    public final void setPosXRatio(float f) {
        this.posXRatio = f;
    }

    public final void setPosYRatio(float f) {
        this.posYRatio = f;
    }

    public void setRequestedHeight(int i) {
        this.requestedHeight = i;
    }

    public void setRequestedWidth(int i) {
        this.requestedWidth = i;
    }

    public void setShowAnimationListener(@Nullable IFloatingPaneCallback.AnimationListener animationListener) {
        this.showAnimationListener = animationListener;
    }

    public boolean shouldInterceptTouch(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
        return false;
    }

    public abstract void updateBehavior(@NotNull View parent);

    public void updateDivider(@NotNull View divider, int dividerSize) {
        Intrinsics.checkNotNullParameter(divider, "divider");
        divider.setVisibility(8);
    }

    public void updateLayoutParams(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public boolean updateMinimize(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return false;
    }

    public void updateState(@NotNull View view, @NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(event, "event");
    }

    private CommonBehavior(int i, FloatingPaneCallbackNotifier callbackNotifier) {
        Intrinsics.checkNotNullParameter(callbackNotifier, "callbackNotifier");
        this.mode = i;
        this.callbackNotifier = callbackNotifier;
        this.minWidth = -1;
        this.minHeight = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.requestedWidth = -1;
        this.requestedHeight = -1;
        this.posXRatio = -1.0f;
        this.posYRatio = -1.0f;
        this.minimizeWidth = -1;
        this.minimizeHeight = -1;
        this.minimizeMaxWidth = -1;
        this.minimizeMaxHeight = Integer.MAX_VALUE;
        this.minimizeMinWidth = -1;
        this.minimizeMinHeight = -1;
    }
}
