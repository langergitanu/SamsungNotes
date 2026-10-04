package com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor;

import android.util.Pair;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator.BaseComparator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator.DetailComparator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator.SubheadingComparator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.comparator.TitleComparator;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.DetailSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.MatchableSentence;
import com.samsung.android.support.senl.p148nt.model.assist.llm.postprocessor.components.SubContent;
import com.samsung.android.support.senl.p148nt.model.assist.llm.strings.Sentence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StructuredAutoFormatPostProcessor extends AbsStructuredFormatPostProcessor {
    private static String QUOTES = "\\\"";
    private static final String TAG = "Ai$StructuredAutoFormatPostProcessor";
    private final int ERROR;
    private final int EXECUTE_POSTPROCESSOR;
    private final int RETURN_ORIGINAL_JSON;
    private final DetailComparator mDetailComparator;
    private String mInputText;
    private final List<String> mLineSentences;
    private final List<MatchableSentence> mSourceSentences;
    private final SubheadingComparator mSubheadingComparator;

    public StructuredAutoFormatPostProcessor(String str, String str2) {
        super(str);
        this.mSourceSentences = new ArrayList();
        this.mSubheadingComparator = new SubheadingComparator();
        this.mDetailComparator = new DetailComparator();
        this.EXECUTE_POSTPROCESSOR = 0;
        this.RETURN_ORIGINAL_JSON = 1;
        this.ERROR = 2;
        this.mInputText = str2;
        this.mLineSentences = new ArrayList(Arrays.asList(str.split("\\n")));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02a8  */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v29 */
    /* JADX WARN: Type inference failed for: r6v37 */
    /* JADX WARN: Type inference failed for: r6v38 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void addMissingSentences(Collection<MatchableSentence> collection) {
        MatchableSentence next;
        Iterator<MatchableSentence> it;
        int i;
        int i2;
        int i4;
        int i5;
        char c;
        int i6;
        String str;
        ?? r6;
        ?? r62;
        int i7 = 1;
        int size = this.mSourceSentences.size() - 1;
        int size2 = this.mResult.mSubContents.size();
        Iterator<MatchableSentence> it2 = collection.iterator();
        while (true) {
            int i8 = 0;
            while (it2.hasNext()) {
                next = it2.next();
                char c2 = 3;
                if (next.getIndex() < 3 && this.mResult.mTitle.getText().contains(next.getText())) {
                    Logger.m8697d(TAG, "addMissingSentences, skip!, contained in title: " + next.getLength());
                    next.setMask(i7);
                    this.mResult.mTitle.mMatchedSentences.add(next);
                    i8 = i7;
                } else if (next.getIndex() == 0 || (next.getIndex() < 3 && i8 != 0)) {
                    i2 = size;
                    i4 = i7;
                    i = size2;
                    it = it2;
                    String header = this.mResult.mSubContents.get(0).getHeader();
                    if (!BaseComparator.contains(next.getText(), header) || !SubheadingComparator.canReplace(header, next.getText())) {
                        ArrayList arrayList = new ArrayList();
                        DetailSentence detailSentence = new DetailSentence(next);
                        detailSentence.getMatchedSentences().add(next);
                        arrayList.add(detailSentence);
                        arrayList.addAll(this.mResult.mSubContents.get(0).mDetails);
                        this.mResult.mSubContents.get(0).mDetails = arrayList;
                        Logger.m8697d(TAG, "addMissingSentences, add at the first: " + next.getLength());
                        i8 = 0;
                        i7 = i4;
                        size = i2;
                        size2 = i;
                        it2 = it;
                    }
                } else {
                    if (next.getIndex() == size) {
                        int size3 = this.mResult.mSubContents.size() - i7;
                        ArrayList arrayList2 = new ArrayList(this.mResult.mSubContents.get(size3).mDetails);
                        DetailSentence detailSentence2 = new DetailSentence(next);
                        detailSentence2.getMatchedSentences().add(next);
                        arrayList2.add(detailSentence2);
                        this.mResult.mSubContents.get(size3).mDetails = arrayList2;
                        Logger.m8697d(TAG, "addMissingSentences, add at the last: " + next.getLength());
                        i2 = size;
                        i4 = i7;
                        i = size2;
                        it = it2;
                        i5 = i8;
                    } else {
                        int iIndexOf = this.mSourceSentences.indexOf(next);
                        if (iIndexOf < 0) {
                            Logger.m8697d(TAG, "addMissingSentences, sentence does not exist: " + next.getLength());
                        } else {
                            int i9 = iIndexOf - 1;
                            int i10 = 0;
                            while (true) {
                                if (i9 < 0) {
                                    i2 = size;
                                    i4 = i7;
                                    i = size2;
                                    it = it2;
                                    i5 = i8;
                                    break;
                                }
                                MatchableSentence matchableSentence = this.mSourceSentences.get(i9);
                                if (matchableSentence.getIndex() > next.getIndex()) {
                                    i2 = size;
                                    i4 = i7;
                                    i = size2;
                                    it = it2;
                                    i5 = i8;
                                    c = c2;
                                } else {
                                    Iterator<SubContent> it3 = this.mResult.mSubContents.iterator();
                                    while (true) {
                                        if (!it3.hasNext()) {
                                            i2 = size;
                                            i4 = i7;
                                            i = size2;
                                            it = it2;
                                            i5 = i8;
                                            c = c2;
                                            break;
                                        }
                                        SubContent next2 = it3.next();
                                        i4 = i7;
                                        ArrayList arrayList3 = new ArrayList();
                                        if (isPrevIndex(matchableSentence.getIndex(), next2.mMatchedSentences)) {
                                            DetailSentence detailSentence3 = new DetailSentence(next);
                                            detailSentence3.getMatchedSentences().add(next);
                                            arrayList3.add(detailSentence3);
                                            Logger.m8697d(TAG, "addMissingSentences, add [" + next.getLength() + "] after subheading [" + next2.getHeaderLength() + "]");
                                            i10 = i4;
                                        }
                                        int size4 = next2.mDetails.size() - 1;
                                        int iIndexOf2 = this.mResult.mSubContents.indexOf(next2) + 1;
                                        i2 = size;
                                        String header2 = iIndexOf2 < size2 ? this.mResult.mSubContents.get(iIndexOf2).getHeader() : "";
                                        i = size2;
                                        Iterator<DetailSentence> it4 = next2.mDetails.iterator();
                                        while (it4.hasNext()) {
                                            Iterator<DetailSentence> it5 = it4;
                                            DetailSentence next3 = it4.next();
                                            arrayList3.add(next3);
                                            Iterator<MatchableSentence> it6 = it2;
                                            if (i10 == 0) {
                                                i6 = i8;
                                                if (isPrevIndex(matchableSentence.getIndex(), next3.getMatchedSentences())) {
                                                    if (header2.isEmpty() || size4 != next2.mDetails.indexOf(next3)) {
                                                        str = header2;
                                                        r6 = 0;
                                                        if (r6 == 0) {
                                                            DetailSentence detailSentence4 = new DetailSentence(next);
                                                            detailSentence4.getMatchedSentences().add(next);
                                                            next.setMask(1000);
                                                            arrayList3.add(detailSentence4);
                                                            Logger.m8697d(TAG, "addMissingSentences, add sentence [" + detailSentence4.getLength() + "] after [" + next3.getLength() + "]");
                                                        }
                                                        i10 = i4;
                                                    } else {
                                                        if (BaseComparator.contains(header2, next.getText()) && !BaseComparator.contains(this.mSrcText, header2)) {
                                                            this.mResult.mSubContents.get(iIndexOf2).mMatchedSentences.add(next);
                                                            Logger.m8697d(TAG, "addMissingSentences, skip! changed to subHeading: " + next.getLength());
                                                            str = header2;
                                                            r6 = i4;
                                                        } else if (BaseComparator.contains(next.getText(), header2)) {
                                                            String[] strArrSplit = header2.split(" ");
                                                            if (SubheadingComparator.canReplace(header2, next.getText())) {
                                                                this.mResult.mSubContents.get(iIndexOf2).setHeader(next.getText());
                                                                next.setMask(11);
                                                                Logger.m8697d(TAG, "addMissingSentences, replace next sub header with: " + next.getLength());
                                                                str = header2;
                                                                r62 = i4;
                                                            } else {
                                                                ?? r63 = (strArrSplit.length > 2 || next.getLength() > 3) ? 0 : i4;
                                                                str = header2;
                                                                StringBuilder sbM3200j = AbstractC4539a.m3200j("addMissingSentences, skip: ", ", len: ", r63);
                                                                sbM3200j.append(strArrSplit.length);
                                                                sbM3200j.append("/");
                                                                sbM3200j.append(next.getLength());
                                                                Logger.m8697d(TAG, sbM3200j.toString());
                                                                r62 = r63;
                                                            }
                                                            this.mResult.mSubContents.get(iIndexOf2).mMatchedSentences.add(next);
                                                            r6 = r62;
                                                        }
                                                        if (r6 == 0) {
                                                        }
                                                        i10 = i4;
                                                    }
                                                }
                                                it2 = it6;
                                                it4 = it5;
                                                i8 = i6;
                                                header2 = str;
                                            } else {
                                                i6 = i8;
                                            }
                                            str = header2;
                                            it2 = it6;
                                            it4 = it5;
                                            i8 = i6;
                                            header2 = str;
                                        }
                                        it = it2;
                                        i5 = i8;
                                        c = 3;
                                        if (i10 != 0) {
                                            next2.mDetails = arrayList3;
                                            break;
                                        }
                                        i7 = i4;
                                        c2 = 3;
                                        size = i2;
                                        size2 = i;
                                        it2 = it;
                                        i8 = i5;
                                    }
                                    if (i10 != 0) {
                                        break;
                                    }
                                }
                                i9--;
                                i7 = i4;
                                c2 = c;
                                size = i2;
                                size2 = i;
                                it2 = it;
                                i8 = i5;
                            }
                            if (i10 == 0) {
                                Logger.m8703w(TAG, "addMissingSentences, fail to add: " + next.getLength());
                            }
                        }
                    }
                    i8 = i5;
                    i7 = i4;
                    size = i2;
                    size2 = i;
                    it2 = it;
                }
            }
            return;
            this.mResult.mSubContents.get(0).setHeader(next.getText());
            next.setMask(11);
            Logger.m8697d(TAG, "addMissingSentences, replace first subheading with first miss: " + next.getLength());
            i7 = i4;
            size = i2;
            size2 = i;
            it2 = it;
        }
    }

    private boolean checkExcessiveMissingSentences(int i) {
        return (this.mSourceSentences.size() >= 50 && Float.compare((float) i, ((float) this.mSourceSentences.size()) * 0.3f) >= 0) || Float.compare((float) i, ((float) this.mSourceSentences.size()) * 0.7f) >= 0;
    }

    private boolean executePostProcess() {
        parseServerResult();
        mergeSameSubheadings();
        int iHandleMissingSentences = handleMissingSentences();
        if (iHandleMissingSentences == 2) {
            return false;
        }
        if (iHandleMissingSentences == 1) {
            return true;
        }
        removeDetailsSameWithSubHeading();
        removeEmptySubheadings();
        removeUnexpectedCharsOfSentences();
        return true;
    }

    private boolean existsSameTextInMatchedSentences(DetailSentence detailSentence, SubContent subContent) {
        Iterator<MatchableSentence> it = subContent.mMatchedSentences.iterator();
        while (it.hasNext()) {
            if (it.next().getText().equals(detailSentence.getText())) {
                return true;
            }
        }
        return false;
    }

    private Pair<String, String> getFirstNWordsAndLastNWords(String str) {
        String string;
        String string2;
        int iMin;
        String[] strArrSplit = str.split(" ");
        if (strArrSplit.length <= 1 || (iMin = Math.min((int) Math.ceil(strArrSplit.length * 0.4f), 8)) <= 1) {
            string = "";
            string2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(strArrSplit[0]);
            for (int i = 1; i < iMin; i++) {
                sb.append(' ');
                sb.append(strArrSplit[i]);
            }
            string = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            for (int length = strArrSplit.length - iMin; length < strArrSplit.length; length++) {
                sb2.append(' ');
                sb2.append(strArrSplit[length]);
            }
            string2 = sb2.toString();
        }
        return new Pair<>(string, string2);
    }

    private Collection<MatchableSentence> getMissingSentences() {
        boolean z = false;
        for (MatchableSentence matchableSentence : this.mSourceSentences) {
            if (z || !TitleComparator.compare(this.mResult.mTitle, matchableSentence)) {
                Pair<String, String> firstNWordsAndLastNWords = getFirstNWordsAndLastNWords(matchableSentence.getText());
                String str = (String) firstNWordsAndLastNWords.first;
                String str2 = (String) firstNWordsAndLastNWords.second;
                Iterator<SubContent> it = this.mResult.mSubContents.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SubContent next = it.next();
                        if (!this.mSubheadingComparator.compare(next, matchableSentence, str)) {
                            Iterator<DetailSentence> it2 = next.mDetails.iterator();
                            while (it2.hasNext()) {
                                DetailComparator.Result resultCompare = this.mDetailComparator.compare(it2.next(), matchableSentence, str, str2);
                                if (resultCompare != DetailComparator.Result.CONTINUE && (resultCompare == DetailComparator.Result.BREAK || matchableSentence.getMask() > 0)) {
                                    break;
                                }
                            }
                            if (matchableSentence.getMask() > 0) {
                                break;
                            }
                        } else {
                            if (SubheadingComparator.canReplace(next.getHeader(), matchableSentence.getText())) {
                                Logger.m8697d(TAG, "getMissingSentences, replace subheading: [" + next.getHeaderLength() + "] with [" + matchableSentence.getLength() + "]");
                                next.setHeader(matchableSentence.getText());
                                matchableSentence.setMask(11);
                            } else {
                                Logger.m8697d(TAG, "getMissingSentences, exists in subheading: [" + next.getHeaderLength() + "] has [" + matchableSentence.getLength() + "]");
                                matchableSentence.setMask(10);
                            }
                            next.mMatchedSentences.add(matchableSentence);
                        }
                    }
                }
            } else {
                Logger.m8697d(TAG, "getMissingSentences, replace title: [" + this.mResult.mTitle.getLength() + "] with [" + matchableSentence.getLength() + "]");
                this.mResult.mTitle.setText(matchableSentence.getText());
                matchableSentence.setMask(2);
                this.mResult.mTitle.mMatchedSentences.add(matchableSentence);
                z = true;
            }
        }
        return returnMissingSentences();
    }

    private int handleMissingSentences() {
        if (this.mResult.mSubContents.isEmpty()) {
            return 2;
        }
        initSrcSentenceMap();
        initComparators();
        Collection<MatchableSentence> missingSentences = getMissingSentences();
        Logger.m8702i(TAG, "handleMissingSentences, sentences/missing: " + this.mSourceSentences.size() + "/" + missingSentences.size());
        if (checkExcessiveMissingSentences(missingSentences.size())) {
            return (this.mSourceSentences.size() >= 3 || this.mSourceSentences.size() != missingSentences.size()) ? 2 : 1;
        }
        addMissingSentences(missingSentences);
        removeDuplicatedDetails();
        removeUnmatchedSentences();
        Logger.m8702i(TAG, "handleMissingSentences, end");
        return 0;
    }

    private void initComparators() {
        ArrayList arrayList = new ArrayList();
        Iterator<SubContent> it = this.mResult.mSubContents.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().mDetails);
        }
        this.mSubheadingComparator.init(this.mSourceSentences, this.mLineSentences);
        this.mDetailComparator.init(this.mSourceSentences, this.mLineSentences);
        this.mDetailComparator.initDetailList(arrayList);
    }

    private void initSrcSentenceMap() {
        for (Sentence sentence : splitSrcTextByNewLineAndDot()) {
            if (!new UnicodeUtils.Builder(sentence.getText()).replace(UnicodeUtils.NBSP, " ").remove("\u200b").trim().getText().isEmpty()) {
                this.mSourceSentences.add(new MatchableSentence(sentence));
            }
        }
    }

    private boolean isPrevIndex(int i, List<MatchableSentence> list) {
        Iterator<MatchableSentence> it = list.iterator();
        while (it.hasNext()) {
            if (i == it.next().getIndex()) {
                return true;
            }
        }
        return false;
    }

    private void mergeSameSubheadings() {
        Logger.m8697d(TAG, "mergeSameSubheadings, before size: " + this.mResult.mSubContents.size());
        if (this.mResult.mSubContents.size() < 2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int size = this.mResult.mSubContents.size() - 1; size >= 1; size--) {
            SubContent subContent = this.mResult.mSubContents.get(size);
            SubContent subContent2 = this.mResult.mSubContents.get(size - 1);
            if (subContent.getHeader().equals(subContent2.getHeader())) {
                subContent2.mDetails.addAll(subContent.mDetails);
                arrayList.add(subContent);
            }
        }
        this.mResult.mSubContents.removeAll(arrayList);
        Logger.m8697d(TAG, "mergeSameSubheadings, after size: " + this.mResult.mSubContents.size());
    }

    private int parseSentence(List<DetailSentence> list, String[] strArr, int i) {
        String str;
        int iIndexOf;
        if (strArr[i].indexOf(93) >= 0) {
            Logger.m8697d(TAG, "parseSentence# empty");
            return i;
        }
        while (true) {
            i++;
            if (i >= strArr.length || ((iIndexOf = (str = strArr[i]).indexOf(93)) > -1 && str.indexOf(34, iIndexOf) == -1)) {
                break;
            }
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                int iIndexOf2 = strTrim.indexOf(QUOTES) + 1;
                int iLastIndexOf = strTrim.lastIndexOf(QUOTES);
                if (iIndexOf2 > iLastIndexOf) {
                    iLastIndexOf = strTrim.length();
                }
                list.add(new DetailSentence(-1, strTrim.substring(iIndexOf2, iLastIndexOf)));
            }
        }
        return i;
    }

    private void parseServerResult() {
        String[] strArrSplitLine = splitLine();
        CharSequence charSequence = QUOTES + "title" + QUOTES;
        CharSequence charSequence2 = QUOTES + "subheading" + QUOTES;
        CharSequence charSequence3 = QUOTES + "details" + QUOTES;
        ArrayList arrayList = new ArrayList();
        int sentence = 0;
        boolean z = false;
        boolean z2 = false;
        String valueFromKeyValue = "";
        while (sentence < strArrSplitLine.length) {
            String str = strArrSplitLine[sentence];
            if (str.contains(charSequence)) {
                this.mResult.mTitle.setText(parseValueFromKeyValue(str));
            } else if (str.contains(charSequence2)) {
                valueFromKeyValue = parseValueFromKeyValue(str);
                z = true;
            } else if (str.contains(charSequence3)) {
                sentence = parseSentence(arrayList, strArrSplitLine, sentence);
                z2 = true;
            }
            if (z && z2) {
                SubContent subContent = new SubContent();
                subContent.setHeader(valueFromKeyValue);
                subContent.mDetails.addAll(arrayList);
                this.mResult.mSubContents.add(subContent);
                arrayList.clear();
                z = false;
                z2 = false;
                valueFromKeyValue = "";
            }
            sentence++;
        }
    }

    private String parseValueFromKeyValue(String str) {
        return parseValueFromValue(str, str.indexOf(58));
    }

    private String parseValueFromValue(String str, int i) {
        int length = QUOTES.length() + str.indexOf(QUOTES, i);
        int iIndexOf = str.indexOf(QUOTES, length);
        if (length > iIndexOf) {
            iIndexOf = str.length();
        }
        return str.substring(length, iIndexOf);
    }

    private void preProcess() {
        StringBuilder sb = new StringBuilder(this.mInputText.length());
        int i = 0;
        Integer numValueOf = null;
        for (int i2 = 1; i2 < this.mInputText.length(); i2++) {
            char cCharAt = this.mInputText.charAt(i2 - 1);
            if (this.mInputText.charAt(i2) == '\"') {
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i2);
                    sb.append(this.mInputText.substring(i, i2));
                } else if (cCharAt != '\\') {
                    sb.append(StringUtils.convertUnexpectedChars(this.mInputText.substring(numValueOf.intValue(), i2)));
                    numValueOf = null;
                }
                i = i2;
            }
        }
        if (i != this.mInputText.length() - 1) {
            sb.append(StringUtils.convertUnexpectedChars(this.mInputText.substring(i)));
        }
        this.mInputText = sb.toString();
    }

    private void removeDetailsSameWithSubHeading() {
        int size = this.mResult.mSubContents.size() - 1;
        int i = 0;
        for (SubContent subContent : this.mResult.mSubContents) {
            if (subContent.mDetails.size() > 1) {
                ArrayList arrayList = new ArrayList();
                for (DetailSentence detailSentence : subContent.mDetails) {
                    if (subContent.getHeader().equals(detailSentence.getText().replace("\\\"", "\""))) {
                        Logger.m8697d(TAG, "removeDetailsSameWithSubHeading (current subheading), detail: " + detailSentence.getLength());
                    } else {
                        arrayList.add(detailSentence);
                    }
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(subContent.mDetails.get(0));
                } else if (arrayList.size() > 1 && i < size && this.mResult.mSubContents.get(i + 1).getHeader().replace("\\\"", "\"").equals(((DetailSentence) AbstractC1974b.m1313f(1, arrayList)).getText())) {
                    Logger.m8697d(TAG, "removeDetailsSameWithSubHeading (next subheading), detail");
                    arrayList.remove(arrayList.size() - 1);
                }
                subContent.mDetails = arrayList;
                i++;
            }
        }
    }

    private void removeDuplicatedDetails() {
        setExistsInSourceSentences();
        for (SubContent subContent : this.mResult.mSubContents) {
            int[] iArr = {0};
            for (int size = subContent.mDetails.size(); removeNextDuplicatedDetails(subContent, iArr, size); size = subContent.mDetails.size()) {
            }
        }
    }

    private void removeEmptySubheadings() {
        ArrayList arrayList = new ArrayList();
        int size = this.mResult.mSubContents.size();
        for (int i = 0; i < size; i++) {
            SubContent subContent = this.mResult.mSubContents.get(i);
            if (!subContent.mDetails.isEmpty()) {
                arrayList.add(subContent);
            } else if (subContent.mMatchedSentences.isEmpty()) {
                Logger.m8697d(TAG, "removeEmptySubheadings, remove: " + subContent.getHeaderLength());
            } else {
                DetailSentence detailSentence = new DetailSentence(-1, subContent.getHeader());
                detailSentence.getMatchedSentences().addAll(subContent.mMatchedSentences);
                if (i == 0) {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(detailSentence);
                    if (size > 1) {
                        SubContent subContent2 = this.mResult.mSubContents.get(1);
                        arrayList2.addAll(subContent2.mDetails);
                        subContent2.mDetails = arrayList2;
                        Logger.m8697d(TAG, "removeEmptySubheadings, change subheading to detail in next subheading: " + subContent.getHeaderLength());
                    } else {
                        subContent.mDetails = arrayList2;
                        Logger.m8697d(TAG, "removeEmptySubheadings, add dummy detail: " + subContent.getHeaderLength());
                    }
                } else {
                    this.mResult.mSubContents.get(i - 1).mDetails.add(detailSentence);
                    Logger.m8697d(TAG, "removeEmptySubheadings, change subheading to detail in prev subheading: " + subContent.getHeaderLength());
                }
            }
        }
        this.mResult.mSubContents = arrayList;
    }

    private boolean removeNextDuplicatedDetails(SubContent subContent, int[] iArr, int i) {
        HashSet hashSet = new HashSet();
        int i2 = iArr[0];
        while (true) {
            if (i2 >= i) {
                break;
            }
            DetailSentence detailSentence = subContent.mDetails.get(i2);
            i2++;
            for (int i4 = i2; i4 < i; i4++) {
                DetailSentence detailSentence2 = subContent.mDetails.get(i4);
                if (detailSentence.getText().contains(detailSentence2.getText()) && ((detailSentence2.getExistsInSourceText() == -1 && detailSentence.getExistsInSourceText() == 1) || (detailSentence2.getExistsInSourceText() == 1 && detailSentence.getExistsInSourceText() == -1 && !this.mDetailComparator.existsInLineSentences(detailSentence.getText())))) {
                    detailSentence.getMatchedSentences().addAll(detailSentence2.getMatchedSentences());
                    Logger.m8697d(TAG, "removeNextDuplicatedDetails: [" + detailSentence2.getLength() + "]");
                    hashSet.add(detailSentence2);
                }
            }
            if (!hashSet.isEmpty()) {
                subContent.mDetails.removeAll(hashSet);
                iArr[0] = i2;
                break;
            }
        }
        return !hashSet.isEmpty();
    }

    private void removeUnexpectedCharsOfSentences() {
        for (SubContent subContent : this.mResult.mSubContents) {
            String strTrim = subContent.getHeader().trim();
            if (strTrim.substring(0, Math.min(strTrim.length(), 5)).matches("^\\d+\\.\\D.*")) {
                Logger.m8697d(TAG, "removeHeadersOfSentences, remove head of header: [" + strTrim.length() + "]");
                subContent.setHeader(strTrim.substring(strTrim.indexOf(Extension.DOT) + 1).trim());
            }
            for (DetailSentence detailSentence : subContent.mDetails) {
                String strTrim2 = detailSentence.getText().trim();
                if (strTrim2.startsWith("•")) {
                    Logger.m8697d(TAG, "removeHeadersOfSentences(" + strTrim2.charAt(0) + "): [" + detailSentence.getLength() + "]");
                    strTrim2 = strTrim2.substring(1).trim();
                }
                detailSentence.setText(UnicodeUtils.removeUnicode(strTrim2, UnicodeUtils.REPLACEMENT));
            }
        }
    }

    private void removeUnmatchedSentences() {
        for (SubContent subContent : this.mResult.mSubContents) {
            HashSet hashSet = new HashSet();
            for (DetailSentence detailSentence : subContent.mDetails) {
                if (detailSentence.getLength() == 0) {
                    hashSet.add(detailSentence);
                    Logger.m8697d(TAG, "removeUnmatchedSentences, empty detail");
                } else if (detailSentence.getMatchedSentences().isEmpty() && (detailSentence.getWordCount() >= 2 || existsSameTextInMatchedSentences(detailSentence, subContent) || (!this.mDetailComparator.existsInSrcSentences(detailSentence.getText()) && !this.mDetailComparator.existsInLineSentences(detailSentence.getText())))) {
                    hashSet.add(detailSentence);
                    Logger.m8697d(TAG, "removeUnmatchedSentences, detail: " + detailSentence.getLength());
                }
            }
            subContent.mDetails.removeAll(hashSet);
        }
    }

    private List<MatchableSentence> returnMissingSentences() {
        ArrayList arrayList = new ArrayList();
        for (MatchableSentence matchableSentence : this.mSourceSentences) {
            if (matchableSentence.getMask() == 0) {
                Logger.m8697d(TAG, "returnMissingSentences, missing:[" + matchableSentence.getLength() + "]");
                arrayList.add(matchableSentence);
            }
        }
        return arrayList;
    }

    private void setExistsInSourceSentences() {
        Iterator<SubContent> it = this.mResult.mSubContents.iterator();
        while (it.hasNext()) {
            for (DetailSentence detailSentence : it.next().mDetails) {
                detailSentence.setExistsInSourceText(this.mDetailComparator.existsInSrcSentences(detailSentence.getText()) ? 1 : -1);
            }
        }
    }

    private String[] splitLine() {
        preProcess();
        String[] strArrSplit = this.mInputText.replace("\\n", "\n").split("\n");
        int length = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = strArrSplit[i];
            int iIndexOf = str.indexOf(58);
            if (iIndexOf == -1) {
                i++;
            } else if (!str.substring(0, iIndexOf).contains(QUOTES)) {
                QUOTES = "\"";
                Logger.m8703w(TAG, "parse# quotes is changed");
                return strArrSplit;
            }
        }
        return strArrSplit;
    }

    public String getResult() {
        return !executePostProcess() ? "AUTO_FORMAT_ERROR_MANUAL_FORMATTING_REQUIRED" : applyJsonFormat();
    }
}
