package com.samsung.android.smartswitchfileshare;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class FileUtil {
    private final String TAG;
    private final ContentResolver contentResolver;

    public FileUtil(@NonNull ContentResolver contentResolver, @Nullable String str) {
        this.contentResolver = contentResolver;
        this.TAG = CommonUtil.makeFormattedTag(str) + "FileUtil";
    }

    private void prepareOutFile(@NonNull File file) {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            Log.e(this.TAG, "prepareOutFilefailed to create parentFile" + parentFile.getAbsolutePath());
            return;
        }
        if (!file.exists() || file.delete()) {
            return;
        }
        Log.e(this.TAG, "prepareOutFilefailed to delete outFile" + file.getAbsolutePath());
    }

    public boolean copyFileToStream(File file, OutputStream outputStream, ProgressManager progressManager) {
        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        boolean zCpStream = false;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedInputStream = new BufferedInputStream(fileInputStream);
            } finally {
            }
        } catch (Exception e) {
            Log.e(this.TAG, "copyFileToStream " + file.getName() + " Exception " + Log.getStackTraceString(e));
        }
        try {
            zCpStream = cpStream(bufferedInputStream, outputStream, progressManager);
            if (progressManager != null) {
                progressManager.updateTransferredCount(zCpStream);
            }
            bufferedInputStream.close();
            fileInputStream.close();
            String str = this.TAG;
            StringBuilder sbM3200j = AbstractC4539a.m3200j("copyFileToStream result :", ", srcFile : ", zCpStream);
            sbM3200j.append(file.getAbsolutePath());
            sbM3200j.append("(");
            sbM3200j.append(file.length());
            sbM3200j.append(")");
            Log.v(str, sbM3200j.toString());
            return zCpStream;
        } finally {
        }
    }

    public boolean cpStream(InputStream inputStream, OutputStream outputStream) {
        return cpStream(inputStream, outputStream, null);
    }

    public boolean cpUriToFile(@NonNull Uri uri, @NonNull File file) {
        return cpUriToFile(uri, file, null);
    }

    public Uri createFile(Uri uri, String str, String str2) {
        Uri uriCreateDocument;
        try {
            uriCreateDocument = DocumentsContract.createDocument(this.contentResolver, uri, str2, str);
        } catch (Exception e) {
            Log.e(this.TAG, "createFile : " + str, e);
            uriCreateDocument = null;
        }
        CommonUtil.printLog(uriCreateDocument != null, this.TAG, String.format("createFile : %s, Document Uri : %s, Created directory Uri : %s", str, uri, uriCreateDocument));
        return uriCreateDocument;
    }

    public List<File> exploredFolder(File file, List<String> list, List<String> list2, boolean z) {
        File[] fileArrListFiles;
        ArrayList arrayList = new ArrayList();
        if (file != null && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    if (!z || (!file2.getName().startsWith(Extension.DOT) && !new File(file2, ".nomedia").exists())) {
                        arrayList.addAll(exploredFolder(file2, list, list2, z));
                    }
                } else if (!z || !file2.getName().startsWith(Extension.DOT)) {
                    boolean z2 = list == null || list.size() <= 0 || list.contains(getFileExt(file2.getName()));
                    if (z2 && list2 != null && list2.size() > 0 && list2.contains(getFileName(file2.getName()))) {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDataFromUri(@NonNull Uri uri) throws Throwable {
        BufferedInputStream bufferedInputStream;
        Exception e;
        InputStream inputStreamOpenInputStream;
        String streamData;
        InputStream inputStream = null;
        try {
            inputStreamOpenInputStream = this.contentResolver.openInputStream(uri);
        } catch (Exception e2) {
            bufferedInputStream = null;
            e = e2;
            inputStreamOpenInputStream = null;
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
            if (inputStream != null) {
            }
            if (bufferedInputStream == null) {
            }
        }
        try {
            bufferedInputStream = new BufferedInputStream(inputStreamOpenInputStream);
            try {
                try {
                    streamData = getStreamData(bufferedInputStream);
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused) {
                            Log.e(this.TAG, "inputStream close exception");
                        }
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused2) {
                        Log.e(this.TAG, "bInputStream close exception");
                    }
                } catch (Exception e3) {
                    e = e3;
                    Log.e(this.TAG, String.format("getDataFromUri %s Exception %s", uri, Log.getStackTraceString(e)));
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException unused3) {
                            Log.e(this.TAG, "inputStream close exception");
                        }
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused4) {
                            Log.e(this.TAG, "bInputStream close exception");
                        }
                    }
                    streamData = "";
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpenInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused5) {
                        Log.e(this.TAG, "inputStream close exception");
                    }
                }
                if (bufferedInputStream == null) {
                    throw th;
                }
                try {
                    bufferedInputStream.close();
                    throw th;
                } catch (IOException unused6) {
                    Log.e(this.TAG, "bInputStream close exception");
                    throw th;
                }
            }
        } catch (Exception e5) {
            bufferedInputStream = null;
            e = e5;
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
            inputStream = inputStreamOpenInputStream;
            if (inputStream != null) {
            }
            if (bufferedInputStream == null) {
            }
        }
        Log.v(this.TAG, "getDataFromUri result :" + streamData + ", srcUri : " + uri + ")");
        return streamData;
    }

    public int getExtDotIndex(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int iLastIndexOf = str.lastIndexOf(File.separatorChar);
        int iLastIndexOf2 = str.lastIndexOf(Extension.DOT);
        if (iLastIndexOf2 <= 0 || iLastIndexOf2 <= iLastIndexOf + 1) {
            return -1;
        }
        return iLastIndexOf2;
    }

    public String getFileExt(String str) {
        int extDotIndex = getExtDotIndex(str);
        return extDotIndex > 0 ? str.substring(extDotIndex + 1) : "";
    }

    public String getFileName(String str) {
        return getFileName(str, false);
    }

    public String getStreamData(InputStream inputStream) {
        StringBuilder sb;
        char[] cArr;
        if (inputStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            try {
                cArr = new char[2048];
                sb = null;
            } catch (IOException e) {
                e = e;
                sb = null;
            }
            while (true) {
                try {
                    int i = bufferedReader.read(cArr);
                    if (i > 0) {
                        if (sb == null) {
                            sb = new StringBuilder(2048);
                        }
                        sb.append(cArr, 0, i);
                    }
                } catch (IOException e2) {
                    e = e2;
                    Log.e(this.TAG, "getStreamData ex : " + Log.getStackTraceString(e));
                }
                try {
                    break;
                } catch (IOException unused) {
                    Log.e(this.TAG, "getStreamData close ex");
                }
            }
            bufferedReader.close();
            if (sb == null) {
                return null;
            }
            return sb.toString();
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.e(this.TAG, "getStreamData close ex");
            }
            throw th;
        }
    }

    public boolean mkFile(File file, String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            prepareOutFile(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
                    try {
                        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter, 32768);
                        try {
                            int length = str.length();
                            for (int i = 0; i < length; i += 32768) {
                                bufferedWriter.write(str, i, Math.min(32768, length - i));
                            }
                            bufferedWriter.close();
                            outputStreamWriter.close();
                            fileOutputStream.close();
                            return true;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } catch (IOException e) {
                Log.e(this.TAG, "mkFile", e);
            }
        }
        return false;
    }

    private boolean cpStream(InputStream inputStream, OutputStream outputStream, ProgressManager progressManager) throws FileShareException {
        long j;
        long j2;
        if (inputStream == null || outputStream == null) {
            Log.e(this.TAG, "cpStream Error : " + (outputStream == null ? "out" : "in") + " stream is null");
        } else {
            try {
                byte[] bArr = new byte[32768];
                long j3 = 0;
                loop0: while (true) {
                    j = j3;
                    do {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break loop0;
                        }
                        outputStream.write(bArr, 0, i);
                        j3 += (long) i;
                        j2 = j3 - j;
                    } while (j2 < 1048576);
                    if (progressManager != null) {
                        progressManager.updateTransferredSize(j2);
                    }
                }
                if (progressManager == null || j3 <= j) {
                    return true;
                }
                progressManager.updateTransferredSize(j3 - j);
                return true;
            } catch (Exception e) {
                Log.w(this.TAG, "cpStream Error", e);
                if (progressManager == null || !progressManager.hasCallback()) {
                    throw FileShareException.makeFileShareException("cpStream Error", 7);
                }
            }
        }
        return false;
    }

    public static String getFileName(String str, boolean z) {
        int iLastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String name = new File(str).getName();
        return !TextUtils.isEmpty(name) ? (!z || (iLastIndexOf = name.lastIndexOf(Extension.DOT)) <= 0) ? name : name.substring(0, iLastIndexOf) : "";
    }

    public boolean cpUriToFile(@NonNull Uri uri, @NonNull File file, ProgressManager progressManager) {
        String str;
        String str2;
        boolean zCpStream = false;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.contentResolver.openInputStream(uri));
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        OutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                        try {
                            zCpStream = cpStream(bufferedInputStream, bufferedOutputStream, progressManager);
                            if (progressManager != null) {
                                progressManager.updateTransferredCount(zCpStream);
                            }
                            bufferedOutputStream.close();
                            fileOutputStream.close();
                            bufferedInputStream.close();
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        bufferedInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                Log.w(this.TAG, String.format("cpUriToFile srcUri[%s], dstFile[%s]", uri, file), e);
                if (0 == 0 && file.length() <= 0) {
                    file.delete();
                    str = this.TAG;
                    str2 = String.format(Locale.ENGLISH, "cpUriToFile seems not a files srcUri[%s]", uri);
                }
            }
            if (!zCpStream && file.length() <= 0) {
                file.delete();
                str = this.TAG;
                str2 = String.format(Locale.ENGLISH, "cpUriToFile seems not a files srcUri[%s]", uri);
                Log.w(str, str2);
            }
            Log.v(this.TAG, String.format(Locale.ENGLISH, "cpUriToFile result[%s], srcUri[%s], dstFile[%s][%s]", Boolean.valueOf(zCpStream), uri, file, Long.valueOf(file.length())));
            return zCpStream;
        } catch (Throwable th3) {
            if (0 == 0 && file.length() <= 0) {
                file.delete();
                Log.w(this.TAG, String.format(Locale.ENGLISH, "cpUriToFile seems not a files srcUri[%s]", uri));
            }
            throw th3;
        }
    }

    public boolean copyFileToStream(File file, OutputStream outputStream) {
        return copyFileToStream(file, outputStream, null);
    }
}
