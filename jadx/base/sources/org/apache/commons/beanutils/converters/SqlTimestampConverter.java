package org.apache.commons.beanutils.converters;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SqlTimestampConverter extends DateTimeConverter {
    public SqlTimestampConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return Timestamp.class;
    }

    @Override // org.apache.commons.beanutils.converters.DateTimeConverter
    public DateFormat getFormat(Locale locale, TimeZone timeZone) {
        DateFormat dateTimeInstance = locale == null ? DateFormat.getDateTimeInstance(3, 3) : DateFormat.getDateTimeInstance(3, 3, locale);
        if (timeZone != null) {
            dateTimeInstance.setTimeZone(timeZone);
        }
        return dateTimeInstance;
    }

    public SqlTimestampConverter(Object obj) {
        super(obj);
    }
}
