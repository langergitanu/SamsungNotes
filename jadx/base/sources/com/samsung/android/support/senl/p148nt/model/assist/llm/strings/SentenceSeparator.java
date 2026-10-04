package com.samsung.android.support.senl.p148nt.model.assist.llm.strings;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SentenceSeparator {
    private static final String[] EXCEPTIONAL_SYNTAX = {"m.in.", "np.", "e.g.", "tys.", "godz.", "Dr.", "Mr.", "Ms.", "Mrs.", "Sr.", "Jr."};
    private static final String HINDI_TAG = "hi-IN";
    private static final String JAPAN_TAG = "ja-JP";
    private static final String REPLACE_STR = "�";
    static final String REPLACE_STR_UNICODE_DOUBLE_QUOTE_END = "�\"";
    static final String REPLACE_STR_UNICODE_DOUBLE_QUOTE_START = "\"�";
    static final HashMap<Character, ReplacementCharacter> sPeriodCharacters;
    private final String mSrcText;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReplacementCharacter {
        public String mNewLine = "�\n";
        public String mSpace;
        public String mTab;

        public ReplacementCharacter(String str) {
            this.mSpace = AbstractC0541b.m773o("�", str, " ");
            this.mTab = AbstractC0541b.m773o("�", str, "\t");
        }
    }

    static {
        HashMap<Character, ReplacementCharacter> map = new HashMap<>();
        sPeriodCharacters = map;
        map.put('.', new ReplacementCharacter(""));
        map.put((char) 12290, new ReplacementCharacter(JAPAN_TAG));
        map.put((char) 2404, new ReplacementCharacter(HINDI_TAG));
    }

    public SentenceSeparator(@NonNull String str) {
        this.mSrcText = str;
    }

    private String addNewLineCharToSplit(String str) {
        String strReplace = str.replace("\r\n", "\n");
        for (Character ch : sPeriodCharacters.keySet()) {
            strReplace = strReplace.replace(ch + "\t", ch + "\n");
            if (ch.charValue() != '.') {
                strReplace = strReplace.replace(ch + " ", ch + "\n");
            }
        }
        int length = strReplace.length();
        int i = length - 1;
        if (i < 2) {
            return strReplace;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = strReplace.charAt(i);
        int i2 = length - 2;
        char cCharAt2 = strReplace.charAt(i2);
        sb.append(cCharAt);
        char c = cCharAt;
        char c2 = cCharAt2;
        char cCharAt3 = ' ';
        while (i2 > 0) {
            cCharAt3 = strReplace.charAt(i2 - 1);
            if (c2 == '.' && c == ' ' && ((cCharAt3 < '0' || cCharAt3 > '9') && cCharAt3 != '\n' && cCharAt3 != '\r' && !isExceptionCaseOfFullStop(strReplace, i2))) {
                sb.replace(0, 0, "\n");
            }
            sb.insert(0, c2);
            i2--;
            c = c2;
            c2 = cCharAt3;
        }
        sb.insert(0, cCharAt3);
        return sb.toString();
    }

    private boolean hasFullStopChar() {
        Iterator<Character> it = sPeriodCharacters.keySet().iterator();
        while (it.hasNext()) {
            char cCharValue = it.next().charValue();
            if (this.mSrcText.contains(cCharValue + "")) {
                return true;
            }
        }
        return false;
    }

    private boolean hasReplacementCharacter(String str) {
        for (ReplacementCharacter replacementCharacter : sPeriodCharacters.values()) {
            if (str.contains(replacementCharacter.mSpace) || str.contains(replacementCharacter.mTab) || str.contains(replacementCharacter.mNewLine)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAbbreviationOfName(String str, int i) {
        char cCharAt;
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            String strSubstring = str.substring(i - 1, i);
            if ((i <= 2 || (cCharAt = str.charAt(i - 2)) == ' ' || cCharAt == '\n') && strSubstring.toUpperCase().equals(strSubstring)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isExceptionCaseOfFullStop(String str, int i) {
        return isExceptionalSyntaxForFullStop(str, i) || isAbbreviationOfName(str, i);
    }

    private static boolean isExceptionalSyntaxForFullStop(String str, int i) {
        for (String str2 : EXCEPTIONAL_SYNTAX) {
            int length = (i - str2.length()) + 1;
            int i2 = i + 1;
            if (length >= 0 && i2 < str.length() && str.substring(length, i2).equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidReplacedResult(String str, String str2, boolean z, int i, char c) {
        if (z && i == 1 && hasReplacementCharacter(str2)) {
            int iIndexOf = str.indexOf(c);
            int iLastIndexOf = str.lastIndexOf(c);
            if (iIndexOf > iLastIndexOf) {
                return false;
            }
            int length = str.length();
            int i2 = iLastIndexOf - iIndexOf;
            if ((length >= 100 && Float.compare(i2, length * 0.3f) >= 0) || ((length >= 50 && Float.compare(i2, length * 0.5f) >= 0) || Float.compare(i2, length * 0.7f) >= 0)) {
                return false;
            }
        }
        return true;
    }

    private static void removeLastChar(@NonNull List<Character> list, Character ch) {
        int iLastIndexOf = list.lastIndexOf(ch);
        if (iLastIndexOf < 0 || iLastIndexOf >= list.size()) {
            return;
        }
        list.remove(iLastIndexOf);
    }

    private String replaceDotsInParenthesesAndQuotations(boolean z, boolean z2) {
        boolean z3;
        int i;
        String strReplace = this.mSrcText.replace("“", REPLACE_STR_UNICODE_DOUBLE_QUOTE_START).replace("”", REPLACE_STR_UNICODE_DOUBLE_QUOTE_END);
        int length = strReplace.length();
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i4 = 0;
        char c = 0;
        while (i2 < length) {
            char cCharAt = strReplace.charAt(i2);
            Character chValueOf = Character.valueOf(cCharAt);
            Iterator<Map.Entry<Character, ReplacementCharacter>> it = sPeriodCharacters.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                Map.Entry<Character, ReplacementCharacter> next = it.next();
                if (chValueOf.equals(next.getKey())) {
                    if (arrayList.isEmpty() || (i = i2 + 1) >= length) {
                        sb.append(chValueOf);
                        z3 = true;
                    } else {
                        char cCharAt2 = strReplace.charAt(i);
                        if (cCharAt2 == ' ') {
                            sb.append(next.getValue().mSpace);
                        } else if (cCharAt2 == '\n') {
                            sb.append(next.getValue().mNewLine);
                        } else {
                            if (cCharAt2 == '\t') {
                                sb.append(next.getValue().mTab);
                            }
                            sb.append(chValueOf);
                            z3 = true;
                        }
                        i2 = i;
                        z3 = true;
                    }
                }
            }
            if (!z3) {
                if (z2 && cCharAt == '\"') {
                    if (arrayList.isEmpty()) {
                        arrayList.add(chValueOf);
                        i4++;
                        c = cCharAt;
                    } else if (((Character) AbstractC1974b.m1313f(1, arrayList)).charValue() == cCharAt) {
                        removeLastChar(arrayList, chValueOf);
                    }
                    sb.append(chValueOf);
                } else {
                    if (z) {
                        if (cCharAt == '(' || cCharAt == '{' || cCharAt == '[') {
                            arrayList.add(chValueOf);
                        } else if (!arrayList.isEmpty()) {
                            if (cCharAt == ')' && ((Character) AbstractC1974b.m1313f(1, arrayList)).charValue() == '(') {
                                removeLastChar(arrayList, Character.valueOf(PropertyUtils.MAPPED_DELIM));
                            } else if (cCharAt == '}' && ((Character) AbstractC1974b.m1313f(1, arrayList)).charValue() == '{') {
                                removeLastChar(arrayList, '{');
                            } else if (cCharAt == ']' && ((Character) AbstractC1974b.m1313f(1, arrayList)).charValue() == '[') {
                                removeLastChar(arrayList, Character.valueOf(PropertyUtils.INDEXED_DELIM));
                            }
                        }
                    }
                    sb.append(chValueOf);
                }
            }
            i2++;
        }
        return (arrayList.isEmpty() && isValidReplacedResult(strReplace, sb.toString(), z2, i4, c)) ? sb.toString() : z ? z2 ? replaceDotsInParenthesesAndQuotations(true, false) : replaceDotsInParenthesesAndQuotations(false, false) : this.mSrcText;
    }

    public List<Sentence> execute() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (String str : addNewLineCharToSplit(hasFullStopChar() ? replaceDotsInParenthesesAndQuotations(true, true) : this.mSrcText).split("\\n")) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                String strReplace = strTrim.replace(REPLACE_STR_UNICODE_DOUBLE_QUOTE_START, "“").replace(REPLACE_STR_UNICODE_DOUBLE_QUOTE_END, "”");
                for (Map.Entry<Character, ReplacementCharacter> entry : sPeriodCharacters.entrySet()) {
                    Character key = entry.getKey();
                    ReplacementCharacter value = entry.getValue();
                    strReplace = strReplace.replace(value.mSpace, key + " ").replace(value.mTab, key + "\t").replace(value.mNewLine, key + "\n");
                }
                arrayList.add(new Sentence(i, strReplace));
                i++;
            }
        }
        return arrayList;
    }
}
