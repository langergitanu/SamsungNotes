package org.apache.xmlbeans;

import org.apache.xmlbeans.XmlCursor;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlLineNumber extends XmlCursor.XmlBookmark {
    private int _column;
    private int _line;
    private int _offset;

    public XmlLineNumber(int i) {
        this(i, -1, -1);
    }

    public int getColumn() {
        return this._column;
    }

    public int getLine() {
        return this._line;
    }

    public int getOffset() {
        return this._offset;
    }

    public XmlLineNumber(int i, int i2) {
        this(i, i2, -1);
    }

    public XmlLineNumber(int i, int i2, int i4) {
        super(false);
        this._line = i;
        this._column = i2;
        this._offset = i4;
    }
}
