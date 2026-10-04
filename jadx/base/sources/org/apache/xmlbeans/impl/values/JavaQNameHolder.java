package org.apache.xmlbeans.impl.values;

import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class JavaQNameHolder extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final NamespaceManager PRETTY_PREFIXER;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$values$JavaQNameHolder;
    private QName _value;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PrettyNamespaceManager implements NamespaceManager {
        private PrettyNamespaceManager() {
        }

        @Override // org.apache.xmlbeans.impl.values.NamespaceManager
        public String find_prefix_for_nsuri(String str, String str2) {
            return QNameHelper.suggestPrefix(str);
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            throw new RuntimeException("Should not be called");
        }
    }

    static {
        if (class$org$apache$xmlbeans$impl$values$JavaQNameHolder == null) {
            class$org$apache$xmlbeans$impl$values$JavaQNameHolder = class$("org.apache.xmlbeans.impl.values.JavaQNameHolder");
        }
        $assertionsDisabled = true;
        PRETTY_PREFIXER = new PrettyNamespaceManager();
    }

    public static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw AbstractC12991c.m13994o(e);
        }
    }

    private static QName parse(String str, PrefixResolver prefixResolver) {
        String strSubstring;
        String strSubstring2;
        int length = str.length();
        while (length > 0 && XMLChar.isSpace(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        while (i < length && XMLChar.isSpace(str.charAt(i))) {
            i++;
        }
        int iIndexOf = str.indexOf(58, i);
        String str2 = "";
        if (iIndexOf >= 0) {
            strSubstring2 = str.substring(i, iIndexOf);
            strSubstring = str.substring(iIndexOf + 1, length);
        } else {
            strSubstring = str.substring(i, length);
            strSubstring2 = "";
        }
        if (strSubstring2.length() > 0 && !XMLChar.isValidNCName(strSubstring2)) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.QNAME, new Object[]{AbstractC12991c.m13990k("Prefix not a valid NCName in '", str, "'")});
        }
        if (!XMLChar.isValidNCName(strSubstring)) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.QNAME, new Object[]{AbstractC12991c.m13990k("Localname not a valid NCName in '", str, "'")});
        }
        String namespaceForPrefix = prefixResolver == null ? null : prefixResolver.getNamespaceForPrefix(strSubstring2);
        if (namespaceForPrefix != null) {
            str2 = namespaceForPrefix;
        } else if (strSubstring2.length() > 0) {
            throw new XmlValueOutOfRangeException(XmlErrorCodes.QNAME, new Object[]{AbstractC12991c.m13990k("Can't resolve prefix '", strSubstring2, "'")});
        }
        return strSubstring2.length() > 0 ? new QName(str2, strSubstring, strSubstring2) : new QName(str2, strSubstring);
    }

    public static QName validateLexical(String str, ValidationContext validationContext, PrefixResolver prefixResolver) {
        try {
            return parse(str, prefixResolver);
        } catch (XmlValueOutOfRangeException e) {
            validationContext.invalid(e.getMessage());
            return null;
        }
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        if (namespaceManager == null) {
            namespaceManager = PRETTY_PREFIXER;
        }
        String namespaceURI = this._value.getNamespaceURI();
        String localPart = this._value.getLocalPart();
        if (namespaceURI != null && namespaceURI.length() != 0) {
            String strFind_prefix_for_nsuri = namespaceManager.find_prefix_for_nsuri(namespaceURI, null);
            if (!$assertionsDisabled && strFind_prefix_for_nsuri == null) {
                throw new AssertionError();
            }
            if (!"".equals(strFind_prefix_for_nsuri)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(strFind_prefix_for_nsuri);
                stringBuffer.append(":");
                stringBuffer.append(localPart);
                return stringBuffer.toString();
            }
        }
        return localPart;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._value.equals(((XmlObjectBase) xmlObject).qNameValue());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        check_dated();
        return this._value;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int get_wscanon_rule() {
        return 1;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return BuiltinSchemaTypeSystem.ST_QNAME;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_QName(QName qName) {
        if (!$assertionsDisabled && qName == null) {
            throw new AssertionError();
        }
        if (has_store()) {
            get_store().find_prefix_for_nsuri(qName.getNamespaceURI(), null);
        }
        this._value = qName;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
        this._value = null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
        PrefixResolver current = NamespaceContext.getCurrent();
        if (current == null && has_store()) {
            current = get_store();
        }
        this._value = parse(str, current);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_xmlanysimple(XmlAnySimpleType xmlAnySimpleType) {
        this._value = parse(xmlAnySimpleType.getStringValue(), NamespaceContext.getCurrent());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        return this._value.hashCode();
    }
}
