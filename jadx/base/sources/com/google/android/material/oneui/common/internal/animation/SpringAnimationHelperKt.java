package com.google.android.material.oneui.common.internal.animation;

import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a}\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0002H\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00070\u00062\u001a\b\u0004\u0010\b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t2\u0014\b\u0006\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\n0\u00062\u000e\b\u0006\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, m13886d2 = {"springAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "T", "name", "", "getter", "Lkotlin/Function1;", "", "setter", "Lkotlin/Function2;", "", "onUpdate", "onEnd", "Lkotlin/Function0;", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Landroidx/dynamicanimation/animation/SpringAnimation;", "material_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SpringAnimationHelperKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.android.material.oneui.common.internal.animation.SpringAnimationHelperKt$springAnimation$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, m13886d2 = {"com/google/android/material/oneui/common/internal/animation/SpringAnimationHelperKt$springAnimation$3", "Landroidx/dynamicanimation/animation/FloatPropertyCompat;", "getValue", "", "newValue", "(Ljava/lang/Object;)F", "setValue", "", "value", "(Ljava/lang/Object;F)V", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 176)
    public static final class C47653<T> extends FloatPropertyCompat<T> {
        final /* synthetic */ Function1<T, Float> $getter;
        final /* synthetic */ Function1<T, Unit> $onUpdate;
        final /* synthetic */ Function2<T, Float, Unit> $setter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C47653(String str, Function1<? super T, Float> function1, Function2<? super T, ? super Float, Unit> function2, Function1<? super T, Unit> function12) {
            super(str);
            this.$getter = function1;
            this.$setter = function2;
            this.$onUpdate = function12;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public float getValue(T newValue) {
            return this.$getter.invoke(newValue).floatValue();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public void setValue(T newValue, float value) {
            this.$setter.invoke(newValue, Float.valueOf(value));
            this.$onUpdate.invoke(newValue);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* synthetic */ <T> SpringAnimation springAnimation(T t, String name, Function1<? super T, Float> getter, Function2<? super T, ? super Float, Unit> setter, Function1<? super T, Unit> onUpdate, Function0<Unit> onEnd) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(getter, "getter");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        Intrinsics.needClassReification();
        SpringAnimation springAnimation = new SpringAnimation(t, new C47653(name, getter, setter, onUpdate));
        SpringForce springForce = new SpringForce(getter.invoke(t).floatValue());
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(1500.0f);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(new SpringAnimationHelperKt$springAnimation$4$2(onEnd));
        return springAnimation;
    }

    public static /* synthetic */ SpringAnimation springAnimation$default(Object obj, String name, Function1 getter, Function2 setter, Function1 onUpdate, Function0 onEnd, int i, Object obj2) {
        if ((i & 8) != 0) {
            Intrinsics.needClassReification();
            onUpdate = C47631.INSTANCE;
        }
        if ((i & 16) != 0) {
            onEnd = new Function0<Unit>() { // from class: com.google.android.material.oneui.common.internal.animation.SpringAnimationHelperKt.springAnimation.2
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(getter, "getter");
        Intrinsics.checkNotNullParameter(setter, "setter");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        Intrinsics.needClassReification();
        SpringAnimation springAnimation = new SpringAnimation(obj, new C47653(name, getter, setter, onUpdate));
        SpringForce springForce = new SpringForce(((Number) getter.invoke(obj)).floatValue());
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(1500.0f);
        springAnimation.setSpring(springForce);
        springAnimation.addEndListener(new SpringAnimationHelperKt$springAnimation$4$2(onEnd));
        return springAnimation;
    }
}
