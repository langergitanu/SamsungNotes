package com.sec.android.app.voicenote.common.util;

import com.samsung.android.support.senl.p148nt.stt.base.filedata.Logger;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DataConverter {
    public static final String TAG = "DataConverter";

    public static ParagraphInfo convertParagraphToVRData(int[] iArr, long[] jArr, long[] jArr2) {
        if (iArr == null || jArr == null || jArr2 == null) {
            return null;
        }
        return new ParagraphInfo(iArr, jArr, jArr2);
    }

    public static AiSpeakerData convertSpeakerToVRData(Map<Integer, String> map) {
        if (map == null) {
            return null;
        }
        return new AiSpeakerData(map);
    }

    public static ArrayList<AISummarySectionData> convertSummaryToVRData(int i, String[] strArr, long[] jArr, ArrayList<String>[] arrayListArr, int i2) {
        if (arrayListArr != null && strArr != null) {
            if (strArr.length == i && jArr.length == i && arrayListArr.length == i) {
                ArrayList<AISummarySectionData> arrayList = new ArrayList<>();
                for (int i4 = 0; i4 < i; i4++) {
                    arrayList.add(new AISummarySectionData(strArr[i4], jArr[i4], arrayListArr[i4], i2));
                }
                return arrayList;
            }
            Logger.m12702e(TAG, "convertToVRData size not equal");
        }
        return null;
    }

    public static ArrayList<TextData> convertToVRData(int i, String[] strArr, long[] jArr, long[] jArr2, int[] iArr) {
        if (strArr == null || jArr == null || jArr2 == null) {
            return new ArrayList<>();
        }
        if (strArr.length != i || jArr.length != i || jArr2.length != i) {
            Logger.m12702e(TAG, "convertToVRData size not equal");
            return null;
        }
        ArrayList<TextData> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < i; i2++) {
            TextData textData = new TextData();
            textData.mText[0] = strArr[i2];
            long j = jArr[i2];
            textData.timeStamp = j;
            textData.duration = jArr2[i2] - j;
            if (iArr != null) {
                textData.speakerId = iArr[i2];
            }
            arrayList.add(textData);
        }
        return arrayList;
    }
}
