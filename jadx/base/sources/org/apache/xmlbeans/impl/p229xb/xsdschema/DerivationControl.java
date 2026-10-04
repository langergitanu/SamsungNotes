package org.apache.xmlbeans.impl.p229xb.xsdschema;

import com.google.android.gms.common.data.AbstractC4539a;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface DerivationControl extends XmlNMTOKEN {
    public static final Enum EXTENSION;
    public static final int INT_EXTENSION = 2;
    public static final int INT_LIST = 4;
    public static final int INT_RESTRICTION = 3;
    public static final int INT_SUBSTITUTION = 1;
    public static final int INT_UNION = 5;
    public static final Enum LIST;
    public static final Enum RESTRICTION;
    public static final Enum SUBSTITUTION;
    public static final Enum UNION;
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141931 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl;

        public static /* synthetic */ Class class$(String str) throws Throwable {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw AbstractC12991c.m13994o(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_EXTENSION = 2;
        static final int INT_LIST = 4;
        static final int INT_RESTRICTION = 3;
        static final int INT_SUBSTITUTION = 1;
        static final int INT_UNION = 5;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("substitution", 1), new Enum(BundleContract.EXTRA_DATA, 2), new Enum("restriction", 3), new Enum(XmlErrorCodes.LIST, 4), new Enum(XmlErrorCodes.UNION, 5)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static DerivationControl newInstance() {
            return (DerivationControl) XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationControl.type, null);
        }

        public static DerivationControl newValue(Object obj) {
            return (DerivationControl) DerivationControl.type.newValue(obj);
        }

        public static DerivationControl parse(String str) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(str, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl newInstance(XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().newInstance(DerivationControl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(String str, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(str, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(File file) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(file, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(File file, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(file, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(URL url) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(url, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(URL url, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(url, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(InputStream inputStream) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(Reader reader) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(reader, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(Reader reader, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(reader, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(XMLStreamReader xMLStreamReader) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(Node node) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(node, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(Node node, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(node, DerivationControl.type, xmlOptions);
        }

        public static DerivationControl parse(XMLInputStream xMLInputStream) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationControl.type, (XmlOptions) null);
        }

        public static DerivationControl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (DerivationControl) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationControl.type, xmlOptions);
        }
    }

    static {
        Class clsClass$ = C141931.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl;
        if (clsClass$ == null) {
            clsClass$ = C141931.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl");
            C141931.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationControl = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "derivationcontrola5dftype");
        SUBSTITUTION = Enum.forString("substitution");
        EXTENSION = Enum.forString(BundleContract.EXTRA_DATA);
        RESTRICTION = Enum.forString("restriction");
        LIST = Enum.forString(XmlErrorCodes.LIST);
        UNION = Enum.forString(XmlErrorCodes.UNION);
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
