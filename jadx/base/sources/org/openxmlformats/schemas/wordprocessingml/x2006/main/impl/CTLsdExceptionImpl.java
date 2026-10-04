package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLsdException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STString;

/* JADX INFO: loaded from: classes11.dex */
public class CTLsdExceptionImpl extends XmlComplexContentImpl implements CTLsdException {
    private static final QName NAME$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "name");
    private static final QName LOCKED$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "locked");
    private static final QName UIPRIORITY$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "uiPriority");
    private static final QName SEMIHIDDEN$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "semiHidden");
    private static final QName UNHIDEWHENUSED$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "unhideWhenUsed");
    private static final QName QFORMAT$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "qFormat");

    public CTLsdExceptionImpl(SchemaType schemaType) {
        super(schemaType);
    }

    public STOnOff.Enum getLocked() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LOCKED$2);
                if (simpleValue == null) {
                    return null;
                }
                return (STOnOff.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getName() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(NAME$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getStringValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public STOnOff.Enum getQFormat() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(QFORMAT$10);
                if (simpleValue == null) {
                    return null;
                }
                return (STOnOff.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public STOnOff.Enum getSemiHidden() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(SEMIHIDDEN$6);
                if (simpleValue == null) {
                    return null;
                }
                return (STOnOff.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public BigInteger getUiPriority() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(UIPRIORITY$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public STOnOff.Enum getUnhideWhenUsed() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(UNHIDEWHENUSED$8);
                if (simpleValue == null) {
                    return null;
                }
                return (STOnOff.Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean isSetLocked() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(LOCKED$2) != null;
        }
        return z;
    }

    public boolean isSetQFormat() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(QFORMAT$10) != null;
        }
        return z;
    }

    public boolean isSetSemiHidden() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(SEMIHIDDEN$6) != null;
        }
        return z;
    }

    public boolean isSetUiPriority() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UIPRIORITY$4) != null;
        }
        return z;
    }

    public boolean isSetUnhideWhenUsed() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(UNHIDEWHENUSED$8) != null;
        }
        return z;
    }

    public void setLocked(STOnOff.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LOCKED$2;
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

    public void setName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
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

    public void setQFormat(STOnOff.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = QFORMAT$10;
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

    public void setSemiHidden(STOnOff.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SEMIHIDDEN$6;
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

    public void setUiPriority(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = UIPRIORITY$4;
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

    public void setUnhideWhenUsed(STOnOff.Enum r4) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = UNHIDEWHENUSED$8;
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

    public void unsetLocked() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(LOCKED$2);
        }
    }

    public void unsetQFormat() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(QFORMAT$10);
        }
    }

    public void unsetSemiHidden() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(SEMIHIDDEN$6);
        }
    }

    public void unsetUiPriority() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UIPRIORITY$4);
        }
    }

    public void unsetUnhideWhenUsed() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(UNHIDEWHENUSED$8);
        }
    }

    public STOnOff xgetLocked() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(LOCKED$2);
        }
        return sTOnOff;
    }

    public STString xgetName() {
        STString sTString;
        synchronized (monitor()) {
            check_orphaned();
            sTString = (STString) get_store().find_attribute_user(NAME$0);
        }
        return sTString;
    }

    public STOnOff xgetQFormat() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(QFORMAT$10);
        }
        return sTOnOff;
    }

    public STOnOff xgetSemiHidden() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(SEMIHIDDEN$6);
        }
        return sTOnOff;
    }

    public STDecimalNumber xgetUiPriority() {
        STDecimalNumber sTDecimalNumber;
        synchronized (monitor()) {
            check_orphaned();
            sTDecimalNumber = (STDecimalNumber) get_store().find_attribute_user(UIPRIORITY$4);
        }
        return sTDecimalNumber;
    }

    public STOnOff xgetUnhideWhenUsed() {
        STOnOff sTOnOff;
        synchronized (monitor()) {
            check_orphaned();
            sTOnOff = (STOnOff) get_store().find_attribute_user(UNHIDEWHENUSED$8);
        }
        return sTOnOff;
    }

    public void xsetLocked(STOnOff sTOnOff) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LOCKED$2;
                STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
                if (sTOnOff2 == null) {
                    sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
                }
                sTOnOff2.set(sTOnOff);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xsetName(STString sTString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = NAME$0;
                STString sTString2 = (STString) typeStore.find_attribute_user(qName);
                if (sTString2 == null) {
                    sTString2 = (STString) get_store().add_attribute_user(qName);
                }
                sTString2.set(sTString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xsetQFormat(STOnOff sTOnOff) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = QFORMAT$10;
                STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
                if (sTOnOff2 == null) {
                    sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
                }
                sTOnOff2.set(sTOnOff);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xsetSemiHidden(STOnOff sTOnOff) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SEMIHIDDEN$6;
                STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
                if (sTOnOff2 == null) {
                    sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
                }
                sTOnOff2.set(sTOnOff);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xsetUiPriority(STDecimalNumber sTDecimalNumber) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = UIPRIORITY$4;
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

    public void xsetUnhideWhenUsed(STOnOff sTOnOff) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = UNHIDEWHENUSED$8;
                STOnOff sTOnOff2 = (STOnOff) typeStore.find_attribute_user(qName);
                if (sTOnOff2 == null) {
                    sTOnOff2 = (STOnOff) get_store().add_attribute_user(qName);
                }
                sTOnOff2.set(sTOnOff);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
