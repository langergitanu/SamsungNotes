package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;
import opennlp.tools.namefind.BilouCodec;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\b\u001a\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, m13886d2 = {"saturatingAdd", "", "value", BilouCodec.UNIT, "Lkotlin/time/DurationUnit;", XmlErrorCodes.DURATION, "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,81:1\n80#1:82\n80#1:83\n80#1:84\n80#1:85\n80#1:86\n80#1:87\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n14#1:82\n17#1:83\n36#1:84\n46#1:85\n53#1:86\n57#1:87\n*E\n"})
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m23655checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m23579isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.INSTANCE.m23644getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.INSTANCE.m23643getINFINITEUwyO8pc();
    }

    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m23656saturatingAddNuflL3o(long j, @NotNull DurationUnit unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long jM23593toLongimpl = Duration.m23593toLongimpl(j2, unit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m23655checkInfiniteSumDefinedPjuGub4(j, j2, jM23593toLongimpl);
        }
        if (((jM23593toLongimpl - 1) | 1) == Long.MAX_VALUE) {
            return m23657saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + jM23593toLongimpl;
        return ((j ^ j3) & (jM23593toLongimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m23657saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long jM23557divUwyO8pc = Duration.m23557divUwyO8pc(j2, 2);
        long jM23593toLongimpl = Duration.m23593toLongimpl(jM23557divUwyO8pc, durationUnit);
        return (1 | (jM23593toLongimpl - 1)) == Long.MAX_VALUE ? jM23593toLongimpl : m23656saturatingAddNuflL3o(m23656saturatingAddNuflL3o(j, durationUnit, jM23557divUwyO8pc), durationUnit, Duration.m23582minusLRDsOJo(j2, jM23557divUwyO8pc));
    }

    public static final long saturatingDiff(long j, long j2, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (1 | (j2 - 1)) == Long.MAX_VALUE ? Duration.m23598unaryMinusUwyO8pc(infinityOfSign(j2)) : saturatingFiniteDiff(j, j2, unit);
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            return DurationKt.toDuration(j3, durationUnit);
        }
        DurationUnit durationUnit2 = DurationUnit.MILLISECONDS;
        if (durationUnit.compareTo(durationUnit2) >= 0) {
            return Duration.m23598unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        long jConvertDurationUnit = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1L, durationUnit2, durationUnit);
        long j5 = (j / jConvertDurationUnit) - (j2 / jConvertDurationUnit);
        long j6 = (j % jConvertDurationUnit) - (j2 % jConvertDurationUnit);
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m23583plusLRDsOJo(DurationKt.toDuration(j5, durationUnit2), DurationKt.toDuration(j6, durationUnit));
    }

    public static final long saturatingOriginsDiff(long j, long j2, @NotNull DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return ((j2 - 1) | 1) == Long.MAX_VALUE ? j == j2 ? Duration.INSTANCE.m23645getZEROUwyO8pc() : Duration.m23598unaryMinusUwyO8pc(infinityOfSign(j2)) : (1 | (j - 1)) == Long.MAX_VALUE ? infinityOfSign(j) : saturatingFiniteDiff(j, j2, unit);
    }
}
