package com.samsung.android.support.senl.p148nt.app.main.drawer.model;

import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMainListEntry;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class WaitedObservedMap {
    private Map<String, NotesDocumentCountEntry> mCountEntryMap = null;
    private DocumentCategoryTree mDocumentCategoryTree = null;
    private List<CoeditMainListEntry> mCoeditMainListEntries = null;

    public void clearWaitedObservedMap() {
        this.mCountEntryMap = null;
        this.mDocumentCategoryTree = null;
        this.mCoeditMainListEntries = null;
    }

    public DocumentCategoryTree dequeueWaitedCategoryObservedMap() {
        return this.mDocumentCategoryTree;
    }

    public List<CoeditMainListEntry> dequeueWaitedCoeditObservedMap() {
        return this.mCoeditMainListEntries;
    }

    public Map<String, NotesDocumentCountEntry> dequeueWaitedCountObservedMap() {
        return this.mCountEntryMap;
    }

    public void enqueueWaitedObservedMap(Map<String, NotesDocumentCountEntry> map) {
        this.mCountEntryMap = map;
    }

    public void enqueueWaitedObservedMap(DocumentCategoryTree documentCategoryTree) {
        this.mDocumentCategoryTree = documentCategoryTree;
    }

    public void enqueueWaitedObservedMap(List<CoeditMainListEntry> list) {
        this.mCoeditMainListEntries = list;
    }
}
