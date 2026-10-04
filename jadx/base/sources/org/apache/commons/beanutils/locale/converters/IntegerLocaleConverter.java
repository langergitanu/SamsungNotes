package org.apache.commons.beanutils.locale.converters;

import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IntegerLocaleConverter extends DecimalLocaleConverter {
    public IntegerLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        Number number = (Number) super.parse(obj, str);
        if (number.longValue() == number.intValue()) {
            return Integer.valueOf(number.intValue());
        }
        throw new ConversionException("Suplied number is not of type Integer: " + number.longValue());
    }

    public IntegerLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public IntegerLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public IntegerLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public IntegerLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public IntegerLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public IntegerLocaleConverter(Object obj) {
        this(obj, false);
    }

    public IntegerLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public IntegerLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public IntegerLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }
}
