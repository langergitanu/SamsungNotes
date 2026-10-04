package com.google.android.play.core.internal;

import android.util.Log;
import com.google.android.play.core.splitinstall.C5309k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ba */
/* JADX INFO: loaded from: classes5.dex */
final class C5179ba implements InterfaceC5172au {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5177az m3916a() {
        return new C5174aw();
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC5176ay m3919b() {
        return new C5175ax();
    }

    /* JADX INFO: renamed from: a */
    public static Object m3917a(ClassLoader classLoader) {
        return C5195bq.m3934a(classLoader, "pathList", Object.class).m3929a();
    }

    /* JADX INFO: renamed from: b */
    public static void m3920b(ClassLoader classLoader, Set<File> set) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (File file : set) {
            String strValueOf = String.valueOf(file.getParentFile().getAbsolutePath());
            Log.d("Splitcompat", strValueOf.length() != 0 ? "Adding native library parent directory: ".concat(strValueOf) : new String("Adding native library parent directory: "));
            hashSet.add(file.getParentFile());
        }
        C5194bp c5194bpM3948b = C5195bq.m3948b(m3917a(classLoader), "nativeLibraryDirectories", File.class);
        hashSet.removeAll(Arrays.asList((File[]) c5194bpM3948b.m3929a()));
        synchronized (C5309k.class) {
            int size = hashSet.size();
            StringBuilder sb = new StringBuilder(30);
            sb.append("Adding directories ");
            sb.append(size);
            Log.d("Splitcompat", sb.toString());
            c5194bpM3948b.m3933b(hashSet);
        }
    }

    @Override // com.google.android.play.core.internal.InterfaceC5172au
    /* JADX INFO: renamed from: a */
    public final void mo3908a(ClassLoader classLoader, Set<File> set) {
        m3920b(classLoader, set);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5172au
    /* JADX INFO: renamed from: a */
    public final boolean mo3909a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m3918a(classLoader, file, file2, z, m3916a(), "zip", m3919b());
    }

    /* JADX INFO: renamed from: a */
    public static boolean m3918a(ClassLoader classLoader, File file, File file2, boolean z, InterfaceC5177az interfaceC5177az, String str, InterfaceC5176ay interfaceC5176ay) {
        ArrayList<IOException> arrayList = new ArrayList<>();
        Object objM3917a = m3917a(classLoader);
        C5194bp c5194bpM3948b = C5195bq.m3948b(objM3917a, "dexElements", Object.class);
        List listAsList = Arrays.asList((Object[]) c5194bpM3948b.m3929a());
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            arrayList2.add((File) C5195bq.m3934a(it.next(), str, File.class).m3929a());
        }
        if (arrayList2.contains(file2)) {
            return true;
        }
        if (!z && !interfaceC5176ay.mo3915a(objM3917a, file2, file)) {
            String strValueOf = String.valueOf(file2.getPath());
            Log.w("SplitCompat", strValueOf.length() != 0 ? "Should be optimized ".concat(strValueOf) : new String("Should be optimized "));
            return false;
        }
        c5194bpM3948b.m3931a((Collection) Arrays.asList(interfaceC5177az.mo3914a(objM3917a, new ArrayList<>(Collections.singleton(file2)), file, arrayList)));
        if (arrayList.isEmpty()) {
            return true;
        }
        C5193bo c5193bo = new C5193bo("DexPathList.makeDexElement failed");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            IOException iOException = arrayList.get(i);
            Log.e("SplitCompat", "DexPathList.makeDexElement failed", iOException);
            C5214ci.m3978a(c5193bo, iOException);
        }
        C5195bq.m3948b(objM3917a, "dexElementsSuppressedExceptions", IOException.class).m3931a((Collection) arrayList);
        throw c5193bo;
    }
}
