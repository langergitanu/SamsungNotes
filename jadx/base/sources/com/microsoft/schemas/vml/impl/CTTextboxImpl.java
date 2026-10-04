package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.office.STInsetMode;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.CTTextbox;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTxbxContent;

/* JADX INFO: loaded from: classes6.dex */
public class CTTextboxImpl extends XmlComplexContentImpl implements CTTextbox {
    private static final QName TXBXCONTENT$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "txbxContent");
    private static final QName ID$2 = new QName("", "id");
    private static final QName STYLE$4 = new QName("", "style");
    private static final QName INSET$6 = new QName("", "inset");
    private static final QName SINGLECLICK$8 = new QName("urn:schemas-microsoft-com:office:office", "singleclick");
    private static final QName INSETMODE$10 = new QName("urn:schemas-microsoft-com:office:office", "insetmode");

    public CTTextboxImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public CTTxbxContent addNewTxbxContent() {
        CTTxbxContent cTTxbxContent;
        synchronized (monitor()) {
            check_orphaned();
            cTTxbxContent = (CTTxbxContent) get_store().add_element_user(TXBXCONTENT$0);
        }
        return cTTxbxContent;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public String getId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public String getInset() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INSET$6);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public STInsetMode.Enum getInsetmode() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSETMODE$10;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public STTrueFalse.Enum getSingleclick() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SINGLECLICK$8);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public String getStyle() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STYLE$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public CTTxbxContent getTxbxContent() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTxbxContent cTTxbxContent = (CTTxbxContent) get_store().find_element_user(TXBXCONTENT$0, 0);
                if (cTTxbxContent == null) {
                    return null;
                }
                return cTTxbxContent;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public boolean isSetInset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSET$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public boolean isSetInsetmode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETMODE$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public boolean isSetSingleclick() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SINGLECLICK$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public boolean isSetStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STYLE$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public boolean isSetTxbxContent() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TXBXCONTENT$0) != 0;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void setId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void setInset(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSET$6;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void setInsetmode(STInsetMode.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSETMODE$10;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void setSingleclick(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SINGLECLICK$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void setStyle(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STYLE$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void setTxbxContent(CTTxbxContent cTTxbxContent) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TXBXCONTENT$0;
                CTTxbxContent cTTxbxContent2 = (CTTxbxContent) typeStore.find_element_user(qName, 0);
                if (cTTxbxContent2 == null) {
                    cTTxbxContent2 = (CTTxbxContent) get_store().add_element_user(qName);
                }
                cTTxbxContent2.set(cTTxbxContent);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void unsetInset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSET$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void unsetInsetmode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETMODE$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void unsetSingleclick() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SINGLECLICK$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void unsetStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STYLE$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void unsetTxbxContent() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TXBXCONTENT$0, 0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$2);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public XmlString xgetInset() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(INSET$6);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public STInsetMode xgetInsetmode() {
        STInsetMode sTInsetModeFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSETMODE$10;
                sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTInsetModeFind_attribute_user == null) {
                    sTInsetModeFind_attribute_user = (STInsetMode) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTInsetModeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public STTrueFalse xgetSingleclick() {
        STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(SINGLECLICK$8);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public XmlString xgetStyle() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(STYLE$4);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$2;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void xsetInset(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSET$6;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void xsetInsetmode(STInsetMode sTInsetMode) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSETMODE$10;
                STInsetMode sTInsetModeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTInsetModeFind_attribute_user == null) {
                    sTInsetModeFind_attribute_user = (STInsetMode) get_store().add_attribute_user(qName);
                }
                sTInsetModeFind_attribute_user.set(sTInsetMode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void xsetSingleclick(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SINGLECLICK$8;
                STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTrueFalseFind_attribute_user == null) {
                    sTTrueFalseFind_attribute_user = (STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalseFind_attribute_user.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTTextbox
    public void xsetStyle(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STYLE$4;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
