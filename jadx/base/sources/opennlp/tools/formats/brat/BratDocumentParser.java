package opennlp.tools.formats.brat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BratDocumentParser {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) BratDocumentParser.class);
    private final Set<String> nameTypes;
    private final SentenceDetector sentDetector;
    private final Tokenizer tokenizer;

    public BratDocumentParser(SentenceDetector sentenceDetector, Tokenizer tokenizer) {
        this(sentenceDetector, tokenizer, null);
    }

    private boolean isSpanAnnotation(BratAnnotation bratAnnotation) {
        if (!(bratAnnotation instanceof SpanAnnotation)) {
            return false;
        }
        Set<String> set = this.nameTypes;
        return set == null || set.contains(bratAnnotation.getType());
    }

    public List<NameSample> parse(BratDocument bratDocument) {
        HashSet hashSet;
        Iterator it;
        Span span;
        HashSet hashSet2;
        Iterator it2;
        Span span2;
        BratDocumentParser bratDocumentParser = this;
        HashSet hashSet3 = new HashSet();
        HashMap map = new HashMap();
        for (BratAnnotation bratAnnotation : bratDocument.getAnnotations()) {
            if (bratDocumentParser.isSpanAnnotation(bratAnnotation)) {
                hashSet3.add(bratAnnotation.getId());
                for (Span span3 : ((SpanAnnotation) bratAnnotation).getSpans()) {
                    for (int start = span3.getStart(); start < span3.getEnd(); start++) {
                        map.put(Integer.valueOf(start), span3);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Span span4 : bratDocumentParser.sentDetector.sentPosDetect(bratDocument.getText())) {
            Span span5 = (Span) map.get(Integer.valueOf(span4.getStart()));
            if (arrayList.size() <= 0 || span5 == null || span5.getStart() >= span4.getStart()) {
                arrayList.add(span4);
            } else {
                arrayList.add(new Span(((Span) arrayList.remove(arrayList.size() - 1)).getStart(), span4.getEnd()));
                logger.info("Correcting sentence segmentation in document {}", bratDocument.getId());
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Span span6 = (Span) it3.next();
            String string = span6.getCoveredText(bratDocument.getText()).toString();
            Span[] spanArr = bratDocumentParser.tokenizer.tokenizePos(string);
            HashMap map2 = new HashMap();
            int i = 0;
            while (i < spanArr.length) {
                map2.put(Integer.valueOf(-(spanArr[i].getStart() + span6.getStart())), Integer.valueOf(i));
                Integer numValueOf = Integer.valueOf(spanArr[i].getEnd() + span6.getStart());
                i++;
                map2.put(numValueOf, Integer.valueOf(i));
            }
            ArrayList arrayList3 = new ArrayList();
            for (BratAnnotation bratAnnotation2 : bratDocument.getAnnotations()) {
                if (bratDocumentParser.isSpanAnnotation(bratAnnotation2)) {
                    SpanAnnotation spanAnnotation = (SpanAnnotation) bratAnnotation2;
                    ArrayList<Span> arrayList4 = new ArrayList();
                    Span[] spans = spanAnnotation.getSpans();
                    int length = spans.length;
                    int i2 = 0;
                    while (i2 < length) {
                        Span span7 = spans[i2];
                        if (span6.contains(span7)) {
                            it2 = it3;
                            hashSet3.remove(bratAnnotation2.getId());
                            Span spanTrim = span7.trim(bratDocument.getText());
                            Integer num = (Integer) map2.get(Integer.valueOf(-spanTrim.getStart()));
                            hashSet2 = hashSet3;
                            Integer num2 = (Integer) map2.get(Integer.valueOf(spanTrim.getEnd()));
                            if (num == null || num2 == null) {
                                span2 = span6;
                                logger.warn("Dropped entity {} ({}) in document {} as it is not matching tokenization!", spanAnnotation.getId(), spanTrim.getCoveredText(bratDocument.getText()), bratDocument.getId());
                            } else {
                                span2 = span6;
                                arrayList4.add(new Span(num.intValue(), num2.intValue(), spanAnnotation.getType()));
                            }
                        } else {
                            hashSet2 = hashSet3;
                            it2 = it3;
                            span2 = span6;
                        }
                        i2++;
                        it3 = it2;
                        span6 = span2;
                        hashSet3 = hashSet2;
                    }
                    hashSet = hashSet3;
                    it = it3;
                    span = span6;
                    Collections.sort(arrayList4);
                    for (int i4 = 1; i4 < arrayList4.size(); i4++) {
                        int i5 = i4 - 1;
                        if (((Span) arrayList4.get(i5)).getEnd() == ((Span) arrayList4.get(i4)).getStart()) {
                            arrayList4.set(i4, new Span(((Span) arrayList4.get(i5)).getStart(), ((Span) arrayList4.get(i4)).getEnd(), ((Span) arrayList4.get(i4)).getType()));
                            arrayList4.set(i5, null);
                        }
                    }
                    for (Span span8 : arrayList4) {
                        if (span8 != null) {
                            arrayList3.add(span8);
                        }
                    }
                } else {
                    hashSet = hashSet3;
                    it = it3;
                    span = span6;
                }
                bratDocumentParser = this;
                it3 = it;
                span6 = span;
                hashSet3 = hashSet;
            }
            HashSet hashSet4 = hashSet3;
            Iterator it4 = it3;
            arrayList2.add(new NameSample(bratDocument.getId(), Span.spansToStrings(spanArr, string), (Span[]) arrayList3.toArray(new Span[0]), null, arrayList2.size() == 0));
            bratDocumentParser = this;
            it3 = it4;
            hashSet3 = hashSet4;
        }
        Iterator it5 = hashSet3.iterator();
        while (it5.hasNext()) {
            logger.warn("Dropped entity {} in document {}, is not matching sentence segmentation!", (String) it5.next(), bratDocument.getId());
        }
        return arrayList2;
    }

    public BratDocumentParser(SentenceDetector sentenceDetector, Tokenizer tokenizer, Set<String> set) {
        if (set != null && set.size() == 0) {
            throw new IllegalArgumentException("nameTypes should be null or have one or more elements");
        }
        this.sentDetector = sentenceDetector;
        this.tokenizer = tokenizer;
        this.nameTypes = set;
    }
}
