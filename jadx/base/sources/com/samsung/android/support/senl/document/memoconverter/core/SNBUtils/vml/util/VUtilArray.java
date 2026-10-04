package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VUtilArray {
    public static float[] toFloatArray(ArrayList<Float> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return null;
        }
        float[] fArr = new float[arrayList.size()];
        Iterator<Float> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            fArr[i] = it.next().floatValue();
            i++;
        }
        return fArr;
    }

    public static int[] toIntArray(ArrayList<Integer> arrayList) {
        if (arrayList.size() <= 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        Iterator<Integer> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }
}
