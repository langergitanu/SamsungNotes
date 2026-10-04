package com.samsung.android.sesl.visualeffect.surfaceeffects.ripple;

import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0201c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\u001c\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleController;", "", "multipleRippleView", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView;", "<init>", "(Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleView;)V", "updateConfigs", "", "updateColor", "color", "", "play", "rippleAnimation", "Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/RippleAnimation;", "onAnimationEnd", "Ljava/lang/Runnable;", "Companion", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMultiRippleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MultiRippleController.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleController\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,60:1\n1863#2,2:61\n1863#2,2:63\n*S KotlinDebug\n*F\n+ 1 MultiRippleController.kt\ncom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleController\n*L\n35#1:61,2\n43#1:63,2\n*E\n"})
public final class MultiRippleController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_RIPPLE_NUMBER = 20;

    @NotNull
    public static final String TAG = "MultiRippleController";

    @NotNull
    private final MultiRippleView multipleRippleView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sesl/visualeffect/surfaceeffects/ripple/MultiRippleController$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAX_RIPPLE_NUMBER", "", "getMAX_RIPPLE_NUMBER$annotations", "sesl-visualeffect-INTERNAL-2.1.10_release"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getMAX_RIPPLE_NUMBER$annotations() {
        }

        private Companion() {
        }
    }

    public MultiRippleController(@NotNull MultiRippleView multipleRippleView) {
        Intrinsics.checkNotNullParameter(multipleRippleView, "multipleRippleView");
        this.multipleRippleView = multipleRippleView;
    }

    public static /* synthetic */ void play$default(MultiRippleController multiRippleController, RippleAnimation rippleAnimation, Runnable runnable, int i, Object obj) {
        if ((i & 2) != 0) {
            runnable = null;
        }
        multiRippleController.play(rippleAnimation, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void play$lambda$2(MultiRippleController multiRippleController, RippleAnimation rippleAnimation, Runnable runnable) {
        multiRippleController.multipleRippleView.getRipples().remove(rippleAnimation);
        if (runnable != null) {
            runnable.run();
        }
    }

    @RequiresApi(33)
    public final void play(@NotNull RippleAnimation rippleAnimation, @Nullable Runnable onAnimationEnd) {
        Intrinsics.checkNotNullParameter(rippleAnimation, "rippleAnimation");
        if (this.multipleRippleView.getRipples().size() >= 20) {
            Log.w(TAG, "Too many ripple animations. (20)");
            return;
        }
        this.multipleRippleView.getRipples().add(rippleAnimation);
        RippleAnimation.play$default(rippleAnimation, new RunnableC0201c(this, 20, rippleAnimation, onAnimationEnd), null, 2, null);
        this.multipleRippleView.invalidate();
    }

    @RequiresApi(33)
    public final void updateColor(int color) {
        Iterator<T> it = this.multipleRippleView.getRipples().iterator();
        while (it.hasNext()) {
            ((RippleAnimation) it.next()).updateColor(color);
        }
    }

    @RequiresApi(33)
    public final void updateConfigs() {
        Iterator<T> it = this.multipleRippleView.getRipples().iterator();
        while (it.hasNext()) {
            ((RippleAnimation) it.next()).updateConfigs();
        }
    }
}
