package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator;

import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.MatchableSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.Title;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class TitleComparator extends BaseComparator {
    public static boolean compare(Title title, MatchableSentence matchableSentence) {
        int wordCount = title.getWordCount();
        if (matchableSentence.getIndex() == 0 && BaseComparator.looseEquals(matchableSentence.getText(), title.getText())) {
            return true;
        }
        if (wordCount >= 3 && BaseComparator.contains(matchableSentence.getText(), title.getText())) {
            if (matchableSentence.getIndex() == 0 && matchableSentence.getWordCount() >= wordCount && matchableSentence.getWordCount() <= wordCount + 1) {
                return true;
            }
            String strTrim = matchableSentence.getText().trim();
            if (((strTrim.startsWith("[") && strTrim.endsWith("]")) || (strTrim.startsWith("<") && strTrim.endsWith(">"))) && matchableSentence.getWordCount() >= wordCount && matchableSentence.getWordCount() <= wordCount + 3) {
                return true;
            }
        }
        return false;
    }
}
