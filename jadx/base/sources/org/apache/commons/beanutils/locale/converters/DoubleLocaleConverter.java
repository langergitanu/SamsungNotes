package org.apache.commons.beanutils.locale.converters;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoubleLocaleConverter extends DecimalLocaleConverter {
    public DoubleLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        Number number = (Number) super.parse(obj, str);
        return number instanceof Long ? Double.valueOf(number.doubleValue()) : number;
    }

    public DoubleLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public DoubleLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DoubleLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public DoubleLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DoubleLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public DoubleLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DoubleLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public DoubleLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DoubleLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }
}
