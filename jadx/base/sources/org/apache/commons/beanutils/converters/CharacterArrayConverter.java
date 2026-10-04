package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class CharacterArrayConverter extends AbstractArrayConverter {
    private static final char[] MODEL = new char[0];

    public CharacterArrayConverter() {
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
        if (AbstractArrayConverter.strings.getClass() == obj.getClass()) {
            try {
                String[] strArr = (String[]) obj;
                char[] cArr = new char[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    cArr[i] = strArr[i].charAt(0);
                }
                return cArr;
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
            char[] cArr2 = new char[size];
            for (int i2 = 0; i2 < size; i2++) {
                cArr2[i2] = elements.get(i2).charAt(0);
            }
            return cArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }

    public CharacterArrayConverter(Object obj) {
        this.defaultValue = obj;
        this.useDefault = true;
    }
}
