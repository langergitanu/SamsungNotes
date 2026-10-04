package com.vladsch.flexmark.util.sequence;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Utils;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Escaping {

    @NotNull
    public static final CharPredicate AMP_BACKSLASH_SET;
    private static final Pattern AMP_ONLY;
    private static final Pattern BACKSLASH_ONLY;
    private static final Pattern BACKSLASH_OR_AMP;
    private static final Pattern COLLAPSE_WHITESPACE;
    private static final Replacer COLLAPSE_WHITESPACE_REPLACER;
    private static final String ENTITY = "&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});";
    private static final Pattern ENTITY_ONLY;
    private static final Pattern ENTITY_OR_ESCAPED_CHAR;
    private static final Replacer ENTITY_REPLACER;
    public static final String ESCAPABLE;
    public static final String ESCAPABLE_CHARS = "\"#$%&'()*+,./:;<=>?@[]\\^_`{|}~-";
    private static final Pattern ESCAPED_CHAR;
    private static final Pattern ESCAPE_IN_URI;
    private static final Pattern ESCAPE_URI_DECODE;
    static final char[] HEX_DIGITS;
    private static final Replacer REMOVE_REPLACER;
    private static final Replacer UNESCAPE_REPLACER;
    private static final Replacer UNSAFE_CHAR_REPLACER;
    private static final Replacer URL_DECODE_REPLACER;
    private static final Replacer URL_ENCODE_REPLACER;
    private static final Pattern WHITESPACE;
    private static final String XML_SPECIAL = "[&<>\"]";
    private static final Pattern XML_SPECIAL_OR_ENTITY;
    private static final Pattern XML_SPECIAL_RE;
    private static Random random;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Replacer {
        void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper);

        void replace(@NotNull String str, @NotNull StringBuilder sb);
    }

    static {
        String strM773o = AbstractC0541b.m773o("[!", ESCAPABLE_CHARS.replace("\\", "\\\\").replace("[", "\\[").replace("]", "\\]"), "]");
        ESCAPABLE = strM773o;
        BACKSLASH_ONLY = Pattern.compile("[\\\\]");
        ESCAPED_CHAR = Pattern.compile("\\\\" + strM773o, 2);
        BACKSLASH_OR_AMP = Pattern.compile("[\\\\&]");
        AMP_ONLY = Pattern.compile("[\\&]");
        ENTITY_OR_ESCAPED_CHAR = Pattern.compile("\\\\" + strM773o + "|&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
        ENTITY_ONLY = Pattern.compile(ENTITY, 2);
        XML_SPECIAL_RE = Pattern.compile(XML_SPECIAL);
        XML_SPECIAL_OR_ENTITY = Pattern.compile("&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});|[&<>\"]", 2);
        ESCAPE_IN_URI = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        ESCAPE_URI_DECODE = Pattern.compile("(%[a-fA-F0-9]{2})");
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        WHITESPACE = Pattern.compile("[ \t\r\n]+");
        COLLAPSE_WHITESPACE = Pattern.compile("[ \t]{2,}");
        UNSAFE_CHAR_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.1
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
                str.getClass();
                switch (str) {
                    case """:
                        sb.append("&quot;");
                        break;
                    case "&":
                        sb.append("&amp;");
                        break;
                    case "<":
                        sb.append("&lt;");
                        break;
                    case ">":
                        sb.append("&gt;");
                        break;
                    default:
                        sb.append(str);
                        break;
                }
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                String string = basedSequence.subSequence(i, i2).toString();
                string.getClass();
                switch (string) {
                    case """:
                        replacedTextMapper.addReplacedText(i, i2, PrefixedSubSequence.prefixOf("&quot;", BasedSequence.NULL));
                        break;
                    case "&":
                        replacedTextMapper.addReplacedText(i, i2, PrefixedSubSequence.prefixOf("&amp;", BasedSequence.NULL));
                        break;
                    case "<":
                        replacedTextMapper.addReplacedText(i, i2, PrefixedSubSequence.prefixOf("&lt;", BasedSequence.NULL));
                        break;
                    case ">":
                        replacedTextMapper.addReplacedText(i, i2, PrefixedSubSequence.prefixOf("&gt;", BasedSequence.NULL));
                        break;
                    default:
                        replacedTextMapper.addOriginalText(i, i2);
                        break;
                }
            }
        };
        COLLAPSE_WHITESPACE_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.2
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
                sb.append(" ");
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                replacedTextMapper.addReplacedText(i, i2, basedSequence.subSequence(i, i + 1));
            }
        };
        UNESCAPE_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.3
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
                if (str.charAt(0) == '\\') {
                    sb.append((CharSequence) str, 1, str.length());
                } else {
                    sb.append(Html5Entities.entityToString(str));
                }
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                if (basedSequence.charAt(i) == '\\') {
                    replacedTextMapper.addReplacedText(i, i2, basedSequence.subSequence(i + 1, i2));
                } else {
                    replacedTextMapper.addReplacedText(i, i2, Html5Entities.entityToSequence(basedSequence.subSequence(i, i2)));
                }
            }
        };
        REMOVE_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.4
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                replacedTextMapper.addReplacedText(i, i2, basedSequence.subSequence(i2, i2));
            }
        };
        ENTITY_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.5
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
                sb.append(Html5Entities.entityToString(str));
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                replacedTextMapper.addReplacedText(i, i2, Html5Entities.entityToSequence(basedSequence.subSequence(i, i2)));
            }
        };
        URL_ENCODE_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.6
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
                if (str.startsWith("%")) {
                    if (str.length() == 3) {
                        sb.append(str);
                        return;
                    } else {
                        sb.append("%25");
                        sb.append((CharSequence) str, 1, str.length());
                        return;
                    }
                }
                for (byte b : str.getBytes(StandardCharsets.UTF_8)) {
                    sb.append('%');
                    char[] cArr = Escaping.HEX_DIGITS;
                    sb.append(cArr[(b >> 4) & 15]);
                    sb.append(cArr[b & 15]);
                }
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                BasedSequence basedSequenceSubSequence = basedSequence.subSequence(i, i2);
                if (basedSequenceSubSequence.startsWith("%")) {
                    if (basedSequenceSubSequence.length() == 3) {
                        replacedTextMapper.addOriginalText(i, i2);
                        return;
                    }
                    int i4 = i + 1;
                    replacedTextMapper.addReplacedText(i, i4, PrefixedSubSequence.prefixOf("%25", BasedSequence.NULL));
                    replacedTextMapper.addOriginalText(i4, i2);
                    return;
                }
                byte[] bytes = basedSequenceSubSequence.toString().getBytes(StandardCharsets.UTF_8);
                StringBuilder sb = new StringBuilder();
                for (byte b : bytes) {
                    sb.append('%');
                    char[] cArr = Escaping.HEX_DIGITS;
                    sb.append(cArr[(b >> 4) & 15]);
                    sb.append(cArr[b & 15]);
                }
                replacedTextMapper.addReplacedText(i, i2, PrefixedSubSequence.prefixOf(sb.toString(), BasedSequence.NULL));
            }
        };
        URL_DECODE_REPLACER = new Replacer() { // from class: com.vladsch.flexmark.util.sequence.Escaping.7
            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull String str, @NotNull StringBuilder sb) {
                sb.append(Utils.urlDecode(str, null));
            }

            @Override // com.vladsch.flexmark.util.sequence.Escaping.Replacer
            public void replace(@NotNull BasedSequence basedSequence, int i, int i2, @NotNull ReplacedTextMapper replacedTextMapper) {
                replacedTextMapper.addReplacedText(i, i2, PrefixedSubSequence.prefixOf(Utils.urlDecode(basedSequence.subSequence(i, i2).toString(), null), BasedSequence.NULL));
            }
        };
        AMP_BACKSLASH_SET = CharPredicate.anyOf('\\', Typography.amp);
        random = new Random(9766L);
    }

    @NotNull
    public static String collapseWhitespace(@NotNull CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        int length = charSequence.length();
        boolean z2 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == ' ' || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r') {
                z2 = true;
            } else {
                if (z2 && (!z || sb.length() > 0)) {
                    sb.append(' ');
                }
                sb.append(cCharAt);
                z2 = false;
            }
        }
        if (z2 && !z) {
            sb.append(' ');
        }
        return sb.toString();
    }

    @Nullable
    private static String encode(char c) {
        if (c == '\"') {
            return "&quot;";
        }
        if (c == '<') {
            return "&lt;";
        }
        if (c == '>') {
            return "&gt;";
        }
        if (c == '&') {
            return "&amp;";
        }
        if (c != '\'') {
            return null;
        }
        return "&#39;";
    }

    public static String escapeHtml(@NotNull CharSequence charSequence, boolean z) {
        return replaceAll(z ? XML_SPECIAL_OR_ENTITY : XML_SPECIAL_RE, charSequence, UNSAFE_CHAR_REPLACER);
    }

    @NotNull
    public static String normalizeEOL(@NotNull CharSequence charSequence) {
        return normalizeEOL(charSequence, false);
    }

    @NotNull
    public static String normalizeEndWithEOL(@NotNull CharSequence charSequence) {
        return normalizeEOL(charSequence, true);
    }

    @NotNull
    public static String normalizeReference(@NotNull CharSequence charSequence, boolean z) {
        return z ? collapseWhitespace((CharSequence) charSequence.toString(), true).toLowerCase() : collapseWhitespace((CharSequence) charSequence.toString(), true);
    }

    @NotNull
    public static String normalizeReferenceChars(@NotNull CharSequence charSequence, boolean z) {
        if (charSequence.length() <= 1) {
            return String.valueOf(charSequence);
        }
        return normalizeReference(charSequence.subSequence(charSequence.charAt(0) == '!' ? 2 : 1, charSequence.length() - (charSequence.charAt(charSequence.length() - 1) == ':' ? 2 : 1)), z);
    }

    @NotNull
    public static String obfuscate(@NotNull String str, boolean z) {
        if (!z) {
            random = new Random(0L);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            int iNextInt = random.nextInt(5);
            if (iNextInt == 0 || iNextInt == 1) {
                sb.append("&#");
                sb.append((int) cCharAt);
                sb.append(SQLKeyword.DELIMITER);
            } else if (iNextInt == 2 || iNextInt == 3) {
                sb.append("&#x");
                sb.append(Integer.toHexString(cCharAt));
                sb.append(SQLKeyword.DELIMITER);
            } else if (iNextInt == 4) {
                String strEncode = encode(cCharAt);
                if (strEncode != null) {
                    sb.append(strEncode);
                } else {
                    sb.append(cCharAt);
                }
            }
        }
        return sb.toString();
    }

    @NotNull
    public static String percentDecodeUrl(@NotNull CharSequence charSequence) {
        return replaceAll(ESCAPE_URI_DECODE, charSequence, URL_DECODE_REPLACER);
    }

    @NotNull
    public static String percentEncodeUrl(@NotNull CharSequence charSequence) {
        return replaceAll(ESCAPE_IN_URI, charSequence, URL_ENCODE_REPLACER);
    }

    @NotNull
    public static BasedSequence removeAll(@NotNull BasedSequence basedSequence, @NotNull CharSequence charSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        if (basedSequence.indexOf(charSequence) == -1) {
            return basedSequence;
        }
        return replaceAll(Pattern.compile("\\Q" + ((Object) charSequence) + "\\E"), basedSequence, REMOVE_REPLACER, replacedTextMapper);
    }

    @NotNull
    private static String replaceAll(@NotNull Pattern pattern, @NotNull CharSequence charSequence, @NotNull Replacer replacer) {
        Matcher matcher = pattern.matcher(charSequence);
        if (!matcher.find()) {
            return String.valueOf(charSequence);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() + 16);
        int iEnd = 0;
        do {
            sb.append(charSequence, iEnd, matcher.start());
            replacer.replace(matcher.group(), sb);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd != charSequence.length()) {
            sb.append(charSequence, iEnd, charSequence.length());
        }
        return sb.toString();
    }

    @NotNull
    public static BasedSequence unescape(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return basedSequence.indexOfAny(AMP_BACKSLASH_SET) != -1 ? replaceAll(ENTITY_OR_ESCAPED_CHAR, basedSequence, UNESCAPE_REPLACER, replacedTextMapper) : basedSequence;
    }

    @NotNull
    public static String unescapeHtml(@NotNull CharSequence charSequence) {
        return AMP_ONLY.matcher(charSequence).find() ? replaceAll(ENTITY_ONLY, charSequence, ENTITY_REPLACER) : String.valueOf(charSequence);
    }

    @NotNull
    public static String unescapeString(@NotNull CharSequence charSequence) {
        return BACKSLASH_OR_AMP.matcher(charSequence).find() ? replaceAll(ENTITY_OR_ESCAPED_CHAR, charSequence, UNESCAPE_REPLACER) : String.valueOf(charSequence);
    }

    @NotNull
    public static String normalizeEOL(@NotNull CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        int length = charSequence.length();
        boolean z2 = false;
        boolean z3 = false;
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt == '\r') {
                z3 = true;
            } else if (cCharAt == '\n') {
                sb.append("\n");
                z3 = false;
                z2 = true;
            } else {
                if (z3) {
                    sb.append('\n');
                }
                sb.append(cCharAt);
                z2 = false;
                z3 = false;
            }
        }
        if (z && !z2) {
            sb.append('\n');
        }
        return sb.toString();
    }

    @NotNull
    public static BasedSequence normalizeEndWithEOL(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return normalizeEOL(basedSequence, replacedTextMapper, true);
    }

    @NotNull
    public static BasedSequence percentDecodeUrl(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return replaceAll(ESCAPE_URI_DECODE, basedSequence, URL_DECODE_REPLACER, replacedTextMapper);
    }

    @NotNull
    public static BasedSequence percentEncodeUrl(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return replaceAll(ESCAPE_IN_URI, basedSequence, URL_ENCODE_REPLACER, replacedTextMapper);
    }

    @NotNull
    public static BasedSequence escapeHtml(@NotNull BasedSequence basedSequence, boolean z, @NotNull ReplacedTextMapper replacedTextMapper) {
        return replaceAll(z ? XML_SPECIAL_OR_ENTITY : XML_SPECIAL_RE, basedSequence, UNSAFE_CHAR_REPLACER, replacedTextMapper);
    }

    @NotNull
    public static BasedSequence unescapeHtml(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return basedSequence.indexOf(Typography.amp) != -1 ? replaceAll(ENTITY_ONLY, basedSequence, ENTITY_REPLACER, replacedTextMapper) : basedSequence;
    }

    @NotNull
    public static String unescapeString(@NotNull CharSequence charSequence, boolean z) {
        if (z) {
            if (BACKSLASH_OR_AMP.matcher(charSequence).find()) {
                return replaceAll(ESCAPED_CHAR, charSequence, UNESCAPE_REPLACER);
            }
            return String.valueOf(charSequence);
        }
        if (BACKSLASH_ONLY.matcher(charSequence).find()) {
            return replaceAll(ENTITY_OR_ESCAPED_CHAR, charSequence, UNESCAPE_REPLACER);
        }
        return String.valueOf(charSequence);
    }

    @NotNull
    public static BasedSequence unescapeHtml(@NotNull BasedSequence basedSequence, @NotNull List<Range> list, @NotNull ReplacedTextMapper replacedTextMapper) {
        return basedSequence.indexOf(Typography.amp) != -1 ? replaceAll(ENTITY_ONLY, basedSequence, list, ENTITY_REPLACER, replacedTextMapper) : basedSequence;
    }

    @NotNull
    public static BasedSequence collapseWhitespace(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return replaceAll(COLLAPSE_WHITESPACE, basedSequence, COLLAPSE_WHITESPACE_REPLACER, replacedTextMapper);
    }

    @NotNull
    public static BasedSequence normalizeEOL(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper) {
        return normalizeEOL(basedSequence, replacedTextMapper, false);
    }

    @NotNull
    public static BasedSequence normalizeEOL(@NotNull BasedSequence basedSequence, @NotNull ReplacedTextMapper replacedTextMapper, boolean z) {
        int length = basedSequence.length();
        if (replacedTextMapper.isModified()) {
            replacedTextMapper.startNestedReplacement(basedSequence);
        }
        boolean z2 = false;
        int i = 0;
        boolean z3 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = basedSequence.charAt(i2);
            if (cCharAt == '\r') {
                z2 = true;
            } else if (cCharAt == '\n') {
                if (z2) {
                    int i4 = i2 - 1;
                    if (i < i4) {
                        replacedTextMapper.addOriginalText(i, i4);
                    }
                    z2 = false;
                    i = i2;
                    z3 = true;
                }
            } else if (z2) {
                int i5 = i2 - 1;
                if (i < i5) {
                    replacedTextMapper.addOriginalText(i, i2 + 1);
                }
                replacedTextMapper.addReplacedText(i5, i2, BasedSequence.EOL);
                z2 = false;
                z3 = false;
                i = i2;
            }
        }
        if (!z2) {
            if (i < length) {
                replacedTextMapper.addOriginalText(i, length);
            }
            if (!z3 && z) {
                replacedTextMapper.addReplacedText(length - 1, length, BasedSequence.EOL);
            }
        }
        return replacedTextMapper.getReplacedSequence();
    }

    @NotNull
    private static BasedSequence replaceAll(@NotNull Pattern pattern, @NotNull BasedSequence basedSequence, @NotNull Replacer replacer, @NotNull ReplacedTextMapper replacedTextMapper) {
        return replaceAll(pattern, basedSequence, 0, basedSequence.length(), replacer, replacedTextMapper);
    }

    @NotNull
    private static BasedSequence replaceAll(@NotNull Pattern pattern, @NotNull BasedSequence basedSequence, int i, int i2, @NotNull Replacer replacer, @NotNull ReplacedTextMapper replacedTextMapper) {
        Matcher matcher = pattern.matcher(basedSequence);
        matcher.region(i, i2);
        int iEnd = 0;
        matcher.useTransparentBounds(false);
        if (replacedTextMapper.isModified()) {
            replacedTextMapper.startNestedReplacement(basedSequence);
        }
        if (!matcher.find()) {
            replacedTextMapper.addOriginalText(0, basedSequence.length());
            return basedSequence;
        }
        do {
            replacedTextMapper.addOriginalText(iEnd, matcher.start());
            replacer.replace(basedSequence, matcher.start(), matcher.end(), replacedTextMapper);
            iEnd = matcher.end();
        } while (matcher.find());
        if (iEnd < basedSequence.length()) {
            replacedTextMapper.addOriginalText(iEnd, basedSequence.length());
        }
        return replacedTextMapper.getReplacedSequence();
    }

    @NotNull
    private static BasedSequence replaceAll(@NotNull Pattern pattern, @NotNull BasedSequence basedSequence, @NotNull List<Range> list, @NotNull Replacer replacer, @NotNull ReplacedTextMapper replacedTextMapper) {
        Matcher matcher = pattern.matcher(basedSequence);
        int iEnd = 0;
        matcher.useTransparentBounds(false);
        if (replacedTextMapper.isModified()) {
            replacedTextMapper.startNestedReplacement(basedSequence);
        }
        for (Range range : list) {
            int iRangeLimit = Utils.rangeLimit(range.getStart(), iEnd, basedSequence.length());
            matcher.region(iRangeLimit, Utils.rangeLimit(range.getEnd(), iRangeLimit, basedSequence.length()));
            while (matcher.find()) {
                replacedTextMapper.addOriginalText(iEnd, matcher.start());
                replacer.replace(basedSequence, matcher.start(), matcher.end(), replacedTextMapper);
                iEnd = matcher.end();
            }
        }
        if (iEnd < basedSequence.length()) {
            replacedTextMapper.addOriginalText(iEnd, basedSequence.length());
        }
        return replacedTextMapper.getReplacedSequence();
    }
}
