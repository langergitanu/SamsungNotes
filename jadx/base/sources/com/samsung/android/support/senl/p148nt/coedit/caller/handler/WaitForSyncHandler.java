package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.CoeditStartManager;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSamsungAccountManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.control.ExternalSnapState;
import com.samsung.android.support.senl.p148nt.coedit.control.common.UpdatePriority;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import p001A.AbstractC0000a;
import p041J.AbstractC0142a;
import p042J1.AbstractC0155m;
import p079T.AbstractC0291i;
import p079T.AbstractC0298p;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class WaitForSyncHandler {
    private static final String TAG = "WaitForSyncHandler";
    private final UpDownloaderContract mContract;
    private final Executor mExecutor = AbstractC4539a.m3201k("WaitForSyncHandler_handler");
    private final Object mSyncRequestedSpaceIdsLock = new Object();
    private final Queue<String> mSyncRequestedSpaceIds = new ConcurrentLinkedQueue();
    private final Set<String> mSyncRequiredUuids = new CopyOnWriteArraySet();
    private final Handler mWaitForSync = new Handler(Looper.getMainLooper()) { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForSyncHandler.1

        /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForSyncHandler$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public class AnonymousClass1 implements IAuthInfoReqListener {
            public AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void lambda$onReceived$0() {
                try {
                    try {
                        WaitForSyncHandler.this.mContract.requestConnectSession();
                        synchronized (WaitForSyncHandler.this.mSyncRequestedSpaceIdsLock) {
                            while (!WaitForSyncHandler.this.mSyncRequestedSpaceIds.isEmpty()) {
                                try {
                                    String str = (String) WaitForSyncHandler.this.mSyncRequestedSpaceIds.poll();
                                    if (!TextUtils.isEmpty(str)) {
                                        WaitForSyncHandler.this.externalSnapStartAllList(str);
                                    }
                                } finally {
                                }
                            }
                        }
                        synchronized (WaitForSyncHandler.this.mSyncRequestedSpaceIdsLock) {
                            WaitForSyncHandler.this.mSyncRequiredUuids.clear();
                        }
                    } catch (Exception e) {
                        CoeditLogger.m8920e(WaitForSyncHandler.TAG, "[CS6-2] mWaitForSync, onReceived() : " + e.getMessage());
                        synchronized (WaitForSyncHandler.this.mSyncRequestedSpaceIdsLock) {
                            WaitForSyncHandler.this.mSyncRequiredUuids.clear();
                        }
                    }
                    WaitForSyncHandler.this.mContract.requestDisconnectSession();
                } catch (Throwable th) {
                    synchronized (WaitForSyncHandler.this.mSyncRequestedSpaceIdsLock) {
                        WaitForSyncHandler.this.mSyncRequiredUuids.clear();
                        WaitForSyncHandler.this.mContract.requestDisconnectSession();
                        throw th;
                    }
                }
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
            public void onError(String str, String str2) {
                CoeditLogger.m8920e(WaitForSyncHandler.TAG, "[CS6-2] mWaitForSync, onReceived() : errCode = " + str2 + " , errMsg = " + str2);
            }

            @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthInfoReqListener
            public void onReceived(String str, String str2) {
                CoeditLogger.m8923i(WaitForSyncHandler.TAG, "[CS6-1] mWaitForSync, onReceived()");
                WaitForSyncHandler.this.mExecutor.execute(new RunnableC9011a(this, 1));
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            CoeditLogger.m8923i(WaitForSyncHandler.TAG, "[CS6] mWaitForSync, handleMessage");
            WaitForSyncHandler.this.mContract.cancelCoeditTrimLocalSDoc();
            if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                RequestToSamsungAccountManager.INSTANCE.requestAuthInfo(new AnonymousClass1());
            } else {
                CoeditLogger.m8920e(WaitForSyncHandler.TAG, "[CS6-2] mWaitForSync, handleMessage fail : wifi only mode restrict");
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        SKIP,
        INVALID,
        VALID
    }

    public WaitForSyncHandler(UpDownloaderContract upDownloaderContract) {
        this.mContract = upDownloaderContract;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void externalSnapStartAllList(String str) {
        CoeditLogger.m8919d(TAG, "externalSnapStartAllList spaceId " + str);
        Context applicationContext = BaseUtils.getApplicationContext();
        List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(applicationContext, str);
        if (listRequestSharedItemList == null) {
            CoeditLogger.m8919d(TAG, "externalSnapStartAllList, result null");
            return;
        }
        CoeditLogger.m8919d(TAG, "externalSnapStartAllList, requestSharedItemSync size : " + listRequestSharedItemList.size());
        Iterator<SharedItem> it = listRequestSharedItemList.iterator();
        while (it.hasNext()) {
            if (registerExternalSnap(applicationContext, it.next(), UpdatePriority.IMPORT_PRIORITY) == State.INVALID) {
                return;
            }
        }
        CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public State getSnapState(Context context, String str, String str2, UpdatePriority updatePriority) {
        NotesDocumentEntity notesDocumentEntityM9f;
        if (!UUIDUtils.isCoeditUuid(str)) {
            CoeditLogger.m8924w(TAG, "externalSnapStart, ignore, not coeditUuid, uuid: [" + str + "]");
            return State.SKIP;
        }
        if (this.mContract.isRunningNoteUuids(str)) {
            CoeditLogger.m8924w(TAG, "externalSnapStart, ignore, uuid: [" + str + "] is running");
            return State.SKIP;
        }
        if (!UserInputSkipper.isValidSingleActionEvent(false, UserInputSkipper.Tag.OpenActivity) || !UserInputSkipper.isValidEvent(UserInputSkipper.Tag.MemoList)) {
            return State.SKIP;
        }
        synchronized (this.mSyncRequestedSpaceIdsLock) {
            try {
                if (UpdatePriority.IMPORT_PRIORITY == updatePriority && !this.mSyncRequiredUuids.contains(str)) {
                    CoeditLogger.m8924w(TAG, "externalSnapStart, ignore, uuid: [" + str + "] is not required");
                    return State.SKIP;
                }
                if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                    CoeditLogger.m8924w(TAG, "externalSnapStart, stop, data network failed or wifi mode enabled");
                    return State.INVALID;
                }
                if (!CoeditStartManager.INSTANCE.canStartCoedit()) {
                    CoeditLogger.m8924w(TAG, "externalSnapStart, stop, Smart Switch started");
                    return State.INVALID;
                }
                if (TextUtils.isEmpty(str2)) {
                    CoeditLogger.m8924w(TAG, "externalSnapStart, groupId is empty, " + str);
                    return State.SKIP;
                }
                if (str != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
                    AbstractC0000a.m18o(context, context, context);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if (notesDocumentEntityM9f == null) {
                    CoeditLogger.m8924w(TAG, "externalSnapStart, entity is invalid, " + str);
                    return State.SKIP;
                }
                if (!TextUtils.isEmpty(notesDocumentEntityM9f.getFilePath())) {
                    return State.VALID;
                }
                CoeditLogger.m8924w(TAG, "externalSnapStart, filePath is empty, " + str);
                return State.SKIP;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private State registerExternalSnap(final Context context, final SharedItem sharedItem, final UpdatePriority updatePriority) {
        final String originFilePath;
        final String str = (String) sharedItem.getMetaData().get("uuid");
        final String strM289a = AbstractC0142a.m289a(sharedItem.getSpaceId());
        State snapState = getSnapState(context, str, strM289a, updatePriority);
        State state = State.INVALID;
        if (snapState == state) {
            return state;
        }
        State state2 = State.SKIP;
        if (snapState == state2 || (originFilePath = getOriginFilePath(context, str)) == null || AbstractC0291i.m569f(str)) {
            return state2;
        }
        CoeditHandlerManager.getInstance().registerExternalSnap(new ExternalSnapState(str, new ExternalSnapState.ExternalSnapContract() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForSyncHandler.2
            @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
            public boolean isExceedExternalSnap() {
                return WaitForSyncHandler.this.mContract.isExceedRunningNoteUuids();
            }

            @Override // com.samsung.android.support.senl.nt.coedit.control.ExternalSnapState.ExternalSnapContract
            public void wakeExternalSnap() {
                if (WaitForSyncHandler.this.getSnapState(context, str, strM289a, updatePriority) == State.INVALID) {
                    CoeditLogger.m8919d(WaitForSyncHandler.TAG, "wakeExternalSnap, INVALID");
                    return;
                }
                if (WaitForSyncHandler.this.mContract.addToRunningNoteUuids(str, "externalSnapStart")) {
                    final String strM387b = AbstractC0155m.m387b(WDocUtils.getNoteFilePath(context), sharedItem.getItemId() + sharedItem.getSpaceId() + ".sdocx.temp");
                    WaitForSyncHandler.this.mContract.externalSnapStart(context, originFilePath, strM387b, str, strM289a, sharedItem.getResourceId(), new DownloadNoteCallback() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.WaitForSyncHandler.2.1
                        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback
                        public void onFailed() {
                            CoeditLogger.m8920e(WaitForSyncHandler.TAG, "externalSnapStart, onFailed, syncSpenWNote failed itemId : " + sharedItem.getItemId() + " ,uuid : " + str);
                            CoeditConnectionUtils.deleteTempFile(strM387b);
                            WaitForSyncHandler.this.mContract.removeFromRunningNoteUuids(str, "externalSnapStart-onFailed");
                            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r2v16 */
                        /* JADX WARN: Type inference failed for: r2v17, types: [com.samsung.android.support.senl.nt.data.sync.resolver.NoteDbResolver] */
                        /* JADX WARN: Type inference failed for: r2v18 */
                        /* JADX WARN: Type inference failed for: r2v19 */
                        /* JADX WARN: Type inference failed for: r2v20 */
                        /* JADX WARN: Type inference failed for: r2v21 */
                        /* JADX WARN: Type inference failed for: r2v24 */
                        /* JADX WARN: Type inference failed for: r2v26 */
                        /* JADX WARN: Type inference failed for: r2v27 */
                        /* JADX WARN: Type inference failed for: r2v28 */
                        /* JADX WARN: Type inference failed for: r2v29 */
                        /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
                        @Override // com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.DownloadNoteCallback
                        public void onFinished(String str2) throws Throwable {
                            String str3;
                            String str4;
                            C6747p c6747p;
                            Object obj;
                            String str5;
                            ?? r2;
                            UpDownloaderContract upDownloaderContract;
                            long jLongValue;
                            C90102 c90102;
                            Context context2;
                            long createdTime;
                            long modifiedTime;
                            String spaceId;
                            String itemId;
                            C90102 c901022;
                            Object obj2;
                            C6747p c6747p2 = new C6747p(context);
                            c6747p2.m4869a();
                            try {
                                Map metaData = sharedItem.getMetaData();
                                jLongValue = (metaData == null || (obj2 = metaData.get("lastModifiedAt")) == null) ? 0L : ((Long) obj2).longValue();
                                c90102 = C90102.this;
                                str4 = "externalSnapStart-onFinished";
                            } catch (ShareException e) {
                                e = e;
                                str4 = "externalSnapStart-onFinished";
                                obj = WaitForSyncHandler.TAG;
                                str5 = "externalSnapStart, onFinished, , e : ";
                                c6747p = c6747p2;
                                str3 = str2;
                                r2 = obj;
                                try {
                                    CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                    CoeditConnectionUtils.deleteTempFile(strM387b);
                                    c6747p.m4870b();
                                    upDownloaderContract = WaitForSyncHandler.this.mContract;
                                    upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                    CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                                } catch (Throwable th) {
                                    th = th;
                                    CoeditConnectionUtils.deleteTempFile(strM387b);
                                    c6747p.m4870b();
                                    WaitForSyncHandler.this.mContract.removeFromRunningNoteUuids(str3, str4);
                                    CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                                    throw th;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                str4 = "externalSnapStart-onFinished";
                                obj = WaitForSyncHandler.TAG;
                                str5 = "externalSnapStart, onFinished, , e : ";
                                c6747p = c6747p2;
                                str3 = str2;
                                r2 = obj;
                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                c6747p.m4870b();
                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                            } catch (Throwable th2) {
                                th = th2;
                                str3 = str2;
                                str4 = "externalSnapStart-onFinished";
                            }
                            try {
                                context2 = context;
                                createdTime = sharedItem.getCreatedTime();
                                modifiedTime = sharedItem.getModifiedTime();
                                spaceId = sharedItem.getSpaceId();
                                itemId = sharedItem.getItemId();
                                c901022 = C90102.this;
                                c6747p = c6747p2;
                            } catch (ShareException e3) {
                                e = e3;
                                obj = WaitForSyncHandler.TAG;
                                str5 = "externalSnapStart, onFinished, , e : ";
                                c6747p = c6747p2;
                                str3 = str2;
                                r2 = obj;
                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                c6747p.m4870b();
                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                            } catch (IOException e5) {
                                e = e5;
                                obj = WaitForSyncHandler.TAG;
                                str5 = "externalSnapStart, onFinished, , e : ";
                                c6747p = c6747p2;
                                str3 = str2;
                                r2 = obj;
                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                c6747p.m4870b();
                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                            } catch (Throwable th3) {
                                th = th3;
                                str3 = str2;
                                c6747p = c6747p2;
                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                c6747p.m4870b();
                                WaitForSyncHandler.this.mContract.removeFromRunningNoteUuids(str3, str4);
                                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                                throw th;
                            }
                            try {
                                String str6 = strM289a;
                                String leaderId = sharedItem.getLeaderId();
                                C90102 c901023 = C90102.this;
                                try {
                                    try {
                                        String str7 = originFilePath;
                                        try {
                                            String str8 = strM387b;
                                            sharedItem.getResourceId();
                                            str5 = "externalSnapStart, onFinished, , e : ";
                                            str3 = str2;
                                            try {
                                                try {
                                                    AbstractC0298p.m587i(context2, true, str3, createdTime, jLongValue, modifiedTime, spaceId, itemId, str6, leaderId, str7, str8, c6747p);
                                                    ?? noteDbResolver = new NoteDbResolver(str3);
                                                    try {
                                                        if (noteDbResolver.exists()) {
                                                            try {
                                                                noteDbResolver.setWorkspaceId(sharedItem.getResourceId());
                                                                noteDbResolver.updateTitleAndModifiedTime(sharedItem.getTitle(), sharedItem.getModifiedTime());
                                                                String str9 = "externalSnapStart, succeed to save : " + sharedItem.getResourceId();
                                                                String str10 = WaitForSyncHandler.TAG;
                                                                CoeditLogger.m8923i(str10, str9);
                                                                noteDbResolver = str10;
                                                            } catch (ShareException e6) {
                                                                e = e6;
                                                                noteDbResolver = WaitForSyncHandler.TAG;
                                                                str4 = str4;
                                                                r2 = noteDbResolver;
                                                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                                                c6747p.m4870b();
                                                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                                            } catch (IOException e7) {
                                                                e = e7;
                                                                noteDbResolver = WaitForSyncHandler.TAG;
                                                                str4 = str4;
                                                                r2 = noteDbResolver;
                                                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                                                c6747p.m4870b();
                                                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                                            }
                                                        } else {
                                                            String str11 = WaitForSyncHandler.TAG;
                                                            CoeditLogger.m8920e(str11, "externalSnapStart, fail to save!");
                                                            noteDbResolver = str11;
                                                        }
                                                        CoeditConnectionUtils.deleteTempFile(strM387b);
                                                        c6747p.m4870b();
                                                        upDownloaderContract = WaitForSyncHandler.this.mContract;
                                                        str4 = str4;
                                                    } catch (ShareException e8) {
                                                        e = e8;
                                                    } catch (IOException e9) {
                                                        e = e9;
                                                    }
                                                } catch (Throwable th4) {
                                                    th = th4;
                                                    str4 = str4;
                                                    CoeditConnectionUtils.deleteTempFile(strM387b);
                                                    c6747p.m4870b();
                                                    WaitForSyncHandler.this.mContract.removeFromRunningNoteUuids(str3, str4);
                                                    CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                                                    throw th;
                                                }
                                            } catch (ShareException | IOException e10) {
                                                e = e10;
                                                str4 = str4;
                                                r2 = WaitForSyncHandler.TAG;
                                            }
                                        } catch (ShareException | IOException e11) {
                                            e = e11;
                                            str5 = "externalSnapStart, onFinished, , e : ";
                                            str4 = str4;
                                            obj = WaitForSyncHandler.TAG;
                                            str3 = str2;
                                            r2 = obj;
                                            CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                            CoeditConnectionUtils.deleteTempFile(strM387b);
                                            c6747p.m4870b();
                                            upDownloaderContract = WaitForSyncHandler.this.mContract;
                                            upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        str3 = str2;
                                        str4 = str4;
                                    }
                                } catch (ShareException | IOException e12) {
                                    e = e12;
                                    obj = WaitForSyncHandler.TAG;
                                    str5 = "externalSnapStart, onFinished, , e : ";
                                    str4 = str4;
                                }
                            } catch (ShareException e13) {
                                e = e13;
                                obj = WaitForSyncHandler.TAG;
                                str5 = "externalSnapStart, onFinished, , e : ";
                                str4 = str4;
                                str3 = str2;
                                r2 = obj;
                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                c6747p.m4870b();
                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                            } catch (IOException e14) {
                                e = e14;
                                obj = WaitForSyncHandler.TAG;
                                str5 = "externalSnapStart, onFinished, , e : ";
                                str4 = str4;
                                str3 = str2;
                                r2 = obj;
                                CoeditLogger.m8920e(r2, str5 + e.getMessage());
                                CoeditConnectionUtils.deleteTempFile(strM387b);
                                c6747p.m4870b();
                                upDownloaderContract = WaitForSyncHandler.this.mContract;
                                upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                            } catch (Throwable th6) {
                                th = th6;
                                str3 = str2;
                                str4 = str4;
                            }
                            upDownloaderContract.removeFromRunningNoteUuids(str3, str4);
                            CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                        }
                    });
                }
            }
        }, updatePriority));
        return State.VALID;
    }

    public void addSpaceIdToSyncRequestedSpaceIds(String str) {
        if (this.mSyncRequestedSpaceIds.contains(str)) {
            return;
        }
        AbstractC8014b.m7219u("addSpaceIdToSyncRequestedSpaceIds, add spaceId ", str, TAG);
        this.mSyncRequestedSpaceIds.offer(str);
    }

    public void cancelRequestedSync() {
        this.mWaitForSync.removeMessages(0);
        synchronized (this.mSyncRequestedSpaceIdsLock) {
            CoeditLogger.m8919d(TAG, "cancelRequestedSync");
            this.mSyncRequiredUuids.clear();
            this.mSyncRequestedSpaceIds.clear();
        }
    }

    public String getOriginFilePath(Context context, String str) {
        NotesDocumentEntity notesDocumentEntityM9f;
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        if (notesDocumentEntityM9f == null) {
            CoeditLogger.m8924w(TAG, "externalSnapStart, entity is invalid, " + str);
            return null;
        }
        String filePath = notesDocumentEntityM9f.getFilePath();
        if (!TextUtils.isEmpty(filePath)) {
            return filePath;
        }
        CoeditLogger.m8924w(TAG, "externalSnapStart, filePath is empty, " + str);
        return null;
    }

    public boolean hasLowUpdatePrioritySnap() {
        return (this.mSyncRequiredUuids.isEmpty() && this.mSyncRequestedSpaceIds.isEmpty()) ? false : true;
    }

    public void requestSync(@NonNull List<String> list, Set<String> set) {
        synchronized (this.mSyncRequestedSpaceIdsLock) {
            try {
                if (!this.mSyncRequestedSpaceIds.isEmpty() && !set.isEmpty() && new HashSet(list).equals(new HashSet(this.mSyncRequestedSpaceIds)) && this.mSyncRequiredUuids.equals(set)) {
                    CoeditLogger.m8924w(TAG, "requestSync, ignore, same request data used");
                    return;
                }
                if (list.isEmpty()) {
                    CoeditLogger.m8924w(TAG, "requestSync, ignore, empty spaceIds reuested");
                    return;
                }
                if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning()) {
                    CoeditLogger.m8924w(TAG, "requestSync, ignore, CoeditWithComposerRunning");
                    this.mWaitForSync.removeMessages(0);
                    return;
                }
                this.mWaitForSync.removeMessages(0);
                synchronized (this.mSyncRequestedSpaceIdsLock) {
                    try {
                        CoeditLogger.m8919d(TAG, "requestSync : " + Arrays.toString(list.toArray()));
                        this.mSyncRequiredUuids.clear();
                        this.mSyncRequiredUuids.addAll(set);
                        this.mSyncRequestedSpaceIds.clear();
                        Iterator<String> it = list.iterator();
                        while (it.hasNext()) {
                            addSpaceIdToSyncRequestedSpaceIds(it.next());
                        }
                        Handler handler = this.mWaitForSync;
                        handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
                    } finally {
                    }
                }
            } finally {
            }
        }
    }

    public void requestSyncAllNotes() {
        CoeditMainListEntry coeditMainListEntry;
        CoeditLogger.m8919d(TAG, "requestSyncAllNotes");
        List<Space> listRequestSpaceList = SesCoeditShareReadResolver.getInstance().requestSpaceList();
        if (listRequestSpaceList != null && !listRequestSpaceList.isEmpty()) {
            Context applicationContext = BaseUtils.getApplicationContext();
            Iterator<Space> it = listRequestSpaceList.iterator();
            while (it.hasNext()) {
                String spaceId = it.next().getSpaceId();
                List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(applicationContext, spaceId);
                if (listRequestSharedItemList == null || listRequestSharedItemList.isEmpty()) {
                    CoeditLogger.m8919d(TAG, "requestSyncAllNotes, result isEmpty");
                    return;
                }
                Map mapM568e = AbstractC0291i.m568e(spaceId);
                if (mapM568e == null) {
                    CoeditLogger.m8919d(TAG, "requestSyncAllNotes, uploadedItems : null");
                } else {
                    CoeditLogger.m8919d(TAG, "requestSyncAllNotes, size : " + listRequestSharedItemList.size());
                    for (SharedItem sharedItem : listRequestSharedItemList) {
                        String str = (String) sharedItem.getMetaData().get("uuid");
                        if (str == null) {
                            CoeditLogger.m8924w(TAG, "requestSyncAllNotes, uuid is null");
                        } else if (mapM568e.containsKey(str) && (coeditMainListEntry = (CoeditMainListEntry) mapM568e.get(str)) != null) {
                            long socialServerChangePoint = coeditMainListEntry.getSocialServerChangePoint();
                            long lastDownloadedCheckPoint = CoeditCacheUtils.getLastDownloadedCheckPoint(str);
                            if (coeditMainListEntry.isSnapShotUpdateRequired() || lastDownloadedCheckPoint == -1 || socialServerChangePoint != lastDownloadedCheckPoint || CoeditCacheUtils.isLocalDataChanged(str)) {
                                if (registerExternalSnap(applicationContext, sharedItem, UpdatePriority.BACKGROUND_PRIORITY) == State.INVALID) {
                                    return;
                                }
                            } else {
                                CoeditLogger.m8924w(TAG, "requestSyncAllNotes, ignore snapped check point same, uuid: [" + str + "] snapCheckPoint: " + lastDownloadedCheckPoint);
                            }
                        }
                    }
                }
            }
        }
        CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
    }

    public void resumeBackgroundSync() {
        if (this.mSyncRequiredUuids.isEmpty() && this.mSyncRequestedSpaceIds.isEmpty()) {
            if (CoeditHandlerManager.getInstance().hasWaitingExternalSnap()) {
                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
            }
        } else {
            this.mWaitForSync.removeMessages(0);
            Handler handler = this.mWaitForSync;
            handler.sendMessageDelayed(Message.obtain(handler, 0), 500L);
        }
    }

    public void registerExternalSnap(String str, String str2) {
        CoeditLogger.m8919d(TAG, "registerExternalSnap uuid " + str + " spaceId " + str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(applicationContext, str2);
        if (listRequestSharedItemList == null) {
            CoeditLogger.m8919d(TAG, "registerExternalSnap, result null");
            return;
        }
        for (SharedItem sharedItem : listRequestSharedItemList) {
            if (str.equals((String) sharedItem.getMetaData().get("uuid"))) {
                registerExternalSnap(applicationContext, sharedItem, UpdatePriority.LIST_PRIORITY);
                CoeditHandlerManager.getInstance().checkWaitingExternalSnap();
                return;
            }
        }
    }
}
