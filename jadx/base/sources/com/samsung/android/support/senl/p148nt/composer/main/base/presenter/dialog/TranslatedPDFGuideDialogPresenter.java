package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslatedPDFGuideDialogPresenter extends AbsDialogFragmentPresenter {
    private static final String TAG = Logger.createTag("TranslatedPDFGuideDialogPresenter");
    private final ComposerModel mComposerModel;
    private final DialogContract.IDialogCreator mCreator;

    public TranslatedPDFGuideDialogPresenter(DialogContract.IDialogCreator iDialogCreator, ComposerModel composerModel) {
        this.mCreator = iDialogCreator;
        this.mComposerModel = composerModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public boolean canShow(Activity activity, String str) {
        Intent intent;
        if (!super.canShow(activity, str) || (intent = activity.getIntent()) == null) {
            return false;
        }
        boolean booleanExtra = intent.getBooleanExtra(ComposerConstants.ARG_GUIDE_TRANSLATED_PDF_NEED_TO_SHOW, false);
        intent.removeExtra(ComposerConstants.ARG_GUIDE_TRANSLATED_PDF_NEED_TO_SHOW);
        return booleanExtra;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    public void show() {
        if (this.mComposerModel.isTranslatedPDFNote()) {
            Activity activity = this.mActivity;
            String str = TAG;
            if (canShow(activity, str)) {
                show(this.mActivity, str, this.mCreator.createTranslatedPDFGuideDialogFragment());
            }
        }
    }
}
