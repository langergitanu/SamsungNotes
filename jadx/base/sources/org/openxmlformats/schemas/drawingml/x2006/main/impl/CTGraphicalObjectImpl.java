package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;

/* JADX INFO: loaded from: classes11.dex */
public class CTGraphicalObjectImpl extends XmlComplexContentImpl implements CTGraphicalObject {
    private static final QName GRAPHICDATA$0 = new QName(XSSFRelation.NS_DRAWINGML, "graphicData");

    public CTGraphicalObjectImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject
    public CTGraphicalObjectData addNewGraphicData() {
        CTGraphicalObjectData cTGraphicalObjectData;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectData = (CTGraphicalObjectData) get_store().add_element_user(GRAPHICDATA$0);
        }
        return cTGraphicalObjectData;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject
    public CTGraphicalObjectData getGraphicData() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGraphicalObjectData cTGraphicalObjectData = (CTGraphicalObjectData) get_store().find_element_user(GRAPHICDATA$0, 0);
                if (cTGraphicalObjectData == null) {
                    return null;
                }
                return cTGraphicalObjectData;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject
    public void setGraphicData(CTGraphicalObjectData cTGraphicalObjectData) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRAPHICDATA$0;
                CTGraphicalObjectData cTGraphicalObjectData2 = (CTGraphicalObjectData) typeStore.find_element_user(qName, 0);
                if (cTGraphicalObjectData2 == null) {
                    cTGraphicalObjectData2 = (CTGraphicalObjectData) get_store().add_element_user(qName);
                }
                cTGraphicalObjectData2.set(cTGraphicalObjectData);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
