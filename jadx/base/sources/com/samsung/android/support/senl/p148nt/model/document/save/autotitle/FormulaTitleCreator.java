package com.samsung.android.support.senl.p148nt.model.document.save.autotitle;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectFormula;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FormulaTitleCreator extends AutoTitleCreator<SpenObjectFormula> {
    private static final String TAG = ModelLogger.createTag("FormulaTitleCreator");

    private boolean existOnlyFollowers(@NonNull SpenWNote spenWNote) {
        int objectCount = 0;
        for (int i = 0; i < spenWNote.getPageCount() && (objectCount = objectCount + spenWNote.getPage(i).getObjectCount(1, false)) <= 0; i++) {
        }
        DataLogger.m12307i(TAG, "existOnlyFollowers, strokeCount : " + objectCount);
        return objectCount == 0;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public String apply(@NonNull Resources resources, @NonNull SpenWNote spenWNote) {
        if (needToCreateTitle(spenWNote)) {
            return AutoTitleCreator.CreationPriority.MATH.toString();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator
    public boolean needToCreateTitle(@NonNull SpenWNote spenWNote) {
        SpenObjectFormula spenObjectFormulaFindFirstObject = findFirstObject(spenWNote, 11, 1024);
        DataLogger.m12307i(TAG, "apply, find object (needToCreateTitle) : " + spenObjectFormulaFindFirstObject);
        return spenObjectFormulaFindFirstObject != null && TextUtils.isEmpty(spenWNote.getTitle().getText()) && SpenWNoteObjectHelper.isEmptyBodyText(spenWNote.getBodyText().getText()) && existOnlyFollowers(spenWNote);
    }
}
