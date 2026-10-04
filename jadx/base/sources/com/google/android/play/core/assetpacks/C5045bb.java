package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.annotation.Nullable;
import com.google.android.play.core.internal.C5157af;
import com.google.android.play.core.internal.C5214ci;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bb */
/* JADX INFO: loaded from: classes5.dex */
final class C5045bb {

    /* JADX INFO: renamed from: a */
    private static final C5157af f2599a = new C5157af("AssetPackStorage");

    /* JADX INFO: renamed from: b */
    private static final long f2600b;

    /* JADX INFO: renamed from: c */
    private static final long f2601c;

    /* JADX INFO: renamed from: d */
    private final Context f2602d;

    /* JADX INFO: renamed from: e */
    private final C5109dl f2603e;

    static {
        TimeUnit timeUnit = TimeUnit.DAYS;
        f2600b = timeUnit.toMillis(14L);
        f2601c = timeUnit.toMillis(28L);
    }

    public C5045bb(Context context, C5109dl c5109dl) {
        this.f2602d = context;
        this.f2603e = c5109dl;
    }

    /* JADX INFO: renamed from: b */
    private static long m3683b(File file) {
        if (!file.exists()) {
            return -1L;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (File file2 : file.listFiles()) {
                if (!file2.getName().equals("stale.tmp")) {
                    arrayList.add(Long.valueOf(file2.getName()));
                }
            }
        } catch (NumberFormatException e) {
            f2599a.m3876a(e, "Corrupt asset pack directories.", new Object[0]);
        }
        if (arrayList.isEmpty()) {
            return -1L;
        }
        Collections.sort(arrayList);
        return ((Long) arrayList.get(arrayList.size() - 1)).longValue();
    }

    /* JADX INFO: renamed from: g */
    private final File m3685g(String str) {
        return new File(m3690i(), str);
    }

    /* JADX INFO: renamed from: h */
    private final File m3688h() {
        return new File(m3690i(), "_tmp");
    }

