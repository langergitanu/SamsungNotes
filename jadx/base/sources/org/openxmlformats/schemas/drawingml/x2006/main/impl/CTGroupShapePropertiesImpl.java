package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScene3D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode;
import org.openxmlformats.schemas.drawingml.x2006.main.STBlackWhiteMode$Enum;

/* JADX INFO: loaded from: classes11.dex */
public class CTGroupShapePropertiesImpl extends XmlComplexContentImpl implements CTGroupShapeProperties {
    private static final QName XFRM$0 = new QName(XSSFRelation.NS_DRAWINGML, "xfrm");
    private static final QName NOFILL$2 = new QName(XSSFRelation.NS_DRAWINGML, "noFill");
    private static final QName SOLIDFILL$4 = new QName(XSSFRelation.NS_DRAWINGML, "solidFill");
    private static final QName GRADFILL$6 = new QName(XSSFRelation.NS_DRAWINGML, "gradFill");
    private static final QName BLIPFILL$8 = new QName(XSSFRelation.NS_DRAWINGML, "blipFill");
    private static final QName PATTFILL$10 = new QName(XSSFRelation.NS_DRAWINGML, "pattFill");
    private static final QName GRPFILL$12 = new QName(XSSFRelation.NS_DRAWINGML, "grpFill");
    private static final QName EFFECTLST$14 = new QName(XSSFRelation.NS_DRAWINGML, "effectLst");
    private static final QName EFFECTDAG$16 = new QName(XSSFRelation.NS_DRAWINGML, "effectDag");
    private static final QName SCENE3D$18 = new QName(XSSFRelation.NS_DRAWINGML, "scene3d");
    private static final QName EXTLST$20 = new QName(XSSFRelation.NS_DRAWINGML, "extLst");
    private static final QName BWMODE$22 = new QName("", "bwMode");

