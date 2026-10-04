package com.samsung.android.support.senl.p148nt.composer.main.oldcomposer.model;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.config.Config;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OldComposerModel extends ComposerModel {
    private String mOldDocUuid;

    public OldComposerModel(Activity activity, @NonNull Config config) {
        super(activity, config);
        getComposerState().setEditable(false);
        getComposerSaveModel().setEditable(false);
        if (activity.getIntent() != null) {
            this.mOldDocUuid = activity.getIntent().getStringExtra(ComposerConstants.ARG_SDOC_OLD_UUID);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel
    public void setDocState(NotesDocument<SpenWordDocument> notesDocument) {
        super.setDocState(notesDocument);
        if (notesDocument != null) {
            notesDocument.getDocumentRepository().setOldUuid(this.mOldDocUuid);
            notesDocument.getDocumentRepository().removeSaveStrategy(128);
        }
    }
}
