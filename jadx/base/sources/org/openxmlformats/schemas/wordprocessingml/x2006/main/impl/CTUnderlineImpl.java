package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHexColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STThemeColor;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUcharHexNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STUnderline;

/* JADX INFO: loaded from: classes11.dex */
public class CTUnderlineImpl extends XmlComplexContentImpl implements CTUnderline {
    private static final QName VAL$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", VElementFormulasCmd.FVAL);
    private static final QName COLOR$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "color");
    private static final QName THEMECOLOR$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeColor");
    private static final QName THEMETINT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeTint");
    private static final QName THEMESHADE$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "themeShade");

    public CTUnderlineImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public Object getColor() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(COLOR$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STThemeColor.Enum getThemeColor() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(THEMECOLOR$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public byte[] getThemeShade() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(THEMESHADE$8);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getByteArrayValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public byte[] getThemeTint() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(THEMETINT$6);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getByteArrayValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUnderline.Enum getVal() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(VAL$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STUnderline.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(COLOR$2) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetThemeColor() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMECOLOR$4) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetThemeShade() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMESHADE$8) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetThemeTint() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(THEMETINT$6) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public boolean isSetVal() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(VAL$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setColor(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = COLOR$2;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setThemeColor(STThemeColor.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEMECOLOR$4;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setThemeShade(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEMESHADE$8;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setThemeTint(byte[] bArr) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEMETINT$6;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setByteArrayValue(bArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void setVal(STUnderline.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(COLOR$2);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetThemeColor() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMECOLOR$4);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetThemeShade() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMESHADE$8);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetThemeTint() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(THEMETINT$6);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void unsetVal() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(VAL$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STHexColor xgetColor() {
        STHexColor sTHexColor;
        synchronized (monitor()) {
            check_orphaned();
            sTHexColor = (STHexColor) get_store().find_attribute_user(COLOR$2);
        }
        return sTHexColor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STThemeColor xgetThemeColor() {
        STThemeColor sTThemeColorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTThemeColorFind_attribute_user = get_store().find_attribute_user(THEMECOLOR$4);
        }
        return sTThemeColorFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUcharHexNumber xgetThemeShade() {
        STUcharHexNumber sTUcharHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUcharHexNumberFind_attribute_user = get_store().find_attribute_user(THEMESHADE$8);
        }
        return sTUcharHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUcharHexNumber xgetThemeTint() {
        STUcharHexNumber sTUcharHexNumberFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTUcharHexNumberFind_attribute_user = get_store().find_attribute_user(THEMETINT$6);
        }
        return sTUcharHexNumberFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public STUnderline xgetVal() {
        STUnderline sTUnderline;
        synchronized (monitor()) {
            check_orphaned();
            sTUnderline = (STUnderline) get_store().find_attribute_user(VAL$0);
        }
        return sTUnderline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetColor(STHexColor sTHexColor) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = COLOR$2;
                STHexColor sTHexColor2 = (STHexColor) typeStore.find_attribute_user(qName);
                if (sTHexColor2 == null) {
                    sTHexColor2 = (STHexColor) get_store().add_attribute_user(qName);
                }
                sTHexColor2.set(sTHexColor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetThemeColor(STThemeColor sTThemeColor) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEMECOLOR$4;
                STThemeColor sTThemeColorFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTThemeColorFind_attribute_user == null) {
                    sTThemeColorFind_attribute_user = (STThemeColor) get_store().add_attribute_user(qName);
                }
                sTThemeColorFind_attribute_user.set(sTThemeColor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetThemeShade(STUcharHexNumber sTUcharHexNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEMESHADE$8;
                STUcharHexNumber sTUcharHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTUcharHexNumberFind_attribute_user == null) {
                    sTUcharHexNumberFind_attribute_user = (STUcharHexNumber) get_store().add_attribute_user(qName);
                }
                sTUcharHexNumberFind_attribute_user.set(sTUcharHexNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetThemeTint(STUcharHexNumber sTUcharHexNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEMETINT$6;
                STUcharHexNumber sTUcharHexNumberFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTUcharHexNumberFind_attribute_user == null) {
                    sTUcharHexNumberFind_attribute_user = (STUcharHexNumber) get_store().add_attribute_user(qName);
                }
                sTUcharHexNumberFind_attribute_user.set(sTUcharHexNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTUnderline
    public void xsetVal(STUnderline sTUnderline) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = VAL$0;
                STUnderline sTUnderline2 = (STUnderline) typeStore.find_attribute_user(qName);
                if (sTUnderline2 == null) {
                    sTUnderline2 = (STUnderline) get_store().add_attribute_user(qName);
                }
                sTUnderline2.set(sTUnderline);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
