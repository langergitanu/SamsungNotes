package androidx.compose.p109ui.unit;

import androidx.compose.p109ui.geometry.InlineClassHelperKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ\u000f\u0010!\u001a\u00020\"H\u0017¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\u00020\t8FX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, m13886d2 = {"Landroidx/compose/ui/unit/DpOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "Landroidx/compose/ui/unit/Dp;", "getX-D9Ej5fM$annotations", "getX-D9Ej5fM", "(J)F", "y", "getY-D9Ej5fM$annotations", "getY-D9Ej5fM", "copy", "copy-tPigGR8", "(JFF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "minus", "minus-CB-Mgk4", "(JJ)J", "plus", "plus-CB-Mgk4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@JvmInline
@SourceDebugExtension({"SMAP\nDp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/DpOffset\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n+ 4 Dp.kt\nandroidx/compose/ui/unit/DpKt\n+ 5 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n1#1,577:1\n72#2:578\n86#2:581\n63#2,3:584\n63#2,3:589\n63#2,3:594\n22#3:579\n22#3:582\n169#4:580\n169#4:583\n325#4:597\n57#5:587\n57#5:588\n51#5:592\n51#5:593\n*S KotlinDebug\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/DpOffset\n*L\n261#1:578\n267#1:581\n273#1:584,3\n280#1:589,3\n291#1:594,3\n261#1:579\n267#1:582\n261#1:580\n267#1:583\n299#1:597\n281#1:587\n282#1:588\n292#1:592\n293#1:593\n*E\n"})
public final class DpOffset {
    private final long packedValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m21024constructorimpl(0);
    private static final long Unspecified = m21024constructorimpl(InlineClassHelperKt.UnspecifiedPackedFloats);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, m13886d2 = {"Landroidx/compose/ui/unit/DpOffset$Companion;", "", "()V", "Unspecified", "Landroidx/compose/ui/unit/DpOffset;", "getUnspecified-RKDOV3M", "()J", "J", "Zero", "getZero-RKDOV3M", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getUnspecified-RKDOV3M, reason: not valid java name */
        public final long m21038getUnspecifiedRKDOV3M() {
            return DpOffset.Unspecified;
        }

        /* JADX INFO: renamed from: getZero-RKDOV3M, reason: not valid java name */
        public final long m21039getZeroRKDOV3M() {
            return DpOffset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ DpOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ DpOffset m21023boximpl(long j) {
        return new DpOffset(j);
    }

    /* JADX INFO: renamed from: copy-tPigGR8, reason: not valid java name */
    public static final long m21025copytPigGR8(long j, float f, float f4) {
        return m21024constructorimpl((((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-tPigGR8$default, reason: not valid java name */
    public static /* synthetic */ long m21026copytPigGR8$default(long j, float f, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = m21029getXD9Ej5fM(j);
        }
        if ((i & 2) != 0) {
            f4 = m21031getYD9Ej5fM(j);
        }
        return m21025copytPigGR8(j, f, f4);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21027equalsimpl(long j, Object obj) {
        return (obj instanceof DpOffset) && j == ((DpOffset) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21028equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public static final float m21029getXD9Ej5fM(long j) {
        return C2256Dp.m20968constructorimpl(Float.intBitsToFloat((int) (j >> 32)));
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public static final float m21031getYD9Ej5fM(long j) {
        return C2256Dp.m20968constructorimpl(Float.intBitsToFloat((int) (j & 4294967295L)));
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21033hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-CB-Mgk4, reason: not valid java name */
    public static final long m21034minusCBMgk4(long j, long j2) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(m21029getXD9Ej5fM(j) - m21029getXD9Ej5fM(j2));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(m21031getYD9Ej5fM(j) - m21031getYD9Ej5fM(j2));
        return m21024constructorimpl((((long) Float.floatToRawIntBits(fM20968constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM20968constructorimpl2))));
    }

    @Stable
    /* JADX INFO: renamed from: plus-CB-Mgk4, reason: not valid java name */
    public static final long m21035plusCBMgk4(long j, long j2) {
        float fM20968constructorimpl = C2256Dp.m20968constructorimpl(m21029getXD9Ej5fM(j2) + m21029getXD9Ej5fM(j));
        float fM20968constructorimpl2 = C2256Dp.m20968constructorimpl(m21031getYD9Ej5fM(j2) + m21031getYD9Ej5fM(j));
        return m21024constructorimpl((((long) Float.floatToRawIntBits(fM20968constructorimpl)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(fM20968constructorimpl2))));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21036toStringimpl(long j) {
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "DpOffset.Unspecified";
        }
        return "(" + ((Object) C2256Dp.m20979toStringimpl(m21029getXD9Ej5fM(j))) + SQLKeyword.COMMA + ((Object) C2256Dp.m20979toStringimpl(m21031getYD9Ej5fM(j))) + PropertyUtils.MAPPED_DELIM2;
    }

    public boolean equals(Object obj) {
        return m21027equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m21033hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m21036toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getX-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m21030getXD9Ej5fM$annotations() {
    }

    @Stable
    /* JADX INFO: renamed from: getY-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m21032getYD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m21024constructorimpl(long j) {
        return j;
    }
}
