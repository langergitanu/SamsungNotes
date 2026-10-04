package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtension;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList;

/* JADX INFO: loaded from: classes11.dex */
public class CTExtensionListImpl extends XmlComplexContentImpl implements CTExtensionList {
    private static final QName EXT$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "ext");

    public CTExtensionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
    public CTExtension addNewExt() {
        CTExtension cTExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTExtension = (CTExtension) get_store().add_element_user(EXT$0);
        }
        return cTExtension;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
    public List<CTExtension> getExtList() {
        AbstractList<CTExtension> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTExtension>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTExtensionListImpl.1ExtList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTExtensionListImpl.this.sizeOfExtArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTExtension cTExtension) {
                    CTExtensionListImpl.this.insertNewExt(i).set(cTExtension);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtension get(int i) {
                    return CTExtensionListImpl.this.getExtArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtension remove(int i) {
                    CTExtension extArray = CTExtensionListImpl.this.getExtArray(i);
                    CTExtensionListImpl.this.removeExt(i);
                    return extArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTExtension set(int i, CTExtension cTExtension) {
                    CTExtension extArray = CTExtensionListImpl.this.getExtArray(i);
                    CTExtensionListImpl.this.setExtArray(i, cTExtension);
                    return extArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
    public CTExtension insertNewExt(int i) {
        CTExtension cTExtension;
        synchronized (monitor()) {
            check_orphaned();
            cTExtension = (CTExtension) get_store().insert_element_user(EXT$0, i);
        }
        return cTExtension;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
    public void removeExt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
    public int sizeOfExtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(EXT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionList
    public void setExtArray(CTExtension[] cTExtensionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTExtensionArr, EXT$0);
        }
    }
}
