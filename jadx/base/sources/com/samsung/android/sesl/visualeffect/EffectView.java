package com.samsung.android.sesl.visualeffect;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import com.samsung.android.sesl.visualeffect.utils.EffectFrameRateHelper;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\b&\u0018\u0000 ,2\u00020\u0001:\u0003,-.B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0018H\u0002J\b\u0010(\u001a\u00020%H$J\b\u0010)\u001a\u00020%H\u0017J\b\u0010*\u001a\u00020%H\u0017J\b\u0010+\u001a\u00020%H&R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0000@\u0000X\u0081\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\n\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010'\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/EffectView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/samsung/android/sesl/visualeffect/EffectView$FrameRateCategory;", "frameRatePolicy", "getFrameRatePolicy", "()Lcom/samsung/android/sesl/visualeffect/EffectView$FrameRateCategory;", "setFrameRatePolicy", "(Lcom/samsung/android/sesl/visualeffect/EffectView$FrameRateCategory;)V", "requestedEffectFrameRate", "", "getRequestedEffectFrameRate$sesl_visualeffect_INTERNAL_2_1_10_release", "()Ljava/lang/Float;", "setRequestedEffectFrameRate$sesl_visualeffect_INTERNAL_2_1_10_release", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "Lcom/samsung/android/sesl/visualeffect/EffectView$AnimationState;", "animationState", "getAnimationState", "()Lcom/samsung/android/sesl/visualeffect/EffectView$AnimationState;", "setAnimationState", "(Lcom/samsung/android/sesl/visualeffect/EffectView$AnimationState;)V", XmlErrorCodes.DURATION, "", "getDuration", "()J", "setDuration", "(J)V", "updateEffectFrameRateByState", "", "state", "initialFrameRate", "initView", "startAnimation", "cancelAnimation", "reset", "Companion", "AnimationState", "FrameRateCategory", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class EffectView extends LinearLayout {

    @NotNull
    public static final String TAG = "EffectView";

    @NotNull
    private AnimationState animationState;
    private long duration;

    @NotNull
    private FrameRateCategory frameRatePolicy;
    private final float initialFrameRate;

    @FloatRange(from = 1.0d, m705to = 120.0d)
    @Nullable
    private Float requestedEffectFrameRate;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/EffectView$AnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "READY", DebugCoroutineInfoImplKt.RUNNING, "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AnimationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationState[] $VALUES;
        public static final AnimationState READY = new AnimationState("READY", 0);
        public static final AnimationState RUNNING = new AnimationState(DebugCoroutineInfoImplKt.RUNNING, 1);

        private static final /* synthetic */ AnimationState[] $values() {
            return new AnimationState[]{READY, RUNNING};
        }

        static {
            AnimationState[] animationStateArr$values = $values();
            $VALUES = animationStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(animationStateArr$values);
        }

        private AnimationState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<AnimationState> getEntries() {
            return $ENTRIES;
        }

        public static AnimationState valueOf(String str) {
            return (AnimationState) Enum.valueOf(AnimationState.class, str);
        }

        public static AnimationState[] values() {
            return (AnimationState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/EffectView$FrameRateCategory;", "", "<init>", "(Ljava/lang/String;I)V", "LOW", "NORMAL", "HIGH", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class FrameRateCategory {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FrameRateCategory[] $VALUES;
        public static final FrameRateCategory LOW = new FrameRateCategory("LOW", 0);
        public static final FrameRateCategory NORMAL = new FrameRateCategory("NORMAL", 1);
        public static final FrameRateCategory HIGH = new FrameRateCategory("HIGH", 2);

        private static final /* synthetic */ FrameRateCategory[] $values() {
            return new FrameRateCategory[]{LOW, NORMAL, HIGH};
        }

        static {
            FrameRateCategory[] frameRateCategoryArr$values = $values();
            $VALUES = frameRateCategoryArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(frameRateCategoryArr$values);
        }

        private FrameRateCategory(String str, int i) {
        }

        @NotNull
        public static EnumEntries<FrameRateCategory> getEntries() {
            return $ENTRIES;
        }

        public static FrameRateCategory valueOf(String str) {
            return (FrameRateCategory) Enum.valueOf(FrameRateCategory.class, str);
        }

        public static FrameRateCategory[] values() {
            return (FrameRateCategory[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FrameRateCategory.values().length];
            try {
                iArr[FrameRateCategory.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FrameRateCategory.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FrameRateCategory.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AnimationState.values().length];
            try {
                iArr2[AnimationState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[AnimationState.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public /* synthetic */ EffectView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void setAnimationState(AnimationState animationState) {
        this.animationState = animationState;
        if (Build.VERSION.SDK_INT >= 35) {
            updateEffectFrameRateByState(animationState);
        }
    }

    private final void updateEffectFrameRateByState(AnimationState state) {
        Float f = this.requestedEffectFrameRate;
        if (f != null) {
            float fFloatValue = f.floatValue();
            if (!EffectFrameRateHelper.INSTANCE.isViewFrameRateUpdateAvailable() || Build.VERSION.SDK_INT < 35) {
                return;
            }
            int i = WhenMappings.$EnumSwitchMapping$1[state.ordinal()];
            if (i == 1) {
                fFloatValue = this.initialFrameRate;
            } else if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            setRequestedFrameRate(fFloatValue);
        }
    }

    @CallSuper
    public void cancelAnimation() {
        Log.d(TAG, "cancelAnimation");
        reset();
        setAnimationState(AnimationState.READY);
    }

    @NotNull
    public final AnimationState getAnimationState() {
        return this.animationState;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final FrameRateCategory getFrameRatePolicy() {
        return this.frameRatePolicy;
    }

    @Nullable
    /* JADX INFO: renamed from: getRequestedEffectFrameRate$sesl_visualeffect_INTERNAL_2_1_10_release, reason: from getter */
    public final Float getRequestedEffectFrameRate() {
        return this.requestedEffectFrameRate;
    }

    public abstract void initView();

    public abstract void reset();

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final void setFrameRatePolicy(@NotNull FrameRateCategory value) {
        Float fValueOf;
        Intrinsics.checkNotNullParameter(value, "value");
        this.frameRatePolicy = value;
        int i = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
        if (i == 1) {
            fValueOf = Float.valueOf(30.0f);
        } else if (i == 2) {
            fValueOf = Float.valueOf(60.0f);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            fValueOf = null;
        }
        this.requestedEffectFrameRate = fValueOf;
    }

    /* JADX INFO: renamed from: setRequestedEffectFrameRate$sesl_visualeffect_INTERNAL_2_1_10_release */
    public final void m6546x4c213c76(@Nullable Float f) {
        this.requestedEffectFrameRate = f;
    }

    @CallSuper
    public void startAnimation() {
        Log.d(TAG, "startAnimation");
        setAnimationState(AnimationState.RUNNING);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EffectView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.frameRatePolicy = FrameRateCategory.NORMAL;
        this.requestedEffectFrameRate = Float.valueOf(60.0f);
        this.animationState = AnimationState.READY;
        this.initialFrameRate = Build.VERSION.SDK_INT >= 35 ? getRequestedFrameRate() : 60.0f;
    }
}
