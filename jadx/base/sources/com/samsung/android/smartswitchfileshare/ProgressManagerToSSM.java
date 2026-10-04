package com.samsung.android.smartswitchfileshare;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ProgressManagerToSSM extends ProgressManager {
    protected final List<FileInfo> internalFiles;

    public ProgressManagerToSSM(@Nullable FileShareCallback fileShareCallback, FileUtil fileUtil, @NonNull File file, @NonNull Uri uri, boolean z) {
        super(fileShareCallback, "ProgressManagerToSSM", z);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.totalSize = 0L;
        ArrayList arrayList = new ArrayList();
        this.internalFiles = arrayList;
        updateFileListNsize(fileUtil, file, uri);
        this.totalCount = arrayList.size();
        if (this.enableLog) {
            Log.d(this.TAG, String.format("ProgressManagerToSSM totalSize[%d] totalCount[%d] done [%s]", Long.valueOf(this.totalSize), Integer.valueOf(this.totalCount), CommonUtil.getElapseSz(jElapsedRealtime)));
        }
    }

    private void addFileInfo(File file, Uri uri) {
        this.internalFiles.add(new FileInfo(file, uri));
        this.totalSize = file.length() + this.totalSize;
    }

    private void updateFileListNsize(FileUtil fileUtil, File file, Uri uri) {
        if (file == null || !file.exists()) {
            Log.e(this.TAG, "updateFileListNsize - no srcFile");
            return;
        }
        if (uri == null) {
            Log.e(this.TAG, "updateFileListNsize - no dstDir");
            return;
        }
        if (file.isDirectory()) {
            Uri uriCreateFile = fileUtil.createFile(uri, file.getName(), "vnd.android.document/directory");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    updateFileListNsize(fileUtil, file2, uriCreateFile);
                }
            }
        } else {
            addFileInfo(file, uri);
        }
        updateTransferredSize(0L);
    }

    public List<FileInfo> getInternalFiles() {
        return this.internalFiles;
    }
}
