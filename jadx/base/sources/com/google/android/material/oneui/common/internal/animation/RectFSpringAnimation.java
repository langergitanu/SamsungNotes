package com.google.android.material.oneui.common.internal.animation;

import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.carousel.RunnableC4617a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 32\u00020\u0001:\u00013B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010 \u001a\u00020\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\"\u001a\u00020\r2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u001a\u0010$\u001a\u00020\r2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u001fJ\u000e\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u0003J\b\u0010(\u001a\u00020\rH\u0016J\b\u0010)\u001a\u00020\u0012H\u0002J\b\u0010*\u001a\u00020\u0012H\u0016J\b\u0010+\u001a\u00020\rH\u0002J\b\u0010#\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u0003H\u0002J\u001f\u0010.\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00101J\b\u00102\u001a\u00020\rH\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\n\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u000e*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u000e*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000RJ\u0010\u001d\u001a>\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u000e*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f \u000e*\u001e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r \u000e*\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\f\u0018\u00010\b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u001f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/google/android/material/oneui/common/internal/animation/RectFSpringAnimation;", "Lcom/google/android/material/oneui/common/internal/animation/BaseAnimation;", "rectF", "Landroid/graphics/RectF;", "ratio", "", "(Landroid/graphics/RectF;F)V", "childrenAnim", "", "Landroidx/dynamicanimation/animation/SpringAnimation;", "endListeners", "", "Lkotlin/Function0;", "", "kotlin.jvm.PlatformType", "handler", "Landroid/os/Handler;", "isUpdatePosted", "", "()Z", "setUpdatePosted", "(Z)V", "pendingRectF", "getRatio", "()F", "rectBottomAnim", "rectLeftAnim", "rectRightAnim", "rectTopAnim", "startListeners", "updateListeners", "Lkotlin/Function1;", "addEndListener", "onEnd", "addStartListener", "onStart", "addUpdateListener", "function", "animateToFinalPosition", "finalPosition", "cancel", "isEnded", "isRunning", "maybeEnd", "onUpdate", "newRectF", "setSpringForce", "dampingRatio", "stiffness", "(Ljava/lang/Float;Ljava/lang/Float;)V", "skipToEnd", "Companion", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nRectFSpringAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RectFSpringAnimation.kt\ncom/google/android/material/oneui/common/internal/animation/RectFSpringAnimation\n+ 2 SpringAnimationHelper.kt\ncom/google/android/material/oneui/common/internal/animation/SpringAnimationHelperKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,152:1\n34#2,22:153\n34#2,22:175\n34#2,22:197\n34#2,22:219\n1855#3,2:241\n1747#3,3:243\n1726#3,3:246\n1855#3,2:249\n1855#3,2:251\n1855#3:253\n1856#3:255\n1855#3,2:256\n1855#3,2:258\n1#4:254\n*S KotlinDebug\n*F\n+ 1 RectFSpringAnimation.kt\ncom/google/android/material/oneui/common/internal/animation/RectFSpringAnimation\n*L\n31#1:153,22\n40#1:175,22\n49#1:197,22\n59#1:219,22\n106#1:241,2\n115#1:243,3\n119#1:246,3\n124#1:249,2\n130#1:251,2\n136#1:253\n136#1:255\n146#1:256,2\n84#1:258,2\n*E\n"})
public final class RectFSpringAnimation implements BaseAnimation {

    @NotNull
    public static final String TAG = "RectFAnimation";

    @NotNull
    private final List<SpringAnimation> childrenAnim;
    private final List<Function0<Unit>> endListeners;

    @NotNull
    private final Handler handler;
    private boolean isUpdatePosted;

    @NotNull
    private final RectF pendingRectF;
    private final float ratio;

    @NotNull
    private final SpringAnimation rectBottomAnim;

    @NotNull
    private final SpringAnimation rectLeftAnim;

    @NotNull
    private final SpringAnimation rectRightAnim;

    @NotNull
    private final SpringAnimation rectTopAnim;
    private final List<Function0<Unit>> startListeners;

    @NotNull
    private final List<Function1<RectF, Unit>> updateListeners;

