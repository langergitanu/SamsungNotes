package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STDirection;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderSize$Enum;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* JADX INFO: loaded from: classes11.dex */
public class CTPlaceholderImpl extends XmlComplexContentImpl implements CTPlaceholder {
    private static final QName EXTLST$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");
    private static final QName TYPE$2 = new QName("", "type");
    private static final QName ORIENT$4 = new QName("", "orient");
    private static final QName SZ$6 = new QName("", "sz");
    private static final QName IDX$8 = new QName("", "idx");
    private static final QName HASCUSTOMPROMPT$10 = new QName("", "hasCustomPrompt");

    public CTPlaceholderImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModify;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModify = (CTExtensionListModify) get_store().add_element_user(EXTLST$0);
        }
        return cTExtensionListModify;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionListModify cTExtensionListModify = (CTExtensionListModify) get_store().find_element_user(EXTLST$0, 0);
                if (cTExtensionListModify == null) {
                    return null;
                }
                return cTExtensionListModify;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean getHasCustomPrompt() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HASCUSTOMPROMPT$10;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return false;
                }
                return simpleValue.getBooleanValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public long getIdx() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = IDX$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return 0L;
                }
                return simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STDirection.Enum getOrient() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ORIENT$4;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderSize$Enum getSz() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SZ$6;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return (STPlaceholderSize$Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderType.Enum getType() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qName);
                }
                if (simpleValue == null) {
                    return null;
                }
                return (STPlaceholderType.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetHasCustomPrompt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(HASCUSTOMPROMPT$10) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetIdx() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(IDX$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetOrient() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIENT$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetSz() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SZ$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$0;
                CTExtensionListModify cTExtensionListModify2 = (CTExtensionListModify) typeStore.find_element_user(qName, 0);
                if (cTExtensionListModify2 == null) {
                    cTExtensionListModify2 = (CTExtensionListModify) get_store().add_element_user(qName);
                }
                cTExtensionListModify2.set(cTExtensionListModify);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setHasCustomPrompt(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HASCUSTOMPROMPT$10;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setBooleanValue(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setIdx(long j) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = IDX$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setLongValue(j);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setOrient(STDirection.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ORIENT$4;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setSz(STPlaceholderSize$Enum sTPlaceholderSize$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SZ$6;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(sTPlaceholderSize$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void setType(STPlaceholderType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$2;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetHasCustomPrompt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(HASCUSTOMPROMPT$10);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetIdx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(IDX$8);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetOrient() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIENT$4);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetSz() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SZ$6);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public XmlBoolean xgetHasCustomPrompt() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HASCUSTOMPROMPT$10;
                xmlBoolean = (XmlBoolean) typeStore.find_attribute_user(qName);
                if (xmlBoolean == null) {
                    xmlBoolean = (XmlBoolean) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlBoolean;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public XmlUnsignedInt xgetIdx() {
        XmlUnsignedInt xmlUnsignedInt;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = IDX$8;
                xmlUnsignedInt = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
                if (xmlUnsignedInt == null) {
                    xmlUnsignedInt = (XmlUnsignedInt) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return xmlUnsignedInt;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STDirection xgetOrient() {
        STDirection sTDirectionFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ORIENT$4;
                sTDirectionFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTDirectionFind_attribute_user == null) {
                    sTDirectionFind_attribute_user = (STDirection) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTDirectionFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderSize xgetSz() {
        STPlaceholderSize sTPlaceholderSizeFind_attribute_user;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SZ$6;
                sTPlaceholderSizeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTPlaceholderSizeFind_attribute_user == null) {
                    sTPlaceholderSizeFind_attribute_user = (STPlaceholderSize) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPlaceholderSizeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public STPlaceholderType xgetType() {
        STPlaceholderType sTPlaceholderType;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$2;
                sTPlaceholderType = (STPlaceholderType) typeStore.find_attribute_user(qName);
                if (sTPlaceholderType == null) {
                    sTPlaceholderType = (STPlaceholderType) get_default_attribute_value(qName);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTPlaceholderType;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetHasCustomPrompt(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HASCUSTOMPROMPT$10;
                XmlBoolean xmlBoolean2 = (XmlBoolean) typeStore.find_attribute_user(qName);
                if (xmlBoolean2 == null) {
                    xmlBoolean2 = (XmlBoolean) get_store().add_attribute_user(qName);
                }
                xmlBoolean2.set(xmlBoolean);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetIdx(XmlUnsignedInt xmlUnsignedInt) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = IDX$8;
                XmlUnsignedInt xmlUnsignedInt2 = (XmlUnsignedInt) typeStore.find_attribute_user(qName);
                if (xmlUnsignedInt2 == null) {
                    xmlUnsignedInt2 = (XmlUnsignedInt) get_store().add_attribute_user(qName);
                }
                xmlUnsignedInt2.set(xmlUnsignedInt);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetOrient(STDirection sTDirection) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ORIENT$4;
                STDirection sTDirectionFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTDirectionFind_attribute_user == null) {
                    sTDirectionFind_attribute_user = (STDirection) get_store().add_attribute_user(qName);
                }
                sTDirectionFind_attribute_user.set(sTDirection);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetSz(STPlaceholderSize sTPlaceholderSize) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SZ$6;
                STPlaceholderSize sTPlaceholderSizeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTPlaceholderSizeFind_attribute_user == null) {
                    sTPlaceholderSizeFind_attribute_user = (STPlaceholderSize) get_store().add_attribute_user(qName);
                }
                sTPlaceholderSizeFind_attribute_user.set(sTPlaceholderSize);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder
    public void xsetType(STPlaceholderType sTPlaceholderType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$2;
                STPlaceholderType sTPlaceholderType2 = (STPlaceholderType) typeStore.find_attribute_user(qName);
                if (sTPlaceholderType2 == null) {
                    sTPlaceholderType2 = (STPlaceholderType) get_store().add_attribute_user(qName);
                }
                sTPlaceholderType2.set(sTPlaceholderType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
