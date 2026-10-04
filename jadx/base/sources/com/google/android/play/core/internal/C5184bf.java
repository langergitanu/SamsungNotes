package com.google.android.play.core.internal;

import com.google.android.play.core.splitinstall.C5309k;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bf */
/* JADX INFO: loaded from: classes5.dex */
final class C5184bf implements InterfaceC5172au {
    /* JADX INFO: renamed from: a */
    public static InterfaceC5177az m3922a() {
        return new C5181bc();
    }

    /* JADX INFO: renamed from: b */
    public static InterfaceC5183be m3924b() {
        return new C5182bd();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m3925b(ClassLoader classLoader, File file, File file2, boolean z) {
        return C5179ba.m3918a(classLoader, file, file2, z, m3922a(), "zip", C5179ba.m3919b());
    }

    @Override // com.google.android.play.core.internal.InterfaceC5172au
    /* JADX INFO: renamed from: a */
    public final void mo3908a(ClassLoader classLoader, Set<File> set) {
        m3923a(classLoader, set, m3924b());
    }

    /* JADX INFO: renamed from: a */
    public static void m3923a(ClassLoader classLoader, Set<File> set, InterfaceC5183be interfaceC5183be) {
        if (set.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getParentFile());
        }
        Object objM3917a = C5179ba.m3917a(classLoader);
        C5194bp c5194bpM3934a = C5195bq.m3934a(objM3917a, "nativeLibraryDirectories", List.class);
        synchronized (C5309k.class) {
            ArrayList arrayList = new ArrayList((Collection) c5194bpM3934a.m3929a());
            hashSet.removeAll(arrayList);
            arrayList.addAll(hashSet);
            c5194bpM3934a.m3930a(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Object[] objArrMo3921a = interfaceC5183be.mo3921a(objM3917a, new ArrayList<>(hashSet), arrayList2);
        if (arrayList2.isEmpty()) {
            synchronized (C5309k.class) {
                C5195bq.m3948b(objM3917a, "nativeLibraryPathElements", Object.class).m3933b(Arrays.asList(objArrMo3921a));
            }
            return;
        }
        C5193bo c5193bo = new C5193bo("Error in makePathElements");
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            C5214ci.m3978a(c5193bo, (IOException) arrayList2.get(i));
        }
        throw c5193bo;
    }

    @Override // com.google.android.play.core.internal.InterfaceC5172au
    /* JADX INFO: renamed from: a */
    public final boolean mo3909a(ClassLoader classLoader, File file, File file2, boolean z) {
        return m3925b(classLoader, file, file2, z);
    }
}
