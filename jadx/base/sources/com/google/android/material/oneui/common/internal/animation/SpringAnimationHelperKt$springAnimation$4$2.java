package com.google.android.material.oneui.common.internal.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u001c\u0010\u0003\u001a\u0018\u0012\u0002\b\u0003 \u0005*\u000b\u0012\u0002\b\u0003\u0018\u00010\u0004¨\u0006\u00010\u0004¨\u0006\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\n¢\u0006\u0002\b\u000b"}, m13886d2 = {"<anonymous>", "", "T", "<anonymous parameter 0>", "Landroidx/dynamicanimation/animation/DynamicAnimation;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "onAnimationEnd"}, m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 176)
public final class SpringAnimationHelperKt$springAnimation$4$2 implements DynamicAnimation.OnAnimationEndListener {
    final /* synthetic */ Function0<Unit> $onEnd;

    public SpringAnimationHelperKt$springAnimation$4$2(Function0<Unit> function0) {
        this.$onEnd = function0;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        this.$onEnd.invoke();
    }
}
