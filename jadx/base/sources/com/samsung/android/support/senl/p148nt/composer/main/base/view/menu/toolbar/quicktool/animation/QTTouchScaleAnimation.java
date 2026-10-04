package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.animation;

import android.view.MotionEvent;
import android.view.View;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/animation/QTTouchScaleAnimation;", "", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", WiggleAnimationConfig.KEY_SCALE, "", "event", "Landroid/view/MotionEvent;", "scaleIn", "scaleOut", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTTouchScaleAnimation {

    @NotNull
    private final View view;

    public QTTouchScaleAnimation(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
    }

    private final void scaleIn() {
        this.view.animate().scaleX(1.02f).scaleY(1.02f).setDuration(450L).setInterpolator(QTAnimationKt.getOneEasing()).start();
    }

    private final void scaleOut() {
        this.view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(450L).setInterpolator(QTAnimationKt.getOneEasing()).start();
    }

    public final void scale(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            scaleIn();
        } else if (action == 1 || action == 3) {
            scaleOut();
        }
    }
}
