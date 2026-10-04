package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class StringArrayConverter extends AbstractArrayConverter {
    private static final String[] MODEL = new String[0];
    private static final int[] INT_MODEL = new int[0];

    public StringArrayConverter() {
        this.defaultValue = null;
        this.useDefault = false;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractArrayConverter, org.apache.commons.beanutils.Converter
    public Object convert(Class cls, Object obj) {
        if (obj == null) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException("No value specified");
        }
        if (MODEL.getClass() == obj.getClass()) {
            return obj;
        }
        int i = 0;
        if (INT_MODEL.getClass() == obj.getClass()) {
            int[] iArr = (int[]) obj;
            String[] strArr = new String[iArr.length];
            while (i < iArr.length) {
                strArr[i] = Integer.toString(iArr[i]);
                i++;
            }
            return strArr;
        }
        try {
            List<String> elements = parseElements(obj.toString());
            int size = elements.size();
            String[] strArr2 = new String[size];
            while (i < size) {
                strArr2[i] = elements.get(i);
                i++;
            }
            return strArr2;
        } catch (Exception e) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e);
        }
    }

    public StringArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}
