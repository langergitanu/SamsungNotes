package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode;

import androidx.appcompat.widget.ListPopupWindow;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.PickerTabView;
import com.samsung.android.support.senl.p148nt.app.main.oldnotes.view.OldCategoryFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsCustomizeToolbarFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsPasswordAndBiometricsFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemHolder;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemTouchHelperCallback;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.ImportDocumentPresenter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportDocumentMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportMemoSCloudMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.presenter.mode.ImportScrapbookMode;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.documentlist.view.ImportDocumentView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportSDocMode;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsIntelligenceHelper;
import com.samsung.android.support.senl.p148nt.app.settings.microsoft.SettingsMicrosoft;
import com.samsung.android.support.senl.p148nt.app.sync.providers.DataUpdateObserverImpl;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmWaitForSaveTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.listener.SoftInputListenerImpl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.SmTextManager;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.view.floater.FloatLayout;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbarFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.AiProgressActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress.AnimatedHelpTextView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.view.SolveMathResult;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.view.mode.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8669a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6274a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6275b;

    public /* synthetic */ RunnableC8669a(Object obj, int i) {
        this.f6274a = i;
        this.f6275b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6274a) {
            case 0:
                ((OldSelectMode) this.f6275b).lambda$updateOptionsMenu$0();
                break;
            case 1:
                ((SearchMode) this.f6275b).lambda$onBackKeyDown$0();
                break;
            case 2:
                ((PickerTabView) this.f6275b).lambda$new$0();
                break;
            case 3:
                OldCategoryFragment.updateButtonMargin$lambda$0((OldCategoryFragment) this.f6275b);
                break;
            case 4:
                SettingsCustomizeToolbarFragment.onConfigurationChanged$lambda$0((SettingsCustomizeToolbarFragment) this.f6275b);
                break;
            case 5:
                ((SettingsPasswordAndBiometricsFragment) this.f6275b).updateBiometricsViews();
                break;
            case 6:
                CustomToolbarItemTouchHelperCallback.onSelectedChanged$lambda$4((CustomToolbarItemHolder) this.f6275b);
                break;
            case 7:
                ImportDocumentPresenter.registerImportListRequest$lambda$4((ImportDocumentPresenter) this.f6275b);
                break;
            case 8:
                ImportDocumentMode.mSyncQuotaListener$lambda$2$lambda$1((ImportDocumentMode) this.f6275b);
                break;
            case 9:
                ImportMemoSCloudMode.onCreate$lambda$0((ImportMemoSCloudMode) this.f6275b);
                break;
            case 10:
                ImportScrapbookMode.onCreate$lambda$0((ImportScrapbookMode) this.f6275b);
                break;
            case 11:
                ((ListPopupWindow) this.f6275b).show();
                break;
            case 12:
                ImportDocumentView.C88077.onItemClick$lambda$0((ImportDocumentView) this.f6275b);
                break;
            case 13:
                ((ImportSDocMode) this.f6275b).requestImportListRunner();
                break;
            case 14:
                SettingsIntelligenceHelper.handleActivityResults$lambda$4((SettingsIntelligenceHelper) this.f6275b);
                break;
            case 15:
                ((SettingsMicrosoft) this.f6275b).signIn();
                break;
            case 16:
                ((DataUpdateObserverImpl) this.f6275b).notifyEventToOtherApps();
                break;
            case 17:
                ((RequestToSyncManager.Companion) this.f6275b).requestSyncByModification();
                break;
            case 18:
                ((SmTextManager) this.f6275b).showExceedToast();
                break;
            case 19:
                SmWaitForSaveTask.run$lambda$0((SmWaitForSaveTask) this.f6275b);
                break;
            case 20:
                SoftInputListenerImpl.onShowSoftInput$lambda$0((SoftInputListenerImpl) this.f6275b);
                break;
            case 21:
                ((AbsDialogFragment) this.f6275b).setAnchor();
                break;
            case 22:
                ((FloatLayout) this.f6275b).drop(true);
                break;
            case 23:
                CustomToolbarFragment.enableToolbar$lambda$1((CustomToolbarFragment) this.f6275b);
                break;
            case 24:
                AiProgressActivity.stopProgress$lambda$0((AiProgressActivity) this.f6275b);
                break;
            case 25:
                ((ListenerImplContract.IPresenter) this.f6275b).clearWritingToolControl();
                break;
            case 26:
                ((AiActionStatus) this.f6275b).release();
                break;
            case 27:
                ((AiContextMenuPresenter) this.f6275b).setTranslationOverlay();
                break;
            case 28:
                AnimatedHelpTextView._init_$lambda$0((AnimatedHelpTextView) this.f6275b);
                break;
            default:
                ((SolveMathResult) this.f6275b).lambda$init$0();
                break;
        }
    }
}
