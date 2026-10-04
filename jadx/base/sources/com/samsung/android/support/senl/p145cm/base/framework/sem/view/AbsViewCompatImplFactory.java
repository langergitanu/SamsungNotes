package com.samsung.android.support.senl.p145cm.base.framework.sem.view;

import android.animation.StateListAnimator;
import android.content.ClipData;
import android.content.Context;
import android.util.Pair;
import android.view.PointerIcon;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p145cm.base.framework.view.SemBlurInfoCompat;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0003\b\t\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IViewCompatImpl", "AbsViewCompatImpl", "ViewCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public abstract class AbsViewCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$AbsViewCompatImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl;", "<init>", "()V", "startDragAndDrop", "", "view", "Landroid/view/View;", "data", "Landroid/content/ClipData;", "shadowBuilder", "Landroid/view/View$DragShadowBuilder;", "myLocalState", "", "flags", "", "cancelDragAndDrop", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static abstract class AbsViewCompatImpl implements IViewCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void cancelDragAndDrop(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.cancelDragAndDrop();
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public boolean startDragAndDrop(@NotNull View view, @Nullable ClipData data, @Nullable View.DragShadowBuilder shadowBuilder, @Nullable Object myLocalState, int flags) {
            Intrinsics.checkNotNullParameter(view, "view");
            return view.startDragAndDrop(data, shadowBuilder, myLocalState, flags);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 A2\u00020\u0001:\u0001AJ6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J\"\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0003H&J\u001a\u0010#\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%H&J\u001a\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010(\u001a\u00020\fH&J2\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0006\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003H&J\u001a\u0010-\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010.\u001a\u00020\fH&J\u0012\u0010/\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u00100\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00101\u001a\u00020\fH&J\"\u00100\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\f2\u0006\u00101\u001a\u00020\fH&J.\u00103\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u00020\f2\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f05H&J\u001a\u00106\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020\u0003H&J\u001a\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\fH&J\u001a\u0010=\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010?H&J\u0010\u0010@\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H&R\u0012\u0010\u0013\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0012\u0010\u0018\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0012\u0010\u001a\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0012\u0010\u001c\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl;", "", "startDragAndDrop", "", "view", "Landroid/view/View;", "data", "Landroid/content/ClipData;", "shadowBuilder", "Landroid/view/View$DragShadowBuilder;", "myLocalState", "flags", "", "cancelDragAndDrop", "", "setPointerIcon", "toolType", "pointerIcon", "Landroid/view/PointerIcon;", "hoveringSpenIconDefault", "getHoveringSpenIconDefault", "()I", "stylusScrollUpType", "getStylusScrollUpType", "stylusScrollDownType", "getStylusScrollDownType", "stylusScrollLeftType", "getStylusScrollLeftType", "stylusScrollRightType", "getStylusScrollRightType", "setActionModeMenuItemEnabled", "textView", "Landroid/widget/TextView;", "menuid", "value", "setTooltipText", "tooltipText", "", "setSystemUiVisibility", "decorView", "visibility", "flag", "disableRecent", "disableHome", "disableBack", "performHapticFeedback", "feedbackConstant", "requestAccessibilityFocus", "setRoundedCornerColor", "color", "corners", "setRoundedCorners", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/util/Pair;", "setAutoHandwritingEnabled", "enabled", "getRecoilStateListAnimator", "Landroid/animation/StateListAnimator;", "context", "Landroid/content/Context;", "type", "semSetBlurInfo", "blurInfoCompatBuilder", "Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$Builder;", "semClearUiDescriptors", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IViewCompatImpl {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int HAPTIC_INDEX_DRAG_DROP_EFFECT_TICK = 41;
        public static final int HAPTIC_INDEX_DRAG_DROP_FLOATING = 110;
        public static final int HAPTIC_INDEX_DRAG_DROP_START = 108;
        public static final int HAPTIC_INDEX_LONG_PRESS = 1;
        public static final int HAPTIC_INDEX_ONLY_FOR_DC = 100;
        public static final int HAPTIC_INDEX_SHUTTER_PRESS = 37;
        public static final int HAPTIC_INDEX_SHUTTER_RELEASE = 48;
        public static final int RECOIL_LARGE_TOUCH_ANIMATOR = 2;
        public static final int RECOIL_MEDIUM_TOUCH_ANIMATOR = 1;
        public static final int RECOIL_SMALL_TOUCH_ANIMATOR = 0;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$IViewCompatImpl$Companion;", "", "<init>", "()V", "HAPTIC_INDEX_ONLY_FOR_DC", "", "HAPTIC_INDEX_DRAG_DROP_START", "HAPTIC_INDEX_DRAG_DROP_FLOATING", "HAPTIC_INDEX_DRAG_DROP_EFFECT_TICK", "HAPTIC_INDEX_SHUTTER_PRESS", "HAPTIC_INDEX_SHUTTER_RELEASE", "HAPTIC_INDEX_LONG_PRESS", "RECOIL_SMALL_TOUCH_ANIMATOR", "RECOIL_MEDIUM_TOUCH_ANIMATOR", "RECOIL_LARGE_TOUCH_ANIMATOR", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int HAPTIC_INDEX_DRAG_DROP_EFFECT_TICK = 41;
            public static final int HAPTIC_INDEX_DRAG_DROP_FLOATING = 110;
            public static final int HAPTIC_INDEX_DRAG_DROP_START = 108;
            public static final int HAPTIC_INDEX_LONG_PRESS = 1;
            public static final int HAPTIC_INDEX_ONLY_FOR_DC = 100;
            public static final int HAPTIC_INDEX_SHUTTER_PRESS = 37;
            public static final int HAPTIC_INDEX_SHUTTER_RELEASE = 48;
            public static final int RECOIL_LARGE_TOUCH_ANIMATOR = 2;
            public static final int RECOIL_MEDIUM_TOUCH_ANIMATOR = 1;
            public static final int RECOIL_SMALL_TOUCH_ANIMATOR = 0;

            private Companion() {
            }
        }

        void cancelDragAndDrop(@NotNull View view);

        int getHoveringSpenIconDefault();

        @Nullable
        StateListAnimator getRecoilStateListAnimator(@NotNull Context context, int type);

        int getStylusScrollDownType();

        int getStylusScrollLeftType();

        int getStylusScrollRightType();

        int getStylusScrollUpType();

        void performHapticFeedback(@Nullable View view, int feedbackConstant);

        void requestAccessibilityFocus(@Nullable View view);

        void semClearUiDescriptors(@NotNull View view);

        void semSetBlurInfo(@NotNull View view, @Nullable SemBlurInfoCompat.Builder blurInfoCompatBuilder);

        boolean setActionModeMenuItemEnabled(@Nullable TextView textView, int menuid, boolean value);

        void setAutoHandwritingEnabled(@Nullable View view, boolean enabled);

        boolean setPointerIcon(@Nullable View view, int toolType, @Nullable PointerIcon pointerIcon);

        void setRoundedCornerColor(@Nullable View view, int color);

        void setRoundedCornerColor(@Nullable View view, int corners, int color);

        void setRoundedCorners(@Nullable View view, int corners, @NotNull Pair<Integer, Integer> offset);

        void setSystemUiVisibility(@Nullable View decorView, int visibility);

        void setSystemUiVisibility(@Nullable View decorView, int flag, boolean disableRecent, boolean disableHome, boolean disableBack);

        void setTooltipText(@NotNull View view, @Nullable CharSequence tooltipText);

        boolean startDragAndDrop(@NotNull View view, @Nullable ClipData data, @Nullable View.DragShadowBuilder shadowBuilder, @Nullable Object myLocalState, int flags);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020\tH\u0016J2\u0010 \u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u00072\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\u001a\u0010'\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010(\u001a\u00020\tH\u0016J\u0012\u0010)\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010*\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010+\u001a\u00020\tH\u0016J\"\u0010*\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0016J.\u0010-\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020\t2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0/H\u0016J\u001a\u00100\u001a\u00020\u001d2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u00101\u001a\u00020\u0005H\u0016J\u001a\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\tH\u0016J\u001a\u00107\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010:\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000e¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$ViewCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/view/AbsViewCompatImplFactory$AbsViewCompatImpl;", "<init>", "()V", "setPointerIcon", "", "view", "Landroid/view/View;", "toolType", "", "pointerIcon", "Landroid/view/PointerIcon;", "hoveringSpenIconDefault", "getHoveringSpenIconDefault", "()I", "stylusScrollUpType", "getStylusScrollUpType", "stylusScrollDownType", "getStylusScrollDownType", "stylusScrollLeftType", "getStylusScrollLeftType", "stylusScrollRightType", "getStylusScrollRightType", "setActionModeMenuItemEnabled", "textView", "Landroid/widget/TextView;", "menuid", "value", "setTooltipText", "", "tooltipText", "", "setSystemUiVisibility", "decorView", "visibility", "flag", "disableRecent", "disableHome", "disableBack", "performHapticFeedback", "feedbackConstant", "requestAccessibilityFocus", "setRoundedCornerColor", "color", "corners", "setRoundedCorners", TypedValues.Cycle.S_WAVE_OFFSET, "Landroid/util/Pair;", "setAutoHandwritingEnabled", "enabled", "getRecoilStateListAnimator", "Landroid/animation/StateListAnimator;", "context", "Landroid/content/Context;", "type", "semSetBlurInfo", "blurInfoCompatBuilder", "Lcom/samsung/android/support/senl/cm/base/framework/view/SemBlurInfoCompat$Builder;", "semClearUiDescriptors", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static class ViewCompatPureImpl extends AbsViewCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getHoveringSpenIconDefault() {
            return 1;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        @Nullable
        public StateListAnimator getRecoilStateListAnimator(@NotNull Context context, int type) {
            Intrinsics.checkNotNullParameter(context, "context");
            return null;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollDownType() {
            return 15;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollLeftType() {
            return 17;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollRightType() {
            return 13;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public int getStylusScrollUpType() {
            return 11;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void performHapticFeedback(@Nullable View view, int feedbackConstant) {
            if (view != null) {
                view.performHapticFeedback(0);
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void requestAccessibilityFocus(@Nullable View view) {
            LoggerBase.INSTANCE.m7132d("ViewCompat", "requestAccessibilityFocus");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void semClearUiDescriptors(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void semSetBlurInfo(@NotNull View view, @Nullable SemBlurInfoCompat.Builder blurInfoCompatBuilder) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public boolean setActionModeMenuItemEnabled(@Nullable TextView textView, int menuid, boolean value) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public boolean setPointerIcon(@Nullable View view, int toolType, @Nullable PointerIcon pointerIcon) {
            return false;
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setRoundedCornerColor(@Nullable View view, int color) {
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setRoundedCorners(@Nullable View view, int corners, @NotNull Pair<Integer, Integer> offset) {
            Intrinsics.checkNotNullParameter(offset, "offset");
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
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setSystemUiVisibility(@Nullable View decorView, int flag, boolean disableRecent, boolean disableHome, boolean disableBack) {
            setSystemUiVisibility(decorView, flag);
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsViewCompatImplFactory.IViewCompatImpl
        public void setAutoHandwritingEnabled(@Nullable View view, boolean enabled) {
        }
    }

    @NotNull
    public IViewCompatImpl create(int deviceType) {
        return new ViewCompatPureImpl();
    }
}
