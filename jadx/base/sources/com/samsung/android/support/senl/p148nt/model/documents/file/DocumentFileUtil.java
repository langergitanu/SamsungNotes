package com.samsung.android.support.senl.p148nt.model.documents.file;

import android.util.Size;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentFileUtil {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DocumentFileSizeType {
        Composer(1440),
        Document(1080),
        CoEdit(2160);

        public final int width;

        DocumentFileSizeType(int i) {
            this.width = i;
        }
    }

    public static Size getSize(DocumentFileSizeType documentFileSizeType, int i, boolean z) {
        int i2;
        if (z) {
            int i4 = documentFileSizeType.width;
            if (DocumentFileSizeType.Composer != documentFileSizeType || i <= 0) {
                i = i4;
            }
            i2 = (int) (i * 1.4142857f);
        } else {
            int i5 = documentFileSizeType.width;
            if (DocumentFileSizeType.Composer != documentFileSizeType || i <= 0) {
                i = i5;
            }
            int i6 = i;
            i = (int) (i * 1.4142857f);
            i2 = i6;
        }
        return new Size(i2, i);
    }

    public static Size getSize(@NonNull String str, DocumentFileSizeType documentFileSizeType, int i) {
        return getSize(documentFileSizeType, i, SpenWNoteFile.getOrientation(str) == SpenWNote.Orientation.LANDSCAPE_NEW);
    }
}
