package p187i1;

import com.samsung.android.app.notes.sync.network.multipart.FileItemStream$ItemSkippedException;
import com.samsung.android.app.notes.sync.network.multipart.MultipartStream$MalformedStreamException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: i1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12032a extends InputStream {

    /* JADX INFO: renamed from: a */
    public int f8797a;

    /* JADX INFO: renamed from: b */
    public int f8798b;

    /* JADX INFO: renamed from: c */
    public boolean f8799c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C12033b f8800d;

    public C12032a(C12033b c12033b) {
        this.f8800d = c12033b;
        m13723b();
    }

    @Override // java.io.InputStream
    public final int available() {
        int i;
        int i2 = this.f8798b;
        C12033b c12033b = this.f8800d;
        if (i2 == -1) {
            i2 = c12033b.f8813i - c12033b.f8812h;
            i = this.f8797a;
        } else {
            i = c12033b.f8812h;
        }
        return i2 - i;
    }

    /* JADX INFO: renamed from: b */
    public final void m13723b() {
        int i;
        C12033b c12033b = this.f8800d;
        int i2 = c12033b.f8812h;
        int i4 = 0;
        while (true) {
            if (i2 >= c12033b.f8813i) {
                i = -1;
                break;
            }
            while (i4 >= 0 && c12033b.f8811g[i2] != c12033b.f8808d[i4]) {
                i4 = c12033b.f8809e[i4];
            }
            i2++;
            i4++;
            int i5 = c12033b.f8806b;
            if (i4 == i5) {
                i = i2 - i5;
                break;
            }
        }
        this.f8798b = i;
        if (i == -1) {
            int i6 = c12033b.f8813i;
            int i7 = c12033b.f8812h;
            int i8 = i6 - i7;
            int i9 = c12033b.f8807c;
            if (i8 > i9) {
                this.f8797a = i9;
            } else {
                this.f8797a = i6 - i7;
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m13724c() throws IOException {
        int iAvailable;
        C12033b c12033b = this.f8800d;
        byte[] bArr = c12033b.f8811g;
        if (this.f8798b != -1) {
            return 0;
        }
        int i = c12033b.f8813i;
        int i2 = this.f8797a;
        System.arraycopy(bArr, i - i2, bArr, 0, i2);
        c12033b.f8812h = 0;
        c12033b.f8813i = this.f8797a;
        do {
            InputStream inputStream = c12033b.f8805a;
            int i4 = c12033b.f8813i;
            int i5 = inputStream.read(bArr, i4, c12033b.f8810f - i4);
            if (i5 == -1) {
                throw new MultipartStream$MalformedStreamException("Stream ended unexpectedly");
            }
            c12033b.f8813i += i5;
            m13723b();
            iAvailable = available();
            if (iAvailable > 0) {
                break;
            }
        } while (this.f8798b == -1);
        return iAvailable;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws FileItemStream$ItemSkippedException {
        if (this.f8799c) {
            return;
        }
        while (true) {
            int iAvailable = available();
            if (iAvailable == 0 && (iAvailable = m13724c()) == 0) {
                this.f8799c = true;
                return;
            }
            skip(iAvailable);
        }
    }

    @Override // java.io.InputStream
    public final int read() throws FileItemStream$ItemSkippedException {
        if (this.f8799c) {
            throw new FileItemStream$ItemSkippedException();
        }
        if (available() == 0 && m13724c() == 0) {
            return -1;
        }
        C12033b c12033b = this.f8800d;
        byte[] bArr = c12033b.f8811g;
        int i = c12033b.f8812h;
        c12033b.f8812h = i + 1;
        byte b = bArr[i];
        return b >= 0 ? b : b + 256;
    }

    @Override // java.io.InputStream
    public final long skip(long j) throws FileItemStream$ItemSkippedException {
        if (this.f8799c) {
            throw new FileItemStream$ItemSkippedException();
        }
        int iAvailable = available();
        if (iAvailable == 0 && (iAvailable = m13724c()) == 0) {
            return 0L;
        }
        long jMin = Math.min(iAvailable, j);
        C12033b c12033b = this.f8800d;
        c12033b.f8812h = (int) (((long) c12033b.f8812h) + jMin);
        return jMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws FileItemStream$ItemSkippedException {
        if (this.f8799c) {
            throw new FileItemStream$ItemSkippedException();
        }
        if (i2 == 0) {
            return 0;
        }
        int iAvailable = available();
        if (iAvailable == 0 && (iAvailable = m13724c()) == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i2);
        C12033b c12033b = this.f8800d;
        System.arraycopy(c12033b.f8811g, c12033b.f8812h, bArr, i, iMin);
        c12033b.f8812h += iMin;
        return iMin;
    }
}
