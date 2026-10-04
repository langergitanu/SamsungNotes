package org.apache.xmlbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringEnumAbstractBase implements Serializable {
    private static final long serialVersionUID = 1;
    private int _int;
    private String _string;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Table {
        private List _list;
        private Map _map;

        public Table(StringEnumAbstractBase[] stringEnumAbstractBaseArr) {
            this._map = new HashMap(stringEnumAbstractBaseArr.length);
            this._list = new ArrayList(stringEnumAbstractBaseArr.length + 1);
            for (int i = 0; i < stringEnumAbstractBaseArr.length; i++) {
                this._map.put(stringEnumAbstractBaseArr[i].toString(), stringEnumAbstractBaseArr[i]);
                int iIntValue = stringEnumAbstractBaseArr[i].intValue();
                while (this._list.size() <= iIntValue) {
                    this._list.add(null);
                }
                this._list.set(iIntValue, stringEnumAbstractBaseArr[i]);
            }
        }

        public StringEnumAbstractBase forInt(int i) {
            if (i < 0 || i > this._list.size()) {
                return null;
            }
            return (StringEnumAbstractBase) this._list.get(i);
        }

        public StringEnumAbstractBase forString(String str) {
            return (StringEnumAbstractBase) this._map.get(str);
        }

        public int lastInt() {
            return this._list.size() - 1;
        }
    }

    public StringEnumAbstractBase(String str, int i) {
        this._string = str;
        this._int = i;
    }

    public final int hashCode() {
        return this._string.hashCode();
    }

    public final int intValue() {
        return this._int;
    }

    public final String toString() {
        return this._string;
    }
}
