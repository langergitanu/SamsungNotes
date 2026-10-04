package p041J;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditGroupReadResolver;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.sdk.mobileservice.common.ErrorCodeConvertor;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.SharedItem;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.CoeditBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.NoteDbResolver;
import java.util.List;
import p001A.AbstractC0000a;
import p075S.AbstractC0254f;
import p075S.AbstractC0267s;
import p079T.AbstractC0291i;
import p079T.AbstractC0298p;

/* JADX INFO: renamed from: J.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0142a {
    /* JADX INFO: renamed from: a */
    public static String m289a(String str) {
        SpaceResult spaceResultM548f;
        String groupId = SesCoeditShareReadResolver.getInstance().getGroupId(str);
        if (!TextUtils.isEmpty(groupId)) {
            return groupId;
        }
        try {
            spaceResultM548f = AbstractC0267s.m548f(str);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("fail to requestSpace : "), "CoeditShareManager");
            spaceResultM548f = null;
        }
        if (spaceResultM548f == null) {
            Debugger.m8618w("CoeditShareManager", "getGroupId, result empty");
            return groupId;
        }
        if (spaceResultM548f.getResult() != null) {
            return spaceResultM548f.getResult().getGroupId();
        }
        Debugger.m8618w("CoeditShareManager", "getGroupId, result getResult empty");
        return groupId;
    }

    /* JADX INFO: renamed from: b */
    public static void m290b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (CoeditResolverContract.MemberInfo memberInfo : SesCoeditGroupReadResolver.getInstance().getMemberInfoList(str)) {
            if (memberInfo == null || TextUtils.isEmpty(memberInfo.getMemberName())) {
                if (str == null) {
                    return;
                }
                try {
                    AbstractC0254f.m538d(str);
                    return;
                } catch (Exception e) {
                    Debugger.m8607d("SesCoeditGroupUserNameCache", "cacheGroupMemberInfo() : " + e.toString());
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m291c(String str) {
        NotesDocumentEntity notesDocumentEntityM9f;
        Debugger.m8607d("CoeditShareManager", "[CS6] updateNoteTitleAndModifiedTime() : spaceId = " + str);
        Context applicationContext = BaseUtils.getApplicationContext();
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            BooleanResult booleanResultM547e = AbstractC0267s.m547e(str);
            if (booleanResultM547e != null && !booleanResultM547e.getResult() && booleanResultM547e.getStatus() != null && booleanResultM547e.getStatus().getCode() == 107 && booleanResultM547e.getStatus().getAgentCode().equals(Long.toString(ErrorCodeConvertor.RESOURCE_NOT_FOUND))) {
                Intent intent = new Intent(CoeditBaseConstants.SPACE_DELTE_RECEIVED_INTENT_FILTER);
                intent.putExtra(CoeditBaseConstants.COEDIT_DELETED_GROUP_ID, "");
                intent.putExtra(CoeditBaseConstants.COEDIT_DELETED_SPACE_ID, str);
                intent.putExtra(CoeditBaseConstants.COEDIT_DELETED_GROUP_NAME, "");
                LocalBroadcastManager.getInstance(applicationContext).sendBroadcast(intent);
            }
            Debugger.m8615i("CoeditShareManager", "[CS6-1] updateNoteTitleAndModifiedTime() : requestSharedItemSync end, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            List<SharedItem> listRequestSharedItemList = SesCoeditShareReadResolver.getInstance().requestSharedItemList(applicationContext, str);
            if (listRequestSharedItemList == null) {
                Debugger.m8609e("CoeditShareManager", "[CS6-2] updateNoteTitleAndModifiedTime() : sharedItemListResult is null");
                return;
            }
            SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
            Debugger.m8607d("CoeditShareManager", "[CS6] updateNoteTitleAndModifiedTime() : requestSharedItemSync size : " + listRequestSharedItemList.size());
            long j = SharedPreferencesCompat.getInstance("CoeditPref").getLong("CoeditPrefKeyReadAllTime", -1L);
            for (SharedItem sharedItem : listRequestSharedItemList) {
                String title = sharedItem.getTitle();
                long modifiedTime = sharedItem.getModifiedTime();
                String str2 = (String) sharedItem.getMetaData().get("uuid");
                if (str2 != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext, str2);
                    AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if (notesDocumentEntityM9f == null) {
                    AbstractC4539a.m3190D("[CS6] updateNoteTitleAndModifiedTime : No note, uuid = ", str2, "CoeditShareManager");
                } else if (AbstractC0298p.m585g(str2, sharedItem, sharedItem.getTitle()) || sharedItem.getModifiedTime() != notesDocumentEntityM9f.getLastModifiedAt()) {
                    long jM572i = AbstractC0291i.m572i(sharedItem.getMemo());
                    long checkpoint = syncNoteDataRepository.getCheckpoint(str2);
                    if (jM572i != -1 && checkpoint != -1 && checkpoint < jM572i && j != notesDocumentEntityM9f.getFirstOpendAt()) {
                        syncNoteDataRepository.updateFirstOpenedAt(str2, 0L);
                    }
                    new NoteDbResolver(str2).updateTitleAndModifiedTime(title, modifiedTime);
                    Debugger.m8615i("CoeditShareManager", "[CS6] updateNoteTitleAndModifiedTime : uuid = " + str2 + ", time = " + modifiedTime);
                } else {
                    AbstractC4539a.m3190D("[CS6] updateNoteTitleAndModifiedTime : No change, uuid = ", str2, "CoeditShareManager");
                }
            }
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("[CS6-2] updateNoteTitleAndModifiedTime() : requestSharedItemSync failed "), "CoeditShareManager");
        }
    }
}
