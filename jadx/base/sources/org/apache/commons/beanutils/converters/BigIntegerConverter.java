package org.apache.commons.beanutils.converters;

import java.math.BigInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class BigIntegerConverter extends NumberConverter {
    public BigIntegerConverter() {
        super(false);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<BigInteger> getDefaultType() {
        return BigInteger.class;
    }

    public BigIntegerConverter(Object obj) {
        super(false, obj);
    }
}
