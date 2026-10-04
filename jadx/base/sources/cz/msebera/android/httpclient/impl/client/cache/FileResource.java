package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.SAFE)
public class FileResource implements Resource {
    private static final long serialVersionUID = 4132244415919043397L;
    private volatile boolean disposed = false;
    private final File file;

    public FileResource(File file) {
        this.file = file;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized void dispose() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.file.delete();
    }

    public synchronized File getFile() {
        return this.file;
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized InputStream getInputStream() {
        return new FileInputStream(this.file);
    }

    @Override // cz.msebera.android.httpclient.client.cache.Resource
    public synchronized long length() {
        return this.file.length();
    }
}
