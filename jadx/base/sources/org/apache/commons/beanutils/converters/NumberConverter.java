package org.apache.commons.beanutils.converters;

import androidx.appcompat.widget.AbstractC0541b;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class NumberConverter extends AbstractConverter {
    private final boolean allowDecimals;
    private Locale locale;
    private String pattern;
    private boolean useLocaleFormat;
    private static final Integer ZERO = 0;
    private static final Integer ONE = 1;

    public NumberConverter(boolean z) {
        this.allowDecimals = z;
    }

    private NumberFormat getFormat() {
        NumberFormat numberFormat;
        if (this.pattern != null) {
            if (this.locale == null) {
                if (log().isDebugEnabled()) {
                    log().debug("    Using pattern '" + this.pattern + "'");
                }
                numberFormat = new DecimalFormat(this.pattern);
            } else {
                if (log().isDebugEnabled()) {
                    log().debug("    Using pattern '" + this.pattern + "' with Locale[" + this.locale + "]");
                }
                numberFormat = new DecimalFormat(this.pattern, new DecimalFormatSymbols(this.locale));
            }
        } else if (this.locale == null) {
            if (log().isDebugEnabled()) {
                log().debug("    Using default Locale format");
            }
            numberFormat = NumberFormat.getInstance();
        } else {
            if (log().isDebugEnabled()) {
                log().debug("    Using Locale[" + this.locale + "] format");
            }
            numberFormat = NumberFormat.getInstance(this.locale);
        }
        if (!this.allowDecimals) {
            numberFormat.setParseIntegerOnly(true);
        }
        return numberFormat;
    }

    private Number parse(Class<?> cls, Class<?> cls2, String str, NumberFormat numberFormat) {
        ParsePosition parsePosition = new ParsePosition(0);
        Number number = numberFormat.parse(str, parsePosition);
        if (parsePosition.getErrorIndex() < 0 && parsePosition.getIndex() == str.length() && number != null) {
            return number;
        }
        String string = "Error converting from '" + toString(cls) + "' to '" + toString(cls2) + "'";
        if (numberFormat instanceof DecimalFormat) {
            StringBuilder sbM781w = AbstractC0541b.m781w(string, " using pattern '");
            sbM781w.append(((DecimalFormat) numberFormat).toPattern());
            sbM781w.append("'");
            string = sbM781w.toString();
        }
        if (this.locale != null) {
            StringBuilder sbM781w2 = AbstractC0541b.m781w(string, " for locale=[");
            sbM781w2.append(this.locale);
            sbM781w2.append("]");
            string = sbM781w2.toString();
        }
        if (log().isDebugEnabled()) {
            log().debug("    " + string);
        }
        throw new ConversionException(string);
    }

    private Number toNumber(Class<?> cls, Class<?> cls2, String str) {
        if (cls2.equals(Byte.class)) {
            return Byte.valueOf(str);
        }
        if (cls2.equals(Short.class)) {
            return Short.valueOf(str);
        }
        if (cls2.equals(Integer.class)) {
            return Integer.valueOf(str);
        }
        if (cls2.equals(Long.class)) {
            return Long.valueOf(str);
        }
        if (cls2.equals(Float.class)) {
            return Float.valueOf(str);
        }
        if (cls2.equals(Double.class)) {
            return Double.valueOf(str);
        }
        if (cls2.equals(BigDecimal.class)) {
            return new BigDecimal(str);
        }
        if (cls2.equals(BigInteger.class)) {
            return new BigInteger(str);
        }
        String str2 = toString(getClass()) + " cannot handle conversion from '" + toString(cls) + "' to '" + toString(cls2) + "'";
        if (log().isWarnEnabled()) {
            log().warn("    " + str2);
        }
        throw new ConversionException(str2);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String convertToString(Object obj) {
        if (!this.useLocaleFormat || !(obj instanceof Number)) {
            String string = obj.toString();
            if (log().isDebugEnabled()) {
                log().debug("    Converted  to String using toString() '" + string + "'");
            }
            return string;
        }
        NumberFormat format = getFormat();
        format.setGroupingUsed(false);
        String str = format.format(obj);
        if (log().isDebugEnabled()) {
            log().debug("    Converted  to String using format '" + str + "'");
        }
        return str;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        Number number;
        Class<?> cls2 = obj.getClass();
        if (obj instanceof Number) {
            return (T) toNumber(cls2, cls, (Number) obj);
        }
        if (obj instanceof Boolean) {
            return (T) toNumber(cls2, cls, ((Boolean) obj).booleanValue() ? ONE : ZERO);
        }
        if ((obj instanceof Date) && Long.class.equals(cls)) {
            return cls.cast(Long.valueOf(((Date) obj).getTime()));
        }
        if ((obj instanceof Calendar) && Long.class.equals(cls)) {
            return cls.cast(Long.valueOf(((Calendar) obj).getTime().getTime()));
        }
        String strTrim = obj.toString().trim();
        if (strTrim.length() == 0) {
            return (T) handleMissing(cls);
        }
        if (this.useLocaleFormat) {
            number = parse(cls2, cls, strTrim, getFormat());
        } else {
            if (log().isDebugEnabled()) {
                log().debug("    No NumberFormat, using default conversion");
            }
            number = toNumber(cls2, (Class<?>) cls, strTrim);
        }
        return (T) toNumber(cls2, cls, number);
    }

    public Locale getLocale() {
        return this.locale;
    }

    public String getPattern() {
        return this.pattern;
    }

    public boolean isAllowDecimals() {
        return this.allowDecimals;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
        setUseLocaleFormat(true);
    }

    public void setPattern(String str) {
        this.pattern = str;
        setUseLocaleFormat(true);
    }

    public void setUseLocaleFormat(boolean z) {
        this.useLocaleFormat = z;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString(getClass()));
        sb.append("[UseDefault=");
        sb.append(isUseDefault());
        sb.append(", UseLocaleFormat=");
        sb.append(this.useLocaleFormat);
        if (this.pattern != null) {
            sb.append(", Pattern=");
            sb.append(this.pattern);
        }
        if (this.locale != null) {
            sb.append(", Locale=");
            sb.append(this.locale);
        }
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }

    public NumberConverter(boolean z, Object obj) {
        this.allowDecimals = z;
        setDefaultValue(obj);
    }

    private <T> T toNumber(Class<?> cls, Class<T> cls2, Number number) {
        if (cls2.equals(number.getClass())) {
            return cls2.cast(number);
        }
        if (cls2.equals(Byte.class)) {
            long jLongValue = number.longValue();
            if (jLongValue > 127) {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            }
            if (jLongValue >= -128) {
                return cls2.cast(Byte.valueOf(number.byteValue()));
            }
            throw new ConversionException(toString(cls) + " value '" + number + "' is too small " + toString(cls2));
        }
        if (cls2.equals(Short.class)) {
            long jLongValue2 = number.longValue();
            if (jLongValue2 > 32767) {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            }
            if (jLongValue2 >= -32768) {
                return cls2.cast(Short.valueOf(number.shortValue()));
            }
            throw new ConversionException(toString(cls) + " value '" + number + "' is too small " + toString(cls2));
        }
        if (cls2.equals(Integer.class)) {
            long jLongValue3 = number.longValue();
            if (jLongValue3 > 2147483647L) {
                throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
            }
            if (jLongValue3 >= -2147483648L) {
                return cls2.cast(Integer.valueOf(number.intValue()));
            }
            throw new ConversionException(toString(cls) + " value '" + number + "' is too small " + toString(cls2));
        }
        if (cls2.equals(Long.class)) {
            return cls2.cast(Long.valueOf(number.longValue()));
        }
        if (cls2.equals(Float.class)) {
            if (number.doubleValue() <= 3.4028234663852886E38d) {
                return cls2.cast(Float.valueOf(number.floatValue()));
            }
            throw new ConversionException(toString(cls) + " value '" + number + "' is too large for " + toString(cls2));
        }
        if (cls2.equals(Double.class)) {
            return cls2.cast(Double.valueOf(number.doubleValue()));
        }
        if (cls2.equals(BigDecimal.class)) {
            if (!(number instanceof Float) && !(number instanceof Double)) {
                if (number instanceof BigInteger) {
                    return cls2.cast(new BigDecimal((BigInteger) number));
                }
                if (number instanceof BigDecimal) {
                    return cls2.cast(new BigDecimal(number.toString()));
                }
                return cls2.cast(BigDecimal.valueOf(number.longValue()));
            }
            return cls2.cast(new BigDecimal(number.toString()));
        }
        if (cls2.equals(BigInteger.class)) {
            if (number instanceof BigDecimal) {
                return cls2.cast(((BigDecimal) number).toBigInteger());
            }
            return cls2.cast(BigInteger.valueOf(number.longValue()));
        }
        String str = toString(getClass()) + " cannot handle conversion to '" + toString(cls2) + "'";
        if (log().isWarnEnabled()) {
            log().warn("    " + str);
        }
        throw new ConversionException(str);
    }
}
