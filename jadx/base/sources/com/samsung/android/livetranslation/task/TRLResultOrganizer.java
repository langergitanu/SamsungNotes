package com.samsung.android.livetranslation.task;

import com.samsung.android.livetranslation.text.KeyFrame;
import com.samsung.android.livetranslation.text.SceneText;
import com.samsung.android.livetranslation.util.LTTLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class TRLResultOrganizer {
    private static final String TAG = "TRLResultOrganizer";
    KeyFrame mKeyFrame;
    List<String> mTRLResultStr;

    public TRLResultOrganizer(KeyFrame keyFrame, List<String> list) {
        this.mKeyFrame = keyFrame;
        this.mTRLResultStr = list;
    }

    public boolean LineBreakDistribution(String str, SceneText sceneText) {
        String str2 = TAG;
        LTTLogger.m5581d(str2, "LineBreakDistribution" + str);
        List listAsList = Arrays.asList(str.split("\n"));
        LTTLogger.m5581d(str2, "After split trl lines count = " + listAsList.size());
        int i = 0;
        if (listAsList.size() == sceneText.getComponents().size()) {
            Iterator<SceneText> it = sceneText.getComponents().iterator();
            while (it.hasNext()) {
                it.next().setTrsValue((String) listAsList.get(i));
                i++;
            }
            return true;
        }
        LTTLogger.m5581d(str2, "LineBreakDistribution" + listAsList.size() + " != " + sceneText.getComponents().size());
        return false;
    }

    public abstract int countTRLReqElements();

    public abstract int countTRLResElements();

    public abstract void distributeTRLResultsBasedOnBlockSpace(String str, int i, int i2, SceneText sceneText);

    public void distributeTRLResultsToLines() {
        if (this.mKeyFrame.getGoogleBlockCount() != this.mTRLResultStr.size()) {
            LTTLogger.m5582e(TAG, "distributeTRLResultsToLineBasedOnSpace : Error! Block(" + this.mKeyFrame.getGoogleBlockCount() + ") != Trs elements" + this.mTRLResultStr.size() + ")");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (SceneText sceneText : this.mKeyFrame.getSceneTexts()) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(sceneText.getComponents());
            arrayList.add(new ParaBlockData(arrayList2, sceneText));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            ParaBlockData paraBlockData = (ParaBlockData) arrayList.get(i);
            String str = this.mTRLResultStr.get(i);
            if (paraBlockData.paragraph.isParagraphRendering()) {
                distributeTRLResultsBasedOnBlockSpace(str, paraBlockData.blockWidth, paraBlockData.blockHeight, paraBlockData.paragraph);
            } else if (!LineBreakDistribution(str, paraBlockData.paragraph)) {
                distributeTrsResultsBasedOnLinesSpace(str, paraBlockData);
            }
        }
    }

    public abstract boolean distributeTrsResultsBasedOnLinesSpace(String str, ParaBlockData paraBlockData);

    public boolean isInvalidTRLResult() {
        int iCountTRLReqElements = countTRLReqElements();
        int iCountTRLResElements = countTRLResElements();
        boolean z = iCountTRLResElements != iCountTRLReqElements;
        if (z) {
            LTTLogger.m5582e(TAG, "ERROR : TRL Req Element Count=" + iCountTRLReqElements + " TRL Res Element Count=" + iCountTRLResElements);
        }
        return z;
    }

    public void processTRLUnitLine() {
        Iterator<SceneText> it = this.mKeyFrame.getSceneTexts().iterator();
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
        Iterator<SceneText> it = this.mKeyFrame.getSceneTexts().iterator();
        int i = 0;
        while (it.hasNext()) {
            it.next().setTrsValue(this.mTRLResultStr.get(i));
            i++;
        }
    }

    public abstract boolean setTRLResultToKeyFrame();
}
