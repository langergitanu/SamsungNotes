package androidx.compose.foundation.gestures;

import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.unit.Density;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface PressGestureScope extends Density {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m15641roundToPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo15539roundToPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m15642roundToPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo15540roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m15643toDpGaN1DYA(@NotNull PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo15541toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m15644toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo15542toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m15646toDpSizekrfVVM(@NotNull PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo15544toDpSizekrfVVM(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m15647toPxR2X_6o(@NotNull PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo15545toPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m15648toPx0680j_4(@NotNull PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo15546toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull PressGestureScope pressGestureScope, @NotNull DpRect dpRect) {
            return PressGestureScope.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m15649toSizeXkaWNTQ(@NotNull PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo15547toSizeXkaWNTQ(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m15650toSp0xMU5do(@NotNull PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo15548toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m15651toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo15549toSpkPz2Gy4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m15645toDpu2uoSUM(@NotNull PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.mo15543toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m15652toSpkPz2Gy4(@NotNull PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.mo15550toSpkPz2Gy4(i);
        }
    }

    @Nullable
    Object awaitRelease(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object tryAwaitRelease(@NotNull Continuation<? super Boolean> continuation);
}
