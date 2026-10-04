package org.apache.commons.beanutils.converters;

import org.apache.commons.lang3.BooleanUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class BooleanConverter extends AbstractConverter {

    @Deprecated
    public static final Object NO_DEFAULT = new Object();
    private String[] falseStrings;
    private String[] trueStrings;

    public BooleanConverter() {
        this.trueStrings = new String[]{"true", BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.f9757NO, "n", "off", "0"};
    }

    private static String[] copyStrings(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = strArr[i].toLowerCase();
        }
        return strArr2;
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        if (Boolean.class.equals(cls) || Boolean.TYPE.equals(cls)) {
            String lowerCase = obj.toString().toLowerCase();
            for (String str : this.trueStrings) {
                if (str.equals(lowerCase)) {
                    return cls.cast(Boolean.TRUE);
                }
            }
            for (String str2 : this.falseStrings) {
                if (str2.equals(lowerCase)) {
                    return cls.cast(Boolean.FALSE);
                }
            }
        }
        throw conversionException(cls, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<Boolean> getDefaultType() {
        return Boolean.class;
    }

    public BooleanConverter(Object obj) {
        this.trueStrings = new String[]{"true", BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.f9757NO, "n", "off", "0"};
        if (obj != NO_DEFAULT) {
            setDefaultValue(obj);
        }
    }

    public BooleanConverter(String[] strArr, String[] strArr2) {
        this.trueStrings = new String[]{"true", BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.f9757NO, "n", "off", "0"};
        this.trueStrings = copyStrings(strArr);
        this.falseStrings = copyStrings(strArr2);
    }

    public BooleanConverter(String[] strArr, String[] strArr2, Object obj) {
        this.trueStrings = new String[]{"true", BooleanUtils.YES, "y", "on", "1"};
        this.falseStrings = new String[]{"false", BooleanUtils.f9757NO, "n", "off", "0"};
        this.trueStrings = copyStrings(strArr);
        this.falseStrings = copyStrings(strArr2);
        if (obj != NO_DEFAULT) {
            setDefaultValue(obj);
        }
    }
}
