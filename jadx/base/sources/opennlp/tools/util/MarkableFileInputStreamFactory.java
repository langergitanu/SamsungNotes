package opennlp.tools.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MarkableFileInputStreamFactory implements InputStreamFactory {
    private final File file;

    public MarkableFileInputStreamFactory(File file) throws FileNotFoundException {
        if (file.exists()) {
            this.file = file;
            return;
        }
        throw new FileNotFoundException("File '" + file + "' cannot be found");
    }

    @Override // opennlp.tools.util.InputStreamFactory
    public InputStream createInputStream() {
        return new MarkableFileInputStream(this.file);
    }
}
