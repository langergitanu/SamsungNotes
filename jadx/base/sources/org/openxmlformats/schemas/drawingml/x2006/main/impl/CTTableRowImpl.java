package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableCell;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow;
import org.openxmlformats.schemas.drawingml.x2006.main.STCoordinate;

/* JADX INFO: loaded from: classes11.dex */
public class CTTableRowImpl extends XmlComplexContentImpl implements CTTableRow {
    private static final QName TC$0 = new QName(XSSFRelation.NS_DRAWINGML, LangPackConfigConstants.LANGUAGE_CODE_TC);
    private static final QName EXTLST$2 = new QName(XSSFRelation.NS_DRAWINGML, "extLst");
    private static final QName H$4 = new QName("", "h");

    public CTTableRowImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$2);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public CTTableCell addNewTc() {
        CTTableCell cTTableCell;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCell = (CTTableCell) get_store().add_element_user(TC$0);
        }
        return cTTableCell;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$2, 0);
                if (cTOfficeArtExtensionList == null) {
                    return null;
                }
                return cTOfficeArtExtensionList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public long getH() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(H$4);
                if (simpleValue == null) {
                    return 0L;
                }
                return simpleValue.getLongValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public CTTableCell getTcArray(int i) {
        CTTableCell cTTableCell;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTableCell = (CTTableCell) get_store().find_element_user(TC$0, i);
                if (cTTableCell == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTableCell;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public List<CTTableCell> getTcList() {
        1TcList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1TcList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public CTTableCell insertNewTc(int i) {
        CTTableCell cTTableCell;
        synchronized (monitor()) {
            check_orphaned();
            cTTableCell = (CTTableCell) get_store().insert_element_user(TC$0, i);
        }
        return cTTableCell;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void removeTc(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TC$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$2;
                CTOfficeArtExtensionList cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) typeStore.find_element_user(qName, 0);
                if (cTOfficeArtExtensionList2 == null) {
                    cTOfficeArtExtensionList2 = (CTOfficeArtExtensionList) get_store().add_element_user(qName);
                }
                cTOfficeArtExtensionList2.set(cTOfficeArtExtensionList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void setH(long j) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = H$4;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void setTcArray(int i, CTTableCell cTTableCell) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTableCell cTTableCell2 = (CTTableCell) get_store().find_element_user(TC$0, i);
                if (cTTableCell2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTTableCell2.set(cTTableCell);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public int sizeOfTcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(TC$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public STCoordinate xgetH() {
        STCoordinate sTCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTCoordinate = (STCoordinate) get_store().find_attribute_user(H$4);
        }
        return sTCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void xsetH(STCoordinate sTCoordinate) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = H$4;
                STCoordinate sTCoordinate2 = (STCoordinate) typeStore.find_attribute_user(qName);
                if (sTCoordinate2 == null) {
                    sTCoordinate2 = (STCoordinate) get_store().add_attribute_user(qName);
                }
                sTCoordinate2.set(sTCoordinate);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public CTTableCell[] getTcArray() {
        CTTableCell[] cTTableCellArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(TC$0, arrayList);
            cTTableCellArr = new CTTableCell[arrayList.size()];
            arrayList.toArray(cTTableCellArr);
        }
        return cTTableCellArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableRow
    public void setTcArray(CTTableCell[] cTTableCellArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTTableCellArr, TC$0);
        }
    }
}
