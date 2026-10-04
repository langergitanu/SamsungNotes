package org.apache.commons.beanutils.converters;

import java.util.List;
import org.apache.commons.beanutils.ConversionException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public final class BooleanArrayConverter extends AbstractArrayConverter {
    protected final BooleanConverter booleanConverter;
    public static final Class MODEL = new boolean[0].getClass();
    private static final BooleanConverter DEFAULT_CONVERTER = new BooleanConverter();

    public BooleanArrayConverter() {
        this.booleanConverter = DEFAULT_CONVERTER;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractArrayConverter, org.apache.commons.beanutils.Converter
    public Object convert(Class cls, Object obj) {
        if (obj == null) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException("No value specified");
        }
        if (MODEL == obj.getClass()) {
            return obj;
        }
        int i = 0;
        if (AbstractArrayConverter.strings.getClass() == obj.getClass()) {
            try {
                String[] strArr = (String[]) obj;
                boolean[] zArr = new boolean[strArr.length];
                while (i < strArr.length) {
                    zArr[i] = ((Boolean) this.booleanConverter.convert(Boolean.class, strArr[i])).booleanValue();
                    i++;
                }
                return zArr;
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
            boolean[] zArr2 = new boolean[size];
            while (i < size) {
                zArr2[i] = ((Boolean) this.booleanConverter.convert(Boolean.class, elements.get(i))).booleanValue();
                i++;
            }
            return zArr2;
        } catch (Exception e2) {
            if (this.useDefault) {
                return this.defaultValue;
            }
            throw new ConversionException(obj.toString(), e2);
        }
    }

    public BooleanArrayConverter(BooleanConverter booleanConverter, Object obj) {
        super(obj);
        this.booleanConverter = booleanConverter;
    }

    public BooleanArrayConverter(Object obj) {
        super(obj);
        this.booleanConverter = DEFAULT_CONVERTER;
    }
}
