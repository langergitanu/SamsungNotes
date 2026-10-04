package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import org.apache.poi.javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTEmbeddedWAVAudioFile;
import org.openxmlformats.schemas.presentationml.x2006.main.CTEmpty;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLSubShapeId;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement;

/* JADX INFO: loaded from: classes11.dex */
public class CTTLTimeTargetElementImpl extends XmlComplexContentImpl implements CTTLTimeTargetElement {
    private static final QName SLDTGT$0 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sldTgt");
    private static final QName SNDTGT$2 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "sndTgt");
    private static final QName SPTGT$4 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "spTgt");
    private static final QName INKTGT$6 = new QName("http://schemas.openxmlformats.org/presentationml/2006/main", "inkTgt");

    public CTTLTimeTargetElementImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLSubShapeId addNewInkTgt() {
        CTTLSubShapeId cTTLSubShapeIdAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTTLSubShapeIdAdd_element_user = get_store().add_element_user(INKTGT$6);
        }
        return cTTLSubShapeIdAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmpty addNewSldTgt() {
        CTEmpty cTEmptyAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmptyAdd_element_user = get_store().add_element_user(SLDTGT$0);
        }
        return cTEmptyAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmbeddedWAVAudioFile addNewSndTgt() {
        CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileAdd_element_user;
        synchronized (monitor()) {
            check_orphaned();
            cTEmbeddedWAVAudioFileAdd_element_user = get_store().add_element_user(SNDTGT$2);
        }
        return cTEmbeddedWAVAudioFileAdd_element_user;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLShapeTargetElement addNewSpTgt() {
        CTTLShapeTargetElement cTTLShapeTargetElement;
        synchronized (monitor()) {
            check_orphaned();
            cTTLShapeTargetElement = (CTTLShapeTargetElement) get_store().add_element_user(SPTGT$4);
        }
        return cTTLShapeTargetElement;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLSubShapeId getInkTgt() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLSubShapeId cTTLSubShapeIdFind_element_user = get_store().find_element_user(INKTGT$6, 0);
                if (cTTLSubShapeIdFind_element_user == null) {
                    return null;
                }
                return cTTLSubShapeIdFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmpty getSldTgt() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEmpty cTEmptyFind_element_user = get_store().find_element_user(SLDTGT$0, 0);
                if (cTEmptyFind_element_user == null) {
                    return null;
                }
                return cTEmptyFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTEmbeddedWAVAudioFile getSndTgt() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileFind_element_user = get_store().find_element_user(SNDTGT$2, 0);
                if (cTEmbeddedWAVAudioFileFind_element_user == null) {
                    return null;
                }
                return cTEmbeddedWAVAudioFileFind_element_user;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public CTTLShapeTargetElement getSpTgt() {
        synchronized (monitor()) {
            try {
                check_orphaned();
                CTTLShapeTargetElement cTTLShapeTargetElement = (CTTLShapeTargetElement) get_store().find_element_user(SPTGT$4, 0);
                if (cTTLShapeTargetElement == null) {
                    return null;
                }
                return cTTLShapeTargetElement;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetInkTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(INKTGT$6) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSldTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SLDTGT$0) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSndTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SNDTGT$2) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public boolean isSetSpTgt() {
        boolean z;
        synchronized (monitor()) {
            check_orphaned();
            z = get_store().count_elements(SPTGT$4) != 0;
        }
        return z;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setInkTgt(CTTLSubShapeId cTTLSubShapeId) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = INKTGT$6;
                CTTLSubShapeId cTTLSubShapeIdFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTTLSubShapeIdFind_element_user == null) {
                    cTTLSubShapeIdFind_element_user = (CTTLSubShapeId) get_store().add_element_user(qName);
                }
                cTTLSubShapeIdFind_element_user.set(cTTLSubShapeId);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSldTgt(CTEmpty cTEmpty) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SLDTGT$0;
                CTEmpty cTEmptyFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTEmptyFind_element_user == null) {
                    cTEmptyFind_element_user = (CTEmpty) get_store().add_element_user(qName);
                }
                cTEmptyFind_element_user.set(cTEmpty);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSndTgt(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SNDTGT$2;
                CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFileFind_element_user = typeStore.find_element_user(qName, 0);
                if (cTEmbeddedWAVAudioFileFind_element_user == null) {
                    cTEmbeddedWAVAudioFileFind_element_user = (CTEmbeddedWAVAudioFile) get_store().add_element_user(qName);
                }
                cTEmbeddedWAVAudioFileFind_element_user.set(cTEmbeddedWAVAudioFile);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void setSpTgt(CTTLShapeTargetElement cTTLShapeTargetElement) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName qName = SPTGT$4;
                CTTLShapeTargetElement cTTLShapeTargetElement2 = (CTTLShapeTargetElement) typeStore.find_element_user(qName, 0);
                if (cTTLShapeTargetElement2 == null) {
                    cTTLShapeTargetElement2 = (CTTLShapeTargetElement) get_store().add_element_user(qName);
                }
                cTTLShapeTargetElement2.set(cTTLShapeTargetElement);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetInkTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(INKTGT$6, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSldTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SLDTGT$0, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSndTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SNDTGT$2, 0);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeTargetElement
    public void unsetSpTgt() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(SPTGT$4, 0);
        }
    }
}
