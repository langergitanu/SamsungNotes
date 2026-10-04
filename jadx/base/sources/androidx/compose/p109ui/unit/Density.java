package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.geometry.Size;
import androidx.compose.p109ui.geometry.SizeKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Immutable
@Metadata(m13885d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, m13886d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDensity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Density.kt\nandroidx/compose/ui/unit/Density\n+ 2 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Size.kt\nandroidx/compose/ui/geometry/SizeKt\n*L\n1#1,141:1\n26#2:142\n26#2:144\n1#3:143\n169#4:145\n169#4:146\n483#4:147\n198#5:148\n*S KotlinDebug\n*F\n+ 1 Density.kt\nandroidx/compose/ui/unit/Density\n*L\n69#1:142\n86#1:144\n92#1:145\n102#1:146\n125#1:147\n135#1:148\n*E\n"})
public interface Density extends FontScaling {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class DefaultImpls {
        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m20954roundToPxR2X_6o(@NotNull Density density, long j) {
            return Density.super.mo15539roundToPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m20955roundToPx0680j_4(@NotNull Density density, float f) {
            return Density.super.mo15540roundToPx0680j_4(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m20956toDpGaN1DYA(@NotNull Density density, long j) {
            return Density.super.mo15541toDpGaN1DYA(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m20958toDpu2uoSUM(@NotNull Density density, int i) {
            return Density.super.mo15543toDpu2uoSUM(i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m20959toDpSizekrfVVM(@NotNull Density density, long j) {
            return Density.super.mo15544toDpSizekrfVVM(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m20960toPxR2X_6o(@NotNull Density density, long j) {
            return Density.super.mo15545toPxR2X_6o(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m20961toPx0680j_4(@NotNull Density density, float f) {
            return Density.super.mo15546toPx0680j_4(f);
        }

        @Stable
        @Deprecated
        @NotNull
        public static Rect toRect(@NotNull Density density, @NotNull DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m20962toSizeXkaWNTQ(@NotNull Density density, long j) {
            return Density.super.mo15547toSizeXkaWNTQ(j);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m20963toSp0xMU5do(@NotNull Density density, float f) {
            return Density.super.mo15548toSp0xMU5do(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m20965toSpkPz2Gy4(@NotNull Density density, int i) {
            return Density.super.mo15550toSpkPz2Gy4(i);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m20957toDpu2uoSUM(@NotNull Density density, float f) {
            return Density.super.mo15542toDpu2uoSUM(f);
        }

        @Stable
        @Deprecated
        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m20964toSpkPz2Gy4(@NotNull Density density, float f) {
            return Density.super.mo15549toSpkPz2Gy4(f);
        }

        @Stable
        public static /* synthetic */ void getDensity$annotations() {
        }
    }

    float getDensity();

    @Stable
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    default int mo15539roundToPxR2X_6o(long j) {
        return Math.round(mo15545toPxR2X_6o(j));
    }

    @Stable
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    default int mo15540roundToPx0680j_4(float f) {
        float fMo15546toPx0680j_4 = mo15546toPx0680j_4(f);
        if (Float.isInfinite(fMo15546toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return Math.round(fMo15546toPx0680j_4);
    }

    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo15543toDpu2uoSUM(int i) {
        return C2256Dp.m20968constructorimpl(i / getDensity());
    }

    @Stable
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    default long mo15544toDpSizekrfVVM(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats ? DpKt.m20990DpSizeYgX7TsA(mo15542toDpu2uoSUM(Size.m18353getWidthimpl(j)), mo15542toDpu2uoSUM(Size.m18350getHeightimpl(j))) : DpSize.INSTANCE.m21075getUnspecifiedMYxV2XQ();
    }

    @Stable
    /* JADX INFO: renamed from: toPx--R2X_6o */
    default float mo15545toPxR2X_6o(long j) {
        if (TextUnitType.m21189equalsimpl0(TextUnit.m21160getTypeUIouoOA(j), TextUnitType.INSTANCE.m21194getSpUIouoOA())) {
            return mo15546toPx0680j_4(mo15541toDpGaN1DYA(j));
        }
        throw new IllegalStateException("Only Sp can convert to Px");
    }

    @Stable
    /* JADX INFO: renamed from: toPx-0680j_4 */
    default float mo15546toPx0680j_4(float f) {
        return getDensity() * f;
    }

    @Stable
    @NotNull
    default Rect toRect(@NotNull DpRect dpRect) {
        return new Rect(mo15546toPx0680j_4(dpRect.m21051getLeftD9Ej5fM()), mo15546toPx0680j_4(dpRect.m21053getTopD9Ej5fM()), mo15546toPx0680j_4(dpRect.m21052getRightD9Ej5fM()), mo15546toPx0680j_4(dpRect.m21050getBottomD9Ej5fM()));
    }

    @Stable
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    default long mo15547toSizeXkaWNTQ(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats ? SizeKt.Size(mo15546toPx0680j_4(DpSize.m21066getWidthD9Ej5fM(j)), mo15546toPx0680j_4(DpSize.m21064getHeightD9Ej5fM(j))) : Size.INSTANCE.m18361getUnspecifiedNHjbRc();
    }

    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo15550toSpkPz2Gy4(int i) {
        return mo15548toSp0xMU5do(mo15543toDpu2uoSUM(i));
    }

    @Stable
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    default long mo15549toSpkPz2Gy4(float f) {
        return mo15548toSp0xMU5do(mo15542toDpu2uoSUM(f));
    }

    @Stable
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    default float mo15542toDpu2uoSUM(float f) {
        return C2256Dp.m20968constructorimpl(f / getDensity());
    }
}
