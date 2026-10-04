package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CommentsDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CommentsDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "comments3da0doctype");

    public static final class Factory {
        private Factory() {
        }

        public static CommentsDocument newInstance() {
            return (CommentsDocument) POIXMLTypeLoader.newInstance(CommentsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CommentsDocument.type, null);
        }

        public static CommentsDocument parse(File file) {
            return (CommentsDocument) POIXMLTypeLoader.parse(file, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument newInstance(XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.newInstance(CommentsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(File file, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(file, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(InputStream inputStream) {
            return (CommentsDocument) POIXMLTypeLoader.parse(inputStream, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(inputStream, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(Reader reader) {
            return (CommentsDocument) POIXMLTypeLoader.parse(reader, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(reader, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(String str) {
            return (CommentsDocument) POIXMLTypeLoader.parse(str, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(String str, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(str, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(URL url) {
            return (CommentsDocument) POIXMLTypeLoader.parse(url, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(URL url, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(url, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(XMLStreamReader xMLStreamReader) {
            return (CommentsDocument) POIXMLTypeLoader.parse(xMLStreamReader, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(xMLStreamReader, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(XMLInputStream xMLInputStream) {
            return (CommentsDocument) POIXMLTypeLoader.parse(xMLInputStream, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(xMLInputStream, CommentsDocument.type, xmlOptions);
        }

        public static CommentsDocument parse(Node node) {
            return (CommentsDocument) POIXMLTypeLoader.parse(node, CommentsDocument.type, (XmlOptions) null);
        }

        public static CommentsDocument parse(Node node, XmlOptions xmlOptions) {
            return (CommentsDocument) POIXMLTypeLoader.parse(node, CommentsDocument.type, xmlOptions);
        }
    }

    CTComments addNewComments();

    CTComments getComments();

    void setComments(CTComments cTComments);
}
