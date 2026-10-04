package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.util.ClassifyingBlockTracker;
import com.vladsch.flexmark.ast.util.Parsing;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.InlineParserFactory;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.parser.block.BlockContinue;
import com.vladsch.flexmark.parser.block.BlockParser;
import com.vladsch.flexmark.parser.block.BlockParserFactory;
import com.vladsch.flexmark.parser.block.BlockPreProcessor;
import com.vladsch.flexmark.parser.block.BlockPreProcessorFactory;
import com.vladsch.flexmark.parser.block.BlockStart;
import com.vladsch.flexmark.parser.block.CustomBlockParserFactory;
import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
import com.vladsch.flexmark.parser.block.ParserPhase;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.BlockQuoteParser;
import com.vladsch.flexmark.parser.core.DocumentBlockParser;
import com.vladsch.flexmark.parser.core.FencedCodeBlockParser;
import com.vladsch.flexmark.parser.core.HeadingParser;
import com.vladsch.flexmark.parser.core.HtmlBlockParser;
import com.vladsch.flexmark.parser.core.IndentedCodeBlockParser;
import com.vladsch.flexmark.parser.core.ListBlockParser;
import com.vladsch.flexmark.parser.core.ParagraphParser;
import com.vladsch.flexmark.parser.core.ReferencePreProcessorFactory;
import com.vladsch.flexmark.parser.core.ThematicBreakParser;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.BlankLineContainer;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Document;
import com.vladsch.flexmark.util.ast.KeepTrailingBlankLineContainer;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.collection.ItemFactoryMap;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIndexedIterator;
import com.vladsch.flexmark.util.collection.iteration.ReversibleIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.dependency.DependencyResolver;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class DocumentParser implements ParserState {
    private static final HashMap<CustomBlockParserFactory, DataKey<Boolean>> CORE_FACTORIES_DATA_KEYS;
    private static final HashMap<DataKey<Boolean>, ParagraphPreProcessorFactory> CORE_PARAGRAPH_PRE_PROCESSORS;
    public static final InlineParserFactory INLINE_PARSER_FACTORY = new C11830a();
    private boolean blank;
    private final boolean blankLinesInAst;
    private final List<BlockParserFactory> blockParserFactories;
    private final List<List<BlockPreProcessorFactory>> blockPreProcessorDependencies;
    private boolean columnIsInTab;
    private ParserPhase currentPhase;
    private final DocumentBlockParser documentBlockParser;
    private final InlineParser inlineParser;
    private boolean isBlankLine;
    private BasedSequence line;
    private BasedSequence lineWithEOL;
    private final Parsing myParsing;
    private final DataHolder options;
    private final List<List<ParagraphPreProcessorFactory>> paragraphPreProcessorDependencies;
    private final boolean trackDocumentLines;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int lineEOLIndex = 0;
    private int lineEndIndex = 0;
    private int index = 0;
    private int column = 0;
    private int nextNonSpace = 0;
    private int nextNonSpaceColumn = 0;
    private int indent = 0;
    private final List<BasedSequence> lineSegments = new ArrayList();
    private final List<BlockParser> activeBlockParsers = new ArrayList();
    private final ClassifyingBlockTracker blockTracker = new ClassifyingBlockTracker();
    private final Map<Node, Boolean> lastLineBlank = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ParagraphPreProcessorCache extends ItemFactoryMap<ParagraphPreProcessor, ParserState> {
        public ParagraphPreProcessorCache(ParserState parserState) {
            super(parserState);
        }
    }

    static {
        HashMap<CustomBlockParserFactory, DataKey<Boolean>> map = new HashMap<>();
        CORE_FACTORIES_DATA_KEYS = map;
        map.put(new BlockQuoteParser.Factory(), Parser.BLOCK_QUOTE_PARSER);
        map.put(new HeadingParser.Factory(), Parser.HEADING_PARSER);
        map.put(new FencedCodeBlockParser.Factory(), Parser.FENCED_CODE_BLOCK_PARSER);
        map.put(new HtmlBlockParser.Factory(), Parser.HTML_BLOCK_PARSER);
        map.put(new ThematicBreakParser.Factory(), Parser.THEMATIC_BREAK_PARSER);
        map.put(new ListBlockParser.Factory(), Parser.LIST_BLOCK_PARSER);
        map.put(new IndentedCodeBlockParser.Factory(), Parser.INDENTED_CODE_BLOCK_PARSER);
        HashMap<DataKey<Boolean>, ParagraphPreProcessorFactory> map2 = new HashMap<>();
        CORE_PARAGRAPH_PRE_PROCESSORS = map2;
        map2.put(Parser.REFERENCE_PARAGRAPH_PRE_PROCESSOR, new ReferencePreProcessorFactory());
    }

    public DocumentParser(DataHolder dataHolder, List<CustomBlockParserFactory> list, List<List<ParagraphPreProcessorFactory>> list2, List<List<BlockPreProcessorFactory>> list3, InlineParser inlineParser) {
        this.options = dataHolder;
        this.myParsing = inlineParser.getParsing();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<CustomBlockParserFactory> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().apply(dataHolder));
        }
        this.blockParserFactories = arrayList;
        this.paragraphPreProcessorDependencies = list2;
        this.blockPreProcessorDependencies = list3;
        this.inlineParser = inlineParser;
        DocumentBlockParser documentBlockParser = new DocumentBlockParser();
        this.documentBlockParser = documentBlockParser;
        activateBlockParser(documentBlockParser);
        this.currentPhase = ParserPhase.STARTING;
        this.blankLinesInAst = Parser.BLANK_LINES_IN_AST.get(dataHolder).booleanValue();
        this.trackDocumentLines = Parser.TRACK_DOCUMENT_LINES.get(dataHolder).booleanValue();
    }

    private void activateBlockParser(BlockParser blockParser) {
        this.activeBlockParsers.add(blockParser);
        if (this.blockTracker.containsKey(blockParser)) {
            return;
        }
        blockParserAdded(blockParser);
    }

    private <T extends BlockParser> T addChild(T t) {
        while (!getActiveBlockParser().canContain(this, t, t.getBlock())) {
            finalize(getActiveBlockParser());
        }
        getActiveBlockParser().getBlock().appendChild(t.getBlock());
        activateBlockParser(t);
        return t;
    }

    private void addLine() {
        BasedSequence basedSequenceSubSequence = this.lineWithEOL.subSequence(this.index);
        if (this.columnIsInTab) {
            BasedSequence basedSequenceSubSequence2 = basedSequenceSubSequence.subSequence(1);
            int iColumnsToNextTabStop = Parsing.columnsToNextTabStop(this.column);
            StringBuilder sb = new StringBuilder(basedSequenceSubSequence2.length() + iColumnsToNextTabStop);
            for (int i = 0; i < iColumnsToNextTabStop; i++) {
                sb.append(' ');
            }
            basedSequenceSubSequence = PrefixedSubSequence.prefixOf(sb.toString(), basedSequenceSubSequence2);
        }
        getActiveBlockParser().addLine(this, basedSequenceSubSequence);
    }

    private void advance() {
        if (this.line.charAt(this.index) != '\t') {
            this.index++;
            this.column++;
        } else {
            this.index++;
            int i = this.column;
            this.column = Parsing.columnsToNextTabStop(i) + i;
        }
    }

    private void breakOutOfLists(List<BlockParser> list) {
        int i = -1;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).breakOutOnDoubleBlankLine()) {
                i = size;
            }
        }
        if (i != -1) {
            finalizeBlocks(list.subList(i, list.size()));
        }
    }

    public static List<CustomBlockParserFactory> calculateBlockParserFactories(DataHolder dataHolder, List<CustomBlockParserFactory> list) {
        ArrayList arrayList = new ArrayList(list);
        for (Map.Entry<CustomBlockParserFactory, DataKey<Boolean>> entry : CORE_FACTORIES_DATA_KEYS.entrySet()) {
            if (entry.getValue().get(dataHolder).booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        return DependencyResolver.resolveFlatDependencies(arrayList, null, null);
    }

    public static List<List<BlockPreProcessorFactory>> calculateBlockPreProcessors(DataHolder dataHolder, List<BlockPreProcessorFactory> list) {
        return DependencyResolver.resolveDependencies(list, null, null);
    }

    public static List<List<ParagraphPreProcessorFactory>> calculateParagraphPreProcessors(DataHolder dataHolder, List<ParagraphPreProcessorFactory> list, InlineParserFactory inlineParserFactory) {
        ArrayList arrayList = new ArrayList(list);
        if (inlineParserFactory == INLINE_PARSER_FACTORY) {
            for (DataKey<Boolean> dataKey : CORE_PARAGRAPH_PRE_PROCESSORS.keySet()) {
                if (dataKey.get(dataHolder).booleanValue()) {
                    arrayList.add(CORE_PARAGRAPH_PRE_PROCESSORS.get(dataKey));
                }
            }
        }
        return DependencyResolver.resolveDependencies(arrayList, null, null);
    }

    private void deactivateBlockParser() {
        this.activeBlockParsers.remove(r0.size() - 1);
    }

    private void finalize(BlockParser blockParser) {
        if (getActiveBlockParser() == blockParser) {
            deactivateBlockParser();
        }
        Block block = blockParser.getBlock();
        if (block.getParent() != null) {
            Node lastChild = block.getLastChild();
            if ((lastChild instanceof BlankLine) && ((BlankLine) lastChild).getClaimedBlankLine() != block) {
                block.insertChainAfter(lastChild.getFirstInChain());
                block.setCharsFromContentOnly();
            }
        }
        blockParser.closeBlock(this);
        blockParser.finalizeClosedBlock();
        while (true) {
            Node next = block.getNext();
            if (!(next instanceof BlankLine) || next.getEndOffset() > block.getEndOffset()) {
                return;
            } else {
                next.unlink();
            }
        }
    }

    private Document finalizeAndProcess() {
        finalizeBlocks(this.activeBlockParsers);
        this.currentPhase = ParserPhase.PRE_PROCESS_PARAGRAPHS;
        preProcessParagraphs();
        this.currentPhase = ParserPhase.PRE_PROCESS_BLOCKS;
        preProcessBlocks();
        this.currentPhase = ParserPhase.PARSE_INLINES;
        processInlines();
        this.currentPhase = ParserPhase.DONE;
        Document block = this.documentBlockParser.getBlock();
        this.inlineParser.finalizeDocument(block);
        return block;
    }

    private boolean finalizeBlocks(List<BlockParser> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            finalize(list.get(size));
        }
        return true;
    }

    private BlockStartImpl findBlockStart(BlockParser blockParser) {
        MatchedBlockParserImpl matchedBlockParserImpl = new MatchedBlockParserImpl(blockParser);
        for (BlockParserFactory blockParserFactory : this.blockParserFactories) {
            if (blockParser.canInterruptBy(blockParserFactory)) {
                BlockStart blockStartTryStart = blockParserFactory.tryStart(this, matchedBlockParserImpl);
                if (blockStartTryStart instanceof BlockStartImpl) {
                    return (BlockStartImpl) blockStartTryStart;
                }
            }
        }
        return null;
    }

    private void findNextNonSpace() {
        int i = this.index;
        int i2 = this.column;
        this.blank = true;
        while (true) {
            if (i >= this.line.length()) {
                break;
            }
            char cCharAt = this.line.charAt(i);
            if (cCharAt == '\t') {
                i++;
                i2 += 4 - (i2 % 4);
            } else if (cCharAt != ' ') {
                this.blank = false;
                break;
            } else {
                i++;
                i2++;
            }
        }
        this.nextNonSpace = i;
        this.nextNonSpaceColumn = i2;
        this.indent = i2 - this.column;
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x01e1, code lost:
    
        setNewIndex(r12.nextNonSpace);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void incorporateLine(BasedSequence basedSequence) {
        BlankLine blankLine;
        this.line = basedSequence;
        this.index = 0;
        this.column = 0;
        this.columnIsInTab = false;
        if (this.trackDocumentLines) {
            this.lineSegments.add(this.lineWithEOL);
        }
        findNextNonSpace();
        BlockParser blockParser = null;
        if (this.blank && this.blankLinesInAst) {
            blankLine = new BlankLine(this.lineWithEOL);
            this.documentBlockParser.getBlock().appendChild(blankLine);
        } else {
            blankLine = null;
        }
        List<BlockParser> list = this.activeBlockParsers;
        int i = 1;
        for (BlockParser blockParser2 : list.subList(1, list.size())) {
            boolean z = this.blank;
            findNextNonSpace();
            if (this.blank && this.blankLinesInAst) {
                if (blankLine == null) {
                    blankLine = new BlankLine(this.lineWithEOL);
                    this.documentBlockParser.getBlock().appendChild(blankLine);
                }
                if (!z && (blockParser2.getBlock() instanceof BlankLineContainer)) {
                    blankLine.setClaimedBlankLine(blockParser2.getBlock());
                }
            }
            this.isBlankLine = z;
            BlockContinue blockContinueTryContinue = blockParser2.tryContinue(this);
            if (!(blockContinueTryContinue instanceof BlockContinueImpl)) {
                break;
            }
            BlockContinueImpl blockContinueImpl = (BlockContinueImpl) blockContinueTryContinue;
            if (blockContinueImpl.isFinalize()) {
                finalize(blockParser2);
                return;
            }
            if (blockContinueImpl.getNewIndex() != -1) {
                setNewIndex(blockContinueImpl.getNewIndex());
                if (!this.blank && (blockParser2.getBlock() instanceof BlankLineContainer)) {
                    findNextNonSpace();
                    if (this.blank) {
                        blankLine = new BlankLine(this.lineWithEOL, blockParser2.getBlock());
                        blockParser2.getBlock().appendChild(blankLine);
                    }
                }
            } else if (blockContinueImpl.getNewColumn() != -1) {
                setNewColumn(blockContinueImpl.getNewColumn());
                if (!this.blank && (blockParser2.getBlock() instanceof BlankLineContainer)) {
                    findNextNonSpace();
                    if (this.blank) {
                        blankLine = new BlankLine(this.lineWithEOL, blockParser2.getBlock());
                        blockParser2.getBlock().appendChild(blankLine);
                    }
                }
            }
            i++;
            if (blankLine != null && (this.blankLinesInAst || blankLine.getClaimedBlankLine() == blockParser2.getBlock())) {
                if (blockParser2.getBlock() instanceof BlankLineContainer) {
                    blockParser2.getBlock().appendChild(blankLine);
                }
            }
        }
        List<BlockParser> list2 = this.activeBlockParsers;
        ArrayList arrayList = new ArrayList(list2.subList(i, list2.size()));
        BlockParser blockParser3 = this.activeBlockParsers.get(i - 1);
        boolean zIsEmpty = arrayList.isEmpty();
        if (this.blank && isLastLineBlank(blockParser3.getBlock())) {
            breakOutOfLists(new ArrayList<>(this.activeBlockParsers.subList(0, i)));
        }
        boolean zIsContainer = blockParser3.isInterruptible() || blockParser3.isContainer();
        BlockParser blockParserAddChild = blockParser3;
        while (true) {
            if (!zIsContainer) {
                break;
            }
            boolean z2 = this.blank;
            findNextNonSpace();
            boolean z3 = this.blank;
            if (z3 && !z2) {
                blockParser = blockParserAddChild;
            }
            if (z3 || (this.indent < this.myParsing.CODE_BLOCK_INDENT && Parsing.isLetter(this.line, this.nextNonSpace))) {
                break;
            }
            BlockStartImpl blockStartImplFindBlockStart = findBlockStart(blockParserAddChild);
            if (blockStartImplFindBlockStart != null) {
                if (!zIsEmpty) {
                    finalizeBlocks(arrayList);
                    zIsEmpty = true;
                }
                if (blockStartImplFindBlockStart.getNewIndex() != -1) {
                    setNewIndex(blockStartImplFindBlockStart.getNewIndex());
                } else if (blockStartImplFindBlockStart.getNewColumn() != -1) {
                    setNewColumn(blockStartImplFindBlockStart.getNewColumn());
                }
                if (blockStartImplFindBlockStart.isReplaceActiveBlockParser()) {
                    removeActiveBlockParser();
                }
                for (BlockParser blockParser4 : blockStartImplFindBlockStart.getBlockParsers()) {
                    blockParserAddChild = addChild(blockParser4);
                    zIsContainer = blockParser4.isContainer();
                }
            } else if (!blockParserAddChild.isRawText() || !blockParserAddChild.isInterruptible()) {
                setNewIndex(this.nextNonSpace);
            }
        }
        if (!zIsEmpty && !this.blank && getActiveBlockParser().isParagraphParser()) {
            addLine();
            return;
        }
        if (!zIsEmpty) {
            finalizeBlocks(arrayList);
        }
        propagateLastLineBlank(blockParserAddChild, blockParser3);
        if (this.blank && (blockParserAddChild.getBlock() instanceof KeepTrailingBlankLineContainer)) {
            if (blankLine != null) {
                blockParserAddChild.getBlock().appendChild(blankLine);
            } else if (blockParserAddChild.isContainer() && blockParser == blockParserAddChild) {
                blockParserAddChild.getBlock().appendChild(new BlankLine(this.lineWithEOL, blockParserAddChild.getBlock()));
            }
        }
        if (!blockParserAddChild.isContainer()) {
            addLine();
        } else {
            if (this.blank) {
                return;
            }
            addChild(new ParagraphParser());
            addLine();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void preProcessBlocks() {
        HashSet hashSet = new HashSet();
        Iterator<List<BlockPreProcessorFactory>> it = this.blockPreProcessorDependencies.iterator();
        while (it.hasNext()) {
            Iterator<BlockPreProcessorFactory> it2 = it.next().iterator();
            while (it2.hasNext()) {
                hashSet.addAll(it2.next().getBlockTypes());
            }
        }
        if (this.blockTracker.getNodeClassifier().categoriesBitSet(hashSet).isEmpty()) {
            return;
        }
        Iterator<List<BlockPreProcessorFactory>> it3 = this.blockPreProcessorDependencies.iterator();
        while (it3.hasNext()) {
            for (BlockPreProcessorFactory blockPreProcessorFactory : it3.next()) {
                Iterable categoryItems = this.blockTracker.getNodeClassifier().getCategoryItems(Block.class, blockPreProcessorFactory.getBlockTypes());
                BlockPreProcessor blockPreProcessorApply = blockPreProcessorFactory.apply((ParserState) this);
                ReversibleIterator it4 = categoryItems.iterator();
                while (it4.hasNext()) {
                    blockPreProcessorApply.preProcess(this, (Block) it4.next());
                }
            }
        }
    }

    private void preProcessParagraph(Paragraph paragraph, List<ParagraphPreProcessorFactory> list, ParagraphPreProcessorCache paragraphPreProcessorCache) {
        do {
            Iterator<ParagraphPreProcessorFactory> it = list.iterator();
            boolean z = false;
            while (it.hasNext()) {
                int iPreProcessBlock = paragraphPreProcessorCache.getItem(it.next()).preProcessBlock(paragraph, this);
                if (iPreProcessBlock > 0) {
                    BasedSequence chars = paragraph.getChars();
                    BasedSequence basedSequenceSubSequence = chars.subSequence(chars.countLeading(CharPredicate.WHITESPACE, iPreProcessBlock, chars.length()) + iPreProcessBlock);
                    if (basedSequenceSubSequence.isBlank()) {
                        paragraph.unlink();
                        blockRemoved(paragraph);
                        return;
                    }
                    int lineCount = paragraph.getLineCount();
                    int i = 0;
                    while (i < lineCount && paragraph.getLineChars(i).getEndOffset() <= basedSequenceSubSequence.getStartOffset()) {
                        i++;
                    }
                    if (i >= lineCount) {
                        paragraph.unlink();
                        blockRemoved(paragraph);
                        return;
                    }
                    if (paragraph.getLineChars(i).getEndOffset() == basedSequenceSubSequence.getStartOffset()) {
                        paragraph.setContent(paragraph, i, lineCount);
                    } else {
                        int i2 = lineCount - i;
                        ArrayList arrayList = new ArrayList(i2);
                        arrayList.addAll(paragraph.getContentLines().subList(i, lineCount));
                        int startOffset = basedSequenceSubSequence.getStartOffset() - ((BasedSequence) arrayList.get(0)).getStartOffset();
                        if (startOffset > 0 && startOffset < ((BasedSequence) arrayList.get(0)).length()) {
                            arrayList.set(0, ((BasedSequence) arrayList.get(0)).subSequence(startOffset));
                        }
                        int[] iArr = new int[i2];
                        System.arraycopy(paragraph.getLineIndents(), i, iArr, 0, i2);
                        paragraph.setContentLines(arrayList);
                        paragraph.setLineIndents(iArr);
                        paragraph.setChars(basedSequenceSubSequence);
                    }
                    z = true;
                }
            }
            if (!z) {
                return;
            }
        } while (list.size() >= 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void preProcessParagraphs() {
        if (this.blockTracker.getNodeClassifier().containsCategory(Paragraph.class)) {
            ParagraphPreProcessorCache paragraphPreProcessorCache = new ParagraphPreProcessorCache(this);
            for (List<ParagraphPreProcessorFactory> list : this.paragraphPreProcessorDependencies) {
                ReversibleIterator it = this.blockTracker.getNodeClassifier().getCategoryItems(Paragraph.class, Paragraph.class).iterator();
                while (it.hasNext()) {
                    preProcessParagraph((Paragraph) it.next(), list, paragraphPreProcessorCache);
                }
            }
        }
    }

    private void processInlines() {
        ReversibleIndexedIterator<BlockParser> it = this.blockTracker.allBlockParsers().iterator();
        while (it.hasNext()) {
            it.next().parseInlines(this.inlineParser);
        }
    }

    private void propagateLastLineBlank(BlockParser blockParser, BlockParser blockParser2) {
        Node lastChild;
        if (this.blank && (lastChild = blockParser.getBlock().getLastChild()) != null) {
            setLastLineBlank(lastChild, true);
        }
        boolean z = this.blank && blockParser.isPropagatingLastBlankLine(blockParser2);
        for (Node block = blockParser.getBlock(); block != null; block = block.getParent()) {
            setLastLineBlank(block, z);
        }
    }

    private void removeActiveBlockParser() {
        BlockParser activeBlockParser = getActiveBlockParser();
        deactivateBlockParser();
        blockParserRemoved(activeBlockParser);
        activeBlockParser.getBlock().unlink();
    }

    private void setLastLineBlank(Node node, boolean z) {
        this.lastLineBlank.put(node, Boolean.valueOf(z));
    }

    private void setNewColumn(int i) {
        int i2 = this.nextNonSpaceColumn;
        if (i >= i2) {
            this.index = this.nextNonSpace;
            this.column = i2;
        }
        while (this.column < i && this.index != this.line.length()) {
            advance();
        }
        if (this.column <= i) {
            this.columnIsInTab = false;
            return;
        }
        this.index--;
        this.column = i;
        this.columnIsInTab = true;
    }

    private void setNewIndex(int i) {
        int i2 = this.nextNonSpace;
        if (i >= i2) {
            this.index = i2;
            this.column = this.nextNonSpaceColumn;
        }
        while (true) {
            int i4 = this.index;
            if (i4 >= i || i4 == this.line.length()) {
                break;
            } else {
                advance();
            }
        }
        this.columnIsInTab = false;
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockAdded(@NotNull Block block) {
        this.blockTracker.blockAdded(block);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockAddedWithChildren(@NotNull Block block) {
        this.blockTracker.blockAddedWithChildren(block);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockAddedWithDescendants(@NotNull Block block) {
        this.blockTracker.blockAddedWithDescendants(block);
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParserTracker
    public void blockParserAdded(BlockParser blockParser) {
        this.blockTracker.blockParserAdded(blockParser);
    }

    @Override // com.vladsch.flexmark.parser.block.BlockParserTracker
    public void blockParserRemoved(BlockParser blockParser) {
        this.blockTracker.blockParserRemoved(blockParser);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockRemoved(@NotNull Block block) {
        this.blockTracker.blockRemoved(block);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockRemovedWithChildren(@NotNull Block block) {
        this.blockTracker.blockRemovedWithChildren(block);
    }

    @Override // com.vladsch.flexmark.util.ast.BlockTracker
    public void blockRemovedWithDescendants(@NotNull Block block) {
        this.blockTracker.blockRemovedWithDescendants(block);
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public boolean endsWithBlankLine(Node node) {
        while (node != null) {
            if (isLastLineBlank(node)) {
                return true;
            }
            node = node.getLastBlankLineChild();
        }
        return false;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public BlockParser getActiveBlockParser() {
        return (BlockParser) AbstractC0000a.m10g(this.activeBlockParsers, 1);
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public List<BlockParser> getActiveBlockParsers() {
        return this.activeBlockParsers;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getColumn() {
        return this.column;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getIndent() {
        return this.indent;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getIndex() {
        return this.index;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public InlineParser getInlineParser() {
        return this.inlineParser;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public BasedSequence getLine() {
        return this.line;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getLineEndIndex() {
        return this.lineEndIndex;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getLineEolLength() {
        return this.lineEndIndex - this.lineEOLIndex;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public List<BasedSequence> getLineSegments() {
        return this.lineSegments;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getLineStart() {
        return this.lineStart;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public BasedSequence getLineWithEOL() {
        return this.lineWithEOL;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public int getNextNonSpaceIndex() {
        return this.nextNonSpace;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public ParserPhase getParserPhase() {
        return this.currentPhase;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public Parsing getParsing() {
        return this.myParsing;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public MutableDataHolder getProperties() {
        return this.documentBlockParser.getBlock();
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public boolean isBlank() {
        return this.blank;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public boolean isBlankLine() {
        return this.isBlankLine;
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public boolean isLastLineBlank(Node node) {
        Boolean bool = this.lastLineBlank.get(node);
        return bool != null && bool.booleanValue();
    }

    public Document parse(CharSequence charSequence) {
        BasedSequence basedSequenceM13437of = BasedSequence.m13437of(charSequence);
        int i = 0;
        this.lineNumber = 0;
        this.documentBlockParser.initializeDocument(this.options, basedSequenceM13437of);
        this.inlineParser.initializeDocument(this.documentBlockParser.getBlock());
        this.currentPhase = ParserPhase.PARSE_BLOCKS;
        while (true) {
            int iFindLineBreak = Parsing.findLineBreak(basedSequenceM13437of, i);
            if (iFindLineBreak == -1) {
                break;
            }
            BasedSequence basedSequenceSubSequence = basedSequenceM13437of.subSequence(i, iFindLineBreak);
            int i2 = iFindLineBreak + 1;
            if (i2 < basedSequenceM13437of.length() && basedSequenceM13437of.charAt(iFindLineBreak) == '\r' && basedSequenceM13437of.charAt(i2) == '\n') {
                i2 = iFindLineBreak + 2;
            }
            this.lineWithEOL = basedSequenceM13437of.subSequence(i, i2);
            this.lineStart = i;
            this.lineEOLIndex = iFindLineBreak;
            this.lineEndIndex = i2;
            incorporateLine(basedSequenceSubSequence);
            this.lineNumber++;
            i = i2;
        }
        if (basedSequenceM13437of.length() > 0 && (i == 0 || i < basedSequenceM13437of.length())) {
            this.lineWithEOL = basedSequenceM13437of.subSequence(i, basedSequenceM13437of.length());
            this.lineStart = i;
            int length = basedSequenceM13437of.length();
            this.lineEOLIndex = length;
            this.lineEndIndex = length;
            incorporateLine(this.lineWithEOL);
            this.lineNumber++;
        }
        return finalizeAndProcess();
    }

    @Override // com.vladsch.flexmark.parser.block.ParserState
    public BlockParser getActiveBlockParser(Block block) {
        BlockParser key = this.blockTracker.getKey(block);
        if (key == null || key.isClosed()) {
            return null;
        }
        return key;
    }

    public Document parse(Reader reader) throws IOException {
        BufferedReader bufferedReader;
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader);
        }
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[16384];
        while (true) {
            int i = bufferedReader.read(cArr);
            if (i < 0) {
                return parse(BasedSequence.m13437of(sb.toString()));
            }
            sb.append(cArr, 0, i);
        }
    }
}
