package com.google.android.play.core.assetpacks;

import androidx.compose.runtime.AbstractC1974b;
import com.google.android.play.core.internal.AbstractC5206ca;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.be */
/* JADX INFO: loaded from: classes5.dex */
final class C5048be extends AbstractC5206ca {

    /* JADX INFO: renamed from: a */
    private final File f2608a;

    /* JADX INFO: renamed from: b */
    private final File f2609b;

    /* JADX INFO: renamed from: c */
    private final NavigableMap<Long, File> f2610c = new TreeMap();

    public C5048be(File file, File file2) throws IOException {
        this.f2608a = file;
        this.f2609b = file2;
        List<File> listM3822a = C5117dt.m3822a(file, file2);
        if (listM3822a.isEmpty()) {
            throw new C5065bv(String.format("Virtualized slice archive empty for %s, %s", file, file2));
        }
        int size = listM3822a.size();
        long length = 0;
        for (int i = 0; i < size; i++) {
            File file3 = listM3822a.get(i);
            this.f2610c.put(Long.valueOf(length), file3);
            length += file3.length();
        }
    }

    @Override // com.google.android.play.core.internal.AbstractC5206ca
    /* JADX INFO: renamed from: a */
    public final long mo3720a() {
        Map.Entry<Long, File> entryLastEntry = this.f2610c.lastEntry();
        return entryLastEntry.getValue().length() + entryLastEntry.getKey().longValue();
    }

    @Override // com.google.android.play.core.internal.AbstractC5206ca
    /* JADX INFO: renamed from: a */
    public final InputStream mo3721a(long j, long j2) {
        if (j < 0 || j2 < 0) {
            StringBuilder sbM1323p = AbstractC1974b.m1323p(j, "Invalid input parameters ", SQLKeyword.COMMA);
            sbM1323p.append(j2);
            throw new C5065bv(sbM1323p.toString());
        }
        long j3 = j + j2;
        if (j3 > mo3720a()) {
            StringBuilder sbM1323p2 = AbstractC1974b.m1323p(mo3720a(), "Trying to access archive out of bounds. Archive ends at: ", ". Tried accessing: ");
            sbM1323p2.append(j3);
            throw new C5065bv(sbM1323p2.toString());
        }
        Long lFloorKey = this.f2610c.floorKey(Long.valueOf(j));
        Long lFloorKey2 = this.f2610c.floorKey(Long.valueOf(j3));
        if (lFloorKey.equals(lFloorKey2)) {
            return new C5047bd(m3719a(j, lFloorKey), j2);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(m3719a(j, lFloorKey));
        Collection<File> collectionValues = this.f2610c.subMap(lFloorKey, false, lFloorKey2, false).values();
        if (!collectionValues.isEmpty()) {
            arrayList.add(new C5100dc(Collections.enumeration(collectionValues)));
        }
        arrayList.add(new C5047bd(new FileInputStream(this.f2610c.get(lFloorKey2)), j2 - (lFloorKey2.longValue() - j)));
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    /* JADX INFO: renamed from: a */
    private final InputStream m3719a(long j, Long l) {
        FileInputStream fileInputStream = new FileInputStream(this.f2610c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new C5065bv("Virtualized slice archive corrupt, could not skip in file with key " + l);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
