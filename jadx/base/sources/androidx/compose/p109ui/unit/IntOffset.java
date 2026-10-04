package androidx.compose.p109ui.unit;

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
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 32\u00020\u0001:\u00013B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0011\u0010\fJ\u0010\u0010\u0012\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0013\u0010\fJ'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\"\u0010\fJ\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0001¢\u0006\u0004\b'\u0010%J\u001e\u0010(\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\tH\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001e\u0010+\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u001bJ\u000f\u0010-\u001a\u00020.H\u0017¢\u0006\u0004\b/\u00100J\u0016\u00101\u001a\u00020\u0000H\u0087\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\f\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00064"}, m13886d2 = {"Landroidx/compose/ui/unit/IntOffset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue$annotations", "()V", "x", "", "getX$annotations", "getX-impl", "(J)I", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-iSbpLlY", "(JII)J", "div", "operand", "", "div-Bjo55l4", "(JF)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "minus", "minus-qkQi6aY", "(JJ)J", "plus", "plus-qkQi6aY", "rem", "rem-Bjo55l4", "(JI)J", "times", "times-Bjo55l4", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "unaryMinus", "unaryMinus-nOcc-ac", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@JvmInline
@SourceDebugExtension({"SMAP\nIntOffset.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IntOffset.kt\nandroidx/compose/ui/unit/IntOffset\n+ 2 InlineClassHelper.kt\nandroidx/compose/ui/util/InlineClassHelperKt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,199:1\n107#2:200\n114#2:201\n100#2:202\n107#2,8:203\n107#2:211\n114#2:212\n100#2:213\n107#2:214\n114#2:215\n100#2:216\n107#2,8:217\n100#2:225\n107#2:226\n114#2:228\n100#2:230\n107#2:231\n114#2:233\n100#2:235\n107#2:236\n114#2:237\n100#2:238\n26#3:227\n26#3:229\n26#3:232\n26#3:234\n*S KotlinDebug\n*F\n+ 1 IntOffset.kt\nandroidx/compose/ui/unit/IntOffset\n*L\n48#1:200\n55#1:201\n68#1:202\n67#1:203,8\n77#1:211\n78#1:212\n76#1:213\n89#1:214\n90#1:215\n88#1:216\n97#1:217,8\n97#1:225\n109#1:226\n110#1:228\n108#1:230\n124#1:231\n125#1:233\n123#1:235\n139#1:236\n140#1:237\n138#1:238\n109#1:227\n110#1:229\n124#1:232\n125#1:234\n*E\n"})
public final class IntOffset {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m21090constructorimpl(0);
    private final long packedValue;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\b"}, m13886d2 = {"Landroidx/compose/ui/unit/IntOffset$Companion;", "", "()V", "Zero", "Landroidx/compose/ui/unit/IntOffset;", "getZero-nOcc-ac", "()J", "J", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getZero-nOcc-ac, reason: not valid java name */
        public final long m21106getZeronOccac() {
            return IntOffset.Zero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ IntOffset(long j) {
        this.packedValue = j;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntOffset m21087boximpl(long j) {
        return new IntOffset(j);
    }

    @Stable
    /* JADX INFO: renamed from: component1-impl, reason: not valid java name */
    public static final int m21088component1impl(long j) {
        return m21096getXimpl(j);
    }

    @Stable
    /* JADX INFO: renamed from: component2-impl, reason: not valid java name */
    public static final int m21089component2impl(long j) {
        return m21097getYimpl(j);
    }

    /* JADX INFO: renamed from: copy-iSbpLlY, reason: not valid java name */
    public static final long m21091copyiSbpLlY(long j, int i, int i2) {
        return m21090constructorimpl((((long) i) << 32) | (((long) i2) & 4294967295L));
    }

    /* JADX INFO: renamed from: copy-iSbpLlY$default, reason: not valid java name */
    public static /* synthetic */ long m21092copyiSbpLlY$default(long j, int i, int i2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = (int) (j >> 32);
        }
        if ((i4 & 2) != 0) {
            i2 = (int) (4294967295L & j);
        }
        return m21091copyiSbpLlY(j, i, i2);
    }

    @Stable
    /* JADX INFO: renamed from: div-Bjo55l4, reason: not valid java name */
    public static final long m21093divBjo55l4(long j, float f) {
        return m21090constructorimpl((((long) Math.round(((int) (j >> 32)) / f)) << 32) | (((long) Math.round(((int) (j & 4294967295L)) / f)) & 4294967295L));
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m21094equalsimpl(long j, Object obj) {
        return (obj instanceof IntOffset) && j == ((IntOffset) obj).getPackedValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m21095equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* JADX INFO: renamed from: getX-impl, reason: not valid java name */
    public static final int m21096getXimpl(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: getY-impl, reason: not valid java name */
    public static final int m21097getYimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m21098hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    @Stable
    /* JADX INFO: renamed from: minus-qkQi6aY, reason: not valid java name */
    public static final long m21099minusqkQi6aY(long j, long j2) {
        return m21090constructorimpl((((long) (((int) (j >> 32)) - ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) - ((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: plus-qkQi6aY, reason: not valid java name */
    public static final long m21100plusqkQi6aY(long j, long j2) {
        return m21090constructorimpl((((long) (((int) (j >> 32)) + ((int) (j2 >> 32)))) << 32) | (((long) (((int) (j & 4294967295L)) + ((int) (j2 & 4294967295L)))) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: rem-Bjo55l4, reason: not valid java name */
    public static final long m21101remBjo55l4(long j, int i) {
        return m21090constructorimpl((((long) (((int) (j >> 32)) % i)) << 32) | (((long) (((int) (j & 4294967295L)) % i)) & 4294967295L));
    }

    @Stable
    /* JADX INFO: renamed from: times-Bjo55l4, reason: not valid java name */
    public static final long m21102timesBjo55l4(long j, float f) {
        return m21090constructorimpl((((long) Math.round(((int) (j >> 32)) * f)) << 32) | (((long) Math.round(((int) (j & 4294967295L)) * f)) & 4294967295L));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m21103toStringimpl(long j) {
        return "(" + m21096getXimpl(j) + SQLKeyword.COMMA + m21097getYimpl(j) + PropertyUtils.MAPPED_DELIM2;
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-nOcc-ac, reason: not valid java name */
    public static final long m21104unaryMinusnOccac(long j) {
        int i = -((int) (j >> 32));
        return m21090constructorimpl((((long) (-((int) (j & 4294967295L)))) & 4294967295L) | (((long) i) << 32));
    }

    public boolean equals(Object obj) {
        return m21094equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m21098hashCodeimpl(this.packedValue);
    }

    @Stable
    @NotNull
    public String toString() {
        return m21103toStringimpl(this.packedValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getPackedValue() {
        return this.packedValue;
    }

    @PublishedApi
    public static /* synthetic */ void getPackedValue$annotations() {
    }

    @Stable
    public static /* synthetic */ void getX$annotations() {
    }

    @Stable
    public static /* synthetic */ void getY$annotations() {
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m21090constructorimpl(long j) {
        return j;
    }
}
