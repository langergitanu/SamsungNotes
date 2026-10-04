package opennlp.tools.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PlainTextByLineStream implements ObjectStream<String> {
    private final Charset encoding;

    /* JADX INFO: renamed from: in */
    private BufferedReader f9699in;
    private final InputStreamFactory inputStreamFactory;

    public PlainTextByLineStream(InputStreamFactory inputStreamFactory, String str) {
        this(inputStreamFactory, Charset.forName(str));
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() throws IOException {
        BufferedReader bufferedReader = this.f9699in;
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.f9699in = new BufferedReader(new InputStreamReader(this.inputStreamFactory.createInputStream(), this.encoding));
    }

    public PlainTextByLineStream(InputStreamFactory inputStreamFactory, Charset charset) {
        Objects.requireNonNull(inputStreamFactory, "inputStreamFactory must not be null!");
        this.inputStreamFactory = inputStreamFactory;
        this.encoding = charset;
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public String read() {
        return this.f9699in.readLine();
    }
}
