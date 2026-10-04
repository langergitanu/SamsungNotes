package org.apache.commons.beanutils.converters;

import java.sql.Date;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SqlDateConverter extends DateTimeConverter {
    public SqlDateConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return Date.class;
    }

    public SqlDateConverter(Object obj) {
        super(obj);
    }
}
