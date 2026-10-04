package com.samsung.android.support.senl.p148nt.model.securefolder.domain;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import com.samsung.android.support.senl.p148nt.model.importer.utils.ImportUtils;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderUtils;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import p200l4.C13519a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class ImportNoteFromSecureSpaceUseCase extends AsyncTask<Void, Void, Integer> {
    private static final int DELETE_CONDITION_HOUR = 24;

    @SuppressLint({"StaticFieldLeak"})
    private final Context mAppContext;
    private final String mTag;
    private String mTempDirectoryPath = "";
    private final SecureFolderConstants.ImportType mType;

    public ImportNoteFromSecureSpaceUseCase(Context context) {
        this.mAppContext = context;
        SecureFolderConstants.ImportType type = getType();
        this.mType = type;
        this.mTag = ModelLogger.createSecureFolderTag("Import" + type.name());
    }

    private void deleteDummyFiles() {
        File[] deleteTargetFiles = getDeleteTargetFiles();
        if (deleteTargetFiles == null) {
            DataLogger.m12307i(this.mTag, "deleteDummyFiles, there is no target file");
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(10, -24);
        Date time = calendar.getTime();
        for (File file : deleteTargetFiles) {
            if (new Date(file.lastModified()).before(time)) {
                try {
                    if (FileUtils.deleteFile(file)) {
                        DataLogger.m12305f(this.mTag, "deleteDummyFiles, delete: " + DataLogger.getEncode(file.getAbsolutePath()));
                    }
                } catch (IOException e) {
                    AbstractC11014a.m12332q(e, new StringBuilder("deleteDummyFiles, e: "), this.mTag);
                }
            }
        }
    }

    private File[] getDeleteTargetFiles() {
        return new File(this.mTempDirectoryPath).listFiles(new C13519a(this, 1));
    }

    private File[] getImportTargetFiles() {
        return new File(this.mTempDirectoryPath).listFiles(new C13519a(this, 0));
    }

    private SecureFolderConstants.ImportType getType() {
        return SecureFolderUtils.isSecureFolderMode() ? SecureFolderConstants.ImportType.FromNormalFolder : SecureFolderConstants.ImportType.FromSecureFolder;
    }

    private boolean importDocument(File file) {
        SecureFolderUtils.detachLockedSNote(this.mAppContext, file.getPath());
        String strCreateNewUuid = ImportUtils.createNewUuid(this.mAppContext, file.getPath());
        boolean zImportSdocX = importSdocX(new ImportSdocXParam().setContext(this.mAppContext).setUuid(strCreateNewUuid).setExternalPath(file.getPath()).setIsNew(true).setCaller(this.mTag));
        DataLogger.m12305f(this.mTag, "importDocument, result: " + zImportSdocX + ", uuid: " + strCreateNewUuid + ", tmpPath: " + DataLogger.getEncode(file.getPath()));
        return zImportSdocX;
    }

    private void importFiles() {
        File[] importTargetFiles = getImportTargetFiles();
        if (importTargetFiles == null || importTargetFiles.length == 0) {
            DataLogger.m12307i(this.mTag, "importFiles, there is no target file");
            return;
        }
        DataLogger.m12305f(this.mTag, "importFiles: " + importTargetFiles.length);
        try {
            for (File file : importTargetFiles) {
                if (importDocument(file) && !FileUtils.deleteFile(file)) {
                    DataLogger.m12303e(this.mTag, "importFiles, fail to delete: " + DataLogger.getEncode(file.getPath()));
                }
            }
        } catch (Exception e) {
            DataLogger.m12305f(this.mTag, "importFiles, e: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getDeleteTargetFiles$1(File file, String str) {
        return str.endsWith("sdocx") && str.startsWith(this.mType.getDeleteFilePrefix());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$getImportTargetFiles$0(File file, String str) {
        return str.endsWith("sdocx") && str.startsWith(this.mType.getImportFilePrefix());
    }

    @VisibleForTesting
    public boolean importSdocX(ImportSdocXParam importSdocXParam) {
        return new ImportSdocXTask(importSdocXParam).setImported(true).call().booleanValue();
    }

    @Override // android.os.AsyncTask
    public Integer doInBackground(Void... voidArr) {
        Thread.currentThread().setName(this.mTag);
        if (!SecureFolderUtils.isMenuSupported(this.mAppContext)) {
            return 1;
        }
        String tempDirPath = SecureFolderUtils.getTempDirPath(this.mAppContext);
        this.mTempDirectoryPath = tempDirPath;
        if (tempDirPath.isEmpty()) {
            DataLogger.m12302d(this.mTag, "temp directory path is empty");
            return 1;
        }
        importFiles();
        deleteDummyFiles();
        return 0;
    }
}
