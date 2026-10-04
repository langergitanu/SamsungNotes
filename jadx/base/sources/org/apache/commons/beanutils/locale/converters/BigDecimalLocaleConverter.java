package org.apache.commons.beanutils.locale.converters;

import androidx.appcompat.widget.AbstractC0541b;
import java.math.BigDecimal;
import java.util.Locale;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BigDecimalLocaleConverter extends DecimalLocaleConverter {
    public BigDecimalLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        Object obj2 = super.parse(obj, str);
        if (obj2 == null || (obj2 instanceof BigDecimal)) {
            return obj2;
        }
        try {
            return new BigDecimal(obj2.toString());
        } catch (NumberFormatException unused) {
            throw new ConversionException(AbstractC0541b.m769k(obj2, "Suplied number is not of type BigDecimal: "));
        }
    }

    public BigDecimalLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public BigDecimalLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public BigDecimalLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public BigDecimalLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public BigDecimalLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public BigDecimalLocaleConverter(Object obj) {
        this(obj, false);
    }

    public BigDecimalLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public BigDecimalLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }
}
