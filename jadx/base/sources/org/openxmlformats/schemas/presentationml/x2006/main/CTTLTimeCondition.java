package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.presentationml.x2006.main.STTLTriggerEvent;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTLTimeCondition extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTLTimeCondition.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttltimecondition1eb9type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTLTimeCondition newInstance() {
            return (CTTLTimeCondition) POIXMLTypeLoader.newInstance(CTTLTimeCondition.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeCondition.type, null);
        }

        public static CTTLTimeCondition parse(File file) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(file, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition newInstance(XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.newInstance(CTTLTimeCondition.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(File file, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(file, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(InputStream inputStream) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(inputStream, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(inputStream, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(Reader reader) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(reader, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(reader, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(String str) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(str, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(String str, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(str, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(URL url) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(url, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(URL url, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(url, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(XMLStreamReader xMLStreamReader) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(xMLStreamReader, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(XMLInputStream xMLInputStream) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(xMLInputStream, CTTLTimeCondition.type, xmlOptions);
        }

        public static CTTLTimeCondition parse(Node node) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(node, CTTLTimeCondition.type, (XmlOptions) null);
        }

        public static CTTLTimeCondition parse(Node node, XmlOptions xmlOptions) {
            return (CTTLTimeCondition) POIXMLTypeLoader.parse(node, CTTLTimeCondition.type, xmlOptions);
        }
    }

    CTTLTriggerRuntimeNode addNewRtn();

    CTTLTimeTargetElement addNewTgtEl();

    CTTLTriggerTimeNodeID addNewTn();

    Object getDelay();

    STTLTriggerEvent.Enum getEvt();

    CTTLTriggerRuntimeNode getRtn();

    CTTLTimeTargetElement getTgtEl();

    CTTLTriggerTimeNodeID getTn();

    boolean isSetDelay();

    boolean isSetEvt();

    boolean isSetRtn();

    boolean isSetTgtEl();

    boolean isSetTn();

    void setDelay(Object obj);

    void setEvt(STTLTriggerEvent.Enum r12);

    void setRtn(CTTLTriggerRuntimeNode cTTLTriggerRuntimeNode);

    void setTgtEl(CTTLTimeTargetElement cTTLTimeTargetElement);

    void setTn(CTTLTriggerTimeNodeID cTTLTriggerTimeNodeID);

    void unsetDelay();

    void unsetEvt();

    void unsetRtn();

    void unsetTgtEl();

    void unsetTn();

    STTLTime xgetDelay();

    STTLTriggerEvent xgetEvt();

    void xsetDelay(STTLTime sTTLTime);

    void xsetEvt(STTLTriggerEvent sTTLTriggerEvent);
}
