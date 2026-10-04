package org.ccil.cowan.tagsoup;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class Schema {
    public static final int F_CDATA = 2;
    public static final int F_NOFORCE = 4;
    public static final int F_RESTART = 1;
    public static final int M_ANY = -1;
    public static final int M_EMPTY = 0;
    public static final int M_PCDATA = 1073741824;
    public static final int M_ROOT = Integer.MIN_VALUE;
    private HashMap theEntities = new HashMap();
    private HashMap theElementTypes = new HashMap();
    private String theURI = "";
    private String thePrefix = "";
    private ElementType theRoot = null;

    public void attribute(String str, String str2, String str3, String str4) {
        ElementType elementType = getElementType(str);
        if (elementType != null) {
            elementType.setAttribute(str2, str3, str4);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("Attribute ");
        stringBuffer.append(str2);
        stringBuffer.append(" specified for unknown element type ");
        stringBuffer.append(str);
        throw new Error(stringBuffer.toString());
    }

    public void elementType(String str, int i, int i2, int i4) {
        ElementType elementType = new ElementType(str, i, i2, i4, this);
        this.theElementTypes.put(str.toLowerCase(), elementType);
        if (i2 == Integer.MIN_VALUE) {
            this.theRoot = elementType;
        }
    }

    public void entity(String str, int i) {
        this.theEntities.put(str, new Integer(i));
    }

    public ElementType getElementType(String str) {
        return (ElementType) this.theElementTypes.get(str.toLowerCase());
    }

    public int getEntity(String str) {
        Integer num = (Integer) this.theEntities.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String getPrefix() {
        return this.thePrefix;
    }

    public String getURI() {
        return this.theURI;
    }

    public void parent(String str, String str2) {
        ElementType elementType = getElementType(str);
        ElementType elementType2 = getElementType(str2);
        if (elementType == null) {
            StringBuffer stringBuffer = new StringBuffer("No child ");
            stringBuffer.append(str);
            stringBuffer.append(" for parent ");
            stringBuffer.append(str2);
            throw new Error(stringBuffer.toString());
        }
        if (elementType2 != null) {
            elementType.setParent(elementType2);
            return;
        }
        StringBuffer stringBuffer2 = new StringBuffer("No parent ");
        stringBuffer2.append(str2);
        stringBuffer2.append(" for child ");
        stringBuffer2.append(str);
        throw new Error(stringBuffer2.toString());
    }

    public ElementType rootElementType() {
        return this.theRoot;
    }

    public void setPrefix(String str) {
        this.thePrefix = str;
    }

    public void setURI(String str) {
        this.theURI = str;
    }
}
