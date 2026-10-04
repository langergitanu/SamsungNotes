package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator;

import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.SubContent;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class SubheadingComparator extends BaseComparator {
    public static boolean canReplace(String str, String str2) {
        return str.length() < str2.length() && str.length() * 2 >= str2.length();
    }

    private boolean containsSentenceInSubHeader(SubContent subContent, Sentence sentence, String str) {
        if (subContent.getHeaderWordCount() < 2 && subContent.getHeaderLength() > 5) {
            return false;
        }
        if (!str.isEmpty() && subContent.mMatchedSentences.isEmpty() && BaseComparator.contains(subContent.getHeader(), str)) {
            return true;
        }
        return looseContains(subContent.getHeader(), sentence.getText()) && subContent.getHeaderLength() - sentence.getLength() <= 4;
    }

    private boolean containsSubHeaderInSentence(SubContent subContent, Sentence sentence) {
        if (looseContains(sentence.getText(), subContent.getHeader()) && !existsInLineSentences(subContent.getHeader())) {
            if (sentence.getLength() - subContent.getHeaderLength() <= 4 || isParenthesesRemovedSubHeader(subContent, sentence)) {
                return true;
            }
            if (subContent.getHeaderWordCount() <= sentence.getWordCount() && sentence.getWordCount() <= subContent.getHeaderWordCount() + 2 && sentence.getLength() - subContent.getHeaderLength() <= 10) {
                return true;
            }
        }
        return false;
    }

    private boolean isParenthesesRemovedSubHeader(SubContent subContent, Sentence sentence) {
        String header = subContent.getHeader();
        int iIndexOf = sentence.getText().indexOf(header);
        if (iIndexOf < 0) {
            return false;
        }
        String strTrim = sentence.getText().substring(header.length() + iIndexOf).trim();
        return strTrim.startsWith("(") && strTrim.endsWith(")");
    }

    public boolean compare(SubContent subContent, Sentence sentence, String str) {
        if (containsSentenceInSubHeader(subContent, sentence, str)) {
            return true;
        }
        return containsSubHeaderInSentence(subContent, sentence);
    }
}
