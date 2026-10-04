package com.sec.android.app.voicenote.common.util;

import androidx.annotation.NonNull;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AISummarySectionData implements Comparable<AISummarySectionData> {
    public long duration;
    public String sectionTitle;
    public int style;
    public ArrayList<String> summaryList;
    public long timeStamp;
    public String translatedLanguage;
    public String translatedSectionTitle;
    public List<String> translatedSummaryList;

    public AISummarySectionData(String str, long j, ArrayList<String> arrayList, int i) {
        this.sectionTitle = str;
        this.timeStamp = j;
        this.summaryList = arrayList;
        this.style = i;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("AISummarySectionData{style='");
        sb.append(this.style);
        sb.append("'sectionTitle='");
        sb.append(this.sectionTitle);
        sb.append("', timeStamp=");
        sb.append(this.timeStamp);
        sb.append(", summaryList=");
        ArrayList<String> arrayList = this.summaryList;
        sb.append(arrayList != null ? Arrays.toString(arrayList.toArray()) : "");
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", translatedLanguage='");
        sb.append(this.translatedLanguage);
        sb.append("', translatedSectionTitle='");
        sb.append(this.translatedSectionTitle);
        sb.append("', translatedSummaryList=");
        List<String> list = this.translatedSummaryList;
        return AbstractC1038a.m1213n('}', list != null ? Arrays.toString(list.toArray()) : "", sb);
    }

    @Override // java.lang.Comparable
    public int compareTo(AISummarySectionData aISummarySectionData) {
        long j = aISummarySectionData.timeStamp;
        long j2 = this.timeStamp;
        if (j < j2) {
            return 1;
        }
        return j > j2 ? -1 : 0;
    }
}
