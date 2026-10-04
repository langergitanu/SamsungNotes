package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.p109ui.util.MathHelpersKt;
import androidx.compose.runtime.Stable;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b:\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\"\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a\"\u0010:\u001a\u00020\u00022\u0006\u00102\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0007ø\u0001\u0000¢\u0006\u0004\b;\u00109\u001a*\u0010<\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b@\u0010A\u001a*\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u00012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\bB\u0010C\u001a*\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\bD\u0010C\u001a#\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\bH\u0010I\u001a#\u0010J\u001a\u00020\b2\u0006\u0010F\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\bK\u0010I\u001a\u001f\u0010L\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\bN\u0010I\u001a\u001f\u0010O\u001a\u00020\b*\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\bQ\u0010I\u001a'\u0010R\u001a\u00020\b*\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010P\u001a\u00020\bH\u0087\bø\u0001\u0000¢\u0006\u0004\bS\u0010A\u001a%\u0010T\u001a\u00020\b*\u00020\b2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0VH\u0086\bø\u0001\u0000¢\u0006\u0004\bW\u0010X\u001a%\u0010T\u001a\u00020\u0001*\u00020\u00012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00010VH\u0086\bø\u0001\u0000¢\u0006\u0004\bY\u0010Z\u001a%\u0010T\u001a\u00020\u0002*\u00020\u00022\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020VH\u0086\bø\u0001\u0000¢\u0006\u0004\b[\u0010Z\u001a\u001f\u0010\\\u001a\u00020\b*\u00020\t2\u0006\u0010]\u001a\u00020\bH\u0087\nø\u0001\u0000¢\u0006\u0004\b^\u0010_\u001a\u001f\u0010\\\u001a\u00020\b*\u00020\u000e2\u0006\u0010]\u001a\u00020\bH\u0087\nø\u0001\u0000¢\u0006\u0004\b^\u0010I\u001a\u001f\u0010\\\u001a\u00020\u0002*\u00020\u000e2\u0006\u0010.\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b`\u0010a\u001a\u001f\u0010\\\u001a\u00020\b*\u00020\u00112\u0006\u0010]\u001a\u00020\bH\u0087\nø\u0001\u0000¢\u0006\u0004\b^\u0010b\u001a\u001f\u0010\\\u001a\u00020\u0002*\u00020\u00112\u0006\u0010.\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b`\u0010c\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000f\u001a\u0004\b\f\u0010\u0010\"\u001f\u0010\u0007\u001a\u00020\b*\u00020\u00118Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0012\u001a\u0004\b\f\u0010\u0013\"\u001f\u0010\u0014\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001f\u0010\u001a\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u001e\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b \u0010\u000f\u001a\u0004\b!\u0010\u001e\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0004\u001a\u0004\b#\u0010$\"\u001f\u0010\u001f\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010$\"\u001f\u0010'\u001a\u00020\u001b*\u00020\b8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u000f\u001a\u0004\b)\u0010\u001e\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00018Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010$\"\u001f\u0010'\u001a\u00020\u001b*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0004\u001a\u0004\b-\u0010$\"\u001f\u0010.\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0017\u001a\u0004\b0\u00101\"\u001f\u00102\u001a\u00020\b*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b3\u0010\u0017\u001a\u0004\b4\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006d"}, m13886d2 = {"center", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/ui/unit/DpSize;", "getCenter-EaSLcWc$annotations", "(J)V", "getCenter-EaSLcWc", "(J)J", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "Landroidx/compose/ui/unit/Dp;", "", "getDp$annotations", "(D)V", "getDp", "(D)F", "", "(F)V", "(F)F", "", "(I)V", "(I)F", "height", "Landroidx/compose/ui/unit/DpRect;", "getHeight$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getHeight", "(Landroidx/compose/ui/unit/DpRect;)F", "isFinite", "", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "(F)Z", "isSpecified", "isSpecified-0680j_4$annotations", "isSpecified-0680j_4", "isSpecified-jo-Fl9I$annotations", "isSpecified-jo-Fl9I", "(J)Z", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "size", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "width", "getWidth$annotations", "getWidth", "DpOffset", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "DpSize", "DpSize-YgX7TsA", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "(FFF)F", "lerp-xhh869w", "(JJF)J", "lerp-IDex15A", VElementFormulasCmd.FMAX, "a", "b", "max-YgX7TsA", "(FF)F", VElementFormulasCmd.FMIN, "min-YgX7TsA", "coerceAtLeast", "minimumValue", "coerceAtLeast-YgX7TsA", "coerceAtMost", "maximumValue", "coerceAtMost-YgX7TsA", "coerceIn", "coerceIn-2z7ARbQ", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "takeOrElse-itqla9I", "times", "other", "times-3ABfNKs", "(DF)F", "times-6HolHcs", "(FJ)J", "(IF)F", "(IJ)J", "ui-unit_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,577:1\n125#1:578\n325#1:582\n483#1:589\n564#1:600\n570#1:602\n63#2,3:579\n63#2,3:583\n63#2,3:586\n63#2,3:592\n63#2,3:595\n69#3:590\n69#3:591\n57#3:598\n57#3:599\n57#3:601\n*S KotlinDebug\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n139#1:578\n339#1:582\n497#1:589\n576#1:600\n576#1:602\n249#1:579,3\n355#1:583,3\n365#1:586,3\n506#1:592,3\n531#1:595,3\n507#1:590\n508#1:591\n564#1:598\n570#1:599\n576#1:601\n*E\n"})
public final class DpKt {
    @Stable
    /* JADX INFO: renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m20989DpOffsetYgX7TsA(float f, float f4) {
        return DpOffset.m21024constructorimpl((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m20990DpSizeYgX7TsA(float f, float f4) {
        return DpSize.m21057constructorimpl((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    @Stable
    /* JADX INFO: renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m20991coerceAtLeastYgX7TsA(float f, float f4) {
        return C2256Dp.m20968constructorimpl(RangesKt.coerceAtLeast(f, f4));
    }

    @Stable
    /* JADX INFO: renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m20992coerceAtMostYgX7TsA(float f, float f4) {
        return C2256Dp.m20968constructorimpl(RangesKt.coerceAtMost(f, f4));
    }

    @Stable
    /* JADX INFO: renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m20993coerceIn2z7ARbQ(float f, float f4, float f5) {
        return C2256Dp.m20968constructorimpl(RangesKt.coerceIn(f, f4, f5));
    }

    /* JADX INFO: renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m20994getCenterEaSLcWc(long j) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(DpSize.m21066getWidthD9Ej5fM(j) / 2.0f);
        return DpOffset.m21024constructorimpl((((long) Float.floatToRawIntBits(C2256Dp.m20968constructorimpl(DpSize.m21064getHeightD9Ej5fM(j) / 2.0f))) & 4294967295L) | (Float.floatToRawIntBits(fM20968constructorimpl) << 32));
    }

    public static final float getDp(int i) {
        return C2256Dp.m20968constructorimpl(i);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static final float getHeight(@NotNull DpRect dpRect) {
        return C2256Dp.m20968constructorimpl(dpRect.m21050getBottomD9Ej5fM() - dpRect.m21053getTopD9Ej5fM());
    }

    public static final long getSize(@NotNull DpRect dpRect) {
        return m20990DpSizeYgX7TsA(C2256Dp.m20968constructorimpl(dpRect.m21052getRightD9Ej5fM() - dpRect.m21051getLeftD9Ej5fM()), C2256Dp.m20968constructorimpl(dpRect.m21050getBottomD9Ej5fM() - dpRect.m21053getTopD9Ej5fM()));
    }

    public static final float getWidth(@NotNull DpRect dpRect) {
        return C2256Dp.m20968constructorimpl(dpRect.m21052getRightD9Ej5fM() - dpRect.m21051getLeftD9Ej5fM());
    }

    /* JADX INFO: renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m20996isFinite0680j_4(float f) {
        return !(f == Float.POSITIVE_INFINITY);
    }

    /* JADX INFO: renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m20998isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    /* JADX INFO: renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m21000isSpecifiedEaSLcWc(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m21002isSpecifiedjoFl9I(long j) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m21004isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    /* JADX INFO: renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m21006isUnspecifiedEaSLcWc(long j) {
        return j == InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m21008isUnspecifiedjoFl9I(long j) {
        return j == InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    @Stable
    /* JADX INFO: renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m21010lerpIDex15A(long j, long j2, float f) {
        float fM21011lerpMdfbLM = m21011lerpMdfbLM(DpSize.m21066getWidthD9Ej5fM(j), DpSize.m21066getWidthD9Ej5fM(j2), f);
        float fM21011lerpMdfbLM2 = m21011lerpMdfbLM(DpSize.m21064getHeightD9Ej5fM(j), DpSize.m21064getHeightD9Ej5fM(j2), f);
        return DpSize.m21057constructorimpl((((long) Float.floatToRawIntBits(fM21011lerpMdfbLM)) << 32) | (((long) Float.floatToRawIntBits(fM21011lerpMdfbLM2)) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m21011lerpMdfbLM(float f, float f4, float f5) {
        return C2256Dp.m20968constructorimpl(MathHelpersKt.lerp(f, f4, f5));
    }

    @Stable
    /* JADX INFO: renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m21012lerpxhh869w(long j, long j2, float f) {
        float fLerp = MathHelpersKt.lerp(DpOffset.m21029getXD9Ej5fM(j), DpOffset.m21029getXD9Ej5fM(j2), f);
        float fLerp2 = MathHelpersKt.lerp(DpOffset.m21031getYD9Ej5fM(j), DpOffset.m21031getYD9Ej5fM(j2), f);
        return DpOffset.m21024constructorimpl((((long) Float.floatToRawIntBits(fLerp)) << 32) | (((long) Float.floatToRawIntBits(fLerp2)) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m21013maxYgX7TsA(float f, float f4) {
        return C2256Dp.m20968constructorimpl(Math.max(f, f4));
    }

    @Stable
    /* JADX INFO: renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m21014minYgX7TsA(float f, float f4) {
        return C2256Dp.m20968constructorimpl(Math.min(f, f4));
    }

    /* JADX INFO: renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m21015takeOrElseD5KLDUw(float f, @NotNull Function0<C2256Dp> function0) {
        return !Float.isNaN(f) ? f : function0.invoke().m20982unboximpl();
    }

    /* JADX INFO: renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m21016takeOrElsegVKV90s(long j, @NotNull Function0<DpOffset> function0) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().getPackedValue();
    }

    /* JADX INFO: renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m21017takeOrElseitqla9I(long j, @NotNull Function0<DpSize> function0) {
        return j != InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().getPackedValue();
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m21019times3ABfNKs(float f, float f4) {
        return C2256Dp.m20968constructorimpl(f * f4);
    }

    @Stable
    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m21022times6HolHcs(int i, long j) {
        return DpSize.m21072timesGh9hcWk(j, i);
    }

    public static final float getDp(double d) {
        return C2256Dp.m20968constructorimpl((float) d);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(float f) {
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m21018times3ABfNKs(double d, float f) {
        return C2256Dp.m20968constructorimpl(((float) d) * f);
    }

    @Stable
    /* JADX INFO: renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m21021times6HolHcs(float f, long j) {
        return DpSize.m21071timesGh9hcWk(j, f);
    }

    public static final float getDp(float f) {
        return C2256Dp.m20968constructorimpl(f);
    }

    @Stable
    public static /* synthetic */ void getDp$annotations(int i) {
    }

    @Stable
    /* JADX INFO: renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m21020times3ABfNKs(int i, float f) {
        return C2256Dp.m20968constructorimpl(i * f);
    }

    @Stable
    /* JADX INFO: renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m20995getCenterEaSLcWc$annotations(long j) {
    }

    @Stable
    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    @Stable
    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    @Stable
    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    @Stable
    /* JADX INFO: renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m20997isFinite0680j_4$annotations(float f) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m20999isSpecified0680j_4$annotations(float f) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m21001isSpecifiedEaSLcWc$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m21003isSpecifiedjoFl9I$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m21005isUnspecified0680j_4$annotations(float f) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m21007isUnspecifiedEaSLcWc$annotations(long j) {
    }

    @Stable
    /* JADX INFO: renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m21009isUnspecifiedjoFl9I$annotations(long j) {
    }
}
