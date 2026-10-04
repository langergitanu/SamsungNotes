package org.apache.commons.text;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import com.squareup.moshi.Json;
import java.io.IOException;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import org.apache.commons.text.translate.AggregateTranslator;
import org.apache.commons.text.translate.CharSequenceTranslator;
import org.apache.commons.text.translate.CsvTranslators;
import org.apache.commons.text.translate.EntityArrays;
import org.apache.commons.text.translate.JavaUnicodeEscaper;
import org.apache.commons.text.translate.LookupTranslator;
import org.apache.commons.text.translate.NumericEntityEscaper;
import org.apache.commons.text.translate.NumericEntityUnescaper;
import org.apache.commons.text.translate.OctalUnescaper;
import org.apache.commons.text.translate.UnicodeUnescaper;
import org.apache.commons.text.translate.UnicodeUnpairedSurrogateRemover;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_CSV;
    public static final CharSequenceTranslator ESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator ESCAPE_HTML3;
    public static final CharSequenceTranslator ESCAPE_HTML4;
    public static final CharSequenceTranslator ESCAPE_JAVA;
    public static final CharSequenceTranslator ESCAPE_JSON;
    public static final CharSequenceTranslator ESCAPE_XML10;
    public static final CharSequenceTranslator ESCAPE_XML11;
    public static final CharSequenceTranslator ESCAPE_XSI;
    public static final CharSequenceTranslator UNESCAPE_CSV;
    public static final CharSequenceTranslator UNESCAPE_ECMASCRIPT;
    public static final CharSequenceTranslator UNESCAPE_HTML3;
    public static final CharSequenceTranslator UNESCAPE_HTML4;
    public static final CharSequenceTranslator UNESCAPE_JAVA;
    public static final CharSequenceTranslator UNESCAPE_JSON;
    public static final CharSequenceTranslator UNESCAPE_XML;
    public static final CharSequenceTranslator UNESCAPE_XSI;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Builder {

        /* JADX INFO: renamed from: sb */
        private final StringBuilder f9993sb;
        private final CharSequenceTranslator translator;

        public Builder append(String str) {
            this.f9993sb.append(str);
            return this;
        }

        public Builder escape(String str) {
            this.f9993sb.append(this.translator.translate(str));
            return this;
        }

        public String toString() {
            return this.f9993sb.toString();
        }

        private Builder(CharSequenceTranslator charSequenceTranslator) {
            this.f9993sb = new StringBuilder();
            this.translator = charSequenceTranslator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class XsiUnescaper extends CharSequenceTranslator {
        private static final char BACKSLASH = '\\';

        @Override // org.apache.commons.text.translate.CharSequenceTranslator
        public int translate(CharSequence charSequence, int i, Writer writer) throws IOException {
            if (i != 0) {
                throw new IllegalStateException("XsiUnescaper should never reach the [1] index");
            }
            String string = charSequence.toString();
            int i2 = 0;
            int i4 = 0;
            while (true) {
                int iIndexOf = string.indexOf(92, i2);
                if (iIndexOf == -1) {
                    break;
                }
                if (iIndexOf > i4) {
                    writer.write(string.substring(i4, iIndexOf));
                }
                i4 = iIndexOf + 1;
                i2 = iIndexOf + 2;
            }
            if (i4 < string.length()) {
                writer.write(string.substring(i4));
            }
            return Character.codePointCount(charSequence, 0, charSequence.length());
        }
    }

    static {
        LookupTranslator lookupTranslator = new LookupTranslator(Collections.unmodifiableMap(AbstractC12991c.m13996q("\"", "\\\"", "\\", "\\\\")));
        Map<CharSequence, CharSequence> map = EntityArrays.JAVA_CTRL_CHARS_ESCAPE;
        ESCAPE_JAVA = new AggregateTranslator(lookupTranslator, new LookupTranslator(map), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap mapM13996q = AbstractC12991c.m13996q("'", "\\'", "\"", "\\\"");
        mapM13996q.put("\\", "\\\\");
        mapM13996q.put("/", "\\/");
        ESCAPE_ECMASCRIPT = new AggregateTranslator(new LookupTranslator(Collections.unmodifiableMap(mapM13996q)), new LookupTranslator(map), JavaUnicodeEscaper.outsideOf(32, 127));
        HashMap mapM13996q2 = AbstractC12991c.m13996q("\"", "\\\"", "\\", "\\\\");
        mapM13996q2.put("/", "\\/");
        ESCAPE_JSON = new AggregateTranslator(new LookupTranslator(Collections.unmodifiableMap(mapM13996q2)), new LookupTranslator(map), JavaUnicodeEscaper.outsideOf(32, 126));
        HashMap mapM13996q3 = AbstractC12991c.m13996q(Json.UNSET_NAME, "", "\u0001", "");
        mapM13996q3.put("\u0002", "");
        mapM13996q3.put("\u0003", "");
        mapM13996q3.put("\u0004", "");
        mapM13996q3.put("\u0005", "");
        mapM13996q3.put("\u0006", "");
        mapM13996q3.put("\u0007", "");
        mapM13996q3.put("\b", "");
        mapM13996q3.put("\u000b", "");
        mapM13996q3.put("\f", "");
        mapM13996q3.put(Utils.LOG_DELIMITER, "");
        mapM13996q3.put("\u000f", "");
        mapM13996q3.put("\u0010", "");
        mapM13996q3.put("\u0011", "");
        mapM13996q3.put("\u0012", "");
        mapM13996q3.put("\u0013", "");
        mapM13996q3.put("\u0014", "");
        mapM13996q3.put("\u0015", "");
        mapM13996q3.put("\u0016", "");
        mapM13996q3.put("\u0017", "");
        mapM13996q3.put("\u0018", "");
        mapM13996q3.put("\u0019", "");
        mapM13996q3.put("\u001a", "");
        mapM13996q3.put("\u001b", "");
        mapM13996q3.put("\u001c", "");
        mapM13996q3.put("\u001d", "");
        mapM13996q3.put("\u001e", "");
        mapM13996q3.put(UnicodeUtils.UNIT_SEPARATOR, "");
        mapM13996q3.put("\ufffe", "");
        mapM13996q3.put("\uffff", "");
        Map<CharSequence, CharSequence> map2 = EntityArrays.BASIC_ESCAPE;
        LookupTranslator lookupTranslator2 = new LookupTranslator(map2);
        Map<CharSequence, CharSequence> map3 = EntityArrays.APOS_ESCAPE;
        ESCAPE_XML10 = new AggregateTranslator(lookupTranslator2, new LookupTranslator(map3), new LookupTranslator(Collections.unmodifiableMap(mapM13996q3)), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        HashMap mapM13996q4 = AbstractC12991c.m13996q(Json.UNSET_NAME, "", "\u000b", "&#11;");
        mapM13996q4.put("\f", "&#12;");
        mapM13996q4.put("\ufffe", "");
        mapM13996q4.put("\uffff", "");
        ESCAPE_XML11 = new AggregateTranslator(new LookupTranslator(map2), new LookupTranslator(map3), new LookupTranslator(Collections.unmodifiableMap(mapM13996q4)), NumericEntityEscaper.between(1, 8), NumericEntityEscaper.between(14, 31), NumericEntityEscaper.between(127, 132), NumericEntityEscaper.between(134, 159), new UnicodeUnpairedSurrogateRemover());
        LookupTranslator lookupTranslator3 = new LookupTranslator(map2);
        Map<CharSequence, CharSequence> map4 = EntityArrays.ISO8859_1_ESCAPE;
        ESCAPE_HTML3 = new AggregateTranslator(lookupTranslator3, new LookupTranslator(map4));
        ESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(map2), new LookupTranslator(map4), new LookupTranslator(EntityArrays.HTML40_EXTENDED_ESCAPE));
        ESCAPE_CSV = new CsvTranslators.CsvEscaper();
        HashMap mapM13996q5 = AbstractC12991c.m13996q("|", "\\|", MsalUtils.QUERY_STRING_DELIMITER, "\\&");
        mapM13996q5.put(";", "\\;");
        mapM13996q5.put("<", "\\<");
        mapM13996q5.put(">", "\\>");
        mapM13996q5.put("(", "\\(");
        mapM13996q5.put(")", "\\)");
        mapM13996q5.put("$", "\\$");
        mapM13996q5.put("`", "\\`");
        mapM13996q5.put("\\", "\\\\");
        mapM13996q5.put("\"", "\\\"");
        mapM13996q5.put("'", "\\'");
        mapM13996q5.put(" ", "\\ ");
        mapM13996q5.put("\t", "\\\t");
        mapM13996q5.put("\r\n", "");
        mapM13996q5.put("\n", "");
        mapM13996q5.put("*", "\\*");
        mapM13996q5.put(MsalUtils.QUERY_STRING_SYMBOL, "\\?");
        mapM13996q5.put("[", "\\[");
        mapM13996q5.put(ContentUtils.HASH_SYMBOL, "\\#");
        mapM13996q5.put("~", "\\~");
        mapM13996q5.put(MarketingConstants.REFERRER_DELIMITER_U003D, "\\=");
        mapM13996q5.put("%", "\\%");
        ESCAPE_XSI = new LookupTranslator(Collections.unmodifiableMap(mapM13996q5));
        HashMap mapM13996q6 = AbstractC12991c.m13996q("\\\\", "\\", "\\\"", "\"");
        mapM13996q6.put("\\'", "'");
        mapM13996q6.put("\\", "");
        AggregateTranslator aggregateTranslator = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE), new LookupTranslator(Collections.unmodifiableMap(mapM13996q6)));
        UNESCAPE_JAVA = aggregateTranslator;
        UNESCAPE_ECMASCRIPT = aggregateTranslator;
        UNESCAPE_JSON = aggregateTranslator;
        Map<CharSequence, CharSequence> map5 = EntityArrays.BASIC_UNESCAPE;
        LookupTranslator lookupTranslator4 = new LookupTranslator(map5);
        Map<CharSequence, CharSequence> map6 = EntityArrays.ISO8859_1_UNESCAPE;
        UNESCAPE_HTML3 = new AggregateTranslator(lookupTranslator4, new LookupTranslator(map6), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_HTML4 = new AggregateTranslator(new LookupTranslator(map5), new LookupTranslator(map6), new LookupTranslator(EntityArrays.HTML40_EXTENDED_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_XML = new AggregateTranslator(new LookupTranslator(map5), new LookupTranslator(EntityArrays.APOS_UNESCAPE), new NumericEntityUnescaper(new NumericEntityUnescaper.OPTION[0]));
        UNESCAPE_CSV = new CsvTranslators.CsvUnescaper();
        UNESCAPE_XSI = new XsiUnescaper();
    }

    public static Builder builder(CharSequenceTranslator charSequenceTranslator) {
        return new Builder(charSequenceTranslator);
    }

    public static String escapeCsv(String str) {
        return ESCAPE_CSV.translate(str);
    }

    public static String escapeEcmaScript(String str) {
        return ESCAPE_ECMASCRIPT.translate(str);
    }

    public static String escapeHtml3(String str) {
        return ESCAPE_HTML3.translate(str);
    }

    public static String escapeHtml4(String str) {
        return ESCAPE_HTML4.translate(str);
    }

    public static String escapeJava(String str) {
        return ESCAPE_JAVA.translate(str);
    }

    public static String escapeJson(String str) {
        return ESCAPE_JSON.translate(str);
    }

    public static String escapeXSI(String str) {
        return ESCAPE_XSI.translate(str);
    }

    public static String escapeXml10(String str) {
        return ESCAPE_XML10.translate(str);
    }

    public static String escapeXml11(String str) {
        return ESCAPE_XML11.translate(str);
    }

    public static String unescapeCsv(String str) {
        return UNESCAPE_CSV.translate(str);
    }

    public static String unescapeEcmaScript(String str) {
        return UNESCAPE_ECMASCRIPT.translate(str);
    }

    public static String unescapeHtml3(String str) {
        return UNESCAPE_HTML3.translate(str);
    }

    public static String unescapeHtml4(String str) {
        return UNESCAPE_HTML4.translate(str);
    }

    public static String unescapeJava(String str) {
        return UNESCAPE_JAVA.translate(str);
    }

    public static String unescapeJson(String str) {
        return UNESCAPE_JSON.translate(str);
    }

    public static String unescapeXSI(String str) {
        return UNESCAPE_XSI.translate(str);
    }

    public static String unescapeXml(String str) {
        return UNESCAPE_XML.translate(str);
    }
}
