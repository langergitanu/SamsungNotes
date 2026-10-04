package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WebCardTitleCreator extends AutoTitleCreator<SpenObjectWeb> {
    private static final String TAG = ModelLogger.createTag("WebCardTitleCreator");

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        if (!needToCreateTitle(spenWNote)) {
            return null;
        }
        SpenObjectWeb spenObjectWebFindFirstObject = findFirstObject(spenWNote, 13, 4096);
        String str = TAG;
        DataLogger.m12307i(str, "apply, find object : " + spenObjectWebFindFirstObject);
        if (spenObjectWebFindFirstObject == null) {
            return null;
        }
        DataLogger.m12307i(str, "apply, find web title : " + DataLogger.getEncode(spenObjectWebFindFirstObject.getTitle()));
        return spenObjectWebFindFirstObject.getTitle();
    }
}
