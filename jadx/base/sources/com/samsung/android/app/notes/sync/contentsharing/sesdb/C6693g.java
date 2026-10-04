package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.extractor.EventManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p079T.AbstractC0291i;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6693g extends AbstractC6688b {

    /* JADX INFO: renamed from: f */
    public LiveData f3999f;

    /* JADX INFO: renamed from: g */
    public final SortParam f4000g;

    /* JADX INFO: renamed from: h */
    public final String f4001h;

    /* JADX INFO: renamed from: i */
    public final String f4002i;

    /* JADX INFO: renamed from: j */
    public final C6692f f4003j;

    /* JADX INFO: renamed from: k */
    public final SyncNoteDataRepository f4004k;

    /* JADX INFO: renamed from: l */
    public final C6697k f4005l;

    public C6693g(Context context, String str, String str2, SortParam sortParam) {
        super(context, SesCoeditShareReadResolver.getInstance().getSharedItemContentUri(str), true);
        this.f4005l = new C6697k(this, 2);
        this.f4000g = sortParam;
        this.f4001h = str;
        this.f4002i = str2;
        this.f4004k = new SyncNoteDataRepository();
        this.f4003j = new C6692f(this);
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.AbstractC6688b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final List mo4781a() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Context context = this.f3991a;
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        long j = SharedPreferencesCompat.getInstance("CoeditPref").getLong("CoeditPrefKeyReadAllTime", -1L);
        int groupCount = SesCoeditGroupReadResolver.getInstance().getGroupCount(this.f4002i);
        String str = this.f4001h;
        Iterator<MainListDocumentData> it = new MainListDocumentDataRepository().getCoEditMainListEntryListBySpaceIdList(Collections.singletonList(str), this.f4000g).iterator();
        while (it.hasNext()) {
            CoeditMainListEntry coeditMainListEntryM617a = AbstractC0299q.m617a(this.f3991a, it.next(), this.f4004k, j, groupCount);
            if (coeditMainListEntryM617a != null) {
                hashSet.add(coeditMainListEntryM617a.getMainListDocumentData().getMdeItemId());
                arrayList.add(coeditMainListEntryM617a);
            }
        }
        Map mapM568e = AbstractC0291i.m568e(str);
        if (mapM568e != null) {
            for (Map.Entry entry : mapM568e.entrySet()) {
                if (!hashSet.contains(entry.getKey())) {
                    arrayList.add((CoeditMainListEntry) entry.getValue());
                }
            }
        }
        return arrayList;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.AbstractC6688b, androidx.lifecycle.LiveData
    public final void onActive() {
        super.onActive();
        LiveData<List<MainListDocumentData>> allContentShare_LiveData = NotesDataRepositoryFactory.newInstance(BaseUtils.getApplicationContext()).createMainListDocumentDataRepository().getAllContentShare_LiveData(this.f4000g, this.f4001h);
        this.f3999f = allContentShare_LiveData;
        allContentShare_LiveData.observeForever(this.f4005l);
        EventManager.getEventBus().register(this.f4003j);
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.AbstractC6688b, androidx.lifecycle.LiveData
    public final void onInactive() {
        super.onInactive();
        LiveData liveData = this.f3999f;
        if (liveData != null) {
            liveData.removeObserver(this.f4005l);
        }
        EventManager.getEventBus().unregister(this.f4003j);
    }
}