    public CTGroupShapePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$8);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTEffectContainer addNewEffectDag() {
        CTEffectContainer cTEffectContainerAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainerAdd_element_user = get_store().add_element_user(EFFECTDAG$16);
        }
        return cTEffectContainerAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTEffectList addNewEffectLst() {
        CTEffectList cTEffectListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectListAdd_element_user = get_store().add_element_user(EFFECTLST$14);
        }
        return cTEffectListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$20);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillPropertiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillPropertiesAdd_element_user = get_store().add_element_user(GRADFILL$6);
        }
        return cTGradientFillPropertiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().add_element_user(GRPFILL$12);
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$2);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PATTFILL$10);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTScene3D addNewScene3D() {
        CTScene3D cTScene3DAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTScene3DAdd_element_user = get_store().add_element_user(SCENE3D$18);
        }
        return cTScene3DAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$4);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTGroupTransform2D addNewXfrm() {
        CTGroupTransform2D cTGroupTransform2D;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupTransform2D = (CTGroupTransform2D) get_store().add_element_user(XFRM$0);
        }
        return cTGroupTransform2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTBlipFillProperties getBlipFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTBlipFillProperties cTBlipFillProperties = (CTBlipFillProperties) get_store().find_element_user(BLIPFILL$8, 0);
                if (cTBlipFillProperties == null) {
                    return null;
                }
                return cTBlipFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public STBlackWhiteMode$Enum getBwMode() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BWMODE$22);
                if (simpleValue == null) {
                    return null;
                }
                return (STBlackWhiteMode$Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTEffectContainer getEffectDag() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEffectContainer cTEffectContainerFind_element_user = get_store().find_element_user(EFFECTDAG$16, 0);
                if (cTEffectContainerFind_element_user == null) {
                    return null;
                }
                return cTEffectContainerFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTEffectList getEffectLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEffectList cTEffectListFind_element_user = get_store().find_element_user(EFFECTLST$14, 0);
                if (cTEffectListFind_element_user == null) {
                    return null;
                }
                return cTEffectListFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTOfficeArtExtensionList getExtLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOfficeArtExtensionList cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(EXTLST$20, 0);
                if (cTOfficeArtExtensionList == null) {
                    return null;
                }
                return cTOfficeArtExtensionList;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTGradientFillProperties getGradFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGradientFillProperties cTGradientFillPropertiesFind_element_user = get_store().find_element_user(GRADFILL$6, 0);
                if (cTGradientFillPropertiesFind_element_user == null) {
                    return null;
                }
                return cTGradientFillPropertiesFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTGroupFillProperties getGrpFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupFillProperties cTGroupFillProperties = (CTGroupFillProperties) get_store().find_element_user(GRPFILL$12, 0);
                if (cTGroupFillProperties == null) {
                    return null;
                }
                return cTGroupFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTNoFillProperties getNoFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTNoFillProperties cTNoFillProperties = (CTNoFillProperties) get_store().find_element_user(NOFILL$2, 0);
                if (cTNoFillProperties == null) {
                    return null;
                }
                return cTNoFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTPatternFillProperties getPattFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTPatternFillProperties cTPatternFillProperties = (CTPatternFillProperties) get_store().find_element_user(PATTFILL$10, 0);
                if (cTPatternFillProperties == null) {
                    return null;
                }
                return cTPatternFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTScene3D getScene3D() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTScene3D cTScene3DFind_element_user = get_store().find_element_user(SCENE3D$18, 0);
                if (cTScene3DFind_element_user == null) {
                    return null;
                }
                return cTScene3DFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTSolidColorFillProperties getSolidFill() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().find_element_user(SOLIDFILL$4, 0);
                if (cTSolidColorFillProperties == null) {
                    return null;
                }
                return cTSolidColorFillProperties;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public CTGroupTransform2D getXfrm() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTGroupTransform2D cTGroupTransform2D = (CTGroupTransform2D) get_store().find_element_user(XFRM$0, 0);
                if (cTGroupTransform2D == null) {
                    return null;
                }
                return cTGroupTransform2D;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetBlipFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIPFILL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetBwMode() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BWMODE$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetEffectDag() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTDAG$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetEffectLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTLST$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetGrpFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPFILL$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetScene3D() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SCENE3D$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public boolean isSetXfrm() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(XFRM$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setBlipFill(CTBlipFillProperties cTBlipFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BLIPFILL$8;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setBwMode(STBlackWhiteMode$Enum sTBlackWhiteMode$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BWMODE$22;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(sTBlackWhiteMode$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setEffectDag(CTEffectContainer cTEffectContainer) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EFFECTDAG$16;
                CTEffectContainer cTEffectContainerFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTEffectContainerFind_element_user == null) {
                    cTEffectContainerFind_element_user = (CTEffectContainer) get_store().add_element_user(qName);
                }
                cTEffectContainerFind_element_user.set(cTEffectContainer);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setEffectLst(CTEffectList cTEffectList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EFFECTLST$14;
                CTEffectList cTEffectListFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTEffectListFind_element_user == null) {
                    cTEffectListFind_element_user = (CTEffectList) get_store().add_element_user(qName);
                }
                cTEffectListFind_element_user.set(cTEffectList);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTLST$20;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setGradFill(CTGradientFillProperties cTGradientFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRADFILL$6;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setGrpFill(CTGroupFillProperties cTGroupFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRPFILL$12;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setNoFill(CTNoFillProperties cTNoFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NOFILL$2;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setPattFill(CTPatternFillProperties cTPatternFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = PATTFILL$10;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setScene3D(CTScene3D cTScene3D) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SCENE3D$18;
                CTScene3D cTScene3DFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTScene3DFind_element_user == null) {
                    cTScene3DFind_element_user = (CTScene3D) get_store().add_element_user(qName);
                }
                cTScene3DFind_element_user.set(cTScene3D);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SOLIDFILL$4;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void setXfrm(CTGroupTransform2D cTGroupTransform2D) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = XFRM$0;
                CTGroupTransform2D cTGroupTransform2D2 = (CTGroupTransform2D) typeStore.find_element_user(qName, 0);
                if (cTGroupTransform2D2 == null) {
                    cTGroupTransform2D2 = (CTGroupTransform2D) get_store().add_element_user(qName);
                }
                cTGroupTransform2D2.set(cTGroupTransform2D);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetBwMode() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BWMODE$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTDAG$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTLST$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetScene3D() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SCENE3D$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void unsetXfrm() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(XFRM$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public STBlackWhiteMode xgetBwMode() {
        STBlackWhiteMode sTBlackWhiteModeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTBlackWhiteModeFind_attribute_user = get_store().find_attribute_user(BWMODE$22);
        }
        return sTBlackWhiteModeFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties
    public void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BWMODE$22;
                STBlackWhiteMode sTBlackWhiteModeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTBlackWhiteModeFind_attribute_user == null) {
                    sTBlackWhiteModeFind_attribute_user = (STBlackWhiteMode) get_store().add_attribute_user(qName);
                }
                sTBlackWhiteModeFind_attribute_user.set(sTBlackWhiteMode);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
