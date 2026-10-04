package com.samsung.android.support.senl.p148nt.model.domain.search;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.C8878a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.SemanticSearchRepository;
import com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.C11561g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/search/SemanticSearchNoteUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/common/BaseUseCase;", "Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SearchParam;", "Lcom/samsung/android/support/senl/nt/model/domain/search/SemanticSearchNoteUseCase$Result;", "semanticSearchRepository", "Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository;", "documentDataRepository", "Lcom/samsung/android/support/senl/nt/data/repository/document/MainListDocumentDataRepository;", "<init>", "(Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository;Lcom/samsung/android/support/senl/nt/data/repository/document/MainListDocumentDataRepository;)V", "getSemanticSearchRepository", "()Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository;", "getDocumentDataRepository", "()Lcom/samsung/android/support/senl/nt/data/repository/document/MainListDocumentDataRepository;", "execute", "param", "Result", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SemanticSearchNoteUseCase extends BaseUseCase<SearchParam, Result> {

    @NotNull
    private final MainListDocumentDataRepository documentDataRepository;

    @NotNull
    private final SemanticSearchRepository semanticSearchRepository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003Ji\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\nHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/search/SemanticSearchNoteUseCase$Result;", "", "totalResult", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "keywordSearchResultWithoutQp", "keywordSearchResultWithQp", "semanticSearchResult", "sematicSearchScoreMap", "", "", "", "contextualKeyword", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getTotalResult", "()Ljava/util/List;", "getKeywordSearchResultWithoutQp", "getKeywordSearchResultWithQp", "getSemanticSearchResult", "getSematicSearchScoreMap", "()Ljava/util/Map;", "getContextualKeyword", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Result {

        @NotNull
        private final String contextualKeyword;

        @NotNull
        private final List<MainListDocumentData> keywordSearchResultWithQp;

        @NotNull
        private final List<MainListDocumentData> keywordSearchResultWithoutQp;

        @NotNull
        private final List<MainListDocumentData> semanticSearchResult;

        @NotNull
        private final Map<String, Float> sematicSearchScoreMap;

        @NotNull
        private final List<MainListDocumentData> totalResult;

        public Result(@NotNull List<MainListDocumentData> totalResult, @NotNull List<MainListDocumentData> keywordSearchResultWithoutQp, @NotNull List<MainListDocumentData> keywordSearchResultWithQp, @NotNull List<MainListDocumentData> semanticSearchResult, @NotNull Map<String, Float> sematicSearchScoreMap, @NotNull String contextualKeyword) {
            Intrinsics.checkNotNullParameter(totalResult, "totalResult");
            Intrinsics.checkNotNullParameter(keywordSearchResultWithoutQp, "keywordSearchResultWithoutQp");
            Intrinsics.checkNotNullParameter(keywordSearchResultWithQp, "keywordSearchResultWithQp");
            Intrinsics.checkNotNullParameter(semanticSearchResult, "semanticSearchResult");
            Intrinsics.checkNotNullParameter(sematicSearchScoreMap, "sematicSearchScoreMap");
            Intrinsics.checkNotNullParameter(contextualKeyword, "contextualKeyword");
            this.totalResult = totalResult;
            this.keywordSearchResultWithoutQp = keywordSearchResultWithoutQp;
            this.keywordSearchResultWithQp = keywordSearchResultWithQp;
            this.semanticSearchResult = semanticSearchResult;
            this.sematicSearchScoreMap = sematicSearchScoreMap;
            this.contextualKeyword = contextualKeyword;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, List list, List list2, List list3, List list4, Map map, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = result.totalResult;
            }
            if ((i & 2) != 0) {
                list2 = result.keywordSearchResultWithoutQp;
            }
            if ((i & 4) != 0) {
                list3 = result.keywordSearchResultWithQp;
            }
            if ((i & 8) != 0) {
                list4 = result.semanticSearchResult;
            }
            if ((i & 16) != 0) {
                map = result.sematicSearchScoreMap;
            }
            if ((i & 32) != 0) {
                str = result.contextualKeyword;
            }
            Map map2 = map;
            String str2 = str;
            return result.copy(list, list2, list3, list4, map2, str2);
        }

        @NotNull
        public final List<MainListDocumentData> component1() {
            return this.totalResult;
        }

        @NotNull
        public final List<MainListDocumentData> component2() {
            return this.keywordSearchResultWithoutQp;
        }

        @NotNull
        public final List<MainListDocumentData> component3() {
            return this.keywordSearchResultWithQp;
        }

        @NotNull
        public final List<MainListDocumentData> component4() {
            return this.semanticSearchResult;
        }

        @NotNull
        public final Map<String, Float> component5() {
            return this.sematicSearchScoreMap;
        }

        @NotNull
        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getContextualKeyword() {
            return this.contextualKeyword;
        }

        @NotNull
        public final Result copy(@NotNull List<MainListDocumentData> totalResult, @NotNull List<MainListDocumentData> keywordSearchResultWithoutQp, @NotNull List<MainListDocumentData> keywordSearchResultWithQp, @NotNull List<MainListDocumentData> semanticSearchResult, @NotNull Map<String, Float> sematicSearchScoreMap, @NotNull String contextualKeyword) {
            Intrinsics.checkNotNullParameter(totalResult, "totalResult");
            Intrinsics.checkNotNullParameter(keywordSearchResultWithoutQp, "keywordSearchResultWithoutQp");
            Intrinsics.checkNotNullParameter(keywordSearchResultWithQp, "keywordSearchResultWithQp");
            Intrinsics.checkNotNullParameter(semanticSearchResult, "semanticSearchResult");
            Intrinsics.checkNotNullParameter(sematicSearchScoreMap, "sematicSearchScoreMap");
            Intrinsics.checkNotNullParameter(contextualKeyword, "contextualKeyword");
            return new Result(totalResult, keywordSearchResultWithoutQp, keywordSearchResultWithQp, semanticSearchResult, sematicSearchScoreMap, contextualKeyword);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.totalResult, result.totalResult) && Intrinsics.areEqual(this.keywordSearchResultWithoutQp, result.keywordSearchResultWithoutQp) && Intrinsics.areEqual(this.keywordSearchResultWithQp, result.keywordSearchResultWithQp) && Intrinsics.areEqual(this.semanticSearchResult, result.semanticSearchResult) && Intrinsics.areEqual(this.sematicSearchScoreMap, result.sematicSearchScoreMap) && Intrinsics.areEqual(this.contextualKeyword, result.contextualKeyword);
        }

        @NotNull
        public final String getContextualKeyword() {
            return this.contextualKeyword;
        }

        @NotNull
        public final List<MainListDocumentData> getKeywordSearchResultWithQp() {
            return this.keywordSearchResultWithQp;
        }

        @NotNull
        public final List<MainListDocumentData> getKeywordSearchResultWithoutQp() {
            return this.keywordSearchResultWithoutQp;
        }

        @NotNull
        public final List<MainListDocumentData> getSemanticSearchResult() {
            return this.semanticSearchResult;
        }

        @NotNull
        public final Map<String, Float> getSematicSearchScoreMap() {
            return this.sematicSearchScoreMap;
        }

        @NotNull
        public final List<MainListDocumentData> getTotalResult() {
            return this.totalResult;
        }

        public int hashCode() {
            return this.contextualKeyword.hashCode() + ((this.sematicSearchScoreMap.hashCode() + AbstractC0622a.m1159e(this.semanticSearchResult, AbstractC0622a.m1159e(this.keywordSearchResultWithQp, AbstractC0622a.m1159e(this.keywordSearchResultWithoutQp, this.totalResult.hashCode() * 31, 31), 31), 31)) * 31);
        }

        @NotNull
        public String toString() {
            return "Result(totalResult=" + this.totalResult + ", keywordSearchResultWithoutQp=" + this.keywordSearchResultWithoutQp + ", keywordSearchResultWithQp=" + this.keywordSearchResultWithQp + ", semanticSearchResult=" + this.semanticSearchResult + ", sematicSearchScoreMap=" + this.sematicSearchScoreMap + ", contextualKeyword=" + this.contextualKeyword + ")";
        }
    }

    public SemanticSearchNoteUseCase(@NotNull SemanticSearchRepository semanticSearchRepository, @NotNull MainListDocumentDataRepository documentDataRepository) {
        Intrinsics.checkNotNullParameter(semanticSearchRepository, "semanticSearchRepository");
        Intrinsics.checkNotNullParameter(documentDataRepository, "documentDataRepository");
        this.semanticSearchRepository = semanticSearchRepository;
        this.documentDataRepository = documentDataRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int execute$lambda$0(LinkedHashMap linkedHashMap, MainListDocumentData note1, MainListDocumentData note2) {
        Intrinsics.checkNotNullParameter(note1, "note1");
        Intrinsics.checkNotNullParameter(note2, "note2");
        SemanticSearchRepository.Result.Note note = (SemanticSearchRepository.Result.Note) linkedHashMap.get(note1.getUuid());
        Float fValueOf = note != null ? Float.valueOf(note.getSemanticScore()) : null;
        if (fValueOf == null) {
            return -1;
        }
        SemanticSearchRepository.Result.Note note3 = (SemanticSearchRepository.Result.Note) linkedHashMap.get(note2.getUuid());
        Float fValueOf2 = note3 != null ? Float.valueOf(note3.getSemanticScore()) : null;
        if (fValueOf2 == null) {
            return 1;
        }
        return Float.compare(fValueOf2.floatValue(), fValueOf.floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int execute$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    @NotNull
    public final MainListDocumentDataRepository getDocumentDataRepository() {
        return this.documentDataRepository;
    }

    @NotNull
    public final SemanticSearchRepository getSemanticSearchRepository() {
        return this.semanticSearchRepository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase
    @NotNull
    public Result execute(@NotNull SearchParam param) {
        Intrinsics.checkNotNullParameter(param, "param");
        SearchFilterParam filterParam = param.getFilterParam();
        SemanticSearchRepository semanticSearchRepository = this.semanticSearchRepository;
        String queryText = param.getQueryText();
        Intrinsics.checkNotNullExpressionValue(queryText, "getQueryText(...)");
        long requestedTime = param.getRequestedTime();
        SearchFilterParam toTime = new SearchFilterParam().setContentType(filterParam.getContentType()).setCoverSticker(filterParam.getCoverSticker()).setFromTime(filterParam.getFromTime()).setToTime(filterParam.getToTime());
        Intrinsics.checkNotNullExpressionValue(toTime, "setToTime(...)");
        SemanticSearchRepository.Result resultSearch = semanticSearchRepository.search(queryText, requestedTime, 0, toTime);
        LinkedHashMap<String, SemanticSearchRepository.Result.Note> notes = resultSearch.getNotes();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        List<MainListDocumentData> entities = this.documentDataRepository.getEntities(notes.keySet(), param.getTargetFolderUuid());
        Intrinsics.checkNotNullExpressionValue(entities, "getEntities(...)");
        for (MainListDocumentData mainListDocumentData : entities) {
            SemanticSearchRepository.Result.Note note = notes.get(mainListDocumentData.getUuid());
            if (note != null && note.getResultType() != 0) {
                if (note.getResultType() == 1) {
                    arrayList.add(mainListDocumentData);
                } else if (note.getResultType() == 2) {
                    arrayList2.add(mainListDocumentData);
                } else {
                    map.put(note.getUuid(), Float.valueOf(note.getSemanticScore()));
                }
            }
        }
        entities.removeAll(arrayList);
        entities.removeAll(arrayList2);
        CollectionsKt.sortWith(entities, new C8878a(new C11561g(notes, 1), 4));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        arrayList3.addAll(entities);
        return new Result(arrayList3, arrayList, arrayList2, entities, map, resultSearch.getContextualKeyword());
    }
}
