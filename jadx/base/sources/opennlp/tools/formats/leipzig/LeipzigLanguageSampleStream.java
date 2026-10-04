package opennlp.tools.formats.leipzig;

import com.opencsv.bean.C6617b;
import com.samsung.android.ocr.C7212a;
import com.samsung.android.support.senl.p145cm.base.framework.content.C7969a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.langdetect.Language;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.MarkableFileInputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import p074R1.C0232d;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LeipzigLanguageSampleStream implements ObjectStream<LanguageSample> {
    private final Map<String, Integer> langSampleCounts;
    private final Random random;
    private ObjectStream<LanguageSample> sampleStream;
    private final File[] sentencesFiles;
    private Iterator<File> sentencesFilesIt;
    private final int sentencesPerSample;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LeipzigSentencesStream implements ObjectStream<LanguageSample> {
        private final String lang;
        private final Iterator<String> lineIterator;

        public LeipzigSentencesStream(String str, File file, int i, int i2) throws InvalidFormatException {
            this.lang = str;
            int iCount = (int) Files.lines(file.toPath()).count();
            int i4 = i * i2;
            if (iCount < i4) {
                throw new InvalidFormatException(String.format("%s does not contain enough lines (%d lines < %d required lines).", file.getPath(), Integer.valueOf(iCount), Integer.valueOf(i4)));
            }
            int i5 = 0;
            List list = (List) IntStream.range(0, iCount).boxed().collect(Collectors.toList());
            Collections.shuffle(list, LeipzigLanguageSampleStream.this.random);
            HashSet hashSet = new HashSet(list.subList(0, i4));
            ArrayList arrayList = new ArrayList();
            PlainTextByLineStream plainTextByLineStream = new PlainTextByLineStream(new MarkableFileInputStreamFactory(file), StandardCharsets.UTF_8);
            while (true) {
                try {
                    String str2 = plainTextByLineStream.read();
                    if (str2 == null) {
                        plainTextByLineStream.close();
                        Collections.shuffle(arrayList, LeipzigLanguageSampleStream.this.random);
                        this.lineIterator = arrayList.iterator();
                        return;
                    } else {
                        if (str2.indexOf(9) != -1 && hashSet.contains(Integer.valueOf(i5))) {
                            arrayList.add(str2);
                        }
                        i5++;
                    }
                } catch (Throwable th) {
                    try {
                        plainTextByLineStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }

        @Override // opennlp.tools.util.ObjectStream
        public LanguageSample read() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < LeipzigLanguageSampleStream.this.sentencesPerSample && this.lineIterator.hasNext(); i++) {
                String next = this.lineIterator.next();
                sb.append(next.substring(next.indexOf(9) + 1));
                sb.append(" ");
            }
            if (sb.length() > 0) {
                return new LanguageSample(new Language(this.lang), sb);
            }
            return null;
        }
    }

    public LeipzigLanguageSampleStream(File file, int i, int i2) {
        this.sentencesPerSample = i;
        File[] fileArrListFiles = file.listFiles(new C7969a(1));
        this.sentencesFiles = fileArrListFiles;
        if (fileArrListFiles == null) {
            throw new TerminateToolException(-1, "Directory " + file + " empty , No files to read!");
        }
        Arrays.sort(fileArrListFiles);
        this.langSampleCounts = (Map) ((Map) Arrays.stream(fileArrListFiles).map(new C11419a(25)).collect(Collectors.groupingBy(new C11419a(26), Collectors.summingInt(new C7212a(2))))).entrySet().stream().collect(Collectors.toMap(new C6617b(7), new C0232d(i2, 4)));
        this.random = new Random(23L);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(File file) {
        return !file.isHidden() && file.isFile() && file.getName().length() >= 3 && file.getName().substring(0, 3).matches("[a-z]+");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$new$1(File file) {
        return file.getName().substring(0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$new$2(String str) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$new$3(int i, Map.Entry entry) {
        return Integer.valueOf(i / ((Integer) entry.getValue()).intValue());
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.sentencesFilesIt = Arrays.asList(this.sentencesFiles).iterator();
        this.sampleStream = null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public LanguageSample read() {
        LanguageSample languageSample;
        ObjectStream<LanguageSample> objectStream = this.sampleStream;
        if (objectStream != null && (languageSample = objectStream.read()) != null) {
            return languageSample;
        }
        if (!this.sentencesFilesIt.hasNext()) {
            return null;
        }
        File next = this.sentencesFilesIt.next();
        String strSubstring = next.getName().substring(0, 3);
        this.sampleStream = new LeipzigSentencesStream(strSubstring, next, this.sentencesPerSample, this.langSampleCounts.get(strSubstring).intValue());
        return read();
    }
}
