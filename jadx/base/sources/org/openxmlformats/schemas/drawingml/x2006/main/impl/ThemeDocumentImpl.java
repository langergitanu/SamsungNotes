package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeStyleSheet;
import org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument;

/* JADX INFO: loaded from: classes11.dex */
public class ThemeDocumentImpl extends XmlComplexContentImpl implements ThemeDocument {
    private static final QName THEME$0 = new QName(XSSFRelation.NS_DRAWINGML, BaseWidgetConstant.WIDGET_THEME);

    public ThemeDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument
    public CTOfficeStyleSheet addNewTheme() {
        CTOfficeStyleSheet cTOfficeStyleSheet;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeStyleSheet = (CTOfficeStyleSheet) get_store().add_element_user(THEME$0);
        }
        return cTOfficeStyleSheet;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument
    public CTOfficeStyleSheet getTheme() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTOfficeStyleSheet cTOfficeStyleSheet = (CTOfficeStyleSheet) get_store().find_element_user(THEME$0, 0);
                if (cTOfficeStyleSheet == null) {
                    return null;
                }
                return cTOfficeStyleSheet;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.ThemeDocument
    public void setTheme(CTOfficeStyleSheet cTOfficeStyleSheet) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = THEME$0;
                CTOfficeStyleSheet cTOfficeStyleSheet2 = (CTOfficeStyleSheet) typeStore.find_element_user(qName, 0);
                if (cTOfficeStyleSheet2 == null) {
                    cTOfficeStyleSheet2 = (CTOfficeStyleSheet) get_store().add_element_user(qName);
                }
                cTOfficeStyleSheet2.set(cTOfficeStyleSheet);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
