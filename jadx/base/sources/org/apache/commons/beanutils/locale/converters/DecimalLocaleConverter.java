package org.apache.commons.beanutils.locale.converters;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.commons.beanutils.locale.BaseLocaleConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DecimalLocaleConverter extends BaseLocaleConverter {
    private final Log log;

    public DecimalLocaleConverter() {
        this(false);
    }

    @Override // org.apache.commons.beanutils.locale.BaseLocaleConverter
    public Object parse(Object obj, String str) {
        if (obj instanceof Number) {
            return obj;
        }
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(this.locale);
        if (str == null) {
            this.log.debug("No pattern provided, using default.");
        } else if (this.locPattern) {
            decimalFormat.applyLocalizedPattern(str);
        } else {
            decimalFormat.applyPattern(str);
        }
        return decimalFormat.parse((String) obj);
    }

    public DecimalLocaleConverter(boolean z) {
        this(Locale.getDefault(), z);
    }

    public DecimalLocaleConverter(Locale locale) {
        this(locale, false);
    }

    public DecimalLocaleConverter(Locale locale, boolean z) {
        this(locale, (String) null, z);
    }

    public DecimalLocaleConverter(Locale locale, String str) {
        this(locale, str, false);
    }

    public DecimalLocaleConverter(Locale locale, String str, boolean z) {
        super(locale, str, z);
        this.log = LogFactory.getLog((Class<?>) DecimalLocaleConverter.class);
    }

    public DecimalLocaleConverter(Object obj) {
        this(obj, false);
    }

    public DecimalLocaleConverter(Object obj, boolean z) {
        this(obj, Locale.getDefault(), z);
    }

    public DecimalLocaleConverter(Object obj, Locale locale) {
        this(obj, locale, false);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, boolean z) {
        this(obj, locale, null, z);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, String str) {
        this(obj, locale, str, false);
    }

    public DecimalLocaleConverter(Object obj, Locale locale, String str, boolean z) {
        super(obj, locale, str, z);
        this.log = LogFactory.getLog((Class<?>) DecimalLocaleConverter.class);
    }
}
