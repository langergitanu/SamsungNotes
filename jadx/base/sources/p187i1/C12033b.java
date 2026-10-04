package p187i1;

import com.samsung.android.app.notes.sync.network.multipart.FileUploadIOException;
import com.samsung.android.app.notes.sync.network.multipart.MultipartStream$MalformedStreamException;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: renamed from: i1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12033b {

    /* JADX INFO: renamed from: j */
    public static final byte[] f8801j = {13, 10, 13, 10};

    /* JADX INFO: renamed from: k */
    public static final byte[] f8802k = {13, 10};

    /* JADX INFO: renamed from: l */
    public static final byte[] f8803l = {45, 45};

    /* JADX INFO: renamed from: m */
    public static final byte[] f8804m = {13, 10, 45, 45};

    /* JADX INFO: renamed from: a */
    public final InputStream f8805a;

    /* JADX INFO: renamed from: b */
    public int f8806b;

    /* JADX INFO: renamed from: c */
    public final int f8807c;

    /* JADX INFO: renamed from: d */
    public final byte[] f8808d;

    /* JADX INFO: renamed from: e */
    public final int[] f8809e;

    /* JADX INFO: renamed from: f */
    public final int f8810f;

    /* JADX INFO: renamed from: g */
    public final byte[] f8811g;

    /* JADX INFO: renamed from: h */
    public int f8812h;

    /* JADX INFO: renamed from: i */
    public int f8813i;

    public C12033b(InputStream inputStream, byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("boundary may not be null");
        }
        int length = bArr.length;
        int i = length + 4;
        this.f8806b = i;
        if (4096 < length + 5) {
            throw new IllegalArgumentException("The buffer size specified for the MultipartStream is too small");
        }
        this.f8805a = inputStream;
        int iMax = Math.max(4096, i * 2);
        this.f8810f = iMax;
        this.f8811g = new byte[iMax];
        int i2 = this.f8806b;
        byte[] bArr2 = new byte[i2];
        this.f8808d = bArr2;
        this.f8809e = new int[i2 + 1];
        this.f8807c = i2;
        System.arraycopy(f8804m, 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        m13725a();
        this.f8812h = 0;
        this.f8813i = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m13725a() {
        int[] iArr = this.f8809e;
        iArr[0] = -1;
        iArr[1] = 0;
        int i = 2;
        int i2 = 0;
        while (i <= this.f8806b) {
            byte[] bArr = this.f8808d;
            if (bArr[i - 1] == bArr[i2]) {
                i2++;
                iArr[i] = i2;
            } else if (i2 > 0) {
                i2 = iArr[i2];
            } else {
                iArr[i] = 0;
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m13726b(ByteArrayOutputStream byteArrayOutputStream) {
        C12032a c12032a = new C12032a(this);
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            try {
                int i = c12032a.read(bArr);
                if (i == -1) {
                    break;
                }
                if (i > 0) {
                    j += (long) i;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.write(bArr, 0, i);
                    }
                }
            } catch (Throwable th) {
                try {
                    c12032a.close();
                } catch (IOException e) {
                    Debugger.m8611e("NT$Streams", e);
                }
                throw th;
            }
        }
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.flush();
        }
        c12032a.close();
        return (int) j;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m13727c() throws FileUploadIOException, MultipartStream$MalformedStreamException {
        boolean z;
        byte[] bArr = new byte[2];
        this.f8812h += this.f8806b;
        try {
            byte bM13728d = m13728d();
            boolean z2 = false;
            bArr[0] = bM13728d;
            if (bM13728d != 10) {
                bArr[1] = m13728d();
                byte[] bArr2 = f8803l;
                int i = 0;
                while (true) {
                    if (i >= 2) {
                        z = true;
                        break;
                    }
                    if (bArr[i] != bArr2[i]) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    return false;
                }
                byte[] bArr3 = f8802k;
                int i2 = 0;
                while (true) {
                    if (i2 >= 2) {
                        z2 = true;
                        break;
                    }
                    if (bArr[i2] != bArr3[i2]) {
                        break;
                    }
                    i2++;
                }
                if (!z2) {
                    throw new MultipartStream$MalformedStreamException("Unexpected characters follow a boundary");
                }
            }
            return true;
        } catch (FileUploadIOException e) {
            throw e;
        } catch (IOException unused) {
            throw new MultipartStream$MalformedStreamException("Stream ended unexpectedly");
        }
    }

    /* JADX INFO: renamed from: d */
    public final byte m13728d() throws IOException {
        int i = this.f8812h;
        int i2 = this.f8813i;
        byte[] bArr = this.f8811g;
        if (i == i2) {
            this.f8812h = 0;
            int i4 = this.f8805a.read(bArr, 0, this.f8810f);
            this.f8813i = i4;
            if (i4 == -1) {
                throw new IOException("No more data is available");
            }
        }
        int i5 = this.f8812h;
        this.f8812h = i5 + 1;
        return bArr[i5];
    }

    /* JADX INFO: renamed from: e */
    public final String m13729e() throws FileUploadIOException, MultipartStream$MalformedStreamException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            try {
                byte bM13728d = m13728d();
                i2++;
                if (i2 > 10240) {
                    throw new MultipartStream$MalformedStreamException("Header section has more than 10240 bytes (maybe it is not properly terminated)");
                }
                i = bM13728d == f8801j[i] ? i + 1 : 0;
                byteArrayOutputStream.write(bM13728d);
            } catch (FileUploadIOException e) {
                throw e;
            } catch (IOException unused) {
                throw new MultipartStream$MalformedStreamException("Stream ended unexpectedly");
            }
        }
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
    }

    /* JADX INFO: renamed from: f */
    public final boolean m13730f() {
        byte[] bArr = this.f8808d;
        System.arraycopy(bArr, 2, bArr, 0, bArr.length - 2);
        this.f8806b = bArr.length - 2;
        m13725a();
        try {
            m13726b(null);
            return m13727c();
        } catch (MultipartStream$MalformedStreamException unused) {
            return false;
        } finally {
            System.arraycopy(bArr, 0, bArr, 2, bArr.length - 2);
            this.f8806b = bArr.length;
            bArr[0] = 13;
            bArr[1] = 10;
            m13725a();
        }
    }
}
