package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import java.net.URL;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTcMar extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTcMar.class, "schemaorg_apache_xmlbeans.system.sD023D6490046BA0250A839A9AD24C443", "cttcmar23c3type");

    public static final class Factory {
        private static SoftReference<SchemaTypeLoader> typeLoader;

        private Factory() {
        }

        private static synchronized SchemaTypeLoader getTypeLoader() {
            SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader;
            SoftReference<SchemaTypeLoader> softReference = typeLoader;
            schemaTypeLoaderTypeLoaderForClassLoader = softReference == null ? null : softReference.get();
            if (schemaTypeLoaderTypeLoaderForClassLoader == null) {
                schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(CTTcMar.class.getClassLoader());
                typeLoader = new SoftReference<>(schemaTypeLoaderTypeLoaderForClassLoader);
            }
            return schemaTypeLoaderTypeLoaderForClassLoader;
        }

        public static CTTcMar newInstance() {
            return (CTTcMar) getTypeLoader().newInstance(CTTcMar.type, null);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcMar.type, null);
        }

        public static CTTcMar parse(File file) {
            return (CTTcMar) getTypeLoader().parse(file, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar newInstance(XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().newInstance(CTTcMar.type, xmlOptions);
        }

        @Deprecated
        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return getTypeLoader().newValidatingXMLInputStream(xMLInputStream, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(File file, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(file, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(InputStream inputStream) {
            return (CTTcMar) getTypeLoader().parse(inputStream, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(inputStream, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(Reader reader) {
            return (CTTcMar) getTypeLoader().parse(reader, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(reader, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(String str) {
            return (CTTcMar) getTypeLoader().parse(str, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar parse(String str, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(str, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(URL url) {
            return (CTTcMar) getTypeLoader().parse(url, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar parse(URL url, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(url, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(XMLStreamReader xMLStreamReader) {
            return (CTTcMar) getTypeLoader().parse(xMLStreamReader, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(xMLStreamReader, CTTcMar.type, xmlOptions);
        }

        @Deprecated
        public static CTTcMar parse(XMLInputStream xMLInputStream) {
            return (CTTcMar) getTypeLoader().parse(xMLInputStream, CTTcMar.type, (XmlOptions) null);
        }

        @Deprecated
        public static CTTcMar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(xMLInputStream, CTTcMar.type, xmlOptions);
        }

        public static CTTcMar parse(Node node) {
            return (CTTcMar) getTypeLoader().parse(node, CTTcMar.type, (XmlOptions) null);
        }

        public static CTTcMar parse(Node node, XmlOptions xmlOptions) {
            return (CTTcMar) getTypeLoader().parse(node, CTTcMar.type, xmlOptions);
        }
    }

    CTTblWidth addNewBottom();

    CTTblWidth addNewLeft();

    CTTblWidth addNewRight();

    CTTblWidth addNewTop();

    CTTblWidth getBottom();

    CTTblWidth getLeft();

    CTTblWidth getRight();

    CTTblWidth getTop();

    boolean isSetBottom();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBottom(CTTblWidth cTTblWidth);

    void setLeft(CTTblWidth cTTblWidth);

    void setRight(CTTblWidth cTTblWidth);

    void setTop(CTTblWidth cTTblWidth);

    void unsetBottom();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
