package com.samsung.android.support.senl.p148nt.data.database.core.query.search;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SearchFilterParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SearchFilterQuery {
    private boolean contains(int i, @SearchConstants.ContentFilter int i2) {
        return (i & i2) != 0;
    }

    public String getContentFilter(int i) {
        NotesSQLBuilder notesSQLBuilder = new NotesSQLBuilder();
        if (i == 0) {
            return notesSQLBuilder.build();
        }
        if (contains(i, 2)) {
            String strBuild = new NotesSQLBuilder().selectDistinct("sdocUUID").from("content").where("mime_type = 'content/voice_recording'").build();
            if (!notesSQLBuilder.isEmpty()) {
                notesSQLBuilder.append(SQLKeyword.AND);
            }
            notesSQLBuilder.append("sdoc.UUID").mo12420in(strBuild);
        }
        if (contains(i, 1)) {
            if (!notesSQLBuilder.isEmpty()) {
                notesSQLBuilder.append(SQLKeyword.AND);
            }
            notesSQLBuilder.append("sdoc.title != ''");
        }
        return notesSQLBuilder.build();
    }

    public String getTimeFilterQuery(@NonNull String str, @NonNull SearchFilterParam searchFilterParam) {
        String string;
        String string2 = "";
        if (!searchFilterParam.isValidTimeCondition()) {
            return "";
        }
        String strM756B = AbstractC0541b.m756B(str, ".lastModifiedAt");
        if (searchFilterParam.getFromTime() > 0) {
            StringBuilder sbM781w = AbstractC0541b.m781w(strM756B, " >= ");
            sbM781w.append(searchFilterParam.getFromTime());
            string = sbM781w.toString();
        } else {
            string = "";
        }
        String str2 = (searchFilterParam.getFromTime() <= 0 || searchFilterParam.getToTime() <= 0) ? "" : SQLKeyword.AND;
        if (searchFilterParam.getToTime() > 0) {
            StringBuilder sbM781w2 = AbstractC0541b.m781w(strM756B, " <= ");
            sbM781w2.append(searchFilterParam.getToTime());
            string2 = sbM781w2.toString();
        }
        return AbstractC0541b.m775q("(", string, str2, string2, ")");
    }
}
