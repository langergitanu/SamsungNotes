package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PdfTitleCreator extends AutoTitleCreator<SpenObjectBase> {
    private static final String TAG = ModelLogger.createTag("PdfTitleCreator");

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        if (!needToCreateTitle(spenWNote)) {
            return null;
        }
        for (int i = 0; i < spenWNote.getPageCount(); i++) {
            SpenWPage page = spenWNote.getPage(i);
            if (page != null && SpenWNoteObjectHelper.hasPdfObject(page)) {
                DataLogger.m12307i(TAG, "apply, pdf name : " + DataLogger.getEncode("Pdf"));
                return "Pdf";
            }
        }
        return null;
    }
}
