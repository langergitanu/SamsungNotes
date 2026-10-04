package org.jsoup.nodes;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.CharsetEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;
import kotlin.text.Typography;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Entities {
    private static final Map<String, Character> base;
    private static final Map<Character, String> baseByVal;
    private static final Map<String, Character> full;
    private static final Map<Character, String> fullByVal;
    private static final Object[][] xhtmlArray;
    private static final Map<Character, String> xhtmlByVal = new HashMap();

    /* JADX INFO: renamed from: org.jsoup.nodes.Entities$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C142581 {
        static final /* synthetic */ int[] $SwitchMap$org$jsoup$nodes$Entities$CoreCharset;

        static {
            int[] iArr = new int[CoreCharset.values().length];
            $SwitchMap$org$jsoup$nodes$Entities$CoreCharset = iArr;
            try {
                iArr[CoreCharset.ascii.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$jsoup$nodes$Entities$CoreCharset[CoreCharset.utf.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum CoreCharset {
        ascii,
        utf,
        fallback;

        /* JADX INFO: Access modifiers changed from: private */
        public static CoreCharset byName(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum EscapeMode {
        xhtml(Entities.xhtmlByVal),
        base(Entities.baseByVal),
        extended(Entities.fullByVal);

        private Map<Character, String> map;

        EscapeMode(Map map) {
            this.map = map;
        }

        public Map<Character, String> getMap() {
            return this.map;
        }
    }

    static {
        Object[][] objArr = {new Object[]{"quot", 34}, new Object[]{"amp", 38}, new Object[]{"lt", 60}, new Object[]{"gt", 62}};
        xhtmlArray = objArr;
        Map<String, Character> mapLoadEntities = loadEntities("entities-base.properties");
        base = mapLoadEntities;
        baseByVal = toCharacterKey(mapLoadEntities);
        Map<String, Character> mapLoadEntities2 = loadEntities("entities-full.properties");
        full = mapLoadEntities2;
        fullByVal = toCharacterKey(mapLoadEntities2);
        for (Object[] objArr2 : objArr) {
            xhtmlByVal.put(Character.valueOf((char) ((Integer) objArr2[1]).intValue()), (String) objArr2[0]);
        }
    }

    private Entities() {
    }

    private static boolean canEncode(CoreCharset coreCharset, char c, CharsetEncoder charsetEncoder) {
        int i = C142581.$SwitchMap$org$jsoup$nodes$Entities$CoreCharset[coreCharset.ordinal()];
        if (i == 1) {
            return c < 128;
        }
        if (i != 2) {
            return charsetEncoder.canEncode(c);
        }
        return true;
    }

    public static String escape(String str, Document.OutputSettings outputSettings) {
        StringBuilder sb = new StringBuilder(str.length() * 2);
        escape(sb, str, outputSettings, false, false, false);
        return sb.toString();
    }

    public static Character getCharacterByName(String str) {
        return full.get(str);
    }

    public static boolean isBaseNamedEntity(String str) {
        return base.containsKey(str);
    }

    public static boolean isNamedEntity(String str) {
        return full.containsKey(str);
    }

    private static Map<String, Character> loadEntities(String str) {
        Properties properties = new Properties();
        HashMap map = new HashMap();
        try {
            InputStream resourceAsStream = Entities.class.getResourceAsStream(str);
            properties.load(resourceAsStream);
            resourceAsStream.close();
            for (Map.Entry entry : properties.entrySet()) {
                map.put((String) entry.getKey(), Character.valueOf((char) Integer.parseInt((String) entry.getValue(), 16)));
            }
            return map;
        } catch (IOException e) {
            throw new MissingResourceException("Error loading entities resource: " + e.getMessage(), "Entities", str);
        }
    }

    private static Map<Character, String> toCharacterKey(Map<String, Character> map) {
        HashMap map2 = new HashMap();
        for (Map.Entry<String, Character> entry : map.entrySet()) {
            Character value = entry.getValue();
            String key = entry.getKey();
            if (!map2.containsKey(value)) {
                map2.put(value, key);
            } else if (key.toLowerCase().equals(key)) {
                map2.put(value, key);
            }
        }
        return map2;
    }

    public static String unescape(String str) {
        return unescape(str, false);
    }

    public static String unescape(String str, boolean z) {
        return Parser.unescapeEntities(str, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void escape(StringBuilder sb, String str, Document.OutputSettings outputSettings, boolean z, boolean z2, boolean z3) {
        EscapeMode escapeMode = outputSettings.escapeMode();
        CharsetEncoder charsetEncoderEncoder = outputSettings.encoder();
        CoreCharset coreCharsetByName = CoreCharset.byName(charsetEncoderEncoder.charset().name());
        Map<Character, String> map = escapeMode.getMap();
        int length = str.length();
        int iCharCount = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (z2) {
                if (!StringUtil.isWhitespace(iCodePointAt)) {
                    z4 = true;
                    z5 = false;
                    if (iCodePointAt >= 65536) {
                    }
                } else if ((!z3 || z4) && !z5) {
                    sb.append(' ');
                    z5 = true;
                }
            } else if (iCodePointAt >= 65536) {
                char c = (char) iCodePointAt;
                if (c != '\"') {
                    if (c == '&') {
                        sb.append("&amp;");
                    } else if (c != '<') {
                        if (c != '>') {
                            if (c != 160) {
                                if (canEncode(coreCharsetByName, c, charsetEncoderEncoder)) {
                                    sb.append(c);
                                } else if (map.containsKey(Character.valueOf(c))) {
                                    sb.append(Typography.amp);
                                    sb.append(map.get(Character.valueOf(c)));
                                    sb.append(SQLKeyword.DELIMITER);
                                } else {
                                    sb.append("&#x");
                                    sb.append(Integer.toHexString(iCodePointAt));
                                    sb.append(SQLKeyword.DELIMITER);
                                }
                            } else if (escapeMode != EscapeMode.xhtml) {
                                sb.append("&nbsp;");
                            } else {
                                sb.append("&#xa0;");
                            }
                        } else if (!z) {
                            sb.append("&gt;");
                        } else {
                            sb.append(c);
                        }
                    } else if (z && escapeMode != EscapeMode.xhtml) {
                        sb.append(c);
                    } else {
                        sb.append("&lt;");
                    }
                } else if (z) {
                    sb.append("&quot;");
                } else {
                    sb.append(c);
                }
            } else {
                String str2 = new String(Character.toChars(iCodePointAt));
                if (charsetEncoderEncoder.canEncode(str2)) {
                    sb.append(str2);
                } else {
                    sb.append("&#x");
                    sb.append(Integer.toHexString(iCodePointAt));
                    sb.append(SQLKeyword.DELIMITER);
                }
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }
}
