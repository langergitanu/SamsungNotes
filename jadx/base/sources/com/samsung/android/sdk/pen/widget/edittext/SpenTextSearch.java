package com.samsung.android.sdk.pen.widget.edittext;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0002\b\u000b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J>\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eJB\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u0018J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006#"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch;", "", "<init>", "()V", "search", "", "originText", "", "searchText", "measureWidths", "", "out", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch$SearchInfo;", "Lkotlin/collections/ArrayList;", "searchTextWithPattern", "", "searchPattern", "Ljava/util/regex/Pattern;", "createSearchHightlightPattern", "searchString", "isSurrogate", "", "charcode", "", "isIndianChar", "isThaiChar", "isKhmerChar", "isMyanmarChar", "isLaoChar", "isCombinedCode", "c", "isHalant", "SearchInfo", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenTextSearch.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenTextSearch.kt\ncom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,199:1\n107#2:200\n79#2,22:201\n107#2:223\n79#2,22:224\n*S KotlinDebug\n*F\n+ 1 SpenTextSearch.kt\ncom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch\n*L\n39#1:200\n39#1:201,22\n131#1:223\n131#1:224,22\n*E\n"})
public final class SpenTextSearch {

    @NotNull
    private static final String TAG = "SpenTextSearch";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/widget/edittext/SpenTextSearch$SearchInfo;", "", "start", "", "end", "<init>", "(II)V", "getStart", "()I", "setStart", "(I)V", "getEnd", "setEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SearchInfo {
        private int end;
        private int start;

        public SearchInfo(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setEnd(int i) {
            this.end = i;
        }

        public final void setStart(int i) {
            this.start = i;
        }
    }

    private final Pattern createSearchHightlightPattern(String searchString) {
        if (TextUtils.isEmpty(searchString)) {
            return null;
        }
        int length = searchString.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) searchString.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String strReplace = new Regex(" ").replace(searchString.subSequence(i, length + 1).toString(), "");
        boolean z3 = strReplace.length() != 1;
        Pattern patternCompile = Pattern.compile("[$*()+|<>?{}\\[\\]\\{\\}\\^\\\\\\.]");
        StringBuilder sb = new StringBuilder(strReplace);
        for (int length2 = strReplace.length() - 1; -1 < length2; length2--) {
            if (patternCompile.matcher(strReplace.subSequence(length2, length2 + 1)).find()) {
                sb.insert(length2, "\\");
            }
            if (z3 && !Character.isLowSurrogate(strReplace.charAt(length2)) && length2 != 0) {
                sb.insert(length2, "[\\s]{0,}");
            }
        }
        return Pattern.compile(sb.toString(), 2);
    }

    private final boolean isHalant(char charcode) {
        return charcode == 2381 || charcode == 2509 || charcode == 2637 || charcode == 2765 || charcode == 3021 || charcode == 3149 || charcode == 3277 || charcode == 3405 || charcode == 3551 || charcode == 2893;
    }

    private final boolean isIndianChar(char charcode) {
        return 2304 <= charcode && charcode < 3583;
    }

    private final boolean isKhmerChar(char charcode) {
        return 6016 <= charcode && charcode < 6138;
    }

    private final boolean isLaoChar(char charcode) {
        if (3713 > charcode || charcode >= 3806) {
            return 57345 <= charcode && charcode < 57369;
        }
        return true;
    }

    private final boolean isMyanmarChar(char charcode) {
        return 4096 <= charcode && charcode < 4248;
    }

    private final boolean isSurrogate(char charcode) {
        return (charcode & 64512) == 55296;
    }

    private final boolean isThaiChar(char charcode) {
        return 3585 <= charcode && charcode < 3675;
    }

    private final void searchTextWithPattern(Pattern searchPattern, String searchText, String originText, float[] measureWidths, ArrayList<SearchInfo> out) {
        if (searchPattern == null) {
            Log.e(TAG, "searchTextWithPattern is null");
            return;
        }
        try {
            boolean z = true;
            int length = searchText.length() - 1;
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            while (i2 <= length) {
                boolean z3 = Intrinsics.compare((int) searchText.charAt(!z2 ? i2 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i2++;
                } else {
                    z2 = true;
                }
            }
            char[] charArray = new Regex(" ").replace(searchText.subSequence(i2, length + 1).toString(), "").toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "this as java.lang.String).toCharArray()");
            char[] charArray2 = originText.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray2, "this as java.lang.String).toCharArray()");
            int length2 = charArray2.length;
            int length3 = charArray.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length3) {
                    z = false;
                    i4 = 0;
                    break;
                } else if (isCombinedCode(charArray[i4])) {
                    break;
                } else {
                    i4++;
                }
            }
            Matcher matcher = searchPattern.matcher(originText);
            while (matcher.find()) {
                if (z) {
                    String strGroup = matcher.group();
                    Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                    char[] charArray3 = strGroup.toCharArray();
                    Intrinsics.checkNotNullExpressionValue(charArray3, "this as java.lang.String).toCharArray()");
                    if (i4 >= charArray3.length) {
                        Log.e(TAG, "highlightMessage:: combine index greater than length.");
                    } else {
                        int i5 = i4;
                        while (i5 < matcher.end() && i5 < charArray3.length && !isCombinedCode(charArray3[i5])) {
                            i5++;
                        }
                        if (i5 >= charArray3.length) {
                            Log.e(TAG, "highlightMessage:: current combine index is greater than length.");
                        } else if (i5 >= matcher.end()) {
                            Log.e(TAG, "highlightMessage:: it is not combined.");
                        } else {
                            int iStart = matcher.start();
                            if (isIndianChar(charArray3[i5])) {
                                while (iStart > i && isHalant(charArray2[iStart - 1])) {
                                    iStart -= 2;
                                }
                                if (iStart < i) {
                                    Log.e(TAG, "highlightMessage:: pre pos halant is smaller than min.");
                                    iStart = matcher.start();
                                }
                            } else {
                                while (iStart > i && measureWidths[iStart] == 0.0f) {
                                    iStart--;
                                }
                            }
                            int iEnd = matcher.end();
                            while (iEnd < length2 && (measureWidths[iEnd] == 0.0f || isHalant(charArray2[iEnd - 1]))) {
                                iEnd++;
                            }
                            int i6 = iEnd - 1;
                            out.add(new SearchInfo(iStart, iEnd));
                            i = i6;
                        }
                    }
                } else {
                    out.add(new SearchInfo(matcher.start(), matcher.end()));
                }
            }
        } catch (IllegalArgumentException unused) {
            Log.e(TAG, "IllegalArgumentException");
        }
    }

    public final boolean isCombinedCode(char c) {
        return isSurrogate(c) || isIndianChar(c) || isThaiChar(c) || isKhmerChar(c) || isMyanmarChar(c) || isLaoChar(c);
    }

    public final int search(@Nullable String originText, @Nullable String searchText, @NotNull float[] measureWidths, @Nullable ArrayList<SearchInfo> out) {
        Intrinsics.checkNotNullParameter(measureWidths, "measureWidths");
        if (searchText == null || originText == null || out == null) {
            Log.e(TAG, "search is null");
            return 0;
        }
        if (TextUtils.isEmpty(searchText)) {
            Log.e(TAG, "search -" + searchText + " #search text is empty");
            return 0;
        }
        searchTextWithPattern(createSearchHightlightPattern(searchText), searchText, originText, measureWidths, out);
        Log.d(TAG, "search - count:" + out.size());
        return out.size();
    }
}
