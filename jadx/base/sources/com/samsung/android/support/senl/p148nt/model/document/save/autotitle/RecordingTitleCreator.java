package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RecordingTitleCreator extends AutoTitleCreator<SpenObjectVoice> {
    private static final String TAG = ModelLogger.createTag("RecordingTitleCreator");

    private boolean hasVoiceRecording(SpenWNote spenWNote) {
        ArrayList<SpenVoiceData> voiceDataList = spenWNote.getVoiceDataList();
        return (voiceDataList == null || voiceDataList.isEmpty()) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        if (!needToCreateTitle(spenWNote) || !hasVoiceRecording(spenWNote)) {
            return null;
        }
        DataLogger.m12307i(TAG, "apply, find voice recording");
        return AutoTitleCreator.CreationPriority.RECORDING.toString();
    }
}
