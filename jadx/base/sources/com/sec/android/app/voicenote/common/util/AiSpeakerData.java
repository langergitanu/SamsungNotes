package com.sec.android.app.voicenote.common.util;

import androidx.annotation.RequiresApi;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AiSpeakerData {
    public Map<Integer, String> mSpeakerNameMap;

    public AiSpeakerData(Map<Integer, String> map) {
        this.mSpeakerNameMap = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toString$0(StringBuilder sb, Integer num, String str) {
        sb.append("");
        sb.append(num);
        sb.append(" ");
        sb.append(str);
        sb.append(SQLKeyword.COMMA);
    }

    @RequiresApi(api = 24)
    public String toString() {
        StringBuilder sbM1324q = AbstractC1974b.m1324q("AISpeakerData{speakerNameMap=");
        this.mSpeakerNameMap.forEach(new C11697a(0, sbM1324q));
        sbM1324q.append('}');
        return sbM1324q.toString();
    }

    public AiSpeakerData(AiSpeakerData aiSpeakerData) {
        if (aiSpeakerData.mSpeakerNameMap != null) {
            this.mSpeakerNameMap = new HashMap(aiSpeakerData.mSpeakerNameMap);
        }
    }
}
