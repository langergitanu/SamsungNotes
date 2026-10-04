package com.samsung.android.support.senl.p148nt.data.database.core.query.search;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.search.SemanticSearchRepository;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FinderSearchQuery {
    private static final String ACTION_VIEW_FINDER = "'com.samsung.android.app.notes.action.VIEW_FROM_FINDER'";
    private static final String FINDER_DATA_SCHEME = "'notes_finder://'";
    public static final String RESULT_ORDER = "RESULT_ORDER";
    public static final String SCORE_ORDER = "SCORE_ORDER";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Param extends AbstractC12991c {

        @NonNull
        private final List<String> keywords;
        private final int limit;

        @NonNull
        private final String modifiedTimeCondition;

        @NonNull
        private final LinkedHashMap<String, SemanticSearchRepository.Result.Note> semanticSearchResult;

        public Param(@NonNull List<String> list, int i, @NonNull String str, @NonNull LinkedHashMap<String, SemanticSearchRepository.Result.Note> linkedHashMap) {
            this.keywords = list;
            this.limit = i;
            this.modifiedTimeCondition = str;
            this.semanticSearchResult = linkedHashMap;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Param)) {
                return false;
            }
            Param param = (Param) obj;
            return this.limit == param.limit && Objects.equals(this.keywords, param.keywords) && Objects.equals(this.modifiedTimeCondition, param.modifiedTimeCondition) && Objects.equals(this.semanticSearchResult, param.semanticSearchResult);
        }

        public final int hashCode() {
            int i = this.limit;
            List<String> list = this.keywords;
            String str = this.modifiedTimeCondition;
            LinkedHashMap<String, SemanticSearchRepository.Result.Note> linkedHashMap = this.semanticSearchResult;
            return Objects.hashCode(linkedHashMap) + ((Objects.hashCode(str) + ((Objects.hashCode(list) + (i * 31)) * 31)) * 31);
        }

        @NonNull
        public List<String> keywords() {
            return this.keywords;
        }

        public int limit() {
            return this.limit;
        }

        @NonNull
        public String modifiedTimeCondition() {
            return this.modifiedTimeCondition;
        }

        @NonNull
        public LinkedHashMap<String, SemanticSearchRepository.Result.Note> semanticSearchResult() {
            return this.semanticSearchResult;
        }

        public final String toString() {
            Object[] objArr = {this.keywords, Integer.valueOf(this.limit), this.modifiedTimeCondition, this.semanticSearchResult};
            String[] strArrSplit = "keywords;limit;modifiedTimeCondition;semanticSearchResult".length() == 0 ? new String[0] : "keywords;limit;modifiedTimeCondition;semanticSearchResult".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(Param.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private String createKeywordSearchCondition(@NonNull List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(getLikeClauseForSearch(it.next()));
            sb.append(SQLKeyword.AND);
        }
        return " ( " + sb.substring(0, sb.lastIndexOf(SQLKeyword.AND)) + " ) ";
    }

    private String createSelectClause(@NonNull String str, int i, @NonNull String str2) {
        return new NotesSQLBuilder().append("sdoc._id , ").mo12419as("sdoc.title", NotesSearchManager.FINDER_SEARCH_TITLE).mo12419as(str, NotesSearchManager.FINDER_SEARCH_BODY_CONTENT).mo12419as(getIconField(), NotesSearchManager.FINDER_SEARCH_THUMBNAIL).mo12419as("sdoc.lastModifiedAt", NotesSearchManager.get_SUGGEST_COLUMN_TEXT_3()).mo12419as(ACTION_VIEW_FINDER, "suggest_intent_action").mo12419as(FINDER_DATA_SCHEME, "suggest_intent_data").mo12419as("sdoc.UUID", "suggest_intent_extra_data").mo12419as("CASE WHEN sdoc.vrUUID='' THEN NULL ELSE 1 END", NotesSearchManager.get_SUGGEST_COLUMN_EXTRA()).mo12419as(AbstractC0541b.m756B("'" + ExternalDataConstants.BASE_URI_NOTE + "/'||", "sdoc._id"), NotesSearchManager.get_SUGGEST_COLUMN_URI()).mo12419as("'text/plain'", NotesSearchManager.get_SUGGEST_COLUMN_MIME_TYPE()).mo12419as(i + "", RESULT_ORDER).asEnd(str2, SCORE_ORDER).build();
    }

    private String getFinderBodyContent(@NonNull List<String> list) {
        StringBuilder sb = new StringBuilder("CASE WHEN sdoc.isLock = 0 THEN (CASE WHEN ");
        sb.append(getLikeClauseForFinderBody(list, "stroke.text"));
        sb.append(" THEN stroke.text WHEN ");
        sb.append(getLikeClauseForFinderBody(list, "stt_content.content"));
        sb.append(" THEN stt_content.content WHEN ");
        return AbstractC0622a.m1170p(getLikeClauseForFinderBody(list, "tag_list.normalizeName"), " THEN tag_list.normalizeName ELSE CAST(sdoc.content AS TEXT) END) ELSE ''  END ", sb);
    }

    private String getIconField() {
        String str = "'" + ExternalDataConstants.URI_FINDER_THUMBNAIL + "/'";
        return new NotesSQLBuilder().caseWhen(QueryConstants.LOCKED_CONDITION).then(str).elseEnd(str + "||sdoc.UUID").build();
    }

    private String getInternalSearchQuery(@NonNull List<String> list, @NonNull String str, int i, @NonNull Collection<String> collection) {
        return new NotesSQLBuilder().select(createSelectClause(getFinderBodyContent(list), 0, "0.0")).from("sdoc").leftJoin(DBSchema.TextSearch.TABLE_NAME).mo12421on("sdoc.UUID = text_search.sdocUUID").leftJoin("stroke").mo12421on("sdoc.UUID = stroke.sdocUUID").leftJoin("tag_list").mo12421on("sdoc.UUID = tag_list.docUUID").leftJoin("content").mo12421on("sdoc.UUID = content.sdocUUID").leftJoin(DBSchema.SttContent.TABLE_NAME).mo12421on("sdoc.UUID = stt_content.documentUUID").leftJoin(DBSchema.MappedDocument.TABLE_NAME).mo12421on("sdoc.UUID = mapped_document.UUID").where("sdoc.UUID").mo12420in(getSubQueryForPerformance(list, i, collection)).and(QueryConstants.USED_DOCUMENT_CONDITION).and("mapped_document.mappedUUID IS NULL").and(str).and(createKeywordSearchCondition(list)).groupBy("sdoc.UUID").build();
    }

    private String getLikeClauseForFinderBody(@NonNull List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(QueryUtils.getLikeClauseColumn(str) + " LIKE '%" + it.next() + "%' ESCAPE '�'");
            sb.append(SQLKeyword.AND);
        }
        return "(" + sb.substring(0, sb.lastIndexOf(SQLKeyword.AND)) + ")";
    }

    private String getLikeClauseForSearch(String str) {
        String strM773o = AbstractC0541b.m773o("'%", str, "%'");
        return new NotesSQLBuilder().setNoSpacePartialMatching(QueryUtils.isNoSpacePartialMatchingSupported()).caseWhen(QueryConstants.UNLOCKED_CONDITION).then().append("(").replace("sdoc.title", "' '", "''").like(strM773o).escape(QueryConstants.ESCAPE_CHARACTER_STRING).m12422or().replace("text_search.strippedContent", "' '", "''").like(strM773o).escape(QueryConstants.ESCAPE_CHARACTER_STRING).m12422or().replace("stroke.text", "' '", "''").like(strM773o).escape(QueryConstants.ESCAPE_CHARACTER_STRING).m12422or().replace("stt_content.content", "' '", "''").like(strM773o).escape(QueryConstants.ESCAPE_CHARACTER_STRING).m12422or().replace("tag_list.normalizeName", "' '", "''").like(strM773o).escape(QueryConstants.ESCAPE_CHARACTER_STRING).append(")").else_().append("(").replace("sdoc.title", "' '", "''").like(strM773o).escape(QueryConstants.ESCAPE_CHARACTER_STRING).append(" ) ").end().build();
    }

    private String getSemanticScoreOrder(@NonNull LinkedHashMap<String, SemanticSearchRepository.Result.Note> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, SemanticSearchRepository.Result.Note> entry : linkedHashMap.entrySet()) {
            sb.append(" WHEN sdoc.UUID = '");
            sb.append(entry.getKey());
            sb.append("' THEN ");
            sb.append(entry.getValue().getSemanticScore());
        }
        StringBuilder sb2 = new StringBuilder("( CASE ");
        sb.append(" ELSE 0.0 END ");
        sb2.append((Object) sb);
        sb2.append(")");
        return sb2.toString();
    }

    private String getSemanticSearchQuery(@NonNull LinkedHashMap<String, SemanticSearchRepository.Result.Note> linkedHashMap) {
        if (linkedHashMap.isEmpty()) {
            return "";
        }
        return new NotesSQLBuilder().select(createSelectClause("SUBSTR(CAST(text_search.strippedContent AS TEXT), 1, 1000)", 1, getSemanticScoreOrder(linkedHashMap))).from("sdoc").leftJoin(DBSchema.TextSearch.TABLE_NAME).mo12421on("sdoc.UUID = text_search.sdocUUID").where("sdoc.UUID").mo12420in(QueryUtils.getCommaSeparatedString(linkedHashMap.keySet())).and(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).build() + SQLKeyword.UNION_ALL;
    }

    private String getSubQueryForPerformance(@NonNull List<String> list, int i, @NonNull Collection<String> collection) {
        return new NotesSQLBuilder().select("UUID").from("sdoc").where(QueryConstants.USED_DOCUMENT_CONDITION).and("sdoc.UUID").notIn(QueryUtils.getCommaSeparatedString(collection)).and("sdoc.UUID").notIn(new NotesSQLBuilder().select("mapped_document.UUID").from(DBSchema.MappedDocument.TABLE_NAME).build()).and("sdoc.UUID").mo12420in(new NotesSQLBuilder().select("doc.UUID").from("sdoc as doc").where(QueryConstants.USED_DOCUMENT_CONDITION.replace("sdoc.", "doc.")).and(getLikeClauseForFinderBody(list, "doc.title")).union().select("text_search.sdocUUID").from(DBSchema.TextSearch.TABLE_NAME).leftJoin("sdoc").mo12421on("text_search.sdocUUID = sdoc.UUID").where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(getLikeClauseForFinderBody(list, "text_search.strippedContent")).union().select("tag_list.docUUID").from("tag_list").innerJoin("sdoc").mo12421on("tag_list.docUUID = sdoc.UUID").where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(getLikeClauseForFinderBody(list, "tag_list.normalizeName")).union().select("stroke.sdocUUID").from("stroke").innerJoin("sdoc").mo12421on("stroke.sdocUUID = sdoc.UUID").where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(getLikeClauseForFinderBody(list, "stroke.text")).union().select("stt_content.documentUUID").from(DBSchema.SttContent.TABLE_NAME).innerJoin("sdoc").mo12421on("stt_content.documentUUID = sdoc.UUID").where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and("stt_content.type = 0").and(getLikeClauseForFinderBody(list, "stt_content.content")).build()).orderBy("sdoc.lastModifiedAt", SQLKeyword.SortingOrder.DESC).limit(i).build();
    }

    public String getQuery(@NonNull Param param) {
        return new NotesSQLBuilder().select("*").from("(" + getSemanticSearchQuery(param.semanticSearchResult) + getInternalSearchQuery(param.keywords, param.modifiedTimeCondition, param.limit, param.semanticSearchResult.keySet()) + ")").orderBy(RESULT_ORDER, SQLKeyword.SortingOrder.DESC).nextOrder(SCORE_ORDER, SQLKeyword.SortingOrder.DESC).nextOrder(NotesSearchManager.get_SUGGEST_COLUMN_TEXT_3(), SQLKeyword.SortingOrder.DESC).limit(param.limit).delimiter().build();
    }
}
