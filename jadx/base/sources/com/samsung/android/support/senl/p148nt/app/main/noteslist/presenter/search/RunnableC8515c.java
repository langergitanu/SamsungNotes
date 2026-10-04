package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.oneui.floatingactioncontainer.FloatingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.main.common.data.MainEntryParam;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.model.FilterInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.PickEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.SearchMode;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseNonPreferenceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsDefaultNoteStyleFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsImportPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.customizetoolbar.view.CustomToolbarItemTouchHelperCallback;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.presenter.mode.ImportSNoteSCloudMode;
import com.samsung.android.support.senl.p148nt.app.sync.providers.DataUpdateObserverImpl;
import com.samsung.android.support.senl.p148nt.app.sync.providers.HashTagNoteProvider;
import com.samsung.android.support.senl.p148nt.app.updater.restore.RestoreDatabaseManager;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.text.span.SmSpanStates;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieResource;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuWritingToolkit;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuAddPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.solvemath.SolveMathPresenter;
import java.util.List;
import java.util.UUID;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.search.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8515c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6238a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6239b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6240c;

    public /* synthetic */ RunnableC8515c(Object obj, Object obj2, int i) {
        this.f6238a = i;
        this.f6239b = obj;
        this.f6240c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6238a) {
            case 0:
                ((SearchHandler) this.f6239b).lambda$search$1((String) this.f6240c);
                break;
            case 1:
                ((SearchHandler) this.f6239b).lambda$searchCover$3((FilterInfo) this.f6240c);
                break;
            case 2:
                ((PickEditMode) this.f6239b).lambda$sendNoteListToWidget$0((Intent) this.f6240c);
                break;
            case 3:
                ((SearchMode) this.f6239b).lambda$onNoteSelected$1((MainEntryParam) this.f6240c);
                break;
            case 4:
                SettingsBaseFragment.onCreateRecyclerView$lambda$0((RecyclerView) this.f6239b, (SettingsBaseFragment) this.f6240c);
                break;
            case 5:
                SettingsBaseNonPreferenceFragment.updateListForVst$lambda$2$lambda$1((SettingsBaseNonPreferenceFragment) this.f6239b, (View) this.f6240c);
                break;
            case 6:
                SettingsDefaultNoteStyleFragment.updateViewPagerWidth$lambda$7$lambda$6((SettingsDefaultNoteStyleFragment) this.f6239b, (TabLayout) this.f6240c);
                break;
            case 7:
                SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15$lambda$5((SettingsImportPrefFragment) this.f6239b, (String[]) this.f6240c);
                break;
            case 8:
                SettingsNotesAssistPrefFragment.initNotesAssistSwitch$lambda$9$lambda$8((CompoundButton) this.f6239b, (SettingsNotesAssistPrefFragment) this.f6240c);
                break;
            case 9:
                SettingsSyncToMicrosoftPrefFragment.C87721.onEnd$lambda$1((SettingsSyncToMicrosoftPrefFragment) this.f6239b, (SettingsSyncToMicrosoftPrefFragment.C87721) this.f6240c);
                break;
            case 10:
                CustomToolbarItemTouchHelperCallback.clearView$lambda$3((CustomToolbarItemTouchHelperCallback) this.f6239b, (RecyclerView.ViewHolder) this.f6240c);
                break;
            case 11:
                ((ImportView) this.f6239b).addPaddingNoTextView((FloatingToolbarLayout) this.f6240c);
                break;
            case 12:
                ImportSNoteSCloudMode.requestImportList$lambda$0((ImportSNoteSCloudMode) this.f6239b, (Context) this.f6240c);
                break;
            case 13:
                ((DataUpdateObserverImpl) this.f6239b).lambda$notifyOldNoteDeleted$4((List) this.f6240c);
                break;
            case 14:
                HashTagNoteProvider.lambda$delete$0((Context) this.f6239b, (UUID) this.f6240c);
                break;
            case 15:
                RestoreDatabaseManager.lambda$restoreGuaranteed$2((Context) this.f6239b, (SharedPreferencesCompat) this.f6240c);
                break;
            case 16:
                SCSLLMRequesterImpl.onFailed$lambda$1((SCSLLMRequesterImpl) this.f6239b, (String) this.f6240c);
                break;
            case 17:
                ((ToolShareControl) this.f6239b).onChangedState((SmSpanStates) this.f6240c);
                break;
            case 18:
                ClipboardController.setClipboardFilter$lambda$1$lambda$0((ClipboardController) this.f6239b, (ClipData) this.f6240c);
                break;
            case 19:
                SipController.delayHide$lambda$1((SipController) this.f6239b, (View) this.f6240c);
                break;
            case 20:
                BaseWidgetSettingView.initDarkModeSwitch$lambda$7((TextView) this.f6239b, (View) this.f6240c);
                break;
            case 21:
                LottieWithMessageLayout.animateMessageView$lambda$2((LottieResource.MessageInfo) this.f6239b, (TextView) this.f6240c);
                break;
            case 22:
                ((ComposerViewPresenter) this.f6239b).lambda$pauseCoEdit$3((Runnable) this.f6240c);
                break;
            case 23:
                ((SoftInputManager) this.f6239b).lambda$delayHide$1((View) this.f6240c);
                break;
            case 24:
                ((AiActionStatus) this.f6239b).lambda$executeAiNoticeDialog$0((Activity) this.f6240c);
                break;
            case 25:
                ((SolveMathPresenter) this.f6239b).lambda$updateRecognitionResultContentPosition$4((RectF) this.f6240c);
                break;
            case 26:
                ((SolveMathPresenter) this.f6239b).lambda$updateRecognitionResultContent$2((Bitmap) this.f6240c);
                break;
            case 27:
                ((ContextMenuWritingToolkit) this.f6239b).lambda$checkPermission$0((String[]) this.f6240c);
                break;
            case 28:
                ((OptionMenuAddPresenter) this.f6239b).lambda$addScan$2((String[]) this.f6240c);
                break;
            default:
                ((OptionMenuAddPresenter) this.f6239b).lambda$addScan$3((String) this.f6240c);
                break;
        }
    }
}
