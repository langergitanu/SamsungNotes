package com.google.android.play.core.assetpacks;

import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.play.core.internal.InterfaceC5215cj;
import com.google.android.play.core.tasks.Tasks;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/* JADX INFO: renamed from: com.google.android.play.core.assetpacks.bk */
/* JADX INFO: loaded from: classes5.dex */
final class C5054bk {

    /* JADX INFO: renamed from: a */
    private final InterfaceC5215cj<InterfaceC5141w> f2627a;

    public C5054bk(InterfaceC5215cj<InterfaceC5141w> interfaceC5215cj) {
        this.f2627a = interfaceC5215cj;
    }

    /* JADX INFO: renamed from: a */
    public final InputStream m3722a(int i, String str, String str2, int i2) {
        try {
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) Tasks.await(this.f2627a.m3979a().mo3673b(i, str, str2, i2));
            if (parcelFileDescriptor != null && parcelFileDescriptor.getFileDescriptor() != null) {
                return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            }
            throw new C5065bv("Corrupted ParcelFileDescriptor, session " + i + " packName " + str + " sliceId " + str2 + ", chunkNumber " + i2, i);
        } catch (InterruptedException e) {
            throw new C5065bv("Extractor was interrupted while waiting for chunk file.", e, i);
        } catch (ExecutionException e2) {
            StringBuilder sbM1629s = AbstractC2322a.m1629s("Error opening chunk file, session ", i, " packName ", str, " sliceId ");
            sbM1629s.append(str2);
            sbM1629s.append(", chunkNumber ");
            sbM1629s.append(i2);
            throw new C5065bv(sbM1629s.toString(), e2, i);
        }
    }
}
