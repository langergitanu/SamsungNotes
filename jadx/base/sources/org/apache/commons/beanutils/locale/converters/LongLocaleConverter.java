package org.apache.commons.beanutils.locale.converters;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LongLocaleConverter extends DecimalLocaleConverter {
    public LongLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DecimalLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        Object obj2 = super.parse(obj, str);
        return (obj2 == null || (obj2 instanceof Long)) ? obj2 : Long.valueOf(((Number) obj2).longValue());
    }

    public LongLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public LongLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public LongLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public LongLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public LongLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public LongLocaleConverter(Object obj) {
        this(obj, false);
    }

    public LongLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public LongLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public LongLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public LongLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public LongLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }
}
