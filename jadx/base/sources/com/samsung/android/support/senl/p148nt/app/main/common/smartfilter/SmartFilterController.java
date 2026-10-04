package com.samsung.android.support.senl.p148nt.app.main.common.smartfilter;

import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.repository.document.MainListDocumentDataRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SmartFilterController {
    private static final String TAG = "SmartFilterController";
    private final FilterObject mRecentlyImported = new FilterObject(new RecentlyImported());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class FilterObject {
        final AbsSmartFilter mFilter;
        final ArrayList<String> mNotesUUIDList;

        public FilterObject(AbsSmartFilter absSmartFilter) {
            this.mFilter = absSmartFilter;
            this.mNotesUUIDList = absSmartFilter.getNotesUUIDPreference();
        }
    }

    public int getRecentlyImportedCount() {
        return this.mRecentlyImported.mFilter.getCount();
    }

    public List<MainListDocumentData> getRecentlyImportedEntry() {
        MainListDocumentDataRepository mainListRepository = this.mRecentlyImported.mFilter.getMainListRepository();
        return mainListRepository == null ? Collections.EMPTY_LIST : mainListRepository.rawQuery(new SimpleSQLiteQuery(this.mRecentlyImported.mFilter.getSelection(), null));
    }

    public List<NotesFolder> getSmartFilter(Map<String, NotesFolder> map, Map<String, NotesDocumentCountEntry> map2, Map<String, NotesDocumentCountEntry> map3) {
        ArrayList arrayList = new ArrayList();
        int count = this.mRecentlyImported.mFilter.getCount();
        NotesFolder notesFolder = map.get("recentlyImported:///");
        NotesDocumentCountEntry notesDocumentCountEntry = map2.get("recentlyImported:///");
        AbstractC8014b.m7201c(count, "filterDrawer RecentlyImported# ", TAG);
        if (count <= 0) {
            if (notesFolder != null) {
                map.remove("recentlyImported:///");
                map2.remove("recentlyImported:///");
            }
            return arrayList;
        }
        if (notesFolder == null) {
            notesFolder = new NotesFolder("recentlyImported:///", null, FolderConstants.RecentlyImported.DISPLAY_NAME, "recentlyImported:///");
            notesFolder.setViewType(1006);
            notesFolder.setId(-6L);
            map.put("recentlyImported:///", notesFolder);
        }
        if (notesDocumentCountEntry == null) {
            notesDocumentCountEntry = new NotesDocumentCountEntry();
            notesDocumentCountEntry.setCategoryUuid("recentlyImported:///");
        }
        notesDocumentCountEntry.setDocumentCount(count);
        map3.put("recentlyImported:///", notesDocumentCountEntry);
        arrayList.add(notesFolder);
        return arrayList;
    }

    public void inactivate() {
        this.mRecentlyImported.mFilter.setNotesUUIDPreference(new HashSet(this.mRecentlyImported.mNotesUUIDList));
    }
}
