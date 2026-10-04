package opennlp.tools.formats;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TwentyNewsgroupSampleStream implements ObjectStream<DocumentSample> {
    private final Map<Path, String> catFileMap = new HashMap();
    private Iterator<Map.Entry<Path, String>> catFileTupleIterator;
    private final Tokenizer tokenizer;

    public TwentyNewsgroupSampleStream(Tokenizer tokenizer, Path path) {
        this.tokenizer = tokenizer;
        for (Path path2 : Files.newDirectoryStream(path, new C13632a())) {
            Iterator<Path> it = Files.newDirectoryStream(path2).iterator();
            while (it.hasNext()) {
                this.catFileMap.put(it.next(), path2.getFileName().toString());
            }
        }
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(Path path) {
        return Files.isDirectory(path, new LinkOption[0]);
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.catFileTupleIterator = this.catFileMap.entrySet().iterator();
    }

    @Override // opennlp.tools.util.ObjectStream
    public DocumentSample read() {
        if (!this.catFileTupleIterator.hasNext()) {
            return null;
        }
        Map.Entry<Path, String> next = this.catFileTupleIterator.next();
        return new DocumentSample(next.getValue(), this.tokenizer.tokenize(new String(Files.readAllBytes(next.getKey()))));
    }
}
