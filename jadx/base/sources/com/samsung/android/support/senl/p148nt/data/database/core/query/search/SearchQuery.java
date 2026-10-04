package com.samsung.android.support.senl.p148nt.data.database.core.query.search;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SearchWord;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.FolderSearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchQuery {
    static final String COEDIT_SPACE = "sdoc.categoryUUID = 'coedit:///'";
    static final String DEFAULT = "sdoc.mdeSpaceId = ''";
    private final SearchParam mParam;
    private final List<SearchWord> mWords;

    public SearchQuery(SearchParam searchParam, List<SearchWord> list) {
        this.mParam = searchParam;
        this.mWords = list;
    }

    private String getContentFilterQuery() {
        return new SearchFilterQuery().getContentFilter(this.mParam.getFilterParam().getContentType());
    }

    private static String getContentSearchQuery(List<SearchWord> list) {
        return new NotesSQLBuilder().select("text_search.sdocUUID").from(DBSchema.TextSearch.TABLE_NAME).leftJoin("sdoc").mo12421on("sdoc.UUID = text_search.sdocUUID").where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(QueryUtils.getLikeSelection("text_search.strippedContent", list)).build();
    }

    private String getCoverStickerFilterQuery() {
        String coverSticker = this.mParam.getFilterParam().getCoverSticker();
        if (coverSticker.isEmpty() || CoverStickerConstants.Category.NONE.UUID.equals(coverSticker)) {
            return "";
        }
        return AbstractC0622a.m1170p(new NotesSQLBuilder().select("documentUUID").from("document_cover").where("document_cover.templateUUID").mo12420in(SearchUtils.getCoverTemplateUuidsWithSummaryAndCategoryQuery()).and("document_cover.categoryUUID = '" + coverSticker + "'").and("document_cover.isEnabled=1").build(), "))", new StringBuilder("(sdoc.isLock = 0 AND sdoc.UUID in ("));
    }

    private static String getCoverSummarySearchQuery(List<SearchWord> list) {
        return new NotesSQLBuilder().select("document_cover.documentUUID").from("(").append(new NotesSQLBuilder().select("document_cover.*").from("document_cover").where("document_cover.templateUUID").mo12420in(SearchUtils.getCoverTemplateUuidsWithSummaryAndCategoryQuery()).append(")").mo12418as("document_cover").build()).innerJoin("sdoc").mo12421on("sdoc.UUID = document_cover.documentUUID").and("document_cover.isEnabled = 1").and(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(QueryUtils.getLikeSelection(DBSchema.DocumentCover.SUMMARY, list)).build();
    }

    private String getExcludeConvertedNoteQuery() {
        return "sdoc.lastMappedAt = 0";
    }

    private String getFindQuery() {
        String strM1170p = AbstractC0622a.m1170p(integrateSearchTables(this.mWords), ")", new StringBuilder("sdoc.UUID in ("));
        if (this.mParam.isCoEditMode() || !this.mParam.includeFolderName()) {
            return strM1170p;
        }
        return AbstractC0541b.m775q("((", strM1170p, ") OR (", AbstractC0622a.m1170p(getFolderSearchQuery(this.mWords, this.mParam.getTargetFolderUuid(), this.mParam.getFilterParam()), ")", new StringBuilder("sdoc.categoryUUID in (")), "))");
    }

    private static String getFolderSearchQuery(List<SearchWord> list, @NonNull String str, @NonNull SearchFilterParam searchFilterParam) {
        return new FolderSearchQuery(new FolderSearchParam(list).setSelectOnlyUuid(true).setTargetFolderUuid(str).setFilterParam(searchFilterParam).addExcludedFolders(PredefinedCategory.INVISIBLE_FOLDERS)).getQuery(-1);
    }

    private String getInsideFolderQuery() {
        if (this.mParam.getTargetFolderUuid().isEmpty()) {
            return "";
        }
        return "sdoc.categoryUUID = '" + this.mParam.getTargetFolderUuid() + "'";
    }

    private String getMdeSpaceQuery() {
        return this.mParam.isCoEditMode() ? COEDIT_SPACE : DEFAULT;
    }

    private String getOldDocumentQuery() {
        if (this.mParam.getOldDocumentOption() == 2) {
            return QueryConstants.SDOCX_CONDITION;
        }
        if (this.mParam.getOldDocumentOption() != 1) {
            return "";
        }
        return "(sdoc.filePath LIKE '%.sdocx' OR sdoc.UUID IN (" + new NotesSQLBuilder().select("sdocUUID").from("retry").where("retry.state = 2").build() + "))";
    }

    private String getPageModeQuery() {
        if (this.mParam.getPageMode() == 0) {
            return "";
        }
        return "sdoc.pageMode = " + this.mParam.getPageMode();
    }

    private static String getSTTContentSearchQuery(List<SearchWord> list) {
        return new NotesSQLBuilder().selectDistinct("stt_content.documentUUID").from(DBSchema.SttContent.TABLE_NAME).innerJoin("sdoc").mo12421on("sdoc.UUID = stt_content.documentUUID").and("stt_content.type = 0").and(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(QueryUtils.getLikeSelection("stt_content.content", list)).build();
    }

    private String getSelectClause() {
        return DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION;
    }

    private static String getStrokeSearchQuery(List<SearchWord> list) {
        return new NotesSQLBuilder().select("sdoc.UUID").from("sdoc").innerJoin(new NotesSQLBuilder().append("(").select("stroke.sdocUUID AS sdocUUID").from("stroke").groupBy("stroke.sdocUUID").having(QueryUtils.getLikeSelection("GROUP_CONCAT(stroke.text, ' ')", list, true)).append(")").asEnd("hwData").build()).mo12421on("sdoc.UUID = hwData.sdocUUID").where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).build();
    }

    private static String getTagListSearchQuery(List<SearchWord> list) {
        return new NotesSQLBuilder().select("tag_list.docUUID").from("tag_list").innerJoin("sdoc").mo12421on("sdoc.UUID = tag_list.docUUID").and(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and(QueryUtils.getLikeSelection("'#' || tag_list.normalizeName", list)).build();
    }

    private String getTimeQuery() {
        return new SearchFilterQuery().getTimeFilterQuery("sdoc", this.mParam.getFilterParam());
    }

    private String getTitleSearchQuery(List<SearchWord> list) {
        return new NotesSQLBuilder().select("sdoc.UUID").from("sdoc").where(QueryConstants.USED_DOCUMENT_CONDITION).and(this.mParam.includeLockedNoteTitle() ? "" : QueryConstants.UNLOCKED_CONDITION).and(QueryUtils.getLikeSelection("sdoc.title", list)).build();
    }

    private String integrateSearchTables(List<SearchWord> list) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(SearchUtils.isTargetContent(SearchConstants.TargetContents.TITLE) ? getTitleSearchQuery(list) : "");
        arrayList.add(SearchUtils.isTargetContent(SearchConstants.TargetContents.BODY_TEXT) ? getContentSearchQuery(list) : "");
        arrayList.add(SearchUtils.isTargetContent(SearchConstants.TargetContents.TAG) ? getTagListSearchQuery(list) : "");
        arrayList.add(SearchUtils.isTargetContent(SearchConstants.TargetContents.STROKE) ? getStrokeSearchQuery(list) : "");
        arrayList.add(SearchUtils.isTargetContent(SearchConstants.TargetContents.COVER_SUMMARY) ? getCoverSummarySearchQuery(list) : "");
        arrayList.add(SearchUtils.isTargetContent(SearchConstants.TargetContents.STT_CONTENT) ? getSTTContentSearchQuery(list) : "");
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (!str.isEmpty()) {
                sb.append(sb.toString().isEmpty() ? "" : SQLKeyword.UNION);
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public String getQuery(String str, String str2) {
        return new NotesSQLBuilder().select(getSelectClause()).from("").append("(").select("sdoc.*").from("sdoc").where(QueryConstants.USED_DOCUMENT_CONDITION).and(getExcludeConvertedNoteQuery()).and(getMdeSpaceQuery()).and(getPageModeQuery()).and(getOldDocumentQuery()).and(getInsideFolderQuery()).and(str).and(getTimeQuery()).and(getCoverStickerFilterQuery()).and(getFindQuery()).and(getContentFilterQuery()).append(")").asEnd("sdoc").append(DBSchema.MAIN_LIST_DOCUMENT_JOINED_STATEMENT).orderBy(str2).limit(this.mParam.getMaxCount()).delimiter().build();
    }
}
