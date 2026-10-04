package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;

/* JADX INFO: loaded from: classes11.dex */
public class CTNumLvlImpl extends XmlComplexContentImpl implements CTNumLvl {
    private static final QName STARTOVERRIDE$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "startOverride");
    private static final QName LVL$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "lvl");
    private static final QName ILVL$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "ilvl");

    public CTNumLvlImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public CTLvl addNewLvl() {
        CTLvl cTLvl;
        synchronized (monitor()) {
            check_orphaned();
            cTLvl = (CTLvl) get_store().add_element_user(LVL$2);
        }
        return cTLvl;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public CTDecimalNumber addNewStartOverride() {
        CTDecimalNumber cTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            cTDecimalNumber = (CTDecimalNumber) get_store().add_element_user(STARTOVERRIDE$0);
        }
        return cTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public BigInteger getIlvl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(ILVL$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public CTLvl getLvl() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTLvl cTLvl = (CTLvl) get_store().find_element_user(LVL$2, 0);
                if (cTLvl == null) {
                    return null;
                }
                return cTLvl;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public CTDecimalNumber getStartOverride() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTDecimalNumber cTDecimalNumber = (CTDecimalNumber) get_store().find_element_user(STARTOVERRIDE$0, 0);
                if (cTDecimalNumber == null) {
                    return null;
                }
                return cTDecimalNumber;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public boolean isSetLvl() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LVL$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public boolean isSetStartOverride() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(STARTOVERRIDE$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public void setIlvl(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ILVL$4;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setBigIntegerValue(bigInteger);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public void setLvl(CTLvl cTLvl) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LVL$2;
                CTLvl cTLvl2 = (CTLvl) typeStore.find_element_user(qName, 0);
                if (cTLvl2 == null) {
                    cTLvl2 = (CTLvl) get_store().add_element_user(qName);
                }
                cTLvl2.set(cTLvl);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public void setStartOverride(CTDecimalNumber cTDecimalNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = STARTOVERRIDE$0;
                CTDecimalNumber cTDecimalNumber2 = (CTDecimalNumber) typeStore.find_element_user(qName, 0);
                if (cTDecimalNumber2 == null) {
                    cTDecimalNumber2 = (CTDecimalNumber) get_store().add_element_user(qName);
                }
                cTDecimalNumber2.set(cTDecimalNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public void unsetLvl() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LVL$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public void unsetStartOverride() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(STARTOVERRIDE$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public STDecimalNumber xgetIlvl() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(ILVL$4);
        }
        return sTDecimalNumber;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl
    public void xsetIlvl(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = ILVL$4;
                STDecimalNumber sTDecimalNumber2 = (STDecimalNumber) typeStore.find_attribute_user(qName);
                if (sTDecimalNumber2 == null) {
                    sTDecimalNumber2 = (STDecimalNumber) get_store().add_attribute_user(qName);
                }
                sTDecimalNumber2.set(sTDecimalNumber);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
