package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.document.util.SDocUtil;
import com.samsung.android.support.senl.document.util.ZipUtil;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import p042J1.AbstractC0156n;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ZipUtilContractImpl {
    public String getUnzippedFileName() {
        return AbstractC0156n.f479a;
    }

    public void oldZip(String str, String str2) {
        ZipUtil.zip(str, str2);
    }

    /* JADX WARN: Finally extract failed */
    public void unzip(File file, File file2, boolean z, boolean z2) throws IOException {
        if (file == null) {
            throw new IOException("unzip() - zipFile can not be null.");
        }
        if (file2 == null) {
            throw new IOException("unzip() - targetDir can not be null.");
        }
        StringBuilder sb = new StringBuilder("unzip() - start, zipFile = [");
        sb.append(SDocUtil.logPath(file.getAbsolutePath()));
        sb.append("], targetDir = [");
        sb.append(SDocUtil.logPath(file2.getAbsolutePath() + "],  " + z + SQLKeyword.COMMA + z2));
        Debugger.m8607d("ZipUtil", sb.toString());
        AbstractC0156n.f479a = null;
        AbstractC0156n.m405a(file2);
        try {
            ZipFile zipFile = new ZipFile(file);
            try {
                String str = file2.getAbsolutePath() + File.separator;
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                String canonicalPath = file2.getCanonicalPath();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    String name = zipEntryNextElement.getName();
                    Debugger.m8607d("ZipUtil", "unzip() - [" + SDocUtil.logPath(name) + "], size = [" + zipEntryNextElement.getSize() + "]");
                    AbstractC0156n.f479a = name;
                    StringBuilder sb2 = new StringBuilder(str);
                    if (z) {
                        sb2.append(name.toLowerCase(Locale.getDefault()));
                    } else {
                        sb2.append(name);
                    }
                    String string = sb2.toString();
                    File file3 = new File(string);
                    if (!file3.getCanonicalPath().startsWith(canonicalPath)) {
                        throw new IOException("unzip() - fail relative path!");
                    }
                    if (!z2 && file3.exists() && file3.length() > 0 && !"fileinfo.dat".equals(name)) {
                        Debugger.m8607d("ZipUtil", "unzip() - skip [" + SDocUtil.logPath(string) + "], size = [" + file3.length() + "]");
                    } else if (zipEntryNextElement.isDirectory()) {
                        AbstractC0156n.m405a(file3);
                    } else {
                        File parentFile = file3.getParentFile();
                        if (parentFile != null) {
                            AbstractC0156n.m405a(parentFile);
                        }
                        InputStream inputStream = zipFile.getInputStream(zipEntryNextElement);
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(string));
                            try {
                                byte[] bArr = new byte[10240];
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i < 0) {
                                        break;
                                    } else {
                                        bufferedOutputStream.write(bArr, 0, i);
                                    }
                                }
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                inputStream.close();
                            } catch (Throwable th) {
                                try {
                                    bufferedOutputStream.close();
                                    throw th;
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                    throw th;
                                }
                            }
                        } finally {
                        }
                    }
                }
                zipFile.close();
            } catch (Throwable th3) {
                try {
                    zipFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (ZipException e) {
            throw new ZipException("Fail to unzip [" + SDocUtil.logPath(file.getAbsolutePath()) + "]\n" + e.toString());
        } catch (IOException e2) {
            throw new IOException("Fail to unzip [" + SDocUtil.logPath(file.getAbsolutePath()) + "]\n" + e2.toString());
        } catch (Exception e3) {
            AbstractC4539a.m3213w(e3, new StringBuilder("unzip() - Exception = "), "ZipUtil");
        }
    }

    public void zip(String str, String str2) {
        File parentFile = new File(str2).getParentFile();
        if (parentFile != null) {
            AbstractC0156n.m405a(parentFile);
        }
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str2)));
        try {
            zipOutputStream.setMethod(8);
            zipOutputStream.setLevel(1);
            File file = new File(str);
            AbstractC0156n.m406b(file, file.getName(), zipOutputStream);
            zipOutputStream.finish();
            zipOutputStream.close();
        } catch (Throwable th) {
            try {
                zipOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
