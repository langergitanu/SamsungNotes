package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing;

/* JADX INFO: loaded from: classes11.dex */
public class CTDrawingImpl extends XmlComplexContentImpl implements CTDrawing {
    private static final QName ANCHOR$0 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "anchor");
    private static final QName INLINE$2 = new QName("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "inline");

    public CTDrawingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor addNewAnchor() {
        CTAnchor cTAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchor = (CTAnchor) get_store().add_element_user(ANCHOR$0);
        }
        return cTAnchor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline addNewInline() {
        CTInline cTInline;
        synchronized (monitor()) {
            check_orphaned();
            cTInline = (CTInline) get_store().add_element_user(INLINE$2);
        }
        return cTInline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor getAnchorArray(int i) {
        CTAnchor cTAnchor;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAnchor = (CTAnchor) get_store().find_element_user(ANCHOR$0, i);
                if (cTAnchor == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAnchor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public List<CTAnchor> getAnchorList() {
        1AnchorList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1AnchorList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline getInlineArray(int i) {
        CTInline cTInline;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTInline = (CTInline) get_store().find_element_user(INLINE$2, i);
                if (cTInline == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTInline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public List<CTInline> getInlineList() {
        1InlineList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1InlineList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor insertNewAnchor(int i) {
        CTAnchor cTAnchor;
        synchronized (monitor()) {
            check_orphaned();
            cTAnchor = (CTAnchor) get_store().insert_element_user(ANCHOR$0, i);
        }
        return cTAnchor;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline insertNewInline(int i) {
        CTInline cTInline;
        synchronized (monitor()) {
            check_orphaned();
            cTInline = (CTInline) get_store().insert_element_user(INLINE$2, i);
        }
        return cTInline;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void removeAnchor(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(ANCHOR$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void removeInline(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INLINE$2, i);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setAnchorArray(int i, CTAnchor cTAnchor) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTAnchor cTAnchor2 = (CTAnchor) get_store().find_element_user(ANCHOR$0, i);
                if (cTAnchor2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTAnchor2.set(cTAnchor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setInlineArray(int i, CTInline cTInline) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTInline cTInline2 = (CTInline) get_store().find_element_user(INLINE$2, i);
                if (cTInline2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTInline2.set(cTInline);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public int sizeOfAnchorArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(ANCHOR$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public int sizeOfInlineArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(INLINE$2);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTAnchor[] getAnchorArray() {
        CTAnchor[] cTAnchorArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(ANCHOR$0, arrayList);
            cTAnchorArr = new CTAnchor[arrayList.size()];
            arrayList.toArray(cTAnchorArr);
        }
        return cTAnchorArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public CTInline[] getInlineArray() {
        CTInline[] cTInlineArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(INLINE$2, arrayList);
            cTInlineArr = new CTInline[arrayList.size()];
            arrayList.toArray(cTInlineArr);
        }
        return cTInlineArr;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setAnchorArray(CTAnchor[] cTAnchorArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAnchorArr, ANCHOR$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing
    public void setInlineArray(CTInline[] cTInlineArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTInlineArr, INLINE$2);
        }
    }
}
