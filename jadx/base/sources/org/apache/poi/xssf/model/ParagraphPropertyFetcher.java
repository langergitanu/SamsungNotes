package org.apache.poi.xssf.model;

import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraphProperties;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public abstract class ParagraphPropertyFetcher<T> {
    private int _level;
    private T _value;

    public ParagraphPropertyFetcher(int i) {
        this._level = i;
    }

    public abstract boolean fetch(CTTextParagraphProperties cTTextParagraphProperties);

    public boolean fetch(CTShape cTShape) {
        XmlObject[] xmlObjectArrSelectPath = cTShape.selectPath("declare namespace xdr='http://schemas.openxmlformats.org/drawingml/2006/spreadsheetDrawing' declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' .//xdr:txBody/a:lstStyle/a:lvl" + (this._level + 1) + "pPr");
        if (xmlObjectArrSelectPath.length == 1) {
            return fetch((CTTextParagraphProperties) xmlObjectArrSelectPath[0]);
        }
        return false;
    }

    public T getValue() {
        return this._value;
    }

    public void setValue(T t) {
        this._value = t;
    }
}
