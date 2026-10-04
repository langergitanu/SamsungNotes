package com.samsung.android.model.contractimpl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.samsung.android.app.notes.sync.coedit.controllers.C6666b;
import com.samsung.android.app.notes.sync.contentsharing.controllers.C6684b;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.synchronization.controllers.C6896g;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.app.notes.widget.broadcast.WidgetBroadcast;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IServerNoteInfoListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncProgressListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.TemporalServerNoteInfo;
import com.samsung.android.support.senl.p148nt.base.common.sync.UserInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p026F1.C0099c;
import p042J1.C0145c;
import p044K.C0158a;
import p052M.C0171a;
import p066P2.RunnableC0201c;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;
import p079T.AbstractC0298p;
import p079T.C0296n;
import p207n1.C13540g;
import p207n1.C13541h;
import p244u1.C14477a;
import p249v1.C14499b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class RequestSyncContractImpl implements RequestSyncContract {
    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public String getAccountGuid(Context context) {
        return C13541h.m14287e().m14294h();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void initPreferenceMDESupported() {
        NotesUtils.initPreferenceMDESupported();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isAccountLogined(Context context) {
        return ((C13540g) C13541h.m14287e().f9588a).m14285a();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isAutoSyncPossible() {
        return C0158a.m407a().m413c();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isCoeditFeatureSupported(Context context) {
        return C0158a.m409d(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isCoeditWiFiSyncOnlyAndNotWiFiConnected(Context context) {
        return C0145c.m333r(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isDataCallNotLimitedForApp() {
        return C0158a.m407a().m414e();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isDataNetworkAvailable(Context context) {
        return C0145c.m334s(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isSesAvailable(Context context) {
        return C0158a.m412j(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isSyncEnableMode() {
        return C0158a.m407a().m417k();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isWiFiAvailable(Context context) {
        return C0145c.m297E(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean isWiFiSyncOnlyAndNotWiFiConnected(Context context) {
        return C0145c.m299G(context) && !C0145c.m298F(context);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void notifyOnDocumentClosed() {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        if (C0158a.m407a().m416i()) {
            Debugger.m8615i("SyncManager", "requestSyncForMsFeed()");
            c14477aM15065b.f10283a.m5100j(new C0099c(4096));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestCoeditTitleUpdate(String str, String str2, String str3) {
        AbstractC0291i.f754c.execute(new RunnableC0201c(str, 3, str3, str2));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestCoeditUpdateItemData(String str, String str2, String str3) {
        NotesDocumentEntity notesDocumentEntityM9f;
        Context applicationContext = BaseUtils.getApplicationContext();
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return;
        }
        Debugger.m8607d("Mde$SesShareUtil", "coeditUpdateItemData docUuid : " + str2);
        ArrayList arrayList = new ArrayList();
        SharedItem sharedItemByItemId = SesCoeditShareReadResolver.getInstance().getSharedItemByItemId(applicationContext, str, str3);
        if (sharedItemByItemId == null) {
            return;
        }
        if (str2 != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext, str2);
            AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
        } else {
            notesDocumentEntityM9f = null;
        }
        String strM583e = AbstractC0298p.m583e(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getTitle() : "");
        StringBuilder sb = new StringBuilder("coeditUpdateItemData  , time : ");
        sb.append(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getLastModifiedAt() : -1L);
        sb.append(" , item time : ");
        sb.append(sharedItemByItemId.getModifiedTime());
        Debugger.m8607d("Mde$SesShareUtil", sb.toString());
        if (!AbstractC0298p.m585g(str2, sharedItemByItemId, strM583e)) {
            if (sharedItemByItemId.getModifiedTime() == (notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getLastModifiedAt() : -1L)) {
                return;
            }
        }
        if (TextUtils.isEmpty(strM583e)) {
            strM583e = AbstractC0291i.m567d(applicationContext, strM583e, str, sharedItemByItemId.getCreatedTime());
        }
        ShareApi.SharedItemUpdateWithUriListRequest sharedItemUpdateWithUriListRequest = new ShareApi.SharedItemUpdateWithUriListRequest(str3, strM583e);
        sharedItemUpdateWithUriListRequest.setMemo(sharedItemByItemId.getMemo());
        HashMap map = new HashMap();
        map.put("uuid", str2);
        map.put("lastModifiedAt", Long.valueOf(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : 0L));
        map.put("createdAt", Long.valueOf(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCreatedAt() : -1L));
        map.put("DoclastModifiedAt", Long.valueOf(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getLastModifiedAt() : -1L));
        UserInfo coeditNoteUserInfo = SesCoeditShareReadResolver.getInstance().getCoeditNoteUserInfo(applicationContext, str, str3);
        if (coeditNoteUserInfo != null) {
            map.put("creatorName", coeditNoteUserInfo.getCreatorName());
        } else {
            map.put("creatorName", "");
        }
        sharedItemUpdateWithUriListRequest.setMetaData(map);
        arrayList.add(sharedItemUpdateWithUriListRequest);
        try {
            AbstractC0267s.m543a().requestSharedItemWithUriListUpdate(str, arrayList, new C0296n(str2), null, null);
            if (SesCoeditShareReadResolver.getInstance().getStandAlone(str)) {
                ConcurrentSkipListSet concurrentSkipListSet = AbstractC0291i.f752a;
                AbstractC0267s.m543a().requestSpaceUpdate(str, "Group://Standalone " + strM583e, "", (ShareApi.SpaceResultCallback) null);
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("coeditUpdateTitle"), "Mde$SesShareUtil");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestDeleteCoeditNoteDataAllAndDownload(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        NotesDocumentEntity notesDocumentEntityM9f;
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        String mdeItemId = notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getMdeItemId() : "";
        AbstractC0291i.m566c(context, str, 6);
        CoeditNoteUpDownloader.getInstance().requestDownloadAddedNoteFromComposer(str2, mdeItemId, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestServerNoteInfo(String str, IServerNoteInfoListener iServerNoteInfoListener) {
        C14477a.m15065b().getClass();
        C14477a.m15067f(str, iServerNoteInfoListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean requestShareBackground(String str) {
        C0171a.m429a().m433e(str, false);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestShareDelete(@NonNull Context context, String str, @NonNull List<String> list) {
        C0171a c0171aM429a = C0171a.m429a();
        c0171aM429a.getClass();
        if (!C0145c.m333r(BaseUtils.getApplicationContext())) {
            C6684b c6684b = c0171aM429a.f543a;
            c6684b.getClass();
            c6684b.m4777a(new C6906i(str, list));
        }
        WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(context, list);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestShareDeleteCoedit(@NonNull Context context, String str, @NonNull List<String> list) {
        ((C6666b) C0073a.m194g().f254b).m4728a(str, list);
        WidgetBroadcast.sendDeleteUUIDWidgetBroadcast(context, list);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean requestSyncBackground() {
        C14477a.m15065b().m15071g(null);
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public boolean requestSyncByModification() {
        C14477a.m15065b().m15073i();
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestSyncDownForServerNoteTemporarily(TemporalServerNoteInfo temporalServerNoteInfo) {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncDownForServerNoteTemporarily() : " + temporalServerNoteInfo.getDocUuid() + ", fullFolderPath = " + temporalServerNoteInfo.getFullFolderPath());
        C0099c c0099c = new C0099c(2112);
        c0099c.f326e = temporalServerNoteInfo;
        c14477aM15065b.f10283a.m5100j(c0099c);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestSyncDownImmediately(String str) {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncDownImmediately() : " + str);
        c14477aM15065b.m15074j(str, null);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestSyncForConflictedNote(String str, int i) {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncForConflictedNote() : " + str + " , conflictStrategy = " + i);
        C0099c c0099c = new C0099c(64);
        c0099c.f325d = str;
        c0099c.f324c = i;
        c14477aM15065b.f10283a.m5100j(c0099c);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestSyncForServerPolling() {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncForServerPolling()");
        C6896g c6896g = c14477aM15065b.f10283a;
        if (c6896g.m5099h()) {
            c6896g.m5100j(new C0099c(1));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestSyncUpFirst(String str) {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncUpFirst() : " + str);
        if (UUIDUtils.isGenUuid(str)) {
            Debugger.m8615i("SyncManager", "requestSyncUpFirst() : passed due to the GEN UUID!");
            return;
        }
        C0099c c0099c = new C0099c(64);
        c0099c.f323b = str;
        c14477aM15065b.f10283a.m5100j(c0099c);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void requestSyncWithoutCancel() {
        C14477a c14477aM15065b = C14477a.m15065b();
        c14477aM15065b.getClass();
        Debugger.m8615i("SyncManager", "requestSyncWithoutCancel()");
        c14477aM15065b.f10283a.m5100j(new C0099c(16));
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void setCategoryOrderModifiedTime(long j) {
        C0145c.m308P(j, "CategoryOrderTime", "CategoryOrderTimeKey");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void setRootServerTimestamp(long j) {
        C0145c.m308P(j, "sync_v2_pref", "folderLastRootServerTimestamp");
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void setSyncEnableByUserClick(boolean z) {
        C14477a.m15065b().m15075k(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void stopCoeditDownloadBySmartSwitch(SyncProgressListener syncProgressListener) {
        CoeditNoteUpDownloader.getInstance().stopDownloadCoeditBySmartSwitch(syncProgressListener);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.RequestSyncContract
    public void stopSyncBySmartSwitch(SyncProgressListener syncProgressListener) {
        C6896g c6896g = C14477a.m15065b().f10283a;
        if (c6896g.m5099h()) {
            syncProgressListener.onEnded(0);
            return;
        }
        c6896g.getClass();
        ArrayList arrayList = C14499b.f10313g;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        ArrayList arrayList2 = C14499b.f10313g;
                        arrayList2.add(syncProgressListener);
                        Debugger.m8607d("SyncLogic", "Added Sync progress listener - size : " + arrayList2.size());
                        break;
                    }
                    if (((SyncProgressListener) it.next()).equals(syncProgressListener)) {
                    }
                }
            } finally {
            }
        }
        c6896g.mo5089a(110);
    }
}
