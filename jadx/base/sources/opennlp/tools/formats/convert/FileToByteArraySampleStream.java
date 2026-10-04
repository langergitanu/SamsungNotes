package opennlp.tools.formats.convert;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import opennlp.tools.commons.Internal;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class FileToByteArraySampleStream extends FilterObjectStream<File, byte[]> {
    public FileToByteArraySampleStream(ObjectStream<File> objectStream) {
        super(objectStream);
    }

    private static byte[] readFile(File file) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = bufferedInputStream.read(bArr, 0, 1024);
                if (i <= 0) {
                    bufferedInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // opennlp.tools.util.ObjectStream
    public byte[] read() {
        File file = (File) this.samples.read();
        if (file != null) {
            return readFile(file);
        }
        return null;
    }
}
