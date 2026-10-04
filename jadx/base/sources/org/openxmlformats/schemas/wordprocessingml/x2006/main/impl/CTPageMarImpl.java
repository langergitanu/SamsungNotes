package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.math.BigInteger;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSignedTwipsMeasure;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTwipsMeasure;

/* JADX INFO: loaded from: classes11.dex */
public class CTPageMarImpl extends XmlComplexContentImpl implements CTPageMar {
    private static final QName TOP$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
    private static final QName RIGHT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");
    private static final QName BOTTOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
    private static final QName LEFT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName HEADER$8 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "header");
    private static final QName FOOTER$10 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "footer");
    private static final QName GUTTER$12 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "gutter");

    public CTPageMarImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getBottom() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(BOTTOM$4);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getFooter() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(FOOTER$10);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getGutter() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(GUTTER$12);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getHeader() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(HEADER$8);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getLeft() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(LEFT$6);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getRight() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(RIGHT$2);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public BigInteger getTop() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(TOP$0);
                if (simpleValue == null) {
                    return null;
                }
                return simpleValue.getBigIntegerValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setBottom(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BOTTOM$4;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setFooter(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FOOTER$10;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setGutter(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GUTTER$12;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setHeader(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HEADER$8;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setLeft(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LEFT$6;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setRight(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RIGHT$2;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void setTop(BigInteger bigInteger) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TOP$0;
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

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STSignedTwipsMeasure xgetBottom() {
        STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedTwipsMeasureFind_attribute_user = get_store().find_attribute_user(BOTTOM$4);
        }
        return sTSignedTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STTwipsMeasure xgetFooter() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(FOOTER$10);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STTwipsMeasure xgetGutter() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(GUTTER$12);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STTwipsMeasure xgetHeader() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(HEADER$8);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STTwipsMeasure xgetLeft() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(LEFT$6);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STTwipsMeasure xgetRight() {
        STTwipsMeasure sTTwipsMeasure;
        synchronized (monitor()) {
            check_orphaned();
            sTTwipsMeasure = (STTwipsMeasure) get_store().find_attribute_user(RIGHT$2);
        }
        return sTTwipsMeasure;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public STSignedTwipsMeasure xgetTop() {
        STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTSignedTwipsMeasureFind_attribute_user = get_store().find_attribute_user(TOP$0);
        }
        return sTSignedTwipsMeasureFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetBottom(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = BOTTOM$4;
                STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTSignedTwipsMeasureFind_attribute_user == null) {
                    sTSignedTwipsMeasureFind_attribute_user = (STSignedTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTSignedTwipsMeasureFind_attribute_user.set(sTSignedTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetFooter(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = FOOTER$10;
                STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
                if (sTTwipsMeasure2 == null) {
                    sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTTwipsMeasure2.set(sTTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetGutter(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = GUTTER$12;
                STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
                if (sTTwipsMeasure2 == null) {
                    sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTTwipsMeasure2.set(sTTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetHeader(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = HEADER$8;
                STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
                if (sTTwipsMeasure2 == null) {
                    sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTTwipsMeasure2.set(sTTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetLeft(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = LEFT$6;
                STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
                if (sTTwipsMeasure2 == null) {
                    sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTTwipsMeasure2.set(sTTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetRight(STTwipsMeasure sTTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = RIGHT$2;
                STTwipsMeasure sTTwipsMeasure2 = (STTwipsMeasure) typeStore.find_attribute_user(qName);
                if (sTTwipsMeasure2 == null) {
                    sTTwipsMeasure2 = (STTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTTwipsMeasure2.set(sTTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar
    public void xsetTop(STSignedTwipsMeasure sTSignedTwipsMeasure) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = TOP$0;
                STSignedTwipsMeasure sTSignedTwipsMeasureFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTSignedTwipsMeasureFind_attribute_user == null) {
                    sTSignedTwipsMeasureFind_attribute_user = (STSignedTwipsMeasure) get_store().add_attribute_user(qName);
                }
                sTSignedTwipsMeasureFind_attribute_user.set(sTSignedTwipsMeasure);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
