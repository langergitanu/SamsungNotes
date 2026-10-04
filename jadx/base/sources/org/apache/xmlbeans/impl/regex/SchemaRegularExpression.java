package org.apache.xmlbeans.impl.regex;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SchemaRegularExpression extends RegularExpression {
    static final Map knownPatterns = buildKnownPatternMap();

    private static Map buildKnownPatternMap() {
        HashMap map = new HashMap();
        map.put("\\c+", new SchemaRegularExpression("\\c+") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.1
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidNmtoken(str);
            }
        });
        map.put("\\i\\c*", new SchemaRegularExpression("\\i\\c*") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.2
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidName(str);
            }
        });
        map.put("[\\i-[:]][\\c-[:]]*", new SchemaRegularExpression("[\\i-[:]][\\c-[:]]*") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.3
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidNCName(str);
            }
        });
        return map;
    }

    public static RegularExpression forPattern(String str) {
        SchemaRegularExpression schemaRegularExpression = (SchemaRegularExpression) knownPatterns.get(str);
        return schemaRegularExpression != null ? schemaRegularExpression : new RegularExpression(str, "X");
    }

    private SchemaRegularExpression(String str) {
        super(str, "X");
    }
}
