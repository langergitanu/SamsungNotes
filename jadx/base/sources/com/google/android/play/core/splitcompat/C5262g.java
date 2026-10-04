package com.google.android.play.core.splitcompat;

import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.play.core.internal.C5214ci;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.google.android.play.core.splitcompat.g */
/* JADX INFO: loaded from: classes5.dex */
final class C5262g implements InterfaceC5264i {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ Set f3042a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ C5272q f3043b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ ZipFile f3044c;

    public C5262g(Set set, C5272q c5272q, ZipFile zipFile) {
        this.f3042a = set;
        this.f3043b = c5272q;
        this.f3044c = zipFile;
    }

    @Override // com.google.android.play.core.splitcompat.InterfaceC5264i
    /* JADX INFO: renamed from: a */
    public final void mo4087a(C5265j c5265j, File file, boolean z) throws IOException {
        this.f3042a.add(file);
        if (z) {
            return;
        }
        String strM4100b = this.f3043b.m4100b();
        String str = c5265j.f3045a;
        String absolutePath = this.f3043b.m4099a().getAbsolutePath();
        String name = c5265j.f3046b.getName();
        String absolutePath2 = file.getAbsolutePath();
        StringBuilder sbM16m = AbstractC0000a.m16m("NativeLibraryExtractor: split '", strM4100b, "' has native library '", str, "' that does not exist; extracting from '");
        AbstractC2821a.m2207B(sbM16m, absolutePath, "!", name, "' to '");
        AbstractC4539a.m3209s(sbM16m, absolutePath2, "'", "SplitCompat");
        ZipFile zipFile = this.f3044c;
        ZipEntry zipEntry = c5265j.f3046b;
        int i = C5266k.f3047a;
        byte[] bArr = new byte[4096];
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        fileOutputStream.close();
                        inputStream.close();
                        return;
                    }
                    fileOutputStream.write(bArr, 0, i2);
                } finally {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    C5214ci.m3978a(th, th2);
                }
            }
            throw th;
        }
    }
}
