package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.SAXParser;
import opennlp.tools.util.Span;
import opennlp.tools.util.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascDocument {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MascDocument.class);
    private final String pathToFile;
    private Iterator<MascSentence> sentenceIterator;
    private final List<MascSentence> sentences;
    private boolean hasPennTags = false;
    private boolean hasNamedEntities = false;

    public MascDocument(String str, List<MascSentence> list) {
        this.pathToFile = str;
        this.sentences = list;
        this.sentenceIterator = list.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addNamedEntityTags(Map<String, Map<Integer, ? extends Object>> map) {
        try {
            Map<Integer, ? extends Object> map2 = map.get("entityIDtoEntityType");
            Map<Integer, ? extends Object> map3 = map.get("entityIDsToTokens");
            Iterator<MascSentence> it = this.sentences.iterator();
            while (it.hasNext()) {
                if (!it.next().addNamedEntities(map2, map3)) {
                    logger.warn("Issues occurred in the file:  {}", this.pathToFile);
                }
            }
            this.hasNamedEntities = true;
        } catch (IOException e) {
            logger.error("Failed connecting tokens and named entities. The error occurred in the file: {}", this.pathToFile, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void addPennTags(Map<String, Map<Integer, ?>> map) throws IOException {
        try {
            Map<Integer, ?> map2 = map.get("tokenToTag");
            Map<Integer, ?> map3 = map.get("tokenToBase");
            Map<Integer, ?> map4 = map.get("tokenToQuarks");
            for (Map.Entry<Integer, ?> entry : map4.entrySet()) {
                if (((int[]) entry.getValue()).length == 0) {
                    logger.warn("Token without quarks: {}", entry.getKey());
                }
            }
            HashMap map5 = new HashMap();
            for (Map.Entry<Integer, ?> entry2 : map4.entrySet()) {
                int iIntValue = entry2.getKey().intValue();
                int[] iArr = (int[]) entry2.getValue();
                int length = iArr.length;
                int i = 0;
                int i2 = 0;
                while (i2 < length) {
                    int i4 = iArr[i2];
                    if (map5.containsKey(Integer.valueOf(i4))) {
                        int[] iArr2 = (int[]) map5.get(Integer.valueOf(i4));
                        int[] iArr3 = new int[iArr2.length + 1];
                        iArr3[i] = iIntValue;
                        System.arraycopy(iArr2, i, iArr3, 1, iArr2.length);
                        Logger logger2 = logger;
                        logger2.warn("One quark belongs to several tokens. f-seg ID: {}.", Integer.valueOf(i4));
                        logger2.warn("The error occurred in file: {}", this.pathToFile);
                        map5.put(Integer.valueOf(i4), iArr3);
                    } else {
                        map5.put(Integer.valueOf(i4), new int[]{iIntValue});
                    }
                    i2++;
                    i = 0;
                }
            }
            Iterator<MascSentence> it = this.sentences.iterator();
            while (it.hasNext()) {
                if (!it.next().tokenizePenn(map4, map5, map3, map2)) {
                    logger.warn("Issues occurred in the file:  {}", this.pathToFile);
                }
            }
            this.hasPennTags = true;
        } catch (Exception e) {
            throw new IOException(AbstractC0541b.m773o("Could not attach POS tags to words. ", e.getMessage(), Arrays.toString(e.getStackTrace())));
        }
    }

    private static List<MascSentence> combineAnnotations(String str, List<Span> list, List<MascWord> list2) throws IOException {
        String str2;
        List<MascWord> list3;
        int size = list2.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Span span : list) {
            if (span.getEnd() - span.getStart() > 0) {
                ArrayList arrayList2 = new ArrayList();
                int start = span.getStart();
                int end = span.getEnd();
                MascWord mascWord = list2.get(i);
                while (start < mascWord.getEnd() && i > 0) {
                    i--;
                    mascWord = list2.get(i);
                }
                boolean z = false;
                while (!z && i < size) {
                    MascWord mascWord2 = list2.get(i);
                    int start2 = mascWord2.getStart();
                    int end2 = mascWord2.getEnd();
                    if (end > start2 && start < end2) {
                        arrayList2.add(mascWord2);
                        if (end == end2) {
                            z = true;
                        }
                    } else if (end <= start2) {
                        z = true;
                    }
                    i++;
                }
                if (!z && arrayList.size() != list.size() - 1) {
                    throw new IOException(AbstractC0000a.m11h(end, "Sentence ends and word ends do not match.First sentence not completed ends at character: "));
                }
                str2 = str;
                list3 = list2;
                arrayList.add(new MascSentence(start, end, str2, arrayList2, list3));
            } else {
                str2 = str;
                list3 = list2;
            }
            str = str2;
            list2 = list3;
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static MascDocument parseDocument(String str, InputStream inputStream, InputStream inputStream2, InputStream inputStream3, InputStream inputStream4, InputStream inputStream5) throws IOException {
        MascDocument mascDocument = new MascDocument(str, combineAnnotations(readText(inputStream), parseSentences(inputStream4), parseWords(inputStream2)));
        if (inputStream3 != null) {
            mascDocument.addPennTags(parsePennTags(inputStream3));
        }
        if (inputStream5 != null) {
            mascDocument.addNamedEntityTags(parseNamedEntity(inputStream5));
        }
        return mascDocument;
    }

    private static Map<String, Map<Integer, ?>> parseNamedEntity(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            SAXParser sAXParserCreateSaxParser = XmlUtil.createSaxParser();
            MascNamedEntityParser mascNamedEntityParser = new MascNamedEntityParser();
            try {
                sAXParserCreateSaxParser.parse(bufferedInputStream, mascNamedEntityParser);
                Map<Integer, String> entityIDtoEntityType = mascNamedEntityParser.getEntityIDtoEntityType();
                Map<Integer, List<Integer>> entityIDsToTokens = mascNamedEntityParser.getEntityIDsToTokens();
                HashMap map = new HashMap();
                map.put("entityIDtoEntityType", entityIDtoEntityType);
                map.put("entityIDsToTokens", entityIDsToTokens);
                bufferedInputStream.close();
                return map;
            } catch (SAXException e) {
                throw new IOException("Could not parse the named entity annotation file", e);
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

    private static Map<String, Map<Integer, ?>> parsePennTags(InputStream inputStream) throws IOException {
        HashMap map = new HashMap();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            SAXParser sAXParserCreateSaxParser = XmlUtil.createSaxParser();
            MascPennTagParser mascPennTagParser = new MascPennTagParser();
            try {
                sAXParserCreateSaxParser.parse(bufferedInputStream, mascPennTagParser);
                map.put("tokenToTag", mascPennTagParser.getTags());
                map.put("tokenToBase", mascPennTagParser.getBases());
                map.put("tokenToQuarks", mascPennTagParser.getTokenToQuarks());
                bufferedInputStream.close();
                return map;
            } catch (SAXException unused) {
                throw new IOException("Could not parse the Penn tag annotation file");
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

    private static List<Span> parseSentences(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            SAXParser sAXParserCreateSaxParser = XmlUtil.createSaxParser();
            MascSentenceParser mascSentenceParser = new MascSentenceParser();
            try {
                sAXParserCreateSaxParser.parse(bufferedInputStream, mascSentenceParser);
                List<Span> anchors = mascSentenceParser.getAnchors();
                ArrayList arrayList = new ArrayList();
                int i = 0;
                while (i < anchors.size() - 1) {
                    int i2 = i + 1;
                    if (anchors.get(i).getEnd() < anchors.get(i2).getStart()) {
                        arrayList.add(anchors.get(i));
                    }
                    i = i2;
                }
                arrayList.add(anchors.get(anchors.size() - 1));
                List<Span> listUnmodifiableList = Collections.unmodifiableList(arrayList);
                bufferedInputStream.close();
                return listUnmodifiableList;
            } catch (SAXException unused) {
                throw new IOException("Could not parse the sentence annotation file");
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

    private static List<MascWord> parseWords(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            SAXParser sAXParserCreateSaxParser = XmlUtil.createSaxParser();
            MascWordParser mascWordParser = new MascWordParser();
            try {
                sAXParserCreateSaxParser.parse(bufferedInputStream, mascWordParser);
                List<MascWord> listUnmodifiableList = Collections.unmodifiableList(mascWordParser.getAnchors());
                bufferedInputStream.close();
                return listUnmodifiableList;
            } catch (SAXException unused) {
                throw new IOException("Could not parse the region annotation file");
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

    private static String readText(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[8192];
            while (true) {
                int i = bufferedReader.read(cArr, 0, 8192);
                if (i <= 0) {
                    String string = sb.toString();
                    bufferedReader.close();
                    return string;
                }
                sb.append(cArr, 0, i);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public boolean hasNamedEntities() {
        return this.hasNamedEntities;
    }

    public boolean hasPennTags() {
        return this.hasPennTags;
    }

    public MascSentence read() {
        if (this.sentenceIterator.hasNext()) {
            return this.sentenceIterator.next();
        }
        return null;
    }

    public void reset() {
        this.sentenceIterator = this.sentences.iterator();
    }
}
