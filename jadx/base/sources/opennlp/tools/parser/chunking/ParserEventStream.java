package opennlp.tools.parser.chunking;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.Arrays;
import java.util.List;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.AbstractParserEventStream;
import opennlp.tools.parser.HeadRules;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserEventTypeEnum;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParserEventStream extends AbstractParserEventStream {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ParserEventStream.class);
    protected BuildContextGenerator bcg;
    protected CheckContextGenerator kcg;

    public ParserEventStream(ObjectStream<Parse> objectStream, HeadRules headRules, ParserEventTypeEnum parserEventTypeEnum, Dictionary dictionary) {
        super(objectStream, headRules, parserEventTypeEnum, dictionary);
    }

    public static Parse[] reduceChunks(Parse[] parseArr, int i, Parse parse) {
        String type = parse.getType();
        int i2 = i;
        while (i2 >= 0 && parseArr[i2].getParent() == parse) {
            i2--;
        }
        int i4 = i2 + 1;
        if (type.equals(AbstractBottomUpParser.TOP_NODE)) {
            return new Parse[0];
        }
        Parse[] parseArr2 = new Parse[(parseArr.length - ((i - i4) + 1)) + 1];
        System.arraycopy(parseArr, 0, parseArr2, 0, i4);
        parseArr2[i4] = parse;
        parse.setPrevPunctuation(parseArr[i4].getPreviousPunctuationSet());
        parse.setNextPunctuation(parseArr[i].getNextPunctuationSet());
        int i5 = i2 + 2;
        while (true) {
            i++;
            if (i >= parseArr.length) {
                return parseArr2;
            }
            parseArr2[i5] = parseArr[i];
            i5++;
        }
    }

    @Override // opennlp.tools.parser.AbstractParserEventStream
    public void addParseEvents(List<Event> list, Parse[] parseArr) {
        int i = 0;
        while (i < parseArr.length) {
            Logger logger2 = logger;
            if (logger2.isTraceEnabled()) {
                logger2.trace("parserEventStream.addParseEvents: chunks={}", Arrays.asList(parseArr));
            }
            Parse parse = parseArr[i];
            Parse parent = parse.getParent();
            if (parent != null) {
                String type = parent.getType();
                String strM772n = firstChild(parse, parent) ? AbstractC0541b.m772n(AbstractBottomUpParser.START, type) : AbstractC0541b.m772n(AbstractBottomUpParser.CONT, type);
                if (logger2.isTraceEnabled()) {
                    logger2.trace("parserEventStream.addParseEvents: chunks[{}]={} label={} bcg={}", Integer.valueOf(i), parse, strM772n, this.bcg);
                }
                parse.setLabel(strM772n);
                if (this.etype == ParserEventTypeEnum.BUILD) {
                    list.add(new Event(strM772n, this.bcg.getContext(parseArr, i)));
                }
                int i2 = i - 1;
                while (i2 >= 0 && parseArr[i2].getParent() == parent) {
                    i2--;
                }
                if (lastChild(parse, parent)) {
                    if (this.etype == ParserEventTypeEnum.CHECK) {
                        list.add(new Event("c", this.kcg.getContext(parseArr, type, i2 + 1, i)));
                    }
                    int i4 = i;
                    while (i4 >= 0 && parseArr[i4].getParent() == parent) {
                        i4--;
                    }
                    parseArr = reduceChunks(parseArr, i, parent);
                    i = i4;
                } else if (this.etype == ParserEventTypeEnum.CHECK) {
                    list.add(new Event("i", this.kcg.getContext(parseArr, type, i2 + 1, i)));
                }
            }
            i++;
        }
    }

    public boolean firstChild(Parse parse, Parse parse2) {
        return AbstractBottomUpParser.collapsePunctuation(parse2.getChildren(), this.punctSet)[0] == parse;
    }

    @Override // opennlp.tools.parser.AbstractParserEventStream
    public void init() {
        ParserEventTypeEnum parserEventTypeEnum = this.etype;
        if (parserEventTypeEnum == ParserEventTypeEnum.BUILD) {
            this.bcg = new BuildContextGenerator(this.dict);
        } else if (parserEventTypeEnum == ParserEventTypeEnum.CHECK) {
            this.kcg = new CheckContextGenerator();
        }
    }

    public ParserEventStream(ObjectStream<Parse> objectStream, HeadRules headRules, ParserEventTypeEnum parserEventTypeEnum) {
        this(objectStream, headRules, parserEventTypeEnum, null);
    }
}
