package com.sec.android.app.voicenote.common.util;

import androidx.annotation.NonNull;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TextData implements Comparable<TextData>, Serializable, Cloneable {
    private static final long serialVersionUID = -7074386552926531709L;
    public double ConfidenceScore;
    public int dataType;
    public long duration;
    public long elapsedTime;
    public String[] mText;
    public int speakerId;
    public long timeStamp;

    public TextData() {
        this.speakerId = 0;
        this.dataType = 0;
        this.mText = new String[10];
    }

    public Object clone() {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TextData)) {
            return false;
        }
        TextData textData = (TextData) obj;
        return Arrays.equals(this.mText, textData.mText) && this.ConfidenceScore == textData.ConfidenceScore && this.timeStamp == textData.timeStamp && this.elapsedTime == textData.elapsedTime;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull TextData textData) {
        long j = this.timeStamp;
        long j2 = textData.timeStamp;
        if (j > j2) {
            return 1;
        }
        return j < j2 ? -1 : 0;
    }

    public TextData(TextData textData) {
        this.speakerId = 0;
        this.dataType = 0;
        this.speakerId = textData.speakerId;
        int length = textData.mText.length;
        String[] strArr = new String[length];
        this.mText = strArr;
        System.arraycopy(textData.mText, 0, strArr, 0, length);
        this.ConfidenceScore = textData.ConfidenceScore;
        this.timeStamp = textData.timeStamp;
        this.elapsedTime = textData.elapsedTime;
    }
}
