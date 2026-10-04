package com.samsung.android.support.senl.p148nt.data.repository.search;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.mobileservice.profile.Privacy;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupInvitationContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository;", "", "search", "Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository$Result;", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", GroupInvitationContract.Invitation.REQUESTED_TIME, "", "limit", "", "filterParam", "Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SearchFilterParam;", "Result", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface SemanticSearchRepository {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0017B3\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ%\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J9\u0010\u0010\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository$Result;", "", Privacy.KEY_NOTES, "Ljava/util/LinkedHashMap;", "", "Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository$Result$Note;", "Lkotlin/collections/LinkedHashMap;", "contextualKeyword", "<init>", "(Ljava/util/LinkedHashMap;Ljava/lang/String;)V", "getNotes", "()Ljava/util/LinkedHashMap;", "getContextualKeyword", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Note", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class Result {

        @NotNull
        private final String contextualKeyword;

        @NotNull
        private final LinkedHashMap<String, Note> notes;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/data/repository/search/SemanticSearchRepository$Result$Note;", "", "uuid", "", "resultType", "", "semanticScore", "", "<init>", "(Ljava/lang/String;IF)V", "getUuid", "()Ljava/lang/String;", "getResultType", "()I", "getSemanticScore", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ntData_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final /* data */ class Note {
            private final int resultType;
            private final float semanticScore;

            @NotNull
            private final String uuid;

            public Note(@NotNull String uuid, @SearchConstants.SearchEngineResultType int i, float f) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                this.uuid = uuid;
                this.resultType = i;
                this.semanticScore = f;
            }

            public static /* synthetic */ Note copy$default(Note note, String str, int i, float f, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = note.uuid;
                }
                if ((i2 & 2) != 0) {
                    i = note.resultType;
                }
                if ((i2 & 4) != 0) {
                    f = note.semanticScore;
                }
                return note.copy(str, i, f);
            }

            @NotNull
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUuid() {
                return this.uuid;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getResultType() {
                return this.resultType;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final float getSemanticScore() {
                return this.semanticScore;
            }

            @NotNull
            public final Note copy(@NotNull String uuid, @SearchConstants.SearchEngineResultType int resultType, float semanticScore) {
                Intrinsics.checkNotNullParameter(uuid, "uuid");
                return new Note(uuid, resultType, semanticScore);
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Note)) {
                    return false;
                }
                Note note = (Note) other;
                return Intrinsics.areEqual(this.uuid, note.uuid) && this.resultType == note.resultType && Float.compare(this.semanticScore, note.semanticScore) == 0;
            }

            public final int getResultType() {
                return this.resultType;
            }

            public final float getSemanticScore() {
                return this.semanticScore;
            }

            @NotNull
            public final String getUuid() {
                return this.uuid;
            }

            public int hashCode() {
                return Float.hashCode(this.semanticScore) + AbstractC0622a.m1157c(this.resultType, this.uuid.hashCode() * 31, 31);
            }

            @NotNull
            public String toString() {
                String str = this.uuid;
                int i = this.resultType;
                return AbstractC1038a.m1217r(AbstractC0541b.m780v("Note(uuid=", i, str, ", resultType=", ", semanticScore="), ")", this.semanticScore);
            }
        }

        public Result(@NotNull LinkedHashMap<String, Note> notes, @NotNull String contextualKeyword) {
            Intrinsics.checkNotNullParameter(notes, "notes");
            Intrinsics.checkNotNullParameter(contextualKeyword, "contextualKeyword");
            this.notes = notes;
            this.contextualKeyword = contextualKeyword;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Result copy$default(Result result, LinkedHashMap linkedHashMap, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                linkedHashMap = result.notes;
            }
            if ((i & 2) != 0) {
                str = result.contextualKeyword;
            }
            return result.copy(linkedHashMap, str);
        }

        @NotNull
        public final LinkedHashMap<String, Note> component1() {
            return this.notes;
        }

        @NotNull
        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getContextualKeyword() {
            return this.contextualKeyword;
        }

        @NotNull
        public final Result copy(@NotNull LinkedHashMap<String, Note> notes, @NotNull String contextualKeyword) {
            Intrinsics.checkNotNullParameter(notes, "notes");
            Intrinsics.checkNotNullParameter(contextualKeyword, "contextualKeyword");
            return new Result(notes, contextualKeyword);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return Intrinsics.areEqual(this.notes, result.notes) && Intrinsics.areEqual(this.contextualKeyword, result.contextualKeyword);
        }

        @NotNull
        public final String getContextualKeyword() {
            return this.contextualKeyword;
        }

        @NotNull
        public final LinkedHashMap<String, Note> getNotes() {
            return this.notes;
        }

        public int hashCode() {
            return this.contextualKeyword.hashCode() + (this.notes.hashCode() * 31);
        }

        @NotNull
        public String toString() {
            return "Result(notes=" + this.notes + ", contextualKeyword=" + this.contextualKeyword + ")";
        }
    }

    @NotNull
    Result search(@NotNull String keyword, long requestedTime, int limit, @NotNull SearchFilterParam filterParam);
}
