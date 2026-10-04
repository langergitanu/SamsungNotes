package org.apache.commons.text.numbers;

import androidx.exifinterface.media.ExifInterface;
import java.text.DecimalFormatSymbols;
import java.util.Objects;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import org.apache.commons.text.numbers.DoubleFormat;
import org.apache.commons.text.numbers.ParsedDecimal;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'PLAIN' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DoubleFormat {
    private static final /* synthetic */ DoubleFormat[] $VALUES = $values();
    public static final DoubleFormat ENGINEERING;
    public static final DoubleFormat MIXED;
    public static final DoubleFormat PLAIN;
    public static final DoubleFormat SCIENTIFIC;
    private final Function<Builder, DoubleFunction<String>> factory;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class AbstractDoubleFormat implements DoubleFunction<String>, ParsedDecimal.FormatOptions {
        private final boolean alwaysIncludeExponent;
        private final char decimalSeparator;
        private final char[] digits;
        private final char[] exponentSeparatorChars;
        private final boolean fractionPlaceholder;
        private final boolean groupThousands;
        private final char groupingSeparator;
        private final int maxPrecision;
        private final int minDecimalExponent;
        private final char minusSign;
        private final String nan;
        private final String negativeInfinity;
        private final String positiveInfinity;
        private final boolean signedZero;

        public AbstractDoubleFormat(Builder builder) {
            this.maxPrecision = builder.maxPrecision;
            this.minDecimalExponent = builder.minDecimalExponent;
            this.positiveInfinity = builder.infinity;
            this.negativeInfinity = builder.minusSign + builder.infinity;
            this.nan = builder.nan;
            this.fractionPlaceholder = builder.fractionPlaceholder;
            this.signedZero = builder.signedZero;
            this.digits = builder.digits.toCharArray();
            this.decimalSeparator = builder.decimalSeparator;
            this.groupingSeparator = builder.groupingSeparator;
            this.groupThousands = builder.groupThousands;
            this.minusSign = builder.minusSign;
            this.exponentSeparatorChars = builder.exponentSeparator.toCharArray();
            this.alwaysIncludeExponent = builder.alwaysIncludeExponent;
        }

        private String applyFinite(double d) {
            ParsedDecimal parsedDecimalFrom = ParsedDecimal.from(d);
            int iMax = Math.max(parsedDecimalFrom.getExponent(), this.minDecimalExponent);
            if (this.maxPrecision > 0) {
                iMax = Math.max((parsedDecimalFrom.getScientificExponent() - this.maxPrecision) + 1, iMax);
            }
            parsedDecimalFrom.round(iMax);
            return applyFiniteInternal(parsedDecimalFrom);
        }

        public abstract String applyFiniteInternal(ParsedDecimal parsedDecimal);

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public char getDecimalSeparator() {
            return this.decimalSeparator;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public char[] getDigits() {
            return this.digits;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public char[] getExponentSeparatorChars() {
            return this.exponentSeparatorChars;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public char getGroupingSeparator() {
            return this.groupingSeparator;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public char getMinusSign() {
            return this.minusSign;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public boolean isAlwaysIncludeExponent() {
            return this.alwaysIncludeExponent;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public boolean isGroupThousands() {
            return this.groupThousands;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public boolean isIncludeFractionPlaceholder() {
            return this.fractionPlaceholder;
        }

        @Override // org.apache.commons.text.numbers.ParsedDecimal.FormatOptions
        public boolean isSignedZero() {
            return this.signedZero;
        }

        @Override // java.util.function.DoubleFunction
        public String apply(double d) {
            return Double.isFinite(d) ? applyFinite(d) : Double.isInfinite(d) ? d > 0.0d ? this.positiveInfinity : this.negativeInfinity : this.nan;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder implements Supplier<DoubleFunction<String>> {
        private static final String DEFAULT_DECIMAL_DIGITS = "0123456789";
        private static final int DEFAULT_PLAIN_FORMAT_MAX_DECIMAL_EXPONENT = 6;
        private static final int DEFAULT_PLAIN_FORMAT_MIN_DECIMAL_EXPONENT = -3;
        private boolean alwaysIncludeExponent;
        private char decimalSeparator;
        private String digits;
        private String exponentSeparator;
        private final Function<Builder, DoubleFunction<String>> factory;
        private boolean fractionPlaceholder;
        private boolean groupThousands;
        private char groupingSeparator;
        private String infinity;
        private int maxPrecision;
        private int minDecimalExponent;
        private char minusSign;
        private String nan;
        private int plainFormatMaxDecimalExponent;
        private int plainFormatMinDecimalExponent;
        private boolean signedZero;

        private static String getDigitString(DecimalFormatSymbols decimalFormatSymbols) {
            int zeroDigit = decimalFormatSymbols.getZeroDigit() - DEFAULT_DECIMAL_DIGITS.charAt(0);
            char[] cArr = new char[10];
            for (int i = 0; i < 10; i++) {
                cArr[i] = (char) (DEFAULT_DECIMAL_DIGITS.charAt(i) + zeroDigit);
            }
            return String.valueOf(cArr);
        }

        public Builder allowSignedZero(boolean z) {
            this.signedZero = z;
            return this;
        }

        public Builder alwaysIncludeExponent(boolean z) {
            this.alwaysIncludeExponent = z;
            return this;
        }

        @Deprecated
        public DoubleFunction<String> build() {
            return get();
        }

        public Builder decimalSeparator(char c) {
            this.decimalSeparator = c;
            return this;
        }

        public Builder digits(String str) {
            Objects.requireNonNull(str, "digits");
            if (str.length() != 10) {
                throw new IllegalArgumentException("Digits string must contain exactly 10 characters.");
            }
            this.digits = str;
            return this;
        }

        public Builder exponentSeparator(String str) {
            Objects.requireNonNull(str, "exponentSeparator");
            this.exponentSeparator = str;
            return this;
        }

        public Builder formatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
            Objects.requireNonNull(decimalFormatSymbols, "symbols");
            return digits(getDigitString(decimalFormatSymbols)).decimalSeparator(decimalFormatSymbols.getDecimalSeparator()).groupingSeparator(decimalFormatSymbols.getGroupingSeparator()).minusSign(decimalFormatSymbols.getMinusSign()).exponentSeparator(decimalFormatSymbols.getExponentSeparator()).infinity(decimalFormatSymbols.getInfinity()).nan(decimalFormatSymbols.getNaN());
        }

        public Builder groupThousands(boolean z) {
            this.groupThousands = z;
            return this;
        }

        public Builder groupingSeparator(char c) {
            this.groupingSeparator = c;
            return this;
        }

        public Builder includeFractionPlaceholder(boolean z) {
            this.fractionPlaceholder = z;
            return this;
        }

        public Builder infinity(String str) {
            Objects.requireNonNull(str, "infinity");
            this.infinity = str;
            return this;
        }

        public Builder maxPrecision(int i) {
            this.maxPrecision = i;
            return this;
        }

        public Builder minDecimalExponent(int i) {
            this.minDecimalExponent = i;
            return this;
        }

        public Builder minusSign(char c) {
            this.minusSign = c;
            return this;
        }

        public Builder nan(String str) {
            Objects.requireNonNull(str, "nan");
            this.nan = str;
            return this;
        }

        public Builder plainFormatMaxDecimalExponent(int i) {
            this.plainFormatMaxDecimalExponent = i;
            return this;
        }

        public Builder plainFormatMinDecimalExponent(int i) {
            this.plainFormatMinDecimalExponent = i;
            return this;
        }

        private Builder(Function<Builder, DoubleFunction<String>> function) {
            this.minDecimalExponent = Integer.MIN_VALUE;
            this.plainFormatMaxDecimalExponent = 6;
            this.plainFormatMinDecimalExponent = -3;
            this.infinity = "Infinity";
            this.nan = "NaN";
            this.fractionPlaceholder = true;
            this.signedZero = true;
            this.digits = DEFAULT_DECIMAL_DIGITS;
            this.decimalSeparator = '.';
            this.groupingSeparator = ',';
            this.minusSign = '-';
            this.exponentSeparator = ExifInterface.LONGITUDE_EAST;
            this.factory = function;
        }

        @Override // java.util.function.Supplier
        public DoubleFunction<String> get() {
            return this.factory.apply(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class EngineeringDoubleFormat extends AbstractDoubleFormat {
        public EngineeringDoubleFormat(Builder builder) {
            super(builder);
        }

        @Override // org.apache.commons.text.numbers.DoubleFormat.AbstractDoubleFormat
        public String applyFiniteInternal(ParsedDecimal parsedDecimal) {
            return parsedDecimal.toEngineeringString(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class MixedDoubleFormat extends AbstractDoubleFormat {
        private final int plainMaxExponent;
        private final int plainMinExponent;

        public MixedDoubleFormat(Builder builder) {
            super(builder);
            this.plainMaxExponent = builder.plainFormatMaxDecimalExponent;
            this.plainMinExponent = builder.plainFormatMinDecimalExponent;
        }

        @Override // org.apache.commons.text.numbers.DoubleFormat.AbstractDoubleFormat
        public String applyFiniteInternal(ParsedDecimal parsedDecimal) {
            int scientificExponent = parsedDecimal.getScientificExponent();
            return (scientificExponent > this.plainMaxExponent || scientificExponent < this.plainMinExponent) ? parsedDecimal.toScientificString(this) : parsedDecimal.toPlainString(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class PlainDoubleFormat extends AbstractDoubleFormat {
        public PlainDoubleFormat(Builder builder) {
            super(builder);
        }

        @Override // org.apache.commons.text.numbers.DoubleFormat.AbstractDoubleFormat
        public String applyFiniteInternal(ParsedDecimal parsedDecimal) {
            return parsedDecimal.toPlainString(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ScientificDoubleFormat extends AbstractDoubleFormat {
        public ScientificDoubleFormat(Builder builder) {
            super(builder);
        }

        @Override // org.apache.commons.text.numbers.DoubleFormat.AbstractDoubleFormat
        public String applyFiniteInternal(ParsedDecimal parsedDecimal) {
            return parsedDecimal.toScientificString(this);
        }
    }

    private static /* synthetic */ DoubleFormat[] $values() {
        return new DoubleFormat[]{PLAIN, SCIENTIFIC, ENGINEERING, MIXED};
    }

    static {
        final int i = 0;
        PLAIN = new DoubleFormat("PLAIN", 0, new Function() { // from class: org.apache.commons.text.numbers.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                switch (i) {
                    case 0:
                        return new DoubleFormat.PlainDoubleFormat((DoubleFormat.Builder) obj);
                    case 1:
                        return new DoubleFormat.ScientificDoubleFormat((DoubleFormat.Builder) obj);
                    case 2:
                        return new DoubleFormat.EngineeringDoubleFormat((DoubleFormat.Builder) obj);
                    default:
                        return new DoubleFormat.MixedDoubleFormat((DoubleFormat.Builder) obj);
                }
            }
        });
        final int i2 = 1;
        SCIENTIFIC = new DoubleFormat("SCIENTIFIC", 1, new Function() { // from class: org.apache.commons.text.numbers.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                switch (i2) {
                    case 0:
                        return new DoubleFormat.PlainDoubleFormat((DoubleFormat.Builder) obj);
                    case 1:
                        return new DoubleFormat.ScientificDoubleFormat((DoubleFormat.Builder) obj);
                    case 2:
                        return new DoubleFormat.EngineeringDoubleFormat((DoubleFormat.Builder) obj);
                    default:
                        return new DoubleFormat.MixedDoubleFormat((DoubleFormat.Builder) obj);
                }
            }
        });
        final int i4 = 2;
        ENGINEERING = new DoubleFormat("ENGINEERING", 2, new Function() { // from class: org.apache.commons.text.numbers.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                switch (i4) {
                    case 0:
                        return new DoubleFormat.PlainDoubleFormat((DoubleFormat.Builder) obj);
                    case 1:
                        return new DoubleFormat.ScientificDoubleFormat((DoubleFormat.Builder) obj);
                    case 2:
                        return new DoubleFormat.EngineeringDoubleFormat((DoubleFormat.Builder) obj);
                    default:
                        return new DoubleFormat.MixedDoubleFormat((DoubleFormat.Builder) obj);
                }
            }
        });
        final int i5 = 3;
        MIXED = new DoubleFormat("MIXED", 3, new Function() { // from class: org.apache.commons.text.numbers.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                switch (i5) {
                    case 0:
                        return new DoubleFormat.PlainDoubleFormat((DoubleFormat.Builder) obj);
                    case 1:
                        return new DoubleFormat.ScientificDoubleFormat((DoubleFormat.Builder) obj);
                    case 2:
                        return new DoubleFormat.EngineeringDoubleFormat((DoubleFormat.Builder) obj);
                    default:
                        return new DoubleFormat.MixedDoubleFormat((DoubleFormat.Builder) obj);
                }
            }
        });
    }

    private DoubleFormat(String str, int i, Function function) {
        this.factory = function;
    }

    public static DoubleFormat valueOf(String str) {
        return (DoubleFormat) Enum.valueOf(DoubleFormat.class, str);
    }

    public static DoubleFormat[] values() {
        return (DoubleFormat[]) $VALUES.clone();
    }

    public Builder builder() {
        return new Builder(this.factory);
    }
}
