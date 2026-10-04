package com.samsung.android.sdk.pen.setting.common;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.drawable.ScaleDrawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.animation.LinearInterpolator;
import android.widget.SeekBar;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSliderAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0002;<B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\fJ-\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00122\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001f¢\u0006\u0002\u0010 J5\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u00122\u0010\u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u001f¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0018H\u0004J\b\u0010'\u001a\u00020\u0018H\u0004J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0012J\u000e\u0010*\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u0012J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\nH\u0002J\u000e\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020:R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation;", "", "<init>", "()V", "mThumbList", "", "Landroid/graphics/drawable/ScaleDrawable;", "mProgressList", "Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;", "mState", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation$AnimationState;", "mSeekBar", "Landroid/widget/SeekBar;", "mStartAnimator", "Landroid/animation/AnimatorSet;", "mEndAnimator", "mReadyState", "mProgressMinHeight", "", "mProgressMaxHeight", "mDefaultSliderHeight", "mThumbMinLevel", "mThumbMaxLevel", "close", "", "setAutoAnimation", "seekBar", "setThumbInformation", "minLevel", "maxLevel", "drawable", "", "(II[Landroid/graphics/drawable/ScaleDrawable;)V", "setProgressInformation", "defaultHeight", "minHeight", "maxHeight", "(III[Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;)V", "startAnimation", "endAnimation", "setProgress", "expectedHeight", "setThumbLevel", "level", "setState", "state", "mProgressUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "mThumbUpdateListener", "mAnimatorListener", "Landroid/animation/Animator$AnimatorListener;", "mTouchSlop", "mDownX", "", "mIsMoving", "", "setOnTouchEvent", "event", "Landroid/view/MotionEvent;", "Companion", "AnimationState", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSliderAnimation {
    private static final int PROGRESS_SCALE_DURATION = 250;

    @NotNull
    private static final String TAG = "SpenSliderAnimation";
    private static final int THUMB_SCALE_DOWN_DURATION = 100;
    private static final int THUMB_SCALE_UP_DURATION = 300;
    private int mDefaultSliderHeight;
    private float mDownX;

    @Nullable
    private AnimatorSet mEndAnimator;
    private boolean mIsMoving;
    private int mProgressMaxHeight;
    private int mProgressMinHeight;

    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mProgressUpdateListener;

    @Nullable
    private AnimationState mReadyState;

    @Nullable
    private SeekBar mSeekBar;

    @Nullable
    private AnimatorSet mStartAnimator;
    private int mThumbMaxLevel;
    private int mThumbMinLevel;

    @NotNull
    private final ValueAnimator.AnimatorUpdateListener mThumbUpdateListener;
    private int mTouchSlop;

    @NotNull
    private List<ScaleDrawable> mThumbList = new ArrayList();

    @NotNull
    private List<SpenInsetDrawable> mProgressList = new ArrayList();

    @NotNull
    private AnimationState mState = AnimationState.NORMAL;

    @NotNull
    private final Animator.AnimatorListener mAnimatorListener = new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSliderAnimation$mAnimatorListener$1
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenSliderAnimation", "onAnimationCancel() ");
            if (this.this$0.mStartAnimator != null && Intrinsics.areEqual(animation, this.this$0.mStartAnimator)) {
                this.this$0.setState(SpenSliderAnimation.AnimationState.NORMAL);
            } else if (this.this$0.mEndAnimator == null || !Intrinsics.areEqual(animation, this.this$0.mEndAnimator)) {
                Log.i("SpenSliderAnimation", "What is happened?");
            } else {
                this.this$0.setState(SpenSliderAnimation.AnimationState.EXPEND);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenSliderAnimation", "onAnimationEnd() ");
            if (this.this$0.mStartAnimator == null || !Intrinsics.areEqual(animation, this.this$0.mStartAnimator)) {
                if (this.this$0.mEndAnimator == null || !Intrinsics.areEqual(animation, this.this$0.mEndAnimator)) {
                    Log.i("SpenSliderAnimation", "What is happened?");
                    return;
                } else {
                    this.this$0.setState(SpenSliderAnimation.AnimationState.NORMAL);
                    return;
                }
            }
            this.this$0.setState(SpenSliderAnimation.AnimationState.EXPEND);
            if (this.this$0.mReadyState == null || this.this$0.mReadyState != SpenSliderAnimation.AnimationState.ENDING) {
                return;
            }
            this.this$0.mReadyState = null;
            this.this$0.endAnimation();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Log.i("SpenSliderAnimation", "onAnimationStart()");
            if (this.this$0.mStartAnimator != null && Intrinsics.areEqual(animation, this.this$0.mStartAnimator)) {
                this.this$0.setState(SpenSliderAnimation.AnimationState.STARTING);
            } else if (this.this$0.mEndAnimator == null || !Intrinsics.areEqual(animation, this.this$0.mEndAnimator)) {
                Log.i("SpenSliderAnimation", "What is happened?");
            } else {
                this.this$0.setState(SpenSliderAnimation.AnimationState.ENDING);
            }
        }
    };

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation$AnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "STARTING", "EXPEND", "ENDING", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AnimationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnimationState[] $VALUES;
        public static final AnimationState NORMAL = new NORMAL("NORMAL", 0);
        public static final AnimationState STARTING = new STARTING("STARTING", 1);
        public static final AnimationState EXPEND = new EXPEND("EXPEND", 2);
        public static final AnimationState ENDING = new ENDING("ENDING", 3);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/common/SpenSliderAnimation.AnimationState.ENDING", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation$AnimationState;", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class ENDING extends AnimationState {
            public ENDING(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            @NotNull
            public String toString() {
                return "ENDING";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/common/SpenSliderAnimation.AnimationState.EXPEND", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation$AnimationState;", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class EXPEND extends AnimationState {
            public EXPEND(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            @NotNull
            public String toString() {
                return "EXPEND";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/common/SpenSliderAnimation.AnimationState.NORMAL", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation$AnimationState;", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class NORMAL extends AnimationState {
            public NORMAL(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            @NotNull
            public String toString() {
                return "NORMAL";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m13886d2 = {"com/samsung/android/sdk/pen/setting/common/SpenSliderAnimation.AnimationState.STARTING", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation$AnimationState;", "toString", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
        public static final class STARTING extends AnimationState {
            public STARTING(String str, int i) {
                super(str, i, null);
            }

            @Override // java.lang.Enum
            @NotNull
            public String toString() {
                return "STARTING";
            }
        }

        private static final /* synthetic */ AnimationState[] $values() {
            return new AnimationState[]{NORMAL, STARTING, EXPEND, ENDING};
        }

        static {
            AnimationState[] animationStateArr$values = $values();
            $VALUES = animationStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(animationStateArr$values);
        }

        public /* synthetic */ AnimationState(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
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

        private AnimationState(String str, int i) {
        }
    }

    public SpenSliderAnimation() {
        final int i = 0;
        this.mProgressUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.common.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSliderAnimation f5039b;

            {
                this.f5039b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        SpenSliderAnimation.mProgressUpdateListener$lambda$0(this.f5039b, valueAnimator);
                        break;
                    default:
                        SpenSliderAnimation.mThumbUpdateListener$lambda$1(this.f5039b, valueAnimator);
                        break;
                }
            }
        };
        final int i2 = 1;
        this.mThumbUpdateListener = new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.sdk.pen.setting.common.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSliderAnimation f5039b;

            {
                this.f5039b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        SpenSliderAnimation.mProgressUpdateListener$lambda$0(this.f5039b, valueAnimator);
                        break;
                    default:
                        SpenSliderAnimation.mThumbUpdateListener$lambda$1(this.f5039b, valueAnimator);
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mProgressUpdateListener$lambda$0(SpenSliderAnimation spenSliderAnimation, ValueAnimator valueAnimator) {
        spenSliderAnimation.setProgress(((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mThumbUpdateListener$lambda$1(SpenSliderAnimation spenSliderAnimation, ValueAnimator valueAnimator) {
        spenSliderAnimation.setThumbLevel(((Integer) AbstractC6670b.m4742c(valueAnimator, "animation", "null cannot be cast to non-null type kotlin.Int")).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setState(AnimationState state) {
        Log.i(TAG, "setState() :: " + state);
        if (state == AnimationState.NORMAL) {
            setProgress(this.mProgressMinHeight);
            setThumbLevel(this.mThumbMaxLevel);
        } else if (state == AnimationState.EXPEND) {
            setProgress(this.mProgressMaxHeight);
            setThumbLevel(this.mThumbMinLevel);
        }
        this.mState = state;
    }

    public final void close() {
        AnimatorSet animatorSet;
        AnimatorSet animatorSet2;
        SeekBar seekBar = this.mSeekBar;
        if (seekBar != null) {
            seekBar.setOnTouchListener(null);
        }
        this.mSeekBar = null;
        AnimatorSet animatorSet3 = this.mStartAnimator;
        if (animatorSet3 != null && animatorSet3.isRunning() && (animatorSet2 = this.mStartAnimator) != null) {
            animatorSet2.cancel();
        }
        this.mStartAnimator = null;
        AnimatorSet animatorSet4 = this.mEndAnimator;
        if (animatorSet4 != null && animatorSet4.isRunning() && (animatorSet = this.mEndAnimator) != null) {
            animatorSet.cancel();
        }
        this.mEndAnimator = null;
        this.mThumbList.clear();
        this.mProgressList.clear();
        this.mState = AnimationState.NORMAL;
    }

    public final void endAnimation() {
        AnimatorSet animatorSet;
        if (this.mEndAnimator == null) {
            this.mEndAnimator = new AnimatorSet();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mProgressMaxHeight, this.mProgressMinHeight);
            valueAnimatorOfInt.addUpdateListener(this.mProgressUpdateListener);
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.setInterpolator(SpenSettingUtilAnimation.getInterpolator(4));
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(this.mThumbMinLevel, this.mThumbMaxLevel);
            valueAnimatorOfInt2.addUpdateListener(this.mThumbUpdateListener);
            valueAnimatorOfInt2.setDuration(300L);
            valueAnimatorOfInt2.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet2 = this.mEndAnimator;
            if (animatorSet2 != null) {
                animatorSet2.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2);
            }
            AnimatorSet animatorSet3 = this.mEndAnimator;
            if (animatorSet3 != null) {
                animatorSet3.addListener(this.mAnimatorListener);
            }
        }
        Log.i(TAG, "endAnimation() state=" + this.mState);
        if (this.mState == AnimationState.STARTING && (animatorSet = this.mStartAnimator) != null && animatorSet.isRunning()) {
            Log.i(TAG, "endAnimation() But startAnimation is running.... ");
            this.mReadyState = AnimationState.ENDING;
            AnimatorSet animatorSet4 = this.mStartAnimator;
            if (animatorSet4 != null) {
                animatorSet4.end();
                return;
            }
            return;
        }
        if (this.mState == AnimationState.EXPEND) {
            this.mState = AnimationState.ENDING;
            AnimatorSet animatorSet5 = this.mEndAnimator;
            if (animatorSet5 != null) {
                animatorSet5.start();
            }
        }
    }

    public final void setAutoAnimation(@Nullable SeekBar seekBar) {
        if (seekBar == null) {
            return;
        }
        this.mSeekBar = seekBar;
        seekBar.setBackground(null);
        this.mTouchSlop = ViewConfiguration.get(seekBar.getContext()).getScaledTouchSlop() / 2;
    }

    public final void setOnTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.mSeekBar == null) {
            return;
        }
        int action = event.getAction();
        if (action == 0) {
            this.mDownX = event.getX();
            this.mIsMoving = false;
            return;
        }
        if (action != 1) {
            if (action == 2) {
                if (this.mIsMoving || Math.abs(event.getX() - this.mDownX) <= this.mTouchSlop) {
                    return;
                }
                this.mIsMoving = true;
                Log.i(TAG, "[AUTO] startAnimation()");
                startAnimation();
                return;
            }
            if (action != 3) {
                return;
            }
        }
        if (this.mIsMoving) {
            Log.i(TAG, "[AUTO] endAnimation()");
            endAnimation();
            this.mIsMoving = false;
        }
    }

    public final void setProgress(int expectedHeight) {
        int iFloor;
        int i;
        AbstractC2322a.m1631u(expectedHeight, "setProgress() height=", TAG);
        if (this.mProgressList.size() == 0) {
            return;
        }
        int i2 = this.mDefaultSliderHeight - expectedHeight;
        if (i2 % 2 == 0) {
            iFloor = i2 / 2;
            i = iFloor;
        } else {
            iFloor = (int) Math.floor(i2 / 2.0f);
            i = iFloor + 1;
        }
        int i4 = this.mDefaultSliderHeight;
        int size = this.mProgressList.size();
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i4, iFloor, "setProgress() [", "] = TOP[", "], SIZE[");
        AbstractC2821a.m2235z(sbM1173s, expectedHeight, i, "], BOTTOM[", "] drawableSize=");
        AbstractC0000a.m26w(sbM1173s, TAG, size);
    }

    public final void setProgressInformation(int defaultHeight, int minHeight, int maxHeight, @Nullable SpenInsetDrawable[] drawable) {
        this.mDefaultSliderHeight = defaultHeight;
        this.mProgressMinHeight = minHeight;
        this.mProgressMaxHeight = maxHeight;
        this.mProgressList.clear();
        if (drawable == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(drawable);
        while (it.hasNext()) {
            SpenInsetDrawable spenInsetDrawable = (SpenInsetDrawable) it.next();
            if (spenInsetDrawable != null) {
                this.mProgressList.add(spenInsetDrawable);
            }
        }
    }

    public final void setThumbInformation(int minLevel, int maxLevel, @Nullable ScaleDrawable[] drawable) {
        this.mThumbMinLevel = minLevel;
        this.mThumbMaxLevel = maxLevel;
        this.mThumbList.clear();
        if (drawable == null) {
            return;
        }
        Iterator it = ArrayIteratorKt.iterator(drawable);
        while (it.hasNext()) {
            ScaleDrawable scaleDrawable = (ScaleDrawable) it.next();
            if (scaleDrawable != null) {
                this.mThumbList.add(scaleDrawable);
            }
        }
    }

    public final void setThumbLevel(int level) {
        AbstractC2322a.m1631u(level, "setThumbLevel() level=", TAG);
        if (this.mThumbList.size() == 0) {
            return;
        }
        Iterator<ScaleDrawable> it = this.mThumbList.iterator();
        while (it.hasNext()) {
            it.next().setLevel(level);
        }
    }

    public final void startAnimation() {
        AnimatorSet animatorSet;
        if (this.mStartAnimator == null) {
            this.mStartAnimator = new AnimatorSet();
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mProgressMinHeight, this.mProgressMaxHeight);
            valueAnimatorOfInt.addUpdateListener(this.mProgressUpdateListener);
            valueAnimatorOfInt.setDuration(250L);
            valueAnimatorOfInt.setInterpolator(SpenSettingUtilAnimation.getInterpolator(4));
            ValueAnimator valueAnimatorOfInt2 = ValueAnimator.ofInt(this.mThumbMaxLevel, this.mThumbMinLevel);
            valueAnimatorOfInt2.addUpdateListener(this.mThumbUpdateListener);
            valueAnimatorOfInt2.setDuration(100L);
            valueAnimatorOfInt2.setInterpolator(new LinearInterpolator());
            AnimatorSet animatorSet2 = this.mStartAnimator;
            if (animatorSet2 != null) {
                animatorSet2.playTogether(valueAnimatorOfInt, valueAnimatorOfInt2);
            }
            AnimatorSet animatorSet3 = this.mStartAnimator;
            if (animatorSet3 != null) {
                animatorSet3.addListener(this.mAnimatorListener);
            }
        }
        Log.i(TAG, "startAnimation() state=" + this.mState);
        if (this.mState != AnimationState.NORMAL || (animatorSet = this.mStartAnimator) == null) {
            return;
        }
        animatorSet.start();
    }
}
