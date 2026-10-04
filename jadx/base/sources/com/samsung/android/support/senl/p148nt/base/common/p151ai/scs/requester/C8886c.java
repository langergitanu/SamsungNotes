package com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester;

import android.view.MenuItem;
import androidx.arch.core.util.Function;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.google.android.material.navigation.NavigationBarView;
import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.IFolderPickerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.common.IModelParent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view.AiMenuPopup;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.AutoFormat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AutoFormatTypePopupWindow;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.Initializer;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPaste;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.pages.PageListEditModeLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.FolderViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditorViewSet;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordSimpleMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation.VoiceAnimation;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentTempDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.ExternalSharedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentPageDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import java.util.List;
import p100Y3.C0348a;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.common.ai.scs.requester.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8886c implements OnCompleteListener, IModelParent, AutoFormatTypePopupWindow.OnItemClickListener, TaskPaste.ISoftInputController, VoiceModel.RestoreCompleteListener, ModeManager.SoftInputManagerContract, NavigationBarView.OnItemSelectedListener, CommonTemplateStyleLayout.Callback, IFolderPickerDialog.OnFolderSelectedListener, TitleViewManager.OnTitleChangedListener, SimpleLottieValueCallback, AllSideToolbarContainerLayout.CheckAnimation, Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6435a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6436b;

    public /* synthetic */ C8886c(Object obj, int i) {
        this.f6435a = i;
        this.f6436b = obj;
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public Object mo22196apply(Object obj) {
        switch (this.f6435a) {
            case 16:
                return ((DocumentExtraDao) this.f6436b).lambda$deleteByUuids$0((List) obj);
            case 17:
                return ((DocumentTempDataDao) this.f6436b).lambda$deleteByUuids$0((List) obj);
            case 18:
                return ((DocumentThumbnailDao) this.f6436b).lambda$delete$0((List) obj);
            case 19:
                return ((ExternalSharedDocumentDao) this.f6436b).lambda$delete$0((List) obj);
            case 20:
                return ((MainListDocumentDataDao) this.f6436b).getEntitiesInChunk((List) obj);
            case 21:
                return ((NotesCategoryTreeDao) this.f6436b).getEntitiesInChunk((List) obj);
            case 22:
                return ((NotesContentDao) this.f6436b).lambda$deleteBySDocUuid$0((List) obj);
            case 23:
                return ((NotesConvertedDocumentDao) this.f6436b).getOldNotesWithConvertedNotesInUseInChunk((List) obj);
            case 24:
                return ((NotesDebugDao) this.f6436b).lambda$deleteNotes$0((List) obj);
            case 25:
                return ((NotesDocumentCoverDao) this.f6436b).lambda$deleteByUuids$0((List) obj);
            case 26:
                return ((NotesDocumentPageDao) this.f6436b).lambda$deleteByDocumentUuid$0((List) obj);
            case 27:
                return ((NotesOrganizedDocumentDao) this.f6436b).lambda$deleteByUuids$0((List) obj);
            case 28:
                return ((NotesRestoreDao) this.f6436b).lambda$deleteDummyNewFolders$0((List) obj);
            default:
                return ((NotesStrokeDao) this.f6436b).lambda$deleteByUuid$0((List) obj);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mode.ModeManager.SoftInputManagerContract
    public void blockToShow(boolean z) {
        ((Initializer) this.f6436b).lambda$restore$3(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.model.common.IModelParent
    public NotesDocument getDocState() {
        return ((ComposerModel) this.f6436b).lambda$new$0();
    }

    @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return VoiceRecordSimpleMenu.updateBgRecording$lambda$11((VoiceRecordSimpleMenu) this.f6436b, lottieFrameInfo);
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.f6435a) {
            case 0:
                SCSLVMRequesterImpl.prepare$lambda$6((C8884a) this.f6436b, task);
                break;
            case 1:
                SCSLVMRequesterImpl.cancel$lambda$12((C0348a) this.f6436b, task);
                break;
            case 2:
                SCSLVMRequesterImpl.cancel$lambda$14((C0348a) this.f6436b, task);
                break;
            case 3:
                SCSLVMRequesterImpl.cancel$lambda$16((C0348a) this.f6436b, task);
                break;
            default:
                AiLanguageHelper.updateLanguageList$lambda$3((Runnable) this.f6436b, task);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.base.winset.app.dialog.IFolderPickerDialog.OnFolderSelectedListener
    public void onFolderSelected(String str) {
        ((FolderViewManager) this.f6436b).lambda$initFolderPickerDialog$3(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.AutoFormatTypePopupWindow.OnItemClickListener
    public void onItemClick(AutoFormat.FormatType formatType) {
        ((AiMenuPopup) this.f6436b).lambda$showAutoFormatTypeListWindow$1(formatType);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.voice.VoiceModel.RestoreCompleteListener
    public void onMenuUpdate() {
        VoiceRecordMenuPresenter.mRestoreListener$lambda$0((VoiceRecordMenuPresenter) this.f6436b);
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return ((PageListEditModeLayout) this.f6436b).lambda$initBottomNavigation$2(menuItem);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout.Callback
    public void onPageChanged(int i) {
        BaseTemplateStyleFragment.initCommonTemplateStyleLayout$lambda$1((BaseTemplateStyleFragment) this.f6436b, i);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.title.TitleViewManager.OnTitleChangedListener
    public void onTitleChanged() {
        ((TitleEditorViewSet) this.f6436b).lambda$initTitleTextView$0();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.common.AllSideToolbarContainerLayout.CheckAnimation
    public boolean onUpdateAnimationState() {
        return VoiceAnimation.checkAnimationStateTypeNone$lambda$0((AllSideToolbarContainerLayout) this.f6436b);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskPaste.ISoftInputController
    public void blockToShow(boolean z, String str) {
        ((SoftInputManager) this.f6436b).blockToShow(z, str);
    }
}
