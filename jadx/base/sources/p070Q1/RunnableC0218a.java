package p070Q1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Configuration;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.WorkGenerationalId;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.microsoft.identity.common.internal.fido.AuthFidoChallengeHandler;
import com.samsung.android.app.notes.widget.setting.presenter.WidgetSettingPresenter;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.docscan.detect.CameraFragment;
import com.samsung.android.support.senl.docscan.detect.CameraFragment$captureStillPicture$pictureCallback$1;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.HandoffLaunchManager;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.MainHandoffManager;
import com.samsung.android.support.senl.p148nt.app.settings.common.component.SettingsBaseFragment;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.HandoffUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLLMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.SCSLVMRequesterImpl;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.type.SCSRequesterType;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.VoiceRecordExpandSubMenu;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertResultData;
import com.samsung.android.support.senl.p148nt.stt.presenter.STTPresenter;
import com.samsung.android.support.senl.p148nt.word.base.OfficeView;
import com.samsung.scsp.common.Holder;
import com.samsung.scsp.pam.kps.lite.ScspKpsLite;
import com.vladsch.flexmark.ast.DelimitedLinkNode;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeRepositoryFormatter;
import com.vladsch.flexmark.formatter.internal.CoreNodeFormatter;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.util.ast.Node;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import p079T.AbstractC0291i;
import p079T.InterfaceC0290h;

