package opennlp.tools.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import opennlp.tools.chunker.ChunkerContextGenerator;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.postag.DefaultPOSContextGenerator;
import opennlp.tools.postag.POSContextGenerator;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractParserEventStream extends AbstractEventStream<Parse> {
    private ChunkerContextGenerator chunkerContextGenerator;
    protected final Dictionary dict;
    protected final ParserEventTypeEnum etype;
    protected boolean fixPossesives;
    protected final Set<String> punctSet;
    protected final HeadRules rules;
    private POSContextGenerator tagContextGenerator;

    public AbstractParserEventStream(ObjectStream<Parse> objectStream, HeadRules headRules, ParserEventTypeEnum parserEventTypeEnum, Dictionary dictionary) {
        super(objectStream);
        this.dict = dictionary;
        if (parserEventTypeEnum == ParserEventTypeEnum.CHUNK) {
            this.chunkerContextGenerator = new ChunkContextGenerator();
        } else if (parserEventTypeEnum == ParserEventTypeEnum.TAG) {
            this.tagContextGenerator = new DefaultPOSContextGenerator(null);
        }
        this.rules = headRules;
        this.punctSet = headRules.getPunctuationTags();
        this.etype = parserEventTypeEnum;
        init();
    }

    private void addChunkEvents(List<Event> list, Parse[] parseArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Parse parse : parseArr) {
            if (parse.isPosTag()) {
                arrayList.add(parse.getCoveredText());
                arrayList2.add(parse.getType());
                arrayList3.add("O");
            } else {
                String type = parse.getType();
                boolean z = true;
                for (Parse parse2 : parse.getChildren()) {
                    arrayList.add(parse2.getCoveredText());
                    arrayList2.add(parse2.getType());
                    if (z) {
                        arrayList3.add(AbstractBottomUpParser.START + type);
                        z = false;
                    } else {
                        arrayList3.add(AbstractBottomUpParser.CONT + type);
                    }
                }
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            list.add(new Event((String) arrayList3.get(i), this.chunkerContextGenerator.getContext(i, (String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), (String[]) arrayList3.toArray(new String[0]))));
        }
    }

    private void addTagEvents(List<Event> list, Parse[] parseArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Parse parse : parseArr) {
            if (parse.isPosTag()) {
                arrayList.add(parse.getCoveredText());
                arrayList2.add(parse.getType());
            } else {
                for (Parse parse2 : parse.getChildren()) {
                    arrayList.add(parse2.getCoveredText());
                    arrayList2.add(parse2.getType());
                }
            }
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            list.add(new Event((String) arrayList2.get(i), this.tagContextGenerator.getContext(i, (String[]) arrayList.toArray(new String[0]), (String[]) arrayList2.toArray(new String[0]), (Object[]) null)));
        }
    }

    public static Parse[] getInitialChunks(Parse parse) {
        ArrayList arrayList = new ArrayList();
        getInitialChunks(parse, arrayList);
        return (Parse[]) arrayList.toArray(new Parse[0]);
    }

    public abstract void addParseEvents(List<Event> list, Parse[] parseArr);

    public void init() {
        this.fixPossesives = false;
    }

    public boolean lastChild(Parse parse, Parse parse2) {
        Parse[] parseArrCollapsePunctuation = AbstractBottomUpParser.collapsePunctuation(parse2.getChildren(), this.punctSet);
        return parseArrCollapsePunctuation[parseArrCollapsePunctuation.length - 1] == parse;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(Parse parse) {
        ArrayList arrayList = new ArrayList();
        Parse.pruneParse(parse);
        if (this.fixPossesives) {
            Parse.fixPossesives(parse);
        }
        parse.updateHeads(this.rules);
        Parse[] initialChunks = getInitialChunks(parse);
        ParserEventTypeEnum parserEventTypeEnum = this.etype;
        if (parserEventTypeEnum == ParserEventTypeEnum.TAG) {
            addTagEvents(arrayList, initialChunks);
        } else if (parserEventTypeEnum == ParserEventTypeEnum.CHUNK) {
            addChunkEvents(arrayList, initialChunks);
        } else {
            addParseEvents(arrayList, AbstractBottomUpParser.collapsePunctuation(initialChunks, this.punctSet));
        }
        return arrayList.iterator();
    }

    private static void getInitialChunks(Parse parse, List<Parse> list) {
        if (parse.isPosTag()) {
            list.add(parse);
            return;
        }
        Parse[] children = parse.getChildren();
        for (Parse parse2 : children) {
            if (!parse2.isPosTag()) {
                for (Parse parse3 : children) {
                    getInitialChunks(parse3, list);
                }
                return;
            }
        }
        list.add(parse);
    }

    public AbstractParserEventStream(ObjectStream<Parse> objectStream, HeadRules headRules, ParserEventTypeEnum parserEventTypeEnum) {
        this(objectStream, headRules, parserEventTypeEnum, null);
    }
}
