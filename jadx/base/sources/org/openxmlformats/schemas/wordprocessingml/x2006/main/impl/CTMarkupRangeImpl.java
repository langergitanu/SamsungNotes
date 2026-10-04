package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDisplacedByCustomXml;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STDisplacedByCustomXml$Enum;

/* JADX INFO: loaded from: classes11.dex */
public class CTMarkupRangeImpl extends CTMarkupImpl implements CTMarkupRange {
    private static final QName DISPLACEDBYCUSTOMXML$0 = new QName("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "displacedByCustomXml");

    public CTMarkupRangeImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange
    public STDisplacedByCustomXml$Enum getDisplacedByCustomXml() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0);
                if (simpleValue == null) {
                    return null;
                }
                return (STDisplacedByCustomXml$Enum) simpleValue.getEnumValue();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange
    public boolean isSetDisplacedByCustomXml() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0) != null;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange
    public void setDisplacedByCustomXml(STDisplacedByCustomXml$Enum sTDisplacedByCustomXml$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DISPLACEDBYCUSTOMXML$0;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qName);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qName);
                }
                simpleValue.setEnumValue(sTDisplacedByCustomXml$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange
    public void unsetDisplacedByCustomXml() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(DISPLACEDBYCUSTOMXML$0);
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange
    public STDisplacedByCustomXml xgetDisplacedByCustomXml() {
        STDisplacedByCustomXml sTDisplacedByCustomXmlFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTDisplacedByCustomXmlFind_attribute_user = get_store().find_attribute_user(DISPLACEDBYCUSTOMXML$0);
        }
        return sTDisplacedByCustomXmlFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTMarkupRange
    public void xsetDisplacedByCustomXml(STDisplacedByCustomXml sTDisplacedByCustomXml) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = DISPLACEDBYCUSTOMXML$0;
                STDisplacedByCustomXml sTDisplacedByCustomXmlFind_attribute_user = typeStore.find_attribute_user(qName);
                if (sTDisplacedByCustomXmlFind_attribute_user == null) {
                    sTDisplacedByCustomXmlFind_attribute_user = (STDisplacedByCustomXml) get_store().add_attribute_user(qName);
                }
                sTDisplacedByCustomXmlFind_attribute_user.set(sTDisplacedByCustomXml);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
