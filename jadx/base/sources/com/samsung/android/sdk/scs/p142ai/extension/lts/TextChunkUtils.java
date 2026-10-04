package com.samsung.android.sdk.scs.p142ai.extension.lts;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
final class TextChunkUtils {
    private static final String TAG = "TextChunkUtils";

    private TextChunkUtils() {
    }

    public static void printLogs(String str, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String str2 = list.get(i);
            Log.i(TAG, str + " " + i + " (" + str2.length() + "): " + str2);
        }
    }

    public static List<String> splitWordsIntoChunks(String[] strArr, int i) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (str.length() + sb.length() <= i) {
                sb.append(str);
                sb.append(" ");
            } else {
                if (sb.length() > 0) {
                    arrayList.add(sb.toString().trim());
                    sb.setLength(0);
                }
                sb.append(str);
                sb.append(" ");
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString().trim());
        }
        return arrayList;
    }
}
