package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectContainer;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEffectList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNoFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPatternFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTableStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.STGuid;

/* JADX INFO: loaded from: classes11.dex */
public class CTTablePropertiesImpl extends XmlComplexContentImpl implements CTTableProperties {
    private static final QName NOFILL$0 = new QName(XSSFRelation.NS_DRAWINGML, "noFill");
    private static final QName SOLIDFILL$2 = new QName(XSSFRelation.NS_DRAWINGML, "solidFill");
    private static final QName GRADFILL$4 = new QName(XSSFRelation.NS_DRAWINGML, "gradFill");
    private static final QName BLIPFILL$6 = new QName(XSSFRelation.NS_DRAWINGML, "blipFill");
    private static final QName PATTFILL$8 = new QName(XSSFRelation.NS_DRAWINGML, "pattFill");
    private static final QName GRPFILL$10 = new QName(XSSFRelation.NS_DRAWINGML, "grpFill");
    private static final QName EFFECTLST$12 = new QName(XSSFRelation.NS_DRAWINGML, "effectLst");
    private static final QName EFFECTDAG$14 = new QName(XSSFRelation.NS_DRAWINGML, "effectDag");
    private static final QName TABLESTYLE$16 = new QName(XSSFRelation.NS_DRAWINGML, "tableStyle");
    private static final QName TABLESTYLEID$18 = new QName(XSSFRelation.NS_DRAWINGML, "tableStyleId");
    private static final QName EXTLST$20 = new QName(XSSFRelation.NS_DRAWINGML, "extLst");
    private static final QName RTL$22 = new QName("", "rtl");
    private static final QName FIRSTROW$24 = new QName("", "firstRow");
    private static final QName FIRSTCOL$26 = new QName("", "firstCol");
    private static final QName LASTROW$28 = new QName("", "lastRow");
    private static final QName LASTCOL$30 = new QName("", "lastCol");
    private static final QName BANDROW$32 = new QName("", "bandRow");
    private static final QName BANDCOL$34 = new QName("", "bandCol");

