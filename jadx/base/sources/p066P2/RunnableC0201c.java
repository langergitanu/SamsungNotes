package p066P2;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.room.QueryInterceptorDatabase;
import androidx.work.ListenableWorker;
import androidx.work.WorkRequest;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.WorkerUpdater;
import androidx.work.impl.WorkerWrapper;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.multiprocess.RemoteWorkerWrapper;
import androidx.work.multiprocess.RemoteWorkerWrapperKt;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.gson.Gson;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.sdk.deepsky.contract.feedback.FeedbackType;
import com.samsung.android.app.sdk.deepsky.donation.ActionDonation;
import com.samsung.android.app.sdk.deepsky.donation.DonationImpl;
import com.samsung.android.app.sdk.deepsky.donation.DonationListener;
import com.samsung.android.app.sdk.deepsky.feedback.FeedbackRequest;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionView;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SuggestionViewConfig;
import com.samsung.android.app.sdk.deepsky.suggestion.view.SurfacePackageUpdater;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNearbyMyDeviceWrapper;
import com.samsung.android.mcf.continuity.interfaces.ContinuityNetworkPolicyWrapper;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.scs.p142ai.extension.lts.LongTextSummarizer;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.GuidingLightEffect;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.MultiRippleController;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimation;
import com.samsung.android.support.notes.bixby.bixby2.action.BixbyDeleteAction;
import com.samsung.android.support.notes.bixby.bixby2.aid.ActionResult;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.inapp.InAppCollaborationActivity;
import com.samsung.android.support.senl.p148nt.app.lock.ScreenLockManager;
import com.samsung.android.support.senl.p148nt.app.lock.presenter.create.CreatePasswordPresenter;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holder.SubFolderHolder;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.AdapterManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.TipCardAdapter;
import com.samsung.android.support.senl.p148nt.app.settings.about.AboutActivity;
import com.samsung.android.support.senl.p148nt.app.settings.detail.SettingsSyncToMicrosoftPrefFragment;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.UserInfo;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p001A.AbstractC0000a;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;
import p079T.AbstractC0298p;
import p079T.C0288f;

