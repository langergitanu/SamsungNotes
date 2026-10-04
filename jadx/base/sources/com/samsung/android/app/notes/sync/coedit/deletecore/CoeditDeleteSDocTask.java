package com.samsung.android.app.notes.sync.coedit.deletecore;

import android.content.Context;
import android.os.SystemClock;
import com.samsung.android.app.notes.sync.coedit.basecore.CoeditSDocTask;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.sdk.mobileservice.social.share.result.ItemListResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p028G.InterfaceC0103b;
import p075S.AbstractC0248O;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditDeleteSDocTask extends CoeditSDocTask {
    private static final long ERROR_ITEM_WAS_ALREADY_REMOVED = 112601;
    public static final int SPLIT_SIZE = 50;
    private static final String TAG = "MdeDeleteSDocTask";
    private boolean mCancelFlag = false;
    private final List<String> mDeleteList;
    private InterfaceC0103b mListener;
    private final String mSpaceId;

    public CoeditDeleteSDocTask(String str, List<String> list, InterfaceC0103b interfaceC0103b) {
        this.mSpaceId = str;
        this.mDeleteList = list;
        this.mListener = interfaceC0103b;
    }

    private void deleteLocal(Context context, String str) {
        NotesDocumentEntity notesDocumentEntityM9f;
        if (str != null) {
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            AbstractC0000a.m18o(context, context, context);
        } else {
            notesDocumentEntityM9f = null;
        }
        NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
        C14433b c14433b = new C14433b(12);
        if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) == 1) {
            Debugger.m8607d(TAG, str + " is already deleted!");
            return;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("[SyncDelete] deleteAllNoteData, docUUID: ", str, " by ", TAG, ", callee: ");
        sbM16m.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Debugger.m8614f("WDocWriteResolver", sbM16m.toString());
        DocumentWriteResolver.deleteAllNoteData(context, str, 4);
        c14433b.m15037k(str);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.mListener.onStart();
    }

    @Override // com.samsung.android.app.notes.sync.coedit.basecore.CoeditSDocTask
    public void stop() {
        synchronized (this) {
            this.mListener = null;
            Debugger.m8615i(TAG, "stop()");
            this.mCancelFlag = true;
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.basecore.CoeditSDocTask, android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        Thread.currentThread().setName("DeleteSharedSDocTask");
        Context appContext = C0322h.m670a().f815a.getAppContext();
        SpenSdkInitializer.initialize(appContext);
        try {
            try {
                C6715o.m4808q().m4796c(3);
                ArrayList arrayList = new ArrayList();
                SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
                for (List list : AbstractC0299q.m624d0(this.mDeleteList, 50)) {
                    ArrayList arrayList2 = new ArrayList();
                    HashMap map = new HashMap();
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String str = (String) it.next();
                        if (this.mCancelFlag) {
                            Debugger.m8607d(TAG, "Deleting task cancelled.");
                            break;
                        }
                        Debugger.m8607d(TAG, "Try to delete - " + str);
                        String itemId = syncNoteDataRepository.getShareSyncEntry(str).getItemId();
                        if (itemId == null || itemId.isEmpty()) {
                            Debugger.m8607d(TAG, "Item ID is null or empty. Delete local item.");
                            deleteLocal(appContext, str);
                            arrayList.add(str);
                        } else {
                            arrayList2.add(itemId);
                            map.put(itemId, str);
                        }
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    ItemListResult itemListResultM529c = AbstractC0248O.m529c(this.mSpaceId, arrayList2);
                    if (itemListResultM529c == null) {
                        Debugger.m8607d(TAG, "requestResult is null.");
                    } else {
                        if (itemListResultM529c.getStatus() != null) {
                            Debugger.m8607d(TAG, "requestSharedItemDeletion : error code = " + itemListResultM529c.getStatus().getCode());
                        }
                        Debugger.m8607d(TAG, "requestSharedItemDeletion : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                        List<ItemListResult.SharedItemListSuccessResult> successList = itemListResultM529c.getSuccessList();
                        List<ItemListResult.SharedItemListFailureResult> failureList = itemListResultM529c.getFailureList();
                        if (successList != null && !successList.isEmpty()) {
                            Iterator<ItemListResult.SharedItemListSuccessResult> it2 = successList.iterator();
                            while (it2.hasNext()) {
                                String itemId2 = it2.next().getItemId();
                                if (arrayList2.contains(itemId2)) {
                                    Debugger.m8607d(TAG, "Success to remove the item. : " + itemId2);
                                    String str2 = (String) map.get(itemId2);
                                    deleteLocal(appContext, str2);
                                    arrayList.add(str2);
                                }
                            }
                        } else if (failureList == null || failureList.isEmpty()) {
                            Debugger.m8609e(TAG, "Unknown Case.");
                        } else {
                            for (ItemListResult.SharedItemListFailureResult sharedItemListFailureResult : failureList) {
                                Long errorCode = sharedItemListFailureResult.getErrorCode();
                                if (errorCode.longValue() == ERROR_ITEM_WAS_ALREADY_REMOVED) {
                                    Debugger.m8607d(TAG, "The item was already removed.");
                                    String str3 = (String) map.get(sharedItemListFailureResult.getItemId());
                                    deleteLocal(appContext, str3);
                                    arrayList.add(str3);
                                } else {
                                    Debugger.m8609e(TAG, "Failed to delete item. errCode : " + errorCode);
                                }
                            }
                        }
                    }
                }
                Debugger.m8607d(TAG, "DeleteSharedSDoc. Total : " + this.mDeleteList.size() + " / Success : " + arrayList.size());
            } catch (Exception e) {
                Debugger.m8609e(TAG, "Exception while deleting item. " + e.getMessage());
            }
            C6715o.m4808q().m4797d(3, null);
            return null;
        } catch (Throwable th) {
            C6715o.m4808q().m4797d(3, null);
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Void r2) {
        super.onPostExecute(r2);
        InterfaceC0103b interfaceC0103b = this.mListener;
        if (interfaceC0103b != null) {
            interfaceC0103b.mo245a(this.mSpaceId);
        }
    }
}
