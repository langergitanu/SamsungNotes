package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkTitleCreator extends AutoTitleCreator<SpenObjectLink> {
    private static final String TAG = ModelLogger.createTag("LinkTitleCreator");

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        if (!needToCreateTitle(spenWNote)) {
            return null;
        }
        SpenObjectLink spenObjectLinkFindFirstBodyObject = findFirstBodyObject(spenWNote, 65536);
        DataLogger.m12307i(TAG, "apply, find object : " + spenObjectLinkFindFirstBodyObject);
        if (spenObjectLinkFindFirstBodyObject == null) {
            return null;
        }
        String title = spenObjectLinkFindFirstBodyObject.getTitle();
        return TextUtils.isEmpty(title) ? AutoTitleCreator.CreationPriority.LINK.toString() : title;
    }
}
