package com.samsung.android.support.senl.p148nt.app.main.common.smartfilter;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class RecentlyImported extends AbsSmartFilter {
    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public int getCount() {
        if (!NotesDatabaseManager.getInstance().isOpen()) {
            return SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("recentlyImported:///", 0);
        }
        MainListDocumentDataRepository mainListRepository = getMainListRepository();
        return mainListRepository == null ? SharedPreferencesCompat.getInstance(FolderConstants.PREF_FOLDER_INFO).getInt("recentlyImported:///", 0) : mainListRepository.getRecentlyImportedNoteCount(System.currentTimeMillis() - 604800000);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public long getID() {
        return -6L;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public String getKey() {
        return NotesConstants.UUID_RECENTLY_IMPORTED;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public ArrayList<String> getNotesUUIDPreference() {
        Set<String> stringSet = SharedPreferencesCompat.getInstance(SmartFilterConstants.FOLDER_SUGGESTION).getStringSet(SmartFilterConstants.RECENT_IMPORT_NOTES_LIST, null);
        return stringSet != null ? new ArrayList<>(stringSet) : new ArrayList<>();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public String getSelection() {
        return new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.UUID").notIn(new NotesSQLBuilder().select("mapped_document.UUID").from(DBSchema.MappedDocument.TABLE_NAME).build()).and("sdoc.importedAt >= " + (System.currentTimeMillis() - 604800000)).and(QueryConstants.USED_DOCUMENT_CONDITION).orderBy(new DocumentSortQuery().createQuery(NotesUtils.getRecentlyImportedSortParam())).build();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public String getTitle(Context context) {
        return context.getResources().getString(C8003R.string.folder_recently_imported);
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.smartfilter.AbsSmartFilter
    public void setNotesUUIDPreference(Set<String> set) {
        SharedPreferencesCompat.getInstance(SmartFilterConstants.FOLDER_SUGGESTION).putStringSet(SmartFilterConstants.RECENT_IMPORT_NOTES_LIST, set);
    }
}