    /* JADX INFO: renamed from: i */
    private final File m3690i() {
        return new File(this.f2602d.getFilesDir(), "assetpacks");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006a  */
    @Nullable
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AssetLocation m3691a(String str, String str2) {
        PackageInfo packageInfo;
        ArrayList arrayList;
        String str3;
        String strConcat;
        int i = 0;
        try {
            packageInfo = this.f2602d.getPackageManager().getPackageInfo(this.f2602d.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            f2599a.m3877b("Could not find PackageInfo.", new Object[0]);
            packageInfo = null;
        }
        if (packageInfo == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            String[] strArr = packageInfo.splitNames;
            if (strArr == null || packageInfo.applicationInfo.splitSourceDirs == null) {
                f2599a.m3875a("No splits present for package %s.", str);
            } else {
                int iBinarySearch = Arrays.binarySearch(strArr, str);
                if (iBinarySearch < 0) {
                    f2599a.m3875a("Asset Pack '%s' is not installed.", str);
                } else {
                    str3 = packageInfo.applicationInfo.splitSourceDirs[iBinarySearch];
                    if (str3 != null) {
                        arrayList.add(packageInfo.applicationInfo.sourceDir);
                        strConcat = "config.";
                    } else {
                        arrayList.add(str3);
                        strConcat = String.valueOf(str).concat(".config.");
                    }
                    arrayList.addAll(m3681a(packageInfo, strConcat));
                }
            }
            str3 = null;
            if (str3 != null) {
            }
            arrayList.addAll(m3681a(packageInfo, strConcat));
        }
        if (arrayList == null) {
            return null;
        }
        String path = new File("assets", str2).getPath();
        int size = arrayList.size();
        while (i < size) {
            String str4 = (String) arrayList.get(i);
            try {
                AssetLocation assetLocationM3780a = C5099db.m3780a(str4, path);
                i++;
                if (assetLocationM3780a != null) {
                    return assetLocationM3780a;
                }
            } catch (IOException e) {
                f2599a.m3876a(e, "Failed to parse APK file '%s' looking for asset '%s'.", str4, str2);
                return null;
            }
        }
        f2599a.m3875a("The asset %s is not present in Asset Pack %s. Searched in APKs: %s", str2, str, arrayList);
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final File m3703c(String str, int i, long j) {
        return new File(m3689h(str, i, j), "_packs");
    }

    /* JADX INFO: renamed from: d */
    public final int m3707d(String str, int i, long j) throws IOException {
        File fileM3686g = m3686g(str, i, j);
        if (!fileM3686g.exists()) {
            return 0;
        }
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(fileM3686g);
        try {
            properties.load(fileInputStream);
            fileInputStream.close();
            if (properties.getProperty("numberOfMerges") == null) {
                throw new C5065bv("Merge checkpoint file corrupt.");
            }
            try {
                return Integer.parseInt(properties.getProperty("numberOfMerges"));
            } catch (NumberFormatException e) {
                throw new C5065bv("Merge checkpoint file corrupt.", e);
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                C5214ci.m3978a(th, th2);
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m3711e(String str) {
        return (int) m3683b(m3685g(str));
    }

    /* JADX INFO: renamed from: f */
    public final long m3715f(String str) {
        return m3683b(m3680a(str, m3711e(str)));
    }

    /* JADX INFO: renamed from: g */
    private final File m3686g(String str, int i, long j) {
        return new File(m3703c(str, i, j), "merge.tmp");
    }

    /* JADX INFO: renamed from: h */
    private final File m3689h(String str, int i, long j) {
        return new File(new File(new File(m3688h(), str), String.valueOf(i)), String.valueOf(j));
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final AssetLocation m3692a(String str, String str2, AssetPackLocation assetPackLocation) {
        File file = new File(assetPackLocation.assetsPath(), str2);
        if (file.exists()) {
            return AssetLocation.m3617a(file.getPath(), 0L, file.length());
        }
        f2599a.m3875a("The asset %s is not present in Asset Pack %s. Searched in folder: %s", str2, str, assetPackLocation.assetsPath());
        return null;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public final AssetPackLocation m3699b(String str) {
        String strM3705c = m3705c(str);
        if (strM3705c == null) {
            return null;
        }
        File file = new File(strM3705c, "assets");
        if (file.isDirectory()) {
            return AssetPackLocation.m3622a(strM3705c, file.getCanonicalPath());
        }
        f2599a.m3877b("Failed to find assets directory: %s", file);
        return null;
    }

    /* JADX INFO: renamed from: c */
    public final File m3704c(String str, int i, long j, String str2) {
        return new File(m3716f(str, i, j, str2), "checkpoint.dat");
    }

    /* JADX INFO: renamed from: d */
    public final File m3708d(String str, int i, long j, String str2) {
        return new File(m3716f(str, i, j, str2), "checkpoint_ext.dat");
    }

    /* JADX INFO: renamed from: e */
    public final File m3712e(String str, int i, long j) {
        return new File(new File(m3689h(str, i, j), "_slices"), "_metadata");
    }

    /* JADX INFO: renamed from: f */
    public final File m3716f(String str, int i, long j, String str2) {
        return new File(m3712e(str, i, j), str2);
    }

    /* JADX INFO: renamed from: a */
    private final File m3680a(String str, int i) {
        return new File(m3685g(str), String.valueOf(i));
    }

    /* JADX INFO: renamed from: g */
    private final List<File> m3687g() {
        ArrayList arrayList = new ArrayList();
        try {
            if (m3690i().exists() && m3690i().listFiles() != null) {
                for (File file : m3690i().listFiles()) {
                    if (!file.getCanonicalPath().equals(m3688h().getCanonicalPath())) {
                        arrayList.add(file);
                    }
                }
            }
            return arrayList;
        } catch (IOException e) {
            f2599a.m3877b("Could not process directory while scanning installed packs. %s", e);
            return arrayList;
        }
    }

    /* JADX INFO: renamed from: b */
    public final File m3700b(String str, int i, long j) {
        return new File(m3693a(str, i, j), "_metadata");
    }

    @Nullable
    /* JADX INFO: renamed from: c */
    public final String m3705c(String str) {
        int length;
        File file = new File(m3690i(), str);
        if (!file.exists()) {
            f2599a.m3875a("Pack not found with pack name: %s", str);
            return null;
        }
        File file2 = new File(file, String.valueOf(this.f2603e.m3800a()));
        if (!file2.exists()) {
            f2599a.m3875a("Pack not found with pack name: %s app version: %s", str, Integer.valueOf(this.f2603e.m3800a()));
            return null;
        }
        File[] fileArrListFiles = file2.listFiles();
        if (fileArrListFiles == null || (length = fileArrListFiles.length) == 0) {
            f2599a.m3875a("No pack version found for pack name: %s app version: %s", str, Integer.valueOf(this.f2603e.m3800a()));
            return null;
        }
        if (length <= 1) {
            return fileArrListFiles[0].getCanonicalPath();
        }
        f2599a.m3877b("Multiple pack versions found for pack name: %s app version: %s", str, Integer.valueOf(this.f2603e.m3800a()));
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final void m3709d() {
        List<File> listM3687g = m3687g();
        int size = listM3687g.size();
        for (int i = 0; i < size; i++) {
            File file = listM3687g.get(i);
            if (file.listFiles() != null) {
                for (File file2 : file.listFiles()) {
                    File file3 = new File(file2, "stale.tmp");
                    if (file3.exists() && System.currentTimeMillis() - file3.lastModified() > f2601c) {
                        m3684c(file2);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final File m3713e(String str, int i, long j, String str2) {
        return new File(m3716f(str, i, j, str2), "slice.zip");
    }

    /* JADX INFO: renamed from: f */
    public final void m3717f() {
        m3684c(m3690i());
    }

    /* JADX INFO: renamed from: a */
    public final File m3693a(String str, int i, long j) {
        return new File(m3680a(str, i), String.valueOf(j));
    }

    /* JADX INFO: renamed from: b */
    public final File m3701b(String str, int i, long j, String str2) {
        return new File(new File(new File(m3689h(str, i, j), "_slices"), "_verified"), str2);
    }

    /* JADX INFO: renamed from: c */
    public final void m3706c() {
        List<File> listM3687g = m3687g();
        int size = listM3687g.size();
        for (int i = 0; i < size; i++) {
            File file = listM3687g.get(i);
            if (file.listFiles() != null) {
                m3682a(file);
                long jM3683b = m3683b(file);
                if (this.f2603e.m3800a() != jM3683b) {
                    try {
                        new File(new File(file, String.valueOf(jM3683b)), "stale.tmp").createNewFile();
                    } catch (IOException unused) {
                        f2599a.m3877b("Could not write staleness marker.", new Object[0]);
                    }
                }
                for (File file2 : file.listFiles()) {
                    m3682a(file2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m3710d(String str) {
        if (m3685g(str).exists()) {
            return m3684c(m3685g(str));
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    public final void m3714e() {
        if (m3688h().exists()) {
            for (File file : m3688h().listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() > f2600b) {
                    m3684c(file);
                } else {
                    m3682a(file);
                }
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m3718f(String str, int i, long j) {
        if (m3689h(str, i, j).exists()) {
            m3684c(m3689h(str, i, j));
        }
    }

    /* JADX INFO: renamed from: c */
    private static boolean m3684c(File file) {
        boolean zM3684c;
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            zM3684c = true;
            for (File file2 : fileArrListFiles) {
                zM3684c &= m3684c(file2);
            }
        } else {
            zM3684c = true;
        }
        return file.delete() && true == zM3684c;
    }

    /* JADX INFO: renamed from: a */
    public final File m3694a(String str, int i, long j, String str2) {
        return new File(new File(new File(m3689h(str, i, j), "_slices"), "_unverified"), str2);
    }

    /* JADX INFO: renamed from: b */
    public final Map<String, Long> m3702b() {
        HashMap map = new HashMap();
        for (String str : m3695a().keySet()) {
            map.put(str, Long.valueOf(m3715f(str)));
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m3681a(PackageInfo packageInfo, String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArr = packageInfo.splitNames;
        if (strArr != null) {
            int i = (-Arrays.binarySearch(strArr, str)) - 1;
            while (true) {
                String[] strArr2 = packageInfo.splitNames;
                if (i >= strArr2.length || !strArr2[i].startsWith(str)) {
                    break;
                }
                arrayList.add(packageInfo.applicationInfo.splitSourceDirs[i]);
                i++;
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public final Map<String, AssetPackLocation> m3695a() {
        HashMap map = new HashMap();
        try {
            for (File file : m3687g()) {
                AssetPackLocation assetPackLocationM3699b = m3699b(file.getName());
                if (assetPackLocationM3699b != null) {
                    map.put(file.getName(), assetPackLocationM3699b);
                }
            }
            return map;
        } catch (IOException e) {
            f2599a.m3877b("Could not process directory while scanning installed packs: %s", e);
            return map;
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m3682a(File file) {
        if (file.listFiles() == null || file.listFiles().length <= 1) {
            return;
        }
        long jM3683b = m3683b(file);
        for (File file2 : file.listFiles()) {
            if (!file2.getName().equals(String.valueOf(jM3683b)) && !file2.getName().equals("stale.tmp")) {
                m3684c(file2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3696a(String str, int i, long j, int i2) throws IOException {
        File fileM3686g = m3686g(str, i, j);
        Properties properties = new Properties();
        properties.put("numberOfMerges", String.valueOf(i2));
        fileM3686g.getParentFile().mkdirs();
        fileM3686g.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(fileM3686g);
        properties.store(fileOutputStream, (String) null);
        fileOutputStream.close();
    }

    /* JADX INFO: renamed from: a */
    public final void m3697a(List<String> list) {
        int iM3800a = this.f2603e.m3800a();
        List<File> listM3687g = m3687g();
        int size = listM3687g.size();
        for (int i = 0; i < size; i++) {
            File file = listM3687g.get(i);
            if (!list.contains(file.getName()) && m3683b(file) != iM3800a) {
                m3684c(file);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m3698a(String str) {
        return m3705c(str) != null;
    }
}
