package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.animation;

import android.view.View;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.view.animation.SineInOut33;
import com.samsung.android.view.animation.SineInOut70;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/animation/QTAddFavoritePenAnimation;", "", "<init>", "()V", Constants.IntentExtraValue.SHOW, "", "view", "Landroid/view/View;", "hide", Profile.PhoneNumberData.TYPE_CALLBACK, "Ljava/lang/Runnable;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class QTAddFavoritePenAnimation {
    public final void hide(@NotNull View view, @NotNull Runnable callback) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(callback, "callback");
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
        view.animate().scaleX(0.95f).scaleY(0.95f).setDuration(250L).setInterpolator(new SineInOut70()).start();
        view.animate().alpha(0.0f).setDuration(150L).setInterpolator(new SineInOut33()).withEndAction(callback).start();
    }

    public final void show(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setScaleX(0.95f);
        view.setScaleY(0.95f);
        view.setAlpha(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(250L).setInterpolator(new SineInOut70()).start();
        view.animate().alpha(1.0f).setDuration(150L).setInterpolator(new SineInOut33()).start();
    }
}
