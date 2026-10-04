package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Context;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import java.io.File;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class StorageChecker {
    public static final int ERR_NONE = 0;
    public static final int ERR_NOT_ENOUGH_MEMORY = 1;
    public static final int ERR_OVER_SIZE = 2;
    private static final String TAG = Logger.createTag("StorageChecker");
    private Context mContext;
    private final long mMaxDocumentByteSize;
    private SpenWNote mNote;

    public StorageChecker() {
        this(1073741824L);
    }

    private int getNoteSize() {
        SpenWNote spenWNote = this.mNote;
        if (spenWNote != null) {
            return spenWNote.getBoundFilesSize();
        }
        return 0;
    }

    private boolean isAvailableNoteSize() {
        long noteSize = getNoteSize();
        if (noteSize <= this.mMaxDocumentByteSize) {
            return true;
        }
        String str = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(noteSize, "isAvailableNoteSize# ", "/");
        sbM1323p.append(this.mMaxDocumentByteSize);
        Logger.m10999d(str, sbM1323p.toString());
        return false;
    }

    public static boolean showErrorDialog(Context context, int i) {
        return showErrorDialog(context, i, 1024L);
    }

    public List<String> checkAvailableStateToAdd(List<String> list) {
        long noteSize = getNoteSize();
        int size = list.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            noteSize += new File(list.get(i)).length();
            if (noteSize > this.mMaxDocumentByteSize) {
                String str = TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(i, size, "checkAvailableStateToAdd# ", "/", " size: ");
                sbM1173s.append(noteSize);
                Logger.m10999d(str, sbM1173s.toString());
                break;
            }
            i++;
        }
        return i < size ? list.subList(0, i) : list;
    }

    public int checkAvailableStateToEdit(boolean z, boolean z2) {
        return checkAvailableStateToEdit(z, false, z2);
    }

    public long getMaximumDocumentSize() {
        return 1073741824 - ((long) getNoteSize());
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setNote(SpenWNote spenWNote) {
        this.mNote = spenWNote;
    }

    public StorageChecker(long j) {
        this.mMaxDocumentByteSize = j;
    }

    public static boolean showErrorDialog(Context context, int i, long j) {
        AbstractC0000a.m3D(i, "showErrorDialog# ", TAG);
        if ((i & 1) != 0) {
            DialogUtils.showNotEnoughStorageDialog(context, null);
            return true;
        }
        if ((i & 2) == 0) {
            return false;
        }
        DialogUtils.showOverSizeItemsDialog(context, j);
        return true;
    }

    public int checkAvailableStateToEdit(boolean z, boolean z2, boolean z3) {
        int i;
        Context context;
        if (!z || StorageUtils.isAvailableMinimumMemory()) {
            i = 0;
        } else {
            Logger.m11004w(TAG, "checkAvailableStateToEdit# not enough memory");
            i = 1;
        }
        if (z2 && !isAvailableNoteSize()) {
            i |= 2;
            Logger.m11004w(TAG, "checkAvailableStateToEdit# over size");
        }
        if (z3 && (context = this.mContext) != null) {
            showErrorDialog(context, i);
        }
        return i;
    }

    public boolean checkAvailableStateToAdd(String str) {
        long length = new File(str).length() + ((long) getNoteSize());
        if (length <= this.mMaxDocumentByteSize) {
            return true;
        }
        Logger.m10999d(TAG, "checkAvailableStateToAdd# " + length);
        return false;
    }
}
