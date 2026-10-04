package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import androidx.lifecycle.MediatorLiveData;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SpaceEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p079T.AbstractC0291i;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6698l extends MediatorLiveData {

    /* JADX INFO: renamed from: a */
    public final ThreadPoolExecutor f4016a;

    /* JADX INFO: renamed from: b */
    public final Context f4017b;

    /* JADX INFO: renamed from: c */
    public final SyncNoteDataRepository f4018c;

    /* JADX INFO: renamed from: d */
    public final SortParam f4019d;

    public C6698l(Context context, SortParam sortParam) {
        C6697k c6697k = new C6697k(this, 0);
        this.f4017b = context;
        this.f4019d = sortParam;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(2), new ThreadPoolExecutor.DiscardPolicy());
        this.f4016a = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new SenlThreadFactory("SesCoeditStandaloneNoteLiveData"));
        C6695i c6695i = new C6695i(context, SesCoeditShareReadResolver.getInstance().mContentUri, true, 2);
        SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
        this.f4018c = syncNoteDataRepository;
        addSource(syncNoteDataRepository.getAllCoeditStandAloneNoteList_LiveData(sortParam), c6697k);
        addSource(c6695i, new C6697k(this, 1));
    }

    /* JADX INFO: renamed from: a */
    public final List m4784a() {
        List<Space> listRequestSpaceList = SesCoeditShareReadResolver.getInstance().requestSpaceList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (listRequestSpaceList != null) {
            HashSet hashSet = new HashSet();
            Context context = this.f4017b;
            NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
            NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
            NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            for (Space space : listRequestSpaceList) {
                String spaceId = space.getSpaceId();
                if (space.getStandAlone()) {
                    arrayList2.add(spaceId);
                } else {
                    SpaceEntry spaceEntry = new SpaceEntry(space.getGroupId(), space.getSpaceId(), space.getCreatedTime());
                    spaceEntry.setOwnedByMe(space.isOwnedByMe());
                    spaceEntry.setStandAlone(space.getStandAlone());
                    spaceEntry.setTitle(space.getTitle());
                    spaceEntry.setOwnedByMe(space.isOwnedByMe());
                    spaceEntry.setMembers(SesCoeditGroupReadResolver.getInstance().getMemberInfoList(space.getGroupId()));
                    spaceEntry.setUnReadCount(this.f4018c.getUnreadCoeditNoteCount(spaceId));
                    CoeditMainListEntry coeditMainListEntry = new CoeditMainListEntry();
                    coeditMainListEntry.setSpaceEntry(spaceEntry);
                    coeditMainListEntry.setType(1);
                    coeditMainListEntry.setAuthority("r/w");
                    arrayList.add(coeditMainListEntry);
                }
            }
            long j = SharedPreferencesCompat.getInstance("CoeditPref").getLong("CoeditPrefKeyReadAllTime", -1L);
            for (MainListDocumentData mainListDocumentData : new MainListDocumentDataRepository().getCoEditMainListEntryListBySpaceIdList(arrayList2, this.f4019d)) {
                CoeditMainListEntry coeditMainListEntryM617a = AbstractC0299q.m617a(this.f4017b, mainListDocumentData, this.f4018c, j, SesCoeditGroupReadResolver.getInstance().getGroupCount(mainListDocumentData.getMdeGroupId()));
                if (coeditMainListEntryM617a != null) {
                    hashSet.add(coeditMainListEntryM617a.getMainListDocumentData().getMdeItemId());
                    arrayList.add(coeditMainListEntryM617a);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Map mapM568e = AbstractC0291i.m568e((String) it.next());
                if (mapM568e != null) {
                    for (Map.Entry entry : mapM568e.entrySet()) {
                        if (!hashSet.contains(entry.getKey())) {
                            arrayList.add((CoeditMainListEntry) entry.getValue());
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
