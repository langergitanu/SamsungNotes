package org.apache.xmlbeans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlException extends Exception {
    private static final long serialVersionUID = 1;
    private List _errors;

    public XmlException(String str) {
        super(str);
    }

    public XmlError getError() {
        List list = this._errors;
        if (list == null || list.size() == 0) {
            return null;
        }
        return (XmlError) this._errors.get(0);
    }

    public Collection getErrors() {
        return this._errors;
    }

    public XmlException(String str, Throwable th) {
        super(str, th);
    }

    public XmlException(Throwable th) {
        super(th);
    }

    public XmlException(XmlError xmlError) {
        this(xmlError.toString(), (Throwable) null, xmlError);
    }

    public XmlException(String str, Throwable th, XmlError xmlError) {
        this(str, th, Collections.singletonList(xmlError));
    }

    public XmlException(String str, Throwable th, Collection collection) {
        super(str, th);
        if (collection != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(collection));
        }
    }

    public XmlException(XmlRuntimeException xmlRuntimeException) {
        super(xmlRuntimeException.getMessage(), xmlRuntimeException.getCause());
        Collection errors = xmlRuntimeException.getErrors();
        if (errors != null) {
            this._errors = Collections.unmodifiableList(new ArrayList(errors));
        }
    }
}
