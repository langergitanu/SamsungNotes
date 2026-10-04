package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.content.C7969a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.SAXParser;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.MathMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascDocumentStream implements ObjectStream<MascDocument> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MascDocumentStream.class);
    private Iterator<MascDocument> documentIterator;
    private final List<MascDocument> documents;
    private final SAXParser saxParser;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class HeaderHandler extends DefaultHandler {
        private HashMap<String, String> annotationFiles;
        private String fType;
        private String file;

        public /* synthetic */ HeaderHandler(int i) {
            this();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            if (str3.equalsIgnoreCase(MathMLUtilities.ANNOTATION_LOCAL_NAME) || str3.equalsIgnoreCase("primaryData")) {
                this.annotationFiles.put(this.fType, this.file);
            }
        }

        public HashMap<String, String> getPathList() {
            return this.annotationFiles;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            if (str3.equalsIgnoreCase(MathMLUtilities.ANNOTATION_LOCAL_NAME) || str3.equalsIgnoreCase("primaryData")) {
                this.file = attributes.getValue("loc");
                this.fType = attributes.getValue("f.id");
                if (this.annotationFiles == null) {
                    this.annotationFiles = new HashMap<>();
                }
            }
        }

        private HeaderHandler() {
            this.annotationFiles = null;
            this.file = null;
            this.fType = null;
        }
    }

    public MascDocumentStream(File file) {
        this(file, true, new C7969a(2));
    }

    private HashMap<String, File> checkAnnotations(String str) throws IOException {
        HeaderHandler headerHandler = new HeaderHandler(0);
        HashMap<String, File> map = new HashMap<>();
        File file = new File(str);
        try {
            this.saxParser.parse(file, headerHandler);
            HashMap<String, String> pathList = headerHandler.getPathList();
            String absolutePath = file.getParentFile().getAbsolutePath();
            for (Map.Entry<String, String> entry : pathList.entrySet()) {
                File file2 = new File(absolutePath, entry.getValue());
                if (!file2.isFile() || !file2.exists()) {
                    throw new IOException(AbstractC0541b.m773o("Corpus integrity violated. Annotation file ", file2.getAbsolutePath(), " is missing."));
                }
                map.put(entry.getKey(), file2);
            }
            return map;
        } catch (SAXException unused) {
            throw new IOException(AbstractC0541b.m772n("Invalid corpus format. Could not parse the header: ", str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(File file) {
        return file.getName().contains("");
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.documentIterator = null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        Iterator<MascDocument> it = this.documents.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        this.documentIterator = this.documents.iterator();
    }

    public MascDocumentStream(File file, boolean z, FileFilter fileFilter) throws IOException {
        this.documents = new LinkedList();
        this.saxParser = XmlUtil.createSaxParser();
        if (!file.isDirectory()) {
            throw new IOException("Input corpus directory must be a directory according to File.isDirectory()!");
        }
        Stack stack = new Stack();
        stack.add(file);
        int i = 0;
        while (!stack.isEmpty()) {
            int i2 = i;
            for (File file2 : ((File) stack.pop()).listFiles(fileFilter)) {
                if (file2.isFile()) {
                    String absolutePath = file2.getAbsolutePath();
                    if (absolutePath.endsWith(".hdr")) {
                        HashMap<String, File> mapCheckAnnotations = checkAnnotations(absolutePath);
                        try {
                            this.documents.add(MascDocument.parseDocument(absolutePath, new BufferedInputStream(new FileInputStream(mapCheckAnnotations.get("f.text"))), mapCheckAnnotations.containsKey("f.seg") ? new BufferedInputStream(new FileInputStream(mapCheckAnnotations.get("f.seg"))) : null, mapCheckAnnotations.containsKey("f.penn") ? new BufferedInputStream(new FileInputStream(mapCheckAnnotations.get("f.penn"))) : null, mapCheckAnnotations.containsKey("f.s") ? new BufferedInputStream(new FileInputStream(mapCheckAnnotations.get("f.s"))) : null, mapCheckAnnotations.containsKey("f.ne") ? new BufferedInputStream(new FileInputStream(mapCheckAnnotations.get("f.ne"))) : null));
                        } catch (IOException e) {
                            logger.error("Failed to parse the file: {}", absolutePath, e);
                            i2++;
                        }
                    }
                } else if (z && file2.isDirectory()) {
                    stack.push(file2);
                }
            }
            i = i2;
        }
        Logger logger2 = logger;
        logger2.info("Documents loaded: {}", Integer.valueOf(this.documents.size()));
        if (i > 0) {
            logger2.info("Failed loading {} documents.", Integer.valueOf(i));
        }
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public MascDocument read() {
        if (this.documentIterator.hasNext()) {
            return this.documentIterator.next();
        }
        return null;
    }
}
