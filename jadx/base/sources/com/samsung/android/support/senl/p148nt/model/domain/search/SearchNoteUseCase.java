package com.samsung.android.support.senl.p148nt.model.domain.search;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SearchWord;
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.search.BixbySearchQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.search.SearchQuery;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.domain.search.SearchNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.domain.search.SemanticSearchNoteUseCase;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;
import p122b2.C4191n;
import p184g4.C12014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SearchNoteUseCase {
    private static final String TAG = ModelLogger.createTag("SearchNoteUseCase");
    private final MainListDocumentDataRepository mDocumentDataRepository;
    private final NotesSearchRepository mSearchRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private static final String ESCAPE_CHARACTER_STRING = String.valueOf((char) 65533);
        private final Set<String> mContextualKeywords;
        private final List<MainListDocumentData> mDatabaseSearchNotes;
        private final List<MainListDocumentData> mKeywordSearchNotes;
        private final List<MainListDocumentData> mKeywordSearchNotesWithQp;
        private final List<MainListDocumentData> mKeywordSearchNotesWithoutQp;
        private final List<MainListDocumentData> mNotesBasedKeywords;
        private final List<MainListDocumentData> mNotesRelatedKeywords;
        private final Map<String, Float> mSemanticScoreMap;
        private final List<MainListDocumentData> mSemanticSearchNotes;
        private final List<MainListDocumentData> mTotalNotes;
        private final List<SearchWord> mWords;

        public Result() {
            this(new ArrayList());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(SearchWord searchWord) {
            SearchWord searchWord2 = new SearchWord(searchWord.getWord().replace(ESCAPE_CHARACTER_STRING, ""));
            searchWord2.setStemmedWord(searchWord.getStemmedWord());
            searchWord2.addSynonyms(searchWord.getSynonyms());
            this.mWords.add(searchWord2);
        }

        @NonNull
        public Result addContextualKeyword(@NotNull Set<String> set) {
            this.mContextualKeywords.addAll(set);
            return this;
        }

        @NonNull
        public Result addDatabaseSearchNotes(@NonNull List<MainListDocumentData> list) {
            this.mDatabaseSearchNotes.addAll(list);
            this.mNotesBasedKeywords.addAll(list);
            this.mTotalNotes.addAll(list);
            return this;
        }

        @NonNull
        public Result addKeywordSearchNotesWithQp(@NonNull List<MainListDocumentData> list) {
            this.mKeywordSearchNotesWithQp.addAll(list);
            this.mKeywordSearchNotes.addAll(list);
            this.mNotesRelatedKeywords.addAll(list);
            this.mTotalNotes.addAll(list);
            return this;
        }

        @NonNull
        public Result addKeywordSearchNotesWithoutQp(@NonNull List<MainListDocumentData> list) {
            this.mKeywordSearchNotesWithoutQp.addAll(list);
            this.mKeywordSearchNotes.addAll(list);
            this.mNotesBasedKeywords.addAll(list);
            this.mTotalNotes.addAll(list);
            return this;
        }

        @NonNull
        public Result addSemanticScoreMap(@NonNull Map<String, Float> map) {
            this.mSemanticScoreMap.putAll(map);
            return this;
        }

        @NonNull
        public Result addSemanticSearchNotes(@NonNull List<MainListDocumentData> list) {
            this.mSemanticSearchNotes.addAll(list);
            this.mNotesRelatedKeywords.addAll(list);
            this.mTotalNotes.addAll(list);
            return this;
        }

        @NonNull
        public Set<String> getContextualKeywords() {
            return this.mContextualKeywords;
        }

        @NonNull
        public List<MainListDocumentData> getDatabaseSearchNotes() {
            return this.mDatabaseSearchNotes;
        }

        @NonNull
        public List<MainListDocumentData> getKeywordSearchNotes() {
            return this.mKeywordSearchNotes;
        }

        @NonNull
        public List<MainListDocumentData> getKeywordSearchNotesWithQp() {
            return this.mKeywordSearchNotesWithQp;
        }

        @NonNull
        public List<MainListDocumentData> getKeywordSearchNotesWithoutQp() {
            return this.mKeywordSearchNotesWithoutQp;
        }

        @NonNull
        public List<MainListDocumentData> getNotesBasedKeywords() {
            return this.mNotesBasedKeywords;
        }

        @NonNull
        public List<MainListDocumentData> getNotesRelatedKeywords() {
            return this.mNotesRelatedKeywords;
        }

        @NonNull
        public Map<String, Float> getSemanticScoreMap() {
            return this.mSemanticScoreMap;
        }

        @NonNull
        public List<MainListDocumentData> getSemanticSearchNotes() {
            return this.mSemanticSearchNotes;
        }

        @NonNull
        public List<SearchWord> getTargetWords() {
            return this.mWords;
        }

        @NonNull
        public List<MainListDocumentData> getTotalNotes() {
            return this.mTotalNotes;
        }

        public void removeDuplicateNotes(@NonNull List<MainListDocumentData> list) {
            this.mTotalNotes.removeAll(list);
            this.mDatabaseSearchNotes.removeAll(list);
            this.mKeywordSearchNotesWithoutQp.removeAll(list);
            this.mKeywordSearchNotesWithQp.removeAll(list);
            this.mKeywordSearchNotes.removeAll(list);
            this.mSemanticSearchNotes.removeAll(list);
            this.mNotesBasedKeywords.removeAll(list);
            this.mNotesRelatedKeywords.removeAll(list);
        }

        public Result(@NonNull List<SearchWord> list) {
            this.mWords = new ArrayList();
            this.mTotalNotes = new ArrayList();
            this.mNotesBasedKeywords = new ArrayList();
            this.mNotesRelatedKeywords = new ArrayList();
            this.mDatabaseSearchNotes = new ArrayList();
            this.mKeywordSearchNotes = new ArrayList();
            this.mKeywordSearchNotesWithoutQp = new ArrayList();
            this.mKeywordSearchNotesWithQp = new ArrayList();
            this.mSemanticSearchNotes = new ArrayList();
            this.mSemanticScoreMap = new HashMap();
            this.mContextualKeywords = new HashSet();
            list.forEach(new C4191n(this, 21));
        }
    }

    public SearchNoteUseCase(@NonNull NotesSearchRepository notesSearchRepository, @NonNull MainListDocumentDataRepository mainListDocumentDataRepository) {
        this.mSearchRepository = notesSearchRepository;
        this.mDocumentDataRepository = mainListDocumentDataRepository;
    }

    private String createQuery(SearchParam searchParam, String str, List<SearchWord> list) {
        return new SearchQuery(searchParam, list).getQuery(str, new DocumentSortQuery().createQuery(searchParam.getSortParam()));
    }

    @Nullable
    private BiFunction<MainListDocumentData, MainListDocumentData, Integer> createSortFunction(@NonNull SearchParam searchParam) {
        SortParam sortParam = searchParam.getSortParam();
        if (sortParam == null) {
            return null;
        }
        int sortType = sortParam.getSortType();
        if (sortType == 0) {
            return sortParam.getIsDesc() ? new C12014a(0) : new C12014a(1);
        }
        if (sortType == 1) {
            return sortParam.getIsDesc() ? new C12014a(2) : new C12014a(3);
        }
        if (sortType != 2) {
            return null;
        }
        return sortParam.getIsDesc() ? new C12014a(4) : new C12014a(5);
    }

    private String getBixbySelection(SearchParam searchParam) {
        String str = TAG;
        DataLogger.m12307i(str, "getBixbySelection, param: " + searchParam);
        List<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(searchParam.getQueryFolderName())) {
            arrayList = FolderManager.getInstance().getUuidsByDisplayName(searchParam.getQueryFolderName());
            if (arrayList.isEmpty()) {
                DataLogger.m12302d(str, "getBixbySelection, cannot find a folder");
                return "";
            }
        }
        return new BixbySearchQuery(arrayList, searchParam).createSelection();
    }

    private Result invokeSemanticSearch(@NonNull SearchParam searchParam) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, false);
        SemanticSearchNoteUseCase.Result resultInvoke = new SemanticSearchNoteUseCase(this.mSearchRepository.getSemanticSearchRepository(), this.mDocumentDataRepository).invoke(searchParam);
        return new Result(searchKeywords).addKeywordSearchNotesWithoutQp(resultInvoke.getKeywordSearchResultWithoutQp()).addKeywordSearchNotesWithQp(resultInvoke.getKeywordSearchResultWithQp()).addSemanticSearchNotes(resultInvoke.getSemanticSearchResult()).addSemanticScoreMap(resultInvoke.getSematicSearchScoreMap()).addContextualKeyword(Collections.singleton(resultInvoke.getContextualKeyword()));
    }

    private boolean isSearchableParam(SearchParam searchParam) {
        return (searchParam.getQueryText().isEmpty() && !searchParam.getFilterParam().isValid() && CoverStickerConstants.Category.NONE.UUID.equals(searchParam.getFilterParam().getCoverSticker())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createSortFunction$1(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return Integer.valueOf(mainListDocumentData2.getTitle().compareTo(mainListDocumentData.getTitle()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createSortFunction$2(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return Integer.valueOf(mainListDocumentData.getTitle().compareTo(mainListDocumentData2.getTitle()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createSortFunction$3(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return Integer.valueOf(Long.compare(mainListDocumentData2.getCreatedAt(), mainListDocumentData.getCreatedAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createSortFunction$4(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return Integer.valueOf(Long.compare(mainListDocumentData.getCreatedAt(), mainListDocumentData2.getCreatedAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createSortFunction$5(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return Integer.valueOf(Long.compare(mainListDocumentData2.getLastModifiedAt(), mainListDocumentData.getLastModifiedAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$createSortFunction$6(MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return Integer.valueOf(Long.compare(mainListDocumentData.getLastModifiedAt(), mainListDocumentData2.getLastModifiedAt()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortNotes$0(BiFunction biFunction, MainListDocumentData mainListDocumentData, MainListDocumentData mainListDocumentData2) {
        return mainListDocumentData.getIsFavorite() == mainListDocumentData2.getIsFavorite() ? ((Integer) biFunction.apply(mainListDocumentData, mainListDocumentData2)).intValue() : Integer.compare(mainListDocumentData2.getIsFavorite(), mainListDocumentData.getIsFavorite());
    }

    public static int removeDuplicatedNotes(@NonNull Result result, @NonNull Result result2) {
        ArrayList arrayList = new ArrayList();
        Set set = (Set) result.getTotalNotes().stream().map(new C11419a(17)).collect(Collectors.toSet());
        for (MainListDocumentData mainListDocumentData : result2.getTotalNotes()) {
            if (set.contains(mainListDocumentData.getUuid())) {
                arrayList.add(mainListDocumentData);
            } else {
                set.add(mainListDocumentData.getUuid());
            }
        }
        result2.removeDuplicateNotes(arrayList);
        return arrayList.size();
    }

    @NonNull
    private Result search(SearchParam searchParam, String str) {
        if (searchParam.checkStrategy(2)) {
            Result resultSearchSourceWord = searchSourceWord(searchParam, str);
            if (resultSearchSourceWord.getTotalNotes().isEmpty()) {
                resultSearchSourceWord = searchStemmedWord(searchParam, str);
            }
            return resultSearchSourceWord.getTotalNotes().isEmpty() ? searchSynonyms(searchParam, str) : resultSearchSourceWord;
        }
        if (searchParam.getStrategy() != 4) {
            List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, false);
            return new Result(searchKeywords).addDatabaseSearchNotes(this.mSearchRepository.search(createQuery(searchParam, str, searchKeywords), QueryUtils.createSearchBindArgs(searchKeywords, SearchUtils.getArgCountInTotalQuery(searchParam.includeFolderName()))));
        }
        List<SearchWord> searchKeywords2 = QueryUtils.getSearchKeywords(searchParam.getQueryText(), true, true);
        boolean z = searchParam.getMaxCount() > 0;
        HashSet hashSet = new HashSet();
        List<MainListDocumentData> totalNotes = searchSourceWord(searchParam, str).getTotalNotes();
        if (z && totalNotes.size() > searchParam.getMaxCount()) {
            totalNotes = totalNotes.subList(0, searchParam.getMaxCount());
        }
        Iterator<MainListDocumentData> it = totalNotes.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getUuid());
        }
        if (!z || hashSet.size() < searchParam.getMaxCount()) {
            for (MainListDocumentData mainListDocumentData : searchStemmedWord(searchParam, str).getTotalNotes()) {
                if (z && hashSet.size() >= searchParam.getMaxCount()) {
                    break;
                }
                if (!hashSet.contains(mainListDocumentData.getUuid())) {
                    totalNotes.add(mainListDocumentData);
                    hashSet.add(mainListDocumentData.getUuid());
                }
            }
        }
        if (!z || hashSet.size() < searchParam.getMaxCount()) {
            for (MainListDocumentData mainListDocumentData2 : searchSynonyms(searchParam, str).getTotalNotes()) {
                if (z && hashSet.size() >= searchParam.getMaxCount()) {
                    break;
                }
                if (!hashSet.contains(mainListDocumentData2.getUuid())) {
                    totalNotes.add(mainListDocumentData2);
                    hashSet.add(mainListDocumentData2.getUuid());
                }
            }
        }
        return new Result(searchKeywords2).addDatabaseSearchNotes(totalNotes);
    }

    @NonNull
    private Result searchFromBixby(SearchParam searchParam) {
        String bixbySelection = getBixbySelection(searchParam);
        if (isSearchableParam(searchParam) || !TextUtils.isEmpty(bixbySelection)) {
            return search(searchParam, bixbySelection);
        }
        DataLogger.m12307i(TAG, "searchFromBixby, invalid bixby param");
        return new Result();
    }

    @NonNull
    private Result searchFromList(SearchParam searchParam) {
        if (isSearchableParam(searchParam)) {
            return search(searchParam, "");
        }
        if (searchParam.getMaxCount() > 0) {
            return searchLatestNotes(searchParam);
        }
        DataLogger.m12307i(TAG, "search, target is empty.");
        return new Result();
    }

    private Result searchInDatabase(@NonNull SearchParam searchParam, boolean z) {
        if (z) {
            int searchMode = searchParam.getSearchMode();
            return searchMode != 0 ? searchMode != 1 ? searchMode != 2 ? new Result() : searchLatestNotes(searchParam) : searchFromBixby(searchParam) : searchFromList(searchParam);
        }
        DataLogger.m12307i(TAG, "searchInDatabase, skip");
        return new Result();
    }

    private Result searchLatestNotes(SearchParam searchParam) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<MainListDocumentData> listSearchLatestNotes = this.mSearchRepository.searchLatestNotes(searchParam.getMaxCount());
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12307i(TAG, "searchLatestNotes, maxCount: " + searchParam.getMaxCount() + " / results : " + listSearchLatestNotes.size() + " / duration : " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        return new Result(new ArrayList()).addDatabaseSearchNotes(listSearchLatestNotes);
    }

    private Result searchSourceWord(SearchParam searchParam, String str) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, false);
        String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, SearchUtils.getArgCountInTotalQuery(searchParam.includeFolderName()));
        return new Result(searchKeywords).addDatabaseSearchNotes(this.mSearchRepository.search(createQuery(searchParam, str, searchKeywords), strArrCreateSearchBindArgs));
    }

    private Result searchStemmedWord(SearchParam searchParam, String str) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), true, false);
        Iterator<SearchWord> it = searchKeywords.iterator();
        while (it.hasNext()) {
            if (!it.next().getStemmedWord().isEmpty()) {
                String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, SearchUtils.getArgCountInTotalQuery(searchParam.includeFolderName()));
                return new Result(searchKeywords).addDatabaseSearchNotes(this.mSearchRepository.search(createQuery(searchParam, str, searchKeywords), strArrCreateSearchBindArgs));
            }
        }
        return new Result(searchKeywords);
    }

    private Result searchSynonyms(SearchParam searchParam, String str) {
        List<SearchWord> searchKeywords = QueryUtils.getSearchKeywords(searchParam.getQueryText(), false, true);
        Iterator<SearchWord> it = searchKeywords.iterator();
        while (it.hasNext()) {
            if (!it.next().getSynonyms().isEmpty()) {
                String[] strArrCreateSearchBindArgs = QueryUtils.createSearchBindArgs(searchKeywords, SearchUtils.getArgCountInTotalQuery(searchParam.includeFolderName()));
                return new Result(searchKeywords).addDatabaseSearchNotes(this.mSearchRepository.search(createQuery(searchParam, str, searchKeywords), strArrCreateSearchBindArgs));
            }
        }
        return new Result(searchKeywords);
    }

    @NonNull
    private List<MainListDocumentData> sortNotes(@NonNull List<MainListDocumentData> list, @NonNull SearchParam searchParam) {
        final BiFunction<MainListDocumentData, MainListDocumentData, Integer> biFunctionCreateSortFunction = createSortFunction(searchParam);
        if (biFunctionCreateSortFunction == null) {
            return list;
        }
        if (searchParam.getSortParam().getIsPinFavorite()) {
            final int i = 0;
            list.sort(new Comparator() { // from class: g4.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    MainListDocumentData mainListDocumentData = (MainListDocumentData) obj;
                    MainListDocumentData mainListDocumentData2 = (MainListDocumentData) obj2;
                    switch (i) {
                        case 0:
                            return SearchNoteUseCase.lambda$sortNotes$0(biFunctionCreateSortFunction, mainListDocumentData, mainListDocumentData2);
                        default:
                            return ((Integer) biFunctionCreateSortFunction.apply(mainListDocumentData, mainListDocumentData2)).intValue();
                    }
                }
            });
            return list;
        }
        final int i2 = 1;
        list.sort(new Comparator() { // from class: g4.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                MainListDocumentData mainListDocumentData = (MainListDocumentData) obj;
                MainListDocumentData mainListDocumentData2 = (MainListDocumentData) obj2;
                switch (i2) {
                    case 0:
                        return SearchNoteUseCase.lambda$sortNotes$0(biFunctionCreateSortFunction, mainListDocumentData, mainListDocumentData2);
                    default:
                        return ((Integer) biFunctionCreateSortFunction.apply(mainListDocumentData, mainListDocumentData2)).intValue();
                }
            }
        });
        return list;
    }

    private void updateStrategy(@NonNull SearchParam searchParam, boolean z) {
        String str;
        if (Looper.getMainLooper() == Looper.myLooper() || z) {
            if (searchParam.checkStrategy(2)) {
                searchParam.removeStrategy(2);
                str = " [NEXT_IF_EMPTY]";
            } else {
                str = "";
            }
            if (searchParam.checkStrategy(4)) {
                searchParam.removeStrategy(4);
                str = str + " [COUNT_BASED]";
            }
            if (str.isEmpty()) {
                return;
            }
            String str2 = TAG;
            StringBuilder sbM15l = AbstractC0000a.m15l("updateStrategy, remove", str, " by ");
            sbM15l.append(z ? "semantic" : "main thread");
            DataLogger.m12309w(str2, sbM15l.toString());
        }
    }

    @NonNull
    public Result invoke(SearchParam searchParam) {
        boolean zIsSearchEngineConnected = Features.isSearchEngineConnected();
        updateStrategy(searchParam, zIsSearchEngineConnected);
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        boolean zCheckStrategy = searchParam.checkStrategy(1);
        Result resultSearchInDatabase = searchInDatabase(searchParam, zCheckStrategy);
        Result result = new Result();
        int iRemoveDuplicatedNotes = 0;
        if (!searchParam.checkStrategy(8) || (searchParam.getMaxCount() != 0 && resultSearchInDatabase.mTotalNotes.size() >= searchParam.getMaxCount())) {
            z = false;
        }
        if (z) {
            if (zIsSearchEngineConnected) {
                result = invokeSemanticSearch(searchParam);
            } else {
                DataLogger.m12309w(TAG, "[Semantic] search engine is not supported");
            }
        }
        if (z && zCheckStrategy) {
            iRemoveDuplicatedNotes = removeDuplicatedNotes(resultSearchInDatabase, result);
        }
        Result resultAddContextualKeyword = new Result(resultSearchInDatabase.getTargetWords().isEmpty() ? result.getTargetWords() : resultSearchInDatabase.getTargetWords()).addDatabaseSearchNotes(resultSearchInDatabase.getTotalNotes()).addKeywordSearchNotesWithoutQp(result.getKeywordSearchNotesWithoutQp()).addKeywordSearchNotesWithQp(sortNotes(result.getKeywordSearchNotesWithQp(), searchParam)).addSemanticSearchNotes(result.getSemanticSearchNotes()).addSemanticScoreMap(result.getSemanticScoreMap()).addContextualKeyword(result.getContextualKeywords());
        sortNotes(resultAddContextualKeyword.getNotesBasedKeywords(), searchParam);
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        DataLogger.m12307i(TAG, "search, target : " + DataLogger.getEncode(searchParam.getQueryText()) + " / results (" + resultAddContextualKeyword.getTotalNotes().size() + ") = {basic (" + resultAddContextualKeyword.getNotesBasedKeywords().size() + ") = app (" + resultAddContextualKeyword.getDatabaseSearchNotes().size() + ") + keyword[-QP] (" + resultAddContextualKeyword.getKeywordSearchNotesWithoutQp().size() + ")} + {related (" + resultAddContextualKeyword.getNotesRelatedKeywords().size() + ") = keyword[+QP] (" + resultAddContextualKeyword.getKeywordSearchNotesWithQp().size() + ") + semantic (" + resultAddContextualKeyword.getSemanticSearchNotes().size() + ")} / dup (" + iRemoveDuplicatedNotes + ")  / isCoedit: " + searchParam.isCoEditMode() + ", filter: {" + searchParam.getFilterParam() + "}, [Semantic]: " + z + ", duration: " + (jCurrentTimeMillis2 - jCurrentTimeMillis));
        return resultAddContextualKeyword;
    }
}
