package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.CoeditTrimLocalSDoc;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.CoeditStartManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteEventManager;
import com.samsung.android.support.senl.p148nt.coedit.caller.Event;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.BackgroundDownloadResponse;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadRequest;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadResponse;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.ExternalSnapState;
import com.samsung.android.support.senl.p148nt.coedit.control.common.UpdatePriority;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventManager;
import com.samsung.android.support.senl.p148nt.model.service.RestoreCacheManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import p001A.AbstractC0000a;
import p041J.AbstractC0142a;
import p042J1.AbstractC0155m;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;
import p079T.AbstractC0298p;
import p086V.C0322h;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WaitForDownloadHandler {
    private static final String TAG = "WaitForDownloadHandler";
    private final UpDownloaderContract mContract;
    private final Object mDownloadListLock = new Object();
    private CoeditTrimLocalSDoc mCoeditTrimLocalSDoc = null;
    private final List<DownloadRequest> mDownloadList = new CopyOnWriteArrayList();
    private final Executor mExecutor = AbstractC4539a.m3201k("WaitForDownloadHandler_handler");
    private final Handler mWaitForDownload = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForDownloadHandler.1
        private long mTrimRequestTime = 0;

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForDownloadHandler$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass1 implements IAuthInfoReqListener {
            public AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onReceived$0() {
                DownloadRequest downloadRequest;
                try {
                    try {
                        WaitForDownloadHandler.this.mContract.requestConnectSession();
                        while (!WaitForDownloadHandler.this.mDownloadList.isEmpty()) {
                            synchronized (WaitForDownloadHandler.this.mDownloadListLock) {
                                try {
                                    if (WaitForDownloadHandler.this.mDownloadList.isEmpty()) {
                                        downloadRequest = null;
                                    } else {
                                        downloadRequest = (DownloadRequest) WaitForDownloadHandler.this.mDownloadList.get(0);
                                        WaitForDownloadHandler.this.mDownloadList.remove(0);
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (downloadRequest != null) {
                                WaitForDownloadHandler.this.requestDownloadInternal(downloadRequest);
                            }
                        }
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - HandlerC90071.this.mTrimRequestTime;
                        if (jElapsedRealtime < 3600000) {
                            CoeditLogger.m8923i(WaitForDownloadHandler.TAG, "[CS9] handleMessage, onReceived() : No trim, et = " + jElapsedRealtime);
                        } else {
                            HandlerC90071.this.mTrimRequestTime = SystemClock.elapsedRealtime();
                            WaitForDownloadHandler.this.mCoeditTrimLocalSDoc = new CoeditTrimLocalSDoc();
                            WaitForDownloadHandler.this.mCoeditTrimLocalSDoc.execute(new Void[0]);
                        }
                    } catch (Exception e) {
                        CoeditLogger.m8920e(WaitForDownloadHandler.TAG, "[CS7-2] handleMessage, onReceived() : " + e.getMessage());
                    }
                } finally {
                    WaitForDownloadHandler.this.mContract.requestDisconnectSession();
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
            public void onError(@NonNull String str, @NonNull String str2) {
                CoeditLogger.m8920e(WaitForDownloadHandler.TAG, "[CS7-2] handleMessage, onError() : errCode = " + str + " , errMsg = " + str2);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
            public void onReceived(@NonNull String str, String str2) {
                CoeditLogger.m8923i(WaitForDownloadHandler.TAG, "[CS7] handleMessage, onReceived()");
                WaitForDownloadHandler.this.mExecutor.execute(new RunnableC9011a(this, 0));
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            CoeditLogger.m8923i(WaitForDownloadHandler.TAG, "[CS7] handleMessage");
            WaitForDownloadHandler.this.cancelCoeditTrimLocalSDoc();
            if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                RequestToSamsungAccountManager.INSTANCE.requestAuthInfo(new AnonymousClass1());
            } else {
                CoeditLogger.m8920e(WaitForDownloadHandler.TAG, "[CS7-2] handleMessage fail : wifi only mode restrict");
            }
        }
    };

    public WaitForDownloadHandler(UpDownloaderContract upDownloaderContract) {
        this.mContract = upDownloaderContract;
    }

    private void addOnlyNewSpaceIdToDownloadList(DownloadRequest downloadRequest, boolean z) {
        Iterator<DownloadRequest> it = this.mDownloadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadRequest next = it.next();
            if (downloadRequest.mSpaceId.equals(next.mSpaceId)) {
                if (next.mRunnable == null && downloadRequest.mRunnable == null) {
                    CoeditLogger.m8919d(TAG, "[CS7] addOnlyNewSpaceIdToDownloadList : exist!");
                    return;
                }
            }
        }
        if (z) {
            this.mDownloadList.add(0, downloadRequest);
        } else {
            this.mDownloadList.add(downloadRequest);
        }
        CoeditHandlerManager.getInstance().setBackgroundDownloading(true);
    }

    private void addOnlyNewSpaceIdToDownloadListFromComposer(DownloadRequest downloadRequest) {
        String str;
        Iterator<DownloadRequest> it = this.mDownloadList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DownloadRequest next = it.next();
            if (downloadRequest.mSpaceId.equals(next.mSpaceId) && (str = downloadRequest.mItemId) != null && str.equals(next.mItemId)) {
                if (next.mRunnable == null && downloadRequest.mRunnable == null) {
                    CoeditLogger.m8919d(TAG, "[CS7] addOnlyNewSpaceIdToDownloadListFromComposer : exist!");
                    return;
                }
            }
        }
        CoeditLogger.m8919d(TAG, "[CS7] addOnlyNewSpaceIdToDownloadListFromComposer " + downloadRequest.mSpaceId);
        this.mDownloadList.add(0, downloadRequest);
        CoeditHandlerManager.getInstance().setBackgroundDownloading(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadSpenWNoteOnFailed(@NonNull SharedItem sharedItem, String str, String str2, String str3, @NonNull DownloadRequest downloadRequest, String str4) {
        CoeditLogger.m8920e(TAG, "[CS7-2] downloadSpenWNote, onFailed(), itemId : " + sharedItem.getItemId() + ", uuid : " + str);
        CoeditConnectionUtils.deleteTempFile(str2);
        this.mContract.removeFromRunningNoteUuids(str, "requestDownloadInternal-onFailed");
        publishLinkSharingFailedEventByGroupId(str4);
        downloadRequest.onFailed(str);
        AbstractC0291i.m573j(str3, sharedItem.getItemId());
        CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadSpenWNoteOnFinished(String str, Context context, @NonNull SharedItem sharedItem, String str2, String str3, String str4, String str5, DownloadRequest downloadRequest) throws Throwable {
        String str6;
        String str7;
        String str8;
        C6747p c6747p;
        String str9;
        DownloadRequest downloadRequest2;
        String str10;
        String str11;
        WaitForDownloadHandler waitForDownloadHandler;
        UpDownloaderContract upDownloaderContract;
        long createdTime;
        long j;
        long modifiedTime;
        String itemId;
        String leaderId;
        Object obj;
        CoeditLogger.m8923i(TAG, "[CS7-1] requestDownloadInternal, onFinished() saveCoeditNote : uuid = " + str);
        C6747p c6747p2 = new C6747p(context);
        String strM387b = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(C0322h.m670a().f815a.getAppContext()), sharedItem.getItemId() + sharedItem.getSpaceId() + ".sdocx");
        c6747p2.m4869a();
        try {
            Map metaData = sharedItem.getMetaData();
            long jLongValue = (metaData == null || (obj = metaData.get("lastModifiedAt")) == null) ? 0L : ((Long) obj).longValue();
            createdTime = sharedItem.getCreatedTime();
            c6747p = c6747p2;
            j = jLongValue;
        } catch (ShareException e) {
            e = e;
            str6 = str2;
            str9 = str3;
            downloadRequest2 = downloadRequest;
            str8 = "requestDownloadInternal-onFinished";
            str10 = "[CS7-2] requestDownloadInternal, onFinished() : ";
            c6747p = c6747p2;
            str11 = TAG;
            waitForDownloadHandler = this;
            str7 = str5;
            try {
                CoeditLogger.m8920e(str11, str10 + e.getMessage());
                waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
                downloadRequest2.onFailed(str7);
                CoeditConnectionUtils.deleteTempFile(str4);
                c6747p.m4870b();
                upDownloaderContract = waitForDownloadHandler.mContract;
                upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
                AbstractC0291i.m573j(str6, sharedItem.getItemId());
                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
            } catch (Throwable th) {
                th = th;
                CoeditConnectionUtils.deleteTempFile(str4);
                c6747p.m4870b();
                waitForDownloadHandler.mContract.removeFromRunningNoteUuids(str7, str8);
                AbstractC0291i.m573j(str6, sharedItem.getItemId());
                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            str6 = str2;
            str9 = str3;
            downloadRequest2 = downloadRequest;
            str8 = "requestDownloadInternal-onFinished";
            str10 = "[CS7-2] requestDownloadInternal, onFinished() : ";
            c6747p = c6747p2;
            str11 = TAG;
            waitForDownloadHandler = this;
            str7 = str5;
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
            upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
        } catch (Throwable th2) {
            th = th2;
            str6 = str2;
            str7 = str5;
            str8 = "requestDownloadInternal-onFinished";
            c6747p = c6747p2;
        }
        try {
            modifiedTime = sharedItem.getModifiedTime();
            itemId = sharedItem.getItemId();
            leaderId = sharedItem.getLeaderId();
            sharedItem.getResourceId();
            str11 = TAG;
            str10 = "[CS7-2] requestDownloadInternal, onFinished() : ";
            str6 = str2;
            str9 = str3;
        } catch (ShareException e3) {
            e = e3;
            str9 = str3;
            downloadRequest2 = downloadRequest;
            str8 = "requestDownloadInternal-onFinished";
            str10 = "[CS7-2] requestDownloadInternal, onFinished() : ";
            str11 = TAG;
            waitForDownloadHandler = this;
            str6 = str2;
            str7 = str5;
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
            upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
        } catch (IOException e5) {
            e = e5;
            str9 = str3;
            downloadRequest2 = downloadRequest;
            str8 = "requestDownloadInternal-onFinished";
            str10 = "[CS7-2] requestDownloadInternal, onFinished() : ";
            str11 = TAG;
            waitForDownloadHandler = this;
            str6 = str2;
            str7 = str5;
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
            upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
        } catch (Throwable th3) {
            th = th3;
            str6 = str2;
            str7 = str5;
            str8 = "requestDownloadInternal-onFinished";
            waitForDownloadHandler = this;
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            waitForDownloadHandler.mContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
            throw th;
        }
        try {
            AbstractC0298p.m587i(context, false, str, createdTime, j, modifiedTime, str6, itemId, str9, leaderId, strM387b, str4, c6747p);
            NoteDbResolver noteDbResolver = new NoteDbResolver(str);
            if (noteDbResolver.exists()) {
                Map mapM568e = AbstractC0291i.m568e(str6);
                if (mapM568e != null) {
                    mapM568e.remove(sharedItem.getItemId());
                }
                noteDbResolver.setWorkspaceId(sharedItem.getResourceId());
                noteDbResolver.updateTitleAndModifiedTime(sharedItem.getTitle(), sharedItem.getModifiedTime());
                CoeditLogger.m8923i(str11, "[CS7-1] requestDownloadInternal, workspaceId = " + CoeditLogger.pii(sharedItem.getResourceId()));
                Event event = new Event(CoeditNoteEventManager.LINK_EVENT_STRING + str9);
                event.setEventData(str);
                CoeditNoteEventManager.getEventBus().publish(event);
                waitForDownloadHandler = this;
            } else {
                CoeditLogger.m8920e(str11, "[CS7-2] requestDownloadInternal, fail to save : " + sharedItem.getResourceId());
                waitForDownloadHandler = this;
                try {
                    waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
                } catch (ShareException e6) {
                    e = e6;
                    str7 = str5;
                    downloadRequest2 = downloadRequest;
                    str8 = "requestDownloadInternal-onFinished";
                    CoeditLogger.m8920e(str11, str10 + e.getMessage());
                    waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
                    downloadRequest2.onFailed(str7);
                    CoeditConnectionUtils.deleteTempFile(str4);
                    c6747p.m4870b();
                    upDownloaderContract = waitForDownloadHandler.mContract;
                    upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
                    AbstractC0291i.m573j(str6, sharedItem.getItemId());
                    CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                } catch (IOException e7) {
                    e = e7;
                    str7 = str5;
                    downloadRequest2 = downloadRequest;
                    str8 = "requestDownloadInternal-onFinished";
                    CoeditLogger.m8920e(str11, str10 + e.getMessage());
                    waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
                    downloadRequest2.onFailed(str7);
                    CoeditConnectionUtils.deleteTempFile(str4);
                    c6747p.m4870b();
                    upDownloaderContract = waitForDownloadHandler.mContract;
                    upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
                    AbstractC0291i.m573j(str6, sharedItem.getItemId());
                    CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                } catch (Throwable th4) {
                    th = th4;
                    str7 = str5;
                    str8 = "requestDownloadInternal-onFinished";
                    CoeditConnectionUtils.deleteTempFile(str4);
                    c6747p.m4870b();
                    waitForDownloadHandler.mContract.removeFromRunningNoteUuids(str7, str8);
                    AbstractC0291i.m573j(str6, sharedItem.getItemId());
                    CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                    throw th;
                }
            }
            str7 = str5;
            downloadRequest2 = downloadRequest;
        } catch (ShareException e8) {
            e = e8;
            waitForDownloadHandler = this;
            str7 = str5;
            downloadRequest2 = downloadRequest;
            str8 = "requestDownloadInternal-onFinished";
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
            upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
        } catch (IOException e9) {
            e = e9;
            waitForDownloadHandler = this;
            str7 = str5;
            downloadRequest2 = downloadRequest;
            str8 = "requestDownloadInternal-onFinished";
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
            upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
        } catch (Throwable th5) {
            th = th5;
            waitForDownloadHandler = this;
        }
        try {
            downloadRequest2.onSuccess(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
            str8 = "requestDownloadInternal-onFinished";
        } catch (ShareException e10) {
            e = e10;
            str8 = "requestDownloadInternal-onFinished";
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
        } catch (IOException e11) {
            e = e11;
            str8 = "requestDownloadInternal-onFinished";
            CoeditLogger.m8920e(str11, str10 + e.getMessage());
            waitForDownloadHandler.publishLinkSharingFailedEventByGroupId(str9);
            downloadRequest2.onFailed(str7);
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            upDownloaderContract = waitForDownloadHandler.mContract;
        } catch (Throwable th6) {
            th = th6;
            str8 = "requestDownloadInternal-onFinished";
            CoeditConnectionUtils.deleteTempFile(str4);
            c6747p.m4870b();
            waitForDownloadHandler.mContract.removeFromRunningNoteUuids(str7, str8);
            AbstractC0291i.m573j(str6, sharedItem.getItemId());
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
            throw th;
        }
        upDownloaderContract.removeFromRunningNoteUuids(str7, str8);
        AbstractC0291i.m573j(str6, sharedItem.getItemId());
        CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
    }

    private void finishRequestDownloadInternal(int[] iArr, String str, boolean z, String str2) {
        Context applicationContext = BaseUtils.getApplicationContext();
        List<ShareSyncEntry> localCoeditDocItemsBySpaceId = getLocalCoeditDocItemsBySpaceId(applicationContext, str);
        List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(applicationContext, str);
        if (listRequestSharedItemList == null) {
            CoeditLogger.m8920e(TAG, "[CS8] finishRequestDownloadInternal() : requestSharedItemList Failed");
            listRequestSharedItemList = new ArrayList<>();
        }
        CoeditLogger.m8919d(TAG, "[CS8] finishRequestDownloadInternal() : requestSharedItemSync current size : " + listRequestSharedItemList.size());
        if (iArr[0] == 0) {
            Map mapM568e = AbstractC0291i.m568e(str);
            if (!z && (mapM568e == null || mapM568e.isEmpty())) {
                publishLinkSharingFailedEventByGroupId(str2);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SharedItem> it = listRequestSharedItemList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getItemId());
        }
        for (ShareSyncEntry shareSyncEntry : localCoeditDocItemsBySpaceId) {
            if (!TextUtils.isEmpty(shareSyncEntry.getItemId()) && !arrayList.contains(shareSyncEntry.getItemId())) {
                if (shareSyncEntry.getIsDeleted() != 1) {
                    CoeditLogger.m8923i(TAG, "[CS8] finishRequestDownloadInternal() : delete " + shareSyncEntry.getItemId());
                    AbstractC0291i.m565b(shareSyncEntry.getUuid(), "SPACE_DELETION_FROM_SERVER", new C8416h(4));
                } else {
                    CoeditLogger.m8919d(TAG, "[CS8] finishRequestDownloadInternal() : " + shareSyncEntry.getItemId() + " is already deleted!");
                }
            }
        }
    }

    private List<ShareSyncEntry> getLocalCoeditDocItemsBySpaceId(Context context, String str) {
        CoeditLogger.m8919d(TAG, "Start to get local coedit list ");
        ArrayList arrayList = new ArrayList();
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        for (ShareSyncEntry shareSyncEntry : syncNoteDataRepositoryCreateSyncNoteDataRepository.getCoeditDocUuidList()) {
            if (shareSyncEntry.getSpaceId().equals(str) && !TextUtils.isEmpty(shareSyncEntry.getItemId())) {
                arrayList.add(shareSyncEntry);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$finishRequestDownloadInternal$0(int i) {
        CoeditLogger.m8923i(TAG, "[CS8] finishRequestDownloadInternal() onResult : " + i);
    }

    private void publishLinkSharingFailedEvent(String str) {
        publishLinkSharingFailedEventByGroupId(AbstractC0142a.m289a(str));
    }

    private void publishLinkSharingFailedEventByGroupId(String str) {
        Event event = new Event(AbstractC0541b.m772n(CoeditNoteEventManager.LINK_EVENT_STRING, str));
        event.setEventData(null);
        CoeditNoteEventManager.getEventBus().publish(event);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestDownloadInternal(final DownloadRequest downloadRequest) {
        boolean z;
        Map map;
        long j;
        boolean z2;
        boolean z3;
        String str;
        Context context;
        DownloadRequest downloadRequest2 = downloadRequest;
        final String str2 = downloadRequest2.mSpaceId;
        CoeditLogger.m8919d(TAG, "[CS7] requestDownloadInternal : spaceId = " + str2);
        if (TextUtils.isEmpty(str2)) {
            CoeditLogger.m8919d(TAG, "[CS7] requestDownloadInternal : spaceId is empty");
            return;
        }
        final Context applicationContext = BaseUtils.getApplicationContext();
        String strM289a = null;
        try {
            CoeditLogger.m8919d(TAG, "requestSharedItemSync start");
            BooleanResult booleanResultM547e = AbstractC0267s.m547e(str2);
            if (booleanResultM547e != null && !booleanResultM547e.getResult() && booleanResultM547e.getStatus().getCode() == 301) {
                AbstractC0267s.m549g();
                AbstractC0267s.m547e(str2);
            }
            strM289a = AbstractC0142a.m289a(str2);
            AbstractC0142a.m290b(strM289a);
            CoeditLogger.m8919d(TAG, "requestSharedItemSync end");
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("[CS7] requestSharedItemSync failed "), TAG);
            publishLinkSharingFailedEvent(str2);
        }
        final String str3 = strM289a;
        List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(applicationContext, str2);
        if (listRequestSharedItemList == null) {
            CoeditLogger.m8920e(TAG, "[CS7-2] sharedItemListResult is null");
            publishLinkSharingFailedEventByGroupId(str3);
            return;
        }
        if (listRequestSharedItemList.isEmpty()) {
            CoeditLogger.m8920e(TAG, "[CS7-2] sharedItemListResult is empty");
            publishLinkSharingFailedEventByGroupId(str3);
        } else {
            CoeditLogger.m8919d(TAG, "[CS7-1] sharedItemListResult size : " + listRequestSharedItemList.size());
        }
        SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
        long j2 = -1;
        long j3 = SharedPreferencesCompat.getInstance("CoeditPref").getLong("CoeditPrefKeyReadAllTime", -1L);
        boolean z4 = true;
        int[] iArr = new int[1];
        char c = 0;
        iArr[0] = 0;
        if (downloadRequest2.isComposerPriority() && TextUtils.isEmpty(downloadRequest2.mItemId)) {
            CoeditLogger.m8920e(TAG, "[CS7-2] ComposerPriority uuid is empty");
            finishRequestDownloadInternal(iArr, str2, false, str3);
            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
            return;
        }
        Map mapM568e = AbstractC0291i.m568e(str2);
        boolean z5 = false;
        for (final SharedItem sharedItem : listRequestSharedItemList) {
            char c2 = c;
            if (TextUtils.isEmpty(sharedItem.getItemId())) {
                map = mapM568e;
                j = j2;
                z2 = z4;
                z3 = z5;
            } else {
                j = j2;
                if (!downloadRequest2.isComposerPriority() || downloadRequest2.mItemId.equals(sharedItem.getItemId())) {
                    final String str4 = (String) sharedItem.getMetaData().get("uuid");
                    if (str4 == null) {
                        CoeditLogger.m8924w(TAG, "[CS7] requestDownloadInternal, uuid is null");
                    } else {
                        z2 = z4;
                        if (!UUIDUtils.isCoeditUuid(str4)) {
                            CoeditLogger.m8924w(TAG, "[CS7] requestDownloadInternal, ignore, not coeditUuid, uuid: [" + str4 + "]");
                        } else if (RestoreCacheManager.isRestoring(str4)) {
                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, ignore, isRestoring, uuid: [" + str4 + "]");
                        } else if (!CoeditCacheUtils.isLocalDataChanged(str4)) {
                            if (!this.mContract.isRunningNoteUuids(str4)) {
                                if (mapM568e == null || !mapM568e.containsKey(str4)) {
                                    str = str2;
                                    map = mapM568e;
                                } else {
                                    CoeditMainListEntry coeditMainListEntry = (CoeditMainListEntry) mapM568e.get(str4);
                                    if (coeditMainListEntry != null) {
                                        long socialServerChangePoint = coeditMainListEntry.getSocialServerChangePoint();
                                        str = str2;
                                        map = mapM568e;
                                        long lastDownloadedCheckPoint = CoeditCacheUtils.getLastDownloadedCheckPoint(str4);
                                        if (!coeditMainListEntry.isSnapShotUpdateRequired() && lastDownloadedCheckPoint != j && socialServerChangePoint == lastDownloadedCheckPoint && !CoeditCacheUtils.isLocalDataChanged(str4)) {
                                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, ignore snapped check point same, uuid: [" + str4 + "] snapCheckPoint: " + lastDownloadedCheckPoint);
                                            z3 = z5;
                                        }
                                        str2 = str;
                                    }
                                }
                                if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                                    CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, stop, data network failed or wifi mode enabled");
                                } else if (!CoeditStartManager.INSTANCE.canStartCoedit()) {
                                    CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, stop, Smart Switch started");
                                } else if (CoeditHandlerManager.getInstance().isCancelDownloadRequested()) {
                                    CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, stop, mIsCancelDownloadRequested");
                                } else {
                                    NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext, str4);
                                    AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
                                    if (notesDocumentEntityM9f != null) {
                                        if (AbstractC0298p.m585g(str4, sharedItem, sharedItem.getTitle()) || sharedItem.getModifiedTime() > notesDocumentEntityM9f.getLastModifiedAt()) {
                                            long jM572i = AbstractC0291i.m572i(sharedItem.getMemo());
                                            long checkpoint = syncNoteDataRepository.getCheckpoint(str4);
                                            if (jM572i != j && checkpoint != j && checkpoint < jM572i && j3 != notesDocumentEntityM9f.getFirstOpendAt()) {
                                                syncNoteDataRepository.updateFirstOpenedAt(str4, 0L);
                                            }
                                            context = applicationContext;
                                            new NoteDbResolver(str4).updateTitleAndModifiedTime(sharedItem.getTitle(), sharedItem.getModifiedTime());
                                        } else {
                                            context = applicationContext;
                                        }
                                        CoeditLogger.m8924w(TAG, "[CS7-1] requestDownloadInternal, ignore, uuid: [" + str4 + "] exists");
                                    } else {
                                        context = applicationContext;
                                        if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, stop, data network failed or wifi mode enabled");
                                            publishLinkSharingFailedEventByGroupId(str3);
                                        } else if (TextUtils.isEmpty(str3)) {
                                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, groupId is empty, uuid: ".concat(str4));
                                        } else if (AbstractC0291i.m569f(str4)) {
                                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, isDeleting, uuid: ".concat(str4));
                                        } else {
                                            iArr[c2] = iArr[c2] + 1;
                                            z3 = z5;
                                            applicationContext = context;
                                            str2 = str;
                                            CoeditHandlerManager.getInstance().registerExternalSnap(new ExternalSnapState(str4, new ExternalSnapState.ExternalSnapContract() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForDownloadHandler.2
                                                @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
                                                public boolean isExceedExternalSnap() {
                                                    return WaitForDownloadHandler.this.mContract.isExceedRunningNoteUuids();
                                                }

                                                @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
                                                public void wakeExternalSnap() {
                                                    if (WaitForDownloadHandler.this.mContract.addToRunningNoteUuids(str4, "requestDownloadInternal")) {
                                                        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(sharedItem.getItemId()) || AbstractC0291i.m569f(str4)) {
                                                            CoeditLogger.m8924w(WaitForDownloadHandler.TAG, "wakeExternalSnap return, uuid: " + str4);
                                                            return;
                                                        }
                                                        String str5 = str3;
                                                        String str6 = str2;
                                                        String itemId = sharedItem.getItemId();
                                                        ConcurrentHashMap concurrentHashMap = AbstractC0291i.f753b;
                                                        synchronized (concurrentHashMap) {
                                                            try {
                                                                Map concurrentHashMap2 = (Map) concurrentHashMap.get(str6);
                                                                if (concurrentHashMap2 == null) {
                                                                    concurrentHashMap2 = new ConcurrentHashMap();
                                                                    concurrentHashMap.put(str6, concurrentHashMap2);
                                                                }
                                                                CoeditMainListEntry coeditMainListEntryM571h = AbstractC0291i.m571h(str5, str6, itemId);
                                                                if (coeditMainListEntryM571h != null) {
                                                                    concurrentHashMap2.put(itemId, coeditMainListEntryM571h);
                                                                }
                                                            } catch (Throwable th) {
                                                                throw th;
                                                            }
                                                        }
                                                        EventManager.getEventBus().publish(new com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.Event("COEDIT_DUMMY_ITEM_EVENT"));
                                                        final String strM387b = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(applicationContext), sharedItem.getItemId() + sharedItem.getSpaceId() + ".sdocx.temp");
                                                        WaitForDownloadHandler.this.mContract.downloadSpenWNote(applicationContext, strM387b, str4, str3, sharedItem.getResourceId(), new DownloadNoteCallback() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForDownloadHandler.2.1
                                                            @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback
                                                            public void onFailed() {
                                                                C90082 c90082 = C90082.this;
                                                                WaitForDownloadHandler.this.downloadSpenWNoteOnFailed(sharedItem, str4, strM387b, str2, downloadRequest, str3);
                                                            }

                                                            @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback
                                                            public void onFinished(String str7) throws Throwable {
                                                                C90082 c90082 = C90082.this;
                                                                WaitForDownloadHandler.this.downloadSpenWNoteOnFinished(str7, applicationContext, sharedItem, str2, str3, strM387b, str4, downloadRequest);
                                                            }
                                                        });
                                                    }
                                                }
                                            }, downloadRequest.getUpdatePriority()));
                                        }
                                    }
                                    z3 = z5;
                                    applicationContext = context;
                                    str2 = str;
                                }
                                z = z5;
                                str2 = str;
                                break;
                            }
                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, ignore, uuid: [" + str4 + "] is running");
                            z5 = z2;
                            z4 = z5;
                            c = c2;
                            j2 = j;
                        } else {
                            CoeditLogger.m8924w(TAG, "[CS7-2] requestDownloadInternal, isLocalDataChanged ".concat(str4));
                        }
                        z3 = z5;
                        map = mapM568e;
                    }
                }
                z3 = z5;
                map = mapM568e;
                z2 = z4;
            }
            downloadRequest2 = downloadRequest;
            z5 = z3;
            z4 = z2;
            c = c2;
            j2 = j;
            mapM568e = map;
        }
        z = z5;
        finishRequestDownloadInternal(iArr, str2, z, str3);
        CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
    }

    public void cancelAllRequestedDownload() {
        CoeditLogger.m8919d(TAG, "cancelRequestedDownload");
        removeMessages();
        this.mDownloadList.clear();
        CoeditHandlerManager.getInstance().clearWaitingExternalSnap();
    }

    public void cancelCoeditTrimLocalSDoc() {
        if (this.mCoeditTrimLocalSDoc != null) {
            CoeditLogger.m8923i(TAG, "[CS9] handleMessage : cancel the coedit trim");
            this.mCoeditTrimLocalSDoc.cancel(true);
            this.mCoeditTrimLocalSDoc = null;
        }
    }

    public void cancelRequestedDownload() {
        CoeditLogger.m8919d(TAG, "cancelRequestedDownload");
        CoeditHandlerManager.getInstance().setCancelDownloadRequested();
    }

    public boolean hasLowUpdatePrioritySnap() {
        Iterator<DownloadRequest> it = this.mDownloadList.iterator();
        while (it.hasNext()) {
            if (it.next().isLowUpdatePriority()) {
                return true;
            }
        }
        return false;
    }

    public void removeMessages() {
        this.mWaitForDownload.removeMessages(0);
    }

    public void requestDownload(String str, DownloadResponse downloadResponse) {
        AbstractC8014b.m7219u("[CS2] requestDownload : ", str, TAG);
        this.mWaitForDownload.removeMessages(0);
        addOnlyNewSpaceIdToDownloadList(new DownloadRequest(str, null, UpdatePriority.LIST_PRIORITY, downloadResponse), false);
        Handler handler = this.mWaitForDownload;
        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
    }

    public void requestDownloadAddedNoteByPush(String str, String str2, DownloadResponse downloadResponse) {
        AbstractC8014b.m7219u("[CS2] requestDownloadAddedNoteByPush : spaceId = ", str, TAG);
        this.mWaitForDownload.removeMessages(0);
        addOnlyNewSpaceIdToDownloadList(new DownloadRequest(str, str2, UpdatePriority.COMPOSE_PRIORITY, downloadResponse), true);
        Handler handler = this.mWaitForDownload;
        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
    }

    public void requestDownloadAddedNoteFromComposer(@NonNull String str, @NonNull String str2, @Nullable DownloadResponse downloadResponse) {
        AbstractC8014b.m7219u("[CS2] requestDownloadAddedNoteFromComposer : spaceId = ", str, TAG);
        this.mWaitForDownload.removeMessages(0);
        addOnlyNewSpaceIdToDownloadListFromComposer(new DownloadRequest(str, str2, UpdatePriority.COMPOSE_PRIORITY, downloadResponse));
        Handler handler = this.mWaitForDownload;
        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
    }

    public void requestDownloadAllNotes() {
        CoeditLogger.m8919d(TAG, "requestDownloadAllNotes");
        List<Space> listRequestSpaceList = SesCoeditShareReadResolver.getInstance().requestSpaceList();
        if (listRequestSpaceList == null || listRequestSpaceList.isEmpty()) {
            return;
        }
        this.mWaitForDownload.removeMessages(0);
        for (Space space : listRequestSpaceList) {
            if (!space.getStandAlone()) {
                addOnlyNewSpaceIdToDownloadList(new DownloadRequest(space.getSpaceId(), null, UpdatePriority.BACKGROUND_PRIORITY, new BackgroundDownloadResponse()), false);
            } else if (SesCoeditGroupReadResolver.getInstance().getGroupCount(space.getGroupId()) > 0) {
                addOnlyNewSpaceIdToDownloadList(new DownloadRequest(space.getSpaceId(), null, UpdatePriority.BACKGROUND_PRIORITY, new BackgroundDownloadResponse()), false);
            }
        }
        Handler handler = this.mWaitForDownload;
        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
    }

    public void requestDownloadByPush(String str, DownloadResponse downloadResponse) {
        AbstractC8014b.m7219u("[CS2] requestDownloadByPush() : spaceId = ", str, TAG);
        this.mWaitForDownload.removeMessages(0);
        addOnlyNewSpaceIdToDownloadList(new DownloadRequest(str, null, UpdatePriority.STANDALONE_PRIORITY, downloadResponse), true);
        Handler handler = this.mWaitForDownload;
        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
    }

    public void requestDownloadStandalone(DownloadResponse downloadResponse) {
        this.mWaitForDownload.removeMessages(0);
        List<Space> listRequestCoEditStandAloneSpaceList = SesCoeditShareReadResolver.getInstance().requestCoEditStandAloneSpaceList();
        if (listRequestCoEditStandAloneSpaceList == null || listRequestCoEditStandAloneSpaceList.isEmpty()) {
            CoeditLogger.m8919d(TAG, "[CS7] requestDownloadStandalone() : No standalone spaces!");
            return;
        }
        CoeditLogger.m8919d(TAG, "[CS7-1] requestDownloadStandalone() : # of coedit standalone : " + listRequestCoEditStandAloneSpaceList.size());
        for (Space space : listRequestCoEditStandAloneSpaceList) {
            if (SesCoeditGroupReadResolver.getInstance().getGroupCount(space.getGroupId()) > 0) {
                addOnlyNewSpaceIdToDownloadList(new DownloadRequest(space.getSpaceId(), null, UpdatePriority.LIST_PRIORITY, downloadResponse), false);
            }
        }
        CoeditLogger.m8919d(TAG, "[CS7] # of valid coedit standalone : " + this.mDownloadList.size());
        Handler handler = this.mWaitForDownload;
        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
    }

    public void resumeBackgroundDownload() {
        if (this.mDownloadList.isEmpty()) {
            if (CoeditHandlerManager.getInstance().hasWaitingExternalSnap()) {
                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
            }
        } else {
            this.mWaitForDownload.removeMessages(0);
            Handler handler = this.mWaitForDownload;
            handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
        }
    }
}
