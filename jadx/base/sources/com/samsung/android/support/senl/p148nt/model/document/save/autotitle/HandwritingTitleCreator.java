package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class HandwritingTitleCreator extends AutoTitleCreator<SpenObjectStroke> {
    private static final String TAG = ModelLogger.createTag("HandwritingTitleCreator");

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        SpenObjectStroke spenObjectStrokeFindFirstObject = findFirstObject(spenWNote, 1, 1);
        String str = TAG;
        DataLogger.m12307i(str, "apply, find object : " + spenObjectStrokeFindFirstObject);
        if (spenObjectStrokeFindFirstObject == null) {
            return null;
        }
        DataLogger.m12307i(str, "apply, find handwriting object : " + spenObjectStrokeFindFirstObject);
        return resources.getString(C8875R.string.handwriting);
    }
}
