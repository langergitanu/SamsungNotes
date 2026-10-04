package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyleList;
import org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument;

/* JADX INFO: loaded from: classes11.dex */
public class TblStyleLstDocumentImpl extends XmlComplexContentImpl implements TblStyleLstDocument {
    private static final QName TBLSTYLELST$0 = new QName(XSSFRelation.NS_DRAWINGML, "tblStyleLst");

    public TblStyleLstDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument
    public CTTableStyleList addNewTblStyleLst() {
        CTTableStyleList cTTableStyleList;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyleList = (CTTableStyleList) get_store().add_element_user(TBLSTYLELST$0);
        }
        return cTTableStyleList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument
    public CTTableStyleList getTblStyleLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTableStyleList cTTableStyleList = (CTTableStyleList) get_store().find_element_user(TBLSTYLELST$0, 0);
                if (cTTableStyleList == null) {
                    return null;
                }
                return cTTableStyleList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.TblStyleLstDocument
    public void setTblStyleLst(CTTableStyleList cTTableStyleList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TBLSTYLELST$0;
                CTTableStyleList cTTableStyleList2 = (CTTableStyleList) typeStore.find_element_user(qName, 0);
                if (cTTableStyleList2 == null) {
                    cTTableStyleList2 = (CTTableStyleList) get_store().add_element_user(qName);
                }
                cTTableStyleList2.set(cTTableStyleList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
