package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.search;

import androidx.collection.AbstractC0622a;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultNote;", "", "searchType", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultType;", "searchIndex", "", "semanticRanking", "contextualKeyword", "", "", "<init>", "(Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultType;IILjava/util/Set;)V", "getSearchType", "()Lcom/samsung/android/support/senl/nt/app/main/noteslist/presenter/search/SearchResultType;", "getSearchIndex", "()I", "getSemanticRanking", "getContextualKeyword", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final /* data */ class SearchResultNote {

    @NotNull
    private final Set<String> contextualKeyword;
    private final int searchIndex;

    @NotNull
    private final SearchResultType searchType;
    private final int semanticRanking;

    public SearchResultNote() {
        this(null, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchResultNote copy$default(SearchResultNote searchResultNote, SearchResultType searchResultType, int i, int i2, Set set, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            searchResultType = searchResultNote.searchType;
        }
        if ((i4 & 2) != 0) {
            i = searchResultNote.searchIndex;
        }
        if ((i4 & 4) != 0) {
            i2 = searchResultNote.semanticRanking;
        }
        if ((i4 & 8) != 0) {
            set = searchResultNote.contextualKeyword;
        }
        return searchResultNote.copy(searchResultType, i, i2, set);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final SearchResultType getSearchType() {
        return this.searchType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSearchIndex() {
        return this.searchIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSemanticRanking() {
        return this.semanticRanking;
    }

    @NotNull
    public final Set<String> component4() {
        return this.contextualKeyword;
    }

    @NotNull
    public final SearchResultNote copy(@NotNull SearchResultType searchType, int searchIndex, int semanticRanking, @NotNull Set<String> contextualKeyword) {
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        Intrinsics.checkNotNullParameter(contextualKeyword, "contextualKeyword");
        return new SearchResultNote(searchType, searchIndex, semanticRanking, contextualKeyword);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchResultNote)) {
            return false;
        }
        SearchResultNote searchResultNote = (SearchResultNote) other;
        return this.searchType == searchResultNote.searchType && this.searchIndex == searchResultNote.searchIndex && this.semanticRanking == searchResultNote.semanticRanking && Intrinsics.areEqual(this.contextualKeyword, searchResultNote.contextualKeyword);
    }

    @NotNull
    public final Set<String> getContextualKeyword() {
        return this.contextualKeyword;
    }

    public final int getSearchIndex() {
        return this.searchIndex;
    }

    @NotNull
    public final SearchResultType getSearchType() {
        return this.searchType;
    }

    public final int getSemanticRanking() {
        return this.semanticRanking;
    }

    public int hashCode() {
        return this.contextualKeyword.hashCode() + AbstractC0622a.m1157c(this.semanticRanking, AbstractC0622a.m1157c(this.searchIndex, this.searchType.hashCode() * 31, 31), 31);
    }

    @NotNull
    public String toString() {
        return "SearchResultNote(searchType=" + this.searchType + ", searchIndex=" + this.searchIndex + ", semanticRanking=" + this.semanticRanking + ", contextualKeyword=" + this.contextualKeyword + ")";
    }

    public SearchResultNote(@NotNull SearchResultType searchType, int i, int i2, @NotNull Set<String> contextualKeyword) {
        Intrinsics.checkNotNullParameter(searchType, "searchType");
        Intrinsics.checkNotNullParameter(contextualKeyword, "contextualKeyword");
        this.searchType = searchType;
        this.searchIndex = i;
        this.semanticRanking = i2;
        this.contextualKeyword = contextualKeyword;
    }

    public /* synthetic */ SearchResultNote(SearchResultType searchResultType, int i, int i2, Set set, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? SearchResultType.NONE : searchResultType, (i4 & 2) != 0 ? -1 : i, (i4 & 4) != 0 ? -1 : i2, (i4 & 8) != 0 ? SetsKt.emptySet() : set);
    }
}
