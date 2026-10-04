package org.apache.commons.beanutils.converters;

import org.apache.commons.beanutils.Converter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ConverterFacade implements Converter {
    private final Converter converter;

    public ConverterFacade(Converter converter) {
        if (converter == null) {
            throw new IllegalArgumentException("Converter is missing");
        }
        this.converter = converter;
    }

    @Override // org.apache.commons.beanutils.Converter
    public <T> T convert(Class<T> cls, Object obj) {
        return (T) this.converter.convert(cls, obj);
    }

    public String toString() {
        return "ConverterFacade[" + this.converter.toString() + "]";
    }
}
