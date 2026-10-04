package androidx.compose.p109ui.graphics;

import com.samsung.android.imagetranslation.common.LttEngineErrors;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000f\b\u0081@\u0018\u0000 R2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001RB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\nJ\u0013\u0010\u0015\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\nJ\u0013\u0010\u0017\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001b\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001fHÖ\u0003¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010\nJ\u0010\u0010$\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010\u000eJ\r\u0010&\u001a\u00020\u001e¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u001e¢\u0006\u0004\b*\u0010(J\r\u0010+\u001a\u00020\u001e¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b.\u0010(J\u0013\u0010/\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u0010\nJ\r\u00101\u001a\u00020\f¢\u0006\u0004\b2\u0010\u000eJ\r\u00103\u001a\u000204¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u0003¢\u0006\u0004\b;\u0010<J\r\u0010=\u001a\u00020>¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\f¢\u0006\u0004\bB\u0010\u000eJ\r\u0010C\u001a\u00020D¢\u0006\u0004\bE\u0010FJ\r\u0010G\u001a\u00020\f¢\u0006\u0004\bH\u0010\u000eJ\r\u0010I\u001a\u00020\t¢\u0006\u0004\bJ\u0010\nJ\u000f\u0010K\u001a\u00020>H\u0016¢\u0006\u0004\bL\u0010@J\u0013\u0010M\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\nJ\u0018\u0010O\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010QR\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0088\u0001\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006S"}, m13886d2 = {"Landroidx/compose/ui/graphics/Float16;", "", "value", "", "constructor-impl", "(F)S", "", "(D)S", "halfValue", "", "(S)S", "exponent", "", "getExponent-impl", "(S)I", "getHalfValue", "()S", "sign", "getSign-slo4al4", "significand", "getSignificand-impl", "absoluteValue", "absoluteValue-slo4al4", "ceil", "ceil-slo4al4", "compareTo", "other", "compareTo-41bOqos", "(SS)I", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floor", "floor-slo4al4", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(S)Z", "isInfinite", "isInfinite-impl", "isNaN", "isNaN-impl", "isNormalized", "isNormalized-impl", "round", "round-slo4al4", "toBits", "toBits-impl", "toByte", "", "toByte-impl", "(S)B", "toDouble", "toDouble-impl", "(S)D", "toFloat", "toFloat-impl", "(S)F", "toHexString", "", "toHexString-impl", "(S)Ljava/lang/String;", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toRawBits", "toRawBits-impl", "toShort", "toShort-impl", "toString", "toString-impl", "trunc", "trunc-slo4al4", "withSign", "withSign-qCeQghg", "(SS)S", "Companion", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@JvmInline
@SourceDebugExtension({"SMAP\nFloat16.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Float16.kt\nandroidx/compose/ui/graphics/Float16\n+ 2 Float16.kt\nandroidx/compose/ui/graphics/Float16Kt\n+ 3 InlineClassHelper.jvm.kt\nandroidx/compose/ui/util/InlineClassHelper_jvmKt\n*L\n1#1,717:1\n605#2,38:718\n650#2,12:756\n662#2,17:769\n592#2,4:786\n22#3:768\n*S KotlinDebug\n*F\n+ 1 Float16.kt\nandroidx/compose/ui/graphics/Float16\n*L\n98#1:718,38\n151#1:756,12\n151#1:769,17\n217#1:786,4\n151#1:768\n*E\n"})
public final class Float16 implements Comparable<Float16> {
    public static final int MaxExponent = 15;
    public static final int MinExponent = -14;
    public static final int Size = 16;
    private final short halfValue;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final short Epsilon = m18634constructorimpl((short) 5120);
    private static final short LowestValue = m18634constructorimpl((short) -1025);
    private static final short MaxValue = m18634constructorimpl((short) 31743);
    private static final short MinNormal = m18634constructorimpl((short) 1024);
    private static final short MinValue = m18634constructorimpl((short) 1);
    private static final short NaN = m18634constructorimpl((short) 32256);
    private static final short NegativeInfinity = m18634constructorimpl((short) -1024);
    private static final short NegativeZero = m18634constructorimpl(ShortCompanionObject.MIN_VALUE);
    private static final short PositiveInfinity = m18634constructorimpl((short) 31744);
    private static final short PositiveZero = m18634constructorimpl((short) 0);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0010\u0010\u0006R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0012\u0010\u0006R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0014\u0010\u0006R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0016\u0010\u0006R\u0019\u0010\u0017\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0018\u0010\u0006R\u0019\u0010\u0019\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001a\u0010\u0006R\u0019\u0010\u001b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001c\u0010\u0006R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, m13886d2 = {"Landroidx/compose/ui/graphics/Float16$Companion;", "", "()V", "Epsilon", "Landroidx/compose/ui/graphics/Float16;", "getEpsilon-slo4al4", "()S", "S", "LowestValue", "getLowestValue-slo4al4", "MaxExponent", "", "MaxValue", "getMaxValue-slo4al4", "MinExponent", "MinNormal", "getMinNormal-slo4al4", "MinValue", "getMinValue-slo4al4", "NaN", "getNaN-slo4al4", "NegativeInfinity", "getNegativeInfinity-slo4al4", "NegativeZero", "getNegativeZero-slo4al4", "PositiveInfinity", "getPositiveInfinity-slo4al4", "PositiveZero", "getPositiveZero-slo4al4", "Size", "ui-graphics_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: renamed from: getEpsilon-slo4al4, reason: not valid java name */
        public final short m18661getEpsilonslo4al4() {
            return Float16.Epsilon;
        }

        /* JADX INFO: renamed from: getLowestValue-slo4al4, reason: not valid java name */
        public final short m18662getLowestValueslo4al4() {
            return Float16.LowestValue;
        }

        /* JADX INFO: renamed from: getMaxValue-slo4al4, reason: not valid java name */
        public final short m18663getMaxValueslo4al4() {
            return Float16.MaxValue;
        }

        /* JADX INFO: renamed from: getMinNormal-slo4al4, reason: not valid java name */
        public final short m18664getMinNormalslo4al4() {
            return Float16.MinNormal;
        }

        /* JADX INFO: renamed from: getMinValue-slo4al4, reason: not valid java name */
        public final short m18665getMinValueslo4al4() {
            return Float16.MinValue;
        }

        /* JADX INFO: renamed from: getNaN-slo4al4, reason: not valid java name */
        public final short m18666getNaNslo4al4() {
            return Float16.NaN;
        }

        /* JADX INFO: renamed from: getNegativeInfinity-slo4al4, reason: not valid java name */
        public final short m18667getNegativeInfinityslo4al4() {
            return Float16.NegativeInfinity;
        }

        /* JADX INFO: renamed from: getNegativeZero-slo4al4, reason: not valid java name */
        public final short m18668getNegativeZeroslo4al4() {
            return Float16.NegativeZero;
        }

        /* JADX INFO: renamed from: getPositiveInfinity-slo4al4, reason: not valid java name */
        public final short m18669getPositiveInfinityslo4al4() {
            return Float16.PositiveInfinity;
        }

        /* JADX INFO: renamed from: getPositiveZero-slo4al4, reason: not valid java name */
        public final short m18670getPositiveZeroslo4al4() {
            return Float16.PositiveZero;
        }

        private Companion() {
        }
    }

    private /* synthetic */ Float16(short s) {
        this.halfValue = s;
    }

    /* JADX INFO: renamed from: absoluteValue-slo4al4, reason: not valid java name */
    public static final short m18628absoluteValueslo4al4(short s) {
        return m18634constructorimpl((short) (s & ShortCompanionObject.MAX_VALUE));
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Float16 m18629boximpl(short s) {
        return new Float16(s);
    }

    /* JADX INFO: renamed from: ceil-slo4al4, reason: not valid java name */
    public static final short m18630ceilslo4al4(short s) {
        int i = 65535 & s;
        int i2 = s & ShortCompanionObject.MAX_VALUE;
        if (i2 < 15360) {
            i = ((-((~(i >> 15)) & (i2 == 0 ? 0 : 1))) & 15360) | (s & ShortCompanionObject.MIN_VALUE);
        } else if (i2 < 25600) {
            int i4 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + (((i >> 15) - 1) & i4)) & (~i4);
        }
        return m18634constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m18634constructorimpl(short s) {
        return s;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m18635equalsimpl(short s, Object obj) {
        return (obj instanceof Float16) && s == ((Float16) obj).m18660unboximpl();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m18636equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* JADX INFO: renamed from: floor-slo4al4, reason: not valid java name */
    public static final short m18637floorslo4al4(short s) {
        int i = s & UShort.MAX_VALUE;
        int i2 = s & ShortCompanionObject.MAX_VALUE;
        if (i2 < 15360) {
            i = (s & ShortCompanionObject.MIN_VALUE) | ((i <= 32768 ? 0 : 65535) & 15360);
        } else if (i2 < 25600) {
            int i4 = (1 << (25 - (i2 >> 10))) - 1;
            i = (i + ((-(i >> 15)) & i4)) & (~i4);
        }
        return m18634constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: getExponent-impl, reason: not valid java name */
    public static final int m18638getExponentimpl(short s) {
        return ((s >>> 10) & 31) - 15;
    }

    /* JADX INFO: renamed from: getSign-slo4al4, reason: not valid java name */
    public static final short m18639getSignslo4al4(short s) {
        return m18644isNaNimpl(s) ? NaN : m18631compareTo41bOqos(s, NegativeZero) < 0 ? Float16Kt.NegativeOne : m18631compareTo41bOqos(s, PositiveZero) > 0 ? Float16Kt.One : s;
    }

    /* JADX INFO: renamed from: getSignificand-impl, reason: not valid java name */
    public static final int m18640getSignificandimpl(short s) {
        return s & 1023;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m18641hashCodeimpl(short s) {
        return Short.hashCode(s);
    }

    /* JADX INFO: renamed from: isFinite-impl, reason: not valid java name */
    public static final boolean m18642isFiniteimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) != 31744;
    }

    /* JADX INFO: renamed from: isInfinite-impl, reason: not valid java name */
    public static final boolean m18643isInfiniteimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) == 31744;
    }

    /* JADX INFO: renamed from: isNaN-impl, reason: not valid java name */
    public static final boolean m18644isNaNimpl(short s) {
        return (s & ShortCompanionObject.MAX_VALUE) > 31744;
    }

    /* JADX INFO: renamed from: isNormalized-impl, reason: not valid java name */
    public static final boolean m18645isNormalizedimpl(short s) {
        int i = s & 31744;
        return (i == 0 || i == 31744) ? false : true;
    }

    /* JADX INFO: renamed from: round-slo4al4, reason: not valid java name */
    public static final short m18646roundslo4al4(short s) {
        int i = s & UShort.MAX_VALUE;
        int i2 = s & ShortCompanionObject.MAX_VALUE;
        if (i2 < 15360) {
            i = (s & ShortCompanionObject.MIN_VALUE) | ((i2 < 14336 ? 0 : 65535) & 15360);
        } else if (i2 < 25600) {
            int i4 = i2 >> 10;
            i = (i + (1 << (24 - i4))) & (~((1 << (25 - i4)) - 1));
        }
        return m18634constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: toBits-impl, reason: not valid java name */
    public static final int m18647toBitsimpl(short s) {
        return m18644isNaNimpl(s) ? NaN : s & UShort.MAX_VALUE;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    public static final byte m18648toByteimpl(short s) {
        return (byte) m18650toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    public static final double m18649toDoubleimpl(short s) {
        return m18650toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    public static final float m18650toFloatimpl(short s) {
        int i;
        int i2;
        int i4;
        int i5 = Short.MIN_VALUE & s;
        int i6 = ((65535 & s) >>> 10) & 31;
        int i7 = s & 1023;
        if (i6 != 0) {
            int i8 = i7 << 13;
            if (i6 == 31) {
                i = 255;
                if (i8 != 0) {
                    i8 |= 4194304;
                }
            } else {
                i = i6 + 112;
            }
            int i9 = i;
            i2 = i8;
            i4 = i9;
        } else {
            if (i7 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i7 + 1056964608) - Float16Kt.Fp32DenormalFloat;
                return i5 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i4 = 0;
            i2 = 0;
        }
        return Float.intBitsToFloat((i4 << 23) | (i5 << 16) | i2);
    }

    @NotNull
    /* JADX INFO: renamed from: toHexString-impl, reason: not valid java name */
    public static final String m18651toHexStringimpl(short s) {
        StringBuilder sb = new StringBuilder();
        int i = 65535 & s;
        int i2 = i >>> 15;
        int i4 = (i >>> 10) & 31;
        int i5 = s & 1023;
        if (i4 != 31) {
            if (i2 == 1) {
                sb.append('-');
            }
            if (i4 != 0) {
                sb.append("0x1.");
                String string = Integer.toString(i5, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(string, ""));
                sb.append('p');
                sb.append(String.valueOf(i4 - 15));
            } else if (i5 == 0) {
                sb.append("0x0.0p0");
            } else {
                sb.append("0x0.");
                String string2 = Integer.toString(i5, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
                sb.append(new Regex("0{2,}$").replaceFirst(string2, ""));
                sb.append("p-14");
            }
        } else if (i5 == 0) {
            if (i2 != 0) {
                sb.append('-');
            }
            sb.append("Infinity");
        } else {
            sb.append("NaN");
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    public static final int m18652toIntimpl(short s) {
        return (int) m18650toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    public static final long m18653toLongimpl(short s) {
        return (long) m18650toFloatimpl(s);
    }

    /* JADX INFO: renamed from: toRawBits-impl, reason: not valid java name */
    public static final int m18654toRawBitsimpl(short s) {
        return s & UShort.MAX_VALUE;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    public static final short m18655toShortimpl(short s) {
        return (short) m18650toFloatimpl(s);
    }

    @NotNull
    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m18656toStringimpl(short s) {
        return String.valueOf(m18650toFloatimpl(s));
    }

    /* JADX INFO: renamed from: trunc-slo4al4, reason: not valid java name */
    public static final short m18657truncslo4al4(short s) {
        int i = 65535 & s;
        int i2 = s & ShortCompanionObject.MAX_VALUE;
        if (i2 < 15360) {
            i = Short.MIN_VALUE & s;
        } else if (i2 < 25600) {
            i &= ~((1 << (25 - (i2 >> 10))) - 1);
        }
        return m18634constructorimpl((short) i);
    }

    /* JADX INFO: renamed from: withSign-qCeQghg, reason: not valid java name */
    public static final short m18658withSignqCeQghg(short s, short s2) {
        return m18634constructorimpl((short) ((s & ShortCompanionObject.MAX_VALUE) | (s2 & ShortCompanionObject.MIN_VALUE)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return m18659compareTo41bOqos(float16.m18660unboximpl());
    }

    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public int m18659compareTo41bOqos(short s) {
        return m18631compareTo41bOqos(this.halfValue, s);
    }

    public boolean equals(Object obj) {
        return m18635equalsimpl(this.halfValue, obj);
    }

    public final short getHalfValue() {
        return this.halfValue;
    }

    public int hashCode() {
        return m18641hashCodeimpl(this.halfValue);
    }

    @NotNull
    public String toString() {
        return m18656toStringimpl(this.halfValue);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m18660unboximpl() {
        return this.halfValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: compareTo-41bOqos, reason: not valid java name */
    public static int m18631compareTo41bOqos(short s, short s2) {
        if (m18644isNaNimpl(s)) {
            return !m18644isNaNimpl(s2) ? 1 : 0;
        }
        if (m18644isNaNimpl(s2)) {
            return -1;
        }
        return Intrinsics.compare((s & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s & UShort.MAX_VALUE) : s & UShort.MAX_VALUE, (s2 & ShortCompanionObject.MIN_VALUE) != 0 ? 32768 - (s2 & UShort.MAX_VALUE) : s2 & UShort.MAX_VALUE);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m18632constructorimpl(double d) {
        return m18633constructorimpl((float) d);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m18633constructorimpl(float f) {
        int i;
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i2 = iFloatToRawIntBits >>> 31;
        int i4 = (iFloatToRawIntBits >>> 23) & 255;
        int i5 = 8388607 & iFloatToRawIntBits;
        int i6 = 31;
        int i7 = 0;
        if (i4 != 255) {
            int i8 = i4 + LttEngineErrors.ERROR_INPAINTING_OCR_BLOCK_EMPTY;
            if (i8 >= 31) {
                i6 = 49;
            } else if (i8 > 0) {
                i7 = i5 >> 13;
                if ((iFloatToRawIntBits & 4096) != 0) {
                    i = (((i8 << 10) | i7) + 1) | (i2 << 15);
                    return m18634constructorimpl((short) i);
                }
                i6 = i8;
            } else if (i8 >= -10) {
                int i9 = (8388608 | i5) >> (1 - i8);
                if ((i9 & 4096) != 0) {
                    i9 += 8192;
                }
                i6 = 0;
                i7 = i9 >> 13;
            } else {
                i6 = 0;
            }
        } else if (i5 != 0) {
            i7 = 512;
        }
        i = (i2 << 15) | (i6 << 10) | i7;
        return m18634constructorimpl((short) i);
    }
}
