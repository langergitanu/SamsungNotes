package org.apache.commons.beanutils.converters;

import java.sql.Time;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SqlTimeConverter extends DateTimeConverter {
    public SqlTimeConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return Time.class;
    }

    @Override // org.apache.commons.beanutils.converters.DateTimeConverter
    public DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat timeInstance = locale == null ? DateFormat.getTimeInstance(3) : DateFormat.getTimeInstance(3, locale);
        if (timeZone != null) {
            timeInstance.setTimeZone(timeZone);
        }
        return timeInstance;
    }

    public SqlTimeConverter(Object obj) {
        super(obj);
    }
}
