package com.samsung.android.support.senl.p148nt.model.collector.recognition.data;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ResultTextRecognition {
    private final List<TextInfo> mTextInfoList = new ArrayList();
    private final List<TextInfo> mLinkInfoList = new ArrayList();

    public void convertFromResultSpenRecognizer(ResultSpenRecognizer resultSpenRecognizer, String str, int i) {
        if (resultSpenRecognizer != null) {
            int size = resultSpenRecognizer.resultString.size();
            for (int i2 = 0; i2 < size; i2++) {
                TextInfo textInfo = new TextInfo();
                textInfo.originalStr = resultSpenRecognizer.resultOriginalString.get(i2);
                textInfo.str = resultSpenRecognizer.resultString.get(i2);
                textInfo.rect = new RectF(resultSpenRecognizer.resultRectF.get(i2));
                textInfo.contentType = 1;
                textInfo.pageUuid = str;
                textInfo.pageWidth = i;
                textInfo.strokeColor = resultSpenRecognizer.resultStringColor.get(i2).intValue();
                textInfo.recognizedObjects = resultSpenRecognizer.recognizedStrokeIndex.get(i2);
                this.mTextInfoList.add(textInfo);
            }
            int size2 = resultSpenRecognizer.resultLinkString.size();
            for (int i4 = 0; i4 < size2; i4++) {
                TextInfo textInfo2 = new TextInfo();
                textInfo2.originalStr = resultSpenRecognizer.resultOriginalLinkString.get(i4);
                textInfo2.linkStr = resultSpenRecognizer.resultLinkString.get(i4);
                textInfo2.repObjectUuid = resultSpenRecognizer.repObjectUuid.get(i4);
                RectF rectF = resultSpenRecognizer.resultStrokeRectF.get(i4);
                textInfo2.strokeRect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                textInfo2.linkType = resultSpenRecognizer.linkType.get(i4).intValue();
                textInfo2.linkObjects = resultSpenRecognizer.linkStrokeIndex.get(i4);
                RectF rectF2 = resultSpenRecognizer.lastCharRect.get(i4);
                textInfo2.lastCharRect = new Rect((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                RectF rectF3 = resultSpenRecognizer.leftCharRect.get(i4);
                textInfo2.leftCharRect = new Rect((int) rectF3.left, (int) rectF3.top, (int) rectF3.right, (int) rectF3.bottom);
                textInfo2.pageUuid = str;
                textInfo2.pageWidth = i;
                textInfo2.strokeColor = resultSpenRecognizer.resultLinkStringColor.get(i4).intValue();
                this.mLinkInfoList.add(textInfo2);
            }
        }
    }

    @NonNull
    public List<TextInfo> getLinkInfoList() {
        return this.mLinkInfoList;
    }

    @NonNull
    public List<TextInfo> getRecognizedText() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.mTextInfoList);
        arrayList.addAll(this.mLinkInfoList);
        return arrayList;
    }

    @NonNull
    public List<TextInfo> getTextInfoList() {
        return this.mTextInfoList;
    }
}
