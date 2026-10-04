package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class LongArrayConverter extends AbstractArrayConverter {
    private static final long[] MODEL = new long[0];

    public LongArrayConverter() {
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
        if (AbstractArrayConverter.strings.getClass() == obj.getClass()) {
            try {
                String[] strArr = (String[]) obj;
                long[] jArr = new long[strArr.length];
                while (i < strArr.length) {
                    jArr[i] = Long.parseLong(strArr[i]);
                    i++;
                }
                return jArr;
            } catch (Exception e) {
                if (this.useDefault) {
                    return this.defaultValue;
                }
                throw new ConversionException(obj.toString(), e);
            }
        }
        try {
            List<String> elements = parseElements(obj.toString());
            int size = elements.size();
            long[] jArr2 = new long[size];
            while (i < size) {
                jArr2[i] = Long.parseLong(elements.get(i));
                i++;
            }
            return jArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }

    public LongArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}
