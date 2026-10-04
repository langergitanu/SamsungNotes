package com.samsung.android.support.senl.p148nt.model.domain.search;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SearchWord;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.FolderSearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.search.FolderSearchQuery;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SearchFolderUseCase {
    private static final String TAG = ModelLogger.createTag("SearchFolderUseCase");
    private final NotesSearchRepository mRepository;

    public SearchFolderUseCase(NotesSearchRepository notesSearchRepository) {
        this.mRepository = notesSearchRepository;
    }

    private FolderSearchParam createFolderSearchParam(@NonNull List<SearchWord> list, @NonNull SearchParam searchParam) {
        return new FolderSearchParam(list).setWithDelimiter(true).setTargetFolderUuid(searchParam.getTargetFolderUuid()).setFilterParam(searchParam.getFilterParam()).addExcludedFolders(PredefinedCategory.RESTRICTED_FOLDERS);
    }

    @NonNull
    private List<NotesCategoryTreeEntity> searchKeywords(@NonNull SearchParam searchParam) {
        if (!searchParam.checkStrategy(4)) {
            List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, false);
            String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, 1);
            return this.mRepository.searchFolder(new FolderSearchQuery(createFolderSearchParam(searchKeywords, searchParam)).getQuery(searchParam.getMaxCount()), strArrCreateSearchBindArgs);
        }
        HashSet hashSet = new HashSet();
        List<NotesCategoryTreeEntity> listSearchSourceWord = searchSourceWord(searchParam);
        Iterator<NotesCategoryTreeEntity> it = listSearchSourceWord.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getUuid());
        }
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : searchStemmedWord(searchParam)) {
            if (!hashSet.contains(notesCategoryTreeEntity.getUuid())) {
                listSearchSourceWord.add(notesCategoryTreeEntity);
                hashSet.add(notesCategoryTreeEntity.getUuid());
            }
        }
        for (NotesCategoryTreeEntity notesCategoryTreeEntity2 : searchSynonyms(searchParam)) {
            if (!hashSet.contains(notesCategoryTreeEntity2.getUuid())) {
                listSearchSourceWord.add(notesCategoryTreeEntity2);
                hashSet.add(notesCategoryTreeEntity2.getUuid());
            }
        }
        return listSearchSourceWord;
    }

    private List<NotesCategoryTreeEntity> searchLatestFolders(@NonNull SearchParam searchParam) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<NotesCategoryTreeEntity> listSearchLatestFolders = this.mRepository.searchLatestFolders(searchParam.getMaxCount(), PredefinedCategory.RESTRICTED_FOLDERS);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12307i(TAG, "searchLatestFolders, maxCount: " + searchParam.getMaxCount() + " / results : " + listSearchLatestFolders.size() + " / duration : " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        return listSearchLatestFolders;
    }

    private List<NotesCategoryTreeEntity> searchSourceWord(@NonNull SearchParam searchParam) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, false);
        String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, 1);
        return this.mRepository.searchFolder(new FolderSearchQuery(createFolderSearchParam(searchKeywords, searchParam)).getQuery(searchParam.getMaxCount()), strArrCreateSearchBindArgs);
    }

    private List<NotesCategoryTreeEntity> searchStemmedWord(@NonNull SearchParam searchParam) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), true, false);
        Iterator<SearchWord> it = searchKeywords.iterator();
        while (it.hasNext()) {
            if (!it.next().getStemmedWord().isEmpty()) {
                String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, 1);
                return this.mRepository.searchFolder(new FolderSearchQuery(createFolderSearchParam(searchKeywords, searchParam)).getQuery(searchParam.getMaxCount()), strArrCreateSearchBindArgs);
            }
        }
        return new ArrayList();
    }

    private List<NotesCategoryTreeEntity> searchSynonyms(@NonNull SearchParam searchParam) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, true);
        Iterator<SearchWord> it = searchKeywords.iterator();
        while (it.hasNext()) {
            if (!it.next().getSynonyms().isEmpty()) {
                String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, 1);
                return this.mRepository.searchFolder(new FolderSearchQuery(createFolderSearchParam(searchKeywords, searchParam)).getQuery(searchParam.getMaxCount()), strArrCreateSearchBindArgs);
            }
        }
        return new ArrayList();
    }

    @NonNull
    public List<NotesCategoryTreeEntity> invoke(@NonNull SearchParam searchParam) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<NotesCategoryTreeEntity> arrayList = new ArrayList<>();
        if (searchParam.getFilterParam().getContentType() != 0) {
            return arrayList;
        }
        if (!searchParam.isCoEditMode()) {
            if (!searchParam.getQueryText().isEmpty() || searchParam.getFilterParam().isValidTimeCondition()) {
                arrayList = searchKeywords(searchParam);
            } else if (searchParam.getMaxCount() > 0) {
                arrayList = searchLatestFolders(searchParam);
            } else {
                DataLogger.m12309w(TAG, "invalid search params");
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12307i(TAG, "search folder, target : " + DataLogger.getEncode(searchParam.getQueryText()) + " / results : " + arrayList.size() + " / duration: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        return arrayList;
    }
}
