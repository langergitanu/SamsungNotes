package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0010\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u0016\u0010\u0012\u001a\u00020\u0007H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000bJ$\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001dJ\u001a\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b#\u0010$J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b)\u0010'J\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001bJ\u001e\u0010*\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u001cH\u0087\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001dJ\u000f\u0010,\u001a\u00020-H\u0017¢\u0006\u0004\b.\u0010/R \u0010\u0006\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\tR \u0010\r\u001a\u00020\u00078FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00061"}, m13886d2 = {"Landroidx/compose/ui/unit/DpSize;", "", "packedValue", "", "constructor-impl", "(J)J", "height", "Landroidx/compose/ui/unit/Dp;", "getHeight-D9Ej5fM$annotations", "()V", "getHeight-D9Ej5fM", "(J)F", "getPackedValue$annotations", "width", "getWidth-D9Ej5fM$annotations", "getWidth-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-DwJknco", "(JFF)J", "div", "other", "", "div-Gh9hcWk", "(JF)J", "", "(JI)J", "equals", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-e_xh8Ic", "(JJ)J", "plus", "plus-e_xh8Ic", "times", "times-Gh9hcWk", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@JvmInline
@SourceDebugExtension({"SMAP\nDp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/DpSize\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,577:1\n72#2:578\n86#2:581\n63#2,3:584\n63#2,3:589\n63#2,3:594\n63#2,3:599\n63#2,3:604\n63#2,3:609\n63#2,3:614\n22#3:579\n22#3:582\n169#4:580\n169#4:583\n483#4:617\n57#5:587\n57#5:588\n51#5:592\n51#5:593\n87#5:597\n87#5:598\n84#5:602\n84#5:603\n72#5:607\n72#5:608\n69#5:612\n69#5:613\n*S KotlinDebug\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/DpSize\n*L\n377#1:578\n383#1:581\n390#1:584,3\n399#1:589,3\n411#1:594,3\n425#1:599,3\n433#1:604,3\n441#1:609,3\n449#1:614,3\n377#1:579\n383#1:582\n377#1:580\n383#1:583\n457#1:617\n400#1:587\n401#1:588\n412#1:592\n413#1:593\n426#1:597\n427#1:598\n434#1:602\n435#1:603\n442#1:607\n443#1:608\n450#1:612\n451#1:613\n*E\n"})
public final class DpSize {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m21057constructorimpl(0);
    private static final long Unspecified = m21057constructorimpl(InlineClassHelperKt.UnspecifiedPackedFloats);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/unit/DpSize$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpSize;", "getUnspecified-MYxV2XQ", "()J", "J", "Zero", "getZero-MYxV2XQ", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-MYxV2XQ, reason: not valid java name */
        public final long m21075getUnspecifiedMYxV2XQ() {
            return DpSize.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-MYxV2XQ, reason: not valid java name */
        public final long m21076getZeroMYxV2XQ() {
            return DpSize.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpSize(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpSize m21054boximpl(long j) {
        return new DpSize(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-D9Ej5fM, reason: not valid java name */
    public static final float m21055component1D9Ej5fM(long j) {
        return m21066getWidthD9Ej5fM(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-D9Ej5fM, reason: not valid java name */
    public static final float m21056component2D9Ej5fM(long j) {
        return m21064getHeightD9Ej5fM(j);
    }

    /* JADX INFO: renamed from: copy-DwJknco, reason: not valid java name */
    public static final long m21058copyDwJknco(long j, float f, float f4) {
        return m21057constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-DwJknco$default, reason: not valid java name */
    public static /* synthetic */ long m21059copyDwJknco$default(long j, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m21066getWidthD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f4 = m21064getHeightD9Ej5fM(j);
        }
        return m21058copyDwJknco(j, f, f4);
    }

    @Stable
    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m21061divGh9hcWk(long j, int i) {
        float f = i;
        return m21057constructorimpl((((long) Float.floatToRawIntBits(C2256Dp.m20968constructorimpl(m21066getWidthD9Ej5fM(j) / f))) << 32) | (((long) Float.floatToRawIntBits(C2256Dp.m20968constructorimpl(m21064getHeightD9Ej5fM(j) / f))) & 4294967295L));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21062equalsimpl(long j, Object obj) {
        return (obj instanceof DpSize) && j == ((DpSize) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21063equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getHeight-D9Ej5fM, reason: not valid java name */
    public static final float m21064getHeightD9Ej5fM(long j) {
        return C2256Dp.m20968constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public static final float m21066getWidthD9Ej5fM(long j) {
        return C2256Dp.m20968constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21068hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-e_xh8Ic, reason: not valid java name */
    public static final long m21069minuse_xh8Ic(long j, long j2) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(m21066getWidthD9Ej5fM(j) - m21066getWidthD9Ej5fM(j2));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(m21064getHeightD9Ej5fM(j) - m21064getHeightD9Ej5fM(j2));
        return m21057constructorimpl((((long) Float.floatToRawIntBits(fM20968constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM20968constructorimpl2))));
    }

    @Stable
    /* JADX INFO: renamed from: plus-e_xh8Ic, reason: not valid java name */
    public static final long m21070pluse_xh8Ic(long j, long j2) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(m21066getWidthD9Ej5fM(j2) + m21066getWidthD9Ej5fM(j));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(m21064getHeightD9Ej5fM(j2) + m21064getHeightD9Ej5fM(j));
        return m21057constructorimpl((((long) Float.floatToRawIntBits(fM20968constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM20968constructorimpl2))));
    }

    @Stable
    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m21072timesGh9hcWk(long j, int i) {
        float f = i;
        return m21057constructorimpl((((long) Float.floatToRawIntBits(C2256Dp.m20968constructorimpl(m21066getWidthD9Ej5fM(j) * f))) << 32) | (((long) Float.floatToRawIntBits(C2256Dp.m20968constructorimpl(m21064getHeightD9Ej5fM(j) * f))) & 4294967295L));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21073toStringimpl(long j) {
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "DpSize.Unspecified";
        }
        return ((Object) C2256Dp.m20979toStringimpl(m21066getWidthD9Ej5fM(j))) + " x " + ((Object) C2256Dp.m20979toStringimpl(m21064getHeightD9Ej5fM(j)));
    }

    public boolean equals(Object obj) {
        return m21062equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m21068hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m21073toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    @Stable
    /* JADX INFO: renamed from: div-Gh9hcWk, reason: not valid java name */
    public static final long m21060divGh9hcWk(long j, float f) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(m21066getWidthD9Ej5fM(j) / f);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(m21064getHeightD9Ej5fM(j) / f);
        return m21057constructorimpl((((long) Float.floatToRawIntBits(fM20968constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM20968constructorimpl2)) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: times-Gh9hcWk, reason: not valid java name */
    public static final long m21071timesGh9hcWk(long j, float f) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(m21066getWidthD9Ej5fM(j) * f);
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(m21064getHeightD9Ej5fM(j) * f);
        return m21057constructorimpl((((long) Float.floatToRawIntBits(fM20968constructorimpl)) << 32) | (((long) Float.floatToRawIntBits(fM20968constructorimpl2)) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: getHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m21065getHeightD9Ej5fM$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getWidth-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m21067getWidthD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m21057constructorimpl(long j) {
        return j;
    }
}
