package org.apache.poi.xslf.model;

import org.apache.poi.util.Internal;
import org.apache.poi.xslf.usermodel.XSLFShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public abstract class PropertyFetcher<T> {
    private T _value;

    public abstract boolean fetch(XSLFShape xSLFShape);

    public T getValue() {
        return this._value;
    }

    public void setValue(T t) {
        this._value = t;
    }
}
