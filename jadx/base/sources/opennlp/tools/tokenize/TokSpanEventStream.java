package opennlp.tools.tokenize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.tokenize.lang.Factory;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokSpanEventStream extends AbstractEventStream<TokenSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokSpanEventStream.class);
    private final Pattern alphaNumeric;

    /* JADX INFO: renamed from: cg */
    private final TokenContextGenerator f9694cg;
    private final boolean skipAlphaNumerics;

    public TokSpanEventStream(ObjectStream<TokenSample> objectStream, boolean z, Pattern pattern, TokenContextGenerator tokenContextGenerator) {
        super(objectStream);
        this.alphaNumeric = pattern;
        this.skipAlphaNumerics = z;
        this.f9694cg = tokenContextGenerator;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(TokenSample tokenSample) {
        Span[] spanArr;
        String str;
        int i;
        int i2;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList(50);
        Span[] tokenSpans = tokenSample.getTokenSpans();
        String text = tokenSample.getText();
        if (tokenSpans.length > 0) {
            int start = tokenSpans[0].getStart();
            int i6 = 1;
            String strSubstring = text.substring(start, tokenSpans[tokenSpans.length - 1].getEnd());
            Span[] spanArr2 = WhitespaceTokenizer.INSTANCE.tokenizePos(strSubstring);
            int length = spanArr2.length;
            int i7 = -1;
            int i8 = 0;
            int i9 = -1;
            while (i8 < length) {
                Span span = spanArr2[i8];
                String strSubstring2 = strSubstring.substring(span.getStart(), span.getEnd());
                Span span2 = new Span(span.getStart() + start, span.getEnd() + start);
                if (strSubstring2.length() <= i6 || (this.skipAlphaNumerics && this.alphaNumeric.matcher(strSubstring2).matches())) {
                    spanArr = tokenSpans;
                    str = text;
                    i = start;
                    i2 = i6;
                } else {
                    int i10 = i7 + 1;
                    i2 = i6;
                    int i11 = 0;
                    while (true) {
                        if (i10 >= tokenSpans.length) {
                            spanArr = tokenSpans;
                            break;
                        }
                        if (span2.contains(tokenSpans[i10])) {
                            if (i11 == 0) {
                                i9 = i10;
                                i11 = i2;
                            }
                            spanArr = tokenSpans;
                            i7 = i10;
                            i4 = i7;
                        } else {
                            spanArr = tokenSpans;
                            if (span2.getEnd() < tokenSpans[i10].getEnd()) {
                                break;
                            }
                            if (spanArr[i10].getEnd() < span2.getStart()) {
                                i4 = i10;
                            } else {
                                Logger logger2 = logger;
                                Span span3 = spanArr[i10];
                                i4 = i10;
                                i5 = start;
                                logger2.warn("Bad training token: {} cand: {} token={}", span3, span2, text.substring(span3.getStart(), spanArr[i4].getEnd()));
                                i10 = i4 + 1;
                                tokenSpans = spanArr;
                                start = i5;
                            }
                        }
                        i5 = start;
                        i10 = i4 + 1;
                        tokenSpans = spanArr;
                        start = i5;
                    }
                    i = start;
                    if (i11 != 0) {
                        int i12 = i9;
                        while (i12 <= i7) {
                            Span span4 = spanArr[i12];
                            int start2 = span2.getStart();
                            int start3 = span4.getStart() + 1;
                            while (start3 < span4.getEnd()) {
                                arrayList.add(new Event(TokenizerME.NO_SPLIT, this.f9694cg.getContext(strSubstring2, start3 - start2)));
                                start3++;
                                i12 = i12;
                                text = text;
                            }
                            int i13 = i12;
                            String str2 = text;
                            if (span4.getEnd() != span2.getEnd()) {
                                arrayList.add(new Event("T", this.f9694cg.getContext(strSubstring2, span4.getEnd() - start2)));
                            }
                            i12 = i13 + 1;
                            text = str2;
                        }
                    }
                    str = text;
                }
                i8++;
                i6 = i2;
                tokenSpans = spanArr;
                text = str;
                start = i;
            }
        }
        return arrayList.iterator();
    }

    public TokSpanEventStream(ObjectStream<TokenSample> objectStream, boolean z, TokenContextGenerator tokenContextGenerator) {
        this(objectStream, z, new Factory().getAlphanumeric(null), tokenContextGenerator);
    }

    public TokSpanEventStream(ObjectStream<TokenSample> objectStream, boolean z) {
        this(objectStream, z, new DefaultTokenContextGenerator());
    }
}
