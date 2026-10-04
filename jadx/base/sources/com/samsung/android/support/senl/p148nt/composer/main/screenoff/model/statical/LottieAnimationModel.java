package com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0018\u001a\u00020\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/statical/LottieAnimationModel;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "PEN_DETACH_EFFECT", "PEN_HOVER_RIPPLE_EFFECT", "value", "Lcom/airbnb/lottie/LottieAnimationView;", "penDetachAnimationView", "getPenDetachAnimationView", "()Lcom/airbnb/lottie/LottieAnimationView;", "penHoverAnimationView", "getPenHoverAnimationView", "", "isPreInitialized", "()Z", "init", "", "context", "Landroid/content/Context;", "initPenDetachAnimationView", "initPenHoverAnimationView", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class LottieAnimationModel {

    @NotNull
    private static final String PEN_DETACH_EFFECT = "screenoff_pen_detach_effect.json";

    @NotNull
    private static final String PEN_HOVER_RIPPLE_EFFECT = "screenoff_pen_hover_ripple_effect.json";
    private static boolean isPreInitialized;

    @Nullable
    private static LottieAnimationView penDetachAnimationView;

    @Nullable
    private static LottieAnimationView penHoverAnimationView;

    @NotNull
    public static final LottieAnimationModel INSTANCE = new LottieAnimationModel();

    @NotNull
    private static final String TAG = SOLogger.createTag("LottieAnimationModel");

    private LottieAnimationModel() {
    }

    private final void initPenDetachAnimationView(Context context) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPenDetachAnimationView#");
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        lottieAnimationView.setAnimation(PEN_DETACH_EFFECT);
        lottieAnimationView.setSpeed(1.37f);
        penDetachAnimationView = lottieAnimationView;
    }

    private final void initPenHoverAnimationView(Context context) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "initPenHoverAnimationView#");
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        penHoverAnimationView = lottieAnimationView;
        lottieAnimationView.setAnimation(PEN_HOVER_RIPPLE_EFFECT);
    }

    @Nullable
    public final LottieAnimationView getPenDetachAnimationView() {
        return penDetachAnimationView;
    }

    @Nullable
    public final LottieAnimationView getPenHoverAnimationView() {
        return penHoverAnimationView;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isPreInitialized = true;
        initPenDetachAnimationView(context);
        initPenHoverAnimationView(context);
    }

    public final boolean isPreInitialized() {
        return isPreInitialized;
    }

    public final void release() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "release#");
        isPreInitialized = false;
        LottieAnimationView lottieAnimationView = penDetachAnimationView;
        if (lottieAnimationView != null) {
            lottieAnimationView.clearAnimation();
        }
        penDetachAnimationView = null;
        LottieAnimationView lottieAnimationView2 = penHoverAnimationView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.clearAnimation();
        }
        penHoverAnimationView = null;
    }
}
