package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Pair;
import android.util.TypedValue;
import android.view.HapticFeedbackConstants;
import android.view.PointerIcon;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.C0419R;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.spen.libse.SePointerIcon;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsViewCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.SemBlurInfoCompat;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/ViewCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ViewCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ViewCompatImplFactory extends AbsViewCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u001a\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020\u000bH\u0016J2\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010%\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u0005H\u0016J\u001a\u0010)\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0012\u0010+\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010,\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020\u000bH\u0016J\"\u0010,\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000bH\u0016J.\u0010/\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010.\u001a\u00020\u000b2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b01H\u0016J\u0010\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0002J\u001a\u00108\u001a\u00020\u001f2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u00109\u001a\u00020\u0005H\u0016J\u001a\u0010:\u001a\u0004\u0018\u00010;2\u0006\u00103\u001a\u0002042\u0006\u0010<\u001a\u00020\u000bH\u0016J\u001a\u0010=\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020\u001f2\u0006\u0010\b\u001a\u00020\tH\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/ViewCompatImplFactory$ViewCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$AbsViewCompatImpl;", "<init>", "()V", "mIsSupportDcHaptic", "", "Ljava/lang/Boolean;", "setPointerIcon", "view", "Landroid/view/View;", "toolType", "", "pointerIcon", "Landroid/view/PointerIcon;", "hoveringSpenIconDefault", "getHoveringSpenIconDefault", "()I", "stylusScrollUpType", "getStylusScrollUpType", "stylusScrollDownType", "getStylusScrollDownType", "stylusScrollLeftType", "getStylusScrollLeftType", "stylusScrollRightType", "getStylusScrollRightType", "setActionModeMenuItemEnabled", "textView", "Landroid/widget/TextView;", "menuid", "value", "setTooltipText", "", "tooltipText", "", "setSystemUiVisibility", "decorView", "visibility", "flag", "disableRecent", "disableHome", "disableBack", "performHapticFeedback", "feedbackConstant", "requestAccessibilityFocus", "setRoundedCornerColor", "color", "corners", "setRoundedCorners", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/util/Pair;", "isSupportDcHaptic", "context", "Landroid/content/Context;", "performDCHapticFeedback", "vibrator", "Landroid/os/Vibrator;", "setAutoHandwritingEnabled", "enabled", "getRecoilStateListAnimator", "Landroid/animation/StateListAnimator;", "type", "semSetBlurInfo", "blurInfoCompatBuilder", "Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$Builder;", "semClearUiDescriptors", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewCompatSemImpl extends AbsViewCompatImplFactory.AbsViewCompatImpl {
        private static final int VALID_HAPTIC_PATTERN = 50;

        @Nullable
        private Boolean mIsSupportDcHaptic;
        private final int hoveringSpenIconDefault = 20001;
        private final int stylusScrollUpType = SePointerIcon.TYPE_STYLUS_SCROLL_UP;
        private final int stylusScrollDownType = SePointerIcon.TYPE_STYLUS_SCROLL_DOWN;
        private final int stylusScrollLeftType = SePointerIcon.TYPE_STYLUS_SCROLL_LEFT;
        private final int stylusScrollRightType = SePointerIcon.TYPE_STYLUS_SCROLL_RIGHT;

        private final boolean isSupportDcHaptic(Context context) {
            if (this.mIsSupportDcHaptic == null) {
                if (FloatingFeature.INSTANCE.getInstance().getBoolean("SEC_FLOATING_FEATURE_AUDIO_SUPPORT_DC_MOTOR_HAPTIC_FEEDBACK")) {
                    Object systemService = context.getSystemService("vibrator");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                    this.mIsSupportDcHaptic = Boolean.valueOf(((Vibrator) systemService).semGetSupportedVibrationType() == 1);
                } else {
                    this.mIsSupportDcHaptic = Boolean.FALSE;
                }
            }
            Boolean bool = this.mIsSupportDcHaptic;
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }

        private final void performDCHapticFeedback(Vibrator vibrator) {
            vibrator.vibrate(VibrationEffect.semCreateWaveform(HapticFeedbackConstants.semGetVibrationIndex(100), -1, VibrationEffect.SemMagnitudeType.TYPE_TOUCH));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getHoveringSpenIconDefault() {
            return this.hoveringSpenIconDefault;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        @Nullable
        public StateListAnimator getRecoilStateListAnimator(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            int i = C0419R.attr.seslSmallTouchAnimator;
            if (type == 1 || type == 2) {
                i = C0419R.attr.seslMediumTouchAnimator;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(i, typedValue, true);
            try {
                return AnimatorInflater.loadStateListAnimator(context, typedValue.resourceId);
            } catch (Resources.NotFoundException unused) {
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollDownType() {
            return this.stylusScrollDownType;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollLeftType() {
            return this.stylusScrollLeftType;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollRightType() {
            return this.stylusScrollRightType;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollUpType() {
            return this.stylusScrollUpType;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void performHapticFeedback(@Nullable View view, int feedbackConstant) {
            Context context;
            if (DeviceInfo.getSemAPIVersionInt(0) >= 2803) {
                Object systemService = (view == null || (context = view.getContext()) == null) ? null : context.getSystemService("vibrator");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                Vibrator vibrator = (Vibrator) systemService;
                if (vibrator.semGetNumberOfSupportedPatterns() >= 50) {
                    Context context2 = view.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    if (!isSupportDcHaptic(context2)) {
                        view.performHapticFeedback(HapticFeedbackConstants.semGetVibrationIndex(feedbackConstant), 1);
                        return;
                    } else {
                        if (feedbackConstant == 41) {
                            return;
                        }
                        performDCHapticFeedback(vibrator);
                        return;
                    }
                }
            }
            if (view != null) {
                view.performHapticFeedback(0);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void requestAccessibilityFocus(@Nullable View view) {
            if (view != null) {
                try {
                    view.semRequestAccessibilityFocus();
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("requestAccessibilityFocus: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "ViewCompat");
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void semClearUiDescriptors(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void semSetBlurInfo(@NotNull View view, @Nullable SemBlurInfoCompat.Builder blurInfoCompatBuilder) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (blurInfoCompatBuilder == null) {
                view.semSetBlurInfo(null);
            } else {
                view.semSetBlurInfo(blurInfoCompatBuilder.build());
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public boolean setActionModeMenuItemEnabled(@Nullable TextView textView, int menuid, boolean value) {
            if (DeviceInfo.getSemPlatformVersionInt(0) >= 90000) {
                if (textView == null) {
                    return true;
                }
                try {
                    textView.semSetActionModeMenuItemEnabled(menuid, value);
                    return true;
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("setSemSetActionModeMenuItemEnabled: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "ViewCompat");
                }
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setAutoHandwritingEnabled(@Nullable View view, boolean enabled) {
            if (Build.VERSION.SDK_INT <= 33 || view == null) {
                return;
            }
            view.setAutoHandwritingEnabled(enabled);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public boolean setPointerIcon(@Nullable View view, int toolType, @Nullable PointerIcon pointerIcon) {
            if (view == null) {
                return true;
            }
            try {
                view.semSetPointerIcon(toolType, pointerIcon);
                return true;
            } catch (NoSuchMethodError e) {
                AbstractC0000a.m23t("setPointerIcon: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "ViewCompat");
                return false;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setRoundedCornerColor(@Nullable View view, int color) {
            setRoundedCornerColor(view, 15, color);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setRoundedCorners(@Nullable View view, int corners, @NotNull Pair<Integer, Integer> offset) {
            Intrinsics.checkNotNullParameter(offset, "offset");
            if (view != null) {
                try {
                    view.semSetRoundedCorners(corners, offset);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("setRoundedCorners: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "ViewCompat");
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setSystemUiVisibility(@Nullable View decorView, int visibility) {
            if (decorView != null) {
                decorView.setSystemUiVisibility(visibility);
            }
            LoggerBase.INSTANCE.m7132d("ViewCompat", "setSystemUiVisibility visibility : " + (decorView != null ? Integer.valueOf(decorView.getSystemUiVisibility()) : null));
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setTooltipText(@NotNull View view, @Nullable CharSequence tooltipText) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.setTooltipText(tooltipText);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setRoundedCornerColor(@Nullable View view, int corners, int color) {
            if (view != null) {
                try {
                    view.semSetRoundedCornerColor(corners, color);
                } catch (NoSuchMethodError e) {
                    AbstractC0000a.m23t("setRoundedCornerColor: NoSuchMethodError] ", e.getMessage(), LoggerBase.INSTANCE, "ViewCompat");
                }
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setSystemUiVisibility(@Nullable View decorView, int flag, boolean disableRecent, boolean disableHome, boolean disableBack) {
            if (disableRecent) {
                flag |= 16777216;
            }
            if (disableHome) {
                flag |= 2097152;
            }
            if (disableBack) {
                flag |= 4194304;
            }
            if (decorView != null) {
                decorView.setSystemUiVisibility(flag);
            }
            LoggerBase.INSTANCE.m7132d("ViewCompat", "setSystemUiVisibility flag : " + (decorView != null ? Integer.valueOf(decorView.getSystemUiVisibility()) : null));
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.view.AbsViewCompatImplFactory
    @NotNull
    public AbsViewCompatImplFactory.IViewCompatImpl create(int deviceType) {
        return deviceType == 2 ? new ViewCompatSemImpl() : super.create(deviceType);
    }
}
