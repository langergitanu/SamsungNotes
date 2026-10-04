package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimation;", "", "init", "", "container", "Landroid/view/View;", "animationView", "Lcom/airbnb/lottie/LottieAnimationView;", "color", "", "startingAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimationListener;", "start", "stop", "release", "isValid", "", "()Z", "isAnimating", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IStartingAnimation {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        public static boolean isAnimating(@NotNull IStartingAnimation iStartingAnimation) {
            return false;
        }

        public static boolean isValid(@NotNull IStartingAnimation iStartingAnimation) {
            return false;
        }
    }

    void init(@Nullable View container, @Nullable LottieAnimationView animationView, int color, @NotNull IStartingAnimationListener startingAnimationListener);

    boolean isAnimating();

    boolean isValid();

    void release();

    void start();

    void stop();
}
