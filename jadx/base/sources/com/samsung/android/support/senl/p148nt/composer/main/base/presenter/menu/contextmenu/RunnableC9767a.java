package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu;

import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.ContextMenuConvertToMath;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.C9875f;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.title.TitleEditorPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.PasteRawContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.AiSuggestionView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.composer.PageTunerButton;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.common.OptionMenuPopupWindowHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingAddFavoritePenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.setting.HwSettingLaserPenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolAiMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.ChipView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.TableAndCellMoreMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.table.TableCalculateMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordControlMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandSubMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordMenuContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.PwFragmentPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option.PwOptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation;
import com.samsung.android.support.senl.p148nt.model.collector.SavingByWhichPidCollectExecutor;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.AudioPickerSearchPresenter;
import com.samsung.android.support.senl.p148nt.stt.picker.presenter.VoiceDataUpdater;
import com.samsung.android.support.senl.p148nt.stt.picker.view.AudioPickerListViewAdapter;
import com.samsung.android.support.senl.p148nt.stt.picker.view.SearchFragment;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.contextmenu.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9767a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6995a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6996b;

    public /* synthetic */ RunnableC9767a(Object obj, int i) {
        this.f6995a = i;
        this.f6996b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6995a) {
            case 0:
                ((ContextMenuConvertToMath.ConvertToMathPopup) this.f6996b).lambda$initWindow$1();
                break;
            case 1:
                ((C9875f) this.f6996b).invoke();
                break;
            case 2:
                ((TitleEditorPresenter) this.f6996b).lambda$onLiveSharingDisconnected$0();
                break;
            case 3:
                VoiceRecordingEventListenerImpl.onPlayStopped$lambda$0((VoiceRecordingEventListenerImpl) this.f6996b);
                break;
            case 4:
                ((PasteRawContent) this.f6996b).lambda$handleWebCard$1();
                break;
            case 5:
                AiSuggestionView.makeButtons$lambda$2$lambda$1((AiSuggestionView) this.f6996b);
                break;
            case 6:
                ((PageTunerButton) this.f6996b).lambda$update$0();
                break;
            case 7:
                OptionMenuPopupWindowHelper.lambda$getPopupWindowNewStyleLayout$1((GuidingLightEffect) this.f6996b);
                break;
            case 8:
                ((HwSettingAddFavoritePenLayout) this.f6996b).lambda$hide$0();
                break;
            case 9:
                ((HwSettingLaserPenLayout) this.f6996b).lambda$show$0();
                break;
            case 10:
                QuickToolAiMenu.translateYRunnable$lambda$0((QuickToolAiMenu) this.f6996b);
                break;
            case 11:
                SettingQTColorLayout.setVisibility$lambda$0((SettingQTColorLayout) this.f6996b);
                break;
            case 12:
                SettingQTPenLayout.setViewModeAttributes$lambda$12((SettingQTPenLayout) this.f6996b);
                break;
            case 13:
                SettingQTPenLayout.setViewModeAttributes$lambda$14$lambda$13((ChipView) this.f6996b);
                break;
            case 14:
                ((TableAndCellMoreMenu) this.f6996b).showPopupWindow();
                break;
            case 15:
                ((TableCalculateMenu) this.f6996b).showPopupWindow();
                break;
            case 16:
                VoiceRecordControlMenu.moveForward$lambda$14((VoiceRecordControlMenu) this.f6996b);
                break;
            case 17:
                VoiceRecordExpandSubMenu.notifyDataSetChanged$lambda$2((VoiceRecordExpandSubMenu) this.f6996b);
                break;
            case 18:
                VoiceRecordMenuContainer.executeAudioEraser$lambda$1((VoiceRecordMenuContainer) this.f6996b);
                break;
            case 19:
                VoiceRecordSimpleMenu.showRecordingAnimation$lambda$9((VoiceRecordSimpleMenu) this.f6996b);
                break;
            case 20:
                ((PwFragmentPresenter) this.f6996b).lambda$showSaveBackupDialog$0();
                break;
            case 21:
                ((PwOptionMenuBackPresenter) this.f6996b).lambda$new$0();
                break;
            case 22:
                ((PwOptionMenuPresenter) this.f6996b).lambda$addToNoteWithTranslation$0();
                break;
            case 23:
                AbsStartingAnimation.start$lambda$0((AbsStartingAnimation) this.f6996b);
                break;
            case 24:
                ((SavingByWhichPidCollectExecutor) this.f6996b).resetIsSavingByWhichPid();
                break;
            case 25:
                AudioPickerSearchPresenter.mMinimiseRunnable$lambda$0((AudioPickerSearchPresenter) this.f6996b);
                break;
            case 26:
                VoiceDataUpdater.startSyncAllVoices$lambda$3((VoiceDataUpdater) this.f6996b);
                break;
            case 27:
                AudioPickerListViewAdapter.onUpdate$lambda$4((AudioPickerListViewAdapter) this.f6996b);
                break;
            case 28:
                SearchFragment.showHideViewWhenSearch$lambda$1((SearchFragment) this.f6996b);
                break;
            default:
                AiSTTListView.notifyDataSetChanged$lambda$3((AiSTTListView) this.f6996b);
                break;
        }
    }
}