    public CTTablePropertiesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTBlipFillProperties addNewBlipFill() {
        CTBlipFillProperties cTBlipFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTBlipFillProperties = (CTBlipFillProperties) get_store().add_element_user(BLIPFILL$6);
        }
        return cTBlipFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTEffectContainer addNewEffectDag() {
        CTEffectContainer cTEffectContainerAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectContainerAdd_element_user = get_store().add_element_user(EFFECTDAG$14);
        }
        return cTEffectContainerAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTEffectList addNewEffectLst() {
        CTEffectList cTEffectListAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEffectListAdd_element_user = get_store().add_element_user(EFFECTLST$12);
        }
        return cTEffectListAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(EXTLST$20);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTGradientFillProperties addNewGradFill() {
        CTGradientFillProperties cTGradientFillPropertiesAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTGradientFillPropertiesAdd_element_user = get_store().add_element_user(GRADFILL$4);
        }
        return cTGradientFillPropertiesAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTGroupFillProperties addNewGrpFill() {
        CTGroupFillProperties cTGroupFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTGroupFillProperties = (CTGroupFillProperties) get_store().add_element_user(GRPFILL$10);
        }
        return cTGroupFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTNoFillProperties addNewNoFill() {
        CTNoFillProperties cTNoFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTNoFillProperties = (CTNoFillProperties) get_store().add_element_user(NOFILL$0);
        }
        return cTNoFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTPatternFillProperties addNewPattFill() {
        CTPatternFillProperties cTPatternFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTPatternFillProperties = (CTPatternFillProperties) get_store().add_element_user(PATTFILL$8);
        }
        return cTPatternFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTSolidColorFillProperties addNewSolidFill() {
        CTSolidColorFillProperties cTSolidColorFillProperties;
        synchronized (monitor()) {
            check_orphaned();
            cTSolidColorFillProperties = (CTSolidColorFillProperties) get_store().add_element_user(SOLIDFILL$2);
        }
        return cTSolidColorFillProperties;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTTableStyle addNewTableStyle() {
        CTTableStyle cTTableStyle;
        synchronized (monitor()) {
            check_orphaned();
            cTTableStyle = (CTTableStyle) get_store().add_element_user(TABLESTYLE$16);
        }
        return cTTableStyle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getBandCol() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDCOL$34;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getBandRow() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDROW$32;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTEffectContainer getEffectDag() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEffectContainer cTEffectContainerFind_element_user = get_store().find_element_user(EFFECTDAG$14, 0);
                if (cTEffectContainerFind_element_user == null) {
                    return null;
                }
                return cTEffectContainerFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTEffectList getEffectLst() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEffectList cTEffectListFind_element_user = get_store().find_element_user(EFFECTLST$12, 0);
                if (cTEffectListFind_element_user == null) {
                    return null;
                }
                return cTEffectListFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getFirstCol() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTCOL$26;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getFirstRow() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTROW$24;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getLastCol() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTCOL$30;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getLastRow() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTROW$28;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean getRtl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RTL$22;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public CTTableStyle getTableStyle() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTableStyle cTTableStyle = (CTTableStyle) get_store().find_element_user(TABLESTYLE$16, 0);
                if (cTTableStyle == null) {
                    return null;
                }
                return cTTableStyle;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public String getTableStyleId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_element_user(TABLESTYLEID$18, 0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetBandCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BANDCOL$34) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetBandRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(BANDROW$32) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetBlipFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BLIPFILL$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetEffectDag() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTDAG$14) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetEffectLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EFFECTLST$12) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetExtLst() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(EXTLST$20) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetFirstCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTCOL$26) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetFirstRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FIRSTROW$24) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetGradFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRADFILL$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetGrpFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(GRPFILL$10) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetLastCol() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LASTCOL$30) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetLastRow() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LASTROW$28) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetNoFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(NOFILL$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetPattFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(PATTFILL$8) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetRtl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(RTL$22) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetSolidFill() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SOLIDFILL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetTableStyle() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABLESTYLE$16) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public boolean isSetTableStyleId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TABLESTYLEID$18) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setBandCol(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDCOL$34;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setBandRow(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDROW$32;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setEffectDag(CTEffectContainer cTEffectContainer) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EFFECTDAG$14;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setEffectLst(CTEffectList cTEffectList) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EFFECTLST$12;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setFirstCol(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTCOL$26;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setFirstRow(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTROW$24;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setLastCol(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTCOL$30;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setLastRow(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTROW$28;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setRtl(boolean z) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RTL$22;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setTableStyle(CTTableStyle cTTableStyle) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TABLESTYLE$16;
                CTTableStyle cTTableStyle2 = (CTTableStyle) typeStore.find_element_user(qName, 0);
                if (cTTableStyle2 == null) {
                    cTTableStyle2 = (CTTableStyle) get_store().add_element_user(qName);
                }
                cTTableStyle2.set(cTTableStyle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void setTableStyleId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TABLESTYLEID$18;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_element_user(qName, 0);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_element_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetBandCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BANDCOL$34);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetBandRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(BANDROW$32);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetBlipFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BLIPFILL$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetEffectDag() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTDAG$14, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetEffectLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EFFECTLST$12, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(EXTLST$20, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetFirstCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTCOL$26);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetFirstRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FIRSTROW$24);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetGradFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRADFILL$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetGrpFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(GRPFILL$10, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetLastCol() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LASTCOL$30);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetLastRow() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LASTROW$28);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetNoFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(NOFILL$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetPattFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PATTFILL$8, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetRtl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(RTL$22);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetSolidFill() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SOLIDFILL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetTableStyle() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLESTYLE$16, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void unsetTableStyleId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TABLESTYLEID$18, 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetBandCol() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDCOL$34;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetBandRow() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDROW$32;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetFirstCol() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTCOL$26;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetFirstRow() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTROW$24;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetLastCol() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTCOL$30;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetLastRow() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTROW$28;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public XmlBoolean xgetRtl() {
        XmlBoolean xmlBoolean;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RTL$22;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public STGuid xgetTableStyleId() {
        STGuid sTGuid;
        synchronized (monitor()) {
            check_orphaned();
            sTGuid = (STGuid) get_store().find_element_user(TABLESTYLEID$18, 0);
        }
        return sTGuid;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetBandCol(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDCOL$34;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetBandRow(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BANDROW$32;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetFirstCol(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTCOL$26;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetFirstRow(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FIRSTROW$24;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetLastCol(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTCOL$30;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetLastRow(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LASTROW$28;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetRtl(XmlBoolean xmlBoolean) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RTL$22;
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTableProperties
    public void xsetTableStyleId(STGuid sTGuid) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TABLESTYLEID$18;
                STGuid sTGuid2 = (STGuid) typeStore.find_element_user(qName, 0);
                if (sTGuid2 == null) {
                    sTGuid2 = (STGuid) get_store().add_element_user(qName);
                }
                sTGuid2.set(sTGuid);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
