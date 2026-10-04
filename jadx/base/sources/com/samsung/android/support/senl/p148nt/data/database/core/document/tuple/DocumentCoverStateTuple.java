package com.samsung.android.support.senl.p148nt.data.database.core.document.tuple;

import androidx.room.ColumnInfo;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DocumentCoverStateTuple extends NotesDocumentCoverEntity {

    @ColumnInfo(defaultValue = "0", name = "state")
    public int state = 0;

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }
}
