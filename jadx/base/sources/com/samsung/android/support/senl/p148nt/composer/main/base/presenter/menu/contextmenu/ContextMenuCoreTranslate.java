package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.TranslatorCommonHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuCoreTranslate extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuCoreTranslate");
    protected final ComposerViewPresenter mComposerViewPresenter;
    private boolean mIsPdf = false;
    private String mSelectedText;
    private final SoftInputManager mSoftInputManager;

    public ContextMenuCoreTranslate(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSoftInputManager = controllerManager.getSoftInputManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void extractCommonTranslator() {
        if (this.mIsPdf) {
            this.mSelectedText = TranslatorCommonHelper.preProcess(this.mSelectedText);
        } else if (this.mComposerViewPresenter.getObjectManager().isSelectedBodyText() && this.mSelectedText.length() > 100000) {
            Logger.m11000e(TAG, " limit max length : " + this.mSelectedText.length());
            SpenObjectShape textBox = this.mComposerViewPresenter.getTextManager().getTextBox();
            int i = this.mComposerViewPresenter.getTextManager().getCursor(textBox)[0];
            textBox.setSelection(i, 100000 + i);
            this.mSelectedText = this.mComposerViewPresenter.getTextManager().getSelectedText();
            ToastHelper.show((Context) this.mActivity, C9086R.string.ai_error_reselect_maximum_characters, 0, true);
        }
        Intent intentForCommonTranslator = TranslatorCommonHelper.getIntentForCommonTranslator(this.mSelectedText);
        if (!this.mIsPdf && this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode()) {
            TranslatorCommonHelper.enableGettingResult(intentForCommonTranslator, true);
        }
        try {
            if (intentForCommonTranslator.resolveActivity(this.mActivity.getPackageManager()) != null) {
                Activity activity = this.mActivity;
                ComposerRequestCode composerRequestCode = ComposerRequestCode.CoreTranslator;
                activity.startActivityForResult(intentForCommonTranslator, composerRequestCode.getId());
                this.mComposerViewPresenter.getComposerModel().getComposerState().setLastRequestCode(composerRequestCode.getId());
                ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_TRANSLATE, "a");
            }
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, " not founded " + e);
        } catch (Exception e2) {
            AbstractC8014b.m7207i(" failed e=", e2, TAG);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        if (TextUtils.isEmpty(TranslatorCommonHelper.getPackageNameCommonTranslator())) {
            List<ResolveInfo> listQueryIntentActivities = this.mActivity.getPackageManager().queryIntentActivities(TranslatorCommonHelper.createCommonTranslatorIntent(this.mSelectedText), 0);
            if (listQueryIntentActivities.isEmpty()) {
                Logger.m10999d(TAG, "addMenu# can not find");
                return;
            }
            TranslatorCommonHelper.setPackageNameCommonTranslator(listQueryIntentActivities.get(0).activityInfo.packageName);
        }
        ContextMenuConstants.ContextMenuCode contextMenuCode = ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_CORE_TRANSLATE;
        menu.add(0, contextMenuCode.getId(), contextMenuCode.getId(), C9086R.string.ai_translate_name).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        String selectedText;
        if (!this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode()) {
            return false;
        }
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            selectedText = this.mComposerViewPresenter.getPdfManager().getSelectedText();
            this.mIsPdf = true;
        } else {
            if (!this.mComposerViewPresenter.getObjectManager().isFocusedTextBox()) {
                return false;
            }
            selectedText = this.mComposerViewPresenter.getTextManager().getSelectedText();
        }
        if (TextUtils.isEmpty(selectedText)) {
            return false;
        }
        this.mSelectedText = selectedText;
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        Logger.m10999d(TAG, "executeMenu#");
        if (!this.mSoftInputManager.isInputMethodShown()) {
            extractCommonTranslator();
        } else {
            this.mSoftInputManager.hide((View) null);
            this.mComposerViewPresenter.getHandler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.ContextMenuCoreTranslate.1
                @Override // java.lang.Runnable
                public void run() {
                    ContextMenuCoreTranslate.this.extractCommonTranslator();
                }
            }, 500L);
        }
    }

    public void onActivityResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            Logger.m11000e(TAG, "onActivityResult# resultCode failed : " + i + " or data is null");
            return;
        }
        String stringExtra = intent.getStringExtra(TranslatorCommonHelper.EXTRA_KEY_TRANSLATED_TEXT);
        if (stringExtra == null) {
            Logger.m11000e(TAG, "onActivityResult# result text is empty ");
            return;
        }
        if (!this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode() || this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            Logger.m11000e(TAG, "isEditMode or hasSelectedPdf");
        } else {
            if (!this.mComposerViewPresenter.getObjectManager().isFocusedTextBox() || TextUtils.isEmpty(this.mSelectedText) || TextUtils.isEmpty(this.mComposerViewPresenter.getTextManager().getSelectedText())) {
                return;
            }
            this.mComposerViewPresenter.getTextManager().changeSelectedText(stringExtra);
        }
    }
}
