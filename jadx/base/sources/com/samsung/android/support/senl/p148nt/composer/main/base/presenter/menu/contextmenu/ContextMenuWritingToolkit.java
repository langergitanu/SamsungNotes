package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search.RunnableC8515c;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.PermissionCode;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuWritingToolkit extends ContextMenuItem {
    private static final String TAG = Logger.createTag("ContextMenuWritingToolkit");
    private static final String WRITING_TOOLKIT_ACTION = "actionShowToolKitHbd";
    ComposerViewPresenter mComposerViewPresenter;
    ObjectManager mObjectManager;
    TextManager mTextManager;

    public ContextMenuWritingToolkit(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mTextManager = composerViewPresenter.getTextManager();
    }

    private void addText(CharSequence charSequence) {
        Content.Text text = new Content.Text(charSequence);
        ArrayList arrayList = new ArrayList();
        arrayList.add(text);
        this.mObjectManager.addContents(0, arrayList, null, true);
    }

    private void callWritingToolkit(@NonNull String str) {
        InputMethodManager inputMethodManager = (InputMethodManager) this.mComposerViewPresenter.getActivity().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.sendAppPrivateCommand(this.mComposerViewPresenter.getView(), WRITING_TOOLKIT_ACTION, null);
        }
        this.mComposerViewPresenter.getComposerControllerManager().getCompSipController().setTemporarySoftInputMode(16);
    }

    private boolean checkPermission() {
        String[] strArr = {"android.permission.WRITE_SECURE_SETTINGS"};
        return PermissionHelper.isPermissionGranted(this.mActivity, new RunnableC8515c(this, strArr, 27), strArr);
    }

    private static Intent getIntent(@NonNull String str) {
        Intent intentPutExtra = new Intent().setAction("com.samsung.android.intent.action.WritingToolkit").setData(Uri.parse("honeyboard://writing-toolkit")).putExtra("toolkitSubject", str).putExtra("isTextEditable", true);
        intentPutExtra.setFlags(0);
        return intentPutExtra;
    }

    private String getSelectedText() {
        String selectedText = this.mTextManager.getSelectedText();
        return selectedText == null ? "" : UnicodeUtils.removeObjectReplacementChar(selectedText);
    }

    public static boolean isSupported(Activity activity) {
        return false;
    }

    public static boolean isSupportedAIVersion() {
        return Features.isWritingToolkitSupportedAiConfigVersion();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$checkPermission$0(String[] strArr) {
        PermissionHelper.requestPermissions(this.mActivity, PermissionCode.PERMISSION_REQUEST_WRITING_TOOLKIT, strArr);
    }

    private void startWritingToolkitActivity(Intent intent) {
        try {
            Logger.m10999d(TAG, "startWritingToolkitActivity# ");
            this.mComposerViewPresenter.getActivity().startActivityForResult(intent, ComposerRequestCode.WritingToolkit.getId());
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "startWritingToolkitActivity# not found " + e.getMessage());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        menu.add(0, ContextMenuConstants.getWritingToolkitId(), ContextMenuConstants.ContextMenuCode.CONTEXT_MENU_ID_WRITING_TOOLKIT.getId(), "").setIcon(C9086R.drawable.ic_ai_menu_title).setEnabled(canShow());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        if (!this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode()) {
            return false;
        }
        if (this.mObjectManager.isSelectedBodyText()) {
            return true;
        }
        return this.mObjectManager.isSelectedTextBox() && this.mObjectManager.isFocusedTextBox();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        String selectedText = getSelectedText();
        if (checkPermission()) {
            callWritingToolkit(selectedText);
        } else {
            Logger.m10999d(TAG, "executeMenu# no permission");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean isForOnlyActionMode() {
        return true;
    }

    public void onActivityResult(int i, Intent intent) {
        if (i != -1 || intent == null) {
            Logger.m11000e(TAG, "onActivityResult# resultCode failed : " + i + " or data is null");
            return;
        }
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("toolkitText");
        CharSequence charSequenceExtra2 = intent.getCharSequenceExtra("toolkitAction");
        String str = TAG;
        Logger.m10999d(str, "onActivityResult# action: " + ((Object) charSequenceExtra2) + " result: " + ((Object) charSequenceExtra));
        if (charSequenceExtra != null) {
            if (Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_REPLACE.contentEquals(charSequenceExtra2)) {
                if (canShow()) {
                    this.mTextManager.removeSelectedText();
                } else {
                    this.mObjectManager.selectObject(this.mComposerViewPresenter.getDoc().getBodyText());
                }
                addText(charSequenceExtra);
                return;
            }
            if (!"addto".contentEquals(charSequenceExtra2)) {
                Logger.m11000e(str, "onActivityResult# ai toolkit action err");
                return;
            }
            if (canShow()) {
                this.mTextManager.clearSelection();
            } else {
                this.mObjectManager.selectObject(this.mComposerViewPresenter.getDoc().getBodyText());
            }
            addText(charSequenceExtra);
        }
    }
}
