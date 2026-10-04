package androidx.compose.p109ui.unit;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import opennlp.tools.tokenize.TokenizerME;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: androidx.compose.ui.unit.Dp */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0087@\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001&B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000fJ\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000fJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u000fJ\u001e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0011J\u000f\u0010 \u001a\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0016\u0010$\u001a\u00020\u0000H\u0087\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, m13886d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "compareTo", "", "other", "compareTo-0680j_4", "(FF)I", "div", "div-0680j_4", "(FF)F", "div-u2uoSUM", "(FI)F", "equals", "", "", "equals-impl", "(FLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(F)I", "minus", "minus-5rwHm24", "plus", "plus-5rwHm24", "times", "times-u2uoSUM", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "unaryMinus", "unaryMinus-D9Ej5fM", "Companion", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@Immutable
@JvmInline
@SourceDebugExtension({"SMAP\nDp.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/Dp\n+ 2 Dp.kt\nandroidx/compose/ui/unit/DpKt\n*L\n1#1,577:1\n132#2:578\n*S KotlinDebug\n*F\n+ 1 Dp.kt\nandroidx/compose/ui/unit/Dp\n*L\n96#1:578\n*E\n"})
public final class C2256Dp implements Comparable<C2256Dp> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final float Hairline = m20968constructorimpl(0.0f);
    private static final float Infinity = m20968constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m20968constructorimpl(Float.NaN);
    private final float value;

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Dp$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\u0007R$\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u0007\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, m13886d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", TokenizerME.NO_SPLIT, "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m20986getHairlineD9Ej5fM() {
            return C2256Dp.Hairline;
        }

        /* JADX INFO: renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m20987getInfinityD9Ej5fM() {
            return C2256Dp.Infinity;
        }

        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m20988getUnspecifiedD9Ej5fM() {
            return C2256Dp.Unspecified;
        }

        private Companion() {
        }

        @Stable
        /* JADX INFO: renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m20983getHairlineD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m20984getInfinityD9Ej5fM$annotations() {
        }

        @Stable
        /* JADX INFO: renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m20985getUnspecifiedD9Ej5fM$annotations() {
        }
    }

    private /* synthetic */ C2256Dp(float f) {
        this.value = f;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ C2256Dp m20966boximpl(float f) {
        return new C2256Dp(f);
    }

    @Stable
    /* JADX INFO: renamed from: div-0680j_4, reason: not valid java name */
    public static final float m20969div0680j_4(float f, float f4) {
        return f / f4;
    }

    @Stable
    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m20970divu2uoSUM(float f, float f4) {
        return m20968constructorimpl(f / f4);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m20972equalsimpl(float f, Object obj) {
        return (obj instanceof C2256Dp) && Float.compare(f, ((C2256Dp) obj).m20982unboximpl()) == 0;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m20973equalsimpl0(float f, float f4) {
        return Float.compare(f, f4) == 0;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m20974hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    @Stable
    /* JADX INFO: renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m20975minus5rwHm24(float f, float f4) {
        return m20968constructorimpl(f - f4);
    }

    @Stable
    /* JADX INFO: renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m20976plus5rwHm24(float f, float f4) {
        return m20968constructorimpl(f + f4);
    }

    @Stable
    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m20977timesu2uoSUM(float f, float f4) {
        return m20968constructorimpl(f * f4);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m20979toStringimpl(float f) {
        if (Float.isNaN(f)) {
            return "Dp.Unspecified";
        }
        return f + ".dp";
    }

    @Stable
    /* JADX INFO: renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m20980unaryMinusD9Ej5fM(float f) {
        return m20968constructorimpl(-f);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(C2256Dp c2256Dp) {
        return m20981compareTo0680j_4(c2256Dp.m20982unboximpl());
    }

    @Stable
    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m20981compareTo0680j_4(float f) {
        return m20967compareTo0680j_4(this.value, f);
    }

    public boolean equals(Object obj) {
        return m20972equalsimpl(this.value, obj);
    }

    public final float getValue() {
        return this.value;
    }

    public int hashCode() {
        return m20974hashCodeimpl(this.value);
    }

    @Stable
    @NotNull
    public String toString() {
        return m20979toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m20982unboximpl() {
        return this.value;
    }

    @Stable
    /* JADX INFO: renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m20967compareTo0680j_4(float f, float f4) {
        return Float.compare(f, f4);
    }

    @Stable
    /* JADX INFO: renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m20971divu2uoSUM(float f, int i) {
        return m20968constructorimpl(f / i);
    }

    @Stable
    /* JADX INFO: renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m20978timesu2uoSUM(float f, int i) {
        return m20968constructorimpl(f * i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static float m20968constructorimpl(float f) {
        return f;
    }
}
