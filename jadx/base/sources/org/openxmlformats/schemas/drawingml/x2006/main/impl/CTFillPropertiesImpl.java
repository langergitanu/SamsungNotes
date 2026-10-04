package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;

/* JADX INFO: loaded from: classes11.dex */
public class CTFillPropertiesImpl extends XmlComplexContentImpl implements CTFillProperties {
    private static final QName NOFILL$0 = new QName(XSSFRelation.NS_DRAWINGML, "noFill");
    private static final QName SOLIDFILL$2 = new QName(XSSFRelation.NS_DRAWINGML, "solidFill");
    private static final QName GRADFILL$4 = new QName(XSSFRelation.NS_DRAWINGML, "gradFill");
    private static final QName BLIPFILL$6 = new QName(XSSFRelation.NS_DRAWINGML, "blipFill");
    private static final QName PATTFILL$8 = new QName(XSSFRelation.NS_DRAWINGML, "pattFill");
    private static final QName GRPFILL$10 = new QName(XSSFRelation.NS_DRAWINGML, "grpFill");

    public CTFillPropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$6);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillPropertiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillPropertiesAdd_element_user = get_store().add_element_user(GRADFILL$4);
        }
        return cTGradientFillPropertiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().add_element_user(GRPFILL$10);
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$0);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PATTFILL$8);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$2);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$6, 0);
                if (cTBlipFillProperties == null) {
                    return null;
                }
                return cTBlipFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTGradientFillProperties getGradFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGradientFillProperties cTGradientFillPropertiesFind_element_user = get_store().find_element_user(GRADFILL$4, 0);
                if (cTGradientFillPropertiesFind_element_user == null) {
                    return null;
                }
                return cTGradientFillPropertiesFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTGroupFillProperties getGrpFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupFillProperties cTGroupFillProperties = (CTGroupFillProperties) get_store().find_element_user(GRPFILL$10, 0);
                if (cTGroupFillProperties == null) {
                    return null;
                }
                return cTGroupFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTNoFillProperties getNoFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTNoFillProperties cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$0, 0);
                if (cTNoFillProperties == null) {
                    return null;
                }
                return cTNoFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTPatternFillProperties getPattFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPatternFillProperties cTPatternFillProperties = (CTPatternFillProperties) get_store().find_element_user(PATTFILL$8, 0);
                if (cTPatternFillProperties == null) {
                    return null;
                }
                return cTPatternFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public CTSolidColorFillProperties getSolidFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$2, 0);
                if (cTSolidColorFillProperties == null) {
                    return null;
                }
                return cTSolidColorFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public boolean isSetBlipFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIPFILL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public boolean isSetGrpFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPFILL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLIPFILL$6;
                CTBlipFillProperties cTBlipFillProperties2 = (CTBlipFillProperties) typeStore.find_element_user(qName, 0);
                if (cTBlipFillProperties2 == null) {
                    cTBlipFillProperties2 = (CTBlipFillProperties) get_store().add_element_user(qName);
                }
                cTBlipFillProperties2.set(cTBlipFillProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRADFILL$4;
                CTGradientFillProperties cTGradientFillPropertiesFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTGradientFillPropertiesFind_element_user == null) {
                    cTGradientFillPropertiesFind_element_user = (CTGradientFillProperties) get_store().add_element_user(qName);
                }
                cTGradientFillPropertiesFind_element_user.set(cTGradientFillProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRPFILL$10;
                CTGroupFillProperties cTGroupFillProperties2 = (CTGroupFillProperties) typeStore.find_element_user(qName, 0);
                if (cTGroupFillProperties2 == null) {
                    cTGroupFillProperties2 = (CTGroupFillProperties) get_store().add_element_user(qName);
                }
                cTGroupFillProperties2.set(cTGroupFillProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NOFILL$0;
                CTNoFillProperties cTNoFillProperties2 = (CTNoFillProperties) typeStore.find_element_user(qName, 0);
                if (cTNoFillProperties2 == null) {
                    cTNoFillProperties2 = (CTNoFillProperties) get_store().add_element_user(qName);
                }
                cTNoFillProperties2.set(cTNoFillProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PATTFILL$8;
                CTPatternFillProperties cTPatternFillProperties2 = (CTPatternFillProperties) typeStore.find_element_user(qName, 0);
                if (cTPatternFillProperties2 == null) {
                    cTPatternFillProperties2 = (CTPatternFillProperties) get_store().add_element_user(qName);
                }
                cTPatternFillProperties2.set(cTPatternFillProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOLIDFILL$2;
                CTSolidColorFillProperties cTSolidColorFillProperties2 = (CTSolidColorFillProperties) typeStore.find_element_user(qName, 0);
                if (cTSolidColorFillProperties2 == null) {
                    cTSolidColorFillProperties2 = (CTSolidColorFillProperties) get_store().add_element_user(qName);
                }
                cTSolidColorFillProperties2.set(cTSolidColorFillProperties);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void unsetBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void unsetGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTFillProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$2, 0);
        }
    }
}
