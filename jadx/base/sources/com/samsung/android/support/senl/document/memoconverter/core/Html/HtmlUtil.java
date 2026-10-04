package com.samsung.android.support.senl.document.memoconverter.core.Html;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.CharacterStyle;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import org.ccil.cowan.tagsoup.HTMLSchema;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class HtmlUtil {
    private static final String TAG = "HtmlUtil";
    private static boolean isImageSpan = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HtmlParser {
        private static final HTMLSchema schema = new HTMLSchema();

        private HtmlParser() {
        }
    }

    private HtmlUtil() {
        DocumentLogger.m7178d(TAG, TAG);
    }

    public static String filterHtml(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("<", "&lt;").replace(">", "&gt;");
    }

    public static Spanned fromHtml(Context context, String str) {
        Parser parser = new Parser();
        try {
            parser.setProperty(Parser.schemaProperty, HtmlParser.schema);
            Spanned spannedConvert = new HtmlToSpannedConverter(context, parser, str).convert();
            HtmlToSpannedConverter.releaseObject();
            return spannedConvert;
        } catch (SAXNotRecognizedException e) {
            throw new RuntimeException(e);
        } catch (SAXNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void processHtmlImage(StringBuilder sb, Spanned spanned, int i, int i2) {
        while (i < i2) {
            int iNextSpanTransition = spanned.nextSpanTransition(i, i2, SpannableString.class);
            for (SpannableString spannableString : (SpannableString[]) spanned.getSpans(i, iNextSpanTransition, SpannableString.class)) {
                sb.append(spannableString.toString());
            }
            withinStyle(sb, spanned.toString(), i, iNextSpanTransition);
            i = iNextSpanTransition;
        }
    }

    public static String toHtml(Spanned spanned) {
        StringBuilder sb = new StringBuilder();
        withinHtml(sb, spanned);
        return sb.toString().replace(UnicodeUtils.OBJECT_REPLACEMENT, "").replace("<p> ", "<p>&nbsp;");
    }

    private static void withinBlockquote(StringBuilder sb, Spanned spanned, int i, int i2) {
        while (i < i2) {
            int iIndexOf = TextUtils.indexOf((CharSequence) spanned, '\n', i, i2);
            if (iIndexOf < 0) {
                iIndexOf = i2;
            }
            int i4 = 0;
            while (iIndexOf < i2 && spanned.charAt(iIndexOf) == '\n') {
                i4++;
                iIndexOf++;
            }
            withinParagraph(sb, spanned, i, iIndexOf - i4, i4);
            i = iIndexOf;
        }
    }

    private static void withinDiv(StringBuilder sb, Spanned spanned, int i, int i2) {
        while (i < i2) {
            int iNextSpanTransition = spanned.nextSpanTransition(i, i2, QuoteSpan.class);
            withinBlockquote(sb, spanned, i, iNextSpanTransition);
            i = iNextSpanTransition;
        }
    }

    private static void withinHtml(StringBuilder sb, Spanned spanned) {
        if (spanned.toString().isEmpty()) {
            return;
        }
        int length = spanned.length();
        sb.append("<p>");
        int i = 0;
        while (i < spanned.length()) {
            int iNextSpanTransition = spanned.nextSpanTransition(i, length, ParagraphStyle.class);
            withinDiv(sb, spanned, i, iNextSpanTransition);
            i = iNextSpanTransition;
        }
        sb.append("</p>");
    }

    private static void withinParagraph(StringBuilder sb, Spanned spanned, int i, int i2, int i4) {
        int i5;
        while (true) {
            if (i >= i2) {
                break;
            }
            int iNextSpanTransition = spanned.nextSpanTransition(i, i2, CharacterStyle.class);
            for (CharacterStyle characterStyle : (CharacterStyle[]) spanned.getSpans(i, iNextSpanTransition, CharacterStyle.class)) {
                if (characterStyle instanceof HtmlImageSpan) {
                    sb.append(((HtmlImageSpan) characterStyle).toHtml());
                    isImageSpan = true;
                }
            }
            if (!isImageSpan) {
                processHtmlImage(sb, spanned, i, iNextSpanTransition);
            }
            isImageSpan = false;
            i = iNextSpanTransition;
        }
        for (i5 = 0; i5 < i4; i5++) {
            sb.append("</p>\n<p>");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void withinStyle(StringBuilder sb, String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ') {
                while (true) {
                    int i4 = i + 1;
                    if (i4 >= i2 || !(str.charAt(i4) == ' ' || str.charAt(i4) == 160)) {
                        break;
                    }
                    sb.append("&nbsp;");
                    i = i4;
                }
                sb.append(' ');
            } else if (cCharAt == '\"') {
                sb.append("&quot;");
            } else if (cCharAt == '<') {
                sb.append("&lt;");
            } else if (cCharAt == '>') {
                sb.append("&gt;");
            } else if (cCharAt != 160) {
                if (cCharAt == '&') {
                    sb.append("&amp;");
                } else if (cCharAt != '\'') {
                    sb.append(cCharAt);
                } else {
                    sb.append("&apos;");
                }
            }
            i++;
        }
    }
}
