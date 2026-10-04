package com.vladsch.flexmark.ext.tables.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ast.Text;
import com.vladsch.flexmark.ast.WhiteSpace;
import com.vladsch.flexmark.ext.tables.TableBlock;
import com.vladsch.flexmark.ext.tables.TableBody;
import com.vladsch.flexmark.ext.tables.TableCaption;
import com.vladsch.flexmark.ext.tables.TableCell;
import com.vladsch.flexmark.ext.tables.TableHead;
import com.vladsch.flexmark.ext.tables.TableRow;
import com.vladsch.flexmark.ext.tables.TableSeparator;
import com.vladsch.flexmark.parser.InlineParser;
import com.vladsch.flexmark.parser.block.CharacterNodeFactory;
import com.vladsch.flexmark.parser.block.ParagraphPreProcessor;
import com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory;
import com.vladsch.flexmark.parser.block.ParserState;
import com.vladsch.flexmark.parser.core.ReferencePreProcessorFactory;
import com.vladsch.flexmark.util.ast.DoNotDecorate;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.NodeIterator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.format.TableFormatOptions;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TableParagraphPreProcessor implements ParagraphPreProcessor {
    private static HashMap<Character, CharacterNodeFactory> pipeIntelliJNodeMap;
    private static HashMap<Character, CharacterNodeFactory> pipeNodeMap;
    Pattern TABLE_HEADER_SEPARATOR;
    private final TableParserOptions options;
    private static BitSet pipeCharacters = new BitSet();
    private static BitSet separatorCharacters = new BitSet();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TableSeparatorRow extends TableRow implements DoNotDecorate {
        public TableSeparatorRow() {
        }

        public TableSeparatorRow(BasedSequence basedSequence) {
            super(basedSequence);
        }
    }

    static {
        pipeCharacters.set(124);
        separatorCharacters.set(124);
        separatorCharacters.set(58);
        separatorCharacters.set(45);
        HashMap<Character, CharacterNodeFactory> map = new HashMap<>();
        pipeNodeMap = map;
        map.put('|', new CharacterNodeFactory() { // from class: com.vladsch.flexmark.ext.tables.internal.TableParagraphPreProcessor.1
            @Override // com.vladsch.flexmark.parser.block.CharacterNodeFactory
            public boolean skipNext(char c) {
                return c == ' ' || c == '\t';
            }

            @Override // com.vladsch.flexmark.parser.block.CharacterNodeFactory
            public boolean skipPrev(char c) {
                return c == ' ' || c == '\t';
            }

            @Override // com.vladsch.flexmark.parser.block.CharacterNodeFactory
            public boolean wantSkippedWhitespace() {
                return true;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public Node get() {
                return new TableColumnSeparator();
            }
        });
        HashMap<Character, CharacterNodeFactory> map2 = new HashMap<>();
        pipeIntelliJNodeMap = map2;
        map2.put('|', new CharacterNodeFactory() { // from class: com.vladsch.flexmark.ext.tables.internal.TableParagraphPreProcessor.2
            @Override // com.vladsch.flexmark.parser.block.CharacterNodeFactory
            public boolean skipNext(char c) {
                return c == ' ' || c == '\t';
            }

            @Override // com.vladsch.flexmark.parser.block.CharacterNodeFactory
            public boolean skipPrev(char c) {
                return c == ' ' || c == '\t';
            }

            @Override // com.vladsch.flexmark.parser.block.CharacterNodeFactory
            public boolean wantSkippedWhitespace() {
                return true;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.function.Supplier
            public Node get() {
                return new TableColumnSeparator();
            }
        });
    }

    public /* synthetic */ TableParagraphPreProcessor(MutableDataHolder mutableDataHolder) {
        this((DataHolder) mutableDataHolder);
    }

    public static ParagraphPreProcessorFactory Factory() {
        return new ParagraphPreProcessorFactory() { // from class: com.vladsch.flexmark.ext.tables.internal.TableParagraphPreProcessor.3
            @Override // com.vladsch.flexmark.util.dependency.Dependent
            public boolean affectsGlobalScope() {
                return false;
            }

            @Override // com.vladsch.flexmark.util.dependency.Dependent
            @Nullable
            public Set<Class<?>> getAfterDependents() {
                HashSet hashSet = new HashSet();
                hashSet.add(ReferencePreProcessorFactory.class);
                return hashSet;
            }

            @Override // com.vladsch.flexmark.util.dependency.Dependent
            @Nullable
            public Set<Class<?>> getBeforeDependents() {
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.vladsch.flexmark.parser.block.ParagraphPreProcessorFactory, java.util.function.Function
            public ParagraphPreProcessor apply(ParserState parserState) {
                return new TableParagraphPreProcessor(parserState.getProperties());
            }
        };
    }

    private static TableCell.Alignment getAlignment(boolean z, boolean z2) {
        if (z && z2) {
            return TableCell.Alignment.CENTER;
        }
        if (z) {
            return TableCell.Alignment.LEFT;
        }
        if (z2) {
            return TableCell.Alignment.RIGHT;
        }
        return null;
    }

    public static Pattern getTableHeaderSeparator(int i, String str) {
        int i2 = i >= 1 ? i : 1;
        int i4 = i >= 2 ? i - 1 : 1;
        int i5 = i >= 3 ? i - 2 : 1;
        Locale locale = Locale.US;
        String strM1625o = AbstractC2322a.m1625o(AbstractC0622a.m1173s(i2, i4, "(?:\\s*-{", ",}\\s*|\\s*:-{", ",}\\s*|\\s*-{"), i4, i5, ",}:\\s*|\\s*:-{", ",}:\\s*)");
        boolean zIsEmpty = str.isEmpty();
        String str2 = zIsEmpty ? "" : TableFormatOptions.INTELLIJ_DUMMY_IDENTIFIER;
        return Pattern.compile(AbstractC0541b.m776r(AbstractC0000a.m16m("\\|", strM1625o, "\\|?\\s*|", strM1625o, "\\|\\s*|\\|?(?:"), strM1625o, "\\|)+", strM1625o, "\\|?\\s*").replace("\\s", zIsEmpty ? "\\s" : AbstractC0541b.m773o("(?:\\s", str2, "?)")).replace("\\|", zIsEmpty ? "\\|" : AbstractC0541b.m775q("(?:", str2, "?\\|", str2, "?)")).replace(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, zIsEmpty ? CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR : AbstractC0541b.m773o("(?:-", str2, "?)")));
    }

    private List<TableCell.Alignment> parseAlignment(BasedSequence basedSequence) {
        List<BasedSequence> listSplit = split(basedSequence, false, false);
        ArrayList arrayList = new ArrayList();
        Iterator<BasedSequence> it = listSplit.iterator();
        while (it.hasNext()) {
            BasedSequence basedSequenceTrim = it.next().trim();
            arrayList.add(getAlignment(basedSequenceTrim.startsWith(":"), basedSequenceTrim.endsWith(":")));
        }
        return arrayList;
    }

    private static List<BasedSequence> split(BasedSequence basedSequence, boolean z, boolean z2) {
        BasedSequence basedSequenceTrim = basedSequence.trim();
        int length = basedSequenceTrim.length();
        ArrayList arrayList = new ArrayList();
        if (basedSequenceTrim.startsWith("|")) {
            if (z2) {
                arrayList.add(basedSequenceTrim.subSequence(0, 1));
            }
            basedSequenceTrim = basedSequenceTrim.subSequence(1, length);
            length--;
        }
        int i = 0;
        boolean z3 = false;
        int i2 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = basedSequenceTrim.charAt(i4);
            if (z3) {
                i++;
                z3 = false;
            } else if (cCharAt == '\\') {
                i++;
                z3 = true;
            } else if (cCharAt != '|') {
                i++;
            } else {
                if (!z || i2 < i4) {
                    arrayList.add(basedSequenceTrim.subSequence(i2, i4));
                }
                if (z2) {
                    arrayList.add(basedSequenceTrim.subSequence(i4, i4 + 1));
                }
                i2 = i4 + 1;
                i = 0;
            }
        }
        if (i > 0) {
            arrayList.add(basedSequenceTrim.subSequence(i2, length));
        }
        return arrayList;
    }

    public List<Node> cleanUpInlinedSeparators(InlineParser inlineParser, TableRow tableRow, List<Node> list) {
        ArrayList<Node> arrayList = null;
        ArrayList arrayList2 = null;
        for (Node node : list) {
            if (node.getParent() != null && node.getParent() != tableRow) {
                Node previous = node.getPrevious() instanceof WhiteSpace ? node.getPrevious() : node;
                Node next = node.getNext() instanceof WhiteSpace ? node.getNext() : node;
                Text text = new Text(node.baseSubSequence(previous.getStartOffset(), next.getEndOffset()));
                node.insertBefore(text);
                node.unlink();
                previous.unlink();
                next.unlink();
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    arrayList = new ArrayList();
                }
                arrayList2.add(node);
                arrayList.add(text.getParent());
            }
        }
        if (arrayList == null) {
            return list;
        }
        for (Node node2 : arrayList) {
            inlineParser.mergeTextNodes(node2.getFirstChild(), node2.getLastChild());
        }
        if (arrayList2.size() == list.size()) {
            return null;
        }
        ArrayList arrayList3 = new ArrayList(list);
        arrayList3.removeAll(arrayList2);
        return arrayList3;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    @Override // com.vladsch.flexmark.parser.block.ParagraphPreProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int preProcessBlock(Paragraph paragraph, ParserState parserState) {
        BasedSequence basedSequenceTrim;
        int i;
        Iterator it;
        NodeIterator nodeIterator;
        int i2;
        BasedSequence basedSequenceBaseSubSequence;
        int i4;
        List<Node> custom;
        int i5;
        InlineParser inlineParser = parserState.getInlineParser();
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        int lineIndent = paragraph.getLineIndent(0);
        BitSet bitSet = separatorCharacters;
        Map<Character, CharacterNodeFactory> map = pipeNodeMap;
        Iterator<BasedSequence> it2 = paragraph.getContentLines().iterator();
        int i7 = -1;
        int i8 = -1;
        BasedSequence basedSequence = null;
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            BasedSequence next = it2.next();
            int size = arrayList.size();
            if (i8 == i7 && size > this.options.maxHeaderRows) {
                return 0;
            }
            if (next.indexOf('|') >= 0) {
                BasedSequence basedSequenceSubSequence = next.subSequence(paragraph.getLineIndent(size));
                if (i8 == i7 && size >= this.options.minHeaderRows && this.TABLE_HEADER_SEPARATOR.matcher(basedSequenceSubSequence).matches()) {
                    if (next.charAt(0) == ' ' || next.charAt(0) == '\t') {
                        if (next.charAt(0) != '|') {
                            basedSequence = basedSequenceSubSequence;
                            i8 = size;
                        } else if (next.charAt(0) == ' ' || next.charAt(0) == '\t') {
                            paragraph.setHasTableSeparator(true);
                        }
                    }
                }
                arrayList.add(basedSequenceSubSequence);
                i7 = -1;
            } else {
                if (i8 == i7) {
                    return 0;
                }
                if (this.options.withCaption) {
                    basedSequenceTrim = next.trim();
                    if (!basedSequenceTrim.startsWith("[") || !basedSequenceTrim.endsWith("]")) {
                        basedSequenceTrim = null;
                    }
                }
            }
        }
        basedSequenceTrim = null;
        i7 = -1;
        if (i8 == i7) {
            return 0;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                i = i6;
                break;
            }
            BasedSequence basedSequence2 = (BasedSequence) it3.next();
            int size2 = arrayList2.size();
            if (paragraph.getLineIndent(size2) <= lineIndent) {
                basedSequenceBaseSubSequence = basedSequence2.trimEOL();
                i = i6;
            } else {
                i = i6;
                basedSequenceBaseSubSequence = basedSequence2.baseSubSequence(basedSequence2.getStartOffset() - (paragraph.getLineIndent(size2) - lineIndent), basedSequence2.getEndOffset() - basedSequence2.eolEndLength());
            }
            int i9 = size2 == i8 ? 1 : i;
            TableRow tableRow = new TableRow(basedSequenceBaseSubSequence);
            if (i9 != 0) {
                Node tableSeparatorRow = new TableSeparatorRow(basedSequenceBaseSubSequence);
                custom = inlineParser.parseCustom(basedSequenceBaseSubSequence, tableSeparatorRow, bitSet, map);
                tableRow.takeChildren(tableSeparatorRow);
                i4 = lineIndent;
                i5 = i;
            } else {
                i4 = lineIndent;
                custom = inlineParser.parseCustom(basedSequenceBaseSubSequence, tableRow, pipeCharacters, pipeNodeMap);
                i5 = size2 < i8 ? size2 + 1 : size2 - i8;
                if (custom != null) {
                    custom = cleanUpInlinedSeparators(inlineParser, tableRow, custom);
                }
            }
            if (custom != null) {
                tableRow.setRowNumber(i5);
                arrayList2.add(tableRow);
                lineIndent = i4;
                i6 = i;
            } else if (size2 <= i8) {
                return i;
            }
        }
        int i10 = i;
        TableBlock tableBlock = new TableBlock((List<BasedSequence>) arrayList.subList(i10, arrayList2.size()));
        Node tableHead = new TableHead(((BasedSequence) arrayList.get(i10)).subSequence(i10, i10));
        tableBlock.appendChild(tableHead);
        List<TableCell.Alignment> alignment = parseAlignment(basedSequence);
        int size3 = alignment.size();
        Iterator it4 = arrayList2.iterator();
        int i11 = 0;
        while (it4.hasNext()) {
            TableRow tableRow2 = (TableRow) it4.next();
            if (i11 == i8) {
                tableHead.setCharsFromContent();
                tableHead = new TableSeparator();
                tableBlock.appendChild(tableHead);
            } else if (i11 == i8 + 1) {
                tableHead.setCharsFromContent();
                tableHead = new TableBody();
                tableBlock.appendChild(tableHead);
            }
            NodeIterator nodeIterator2 = new NodeIterator(tableRow2.getFirstChild());
            TableRow tableRow3 = new TableRow(tableRow2.getChars());
            tableRow3.setRowNumber(tableRow2.getRowNumber());
            int i12 = 0;
            boolean z = true;
            int i13 = 0;
            while (true) {
                if (!nodeIterator2.hasNext()) {
                    it = it4;
                    break;
                }
                it = it4;
                if (i12 >= size3) {
                    TableParserOptions tableParserOptions = this.options;
                    nodeIterator = nodeIterator2;
                    if (tableParserOptions.discardExtraColumns) {
                        if (tableParserOptions.headerSeparatorColumnMatch && i11 < i8) {
                            return 0;
                        }
                    }
                } else {
                    nodeIterator = nodeIterator2;
                }
                TableCell tableCell = new TableCell();
                if (z && (nodeIterator.peek() instanceof TableColumnSeparator)) {
                    Node next2 = nodeIterator.next();
                    tableCell.setOpeningMarker(next2.getChars());
                    next2.unlink();
                    z = false;
                }
                int i14 = i12 + i13;
                TableCell.Alignment alignment2 = i14 < size3 ? alignment.get(i14) : null;
                boolean z2 = z;
                tableCell.setHeader(i11 < i8);
                tableCell.setAlignment(alignment2);
                while (nodeIterator.hasNext() && !(nodeIterator.peek() instanceof TableColumnSeparator)) {
                    tableCell.appendChild(nodeIterator.next());
                }
                int i15 = 1;
                BasedSequence basedSequenceSpliceAtEnd = null;
                while (true) {
                    if (!nodeIterator.hasNext()) {
                        i2 = i13;
                        break;
                    }
                    i2 = i13;
                    if (!(nodeIterator.peek() instanceof TableColumnSeparator)) {
                        break;
                    }
                    if (basedSequenceSpliceAtEnd == null) {
                        basedSequenceSpliceAtEnd = nodeIterator.next().getChars();
                        if (!this.options.columnSpans) {
                            break;
                        }
                        i13 = i2;
                    } else {
                        BasedSequence chars = nodeIterator.peek().getChars();
                        if (!basedSequenceSpliceAtEnd.isContinuedBy(chars)) {
                            break;
                        }
                        basedSequenceSpliceAtEnd = basedSequenceSpliceAtEnd.spliceAtEnd(chars);
                        nodeIterator.next().unlink();
                        i15++;
                        i13 = i2;
                    }
                }
                i13 = (i15 - 1) + i2;
                if (basedSequenceSpliceAtEnd != null) {
                    tableCell.setClosingMarker(basedSequenceSpliceAtEnd);
                }
                tableCell.setChars(tableCell.getChildChars());
                if (this.options.trimCellWhitespace) {
                    tableCell.trimWhiteSpace();
                } else {
                    tableCell.mergeWhiteSpace();
                }
                tableCell.setText(tableCell.getChildChars());
                tableCell.setCharsFromContent();
                tableCell.setSpan(i15);
                tableRow3.appendChild(tableCell);
                i12++;
                it4 = it;
                nodeIterator2 = nodeIterator;
                z = z2;
            }
            if (this.options.headerSeparatorColumnMatch && i11 < i8 && i12 < size3) {
                return 0;
            }
            while (this.options.appendMissingColumns && i12 < size3) {
                TableCell tableCell2 = new TableCell();
                tableCell2.setHeader(i11 < i8);
                tableCell2.setAlignment(alignment.get(i12));
                tableRow3.appendChild(tableCell2);
                i12++;
            }
            tableRow3.setCharsFromContent();
            tableHead.appendChild(tableRow3);
            i11++;
            it4 = it;
        }
        tableHead.setCharsFromContent();
        if (tableHead instanceof TableSeparator) {
            tableBlock.appendChild(new TableBody(tableHead.getChars().subSequence(tableHead.getChars().length())));
        }
        if (basedSequenceTrim != null) {
            TableCaption tableCaption = new TableCaption(basedSequenceTrim.subSequence(0, 1), basedSequenceTrim.subSequence(1, basedSequenceTrim.length() - 1), basedSequenceTrim.subSequence(basedSequenceTrim.length() - 1));
            inlineParser.parse(tableCaption.getText(), tableCaption);
            tableCaption.setCharsFromContent();
            tableBlock.appendChild(tableCaption);
        }
        tableBlock.setCharsFromContent();
        paragraph.insertBefore(tableBlock);
        parserState.blockAdded(tableBlock);
        return tableBlock.getChars().length();
    }

    private TableParagraphPreProcessor(DataHolder dataHolder) {
        TableParserOptions tableParserOptions = new TableParserOptions(dataHolder);
        this.options = tableParserOptions;
        this.TABLE_HEADER_SEPARATOR = getTableHeaderSeparator(tableParserOptions.minSeparatorDashes, "");
    }
}
