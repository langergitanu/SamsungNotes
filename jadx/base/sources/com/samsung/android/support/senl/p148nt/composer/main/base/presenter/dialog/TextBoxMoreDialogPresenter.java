package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextBoxMoreDialogPresenter implements DialogContract.IPresenter {
    private static final String TAG = Logger.createTag("TextBoxMoreDialogPresenter");
    private ComposerModel mComposerModel;
    private DialogContract.IDialog mDialog;
    private boolean mIsLastTextCursorBlinking;
    private ListenerManager mListenerManager;
    private SpenWNote.ObjectEventListener mObjectEventListener;
    private SpenObjectBase mTextBox;
    private TextManager mTextManager;

    public TextBoxMoreDialogPresenter(ComposerModel composerModel, TextManager textManager, ListenerManager listenerManager) {
        this.mComposerModel = composerModel;
        this.mTextManager = textManager;
        this.mListenerManager = listenerManager;
    }

    private SpenWNote.ObjectEventListener getObjectEventListener() {
        SpenWNote.ObjectEventListener objectEventListener = this.mObjectEventListener;
        if (objectEventListener != null) {
            return objectEventListener;
        }
        SpenWNote.ObjectEventListener objectEventListener2 = new SpenWNote.ObjectEventListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.TextBoxMoreDialogPresenter.1
            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
            public void onObjectAdded(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
            public void onObjectChanged(SpenWPage spenWPage, SpenObjectChangedInfo spenObjectChangedInfo, int i) {
                if (TextBoxMoreDialogPresenter.this.mTextBox == null || spenObjectChangedInfo == null || !TextBoxMoreDialogPresenter.this.mTextBox.equals(spenObjectChangedInfo.objectBase)) {
                    return;
                }
                Logger.m11003i(TextBoxMoreDialogPresenter.TAG, "onObjectChanged# ");
                TextBoxMoreDialogPresenter.this.hide();
            }

            @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.ObjectEventListener
            public void onObjectRemoved(SpenWPage spenWPage, ArrayList<SpenObjectBase> arrayList, int i) {
                if (TextBoxMoreDialogPresenter.this.mTextBox == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                Iterator<SpenObjectBase> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (TextBoxMoreDialogPresenter.this.mTextBox.equals(it.next())) {
                        Logger.m11003i(TextBoxMoreDialogPresenter.TAG, "onObjectRemoved# ");
                        TextBoxMoreDialogPresenter.this.hide();
                        return;
                    }
                }
            }
        };
        this.mObjectEventListener = objectEventListener2;
        return objectEventListener2;
    }

    private boolean isAvailableToShow(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (!isShowing()) {
                return true;
            }
            Logger.m11003i(TAG, "isAvailableToShow# dialog is showing");
            return false;
        }
        Logger.m11003i(TAG, "isAvailableToShow# " + activity);
        return false;
    }

    public void hide() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null) {
            iDialog.dismiss();
        }
    }

    public boolean isShowing() {
        DialogContract.IDialog iDialog = this.mDialog;
        return iDialog != null && iDialog.isShowing();
    }

    public void onDetachView() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog == null || !iDialog.isShowing()) {
            return;
        }
        Logger.m11004w("TextBoxMoreDialogPresenter", "onDetachView# dialog is attached");
        this.mDialog.dismiss();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        if (this.mComposerModel.getModeManager().isMode(Mode.Text)) {
            this.mTextManager.setCursorBlink(this.mIsLastTextCursorBlinking);
        }
        SpenWNote.ObjectEventListener objectEventListener = this.mObjectEventListener;
        if (objectEventListener != null) {
            this.mListenerManager.removeSpenObjectEventListener(objectEventListener);
            this.mObjectEventListener = null;
        }
        this.mDialog = null;
    }

    public void show(DialogContract.IDialogCreator iDialogCreator, Activity activity, SpenObjectShape spenObjectShape, String str) {
        if (isAvailableToShow(activity)) {
            if (this.mComposerModel.getModeManager().isMode(Mode.Text)) {
                this.mIsLastTextCursorBlinking = this.mTextManager.isSelected() || this.mTextManager.isCursorBlinking();
                this.mTextManager.setCursorBlink(false);
            }
            DialogContract.IDialog iDialogCreateTextBoxMoreDialog = iDialogCreator.createTextBoxMoreDialog(activity, spenObjectShape.getText(), str, this);
            this.mDialog = iDialogCreateTextBoxMoreDialog;
            iDialogCreateTextBoxMoreDialog.show();
            if (this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote()) {
                this.mTextBox = spenObjectShape;
                this.mListenerManager.addSpenObjectEventListener(getObjectEventListener());
            }
        }
    }
}
