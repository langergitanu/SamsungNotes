package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLTimeConditionListImpl extends XmlComplexContentImpl implements CTTLTimeConditionList {
    private static final QName COND$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "cond");

    public CTTLTimeConditionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition addNewCond() {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().add_element_user(COND$0);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition getCondArray(int i) {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeCondition = (CTTLTimeCondition) get_store().find_element_user(COND$0, i);
                if (cTTLTimeCondition == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public List<CTTLTimeCondition> getCondList() {
        AbstractList<CTTLTimeCondition> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTTLTimeCondition>() { // from class: org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTLTimeConditionListImpl.1CondList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTTLTimeConditionListImpl.this.sizeOfCondArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTTLTimeCondition cTTLTimeCondition) {
                    CTTLTimeConditionListImpl.this.insertNewCond(i).set(cTTLTimeCondition);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeCondition get(int i) {
                    return CTTLTimeConditionListImpl.this.getCondArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeCondition remove(int i) {
                    CTTLTimeCondition condArray = CTTLTimeConditionListImpl.this.getCondArray(i);
                    CTTLTimeConditionListImpl.this.removeCond(i);
                    return condArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTTLTimeCondition set(int i, CTTLTimeCondition cTTLTimeCondition) {
                    CTTLTimeCondition condArray = CTTLTimeConditionListImpl.this.getCondArray(i);
                    CTTLTimeConditionListImpl.this.setCondArray(i, cTTLTimeCondition);
                    return condArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition insertNewCond(int i) {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().insert_element_user(COND$0, i);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void removeCond(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(COND$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void setCondArray(int i, CTTLTimeCondition cTTLTimeCondition) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLTimeCondition cTTLTimeCondition2 = (CTTLTimeCondition) get_store().find_element_user(COND$0, i);
                if (cTTLTimeCondition2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTLTimeCondition2.set(cTTLTimeCondition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public int sizeOfCondArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(COND$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition[] getCondArray() {
        CTTLTimeCondition[] cTTLTimeConditionArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(COND$0, arrayList);
            cTTLTimeConditionArr = new CTTLTimeCondition[arrayList.size()];
            arrayList.toArray(cTTLTimeConditionArr);
        }
        return cTTLTimeConditionArr;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void setCondArray(CTTLTimeCondition[] cTTLTimeConditionArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTLTimeConditionArr, COND$0);
        }
    }
}
