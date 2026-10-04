package opennlp.tools.cmdline;

import java.io.InputStream;
import java.nio.charset.Charset;
import opennlp.tools.util.InputStreamFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SystemInputStreamFactory implements InputStreamFactory {
    private boolean isTainted = false;

    public static Charset encoding() {
        return Charset.defaultCharset();
    }

    @Override // opennlp.tools.util.InputStreamFactory
    public InputStream createInputStream() {
        if (this.isTainted) {
            throw new UnsupportedOperationException("The System.in stream can't be re-created to read from the beginning!");
        }
        this.isTainted = true;
        return System.in;
    }
}
