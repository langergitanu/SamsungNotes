package org.apache.xmlbeans;

import java.util.HashMap;
import kotlin.text.Typography;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XmlOptionCharEscapeMap {
    public static final int DECIMAL = 1;
    public static final int HEXADECIMAL = 2;
    public static final int PREDEF_ENTITY = 0;
    private static final HashMap _predefEntities;
    private HashMap _charMap = new HashMap();

    static {
        HashMap map = new HashMap();
        _predefEntities = map;
        map.put(new Character(Typography.less), "&lt;");
        map.put(new Character('>'), "&gt;");
        map.put(new Character(Typography.amp), "&amp;");
        map.put(new Character('\''), "&apos;");
        map.put(new Character('\"'), "&quot;");
    }

    public void addMapping(char c, int i) throws XmlException {
        Character ch = new Character(c);
        if (i == 0) {
            String str = (String) _predefEntities.get(ch);
            if (str == null) {
                throw new XmlException("XmlOptionCharEscapeMap.addMapping(): the PREDEF_ENTITY mode can only be used for the following characters: <, >, &, \" and '");
            }
            this._charMap.put(ch, str);
            return;
        }
        if (i == 1) {
            HashMap map = this._charMap;
            StringBuffer stringBuffer = new StringBuffer("&#");
            stringBuffer.append((int) c);
            stringBuffer.append(";");
            map.put(ch, stringBuffer.toString());
            return;
        }
        if (i != 2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMapping(): mode must be PREDEF_ENTITY, DECIMAL or HEXADECIMAL");
        }
        String hexString = Integer.toHexString(c);
        HashMap map2 = this._charMap;
        StringBuffer stringBuffer2 = new StringBuffer("&#x");
        stringBuffer2.append(hexString);
        stringBuffer2.append(";");
        map2.put(ch, stringBuffer2.toString());
    }

    public void addMappings(char c, char c2, int i) throws XmlException {
        if (c > c2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMappings(): ch1 must be <= ch2");
        }
        while (c <= c2) {
            addMapping(c, i);
            c = (char) (c + 1);
        }
    }

    public boolean containsChar(char c) {
        return this._charMap.containsKey(new Character(c));
    }

    public String getEscapedString(char c) {
        return (String) this._charMap.get(new Character(c));
    }
}
