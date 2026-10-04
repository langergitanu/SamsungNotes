package com.fasterxml.jackson.core;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.io.Serializable;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class JsonLocation implements Serializable {

    /* JADX INFO: renamed from: NA */
    public static final JsonLocation f1994NA = new JsonLocation("N/A", -1, -1, -1, -1);
    private static final long serialVersionUID = 1;
    final int _columnNr;
    final int _lineNr;
    final Object _sourceRef;
    final long _totalBytes;
    final long _totalChars;

    public JsonLocation(Object obj, long j, int i, int i2) {
        this(obj, -1L, j, i, i2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonLocation)) {
            return false;
        }
        JsonLocation jsonLocation = (JsonLocation) obj;
        Object obj2 = this._sourceRef;
        if (obj2 == null) {
            if (jsonLocation._sourceRef != null) {
                return false;
            }
        } else if (!obj2.equals(jsonLocation._sourceRef)) {
            return false;
        }
        return this._lineNr == jsonLocation._lineNr && this._columnNr == jsonLocation._columnNr && this._totalChars == jsonLocation._totalChars && getByteOffset() == jsonLocation.getByteOffset();
    }

    public long getByteOffset() {
        return this._totalBytes;
    }

    public long getCharOffset() {
        return this._totalChars;
    }

    public int getColumnNr() {
        return this._columnNr;
    }

    public int getLineNr() {
        return this._lineNr;
    }

    public Object getSourceRef() {
        return this._sourceRef;
    }

    public int hashCode() {
        Object obj = this._sourceRef;
        return ((((obj == null ? 1 : obj.hashCode()) ^ this._lineNr) + this._columnNr) ^ ((int) this._totalChars)) + ((int) this._totalBytes);
    }

    public String toString() {
        StringBuilder sbM1627q = AbstractC2322a.m1627q(80, "[Source: ");
        Object obj = this._sourceRef;
        if (obj == null) {
            sbM1627q.append("UNKNOWN");
        } else {
            sbM1627q.append(obj.toString());
        }
        sbM1627q.append("; line: ");
        sbM1627q.append(this._lineNr);
        sbM1627q.append(", column: ");
        return AbstractC0000a.m13j(sbM1627q, this._columnNr, PropertyUtils.INDEXED_DELIM2);
    }

    public JsonLocation(Object obj, long j, long j2, int i, int i2) {
        this._sourceRef = obj;
        this._totalBytes = j;
        this._totalChars = j2;
        this._lineNr = i;
        this._columnNr = i2;
    }
}