/* JADX INFO: renamed from: Q1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0218a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f649a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f650b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f651c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f652d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f653e;

    public /* synthetic */ RunnableC0218a(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        this.f649a = i;
        this.f650b = obj;
        this.f651c = obj2;
        this.f652d = obj3;
        this.f653e = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f649a) {
            case 0:
                WidgetSettingPresenter.updatePreviewAndSetting$lambda$3((WidgetSettingPresenter) this.f650b, (Bitmap) this.f651c, (Bitmap) this.f652d, (String) this.f653e);
                break;
            case 1:
                Schedulers.lambda$registerRescheduling$0((List) this.f650b, (WorkGenerationalId) this.f651c, (Configuration) this.f652d, (WorkDatabase) this.f653e);
                break;
            case 2:
                ((ContinuityAdapterImpl.ServiceConnectionC71851) this.f650b).lambda$onServiceConnected$0((Context) this.f651c, (IBinder) this.f652d, (ContinuityAdapter.ServiceStateListener) this.f653e);
                break;
            case 3:
                ((ContinuityConnection) this.f650b).lambda$addFileSocket$11((Socket) this.f651c, (String) this.f653e, (ContinuitySessionFileManager.FileInfoListener) this.f652d);
                break;
            case 4:
                ((ContinuitySessionManagerImpl) this.f650b).lambda$requestConnect$2((String) this.f653e, (ContinuityNetworkPolicy) this.f651c, (ContinuitySessionManager.PeerStatusListener) this.f652d);
                break;
            case 5:
                ((BaseTransientBottomBar) this.f650b).lambda$seslStartSuggestAnimation$3((SnackbarContentLayout) this.f651c, (TextView) this.f652d, (Button) this.f653e);
                break;
            case 6:
                AuthFidoChallengeHandler.respondToChallenge$lambda$0((String) this.f653e, (AuthFidoChallengeHandler) this.f650b, (String) this.f651c, (Map) this.f652d);
                break;
            case 7:
                CameraFragment.captureStillPicture$lambda$6((CameraCaptureSession) this.f650b, (CaptureRequest.Builder) this.f651c, (CameraFragment$captureStillPicture$pictureCallback$1) this.f652d, (CameraFragment) this.f653e);
                break;
            case 8:
                HandoffLaunchManager.handleHandoffData$lambda$12$lambda$11((String) this.f653e, (HandoffLaunchManager) this.f650b, (AppCompatActivity) this.f651c, (Runnable) this.f652d);
                break;
            case 9:
                MainHandoffManager.handleHandoffAction$lambda$0((Activity) this.f650b, (MainHandoffManager) this.f651c, (String) this.f653e, (String) this.f652d);
                break;
            case 10:
                SettingsBaseFragment.applyHighlight$lambda$9$lambda$8((SettingsBaseFragment) this.f650b, (String) this.f653e, (PreferenceGroup.PreferencePositionCallback) this.f651c, (RecyclerView) this.f652d);
                break;
            case 11:
                SettingsBaseFragment.applyHighlight$lambda$9((RecyclerView) this.f650b, (String) this.f653e, (Handler) this.f651c, (SettingsBaseFragment) this.f652d);
                break;
            case 12:
                SCSLLMRequesterImpl.requestText$lambda$0((String) this.f653e, (SCSLLMRequesterImpl) this.f650b, (SCSRequesterType) this.f651c, (Map) this.f652d);
                break;
            case 13:
                SCSLVMRequesterImpl.requestImage$lambda$0((Bundle) this.f650b, (SCSLVMRequesterImpl) this.f652d, (SCSRequesterType) this.f653e, (Bitmap) this.f651c);
                break;
            case 14:
                HandoffUtils.callHandoff$lambda$0((String) this.f653e, (String) this.f650b, (Bundle) this.f651c, (HandoffUtils.CallBack) this.f652d);
                break;
            case 15:
                AbstractC0291i.m564a((Context) this.f650b, (String) this.f653e, (List) this.f651c, (InterfaceC0290h) this.f652d, "LIST");
                break;
            case 16:
                ((AiDrawingManager) this.f650b).lambda$handleSelectionPositionUpdate$8((RectF) this.f651c, (String) this.f653e, (Runnable) this.f652d);
                break;
            case 17:
                HandleImage.lambda$markGenerativeEditImageByC2pa$0((String) this.f653e, (String) this.f650b, (String) this.f651c, (Rect) this.f652d);
                break;
            case 18:
                VoiceRecordExpandSubMenu.showRecordingListView$lambda$7((View) this.f650b, (VoiceRecordExpandSubMenu) this.f651c, (View) this.f652d, (Activity) this.f653e);
                break;
            case 19:
                STTPresenter.C115141.onResultWord$lambda$1((STTPresenter) this.f650b, (String) this.f653e, (SpenVoiceData) this.f651c, (FastConvertResultData) this.f652d);
                break;
            case 20:
                OfficeView.getExtractTextResult$lambda$0((List[]) this.f650b, (OfficeView) this.f651c, (String) this.f653e, (boolean[]) this.f652d);
                break;
            case 21:
                ((ScspKpsLite) this.f650b).lambda$requestKeySync$2((String) this.f653e, (String) this.f651c, (Holder) this.f652d);
                break;
            case 22:
                ((NodeRepositoryFormatter) this.f650b).lambda$renderReferenceBlockUnique$1((Node) this.f651c, (NodeFormatterContext) this.f652d, (MarkdownWriter) this.f653e);
                break;
            case 23:
                CoreNodeFormatter.lambda$renderAutoLink$5((MarkdownWriter) this.f650b, (String) this.f653e, (DelimitedLinkNode) this.f651c, (String) this.f652d);
                break;
            case 24:
                ((CoreNodeRenderer) this.f650b).lambda$renderLooseParagraph$8((Paragraph) this.f651c, (NodeRendererContext) this.f652d, (HtmlWriter) this.f653e);
                break;
            default:
                ((DefaultScheduler) this.f650b).lambda$schedule$1((TransportContext) this.f651c, (TransportScheduleCallback) this.f652d, (EventInternal) this.f653e);
                break;
        }
    }

    public /* synthetic */ RunnableC0218a(Bundle bundle, SCSLVMRequesterImpl sCSLVMRequesterImpl, SCSRequesterType sCSRequesterType, Bitmap bitmap) {
        this.f649a = 13;
        this.f650b = bundle;
        this.f652d = sCSLVMRequesterImpl;
        this.f653e = sCSRequesterType;
        this.f651c = bitmap;
    }

    public /* synthetic */ RunnableC0218a(Object obj, Object obj2, String str, Object obj3, int i) {
        this.f649a = i;
        this.f650b = obj;
        this.f651c = obj2;
        this.f653e = str;
        this.f652d = obj3;
    }

    public /* synthetic */ RunnableC0218a(Object obj, String str, Object obj2, Object obj3, int i) {
        this.f649a = i;
        this.f650b = obj;
        this.f653e = str;
        this.f651c = obj2;
        this.f652d = obj3;
    }

    public /* synthetic */ RunnableC0218a(String str, Object obj, Object obj2, Object obj3, int i) {
        this.f649a = i;
        this.f653e = str;
        this.f650b = obj;
        this.f651c = obj2;
        this.f652d = obj3;
    }
}
