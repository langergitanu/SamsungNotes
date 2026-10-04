package com.google.android.play.core.splitcompat;

import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.internal.C5214ci;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.k */
/* JADX INFO: loaded from: classes5.dex */
public final class C5266k {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f3047a = 0;

    /* JADX INFO: renamed from: b */
    private static final Pattern f3048b = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* JADX INFO: renamed from: c */
    private final C5258c f3049c;

    public C5266k(C5258c c5258c) {
        this.f3049c = c5258c;
    }

    /* JADX INFO: renamed from: a */
    public final Set<File> m4093a() throws IOException {
        Log.d("SplitCompat", "NativeLibraryExtractor: synchronizing native libraries");
        Set<C5272q> setM4082d = this.f3049c.m4082d();
        for (String str : this.f3049c.m4084e()) {
            Iterator<C5272q> it = setM4082d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    AbstractC4539a.m3207q("NativeLibraryExtractor: extracted split '", str, "' has no corresponding split; deleting", "SplitCompat");
                    this.f3049c.m4083d(str);
                    break;
                }
                if (it.next().m4100b().equals(str)) {
                    break;
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (C5272q c5272q : setM4082d) {
            HashSet hashSet2 = new HashSet();
            m4091a(c5272q, new C5261f(this, hashSet2, c5272q));
            for (File file : this.f3049c.m4085e(c5272q.m4100b())) {
                if (!hashSet2.contains(file)) {
                    String absolutePath = file.getAbsolutePath();
                    String strM4100b = c5272q.m4100b();
                    AbstractC4539a.m3209s(AbstractC0000a.m16m("NativeLibraryExtractor: file '", absolutePath, "' found in split '", strM4100b, "' that is not in the split file '"), c5272q.m4099a().getAbsolutePath(), "'; removing", "SplitCompat");
                    this.f3049c.m4079b(file);
                }
            }
            hashSet.addAll(hashSet2);
        }
        return hashSet;
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ Set m4089a(C5266k c5266k, Set set, C5272q c5272q, ZipFile zipFile) {
        HashSet hashSet = new HashSet();
        c5266k.m4092a(c5272q, set, new C5262g(hashSet, c5272q, zipFile));
        return hashSet;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final Set<File> m4094a(C5272q c5272q) throws IOException {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        HashSet hashSet = new HashSet();
        m4091a(c5272q, new C5260e(this, c5272q, hashSet, atomicBoolean));
        if (atomicBoolean.get()) {
            return hashSet;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static void m4091a(C5272q c5272q, InterfaceC5263h interfaceC5263h) throws IOException {
        ZipFile zipFile;
        StringBuilder sb;
        try {
            zipFile = new ZipFile(c5272q.m4099a());
        } catch (IOException e) {
            e = e;
            zipFile = null;
        }
        try {
            String strM4100b = c5272q.m4100b();
            HashMap map = new HashMap();
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                Matcher matcher = f3048b.matcher(zipEntryNextElement.getName());
                if (matcher.matches()) {
                    String strGroup = matcher.group(1);
                    String strGroup2 = matcher.group(2);
                    Log.d("SplitCompat", "NativeLibraryExtractor: split '" + strM4100b + "' has native library '" + strGroup2 + "' for ABI '" + strGroup + "'");
                    Set hashSet = (Set) map.get(strGroup);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                        map.put(strGroup, hashSet);
                    }
                    hashSet.add(new C5265j(zipEntryNextElement, strGroup2));
                }
            }
            HashMap map2 = new HashMap();
            for (String str : Build.SUPPORTED_ABIS) {
                if (map.containsKey(str)) {
                    Log.d("SplitCompat", "NativeLibraryExtractor: there are native libraries for supported ABI " + str + "; will use this ABI");
                    for (C5265j c5265j : (Set) map.get(str)) {
                        if (map2.containsKey(c5265j.f3045a)) {
                            String str2 = c5265j.f3045a;
                            sb = new StringBuilder();
                            sb.append("NativeLibraryExtractor: skipping library ");
                            sb.append(str2);
                            sb.append(" for ABI ");
                            sb.append(str);
                            sb.append("; already present for a better ABI");
                        } else {
                            map2.put(c5265j.f3045a, c5265j);
                            String str3 = c5265j.f3045a;
                            sb = new StringBuilder();
                            sb.append("NativeLibraryExtractor: using library ");
                            sb.append(str3);
                            sb.append(" for ABI ");
                            sb.append(str);
                        }
                        Log.d("SplitCompat", sb.toString());
                    }
                } else {
                    Log.d("SplitCompat", "NativeLibraryExtractor: there are no native libraries for supported ABI " + str);
                }
            }
            interfaceC5263h.mo4088a(zipFile, new HashSet(map2.values()));
            zipFile.close();
        } catch (IOException e2) {
            e = e2;
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException e3) {
                    C5214ci.m3978a(e, e3);
                }
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m4092a(C5272q c5272q, Set<C5265j> set, InterfaceC5264i interfaceC5264i) {
        for (C5265j c5265j : set) {
            File fileM4075a = this.f3049c.m4075a(c5272q.m4100b(), c5265j.f3045a);
            boolean z = false;
            if (fileM4075a.exists() && fileM4075a.length() == c5265j.f3046b.getSize()) {
                z = true;
            }
            interfaceC5264i.mo4087a(c5265j, fileM4075a, z);
        }
    }
}
