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
public interface CTFFData extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFFData.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctffdataaa7etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFFData newInstance() {
            return (CTFFData) POIXMLTypeLoader.newInstance(CTFFData.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFFData.type, null);
        }

        public static CTFFData parse(File file) {
            return (CTFFData) POIXMLTypeLoader.parse(file, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData newInstance(XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.newInstance(CTFFData.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(File file, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(file, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(InputStream inputStream) {
            return (CTFFData) POIXMLTypeLoader.parse(inputStream, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(inputStream, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(Reader reader) {
            return (CTFFData) POIXMLTypeLoader.parse(reader, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(reader, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(String str) {
            return (CTFFData) POIXMLTypeLoader.parse(str, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(String str, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(str, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(URL url) {
            return (CTFFData) POIXMLTypeLoader.parse(url, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(URL url, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(url, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(XMLStreamReader xMLStreamReader) {
            return (CTFFData) POIXMLTypeLoader.parse(xMLStreamReader, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(xMLStreamReader, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(XMLInputStream xMLInputStream) {
            return (CTFFData) POIXMLTypeLoader.parse(xMLInputStream, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(xMLInputStream, CTFFData.type, xmlOptions);
        }

        public static CTFFData parse(Node node) {
            return (CTFFData) POIXMLTypeLoader.parse(node, CTFFData.type, (XmlOptions) null);
        }

        public static CTFFData parse(Node node, XmlOptions xmlOptions) {
            return (CTFFData) POIXMLTypeLoader.parse(node, CTFFData.type, xmlOptions);
        }
    }

    CTOnOff addNewCalcOnExit();

    CTFFCheckBox addNewCheckBox();

    CTFFDDList addNewDdList();

    CTOnOff addNewEnabled();

    CTMacroName addNewEntryMacro();

    CTMacroName addNewExitMacro();

    CTFFHelpText addNewHelpText();

    CTFFName addNewName();

    CTFFStatusText addNewStatusText();

    CTFFTextInput addNewTextInput();

    CTOnOff getCalcOnExitArray(int i);

    CTOnOff[] getCalcOnExitArray();

    List<CTOnOff> getCalcOnExitList();

    CTFFCheckBox getCheckBoxArray(int i);

    CTFFCheckBox[] getCheckBoxArray();

    List<CTFFCheckBox> getCheckBoxList();

    CTFFDDList getDdListArray(int i);

    CTFFDDList[] getDdListArray();

    List<CTFFDDList> getDdListList();

    CTOnOff getEnabledArray(int i);

    CTOnOff[] getEnabledArray();

    List<CTOnOff> getEnabledList();

    CTMacroName getEntryMacroArray(int i);

    CTMacroName[] getEntryMacroArray();

    List<CTMacroName> getEntryMacroList();

    CTMacroName getExitMacroArray(int i);

    CTMacroName[] getExitMacroArray();

    List<CTMacroName> getExitMacroList();

    CTFFHelpText getHelpTextArray(int i);

    CTFFHelpText[] getHelpTextArray();

    List<CTFFHelpText> getHelpTextList();

    CTFFName getNameArray(int i);

    CTFFName[] getNameArray();

    List<CTFFName> getNameList();

    CTFFStatusText getStatusTextArray(int i);

    CTFFStatusText[] getStatusTextArray();

    List<CTFFStatusText> getStatusTextList();

    CTFFTextInput getTextInputArray(int i);

    CTFFTextInput[] getTextInputArray();

    List<CTFFTextInput> getTextInputList();

    CTOnOff insertNewCalcOnExit(int i);

    CTFFCheckBox insertNewCheckBox(int i);

    CTFFDDList insertNewDdList(int i);

    CTOnOff insertNewEnabled(int i);

    CTMacroName insertNewEntryMacro(int i);

    CTMacroName insertNewExitMacro(int i);

    CTFFHelpText insertNewHelpText(int i);

    CTFFName insertNewName(int i);

    CTFFStatusText insertNewStatusText(int i);

    CTFFTextInput insertNewTextInput(int i);

    void removeCalcOnExit(int i);

    void removeCheckBox(int i);

    void removeDdList(int i);

    void removeEnabled(int i);

    void removeEntryMacro(int i);

    void removeExitMacro(int i);

    void removeHelpText(int i);

    void removeName(int i);

    void removeStatusText(int i);

    void removeTextInput(int i);

    void setCalcOnExitArray(int i, CTOnOff cTOnOff);

    void setCalcOnExitArray(CTOnOff[] cTOnOffArr);

    void setCheckBoxArray(int i, CTFFCheckBox cTFFCheckBox);

    void setCheckBoxArray(CTFFCheckBox[] cTFFCheckBoxArr);

    void setDdListArray(int i, CTFFDDList cTFFDDList);

    void setDdListArray(CTFFDDList[] cTFFDDListArr);

    void setEnabledArray(int i, CTOnOff cTOnOff);

    void setEnabledArray(CTOnOff[] cTOnOffArr);

    void setEntryMacroArray(int i, CTMacroName cTMacroName);

    void setEntryMacroArray(CTMacroName[] cTMacroNameArr);

    void setExitMacroArray(int i, CTMacroName cTMacroName);

    void setExitMacroArray(CTMacroName[] cTMacroNameArr);

    void setHelpTextArray(int i, CTFFHelpText cTFFHelpText);

    void setHelpTextArray(CTFFHelpText[] cTFFHelpTextArr);

    void setNameArray(int i, CTFFName cTFFName);

    void setNameArray(CTFFName[] cTFFNameArr);

    void setStatusTextArray(int i, CTFFStatusText cTFFStatusText);

    void setStatusTextArray(CTFFStatusText[] cTFFStatusTextArr);

    void setTextInputArray(int i, CTFFTextInput cTFFTextInput);

    void setTextInputArray(CTFFTextInput[] cTFFTextInputArr);

    int sizeOfCalcOnExitArray();

    int sizeOfCheckBoxArray();

    int sizeOfDdListArray();

    int sizeOfEnabledArray();

    int sizeOfEntryMacroArray();

    int sizeOfExitMacroArray();

    int sizeOfHelpTextArray();

    int sizeOfNameArray();

    int sizeOfStatusTextArray();

    int sizeOfTextInputArray();
}
