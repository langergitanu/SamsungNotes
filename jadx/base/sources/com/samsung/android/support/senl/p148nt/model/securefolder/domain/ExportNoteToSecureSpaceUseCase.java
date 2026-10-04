package com.samsung.android.support.senl.p148nt.model.securefolder.domain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderUtils;
import com.samsung.android.support.senl.p148nt.model.securefolder.repository.SecureFolderDataRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCopyUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentTimeUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ExportNoteToSecureSpaceUseCase extends AsyncTask<Void, Void, Integer> {

    @SuppressLint({"StaticFieldLeak"})
    private final Context mAppContext;
    private final List<String> mDocUuids;
    private Listener mListener;
    private final String mTag;
    private final SecureFolderConstants.ExportType mType;
    private String mTempDirectoryPath = "";
    private final SecureFolderDataRepository mSecureFolderDataRepository = new SecureFolderDataRepository();
    private final Map<String, String> mExportInfo = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Listener {
        void onExportFinished(@SecureFolderConstants.Result int i);

        void onExportStarted();
    }

    public ExportNoteToSecureSpaceUseCase(Context context, List<String> list, @NonNull Listener listener) {
        this.mAppContext = context;
        this.mDocUuids = list;
        this.mListener = listener;
        SecureFolderConstants.ExportType type = getType();
        this.mType = type;
        this.mTag = ModelLogger.createSecureFolderTag("ExportTo" + type.name());
    }

    private boolean copyFile(NotesDocumentEntity notesDocumentEntity) {
        String filePath = notesDocumentEntity.getFilePath();
        String strCreateDstFilePath = createDstFilePath();
        boolean zCopyFile = copyFile(filePath, strCreateDstFilePath);
        if (!zCopyFile) {
            DataLogger.m12303e(this.mTag, "copyFile, fail, uuid: " + notesDocumentEntity.getUuid() + ", path: " + DataLogger.getEncode(strCreateDstFilePath));
            return zCopyFile;
        }
        DocumentTimeUtils.setDisplayTimes(strCreateDstFilePath, notesDocumentEntity.getCreatedAt(), notesDocumentEntity.getLastModifiedAt());
        this.mSecureFolderDataRepository.addDocumentUuid(strCreateDstFilePath, notesDocumentEntity.getUuid());
        this.mExportInfo.put(notesDocumentEntity.getUuid(), strCreateDstFilePath);
        DataLogger.m12302d(this.mTag, "copyFile, success, uuid: " + notesDocumentEntity.getUuid() + ", path: " + DataLogger.getEncode(strCreateDstFilePath));
        return zCopyFile;
    }

    private void deleteTempFiles() {
        DataLogger.m12302d(this.mTag, "deleteTempFiles: " + this.mExportInfo.size());
        this.mSecureFolderDataRepository.removeDocumentUuids(this.mExportInfo.values());
        Iterator<String> it = this.mExportInfo.values().iterator();
        while (it.hasNext()) {
            try {
                FileUtils.deleteFile(new File(it.next()));
            } catch (Exception e) {
                AbstractC11014a.m12333r(e, new StringBuilder("deleteTempFiles, e: "), this.mTag);
            }
        }
    }

    @SecureFolderConstants.Result
    private int exportFiles(List<NotesDocumentEntity> list) {
        if (!copyToTempSpace(list)) {
            return 1;
        }
        try {
            if (SecureFolderUtils.moveFiles(this.mAppContext, new ArrayList(this.mExportInfo.values()))) {
                printFileLogs();
                return 0;
            }
            DataLogger.m12305f(this.mTag, "exportFiles, fail to move files");
            return 1;
        } catch (Exception e) {
            DataLogger.m12305f(this.mTag, "exportFiles, invoke, e: " + e.getMessage());
            return 1;
        }
    }

    private SecureFolderConstants.ExportType getType() {
        return SecureFolderUtils.isSecureFolderMode() ? SecureFolderConstants.ExportType.ToNormalFolder : SecureFolderConstants.ExportType.ToSecureFolder;
    }

    private boolean isValid(List<NotesDocumentEntity> list) {
        if (this.mDocUuids.size() != list.size()) {
            DataLogger.m12303e(this.mTag, "isValid, some notes are not in DB, entities: " + list.size());
            return false;
        }
        for (NotesDocumentEntity notesDocumentEntity : list) {
            if (notesDocumentEntity.isSdoc()) {
                DataLogger.m12303e(this.mTag, "isValid, sdoc is not supported: " + notesDocumentEntity.getUuid());
                return false;
            }
            if (!new File(notesDocumentEntity.getFilePath()).exists()) {
                DataLogger.m12303e(this.mTag, "isValid, there is no file: " + notesDocumentEntity.getUuid());
                return false;
            }
        }
        return true;
    }

    private void printFileLogs() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.mExportInfo.entrySet()) {
            sb.append("exportFiles, uuid: ");
            sb.append(entry.getKey());
            sb.append(", tmpPath: ");
            sb.append(DataLogger.getEncode(entry.getValue()));
            sb.append('\n');
        }
        DataLogger.m12305f(this.mTag, sb.toString());
    }

    private boolean tempDirExists() {
        String tempDirPath = SecureFolderUtils.getTempDirPath(this.mAppContext);
        this.mTempDirectoryPath = tempDirPath;
        if (!tempDirPath.isEmpty()) {
            return true;
        }
        DataLogger.m12303e(this.mTag, "tempDirExists, fail to create temp directory");
        return false;
    }

    public boolean copyToTempSpace(List<NotesDocumentEntity> list) {
        Iterator<NotesDocumentEntity> it = list.iterator();
        while (it.hasNext()) {
            if (!copyFile(it.next())) {
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    public String createDstFilePath() {
        return this.mTempDirectoryPath + File.separator + this.mType.getPrefix() + System.currentTimeMillis() + ".sdocx";
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onExportStarted();
        }
    }

    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        Thread.currentThread().setName(this.mTag);
        DataLogger.m12307i(this.mTag, "export, start, doc count: " + this.mDocUuids.size());
        if (!SecureFolderUtils.isEnabled(this.mAppContext)) {
            return 2;
        }
        List<NotesDocumentEntity> entitiesByUuids = NotesDataRepositoryFactory.newInstance(this.mAppContext).createDocumentDataRepository().getEntitiesByUuids(this.mDocUuids);
        if (!tempDirExists() || !isValid(entitiesByUuids)) {
            return 1;
        }
        int iExportFiles = exportFiles(entitiesByUuids);
        if (iExportFiles != 0) {
            deleteTempFiles();
        }
        return Integer.valueOf(iExportFiles);
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        DataLogger.m12307i(this.mTag, "onPostExecute, result: " + num);
        try {
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onExportFinished(num.intValue());
                this.mListener = null;
            }
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("onPostExecute, e: "), this.mTag);
        }
    }

    private boolean copyFile(String str, String str2) {
        try {
            DocumentCopyUtils.copy(this.mAppContext, str, str2);
            return AbstractC2322a.m1607A(str2);
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("copyFile, e: "), this.mTag);
            return false;
        }
    }
}
