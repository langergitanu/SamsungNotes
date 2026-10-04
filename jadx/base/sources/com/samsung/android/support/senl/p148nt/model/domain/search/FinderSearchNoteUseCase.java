package com.samsung.android.support.senl.p148nt.model.domain.search;

import android.database.Cursor;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.search.FinderSearchQuery;
import com.samsung.android.support.senl.p148nt.data.repository.search.NotesSearchRepository;
import com.samsung.android.support.senl.p148nt.data.repository.search.SemanticSearchRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00112\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0002\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/search/FinderSearchNoteUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/common/BaseUseCase;", "Lcom/samsung/android/support/senl/nt/model/domain/search/FinderSearchNoteUseCase$Param;", "Landroid/database/Cursor;", "repository", "Lcom/samsung/android/support/senl/nt/data/repository/search/NotesSearchRepository;", "<init>", "(Lcom/samsung/android/support/senl/nt/data/repository/search/NotesSearchRepository;)V", "getRepository", "()Lcom/samsung/android/support/senl/nt/data/repository/search/NotesSearchRepository;", "execute", "param", "getKeywords", "", "", "query", "Param", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nFinderSearchNoteUseCase.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FinderSearchNoteUseCase.kt\ncom/samsung/android/support/senl/nt/model/domain/search/FinderSearchNoteUseCase\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n774#2:63\n865#2,2:64\n1869#2:66\n1870#2:68\n1#3:67\n*S KotlinDebug\n*F\n+ 1 FinderSearchNoteUseCase.kt\ncom/samsung/android/support/senl/nt/model/domain/search/FinderSearchNoteUseCase\n*L\n46#1:63\n46#1:64,2\n47#1:66\n47#1:68\n*E\n"})
public final class FinderSearchNoteUseCase extends BaseUseCase<Param, Cursor> {
    private static final String TAG = ModelLogger.createTag("FinderSearchNoteUseCase");

    @NotNull
    private final NotesSearchRepository repository;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/domain/search/FinderSearchNoteUseCase$Param;", "", "query", "", "limit", "", "modifiedTimeCondition", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "getLimit", "()I", "getModifiedTimeCondition", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Param {
        private final int limit;

        @NotNull
        private final String modifiedTimeCondition;

        @NotNull
        private final String query;

        public Param(@NotNull String query, int i, @NotNull String modifiedTimeCondition) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(modifiedTimeCondition, "modifiedTimeCondition");
            this.query = query;
            this.limit = i;
            this.modifiedTimeCondition = modifiedTimeCondition;
        }

        public static /* synthetic */ Param copy$default(Param param, String str, int i, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = param.query;
            }
            if ((i2 & 2) != 0) {
                i = param.limit;
            }
            if ((i2 & 4) != 0) {
                str2 = param.modifiedTimeCondition;
            }
            return param.copy(str, i, str2);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getLimit() {
            return this.limit;
        }

        @NotNull
        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getModifiedTimeCondition() {
            return this.modifiedTimeCondition;
        }

        @NotNull
        public final Param copy(@NotNull String query, int limit, @NotNull String modifiedTimeCondition) {
            Intrinsics.checkNotNullParameter(query, "query");
            Intrinsics.checkNotNullParameter(modifiedTimeCondition, "modifiedTimeCondition");
            return new Param(query, limit, modifiedTimeCondition);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            return Intrinsics.areEqual(this.query, param.query) && this.limit == param.limit && Intrinsics.areEqual(this.modifiedTimeCondition, param.modifiedTimeCondition);
        }

        public final int getLimit() {
            return this.limit;
        }

        @NotNull
        public final String getModifiedTimeCondition() {
            return this.modifiedTimeCondition;
        }

        @NotNull
        public final String getQuery() {
            return this.query;
        }

        public int hashCode() {
            return this.modifiedTimeCondition.hashCode() + AbstractC0622a.m1157c(this.limit, this.query.hashCode() * 31, 31);
        }

        @NotNull
        public String toString() {
            String str = this.query;
            return AbstractC0622a.m1170p(this.modifiedTimeCondition, ")", AbstractC0541b.m780v("Param(query=", this.limit, str, ", limit=", ", modifiedTimeCondition="));
        }
    }

    public FinderSearchNoteUseCase(@NotNull NotesSearchRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    private final List<String> getKeywords(String query) {
        ArrayList arrayList = new ArrayList();
        String string = StringsKt.trim((CharSequence) query).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String strReplaceInvalidCharacters = QueryUtils.replaceInvalidCharacters(lowerCase);
        Intrinsics.checkNotNull(strReplaceInvalidCharacters);
        List listM13999t = AbstractC12991c.m13999t(0, " ", strReplaceInvalidCharacters);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : listM13999t) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String strReplaceWildcardChar = QueryUtils.replaceWildcardChar((String) it.next(), false);
            String strRemoveHashSymbol = QueryUtils.removeHashSymbol(strReplaceWildcardChar);
            Intrinsics.checkNotNullExpressionValue(strRemoveHashSymbol, "removeHashSymbol(...)");
            if (strRemoveHashSymbol.length() != 0) {
                strReplaceWildcardChar = strRemoveHashSymbol;
            }
            Intrinsics.checkNotNullExpressionValue(strReplaceWildcardChar, "ifEmpty(...)");
            arrayList.add(strReplaceWildcardChar);
        }
        DataLogger.m12307i(TAG, "getKeywords, size: " + arrayList.size());
        return arrayList;
    }

    @NotNull
    public final NotesSearchRepository getRepository() {
        return this.repository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.domain.common.BaseUseCase
    @Nullable
    public Cursor execute(@NotNull Param param) {
        Intrinsics.checkNotNullParameter(param, "param");
        List<String> keywords = getKeywords(param.getQuery());
        if (keywords.isEmpty()) {
            return null;
        }
        boolean zIsSearchEngineConnected = Features.isSearchEngineConnected();
        SemanticSearchRepository.Result resultSearch = zIsSearchEngineConnected ? this.repository.getSemanticSearchRepository().search(param.getQuery(), System.currentTimeMillis(), 10, new SearchFilterParam()) : new SemanticSearchRepository.Result(new LinkedHashMap(), "");
        return this.repository.query(new FinderSearchQuery().getQuery(new FinderSearchQuery.Param(keywords, zIsSearchEngineConnected ? resultSearch.getNotes().size() + 10 : param.getLimit(), param.getModifiedTimeCondition(), resultSearch.getNotes())));
    }
}
