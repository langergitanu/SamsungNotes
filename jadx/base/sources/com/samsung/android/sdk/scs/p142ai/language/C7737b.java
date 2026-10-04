package com.samsung.android.sdk.scs.p142ai.language;

import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.preference.Preference;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.visual.ImageEditorGenerator;
import com.samsung.android.sdk.scs.p142ai.visual.WallpaperGenerator;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanImpl;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import com.samsung.android.support.senl.docscan.rectify.RectifyEditFragment;
import com.samsung.android.support.senl.p148nt.app.main.common.view.ActionMenuController;
import com.samsung.android.support.senl.p148nt.app.main.common.view.BottomMenuController;
import com.samsung.android.support.senl.p148nt.app.main.folder.view.mode.ManageEditMode;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SOMRecognizedCardHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.FiltersSearchView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.SearchFilterFolderView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.CoeditEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.OldEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.PickEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.mode.menu.RecycleBinEditModeView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.PickerTabView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedCardExpandCollapseBtn;
import com.samsung.android.support.senl.p148nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsAutoTranscribePrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsImportPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsNotesAssistOnDeviceFragment;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.presenter.HWRLanguagePresenter;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.view.ImportView;
import com.samsung.android.support.senl.p148nt.app.settings.main.SettingsSyncHelper;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8884a;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLVMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.util.PinnedEdge;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatusManager;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper;
import p100Y3.C0348a;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.language.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7737b implements OnCompleteListener, ActivityResultCallback, PinnedEdge.StateChangeListener, NavigationBarView.OnItemSelectedListener, BottomMenuController.AnimationEndListener, SOMRecognizedCardExpandCollapseBtn.Contract, SearchFilterFolderView.Listener, PickerTabView.TabViewContract, Preference.OnPreferenceClickListener, AiActionStatusManager.SettingsPrenventOnlineProcessingListener, Preference.OnPreferenceChangeListener, TextRecognitionLanguageDownloadHelper.InitFinishedListener, ActionMenuController.OnClickSelectAllListener, SettingsGlobalSyncStatusHandler.Listener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5194a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f5195b;

    public /* synthetic */ C7737b(Object obj, int i) {
        this.f5194a = i;
        this.f5195b = obj;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        VexDocumentScanImpl.registerVexDocumentScan$lambda$0((VexDocumentScanImpl) this.f5195b, (ActivityResult) obj);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.BottomMenuController.AnimationEndListener
    public void onAnimationEnd(boolean z) {
        ((ManageEditMode) this.f5195b).lambda$onPrepareOptionsMenu$0(z);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.AiActionStatusManager.SettingsPrenventOnlineProcessingListener
    public void onChange() {
        SettingsNotesAssistOnDeviceFragment.onCreatePreferences$lambda$2((SettingsNotesAssistOnDeviceFragment) this.f5195b);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.common.view.ActionMenuController.OnClickSelectAllListener
    public void onClick(boolean z) {
        ImportView.startActionMode$lambda$5((ImportView) this.f5195b, z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.somrecognizedcard.SOMRecognizedCardExpandCollapseBtn.Contract
    public void onClicked() {
        ((SOMRecognizedCardHolder) this.f5195b).toggleSOMRecognizedCardExpandCollapseState();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f5194a) {
            case 0:
                ((SmartCoverer) this.f5195b).lambda$release$2(task);
                break;
            case 1:
                ((SmartReplyer) this.f5195b).lambda$release$4(task);
                break;
            case 2:
                ((Suggester) this.f5195b).lambda$release$5(task);
                break;
            case 3:
                ((SuggesterForExternal) this.f5195b).lambda$release$1(task);
                break;
            case 4:
                ((Summarizer) this.f5195b).lambda$release$4(task);
                break;
            case 5:
                ((ToneConverter) this.f5195b).lambda$release$3(task);
                break;
            case 6:
                ((WritingComposer) this.f5195b).lambda$release$3(task);
                break;
            case 7:
                ((ImageEditorGenerator) this.f5195b).lambda$release$0(task);
                break;
            case 8:
                ((WallpaperGenerator) this.f5195b).lambda$release$0(task);
                break;
            case 26:
                SCSLVMRequesterImpl.cancel$lambda$18((C0348a) this.f5195b, task);
                break;
            case 27:
                SCSLVMRequesterImpl.release$lambda$8((C0348a) this.f5195b, task);
                break;
            case 28:
                SCSLVMRequesterImpl.release$lambda$10((C0348a) this.f5195b, task);
                break;
            default:
                SCSLVMRequesterImpl.prepare$lambda$4((C8884a) this.f5195b, task);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.search.view.SearchFilterFolderView.Listener
    public void onFolderFilterChanged(boolean z) {
        ((FiltersSearchView) this.f5195b).lambda$initFolderFilter$1(z);
    }

    @Override // com.samsung.android.support.senl.nt.app.settings.common.handler.SettingsGlobalSyncStatusHandler.Listener
    public void onGlobalSyncChanged() {
        ((SettingsSyncHelper) this.f5195b).updateSCloudSyncSummary();
    }

    @Override // com.samsung.android.support.senl.nt.model.collector.recognition.extractor.TextRecognitionLanguageDownloadHelper.InitFinishedListener
    public void onInitFinished() {
        ((HWRLanguagePresenter) this.f5195b).loadLanguageData();
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (this.f5194a) {
            case 11:
                return RectifyEditFragment.updateBottomNavigationView$lambda$2((RectifyEditFragment) this.f5195b, menuItem);
            case 15:
                return ((CoeditEditModeView) this.f5195b).lambda$onPrepareOptionsMenu$0(menuItem);
            case 16:
                return ((OldEditModeView) this.f5195b).onOptionsItemSelected(menuItem);
            default:
                return ((RecycleBinEditModeView) this.f5195b).lambda$onPrepareOptionsMenu$0(menuItem);
        }
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference preference, Object obj) {
        return SettingsSyncToMicrosoftPrefFragment.initLayout$lambda$0((SettingsSyncToMicrosoftPrefFragment) this.f5195b, preference, obj);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference preference) {
        switch (this.f5194a) {
            case 19:
                return SettingsAutoTranscribePrefFragment.initAutoTranscribeLanguagePackForDownload$lambda$5((SettingsAutoTranscribePrefFragment) this.f5195b, preference);
            default:
                return SettingsImportPrefFragment.mOnPreferenceClickListener$lambda$15((SettingsImportPrefFragment) this.f5195b, preference);
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.common.util.PinnedEdge.StateChangeListener
    public void onStateChanged(boolean z) {
        CameraFragment.mStateChangeListener$lambda$0((CameraFragment) this.f5195b, z);
    }

    @Override // com.samsung.android.support.senl.nt.app.main.noteslist.view.widget.PickerTabView.TabViewContract
    public void onTabSelected(String str) {
        ((PickEditModeView) this.f5195b).lambda$new$0(str);
    }
}
