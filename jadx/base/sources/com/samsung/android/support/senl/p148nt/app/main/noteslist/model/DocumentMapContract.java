package com.samsung.android.support.senl.p148nt.app.main.noteslist.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public interface DocumentMapContract {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Coedit {
        void putHolderInfoMap(int i, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Folder {
        int getDocumentCount(String str);

        void putHolderInfoMap(int i, boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Note {
        void addCommonDisplayList(List<Common> list);

        void clearCommonDisplayList();

        boolean initCommonDisplayList();

        boolean initOldCommonDisplayData(boolean z);

        boolean isEquals(List<Common> list);

        void putHolderInfoMap(int i, boolean z);
    }
}