    public RectFSpringAnimation(@NotNull RectF rectF, float f) {
        Intrinsics.checkNotNullParameter(rectF, "rectF");
        this.ratio = f;
        this.pendingRectF = new RectF();
        final String str = "rectLeft";
        SpringAnimation springAnimation = new SpringAnimation(rectF, new FloatPropertyCompat<RectF>(str, this, this, this) { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$1
            final /* synthetic */ RectFSpringAnimation $receiver$inlined;
            final /* synthetic */ RectFSpringAnimation this$0;

            {
                this.$receiver$inlined = this;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(RectF newValue) {
                return this.this$0.getRatio() * newValue.left;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(RectF newValue, float value) {
                RectF rectF2 = newValue;
                rectF2.left = value / this.this$0.getRatio();
                this.$receiver$inlined.onUpdate(rectF2);
            }
        });
        SpringForce springForce = new SpringForce(getRatio() * rectF.left);
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(1500.0f);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$2
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f4, float f5) {
                this.$receiver$inlined.maybeEnd();
            }
        });
        this.rectLeftAnim = springAnimation;
        final String str2 = "rectTop";
        SpringAnimation springAnimation2 = new SpringAnimation(rectF, new FloatPropertyCompat<RectF>(str2, this, this, this) { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$3
            final /* synthetic */ RectFSpringAnimation $receiver$inlined;
            final /* synthetic */ RectFSpringAnimation this$0;

            {
                this.$receiver$inlined = this;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(RectF newValue) {
                return this.this$0.getRatio() * newValue.top;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(RectF newValue, float value) {
                RectF rectF2 = newValue;
                rectF2.top = value / this.this$0.getRatio();
                this.$receiver$inlined.onUpdate(rectF2);
            }
        });
        SpringForce springForce2 = new SpringForce(getRatio() * rectF.top);
        springForce2.setDampingRatio(1.0f);
        springForce2.setStiffness(1500.0f);
        springAnimation2.setSpring(springForce2);
        springAnimation2.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$4
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f4, float f5) {
                this.$receiver$inlined.maybeEnd();
            }
        });
        this.rectTopAnim = springAnimation2;
        final String str3 = "rectRight";
        SpringAnimation springAnimation3 = new SpringAnimation(rectF, new FloatPropertyCompat<RectF>(str3, this, this, this) { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$5
            final /* synthetic */ RectFSpringAnimation $receiver$inlined;
            final /* synthetic */ RectFSpringAnimation this$0;

            {
                this.$receiver$inlined = this;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(RectF newValue) {
                return this.this$0.getRatio() * newValue.right;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(RectF newValue, float value) {
                RectF rectF2 = newValue;
                rectF2.right = value / this.this$0.getRatio();
                this.$receiver$inlined.onUpdate(rectF2);
            }
        });
        SpringForce springForce3 = new SpringForce(getRatio() * rectF.right);
        springForce3.setDampingRatio(1.0f);
        springForce3.setStiffness(1500.0f);
        springAnimation3.setSpring(springForce3);
        springAnimation3.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$6
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f4, float f5) {
                this.$receiver$inlined.maybeEnd();
            }
        });
        this.rectRightAnim = springAnimation3;
        final String str4 = "rectBottom";
        SpringAnimation springAnimation4 = new SpringAnimation(rectF, new FloatPropertyCompat<RectF>(str4, this, this, this) { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$7
            final /* synthetic */ RectFSpringAnimation $receiver$inlined;
            final /* synthetic */ RectFSpringAnimation this$0;

            {
                this.$receiver$inlined = this;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(RectF newValue) {
                return this.this$0.getRatio() * newValue.bottom;
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(RectF newValue, float value) {
                RectF rectF2 = newValue;
                rectF2.bottom = value / this.this$0.getRatio();
                this.$receiver$inlined.onUpdate(rectF2);
            }
        });
        SpringForce springForce4 = new SpringForce(getRatio() * rectF.bottom);
        springForce4.setDampingRatio(1.0f);
        springForce4.setStiffness(1500.0f);
        springAnimation4.setSpring(springForce4);
        springAnimation4.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.common.internal.animation.RectFSpringAnimation$special$$inlined$springAnimation$8
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f4, float f5) {
                this.$receiver$inlined.maybeEnd();
            }
        });
        this.rectBottomAnim = springAnimation4;
        this.childrenAnim = CollectionsKt.listOf((Object[]) new SpringAnimation[]{springAnimation, springAnimation2, springAnimation3, springAnimation4});
        this.updateListeners = new ArrayList();
        this.handler = new Handler(Looper.getMainLooper());
        this.startListeners = Collections.synchronizedList(new ArrayList());
        this.endListeners = Collections.synchronizedList(new ArrayList());
    }

    private final boolean isEnded() {
        List<SpringAnimation> list = this.childrenAnim;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((SpringAnimation) it.next()).isRunning()) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeEnd() {
        if (isEnded()) {
            List<Function0<Unit>> endListeners = this.endListeners;
            Intrinsics.checkNotNullExpressionValue(endListeners, "endListeners");
            Iterator<T> it = endListeners.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
    }

    private final void onStart() {
        List<Function0<Unit>> startListeners = this.startListeners;
        Intrinsics.checkNotNullExpressionValue(startListeners, "startListeners");
        Iterator<T> it = startListeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUpdate(RectF newRectF) {
        this.pendingRectF.set(newRectF);
        if (this.isUpdatePosted) {
            return;
        }
        this.isUpdatePosted = true;
        this.handler.post(new RunnableC4617a(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onUpdate$lambda$16(RectFSpringAnimation this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.updateListeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(this$0.pendingRectF);
        }
        this$0.isUpdatePosted = false;
    }

    public final void addEndListener(@NotNull Function0<Unit> onEnd) {
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        this.endListeners.add(onEnd);
    }

    public final void addStartListener(@NotNull Function0<Unit> onStart) {
        Intrinsics.checkNotNullParameter(onStart, "onStart");
        this.startListeners.add(onStart);
    }

    public final void addUpdateListener(@NotNull Function1<? super RectF, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.updateListeners.add(function);
    }

    public final void animateToFinalPosition(@NotNull RectF finalPosition) {
        Intrinsics.checkNotNullParameter(finalPosition, "finalPosition");
        Log.d(TAG, "animateToFinalPosition " + finalPosition);
        onStart();
        this.rectLeftAnim.animateToFinalPosition(finalPosition.left * this.ratio);
        this.rectTopAnim.animateToFinalPosition(finalPosition.top * this.ratio);
        this.rectRightAnim.animateToFinalPosition(finalPosition.right * this.ratio);
        this.rectBottomAnim.animateToFinalPosition(finalPosition.bottom * this.ratio);
    }

    @Override // com.google.android.material.oneui.common.internal.animation.BaseAnimation
    public void cancel() {
        Iterator<T> it = this.childrenAnim.iterator();
        while (it.hasNext()) {
            ((SpringAnimation) it.next()).cancel();
        }
    }

    public final float getRatio() {
        return this.ratio;
    }

    @Override // com.google.android.material.oneui.common.internal.animation.BaseAnimation
    public boolean isRunning() {
        List<SpringAnimation> list = this.childrenAnim;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((SpringAnimation) it.next()).isRunning()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isUpdatePosted, reason: from getter */
    public final boolean getIsUpdatePosted() {
        return this.isUpdatePosted;
    }

    public final void setSpringForce(@Nullable Float dampingRatio, @Nullable Float stiffness) {
        for (SpringAnimation springAnimation : this.childrenAnim) {
            Log.d(TAG, "setSpringForce " + springAnimation.isRunning() + ' ' + dampingRatio + ' ' + stiffness);
            SpringForce spring = springAnimation.getSpring();
            if (stiffness != null) {
                spring.setStiffness(stiffness.floatValue());
            }
            if (dampingRatio != null) {
                spring.setDampingRatio(dampingRatio.floatValue());
            }
        }
    }

    public final void setUpdatePosted(boolean z) {
        this.isUpdatePosted = z;
    }

    @Override // com.google.android.material.oneui.common.internal.animation.BaseAnimation
    public void skipToEnd() {
        Log.d(TAG, "skipToEnd");
        Iterator<T> it = this.childrenAnim.iterator();
        while (it.hasNext()) {
            ((SpringAnimation) it.next()).skipToEnd();
        }
    }

    public /* synthetic */ RectFSpringAnimation(RectF rectF, float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(rectF, (i & 2) != 0 ? 1.0f : f);
    }
}
