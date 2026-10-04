package com.microsoft.schemas.vml.impl;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.microsoft.schemas.vml.CTShadow;
import com.microsoft.schemas.vml.STColorType;
import com.microsoft.schemas.vml.STShadowType;
import com.microsoft.schemas.vml.STTrueFalse;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: loaded from: classes6.dex */
public class CTShadowImpl extends XmlComplexContentImpl implements CTShadow {
    private static final QName ID$0 = new QName("", "id");
    private static final QName ON$2 = new QName("", "on");
    private static final QName TYPE$4 = new QName("", "type");
    private static final QName OBSCURED$6 = new QName("", "obscured");
    private static final QName COLOR$8 = new QName("", "color");
    private static final QName OPACITY$10 = new QName("", "opacity");
    private static final QName OFFSET$12 = new QName("", TypedValues.Cycle.S_WAVE_OFFSET);
    private static final QName COLOR2$14 = new QName("", "color2");
    private static final QName OFFSET2$16 = new QName("", "offset2");
    private static final QName ORIGIN$18 = new QName("", "origin");
    private static final QName MATRIX$20 = new QName("", "matrix");

    public CTShadowImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getColor() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR$8);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getColor2() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR2$14);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getMatrix() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(MATRIX$20);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STTrueFalse.Enum getObscured() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OBSCURED$6);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getOffset() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OFFSET$12);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getOffset2() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OFFSET2$16);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STTrueFalse.Enum getOn() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ON$2);
                if (simpleValue == null) {
                    return null;
                }
                return (STTrueFalse.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getOpacity() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(OPACITY$10);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public String getOrigin() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ORIGIN$18);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STShadowType.Enum getType() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TYPE$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$8) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetColor2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR2$14) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetId() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ID$0) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetMatrix() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(MATRIX$20) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetObscured() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OBSCURED$6) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetOffset() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OFFSET$12) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetOffset2() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OFFSET2$16) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetOn() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ON$2) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetOpacity() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(OPACITY$10) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetOrigin() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(ORIGIN$18) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public boolean isSetType() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(TYPE$4) != null;
        }
        return z;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setColor(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = COLOR$8;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setColor2(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = COLOR2$14;
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

    @Override // com.microsoft.schemas.vml.CTShadow
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setMatrix(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MATRIX$20;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setObscured(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OBSCURED$6;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setOffset(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OFFSET$12;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setOffset2(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OFFSET2$16;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setOn(STTrueFalse.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ON$2;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setOpacity(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OPACITY$10;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setOrigin(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ORIGIN$18;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void setType(STShadowType.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$4;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$8);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetColor2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR2$14);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetId() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ID$0);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetMatrix() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(MATRIX$20);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetObscured() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OBSCURED$6);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetOffset() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OFFSET$12);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetOffset2() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OFFSET2$16);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetOn() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ON$2);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetOpacity() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(OPACITY$10);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetOrigin() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(ORIGIN$18);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(TYPE$4);
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STColorType xgetColor() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(COLOR$8);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STColorType xgetColor2() {
        STColorType sTColorTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTColorTypeFind_attribute_user = get_store().find_attribute_user(COLOR2$14);
        }
        return sTColorTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public XmlString xgetId() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ID$0);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public XmlString xgetMatrix() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(MATRIX$20);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STTrueFalse xgetObscured() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(OBSCURED$6);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public XmlString xgetOffset() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OFFSET$12);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public XmlString xgetOffset2() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OFFSET2$16);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STTrueFalse xgetOn() {
        STTrueFalse sTTrueFalse;
        synchronized (monitor()) {
            check_orphaned();
            sTTrueFalse = (STTrueFalse) get_store().find_attribute_user(ON$2);
        }
        return sTTrueFalse;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public XmlString xgetOpacity() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(OPACITY$10);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public XmlString xgetOrigin() {
        XmlString xmlString;
        synchronized (monitor()) {
            check_orphaned();
            xmlString = (XmlString) get_store().find_attribute_user(ORIGIN$18);
        }
        return xmlString;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public STShadowType xgetType() {
        STShadowType sTShadowTypeFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTShadowTypeFind_attribute_user = get_store().find_attribute_user(TYPE$4);
        }
        return sTShadowTypeFind_attribute_user;
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetColor(STColorType sTColorType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = COLOR$8;
                STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTColorTypeFind_attribute_user == null) {
                    sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
                }
                sTColorTypeFind_attribute_user.set(sTColorType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetColor2(STColorType sTColorType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = COLOR2$14;
                STColorType sTColorTypeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTColorTypeFind_attribute_user == null) {
                    sTColorTypeFind_attribute_user = (STColorType) get_store().add_attribute_user(qName);
                }
                sTColorTypeFind_attribute_user.set(sTColorType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetMatrix(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = MATRIX$20;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetObscured(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OBSCURED$6;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetOffset(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OFFSET$12;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetOffset2(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OFFSET2$16;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetOn(STTrueFalse sTTrueFalse) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ON$2;
                STTrueFalse sTTrueFalse2 = (STTrueFalse) typeStore.find_attribute_user(qName);
                if (sTTrueFalse2 == null) {
                    sTTrueFalse2 = (STTrueFalse) get_store().add_attribute_user(qName);
                }
                sTTrueFalse2.set(sTTrueFalse);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetOpacity(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = OPACITY$10;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetOrigin(XmlString xmlString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ORIGIN$18;
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

    @Override // com.microsoft.schemas.vml.CTShadow
    public void xsetType(STShadowType sTShadowType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TYPE$4;
                STShadowType sTShadowTypeFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTShadowTypeFind_attribute_user == null) {
                    sTShadowTypeFind_attribute_user = (STShadowType) get_store().add_attribute_user(qName);
                }
                sTShadowTypeFind_attribute_user.set(sTShadowType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
