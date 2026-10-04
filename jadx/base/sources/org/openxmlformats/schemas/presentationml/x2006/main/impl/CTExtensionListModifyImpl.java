package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtension;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;

/* JADX INFO: loaded from: classes11.dex */
public class CTExtensionListModifyImpl extends XmlComplexContentImpl implements CTExtensionListModify {
    private static final QName EXT$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "ext");
    private static final QName MOD$2 = new QName("", VElementFormulasCmd.FMOD);

    public CTExtensionListModifyImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public CTExtension addNewExt() {
        CTExtension cTExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTExtension = (CTExtension) get_store().add_element_user(EXT$0);
        }
        return cTExtension;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public CTExtension getExtArray(int i) {
        CTExtension cTExtension;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExtension = (CTExtension) get_store().find_element_user(EXT$0, i);
                if (cTExtension == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExtension;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public List<CTExtension> getExtList() {
        AbstractList<CTExtension> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTExtension>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTExtensionListModifyImpl.1ExtList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTExtensionListModifyImpl.this.sizeOfExtArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTExtension cTExtension) {
                    CTExtensionListModifyImpl.this.insertNewExt(i).set(cTExtension);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtension get(int i) {
                    return CTExtensionListModifyImpl.this.getExtArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtension remove(int i) {
                    CTExtension extArray = CTExtensionListModifyImpl.this.getExtArray(i);
                    CTExtensionListModifyImpl.this.removeExt(i);
                    return extArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtension set(int i, CTExtension cTExtension) {
                    CTExtension extArray = CTExtensionListModifyImpl.this.getExtArray(i);
                    CTExtensionListModifyImpl.this.setExtArray(i, cTExtension);
                    return extArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public boolean getMod() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MOD$2;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public CTExtension insertNewExt(int i) {
        CTExtension cTExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTExtension = (CTExtension) get_store().insert_element_user(EXT$0, i);
        }
        return cTExtension;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public boolean isSetMod() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MOD$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public void removeExt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public void setExtArray(int i, CTExtension cTExtension) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtension cTExtension2 = (CTExtension) get_store().find_element_user(EXT$0, i);
                if (cTExtension2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTExtension2.set(cTExtension);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public void setMod(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MOD$2;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public int sizeOfExtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public void unsetMod() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MOD$2);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public XmlBoolean xgetMod() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MOD$2;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public void xsetMod(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MOD$2;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public CTExtension[] getExtArray() {
        CTExtension[] cTExtensionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(EXT$0, arrayList);
            cTExtensionArr = new CTExtension[arrayList.size()];
            arrayList.toArray(cTExtensionArr);
        }
        return cTExtensionArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify
    public void setExtArray(CTExtension[] cTExtensionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTExtensionArr, EXT$0);
        }
    }
}
