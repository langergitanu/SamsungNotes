package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.base.widget.setting.view.BaseWidgetSettingView;
import com.samsung.android.support.senl.p148nt.base.winset.view.RoundCornerOverlayView;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieResource;
import com.samsung.android.support.senl.p148nt.base.winset.view.lottie.LottieWithMessageLayout;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.BaseComposerPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.VoiceDataRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiContextMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.action.AiResultCopyTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskActionSend;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskLoadDynamicTemplate;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSaveToGallery;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleViewManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolAiMenu;
import com.samsung.android.support.senl.p148nt.composer.main.base.widget.view.AnchorPosition;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesContentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption.SDocEncryptionHelper;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.service.NotesDocumentServiceIntentHandler;
import com.samsung.android.support.senl.p148nt.stt.presenter.AiMenuSTTProcessListener;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.word.base.FileInsertHelper;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import com.yubico.yubikit.android.transport.usb.UsbYubiKeyDevice;
import com.yubico.yubikit.core.util.Callback;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8928b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6462a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6463b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6464c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f6465d;

    public /* synthetic */ RunnableC8928b(Object obj, int i, Object obj2, Object obj3) {
        this.f6462a = i;
        this.f6465d = obj;
        this.f6463b = obj2;
        this.f6464c = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6462a) {
            case 0:
                SmCopyTask.runOnThread$lambda$3((SmCopyTask) this.f6465d, (Ref.ObjectRef) this.f6463b, (Ref.ObjectRef) this.f6464c);
                break;
            case 1:
                SmCutTask.runOnThread$lambda$3((SmCutTask) this.f6465d, (Ref.ObjectRef) this.f6463b, (Ref.ObjectRef) this.f6464c);
                break;
            case 2:
                SmPasteTask.pasteSpenObjects$lambda$1((SmPasteTask) this.f6465d, (ArrayList) this.f6463b, (PointF) this.f6464c);
                break;
            case 3:
                BaseWidgetSettingView.updateRoundCornerViewHeight$lambda$9((View) this.f6465d, (View) this.f6463b, (RoundCornerOverlayView) this.f6464c);
                break;
            case 4:
                LottieWithMessageLayout.updateMessageView$lambda$0((LottieWithMessageLayout) this.f6465d, (LottieResource.MessageInfo) this.f6463b, (TextView) this.f6464c);
                break;
            case 5:
                ((CoeditHandlerManager) this.f6465d).lambda$releaseHandler$2((String) this.f6463b, (String) this.f6464c);
                break;
            case 6:
                ((CoeditHandlerManager) this.f6465d).lambda$registerRunningStateListener$3((String) this.f6463b, (CoeditHandlerManager.RunningStateListener) this.f6464c);
                break;
            case 7:
                ((BaseComposerPresenter) this.f6465d).lambda$onActivityCreated$0((Activity) this.f6463b, (Bundle) this.f6464c);
                break;
            case 8:
                ((AiContextMenuPresenter) this.f6465d).lambda$executeTranslateWithOverlay$12((String) this.f6463b, (Runnable) this.f6464c);
                break;
            case 9:
                StickyMemoManager.OnPageUpdateListenerImpl.onDeletedPages$lambda$2((StickyMemoManager.OnPageUpdateListenerImpl) this.f6465d, (StickyMemoManager) this.f6463b, (PageManager.PageUpdateState) this.f6464c);
                break;
            case 10:
                ((HwToolbarPresenter) this.f6465d).lambda$showAiAssistMenu$4((View) this.f6463b, (AnchorPosition) this.f6464c);
                break;
            case 11:
                VoiceRecordListPresenter.updateDialogFragment$lambda$1((View) this.f6465d, (VoiceRecordListPresenter) this.f6463b, (VoiceDataRenameDialogPresenter) this.f6464c);
                break;
            case 12:
                ((TaskActionSend) this.f6465d).lambda$executeTask$1((TaskActionSend.InputValues) this.f6463b, (Context) this.f6464c);
                break;
            case 13:
                TaskLoadDynamicTemplate.executeTask$lambda$1((TaskLoadDynamicTemplate) this.f6465d, (String) this.f6463b, (TaskLoadDynamicTemplate.InputValues) this.f6464c);
                break;
            case 14:
                ((TaskSaveToGallery) this.f6465d).lambda$executeTask$1((TaskSaveToGallery.InputValues) this.f6463b, (SpenObjectBase) this.f6464c);
                break;
            case 15:
                ((TaskWebClip) this.f6465d).lambda$createPdf$2((Context) this.f6463b, (String) this.f6464c);
                break;
            case 16:
                NoteStyleLayout.updateStyleContainerLayout$lambda$4((View) this.f6465d, (NoteStyleLayout) this.f6463b, (View) this.f6464c);
                break;
            case 17:
                NoteStyleLayout.updatePagePreview$lambda$3$lambda$2((View) this.f6465d, (NoteStyleLayout) this.f6463b, (DocumentPageRatio.PageRatioType) this.f6464c);
                break;
            case 18:
                ((TitleViewManager) this.f6465d).lambda$getTitleTextContainerBottom$3((Rect) this.f6463b, (TitleViewManager.TitleContainerBottomCallback) this.f6464c);
                break;
            case 19:
                QuickToolAiMenu.onNoteAssistClick$lambda$11((QuickToolAiMenu) this.f6465d, (QuickToolAiMenu.NoteAssistAction) this.f6463b, (View) this.f6464c);
                break;
            case 20:
                ((NotesDocumentServiceIntentHandler) this.f6465d).lambda$removeCacheAndResave$3((HashSet) this.f6463b, (String) this.f6464c);
                break;
            case 21:
                STTPresenter.updateRealtimeView$lambda$53$lambda$52((STTPresenter) this.f6465d, (SpenVoiceData) this.f6463b, (AiMenuSTTProcessListener) this.f6464c);
                break;
            case 22:
                STTPresenter.saveRealtimeData$lambda$56$lambda$55((STTPresenter) this.f6465d, (AiMenuSTTProcessListener) this.f6463b, (Ref.IntRef) this.f6464c);
                break;
            case 23:
                FileInsertHelper.insertFile$lambda$0((FileInsertHelper) this.f6465d, (CancellationSignal) this.f6463b, (String) this.f6464c);
                break;
            case 24:
                CoreNodeRenderer.lambda$render$0((HtmlWriter) this.f6465d, (Heading) this.f6463b, (NodeRendererContext) this.f6464c);
                break;
            case 25:
                ((NfcYubiKeyDevice) this.f6465d).lambda$requestConnection$1((Class) this.f6463b, (Callback) this.f6464c);
                break;
            case 26:
                ((UsbYubiKeyDevice) this.f6465d).lambda$requestConnection$1((Class) this.f6463b, (Callback) this.f6464c);
                break;
            case 27:
                SDocEncryptionHelper.lambda$convertEncryptContentTo32bit$1((SDocEncryptionHelper) this.f6465d, (String[]) this.f6463b, (String) this.f6464c);
                break;
            case 28:
                ((SDocEncryptionHelper) this.f6465d).lambda$updateDB$0((NotesDocumentRepository) this.f6463b, (NotesContentRepository) this.f6464c);
                break;
            default:
                AiResultCopyTask.runOnThread$lambda$2((AiResultCopyTask) this.f6465d, (Ref.ObjectRef) this.f6463b, (Ref.ObjectRef) this.f6464c);
                break;
        }
    }
}
