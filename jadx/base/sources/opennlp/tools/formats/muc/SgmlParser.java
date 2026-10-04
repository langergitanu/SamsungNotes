package opennlp.tools.formats.muc;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SgmlParser {
    private static String extractTagName(CharSequence charSequence) throws InvalidFormatException {
        int i = (charSequence.length() <= 1 || charSequence.charAt(1) != '/') ? 1 : 2;
        for (int i2 = 1; i2 < charSequence.length(); i2++) {
            if (charSequence.charAt(i2) == '>' || StringUtil.isWhitespace(charSequence.charAt(i2))) {
                return charSequence.subSequence(i, i2).toString();
            }
        }
        throw new InvalidFormatException("Failed to extract tag name!");
    }

    private static Map<String, String> getAttributes(CharSequence charSequence) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < charSequence.length(); i++) {
            if (StringUtil.isWhitespace(charSequence.charAt(i)) && !z) {
                z2 = true;
            } else if (z2 && ('=' == charSequence.charAt(i) || StringUtil.isWhitespace(charSequence.charAt(i)))) {
                z2 = false;
            } else if (z2) {
                sb.append(charSequence.charAt(i));
            } else if ('\"' == charSequence.charAt(i)) {
                if (z) {
                    map.put(sb.toString(), sb2.toString());
                    sb.setLength(0);
                    sb2.setLength(0);
                }
                z = !z;
            } else if (z) {
                sb2.append(charSequence.charAt(i));
            }
        }
        return map;
    }

    public void parse(Reader reader, ContentHandler contentHandler) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        boolean z2 = true;
        int i = -1;
        while (true) {
            int i2 = reader.read();
            if (i2 == -1) {
                if (z) {
                    throw new InvalidFormatException("Did not find matching > char!");
                }
                return;
            }
            if (60 == i2) {
                if (z) {
                    throw new InvalidFormatException("Did not expect < char!");
                }
                if (sb.toString().trim().length() > 0) {
                    contentHandler.characters(sb.toString().trim());
                }
                sb.setLength(0);
                z = true;
                z2 = true;
            }
            sb.appendCodePoint(i2);
            if (47 == i2 && i == 60) {
                z2 = false;
            }
            if (62 == i2) {
                if (!z) {
                    throw new InvalidFormatException("Did not expect > char!");
                }
                if (z2) {
                    contentHandler.startElement(extractTagName(sb), getAttributes(sb));
                } else {
                    contentHandler.endElement(extractTagName(sb));
                }
                sb.setLength(0);
                z = false;
            }
            i = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ContentHandler {
        public void characters(CharSequence charSequence) {
        }

        public void endElement(String str) {
        }

        public void startElement(String str, Map<String, String> map) {
        }
    }
}
