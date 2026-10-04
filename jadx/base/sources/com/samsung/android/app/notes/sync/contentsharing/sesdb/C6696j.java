package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.samsung.android.sdk.mobileservice.social.share.Space;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
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

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6696j extends MediatorLiveData {

    /* JADX INFO: renamed from: a */
    public final ThreadPoolExecutor f4009a;

    /* JADX INFO: renamed from: b */
    public final Context f4010b;

    /* JADX INFO: renamed from: c */
    public int f4011c = 0;

    /* JADX INFO: renamed from: d */
    public int f4012d = 0;

    /* JADX INFO: renamed from: e */
    public final SortParam f4013e;

    public C6696j(Context context, SortParam sortParam) {
        C6694h c6694h = new C6694h(this, 0);
        this.f4010b = context;
        this.f4013e = sortParam;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(2), new ThreadPoolExecutor.DiscardPolicy());
        this.f4009a = threadPoolExecutor;
        threadPoolExecutor.setThreadFactory(new SenlThreadFactory("SesCoeditSpaceAndStandaloneNoteCountLiveData"));
        C6695i c6695i = new C6695i(context, SesCoeditShareReadResolver.getInstance().mContentUri, false, 0);
        C6695i c6695i2 = new C6695i(context, SesCoeditGroupReadResolver.getInstance().mContentUri, false, 1);
        LiveData<List<MainListDocumentData>> allCoeditStandAloneNoteList_LiveData = new SyncNoteDataRepository().getAllCoeditStandAloneNoteList_LiveData(sortParam);
        addSource(c6695i2, new C6694h(this, 1));
        addSource(allCoeditStandAloneNoteList_LiveData, c6694h);
        addSource(c6695i, new C6694h(this, 2));
    }

    /* JADX INFO: renamed from: a */
    public final List m4783a() {
        List<Space> listRequestSpaceList = SesCoeditShareReadResolver.getInstance().requestSpaceList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (listRequestSpaceList != null) {
            HashSet hashSet = new HashSet();
            Context context = this.f4010b;
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
                    arrayList.add(new CoeditMainListEntry());
                }
            }
            for (MainListDocumentData mainListDocumentData : new MainListDocumentDataRepository().getCoEditMainListEntryListBySpaceIdList(arrayList2, this.f4013e)) {
                if (!TextUtils.isEmpty(mainListDocumentData.getMdeGroupId())) {
                    CoeditMainListEntry coeditMainListEntry = new CoeditMainListEntry();
                    hashSet.add(mainListDocumentData.getMdeItemId());
                    arrayList.add(coeditMainListEntry);
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
