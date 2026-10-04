package com.google.android.material.oneui.common.internal.animation;

import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.oneui.common.internal.log.LogTagHelperKt;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.oneui.floatingdock.FloatingDockLogTag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0014\u001a\u00020\u00132\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u0012J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u001f\u0010\u001b\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/google/android/material/oneui/common/internal/animation/ScaleSpringAnimation;", "Lcom/google/android/material/oneui/floatingdock/FloatingDockLogTag;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "animations", "", "Landroidx/dynamicanimation/animation/SpringAnimation;", "logTag", "", "getLogTag", "()Ljava/lang/String;", "ratio", "", "scaleXAnimation", "scaleYAnimation", "updateListeners", "", "Lkotlin/Function2;", "", "addUpdateListener", "function", "animateToFinalPosition", "scaleX", "scaleY", "isRunning", "", "setSpringForce", "dampingRatio", "stiffness", "(Ljava/lang/Float;Ljava/lang/Float;)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nScaleSpringAnimation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScaleSpringAnimation.kt\ncom/google/android/material/oneui/common/internal/animation/ScaleSpringAnimation\n+ 2 SpringAnimationHelper.kt\ncom/google/android/material/oneui/common/internal/animation/SpringAnimationHelperKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n27#2,29:71\n27#2,29:100\n1747#3,3:129\n1855#3:132\n1856#3:134\n1#4:133\n*S KotlinDebug\n*F\n+ 1 ScaleSpringAnimation.kt\ncom/google/android/material/oneui/common/internal/animation/ScaleSpringAnimation\n*L\n31#1:71,29\n36#1:100,29\n50#1:129,3\n61#1:132\n61#1:134\n*E\n"})
public final class ScaleSpringAnimation implements FloatingDockLogTag {

    @NotNull
    private final List<SpringAnimation> animations;

    @NotNull
    private final String logTag;
    private final float ratio;

    @NotNull
    private final SpringAnimation scaleXAnimation;

    @NotNull
    private final SpringAnimation scaleYAnimation;

    @NotNull
    private final List<Function2<Float, Float, Unit>> updateListeners;

    public ScaleSpringAnimation(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.logTag = "ScaleSpringAnimation";
        this.ratio = 1000.0f;
        final String str = "scaleX";
        SpringAnimation springAnimation = new SpringAnimation(view, new FloatPropertyCompat<View>(str, this, this) { // from class: com.google.android.material.oneui.common.internal.animation.ScaleSpringAnimation$special$$inlined$springAnimation$default$1
            final /* synthetic */ ScaleSpringAnimation this$0;

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(View newValue) {
                return this.this$0.ratio * newValue.getScaleX();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(View newValue, float value) {
                newValue.setScaleX(value / this.this$0.ratio);
            }
        });
        SpringForce springForce = new SpringForce(this.ratio * view.getScaleX());
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(1500.0f);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.common.internal.animation.ScaleSpringAnimation$special$$inlined$springAnimation$default$2
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
            }
        });
        this.scaleXAnimation = springAnimation;
        final String str2 = "scaleY";
        SpringAnimation springAnimation2 = new SpringAnimation(view, new FloatPropertyCompat<View>(str2, this, this) { // from class: com.google.android.material.oneui.common.internal.animation.ScaleSpringAnimation$special$$inlined$springAnimation$default$3
            final /* synthetic */ ScaleSpringAnimation this$0;

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(View newValue) {
                return this.this$0.ratio * newValue.getScaleY();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(View newValue, float value) {
                newValue.setScaleY(value / this.this$0.ratio);
            }
        });
        SpringForce springForce2 = new SpringForce(this.ratio * view.getScaleY());
        springForce2.setDampingRatio(1.0f);
        springForce2.setStiffness(1500.0f);
        springAnimation2.setSpring(springForce2);
        springAnimation2.addEndListener(new DynamicAnimation.OnAnimationEndListener() { // from class: com.google.android.material.oneui.common.internal.animation.ScaleSpringAnimation$special$$inlined$springAnimation$default$4
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
            public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
            }
        });
        this.scaleYAnimation = springAnimation2;
        this.animations = CollectionsKt.listOf((Object[]) new SpringAnimation[]{springAnimation, springAnimation2});
        this.updateListeners = new ArrayList();
    }

    public final void addUpdateListener(@NotNull Function2<? super Float, ? super Float, Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.updateListeners.add(function);
    }

    public final void animateToFinalPosition(float scaleX, float scaleY) {
        LogTagHelperKt.debug(this, "animateToFinalPosition scaleX=" + scaleX + ", scaleY=" + scaleY);
        this.scaleXAnimation.animateToFinalPosition(scaleX * this.ratio);
        this.scaleYAnimation.animateToFinalPosition(scaleY * this.ratio);
    }

    @Override // androidx.core.oneui.common.internal.log.LogTag
    @NotNull
    public String getLogTag() {
        return this.logTag;
    }

    public final boolean isRunning() {
        List<SpringAnimation> list = this.animations;
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

    public final void setSpringForce(@Nullable Float dampingRatio, @Nullable Float stiffness) {
        Iterator<T> it = this.animations.iterator();
        while (it.hasNext()) {
            SpringForce spring = ((SpringAnimation) it.next()).getSpring();
            if (dampingRatio != null) {
                spring.setDampingRatio(dampingRatio.floatValue());
            }
            if (stiffness != null) {
                spring.setStiffness(stiffness.floatValue());
            }
        }
    }
}
