package com.google.android.material.oneui.common.internal.animation;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\nJ\b\u0010\u0014\u001a\u00020\rH\u0016J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u001f\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m13886d2 = {"Lcom/google/android/material/oneui/common/internal/animation/ResizeAnimation;", "Lcom/google/android/material/oneui/common/internal/animation/BaseAnimation;", "ratio", "", "(F)V", "anim", "Lcom/google/android/material/oneui/common/internal/animation/RectFSpringAnimation;", "getRatio", "()F", "rectF", "Landroid/graphics/RectF;", "updater", "Lkotlin/Function1;", "", "getUpdater", "()Lkotlin/jvm/functions/Function1;", "setUpdater", "(Lkotlin/jvm/functions/Function1;)V", "animateToFinalPosition", "finalPosition", "cancel", "init", "isRunning", "", "setSpringForce", "dampingRatio", "stiffness", "(Ljava/lang/Float;Ljava/lang/Float;)V", "skipToEnd", "material_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ResizeAnimation implements BaseAnimation {

    @NotNull
    private final RectFSpringAnimation anim;
    private final float ratio;

    @NotNull
    private final RectF rectF;

    @NotNull
    private Function1<? super RectF, Unit> updater;

    public ResizeAnimation() {
        this(0.0f, 1, null);
    }

    public final void animateToFinalPosition(@NotNull RectF finalPosition) {
        Intrinsics.checkNotNullParameter(finalPosition, "finalPosition");
        this.anim.animateToFinalPosition(finalPosition);
    }

    @Override // com.google.android.material.oneui.common.internal.animation.BaseAnimation
    public void cancel() {
        this.anim.cancel();
    }

    public final float getRatio() {
        return this.ratio;
    }

    @NotNull
    public final Function1<RectF, Unit> getUpdater() {
        return this.updater;
    }

    public final void init(@NotNull RectF init) {
        Intrinsics.checkNotNullParameter(init, "init");
        this.rectF.set(init);
    }

    @Override // com.google.android.material.oneui.common.internal.animation.BaseAnimation
    public boolean isRunning() {
        return this.anim.isRunning();
    }

    public final void setSpringForce(@Nullable Float dampingRatio, @Nullable Float stiffness) {
        this.anim.setSpringForce(dampingRatio, stiffness);
    }

    public final void setUpdater(@NotNull Function1<? super RectF, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.updater = function1;
    }

    @Override // com.google.android.material.oneui.common.internal.animation.BaseAnimation
    public void skipToEnd() {
        this.anim.skipToEnd();
    }

    public ResizeAnimation(float f) {
        this.ratio = f;
        this.updater = new Function1<RectF, Unit>() { // from class: com.google.android.material.oneui.common.internal.animation.ResizeAnimation$updater$1
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RectF it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RectF rectF) {
                invoke2(rectF);
                return Unit.INSTANCE;
            }
        };
        RectF rectF = new RectF();
        this.rectF = rectF;
        RectFSpringAnimation rectFSpringAnimation = new RectFSpringAnimation(rectF, f);
        rectFSpringAnimation.setSpringForce(Float.valueOf(1.0f), Float.valueOf(361.0f));
        rectFSpringAnimation.addUpdateListener(new Function1<RectF, Unit>() { // from class: com.google.android.material.oneui.common.internal.animation.ResizeAnimation$anim$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RectF rectF2) {
                invoke2(rectF2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RectF it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (this.this$0.rectF.isEmpty()) {
                    return;
                }
                this.this$0.getUpdater().invoke(it);
            }
        });
        this.anim = rectFSpringAnimation;
    }

    public /* synthetic */ ResizeAnimation(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f);
    }
}
