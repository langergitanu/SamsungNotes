package org.ccil.cowan.tagsoup;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import org.apache.poi.javax.xml.XMLConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ElementType {
    private AttributesImpl theAtts = new AttributesImpl();
    private int theFlags;
    private String theLocalName;
    private int theMemberOf;
    private int theModel;
    private String theName;
    private String theNamespace;
    private ElementType theParent;
    private Schema theSchema;

    public ElementType(String str, int i, int i2, int i4, Schema schema) {
        this.theName = str;
        this.theModel = i;
        this.theMemberOf = i2;
        this.theFlags = i4;
        this.theSchema = schema;
        this.theNamespace = namespace(str, false);
        this.theLocalName = localName(str);
    }

    public static String normalize(String str) {
        if (str == null) {
            return str;
        }
        String strTrim = str.trim();
        if (strTrim.indexOf(Constant.WHITE_SPACE_FOR_LINK_ICON) == -1) {
            return strTrim;
        }
        int length = strTrim.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = strTrim.charAt(i);
            if (cCharAt == ' ') {
                if (!z) {
                    stringBuffer.append(cCharAt);
                }
                z = true;
            } else {
                stringBuffer.append(cCharAt);
                z = false;
            }
        }
        return stringBuffer.toString();
    }

    public AttributesImpl atts() {
        return this.theAtts;
    }

    public boolean canContain(ElementType elementType) {
        return (elementType.theMemberOf & this.theModel) != 0;
    }

    public int flags() {
        return this.theFlags;
    }

    public String localName(String str) {
        int iIndexOf = str.indexOf(58);
        return iIndexOf == -1 ? str : str.substring(iIndexOf + 1).intern();
    }

    public int memberOf() {
        return this.theMemberOf;
    }

    public int model() {
        return this.theModel;
    }

    public String name() {
        return this.theName;
    }

    public String namespace(String str, boolean z) {
        int iIndexOf = str.indexOf(58);
        if (iIndexOf == -1) {
            return z ? "" : this.theSchema.getURI();
        }
        String strSubstring = str.substring(0, iIndexOf);
        return strSubstring.equals("xml") ? "http://www.w3.org/XML/1998/namespace" : "urn:x-prefix:".concat(strSubstring).intern();
    }

    public ElementType parent() {
        return this.theParent;
    }

    public Schema schema() {
        return this.theSchema;
    }

    public void setAttribute(AttributesImpl attributesImpl, String str, String str2, String str3) {
        if (str.equals(XMLConstants.XMLNS_ATTRIBUTE) || str.startsWith("xmlns:")) {
            return;
        }
        String strNamespace = namespace(str, true);
        String strLocalName = localName(str);
        int index = attributesImpl.getIndex(str);
        if (index == -1) {
            String strIntern = str.intern();
            String str4 = str2 == null ? "CDATA" : str2;
            if (!str4.equals("CDATA")) {
                str3 = normalize(str3);
            }
            attributesImpl.addAttribute(strNamespace, strLocalName, strIntern, str4, str3);
            return;
        }
        if (str2 == null) {
            str2 = attributesImpl.getType(index);
        }
        String str5 = str2;
        if (!str5.equals("CDATA")) {
            str3 = normalize(str3);
        }
        attributesImpl.setAttribute(index, strNamespace, strLocalName, str, str5, str3);
    }

    public void setFlags(int i) {
        this.theFlags = i;
    }

    public void setMemberOf(int i) {
        this.theMemberOf = i;
    }

    public void setModel(int i) {
        this.theModel = i;
    }

    public void setParent(ElementType elementType) {
        this.theParent = elementType;
    }

    public String localName() {
        return this.theLocalName;
    }

    public String namespace() {
        return this.theNamespace;
    }

    public void setAttribute(String str, String str2, String str3) {
        setAttribute(this.theAtts, str, str2, str3);
    }
}
