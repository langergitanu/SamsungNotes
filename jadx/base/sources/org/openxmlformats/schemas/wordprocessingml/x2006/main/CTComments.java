package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTComments extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTComments.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctcomments7674type");

    public static final class Factory {
        private Factory() {
        }

        public static CTComments newInstance() {
            return (CTComments) POIXMLTypeLoader.newInstance(CTComments.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTComments.type, null);
        }

        public static CTComments parse(File file) {
            return (CTComments) POIXMLTypeLoader.parse(file, CTComments.type, (XmlOptions) null);
        }

        public static CTComments newInstance(XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.newInstance(CTComments.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(File file, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(file, CTComments.type, xmlOptions);
        }

        public static CTComments parse(InputStream inputStream) {
            return (CTComments) POIXMLTypeLoader.parse(inputStream, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(inputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(Reader reader) {
            return (CTComments) POIXMLTypeLoader.parse(reader, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(Reader reader, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(reader, CTComments.type, xmlOptions);
        }

        public static CTComments parse(String str) {
            return (CTComments) POIXMLTypeLoader.parse(str, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(String str, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(str, CTComments.type, xmlOptions);
        }

        public static CTComments parse(URL url) {
            return (CTComments) POIXMLTypeLoader.parse(url, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(URL url, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(url, CTComments.type, xmlOptions);
        }

        public static CTComments parse(XMLStreamReader xMLStreamReader) {
            return (CTComments) POIXMLTypeLoader.parse(xMLStreamReader, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(xMLStreamReader, CTComments.type, xmlOptions);
        }

        public static CTComments parse(XMLInputStream xMLInputStream) {
            return (CTComments) POIXMLTypeLoader.parse(xMLInputStream, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(xMLInputStream, CTComments.type, xmlOptions);
        }

        public static CTComments parse(Node node) {
            return (CTComments) POIXMLTypeLoader.parse(node, CTComments.type, (XmlOptions) null);
        }

        public static CTComments parse(Node node, XmlOptions xmlOptions) {
            return (CTComments) POIXMLTypeLoader.parse(node, CTComments.type, xmlOptions);
        }
    }

    CTComment addNewComment();

    CTComment getCommentArray(int i);

    CTComment[] getCommentArray();

    List<CTComment> getCommentList();

    CTComment insertNewComment(int i);

    void removeComment(int i);

    void setCommentArray(int i, CTComment cTComment);

    void setCommentArray(CTComment[] cTCommentArr);

    int sizeOfCommentArray();
}
