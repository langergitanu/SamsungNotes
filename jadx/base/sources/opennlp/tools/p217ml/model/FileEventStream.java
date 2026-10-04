package opennlp.tools.p217ml.model;

import androidx.glance.AbstractC2821a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FileEventStream implements ObjectStream<Event> {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    protected final BufferedReader reader;

    public FileEventStream(String str, String str2) {
        this(str2 == null ? new FileReader(str) : new InputStreamReader(new FileInputStream(str), str2));
    }

    public static String toLine(Event event) {
        StringBuilder sb = new StringBuilder();
        sb.append(event.getOutcome());
        String[] context = event.getContext();
        int length = context.length;
        for (int iM2213d = 0; iM2213d < length; iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, " ", context[iM2213d])) {
        }
        sb.append(LINE_SEPARATOR);
        return sb.toString();
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // opennlp.tools.util.ObjectStream
    public Event read() throws IOException {
        String line = this.reader.readLine();
        if (line == null) {
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(line);
        String strNextToken = stringTokenizer.nextToken();
        int iCountTokens = stringTokenizer.countTokens();
        String[] strArr = new String[iCountTokens];
        for (int i = 0; i < iCountTokens; i++) {
            strArr[i] = stringTokenizer.nextToken();
        }
        return new Event(strNextToken, strArr);
    }

    public FileEventStream(String str) {
        this(str, null);
    }

    public FileEventStream(Reader reader) {
        this.reader = new BufferedReader(reader);
    }

    public FileEventStream(File file) {
        this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
    }
}
