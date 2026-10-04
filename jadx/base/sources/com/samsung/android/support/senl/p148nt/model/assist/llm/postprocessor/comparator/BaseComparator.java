package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.MatchableSentence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseComparator {
    final List<MatchableSentence> mSourceSentences = new ArrayList();
    private final List<String> mLineSentences = new ArrayList();

    public static boolean contains(String str, String str2) {
        return replaceNbspRemoveZWS(str).contains(replaceNbspRemoveZWS(str2));
    }

    public static boolean looseEquals(String str, String str2) {
        return removeNbspZwsWhiteSpace(str).equals(removeNbspZwsWhiteSpace(str2));
    }

    private static String removeNbspZwsWhiteSpace(String str) {
        return new UnicodeUtils.Builder(str).remove(UnicodeUtils.NBSP).remove("\u200b").replace(" ", "").getText();
    }

    private static String replaceNbspRemoveZWS(String str) {
        return new UnicodeUtils.Builder(str).replace(UnicodeUtils.NBSP, " ").remove("\u200b").getText();
    }

    public boolean existsInLineSentences(String str) {
        Iterator<String> it = this.mLineSentences.iterator();
        while (it.hasNext()) {
            if (it.next().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsInSrcSentences(String str) {
        Iterator<MatchableSentence> it = this.mSourceSentences.iterator();
        while (it.hasNext()) {
            if (it.next().getText().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void init(@NonNull List<MatchableSentence> list, @NonNull List<String> list2) {
        this.mSourceSentences.addAll(list);
        this.mLineSentences.addAll(list2);
    }

    public boolean looseContains(String str, String str2) {
        return removeNbspZwsWhiteSpace(str).contains(removeNbspZwsWhiteSpace(str2));
    }
}
