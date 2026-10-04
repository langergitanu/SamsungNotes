package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Menu;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.DictionaryHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.TranslatorCommonHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ContextMenuSupportedActivities extends ContextMenuItem {
    private static final String CLASS_SETTINGS = "com.samsung.android.settings.display.SecProcessTextManageAppsFragment";
    private static final String PACKAGE_SETTINGS = "com.android.settings";
    private static final String SEM_PROCESS_TEXT_MANAGE_APPS = "process_text_manager_apps";
    private static final boolean START_ACTIVITY_FOR_RESULT = false;
    private static final String TAG = Logger.createTag("ContextMenuSupportedActivities");
    private final ClipboardController mClipboardController;
    private final ComposerModel mComposerModel;
    protected final ComposerViewPresenter mComposerViewPresenter;
    private final ModeManager mModeManager;
    private final NoteManager mNoteManager;
    private final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    private final PdfManager mPdfManager;
    private final SoftInputManager mSoftInputManager;
    private final List<ResolveInfo> mSupportedActivities = new ArrayList();
    private final TextManager mTextManager;

    public ContextMenuSupportedActivities(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mObjectManager = composerViewPresenter.getObjectManager();
        this.mComposerModel = composerViewPresenter.getComposerModel();
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mNoteManager = composerViewPresenter.getNoteManager();
        this.mPageManager = composerViewPresenter.getPageManager();
        this.mTextManager = composerViewPresenter.getTextManager();
        this.mPdfManager = composerViewPresenter.getPdfManager();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mClipboardController = controllerManager.getClipboardController();
    }

    private Intent createIntentForManageApps() {
        return new Intent().setComponent(new ComponentName(PACKAGE_SETTINGS, CLASS_SETTINGS));
    }

    private Intent createProcessTextIntent() {
        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    private Intent createProcessTextIntentForResolveInfo(ResolveInfo resolveInfo) {
        Intent intentPutExtra = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !this.mModeManager.isEditMode());
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
    }

    private CharSequence getLabel(ResolveInfo resolveInfo) {
        return resolveInfo.loadLabel(this.mActivity.getPackageManager());
    }

    private boolean isSupportedActivity(String str, ResolveInfo resolveInfo) {
        if (!TextUtils.isEmpty(str)) {
            return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() > 60100 ? str.contains(resolveInfo.activityInfo.name) : str.contains(resolveInfo.activityInfo.packageName);
        }
        Logger.m11003i(TAG, "isSupportedActivity# appsStr is empty");
        return false;
    }

    private void loadSupportedActivities() {
        this.mSupportedActivities.clear();
        for (ResolveInfo resolveInfo : this.mActivity.getPackageManager().queryIntentActivities(createProcessTextIntent(), 0)) {
            if (isSupportedActivity(resolveInfo)) {
                this.mSupportedActivities.add(resolveInfo);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void addMenu(Menu menu) {
        String string;
        if (canShow()) {
            boolean z = DeviceInfo.getSemPlatformVersionInt(0) >= 150100;
            if (z) {
                string = Settings.Global.getString(this.mActivity.getContentResolver(), SEM_PROCESS_TEXT_MANAGE_APPS);
                menu.add(0, 200, 201, C9086R.string.composer_ctx_menu_manage_apps).setIntent(createIntentForManageApps()).setShowAsAction(8);
            } else {
                string = null;
            }
            loadSupportedActivities();
            int size = this.mSupportedActivities.size();
            for (int i = 0; i < size; i++) {
                ResolveInfo resolveInfo = this.mSupportedActivities.get(i);
                if (!z || isSupportedActivity(string, resolveInfo)) {
                    menu.add(0, 200, i + 200, getLabel(resolveInfo)).setIntent(createProcessTextIntentForResolveInfo(resolveInfo)).setShowAsAction(1);
                }
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public boolean canShow() {
        int length;
        boolean zIsEmpty;
        if (this.mComposerModel.getComposerState().isSecured()) {
            return false;
        }
        if (this.mPdfManager.hasSelectedText()) {
            zIsEmpty = TextUtils.isEmpty(this.mPdfManager.getSelectedText());
        } else {
            if (!this.mObjectManager.isFocusedTextBox()) {
                return false;
            }
            SpenObjectShape textBox = this.mTextManager.getTextBox();
            int[] cursor = this.mTextManager.getCursor(textBox);
            if (cursor[0] == cursor[1] || textBox.getText() == null || (length = textBox.getText().length()) < cursor[0] || length < cursor[1]) {
                return false;
            }
            zIsEmpty = TextUtils.isEmpty(this.mTextManager.getSelectedText());
        }
        return !zIsEmpty;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuItem
    public void executeMenu() {
        boolean z;
        Intent intent = this.mExecuteMenuItem.getIntent();
        if (intent == null) {
            Logger.m11000e(TAG, "executeMenu# intent is null ");
            return;
        }
        if ("android.intent.action.PROCESS_TEXT".equals(intent.getAction())) {
            intent.putExtra("android.intent.extra.PROCESS_TEXT", this.mPdfManager.hasSelectedText() ? this.mPdfManager.getSelectedText() : this.mTextManager.getSelectedText());
            z = true;
        } else {
            z = false;
        }
        String str = TAG;
        Logger.m11003i(str, "executeMenu# " + intent);
        try {
            ComposerRequestCode composerRequestCode = ComposerRequestCode.None;
            ComposerRequestCode composerRequestCode2 = (intent.getComponent() == null || !PACKAGE_SETTINGS.equals(intent.getComponent().getPackageName())) ? composerRequestCode : ComposerRequestCode.SettingContextMenu;
            if (composerRequestCode2 == composerRequestCode) {
                this.mActivity.startActivity(intent);
            } else if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
                this.mActivity.startActivityForResult(intent, composerRequestCode2.getId());
                this.mComposerModel.getComposerState().setLastRequestCode(composerRequestCode2.getId());
            } else {
                Logger.m11000e(str, "executeMenu# failed resolveActivity");
            }
        } catch (ActivityNotFoundException e) {
            Logger.m11000e(TAG, "executeMenu# ActivityNotFoundException : " + intent.getPackage() + ", e=" + e.getMessage());
        } catch (Exception e2) {
            AbstractC8014b.m7205g(e2, new StringBuilder("executeMenu# failed e="), TAG);
        }
        if (z) {
            this.mObjectManager.clearSelectObject();
        }
    }

    public void executeTaskPaste(ClipData clipData) {
        Logger.m11003i(TAG, "executeTaskPaste# ");
        Activity activity = this.mActivity;
        ComposerModel composerModel = this.mComposerModel;
        ObjectManager objectManager = this.mObjectManager;
        NoteManager noteManager = this.mNoteManager;
        PageManager pageManager = this.mPageManager;
        TextManager textManager = this.mTextManager;
        PdfManager pdfManager = this.mPdfManager;
        int currentPageIndex = pageManager.getDocPageInfo().getCurrentPageIndex();
        SoftInputManager softInputManager = this.mSoftInputManager;
        Objects.requireNonNull(softInputManager);
        this.mClipboardController.executeTaskPaste(clipData, new TaskPaste.InputValues(activity, clipData, composerModel, objectManager, noteManager, pageManager, textManager, pdfManager, currentPageIndex, null, new C8886c(softInputManager, 7), true));
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == ComposerRequestCode.SettingContextMenu.getId() && canShow()) {
            this.mComposerViewPresenter.setContextMenu(true);
            return;
        }
        if (i2 != -1 || intent == null) {
            Logger.m11000e(TAG, "onActivityResult# resultCode failed : " + i2 + " or data is null");
            return;
        }
        CharSequence charSequenceExtra = intent.getCharSequenceExtra("android.intent.extra.PROCESS_TEXT");
        if (charSequenceExtra == null) {
            return;
        }
        if (this.mModeManager.isEditMode()) {
            executeTaskPaste(ClipData.newPlainText("", charSequenceExtra));
        } else {
            if (charSequenceExtra.toString().isEmpty()) {
                return;
            }
            ToastHandler.show(this.mActivity, String.valueOf(charSequenceExtra), 1);
        }
    }

    private boolean isSupportedActivity(ResolveInfo resolveInfo) {
        ActivityInfo activityInfo;
        if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null) {
            String str = activityInfo.packageName;
            if (TextUtils.isEmpty(str)) {
                Logger.m11000e(TAG, "isSupportedActivity# packageName is null");
                return false;
            }
            if (DeviceInfo.getSemPlatformVersionInt(0) < 150100 && (str.contains(DictionaryHelper.DICTIONARY_PACKAGE_NAME) || str.contains(DictionaryHelper.DICTIONARY_PACKAGE_NAME_SEC))) {
                return false;
            }
            if (!TextUtils.isEmpty(TranslatorCommonHelper.getPackageNameCommonTranslator()) && str.equals(TranslatorCommonHelper.getPackageNameCommonTranslator())) {
                return false;
            }
            ActivityInfo activityInfo2 = resolveInfo.activityInfo;
            String str2 = activityInfo2.permission;
            return activityInfo2.exported && (str2 == null || this.mActivity.checkSelfPermission(str2) == 0);
        }
        Logger.m11000e(TAG, "isSupportedActivity# ResolveInfo is null");
        return false;
    }
}
