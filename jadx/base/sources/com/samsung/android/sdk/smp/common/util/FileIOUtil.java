package com.samsung.android.sdk.smp.common.util;

import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class FileIOUtil {
    private static final String TAG = "FileIOUtil";

    public static byte[] compress(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(new BufferedOutputStream(byteArrayOutputStream));
        gZIPOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static synchronized boolean deleteFiles(String str) {
        if (str == null) {
            return false;
        }
        try {
            File file = new File(str);
            boolean z = true;
            if (!file.exists()) {
                return true;
            }
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        if (!deleteFiles(file2.getAbsolutePath())) {
                            z = false;
                        }
                    } else if (!file2.delete()) {
                        z = false;
                    }
                }
            }
            return file.delete() ? z : false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized String findCertainExtension(String str, String str2, String[] strArr) {
        for (String str3 : strArr) {
            if (new File(str + "/" + str2 + Extension.DOT + str3).exists()) {
                return str + "/" + str2 + Extension.DOT + str3;
            }
        }
        return null;
    }

    private static synchronized String readFile(File file) {
        String string;
        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));
            while (true) {
                try {
                    String line = bufferedReader2.readLine();
                    if (line != null) {
                        sb.append(line);
                    } else {
                        string = sb.toString();
                        fileInputStream.close();
                        bufferedReader2.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    fileInputStream.close();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[Catch: all -> 0x00c5, SYNTHETIC, TRY_ENTER, TryCatch #2 {, blocks: (B:49:0x00c1, B:54:0x00c9, B:56:0x00ce, B:70:0x0102, B:72:0x0107, B:74:0x010c, B:75:0x010f, B:61:0x00f0, B:63:0x00f5, B:65:0x00fa), top: B:89:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0107 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized boolean unZip(ZipFile zipFile, String str, String str2) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream;
        int iLastIndexOf;
        ZipEntry entry;
        byte[] bArr;
        InputStream inputStream = null;
        try {
            iLastIndexOf = str.lastIndexOf(47);
            if (iLastIndexOf != -1) {
                String strSubstring = str.substring(0, iLastIndexOf);
                File file = new File(str2 + "/" + strSubstring);
                if (!file.exists() && !file.mkdirs()) {
                    SmpLog.m6501w(TAG, "unzip fail. cannot make directory:" + str2 + "/" + strSubstring);
                    return false;
                }
            }
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
            fileOutputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            fileOutputStream = null;
        }
        if (iLastIndexOf + 1 == str.length() || (entry = zipFile.getEntry(str)) == null) {
            byteArrayOutputStream = null;
            fileOutputStream = null;
        } else {
            InputStream inputStream2 = zipFile.getInputStream(entry);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bArr = new byte[1024];
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                fileOutputStream = null;
            }
            while (true) {
                int i = inputStream2.read(bArr);
                if (i <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
                inputStream = inputStream2;
                e = e;
                try {
                    SmpLog.m6494e(TAG, "unzip fail. " + e.toString());
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return false;
                } catch (Throwable th4) {
                    th = th4;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused4) {
                        }
                    }
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused5) {
                        }
                    }
                    if (fileOutputStream != null) {
                        throw th;
                    }
                    try {
                        fileOutputStream.close();
                        throw th;
                    } catch (IOException unused6) {
                        throw th;
                    }
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            fileOutputStream = new FileOutputStream(str2 + "/" + str);
            try {
                fileOutputStream.write(byteArray);
                inputStream = inputStream2;
            } catch (Exception e5) {
                e = e5;
            } catch (Throwable th5) {
                th = th5;
                inputStream = inputStream2;
                th = th;
                if (inputStream != null) {
                }
                if (byteArrayOutputStream != null) {
                }
                if (fileOutputStream != null) {
                }
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused7) {
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused8) {
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException unused9) {
            }
        }
        return true;
    }

    public static synchronized boolean unzip(String str, String str2, String str3) {
        ZipFile zipFile;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            SmpLog.m6494e(TAG, "unzip fail. invalid params");
            return false;
        }
        ZipFile zipFile2 = null;
        try {
            try {
                zipFile = new ZipFile(new File(str + "/" + str2));
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                if (!unZip(zipFile, enumerationEntries.nextElement().getName(), str3)) {
                    try {
                        zipFile.close();
                    } catch (IOException unused) {
                    }
                    return false;
                }
            }
            SmpLog.m6498i(TAG, "unzip success (" + str + "/" + str2 + ")");
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
            return true;
        } catch (Exception e2) {
            e = e2;
            zipFile2 = zipFile;
            SmpLog.m6494e(TAG, "unzip fail. " + e.toString());
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused3) {
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipFile2 = zipFile;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException unused4) {
                }
            }
            throw th;
        }
    }

    public static synchronized String readFile(String str) {
        File file;
        if (str != null) {
            try {
                file = new File(str);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            file = null;
        }
        return readFile(file);
    }
}
