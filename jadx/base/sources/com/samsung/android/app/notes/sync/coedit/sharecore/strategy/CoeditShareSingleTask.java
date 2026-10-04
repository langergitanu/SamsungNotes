package com.samsung.android.app.notes.sync.coedit.sharecore.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6715o;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;
import p002A0.C0004d;
import p036I.C0118a;
import p036I.C0119b;
import p036I.C0120c;
import p036I.InterfaceC0121d;
import p042J1.AbstractC0155m;
import p068Q.C0204a;
import p075S.AbstractC0267s;
import p079T.AbstractC0298p;
import p079T.AbstractC0299q;
import p079T.C0297o;
import p086V.C0322h;
import p186h1.C12020a;
import p207n1.C13540g;
import p207n1.C13541h;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditShareSingleTask extends CoeditShareBaseTask {
    private static final String TAG = "CoeditShareSingleTask";
    private C0120c mCoeditShareSDoc;
    private InterfaceC0121d mShareTaskContact;

    public CoeditShareSingleTask(Context context, InterfaceC6669a interfaceC6669a, String str) {
        super(context, interfaceC6669a, str);
        this.mShareTaskContact = new C12020a(this, 6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:306:0x0b7f, code lost:
    
        if (r1 != false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:0x0b85, code lost:
    
        if (r11.isCancelled() == false) goto L312;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x0b87, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled before finishing downloading sDocs!");
     */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x090c  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x0b8e  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0bb3  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0bba  */
    @Override // com.samsung.android.app.notes.sync.coedit.sharecore.strategy.CoeditShareBaseTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<C0204a> shareProgress() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        C0118a c0118a;
        List<SharedItem> listRequestSharedItemList;
        HashMap map;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        boolean z2;
        ArrayList arrayList4;
        C0118a c0118a2;
        CoeditShareSingleTask coeditShareSingleTask;
        boolean z3;
        CoeditShareSingleTask coeditShareSingleTask2;
        long j;
        long jLongValue;
        SyncNoteDataRepository syncNoteDataRepository;
        Iterator it;
        boolean z4;
        String str5;
        boolean zM386a;
        String str6;
        String str7;
        HashMap map2;
        Iterator it2;
        String str8;
        String str9;
        String string;
        String str10;
        String str11;
        int i;
        NotesDocumentEntity notesDocumentEntityM9f;
        String str12;
        int i2;
        String str13 = "shareProgress() [" + hashCode() + "]";
        String str14 = TAG;
        Debugger.m8607d(TAG, str13);
        String str15 = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        if (str15 == null) {
            Debugger.m8609e(TAG, "emailID is null");
            return null;
        }
        Context context = this.mContext;
        String str16 = this.mSpaceId;
        C0118a c0118a3 = new C0118a();
        c0118a3.f375b = new ArrayList();
        c0118a3.f377d = true;
        c0118a3.f378e = true;
        c0118a3.f374a = context;
        c0118a3.f376c = str16;
        this.mDocShareInfo = c0118a3;
        this.mDocShareOperation = new C0119b(c0118a3);
        Debugger.m8607d(TAG, "Share : Agent v." + SeMobileService.getAgentVersion(this.mContext) + ", SDK v." + SeMobileService.getSdkVersionName() + " , Server Time : " + TimeManager.getCurrentTime(this.mContext) + " , Device Time : " + System.currentTimeMillis());
        Context context2 = this.mDocShareOperation.f379a.f374a;
        String str17 = "SDocShareData";
        String str18 = " is already deleted!";
        String str19 = "SyncDelayInfoRepository";
        if (str15.equals(context2.getSharedPreferences("CoeditShareService", 0).getString("UserId", null))) {
            str = TAG;
        } else {
            Debugger.m8615i("ShareSingleTask$SDocShareOperation", "Account changed!");
            Context appContext = C0322h.m670a().f815a.getAppContext();
            NotesDataRepositoryFactory.newInstance(appContext).createDocumentDataRepository();
            NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(appContext).createDocumentTempDataRepository();
            SyncDelayInfoDao syncDelayInfoDao = NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(appContext).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(appContext).createDocumentTagRepository();
            NotesDataRepositoryFactory.newInstance(appContext).createNotesDocumentPageRepository();
            NotesDataRepositoryFactory.newInstance(appContext).createMappedDocumentRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            List<String> uuidListCoedit = syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListCoedit();
            for (String str20 : uuidListCoedit) {
                if (str20 != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(appContext, str20);
                    AbstractC0000a.m18o(appContext, appContext, appContext);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if (notesDocumentEntityM9f != null) {
                    int isDeleted = notesDocumentEntityM9f.getIsDeleted();
                    str12 = str14;
                    i2 = isDeleted;
                } else {
                    str12 = str14;
                    i2 = 1;
                }
                if (i2 != 1) {
                    StringBuilder sbM15l = AbstractC0000a.m15l("[SyncDelete] deleteAllNoteData, docUUID: ", str20, " by SDocShareOperation, callee: ");
                    sbM15l.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                    Debugger.m8614f("WDocWriteResolver", sbM15l.toString());
                    DocumentWriteResolver.deleteAllNoteData(appContext, str20, 4);
                    Debugger.m8614f("SyncDelayInfoRepository", "delete, uuid : " + str20);
                    syncDelayInfoDao.delete(str20);
                } else {
                    Debugger.m8607d("ShareSingleTask$SDocShareOperation", str20 + " is already deleted!");
                }
                str14 = str12;
            }
            str = str14;
            Debugger.m8607d("ShareSingleTask$SDocShareOperation", "deleteAllLocalSharedItem. deleted : " + uuidListCoedit.size());
            if (context2 == null) {
                Debugger.m8609e("SDocShareData", "setUserID() : context is null!");
            } else {
                SharedPreferences.Editor editorEdit = context2.getSharedPreferences("CoeditShareService", 0).edit();
                editorEdit.putString("UserId", str15);
                editorEdit.apply();
            }
        }
        C0120c c0120c = new C0120c(this.mDocShareInfo, this.mShareTaskContact);
        this.mCoeditShareSDoc = c0120c;
        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "[Start sharing coedit]");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C12020a c12020a = (C12020a) c0120c.f384e;
        CoeditShareSingleTask coeditShareSingleTask3 = (CoeditShareSingleTask) c12020a.f8772b;
        CoeditShareSingleTask coeditShareSingleTask4 = (CoeditShareSingleTask) c12020a.f8772b;
        if (!coeditShareSingleTask3.isCancelled()) {
            boolean zM402q = AbstractC0155m.m402q();
            C0118a c0118a4 = c0120c.f383d;
            if (!zM402q) {
                c0118a4.f378e = false;
                c0118a4.f377d = false;
                throw new ShareException(ShareConstants$ResultCode.FAIL_DEVICE_STORAGE_FULL_EXCEPTION, "device storage is full!");
            }
            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Start to get local list ");
            Context context3 = c0118a4.f374a;
            String str21 = c0118a4.f376c;
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context3).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context3).createDocumentTagRepository();
            NotesDataRepositoryFactory.newInstance(context3).createNotesDocumentPageRepository();
            NotesDataRepositoryFactory.newInstance(context3).createMappedDocumentRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            List<String> uuidListMde = (str21 == null || str21.isEmpty()) ? syncNoteDataRepositoryCreateSyncNoteDataRepository2.getUuidListMde() : syncNoteDataRepositoryCreateSyncNoteDataRepository2.getUuidListBySpaceIdOld(str21);
            if (uuidListMde == null) {
                Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "Failed to get all uuid List for coedit");
                throw new ShareException(ShareConstants$ResultCode.FAIL_DB_EXCEPTION, "Failed to get all uuid List for coedit");
            }
            List<String> list = uuidListMde;
            ArrayList arrayList5 = new ArrayList();
            str2 = "CoeditShareService";
            SyncNoteDataRepository syncNoteDataRepository2 = new SyncNoteDataRepository();
            for (String str22 : list) {
                String str23 = str17;
                ShareSyncEntry shareSyncEntry = syncNoteDataRepository2.getShareSyncEntry(str22);
                SyncNoteDataRepository syncNoteDataRepository3 = syncNoteDataRepository2;
                if (!"coedit:///".equals(shareSyncEntry.getCategoryUuid())) {
                    C0004d c0004d = new C0004d(shareSyncEntry.getSpaceId(), str22, shareSyncEntry.getFileName(), shareSyncEntry.getServerTimestamp().longValue(), shareSyncEntry.getCreatedAt(), shareSyncEntry.getLastModifiedAt());
                    c0004d.f16a = shareSyncEntry.getItemId();
                    c0004d.f20e = shareSyncEntry.getIsDirty() == 1;
                    arrayList5.add(c0004d);
                }
                str17 = str23;
                syncNoteDataRepository2 = syncNoteDataRepository3;
            }
            str3 = str17;
            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Finish to get local list " + arrayList5.size());
            String str24 = "uuid";
            CoeditShareSingleTask coeditShareSingleTask5 = coeditShareSingleTask4;
            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Start to get server list ");
            if (!C6715o.m4808q().m4801j()) {
                throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, "Ses Session is not connected");
            }
            try {
                if (AbstractC0267s.m549g().getResult()) {
                    Debugger.m8615i("CoeditShareSingleTask$CoeditShareSDoc", "succeed to SesCoeditShareApi.requestSync()");
                    ArrayList arrayList6 = new ArrayList();
                    Context appContext2 = C0322h.m670a().f815a.getAppContext();
                    if (str21 == null || str21.isEmpty()) {
                        c0118a = c0118a4;
                        listRequestSharedItemList = SesShareReadResolver.getInstance().requestSharedItemList(appContext2);
                    } else {
                        c0118a = c0118a4;
                        listRequestSharedItemList = SesShareReadResolver.getInstance().requestSharedItemList(appContext2, str21);
                    }
                    if (listRequestSharedItemList == null) {
                        throw new ShareException(ShareConstants$ResultCode.FAIL_SERVER_EXCEPTION, "requestSharedItemList queryResult is null");
                    }
                    int size = listRequestSharedItemList.size();
                    int i4 = 0;
                    while (i4 < size) {
                        try {
                            SharedItem sharedItem = listRequestSharedItemList.get(i4);
                            List<SharedItem> list2 = listRequestSharedItemList;
                            if (sharedItem.getMetaData().containsKey(str24)) {
                                Object obj = sharedItem.getMetaData().get(str24);
                                if (obj == null) {
                                    Debugger.m8614f("CoeditShareSingleTask$CoeditShareSDoc", "Exception while getting server sdoc item uuid");
                                    str10 = str24;
                                    i4++;
                                    listRequestSharedItemList = list2;
                                    str24 = str10;
                                } else {
                                    string = obj.toString();
                                }
                            } else {
                                string = null;
                            }
                            C0004d c0004d2 = new C0004d(sharedItem.getSpaceId(), string, sharedItem.getTitle(), sharedItem.getMetaData().containsKey("lastModifiedAt") ? ((Long) sharedItem.getMetaData().get("lastModifiedAt")).longValue() : 0L, sharedItem.getMetaData().containsKey("createdAt") ? ((Long) sharedItem.getMetaData().get("createdAt")).longValue() : 0L, sharedItem.getMetaData().containsKey("DoclastModifiedAt") ? ((Long) sharedItem.getMetaData().get("DoclastModifiedAt")).longValue() : 0L);
                            str10 = str24;
                            c0004d2.f16a = sharedItem.getItemId();
                            sharedItem.getCreatedTime();
                            arrayList6.add(c0004d2);
                            i4++;
                            listRequestSharedItemList = list2;
                            str24 = str10;
                        } catch (Exception e) {
                            Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "Exception while getting server sdoc items.");
                            throw new ShareException(ShareConstants$ResultCode.FAIL_SERVER_EXCEPTION, e.getMessage());
                        }
                    }
                    Iterator it3 = arrayList6.iterator();
                    while (true) {
                        boolean zHasNext = it3.hasNext();
                        map = c0120c.f385f;
                        if (!zHasNext) {
                            break;
                        }
                        C0004d c0004d3 = (C0004d) it3.next();
                        map.put(c0004d3.m32b(), c0004d3);
                    }
                    if (coeditShareSingleTask5.isCancelled()) {
                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled Sharing");
                    } else {
                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "makeListsForShare()");
                        NotesDataRepositoryFactory.newInstance(context3).createDocumentDataRepository();
                        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository3 = NotesDataRepositoryFactory.newInstance(context3).createSyncNoteDataRepository();
                        NotesDataRepositoryFactory.newInstance(context3).createDocumentTempDataRepository();
                        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                        SyncNoteDataRepository syncNoteDataRepository4 = new SyncNoteDataRepository();
                        Iterator it4 = arrayList5.iterator();
                        while (true) {
                            boolean zHasNext2 = it4.hasNext();
                            arrayList = c0120c.f381b;
                            arrayList2 = c0120c.f380a;
                            arrayList3 = c0120c.f382c;
                            if (!zHasNext2) {
                                break;
                            }
                            C0004d c0004d4 = (C0004d) it4.next();
                            C0120c c0120c2 = c0120c;
                            C0004d c0004d5 = (C0004d) map.get(c0004d4.m32b());
                            if (c0004d5 != null) {
                                map.remove(c0004d5.m32b());
                                map2 = map;
                                it2 = it4;
                                long jM31a = c0004d4.m31a();
                                str8 = str18;
                                long jM31a2 = c0004d5.m31a();
                                if (jM31a2 > jM31a) {
                                    str9 = str19;
                                    Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "makeListsForShare() uuid : " + c0004d4.m32b() + " server - serverTimestamp :" + jM31a2 + " localTime : " + jM31a);
                                    arrayList.add(c0004d5);
                                } else {
                                    str9 = str19;
                                    if (jM31a2 < jM31a) {
                                        String strM32b = c0004d4.m32b();
                                        if (TextUtils.isEmpty(syncNoteDataRepository4.getShareSyncEntry(strM32b).getItemId())) {
                                            syncNoteDataRepositoryCreateSyncNoteDataRepository3.setMdeItemId(strM32b, c0004d5.f16a);
                                            c0004d4.f16a = c0004d5.f16a;
                                        }
                                        if (!AbstractC14517a.m15166z(context3, strM32b)) {
                                            Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "owner id is different");
                                        } else if (!AbstractC14517a.m15165y(context3, strM32b) && c0004d4.f20e) {
                                            arrayList2.add(c0004d4);
                                        }
                                    } else {
                                        String strM32b2 = c0004d4.m32b();
                                        ShareSyncEntry shareSyncEntry2 = syncNoteDataRepository4.getShareSyncEntry(strM32b2);
                                        if (TextUtils.isEmpty(shareSyncEntry2.getItemId())) {
                                            syncNoteDataRepositoryCreateSyncNoteDataRepository3.setMdeItemId(strM32b2, c0004d5.f16a);
                                            c0004d4.f16a = c0004d5.f16a;
                                        }
                                        if (shareSyncEntry2.getIsDirty() == 1) {
                                            syncNoteDataRepositoryCreateSyncNoteDataRepository3.updateDirty(strM32b2, 0);
                                        }
                                    }
                                }
                            } else {
                                map2 = map;
                                it2 = it4;
                                str8 = str18;
                                str9 = str19;
                                String str25 = c0004d4.f16a;
                                if (str25 != null && !str25.isEmpty()) {
                                    arrayList3.add(c0004d4);
                                } else if (AbstractC14517a.m15166z(context3, c0004d4.m32b())) {
                                    arrayList2.add(c0004d4);
                                } else {
                                    Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "owner id is different (only local)");
                                }
                            }
                            c0120c = c0120c2;
                            map = map2;
                            it4 = it2;
                            str18 = str8;
                            str19 = str9;
                        }
                        String str26 = str18;
                        String str27 = str19;
                        Iterator it5 = map.entrySet().iterator();
                        while (it5.hasNext()) {
                            arrayList.add((C0004d) ((Map.Entry) it5.next()).getValue());
                        }
                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "toDeleteLocalList: " + arrayList3.size());
                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "toUploadList: " + arrayList2.size() + " ,toDownloadList: " + arrayList.size());
                        if (arrayList3.size() + arrayList.size() + arrayList2.size() > 0) {
                            if (arrayList3.isEmpty()) {
                                if (arrayList2.isEmpty()) {
                                }
                                if (arrayList4.isEmpty()) {
                                }
                            } else {
                                Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Start to delete local : " + arrayList3.size());
                                NotesDataRepositoryFactory.newInstance(context3).createDocumentDataRepository();
                                NotesDataRepositoryFactory.newInstance(context3).createSyncNoteDataRepository();
                                NotesDataRepositoryFactory.newInstance(context3).createDocumentTempDataRepository();
                                SyncDelayInfoDao syncDelayInfoDao2 = NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                SyncNoteDataRepository syncNoteDataRepository5 = new SyncNoteDataRepository();
                                Iterator it6 = arrayList3.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Finished to delete local");
                                        break;
                                    }
                                    C0004d c0004d6 = (C0004d) it6.next();
                                    if (coeditShareSingleTask5.isCancelled()) {
                                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled deleteLocal");
                                        if (coeditShareSingleTask5.isCancelled()) {
                                            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled before deleting sDocs in a server!");
                                        }
                                    } else {
                                        ShareSyncEntry shareSyncEntry3 = syncNoteDataRepository5.getShareSyncEntry(c0004d6.m32b());
                                        if (shareSyncEntry3 == null || shareSyncEntry3.getIsDeleted() == 1) {
                                            str6 = str27;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(c0004d6.f16a);
                                            str7 = str26;
                                            sb.append(str7);
                                            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", sb.toString());
                                        } else {
                                            String strM32b3 = c0004d6.m32b();
                                            StringBuilder sbM15l2 = AbstractC0000a.m15l("[SyncDelete] deleteAllNoteData, docUUID: ", strM32b3, " by RemoteShare, callee: ");
                                            sbM15l2.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                                            Debugger.m8614f("WDocWriteResolver", sbM15l2.toString());
                                            DocumentWriteResolver.deleteAllNoteData(context3, strM32b3, 4);
                                            str6 = str27;
                                            Debugger.m8614f(str6, "delete, uuid : " + strM32b3);
                                            syncDelayInfoDao2.delete(strM32b3);
                                            str7 = str26;
                                        }
                                        str26 = str7;
                                        str27 = str6;
                                    }
                                }
                                if (arrayList2.isEmpty()) {
                                    int size2 = arrayList2.size();
                                    Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Start to upload : " + size2);
                                    Context appContext3 = C0322h.m670a().f815a.getAppContext();
                                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                                    HashMap map3 = new HashMap();
                                    HashMap map4 = new HashMap();
                                    SyncNoteDataRepository syncNoteDataRepository6 = new SyncNoteDataRepository();
                                    Iterator it7 = arrayList2.iterator();
                                    int i5 = 0;
                                    String spaceTitle = null;
                                    long j2 = 0;
                                    int i6 = 0;
                                    while (true) {
                                        if (it7.hasNext()) {
                                            arrayList4 = arrayList;
                                            C0004d c0004d7 = (C0004d) it7.next();
                                            if (coeditShareSingleTask5.isCancelled()) {
                                                Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled uploadSdoc");
                                                c0118a2 = c0118a;
                                                z4 = false;
                                                break;
                                            }
                                            Iterator it8 = it7;
                                            int i7 = i5 + 1;
                                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                            int i8 = i6;
                                            String strM32b4 = c0004d7.m32b();
                                            long j3 = j2;
                                            String str28 = c0004d7.f18c;
                                            try {
                                                zM386a = AbstractC0155m.m386a(syncNoteDataRepository6.getShareSyncEntry(strM32b4).getFilePath());
                                                str5 = spaceTitle;
                                            } catch (SyncException e2) {
                                                str5 = spaceTitle;
                                                AbstractC6670b.m4752m(e2, new StringBuilder("SyncException while checking canUpload. "), "CoeditShareSingleTask$CoeditShareSDoc");
                                                zM386a = false;
                                            }
                                            if (zM386a) {
                                                String str29 = c0004d7.f16a;
                                                if (str29 == null || str29.isEmpty()) {
                                                    if (map3.containsKey(str28)) {
                                                        ((ArrayList) map3.get(str28)).add(strM32b4);
                                                    } else {
                                                        ArrayList arrayList7 = new ArrayList();
                                                        arrayList7.add(strM32b4);
                                                        map3.put(str28, arrayList7);
                                                    }
                                                } else if (map4.containsKey(str28)) {
                                                    ((ArrayList) map4.get(str28)).add(new C0297o(strM32b4, str29));
                                                } else {
                                                    ArrayList arrayList8 = new ArrayList();
                                                    arrayList8.add(new C0297o(strM32b4, str29));
                                                    map4.put(str28, arrayList8);
                                                }
                                                long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime3;
                                                StringBuilder sbM1173s = AbstractC0622a.m1173s(i7, size2, "uploadSdoc() [0 / ", " / ", "] ut = ");
                                                sbM1173s.append(jElapsedRealtime4);
                                                Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", sbM1173s.toString());
                                                i5 = i7;
                                                it7 = it8;
                                                arrayList = arrayList4;
                                                j2 = j3 + jElapsedRealtime4;
                                                i6 = i8;
                                            } else {
                                                i6 = i8 + 1;
                                                if (str5 == null) {
                                                    spaceTitle = SesShareReadResolver.getInstance().getSpaceTitle(str28);
                                                    i5 = i7;
                                                    it7 = it8;
                                                    arrayList = arrayList4;
                                                    j2 = j3;
                                                } else {
                                                    i5 = i7;
                                                    it7 = it8;
                                                    arrayList = arrayList4;
                                                    j2 = j3;
                                                }
                                            }
                                            spaceTitle = str5;
                                        } else {
                                            String str30 = spaceTitle;
                                            arrayList4 = arrayList;
                                            long j5 = j2;
                                            int i9 = i6;
                                            SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(appContext3, appContext3);
                                            NotesDataRepositoryFactory.newInstance(appContext3).createDocumentTempDataRepository();
                                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                            for (Map.Entry entry : map3.entrySet()) {
                                                for (List list3 : AbstractC0299q.m624d0((ArrayList) entry.getValue(), 100)) {
                                                    ArrayList<String> arrayList9 = (ArrayList) AbstractC0298p.m590l(context3, (String) entry.getKey(), list3).f4483b;
                                                    if (arrayList9.size() != list3.size()) {
                                                        Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "fail to upload some notes");
                                                    } else {
                                                        for (String str31 : arrayList9) {
                                                            long jLongValue2 = syncNoteDataRepository6.getShareSyncEntry(str31).getServerTimestamp().longValue();
                                                            C0004d c0004dM278a = C0120c.m278a(str31, arrayList2);
                                                            if (jLongValue2 <= (c0004dM278a != null ? c0004dM278a.m31a() : Long.MAX_VALUE)) {
                                                                syncNoteDataRepositoryM3196f.updateDirty(str31, 0);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            for (Map.Entry entry2 : map4.entrySet()) {
                                                for (List list4 : AbstractC0299q.m624d0((ArrayList) entry2.getValue(), 100)) {
                                                    ArrayList<String> arrayList10 = (ArrayList) AbstractC0298p.m589k(context3, (String) entry2.getKey(), list4).f4483b;
                                                    if (arrayList10.size() != list4.size()) {
                                                        Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "fail to update some notes");
                                                    } else {
                                                        for (String str32 : arrayList10) {
                                                            long jLongValue3 = syncNoteDataRepository6.getShareSyncEntry(str32).getServerTimestamp().longValue();
                                                            C0004d c0004dM278a2 = C0120c.m278a(str32, arrayList2);
                                                            if (jLongValue3 <= (c0004dM278a2 != null ? c0004dM278a2.m31a() : Long.MAX_VALUE)) {
                                                                syncNoteDataRepositoryM3196f.updateDirty(str32, 0);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (i9 > 0) {
                                                c0118a2 = c0118a;
                                                c0118a2.f375b.add(new C0204a(2, str30, 5));
                                            } else {
                                                c0118a2 = c0118a;
                                            }
                                            long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                                            StringBuilder sbM1323p = AbstractC1974b.m1323p(j5, "uploadSdoc() finish : tut = ", " , tt = ");
                                            sbM1323p.append(jElapsedRealtime5);
                                            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", sbM1323p.toString());
                                            z4 = true;
                                        }
                                    }
                                    if (!z4 && coeditShareSingleTask5.isCancelled()) {
                                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled before downloading sDocs!");
                                    }
                                } else {
                                    arrayList4 = arrayList;
                                    c0118a2 = c0118a;
                                }
                                if (arrayList4.isEmpty()) {
                                    Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Start to download : " + arrayList4.size());
                                    long jElapsedRealtime6 = SystemClock.elapsedRealtime();
                                    SyncNoteDataRepository syncNoteDataRepository7 = new SyncNoteDataRepository();
                                    HashMap map5 = new HashMap();
                                    HashMap map6 = new HashMap();
                                    Set setM592B = AbstractC0299q.m592B(context3);
                                    Iterator it9 = arrayList4.iterator();
                                    int i10 = 0;
                                    while (true) {
                                        if (it9.hasNext()) {
                                            C0004d c0004d8 = (C0004d) it9.next();
                                            if (coeditShareSingleTask5.isCancelled()) {
                                                Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled downloadSdoc");
                                                coeditShareSingleTask = coeditShareSingleTask5;
                                                z3 = false;
                                                z = true;
                                                break;
                                            }
                                            i10++;
                                            if (!AbstractC0155m.m401p()) {
                                                c0118a2.f377d = false;
                                                throw new ShareException(ShareConstants$ResultCode.FAIL_DEVICE_STORAGE_FULL_EXCEPTION, "device storage is full!");
                                            }
                                            String strM32b5 = c0004d8.m32b();
                                            String str33 = c0004d8.f18c;
                                            long jElapsedRealtime7 = SystemClock.elapsedRealtime();
                                            try {
                                                ShareSyncEntry shareSyncEntry4 = syncNoteDataRepository7.getShareSyncEntry(strM32b5);
                                                if (shareSyncEntry4 == null) {
                                                    j = jElapsedRealtime6;
                                                    jLongValue = 0;
                                                } else {
                                                    j = jElapsedRealtime6;
                                                    jLongValue = shareSyncEntry4.getServerTimestamp().longValue();
                                                }
                                                if (jLongValue >= c0004d8.m31a()) {
                                                    Debugger.m8615i("CoeditShareSingleTask$CoeditShareSDoc", "ignore this file : newTime = " + jLongValue + " , item.getLastModifiedAt = " + c0004d8.m31a());
                                                    syncNoteDataRepository = syncNoteDataRepository7;
                                                } else {
                                                    String str34 = c0004d8.f19d;
                                                    syncNoteDataRepository = syncNoteDataRepository7;
                                                    if (str34.endsWith(".sdocx") || str34.endsWith(".sdoc")) {
                                                        if (setM592B != null) {
                                                            StringBuilder sb2 = new StringBuilder();
                                                            sb2.append(str33);
                                                            it = it9;
                                                            sb2.append(c0004d8.f16a);
                                                            if (setM592B.contains(sb2.toString())) {
                                                                Debugger.m8615i("CoeditShareSingleTask$CoeditShareSDoc", "previous broken file : newTime = " + jLongValue + " , item.getLastModifiedAt = " + c0004d8.m31a());
                                                            }
                                                            syncNoteDataRepository7 = syncNoteDataRepository;
                                                            it9 = it;
                                                            jElapsedRealtime6 = j;
                                                        } else {
                                                            it = it9;
                                                        }
                                                        Debugger.m8615i("CoeditShareSingleTask$CoeditShareSDoc", "download an item : " + c0004d8.m32b());
                                                        if (map5.containsKey(str33)) {
                                                            ((ArrayList) map5.get(str33)).add(c0004d8.f16a);
                                                            map6.put(str33 + c0004d8.f16a, str34);
                                                        } else {
                                                            ArrayList arrayList11 = new ArrayList();
                                                            arrayList11.add(c0004d8.f16a);
                                                            map5.put(str33, arrayList11);
                                                            map6.put(str33 + c0004d8.f16a, str34);
                                                        }
                                                        long jElapsedRealtime8 = SystemClock.elapsedRealtime() - jElapsedRealtime7;
                                                        StringBuilder sbM778t = AbstractC0541b.m778t(i10, "downloadSdoc() [0 / ", " / ");
                                                        sbM778t.append(arrayList4.size());
                                                        sbM778t.append("] dct = ");
                                                        sbM778t.append(jElapsedRealtime8);
                                                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", sbM778t.toString());
                                                        syncNoteDataRepository7 = syncNoteDataRepository;
                                                        it9 = it;
                                                        jElapsedRealtime6 = j;
                                                    } else {
                                                        Debugger.m8615i("CoeditShareSingleTask$CoeditShareSDoc", "not supported this file : newTime = " + jLongValue + " , item.getLastModifiedAt = " + c0004d8.m31a());
                                                    }
                                                }
                                                it = it9;
                                                syncNoteDataRepository7 = syncNoteDataRepository;
                                                it9 = it;
                                                jElapsedRealtime6 = j;
                                            } catch (Exception e3) {
                                                AbstractC0000a.m21r(e3, new StringBuilder("Failed to downloadSDocFile -"), "CoeditShareSingleTask$CoeditShareSDoc");
                                                throw e3;
                                            }
                                        } else {
                                            long j6 = jElapsedRealtime6;
                                            z = true;
                                            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "downloadSdoc() download real " + map5.size());
                                            for (Map.Entry entry3 : map5.entrySet()) {
                                                ArrayList arrayList12 = (ArrayList) entry3.getValue();
                                                for (List list5 : AbstractC0299q.m624d0(arrayList12, 100)) {
                                                    File externalFilesDir = context3.getExternalFilesDir(null);
                                                    if (externalFilesDir != null) {
                                                        ArrayList<String> arrayList13 = (ArrayList) AbstractC0298p.m582d(context3, (String) entry3.getKey(), list5, map6, externalFilesDir.getAbsolutePath()).f4483b;
                                                        if (arrayList13.size() != arrayList12.size()) {
                                                            Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "fail to save(update) some notes");
                                                        } else {
                                                            for (String str35 : arrayList13) {
                                                                CoeditShareSingleTask coeditShareSingleTask6 = coeditShareSingleTask5;
                                                                InterfaceC6669a interfaceC6669a = coeditShareSingleTask6.mListener;
                                                                if (interfaceC6669a != null) {
                                                                    interfaceC6669a.mo4734e(str35);
                                                                }
                                                                coeditShareSingleTask5 = coeditShareSingleTask6;
                                                            }
                                                        }
                                                        coeditShareSingleTask2 = coeditShareSingleTask5;
                                                    } else {
                                                        coeditShareSingleTask2 = coeditShareSingleTask5;
                                                        Debugger.m8609e("CoeditShareSingleTask$CoeditShareSDoc", "fail to save(update) some notes due to null ExternalFilesDir!");
                                                    }
                                                    coeditShareSingleTask5 = coeditShareSingleTask2;
                                                }
                                            }
                                            coeditShareSingleTask = coeditShareSingleTask5;
                                            Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "downloadSdoc() finish : tdct = " + (SystemClock.elapsedRealtime() - j6));
                                            z3 = true;
                                        }
                                    }
                                } else {
                                    z = true;
                                }
                            }
                            if (!z2) {
                                return this.mDocShareInfo.f375b;
                            }
                            C0118a c0118a5 = this.mDocShareInfo;
                            if (c0118a5.f378e && c0118a5.f377d) {
                                Context context4 = this.mContext;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (context4 == null) {
                                    Debugger.m8609e(str3, "setSuccessfulShareTime() : context is null!");
                                    str11 = str2;
                                    i = 0;
                                } else {
                                    str11 = str2;
                                    i = 0;
                                    SharedPreferences.Editor editorEdit2 = context4.getSharedPreferences(str11, 0).edit();
                                    editorEdit2.putLong("SyncSuccessTime", jCurrentTimeMillis);
                                    editorEdit2.apply();
                                }
                                Debugger.m8607d(str, "setSuccessfulShareTime : " + this.mContext.getSharedPreferences(str11, i).getLong("SyncSuccessTime", 0L));
                            }
                            return this.mDocShareInfo.f375b;
                        }
                        z = true;
                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "There is no item to share!");
                        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "[Finish sharing coedit] et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                        z2 = z;
                        if (!z2) {
                        }
                    }
                } else {
                    try {
                        str4 = "fail to SesShareApi.requestSync()";
                        try {
                            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUCCEEDED_API_EXCEPTION, str4);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        str4 = "fail to SesShareApi.requestSync()";
                    }
                }
            } catch (Exception unused3) {
            }
            str4 = "fail to SesShareApi.requestSync()";
            throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SUCCEEDED_API_EXCEPTION, str4);
        }
        Debugger.m8607d("CoeditShareSingleTask$CoeditShareSDoc", "Cancelled sharing!");
        str2 = "CoeditShareService";
        str3 = "SDocShareData";
        z2 = false;
        if (!z2) {
        }
    }
}
