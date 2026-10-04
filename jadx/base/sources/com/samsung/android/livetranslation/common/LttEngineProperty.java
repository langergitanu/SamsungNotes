package com.samsung.android.livetranslation.common;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class LttEngineProperty {
    public static final int PROPERTY_API_VERSION_ADD_DYNAMIC_PADDING = 2;
    public static final int PROPERTY_API_VERSION_ADD_GETVER = 1;
    public static final int PROPERTY_API_VERSION_OLD_LIB = -1;
    private int mKey;
    private Object mValue;

    public LttEngineProperty(int i, Object obj) {
        this.mKey = i;
        this.mValue = obj;
    }

    public int getIntValue(Object obj) {
        return ((Integer) obj).intValue();
    }

    public int getKey() {
        return this.mKey;
    }

    public Object getValue() {
        return this.mValue;
    }

    public boolean isValid() {
        return this.mValue != null && this.mKey == 1;
    }

    public void setKey(int i) {
        this.mKey = i;
    }

    public void setValue(Object obj) {
        this.mValue = obj;
    }
}
