package com.samsung.android.support.senl.p148nt.coedit.caller.handler;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.credentials.playservices.C2517b;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupInvitationResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.CoeditServiceConnection;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ExternalCoeditUploadItem;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ImportResult;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ImportReturnValues;
import com.samsung.android.support.senl.p148nt.coedit.common.CoeditConstants;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;
import com.samsung.android.support.senl.p148nt.coedit.service.CoeditService;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalBaseTask;
import com.samsung.android.support.senl.p148nt.coedit.service.task.ExternalSnapUploadTask;
import com.samsung.android.support.senl.p148nt.coedit.utils.CoeditUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.AddNoteToSharedNotebookUseCase;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import p028G.InterfaceC0102a;
import p041J.AbstractC0142a;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p079T.C0283a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class InternalImportHandler {
    private static final int CORE_POOL_SIZE = 1;
    private static final int KEEP_ALIVE_TIME = 10;
    private static final int MAX_POOL_SIZE = 1;
    private static final String TAG = "InternalImportHandler";
    protected final ThreadPoolExecutor mThreadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new SenlThreadFactory(TAG));

    private Pair<List<String>, Map<String, Integer>> copyToCoeditSpace(@NonNull Context context, @NonNull List<String> list, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        String strM289a = AbstractC0142a.m289a(str);
        C0283a.m562d().getClass();
        String strM561c = C0283a.m561c();
        if (TextUtils.isEmpty(strM289a) || TextUtils.isEmpty(strM561c)) {
            CoeditLogger.m8920e(TAG, "copyToCoeditSpace, failed : empty Id exists, group id: " + strM289a + ", ownerId: " + strM561c);
            return new Pair<>(arrayList, map);
        }
        for (int i = 0; i < list.size(); i++) {
            String strNewUUID = UUIDUtils.newUUID(context, true);
            int iCopyToCoeditSpace = copyToCoeditSpace(context, list.get(i), strNewUUID, str);
            if (iCopyToCoeditSpace == 100) {
                arrayList.add(strNewUUID);
            } else {
                map.put(list.get(i), Integer.valueOf(iCopyToCoeditSpace));
            }
        }
        if (!map.isEmpty()) {
            CoeditLogger.m8919d(TAG, "copyToCoeditSpace, failed : " + Arrays.toString(map.keySet().toArray()));
        }
        return new Pair<>(arrayList, map);
    }

    private ExternalCoeditUploadItem createExternalCoeditUploadItem(ShareSyncEntry shareSyncEntry) {
        if (!isValidUploadEntry(shareSyncEntry)) {
            return null;
        }
        String strM289a = AbstractC0142a.m289a(shareSyncEntry.getSpaceId());
        if (!TextUtils.isEmpty(strM289a)) {
            ExternalCoeditUploadItem externalCoeditUploadItem = new ExternalCoeditUploadItem(shareSyncEntry);
            externalCoeditUploadItem.setGroupId(strM289a);
            return externalCoeditUploadItem;
        }
        CoeditLogger.m8924w(TAG, "createExternalCoeditUploadItem, groupId not exist " + shareSyncEntry.getUuid());
        return null;
    }

    private boolean createSharedNotebooksForRestore(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2)) {
            CoeditLogger.m8920e(TAG, "createSharedNotebooksForRestore# groupId is null or empty.");
            return false;
        }
        if (TextUtils.isEmpty(str3)) {
            CoeditLogger.m8920e(TAG, "createSharedNotebooksForRestore# space name is null or empty.");
            return false;
        }
        CoeditLogger.m8923i(TAG, " createSharedNotebooksForRestore#");
        try {
            ShareApi.SpaceWithUriRequest spaceWithUriRequest = new ShareApi.SpaceWithUriRequest(str3);
            spaceWithUriRequest.setStandAlone(true);
            AbstractC0267s.m543a().requestSpaceCreation(str2, spaceWithUriRequest, new C2517b(2, this, str2, context, str));
            return true;
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("createSharedNotebooksForRestore#, fail to requestSpaceCreation# Exception : "), TAG);
            return false;
        }
    }

    private ImportResult generateImportResult(ImportReturnValues importReturnValues) {
        int i = importReturnValues.ret;
        return i != 200 ? new ImportResult(null, null, i) : (importReturnValues.newUuidList.isEmpty() || importReturnValues.newPathList.isEmpty()) ? new ImportResult(null, null, importReturnValues.ret) : new ImportResult(importReturnValues.newUuidList.get(0), importReturnValues.newPathList.get(0), importReturnValues.ret);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSnapError() {
        if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning()) {
            return 204;
        }
        return !CoeditUtils.isCoeditDataNetworkAvailable() ? 203 : 202;
    }

    private ImportReturnValues importNoteToCoeditInternal(@NonNull Context context, @NonNull List<String> list, @NonNull String str, @Nullable InterfaceC0102a interfaceC0102a) {
        NotesDocumentEntity notesDocumentEntity;
        ImportReturnValues importReturnValues = new ImportReturnValues();
        SpenSdkInitializer.initialize(context);
        Pair<List<String>, Map<String, Integer>> pairCopyToCoeditSpace = copyToCoeditSpace(context, list, str);
        List<String> list2 = (List) pairCopyToCoeditSpace.first;
        Map map = (Map) pairCopyToCoeditSpace.second;
        int size = map.size();
        CoeditLogger.m8919d(TAG, "importNoteToCoeditInternal, requestDocUuidSize : " + list.size() + ", copiedUuidSize : " + list2.size() + ", copyFailedDocSize : " + size);
        int i = 0;
        if (list.size() == size) {
            Iterator it = map.values().iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (iIntValue != 100) {
                    importReturnValues.ret = iIntValue;
                    importReturnValues.uploadFailedCount = 0;
                    importReturnValues.copyFailedCount = size;
                    return importReturnValues;
                }
            }
        }
        if (list2.isEmpty()) {
            importReturnValues.ret = 202;
            importReturnValues.uploadFailedCount = 0;
            importReturnValues.copyFailedCount = list.size();
            return importReturnValues;
        }
        ArrayList arrayList = new ArrayList();
        try {
            try {
                C6749r c6749r = new C6749r(context);
                C6715o.m4808q().m4796c(3);
                for (String str2 : list2) {
                    if (CoeditUtils.isCoeditDataNetworkAvailable()) {
                        ExternalCoeditUploadItem externalCoeditUploadItemCreateExternalCoeditUploadItem = createExternalCoeditUploadItem(new SyncNoteDataRepository().getShareSyncEntry(str2));
                        if (externalCoeditUploadItemCreateExternalCoeditUploadItem == null) {
                            importReturnValues.ret = 202;
                            processFailedImportItem(arrayList, str2, c6749r, context);
                        } else {
                            int iUploadSpenWNote = uploadSpenWNote(context, externalCoeditUploadItemCreateExternalCoeditUploadItem);
                            importReturnValues.ret = iUploadSpenWNote;
                            if (iUploadSpenWNote == 200) {
                                if (str2 != null) {
                                    notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().get(str2);
                                    NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
                                    NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
                                    NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                } else {
                                    notesDocumentEntity = null;
                                }
                                if (TextUtils.isEmpty(notesDocumentEntity != null ? notesDocumentEntity.getMdeItemId() : "")) {
                                    importReturnValues.ret = 202;
                                    processFailedImportItem(arrayList, str2, c6749r, context);
                                } else {
                                    importReturnValues.newUuidList.add(str2);
                                    importReturnValues.newPathList.add(externalCoeditUploadItemCreateExternalCoeditUploadItem.getEntry().getFilePath());
                                }
                            } else {
                                processFailedImportItem(arrayList, str2, c6749r, context);
                            }
                        }
                    } else {
                        importReturnValues.ret = 203;
                        processFailedImportItem(arrayList, str2, c6749r, context);
                    }
                    if (interfaceC0102a != null) {
                        i++;
                        interfaceC0102a.onProgress(i, list2.size());
                    }
                }
            } catch (Exception e) {
                CoeditLogger.m8920e(TAG, "importNoteToCoeditInternal, exception : " + e.getMessage());
            }
            C6715o.m4808q().m4797d(3, null);
            if (!arrayList.isEmpty()) {
                CoeditLogger.m8919d(TAG, "importNoteToCoeditInternal, failed : " + Arrays.toString(arrayList.toArray()));
            }
            importReturnValues.uploadFailedCount = arrayList.size();
            importReturnValues.copyFailedCount = list.size() - list2.size();
            return importReturnValues;
        } catch (Throwable th) {
            C6715o.m4808q().m4797d(3, null);
            throw th;
        }
    }

    private void importToSpaceForRestore(@NonNull Context context, String str, String str2) {
        if (importNoteToCoeditInternal(context, Collections.singletonList(str), str2, null).ret == 200) {
            DocumentWriteResolver.delete(context, str, 1, TAG);
        }
    }

    private boolean isValidUploadEntry(ShareSyncEntry shareSyncEntry) {
        if (TextUtils.isEmpty(shareSyncEntry.getSpaceId())) {
            CoeditLogger.m8924w(TAG, "[5-2] isValidUploadEntry, spaceId not exist " + shareSyncEntry.getUuid());
            return false;
        }
        if (!UUIDUtils.isCoeditUuid(shareSyncEntry.getUuid())) {
            CoeditLogger.m8924w(TAG, "[5-2] isValidUploadEntry, old uuid " + shareSyncEntry.getUuid());
            return false;
        }
        if (new File(shareSyncEntry.getFilePath()).exists()) {
            return true;
        }
        CoeditLogger.m8924w(TAG, "[5-2] isValidUploadEntry, stop, file does not exist, path : " + CoeditLogger.getEncode(shareSyncEntry.getFilePath()));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createSharedNotebooksForRestore$1(String str, Context context, String str2, SpaceResult spaceResult) {
        if (spaceResult.getStatus().getCode() != 1) {
            CoeditLogger.m8920e(TAG, "createSharedNotebooksForRestore#, fail to requestSpaceCreation#");
            return;
        }
        String spaceId = spaceResult.getResult().getSpaceId();
        CoeditLogger.m8923i(TAG, "createSharedNotebooksForRestore#, succeed to requestSpaceCreation#, groupId = " + str + ", spaceId = " + spaceId);
        importToSpaceForRestore(context, str2, spaceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restoreNoteToCoedit$0(Context context, NotesDocumentEntity notesDocumentEntity, String str, GroupInvitationResult groupInvitationResult) {
        boolean z = groupInvitationResult.getStatus().getCode() == 1;
        CoeditLogger.m8923i(TAG, "restoreNoteToCoedit# onResult : " + z + ", displayMessage : " + groupInvitationResult.getDisplayMessage());
        if (!z) {
            CoeditLogger.m8920e(TAG, "restoreNoteToCoedit# fail");
        } else {
            if (createSharedNotebooksForRestore(context, notesDocumentEntity.getUuid(), groupInvitationResult.getGroup().getGroupId(), str)) {
                return;
            }
            CoeditLogger.m8920e(TAG, "restoreNoteToCoedit# fail");
        }
    }

    private void processFailedImportItem(List<String> list, String str, C6749r c6749r, @NonNull Context context) {
        list.add(str);
        releaseFailedImportItem(str, c6749r, context);
    }

    private void releaseFailedImportItem(String str, C6749r c6749r, @NonNull Context context) {
        c6749r.m4886b(6, str, "LocalCoedit FailedImportItem");
        CoeditCacheUtils.removeCoeditCache(context, str);
    }

    private int uploadSpenWNote(Context context, ExternalCoeditUploadItem externalCoeditUploadItem) {
        try {
            try {
                int iConnectServiceToUploadNote = connectServiceToUploadNote(context, externalCoeditUploadItem);
                CoeditLogger.m8923i(TAG, "uploadSpenWNote, ret : " + iConnectServiceToUploadNote);
                return iConnectServiceToUploadNote;
            } catch (Throwable th) {
                CoeditLogger.m8923i(TAG, "uploadSpenWNote, ret : 200");
                throw th;
            }
        } catch (InterruptedException | ExecutionException e) {
            CoeditLogger.m8920e(TAG, "uploadSpenWNote, fail to upload wNote, e : " + e.getMessage());
            CoeditLogger.m8923i(TAG, "uploadSpenWNote, ret : 200");
            return 200;
        }
    }

    @SuppressLint({WarningType.NewApi})
    public int connectServiceToUploadNote(final Context context, final ExternalCoeditUploadItem externalCoeditUploadItem) {
        CoeditLogger.m8919d(TAG, "connectServiceToUploadNote, CoeditService");
        final CompletableFuture completableFuture = new CompletableFuture();
        String uuid = externalCoeditUploadItem.getEntry().getUuid();
        final String str = CoeditConstants.User.UpDownloader.name() + "_up_" + uuid;
        Intent intent = new Intent(context, (Class<?>) CoeditService.class);
        intent.putExtra("document_uuid", uuid);
        CoeditServiceConnection coeditServiceConnection = new CoeditServiceConnection() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.InternalImportHandler.1
            @SuppressLint({WarningType.NewApi})
            private void uploadCoeditNote() {
                CoeditLogger.m8919d(InternalImportHandler.TAG, "[CS5] uploadCoeditNote() uuid : " + externalCoeditUploadItem.getEntry().getUuid());
                String filePath = externalCoeditUploadItem.getEntry().getFilePath();
                final String uuid2 = externalCoeditUploadItem.getEntry().getUuid();
                this.mService.executeExternalTask(new ExternalSnapUploadTask(context, filePath, uuid2, externalCoeditUploadItem.getGroupId(), "", externalCoeditUploadItem.getEntry().getSpaceId(), new ExternalBaseTask.UpDownloadCallback() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.InternalImportHandler.1.1
                    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.UpDownloadCallback
                    @SuppressLint({WarningType.NewApi})
                    public void onCompleted() {
                        CoeditLogger.m8923i(InternalImportHandler.TAG, "[CS5-1] uploadCoeditNote() uuid : " + uuid2);
                        completableFuture.complete(200);
                    }

                    @Override // com.samsung.android.support.senl.nt.coedit.service.task.ExternalBaseTask.UpDownloadCallback
                    @SuppressLint({WarningType.NewApi})
                    public void onError(int i) {
                        StringBuilder sbM778t = AbstractC0541b.m778t(i, "[CS5-2] uploadCoeditNote() fail to upload, errorCode: ", ", uuid : ");
                        sbM778t.append(uuid2);
                        CoeditLogger.m8920e(InternalImportHandler.TAG, sbM778t.toString());
                        completableFuture.complete(Integer.valueOf(i));
                    }
                }));
            }

            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                CoeditLogger.m8920e(InternalImportHandler.TAG, "connectServiceToUploadNote, onNullBinding()");
                completableFuture.complete(Integer.valueOf(InternalImportHandler.this.getSnapError()));
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder == null) {
                    CoeditLogger.m8920e(InternalImportHandler.TAG, "connectServiceToUploadNote, onServiceConnected() CoeditService is unavailable");
                    completableFuture.complete(Integer.valueOf(InternalImportHandler.this.getSnapError()));
                    return;
                }
                CoeditLogger.m8919d(InternalImportHandler.TAG, "connectServiceToUploadNote, onServiceConnected()");
                CoeditService service = ((CoeditService.LocalBinder) iBinder).getService();
                this.mService = service;
                service.subscribe(str);
                uploadCoeditNote();
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                CoeditLogger.m8920e(InternalImportHandler.TAG, "connectServiceToUploadNote, onServiceDisconnected()");
                this.mService = null;
            }
        };
        if (!context.bindService(intent, coeditServiceConnection, 1)) {
            CoeditLogger.m8920e(TAG, "connectServiceToUploadNote, fail to bind!");
            completableFuture.complete(Integer.valueOf(getSnapError()));
        }
        Integer num = 202;
        try {
            try {
                Integer num2 = (Integer) completableFuture.get(600000L, TimeUnit.MILLISECONDS);
                coeditServiceConnection.unsubscribe(str);
                CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
                num = num2;
            } catch (TimeoutException unused) {
                CoeditLogger.m8920e(TAG, "connectServiceToUploadNote, TimeoutException");
                CoeditHandlerManager.getInstance().forceCancel(uuid, "connectServiceToUploadNote-Timeout");
                coeditServiceConnection.unsubscribe(str);
                CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
            }
            return num.intValue();
        } catch (Throwable th) {
            coeditServiceConnection.unsubscribe(str);
            CoeditConnectionUtils.unbindService(context, coeditServiceConnection);
            throw th;
        }
    }

    public ImportResult importNoteToCoedit(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        return generateImportResult(importNoteToCoeditInternal(context, str, str2));
    }

    public void restoreNoteToCoedit(@NonNull Collection<String> collection) {
        String string;
        Throwable th;
        if (!collection.isEmpty()) {
            Context applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                CoeditLogger.m8919d(TAG, "restoreNoteToCoedit# return - appContext is null");
                return;
            }
            for (NotesDocumentEntity notesDocumentEntity : NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository().getEntitiesByUuids(collection)) {
                String mdeExtra = notesDocumentEntity.getMdeExtra();
                if (!mdeExtra.isEmpty()) {
                    try {
                        string = new JSONObject(mdeExtra).getString(Constants.KEY_SPACE_ID);
                    } catch (JSONException e) {
                        Debugger.m8609e(TAG, "coedit restore fail : " + e.getMessage());
                        string = "";
                    }
                    if (SesCoeditShareReadResolver.getInstance().isSpaceExist(string)) {
                        importToSpaceForRestore(applicationContext, notesDocumentEntity.getUuid(), string);
                    } else {
                        if (AbstractC0267s.m544b()) {
                            CoeditLogger.m8919d(TAG, "restoreNoteToCoedit# return - isStorageFull");
                            return;
                        }
                        try {
                            try {
                                C6715o.m4808q().m4796c(1);
                            } catch (Exception e2) {
                                e = e2;
                            }
                            if (AbstractC14517a.m15159s().isAgreementProcedureNeeded(0)) {
                                try {
                                    CoeditLogger.m8919d(TAG, "restoreNoteToCoedit# return - isAgreementProcedureNeeded false");
                                    C6715o.m4808q().m4797d(1, null);
                                    return;
                                } catch (Throwable th2) {
                                    th = th2;
                                    C6715o.m4808q().m4797d(1, null);
                                    throw th;
                                }
                            }
                            String str = "Group://Standalone " + notesDocumentEntity.getTitle();
                            try {
                                try {
                                    AbstractC0254f.m535a().requestGroupCreation(new GroupApi.GroupRequest(str, "UNM1", true), new C2517b(1, this, applicationContext, notesDocumentEntity, str));
                                } catch (Throwable th3) {
                                    th = th3;
                                    th = th;
                                    C6715o.m4808q().m4797d(1, null);
                                    throw th;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                CoeditLogger.m8920e(TAG, "restoreNoteToCoedit# " + e);
                            }
                            C6715o.m4808q().m4797d(1, null);
                            CoeditLogger.m8920e(TAG, "restoreNoteToCoedit# " + e);
                            C6715o.m4808q().m4797d(1, null);
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                }
            }
        }
    }

    public void restoreNoteToCoeditAsync(@NonNull final String str) {
        this.mThreadPoolExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.coedit.caller.handler.InternalImportHandler.2
            @Override // java.lang.Runnable
            public void run() {
                InternalImportHandler.this.restoreNoteToCoedit(Collections.singletonList(str));
            }
        });
    }

    public ImportResult importNoteToCoedit(@NonNull Context context, @NonNull List<String> list, @NonNull String str, @Nullable InterfaceC0102a interfaceC0102a) {
        return generateImportResult(importNoteToCoeditInternal(context, list, str, interfaceC0102a));
    }

    private int copyToCoeditSpace(@NonNull Context context, @NonNull String str, @NonNull String str2, @NonNull String str3) {
        String strM289a = AbstractC0142a.m289a(str3);
        C0283a.m562d().getClass();
        String strM561c = C0283a.m561c();
        if (!TextUtils.isEmpty(strM289a) && !TextUtils.isEmpty(strM561c)) {
            return new AddNoteToSharedNotebookUseCase(context).execute(new AddNoteToSharedNotebookUseCase.Param(str, str2, NotesDocumentFileUtils.createSavedPath(context, ".sdocx"), str3, strM289a, strM561c)).intValue();
        }
        CoeditLogger.m8920e(TAG, "copyToCoeditSpace, failed : empty Id exists, group id: " + strM289a + ", ownerId: " + strM561c);
        return 110;
    }

    private ImportReturnValues importNoteToCoeditInternal(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        ImportReturnValues importReturnValues = new ImportReturnValues();
        SpenSdkInitializer.initialize(context);
        if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning()) {
            CoeditLogger.m8924w(TAG, "importNoteToCoeditInternal, stop, isRunningOnCoeditMode");
            importReturnValues.ret = 204;
            return importReturnValues;
        }
        String strNewUUID = UUIDUtils.newUUID(context, true);
        importReturnValues.ret = copyToCoeditSpace(context, str, strNewUUID, str2);
        CoeditLogger.m8919d(TAG, "importNoteToCoeditInternal, copyResult : " + importReturnValues.ret);
        if (importReturnValues.ret != 100) {
            return importReturnValues;
        }
        try {
            C6749r c6749r = new C6749r(context);
            if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning()) {
                importReturnValues.ret = 204;
                releaseFailedImportItem(strNewUUID, c6749r, context);
                return importReturnValues;
            }
            if (!CoeditUtils.isCoeditDataNetworkAvailable()) {
                importReturnValues.ret = 203;
                releaseFailedImportItem(strNewUUID, c6749r, context);
                return importReturnValues;
            }
            ExternalCoeditUploadItem externalCoeditUploadItemCreateExternalCoeditUploadItem = createExternalCoeditUploadItem(new SyncNoteDataRepository().getShareSyncEntry(strNewUUID));
            if (externalCoeditUploadItemCreateExternalCoeditUploadItem == null) {
                importReturnValues.ret = 202;
                releaseFailedImportItem(strNewUUID, c6749r, context);
                return importReturnValues;
            }
            importReturnValues.ret = 200;
            importReturnValues.newUuidList.add(strNewUUID);
            importReturnValues.newPathList.add(externalCoeditUploadItemCreateExternalCoeditUploadItem.getEntry().getFilePath());
            return importReturnValues;
        } catch (Exception e) {
            AbstractC8014b.m7218t(e, new StringBuilder("importNoteToCoeditInternal, exception : "), TAG);
            return importReturnValues;
        }
    }
}
