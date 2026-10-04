package com.vladsch.flexmark.parser.internal;

import com.microsoft.identity.client.internal.MsalUtils;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.ast.AutoLink;
import com.vladsch.flexmark.ast.Code;
import com.vladsch.flexmark.ast.HardLineBreak;
import com.vladsch.flexmark.ast.HtmlEntity;
import com.vladsch.flexmark.ast.HtmlInline;
import com.vladsch.flexmark.ast.HtmlInlineComment;
import com.vladsch.flexmark.ast.Image;
import com.vladsch.flexmark.ast.ImageRef;
import com.vladsch.flexmark.ast.InlineLinkNode;
import com.vladsch.flexmark.ast.Link;
import com.vladsch.flexmark.ast.LinkRef;
import com.vladsch.flexmark.ast.LinkRefDerived;
import com.vladsch.flexmark.ast.LinkRendered;
import com.vladsch.flexmark.ast.MailLink;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.RefNode;
import com.vladsch.flexmark.ast.Reference;
import com.vladsch.flexmark.ast.SoftLineBreak;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.WhiteSpace;
import com.vladsch.flexmark.ast.util.ReferenceRepository;
import com.vladsch.flexmark.ast.util.TextNodeConverter;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.InlineParserExtension;
import com.vladsch.flexmark.parser.InlineParserExtensionFactory;
import com.vladsch.flexmark.parser.InlineParserOptions;
import com.vladsch.flexmark.parser.LightInlineParser;
import com.vladsch.flexmark.parser.LightInlineParserImpl;
import com.vladsch.flexmark.parser.LinkRefProcessor;
import com.vladsch.flexmark.parser.LinkRefProcessorFactory;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.block.CharacterNodeFactory;
import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.delimiter.AsteriskDelimiterProcessor;
import com.vladsch.flexmark.parser.core.delimiter.Bracket;
import com.vladsch.flexmark.parser.core.delimiter.Delimiter;
import com.vladsch.flexmark.parser.core.delimiter.UnderscoreDelimiterProcessor;
import com.vladsch.flexmark.parser.delimiter.DelimiterProcessor;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.DoNotDecorate;
import com.vladsch.flexmark.util.ast.DoNotTrim;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.collection.iteration.ReversiblePeekingIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.dependency.DependencyResolver;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import com.vladsch.flexmark.util.sequence.SegmentedSequence;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class InlineParserImpl extends LightInlineParserImpl implements InlineParser, ParagraphPreProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected BitSet customCharacters;
    protected Map<Character, CharacterNodeFactory> customSpecialCharacterFactoryMap;
    protected ArrayList<Node> customSpecialCharacterNodes;
    protected final BitSet delimiterCharacters;
    protected final Map<Character, DelimiterProcessor> delimiterProcessors;
    protected List<InlineParserExtensionFactory> inlineParserExtensionFactories;
    protected Map<Character, List<InlineParserExtension>> inlineParserExtensions;
    private Bracket lastBracket;
    protected Delimiter lastDelimiter;
    protected LinkDestinationParser linkDestinationParser;
    protected List<LinkRefProcessor> linkRefProcessors;
    protected final LinkRefProcessorData linkRefProcessorsData;
    protected final BitSet originalSpecialCharacters;
    protected ReferenceRepository referenceRepository;
    protected BitSet specialCharacters;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DelimiterData {
        final boolean canClose;
        final boolean canOpen;
        final int count;

        public DelimiterData(int i, boolean z, boolean z2) {
            this.count = i;
            this.canOpen = z;
            this.canClose = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReferenceProcessorMatch {
        public final BasedSequence nodeChars;
        public final LinkRefProcessor processor;
        public final boolean wantExclamation;

        public ReferenceProcessorMatch(LinkRefProcessor linkRefProcessor, boolean z, BasedSequence basedSequence) {
            this.processor = linkRefProcessor;
            this.nodeChars = basedSequence;
            this.wantExclamation = z;
        }
    }

    public InlineParserImpl(DataHolder dataHolder, BitSet bitSet, BitSet bitSet2, Map<Character, DelimiterProcessor> map, LinkRefProcessorData linkRefProcessorData, List<InlineParserExtensionFactory> list) {
        super(dataHolder);
        this.linkRefProcessors = null;
        this.inlineParserExtensions = null;
        this.inlineParserExtensionFactories = null;
        this.linkDestinationParser = null;
        this.customCharacters = null;
        this.customSpecialCharacterFactoryMap = null;
        this.customSpecialCharacterNodes = null;
        this.delimiterProcessors = map;
        this.linkRefProcessorsData = linkRefProcessorData;
        this.delimiterCharacters = bitSet2;
        this.originalSpecialCharacters = bitSet;
        this.specialCharacters = bitSet;
        this.inlineParserExtensionFactories = list.isEmpty() ? null : list;
        InlineParserOptions inlineParserOptions = this.options;
        if (inlineParserOptions.useHardcodedLinkAddressParser) {
            this.linkDestinationParser = new LinkDestinationParser(inlineParserOptions.linksAllowMatchedParentheses, inlineParserOptions.spaceInLinkUrls, inlineParserOptions.parseJekyllMacrosInUrls, inlineParserOptions.intellijDummyIdentifier);
        }
    }

    private void addBracket(Bracket bracket) {
        Bracket bracket2 = this.lastBracket;
        if (bracket2 != null) {
            bracket2.setBracketAfter(true);
        }
        this.lastBracket = bracket;
    }

    private static void addDelimiterProcessorForChar(char c, DelimiterProcessor delimiterProcessor, Map<Character, DelimiterProcessor> map) {
        DelimiterProcessor delimiterProcessorPut = map.put(Character.valueOf(c), delimiterProcessor);
        if (delimiterProcessorPut != null) {
            if (delimiterProcessorPut.getClass() == delimiterProcessor.getClass()) {
                System.out.println("Delimiter processor for char '" + c + "', added more than once " + delimiterProcessorPut.getClass().getCanonicalName());
                return;
            }
            throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c + "', existing " + delimiterProcessorPut.getClass().getCanonicalName() + ", added " + delimiterProcessor.getClass().getCanonicalName());
        }
    }

    private static void addDelimiterProcessors(List<? extends DelimiterProcessor> list, Map<Character, DelimiterProcessor> map) {
        for (DelimiterProcessor delimiterProcessor : list) {
            char openingCharacter = delimiterProcessor.getOpeningCharacter();
            addDelimiterProcessorForChar(openingCharacter, delimiterProcessor, map);
            char closingCharacter = delimiterProcessor.getClosingCharacter();
            if (openingCharacter != closingCharacter) {
                addDelimiterProcessorForChar(closingCharacter, delimiterProcessor, map);
            }
        }
    }

    public static BitSet calculateDelimiterCharacters(DataHolder dataHolder, Set<Character> set) {
        BitSet bitSet = new BitSet();
        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(it.next().charValue());
        }
        return bitSet;
    }

    public static Map<Character, DelimiterProcessor> calculateDelimiterProcessors(DataHolder dataHolder, List<DelimiterProcessor> list) {
        HashMap map = new HashMap();
        if (Parser.ASTERISK_DELIMITER_PROCESSOR.get(dataHolder).booleanValue()) {
            addDelimiterProcessors(Collections.singletonList(new AsteriskDelimiterProcessor(Parser.STRONG_WRAPS_EMPHASIS.get(dataHolder).booleanValue())), map);
        }
        if (Parser.UNDERSCORE_DELIMITER_PROCESSOR.get(dataHolder).booleanValue()) {
            addDelimiterProcessors(Collections.singletonList(new UnderscoreDelimiterProcessor(Parser.STRONG_WRAPS_EMPHASIS.get(dataHolder).booleanValue())), map);
        }
        addDelimiterProcessors(list, map);
        return map;
    }

    public static Map<Character, List<InlineParserExtensionFactory>> calculateInlineParserExtensions(DataHolder dataHolder, List<InlineParserExtensionFactory> list) {
        HashMap map = new HashMap();
        for (InlineParserExtensionFactory inlineParserExtensionFactory : list) {
            CharSequence characters = inlineParserExtensionFactory.getCharacters();
            for (int i = 0; i < characters.length(); i++) {
                ((List) map.computeIfAbsent(Character.valueOf(characters.charAt(i)), new C11419a(7))).add(inlineParserExtensionFactory);
            }
        }
        HashMap map2 = new HashMap();
        for (Character ch : map.keySet()) {
            map2.put(ch, DependencyResolver.resolveFlatDependencies((List) map.get(ch), null, null));
        }
        return map2;
    }

    public static LinkRefProcessorData calculateLinkRefProcessors(final DataHolder dataHolder, List<LinkRefProcessorFactory> list) {
        int i = 0;
        if (list.size() <= 1) {
            if (list.size() <= 0) {
                return new LinkRefProcessorData(list, 0, new int[0]);
            }
            int bracketNestingLevel = list.get(0).getBracketNestingLevel(dataHolder);
            return new LinkRefProcessorData(list, bracketNestingLevel, new int[bracketNestingLevel + 1]);
        }
        ArrayList<LinkRefProcessorFactory> arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        final int[] iArr = {0};
        Collections.sort(arrayList, new Comparator() { // from class: com.vladsch.flexmark.parser.internal.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return InlineParserImpl.lambda$calculateLinkRefProcessors$3(dataHolder, iArr, (LinkRefProcessorFactory) obj, (LinkRefProcessorFactory) obj2);
            }
        });
        int i2 = iArr[0];
        int[] iArr2 = new int[i2 + 1];
        int bracketNestingLevel2 = -1;
        for (LinkRefProcessorFactory linkRefProcessorFactory : arrayList) {
            if (bracketNestingLevel2 < linkRefProcessorFactory.getBracketNestingLevel(dataHolder)) {
                bracketNestingLevel2 = linkRefProcessorFactory.getBracketNestingLevel(dataHolder);
                iArr2[bracketNestingLevel2] = i;
                if (bracketNestingLevel2 == i2) {
                    break;
                }
            }
            i++;
        }
        return new LinkRefProcessorData(arrayList, i2, iArr2);
    }

    public static BitSet calculateSpecialCharacters(DataHolder dataHolder, BitSet bitSet) {
        BitSet bitSet2 = new BitSet();
        bitSet2.or(bitSet);
        bitSet2.set(13);
        bitSet2.set(10);
        bitSet2.set(96);
        bitSet2.set(91);
        bitSet2.set(93);
        bitSet2.set(92);
        bitSet2.set(33);
        bitSet2.set(60);
        bitSet2.set(38);
        return bitSet2;
    }

    public static void collapseLinkRefChildren(Node node, Function<LinkRefDerived, Boolean> function, boolean z) {
        Node firstChild = node.getFirstChild();
        boolean z2 = false;
        while (firstChild != null) {
            Node next = firstChild.getNext();
            if ((firstChild instanceof LinkRefDerived) && (function == null || function.apply((LinkRefDerived) firstChild).booleanValue())) {
                collapseLinkRefChildren(firstChild, function, false);
                firstChild.unlink();
                TextNodeConverter textNodeConverter = new TextNodeConverter(firstChild.getChars());
                textNodeConverter.addChildrenOf(firstChild);
                if (next != null) {
                    textNodeConverter.insertMergedBefore(next);
                } else {
                    textNodeConverter.appendMergedTo(node);
                }
                z2 = true;
            }
            firstChild = next;
        }
        if (z2) {
            TextNodeConverter.mergeTextNodes(node);
        }
        if (z) {
            Node firstChild2 = node.getFirstChild();
            Node lastChild = node.getLastChild();
            if (firstChild2 == lastChild) {
                if (firstChild2 == null || (firstChild2 instanceof DoNotTrim)) {
                    return;
                }
                firstChild2.setChars(firstChild2.getChars().trim());
                return;
            }
            if (firstChild2 != null && !(firstChild2 instanceof DoNotTrim)) {
                firstChild2.setChars(firstChild2.getChars().trimStart());
            }
            if (lastChild == null || (lastChild instanceof DoNotTrim)) {
                return;
            }
            lastChild.setChars(lastChild.getChars().trimEnd());
        }
    }

    public static boolean containsLinkRefs(Node node, Boolean bool) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if ((firstChild instanceof LinkRendered) && (bool == null || ((LinkRendered) firstChild).isTentative() == bool.booleanValue())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$calculateInlineParserExtensions$2(Character ch) {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$calculateLinkRefProcessors$3(DataHolder dataHolder, int[] iArr, LinkRefProcessorFactory linkRefProcessorFactory, LinkRefProcessorFactory linkRefProcessorFactory2) {
        int bracketNestingLevel = linkRefProcessorFactory.getBracketNestingLevel(dataHolder);
        int bracketNestingLevel2 = linkRefProcessorFactory2.getBracketNestingLevel(dataHolder);
        int i = iArr[0];
        if (i < bracketNestingLevel) {
            i = bracketNestingLevel;
        }
        if (i < bracketNestingLevel2) {
            i = bracketNestingLevel2;
        }
        iArr[0] = i;
        if (bracketNestingLevel == bracketNestingLevel2) {
            if (!linkRefProcessorFactory.getWantExclamationPrefix(dataHolder)) {
                bracketNestingLevel++;
            }
            if (!linkRefProcessorFactory2.getWantExclamationPrefix(dataHolder)) {
                bracketNestingLevel2++;
            }
        }
        return Integer.compare(bracketNestingLevel, bracketNestingLevel2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$parseCloseBracket$0(LinkRefDerived linkRefDerived) {
        return Boolean.valueOf((linkRefDerived instanceof LinkRendered) || linkRefDerived.isTentative());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean lambda$parseCloseBracket$1(LinkRefDerived linkRefDerived) {
        return Boolean.valueOf((linkRefDerived instanceof LinkRendered) || linkRefDerived.isTentative());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0095 A[LOOP:0: B:6:0x0018->B:30:0x0095, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private ReferenceProcessorMatch matchLinkRef(Bracket bracket, int i, int i2, int i4) {
        BasedSequence basedSequence;
        BasedSequence basedSequence2;
        LinkRefProcessorData linkRefProcessorData = this.linkRefProcessorsData;
        if (linkRefProcessorData.nestingIndex.length == 0) {
            return null;
        }
        int size = linkRefProcessorData.processors.size();
        int i5 = i4 + i2;
        int i6 = this.linkRefProcessorsData.nestingIndex[i5];
        BasedSequence basedSequenceSubSequence = null;
        BasedSequence basedSequenceSubSequence2 = null;
        while (i6 < size) {
            LinkRefProcessor linkRefProcessor = this.linkRefProcessors.get(i6);
            if (i5 < linkRefProcessor.getBracketNestingLevel()) {
                break;
            }
            boolean wantExclamationPrefix = linkRefProcessor.getWantExclamationPrefix();
            if (bracket.isImage() && wantExclamationPrefix) {
                if (basedSequenceSubSequence == null) {
                    basedSequenceSubSequence = this.input.subSequence((bracket.getStartIndex() - 1) - i2, i + i2);
                }
            } else if (!wantExclamationPrefix || bracket.getStartIndex() < i2 + 1 || this.input.charAt((bracket.getStartIndex() - 1) - i2) != '!') {
                if (basedSequenceSubSequence2 == null) {
                    basedSequenceSubSequence2 = this.input.subSequence(bracket.getStartIndex() - i2, i + i2);
                }
                basedSequence = basedSequenceSubSequence2;
                basedSequence2 = basedSequenceSubSequence;
                basedSequenceSubSequence = basedSequence;
                if (!linkRefProcessor.isMatch(basedSequenceSubSequence)) {
                    return new ReferenceProcessorMatch(linkRefProcessor, wantExclamationPrefix, basedSequenceSubSequence);
                }
                i6++;
                basedSequenceSubSequence = basedSequence2;
                basedSequenceSubSequence2 = basedSequence;
            } else if (basedSequenceSubSequence == null) {
                basedSequenceSubSequence = this.input.subSequence((bracket.getStartIndex() - 1) - i2, i + i2);
            }
            basedSequence = basedSequenceSubSequence2;
            basedSequence2 = basedSequenceSubSequence;
            if (!linkRefProcessor.isMatch(basedSequenceSubSequence)) {
            }
        }
        return null;
    }

    private boolean processCustomCharacters() {
        char cPeek;
        CharacterNodeFactory characterNodeFactory = this.customSpecialCharacterFactoryMap.get(Character.valueOf(peek()));
        if (characterNodeFactory == null) {
            return false;
        }
        Node node = characterNodeFactory.get();
        BasedSequence basedSequence = this.input;
        int i = this.index;
        node.setChars(basedSequence.subSequence(i, i + 1));
        if (this.currentText != null) {
            BasedSequence basedSequenceCreate = SegmentedSequence.create(node.getChars(), this.currentText);
            BasedSequence basedSequenceSubSequence = null;
            this.currentText = null;
            int length = basedSequenceCreate.length();
            while (length > 0 && characterNodeFactory.skipPrev(basedSequenceCreate.charAt(length - 1))) {
                length--;
            }
            if (length < basedSequenceCreate.length()) {
                basedSequenceSubSequence = basedSequenceCreate.subSequence(length);
                basedSequenceCreate = basedSequenceCreate.subSequence(0, length);
            }
            this.block.appendChild(new Text(basedSequenceCreate));
            if (basedSequenceSubSequence != null && characterNodeFactory.wantSkippedWhitespace()) {
                this.block.appendChild(new WhiteSpace(basedSequenceSubSequence));
            }
        }
        appendNode(node);
        if (this.customSpecialCharacterNodes == null) {
            this.customSpecialCharacterNodes = new ArrayList<>();
        }
        this.customSpecialCharacterNodes.add(node);
        int i2 = this.index + 1;
        do {
            this.index++;
            cPeek = peek();
            if (cPeek == 0) {
                break;
            }
        } while (characterNodeFactory.skipNext(cPeek));
        if (i2 < this.index && characterNodeFactory.wantSkippedWhitespace()) {
            this.block.appendChild(new WhiteSpace(this.input.subSequence(i2, this.index)));
        }
        return true;
    }

    private void removeLastBracket() {
        this.lastBracket = this.lastBracket.getPrevious();
    }

    public Object clone() {
        return super.clone();
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void finalizeDocument(@NotNull Document document) {
        Map<Character, List<InlineParserExtension>> map = this.inlineParserExtensions;
        if (map != null) {
            Iterator<List<InlineParserExtension>> it = map.values().iterator();
            while (it.hasNext()) {
                Iterator<InlineParserExtension> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    it2.next().finalizeDocument(this);
                }
            }
        }
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public Bracket getLastBracket() {
        return this.lastBracket;
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public Delimiter getLastDelimiter() {
        return this.lastDelimiter;
    }

    public void initializeDocument(@NotNull Document document) {
        this.document = document;
        this.referenceRepository = Parser.REFERENCES.get(document);
        this.linkRefProcessors = new ArrayList(this.linkRefProcessorsData.processors.size());
        Iterator<LinkRefProcessorFactory> it = this.linkRefProcessorsData.processors.iterator();
        while (it.hasNext()) {
            this.linkRefProcessors.add(it.next().apply(document));
        }
        List<InlineParserExtensionFactory> list = this.inlineParserExtensionFactories;
        if (list != null) {
            Map<Character, List<InlineParserExtensionFactory>> mapCalculateInlineParserExtensions = calculateInlineParserExtensions(document, list);
            this.inlineParserExtensions = new HashMap(mapCalculateInlineParserExtensions.size());
            HashMap map = new HashMap();
            for (Map.Entry<Character, List<InlineParserExtensionFactory>> entry : mapCalculateInlineParserExtensions.entrySet()) {
                ArrayList arrayList = new ArrayList(entry.getValue().size());
                for (InlineParserExtensionFactory inlineParserExtensionFactory : entry.getValue()) {
                    InlineParserExtension inlineParserExtensionApply = (InlineParserExtension) map.get(inlineParserExtensionFactory);
                    if (inlineParserExtensionApply == null) {
                        inlineParserExtensionApply = inlineParserExtensionFactory.apply((LightInlineParser) this);
                        map.put(inlineParserExtensionFactory, inlineParserExtensionApply);
                    }
                    arrayList.add(inlineParserExtensionApply);
                }
                this.inlineParserExtensions.put(entry.getKey(), arrayList);
                this.specialCharacters.set(entry.getKey().charValue());
            }
        }
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void mergeIfNeeded(Text text, Text text2) {
        if (text == null || text2 == null || text == text2) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(text.getChars());
        Node next = text.getNext();
        Node next2 = text2.getNext();
        while (next != next2) {
            arrayList.add(next.getChars());
            Node next3 = next.getNext();
            next.unlink();
            next = next3;
        }
        text.setChars(SegmentedSequence.create(text.getChars(), arrayList));
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void mergeTextNodes(@Nullable Node node, @Nullable Node node2) {
        Text text = null;
        Text text2 = null;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
            } else {
                mergeIfNeeded(text, text2);
                text = null;
                text2 = null;
            }
            if (node == node2) {
                break;
            } else {
                node = node.getNext();
            }
        }
        mergeIfNeeded(text, text2);
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void parse(@NotNull BasedSequence basedSequence, @NotNull Node node) {
        Map<Character, List<InlineParserExtension>> map;
        this.block = node;
        this.input = basedSequence.trim();
        this.index = 0;
        this.lastDelimiter = null;
        this.lastBracket = null;
        boolean z = node instanceof DoNotDecorate;
        while (parseInline(z)) {
        }
        processDelimiters(null);
        flushTextNode();
        if (!z && (map = this.inlineParserExtensions) != null) {
            Iterator<List<InlineParserExtension>> it = map.values().iterator();
            while (it.hasNext()) {
                Iterator<InlineParserExtension> it2 = it.next().iterator();
                while (it2.hasNext()) {
                    it2.next().finalizeBlock(this);
                }
            }
        }
        mergeTextNodes(node.getFirstChild(), node.getLastChild());
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public boolean parseAutolink() {
        BasedSequence basedSequenceMatch;
        BasedSequence basedSequenceMatch2 = match(this.myParsing.EMAIL_AUTOLINK);
        if (basedSequenceMatch2 != null) {
            appendNode(new MailLink(basedSequenceMatch2.subSequence(0, 1), basedSequenceMatch2.subSequence(1, basedSequenceMatch2.length() - 1), basedSequenceMatch2.subSequence(basedSequenceMatch2.length() - 1, basedSequenceMatch2.length())));
            return true;
        }
        BasedSequence basedSequenceMatch3 = match(this.myParsing.AUTOLINK);
        if (basedSequenceMatch3 != null) {
            appendNode(new AutoLink(basedSequenceMatch3.subSequence(0, 1), basedSequenceMatch3.subSequence(1, basedSequenceMatch3.length() - 1), basedSequenceMatch3.subSequence(basedSequenceMatch3.length() - 1, basedSequenceMatch3.length())));
            return true;
        }
        if (!this.options.wwwAutoLinkElement || (basedSequenceMatch = match(this.myParsing.WWW_AUTOLINK)) == null) {
            return false;
        }
        appendNode(new AutoLink(basedSequenceMatch.subSequence(0, 1), basedSequenceMatch.subSequence(1, basedSequenceMatch.length() - 1), basedSequenceMatch.subSequence(basedSequenceMatch.length() - 1, basedSequenceMatch.length())));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseBackslash() {
        this.index++;
        if (peek() == '\n' || peek() == '\r') {
            int i = peek(1) == '\n' ? 2 : 1;
            BasedSequence basedSequence = this.input;
            int i2 = this.index;
            appendNode(new HardLineBreak(basedSequence.subSequence(i2 - 1, i2 + i)));
            this.index += i;
        } else if (this.index < this.input.length()) {
            Pattern pattern = this.myParsing.ESCAPABLE;
            BasedSequence basedSequence2 = this.input;
            int i4 = this.index;
            if (pattern.matcher(basedSequence2.subSequence(i4, i4 + 1)).matches()) {
                BasedSequence basedSequence3 = this.input;
                int i5 = this.index;
                appendText(basedSequence3, i5 - 1, i5 + 1);
                this.index++;
            } else {
                BasedSequence basedSequence4 = this.input;
                int i6 = this.index;
                appendText(basedSequence4.subSequence(i6 - 1, i6));
            }
        }
        return true;
    }

    public boolean parseBackticks() {
        BasedSequence basedSequenceMatch;
        BasedSequence basedSequenceMatch2 = match(this.myParsing.TICKS_HERE);
        int i = 0;
        if (basedSequenceMatch2 == null) {
            return false;
        }
        int i2 = this.index;
        do {
            basedSequenceMatch = match(this.myParsing.TICKS);
            if (basedSequenceMatch == null) {
                this.index = i2;
                appendText(basedSequenceMatch2);
                return true;
            }
        } while (!basedSequenceMatch.equals(basedSequenceMatch2));
        int length = basedSequenceMatch2.length();
        BasedSequence basedSequenceSubSequence = this.input.subSequence(i2, this.index - length);
        BasedSequence basedSequenceSubSequence2 = this.input.subSequence(i2 - length, i2);
        BasedSequence basedSequence = this.input;
        int i4 = this.index;
        Code code = new Code(basedSequenceSubSequence2, basedSequenceSubSequence, basedSequence.subSequence(i4 - length, i4));
        if (this.options.codeSoftLineBreaks) {
            int length2 = basedSequenceSubSequence.length();
            while (i < length2) {
                int iIndexOfAny = basedSequenceSubSequence.indexOfAny(CharPredicate.ANY_EOL, i);
                int i5 = iIndexOfAny == -1 ? length2 : iIndexOfAny;
                code.appendChild(new Text(basedSequenceSubSequence.subSequence(i, i5)));
                if (i5 >= length2) {
                    break;
                }
                if (basedSequenceSubSequence.charAt(i5) == '\r') {
                    i = i5 + 1;
                    if (i >= length2) {
                        break;
                    }
                    if (basedSequenceSubSequence.charAt(i) == '\n') {
                        i = i5 + 2;
                    }
                } else {
                    i = i5 + 1;
                }
                if (i >= length2) {
                    break;
                }
                if (i5 < i) {
                    code.appendChild(new SoftLineBreak(basedSequenceSubSequence.subSequence(iIndexOfAny, i)));
                }
            }
        } else {
            code.appendChild(new Text(basedSequenceSubSequence));
        }
        appendNode(code);
        return true;
    }

    public boolean parseBang() {
        int i = this.index;
        this.index = i + 1;
        if (peek() == '[') {
            int i2 = this.index;
            int i4 = i2 + 1;
            this.index = i4;
            addBracket(Bracket.image(this.input, appendSeparateText(this.input.subSequence(i2 - 1, i4)), i + 1, this.lastBracket, this.lastDelimiter));
        } else {
            BasedSequence basedSequence = this.input;
            int i5 = this.index;
            appendText(basedSequence.subSequence(i5 - 1, i5));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0234 A[PHI: r10 r11
      0x0234: PHI (r10v21 boolean) = (r10v20 boolean), (r10v20 boolean), (r10v20 boolean), (r10v20 boolean), (r10v22 boolean), (r10v20 boolean) binds: [B:101:0x01d5, B:109:0x020e, B:121:0x0247, B:117:0x0230, B:118:0x0232, B:115:0x0220] A[DONT_GENERATE, DONT_INLINE]
      0x0234: PHI (r11v18 boolean) = (r11v1 boolean), (r11v1 boolean), (r11v1 boolean), (r11v1 boolean), (r11v20 boolean), (r11v1 boolean) binds: [B:101:0x01d5, B:109:0x020e, B:121:0x0247, B:117:0x0230, B:118:0x0232, B:115:0x0220] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x025a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02d6 A[LOOP:1: B:146:0x02d4->B:147:0x02d6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean parseCloseBracket() {
        BasedSequence basedSequenceSubSequence;
        BasedSequence basedSequenceSubSequence2;
        boolean z;
        BasedSequence basedSequenceSubSequence3;
        BasedSequence linkDestination;
        BasedSequence linkTitle;
        BasedSequence basedSequence;
        ReferenceProcessorMatch referenceProcessorMatch;
        boolean z2;
        boolean z3;
        boolean zIsImage;
        Node imageRef;
        Node next;
        Bracket bracket;
        boolean z4;
        BasedSequence basedSequence2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        int i;
        BasedSequence basedSequenceSubSequence4;
        int i2 = this.index;
        int i4 = i2 + 1;
        this.index = i4;
        Bracket bracket2 = this.lastBracket;
        boolean z9 = true;
        if (bracket2 == null) {
            appendText(this.input.subSequence(i2, i4));
            return true;
        }
        if (!bracket2.isAllowed()) {
            BasedSequence basedSequence3 = this.input;
            int i5 = this.index;
            appendText(basedSequence3.subSequence(i5 - 1, i5));
            removeLastBracket();
            return true;
        }
        BasedSequence basedSequenceSubSequence5 = BasedSequence.NULL;
        int i6 = this.index;
        if (this.options.spaceInLinkElements && peek() == ' ') {
            mo13314sp();
        }
        if (peek() == '(') {
            int i7 = this.index;
            basedSequenceSubSequence = this.input.subSequence(i7, i7 + 1);
            this.index++;
            spnl();
            linkDestination = parseLinkDestination();
            if (linkDestination != null) {
                if (this.options.parseMultiLineImageUrls && bracket2.isImage() && !linkDestination.startsWith("<") && linkDestination.endsWith(MsalUtils.QUERY_STRING_SYMBOL) && spnlUrl()) {
                    int i8 = this.index;
                    int i9 = i8;
                    while (true) {
                        mo13314sp();
                        linkTitle = parseLinkTitle();
                        if (linkTitle != null) {
                            mo13314sp();
                        }
                        if (peek() == ')') {
                            BasedSequence basedSequence4 = this.input;
                            int i10 = this.index;
                            basedSequenceSubSequence2 = basedSequence4.subSequence(i10, i10 + 1);
                            this.index++;
                            basedSequenceSubSequence3 = this.input.subSequence(i8, i9);
                            z = true;
                            break;
                        }
                        if (toEOL() == null) {
                            break;
                        }
                        i9 = this.index;
                    }
                } else {
                    spnl();
                    Pattern pattern = this.myParsing.WHITESPACE;
                    BasedSequence basedSequence5 = this.input;
                    int i11 = this.index;
                    if (pattern.matcher(basedSequence5.subSequence(i11 - 1, i11)).matches()) {
                        BasedSequence linkTitle2 = parseLinkTitle();
                        spnl();
                        linkTitle = linkTitle2;
                    } else {
                        linkTitle = null;
                    }
                    if (peek() == ')') {
                        BasedSequence basedSequence6 = this.input;
                        int i12 = this.index;
                        basedSequenceSubSequence2 = basedSequence6.subSequence(i12, i12 + 1);
                        this.index++;
                        z = true;
                    } else {
                        this.index = i7;
                        basedSequenceSubSequence2 = basedSequenceSubSequence5;
                        z = false;
                    }
                    basedSequenceSubSequence3 = null;
                }
                if (z) {
                    ReferenceProcessorMatch referenceProcessorMatchMatchLinkRef = !this.options.matchLookaheadFirst ? matchLinkRef(bracket2, i4, 0, 0) : null;
                    if (referenceProcessorMatchMatchLinkRef != null) {
                        z8 = true;
                    } else {
                        int i13 = this.linkRefProcessorsData.maxNesting;
                        if (i13 > 0) {
                            Bracket previous = bracket2;
                            i = 0;
                            while (true) {
                                if (previous.getPrevious() == null) {
                                    z8 = z9;
                                    break;
                                }
                                z8 = z9;
                                if (previous.getStartIndex() != previous.getPrevious().getStartIndex() + 1 || peek(i) != ']') {
                                    break;
                                }
                                previous = previous.getPrevious();
                                i++;
                                if (i == i13 || previous.isImage()) {
                                    break;
                                }
                                z9 = z8;
                            }
                        } else {
                            z8 = true;
                            i = 0;
                        }
                        int i14 = i + 1;
                        while (true) {
                            int i15 = i14 - 1;
                            if (i14 <= 0) {
                                break;
                            }
                            referenceProcessorMatchMatchLinkRef = matchLinkRef(bracket2, i4, i15, 0);
                            if (referenceProcessorMatchMatchLinkRef == null) {
                                i14 = i15;
                            } else if (i15 > 0) {
                                while (true) {
                                    int i16 = i15 - 1;
                                    if (i15 <= 0) {
                                        break;
                                    }
                                    this.index++;
                                    this.lastBracket.getNode().unlink();
                                    removeLastBracket();
                                    i15 = i16;
                                }
                                bracket2 = this.lastBracket;
                            }
                        }
                    }
                    if (referenceProcessorMatchMatchLinkRef == null) {
                        int i17 = this.index;
                        int linkLabel = parseLinkLabel();
                        if (linkLabel > 2) {
                            basedSequenceSubSequence4 = this.input.subSequence(i17, linkLabel + i17);
                        } else {
                            if (!bracket2.isBracketAfter()) {
                                basedSequenceSubSequence5 = this.input.subSequence(i17, linkLabel + i17);
                                basedSequenceSubSequence4 = bracket2.isImage() ? this.input.subSequence(bracket2.getStartIndex() - 1, i4) : this.input.subSequence(bracket2.getStartIndex(), i4);
                                z3 = z8;
                                BasedSequence basedSequence7 = basedSequenceSubSequence5;
                                if (basedSequenceSubSequence4 == null) {
                                    if (this.referenceRepository.containsKey(Escaping.normalizeReferenceChars(basedSequenceSubSequence4, z8))) {
                                        BasedSequence basedSequenceSubSequence6 = this.input.subSequence(bracket2.getStartIndex(), i4);
                                        if (z3) {
                                            basedSequenceSubSequence6 = basedSequenceSubSequence4;
                                        }
                                        z = !containsLinkRefs(basedSequenceSubSequence6, bracket2.getNode().getNext(), Boolean.FALSE);
                                        basedSequence = basedSequenceSubSequence4;
                                        referenceProcessorMatch = referenceProcessorMatchMatchLinkRef;
                                        basedSequenceSubSequence5 = basedSequence7;
                                        z2 = true;
                                    } else if (bracket2.isStraddling(basedSequenceSubSequence4)) {
                                        basedSequence = basedSequenceSubSequence4;
                                        referenceProcessorMatch = referenceProcessorMatchMatchLinkRef;
                                        basedSequenceSubSequence5 = basedSequence7;
                                        z2 = false;
                                    } else {
                                        if (z3 || peek() != '[') {
                                            if (!containsLinkRefs(basedSequenceSubSequence4, bracket2.getNode().getNext(), null)) {
                                                basedSequence = basedSequenceSubSequence4;
                                                referenceProcessorMatch = referenceProcessorMatchMatchLinkRef;
                                                basedSequenceSubSequence5 = basedSequence7;
                                                z2 = false;
                                                z = true;
                                            }
                                        } else if (parseLinkLabel() > 0) {
                                            this.index = i17;
                                        } else if (!containsLinkRefs(basedSequenceSubSequence4, bracket2.getNode().getNext(), null)) {
                                            z3 = true;
                                            z = true;
                                        }
                                        basedSequence = basedSequenceSubSequence4;
                                        referenceProcessorMatch = referenceProcessorMatchMatchLinkRef;
                                        basedSequenceSubSequence5 = basedSequence7;
                                        z2 = false;
                                    }
                                }
                                if (z && referenceProcessorMatch == null) {
                                    this.index = i4;
                                    appendText(this.input.subSequence(i2, i4));
                                    removeLastBracket();
                                    return true;
                                }
                                flushTextNode();
                                zIsImage = bracket2.isImage();
                                if (referenceProcessorMatch == null) {
                                    if (!referenceProcessorMatch.wantExclamation && zIsImage) {
                                        appendText(this.input.subSequence(bracket2.getStartIndex() - 1, bracket2.getStartIndex()));
                                        bracket2.getNode().setChars(bracket2.getNode().getChars().subSequence(1));
                                        zIsImage = false;
                                    }
                                    imageRef = referenceProcessorMatch.processor.createNode(referenceProcessorMatch.nodeChars);
                                } else {
                                    imageRef = basedSequence != null ? zIsImage ? new ImageRef() : new LinkRef() : zIsImage ? new Image() : new Link();
                                }
                                next = bracket2.getNode().getNext();
                                while (next != null) {
                                    Node next2 = next.getNext();
                                    imageRef.appendChild(next);
                                    next = next2;
                                }
                                if (referenceProcessorMatch == null && imageRef.hasChildren()) {
                                    BasedSequence childChars = imageRef.getChildChars();
                                    bracket = bracket2;
                                    z4 = z2;
                                    BasedSequence basedSequenceAdjustInlineText = referenceProcessorMatch.processor.adjustInlineText(this.document, imageRef);
                                    Delimiter delimiter = this.lastDelimiter;
                                    while (delimiter != null) {
                                        Delimiter previous2 = delimiter.getPrevious();
                                        boolean z10 = z3;
                                        boolean z11 = zIsImage;
                                        BasedSequence basedSequence8 = basedSequenceSubSequence3;
                                        BasedSequence basedSequenceSubSequence7 = delimiter.getInput().subSequence(delimiter.getStartIndex(), delimiter.getEndIndex());
                                        if (childChars.containsAllOf(basedSequenceSubSequence7) && (!basedSequenceAdjustInlineText.containsAllOf(basedSequenceSubSequence7) || !referenceProcessorMatch.processor.allowDelimiters(basedSequenceSubSequence7, this.document, imageRef))) {
                                            removeDelimiterKeepNode(delimiter);
                                        }
                                        delimiter = previous2;
                                        z3 = z10;
                                        zIsImage = z11;
                                        basedSequenceSubSequence3 = basedSequence8;
                                    }
                                    basedSequence2 = basedSequenceSubSequence3;
                                    z5 = z3;
                                    z6 = zIsImage;
                                    if (!basedSequenceAdjustInlineText.containsAllOf(childChars)) {
                                        ReversiblePeekingIterator<Node> it = imageRef.getChildren().iterator();
                                        while (it.hasNext()) {
                                            Node next3 = it.next();
                                            BasedSequence chars = next3.getChars();
                                            if (!basedSequenceAdjustInlineText.containsSomeOf(chars)) {
                                                next3.unlink();
                                            } else if (!basedSequenceAdjustInlineText.containsAllOf(chars)) {
                                                next3.setChars(basedSequenceAdjustInlineText.intersect(chars));
                                            }
                                        }
                                    }
                                } else {
                                    bracket = bracket2;
                                    z4 = z2;
                                    basedSequence2 = basedSequenceSubSequence3;
                                    z5 = z3;
                                    z6 = zIsImage;
                                }
                                appendNode(imageRef);
                                z7 = imageRef instanceof RefNode;
                                if (!z7) {
                                    RefNode refNode = (RefNode) imageRef;
                                    refNode.setReferenceChars(basedSequence);
                                    if (z4) {
                                        refNode.setDefined(true);
                                    }
                                    if (!z5) {
                                        BasedSequence basedSequence9 = this.input;
                                        int startIndex = bracket.getStartIndex();
                                        if (z6) {
                                            startIndex--;
                                        }
                                        refNode.setTextChars(basedSequence9.subSequence(startIndex, i4));
                                    } else if (!basedSequenceSubSequence5.isEmpty()) {
                                        refNode.setTextOpeningMarker(basedSequenceSubSequence5.subSequence(0, 1));
                                        refNode.setTextClosingMarker(basedSequenceSubSequence5.endSequence(1));
                                    }
                                    imageRef.setCharsFromContent();
                                } else if (imageRef instanceof InlineLinkNode) {
                                    InlineLinkNode inlineLinkNode = (InlineLinkNode) imageRef;
                                    inlineLinkNode.setUrlChars(linkDestination);
                                    inlineLinkNode.setTitleChars(linkTitle);
                                    inlineLinkNode.setLinkOpeningMarker(basedSequenceSubSequence);
                                    inlineLinkNode.setLinkClosingMarker(basedSequenceSubSequence2);
                                    BasedSequence basedSequence10 = this.input;
                                    int startIndex2 = bracket.getStartIndex();
                                    if (z6) {
                                        startIndex2--;
                                    }
                                    inlineLinkNode.setTextChars(basedSequence10.subSequence(startIndex2, i4));
                                    if (basedSequence2 != null) {
                                        ((Image) imageRef).setUrlContent(basedSequence2);
                                    }
                                    imageRef.setCharsFromContent();
                                }
                                processDelimiters(bracket.getPreviousDelimiter());
                                Text node = bracket.getNode();
                                removeLastBracket();
                                if (referenceProcessorMatch != null) {
                                    referenceProcessorMatch.processor.updateNodeElements(this.document, imageRef);
                                }
                                if (imageRef instanceof Link) {
                                    if (!z7) {
                                        node.unlink();
                                        return true;
                                    }
                                    collapseLinkRefChildren(imageRef, new C11419a(9), true);
                                    node.unlink();
                                    return true;
                                }
                                for (Bracket previous3 = this.lastBracket; previous3 != null; previous3 = previous3.getPrevious()) {
                                    if (!previous3.isImage()) {
                                        previous3.setAllowed(false);
                                    }
                                }
                                if (this.options.linkTextPriorityOverLinkRef || !containsLinkRefs(imageRef, Boolean.FALSE)) {
                                    collapseLinkRefChildren(imageRef, new C11419a(8), true);
                                    node.unlink();
                                    return true;
                                }
                                imageRef.unlink();
                                this.block.takeChildren(imageRef);
                                appendText(imageRef.baseSubSequence(((Link) imageRef).getTextClosingMarker().getStartOffset(), imageRef.getEndOffset()));
                                return true;
                            }
                            basedSequenceSubSequence4 = null;
                        }
                        z3 = false;
                        BasedSequence basedSequence72 = basedSequenceSubSequence5;
                        if (basedSequenceSubSequence4 == null) {
                        }
                        if (z) {
                        }
                        flushTextNode();
                        zIsImage = bracket2.isImage();
                        if (referenceProcessorMatch == null) {
                        }
                        next = bracket2.getNode().getNext();
                        while (next != null) {
                        }
                        if (referenceProcessorMatch == null) {
                            bracket = bracket2;
                            z4 = z2;
                            basedSequence2 = basedSequenceSubSequence3;
                            z5 = z3;
                            z6 = zIsImage;
                        }
                        appendNode(imageRef);
                        z7 = imageRef instanceof RefNode;
                        if (!z7) {
                        }
                        processDelimiters(bracket.getPreviousDelimiter());
                        Text node2 = bracket.getNode();
                        removeLastBracket();
                        if (referenceProcessorMatch != null) {
                        }
                        if (imageRef instanceof Link) {
                        }
                    } else {
                        basedSequence = null;
                        referenceProcessorMatch = referenceProcessorMatchMatchLinkRef;
                    }
                } else {
                    basedSequence = null;
                    referenceProcessorMatch = null;
                }
                z2 = false;
                z3 = false;
                if (z) {
                }
                flushTextNode();
                zIsImage = bracket2.isImage();
                if (referenceProcessorMatch == null) {
                }
                next = bracket2.getNode().getNext();
                while (next != null) {
                }
                if (referenceProcessorMatch == null) {
                }
                appendNode(imageRef);
                z7 = imageRef instanceof RefNode;
                if (!z7) {
                }
                processDelimiters(bracket.getPreviousDelimiter());
                Text node22 = bracket.getNode();
                removeLastBracket();
                if (referenceProcessorMatch != null) {
                }
                if (imageRef instanceof Link) {
                }
            } else {
                this.index = i7;
            }
            basedSequenceSubSequence2 = basedSequenceSubSequence5;
            z = false;
            basedSequenceSubSequence3 = null;
        } else {
            this.index = i6;
            basedSequenceSubSequence = basedSequenceSubSequence5;
            basedSequenceSubSequence2 = basedSequenceSubSequence;
            z = false;
            basedSequenceSubSequence3 = null;
            linkDestination = null;
        }
        linkTitle = null;
        if (z) {
        }
        z2 = false;
        z3 = false;
        if (z) {
        }
        flushTextNode();
        zIsImage = bracket2.isImage();
        if (referenceProcessorMatch == null) {
        }
        next = bracket2.getNode().getNext();
        while (next != null) {
        }
        if (referenceProcessorMatch == null) {
        }
        appendNode(imageRef);
        z7 = imageRef instanceof RefNode;
        if (!z7) {
        }
        processDelimiters(bracket.getPreviousDelimiter());
        Text node222 = bracket.getNode();
        removeLastBracket();
        if (referenceProcessorMatch != null) {
        }
        if (imageRef instanceof Link) {
        }
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    @Nullable
    public List<Node> parseCustom(@NotNull BasedSequence basedSequence, @NotNull Node node, @NotNull BitSet bitSet, @NotNull Map<Character, CharacterNodeFactory> map) {
        this.customCharacters = bitSet;
        this.specialCharacters.or(bitSet);
        this.customSpecialCharacterFactoryMap = map;
        this.customSpecialCharacterNodes = null;
        parse(basedSequence, node);
        this.specialCharacters = this.originalSpecialCharacters;
        this.customSpecialCharacterFactoryMap = null;
        this.customCharacters = null;
        return this.customSpecialCharacterNodes;
    }

    public boolean parseDelimiters(DelimiterProcessor delimiterProcessor, char c) {
        DelimiterData delimiterDataScanDelimiters = scanDelimiters(delimiterProcessor, c);
        if (delimiterDataScanDelimiters == null) {
            return false;
        }
        int i = delimiterDataScanDelimiters.count;
        int i2 = this.index;
        int i4 = i2 + i;
        this.index = i4;
        Delimiter delimiter = new Delimiter(this.input, appendSeparateText(this.input.subSequence(i2, i4)), c, delimiterDataScanDelimiters.canOpen, delimiterDataScanDelimiters.canClose, this.lastDelimiter, i2);
        this.lastDelimiter = delimiter;
        delimiter.setNumDelims(i);
        if (this.lastDelimiter.getPrevious() == null) {
            return true;
        }
        this.lastDelimiter.getPrevious().setNext(this.lastDelimiter);
        return true;
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public boolean parseEntity() {
        BasedSequence basedSequenceMatch = match(this.myParsing.ENTITY_HERE);
        if (basedSequenceMatch == null) {
            return false;
        }
        appendNode(new HtmlEntity(basedSequenceMatch));
        return true;
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public boolean parseHtmlInline() {
        BasedSequence basedSequenceMatch = match(this.myParsing.HTML_TAG);
        if (basedSequenceMatch == null) {
            return false;
        }
        appendNode((basedSequenceMatch.startsWith("<!--") && basedSequenceMatch.endsWith("-->")) ? new HtmlInlineComment(basedSequenceMatch) : new HtmlInline(basedSequenceMatch));
        return true;
    }

    public boolean parseInline() {
        return parseInline(false);
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public BasedSequence parseLinkDestination() {
        BasedSequence basedSequenceMatch = match(this.myParsing.LINK_DESTINATION_ANGLES);
        if (basedSequenceMatch != null) {
            return basedSequenceMatch;
        }
        LinkDestinationParser linkDestinationParser = this.linkDestinationParser;
        if (linkDestinationParser != null) {
            BasedSequence linkDestination = linkDestinationParser.parseLinkDestination(this.input, this.index);
            this.index = linkDestination.length() + this.index;
            return linkDestination;
        }
        InlineParserOptions inlineParserOptions = this.options;
        boolean z = inlineParserOptions.spaceInLinkUrls;
        if (!inlineParserOptions.linksAllowMatchedParentheses) {
            BasedSequence basedSequenceMatch2 = match(this.myParsing.LINK_DESTINATION);
            return (basedSequenceMatch2 == null || !z) ? basedSequenceMatch2 : basedSequenceMatch2.trimEnd(CharPredicate.SPACE);
        }
        BasedSequence basedSequenceMatch3 = match(this.myParsing.LINK_DESTINATION_MATCHED_PARENS);
        if (basedSequenceMatch3 == null) {
            return null;
        }
        int length = basedSequenceMatch3.length();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char cCharAt = basedSequenceMatch3.charAt(i);
            if (cCharAt == '\\') {
                int i4 = i + 1;
                if (i4 < length && this.myParsing.ESCAPABLE.matcher(basedSequenceMatch3.subSequence(i4, i + 2)).matches()) {
                    i = i4;
                }
            } else if (cCharAt == '(') {
                i2++;
            } else if (cCharAt != ')') {
                continue;
            } else {
                if (i2 == 0) {
                    this.index -= length - i;
                    basedSequenceMatch3 = basedSequenceMatch3.subSequence(0, i);
                    break;
                }
                i2--;
            }
            i++;
        }
        return z ? basedSequenceMatch3.trimEnd(CharPredicate.SPACE) : basedSequenceMatch3;
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public int parseLinkLabel() {
        BasedSequence basedSequenceMatch = match(this.myParsing.LINK_LABEL);
        if (basedSequenceMatch == null) {
            return 0;
        }
        return basedSequenceMatch.length();
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public BasedSequence parseLinkTitle() {
        return match(this.myParsing.LINK_TITLE);
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public boolean parseNewline() {
        Node softLineBreak;
        int i = (this.index >= this.input.length() - 1 || this.input.charAt(this.index + 1) != '\n') ? 0 : 1;
        this.index = i + 1 + this.index;
        flushTextNode();
        Node lastChild = this.block.getLastChild();
        if ((lastChild instanceof Text) && lastChild.getChars().endsWith(" ")) {
            BasedSequence chars = ((Text) lastChild).getChars();
            Matcher matcher = this.myParsing.FINAL_SPACE.matcher(chars);
            int iEnd = matcher.find() ? matcher.end() - matcher.start() : 0;
            if (iEnd >= 2) {
                BasedSequence basedSequence = this.input;
                int i2 = this.index;
                softLineBreak = new HardLineBreak(basedSequence.subSequence(i2 - (this.options.hardLineBreakLimit ? i + 3 : i + (iEnd + 1)), i2));
            } else {
                BasedSequence basedSequence2 = this.input;
                int i4 = this.index;
                softLineBreak = new SoftLineBreak(basedSequence2.subSequence((i4 - 1) - i, i4));
            }
            appendNode(softLineBreak);
            if (iEnd > 0) {
                if (chars.length() > iEnd) {
                    lastChild.setChars(chars.subSequence(0, chars.length() - iEnd).trimEnd());
                } else {
                    lastChild.unlink();
                }
            }
        } else {
            BasedSequence basedSequence3 = this.input;
            int i5 = this.index;
            appendNode(new SoftLineBreak(basedSequence3.subSequence((i5 - 1) - i, i5)));
        }
        while (peek() == ' ') {
            this.index++;
        }
        return true;
    }

    public boolean parseOpenBracket() {
        int i = this.index;
        int i2 = i + 1;
        this.index = i2;
        addBracket(Bracket.link(this.input, appendSeparateText(this.input.subSequence(i, i2)), i, this.lastBracket, this.lastDelimiter));
        return true;
    }

    public int parseReference(Block block, BasedSequence basedSequence) {
        boolean z;
        this.input = basedSequence;
        this.index = 0;
        int linkLabel = parseLinkLabel();
        if (linkLabel == 0 || peek() != ':') {
            return 0;
        }
        BasedSequence basedSequenceSubSequence = this.input.subSequence(0, linkLabel + 1);
        this.index++;
        spnl();
        BasedSequence linkDestination = parseLinkDestination();
        if (linkDestination == null || linkDestination.length() == 0) {
            return 0;
        }
        int i = this.index;
        spnl();
        BasedSequence linkTitle = parseLinkTitle();
        if (linkTitle == null) {
            this.index = i;
        }
        if (this.index == this.input.length() || match(this.myParsing.LINE_END) != null) {
            z = true;
        } else if (linkTitle == null) {
            z = false;
        } else {
            this.index = i;
            z = match(this.myParsing.LINE_END) != null;
            linkTitle = null;
        }
        if (!z) {
            return 0;
        }
        String strNormalizeReferenceChars = Escaping.normalizeReferenceChars(basedSequenceSubSequence, true);
        if (strNormalizeReferenceChars.isEmpty()) {
            return 0;
        }
        Reference reference = new Reference(basedSequenceSubSequence, linkDestination, linkTitle);
        this.referenceRepository.put(strNormalizeReferenceChars, reference);
        block.insertBefore(reference);
        return this.index;
    }

    public boolean parseString() {
        int i = this.index;
        int length = this.input.length();
        while (true) {
            int i2 = this.index;
            if (i2 == length || this.specialCharacters.get(this.input.charAt(i2))) {
                break;
            }
            this.index++;
        }
        int i4 = this.index;
        if (i == i4) {
            return false;
        }
        appendText(this.input, i, i4);
        return true;
    }

    @Override // com.vladsch.flexmark.parser.block.ParagraphPreProcessor
    public int preProcessBlock(Paragraph paragraph, ParserState parserState) {
        BasedSequence chars = paragraph.getChars();
        int iCountLeading = chars.countLeading(CharPredicate.SPACE_TAB);
        int length = chars.length();
        while (iCountLeading <= 3 && length > iCountLeading + 3 && chars.charAt(iCountLeading) == '[') {
            if (iCountLeading > 0) {
                chars = chars.subSequence(iCountLeading, length);
                length -= iCountLeading;
            }
            int reference = parseReference(paragraph, chars);
            if (reference == 0) {
                break;
            }
            chars = chars.subSequence(reference, length);
            length = chars.length();
            iCountLeading = chars.countLeading(CharPredicate.SPACE_TAB);
        }
        return chars.getStartOffset() - paragraph.getStartOffset();
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void processDelimiters(Delimiter delimiter) {
        boolean z;
        HashMap map = new HashMap();
        Delimiter next = this.lastDelimiter;
        while (next != null && next.getPrevious() != delimiter) {
            next = next.getPrevious();
        }
        while (next != null) {
            char delimiterChar = next.getDelimiterChar();
            DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(delimiterChar));
            if (!next.canClose() || delimiterProcessor == null) {
                next = next.getNext();
            } else {
                char openingCharacter = delimiterProcessor.getOpeningCharacter();
                Delimiter previous = next.getPrevious();
                int delimiterUse = 0;
                boolean z2 = false;
                while (previous != null && previous != delimiter && previous != map.get(Character.valueOf(delimiterChar))) {
                    if (previous.canOpen() && previous.getDelimiterChar() == openingCharacter) {
                        delimiterUse = delimiterProcessor.getDelimiterUse(previous, next);
                        z2 = true;
                        if (delimiterUse > 0) {
                            z = true;
                            break;
                        }
                    }
                    previous = previous.getPrevious();
                }
                z = z2;
                z2 = false;
                if (z2) {
                    previous.setNumDelims(previous.getNumDelims() - delimiterUse);
                    next.setNumDelims(next.getNumDelims() - delimiterUse);
                    removeDelimitersBetween(previous, next);
                    previous.setNumDelims(previous.getNumDelims() + delimiterUse);
                    next.setNumDelims(next.getNumDelims() + delimiterUse);
                    delimiterProcessor.process(previous, next, delimiterUse);
                    previous.setNumDelims(previous.getNumDelims() - delimiterUse);
                    next.setNumDelims(next.getNumDelims() - delimiterUse);
                    if (previous.getNumDelims() == 0) {
                        removeDelimiterAndNode(previous);
                    } else {
                        previous.getNode().setChars(previous.getNode().getChars().subSequence(0, previous.getNumDelims()));
                    }
                    if (next.getNumDelims() == 0) {
                        Delimiter next2 = next.getNext();
                        removeDelimiterAndNode(next);
                        next = next2;
                    } else {
                        BasedSequence chars = next.getNode().getChars();
                        int length = chars.length();
                        next.getNode().setChars(chars.subSequence(length - next.getNumDelims(), length));
                        next.setIndex(next.getIndex() + delimiterUse);
                    }
                } else {
                    if (!z) {
                        map.put(Character.valueOf(delimiterChar), next.getPrevious());
                        if (!next.canOpen()) {
                            removeDelimiterKeepNode(next);
                        }
                    }
                    next = next.getNext();
                }
            }
        }
        while (true) {
            Delimiter delimiter2 = this.lastDelimiter;
            if (delimiter2 == null || delimiter2 == delimiter) {
                return;
            } else {
                removeDelimiterKeepNode(delimiter2);
            }
        }
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void removeDelimiter(@NotNull Delimiter delimiter) {
        if (delimiter.getPrevious() != null) {
            delimiter.getPrevious().setNext(delimiter.getNext());
        }
        if (delimiter.getNext() == null) {
            this.lastDelimiter = delimiter.getPrevious();
        } else {
            delimiter.getNext().setPrevious(delimiter.getPrevious());
        }
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void removeDelimiterAndNode(@NotNull Delimiter delimiter) {
        Text node = delimiter.getNode();
        Text previousNonDelimiterTextNode = delimiter.getPreviousNonDelimiterTextNode();
        Text nextNonDelimiterTextNode = delimiter.getNextNonDelimiterTextNode();
        if (previousNonDelimiterTextNode != null && nextNonDelimiterTextNode != null) {
            previousNonDelimiterTextNode.setChars(this.input.baseSubSequence(previousNonDelimiterTextNode.getStartOffset(), nextNonDelimiterTextNode.getEndOffset()));
            nextNonDelimiterTextNode.unlink();
        }
        node.unlink();
        removeDelimiter(delimiter);
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void removeDelimiterKeepNode(@NotNull Delimiter delimiter) {
        DelimiterProcessor delimiterProcessor = this.delimiterProcessors.get(Character.valueOf(delimiter.getDelimiterChar()));
        Node nodeUnmatchedDelimiterNode = delimiterProcessor != null ? delimiterProcessor.unmatchedDelimiterNode(this, delimiter) : null;
        if (nodeUnmatchedDelimiterNode == null) {
            nodeUnmatchedDelimiterNode = delimiter.getNode();
        } else if (nodeUnmatchedDelimiterNode != delimiter.getNode()) {
            delimiter.getNode().insertAfter(nodeUnmatchedDelimiterNode);
            delimiter.getNode().unlink();
        }
        Text previousNonDelimiterTextNode = delimiter.getPreviousNonDelimiterTextNode();
        Text nextNonDelimiterTextNode = delimiter.getNextNonDelimiterTextNode();
        if ((nodeUnmatchedDelimiterNode instanceof Text) && (previousNonDelimiterTextNode != null || nextNonDelimiterTextNode != null)) {
            if (nextNonDelimiterTextNode != null && previousNonDelimiterTextNode != null) {
                nodeUnmatchedDelimiterNode.setChars(this.input.baseSubSequence(previousNonDelimiterTextNode.getStartOffset(), nextNonDelimiterTextNode.getEndOffset()));
                previousNonDelimiterTextNode.unlink();
                nextNonDelimiterTextNode.unlink();
            } else if (previousNonDelimiterTextNode != null) {
                nodeUnmatchedDelimiterNode.setChars(this.input.baseSubSequence(previousNonDelimiterTextNode.getStartOffset(), nodeUnmatchedDelimiterNode.getEndOffset()));
                previousNonDelimiterTextNode.unlink();
            } else {
                nodeUnmatchedDelimiterNode.setChars(this.input.baseSubSequence(nodeUnmatchedDelimiterNode.getStartOffset(), nextNonDelimiterTextNode.getEndOffset()));
                nextNonDelimiterTextNode.unlink();
            }
        }
        removeDelimiter(delimiter);
    }

    @Override // com.vladsch.flexmark.parser.InlineParser
    public void removeDelimitersBetween(@NotNull Delimiter delimiter, @NotNull Delimiter delimiter2) {
        Delimiter previous = delimiter2.getPrevious();
        while (previous != null && previous != delimiter) {
            Delimiter previous2 = previous.getPrevious();
            removeDelimiterKeepNode(previous);
            previous = previous2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008a A[PHI: r5 r8 r9
      0x008a: PHI (r5v24 boolean) = (r5v16 boolean), (r5v16 boolean), (r5v16 boolean), (r5v28 boolean), (r5v28 boolean), (r5v28 boolean) binds: [B:42:0x00b7, B:43:0x00b9, B:44:0x00bb, B:28:0x0084, B:29:0x0086, B:30:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x008a: PHI (r8v11 boolean) = (r8v7 boolean), (r8v7 boolean), (r8v7 boolean), (r8v15 boolean), (r8v15 boolean), (r8v15 boolean) binds: [B:42:0x00b7, B:43:0x00b9, B:44:0x00bb, B:28:0x0084, B:29:0x0086, B:30:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x008a: PHI (r9v8 boolean) = (r9v2 boolean), (r9v2 boolean), (r9v2 boolean), (r9v10 boolean), (r9v10 boolean), (r9v10 boolean) binds: [B:42:0x00b7, B:43:0x00b9, B:44:0x00bb, B:28:0x0084, B:29:0x0086, B:30:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c A[PHI: r5 r8 r9
      0x008c: PHI (r5v17 boolean) = (r5v16 boolean), (r5v16 boolean), (r5v28 boolean), (r5v28 boolean) binds: [B:41:0x00b5, B:44:0x00bb, B:27:0x0082, B:30:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r8v8 boolean) = (r8v7 boolean), (r8v7 boolean), (r8v15 boolean), (r8v15 boolean) binds: [B:41:0x00b5, B:44:0x00bb, B:27:0x0082, B:30:0x0088] A[DONT_GENERATE, DONT_INLINE]
      0x008c: PHI (r9v4 boolean) = (r9v2 boolean), (r9v2 boolean), (r9v10 boolean), (r9v10 boolean) binds: [B:41:0x00b5, B:44:0x00bb, B:27:0x0082, B:30:0x0088] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DelimiterData scanDelimiters(DelimiterProcessor delimiterProcessor, char c) {
        boolean zMatches;
        boolean zMatches2;
        boolean z;
        boolean z2;
        int i = this.index;
        boolean z3 = false;
        int i2 = 0;
        while (peek() == c) {
            i2++;
            this.index++;
        }
        if (i2 < delimiterProcessor.getMinLength()) {
            this.index = i;
            return null;
        }
        String strValueOf = i == 0 ? "\n" : String.valueOf(this.input.charAt(i - 1));
        char cPeek = peek();
        String strValueOf2 = cPeek != 0 ? String.valueOf(cPeek) : "\n";
        boolean zMatches3 = this.myParsing.UNICODE_WHITESPACE_CHAR.matcher(strValueOf).matches();
        boolean zMatches4 = this.myParsing.UNICODE_WHITESPACE_CHAR.matcher(strValueOf2).matches();
        if (this.options.inlineDelimiterDirectionalPunctuations) {
            zMatches = this.myParsing.PUNCTUATION_OPEN.matcher(strValueOf).matches();
            zMatches2 = this.myParsing.PUNCTUATION_CLOSE.matcher(strValueOf2).matches();
            z = !zMatches4 && (!zMatches2 || zMatches3 || zMatches);
            z2 = !zMatches3 && (!zMatches || zMatches4 || zMatches2);
        } else {
            zMatches = this.myParsing.PUNCTUATION.matcher(strValueOf).matches();
            zMatches2 = this.myParsing.PUNCTUATION.matcher(strValueOf2).matches();
            z = !zMatches4 && (!zMatches2 || zMatches3 || zMatches);
            if (zMatches3 || (zMatches && !zMatches4 && !zMatches2)) {
            }
        }
        boolean z4 = zMatches;
        boolean z5 = zMatches2;
        boolean z6 = z2;
        boolean z7 = z;
        boolean z8 = c == delimiterProcessor.getOpeningCharacter() && delimiterProcessor.canBeOpener(strValueOf, strValueOf2, z7, z6, z4, z5, zMatches3, zMatches4);
        if (c == delimiterProcessor.getClosingCharacter() && delimiterProcessor.canBeCloser(strValueOf, strValueOf2, z7, z6, z4, z5, zMatches3, zMatches4)) {
            z3 = true;
        }
        this.index = i;
        if (z8 || z3 || !delimiterProcessor.skipNonOpenerCloser()) {
            return new DelimiterData(i2, z8, z3);
        }
        return null;
    }

    public boolean parseInline(boolean z) {
        boolean newline;
        Map<Character, List<InlineParserExtension>> map;
        List<InlineParserExtension> list;
        char cPeek = peek();
        if (cPeek == 0) {
            return false;
        }
        if (!z && (map = this.inlineParserExtensions) != null && (list = map.get(Character.valueOf(cPeek))) != null) {
            Iterator<InlineParserExtension> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().parse(this)) {
                    return true;
                }
            }
        }
        BitSet bitSet = this.customCharacters;
        if (bitSet != null && bitSet.get(cPeek)) {
            if (processCustomCharacters()) {
                processDelimiters(null);
                this.lastDelimiter = null;
            } else {
                int i = this.index;
                int i2 = i + 1;
                this.index = i2;
                appendText(this.input.subSequence(i, i2));
            }
            return true;
        }
        if (cPeek == '\n' || cPeek == '\r') {
            newline = parseNewline();
        } else if (cPeek == '!') {
            newline = parseBang();
        } else if (cPeek == '&') {
            newline = parseEntity();
        } else if (cPeek != '<') {
            if (cPeek != '`') {
                switch (cPeek) {
                    case '[':
                        newline = parseOpenBracket();
                        break;
                    case '\\':
                        newline = parseBackslash();
                        break;
                    case ']':
                        newline = parseCloseBracket();
                        break;
                    default:
                        newline = !this.delimiterCharacters.get(cPeek) ? parseString() : parseDelimiters(this.delimiterProcessors.get(Character.valueOf(cPeek)), cPeek);
                        break;
                }
            } else {
                newline = parseBackticks();
            }
        } else if (this.delimiterCharacters.get(cPeek) && peek(1) == '<') {
            newline = parseDelimiters(this.delimiterProcessors.get(Character.valueOf(cPeek)), cPeek);
        } else {
            newline = parseAutolink() || parseHtmlInline();
        }
        if (!newline) {
            int i4 = this.index;
            int i5 = i4 + 1;
            this.index = i5;
            appendText(this.input.subSequence(i4, i5));
        }
        return true;
    }

    public static boolean containsLinkRefs(BasedSequence basedSequence, Node node, Boolean bool) {
        int startOffset = basedSequence.getStartOffset();
        int endOffset = basedSequence.getEndOffset();
        while (node != null) {
            if ((node instanceof LinkRefDerived) && ((bool == null || ((LinkRefDerived) node).isTentative() == bool.booleanValue()) && node.getStartOffset() < endOffset && node.getEndOffset() > startOffset)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }
}
