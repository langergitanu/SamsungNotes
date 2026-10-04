package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImageTitleCreator extends AutoTitleCreator<SpenObjectImage> {
    private static final String TAG = ModelLogger.createTag("ImageTitleCreator");

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        if (!needToCreateTitle(spenWNote)) {
            return null;
        }
        boolean zHasObject = hasObject(spenWNote, 3);
        AbstractC11014a.m12335t("apply, find object : ", TAG, zHasObject);
        if (zHasObject) {
            return AutoTitleCreator.CreationPriority.IMAGE.toString();
        }
        return null;
    }
}
