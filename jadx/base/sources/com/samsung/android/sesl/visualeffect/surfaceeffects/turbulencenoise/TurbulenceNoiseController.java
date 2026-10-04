package com.samsung.android.sesl.visualeffect.surfaceeffects.turbulencenoise;

import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0012H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0003J\b\u0010\u001a\u001a\u00020\u0012H\u0003J\b\u0010\u001b\u001a\u00020\u0012H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseController;", "", "turbulenceNoiseView", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseView;", "<init>", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseView;)V", "random", "Ljava/util/Random;", "value", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseController$Companion$AnimationState;", "state", "getState$annotations", "()V", "getState", "()Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseController$Companion$AnimationState;", "setState", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseController$Companion$AnimationState;)V", "updateNoiseColor", "", "color", "", "play", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/turbulencenoise/TurbulenceNoiseAnimationConfig;", "finish", "playEaseInAnimation", "playMainAnimation", "playEaseOutAnimation", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class TurbulenceNoiseController {

    @NotNull
    private final Random random;

    @NotNull
    private Companion.AnimationState state;

    @NotNull
    private final TurbulenceNoiseView turbulenceNoiseView;

    public TurbulenceNoiseController(@NotNull TurbulenceNoiseView turbulenceNoiseView) {
        Intrinsics.checkNotNullParameter(turbulenceNoiseView, "turbulenceNoiseView");
        this.turbulenceNoiseView = turbulenceNoiseView;
        this.random = new Random();
        this.state = Companion.AnimationState.NOT_PLAYING;
        turbulenceNoiseView.setVisibility(4);
    }

    @VisibleForTesting
    public static /* synthetic */ void getState$annotations() {
    }

    @RequiresApi(33)
    private final void playEaseInAnimation() {
        if (this.state != Companion.AnimationState.NOT_PLAYING) {
            return;
        }
        setState(Companion.AnimationState.EASE_IN);
        this.turbulenceNoiseView.playEaseIn(this.random.nextFloat(), this.random.nextFloat(), new RunnableC7895b(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(33)
    public final void playEaseOutAnimation() {
        if (this.state != Companion.AnimationState.MAIN) {
            return;
        }
        setState(Companion.AnimationState.EASE_OUT);
        this.turbulenceNoiseView.playEaseOut(new RunnableC7895b(this, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playEaseOutAnimation$lambda$0(TurbulenceNoiseController turbulenceNoiseController) {
        turbulenceNoiseController.setState(Companion.AnimationState.NOT_PLAYING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(33)
    public final void playMainAnimation() {
        if (this.state != Companion.AnimationState.EASE_IN) {
            return;
        }
        setState(Companion.AnimationState.MAIN);
        this.turbulenceNoiseView.play(new RunnableC7895b(this, 1));
    }

    @RequiresApi(33)
    public final void finish() {
        if (this.state == Companion.AnimationState.MAIN) {
            this.turbulenceNoiseView.finish(new RunnableC7895b(this, 1));
        }
    }

    @NotNull
    public final Companion.AnimationState getState() {
        return this.state;
    }

    @RequiresApi(33)
    public final void play(@NotNull TurbulenceNoiseAnimationConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (this.state != Companion.AnimationState.NOT_PLAYING) {
            return;
        }
        this.turbulenceNoiseView.applyConfig(config);
        playEaseInAnimation();
    }

    public final void setState(@NotNull Companion.AnimationState value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.state = value;
        if (value != Companion.AnimationState.NOT_PLAYING) {
            this.turbulenceNoiseView.setVisibility(0);
        } else {
            this.turbulenceNoiseView.setVisibility(4);
            this.turbulenceNoiseView.clearConfig$sesl_visualeffect_INTERNAL_2_1_10_release();
        }
    }

    @RequiresApi(33)
    public final void updateNoiseColor(int color) {
        if (this.state == Companion.AnimationState.NOT_PLAYING) {
            return;
        }
        this.turbulenceNoiseView.updateColor$sesl_visualeffect_INTERNAL_2_1_10_release(color);
    }
}
