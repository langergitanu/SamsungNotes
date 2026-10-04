package opennlp.tools.formats.brat;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BratDocumentStream implements ObjectStream<BratDocument> {
    private final AnnotationConfiguration config;
    private Iterator<String> documentIdIterator;
    private List<String> documentIds = new LinkedList();

    public BratDocumentStream(AnnotationConfiguration annotationConfiguration, File file, boolean z, FileFilter fileFilter) throws IOException {
        if (!file.isDirectory()) {
            throw new IOException("Input corpus directory must be a directory according to File.isDirectory()!");
        }
        this.config = annotationConfiguration;
        Stack stack = new Stack();
        stack.add(file);
        while (!stack.isEmpty()) {
            for (File file2 : ((File) stack.pop()).listFiles(fileFilter)) {
                if (file2.isFile()) {
                    String absolutePath = file2.getAbsolutePath();
                    if (absolutePath.endsWith(".ann")) {
                        String strM1614d = AbstractC2322a.m1614d(4, 0, absolutePath);
                        File file3 = new File(AbstractC0541b.m756B(strM1614d, Constants.TEXT_EXTENSION_WITH_DOT));
                        if (file3.exists() && file3.isFile()) {
                            this.documentIds.add(strM1614d);
                        }
                    }
                } else if (z && file2.isDirectory()) {
                    stack.push(file2);
                }
            }
        }
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.documentIds = null;
        this.documentIdIterator = null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.documentIdIterator = this.documentIds.iterator();
    }

    @Override // opennlp.tools.util.ObjectStream
    public BratDocument read() throws IOException {
        if (!this.documentIdIterator.hasNext()) {
            return null;
        }
        String next = this.documentIdIterator.next();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(AbstractC0541b.m756B(next, Constants.TEXT_EXTENSION_WITH_DOT)));
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(next + ".ann"));
            try {
                BratDocument document = BratDocument.parseDocument(this.config, next, bufferedInputStream, bufferedInputStream2);
                bufferedInputStream2.close();
                bufferedInputStream.close();
                return document;
            } finally {
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
}
