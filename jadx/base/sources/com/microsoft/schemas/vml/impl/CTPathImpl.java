package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.office.office.STConnectType;
import com.microsoft.schemas.office.office.STTrueFalse;
import com.microsoft.schemas.vml.CTPath;
import com.microsoft.schemas.vml.STTrueFalse;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes6.dex */
public class CTPathImpl extends XmlComplexContentImpl implements CTPath {
    private static final QName ID$0 = new QName("", "id");
    private static final QName V$2 = new QName("", VPathDataCmd.RCurveTo);
    private static final QName LIMO$4 = new QName("", "limo");
    private static final QName TEXTBOXRECT$6 = new QName("", "textboxrect");
    private static final QName FILLOK$8 = new QName("", "fillok");
    private static final QName STROKEOK$10 = new QName("", "strokeok");
    private static final QName SHADOWOK$12 = new QName("", "shadowok");
    private static final QName ARROWOK$14 = new QName("", "arrowok");
    private static final QName GRADIENTSHAPEOK$16 = new QName("", "gradientshapeok");
    private static final QName TEXTPATHOK$18 = new QName("", "textpathok");
    private static final QName INSETPENOK$20 = new QName("", "insetpenok");
    private static final QName CONNECTTYPE$22 = new QName("urn:schemas-microsoft-com:office:office", "connecttype");
    private static final QName CONNECTLOCS$24 = new QName("urn:schemas-microsoft-com:office:office", "connectlocs");
    private static final QName CONNECTANGLES$26 = new QName("urn:schemas-microsoft-com:office:office", "connectangles");
    private static final QName EXTRUSIONOK$28 = new QName("urn:schemas-microsoft-com:office:office", "extrusionok");

    public CTPathImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getArrowok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ARROWOK$14);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public String getConnectangles() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CONNECTANGLES$26);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public String getConnectlocs() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CONNECTLOCS$24);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STConnectType.Enum getConnecttype() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(CONNECTTYPE$22);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getExtrusionok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(EXTRUSIONOK$28);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getFillok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FILLOK$8);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getGradientshapeok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(GRADIENTSHAPEOK$16);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public String getId() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ID$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getInsetpenok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(INSETPENOK$20);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public String getLimo() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LIMO$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getShadowok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SHADOWOK$12);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getStrokeok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(STROKEOK$10);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public String getTextboxrect() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TEXTBOXRECT$6);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STTrueFalse.Enum getTextpathok() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TEXTPATHOK$18);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public String getV() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(V$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetArrowok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ARROWOK$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetConnectangles() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTANGLES$26) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetConnectlocs() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTLOCS$24) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetConnecttype() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(CONNECTTYPE$22) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetExtrusionok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(EXTRUSIONOK$28) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetFillok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(FILLOK$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetGradientshapeok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(GRADIENTSHAPEOK$16) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetInsetpenok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(INSETPENOK$20) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetLimo() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LIMO$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetShadowok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SHADOWOK$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetStrokeok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(STROKEOK$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetTextboxrect() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXTBOXRECT$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetTextpathok() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TEXTPATHOK$18) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public boolean isSetV() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(V$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setArrowok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ARROWOK$14;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setConnectangles(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONNECTANGLES$26;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setConnectlocs(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONNECTLOCS$24;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setConnecttype(STConnectType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONNECTTYPE$22;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setExtrusionok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTRUSIONOK$28;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setFillok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FILLOK$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setGradientshapeok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRADIENTSHAPEOK$16;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setId(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setInsetpenok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSETPENOK$20;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setLimo(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LIMO$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setShadowok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHADOWOK$12;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setStrokeok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STROKEOK$10;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setTextboxrect(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TEXTBOXRECT$6;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setTextpathok(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TEXTPATHOK$18;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(r4);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void setV(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = V$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetArrowok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ARROWOK$14);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetConnectangles() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTANGLES$26);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetConnectlocs() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTLOCS$24);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetConnecttype() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(CONNECTTYPE$22);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetExtrusionok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(EXTRUSIONOK$28);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetFillok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(FILLOK$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetGradientshapeok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(GRADIENTSHAPEOK$16);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetInsetpenok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(INSETPENOK$20);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetLimo() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LIMO$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetShadowok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SHADOWOK$12);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetStrokeok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(STROKEOK$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetTextboxrect() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXTBOXRECT$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetTextpathok() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TEXTPATHOK$18);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void unsetV() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(V$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetArrowok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(ARROWOK$14);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public XmlString xgetConnectangles() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(CONNECTANGLES$26);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public XmlString xgetConnectlocs() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(CONNECTLOCS$24);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public STConnectType xgetConnecttype() {
        STConnectType sTConnectTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTConnectTypeFind_attribute_user = get_store().find_attribute_user(CONNECTTYPE$22);
        }
        return sTConnectTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.office.office.STTrueFalse xgetExtrusionok() {
        com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalseFind_attribute_user = get_store().find_attribute_user(EXTRUSIONOK$28);
        }
        return sTTrueFalseFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetFillok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(FILLOK$8);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetGradientshapeok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(GRADIENTSHAPEOK$16);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$0);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetInsetpenok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(INSETPENOK$20);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public XmlString xgetLimo() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(LIMO$4);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetShadowok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(SHADOWOK$12);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetStrokeok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(STROKEOK$10);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public XmlString xgetTextboxrect() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(TEXTBOXRECT$6);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public com.microsoft.schemas.vml.STTrueFalse xgetTextpathok() {
        com.microsoft.schemas.vml.STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (com.microsoft.schemas.vml.STTrueFalse) get_store().find_attribute_user(TEXTPATHOK$18);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public XmlString xgetV() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(V$2);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetArrowok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ARROWOK$14;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetConnectangles(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONNECTANGLES$26;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetConnectlocs(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONNECTLOCS$24;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetConnecttype(STConnectType sTConnectType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = CONNECTTYPE$22;
                STConnectType sTConnectTypeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTConnectTypeFind_attribute_user == null) {
                    sTConnectTypeFind_attribute_user = (STConnectType) get_store().add_attribute_user(qName);
                }
                sTConnectTypeFind_attribute_user.set(sTConnectType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetExtrusionok(com.microsoft.schemas.office.office.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = EXTRUSIONOK$28;
                com.microsoft.schemas.office.office.STTrueFalse sTTrueFalseFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTTrueFalseFind_attribute_user == null) {
                    sTTrueFalseFind_attribute_user = (com.microsoft.schemas.office.office.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalseFind_attribute_user.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetFillok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FILLOK$8;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetGradientshapeok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GRADIENTSHAPEOK$16;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetId(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ID$0;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetInsetpenok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INSETPENOK$20;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetLimo(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LIMO$4;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetShadowok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SHADOWOK$12;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetStrokeok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STROKEOK$10;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetTextboxrect(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TEXTBOXRECT$6;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetTextpathok(com.microsoft.schemas.vml.STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TEXTPATHOK$18;
                com.microsoft.schemas.vml.STTrueFalse sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (com.microsoft.schemas.vml.STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTPath
    public void xsetV(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = V$2;
                XmlString xmlString2 = (XmlString) typeStore.find_attribute_user(qName);
                if (xmlString2 == null) {
                    xmlString2 = (XmlString) get_store().add_attribute_user(qName);
                }
                xmlString2.set(xmlString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
