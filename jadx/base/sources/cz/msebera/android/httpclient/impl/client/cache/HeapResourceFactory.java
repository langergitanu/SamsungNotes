package cz.msebera.android.httpclient.impl.client.cache;

import cz.msebera.android.httpclient.annotation.Contract;
import cz.msebera.android.httpclient.annotation.ThreadingBehavior;
import cz.msebera.android.httpclient.client.cache.InputLimit;
import cz.msebera.android.httpclient.client.cache.Resource;
import cz.msebera.android.httpclient.client.cache.ResourceFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Contract(threading = ThreadingBehavior.IMMUTABLE)
public class HeapResourceFactory implements ResourceFactory {
    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource copy(String str, Resource resource) throws IOException {
        byte[] byteArray;
        if (resource instanceof HeapResource) {
            byteArray = ((HeapResource) resource).getByteArray();
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copyAndClose(resource.getInputStream(), byteArrayOutputStream);
            byteArray = byteArrayOutputStream.toByteArray();
        }
        return createResource(byteArray);
    }

    public Resource createResource(byte[] bArr) {
        return new HeapResource(bArr);
    }

    @Override // cz.msebera.android.httpclient.client.cache.ResourceFactory
    public Resource generate(String str, InputStream inputStream, InputLimit inputLimit) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            j += (long) i;
            if (inputLimit != null && j > inputLimit.getValue()) {
                inputLimit.reached();
                break;
            }
        }
        return createResource(byteArrayOutputStream.toByteArray());
    }
}
