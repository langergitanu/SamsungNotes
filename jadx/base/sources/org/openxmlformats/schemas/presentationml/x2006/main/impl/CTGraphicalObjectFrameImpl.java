package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTExtensionListModify;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrameNonVisual;

/* JADX INFO: loaded from: classes11.dex */
public class CTGraphicalObjectFrameImpl extends XmlComplexContentImpl implements CTGraphicalObjectFrame {
    private static final QName NVGRAPHICFRAMEPR$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "nvGraphicFramePr");
    private static final QName XFRM$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "xfrm");
    private static final QName GRAPHIC$4 = new QName(XSSFRelation.NS_DRAWINGML, "graphic");
    private static final QName EXTLST$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "extLst");

    public CTGraphicalObjectFrameImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTExtensionListModify addNewExtLst() {
        CTExtensionListModify cTExtensionListModify;
        synchronized (monitor()) {
            check_orphaned();
            cTExtensionListModify = (CTExtensionListModify) get_store().add_element_user(EXTLST$6);
        }
        return cTExtensionListModify;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObject addNewGraphic() {
        CTGraphicalObject cTGraphicalObject;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObject = (CTGraphicalObject) get_store().add_element_user(GRAPHIC$4);
        }
        return cTGraphicalObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr() {
        CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual;
        synchronized (monitor()) {
            check_orphaned();
            cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(NVGRAPHICFRAMEPR$0);
        }
        return cTGraphicalObjectFrameNonVisual;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTTransform2D addNewXfrm() {
        CTTransform2D cTTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTTransform2D = (CTTransform2D) get_store().add_element_user(XFRM$2);
        }
        return cTTransform2D;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTExtensionListModify getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTExtensionListModify cTExtensionListModify = (CTExtensionListModify) get_store().find_element_user(EXTLST$6, 0);
                if (cTExtensionListModify == null) {
                    return null;
                }
                return cTExtensionListModify;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObject getGraphic() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGraphicalObject cTGraphicalObject = (CTGraphicalObject) get_store().find_element_user(GRAPHIC$4, 0);
                if (cTGraphicalObject == null) {
                    return null;
                }
                return cTGraphicalObject;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTGraphicalObjectFrameNonVisual getNvGraphicFramePr() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual = (CTGraphicalObjectFrameNonVisual) get_store().find_element_user(NVGRAPHICFRAMEPR$0, 0);
                if (cTGraphicalObjectFrameNonVisual == null) {
                    return null;
                }
                return cTGraphicalObjectFrameNonVisual;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public CTTransform2D getXfrm() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTransform2D cTTransform2D = (CTTransform2D) get_store().find_element_user(XFRM$2, 0);
                if (cTTransform2D == null) {
                    return null;
                }
                return cTTransform2D;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setExtLst(CTExtensionListModify cTExtensionListModify) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$6;
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

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setGraphic(CTGraphicalObject cTGraphicalObject) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRAPHIC$4;
                CTGraphicalObject cTGraphicalObject2 = (CTGraphicalObject) typeStore.find_element_user(qName, 0);
                if (cTGraphicalObject2 == null) {
                    cTGraphicalObject2 = (CTGraphicalObject) get_store().add_element_user(qName);
                }
                cTGraphicalObject2.set(cTGraphicalObject);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NVGRAPHICFRAMEPR$0;
                CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual2 = (CTGraphicalObjectFrameNonVisual) typeStore.find_element_user(qName, 0);
                if (cTGraphicalObjectFrameNonVisual2 == null) {
                    cTGraphicalObjectFrameNonVisual2 = (CTGraphicalObjectFrameNonVisual) get_store().add_element_user(qName);
                }
                cTGraphicalObjectFrameNonVisual2.set(cTGraphicalObjectFrameNonVisual);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void setXfrm(CTTransform2D cTTransform2D) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XFRM$2;
                CTTransform2D cTTransform2D2 = (CTTransform2D) typeStore.find_element_user(qName, 0);
                if (cTTransform2D2 == null) {
                    cTTransform2D2 = (CTTransform2D) get_store().add_element_user(qName);
                }
                cTTransform2D2.set(cTTransform2D);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$6, 0);
        }
    }
}
