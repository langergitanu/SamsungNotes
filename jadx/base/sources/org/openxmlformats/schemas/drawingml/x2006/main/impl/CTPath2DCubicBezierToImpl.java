package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;

/* JADX INFO: loaded from: classes11.dex */
public class CTPath2DCubicBezierToImpl extends XmlComplexContentImpl implements CTPath2DCubicBezierTo {
    private static final QName PT$0 = new QName(XSSFRelation.NS_DRAWINGML, LangPackConfigConstants.LANGUAGE_CODE_PT);

    public CTPath2DCubicBezierToImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D addNewPt() {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().add_element_user(PT$0);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D getPtArray(int i) {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTAdjPoint2D = (CTAdjPoint2D) get_store().find_element_user(PT$0, i);
                if (cTAdjPoint2D == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public List<CTAdjPoint2D> getPtList() {
        1PtList r12;
        synchronized (monitor()) {
            check_orphaned();
            r12 = new 1PtList(this);
        }
        return r12;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D insertNewPt(int i) {
        CTAdjPoint2D cTAdjPoint2D;
        synchronized (monitor()) {
            check_orphaned();
            cTAdjPoint2D = (CTAdjPoint2D) get_store().insert_element_user(PT$0, i);
        }
        return cTAdjPoint2D;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public void removePt(int i) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PT$0, i);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public void setPtArray(int i, CTAdjPoint2D cTAdjPoint2D) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTAdjPoint2D cTAdjPoint2D2 = (CTAdjPoint2D) get_store().find_element_user(PT$0, i);
                if (cTAdjPoint2D2 == null) {
                    throw new IndexOutOfBoundsException();
                }
                cTAdjPoint2D2.set(cTAdjPoint2D);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public int sizeOfPtArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PT$0);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public CTAdjPoint2D[] getPtArray() {
        CTAdjPoint2D[] cTAdjPoint2DArr;
        synchronized (monitor()) {
            check_orphaned();
            ArrayList arrayList = new ArrayList();
            get_store().find_all_element_users(PT$0, arrayList);
            cTAdjPoint2DArr = new CTAdjPoint2D[arrayList.size()];
            arrayList.toArray(cTAdjPoint2DArr);
        }
        return cTAdjPoint2DArr;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo
    public void setPtArray(CTAdjPoint2D[] cTAdjPoint2DArr) {
        synchronized (monitor()) {
            check_orphaned();
            arraySetterHelper(cTAdjPoint2DArr, PT$0);
        }
    }
}
