package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class BixbyNoteListInfo {
    private String currentFolderDisplayName;
    private String currentFolderUuid;
    private final ArrayList<MainListDocumentData> entryList = new ArrayList<>();

    public void addEntry(MainListDocumentData mainListDocumentData) {
        this.entryList.add(mainListDocumentData);
    }

    public ArrayList<MainListDocumentData> getEntryList() {
        return this.entryList;
    }

    public String getFolderDisplayName() {
        return this.currentFolderDisplayName;
    }

    public String getFolderUuid() {
        return this.currentFolderUuid;
    }

    public void setFolderDisplayName(String str) {
        this.currentFolderDisplayName = str;
    }

    public void setFolderUuid(String str) {
        this.currentFolderUuid = str;
    }
}
