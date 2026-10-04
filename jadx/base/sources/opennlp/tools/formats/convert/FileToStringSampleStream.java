package opennlp.tools.formats.convert;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FileToStringSampleStream extends FilterObjectStream<File, String> {
    private final Charset encoding;

    public FileToStringSampleStream(ObjectStream<File> objectStream, Charset charset) {
        super(objectStream);
        this.encoding = charset;
    }

    private static String readFile(File file, Charset charset) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReaderNewBufferedReader = Files.newBufferedReader(file.toPath(), charset);
        try {
            char[] cArr = new char[1024];
            while (true) {
                int i = bufferedReaderNewBufferedReader.read(cArr, 0, 1024);
                if (i <= 0) {
                    bufferedReaderNewBufferedReader.close();
                    return sb.toString();
                }
                sb.append(cArr, 0, i);
            }
        } catch (Throwable th) {
            if (bufferedReaderNewBufferedReader != null) {
                try {
                    bufferedReaderNewBufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // opennlp.tools.util.ObjectStream
    public String read() {
        File file = (File) this.samples.read();
        if (file != null) {
            return readFile(file, this.encoding);
        }
        return null;
    }
}
