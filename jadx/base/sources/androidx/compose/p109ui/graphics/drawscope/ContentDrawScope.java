package androidx.compose.p109ui.graphics.drawscope;

import androidx.annotation.FloatRange;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.ColorFilter;
import androidx.compose.p109ui.graphics.ImageBitmap;
import androidx.compose.p109ui.graphics.layer.GraphicsLayer;
import androidx.compose.p109ui.unit.DpRect;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface ContentDrawScope extends DrawScope {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m19022drawImageAZ2fEMs(@NotNull ContentDrawScope contentDrawScope, @NotNull ImageBitmap imageBitmap, long j, long j2, long j3, long j5, @FloatRange(from = 0.0d, m705to = 1.0d) float f, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i, int i2) {
            ContentDrawScope.super.mo18978drawImageAZ2fEMs(imageBitmap, j, j2, j3, j5, f, drawStyle, colorFilter, i, i2);
        }

        @Deprecated
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m19023getCenterF1C5BW0(@NotNull ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo19075getCenterF1C5BW0();
        }

        @Deprecated
        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m19024getSizeNHjbRc(@NotNull ContentDrawScope contentDrawScope) {
            return ContentDrawScope.super.mo19076getSizeNHjbRc();
        }

        @Deprecated
        /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m19025recordJVtK1S4(@NotNull ContentDrawScope contentDrawScope, @NotNull GraphicsLayer graphicsLayer, long j, @NotNull Function1<? super DrawScope, Unit> function1) {
            ContentDrawScope.super.mo19077recordJVtK1S4(graphicsLayer, j, function1);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m19026roundToPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo15539roundToPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m19027roundToPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo15540roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m19028toDpGaN1DYA(@NotNull ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo15541toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m19029toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo15542toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m19031toDpSizekrfVVM(@NotNull ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo15544toDpSizekrfVVM(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m19032toPxR2X_6o(@NotNull ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo15545toPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m19033toPx0680j_4(@NotNull ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo15546toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull ContentDrawScope contentDrawScope, @NotNull DpRect dpRect) {
            return ContentDrawScope.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m19034toSizeXkaWNTQ(@NotNull ContentDrawScope contentDrawScope, long j) {
            return ContentDrawScope.super.mo15547toSizeXkaWNTQ(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m19035toSp0xMU5do(@NotNull ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo15548toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m19036toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, float f) {
            return ContentDrawScope.super.mo15549toSpkPz2Gy4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m19030toDpu2uoSUM(@NotNull ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo15543toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m19037toSpkPz2Gy4(@NotNull ContentDrawScope contentDrawScope, int i) {
            return ContentDrawScope.super.mo15550toSpkPz2Gy4(i);
        }
    }

    void drawContent();
}
