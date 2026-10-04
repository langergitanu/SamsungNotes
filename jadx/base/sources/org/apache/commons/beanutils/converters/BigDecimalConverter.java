package org.apache.commons.beanutils.converters;

import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class BigDecimalConverter extends NumberConverter {
    public BigDecimalConverter() {
        super(true);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<BigDecimal> getDefaultType() {
        return BigDecimal.class;
    }

    public BigDecimalConverter(Object obj) {
        super(true, obj);
    }
}
