package com.vladsch.flexmark.parser.internal;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import io.netty.handler.ssl.ApplicationProtocolNames;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HtmlDeepParser {
    public static final Set<String> BLOCK_TAGS;
    public static final Map<String, Set<String>> OPTIONAL_TAGS;
    private static final HtmlMatch[] PATTERN_MAP;
    public static final Pattern START_PATTERN;
    public static final Set<String> VOID_TAGS;
    private final HashSet<String> myBlockTags;
    private Pattern myClosingPattern;
    private boolean myFirstBlockTag;
    private int myHtmlCount;
    private HtmlMatch myHtmlMatch;
    private final ArrayList<String> myOpenTags;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum HtmlMatch {
        NONE(null, null, false),
        SCRIPT("<(script)(?:\\s|>|$)", "</script>", true),
        STYLE("<(style)(?:\\s|>|$)", "</style>", true),
        OPEN_TAG("<((?:(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?)[A-Za-z][A-Za-z0-9-]*)", "<|/>|\\s/>|>", true),
        CLOSE_TAG("</((?:(?:(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�])(?:[_A-Za-zÀ-ÖØ-öø-˿Ͱ-ͽͿ-\u1fff\u200c-\u200d⁰-\u218fⰀ-\u2fef、-\ud7ff豈-﷏ﷰ-�]|[.0-9·̀-ͯ‿-⁀-])*:)?)[A-Za-z][A-Za-z0-9-]*)>", null, true),
        NON_TAG("<(![A-Z])", ">", false),
        TEMPLATE("<([?])", "\\?>", false),
        COMMENT("<(!--)", "-->", false),
        CDATA("<!\\[(CDATA)\\[", "\\]\\]>", false);

        public final boolean caseInsentive;
        public final Pattern close;
        public final Pattern open;

        HtmlMatch(String str, String str2, boolean z) {
            Pattern patternCompile;
            Pattern patternCompile2 = null;
            if (str == null) {
                patternCompile = null;
            } else {
                patternCompile = Pattern.compile(str, z ? 2 : 0);
            }
            this.open = patternCompile;
            if (str2 != null) {
                patternCompile2 = Pattern.compile(str2, z ? 2 : 0);
            }
            this.close = patternCompile2;
            this.caseInsentive = z;
        }
    }

    static {
        HashSet hashSet = new HashSet();
        BLOCK_TAGS = hashSet;
        HashSet hashSet2 = new HashSet();
        VOID_TAGS = hashSet2;
        hashSet.addAll(Arrays.asList("address|article|aside|base|basefont|blockquote|body|caption|center|col|colgroup|dd|details|dialog|dir|div|dl|dt|fieldset|figcaption|figure|footer|form|frame|frameset|h1|h2|h3|h4|h5|h6|head|header|hr|html|iframe|legend|li|link|main|menu|menuitem|meta|nav|noframes|ol|optgroup|option|p|param|pre|section|source|summary|table|tbody|td|tfoot|th|thead|title|tr|track|ul".split("\\|")));
        hashSet2.addAll(Arrays.asList("area|base|br|col|embed|hr|img|input|keygen|link|menuitem|meta|param|source|track|wbr".split("\\|")));
        HashMap map = new HashMap();
        OPTIONAL_TAGS = map;
        map.put("li", new HashSet(Arrays.asList("li")));
        map.put("dt", new HashSet(Arrays.asList("dt", "dd")));
        map.put("dd", new HashSet(Arrays.asList("dd", "dt")));
        map.put("p", new HashSet(Arrays.asList("address", "article", "aside", "blockquote", "details", "div", "dl", "fieldset", "figcaption", "figure", "footer", "form", "h1", ApplicationProtocolNames.HTTP_2, "h3", "h4", "h5", "h6", "header", "hr", "main", ExternalSettingsProvider.EXTRA_MENU, "nav", "ol", "p", "pre", "section", "table", "ul")));
        map.put("rt", new HashSet(Arrays.asList("rt", "rp")));
        map.put("rp", new HashSet(Arrays.asList("rt", "rp")));
        map.put("optgroup", new HashSet(Arrays.asList("optgroup")));
        map.put("option", new HashSet(Arrays.asList("option", "optgroup")));
        map.put("colgroup", new HashSet(Arrays.asList("colgroup")));
        map.put("thead", new HashSet(Arrays.asList("tbody", "tfoot")));
        map.put("tbody", new HashSet(Arrays.asList("tbody", "tfoot")));
        map.put("tfoot", new HashSet(Arrays.asList("tbody")));
        map.put("tr", new HashSet(Arrays.asList("tr")));
        map.put("td", new HashSet(Arrays.asList("td", "th")));
        map.put("th", new HashSet(Arrays.asList("td", "th")));
        PATTERN_MAP = new HtmlMatch[HtmlMatch.values().length];
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (HtmlMatch htmlMatch : HtmlMatch.values()) {
            if (htmlMatch != HtmlMatch.NONE) {
                if (sb.length() != 0) {
                    sb.append("|");
                }
                if (htmlMatch.caseInsentive) {
                    sb.append("(?i:");
                    sb.append(htmlMatch.open.pattern());
                    sb.append(")");
                } else {
                    sb.append(htmlMatch.open.pattern());
                }
                PATTERN_MAP[i] = htmlMatch;
            }
            i++;
        }
        START_PATTERN = Pattern.compile(sb.toString());
    }

    public HtmlDeepParser() {
        this(Collections.EMPTY_LIST);
    }

    private void openTag(String str) {
        if (!this.myOpenTags.isEmpty()) {
            String str2 = (String) AbstractC1974b.m1313f(1, this.myOpenTags);
            Map<String, Set<String>> map = OPTIONAL_TAGS;
            if (map.containsKey(str2) && map.get(str2).contains(str)) {
                ArrayList<String> arrayList = this.myOpenTags;
                arrayList.set(arrayList.size() - 1, str);
                return;
            }
        }
        this.myOpenTags.add(str);
        this.myFirstBlockTag = this.myBlockTags.contains(str);
    }

    public Pattern getClosingPattern() {
        return this.myClosingPattern;
    }

    public int getHtmlCount() {
        return this.myHtmlCount;
    }

    public HtmlMatch getHtmlMatch() {
        return this.myHtmlMatch;
    }

    public ArrayList<String> getOpenTags() {
        return this.myOpenTags;
    }

    public boolean hadHtml() {
        return this.myHtmlCount > 0 || !isHtmlClosed();
    }

    public boolean haveOpenBlockTag() {
        if (this.myOpenTags.isEmpty()) {
            return false;
        }
        Iterator<String> it = this.myOpenTags.iterator();
        while (it.hasNext()) {
            if (this.myBlockTags.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public boolean haveOpenRawTag() {
        return (this.myClosingPattern == null || this.myHtmlMatch == HtmlMatch.OPEN_TAG) ? false : true;
    }

    public boolean isBlankLineInterruptible() {
        return (this.myOpenTags.isEmpty() && this.myClosingPattern == null) || (this.myHtmlMatch == HtmlMatch.OPEN_TAG && this.myClosingPattern != null && this.myOpenTags.size() == 1);
    }

    public boolean isFirstBlockTag() {
        return this.myFirstBlockTag;
    }

    public boolean isHtmlClosed() {
        return this.myClosingPattern == null && this.myOpenTags.isEmpty();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        r3 = r3.matcher(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (r3.find() != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0029, code lost:
    
        if (r10.myHtmlMatch != com.vladsch.flexmark.parser.internal.HtmlDeepParser.HtmlMatch.OPEN_TAG) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        if (r3.group().equals("<") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r2 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r2 = r10.myOpenTags;
        r2.remove(r2.size() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r14 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r10.myClosingPattern = null;
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
    
        if (r3.group().endsWith("/>") == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        if (r2 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
    
        r14 = r10.myOpenTags;
        r14.remove(r14.size() - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        r14 = r10.myHtmlCount;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        if (r14 != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        r10.myHtmlCount = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006c, code lost:
    
        if (r2 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0074, code lost:
    
        if (com.vladsch.flexmark.parser.internal.HtmlDeepParser.VOID_TAGS.contains(r2) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        openTag(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0079, code lost:
    
        r10.myHtmlCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        r11 = r11.subSequence(r3.end(), r11.length());
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008c, code lost:
    
        r11 = r11.subSequence(r3.end(), r11.length());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void parseHtmlChunk(CharSequence charSequence, boolean z, boolean z2, boolean z3) {
        String str;
        int i = this.myHtmlCount;
        if (i == 0 && this.myHtmlMatch != null) {
            this.myHtmlCount = i + 1;
        }
        loop0: while (true) {
            str = null;
            while (true) {
                if (charSequence.length() == 0) {
                    break loop0;
                }
                Pattern pattern = this.myClosingPattern;
                if (pattern != null) {
                    break;
                }
                Matcher matcher = START_PATTERN.matcher(charSequence);
                if (!matcher.find()) {
                    break loop0;
                }
                CharSequence charSequenceSubSequence = charSequence.subSequence(matcher.end(), charSequence.length());
                int length = PATTERN_MAP.length;
                this.myClosingPattern = null;
                int i2 = 1;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (matcher.group(i2) == null) {
                        i2++;
                    } else {
                        String lowerCase = matcher.group(i2).toLowerCase();
                        HtmlMatch htmlMatch = PATTERN_MAP[i2];
                        int iIndexOf = lowerCase.indexOf(58);
                        if (iIndexOf >= 0) {
                            lowerCase = lowerCase.substring(iIndexOf + 1);
                        }
                        boolean zContains = this.myBlockTags.contains(lowerCase);
                        if ((!z && z2) || matcher.start() <= 0 || charSequence.subSequence(0, matcher.start()).toString().trim().isEmpty()) {
                            HtmlMatch htmlMatch2 = HtmlMatch.OPEN_TAG;
                            if (htmlMatch != htmlMatch2 && htmlMatch != HtmlMatch.CLOSE_TAG) {
                                this.myClosingPattern = htmlMatch.close;
                                this.myHtmlMatch = htmlMatch;
                                this.myHtmlCount++;
                                z3 = false;
                            } else if ((!z && z2) || zContains) {
                                if (htmlMatch == htmlMatch2 && VOID_TAGS.contains(lowerCase)) {
                                    if (!z3) {
                                        this.myHtmlMatch = htmlMatch;
                                        this.myHtmlCount++;
                                        z = false;
                                    }
                                    z = false;
                                    str = lowerCase;
                                } else {
                                    if (htmlMatch != htmlMatch2) {
                                        int size = this.myOpenTags.size();
                                        this.myHtmlMatch = htmlMatch;
                                        this.myHtmlCount++;
                                        int i4 = size;
                                        while (true) {
                                            int i5 = i4 - 1;
                                            if (i4 <= 0) {
                                                break;
                                            }
                                            String str2 = this.myOpenTags.get(i5);
                                            if (!str2.equals(lowerCase)) {
                                                if (!zContains && this.myBlockTags.contains(str2)) {
                                                    break;
                                                } else {
                                                    i4 = i5;
                                                }
                                            } else {
                                                while (true) {
                                                    int i6 = size - 1;
                                                    if (size <= i5) {
                                                        break;
                                                    }
                                                    this.myOpenTags.remove(i5);
                                                    size = i6;
                                                }
                                            }
                                        }
                                    } else {
                                        this.myHtmlMatch = htmlMatch;
                                        this.myClosingPattern = htmlMatch.close;
                                        if (!z3) {
                                            openTag(lowerCase);
                                            int i7 = this.myHtmlCount;
                                            if (i7 != 0) {
                                                this.myHtmlCount = i7 + 1;
                                            }
                                        }
                                        z = false;
                                        str = lowerCase;
                                    }
                                    z = false;
                                }
                            }
                        }
                    }
                }
                charSequence = charSequenceSubSequence;
            }
            this.myClosingPattern = null;
        }
        if (str == null || this.myHtmlMatch != HtmlMatch.OPEN_TAG) {
            return;
        }
        this.myClosingPattern = null;
    }

    public HtmlDeepParser(List<String> list) {
        this.myOpenTags = new ArrayList<>();
        this.myClosingPattern = null;
        this.myHtmlMatch = null;
        this.myHtmlCount = 0;
        this.myFirstBlockTag = false;
        HashSet<String> hashSet = new HashSet<>(BLOCK_TAGS);
        this.myBlockTags = hashSet;
        hashSet.addAll(list);
    }
}
