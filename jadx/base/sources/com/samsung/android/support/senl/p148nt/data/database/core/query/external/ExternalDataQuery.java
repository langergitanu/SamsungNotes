package com.samsung.android.support.senl.p148nt.data.database.core.query.external;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SearchUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import p074R1.C0233e;
import p092W3.C0332a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ExternalDataQuery {
    private static final String TAG = DataLogger.createTag("ExternalDataQuery");

    private String getInlineView(@Nullable String str) {
        return new NotesSQLBuilder().append("(").select(getInnerSelectClause(ExternalDataConstants.getProjection())).from(getInnerFromClause()).where("sdoc.isDeleted == 0").and(QueryConstants.SDOCX_CONDITION).and(getInnerWhereClause(str)).append(")").asEnd(ExternalDataConstants.DOCUMENT_TABLE_NAME).build();
    }

    private String getInnerFromClause() {
        return new NotesSQLBuilder().append("sdoc").innerJoin(DBSchema.ExternalSharedDocument.TABLE_NAME).mo12421on("sdoc.UUID = external_shared_documents.UUID").innerJoin(DBSchema.TextSearch.TABLE_NAME).mo12421on("sdoc.UUID = text_search.sdocUUID").leftJoin(DBSchema.DocumentExtra.TABLE_NAME).mo12421on("sdoc.UUID = document_extra.UUID").leftJoin("document_cover").mo12421on("sdoc.UUID = document_cover.documentUUID").build();
    }

    @NonNull
    private String getInnerSelectClause(@NonNull List<String> list) {
        return QueryUtils.getCommaSeparatedString((List) list.stream().map(new C0332a(this, 0)).filter(new C0233e(2)).collect(Collectors.toList()), false);
    }

    private String getInnerWhereClause(String str) {
        return TextUtils.isEmpty(str) ? new NotesSQLBuilder().append("sdoc.UUID").mo12420in(new NotesSQLBuilder().select("retry.sdocUUID").from("retry").where("retry.state = 2").build()).and(QueryConstants.UNLOCKED_CONDITION).and("mdeSpaceId = ''").build() : AbstractC0541b.m773o("sdoc.UUID = '", str, "'");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMatchedStatementByColumn(String str) {
        str.getClass();
        switch (str) {
            case "voiceRecordingTitle":
                return "(SELECT GROUP_CONCAT(stroke.text, '\n') FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 4) AS voiceRecordingTitle";
            case "tableText":
                return "(SELECT GROUP_CONCAT(stroke.text, '\n') FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 6) AS tableText";
            case "tagText":
                return "(SELECT GROUP_CONCAT(tag_list.displayName, '\n') FROM tag_list WHERE tag_list.docUUID = sdoc.UUID) AS tagText";
            case "textBox":
                return "(SELECT GROUP_CONCAT(stroke.text, '\n') FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 0) AS textBox";
            case "simpleBodyText":
                return "SUBSTR(text_search.strippedContent, 1, 300) AS simpleBodyText";
            case "filter":
                return new NotesSQLBuilder().replace("(").replace(new NotesSQLBuilder().append("(").select().caseWhen("sdoc.title != ''").then("'�hasTitle�'").elseEnd("''").append(") || (").select().caseWhen().exists(new NotesSQLBuilder().select("1").from("content").where("content.sdocUUID = sdoc.UUID").and("mime_type = 'content/voice_recording'").build()).then("'�hasVoice�'").elseEnd("''").append(") || (").select().caseWhen("document_extra.hasStroke = 1").then("'�hasStroke�'").elseEnd("''").append(") || (").select().caseWhen("document_extra.hasImage = 1").then("'�hasImage�'").elseEnd("''").append(") || (").select().caseWhen("document_extra.hasPdf = 1").then("'�hasPdf�'").elseEnd("''").append(") || (").select().caseWhen("document_cover.templateUUID").mo12420in(SearchUtils.getCoverTemplateUuidsWithSummaryAndCategoryQuery()).and("document_cover.categoryUUID != 'NONE:///'").and("document_cover.isEnabled=1").then("'�cover_sticker_id=' || document_cover.categoryUUID || '�'").elseEnd("''").append(")").build(), "'��'", "'\u001f'").append(", '�', '')").mo12418as("filter").build();
            case "hwText":
                return "(SELECT SUBSTR(GROUP_CONCAT(stroke.text, ' '), 1, 350000) FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 1) AS hwText";
            case "codeBlockText":
                return "(SELECT GROUP_CONCAT(stroke.text, '\n') FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 7) AS codeBlockText";
            case "pdfText":
                return "(SELECT SUBSTR(GROUP_CONCAT(stroke.text, '\n'), 1, 350000) FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 3) AS pdfText";
            case "coverSummary":
                return "document_cover.summary AS coverSummary";
            case "voiceRecordingStt":
                return "(SELECT GROUP_CONCAT(stt_content.content, '\n') FROM stt_content WHERE stt_content.documentUUID = sdoc.UUID AND stt_content.type = 0) AS voiceRecordingStt";
            case "thumbnailUri":
                return "'" + ExternalDataConstants.URI_FINDER_THUMBNAIL + "/' || sdoc.UUID AS thumbnailUri";
            case "extraData":
                return "'' AS extraData";
            case "_id":
                return "sdoc._id AS _id";
            case "UUID":
                return "sdoc.UUID AS UUID";
            case "timestamp":
                return "external_shared_documents.timestamp AS timestamp";
            case "title":
                return "sdoc.title AS title";
            case "contentUri":
                return "'" + ExternalDataConstants.URI_FINDER_UUID + "' || sdoc.UUID AS contentUri";
            case "createdAt":
                return "sdoc.createdAt AS createdAt";
            case "lastModifiedAt":
                return "sdoc.lastModifiedAt AS lastModifiedAt";
            case "audioTitle":
                return "(SELECT GROUP_CONCAT(stroke.text, '\n') FROM stroke WHERE stroke.sdocUUID = sdoc.UUID AND stroke.type = 5) AS audioTitle";
            case "bodyText":
                return "CAST(text_search.strippedContent AS TEXT) AS bodyText";
            default:
                DataLogger.m12309w(TAG, "getMatchedQuery, column: ".concat(str));
                return "";
        }
    }

    private String getOrderClause(String str) {
        if (QueryUtils.isAllowedStatement(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            DataLogger.m12309w(TAG, "getOrderClause, not allowed statement");
        }
        return "";
    }

    @NonNull
    private String getSelectClause(String[] strArr) {
        return QueryUtils.getCommaSeparatedString((List) Arrays.stream(strArr).filter(new C0233e(1)).collect(Collectors.toList()), false);
    }

    @NonNull
    private String getWhereClause(String str) {
        if (QueryUtils.isAllowedStatement(str)) {
            return str;
        }
        if (!TextUtils.isEmpty(str)) {
            DataLogger.m12309w(TAG, "getWhereClause, not allowed selection statement");
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getInnerSelectClause$0(String str) {
        return !str.isEmpty();
    }

    @NonNull
    public String get(String[] strArr, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        String selectClause = getSelectClause(strArr);
        return selectClause.isEmpty() ? "" : new NotesSQLBuilder().select(selectClause).from(getInlineView(str)).where(getWhereClause(str2)).orderBy(getOrderClause(str3)).build();
    }
}
