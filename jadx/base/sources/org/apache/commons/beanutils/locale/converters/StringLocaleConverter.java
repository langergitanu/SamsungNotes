package org.apache.commons.beanutils.locale.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringLocaleConverter extends BaseLocaleConverter {
    private final Log log;

    public StringLocaleConverter() {
        this(false);
    }

    private DecimalFormat getDecimalFormat(Locale locale, String str) {
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(locale);
        if (str == null) {
            this.log.debug("No pattern provided, using default.");
            return decimalFormat;
        }
        if (this.locPattern) {
            decimalFormat.applyLocalizedPattern(str);
            return decimalFormat;
        }
        decimalFormat.applyPattern(str);
        return decimalFormat;
    }

    @Override // org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        return ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof BigInteger) || (obj instanceof Byte) || (obj instanceof Short)) ? getDecimalFormat(this.locale, str).format(((Number) obj).longValue()) : ((obj instanceof Double) || (obj instanceof BigDecimal) || (obj instanceof Float)) ? getDecimalFormat(this.locale, str).format(((Number) obj).doubleValue()) : obj instanceof Date ? new SimpleDateFormat(str, this.locale).format(obj) : obj.toString();
    }

    public StringLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public StringLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public StringLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public StringLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public StringLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
        this.log = LogFactory.getLog((Class<?>) StringLocaleConverter.class);
    }

    public StringLocaleConverter(Object obj) {
        this(obj, false);
    }

    public StringLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public StringLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public StringLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public StringLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public StringLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
        this.log = LogFactory.getLog((Class<?>) StringLocaleConverter.class);
    }
}
