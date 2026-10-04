package org.apache.commons.beanutils.locale.converters;

import java.sql.Date;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SqlDateLocaleConverter extends DateLocaleConverter {
    public SqlDateLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.converters.DateLocaleConverter, org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        return new Date(((java.util.Date) super.parse(obj, str)).getTime());
    }

    public SqlDateLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public SqlDateLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public SqlDateLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public SqlDateLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public SqlDateLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
    }

    public SqlDateLocaleConverter(Object obj) {
        this(obj, false);
    }

    public SqlDateLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public SqlDateLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
    }
}