/* JADX INFO: renamed from: P2.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC0201c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f622a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f623b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f624c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f625d;

    public /* synthetic */ RunnableC0201c(Object obj, int i, Object obj2, Object obj3) {
        this.f622a = i;
        this.f623b = obj;
        this.f624c = obj2;
        this.f625d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NotesDocumentEntity notesDocumentEntityM9f;
        NotesDocumentEntity notesDocumentEntityM9f2;
        switch (this.f622a) {
            case 0:
                ((TipCardAdapter) this.f623b).lambda$removeTipCard$1((List) this.f624c, (Runnable) this.f625d);
                break;
            case 1:
                ((TipCardAdapter) this.f623b).lambda$addTipCard$0((TipCard) this.f624c, (TipCardAdapter.AddTipCardCallback) this.f625d);
                break;
            case 2:
                AboutActivity.applyOpenSourceLayout$lambda$12((AboutActivity) this.f623b, (View) this.f624c, (View) this.f625d);
                break;
            case 3:
                String str = (String) this.f623b;
                String str2 = (String) this.f624c;
                String str3 = (String) this.f625d;
                Context applicationContext = BaseUtils.getApplicationContext();
                if (!TextUtils.isEmpty(str)) {
                    String strM583e = AbstractC0298p.m583e(str2);
                    if (str3 != null) {
                        notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext, str3);
                        AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
                    } else {
                        notesDocumentEntityM9f = null;
                    }
                    String mdeItemId = notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getMdeItemId() : "";
                    Debugger.m8607d("Coedit$SesCoeditUtil", "coeditTitleUpdate docUuid : " + str3);
                    ArrayList arrayList = new ArrayList();
                    SharedItem sharedItemByItemId = SesCoeditShareReadResolver.getInstance().getSharedItemByItemId(applicationContext, str, mdeItemId);
                    if (sharedItemByItemId != null) {
                        if (str3 != null) {
                            notesDocumentEntityM9f2 = AbstractC0000a.m9f(applicationContext, str3);
                            AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
                        } else {
                            notesDocumentEntityM9f2 = null;
                        }
                        StringBuilder sb = new StringBuilder("coeditTitleUpdate  , time : ");
                        sb.append(notesDocumentEntityM9f2 != null ? notesDocumentEntityM9f2.getLastModifiedAt() : -1L);
                        sb.append(" , item time : ");
                        sb.append(sharedItemByItemId.getModifiedTime());
                        Debugger.m8607d("Coedit$SesCoeditUtil", sb.toString());
                        if (AbstractC0298p.m585g(str3, sharedItemByItemId, strM583e)) {
                            if (TextUtils.isEmpty(strM583e)) {
                                strM583e = AbstractC0291i.m567d(applicationContext, strM583e, str, sharedItemByItemId.getCreatedTime());
                            }
                            ShareApi.SharedItemUpdateWithUriListRequest sharedItemUpdateWithUriListRequest = new ShareApi.SharedItemUpdateWithUriListRequest(mdeItemId, strM583e);
                            sharedItemUpdateWithUriListRequest.setMemo(sharedItemByItemId.getMemo());
                            HashMap map = new HashMap();
                            map.put("uuid", str3);
                            map.put("lastModifiedAt", Long.valueOf(notesDocumentEntityM9f2 != null ? notesDocumentEntityM9f2.getServerTimestamp().longValue() : 0L));
                            map.put("createdAt", Long.valueOf(notesDocumentEntityM9f2 != null ? notesDocumentEntityM9f2.getCreatedAt() : -1L));
                            map.put("DoclastModifiedAt", Long.valueOf(notesDocumentEntityM9f2 != null ? notesDocumentEntityM9f2.getLastModifiedAt() : -1L));
                            UserInfo coeditNoteUserInfo = SesCoeditShareReadResolver.getInstance().getCoeditNoteUserInfo(applicationContext, str, mdeItemId);
                            if (coeditNoteUserInfo != null) {
                                map.put("creatorName", coeditNoteUserInfo.getCreatorName());
                            } else {
                                map.put("creatorName", "");
                            }
                            sharedItemUpdateWithUriListRequest.setMetaData(map);
                            arrayList.add(sharedItemUpdateWithUriListRequest);
                            try {
                                AbstractC0267s.m543a().requestSharedItemWithUriListUpdate(str, arrayList, new C0288f(str3), null, null);
                                if (SesCoeditShareReadResolver.getInstance().getStandAlone(str)) {
                                    AbstractC0267s.m543a().requestSpaceUpdate(str, "Group://Standalone " + strM583e, "", (ShareApi.SpaceResultCallback) null);
                                }
                            } catch (Exception e) {
                                AbstractC0000a.m21r(e, new StringBuilder("coeditUpdateTitle"), "Coedit$SesCoeditUtil");
                                return;
                            }
                            break;
                        }
                    }
                }
                break;
            case 4:
                DonationImpl.removeDonatedData$lambda$3((DonationImpl) this.f623b, (String) this.f624c, (String) this.f625d);
                break;
            case 5:
                DonationImpl.donate$lambda$1((DonationImpl) this.f623b, (ActionDonation) this.f624c, (DonationListener) this.f625d);
                break;
            case 6:
                FeedbackRequest.send$lambda$0((FeedbackRequest) this.f623b, (ComponentName) this.f624c, (FeedbackType) this.f625d);
                break;
            case 7:
                QueryInterceptorDatabase.query$lambda$7((QueryInterceptorDatabase) this.f623b, (String) this.f624c, (Object[]) this.f625d);
                break;
            case 8:
                QueryInterceptorDatabase.execSQL$lambda$11((QueryInterceptorDatabase) this.f623b, (String) this.f624c, (ArrayList) this.f625d);
                break;
            case 9:
                ((Processor) this.f623b).lambda$startWork$1((ListenableFuture) this.f624c, (WorkerWrapper) this.f625d);
                break;
            case 10:
                WorkerUpdater.updateWorkImpl$lambda$3((SettableFuture) this.f623b, (WorkManagerImpl) this.f624c, (WorkRequest) this.f625d);
                break;
            case 11:
                RemoteWorkerWrapperKt.RemoteWorkerWrapper$lambda$1$lambda$0((SettableFuture) this.f623b, (ListenableWorker) this.f624c, (RemoteWorkerWrapper) this.f625d);
                break;
            case 12:
                ((ContinuityAdapterImpl) this.f623b).lambda$bindService$2((ContinuityAdapter.ServiceStateListener) this.f624c, (Context) this.f625d);
                break;
            case 13:
                ((ContinuityConnection) this.f623b).lambda$sendMessage$6((ProtoContinuityPacket.ContinuityPacket) this.f624c, (ContinuitySessionMessageManager.SendMessageCallback) this.f625d);
                break;
            case 14:
                ((ContinuitySession.C71963) this.f623b).lambda$onPeerConnectionRequested$0((ContinuityNearbyMyDeviceWrapper) this.f624c, (ContinuityNetworkPolicyWrapper) this.f625d);
                break;
            case 15:
                ((ContinuitySession.C71985) this.f623b).lambda$onPacketReceived$2((ProtoContinuityPacket.ContinuityPacket) this.f624c, (String) this.f625d);
                break;
            case 16:
                ((ContinuitySessionManager.PeerConnectionRequestListener) this.f623b).onPeerConnectionRequested((ContinuityNearbyMyDevice) this.f624c, (ContinuityNetworkPolicy) this.f625d);
                break;
            case 17:
                SuggestionView.setViewConfig$lambda$1((SuggestionView) this.f623b, (SuggestionViewConfig) this.f624c, (SurfacePackageUpdater) this.f625d);
                break;
            case 18:
                ((LongTextSummarizer) this.f623b).lambda$process$2((String) this.f624c, (AtomicReference) this.f625d);
                break;
            case 19:
                GuidingLightEffect.show$lambda$2((GuidingLightEffect.ShowAnimationType) this.f623b, (GuidingLightEffect) this.f624c, (Long) this.f625d);
                break;
            case 20:
                MultiRippleController.play$lambda$2((MultiRippleController) this.f623b, (RippleAnimation) this.f624c, (Runnable) this.f625d);
                break;
            case 21:
                BixbyDeleteAction.execute$lambda$3((ActionResult) this.f623b, (Gson) this.f624c, (BixbyDeleteAction) this.f625d);
                break;
            case 22:
                InAppCollaborationActivity.updateUIMode$lambda$1((String) this.f623b, (View) this.f624c, (InAppCollaborationActivity) this.f625d);
                break;
            case 23:
                ScreenLockManager.onActivityStopped$lambda$2((ScreenLockManager) this.f623b, (Activity) this.f624c, (Context) this.f625d);
                break;
            case 24:
                CreatePasswordPresenter.savePassword$lambda$0((CreatePasswordPresenter) this.f623b, (Context) this.f624c, (String) this.f625d);
                break;
            case 25:
                SubFolderHolder.showSubFolderHolderList$lambda$11$lambda$10((View) this.f623b, (List) this.f624c, 450L, (Interpolator) this.f625d, 200L);
                break;
            case 26:
                ((AdapterManager) this.f623b).lambda$requestAllDeleteConvertedNotes$2((ArrayList) this.f624c, (ArrayList) this.f625d);
                break;
            case 27:
                ((NotesPresenter) this.f623b).lambda$duplicateToDeviceFailed$5((Context) this.f624c, (String) this.f625d);
                break;
            default:
                SettingsSyncToMicrosoftPrefFragment.C87721.onStart$lambda$0((WorkerTask) this.f623b, (SettingsSyncToMicrosoftPrefFragment) this.f624c, (SettingsSyncToMicrosoftPrefFragment.C87721) this.f625d);
                break;
        }
    }
}
