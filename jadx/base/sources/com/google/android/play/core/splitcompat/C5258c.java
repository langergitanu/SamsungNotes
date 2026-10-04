package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.google.android.play.core.internal.C5173av;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.c */
/* JADX INFO: loaded from: classes5.dex */
public final class C5258c {

    /* JADX INFO: renamed from: a */
    private final long f3031a;

    /* JADX INFO: renamed from: b */
    private final Context f3032b;

    /* JADX INFO: renamed from: c */
    private File f3033c;

    public C5258c(Context context) {
        this.f3032b = context;
        this.f3031a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
    }

    /* JADX INFO: renamed from: f */
    private final File m4067f() throws IOException {
        File file = new File(m4068g(), "verified-splits");
        m4066d(file);
        return file;
    }

    /* JADX INFO: renamed from: g */
    private final File m4068g() throws IOException {
        File file = new File(m4070h(), Long.toString(this.f3031a));
        m4066d(file);
        return file;
    }

    /* JADX INFO: renamed from: h */
    private final File m4070h() throws IOException {
        if (this.f3033c == null) {
            Context context = this.f3032b;
            if (context == null) {
                throw new IllegalStateException("context must be non-null to populate null filesDir");
            }
            this.f3033c = context.getFilesDir();
        }
        File file = new File(this.f3033c, "splitcompat");
        m4066d(file);
        return file;
    }

    /* JADX INFO: renamed from: i */
    private final File m4072i() throws IOException {
        File file = new File(m4068g(), "native-libraries");
        m4066d(file);
        return file;
    }

    /* JADX INFO: renamed from: a */
    public final File m4073a(File file) {
        return m4064a(m4067f(), file.getName());
    }

    /* JADX INFO: renamed from: b */
    public final File m4077b() {
        return new File(m4068g(), "lock.tmp");
    }

    /* JADX INFO: renamed from: c */
    public final File m4080c() throws IOException {
        File file = new File(m4068g(), "unverified-splits");
        m4066d(file);
        return file;
    }

    /* JADX INFO: renamed from: d */
    public final Set<C5272q> m4082d() {
        File fileM4067f = m4067f();
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = fileM4067f.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile() && file.getName().endsWith(".apk")) {
                    hashSet.add(new C5272q(file, file.getName().substring(0, r6.length() - 4)));
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: e */
    public final List<String> m4084e() {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = m4072i().listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isDirectory()) {
                    arrayList.add(file.getName());
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static File m4064a(File file, String str) {
        File file2 = new File(file, str);
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            return file2;
        }
        throw new IllegalArgumentException("split ID cannot be placed in target directory");
    }

    /* JADX INFO: renamed from: d */
    private static void m4066d(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IllegalArgumentException("File input must be directory when it exists.");
            }
        } else {
            file.mkdirs();
            if (file.isDirectory()) {
                return;
            }
            String strValueOf = String.valueOf(file.getAbsolutePath());
            throw new IOException(strValueOf.length() != 0 ? "Unable to create directory: ".concat(strValueOf) : new String("Unable to create directory: "));
        }
    }

    /* JADX INFO: renamed from: g */
    private final File m4069g(String str) throws IOException {
        File fileM4064a = m4064a(m4072i(), str);
        m4066d(fileM4064a);
        return fileM4064a;
    }

    /* JADX INFO: renamed from: h */
    private static String m4071h(String str) {
        return String.valueOf(str).concat(".apk");
    }

    /* JADX INFO: renamed from: b */
    public final File m4078b(String str) {
        return m4064a(m4067f(), m4071h(str));
    }

    /* JADX INFO: renamed from: c */
    public final File m4081c(String str) throws IOException {
        File file = new File(m4068g(), "dex");
        m4066d(file);
        File fileM4064a = m4064a(file, str);
        m4066d(fileM4064a);
        return fileM4064a;
    }

    /* JADX INFO: renamed from: e */
    public final Set<File> m4085e(String str) {
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = m4069g(str).listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (file.isFile()) {
                    hashSet.add(file);
                }
            }
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: f */
    public final void m4086f(String str) throws IOException {
        m4065c(m4078b(str));
    }

    /* JADX INFO: renamed from: c */
    public static void m4065c(File file) throws IOException {
        File[] fileArrListFiles;
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                m4065c(file2);
            }
        }
        if (file.exists() && !file.delete()) {
            throw new IOException(AbstractC0541b.m773o("Failed to delete '", file.getAbsolutePath(), "'"));
        }
    }

    /* JADX INFO: renamed from: a */
    public final File m4074a(String str) {
        return m4064a(m4080c(), m4071h(str));
    }

    /* JADX INFO: renamed from: b */
    public final void m4079b(File file) {
        C5173av.m3913a(file.getParentFile().getParentFile().equals(m4072i()), "File to remove is not a native library");
        m4065c(file);
    }

    /* JADX INFO: renamed from: d */
    public final void m4083d(String str) {
        m4065c(m4069g(str));
    }

    /* JADX INFO: renamed from: a */
    public final File m4075a(String str, String str2) {
        return m4064a(m4069g(str), str2);
    }

    /* JADX INFO: renamed from: a */
    public final void m4076a() throws IOException {
        File fileM4070h = m4070h();
        String[] list = fileM4070h.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals(Long.toString(this.f3031a))) {
                    File file = new File(fileM4070h, str);
                    String strValueOf = String.valueOf(file);
                    long j = this.f3031a;
                    StringBuilder sb = new StringBuilder(strValueOf.length() + 118);
                    AbstractC1974b.m1332y(sb, "FileStorage: removing directory for different version code (directory = ", strValueOf, ", current version code = ");
                    sb.append(j);
                    sb.append(")");
                    Log.d("SplitCompat", sb.toString());
                    m4065c(file);
                }
            }
        }
    }
}
