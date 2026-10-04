package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.DetailSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.MatchableSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class DetailComparator extends BaseComparator {
    private static final String TAG = "Ai$DetailComparator";
    private final List<DetailSentence> mDetailList = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Result {
        NONE,
        CONTINUE,
        BREAK
    }

    public static boolean containsFirstNWords(Sentence sentence, Sentence sentence2) {
        String string;
        int iMin = Math.min((int) Math.ceil(sentence2.getWordCount() * 0.4f), 8);
        if (iMin > 1) {
            String[] words = sentence2.getWords();
            StringBuilder sb = new StringBuilder();
            sb.append(words[0]);
            for (int i = 1; i < iMin; i++) {
                sb.append(' ');
                sb.append(words[i]);
            }
            string = sb.toString();
        } else {
            string = "";
        }
        return !string.isEmpty() && BaseComparator.contains(sentence.getText(), string);
    }

    public static boolean containsMostWords(Sentence sentence, Sentence sentence2) {
        if (sentence.getWordCount() >= 10 && sentence2.getWordCount() >= 10) {
            int iMin = Math.min(sentence.getWordCount(), sentence2.getWordCount());
            int i = 0;
            for (int i2 = 0; i2 < iMin; i2++) {
                if (sentence.getWords()[i2].equals(sentence2.getWords()[i2])) {
                    i++;
                }
            }
            if (Float.compare(i / iMin, 0.9f) >= 0) {
                return true;
            }
        }
        return false;
    }

    private String createUnmissedDetailText(DetailSentence detailSentence, MatchableSentence matchableSentence, String str) {
        int iIndexOf = detailSentence.getText().indexOf(str);
        int iIndexOf2 = matchableSentence.getText().indexOf(str);
        return AbstractC0541b.m757C((iIndexOf2 <= 0 || iIndexOf2 <= iIndexOf) ? iIndexOf > 0 ? detailSentence.getText().substring(0, iIndexOf) : "" : matchableSentence.getText().substring(0, iIndexOf2), str, matchableSentence.getLength() - (str.length() + iIndexOf2) > detailSentence.getLength() - (str.length() + iIndexOf) ? matchableSentence.getText().substring(str.length() + iIndexOf2) : detailSentence.getText().substring(str.length() + iIndexOf));
    }

    private String getContainedText(DetailSentence detailSentence, MatchableSentence matchableSentence, String str, String str2) {
        return BaseComparator.contains(detailSentence.getText(), matchableSentence.getText()) ? matchableSentence.getWordCount() == 1 ? detailSentence.getWordCount() == 1 ? matchableSentence.getText() : (existsInSrcSentences(detailSentence.getText()) || existsInLineSentences(matchableSentence.getText())) ? "" : matchableSentence.getText() : matchableSentence.getText() : (str.isEmpty() || !BaseComparator.contains(detailSentence.getText(), str)) ? (str2.isEmpty() || !BaseComparator.contains(detailSentence.getText(), str2) || existsInSrcSentences(detailSentence.getText())) ? "" : str2 : str;
    }

    private boolean isComparableLength(DetailSentence detailSentence, MatchableSentence matchableSentence) {
        return detailSentence.getLength() > 0 && Math.abs(detailSentence.getLength() - matchableSentence.getLength()) <= 100;
    }

    private boolean isMatchableSentence(List<MatchableSentence> list, MatchableSentence matchableSentence) {
        for (MatchableSentence matchableSentence2 : list) {
            if (matchableSentence2.getText().contains(matchableSentence.getText()) && matchableSentence2.getLength() > matchableSentence.getLength() && existsInLineSentences(matchableSentence.getText())) {
                return false;
            }
        }
        return true;
    }

    private boolean isNonInclusive(String str) {
        Iterator<MatchableSentence> it = this.mSourceSentences.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getText().equals(str)) {
                i++;
            }
        }
        int i2 = 0;
        int i4 = i;
        for (DetailSentence detailSentence : this.mDetailList) {
            if (detailSentence.getText().equals(str)) {
                i2++;
                if (detailSentence.existsInMatchedSentences(str)) {
                    i4--;
                }
            }
        }
        return i == i2 && i4 > 0;
    }

    public static boolean isSourceSentenceContainedInDetail(Sentence sentence, Sentence sentence2) {
        if (sentence.getText().contains(sentence2.getText()) || sentence.getWordCount() <= 5) {
            return true;
        }
        float f = sentence.getWordCount() >= 12 ? 0.3f : sentence.getWordCount() >= 10 ? 0.5f : 0.7f;
        ArrayList arrayList = new ArrayList(Arrays.asList(sentence.getWords()));
        ArrayList arrayList2 = new ArrayList();
        for (String str : sentence2.getWords()) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((String) it.next()).contains(str)) {
                    arrayList2.add(str);
                    arrayList.remove(str);
                    break;
                }
            }
        }
        return Float.compare(((float) arrayList2.size()) / ((float) sentence.getWordCount()), f) >= 0;
    }

    public Result compare(DetailSentence detailSentence, MatchableSentence matchableSentence, String str, String str2) {
        if (!isComparable(detailSentence, matchableSentence)) {
            return Result.CONTINUE;
        }
        if (detailSentence.getText().equals(matchableSentence.getText())) {
            Logger.m8697d(TAG, "getMissingSentences, equals: [" + detailSentence.getLength() + "] and [" + matchableSentence.getLength() + "]");
            matchableSentence.setMask(100);
            detailSentence.getMatchedSentences().add(matchableSentence);
        } else if (detailSentence.getLength() > matchableSentence.getLength()) {
            String containedText = getContainedText(detailSentence, matchableSentence, str, str2);
            if (!TextUtils.isEmpty(new UnicodeUtils.Builder(containedText).replace(UnicodeUtils.NBSP, " ").remove("\u200b").trim().getText()) && isSourceSentenceContainedInDetail(detailSentence, matchableSentence)) {
                String strCreateUnmissedDetailText = createUnmissedDetailText(detailSentence, matchableSentence, containedText);
                if (strCreateUnmissedDetailText.contains(detailSentence.getText()) && strCreateUnmissedDetailText.length() > detailSentence.getLength()) {
                    Logger.m8697d(TAG, "getMissingSentences, apply new detail: [" + detailSentence.getLength() + "] -> [" + strCreateUnmissedDetailText.length() + "]");
                    detailSentence.setText(strCreateUnmissedDetailText);
                    matchableSentence.setMask(101);
                } else {
                    if (isNonInclusive(matchableSentence.getText())) {
                        return Result.CONTINUE;
                    }
                    Logger.m8697d(TAG, "getMissingSentences, #exists in detail: [" + detailSentence.getLength() + "] contains [" + matchableSentence.getLength() + "]");
                    matchableSentence.setMask(100);
                }
                detailSentence.getMatchedSentences().add(matchableSentence);
                return Result.BREAK;
            }
        } else if (isDetailContainedInSourceSentence(matchableSentence, detailSentence)) {
            if (matchableSentence.getLength() > detailSentence.getLength()) {
                if (!detailSentence.existsInMatchedSentences(detailSentence.getText())) {
                    Logger.m8697d(TAG, "getMissingSentences, replace detail: [" + detailSentence.getLength() + "] with [" + matchableSentence.getLength() + "]");
                    detailSentence.setText(matchableSentence.getText());
                    matchableSentence.setMask(101);
                    detailSentence.getMatchedSentences().add(matchableSentence);
                }
            } else {
                if (isNonInclusive(matchableSentence.getText())) {
                    return Result.CONTINUE;
                }
                Logger.m8697d(TAG, "getMissingSentences, ##exists in detail: [" + detailSentence.getLength() + "] contains [" + matchableSentence.getLength() + "]");
                matchableSentence.setMask(100);
                detailSentence.getMatchedSentences().add(matchableSentence);
            }
        }
        return Result.NONE;
    }

    public void initDetailList(@NonNull List<DetailSentence> list) {
        this.mDetailList.addAll(list);
    }

    public boolean isComparable(DetailSentence detailSentence, MatchableSentence matchableSentence) {
        return isComparableLength(detailSentence, matchableSentence) && !detailSentence.existsInMatchedSentences(matchableSentence.getText()) && isMatchableSentence(detailSentence.getMatchedSentences(), matchableSentence);
    }

    public boolean isDetailContainedInSourceSentence(Sentence sentence, Sentence sentence2) {
        boolean zContains;
        if (sentence2.getWordCount() >= 3 || !existsInSrcSentences(sentence2.getText())) {
            zContains = BaseComparator.contains(sentence.getText(), sentence2.getText());
            if (!zContains && !existsInSrcSentences(sentence2.getText())) {
                zContains = containsFirstNWords(sentence, sentence2);
            }
        } else {
            zContains = false;
        }
        return zContains || containsMostWords(sentence, sentence2);
    }
}
