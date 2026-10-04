package p079T;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.controllers.C6666b;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6679d;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.result.ItemListResult;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSCloudManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CoeditCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.ShareSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.domain.coedit.DeleteCoeditNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p024F.C0084a;
import p028G.InterfaceC0102a;
import p075S.AbstractC0267s;

/* JADX INFO: renamed from: T.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0291i {

    /* JADX INFO: renamed from: a */
    public static final ConcurrentSkipListSet f752a = new ConcurrentSkipListSet();

    /* JADX INFO: renamed from: b */
    public static final ConcurrentHashMap f753b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c */
    public static final ExecutorService f754c = AbstractC4539a.m3201k("Coedit$SesCoeditUtil_title_update");

    /* JADX INFO: renamed from: d */
    public static final HashMap f755d = new HashMap();

    /* JADX INFO: renamed from: a */
    public static void m564a(Context context, String str, List list, InterfaceC0290h interfaceC0290h, String str2) {
        ItemListResult itemListResultM546d;
        ArrayList<ShareSyncEntry> arrayList = new ArrayList();
        SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (str3 != null) {
                if (str3.endsWith("Dummy_COEDIT")) {
                    ShareSyncEntry shareSyncEntry = new ShareSyncEntry();
                    shareSyncEntry.setItemId(str3.replace("Dummy_COEDIT", ""));
                    shareSyncEntry.setUuid(str3);
                    shareSyncEntry.setSpaceId(str);
                    arrayList.add(shareSyncEntry);
                    Map mapM568e = m568e(str);
                    if (mapM568e != null) {
                        mapM568e.remove(shareSyncEntry.getItemId());
                    }
                } else {
                    ShareSyncEntry shareSyncEntry2 = syncNoteDataRepository.getShareSyncEntry(str3);
                    if (shareSyncEntry2 != null) {
                        arrayList.add(shareSyncEntry2);
                    }
                }
            }
        }
        List arrayList2 = new ArrayList();
        if (RequestToSCloudManager.INSTANCE.getInstance().isDataNetworkAvailable()) {
            HashMap map = new HashMap();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (ShareSyncEntry shareSyncEntry3 : arrayList) {
                if (TextUtils.isEmpty(shareSyncEntry3.getItemId())) {
                    m565b(shareSyncEntry3.getUuid(), str2, new C0287e(shareSyncEntry3, arrayList4, 0));
                } else {
                    arrayList3.add(shareSyncEntry3.getItemId());
                    map.put(shareSyncEntry3.getItemId(), shareSyncEntry3.getUuid());
                }
            }
            Iterator it2 = AbstractC0299q.m624d0(arrayList3, 100).iterator();
            while (it2.hasNext()) {
                try {
                    itemListResultM546d = AbstractC0267s.m546d(str, (List) it2.next());
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("deleteItems"), "Coedit$SesCoeditUtil");
                    itemListResultM546d = null;
                }
                if (itemListResultM546d != null && itemListResultM546d.getSuccessList() != null && !itemListResultM546d.getSuccessList().isEmpty()) {
                    Iterator<ItemListResult.SharedItemListSuccessResult> it3 = itemListResultM546d.getSuccessList().iterator();
                    while (it3.hasNext()) {
                        String str4 = (String) map.get(it3.next().getItemId());
                        if (str4 != null && !str4.endsWith("Dummy_COEDIT")) {
                            m565b(str4, str2, new C0084a(str4, arrayList4));
                        }
                    }
                }
            }
            arrayList2 = arrayList4;
        } else {
            new Handler(Looper.getMainLooper()).post(new RunnableC0286d(context, 0));
        }
        if (interfaceC0290h != null) {
            ((C6666b) C0073a.m194g().f254b).getClass();
            Iterator it4 = C6679d.f3972g.iterator();
            while (it4.hasNext()) {
                ((InterfaceC0102a) it4.next()).onEnded("", -1);
            }
            interfaceC0290h.onFinished(arrayList2);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m565b(String str, String str2, DeleteCoeditNoteUseCase.ResultCallback resultCallback) {
        Debugger.m8615i("Coedit$SesCoeditUtil", "deleteCoeditNote, uuid: " + str + " caller: " + str2);
        if (m569f(str)) {
            Debugger.m8615i("Coedit$SesCoeditUtil", "deleteCoeditNote, already in list: " + str);
            return;
        }
        if ("LIST".equals(str2) && ComposerManager.getInstance().isOpen(str, null)) {
            Debugger.m8615i("Coedit$SesCoeditUtil", "deleteCoeditNote, is opened: " + str);
            new Handler(Looper.getMainLooper()).post(new RunnableC0284b(0));
            return;
        }
        f752a.add(str);
        if (("SPACE_DELETION_FROM_SERVER".equals(str2) || "PUSH_FROM_SERVER".equals(str2)) && ComposerManager.getInstance().isOpen(str, null)) {
            ComposerManager.getInstance().closeCoeditComposer(null, new RunnableC0285c(str, resultCallback, 0));
        } else {
            Context applicationContext = BaseUtils.getApplicationContext();
            new DeleteCoeditNoteUseCase(NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository(), new C0289g(str, applicationContext)).setResultCallback(resultCallback).invoke(applicationContext, str);
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m566c(Context context, String str, int i) {
        StringBuilder sbM15l = AbstractC0000a.m15l("#deleteCoeditNoteOnlyInLocal, docUUID: ", str, ", callee: ");
        sbM15l.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Debugger.m8614f("Coedit$SesCoeditUtil", sbM15l.toString());
        DocumentWriteResolver.deleteAllNoteData(context, str, i);
        CoeditCacheUtils.removeCoeditCache(context, str);
    }

    /* JADX INFO: renamed from: d */
    public static String m567d(Context context, String str, String str2, long j) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String groupId = SesCoeditShareReadResolver.getInstance().getGroupId(str2);
        return context.getString(C7943R.string.base_coedit_note_auto_title, SesCoeditGroupReadResolver.getInstance().getUserName(groupId, SesCoeditGroupReadResolver.getInstance().getLeaderId(groupId)), LocaleUtils.getTitleTime(j));
    }

    /* JADX INFO: renamed from: e */
    public static Map m568e(String str) {
        return (Map) f753b.get(str);
    }

    /* JADX INFO: renamed from: f */
    public static boolean m569f(String str) {
        return str != null && f752a.contains(str);
    }

    /* JADX INFO: renamed from: g */
    public static boolean m570g(String str) {
        if (str != null) {
            return str.startsWith("Group://Standalone") || str.startsWith(CoeditBaseConstants.STANDALONE_DEFAULT_TITLE_OLD);
        }
        return false;
    }

    /* JADX INFO: renamed from: h */
    public static CoeditMainListEntry m571h(String str, String str2, String str3) {
        List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(BaseUtils.getApplicationContext(), str2);
        if (listRequestSharedItemList == null) {
            Debugger.m8607d("Coedit$SesCoeditUtil", "[CS7] result null");
            return null;
        }
        for (SharedItem sharedItem : listRequestSharedItemList) {
            if (sharedItem.getItemId().equals(str3)) {
                CoeditMainListEntry coeditMainListEntry = new CoeditMainListEntry();
                List<CoeditResolverContract.MemberInfo> memberInfoList = SesCoeditGroupReadResolver.getInstance().getMemberInfoList(str);
                MainListDocumentData mainListDocumentData = new MainListDocumentData();
                String str4 = (String) sharedItem.getMetaData().get("uuid");
                mainListDocumentData.setUuid(str3 + "Dummy_COEDIT");
                mainListDocumentData.setContent("");
                mainListDocumentData.setId(Long.valueOf((long) str3.hashCode()));
                mainListDocumentData.setLastModifiedAt(sharedItem.getModifiedTime());
                mainListDocumentData.setCreatedAt(sharedItem.getCreatedTime());
                String title = sharedItem.getTitle();
                mainListDocumentData.setTitle(title.equals(str4) ? "" : title);
                mainListDocumentData.setMdeSpaceId(str2);
                mainListDocumentData.setMdeItemId(str3);
                mainListDocumentData.setMdeGroupId(str);
                mainListDocumentData.setCategoryUuid("coedit:///");
                coeditMainListEntry.setMainListEntry(mainListDocumentData, memberInfoList.size());
                coeditMainListEntry.setType(2);
                coeditMainListEntry.setAuthority("r/w");
                return coeditMainListEntry;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: i */
    public static long m572i(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(new JSONObject(str).getString("checkpoint"));
        } catch (NumberFormatException e) {
            Debugger.m8615i("Coedit$SesCoeditUtil", "parseCoeditMemoCheckpoint convert Fail " + e.getMessage());
            return -1L;
        } catch (JSONException e2) {
            Debugger.m8615i("Coedit$SesCoeditUtil", "parseCoeditMemoCheckpoint Fail " + e2.getMessage());
            return -1L;
        }
    }

    /* JADX INFO: renamed from: j */
    public static void m573j(String str, String str2) {
        Map map = (Map) f753b.get(str);
        if (map != null) {
            map.remove(str2);
        }
    }
}
