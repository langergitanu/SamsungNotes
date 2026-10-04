package com.opencsv.bean;

import com.opencsv.ICSVParser;
import com.opencsv.exceptions.CsvBadConverterException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ConverterNumber extends AbstractCsvConverter {
    private final UnaryOperator<Number> readConversionFunction;
    private final DecimalFormat readFormatter;
    private final DecimalFormat writeFormatter;

    public ConverterNumber(Class<?> cls, String str, String str2, Locale locale, String str3, String str4, RoundingMode roundingMode) {
        super(cls, str, str2, locale);
        if (!Number.class.isAssignableFrom(this.type.isPrimitive() ? ClassUtils.primitiveToWrapper(this.type) : this.type)) {
            throw new CsvBadConverterException(ConverterNumber.class, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("csvnumber.not.number"));
        }
        DecimalFormat decimalFormatCreateDecimalFormat = createDecimalFormat(str3, this.locale, roundingMode);
        this.readFormatter = decimalFormatCreateDecimalFormat;
        Class<?> cls2 = this.type;
        if (cls2 == BigInteger.class || cls2 == BigDecimal.class) {
            decimalFormatCreateDecimalFormat.setParseBigDecimal(true);
        }
        Class<?> cls3 = this.type;
        if (cls3 == Byte.class || cls3 == Byte.TYPE) {
            final int i = 0;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else if (cls3 == Short.class || cls3 == Short.TYPE) {
            final int i2 = 1;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i2) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else if (cls3 == Integer.class || cls3 == Integer.TYPE) {
            final int i4 = 2;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i4) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else if (cls3 == Long.class || cls3 == Long.TYPE) {
            final int i5 = 3;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i5) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else if (cls3 == Float.class || cls3 == Float.TYPE) {
            final int i6 = 4;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i6) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else if (cls3 == Double.class || cls3 == Double.TYPE) {
            final int i7 = 5;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i7) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else if (cls3 == BigInteger.class) {
            final int i8 = 6;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i8) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        } else {
            final int i9 = 7;
            this.readConversionFunction = new UnaryOperator() { // from class: com.opencsv.bean.h
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Number number = (Number) obj;
                    switch (i9) {
                        case 0:
                            return Byte.valueOf(number.byteValue());
                        case 1:
                            return Short.valueOf(number.shortValue());
                        case 2:
                            return Integer.valueOf(number.intValue());
                        case 3:
                            return Long.valueOf(number.longValue());
                        case 4:
                            return Float.valueOf(number.floatValue());
                        case 5:
                            return Double.valueOf(number.doubleValue());
                        case 6:
                            return ConverterNumber.lambda$new$0(number);
                        default:
                            return ConverterNumber.lambda$new$1(number);
                    }
                }
            };
        }
        this.writeFormatter = createDecimalFormat(str4, this.writeLocale, roundingMode);
    }

    private DecimalFormat createDecimalFormat(String str, Locale locale, RoundingMode roundingMode) {
        NumberFormat numberFormat = NumberFormat.getInstance((Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault(Locale.Category.FORMAT)));
        if (!(numberFormat instanceof DecimalFormat)) {
            throw new CsvBadConverterException(ConverterNumber.class, ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("numberformat.not.decimalformat"));
        }
        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        try {
            decimalFormat.applyLocalizedPattern(str);
            decimalFormat.setRoundingMode(roundingMode);
            return decimalFormat;
        } catch (IllegalArgumentException e) {
            CsvBadConverterException csvBadConverterException = new CsvBadConverterException(ConverterNumber.class, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("invalid.number.pattern"), str));
            csvBadConverterException.initCause(e);
            throw csvBadConverterException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Number lambda$new$0(Number number) {
        return ((BigDecimal) number).toBigInteger();
    }

    @Override // com.opencsv.bean.CsvConverter
    public Object convertToRead(String str) throws CsvDataTypeMismatchException {
        Number number;
        if (!StringUtils.isNotEmpty(str)) {
            return null;
        }
        try {
            synchronized (this.readFormatter) {
                number = this.readFormatter.parse(str);
            }
            return (Number) this.readConversionFunction.apply(number);
        } catch (ArithmeticException | ParseException e) {
            CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(str, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("unparsable.number"), str, this.readFormatter.toPattern()));
            csvDataTypeMismatchException.initCause(e);
            throw csvDataTypeMismatchException;
        }
    }

    @Override // com.opencsv.bean.AbstractCsvConverter, com.opencsv.bean.CsvConverter
    public String convertToWrite(Object obj) {
        String str;
        synchronized (this.writeFormatter) {
            if (obj != null) {
                try {
                    str = this.writeFormatter.format(obj);
                } catch (ArithmeticException e) {
                    CsvDataTypeMismatchException csvDataTypeMismatchException = new CsvDataTypeMismatchException(obj, this.type, String.format(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("unparsable.number"), obj, this.writeFormatter.toPattern()));
                    csvDataTypeMismatchException.initCause(e);
                    throw csvDataTypeMismatchException;
                }
            } else {
                str = null;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Number lambda$new$1(Number number) {
        return number;
    }
}
