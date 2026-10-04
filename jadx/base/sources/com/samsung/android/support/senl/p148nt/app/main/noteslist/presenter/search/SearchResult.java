package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import androidx.collection.AbstractC0622a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResult;", "", "dbCount", "", "keywordCount", "semanticCount", "searchResultMap", "", "", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultNote;", "<init>", "(IIILjava/util/Map;)V", "getDbCount", "()I", "getKeywordCount", "getSemanticCount", "getSearchResultMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class SearchResult {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final int dbCount;
    private final int keywordCount;

    @NotNull
    private final Map<String, SearchResultNote> searchResultMap;
    private final int semanticCount;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J~\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResult$Companion;", "", "<init>", "()V", Constants.MessagePayloadKeys.FROM, "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResult;", "totalNotes", "", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "dbNotes", "keywordNotes", "semanticNotes", "semanticScores", "", "", "", "contextualKeywordNotes", "", "keywordNotesWithoutQp", "keywordNotesWithQp", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSearchResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchResult.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResult$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,106:1\n1573#2:107\n1604#2,4:108\n1193#2,2:112\n1267#2,4:114\n1193#2,2:118\n1267#2,4:120\n1193#2,2:124\n1267#2,4:126\n1193#2,2:130\n1267#2,4:132\n*S KotlinDebug\n*F\n+ 1 SearchResult.kt\ncom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResult$Companion\n*L\n33#1:107\n33#1:108,4\n35#1:112,2\n35#1:114,4\n42#1:118,2\n42#1:120,4\n50#1:124,2\n50#1:126,4\n58#1:130,2\n58#1:132,4\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SearchResult from(@NotNull List<? extends MainListDocumentData> totalNotes, @NotNull List<? extends MainListDocumentData> dbNotes, @NotNull List<? extends MainListDocumentData> keywordNotes, @NotNull List<? extends MainListDocumentData> semanticNotes, @NotNull Map<String, Float> semanticScores, @NotNull Set<String> contextualKeywordNotes, @NotNull List<? extends MainListDocumentData> keywordNotesWithoutQp, @NotNull List<? extends MainListDocumentData> keywordNotesWithQp) {
            Intrinsics.checkNotNullParameter(totalNotes, "totalNotes");
            Intrinsics.checkNotNullParameter(dbNotes, "dbNotes");
            Intrinsics.checkNotNullParameter(keywordNotes, "keywordNotes");
            Intrinsics.checkNotNullParameter(semanticNotes, "semanticNotes");
            Intrinsics.checkNotNullParameter(semanticScores, "semanticScores");
            Set<String> contextualKeywordNotes2 = contextualKeywordNotes;
            Intrinsics.checkNotNullParameter(contextualKeywordNotes2, "contextualKeywordNotes");
            Intrinsics.checkNotNullParameter(keywordNotesWithoutQp, "keywordNotesWithoutQp");
            Intrinsics.checkNotNullParameter(keywordNotesWithQp, "keywordNotesWithQp");
            SearchResultKt.printSearchResultLog(keywordNotes, semanticNotes, semanticScores, contextualKeywordNotes);
            List<? extends MainListDocumentData> list = totalNotes;
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList.add(TuplesKt.m13893to(((MainListDocumentData) obj).getUuid(), Integer.valueOf(i2)));
                i = i2;
            }
            Map map = MapsKt.toMap(arrayList);
            List<? extends MainListDocumentData> list2 = dbNotes;
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(list2)), 16));
            Iterator<T> it = list2.iterator();
            while (true) {
                int iIntValue = -1;
                if (!it.hasNext()) {
                    break;
                }
                MainListDocumentData mainListDocumentData = (MainListDocumentData) it.next();
                String uuid = mainListDocumentData.getUuid();
                SearchResultType searchResultType = SearchResultType.f6227DB;
                Integer num = (Integer) map.get(mainListDocumentData.getUuid());
                if (num != null) {
                    iIntValue = num.intValue();
                }
                Pair pairM13893to = TuplesKt.m13893to(uuid, new SearchResultNote(searchResultType, iIntValue, 0, null, 12, null));
                linkedHashMap.put(pairM13893to.getFirst(), pairM13893to.getSecond());
            }
            List<? extends MainListDocumentData> list3 = keywordNotesWithoutQp;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(list3)), 16));
            for (MainListDocumentData mainListDocumentData2 : list3) {
                String uuid2 = mainListDocumentData2.getUuid();
                LinkedHashMap linkedHashMap3 = linkedHashMap2;
                SearchResultType searchResultType2 = SearchResultType.KEYWORD;
                Integer num2 = (Integer) map.get(mainListDocumentData2.getUuid());
                Pair pairM13893to2 = TuplesKt.m13893to(uuid2, new SearchResultNote(searchResultType2, num2 != null ? num2.intValue() : -1, 0, contextualKeywordNotes2, 4, null));
                linkedHashMap3.put(pairM13893to2.getFirst(), pairM13893to2.getSecond());
                contextualKeywordNotes2 = contextualKeywordNotes;
                linkedHashMap2 = linkedHashMap3;
            }
            LinkedHashMap linkedHashMap4 = linkedHashMap2;
            List<? extends MainListDocumentData> list4 = keywordNotesWithQp;
            LinkedHashMap linkedHashMap5 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(list4)), 16));
            for (MainListDocumentData mainListDocumentData3 : list4) {
                String uuid3 = mainListDocumentData3.getUuid();
                SearchResultType searchResultType3 = SearchResultType.KEYWORD_ETC;
                Integer num3 = (Integer) map.get(mainListDocumentData3.getUuid());
                Pair pairM13893to3 = TuplesKt.m13893to(uuid3, new SearchResultNote(searchResultType3, num3 != null ? num3.intValue() : -1, 0, contextualKeywordNotes, 4, null));
                linkedHashMap5.put(pairM13893to3.getFirst(), pairM13893to3.getSecond());
            }
            Iterable<IndexedValue> iterableWithIndex = CollectionsKt.withIndex(semanticNotes);
            LinkedHashMap linkedHashMap6 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.m13952k(iterableWithIndex)), 16));
            for (IndexedValue indexedValue : iterableWithIndex) {
                int index = indexedValue.getIndex();
                MainListDocumentData mainListDocumentData4 = (MainListDocumentData) indexedValue.component2();
                String uuid4 = mainListDocumentData4.getUuid();
                SearchResultType searchResultType4 = SearchResultType.SEMANTIC;
                Integer num4 = (Integer) map.get(mainListDocumentData4.getUuid());
                Pair pairM13893to4 = TuplesKt.m13893to(uuid4, new SearchResultNote(searchResultType4, num4 != null ? num4.intValue() : -1, index, null, 8, null));
                linkedHashMap6.put(pairM13893to4.getFirst(), pairM13893to4.getSecond());
            }
            return new SearchResult(dbNotes.size(), keywordNotes.size(), semanticNotes.size(), MapsKt.plus(MapsKt.plus(MapsKt.plus(linkedHashMap, linkedHashMap4), linkedHashMap5), linkedHashMap6));
        }

        private Companion() {
        }
    }

    public SearchResult(int i, int i2, int i4, @NotNull Map<String, SearchResultNote> searchResultMap) {
        Intrinsics.checkNotNullParameter(searchResultMap, "searchResultMap");
        this.dbCount = i;
        this.keywordCount = i2;
        this.semanticCount = i4;
        this.searchResultMap = searchResultMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResult copy$default(SearchResult searchResult, int i, int i2, int i4, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = searchResult.dbCount;
        }
        if ((i5 & 2) != 0) {
            i2 = searchResult.keywordCount;
        }
        if ((i5 & 4) != 0) {
            i4 = searchResult.semanticCount;
        }
        if ((i5 & 8) != 0) {
            map = searchResult.searchResultMap;
        }
        return searchResult.copy(i, i2, i4, map);
    }

    @JvmStatic
    @NotNull
    public static final SearchResult from(@NotNull List<? extends MainListDocumentData> list, @NotNull List<? extends MainListDocumentData> list2, @NotNull List<? extends MainListDocumentData> list3, @NotNull List<? extends MainListDocumentData> list4, @NotNull Map<String, Float> map, @NotNull Set<String> set, @NotNull List<? extends MainListDocumentData> list5, @NotNull List<? extends MainListDocumentData> list6) {
        return INSTANCE.from(list, list2, list3, list4, map, set, list5, list6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDbCount() {
        return this.dbCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getKeywordCount() {
        return this.keywordCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSemanticCount() {
        return this.semanticCount;
    }

    @NotNull
    public final Map<String, SearchResultNote> component4() {
        return this.searchResultMap;
    }

    @NotNull
    public final SearchResult copy(int dbCount, int keywordCount, int semanticCount, @NotNull Map<String, SearchResultNote> searchResultMap) {
        Intrinsics.checkNotNullParameter(searchResultMap, "searchResultMap");
        return new SearchResult(dbCount, keywordCount, semanticCount, searchResultMap);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResult)) {
            return false;
        }
        SearchResult searchResult = (SearchResult) other;
        return this.dbCount == searchResult.dbCount && this.keywordCount == searchResult.keywordCount && this.semanticCount == searchResult.semanticCount && Intrinsics.areEqual(this.searchResultMap, searchResult.searchResultMap);
    }

    public final int getDbCount() {
        return this.dbCount;
    }

    public final int getKeywordCount() {
        return this.keywordCount;
    }

    @NotNull
    public final Map<String, SearchResultNote> getSearchResultMap() {
        return this.searchResultMap;
    }

    public final int getSemanticCount() {
        return this.semanticCount;
    }

    public int hashCode() {
        return this.searchResultMap.hashCode() + AbstractC0622a.m1157c(this.semanticCount, AbstractC0622a.m1157c(this.keywordCount, Integer.hashCode(this.dbCount) * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        int i = this.dbCount;
        int i2 = this.keywordCount;
        int i4 = this.semanticCount;
        Map<String, SearchResultNote> map = this.searchResultMap;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "SearchResult(dbCount=", ", keywordCount=", ", semanticCount=");
        sbM1173s.append(i4);
        sbM1173s.append(", searchResultMap=");
        sbM1173s.append(map);
        sbM1173s.append(")");
        return sbM1173s.toString();
    }
}
