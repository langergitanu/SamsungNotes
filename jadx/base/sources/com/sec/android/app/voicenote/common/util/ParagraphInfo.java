package com.sec.android.app.voicenote.common.util;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ParagraphInfo {
    public long[] endTime;
    public int size;
    public int[] speakerId;
    public long[] startTime;

    public ParagraphInfo(int[] iArr, long[] jArr, long[] jArr2) {
        this.speakerId = iArr;
        this.startTime = jArr;
        this.endTime = jArr2;
        this.size = iArr.length;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("ParagraphInfo{paragraphInfo= ");
        sb.append(this.size);
        sb.append(" ");
        for (int i = 0; i < this.size; i++) {
            sb.append(this.speakerId[i]);
            sb.append(" ");
            sb.append(this.startTime[i]);
            sb.append(" ");
            sb.append(this.endTime[i]);
            sb.append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
