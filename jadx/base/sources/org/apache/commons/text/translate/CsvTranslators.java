package org.apache.commons.text.translate;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.Writer;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CsvTranslators {
    private static final char CSV_DELIMITER = ',';
    private static final String CSV_ESCAPED_QUOTE_STR;
    private static final char CSV_QUOTE = '\"';
    private static final String CSV_QUOTE_STR;
    private static final char[] CSV_SEARCH_CHARS;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CsvEscaper extends SinglePassTranslator {
        @Override // org.apache.commons.text.translate.SinglePassTranslator, org.apache.commons.text.translate.CharSequenceTranslator
        public /* bridge */ /* synthetic */ int translate(CharSequence charSequence, int i, Writer writer) {
            return super.translate(charSequence, i, writer);
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator
        public void translateWhole(CharSequence charSequence, Writer writer) throws IOException {
            String string = charSequence.toString();
            if (StringUtils.containsNone(string, CsvTranslators.CSV_SEARCH_CHARS)) {
                writer.write(string);
                return;
            }
            writer.write(34);
            writer.write(StringUtils.replace(string, CsvTranslators.CSV_QUOTE_STR, CsvTranslators.CSV_ESCAPED_QUOTE_STR));
            writer.write(34);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CsvUnescaper extends SinglePassTranslator {
        @Override // org.apache.commons.text.translate.SinglePassTranslator, org.apache.commons.text.translate.CharSequenceTranslator
        public /* bridge */ /* synthetic */ int translate(CharSequence charSequence, int i, Writer writer) {
            return super.translate(charSequence, i, writer);
        }

        @Override // org.apache.commons.text.translate.SinglePassTranslator
        public void translateWhole(CharSequence charSequence, Writer writer) throws IOException {
            if (charSequence.charAt(0) != '\"' || charSequence.charAt(charSequence.length() - 1) != '\"') {
                writer.write(charSequence.toString());
                return;
            }
            String string = charSequence.subSequence(1, charSequence.length() - 1).toString();
            if (StringUtils.containsAny(string, CsvTranslators.CSV_SEARCH_CHARS)) {
                writer.write(StringUtils.replace(string, CsvTranslators.CSV_ESCAPED_QUOTE_STR, CsvTranslators.CSV_QUOTE_STR));
            } else {
                writer.write(string);
            }
        }
    }

    static {
        String strValueOf = String.valueOf('\"');
        CSV_QUOTE_STR = strValueOf;
        CSV_ESCAPED_QUOTE_STR = AbstractC0541b.m756B(strValueOf, strValueOf);
        CSV_SEARCH_CHARS = new char[]{',', '\"', '\r', '\n'};
    }

    private CsvTranslators() {
    }
}
