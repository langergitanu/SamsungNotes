package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar;

/* JADX INFO: loaded from: classes11.dex */
public class CTTcMarImpl extends XmlComplexContentImpl implements CTTcMar {
    private static final long serialVersionUID = 1;
    private static final QName TOP$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "top");
    private static final QName LEFT$2 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "left");
    private static final QName BOTTOM$4 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "bottom");
    private static final QName RIGHT$6 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "right");

    public CTTcMarImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth addNewBottom() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(BOTTOM$4);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth addNewLeft() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(LEFT$2);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth addNewRight() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(RIGHT$6);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth addNewTop() {
        CTTblWidth cTTblWidth;
        synchronized (monitor()) {
            check_orphaned();
            cTTblWidth = (CTTblWidth) get_store().add_element_user(TOP$0);
        }
        return cTTblWidth;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth getBottom() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(BOTTOM$4, 0);
                if (cTTblWidth == null) {
                    return null;
                }
                return cTTblWidth;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth getLeft() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(LEFT$2, 0);
                if (cTTblWidth == null) {
                    return null;
                }
                return cTTblWidth;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth getRight() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(RIGHT$6, 0);
                if (cTTblWidth == null) {
                    return null;
                }
                return cTTblWidth;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public CTTblWidth getTop() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTblWidth cTTblWidth = (CTTblWidth) get_store().find_element_user(TOP$0, 0);
                if (cTTblWidth == null) {
                    return null;
                }
                return cTTblWidth;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public boolean isSetBottom() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(BOTTOM$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public boolean isSetLeft() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(LEFT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public boolean isSetRight() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(RIGHT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public boolean isSetTop() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(TOP$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void setBottom(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, BOTTOM$4, 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void setLeft(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, LEFT$2, 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void setRight(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, RIGHT$6, 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void setTop(CTTblWidth cTTblWidth) throws Throwable {
        generatedSetterHelperImpl(cTTblWidth, TOP$0, 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void unsetBottom() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(BOTTOM$4, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void unsetLeft() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(LEFT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void unsetRight() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(RIGHT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcMar
    public void unsetTop() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(TOP$0, 0);
        }
    }
}
