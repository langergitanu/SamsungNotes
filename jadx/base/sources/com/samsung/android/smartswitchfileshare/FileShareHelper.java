package com.samsung.android.smartswitchfileshare;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.DocumentsContract;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileShareHelper {
    private static final String BNR_PROVIDER_CONTENT_URI = "content://com.sec.android.easyMover.BnRProvider";
    private static final String CMD_GET_BACKUP_FILE_URIS = "getBackupFileUris";
    public static final String EXTRA_FILE_EXIST = "FILE_EXIST";
    public static final String EXTRA_URI_LIST = "URI_LIST";
    private final String TAG;
    private final ContentResolver contentResolver;
    private final Context context;
    private final FileUtil fileUtil;
    private boolean printProgressLog;

    public FileShareHelper(@NonNull Context context, @Nullable String str) {
        this.context = context;
        ContentResolver contentResolver = context.getContentResolver();
        this.contentResolver = contentResolver;
        String strMakeFormattedTag = CommonUtil.makeFormattedTag(str);
        this.TAG = strMakeFormattedTag;
        this.fileUtil = new FileUtil(contentResolver, str);
        Locale locale = Locale.ENGLISH;
        Log.i(strMakeFormattedTag, "FileShareHelper versionName[1.1.0], versionCode[110000000]");
        this.printProgressLog = false;
    }

    private int copyFileToDirUri(@NonNull File file, @NonNull Uri uri, boolean z, FileShareCallback fileShareCallback) throws FileShareException {
        if (file == null || !file.exists()) {
            throw FileShareException.makeFileShareException("copyFileToDirUri", 2);
        }
        if (uri == null) {
            throw FileShareException.makeFileShareException("copyFileToDirUri", 0);
        }
        ProgressManagerToSSM progressManagerToSSM = new ProgressManagerToSSM(fileShareCallback, this.fileUtil, file, uri, this.printProgressLog);
        for (FileInfo fileInfo : progressManagerToSSM.getInternalFiles()) {
            copyFileToFileUri(fileInfo.getFile(), createFile(fileInfo.getUri(), fileInfo.getFile().getName()), z, progressManagerToSSM);
        }
        progressManagerToSSM.finish();
        return progressManagerToSSM.getTransferredCount();
    }

    private boolean copyFileToFileUri(File file, @NonNull Uri uri, boolean z, ProgressManagerToSSM progressManagerToSSM) throws FileShareException {
        boolean zDelete;
        if (file == null) {
            throw FileShareException.makeFileShareException("copyFileToFileUri", 2);
        }
        if (!file.exists() || !file.isFile()) {
            throw FileShareException.makeFileShareException("copyFileToFileUri", 2, file.getName());
        }
        if (uri == null) {
            throw FileShareException.makeFileShareException("copyFileToFileUri", 0);
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(this.contentResolver.openOutputStream(uri));
            try {
                boolean zCopyFileToStream = this.fileUtil.copyFileToStream(file, bufferedOutputStream, progressManagerToSSM);
                if (z && zCopyFileToStream) {
                    try {
                        zDelete = file.delete();
                    } catch (SecurityException e) {
                        Log.w(this.TAG, String.format(Locale.ENGLISH, "copyFileToFileUri delete got SecurityException [%s]", file), e);
                        zDelete = false;
                    }
                } else {
                    zDelete = false;
                }
                CommonUtil.printLog(zCopyFileToStream, this.TAG, String.format(Locale.ENGLISH, "copyFileToFileUri src[%s], dst[%s], needDelSrc[%b], delRes[%b]", file, uri, Boolean.valueOf(z), Boolean.valueOf(zDelete)));
                bufferedOutputStream.close();
                return zCopyFileToStream;
            } finally {
            }
        } catch (IOException e2) {
            Log.e(this.TAG, String.format(Locale.ENGLISH, "copyFileToFileUri src[%s], dst[%s]", file, uri), e2);
            return false;
        }
    }

    private boolean copyUriToFile(@NonNull Uri uri, @NonNull File file, boolean z, ProgressManagerFromSSM progressManagerFromSSM) throws FileShareException {
        boolean zDeleteDocument;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (file.exists() && file.isDirectory()) {
            throw FileShareException.makeFileShareException("copyUriToFiler", 3, file.getAbsolutePath());
        }
        if (!DocumentsContract.isDocumentUri(this.context, uri)) {
            throw FileShareException.makeFileShareException("copyUriToFile", 4, uri.toString());
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        boolean zCpUriToFile = this.fileUtil.cpUriToFile(uri, file, progressManagerFromSSM);
        if (z && zCpUriToFile) {
            try {
                zDeleteDocument = DocumentsContract.deleteDocument(this.contentResolver, uri);
            } catch (FileNotFoundException e) {
                Log.w(this.TAG, String.format(Locale.ENGLISH, "copyUriToFile delete FileNotFoundException [%s]", uri), e);
                zDeleteDocument = false;
            }
        } else {
            zDeleteDocument = false;
        }
        CommonUtil.printLog(zCpUriToFile, this.TAG, String.format(Locale.ENGLISH, "copyUriToFile file srcUri[%s] > dstFile[%s], copyRes[%b], delRes[%b], time[%d]", uri, file, Boolean.valueOf(zCpUriToFile), Boolean.valueOf(zDeleteDocument), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime)));
        return zCpUriToFile;
    }

    private int copyUrisToDir(@NonNull List<Uri> list, @NonNull File file, boolean z, @NonNull ProgressManagerFromSSM progressManagerFromSSM) throws FileShareException {
        if (list.size() < 2) {
            throw FileShareException.makeFileShareException("copyUrisToDir", 5);
        }
        if (file.exists() && file.isFile()) {
            throw FileShareException.makeFileShareException("copyUrisToDir", 3, file.getAbsolutePath());
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Uri uri = list.get(0);
        List<Uri> listSubList = list.subList(1, list.size());
        String documentId = DocumentsContract.isDocumentUri(this.context, uri) ? DocumentsContract.getDocumentId(uri) : DocumentsContract.getTreeDocumentId(uri);
        String absolutePath = file.getAbsolutePath();
        String str = this.TAG;
        Locale locale = Locale.ENGLISH;
        StringBuilder sbM16m = AbstractC0000a.m16m("copyUrisToDir src[", documentId, "] > dst[", absolutePath, "], needDelSrc[");
        sbM16m.append(z);
        sbM16m.append("]");
        Log.i(str, sbM16m.toString());
        for (Uri uri2 : listSubList) {
            if (DocumentsContract.isDocumentUri(this.context, uri2)) {
                copyUriToFile(uri2, new File(DocumentsContract.getDocumentId(uri2).replaceFirst(documentId, absolutePath)), z, progressManagerFromSSM);
            }
        }
        String str2 = this.TAG;
        Locale locale2 = Locale.ENGLISH;
        Log.i(str2, "copyUrisToDir done copied[" + progressManagerFromSSM.getTransferredCount() + "], time[" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "]");
        progressManagerFromSSM.finish();
        return progressManagerFromSSM.getTransferredCount();
    }

    public int copy(@NonNull File file, @NonNull Intent intent) {
        return copy(file, intent, (FileShareCallback) null);
    }

    public Uri createDirectory(Uri uri, String str) {
        return this.fileUtil.createFile(uri, str, "vnd.android.document/directory");
    }

    public Uri createFile(Uri uri, String str) {
        return this.fileUtil.createFile(uri, str, null);
    }

    public List<Uri> getBackupFileUris(@Nullable String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ArrayList arrayList = new ArrayList();
        try {
            Bundle bundleCall = this.contentResolver.call(Uri.parse(BNR_PROVIDER_CONTENT_URI), CMD_GET_BACKUP_FILE_URIS, str, (Bundle) null);
            if (bundleCall.getBoolean(EXTRA_FILE_EXIST) && bundleCall.getStringArrayList(EXTRA_URI_LIST) != null) {
                Iterator<String> it = bundleCall.getStringArrayList(EXTRA_URI_LIST).iterator();
                while (it.hasNext()) {
                    arrayList.add(Uri.parse(it.next()));
                }
            }
        } catch (Exception e) {
            AbstractC2322a.m1636z("getBackupFilesUris Ex: ", Log.getStackTraceString(e), this.TAG);
        }
        Log.d(this.TAG, String.format("getBackupFilesUris uris[%s] %s", arrayList, CommonUtil.getElapseSz(jElapsedRealtime)));
        return arrayList;
    }

    public List<Uri> getPathUris(@NonNull Intent intent) throws FileShareException {
        String stringExtra;
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(Constants.SAVE_PATH_URIS);
        if ((stringArrayListExtra == null || stringArrayListExtra.isEmpty()) && (stringExtra = intent.getStringExtra(Constants.SAVE_PATH_FILE)) != null) {
            stringArrayListExtra = new ArrayList<>();
            try {
                JSONArray jSONArray = new JSONObject(this.fileUtil.getDataFromUri(Uri.parse(stringExtra))).getJSONArray(Constants.JTAG_DATA_LIST);
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        stringArrayListExtra.add(jSONArray.getJSONObject(i).getString(Constants.JTAG_DOC_URI));
                    } catch (Exception e) {
                        Log.e(this.TAG, "getPathUris add", e);
                    }
                }
            } catch (Exception e2) {
                Log.e(this.TAG, "getPathUris", e2);
            }
        }
        if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
            throw FileShareException.makeFileShareException("getPathUris", 6);
        }
        ArrayList arrayList = new ArrayList(stringArrayListExtra.size());
        for (String str : stringArrayListExtra) {
            arrayList.add(Uri.parse(str));
            Log.v(this.TAG, "getPathUris [" + str + "]");
        }
        Log.i(this.TAG, String.format("getPathUris [%d]", Integer.valueOf(arrayList.size())));
        return arrayList;
    }

    public int move(@NonNull File file, @NonNull Intent intent) {
        return move(file, intent, (FileShareCallback) null);
    }

    public void setEnableProgressLog(boolean z) {
        String str = this.TAG;
        Locale locale = Locale.ENGLISH;
        Log.i(str, "setEnableProgressLog [" + this.printProgressLog + " > " + z + "]");
        this.printProgressLog = z;
    }

    public int copy(@NonNull File file, @NonNull Intent intent, FileShareCallback fileShareCallback) throws FileShareException {
        List<Uri> pathUris = getPathUris(intent);
        if (pathUris.isEmpty()) {
            throw FileShareException.makeFileShareException("copy", 0);
        }
        return copy(file, pathUris.get(0), fileShareCallback);
    }

    public int move(@NonNull File file, @NonNull Intent intent, FileShareCallback fileShareCallback) throws FileShareException {
        List<Uri> pathUris = getPathUris(intent);
        if (pathUris.isEmpty()) {
            throw FileShareException.makeFileShareException(SecureFolderConstants.TEMP_FOLDER_NAME, 0);
        }
        return move(file, pathUris.get(0), fileShareCallback);
    }

    public int copy(File file, Uri uri) {
        return copyFileToDirUri(file, uri, false, null);
    }

    public int move(@NonNull File file, @NonNull Uri uri) {
        return move(file, uri, (FileShareCallback) null);
    }

    public int copy(File file, Uri uri, FileShareCallback fileShareCallback) {
        return copyFileToDirUri(file, uri, false, fileShareCallback);
    }

    public int move(@NonNull File file, @NonNull Uri uri, FileShareCallback fileShareCallback) {
        return copyFileToDirUri(file, uri, true, fileShareCallback);
    }

    public int copy(@NonNull Intent intent, @NonNull File file) {
        return copy(intent, file, (FileShareCallback) null);
    }

    public int move(@NonNull Intent intent, @NonNull File file) {
        return move(intent, file, (FileShareCallback) null);
    }

    public int copy(@NonNull Intent intent, @NonNull File file, FileShareCallback fileShareCallback) throws FileShareException {
        List<Uri> pathUris = getPathUris(intent);
        if (!pathUris.isEmpty()) {
            return copyUrisToDir(pathUris, file, false, new ProgressManagerFromSSM(fileShareCallback, intent, this.printProgressLog));
        }
        throw FileShareException.makeFileShareException("copy", 1);
    }

    public int move(@NonNull Intent intent, @NonNull File file, FileShareCallback fileShareCallback) throws FileShareException {
        List<Uri> pathUris = getPathUris(intent);
        if (!pathUris.isEmpty()) {
            return copyUrisToDir(pathUris, file, true, new ProgressManagerFromSSM(fileShareCallback, intent, this.printProgressLog));
        }
        throw FileShareException.makeFileShareException(SecureFolderConstants.TEMP_FOLDER_NAME, 1);
    }

    public int copy(@NonNull List<Uri> list, @NonNull File file) {
        return copyUrisToDir(list, file, false, new ProgressManagerFromSSM(this.printProgressLog));
    }

    public int move(@NonNull Uri uri, @NonNull File file) {
        return copyUriToFile(uri, file, true, null) ? 1 : 0;
    }

    public int copy(@NonNull Uri uri, @NonNull File file) {
        return copyUriToFile(uri, file, false, null) ? 1 : 0;
    }

    public int move(@NonNull List<Uri> list, @NonNull File file) {
        return copyUrisToDir(list, file, true, new ProgressManagerFromSSM(this.printProgressLog));
    }
}
