package com.samsung.android.support.senl.p145cm.base.framework.view;

import android.animation.StateListAnimator;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import android.view.PointerIcon;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsViewCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.ViewCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.SemBlurInfoCompat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 F2\u00020\u0001:\u0001FB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0007J\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u000bJ0\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007J\u0018\u0010'\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020)J4\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u00010\u00012\u0006\u00100\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tJ\u0016\u00102\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\u0006\u00103\u001a\u00020\u000bJ\u0010\u00104\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u00105\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00106\u001a\u00020\u000bJ \u00105\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bJ,\u00108\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u00020\u000b2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0:J\u0018\u0010;\u001a\u00020\u001d2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010<\u001a\u00020\u0007J\u0018\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000bJ\u0018\u0010B\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\t2\b\u0010C\u001a\u0004\u0018\u00010DJ\u000e\u0010E\u001a\u00020\u001d2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000f¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/ViewCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl;)V", "setPointerIcon", "", "view", "Landroid/view/View;", "toolType", "", "pointerIconType", "hoveringSpenIconDefault", "getHoveringSpenIconDefault", "()I", "stylusScrollUpType", "getStylusScrollUpType", "stylusScrollDownType", "getStylusScrollDownType", "stylusScrollLeftType", "getStylusScrollLeftType", "stylusScrollRightType", "getStylusScrollRightType", "setSemSetActionModeAutoFillEnabled", "textView", "Landroid/widget/TextView;", "value", "setTooltipText", "", "tooltipText", "", "setSystemUiVisibility", "decorView", "visibility", "flag", "disableRecent", "disableHome", "disableBack", "setShadowAlpha", "alpha", "", "startDragAndDrop", "data", "Landroid/content/ClipData;", "shadowBuilder", "Landroid/view/View$DragShadowBuilder;", "myLocalState", "flags", "cancelDragAndDrop", "performHapticFeedback", "feedbackConstant", "requestAccessibilityFocus", "setRoundedCornerColor", "color", "corners", "setRoundedCorners", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/util/Pair;", "setAutoHandwritingEnabled", "enabled", "getRecoilStateListAnimator", "Landroid/animation/StateListAnimator;", "context", "Landroid/content/Context;", "type", "semSetBlurInfo", "blurInfoCompatBuilder", "Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$Builder;", "semClearUiDescriptors", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ViewCompat {
    private static final int ACTION_MODE_MENU_ITEM_AUTOFILL_ID = 131072;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int HAPTIC_INDEX_DRAG_DROP_EFFECT_TICK = 41;
    public static final int HAPTIC_INDEX_DRAG_DROP_FLOATING = 110;
    public static final int HAPTIC_INDEX_DRAG_DROP_START = 108;
    public static final int HAPTIC_INDEX_LONG_PRESS = 1;
    public static final int HAPTIC_INDEX_SHUTTER_PRESS = 37;
    public static final int HAPTIC_INDEX_SHUTTER_RELEASE = 48;
    public static final int RECOIL_SMALL_TOUCH_ANIMATOR = 0;

    @Nullable
    private static ViewCompat mInstance;

    @NotNull
    private final AbsViewCompatImplFactory.IViewCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/view/ViewCompat$Companion;", "", "<init>", "()V", "HAPTIC_INDEX_DRAG_DROP_START", "", "HAPTIC_INDEX_DRAG_DROP_FLOATING", "HAPTIC_INDEX_DRAG_DROP_EFFECT_TICK", "HAPTIC_INDEX_SHUTTER_PRESS", "HAPTIC_INDEX_SHUTTER_RELEASE", "HAPTIC_INDEX_LONG_PRESS", "RECOIL_SMALL_TOUCH_ANIMATOR", "mInstance", "Lcom/samsung/android/support/senl/cm/base/framework/view/ViewCompat;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/view/ViewCompat;", "ACTION_MODE_MENU_ITEM_AUTOFILL_ID", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ViewCompat getInstance() {
            ViewCompat viewCompat;
            try {
                if (ViewCompat.mInstance == null) {
                    ViewCompat.mInstance = new ViewCompat(new ViewCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                viewCompat = ViewCompat.mInstance;
                Intrinsics.checkNotNull(viewCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.view.ViewCompat");
            } catch (Throwable th) {
                throw th;
            }
            return viewCompat;
        }

        private Companion() {
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }

    public /* synthetic */ ViewCompat(AbsViewCompatImplFactory.IViewCompatImpl iViewCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iViewCompatImpl);
    }

    @NotNull
    public static final synchronized ViewCompat getInstance() {
        return INSTANCE.getInstance();
    }

    public final void cancelDragAndDrop(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mImpl.cancelDragAndDrop(view);
    }

    public final int getHoveringSpenIconDefault() {
        return this.mImpl.getHoveringSpenIconDefault();
    }

    @Nullable
    public final StateListAnimator getRecoilStateListAnimator(@NotNull Context context, int type) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.mImpl.getRecoilStateListAnimator(context, type);
    }

    public final int getStylusScrollDownType() {
        return this.mImpl.getStylusScrollDownType();
    }

    public final int getStylusScrollLeftType() {
        return this.mImpl.getStylusScrollLeftType();
    }

    public final int getStylusScrollRightType() {
        return this.mImpl.getStylusScrollRightType();
    }

    public final int getStylusScrollUpType() {
        return this.mImpl.getStylusScrollUpType();
    }

    public final void performHapticFeedback(@NotNull View view, int feedbackConstant) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Settings.System.getInt(view.getContext().getContentResolver(), "haptic_feedback_enabled", 1) == 0) {
            return;
        }
        this.mImpl.performHapticFeedback(view, feedbackConstant);
    }

    public final void requestAccessibilityFocus(@Nullable View view) {
        if (view == null) {
            return;
        }
        this.mImpl.requestAccessibilityFocus(view);
    }

    public final void semClearUiDescriptors(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mImpl.semClearUiDescriptors(view);
    }

    public final void semSetBlurInfo(@NotNull View view, @Nullable SemBlurInfoCompat.Builder blurInfoCompatBuilder) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.mImpl.semSetBlurInfo(view, blurInfoCompatBuilder);
    }

    public final void setAutoHandwritingEnabled(@Nullable View view, boolean enabled) {
        if (view == null) {
            return;
        }
        this.mImpl.setAutoHandwritingEnabled(view, enabled);
    }

    public final boolean setPointerIcon(@Nullable View view, int toolType, int pointerIconType) {
        if (view == null) {
            return false;
        }
        return this.mImpl.setPointerIcon(view, toolType, PointerIcon.getSystemIcon(view.getContext(), pointerIconType));
    }

    public final void setRoundedCornerColor(@Nullable View view, int color) {
        if (view == null) {
            return;
        }
        this.mImpl.setRoundedCornerColor(view, color);
    }

    public final void setRoundedCorners(@Nullable View view, int corners, @NotNull Pair<Integer, Integer> offset) {
        Intrinsics.checkNotNullParameter(offset, "offset");
        if (view == null) {
            return;
        }
        this.mImpl.setRoundedCorners(view, corners, offset);
    }

    public final boolean setSemSetActionModeAutoFillEnabled(@Nullable TextView textView, boolean value) {
        if (textView != null) {
            return this.mImpl.setActionModeMenuItemEnabled(textView, 131072, value);
        }
        return false;
    }

    public final void setShadowAlpha(@Nullable View view, float alpha) {
        if (view == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        view.setOutlineSpotShadowColor((((int) (255 * alpha)) << 24) | (view.getOutlineSpotShadowColor() & 16777215));
    }

    public final void setSystemUiVisibility(@Nullable View decorView, int visibility) {
        if (decorView != null) {
            this.mImpl.setSystemUiVisibility(decorView, visibility);
        }
    }

    public final void setTooltipText(@Nullable View view, @Nullable CharSequence tooltipText) {
        if (view != null) {
            this.mImpl.setTooltipText(view, tooltipText);
        }
    }

    public final boolean startDragAndDrop(@NotNull View view, @Nullable ClipData data, @Nullable View.DragShadowBuilder shadowBuilder, @Nullable Object myLocalState, int flags) {
        Intrinsics.checkNotNullParameter(view, "view");
        return this.mImpl.startDragAndDrop(view, data, shadowBuilder, myLocalState, flags);
    }

    private ViewCompat(AbsViewCompatImplFactory.IViewCompatImpl iViewCompatImpl) {
        this.mImpl = iViewCompatImpl;
    }

    public final void setRoundedCornerColor(@Nullable View view, int corners, int color) {
        if (view == null) {
            return;
        }
        this.mImpl.setRoundedCornerColor(view, corners, color);
    }

    public final void setSystemUiVisibility(@Nullable View decorView, int flag, boolean disableRecent, boolean disableHome, boolean disableBack) {
        if (decorView != null) {
            this.mImpl.setSystemUiVisibility(decorView, flag, disableRecent, disableHome, disableBack);
        }
    }

    public final void setTooltipText(@Nullable View view) {
        if (view != null) {
            CharSequence contentDescription = view.getContentDescription();
            this.mImpl.setTooltipText(view, contentDescription instanceof String ? (String) contentDescription : null);
        }
    }
}
