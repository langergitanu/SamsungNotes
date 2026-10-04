package com.samsung.android.livetranslation.task;

import android.content.Context;
import com.samsung.android.livetranslation.text.KeyFrame;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TRLResultManager {
    private Context mContext;
    private KeyFrame mKeyFrame;
    private TRLResultOrganizer mOrganizer;
    private List<String> mTRLResult;

    public TRLResultManager(Context context, KeyFrame keyFrame, List<String> list) {
        this.mKeyFrame = keyFrame;
        this.mTRLResult = list;
        this.mContext = context;
    }

    public TRLResultOrganizer getOrganizer() {
        VisionTRLResultOrganizer visionTRLResultOrganizer = new VisionTRLResultOrganizer(this.mContext, this.mKeyFrame, this.mTRLResult);
        this.mOrganizer = visionTRLResultOrganizer;
        return visionTRLResultOrganizer;
    }
}
