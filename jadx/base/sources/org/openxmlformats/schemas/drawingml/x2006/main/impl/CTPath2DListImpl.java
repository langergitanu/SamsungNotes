package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList;

/* JADX INFO: loaded from: classes11.dex */
public class CTPath2DListImpl extends XmlComplexContentImpl implements CTPath2DList {
    private static final QName PATH$0 = new QName(XSSFRelation.NS_DRAWINGML, "path");

    public CTPath2DListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D addNewPath() {
        CTPath2D cTPath2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2D = (CTPath2D) get_store().add_element_user(PATH$0);
        }
        return cTPath2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D getPathArray(int i) {
        CTPath2D cTPath2D;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTPath2D = (CTPath2D) get_store().find_element_user(PATH$0, i);
                if (cTPath2D == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTPath2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public List<CTPath2D> getPathList() {
        AbstractList<CTPath2D> abstractList;
        synchronized (monitor()) {
            check_orphaned();
            abstractList = new AbstractList<CTPath2D>() { // from class: org.openxmlformats.schemas.drawingml.x2006.main.impl.CTPath2DListImpl.1PathList
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return CTPath2DListImpl.this.sizeOfPathArray();
                }

                @Override // java.util.AbstractList, java.util.List
                public void add(int i, CTPath2D cTPath2D) {
                    CTPath2DListImpl.this.insertNewPath(i).set(cTPath2D);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath2D get(int i) {
                    return CTPath2DListImpl.this.getPathArray(i);
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath2D remove(int i) {
                    CTPath2D pathArray = CTPath2DListImpl.this.getPathArray(i);
                    CTPath2DListImpl.this.removePath(i);
                    return pathArray;
                }

                @Override // java.util.AbstractList, java.util.List
                public CTPath2D set(int i, CTPath2D cTPath2D) {
                    CTPath2D pathArray = CTPath2DListImpl.this.getPathArray(i);
                    CTPath2DListImpl.this.setPathArray(i, cTPath2D);
                    return pathArray;
                }
            };
        }
        return abstractList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D insertNewPath(int i) {
        CTPath2D cTPath2D;
        synchronized (monitor()) {
            check_orphaned();
            cTPath2D = (CTPath2D) get_store().insert_element_user(PATH$0, i);
        }
        return cTPath2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public void removePath(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATH$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public void setPathArray(int i, CTPath2D cTPath2D) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPath2D cTPath2D2 = (CTPath2D) get_store().find_element_user(PATH$0, i);
                if (cTPath2D2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTPath2D2.set(cTPath2D);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public int sizeOfPathArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PATH$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public CTPath2D[] getPathArray() {
        CTPath2D[] cTPath2DArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PATH$0, arrayList);
            cTPath2DArr = new CTPath2D[arrayList.size()];
            arrayList.toArray(cTPath2DArr);
        }
        return cTPath2DArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DList
    public void setPathArray(CTPath2D[] cTPath2DArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTPath2DArr, PATH$0);
        }
    }
}
