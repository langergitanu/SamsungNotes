package com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.constants.ShareConstants$ResultCode;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sessession.C6716p;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.modelerror.ShareException;
import com.samsung.android.sdk.mobileservice.SeMobileService;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p001A.AbstractC0000a;
import p002A0.C0004d;
import p042J1.AbstractC0155m;
import p066P2.C0200b;
import p068Q.C0204a;
import p075S.AbstractC0248O;
import p079T.AbstractC0298p;
import p079T.AbstractC0299q;
import p079T.C0297o;
import p083U.C0304a;
import p083U.C0305b;
import p083U.C0306c;
import p083U.C0308e;
import p083U.InterfaceC0307d;
import p086V.C0322h;
import p207n1.C13540g;
import p207n1.C13541h;
import p212o1.C13573a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareSingleTask extends ShareBaseTask {
    private static final String TAG = "ShareSingleTask";
    private C0306c mShareSDoc;
    private InterfaceC0307d mShareTaskContact;

    public ShareSingleTask(Context context, InterfaceC6717a interfaceC6717a, String str) {
        super(context, interfaceC6717a, str);
        this.mShareTaskContact = new C13573a(this, 7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:308:0x0bc5, code lost:
    
        if (r1 != false) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:310:0x0bcb, code lost:
    
        if (r11.isCancelled() == false) goto L314;
     */
    /* JADX WARN: Code restructure failed: missing block: B:311:0x0bcd, code lost:
    
        com.samsung.android.support.senl.p148nt.base.common.log.Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled before finishing downloading sDocs!");
     */
    /* JADX WARN: Removed duplicated region for block: B:166:0x06ca  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0948  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0952  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0bd4  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0bf9  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0c00  */
    @Override // com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.ShareBaseTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<C0204a> shareProgress() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        C0304a c0304a;
        List<SharedItem> listRequestSharedItemList;
        HashMap map;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        boolean z;
        boolean z2;
        ArrayList arrayList4;
        C0304a c0304a2;
        ShareSingleTask shareSingleTask;
        boolean z3;
        ShareSingleTask shareSingleTask2;
        long j;
        long jLongValue;
        SyncNoteDataRepository syncNoteDataRepository;
        Iterator it;
        boolean z4;
        String str5;
        boolean zM386a;
        String str6;
        String str7;
        String str8;
        HashMap map2;
        Iterator it2;
        String str9;
        String str10;
        String string;
        String str11;
        String str12;
        int i;
        NotesDocumentEntity notesDocumentEntityM9f;
        String str13;
        int i2;
        String str14 = "shareProgress() [" + hashCode() + "]";
        String str15 = TAG;
        Debugger.m8607d(TAG, str14);
        String str16 = ((C13540g) C13541h.m14287e().f9588a).f9582d;
        if (str16 == null) {
            Debugger.m8609e(TAG, "emailID is null");
            return null;
        }
        Context context = this.mContext;
        String str17 = this.mSpaceId;
        C0304a c0304a3 = new C0304a();
        c0304a3.f778b = new ArrayList();
        c0304a3.f780d = true;
        c0304a3.f781e = true;
        c0304a3.f777a = context;
        c0304a3.f779c = str17;
        this.mDocShareInfo = c0304a3;
        this.mDocShareOperation = new C0305b(c0304a3);
        Debugger.m8607d(TAG, "Share : Agent v." + SeMobileService.getAgentVersion(this.mContext) + ", SDK v." + SeMobileService.getSdkVersionName() + " , Server Time : " + TimeManager.getCurrentTime(this.mContext) + " , Device Time : " + System.currentTimeMillis());
        Context context2 = this.mDocShareOperation.f782a.f777a;
        String str18 = "SDocShareData";
        String str19 = "delete, uuid : ";
        String str20 = "SyncDelayInfoRepository";
        if (str16.equals(context2.getSharedPreferences("ShareService", 0).getString("UserId", null))) {
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
            List<String> uuidListMde = syncNoteDataRepositoryCreateSyncNoteDataRepository.getUuidListMde();
            for (String str21 : uuidListMde) {
                if (str21 != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(appContext, str21);
                    AbstractC0000a.m18o(appContext, appContext, appContext);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if (notesDocumentEntityM9f != null) {
                    int isDeleted = notesDocumentEntityM9f.getIsDeleted();
                    str13 = str15;
                    i2 = isDeleted;
                } else {
                    str13 = str15;
                    i2 = 1;
                }
                if (i2 != 1) {
                    StringBuilder sbM15l = AbstractC0000a.m15l("[SyncDelete] deleteAllNoteData, docUUID: ", str21, " by SDocShareOperation, callee: ");
                    sbM15l.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                    Debugger.m8614f("WDocWriteResolver", sbM15l.toString());
                    DocumentWriteResolver.deleteAllNoteData(appContext, str21, 4);
                    Debugger.m8614f("SyncDelayInfoRepository", "delete, uuid : " + str21);
                    syncDelayInfoDao.delete(str21);
                } else {
                    Debugger.m8607d("ShareSingleTask$SDocShareOperation", str21 + " is already deleted!");
                }
                str15 = str13;
            }
            str = str15;
            Debugger.m8607d("ShareSingleTask$SDocShareOperation", "deleteAllLocalSharedItem. deleted : " + uuidListMde.size());
            if (context2 == null) {
                Debugger.m8609e("SDocShareData", "setUserID() : context is null!");
            } else {
                SharedPreferences.Editor editorEdit = context2.getSharedPreferences("ShareService", 0).edit();
                editorEdit.putString("UserId", str16);
                editorEdit.apply();
            }
        }
        C0306c c0306c = new C0306c(this.mDocShareInfo, this.mShareTaskContact);
        this.mShareSDoc = c0306c;
        Debugger.m8607d("ShareSingleTask$ShareSDoc", "[Start sharing sdoc]");
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance("repair_category_uuid_pref_file");
        if (!sharedPreferencesCompat.getBoolean("repair_category_uuid_pref_key_is_fixed", false)) {
            sharedPreferencesCompat.putBoolean("repair_category_uuid_pref_key_is_fixed", true);
            Debugger.m8607d("ShareSingleTask$ShareSDoc", "repairSharedNotesCategoryUuid executed");
            new SyncNoteDataRepository().repairOldSharedNotesCategoryUuid();
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C13573a c13573a = (C13573a) c0306c.f787e;
        ShareSingleTask shareSingleTask3 = (ShareSingleTask) c13573a.f9635b;
        ShareSingleTask shareSingleTask4 = (ShareSingleTask) c13573a.f9635b;
        if (!shareSingleTask3.isCancelled()) {
            boolean zM402q = AbstractC0155m.m402q();
            C0304a c0304a4 = c0306c.f786d;
            if (!zM402q) {
                c0304a4.f781e = false;
                c0304a4.f780d = false;
                throw new ShareException(ShareConstants$ResultCode.FAIL_DEVICE_STORAGE_FULL_EXCEPTION, "device storage is full!");
            }
            Debugger.m8607d("ShareSingleTask$ShareSDoc", "Start to get local list ");
            Context context3 = c0304a4.f777a;
            String str22 = c0304a4.f779c;
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context3).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context3).createDocumentTagRepository();
            NotesDataRepositoryFactory.newInstance(context3).createNotesDocumentPageRepository();
            NotesDataRepositoryFactory.newInstance(context3).createMappedDocumentRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            List<String> uuidListMde2 = (str22 == null || str22.isEmpty()) ? syncNoteDataRepositoryCreateSyncNoteDataRepository2.getUuidListMde() : syncNoteDataRepositoryCreateSyncNoteDataRepository2.getUuidListBySpaceIdOld(str22);
            if (uuidListMde2 == null) {
                Debugger.m8609e("ShareSingleTask$ShareSDoc", "Failed to get all uuid List for MDE");
                throw new ShareException(ShareConstants$ResultCode.FAIL_DB_EXCEPTION, "Failed to get all uuid List for MDE");
            }
            List<String> list = uuidListMde2;
            ArrayList arrayList5 = new ArrayList();
            str2 = "ShareService";
            SyncNoteDataRepository syncNoteDataRepository2 = new SyncNoteDataRepository();
            for (String str23 : list) {
                String str24 = str18;
                ShareSyncEntry shareSyncEntry = syncNoteDataRepository2.getShareSyncEntry(str23);
                C0004d c0004d = new C0004d(shareSyncEntry.getSpaceId(), str23, shareSyncEntry.getFileName(), shareSyncEntry.getServerTimestamp().longValue(), shareSyncEntry.getCreatedAt(), shareSyncEntry.getLastModifiedAt());
                SyncNoteDataRepository syncNoteDataRepository3 = syncNoteDataRepository2;
                c0004d.f16a = shareSyncEntry.getItemId();
                c0004d.f20e = shareSyncEntry.getIsDirty() == 1;
                arrayList5.add(c0004d);
                syncNoteDataRepository2 = syncNoteDataRepository3;
                str18 = str24;
            }
            str3 = str18;
            Debugger.m8607d("ShareSingleTask$ShareSDoc", "Finish to get local list " + arrayList5.size());
            String str25 = "uuid";
            ShareSingleTask shareSingleTask5 = shareSingleTask4;
            Debugger.m8607d("ShareSingleTask$ShareSDoc", "Start to get server list ");
            if (!C6716p.m4809q().m4801j()) {
                throw new ShareException(ShareConstants$ResultCode.FAIL_NOT_SESSION_CONNECTED_EXCEPTION, "Ses Session is not connected");
            }
            try {
                if (AbstractC0248O.m533g().getResult()) {
                    Debugger.m8615i("ShareSingleTask$ShareSDoc", "succeed to SesShareApi.requestSync()");
                    ArrayList arrayList6 = new ArrayList();
                    Context appContext2 = C0322h.m670a().f815a.getAppContext();
                    if (str22 == null || str22.isEmpty()) {
                        c0304a = c0304a4;
                        listRequestSharedItemList = SesShareReadResolver.getInstance().requestSharedItemList(appContext2);
                    } else {
                        c0304a = c0304a4;
                        listRequestSharedItemList = SesShareReadResolver.getInstance().requestSharedItemList(appContext2, str22);
                    }
                    if (listRequestSharedItemList == null) {
                        throw new ShareException(ShareConstants$ResultCode.FAIL_SERVER_EXCEPTION, "requestSharedItemList queryResult is null");
                    }
                    int size = listRequestSharedItemList.size();
                    String str26 = " is already deleted!";
                    listRequestSharedItemList.sort(Comparator.comparing(new C0200b(7)));
                    int i4 = 0;
                    while (i4 < size) {
                        try {
                            SharedItem sharedItem = listRequestSharedItemList.get(i4);
                            List<SharedItem> list2 = listRequestSharedItemList;
                            if (sharedItem.getMetaData().containsKey(str25)) {
                                Object obj = sharedItem.getMetaData().get(str25);
                                if (obj == null) {
                                    Debugger.m8614f("ShareSingleTask$ShareSDoc", "Exception while getting server sdoc item uuid");
                                    str11 = str25;
                                    i4++;
                                    listRequestSharedItemList = list2;
                                    str25 = str11;
                                } else {
                                    string = obj.toString();
                                }
                            } else {
                                string = null;
                            }
                            C0004d c0004d2 = new C0004d(sharedItem.getSpaceId(), string, sharedItem.getTitle(), sharedItem.getMetaData().containsKey("lastModifiedAt") ? ((Long) sharedItem.getMetaData().get("lastModifiedAt")).longValue() : 0L, sharedItem.getMetaData().containsKey("createdAt") ? ((Long) sharedItem.getMetaData().get("createdAt")).longValue() : 0L, sharedItem.getMetaData().containsKey("DoclastModifiedAt") ? ((Long) sharedItem.getMetaData().get("DoclastModifiedAt")).longValue() : 0L);
                            str11 = str25;
                            c0004d2.f16a = sharedItem.getItemId();
                            sharedItem.getCreatedTime();
                            arrayList6.add(c0004d2);
                            i4++;
                            listRequestSharedItemList = list2;
                            str25 = str11;
                        } catch (Exception e) {
                            Debugger.m8609e("ShareSingleTask$ShareSDoc", "Exception while getting server sdoc items.");
                            throw new ShareException(ShareConstants$ResultCode.FAIL_SERVER_EXCEPTION, e.getMessage());
                        }
                    }
                    Iterator it3 = arrayList6.iterator();
                    while (true) {
                        boolean zHasNext = it3.hasNext();
                        map = c0306c.f788f;
                        if (!zHasNext) {
                            break;
                        }
                        C0004d c0004d3 = (C0004d) it3.next();
                        if (map.containsKey(c0004d3.m32b())) {
                            Debugger.m8607d("ShareSingleTask$ShareSDoc", "uuid conflicted. uuid : " + c0004d3.m32b());
                        } else {
                            map.put(c0004d3.m32b(), c0004d3);
                        }
                    }
                    if (shareSingleTask5.isCancelled()) {
                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled Sharing");
                    } else {
                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "makeListsForShare()");
                        NotesDataRepositoryFactory.newInstance(context3).createDocumentDataRepository();
                        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository3 = NotesDataRepositoryFactory.newInstance(context3).createSyncNoteDataRepository();
                        NotesDataRepositoryFactory.newInstance(context3).createDocumentTempDataRepository();
                        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                        SyncNoteDataRepository syncNoteDataRepository4 = new SyncNoteDataRepository();
                        Iterator it4 = arrayList5.iterator();
                        while (true) {
                            boolean zHasNext2 = it4.hasNext();
                            arrayList = c0306c.f784b;
                            arrayList2 = c0306c.f783a;
                            arrayList3 = c0306c.f785c;
                            if (!zHasNext2) {
                                break;
                            }
                            C0004d c0004d4 = (C0004d) it4.next();
                            C0004d c0004d5 = (C0004d) map.get(c0004d4.m32b());
                            if (c0004d5 != null) {
                                map.remove(c0004d5.m32b());
                                map2 = map;
                                it2 = it4;
                                long jM31a = c0004d4.m31a();
                                str9 = str19;
                                str10 = str20;
                                long jM31a2 = c0004d5.m31a();
                                if (jM31a2 > jM31a) {
                                    Debugger.m8607d("ShareSingleTask$ShareSDoc", "makeListsForShare() uuid : " + c0004d4.m32b() + " server - serverTimestamp :" + jM31a2 + " localTime : " + jM31a);
                                    arrayList.add(c0004d5);
                                } else if (jM31a2 < jM31a) {
                                    String strM32b = c0004d4.m32b();
                                    if (TextUtils.isEmpty(syncNoteDataRepository4.getShareSyncEntry(strM32b).getItemId())) {
                                        syncNoteDataRepositoryCreateSyncNoteDataRepository3.setMdeItemId(strM32b, c0004d5.f16a);
                                        c0004d4.f16a = c0004d5.f16a;
                                    }
                                    if (!AbstractC14517a.m15166z(context3, strM32b)) {
                                        Debugger.m8609e("ShareSingleTask$ShareSDoc", "owner id is different");
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
                            } else {
                                map2 = map;
                                it2 = it4;
                                str9 = str19;
                                str10 = str20;
                                String str27 = c0004d4.f16a;
                                if (str27 != null && !str27.isEmpty()) {
                                    arrayList3.add(c0004d4);
                                } else if (AbstractC14517a.m15166z(context3, c0004d4.m32b())) {
                                    arrayList2.add(c0004d4);
                                } else {
                                    Debugger.m8609e("ShareSingleTask$ShareSDoc", "owner id is different (only local)");
                                }
                            }
                            map = map2;
                            it4 = it2;
                            str19 = str9;
                            str20 = str10;
                        }
                        String str28 = str19;
                        String str29 = str20;
                        Iterator it5 = map.entrySet().iterator();
                        while (it5.hasNext()) {
                            arrayList.add((C0004d) ((Map.Entry) it5.next()).getValue());
                        }
                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "toDeleteLocalList: " + arrayList3.size());
                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "toUploadList: " + arrayList2.size() + " ,toDownloadList: " + arrayList.size());
                        if (arrayList3.size() + arrayList.size() + arrayList2.size() > 0) {
                            if (arrayList3.isEmpty()) {
                                if (arrayList2.isEmpty()) {
                                }
                                if (arrayList4.isEmpty()) {
                                }
                            } else {
                                Debugger.m8607d("ShareSingleTask$ShareSDoc", "Start to delete local : " + arrayList3.size());
                                NotesDataRepositoryFactory.newInstance(context3).createDocumentDataRepository();
                                NotesDataRepositoryFactory.newInstance(context3).createSyncNoteDataRepository();
                                NotesDataRepositoryFactory.newInstance(context3).createDocumentTempDataRepository();
                                SyncDelayInfoDao syncDelayInfoDao2 = NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                SyncNoteDataRepository syncNoteDataRepository5 = new SyncNoteDataRepository();
                                Iterator it6 = arrayList3.iterator();
                                while (true) {
                                    if (!it6.hasNext()) {
                                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "Finished to delete local");
                                        break;
                                    }
                                    C0004d c0004d6 = (C0004d) it6.next();
                                    if (shareSingleTask5.isCancelled()) {
                                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled deleteLocal");
                                        if (shareSingleTask5.isCancelled()) {
                                            Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled before deleting sDocs in a server!");
                                        }
                                    } else {
                                        ShareSyncEntry shareSyncEntry3 = syncNoteDataRepository5.getShareSyncEntry(c0004d6.m32b());
                                        if (shareSyncEntry3 == null || shareSyncEntry3.getIsDeleted() == 1) {
                                            str6 = str28;
                                            str7 = str29;
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(c0004d6.f16a);
                                            str8 = str26;
                                            sb.append(str8);
                                            Debugger.m8607d("ShareSingleTask$ShareSDoc", sb.toString());
                                        } else {
                                            String strM32b3 = c0004d6.m32b();
                                            StringBuilder sbM15l2 = AbstractC0000a.m15l("[SyncDelete] deleteAllNoteData, docUUID: ", strM32b3, " by RemoteShare, callee: ");
                                            sbM15l2.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
                                            Debugger.m8614f("WDocWriteResolver", sbM15l2.toString());
                                            DocumentWriteResolver.deleteAllNoteData(context3, strM32b3, 4);
                                            str6 = str28;
                                            str7 = str29;
                                            Debugger.m8614f(str7, str6 + strM32b3);
                                            syncDelayInfoDao2.delete(strM32b3);
                                            str8 = str26;
                                        }
                                        str26 = str8;
                                        str28 = str6;
                                        str29 = str7;
                                    }
                                }
                                if (arrayList2.isEmpty()) {
                                    int size2 = arrayList2.size();
                                    Debugger.m8607d("ShareSingleTask$ShareSDoc", "Start to upload : " + size2);
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
                                            if (shareSingleTask5.isCancelled()) {
                                                Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled uploadSdoc");
                                                c0304a2 = c0304a;
                                                z4 = false;
                                                break;
                                            }
                                            Iterator it8 = it7;
                                            int i7 = i5 + 1;
                                            long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                                            int i8 = i6;
                                            String strM32b4 = c0004d7.m32b();
                                            long j3 = j2;
                                            String str30 = c0004d7.f18c;
                                            try {
                                                zM386a = AbstractC0155m.m386a(syncNoteDataRepository6.getShareSyncEntry(strM32b4).getFilePath());
                                                str5 = spaceTitle;
                                            } catch (SyncException e2) {
                                                str5 = spaceTitle;
                                                AbstractC6670b.m4752m(e2, new StringBuilder("SyncException while checking canUpload. "), "ShareSingleTask$ShareSDoc");
                                                zM386a = false;
                                            }
                                            if (zM386a) {
                                                String str31 = c0004d7.f16a;
                                                if (str31 == null || str31.isEmpty()) {
                                                    if (map3.containsKey(str30)) {
                                                        ((ArrayList) map3.get(str30)).add(strM32b4);
                                                    } else {
                                                        ArrayList arrayList7 = new ArrayList();
                                                        arrayList7.add(strM32b4);
                                                        map3.put(str30, arrayList7);
                                                    }
                                                } else if (map4.containsKey(str30)) {
                                                    ((ArrayList) map4.get(str30)).add(new C0297o(strM32b4, str31));
                                                } else {
                                                    ArrayList arrayList8 = new ArrayList();
                                                    arrayList8.add(new C0297o(strM32b4, str31));
                                                    map4.put(str30, arrayList8);
                                                }
                                                long jElapsedRealtime4 = SystemClock.elapsedRealtime() - jElapsedRealtime3;
                                                StringBuilder sbM1173s = AbstractC0622a.m1173s(i7, size2, "uploadSdoc() [0 / ", " / ", "] ut = ");
                                                sbM1173s.append(jElapsedRealtime4);
                                                Debugger.m8607d("ShareSingleTask$ShareSDoc", sbM1173s.toString());
                                                i5 = i7;
                                                it7 = it8;
                                                arrayList = arrayList4;
                                                j2 = j3 + jElapsedRealtime4;
                                                i6 = i8;
                                            } else {
                                                i6 = i8 + 1;
                                                if (str5 == null) {
                                                    spaceTitle = SesShareReadResolver.getInstance().getSpaceTitle(str30);
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
                                            String str32 = spaceTitle;
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
                                                        Debugger.m8609e("ShareSingleTask$ShareSDoc", "fail to upload some notes");
                                                    } else {
                                                        for (String str33 : arrayList9) {
                                                            long jLongValue2 = syncNoteDataRepository6.getShareSyncEntry(str33).getServerTimestamp().longValue();
                                                            C0004d c0004dM657a = C0306c.m657a(str33, arrayList2);
                                                            if (jLongValue2 <= (c0004dM657a != null ? c0004dM657a.m31a() : Long.MAX_VALUE)) {
                                                                syncNoteDataRepositoryM3196f.updateDirty(str33, 0);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            for (Map.Entry entry2 : map4.entrySet()) {
                                                for (List list4 : AbstractC0299q.m624d0((ArrayList) entry2.getValue(), 100)) {
                                                    ArrayList<String> arrayList10 = (ArrayList) AbstractC0298p.m589k(context3, (String) entry2.getKey(), list4).f4483b;
                                                    if (arrayList10.size() != list4.size()) {
                                                        Debugger.m8609e("ShareSingleTask$ShareSDoc", "fail to update some notes");
                                                    } else {
                                                        for (String str34 : arrayList10) {
                                                            long jLongValue3 = syncNoteDataRepository6.getShareSyncEntry(str34).getServerTimestamp().longValue();
                                                            C0004d c0004dM657a2 = C0306c.m657a(str34, arrayList2);
                                                            if (jLongValue3 <= (c0004dM657a2 != null ? c0004dM657a2.m31a() : Long.MAX_VALUE)) {
                                                                syncNoteDataRepositoryM3196f.updateDirty(str34, 0);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            if (i9 > 0) {
                                                c0304a2 = c0304a;
                                                c0304a2.f778b.add(new C0204a(2, str32, 5));
                                            } else {
                                                c0304a2 = c0304a;
                                            }
                                            long jElapsedRealtime5 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                                            StringBuilder sbM1323p = AbstractC1974b.m1323p(j5, "uploadSdoc() finish : tut = ", " , tt = ");
                                            sbM1323p.append(jElapsedRealtime5);
                                            Debugger.m8607d("ShareSingleTask$ShareSDoc", sbM1323p.toString());
                                            z4 = true;
                                        }
                                    }
                                    if (!z4 && shareSingleTask5.isCancelled()) {
                                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled before downloading sDocs!");
                                    }
                                } else {
                                    arrayList4 = arrayList;
                                    c0304a2 = c0304a;
                                }
                                if (arrayList4.isEmpty()) {
                                    Debugger.m8607d("ShareSingleTask$ShareSDoc", "Start to download : " + arrayList4.size());
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
                                            if (shareSingleTask5.isCancelled()) {
                                                Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled downloadSdoc");
                                                shareSingleTask = shareSingleTask5;
                                                z3 = false;
                                                z = true;
                                                break;
                                            }
                                            i10++;
                                            if (!AbstractC0155m.m402q()) {
                                                c0304a2.f780d = false;
                                                throw new ShareException(ShareConstants$ResultCode.FAIL_DEVICE_STORAGE_FULL_EXCEPTION, "device storage is full!");
                                            }
                                            String strM32b5 = c0004d8.m32b();
                                            String str35 = c0004d8.f18c;
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
                                                    Debugger.m8615i("ShareSingleTask$ShareSDoc", "ignore this file : newTime = " + jLongValue + " , item.getLastModifiedAt = " + c0004d8.m31a());
                                                    syncNoteDataRepository = syncNoteDataRepository7;
                                                } else {
                                                    String str36 = c0004d8.f19d;
                                                    syncNoteDataRepository = syncNoteDataRepository7;
                                                    if (str36.endsWith(".sdocx") || str36.endsWith(".sdoc")) {
                                                        if (setM592B != null) {
                                                            StringBuilder sb2 = new StringBuilder();
                                                            sb2.append(str35);
                                                            it = it9;
                                                            sb2.append(c0004d8.f16a);
                                                            if (setM592B.contains(sb2.toString())) {
                                                                Debugger.m8615i("ShareSingleTask$ShareSDoc", "previous broken file : newTime = " + jLongValue + " , item.getLastModifiedAt = " + c0004d8.m31a());
                                                            }
                                                            syncNoteDataRepository7 = syncNoteDataRepository;
                                                            it9 = it;
                                                            jElapsedRealtime6 = j;
                                                        } else {
                                                            it = it9;
                                                        }
                                                        Debugger.m8615i("ShareSingleTask$ShareSDoc", "download an item : " + c0004d8.m32b());
                                                        if (map5.containsKey(str35)) {
                                                            ((ArrayList) map5.get(str35)).add(c0004d8.f16a);
                                                            map6.put(str35 + c0004d8.f16a, str36);
                                                        } else {
                                                            ArrayList arrayList11 = new ArrayList();
                                                            arrayList11.add(c0004d8.f16a);
                                                            map5.put(str35, arrayList11);
                                                            map6.put(str35 + c0004d8.f16a, str36);
                                                        }
                                                        long jElapsedRealtime8 = SystemClock.elapsedRealtime() - jElapsedRealtime7;
                                                        StringBuilder sbM778t = AbstractC0541b.m778t(i10, "downloadSdoc() [0 / ", " / ");
                                                        sbM778t.append(arrayList4.size());
                                                        sbM778t.append("] dct = ");
                                                        sbM778t.append(jElapsedRealtime8);
                                                        Debugger.m8607d("ShareSingleTask$ShareSDoc", sbM778t.toString());
                                                        syncNoteDataRepository7 = syncNoteDataRepository;
                                                        it9 = it;
                                                        jElapsedRealtime6 = j;
                                                    } else {
                                                        Debugger.m8615i("ShareSingleTask$ShareSDoc", "not supported this file : newTime = " + jLongValue + " , item.getLastModifiedAt = " + c0004d8.m31a());
                                                    }
                                                }
                                                it = it9;
                                                syncNoteDataRepository7 = syncNoteDataRepository;
                                                it9 = it;
                                                jElapsedRealtime6 = j;
                                            } catch (Exception e3) {
                                                AbstractC0000a.m21r(e3, new StringBuilder("Failed to downloadSDocFile -"), "ShareSingleTask$ShareSDoc");
                                                throw e3;
                                            }
                                        } else {
                                            long j6 = jElapsedRealtime6;
                                            z = true;
                                            Debugger.m8607d("ShareSingleTask$ShareSDoc", "downloadSdoc() download real " + map5.size());
                                            for (Map.Entry entry3 : map5.entrySet()) {
                                                ArrayList arrayList12 = (ArrayList) entry3.getValue();
                                                for (List list5 : AbstractC0299q.m624d0(arrayList12, 100)) {
                                                    File externalFilesDir = context3.getExternalFilesDir(null);
                                                    if (externalFilesDir != null) {
                                                        ArrayList<String> arrayList13 = (ArrayList) AbstractC0298p.m582d(context3, (String) entry3.getKey(), list5, map6, externalFilesDir.getAbsolutePath()).f4483b;
                                                        if (arrayList13.size() != arrayList12.size()) {
                                                            Debugger.m8609e("ShareSingleTask$ShareSDoc", "fail to save(update) some notes");
                                                        } else {
                                                            for (String str37 : arrayList13) {
                                                                ShareSingleTask shareSingleTask6 = shareSingleTask5;
                                                                InterfaceC6717a interfaceC6717a = shareSingleTask6.mListener;
                                                                if (interfaceC6717a != null) {
                                                                    interfaceC6717a.mo202e(str37);
                                                                }
                                                                shareSingleTask5 = shareSingleTask6;
                                                            }
                                                        }
                                                        shareSingleTask2 = shareSingleTask5;
                                                    } else {
                                                        shareSingleTask2 = shareSingleTask5;
                                                        Debugger.m8609e("ShareSingleTask$ShareSDoc", "fail to save(update) some notes due to null ExternalFilesDir!");
                                                    }
                                                    shareSingleTask5 = shareSingleTask2;
                                                }
                                            }
                                            shareSingleTask = shareSingleTask5;
                                            Debugger.m8607d("ShareSingleTask$ShareSDoc", "downloadSdoc() finish : tdct = " + (SystemClock.elapsedRealtime() - j6));
                                            z3 = true;
                                        }
                                    }
                                } else {
                                    z = true;
                                }
                            }
                            if (!z2) {
                                return this.mDocShareInfo.f778b;
                            }
                            C0304a c0304a5 = this.mDocShareInfo;
                            if (c0304a5.f781e && c0304a5.f780d) {
                                Context context4 = this.mContext;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (context4 == null) {
                                    Debugger.m8609e(str3, "setSuccessfulShareTime() : context is null!");
                                    str12 = str2;
                                    i = 0;
                                } else {
                                    str12 = str2;
                                    i = 0;
                                    SharedPreferences.Editor editorEdit2 = context4.getSharedPreferences(str12, 0).edit();
                                    editorEdit2.putLong("SyncSuccessTime", jCurrentTimeMillis);
                                    editorEdit2.apply();
                                }
                                Debugger.m8607d(str, "setSuccessfulShareTime : " + this.mContext.getSharedPreferences(str12, i).getLong("SyncSuccessTime", 0L));
                            }
                            new C0308e(this.mShareTaskContact).m661d();
                            return this.mDocShareInfo.f778b;
                        }
                        z = true;
                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "There is no item to share!");
                        Debugger.m8607d("ShareSingleTask$ShareSDoc", "[Finish sharing sdoc] et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
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
        Debugger.m8607d("ShareSingleTask$ShareSDoc", "Cancelled sharing!");
        str2 = "ShareService";
        str3 = "SDocShareData";
        z2 = false;
        if (!z2) {
        }
    }
}
