package com.samsung.android.support.senl.p148nt.data.database.core.query.common;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.common.data.SearchSynonym;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StringStemmer;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class QueryUtils {
    private static final String PLACE_HOLDER = "?";
    private static final String TAG = DataLogger.createTag("QueryUtils");
    private static boolean sNoSpacePartialMatching = false;
    private static final String[] NOT_ALLOWED_PROJECTION_COLUMNS = {"SELECT", "FROM", "WHERE", "CREATE TABLE", "ALTER TABLE", "DROP TABLE"};

    private static String appendWildCardCharacters(@NonNull String str) {
        return AbstractC0541b.m773o("%", str, "%");
    }

    private static String createLikeSelection(String str, SearchWord searchWord) {
        int size = searchWord.getSynonyms().size() + (searchWord.isValidStemmedWord() ? 1 : 0);
        if (size <= 0) {
            return str;
        }
        StringBuilder sbM12325j = AbstractC11014a.m12325j("(", str);
        int iM2213d = 0;
        while (iM2213d < size) {
            iM2213d = AbstractC2821a.m2213d(sbM12325j, iM2213d, 1, SQLKeyword.f7405OR, str);
        }
        sbM12325j.append(")");
        return sbM12325j.toString();
    }

    public static String[] createSearchBindArgs(List<SearchWord> list, int i) {
        int size = list.size();
        for (SearchWord searchWord : list) {
            if (searchWord.isValidStemmedWord()) {
                size++;
            }
            size += searchWord.getSynonyms().size();
        }
        String[] strArr = new String[size * i];
        int i2 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (SearchWord searchWord2 : list) {
                int i5 = i2 + 1;
                strArr[i2] = appendWildCardCharacters(searchWord2.getWord());
                if (searchWord2.isValidStemmedWord()) {
                    strArr[i5] = appendWildCardCharacters(searchWord2.getStemmedWord());
                    i5 = i2 + 2;
                }
                Iterator<String> it = searchWord2.getSynonyms().iterator();
                while (it.hasNext()) {
                    strArr[i5] = appendWildCardCharacters(it.next());
                    i5++;
                }
                i2 = i5;
            }
        }
        return strArr;
    }

    @NonNull
    public static String getCommaSeparatedString(Collection<String> collection) {
        return getCommaSeparatedString(collection, true);
    }

    @NonNull
    public static String getLikeClauseColumn(@NonNull String str) {
        return isNoSpacePartialMatchingSupported() ? AbstractC0541b.m773o("REPLACE(", str, ", ' ', '')") : str;
    }

    public static String getLikeSelection(@NonNull String str, List<SearchWord> list) {
        return getLikeSelection(str, list, false);
    }

    public static String getPlaceHolders(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i - 1;
        for (int i4 = 0; i4 < i; i4++) {
            sb.append("?");
            if (i4 < i2) {
                sb.append(',');
            }
        }
        return sb.toString();
    }

    public static List<SearchWord> getSearchKeywords(@NonNull String str, boolean z, boolean z2) {
        String[] strArrSplit = replaceWildcardChar(str, true).split(" ");
        ArrayList arrayList = new ArrayList();
        for (String str2 : strArrSplit) {
            if (!TextUtils.isEmpty(str2)) {
                SearchWord searchWord = new SearchWord(str2);
                if (z) {
                    String strStem = new StringStemmer().stem(str2);
                    int length = strStem.length();
                    int iCharCount = 0;
                    while (true) {
                        if (iCharCount >= length) {
                            break;
                        }
                        int iCodePointAt = strStem.codePointAt(iCharCount);
                        if (!Character.isWhitespace(iCodePointAt)) {
                            searchWord.setStemmedWord(strStem);
                            break;
                        }
                        iCharCount += Character.charCount(iCodePointAt);
                    }
                }
                if (z2) {
                    searchWord.addSynonyms(SearchSynonym.getSynonyms(str2.toLowerCase()));
                }
                arrayList.add(searchWord);
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new SearchWord(""));
        }
        return arrayList;
    }

    public static boolean hasPlaceHolder(@Nullable String str) {
        return !TextUtils.isEmpty(str) && str.contains("?");
    }

    public static boolean hasSubQuery(@NonNull String str) {
        for (String str2 : NOT_ALLOWED_PROJECTION_COLUMNS) {
            if (str.toUpperCase().contains(str2)) {
                DataLogger.m12309w(TAG, "hasSubQuery: " + DataLogger.getEncode(str));
                return true;
            }
        }
        return false;
    }

    public static boolean isAllowedStatement(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return !hasSubQuery(str);
    }

    public static boolean isNoSpacePartialMatchingSupported() {
        return sNoSpacePartialMatching;
    }

    @NonNull
    public static String removeHashSymbol(@NonNull String str) {
        return str.replace(ContentUtils.HASH_SYMBOL, "");
    }

    public static String replaceInvalidCharacters(@NonNull String str) {
        return new UnicodeUtils.Builder(str).remove(UnicodeUtils.RLM).replace(UnicodeUtils.NBSP, " ").getText();
    }

    public static String replaceWildcardChar(@NonNull String str, boolean z) {
        if (str.contains("%")) {
            str = str.replace("%", "�%");
        }
        if (str.contains("_")) {
            str = str.replace("_", "�_");
        }
        if (str.contains("'")) {
            return str.replace("'", UnicodeUtils.REPLACEMENT.concat(z ? "'" : "''"));
        }
        return str;
    }

    @VisibleForTesting
    public static void setNoSpacePartialMatching(boolean z) {
        sNoSpacePartialMatching = z;
    }

    @NonNull
    public static String getCommaSeparatedString(Collection<String> collection, boolean z) {
        String str = z ? "'" : "";
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            AbstractC2821a.m2207B(sb, str, it.next(), str, SQLKeyword.COMMA);
        }
        int iLastIndexOf = sb.lastIndexOf(SQLKeyword.COMMA);
        return iLastIndexOf <= 0 ? "" : sb.substring(0, iLastIndexOf);
    }

    public static String getLikeSelection(@NonNull String str, @NonNull List<SearchWord> list, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (!z) {
            str = getLikeClauseColumn(str);
        }
        String strM1170p = AbstractC0622a.m1170p(str, " LIKE ? ESCAPE '�'", sb);
        StringBuilder sb2 = new StringBuilder("(");
        sb2.append(createLikeSelection(strM1170p, list.get(0)));
        int size = list.size();
        for (int i = 1; i < size; i++) {
            sb2.append(SQLKeyword.AND);
            sb2.append(createLikeSelection(strM1170p, list.get(i)));
        }
        sb2.append(")");
        return sb2.toString();
    }
}
