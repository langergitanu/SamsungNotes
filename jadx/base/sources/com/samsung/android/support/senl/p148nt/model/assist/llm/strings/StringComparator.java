package com.samsung.android.support.senl.p148nt.model.assist.llm.strings;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.StringUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import difflib.Delta;
import difflib.DiffUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class StringComparator {
    private static final String TAG = "Ai$Comparator";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CNStyleDiff extends DiffBase {
        public CNStyleDiff(String str, String str2) {
            super(str, str2);
        }

        private String[] convertCharStringArray(String str) {
            String[] strArr = new String[str.length()];
            for (int i = 0; i < str.length(); i++) {
                strArr[i] = String.valueOf(str.charAt(i));
            }
            return strArr;
        }

        @Override // com.samsung.android.support.senl.nt.model.assist.llm.strings.StringComparator.DiffBase
        public void splitWords() {
            this.mOriginWords = convertCharStringArray(this.mOrigin);
            this.mResultWords = convertCharStringArray(this.mResult);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeltaInfo {
        private String mCorrectedWords;

        @VisibleForTesting
        Delta mDelta;
        private String mOriginalWords;
        private int mStart;
        private Delta.TYPE mType;

        /* JADX WARN: Multi-variable type inference failed */
        public DeltaInfo(@NonNull Delta delta, int i) {
            this.mOriginalWords = "";
            this.mCorrectedWords = "";
            this.mDelta = delta;
            this.mType = delta.getType();
            this.mStart = i;
            if (!isInsert()) {
                this.mOriginalWords = combineWords(delta.getOriginal().getLines());
            }
            if (isDelete()) {
                return;
            }
            this.mCorrectedWords = combineWords(delta.getRevised().getLines());
        }

        @NonNull
        private String combineWords(@NonNull List<String> list) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            return sb.toString();
        }

        @NonNull
        public String getCorrectedWords() {
            return this.mCorrectedWords;
        }

        public int getOriginalPosition() {
            return this.mDelta.getOriginal().getPosition();
        }

        public int getOriginalSize() {
            return this.mDelta.getOriginal().size();
        }

        @NonNull
        public String getOriginalWords() {
            return this.mOriginalWords;
        }

        public int getStartPosition() {
            return this.mStart;
        }

        public boolean isChange() {
            return Delta.TYPE.CHANGE.equals(this.mType);
        }

        public boolean isDelete() {
            return Delta.TYPE.DELETE.equals(this.mType);
        }

        public boolean isInsert() {
            return Delta.TYPE.INSERT.equals(this.mType);
        }

        @NonNull
        public String toString() {
            return AbstractC0000a.m13j(new StringBuilder("DeltaInfo{mStart="), this.mStart, '}');
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DiffBase {
        private static final String DOUBLE_NEW_LINE = "\n\n";
        private static final int OPTIMIZE_SIZE = 2;
        private static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
        private static final String WORD_MERGE_PATTERN = "-";
        private static final String WORD_SPLIT_EXCEPT_PATTERN = "[0-9]";
        private static final String WORD_SPLIT_PATTERN = " |\n| |\r?\n|。|，|[0-9]";
        private List<DeltaInfo> mDeltaInfoList;
        private List<Delta> mDeltaList;
        private boolean mHasEffectiveDiff = false;
        String mOrigin;
        String[] mOriginWords;
        String mResult;
        String[] mResultWords;

        public DiffBase(String str, String str2) {
            postProcessRawString(str, str2);
            splitWords();
            diff();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cleanEndOfDeltaInfo() {
            int i = 0;
            for (DeltaInfo deltaInfo : this.mDeltaInfoList) {
                if (deltaInfo.mCorrectedWords.endsWith(" ") && !deltaInfo.mOriginalWords.endsWith(" ")) {
                    int length = deltaInfo.mOriginalWords.length() + deltaInfo.mStart;
                    if (length < this.mOrigin.length() && " ".equals(this.mOrigin.substring(length, length + 1))) {
                        deltaInfo.mCorrectedWords = deltaInfo.mCorrectedWords.substring(0, deltaInfo.mCorrectedWords.length() - 1);
                        i++;
                    }
                }
            }
            AbstractC4539a.m3203m(i, "cleanEndDeltaInfo: ", StringComparator.TAG);
        }

        private ArrayList<String> combineDelimiter(String str) {
            String[] strArrSplit = str.split(String.format(WITH_DELIMITER, WORD_SPLIT_PATTERN));
            ArrayList<String> arrayList = new ArrayList<>();
            int length = strArrSplit.length;
            int i = 0;
            boolean z = false;
            while (i < length) {
                String string = strArrSplit[i];
                if (!string.matches(WORD_SPLIT_PATTERN) || string.matches(WORD_SPLIT_EXCEPT_PATTERN)) {
                    if (string.matches("-")) {
                        StringBuilder sb = new StringBuilder(string);
                        String str2 = "";
                        while (true) {
                            i++;
                            if (i >= length) {
                                break;
                            }
                            str2 = strArrSplit[i];
                            if (!str2.equals(" ")) {
                                break;
                            }
                            sb.append(str2);
                        }
                        sb.append(str2);
                        string = sb.toString();
                    }
                    arrayList.add(string);
                    z = false;
                } else if (z) {
                    int size = arrayList.size() - 1;
                    arrayList.set(size, arrayList.get(size) + string);
                } else {
                    arrayList.add(string);
                    z = true;
                }
                i++;
            }
            return arrayList;
        }

        private void diff() {
            this.mDeltaList = DiffUtils.diff(Arrays.asList(this.mOriginWords), Arrays.asList(this.mResultWords)).getDeltas();
            removeUnexpectedResultDelta();
        }

        private int findMergeTarget(int i, Delta.TYPE type) {
            List<?> lines;
            String strReplaceAll;
            String strReplaceAll2;
            if (!Delta.TYPE.INSERT.equals(type)) {
                if (Delta.TYPE.DELETE.equals(type)) {
                    lines = this.mDeltaInfoList.get(i).mDelta.getOriginal().getLines();
                }
                return i;
            }
            lines = this.mDeltaInfoList.get(i).mDelta.getRevised().getLines();
            ArrayList<String> arrayList = new ArrayList();
            Iterator<?> it = lines.iterator();
            while (it.hasNext()) {
                String strReplaceAll3 = ((String) it.next()).replaceAll("\\s*", "");
                if (!TextUtils.isEmpty(strReplaceAll3)) {
                    arrayList.add(strReplaceAll3);
                }
            }
            int i2 = i - 2;
            if (i2 < 0) {
                i2 = 0;
            }
            for (String str : arrayList) {
                if (!str.matches("\\s+")) {
                    for (int i4 = i - 1; i4 >= i2; i4--) {
                        DeltaInfo deltaInfo = this.mDeltaInfoList.get(i4);
                        if (Delta.TYPE.INSERT.equals(type)) {
                            strReplaceAll2 = deltaInfo.mOriginalWords.replaceAll("\\s*", "");
                            strReplaceAll = deltaInfo.mCorrectedWords.replaceAll("\\s*", "");
                        } else if (Delta.TYPE.DELETE.equals(type)) {
                            strReplaceAll2 = deltaInfo.mCorrectedWords.replaceAll("\\s*", "");
                            strReplaceAll = deltaInfo.mOriginalWords.replaceAll("\\s*", "");
                        } else {
                            strReplaceAll = "";
                            strReplaceAll2 = strReplaceAll;
                        }
                        if (!TextUtils.isEmpty(strReplaceAll2) && ((strReplaceAll2.contains(str) && !strReplaceAll.contains(str)) || StringUtils.isSimilarStrings(strReplaceAll2, str))) {
                            return i4;
                        }
                    }
                }
            }
            return i;
        }

        private boolean isContainNextWord(@NonNull DeltaInfo deltaInfo, @NonNull List<String> list) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().replaceAll("\\s*", ""));
            }
            for (String str : arrayList) {
                String strReplaceAll = deltaInfo.mOriginalWords.replaceAll("\\s*", "");
                if (strReplaceAll.contains(str) || StringUtils.isSimilarStrings(strReplaceAll, str)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void makeDeltaInfoList() {
            this.mDeltaInfoList = new ArrayList(this.mDeltaList.size());
            int length = this.mOrigin.length();
            int length2 = 0;
            int size = 0;
            for (Delta delta : this.mDeltaList) {
                Logger.m8697d(StringComparator.TAG, "diff# " + delta.getType());
                while (size < delta.getOriginal().getPosition()) {
                    length2 += this.mOriginWords[size].length();
                    size++;
                }
                if (length2 > length) {
                    length2 = length;
                }
                DeltaInfo deltaInfo = new DeltaInfo(delta, length2);
                if (!deltaInfo.isChange() || !deltaInfo.mOriginalWords.matches("\\s*") || !deltaInfo.mCorrectedWords.matches("\\s*")) {
                    this.mDeltaInfoList.add(deltaInfo);
                    if (delta.getType() != Delta.TYPE.INSERT) {
                        int length3 = deltaInfo.mOriginalWords.length() + length2;
                        size = delta.getOriginal().size() + size;
                        length2 = length3;
                    }
                    if (!this.mHasEffectiveDiff) {
                        this.mHasEffectiveDiff = !StringUtils.isAllLineFeeds(deltaInfo.mOriginalWords);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void optimizeDeltaInfoList() {
            int i;
            int i2;
            String string;
            int i4;
            int i5;
            int size = this.mDeltaInfoList.size();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            boolean zIsChinaAiFeature = CscFeature.INSTANCE.getInstance().isChinaAiFeature();
            int i6 = 1;
            while (i6 < size) {
                DeltaInfo deltaInfo = this.mDeltaInfoList.get(i6);
                if (arrayList.contains(deltaInfo)) {
                    i = size;
                } else {
                    if (deltaInfo.isInsert() || deltaInfo.isDelete()) {
                        int iFindMergeTarget = findMergeTarget(i6, deltaInfo.mType);
                        boolean z = zIsChinaAiFeature && i6 == size + (-1);
                        if (iFindMergeTarget < i6 && !z) {
                            DeltaInfo deltaInfo2 = this.mDeltaInfoList.get(iFindMergeTarget);
                            StringBuilder sb = new StringBuilder(deltaInfo2.mOriginalWords);
                            StringBuilder sb2 = new StringBuilder(deltaInfo2.mCorrectedWords);
                            arrayList2.clear();
                            int i7 = iFindMergeTarget + 1;
                            while (i7 <= i6) {
                                DeltaInfo deltaInfo3 = this.mDeltaInfoList.get(i7);
                                if (TextUtils.isEmpty(deltaInfo3.mOriginalWords)) {
                                    i2 = size;
                                    string = "";
                                } else {
                                    StringBuilder sb3 = new StringBuilder(" ");
                                    i2 = size;
                                    sb3.append(deltaInfo3.mOriginalWords);
                                    string = sb3.toString();
                                }
                                sb.append(string);
                                sb2.append(' ');
                                sb2.append(deltaInfo3.mCorrectedWords);
                                arrayList2.add(deltaInfo3);
                                i7++;
                                size = i2;
                            }
                            i = size;
                            int length = (deltaInfo.mStart - deltaInfo2.mStart) - (deltaInfo2.isDelete() ? deltaInfo2.mOriginalWords.length() : 0);
                            int iMax = Math.max(sb.length(), sb2.length());
                            if (length <= iMax) {
                                deltaInfo2.mOriginalWords = sb.toString();
                                deltaInfo2.mCorrectedWords = sb2.toString();
                                arrayList.addAll(arrayList2);
                                Logger.m8697d(StringComparator.TAG, "optimizeDeltaInfoList# accepted merge @" + iFindMergeTarget + "/" + deltaInfo2.mType.toString());
                                deltaInfo2.mType = Delta.TYPE.CHANGE;
                            } else {
                                Logger.m8697d(StringComparator.TAG, "optimizeDeltaInfoList# denied merge " + length + " > " + iMax);
                            }
                        }
                    } else if (deltaInfo.isChange()) {
                        DeltaInfo deltaInfo4 = this.mDeltaInfoList.get(i6 - 1);
                        if (deltaInfo.mOriginalWords.startsWith(deltaInfo.mCorrectedWords) && (i4 = i6 + 1) < size) {
                            DeltaInfo deltaInfo5 = this.mDeltaInfoList.get(i4);
                            if (isContainNextWord(deltaInfo, deltaInfo5.mDelta.getRevised().getLines()) && deltaInfo5.isChange() && (i5 = i6 + 2) < size) {
                                DeltaInfo deltaInfo6 = this.mDeltaInfoList.get(i5);
                                if (deltaInfo6.isInsert()) {
                                    deltaInfo5.mCorrectedWords += " " + deltaInfo6.mCorrectedWords;
                                    arrayList.add(deltaInfo6);
                                }
                                deltaInfo.mOriginalWords += " " + deltaInfo5.mOriginalWords;
                                deltaInfo.mCorrectedWords += " " + deltaInfo5.mCorrectedWords;
                                arrayList.add(deltaInfo5);
                            }
                        } else if (deltaInfo4.isChange()) {
                            if ((deltaInfo4.mOriginalWords + deltaInfo.mOriginalWords).equals(deltaInfo4.mCorrectedWords)) {
                                deltaInfo.mOriginalWords = deltaInfo4.mOriginalWords + " " + deltaInfo.mOriginalWords;
                                deltaInfo.mCorrectedWords = deltaInfo4.mCorrectedWords + " " + deltaInfo.mCorrectedWords;
                                deltaInfo.mStart = deltaInfo4.mStart;
                                arrayList.add(deltaInfo4);
                            }
                        }
                    }
                    i = size;
                }
                i6++;
                size = i;
            }
            if (!arrayList.isEmpty()) {
                Logger.m8697d(StringComparator.TAG, "optimizeDeltaInfoList# " + arrayList.size());
            }
            this.mDeltaInfoList.removeAll(arrayList);
        }

        private void postProcessRawString(String str, String str2) {
            char cM4a;
            this.mOrigin = str;
            if (str.charAt(0) != str2.charAt(0) && str2.charAt(0) == ' ') {
                str2 = str2.substring(1);
                Logger.m8697d(StringComparator.TAG, "postProcessRawString# remove first space ");
            }
            if (this.mOrigin.contains("\n\n") || !str2.contains("\n\n")) {
                this.mResult = str2;
            } else {
                this.mResult = str2.replace("\n\n", "\n");
            }
            if (this.mResult.isEmpty() || (cM4a = AbstractC0000a.m4a(1, this.mResult)) != '\n' || cM4a == AbstractC0000a.m4a(1, this.mOrigin)) {
                return;
            }
            this.mResult = AbstractC2322a.m1614d(1, 0, this.mResult);
        }

        private void removeUnexpectedResultDelta() {
            if (this.mDeltaList.isEmpty()) {
                return;
            }
            removeZWSPDelta();
        }

        private void removeZWSPDelta() {
            if (this.mDeltaList.isEmpty()) {
                return;
            }
            Iterator<Delta> it = this.mDeltaList.iterator();
            while (it.hasNext()) {
                Delta next = it.next();
                if (Delta.TYPE.CHANGE.equals(next.getType())) {
                    String str = (String) next.getOriginal().getLines().get(0);
                    String str2 = (String) next.getRevised().getLines().get(0);
                    if (str != null && str2 != null && (str.contains("\u200b") || str2.contains("\u200b"))) {
                        if (UnicodeUtils.removeUnicode(str, "\u200b").equals(UnicodeUtils.removeUnicode(str2, "\u200b"))) {
                            it.remove();
                        }
                    }
                }
            }
        }

        public DeltaInfo getDeltaInfoAt(int i) {
            return this.mDeltaInfoList.get(i);
        }

        public String getOriginal() {
            return this.mOrigin;
        }

        public String[] getOriginalWords() {
            return this.mOriginWords;
        }

        public int getSize() {
            return this.mDeltaInfoList.size();
        }

        public boolean hasEffectiveDiff() {
            return this.mHasEffectiveDiff;
        }

        public boolean isEmpty() {
            List<DeltaInfo> list = this.mDeltaInfoList;
            return list == null || list.isEmpty();
        }

        public void splitWords() {
            ArrayList<String> arrayListCombineDelimiter = combineDelimiter(UnicodeUtils.replaceUnicode(this.mOrigin, UnicodeUtils.NBSP, " "));
            String[] strArr = new String[arrayListCombineDelimiter.size()];
            this.mOriginWords = strArr;
            this.mOriginWords = (String[]) arrayListCombineDelimiter.toArray(strArr);
            ArrayList<String> arrayListCombineDelimiter2 = combineDelimiter(UnicodeUtils.replaceUnicode(this.mResult, UnicodeUtils.NBSP, " "));
            String[] strArr2 = new String[arrayListCombineDelimiter2.size()];
            this.mResultWords = strArr2;
            this.mResultWords = (String[]) arrayListCombineDelimiter2.toArray(strArr2);
            Logger.m8697d(StringComparator.TAG, "makeResult# word size: " + this.mOriginWords.length + " / " + this.mResultWords.length);
        }
    }

    public static DiffBase getDiff(String str, String str2, boolean z) {
        String strReplaceAll = str2.replaceAll(String.valueOf(Constants.OBJECT_REPLACEMENT_CHARACTER), " ");
        DiffBase cNStyleDiff = z ? new CNStyleDiff(str, strReplaceAll) : new DiffBase(str, strReplaceAll);
        if (!cNStyleDiff.mDeltaList.isEmpty()) {
            cNStyleDiff.makeDeltaInfoList();
            cNStyleDiff.optimizeDeltaInfoList();
            cNStyleDiff.cleanEndOfDeltaInfo();
        }
        return cNStyleDiff;
    }
}
