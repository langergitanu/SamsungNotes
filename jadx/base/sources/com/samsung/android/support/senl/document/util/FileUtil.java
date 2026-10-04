package com.samsung.android.support.senl.document.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.document.delegator.DocumentLogger;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.lingala.zip4j.util.InternalZipConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    public static void concatFile(String str, String str2) throws IOException {
        if (!AbstractC2322a.m1607A(str)) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("concatFile() - Fail to load base file. [")));
        }
        if (!AbstractC2322a.m1607A(str2)) {
            throw new IOException(AbstractC6670b.m4743d(str2, "]", new StringBuilder("concatFile() - Fail to load extra file. [")));
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, InternalZipConstants.WRITE_MODE);
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, InternalZipConstants.WRITE_MODE);
        try {
            randomAccessFile.seek(randomAccessFile.length());
            while (true) {
                int i = randomAccessFile2.read();
                if (i == -1) {
                    return;
                } else {
                    randomAccessFile.write(i);
                }
            }
        } finally {
            randomAccessFile.close();
            randomAccessFile2.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void copyFile(File file, File file2) throws Throwable {
        FileOutputStream fileOutputStream;
        IOException e;
        FileInputStream fileInputStream;
        if (!file2.exists() && !file2.createNewFile()) {
            throw new IOException("Fail to create dest file. [" + SDocUtil.logPath(file2.getPath()) + "]");
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[10240];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            fileInputStream.close();
                            fileOutputStream2.close();
                            return;
                        }
                        fileOutputStream2.write(bArr, 0, i);
                    }
                } catch (IOException e2) {
                    e = e2;
                    DocumentLogger.m7179e(TAG, "copyFile() - " + e.toString());
                    throw new IOException("Fail to copy [" + SDocUtil.logPath(file.getPath()) + "] to [" + SDocUtil.logPath(file2.getPath()) + "].");
                }
            } catch (IOException e3) {
                e = e3;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileInputStream2 != null) {
            }
            if (fileOutputStream != null) {
            }
            throw th;
        }
    }

    public static void deleteFile(File file) {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                deleteFile(file2);
            }
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("Fail to delete [" + SDocUtil.logPath(file.getPath()) + "]");
    }

    public static void forceRenameTo(String str, String str2) throws IOException {
        if (str == null || str2 == null) {
            DocumentLogger.m7181i(TAG, "forceRenameTo() - Invalid argument.");
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            throw new IOException(AbstractC6670b.m4743d(str, "]", new StringBuilder("forceRenameTo() - Fail to get current path File. [")));
        }
        File file2 = new File(str2);
        if (file2.exists()) {
            if (file.equals(file2)) {
                return;
            } else {
                deleteFile(file2);
            }
        }
        if (file.renameTo(file2)) {
            return;
        }
        throw new IOException("forceRenameTo() - Cannot rename temp file [" + SDocUtil.logPath(str) + "] to [" + SDocUtil.logPath(str2) + "]");
    }

    public static long getAvailableInternalMemorySize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    public static StringBuilder getLogText(Context context) {
        File[] fileArrListFiles = new File(DocumentLogger.getLogFilePath(context)).listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            DocumentLogger.m7178d(TAG, "logText path is empty.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (File file : fileArrListFiles) {
            String name = file.getName();
            if (name.substring(name.lastIndexOf(Extension.DOT) + 1).equals("log") && file.exists()) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append(line);
                        sb.append("\n");
                    }
                    bufferedReader.close();
                    sb.append("\n");
                } catch (IOException e) {
                    AbstractC6670b.m4755p("getLogText : ", e, TAG);
                    return null;
                }
            }
        }
        return sb;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x017a A[Catch: IOException -> 0x017d, TRY_LEAVE, TryCatch #14 {IOException -> 0x017d, blocks: (B:124:0x0175, B:126:0x017a), top: B:138:0x0175 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0101 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0175 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0106 A[Catch: IOException -> 0x0109, TRY_LEAVE, TryCatch #7 {IOException -> 0x0109, blocks: (B:76:0x0101, B:78:0x0106), top: B:134:0x0101 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int copyFile(File file, File file2, boolean z, boolean z2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        byte[] bArr;
        int i = 0;
        if (!file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            FileInputStream fileInputStream3 = null;
            if (z2) {
                File file3 = new File(file2.toString().toLowerCase());
                if (z || !file3.exists()) {
                    File parentFile = file3.getParentFile();
                    if (parentFile != null) {
                        File file4 = new File(parentFile.toString().toLowerCase());
                        if (!file4.exists() && !file4.mkdirs()) {
                            return -1;
                        }
                    }
                    try {
                        try {
                            fileInputStream2 = new FileInputStream(file);
                            try {
                                fileOutputStream2 = new FileOutputStream(file3);
                                try {
                                    bArr = new byte[1024];
                                } catch (IOException e) {
                                    e = e;
                                    fileInputStream3 = fileInputStream2;
                                    try {
                                        i = e.getMessage().contains("ENOSPC") ? -4 : -1;
                                        if (fileInputStream3 != null) {
                                            fileInputStream3.close();
                                        }
                                        if (fileOutputStream2 != null) {
                                        }
                                        return i;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileInputStream3 != null) {
                                            try {
                                                fileInputStream3.close();
                                            } catch (IOException unused) {
                                                throw th;
                                            }
                                        }
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    fileInputStream3 = fileInputStream2;
                                    if (fileInputStream3 != null) {
                                    }
                                    if (fileOutputStream2 != null) {
                                    }
                                    throw th;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                fileOutputStream2 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream2 = null;
                            }
                        } catch (IOException unused2) {
                            i = -1;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        fileOutputStream2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream2 = null;
                    }
                    while (true) {
                        int i2 = fileInputStream2.read(bArr);
                        if (i2 <= 0) {
                            break;
                        }
                        fileOutputStream2.write(bArr, 0, i2);
                        fileOutputStream2.close();
                        return i;
                    }
                    fileInputStream2.close();
                    fileOutputStream2.close();
                    fileInputStream2.close();
                    fileOutputStream2.close();
                    return i;
                }
            } else if (z || !file2.exists()) {
                File parentFile2 = file2.getParentFile();
                if (parentFile2 != null && !parentFile2.exists() && !parentFile2.mkdirs()) {
                    return -1;
                }
                try {
                    try {
                        fileInputStream = new FileInputStream(file);
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                        } catch (IOException e5) {
                            e = e5;
                            fileOutputStream = null;
                        } catch (Throwable th5) {
                            th = th5;
                            fileOutputStream = null;
                        }
                    } catch (IOException unused3) {
                        return -1;
                    }
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream = null;
                }
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i4 = fileInputStream.read(bArr2);
                        if (i4 > 0) {
                            fileOutputStream.write(bArr2, 0, i4);
                        } else {
                            fileInputStream.close();
                            fileOutputStream.close();
                            fileInputStream.close();
                            fileOutputStream.close();
                            return 0;
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    fileInputStream3 = fileInputStream;
                    try {
                        int i5 = e.getMessage().contains("ENOSPC") ? -4 : -1;
                        if (fileInputStream3 != null) {
                            fileInputStream3.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return i5;
                    } catch (Throwable th7) {
                        th = th7;
                        if (fileInputStream3 != null) {
                            try {
                                fileInputStream3.close();
                            } catch (IOException unused4) {
                                throw th;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    fileInputStream3 = fileInputStream;
                    if (fileInputStream3 != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            }
        } else if (z2) {
            File file5 = new File(file2.toString().toLowerCase());
            if (!file5.exists() && !file5.mkdirs()) {
                return -1;
            }
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    copyFile(new File(file, str), new File(file5, str), z, true);
                }
            }
        } else {
            if (!file2.exists() && !file2.mkdirs()) {
                return -1;
            }
            String[] list2 = file.list();
            if (list2 != null) {
                for (String str2 : list2) {
                    copyFile(new File(file, str2), new File(file2, str2), z, false);
                }
            }
        }
        return 0;
    }
}
