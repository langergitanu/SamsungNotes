package com.samsung.android.app.notes.sync.network;

import com.google.api.services.drive.model.File;
import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class NoteGoogleDriveHelper$TimeAscCompare implements Comparator<File>, Serializable {
    private static final long serialVersionUID = 1;

    @Override // java.util.Comparator
    public int compare(File file, File file2) {
        long value = file.getModifiedDate().getValue();
        long value2 = file2.getModifiedDate().getValue();
        if (value > value2) {
            return -1;
        }
        return value < value2 ? 1 : 0;
    }
}
