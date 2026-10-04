package org.apache.commons.beanutils.locale.converters;

import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ShortLocaleConverter extends DecimalLocaleConverter {
    public ShortLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        Object obj2 = super.parse(obj, str);
        if (obj2 == null || (obj2 instanceof Short)) {
            return obj2;
        }
        Number number = (Number) obj2;
        if (number.longValue() == number.shortValue()) {
            return Short.valueOf(number.shortValue());
        }
        throw new ConversionException("Supplied number is not of type Short: " + number.longValue());
    }

    public ShortLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public ShortLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public ShortLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public ShortLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public ShortLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public ShortLocaleConverter(Object obj) {
        this(obj, false);
    }

    public ShortLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public ShortLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public ShortLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public ShortLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public ShortLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }
}
