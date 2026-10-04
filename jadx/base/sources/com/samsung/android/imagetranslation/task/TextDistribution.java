package com.samsung.android.imagetranslation.task;

import android.graphics.Paint;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.imagetranslation.common.LTTLogger;
import com.samsung.android.imagetranslation.data.BlockData;
import com.samsung.android.imagetranslation.jni.KeyFrameParam;
import com.samsung.android.imagetranslation.jni.SceneText;
import com.samsung.android.imagetranslation.util.SceneTextUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TextDistribution {
    private static final String TAG = "TextDistribution";
    private static final List<String> noSpaceLangCode = new ArrayList(Arrays.asList(LangPackConfigConstants.LANGUAGE_CODE_JA, "zh", "lo", "th"));
    KeyFrameParam keyFrameParam;
    List<String> mTRLResultStr;

    public TextDistribution(KeyFrameParam keyFrameParam, List<String> list) {
        this.keyFrameParam = keyFrameParam;
        this.mTRLResultStr = list;
    }

    private ArrayList<Integer> calcTrsCharIdxBasedOnStrLength(ArrayList<SceneText> arrayList, int i, String str) {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Iterator<SceneText> it = arrayList.iterator();
        int length = 0;
        int length2 = 0;
        while (it.hasNext()) {
            length2 += it.next().getValue().length();
        }
        Iterator<SceneText> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            length += it2.next().getValue().length();
            int iCeil = (int) Math.ceil((((double) length) / ((double) length2)) * ((double) i));
            arrayList2.add(Integer.valueOf(checkWordBreakUsingIndex(iCeil, str) + iCeil));
        }
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "calcTrsCharIdxBasedOnStrLength : tarTRLLength(", ") : ");
        sbM778t.append(arrayList2.toString());
        LTTLogger.m5458d(str2, sbM778t.toString());
        return arrayList2;
    }

    private void charUnitRelativeDistribution(ArrayList<SceneText> arrayList, String str) {
        ArrayList<Integer> arrayListCalcTrsCharIdxBasedOnStrLength = calcTrsCharIdxBasedOnStrLength(arrayList, str.length(), str);
        boolean z = arrayList.size() > 1;
        for (int i = 0; i < arrayList.size(); i++) {
            if (i == 0) {
                arrayList.get(i).setTrsValue(getCharsFromString(str, 0, arrayListCalcTrsCharIdxBasedOnStrLength.get(i).intValue(), z));
            } else {
                arrayList.get(i).setTrsValue(getCharsFromString(str, arrayListCalcTrsCharIdxBasedOnStrLength.get(i - 1).intValue(), arrayListCalcTrsCharIdxBasedOnStrLength.get(i).intValue(), z));
            }
        }
    }

    private void distributeTrsStrToLines(ArrayList<SceneText> arrayList, String str) {
        charUnitRelativeDistribution(arrayList, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00f2, code lost:
    
        r2 = r12;
        r3 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean distributeTrsStrToLinesWithSpace(ArrayList<SceneText> arrayList, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        LTTLogger.m5458d(TAG, "distributeTrsStrToLinesWithSpace");
        String[] strArrSplit = str.replace("\n", "").split(" ");
        int length = strArrSplit.length;
        int size = arrayList.size();
        Iterator<SceneText> it = arrayList.iterator();
        SceneText next = it.next();
        int length2 = 0;
        for (SceneText sceneText : arrayList) {
            sceneText.setTrsValue("");
            length2 += sceneText.getValue().length();
        }
        int length3 = strArrSplit.length;
        int i = 0;
        while (true) {
            if (i >= length3) {
                z = true;
                z2 = false;
                break;
            }
            String str2 = strArrSplit[i];
            float length4 = str2.length() / r0.length();
            z = true;
            float length5 = next.getTrsValue().length() / r0.length();
            float length6 = next.getValue().length() / length2;
            int i2 = length3;
            if (length4 == 1.0d) {
                next.setTrsValue(next.getTrsValue() + " " + str2);
                z4 = true;
                z3 = true;
                z2 = false;
                break;
            }
            float f = length4 + length5;
            if (f <= length6) {
                next.setTrsValue(next.getTrsValue() + " " + str2);
            } else {
                float f4 = length6 * 0.5f;
                if (f >= f4 || size > length) {
                    z2 = false;
                    if (!it.hasNext()) {
                        next.setTrsValue(next.getTrsValue() + " " + str2);
                        if (!str2.equals(strArrSplit[strArrSplit.length - 1])) {
                            break;
                        }
                    } else {
                        next = it.next();
                        next.setTrsValue(str2);
                    }
                } else {
                    int iRound = Math.round((f4 - length5) * str2.length());
                    StringBuilder sb = new StringBuilder();
                    sb.append(next.getTrsValue());
                    sb.append(" ");
                    z2 = false;
                    sb.append(str2.substring(0, iRound));
                    next.setTrsValue(sb.toString());
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    next.setTrsValue(str2.substring(iRound));
                }
            }
            i++;
            length3 = i2;
        }
        z3 = z;
        z4 = z2;
        Iterator<SceneText> it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                z5 = z3;
                break;
            }
            SceneText next2 = it2.next();
            float length7 = next2.getTrsValue().length() / r0.length();
            float length8 = next2.getValue().length() / length2;
            if (!z4 && length7 > ((double) length8) * 2.5d) {
                z5 = z2;
                break;
            }
            if (next2.getTrsValue().equals("")) {
                next2.setTrsValue("\u3000");
            }
        }
        if (!z5) {
            Iterator<SceneText> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                it3.next().setTrsValue(null);
            }
        }
        return z5;
    }

    private boolean fitTokensForGivenFontSize(SceneText sceneText, String[] strArr, int i, int i2, Paint paint, ArrayList<String> arrayList) {
        String str;
        String[] strArr2 = strArr;
        int i4 = i;
        String str2 = isLangWithoutSpaceDelimiter(this.keyFrameParam.getDestLanguage()) ? "" : " ";
        int iMin = Math.min((int) (((double) i4) * 0.075d * 2.0d), 30);
        LTTLogger.m5458d(TAG, "Left padding: " + iMin);
        double d = (double) i2;
        int i5 = (int) (0.1d * d);
        arrayList.clear();
        double d2 = 0.0d;
        String strM757C = "";
        int textHeight = 0;
        int i6 = 1;
        int i7 = 0;
        while (true) {
            String str3 = strM757C;
            if (i7 >= strArr2.length) {
                double d3 = d2;
                if (!str3.equals("")) {
                    LTTLogger.m5458d(TAG, "Current Line width: " + SceneTextUtil.getTextWidth(str3, paint));
                    arrayList.add(str3);
                }
                String str4 = TAG;
                LTTLogger.m5458d(str4, "TOTAL line generated: " + i6);
                int maxTextSize = SceneTextUtil.getMaxTextSize(arrayList, paint);
                LTTLogger.m5458d(str4, "Updated Margin: " + Math.min(maxTextSize / 2, i5));
                double d4 = d - d3;
                double d5 = d4 / ((double) (i6 + 1));
                LTTLogger.m5458d(str4, "Updated Margin: totalHeightLeft - " + d4);
                LTTLogger.m5458d(str4, "Updated Margin: spacingBetweenLine - " + d5);
                if (i6 > 1 && d5 < ((double) maxTextSize) / 3.0d) {
                    return false;
                }
                if (i6 == 1 && d4 < ((double) maxTextSize) / 3.0d) {
                    return false;
                }
                sceneText.setMarginY(d5);
                return true;
            }
            String str5 = strArr2[i7];
            if (str5.equals("\n")) {
                arrayList.add(strM757C);
                i6++;
                int textHeight2 = SceneTextUtil.getTextHeight(strM757C, paint);
                d2 += (double) textHeight2;
                textHeight = textHeight2;
                str = str2;
                strM757C = "";
            } else {
                strM757C = strM757C.equals("") ? str5 : AbstractC0541b.m757C(strM757C, str2, str5);
                str = str2;
                if (SceneTextUtil.getTextWidth(strM757C, paint) + iMin < i4) {
                    textHeight = SceneTextUtil.getTextHeight(strM757C, paint);
                    if (i7 == strArr2.length - 1) {
                        d2 += (double) textHeight;
                        LTTLogger.m5458d(TAG, "Total Height: " + d2);
                    }
                } else {
                    if (!str3.equals("")) {
                        arrayList.add(str3);
                    }
                    d2 += (double) textHeight;
                    if (SceneTextUtil.getTextWidth(str5, paint) + iMin > i4) {
                        return false;
                    }
                    int textHeight3 = SceneTextUtil.getTextHeight(str5, paint);
                    if (i7 == strArr2.length - 1) {
                        d2 += (double) textHeight3;
                        LTTLogger.m5458d(TAG, "Total Height: " + d2);
                    }
                    i6++;
                    textHeight = textHeight3;
                    strM757C = str5;
                }
            }
            i7++;
            strArr2 = strArr;
            i4 = i;
            str2 = str;
        }
    }

    private String getCharsFromString(String str, int i, int i2, boolean z) {
        if (!z && i2 - i < 2) {
            return " ";
        }
        String strSubstring = str.substring(i, i2);
        return (strSubstring.length() == 1 && strSubstring.equals(" ")) ? "\u3000" : strSubstring;
    }

    private boolean isLangWithoutSpaceDelimiter(String str) {
        return noSpaceLangCode.contains(str);
    }

    private boolean isSingleLine(ArrayList<SceneText> arrayList) {
        return arrayList.size() == 1;
    }

    public boolean LineBreakDistribution(String str, SceneText sceneText) {
        String str2 = TAG;
        LTTLogger.m5458d(str2, "LineBreakDistribution" + str);
        List listAsList = Arrays.asList(str.split("\n"));
        LTTLogger.m5458d(str2, "After split trl lines count = " + listAsList.size());
        int i = 0;
        if (listAsList.size() == sceneText.getComponents().size()) {
            Iterator<SceneText> it = sceneText.getComponents().iterator();
            while (it.hasNext()) {
                it.next().setTrsValue((String) listAsList.get(i));
                i++;
            }
            return true;
        }
        LTTLogger.m5458d(str2, "LineBreakDistribution" + listAsList.size() + " != " + sceneText.getComponents().size());
        return false;
    }

    public int checkWordBreakUsingIndex(int i, String str) {
        StringBuilder sb = null;
        for (String str2 : str.split(" ")) {
            if (sb == null) {
                sb = new StringBuilder(str2);
            } else {
                sb.append(' ');
                sb.append(str2);
            }
            if (sb.length() > i) {
                int length = sb.length() - i;
                return str2.length() - length > length ? length : -(str2.length() - length);
            }
        }
        return 0;
    }

    public int countTRLReqElements() {
        return this.keyFrameParam.getTrlResult().size();
    }

    public int countTRLResElements() {
        return this.mTRLResultStr.size();
    }

    public boolean distribute() {
        if (isInvalidTRLResult()) {
            return false;
        }
        processTRLUnitParagraph();
        distributeTRLResultsToLines();
        return true;
    }

    public void distributeTRLResultsBasedOnBlockSpace(String str, int i, int i2, SceneText sceneText) {
        String[] strArrSplit;
        int i4 = i2;
        LTTLogger.m5458d(TAG, "distributeTRLResultsBasedOnBlockSpace");
        String strReplaceAll = str.replaceAll("\n", " \n ");
        ArrayList arrayList = new ArrayList();
        for (float f = 0.5f; f <= i4; f += 0.5f) {
            arrayList.add(Float.valueOf(f));
        }
        if (isLangWithoutSpaceDelimiter(this.keyFrameParam.getDestLanguage())) {
            strReplaceAll = strReplaceAll.replaceAll(" ", "");
            int length = strReplaceAll.length();
            String[] strArr = new String[length];
            for (int i5 = 0; i5 < length; i5++) {
                strArr[i5] = strReplaceAll.charAt(i5) + "";
            }
            strArrSplit = strArr;
        } else {
            strArrSplit = strReplaceAll.trim().split(" ");
        }
        LTTLogger.m5458d(TAG, "trsStr = [" + strReplaceAll + "]");
        int length2 = strArrSplit.length;
        for (int i6 = 0; i6 < length2; i6++) {
            String str2 = strArrSplit[i6];
            LTTLogger.m5458d(TAG, "token = [" + str2 + "]");
        }
        int length3 = strArrSplit.length;
        String str3 = TAG;
        int i7 = i;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(length3, i7, "Token Num: ", " blockWidth: ", " blockHeight: ");
        sbM1173s.append(i4);
        LTTLogger.m5458d(str3, sbM1173s.toString());
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size() - 1;
        Paint paint = new Paint();
        int i8 = size;
        float fFloatValue = ((Float) arrayList.get(size)).floatValue();
        int i9 = 0;
        while (i8 > i9) {
            int iM7d = AbstractC0000a.m7d(i8, i9, 2, i9);
            float fFloatValue2 = ((Float) arrayList.get(iM7d)).floatValue();
            String str4 = TAG;
            LTTLogger.m5458d(str4, "Checking for font Size of: " + fFloatValue2);
            paint.setTextSize(fFloatValue2);
            if (fitTokensForGivenFontSize(sceneText, strArrSplit, i7, i4, paint, arrayList2)) {
                LTTLogger.m5458d(str4, "Current best Fit size: " + fFloatValue2);
                i9 = iM7d + 1;
                fFloatValue = fFloatValue2;
            } else {
                i8 = iM7d - 1;
            }
            i7 = i;
            i4 = i2;
        }
        String str5 = TAG;
        LTTLogger.m5458d(str5, "Best fit found for size: " + fFloatValue);
        sceneText.setFontSize(fFloatValue);
        paint.setTextSize(fFloatValue);
        fitTokensForGivenFontSize(sceneText, strArrSplit, i, i2, paint, arrayList2);
        LTTLogger.m5458d(str5, "Generated following lines:");
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            LTTLogger.m5458d(TAG, it.next());
        }
        sceneText.setSplitTRSLines(arrayList2);
    }

    public void distributeTRLResultsToLines() {
        if (this.keyFrameParam.getBlockCount() != this.mTRLResultStr.size()) {
            LTTLogger.m5459e(TAG, "distributeTRLResultsToLineBasedOnSpace : Error! Block(" + this.keyFrameParam.getBlockCount() + ") != Trs elements" + this.mTRLResultStr.size() + ")");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SceneText sceneText : this.keyFrameParam.getSceneTexts()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(sceneText.getComponents());
            arrayList.add(new BlockData(arrayList2, sceneText));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            BlockData blockData = (BlockData) arrayList.get(i);
            String str = this.mTRLResultStr.get(i);
            if (blockData.getParagraph().isParagraphRendering()) {
                distributeTRLResultsBasedOnBlockSpace(str, blockData.getBlockWidth(), blockData.getBlockHeight(), blockData.getParagraph());
            } else if (!LineBreakDistribution(str, blockData.getParagraph())) {
                distributeTrsResultsBasedOnLinesSpace(str, blockData);
            }
        }
    }

    public void distributeTrsResultsBasedOnLinesSpace(String str, BlockData blockData) {
        if (blockData.getLinesInBlock() == null) {
            LTTLogger.m5459e(TAG, "Got a null block");
        } else if (isSingleLine(blockData.getLinesInBlock())) {
            blockData.getLinesInBlock().get(0).setTrsValue(str);
        } else {
            if (distributeTrsStrToLinesWithSpace(blockData.getLinesInBlock(), str)) {
                return;
            }
            distributeTrsStrToLines(blockData.getLinesInBlock(), str);
        }
    }

    public boolean isInvalidTRLResult() {
        int iCountTRLReqElements = countTRLReqElements();
        int iCountTRLResElements = countTRLResElements();
        boolean z = iCountTRLResElements != iCountTRLReqElements;
        if (z) {
            LTTLogger.m5459e(TAG, "ERROR : TRL Req Element Count=" + iCountTRLReqElements + " TRL Res Element Count=" + iCountTRLResElements);
        }
        return z;
    }

    public void processTRLUnitLine() {
        Iterator<SceneText> it = this.keyFrameParam.getSceneTexts().iterator();
        int i = 0;
        while (it.hasNext()) {
            Iterator<SceneText> it2 = it.next().getComponents().iterator();
            while (it2.hasNext()) {
                it2.next().setTrsValue(this.mTRLResultStr.get(i));
                i++;
            }
        }
    }

    public void processTRLUnitParagraph() {
        Iterator<SceneText> it = this.keyFrameParam.getSceneTexts().iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next().setTrsValue(this.mTRLResultStr.get(i));
            i++;
        }
    }
}
