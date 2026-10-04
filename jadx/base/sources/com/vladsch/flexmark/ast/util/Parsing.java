package com.vladsch.flexmark.ast.util;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.TableFormatOptions;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import java.util.HashMap;
import java.util.function.Function;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Parsing {
    public static final String INTELLIJ_DUMMY_IDENTIFIER = TableFormatOptions.INTELLIJ_DUMMY_IDENTIFIER;
    public static final char INTELLIJ_DUMMY_IDENTIFIER_CHAR = 31;
    private static final String ST_ADDITIONAL_CHARS_IDI = "\u001f";
    private static final String ST_ADDITIONAL_CHARS_NO_IDI = "";
    private static final String ST_ADDITIONAL_CHARS_SET_IDI = "[\u001f]";
    private static final String ST_ADDITIONAL_CHARS_SET_NO_IDI = "";
    private static final String ST_ASCII_CLOSE_PUNCTUATION = "\\)>\\]\\}";
    private static final String ST_ASCII_OPEN_PUNCTUATION = "\\(<\\[\\{";
    private static final String ST_ASCII_PUNCTUATION = "'!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~";
    private static final String ST_ATTRIBUTENAME_IDI = "[a-zA-Z\u001f_:][a-zA-Z0-9\u001f:._-]*";
    private static final String ST_ATTRIBUTENAME_NO_IDI = "[a-zA-Z_:][a-zA-Z0-9:._-]*";
    private static final String ST_ATTRIBUTEVALUESPEC_IDI = "(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000-\u001e ]+|'[^']*'|\"[^\"]*\"))";
    private static final String ST_ATTRIBUTEVALUESPEC_NO_IDI = "(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000- ]+|'[^']*'|\"[^\"]*\"))";
    private static final String ST_ATTRIBUTEVALUE_IDI = "(?:[^\"'=<>{}`\u0000-\u001e ]+|'[^']*'|\"[^\"]*\")";
    private static final String ST_ATTRIBUTEVALUE_NO_IDI = "(?:[^\"'=<>{}`\u0000- ]+|'[^']*'|\"[^\"]*\")";
    private static final String ST_ATTRIBUTE_IDI = "(?:\\s+[a-zA-Z\u001f_:][a-zA-Z0-9\u001f:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000-\u001e ]+|'[^']*'|\"[^\"]*\"))?)";
    private static final String ST_ATTRIBUTE_NO_IDI = "(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000- ]+|'[^']*'|\"[^\"]*\"))?)";
    public static final String ST_CDATA = "<!\\[CDATA\\[[\\s\\S]*?\\]\\]>";
    private static final String ST_CLOSETAG_IDI = "</[A-Za-z\u001f][A-Za-z0-9\u001f-]*\\s*[>]";
    private static final String ST_CLOSETAG_NO_IDI = "</[A-Za-z][A-Za-z0-9-]*\\s*[>]";
    private static final String ST_DECLARATION_IDI = "<![A-Z\u001f]+\\s+[^>]*>";
    private static final String ST_DECLARATION_NO_IDI = "<![A-Z]+\\s+[^>]*>";
    public static final String ST_DOUBLEQUOTEDVALUE = "\"[^\"]*\"";
    private static final Pattern ST_ENTITY_HERE_IDI;
    private static final Pattern ST_ENTITY_HERE_NO_IDI;
    private static final String ST_ENTITY_IDI = "&(?:#x[a-f0-9\u001f]{1,8}|#[0-9]{1,8}|[a-z\u001f][a-z0-9\u001f]{1,31});";
    private static final String ST_ENTITY_NO_IDI = "&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});";
    private static final String ST_EOL = "(?:\r\n|\r|\n)";
    private static final Pattern ST_ESCAPABLE;
    private static final String ST_ESCAPED_CHAR;
    private static final String ST_EXCLUDED_0_TO_SPACE_IDI = "\u0000-\u001e ";
    private static final String ST_EXCLUDED_0_TO_SPACE_NO_IDI = "\u0000- ";
    private static final Pattern ST_FINAL_SPACE;
    public static final String ST_HTMLCOMMENT = "<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->";
    private static final String ST_IN_BRACES_W_SP_IDI = "\\{\\{(?:[^{}\\\\\u0000-\u001e ]| |\t)*\\}\\}";
    private static final String ST_IN_BRACES_W_SP_NO_IDI = "\\{\\{(?:[^{}\\\\\u0000- ]| |\t)*\\}\\}";
    private static final String ST_IN_MATCHED_PARENS_NOSP_IDI;
    private static final String ST_IN_MATCHED_PARENS_NOSP_NO_IDI;
    private static final String ST_IN_MATCHED_PARENS_W_SP_IDI;
    private static final String ST_IN_MATCHED_PARENS_W_SP_NO_IDI;
    private static final String ST_IN_PARENS_NOSP_IDI;
    private static final String ST_IN_PARENS_NOSP_NO_IDI;
    private static final String ST_IN_PARENS_W_SP_IDI;
    private static final String ST_IN_PARENS_W_SP_NO_IDI;
    private static final Pattern ST_LINE_END;
    private static final Pattern ST_LINK_DESTINATION_ANGLES_NO_SPC;
    private static final Pattern ST_LINK_DESTINATION_ANGLES_SPC;
    private static final Pattern ST_LINK_LABEL;
    private static final Pattern ST_LINK_TITLE;
    private static final String ST_LINK_TITLE_STRING;
    private static final String ST_NS_CLOSETAG_IDI = "</(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?[A-Za-z\u001f][A-Za-z0-9\u001f-]*\\s*[>]";
    private static final String ST_NS_CLOSETAG_NO_IDI = "</(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?[A-Za-z][A-Za-z0-9-]*\\s*[>]";
    private static final String ST_NS_OPENTAG_IDI = "<(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?[A-Za-z\u001f][A-Za-z0-9\u001f-]*(?:\\s+[a-zA-Z\u001f_:][a-zA-Z0-9\u001f:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000-\u001e ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
    private static final String ST_NS_OPENTAG_NO_IDI = "<(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000- ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
    private static final String ST_OPENTAG_IDI = "<[A-Za-z\u001f][A-Za-z0-9\u001f-]*(?:\\s+[a-zA-Z\u001f_:][a-zA-Z0-9\u001f:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000-\u001e ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
    private static final String ST_OPENTAG_NO_IDI = "<[A-Za-z][A-Za-z0-9-]*(?:\\s+[a-zA-Z_:][a-zA-Z0-9:._-]*(?:\\s*=\\s*(?:[^\"'=<>{}`\u0000- ]+|'[^']*'|\"[^\"]*\"))?)*\\s*/?>";
    public static final String ST_PROCESSINGINSTRUCTION = "[<][?].*?[?][>]";
    private static final Pattern ST_PUNCTUATION;
    private static final Pattern ST_PUNCTUATION_CLOSE;
    private static final Pattern ST_PUNCTUATION_CLOSE_ONLY;
    private static final Pattern ST_PUNCTUATION_ONLY;
    private static final Pattern ST_PUNCTUATION_OPEN;
    private static final Pattern ST_PUNCTUATION_OPEN_ONLY;
    private static final String ST_REG_CHAR_IDI = "[^\\\\()\u0000-\u001e ]";
    private static final String ST_REG_CHAR_NO_IDI = "[^\\\\()\u0000- ]";
    private static final String ST_REG_CHAR_PARENS_IDI = "[^\\\\\u0000-\u001e ]";
    private static final String ST_REG_CHAR_PARENS_NO_IDI = "[^\\\\\u0000- ]";
    private static final String ST_REG_CHAR_SP_IDI = "[^\\\\()\u0000-\u001e ]| (?![\"'])";
    private static final String ST_REG_CHAR_SP_NO_IDI = "[^\\\\()\u0000- ]| (?![\"'])";
    private static final String ST_REG_CHAR_SP_PARENS_IDI = "[^\\\\\u0000-\u001e ]| (?![\"'])";
    private static final String ST_REG_CHAR_SP_PARENS_NO_IDI = "[^\\\\\u0000- ]| (?![\"'])";
    private static final Pattern ST_REST_OF_LINE;
    public static final String ST_SINGLEQUOTEDVALUE = "'[^']*'";
    private static final Pattern ST_SP;
    private static final Pattern ST_SPNI;
    private static final Pattern ST_SPNL;
    private static final Pattern ST_SPNL_URL;
    private static final String ST_TAGNAME_IDI = "[A-Za-z\u001f][A-Za-z0-9\u001f-]*";
    private static final String ST_TAGNAME_NO_IDI = "[A-Za-z][A-Za-z0-9-]*";
    private static final Pattern ST_TICKS;
    private static final Pattern ST_TICKS_HERE;
    private static final Pattern ST_UNICODE_WHITESPACE_CHAR;
    private static final String ST_UNQUOTEDVALUE_IDI = "[^\"'=<>{}`\u0000-\u001e ]+";
    private static final String ST_UNQUOTEDVALUE_NO_IDI = "[^\"'=<>{}`\u0000- ]+";
    private static final Pattern ST_WHITESPACE;
    public static final String XML_NAMESPACE = "(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?";
    public static final String XML_NAMESPACE_CHAR = "[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-]";
    public static final String XML_NAMESPACE_START = "[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]";
    static final HashMap<String, HashMap<PatternTypeFlags, Pattern>> cachedPatterns;
    public final String ADDITIONAL_CHARS;
    public final String ATTRIBUTE;
    public final String ATTRIBUTENAME;
    public final String ATTRIBUTEVALUE;
    public final String ATTRIBUTEVALUESPEC;
    public final Pattern AUTOLINK;
    public final String CLOSETAG;
    public final int CODE_BLOCK_INDENT;
    public final String DECLARATION;
    public final Pattern EMAIL_AUTOLINK;
    public final String ENTITY;
    public final Pattern ENTITY_HERE;
    public final String EXCLUDED_0_TO_SPACE;
    public final String HTMLTAG;
    public final Pattern HTML_TAG;
    public final String IN_BRACES_W_SP;
    public final String IN_MATCHED_PARENS_NOSP;
    public final String IN_MATCHED_PARENS_W_SP;
    public final String IN_PARENS_NOSP;
    public final String IN_PARENS_W_SP;
    public final Pattern LINK_DESTINATION;
    public final Pattern LINK_DESTINATION_ANGLES;
    public final Pattern LINK_DESTINATION_MATCHED_PARENS;
    public final Pattern LINK_DESTINATION_MATCHED_PARENS_NOSP;
    public final Pattern LIST_ITEM_MARKER;
    public final String OPENTAG;
    public final String REG_CHAR;
    public final String REG_CHAR_PARENS;
    public final String REG_CHAR_SP;
    public final String REG_CHAR_SP_PARENS;
    public final String TAGNAME;
    public final String UNQUOTEDVALUE;
    public final Pattern WWW_AUTOLINK;
    public final boolean allowNameSpace;
    public final boolean htmlForTranslator;
    public final boolean intellijDummyIdentifier;
    public final String itemPrefixChars;
    public final boolean listsItemMarkerSpace;
    public final boolean listsOrderedItemDotOnly;
    public final DataHolder options;
    public final boolean parseJekyllMacroInLinkUrl;
    public final boolean spaceInLinkUrl;
    public final String translationAutolinkTagPattern;
    public final String translationHtmlInlineTagPattern;
    public final String EOL = ST_EOL;
    public final String ESCAPED_CHAR = ST_ESCAPED_CHAR;
    public final Pattern LINK_LABEL = ST_LINK_LABEL;
    public final String LINK_TITLE_STRING = ST_LINK_TITLE_STRING;
    public final Pattern LINK_TITLE = ST_LINK_TITLE;
    public final String HTMLCOMMENT = ST_HTMLCOMMENT;
    public final String PROCESSINGINSTRUCTION = ST_PROCESSINGINSTRUCTION;
    public final String CDATA = ST_CDATA;
    public final String SINGLEQUOTEDVALUE = ST_SINGLEQUOTEDVALUE;
    public final String DOUBLEQUOTEDVALUE = ST_DOUBLEQUOTEDVALUE;
    public final String ASCII_PUNCTUATION = ST_ASCII_PUNCTUATION;
    public final String ASCII_OPEN_PUNCTUATION = ST_ASCII_OPEN_PUNCTUATION;
    public final String ASCII_CLOSE_PUNCTUATION = ST_ASCII_CLOSE_PUNCTUATION;
    public final Pattern PUNCTUATION = ST_PUNCTUATION;
    public final Pattern PUNCTUATION_OPEN = ST_PUNCTUATION_OPEN;
    public final Pattern PUNCTUATION_CLOSE = ST_PUNCTUATION_CLOSE;
    public final Pattern PUNCTUATION_ONLY = ST_PUNCTUATION_ONLY;
    public final Pattern PUNCTUATION_OPEN_ONLY = ST_PUNCTUATION_OPEN_ONLY;
    public final Pattern PUNCTUATION_CLOSE_ONLY = ST_PUNCTUATION_CLOSE_ONLY;
    public final Pattern ESCAPABLE = ST_ESCAPABLE;
    public final Pattern TICKS = ST_TICKS;
    public final Pattern TICKS_HERE = ST_TICKS_HERE;
    public final Pattern SPNL = ST_SPNL;
    public final Pattern SPNL_URL = ST_SPNL_URL;
    public final Pattern SPNI = ST_SPNI;

    /* JADX INFO: renamed from: SP */
    public final Pattern f8276SP = ST_SP;
    public final Pattern REST_OF_LINE = ST_REST_OF_LINE;
    public final Pattern UNICODE_WHITESPACE_CHAR = ST_UNICODE_WHITESPACE_CHAR;
    public final Pattern WHITESPACE = ST_WHITESPACE;
    public final Pattern FINAL_SPACE = ST_FINAL_SPACE;
    public final Pattern LINE_END = ST_LINE_END;

    static {
        String str = Escaping.ESCAPABLE;
        String strM772n = AbstractC0541b.m772n("\\\\", str);
        ST_ESCAPED_CHAR = strM772n;
        ST_LINK_LABEL = Pattern.compile("^\\[(?:[^\\\\\\[\\]]|" + strM772n + "|\\\\){0,999}\\]");
        String strM1170p = AbstractC0622a.m1170p(strM772n, "|[^)\\x00])*\\))", AbstractC0000a.m16m("(?:\"(", strM772n, "|[^\"\\x00])*\"|'(", strM772n, "|[^'\\x00])*'|\\(("));
        ST_LINK_TITLE_STRING = strM1170p;
        ST_LINK_TITLE = Pattern.compile("^" + strM1170p);
        ST_PUNCTUATION = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\(<\\[\\{\\)>\\]\\}\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]");
        ST_PUNCTUATION_OPEN = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\(<\\[\\{]|[\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]&&[^\\)>\\]\\}]");
        ST_PUNCTUATION_CLOSE = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\)>\\]\\}]|[\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]&&[^\\(<\\[\\{]");
        ST_PUNCTUATION_ONLY = Pattern.compile("^['!\"#\\$%&\\*\\+,\\-\\./:;=\\?@\\\\\\^_`\\|~\\p{Pc}\\p{Pd}\\p{Pe}\\p{Pf}\\p{Pi}\\p{Po}\\p{Ps}]&&[^\\(<\\[\\{\\)>\\]\\}]");
        ST_PUNCTUATION_OPEN_ONLY = Pattern.compile("^[\\(<\\[\\{]");
        ST_PUNCTUATION_CLOSE_ONLY = Pattern.compile("^[\\)>\\]\\}]");
        ST_ESCAPABLE = Pattern.compile("^" + str);
        ST_TICKS = Pattern.compile("`+");
        ST_TICKS_HERE = Pattern.compile("^`+");
        ST_SPNL = Pattern.compile("^(?:[ \t])*(?:(?:\r\n|\r|\n)(?:[ \t])*)?");
        ST_SPNL_URL = Pattern.compile("^(?:[ \t])*(?:\r\n|\r|\n)");
        ST_SPNI = Pattern.compile("^ {0,3}");
        ST_SP = Pattern.compile("^(?:[ \t])*");
        ST_REST_OF_LINE = Pattern.compile("^.*(?:\r\n|\r|\n)");
        ST_UNICODE_WHITESPACE_CHAR = Pattern.compile("^[\\p{Zs}\t\r\n\f]");
        ST_WHITESPACE = Pattern.compile("\\s+");
        ST_FINAL_SPACE = Pattern.compile(" *$");
        ST_LINE_END = Pattern.compile("^[ \t]*(?:(?:\r\n|\r|\n)|$)");
        ST_LINK_DESTINATION_ANGLES_SPC = Pattern.compile("^(?:[<](?:[^<> \\t\\n\\\\\\x00]|" + strM772n + "|\\\\| (?![\"']))*[>])");
        ST_LINK_DESTINATION_ANGLES_NO_SPC = Pattern.compile("^(?:[<](?:[^<> \\t\\n\\\\\\x00]|" + strM772n + "|\\\\)*[>])");
        ST_IN_MATCHED_PARENS_NOSP_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000-\u001e ]|", strM772n, ")*\\)");
        ST_IN_MATCHED_PARENS_NOSP_NO_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000- ]|", strM772n, ")*\\)");
        ST_IN_MATCHED_PARENS_W_SP_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000-\u001e ]| (?![\"'])|", strM772n, ")*\\)");
        ST_IN_MATCHED_PARENS_W_SP_NO_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000- ]| (?![\"'])|", strM772n, ")*\\)");
        ST_IN_PARENS_NOSP_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000-\u001e ]|", strM772n, ")*\\)");
        ST_IN_PARENS_NOSP_NO_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000- ]|", strM772n, ")*\\)");
        ST_IN_PARENS_W_SP_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000-\u001e ]| (?![\"'])|", strM772n, ")*\\)");
        ST_IN_PARENS_W_SP_NO_IDI = AbstractC0541b.m773o("\\(([^\\\\()\u0000- ]| (?![\"'])|", strM772n, ")*\\)");
        ST_ENTITY_HERE_IDI = Pattern.compile("^&(?:#x[a-f0-9\u001f]{1,8}|#[0-9]{1,8}|[a-z\u001f][a-z0-9\u001f]{1,31});", 2);
        ST_ENTITY_HERE_NO_IDI = Pattern.compile("^&(?:#x[a-f0-9]{1,8}|#[0-9]{1,8}|[a-z][a-z0-9]{1,31});", 2);
        cachedPatterns = new HashMap<>();
    }

    public Parsing(DataHolder dataHolder) {
        Pattern cachedPattern;
        this.options = dataHolder;
        this.CODE_BLOCK_INDENT = Parser.CODE_BLOCK_INDENT.get(dataHolder).intValue();
        PatternTypeFlags patternTypeFlags = new PatternTypeFlags(dataHolder);
        Boolean bool = Boolean.TRUE;
        boolean zEquals = bool.equals(patternTypeFlags.intellijDummyIdentifier);
        this.intellijDummyIdentifier = zEquals;
        this.htmlForTranslator = bool.equals(patternTypeFlags.htmlForTranslator);
        this.translationHtmlInlineTagPattern = patternTypeFlags.translationHtmlInlineTagPattern;
        this.translationAutolinkTagPattern = patternTypeFlags.translationAutolinkTagPattern;
        boolean zEquals2 = bool.equals(patternTypeFlags.spaceInLinkUrl);
        this.spaceInLinkUrl = zEquals2;
        this.parseJekyllMacroInLinkUrl = bool.equals(patternTypeFlags.parseJekyllMacroInLinkUrl);
        this.itemPrefixChars = patternTypeFlags.itemPrefixChars;
        this.listsItemMarkerSpace = bool.equals(patternTypeFlags.listsItemMarkerSpace);
        this.listsOrderedItemDotOnly = bool.equals(patternTypeFlags.listsOrderedItemDotOnly);
        boolean zEquals3 = bool.equals(patternTypeFlags.allowNameSpace);
        this.allowNameSpace = zEquals3;
        if (zEquals) {
            this.ADDITIONAL_CHARS = "\u001f";
            this.EXCLUDED_0_TO_SPACE = ST_EXCLUDED_0_TO_SPACE_IDI;
            this.REG_CHAR = ST_REG_CHAR_IDI;
            this.REG_CHAR_PARENS = ST_REG_CHAR_PARENS_IDI;
            this.REG_CHAR_SP = ST_REG_CHAR_SP_IDI;
            this.REG_CHAR_SP_PARENS = ST_REG_CHAR_SP_PARENS_IDI;
            this.IN_PARENS_NOSP = ST_IN_PARENS_NOSP_IDI;
            this.IN_PARENS_W_SP = ST_IN_PARENS_W_SP_IDI;
            this.IN_MATCHED_PARENS_NOSP = ST_IN_MATCHED_PARENS_NOSP_IDI;
            this.IN_MATCHED_PARENS_W_SP = ST_IN_MATCHED_PARENS_W_SP_IDI;
            this.IN_BRACES_W_SP = ST_IN_BRACES_W_SP_IDI;
            this.DECLARATION = ST_DECLARATION_IDI;
            this.ENTITY = ST_ENTITY_IDI;
            this.TAGNAME = ST_TAGNAME_IDI;
            this.ATTRIBUTENAME = ST_ATTRIBUTENAME_IDI;
            this.UNQUOTEDVALUE = ST_UNQUOTEDVALUE_IDI;
            this.ATTRIBUTEVALUE = ST_ATTRIBUTEVALUE_IDI;
            this.ATTRIBUTEVALUESPEC = ST_ATTRIBUTEVALUESPEC_IDI;
            this.ATTRIBUTE = ST_ATTRIBUTE_IDI;
            this.OPENTAG = zEquals3 ? ST_NS_OPENTAG_IDI : ST_OPENTAG_IDI;
            this.CLOSETAG = zEquals3 ? ST_NS_CLOSETAG_IDI : ST_CLOSETAG_IDI;
        } else {
            this.ADDITIONAL_CHARS = "";
            this.EXCLUDED_0_TO_SPACE = ST_EXCLUDED_0_TO_SPACE_NO_IDI;
            this.REG_CHAR = ST_REG_CHAR_NO_IDI;
            this.REG_CHAR_PARENS = ST_REG_CHAR_PARENS_NO_IDI;
            this.REG_CHAR_SP = ST_REG_CHAR_SP_NO_IDI;
            this.REG_CHAR_SP_PARENS = ST_REG_CHAR_SP_PARENS_NO_IDI;
            this.IN_PARENS_NOSP = ST_IN_PARENS_NOSP_NO_IDI;
            this.IN_PARENS_W_SP = ST_IN_PARENS_W_SP_NO_IDI;
            this.IN_MATCHED_PARENS_NOSP = ST_IN_MATCHED_PARENS_NOSP_NO_IDI;
            this.IN_MATCHED_PARENS_W_SP = ST_IN_MATCHED_PARENS_W_SP_NO_IDI;
            this.IN_BRACES_W_SP = ST_IN_BRACES_W_SP_NO_IDI;
            this.DECLARATION = ST_DECLARATION_NO_IDI;
            this.ENTITY = ST_ENTITY_NO_IDI;
            this.TAGNAME = ST_TAGNAME_NO_IDI;
            this.ATTRIBUTENAME = ST_ATTRIBUTENAME_NO_IDI;
            this.UNQUOTEDVALUE = ST_UNQUOTEDVALUE_NO_IDI;
            this.ATTRIBUTEVALUE = ST_ATTRIBUTEVALUE_NO_IDI;
            this.ATTRIBUTEVALUESPEC = ST_ATTRIBUTEVALUESPEC_NO_IDI;
            this.ATTRIBUTE = ST_ATTRIBUTE_NO_IDI;
            this.OPENTAG = zEquals3 ? ST_NS_OPENTAG_NO_IDI : ST_OPENTAG_NO_IDI;
            this.CLOSETAG = zEquals3 ? ST_NS_CLOSETAG_NO_IDI : ST_CLOSETAG_NO_IDI;
        }
        this.LINK_DESTINATION_ANGLES = zEquals2 ? ST_LINK_DESTINATION_ANGLES_SPC : ST_LINK_DESTINATION_ANGLES_NO_SPC;
        this.ENTITY_HERE = zEquals ? ST_ENTITY_HERE_IDI : ST_ENTITY_HERE_NO_IDI;
        synchronized (cachedPatterns) {
            final int i = 0;
            this.LINK_DESTINATION_MATCHED_PARENS_NOSP = getCachedPattern("LINK_DESTINATION_MATCHED_PARENS_NOSP", patternTypeFlags.withJekyllMacroInLinkUrl(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            final int i2 = 1;
            this.LINK_DESTINATION = getCachedPattern("LINK_DESTINATION", patternTypeFlags.withJekyllMacroSpaceInLinkUrl(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i2) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            final int i4 = 2;
            this.LINK_DESTINATION_MATCHED_PARENS = getCachedPattern("LINK_DESTINATION_MATCHED_PARENS", patternTypeFlags.withJekyllMacroSpaceInLinkUrl(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i4) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            final int i5 = 3;
            this.EMAIL_AUTOLINK = getCachedPattern("EMAIL_AUTOLINK", patternTypeFlags.withHtmlTranslator(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i5) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            final int i6 = 4;
            this.AUTOLINK = getCachedPattern("AUTOLINK", patternTypeFlags.withHtmlTranslator(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i6) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            final int i7 = 5;
            this.WWW_AUTOLINK = getCachedPattern("WWW_AUTOLINK", patternTypeFlags.withHtmlTranslator(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i7) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            final int i8 = 6;
            cachedPattern = getCachedPattern("HTML_TAG", patternTypeFlags.withHtmlTranslator(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i8) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
            this.HTML_TAG = cachedPattern;
            final int i9 = 7;
            this.LIST_ITEM_MARKER = getCachedPattern("LIST_ITEM_MARKER", patternTypeFlags.withItemPrefixChars(), new Function(this) { // from class: com.vladsch.flexmark.ast.util.f

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ Parsing f8289b;

                {
                    this.f8289b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    switch (i9) {
                        case 0:
                            return this.f8289b.lambda$new$1((Parsing.PatternTypeFlags) obj);
                        case 1:
                            return this.f8289b.lambda$new$2((Parsing.PatternTypeFlags) obj);
                        case 2:
                            return this.f8289b.lambda$new$3((Parsing.PatternTypeFlags) obj);
                        case 3:
                            return this.f8289b.lambda$new$4((Parsing.PatternTypeFlags) obj);
                        case 4:
                            return this.f8289b.lambda$new$5((Parsing.PatternTypeFlags) obj);
                        case 5:
                            return this.f8289b.lambda$new$6((Parsing.PatternTypeFlags) obj);
                        case 6:
                            return this.f8289b.lambda$new$7((Parsing.PatternTypeFlags) obj);
                        default:
                            return this.f8289b.lambda$new$8((Parsing.PatternTypeFlags) obj);
                    }
                }
            });
        }
        this.HTMLTAG = cachedPattern.pattern();
    }

    public static int columnsToNextTabStop(int i) {
        return 4 - (i % 4);
    }

    public static int findLineBreak(CharSequence charSequence, int i) {
        return SequenceUtils.indexOfAny(charSequence, CharPredicate.ANY_EOL, i);
    }

    public static Pattern getCachedPattern(@NotNull String str, @NotNull PatternTypeFlags patternTypeFlags, @NotNull Function<PatternTypeFlags, Pattern> function) {
        return cachedPatterns.computeIfAbsent(str, new C11419a(5)).computeIfAbsent(patternTypeFlags, function);
    }

    public static boolean isBlank(CharSequence charSequence) {
        return SequenceUtils.indexOfAnyNot(charSequence, CharPredicate.BLANKSPACE) == -1;
    }

    public static boolean isLetter(CharSequence charSequence, int i) {
        return Character.isLetter(Character.codePointAt(charSequence, i));
    }

    public static boolean isSpaceOrTab(CharSequence charSequence, int i) {
        return CharPredicate.SPACE_TAB.test(SequenceUtils.safeCharAt(charSequence, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HashMap lambda$getCachedPattern$0(String str) {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$1(PatternTypeFlags patternTypeFlags) {
        StringBuilder sbM16m = AbstractC0000a.m16m("^(?:", this.parseJekyllMacroInLinkUrl ? AbstractC0541b.m756B(this.IN_BRACES_W_SP, "|") : "", this.REG_CHAR, "|", this.ESCAPED_CHAR);
        sbM16m.append("|\\\\|\\(|\\))*");
        return Pattern.compile(sbM16m.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$2(PatternTypeFlags patternTypeFlags) {
        String strM756B = this.parseJekyllMacroInLinkUrl ? AbstractC0541b.m756B(this.IN_BRACES_W_SP, "|") : "";
        String strM773o = this.spaceInLinkUrl ? AbstractC0541b.m773o("(?:", this.REG_CHAR_SP, ")|") : AbstractC0541b.m756B(this.REG_CHAR, "|");
        String str = this.ESCAPED_CHAR;
        String str2 = this.spaceInLinkUrl ? this.IN_PARENS_W_SP : this.IN_PARENS_NOSP;
        StringBuilder sbM16m = AbstractC0000a.m16m("^(?:", strM756B, strM773o, str, "|\\\\|");
        sbM16m.append(str2);
        sbM16m.append(")*");
        return Pattern.compile(sbM16m.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$3(PatternTypeFlags patternTypeFlags) {
        return Pattern.compile("^(?:" + (this.parseJekyllMacroInLinkUrl ? AbstractC0541b.m756B(this.IN_BRACES_W_SP, "|") : "") + (this.spaceInLinkUrl ? AbstractC0541b.m773o("(?:", this.REG_CHAR_SP, ")|") : AbstractC0541b.m756B(this.REG_CHAR, "|")) + this.ESCAPED_CHAR + "|\\\\|\\(|\\))*");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$4(PatternTypeFlags patternTypeFlags) {
        String str = this.ADDITIONAL_CHARS;
        String strM773o = this.htmlForTranslator ? AbstractC0541b.m773o("|(?:", this.translationAutolinkTagPattern, ")") : "";
        StringBuilder sbM16m = AbstractC0000a.m16m("^<((?:[a-zA-Z0-9", str, ".!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9", str, "](?:[a-zA-Z0-9");
        AbstractC2821a.m2207B(sbM16m, str, "-]{0,61}[a-zA-Z0-9", str, "])?(?:\\.[a-zA-Z0-9");
        AbstractC2821a.m2207B(sbM16m, str, "](?:[a-zA-Z0-9", str, "-]{0,61}[a-zA-Z0-9");
        sbM16m.append(str);
        sbM16m.append("])?)*)");
        sbM16m.append(strM773o);
        sbM16m.append(")>");
        return Pattern.compile(sbM16m.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$5(PatternTypeFlags patternTypeFlags) {
        String str = this.ADDITIONAL_CHARS;
        String str2 = this.EXCLUDED_0_TO_SPACE;
        String strM773o = this.htmlForTranslator ? AbstractC0541b.m773o("|(?:", this.translationAutolinkTagPattern, ")") : "";
        StringBuilder sbM16m = AbstractC0000a.m16m("^<((?:[a-zA-Z][a-zA-Z0-9", str, ".+-]{1,31}:[^<>", str2, "]*)");
        sbM16m.append(strM773o);
        sbM16m.append(")>");
        return Pattern.compile(sbM16m.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$6(PatternTypeFlags patternTypeFlags) {
        String str = this.ADDITIONAL_CHARS;
        String str2 = this.EXCLUDED_0_TO_SPACE;
        String strM773o = this.htmlForTranslator ? AbstractC0541b.m773o("|(?:", this.translationAutolinkTagPattern, ")") : "";
        StringBuilder sbM16m = AbstractC0000a.m16m("^<((?:w", str, "?){3,3}\\.[^<>", str2, "]*");
        sbM16m.append(strM773o);
        sbM16m.append(")>");
        return Pattern.compile(sbM16m.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$7(PatternTypeFlags patternTypeFlags) {
        String strM775q;
        String str = this.OPENTAG;
        String str2 = this.CLOSETAG;
        String str3 = this.DECLARATION;
        if (this.htmlForTranslator) {
            String str4 = this.translationHtmlInlineTagPattern;
            strM775q = AbstractC0541b.m775q("|<(?:", str4, ")>|</(?:", str4, ")>");
        } else {
            strM775q = "";
        }
        return Pattern.compile(AbstractC0541b.m776r(AbstractC0000a.m16m("^(?:", str, "|", str2, "|<!---->|<!--(?:-?[^>-])(?:-?[^-])*-->|[<][?].*?[?][>]|"), str3, "|<!\\[CDATA\\[[\\s\\S]*?\\]\\]>", strM775q, ")"), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Pattern lambda$new$8(PatternTypeFlags patternTypeFlags) {
        if (this.listsItemMarkerSpace) {
            if (this.listsOrderedItemDotOnly) {
                return Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?=[ \t])|^(\\d{1,9})([.])(?=[ \t])");
            }
            return Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?=[ \t])|^(\\d{1,9})([.)])(?=[ \t])");
        }
        if (this.listsOrderedItemDotOnly) {
            return Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?= |\t|$)|^(\\d{1,9})([.])(?= |\t|$)");
        }
        return Pattern.compile("^([\\Q" + this.itemPrefixChars + "\\E])(?= |\t|$)|^(\\d{1,9})([.)])(?= |\t|$)");
    }

    @Deprecated
    public String ADDITIONAL_CHARS() {
        return this.intellijDummyIdentifier ? "\u001f" : "";
    }

    @Deprecated
    public String ADDITIONAL_CHARS_SET(String str) {
        return this.intellijDummyIdentifier ? AbstractC0541b.m772n(ST_ADDITIONAL_CHARS_SET_IDI, str) : "";
    }

    @Deprecated
    public String EXCLUDED_0_TO_SPACE() {
        return this.intellijDummyIdentifier ? ST_EXCLUDED_0_TO_SPACE_IDI : ST_EXCLUDED_0_TO_SPACE_NO_IDI;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PatternTypeFlags {

        @Nullable
        final Boolean allowNameSpace;

        @Nullable
        final Boolean htmlForTranslator;

        @Nullable
        final Boolean intellijDummyIdentifier;

        @Nullable
        final String itemPrefixChars;

        @Nullable
        final Boolean listsItemMarkerSpace;

        @Nullable
        final Boolean listsOrderedItemDotOnly;

        @Nullable
        final Boolean parseJekyllMacroInLinkUrl;

        @Nullable
        final Boolean spaceInLinkUrl;

        @Nullable
        final String translationAutolinkTagPattern;

        @Nullable
        final String translationHtmlInlineTagPattern;

        public PatternTypeFlags(DataHolder dataHolder) {
            this.intellijDummyIdentifier = Parser.INTELLIJ_DUMMY_IDENTIFIER.get(dataHolder);
            this.htmlForTranslator = Parser.HTML_FOR_TRANSLATOR.get(dataHolder);
            this.translationHtmlInlineTagPattern = Parser.TRANSLATION_HTML_INLINE_TAG_PATTERN.get(dataHolder);
            this.translationAutolinkTagPattern = Parser.TRANSLATION_AUTOLINK_TAG_PATTERN.get(dataHolder);
            this.spaceInLinkUrl = Parser.SPACE_IN_LINK_URLS.get(dataHolder);
            this.parseJekyllMacroInLinkUrl = Parser.PARSE_JEKYLL_MACROS_IN_URLS.get(dataHolder);
            this.itemPrefixChars = Parser.LISTS_ITEM_PREFIX_CHARS.get(dataHolder);
            this.listsItemMarkerSpace = Parser.LISTS_ITEM_MARKER_SPACE.get(dataHolder);
            this.listsOrderedItemDotOnly = Parser.LISTS_ORDERED_ITEM_DOT_ONLY.get(dataHolder);
            this.allowNameSpace = Parser.HTML_ALLOW_NAME_SPACE.get(dataHolder);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PatternTypeFlags patternTypeFlags = (PatternTypeFlags) obj;
            Boolean bool = this.intellijDummyIdentifier;
            if (bool != null && !bool.equals(patternTypeFlags.intellijDummyIdentifier)) {
                return false;
            }
            Boolean bool2 = this.htmlForTranslator;
            if (bool2 != null && !bool2.equals(patternTypeFlags.htmlForTranslator)) {
                return false;
            }
            String str = this.translationHtmlInlineTagPattern;
            if (str != null && !str.equals(patternTypeFlags.translationHtmlInlineTagPattern)) {
                return false;
            }
            String str2 = this.translationAutolinkTagPattern;
            if (str2 != null && !str2.equals(patternTypeFlags.translationAutolinkTagPattern)) {
                return false;
            }
            Boolean bool3 = this.spaceInLinkUrl;
            if (bool3 != null && !bool3.equals(patternTypeFlags.spaceInLinkUrl)) {
                return false;
            }
            Boolean bool4 = this.parseJekyllMacroInLinkUrl;
            if (bool4 != null && !bool4.equals(patternTypeFlags.parseJekyllMacroInLinkUrl)) {
                return false;
            }
            String str3 = this.itemPrefixChars;
            if (str3 != null && !str3.equals(patternTypeFlags.itemPrefixChars)) {
                return false;
            }
            Boolean bool5 = this.listsItemMarkerSpace;
            if (bool5 != null && !bool5.equals(patternTypeFlags.listsItemMarkerSpace)) {
                return false;
            }
            Boolean bool6 = this.allowNameSpace;
            if (bool6 != null && !bool6.equals(patternTypeFlags.allowNameSpace)) {
                return false;
            }
            Boolean bool7 = this.listsOrderedItemDotOnly;
            return bool7 == null || bool7.equals(patternTypeFlags.listsOrderedItemDotOnly);
        }

        public int hashCode() {
            Boolean bool = this.intellijDummyIdentifier;
            int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
            Boolean bool2 = this.htmlForTranslator;
            int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
            String str = this.translationHtmlInlineTagPattern;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.translationAutolinkTagPattern;
            int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Boolean bool3 = this.spaceInLinkUrl;
            int iHashCode5 = (iHashCode4 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
            Boolean bool4 = this.parseJekyllMacroInLinkUrl;
            int iHashCode6 = (iHashCode5 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
            String str3 = this.itemPrefixChars;
            int iHashCode7 = (iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Boolean bool5 = this.listsItemMarkerSpace;
            int iHashCode8 = (iHashCode7 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
            Boolean bool6 = this.listsOrderedItemDotOnly;
            int iHashCode9 = (iHashCode8 + (bool6 != null ? bool6.hashCode() : 0)) * 31;
            Boolean bool7 = this.allowNameSpace;
            return iHashCode9 + (bool7 != null ? bool7.hashCode() : 0);
        }

        public PatternTypeFlags withAllowNameSpace() {
            return new PatternTypeFlags(null, null, null, null, null, null, null, null, null, this.allowNameSpace);
        }

        public PatternTypeFlags withHtmlTranslator() {
            return new PatternTypeFlags(this.intellijDummyIdentifier, this.htmlForTranslator, this.translationHtmlInlineTagPattern, this.translationAutolinkTagPattern, null, null, null, null, null, null);
        }

        public PatternTypeFlags withItemPrefixChars() {
            return new PatternTypeFlags(null, null, null, null, null, null, this.itemPrefixChars, this.listsItemMarkerSpace, this.listsOrderedItemDotOnly, null);
        }

        public PatternTypeFlags withJekyllMacroInLinkUrl() {
            return new PatternTypeFlags(this.intellijDummyIdentifier, null, null, null, null, this.parseJekyllMacroInLinkUrl, null, null, null, null);
        }

        public PatternTypeFlags withJekyllMacroSpaceInLinkUrl() {
            return new PatternTypeFlags(this.intellijDummyIdentifier, null, null, null, this.spaceInLinkUrl, this.parseJekyllMacroInLinkUrl, null, null, null, null);
        }

        public PatternTypeFlags(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str, @Nullable String str2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable String str3, @Nullable Boolean bool5, @Nullable Boolean bool6, @Nullable Boolean bool7) {
            this.intellijDummyIdentifier = bool;
            this.htmlForTranslator = bool2;
            this.translationHtmlInlineTagPattern = str;
            this.translationAutolinkTagPattern = str2;
            this.spaceInLinkUrl = bool3;
            this.parseJekyllMacroInLinkUrl = bool4;
            this.itemPrefixChars = str3;
            this.listsItemMarkerSpace = bool5;
            this.listsOrderedItemDotOnly = bool6;
            this.allowNameSpace = bool7;
        }
    }
}
