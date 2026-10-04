package com.samsung.android.support.senl.p148nt.composer.main.base.external.scrapbook.decoder;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StringEscapeUtils {
    public static final CharSequenceTranslator ESCAPE_JAVA = new LookupTranslator(new String[]{"\"", "\\\""}, new String[]{"\\", "\\\\"}).with(new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())).with(UnicodeEscaper.outsideOf(32, 127));
    public static final CharSequenceTranslator UNESCAPE_JAVA = new AggregateTranslator(new OctalUnescaper(), new UnicodeUnescaper(), new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_UNESCAPE()), new LookupTranslator(new String[]{"\\\\", "\\"}, new String[]{"\\\"", "\""}, new String[]{"\\'", "'"}, new String[]{"\\", ""}));
    public static final CharSequenceTranslator ESCAPE_URL = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_ESCAPE()));
    public static final CharSequenceTranslator UNESCAPE_URL = new AggregateTranslator(new LookupTranslator(EntityArrays.BASIC_UNESCAPE()));

    public static final String escapeJava(String str) {
        return ESCAPE_JAVA.translate(str);
    }

    public static final String escapeUrl(String str) {
        return ESCAPE_URL.translate(str);
    }

    public static final String unescapeJava(String str) {
        return UNESCAPE_JAVA.translate(str);
    }

    public static final String unescapeUrl(String str) {
        return UNESCAPE_URL.translate(str);
    }
}
