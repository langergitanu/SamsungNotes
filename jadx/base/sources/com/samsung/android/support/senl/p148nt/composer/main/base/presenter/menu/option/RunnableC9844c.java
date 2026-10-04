package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.samsung.android.sdk.pen.document.changedInfo.SpenObjectChangedInfo;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.SpanStates;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.RunnableC9874e;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.controller.DynamicTemplateController$objectEventListener$1;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordingEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareCacheHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.RestoreNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCommitContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskPhotoEditor;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskQuickNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSaveToGallery;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskStyleChanger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerCacheFileUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.BaseComposerFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$updateActivityContainer$1$2;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStickerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.OptionMenuNotesAssist;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.generate.AiDrawingContentLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.p157ai.drawing.guide.AiDrawingGuide;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.CommonTemplateStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.item.HwToolbarItemManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.richtext.RtToolbarMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandOptionMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandSubMenu;
import java.io.File;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9844c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7012a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7013b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7014c;

    public /* synthetic */ RunnableC9844c(RunnableC9874e runnableC9874e, StickyMemoView stickyMemoView) {
        this.f7012a = 1;
        this.f7013b = runnableC9874e;
        this.f7014c = stickyMemoView;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        switch (this.f7012a) {
            case 0:
                ((OptionMenuPresenter) this.f7014c).lambda$saveAndExecute$1((Runnable) this.f7013b);
                break;
            case 1:
                StickyMemoManager.addStickyMemo$lambda$8((Runnable) this.f7013b, (StickyMemoView) this.f7014c);
                break;
            case 2:
                StickyMemoManager.OnPageUpdateListenerImpl.onInsertedPages$lambda$1((StickyMemoManager.OnPageUpdateListenerImpl) this.f7014c, (StickyMemoManager) this.f7013b);
                break;
            case 3:
                DynamicTemplateController$objectEventListener$1.onObjectChanged$lambda$0((DynamicTemplateController) this.f7014c, (SpenObjectChangedInfo) this.f7013b);
                break;
            case 4:
                VoiceRecordListPresenter.updateDialogFragment$lambda$2((View) this.f7014c, (VoiceRecordListPresenter) this.f7013b);
                break;
            case 5:
                VoiceRecordListPresenter.startNewRecording$lambda$0((Fragment) this.f7014c, (String[]) this.f7013b);
                break;
            case 6:
                VoiceRecordingEventListenerImpl.updateMediaSession$lambda$1((VoiceRecordingEventListenerImpl) this.f7014c, (String) this.f7013b);
                break;
            case 7:
                ((ShareCacheHelper) this.f7014c).lambda$removeInnerCache$0((File) this.f7013b);
                break;
            case 8:
                ((RestoreNote) this.f7014c).lambda$runRestoreNoteOnThread$0((WeakReference) this.f7013b);
                break;
            case 9:
                ((ServiceContractImpl) this.f7014c).lambda$executeFinishComposerBySyncForDeletedFromServer$6((Activity) this.f7013b);
                break;
            case 10:
                ((TaskCommitContent) this.f7014c).lambda$executeTask$1((TaskCommitContent.InputValues) this.f7013b);
                break;
            case 11:
                ((TaskPhotoEditor) this.f7014c).lambda$executeTask$0((TaskPhotoEditor.InputValues) this.f7013b);
                break;
            case 12:
                ((TaskQuickNote) this.f7014c).lambda$executeTask$0((TaskQuickNote.InputValues) this.f7013b);
                break;
            case 13:
                ((TaskSaveToGallery) this.f7014c).lambda$executeTask$0((TaskSaveToGallery.InputValues) this.f7013b);
                break;
            case 14:
                ((TaskStyleChanger) this.f7014c).lambda$executeTask$0((TaskStyleChanger.InputValues) this.f7013b);
                break;
            case 15:
                ComposerCacheFileUtil.lambda$trimPageThumbnail$5((File[]) this.f7014c, (Context) this.f7013b);
                break;
            case 16:
                ((BaseComposerFragment) this.f7014c).lambda$onConfigurationChanged$3((Configuration) this.f7013b);
                break;
            case 17:
                ((AiDrawingContentLayout) this.f7014c).lambda$setInputImage$2((Bitmap) this.f7013b);
                break;
            case 18:
                ((AiDrawingGuide) this.f7014c).lambda$onTouchEvent$1((MotionEvent) this.f7013b);
                break;
            case 19:
                NoteStyleActivity$updateActivityContainer$1$2.onPreDraw$lambda$0((ViewGroup) this.f7014c, (NoteStyleActivity) this.f7013b);
                break;
            case 20:
                CoverStickerPresenter.updateSpanCount$lambda$1((CoverStickerPresenter) this.f7014c, (RecyclerView) this.f7013b);
                break;
            case 21:
                ((OptionMenuNotesAssist) this.f7014c).lambda$showPopup$0((Activity) this.f7013b);
                break;
            case 22:
                CommonTemplateStyleLayout.calculateTabWidth$lambda$6$lambda$5((TabLayout) this.f7014c, (View) this.f7013b);
                break;
            case 23:
                ((HwToolbarItemManager) this.f7014c).lambda$toolbarMovePosition$0((View) this.f7013b);
                break;
            case 24:
                QuickTool.onConfigurationChanged$lambda$8((QuickToolContainer) this.f7014c, (QuickTool) this.f7013b);
                break;
            case 25:
                ((RtToolbarMenu) this.f7014c).lambda$restore$4((Bundle) this.f7013b);
                break;
            case 26:
                ((RtToolbarMenu) this.f7014c).lambda$update$3((SpanStates) this.f7013b);
                break;
            case 27:
                VoiceRecordExpandMenu.updateRecording$lambda$9((Activity) this.f7014c, (String[]) this.f7013b);
                break;
            case 28:
                VoiceRecordExpandOptionMenu.showPopUp$lambda$15((VoiceRecordExpandOptionMenu) this.f7014c, (View) this.f7013b);
                break;
            default:
                ((VoiceRecordExpandSubMenu) this.f7014c).notifyAdapter((Runnable) this.f7013b);
                break;
        }
    }

    public /* synthetic */ RunnableC9844c(Object obj, Object obj2, int i) {
        this.f7012a = i;
        this.f7014c = obj;
        this.f7013b = obj2;
    }
}
