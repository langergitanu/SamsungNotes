package opennlp.tools.formats.brat;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BratAnnotationStream implements ObjectStream<BratAnnotation> {
    private final AnnotationConfiguration config;

    /* JADX INFO: renamed from: id */
    private final String f9658id;
    private final BufferedReader reader;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AnnotatorNoteParser extends BratAnnotationParser {
        private static final int ATTACH_TO_OFFSET = 2;
        private static final int START_VALUE_OFFSET = 3;

        @Override // opennlp.tools.formats.brat.BratAnnotationStream.BratAnnotationParser
        public BratAnnotation parse(Span[] spanArr, CharSequence charSequence) {
            return new AnnotatorNoteAnnotation(spanArr[0].getCoveredText(charSequence).toString(), spanArr[2].getCoveredText(charSequence).toString(), new Span(spanArr[3].getStart(), spanArr[spanArr.length - 1].getEnd()).getCoveredText(charSequence).toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AttributeAnnotationParser extends BratAnnotationParser {
        private static final int ATTACHED_TO_OFFSET = 2;
        private static final int VALUE_OFFSET = 3;

        @Override // opennlp.tools.formats.brat.BratAnnotationStream.BratAnnotationParser
        public BratAnnotation parse(Span[] spanArr, CharSequence charSequence) throws InvalidFormatException {
            if (spanArr.length == 3 || spanArr.length == 4) {
                return new AttributeAnnotation(spanArr[0].getCoveredText(charSequence).toString(), spanArr[1].getCoveredText(charSequence).toString(), spanArr[2].getCoveredText(charSequence).toString(), spanArr.length == 4 ? spanArr[3].getCoveredText(charSequence).toString() : null);
            }
            throw new InvalidFormatException("Line must have 3 or 4 fields");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class BratAnnotationParser {
        static final int ID_OFFSET = 0;
        static final String NOTES_TYPE = "AnnotatorNotes";
        static final int TYPE_OFFSET = 1;

        public BratAnnotation parse(Span[] spanArr, CharSequence charSequence) {
            return null;
        }

        public int parseInt(String str) throws InvalidFormatException {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new InvalidFormatException(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EventAnnotationParser extends BratAnnotationParser {
        @Override // opennlp.tools.formats.brat.BratAnnotationStream.BratAnnotationParser
        public BratAnnotation parse(Span[] spanArr, CharSequence charSequence) throws InvalidFormatException {
            String[] strArrSplit = spanArr[1].getCoveredText(charSequence).toString().split(":");
            if (strArrSplit.length != 2) {
                throw new InvalidFormatException(String.format("Failed to parse [%s], type part must be in the format type:trigger", charSequence));
            }
            String str = strArrSplit[0];
            String str2 = strArrSplit[1];
            HashMap map = new HashMap();
            for (int i = 2; i < spanArr.length; i++) {
                String[] strArrSplit2 = spanArr[i].getCoveredText(charSequence).toString().split(":");
                if (strArrSplit2.length != 2) {
                    throw new InvalidFormatException(String.format("Failed to parse [%s], argument parts must be in form argument:value", charSequence));
                }
                map.put(strArrSplit2[0], strArrSplit2[1]);
            }
            return new EventAnnotation(spanArr[0].getCoveredText(charSequence).toString(), str, str2, map);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RelationAnnotationParser extends BratAnnotationParser {
        private static final int ARG1_OFFSET = 2;
        private static final int ARG2_OFFSET = 3;

        private String parseArg(String str) throws InvalidFormatException {
            if (str.length() > 4) {
                return str.substring(5).trim();
            }
            throw new InvalidFormatException("Failed to parse argument: ".concat(str));
        }

        @Override // opennlp.tools.formats.brat.BratAnnotationStream.BratAnnotationParser
        public BratAnnotation parse(Span[] spanArr, CharSequence charSequence) {
            return new RelationAnnotation(spanArr[0].getCoveredText(charSequence).toString(), spanArr[1].getCoveredText(charSequence).toString(), parseArg(spanArr[2].getCoveredText(charSequence).toString()), parseArg(spanArr[3].getCoveredText(charSequence).toString()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SpanAnnotationParser extends BratAnnotationParser {
        private static final int BEGIN_OFFSET = 2;
        private static final int END_OFFSET = 3;

        @Override // opennlp.tools.formats.brat.BratAnnotationStream.BratAnnotationParser
        public BratAnnotation parse(Span[] spanArr, CharSequence charSequence) throws InvalidFormatException {
            int i;
            if (spanArr.length <= 4) {
                throw new InvalidFormatException("Line must have at least 5 fields");
            }
            String string = spanArr[1].getCoveredText(charSequence).toString();
            int i2 = parseInt(spanArr[2].getCoveredText(charSequence).toString());
            ArrayList arrayList = new ArrayList();
            int i4 = 3;
            while (true) {
                if (i4 >= spanArr.length) {
                    i = -1;
                    break;
                }
                if (!spanArr[i4].getCoveredText(charSequence).toString().contains(";")) {
                    int i5 = parseInt(spanArr[i4].getCoveredText(charSequence).toString());
                    i = i4 + 1;
                    arrayList.add(new Span(i2, i5, string));
                    break;
                }
                String[] strArrSplit = spanArr[i4].getCoveredText(charSequence).toString().split(";");
                arrayList.add(new Span(i2, parseInt(strArrSplit[0]), string));
                i2 = parseInt(strArrSplit[1]);
                i4++;
            }
            try {
                return new SpanAnnotation(spanArr[0].getCoveredText(charSequence).toString(), string, (Span[]) arrayList.toArray(new Span[0]), charSequence.subSequence(spanArr[i].getStart(), spanArr[spanArr.length - 1].getEnd()).toString());
            } catch (IllegalArgumentException e) {
                throw new InvalidFormatException(e);
            }
        }
    }

    public BratAnnotationStream(AnnotationConfiguration annotationConfiguration, String str, InputStream inputStream) {
        this.config = annotationConfiguration;
        this.f9658id = str;
        this.reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() throws IOException {
        this.reader.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public BratAnnotation read() throws IOException {
        BratAnnotationParser annotatorNoteParser;
        String line = this.reader.readLine();
        if (line == null) {
            return null;
        }
        Span[] spanArr = WhitespaceTokenizer.INSTANCE.tokenizePos(line);
        if (spanArr.length <= 2) {
            return null;
        }
        String string = spanArr[0].getCoveredText(line).toString();
        if (string.length() == 0) {
            throw new InvalidFormatException("annotation id is empty");
        }
        char cCharAt = string.charAt(0);
        if (cCharAt != '#') {
            if (cCharAt == 'A') {
                annotatorNoteParser = new AttributeAnnotationParser();
            } else if (cCharAt == 'E') {
                annotatorNoteParser = new EventAnnotationParser();
            } else if (cCharAt == 'R') {
                annotatorNoteParser = new RelationAnnotationParser();
            } else {
                if (cCharAt != 'T') {
                    return read();
                }
                annotatorNoteParser = new SpanAnnotationParser();
            }
        } else {
            if (!spanArr[1].getCoveredText(line).toString().equals("AnnotatorNotes")) {
                return read();
            }
            annotatorNoteParser = new AnnotatorNoteParser();
        }
        try {
            return annotatorNoteParser.parse(spanArr, line);
        } catch (IOException e) {
            throw new IOException(AbstractC0541b.m773o("Failed to parse ann document with id [", this.f9658id, ".ann]"), e);
        }
    }
}
