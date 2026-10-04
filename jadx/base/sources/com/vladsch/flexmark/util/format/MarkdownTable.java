package com.vladsch.flexmark.util.format;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.work.multiprocess.C4148a;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.ast.TextCollectingVisitor;
import com.vladsch.flexmark.util.collection.MaxAggregator;
import com.vladsch.flexmark.util.collection.MinAggregator;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.format.options.DiscretionaryText;
import com.vladsch.flexmark.util.format.options.TableCaptionHandling;
import com.vladsch.flexmark.util.html.CellAlignment;
import com.vladsch.flexmark.util.misc.ArrayUtils;
import com.vladsch.flexmark.util.misc.CharPredicate;
import com.vladsch.flexmark.util.misc.Pair;
import com.vladsch.flexmark.util.misc.Ref;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.LineAppendable;
import com.vladsch.flexmark.util.sequence.PrefixedSubSequence;
import com.vladsch.flexmark.util.sequence.RepeatedSequence;
import com.vladsch.flexmark.util.sequence.SequenceUtils;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p074R1.C0231c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class MarkdownTable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final NumericSuffixPredicate ALL_SUFFIXES_SORT;
    public static final NumericSuffixPredicate NO_SUFFIXES;
    private final TableSection[] ALL_BODY_ROWS;
    private final TableSection[] ALL_CONTENT_ROWS;
    private final TableSection[] ALL_HEADER_ROWS;
    private final TableSection[] ALL_SECTIONS;
    private final TableSection[] ALL_TABLE_ROWS;
    private CellAlignment[] alignments;
    public final TableSection body;
    public final TableSection caption;
    private int[] columnWidths;
    CharSequence formatTableIndentPrefix;
    public final TableSection header;
    private boolean isHeading;
    private boolean isSeparator;
    public TableFormatOptions options;
    public final TableSection separator;
    private final CharSequence tableChars;

    @NotNull
    private final ArrayList<TrackedOffset> trackedOffsets;
    public static final CharPredicate COLON_TRIM_CHARS = CharPredicate.anyOf(':');
    public static final NumericSuffixPredicate ALL_SUFFIXES_NO_SORT = new NumericSuffixPredicate() { // from class: com.vladsch.flexmark.util.format.MarkdownTable.1
        @Override // com.vladsch.flexmark.util.format.NumericSuffixPredicate
        public boolean sortSuffix(@NotNull String str) {
            return false;
        }

        @Override // java.util.function.Predicate
        public boolean test(String str) {
            return true;
        }
    };

    /* JADX INFO: renamed from: com.vladsch.flexmark.util.format.MarkdownTable$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C118532 {

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$DiscretionaryText */
        static final /* synthetic */ int[] f8371xa6c81092;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$util$format$options$TableCaptionHandling */
        static final /* synthetic */ int[] f8372xe4309ea4;
        static final /* synthetic */ int[] $SwitchMap$com$vladsch$flexmark$util$html$CellAlignment;

        static {
            int[] iArr = new int[CellAlignment.values().length];
            $SwitchMap$com$vladsch$flexmark$util$html$CellAlignment = iArr;
            try {
                iArr[CellAlignment.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$html$CellAlignment[CellAlignment.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vladsch$flexmark$util$html$CellAlignment[CellAlignment.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[TableCaptionHandling.values().length];
            f8372xe4309ea4 = iArr2;
            try {
                iArr2[TableCaptionHandling.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8372xe4309ea4[TableCaptionHandling.REMOVE_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8372xe4309ea4[TableCaptionHandling.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8372xe4309ea4[TableCaptionHandling.AS_IS.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[DiscretionaryText.values().length];
            f8371xa6c81092 = iArr3;
            try {
                iArr3[DiscretionaryText.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8371xa6c81092[DiscretionaryText.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8371xa6c81092[DiscretionaryText.AS_IS.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ColumnSpan {
        int additionalWidth = 0;
        final int columnSpan;
        final int startColumn;
        final int width;

        public ColumnSpan(int i, int i2, int i4) {
            this.startColumn = i;
            this.columnSpan = i2;
            this.width = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IndexSpanOffset {
        public final int index;
        public final int spanOffset;

        public IndexSpanOffset(int i, int i2) {
            this.index = i;
            this.spanOffset = i2;
        }

        public String toString() {
            return AbstractC0622a.m1164j(this.index, this.spanOffset, "IndexSpanOffset{index=", ", spanOffset=", "}");
        }
    }

    static {
        final int i = 1;
        final int i2 = 0;
        NO_SUFFIXES = new NumericSuffixPredicate() { // from class: com.vladsch.flexmark.util.format.e
            @Override // java.util.function.Predicate
            public final boolean test(String str) {
                String str2 = str;
                switch (i2) {
                    case 0:
                        return MarkdownTable.lambda$static$0(str2);
                    default:
                        return MarkdownTable.lambda$static$1(str2);
                }
            }
        };
        ALL_SUFFIXES_SORT = new NumericSuffixPredicate() { // from class: com.vladsch.flexmark.util.format.e
            @Override // java.util.function.Predicate
            public final boolean test(String str) {
                String str2 = str;
                switch (i) {
                    case 0:
                        return MarkdownTable.lambda$static$0(str2);
                    default:
                        return MarkdownTable.lambda$static$1(str2);
                }
            }
        };
    }

    public MarkdownTable(@NotNull CharSequence charSequence, @Nullable DataHolder dataHolder) {
        this(charSequence, new TableFormatOptions(dataHolder));
    }

    private CellAlignment adjustCellAlignment(CellAlignment cellAlignment) {
        int i = C118532.f8371xa6c81092[this.options.leftAlignMarker.ordinal()];
        if (i != 1) {
            if (i == 2 && cellAlignment == CellAlignment.LEFT) {
                return CellAlignment.NONE;
            }
        } else if (cellAlignment == null || cellAlignment == CellAlignment.NONE) {
            return CellAlignment.LEFT;
        }
        return cellAlignment;
    }

    private int aggregateTotalColumnsWithoutColumns(TableSection[] tableSectionArr, BiFunction<Integer, Integer, Integer> biFunction, int... iArr) {
        Integer[] numArr = {null};
        forAllSectionsRows(0, Integer.MAX_VALUE, tableSectionArr, new C11860f(iArr, numArr, biFunction, 1));
        Integer num = numArr[0];
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private int aggregateTotalColumnsWithoutRows(TableSection[] tableSectionArr, BiFunction<Integer, Integer, Integer> biFunction, int... iArr) {
        Integer[] numArr = {null};
        forAllSectionsRows(0, Integer.MAX_VALUE, tableSectionArr, new C11860f(iArr, numArr, biFunction, 0));
        Integer num = numArr[0];
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private void appendColumnSpan(LineAppendable lineAppendable, int i, int i2, int i4) {
        if (i4 == Integer.MAX_VALUE) {
            lineAppendable.append('|', i);
            return;
        }
        if (i4 == 0) {
            setTrackedOffsetIndex(i2 + i4, lineAppendable.offsetWithPending());
            lineAppendable.append('|', i);
        } else if (i4 >= i) {
            lineAppendable.append('|', i);
            setTrackedOffsetIndex(i2 + i4, lineAppendable.offsetWithPending());
        } else {
            lineAppendable.append('|', i4);
            setTrackedOffsetIndex(i2 + i4, lineAppendable.offsetWithPending());
            lineAppendable.append('|', i - i4);
        }
    }

    public static void appendFormattedCaption(LineAppendable lineAppendable, BasedSequence basedSequence, TableFormatOptions tableFormatOptions) {
        String str = formattedCaption(basedSequence, tableFormatOptions);
        if (str != null) {
            lineAppendable.line().append(PropertyUtils.INDEXED_DELIM).append((CharSequence) str).append(PropertyUtils.INDEXED_DELIM2).line();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void appendRows(LineAppendable lineAppendable, List<TableRow> list, boolean z, CharSequence charSequence) {
        CellAlignment cellAlignment;
        int i;
        TableCell tableCell;
        Iterator<TableRow> it = list.iterator();
        while (it.hasNext()) {
            TableRow next = it.next();
            int i2 = 0;
            Ref<Integer> ref = new Ref<>(0);
            lineAppendable.append(charSequence);
            int i4 = next.beforeOffset;
            if (i4 != Integer.MAX_VALUE) {
                setTrackedOffsetIndex(i4, lineAppendable.offsetWithPending());
            }
            int size = next.cells.size();
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i6 < size) {
                TableCell tableCell2 = next.cells.get(i6);
                if (i7 == 0) {
                    if (this.options.leadTrailPipes) {
                        lineAppendable.append('|');
                        if (this.options.spaceAroundPipes && pipeNeedsSpaceAfter(tableCell2)) {
                            lineAppendable.append(' ');
                        }
                    }
                } else if (this.options.spaceAroundPipes && pipeNeedsSpaceAfter(tableCell2)) {
                    lineAppendable.append(' ');
                }
                if (!z || (cellAlignment = tableCell2.alignment) == CellAlignment.NONE) {
                    cellAlignment = this.alignments[i5];
                }
                CellAlignment cellAlignment2 = cellAlignment;
                List<TableCell> list2 = next.cells;
                int iSpanWidth = spanWidth(i5, tableCell2.columnSpan);
                int i8 = i2;
                TableFormatOptions tableFormatOptions = this.options;
                int i9 = (iSpanWidth - tableFormatOptions.spacePad) - (tableFormatOptions.pipeWidth * tableCell2.columnSpan);
                Iterator<TableRow> it2 = it;
                int i10 = i5;
                BasedSequence basedSequenceCellText = cellText(list2, i6, true, z, i9, cellAlignment2, ref);
                if (tableCell2.trackedTextOffset != Integer.MAX_VALUE) {
                    TableCell tableCell3 = next.cells.get(i6);
                    if (tableCell3.trackedTextOffset != Integer.MAX_VALUE) {
                        int iOffsetWithPending = lineAppendable.offsetWithPending();
                        int i11 = tableCell2.text.isBlank() ? -1 : i8;
                        int i12 = tableCell2.trackedTextOffset;
                        if (i6 == 0) {
                            i = i6;
                            tableCell = null;
                        } else {
                            i = i6;
                            tableCell = next.cells.get(i - 1);
                        }
                        if (!setTrackedOffsetIndex(tableCell2.getTextStartOffset(tableCell) + i12, Utils.minLimit(tableCell3.trackedTextOffset + i11, i8) + iOffsetWithPending + tableCell3.trackedTextAdjust)) {
                            System.out.println(String.format("Offset not found: cell.trackedTextOffset: %d, adjusted trackedOffset: %d in offsets: %s", Integer.valueOf(tableCell2.trackedTextOffset), Integer.valueOf(tableCell2.getTextStartOffset(i != 0 ? next.cells.get(i - 1) : null) + tableCell2.trackedTextOffset), this.trackedOffsets));
                        }
                    } else {
                        i = i6;
                    }
                }
                lineAppendable.append((CharSequence) basedSequenceCellText);
                i7++;
                i5 = tableCell2.columnSpan + i10;
                if (i7 < this.alignments.length) {
                    if (this.options.spaceAroundPipes && pipeNeedsSpaceBefore(tableCell2)) {
                        lineAppendable.append(' ');
                    }
                    appendColumnSpan(lineAppendable, tableCell2.columnSpan, tableCell2.getInsideEndOffset(), tableCell2.spanTrackedOffset);
                } else {
                    TableFormatOptions tableFormatOptions2 = this.options;
                    if (tableFormatOptions2.leadTrailPipes) {
                        if (tableFormatOptions2.spaceAroundPipes && pipeNeedsSpaceBefore(tableCell2)) {
                            lineAppendable.append(' ');
                        }
                        appendColumnSpan(lineAppendable, tableCell2.columnSpan, tableCell2.getInsideEndOffset(), tableCell2.spanTrackedOffset);
                    } else {
                        if (tableFormatOptions2.spaceAroundPipes && pipeNeedsSpaceBefore(tableCell2)) {
                            lineAppendable.append(' ');
                        }
                        appendColumnSpan(lineAppendable, tableCell2.columnSpan - 1, tableCell2.getInsideEndOffset(), tableCell2.spanTrackedOffset);
                    }
                }
                i6 = i + 1;
                it = it2;
                i2 = i8;
            }
            Iterator<TableRow> it3 = it;
            int i13 = next.afterOffset;
            if (i13 != Integer.MAX_VALUE) {
                setTrackedOffsetIndex(i13, lineAppendable.offsetWithPending());
            }
            if (i7 > 0) {
                lineAppendable.line();
            }
            it = it3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:98:0x01b1 A[PHI: r5
      0x01b1: PHI (r5v3 com.vladsch.flexmark.util.sequence.BasedSequence) = 
      (r5v2 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v5 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v5 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v5 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v5 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v2 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v2 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v2 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v2 com.vladsch.flexmark.util.sequence.BasedSequence)
      (r5v2 com.vladsch.flexmark.util.sequence.BasedSequence)
     binds: [B:18:0x005b, B:92:0x01a2, B:93:0x01a4, B:95:0x01a8, B:96:0x01aa, B:49:0x00f4, B:64:0x013d, B:65:0x013f, B:67:0x0143, B:21:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v8, types: [T, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private BasedSequence cellText(List<TableCell> list, int i, boolean z, boolean z2, int i2, CellAlignment cellAlignment, Ref<Integer> ref) {
        boolean z3;
        TableCell tableCellWithTrackedOffset;
        int i4;
        CellAlignment cellAlignment2 = cellAlignment;
        TableCell tableCell = list.get(i);
        BasedSequence basedSequenceAppend = tableCell.text;
        int i5 = tableCell.trackedTextOffset;
        boolean z4 = i5 != Integer.MAX_VALUE && i5 >= basedSequenceAppend.length();
        int i6 = tableCell.trackedTextOffset;
        if (i6 == Integer.MAX_VALUE) {
            z3 = false;
        } else {
            if (i6 > tableCell.text.length()) {
                basedSequenceAppend = basedSequenceAppend.append(RepeatedSequence.repeatOf(' ', (tableCell.trackedTextOffset - tableCell.text.length()) - 1));
            } else if (tableCell.trackedTextOffset < 0) {
                z3 = true;
            }
            z3 = false;
        }
        int stringWidth = this.options.charWidthProvider.getStringWidth(basedSequenceAppend);
        if (!this.options.adjustColumnWidth || (stringWidth >= i2 && tableCell.trackedTextOffset <= tableCell.text.length())) {
            tableCellWithTrackedOffset = tableCell;
        } else {
            TableFormatOptions tableFormatOptions = this.options;
            if (!tableFormatOptions.applyColumnAlignment || cellAlignment2 == null || cellAlignment2 == CellAlignment.NONE) {
                cellAlignment2 = (!z2 || tableFormatOptions.leftAlignMarker == DiscretionaryText.ADD) ? CellAlignment.LEFT : CellAlignment.CENTER;
            } else if (z2 && cellAlignment2 == CellAlignment.LEFT && tableFormatOptions.leftAlignMarker == DiscretionaryText.REMOVE) {
                cellAlignment2 = CellAlignment.CENTER;
            }
            int i7 = i2 - stringWidth;
            int iIntValue = (ref.value.intValue() + i7) / this.options.spaceWidth;
            if (i2 > 0) {
                int i8 = iIntValue + 1;
                if (Math.abs((ref.value.intValue() + i7) - (this.options.spaceWidth * i8)) < Math.abs((ref.value.intValue() + i7) - (this.options.spaceWidth * iIntValue))) {
                    iIntValue = i8;
                }
            }
            ref.value = Integer.valueOf((i7 - (this.options.spaceWidth * iIntValue)) + ref.value.intValue());
            int i9 = C118532.$SwitchMap$com$vladsch$flexmark$util$html$CellAlignment[cellAlignment2.ordinal()];
            if (i9 == 1) {
                if (iIntValue > 0) {
                    basedSequenceAppend = basedSequenceAppend.append(PrefixedSubSequence.repeatOf(" ", iIntValue, basedSequenceAppend.getEmptySuffix()));
                }
                if (z && z4 && tableCell.afterSpace && iIntValue <= 0) {
                    tableCellWithTrackedOffset = tableCell.withTrackedTextAdjust(1);
                }
            } else if (i9 == 2) {
                if (iIntValue > 0) {
                    basedSequenceAppend = PrefixedSubSequence.repeatOf(" ", iIntValue, basedSequenceAppend);
                    tableCellWithTrackedOffset = (!z || tableCell.trackedTextOffset == Integer.MAX_VALUE) ? tableCell : tableCell.withTrackedOffset(Utils.maxLimit(basedSequenceAppend.length(), tableCell.trackedTextOffset + iIntValue));
                    if (z && z3 && tableCell.afterSpace) {
                        tableCellWithTrackedOffset = tableCellWithTrackedOffset.withTrackedTextAdjust(1);
                    }
                } else {
                    tableCellWithTrackedOffset = tableCell;
                }
                if (z && z4 && tableCell.afterSpace && (iIntValue <= 0 || !tableCell.afterDelete)) {
                    tableCellWithTrackedOffset = tableCellWithTrackedOffset.withTrackedTextAdjust(1);
                }
            } else if (i9 == 3) {
                int i10 = iIntValue / 2;
                if (iIntValue > 0) {
                    basedSequenceAppend = PrefixedSubSequence.repeatOf(" ", i10, basedSequenceAppend).append(PrefixedSubSequence.repeatOf(" ", iIntValue - i10, basedSequenceAppend.getEmptySuffix()));
                    tableCellWithTrackedOffset = (!z || tableCell.trackedTextOffset == Integer.MAX_VALUE) ? tableCell : tableCell.withTrackedOffset(Utils.maxLimit(basedSequenceAppend.length(), tableCell.trackedTextOffset + i10));
                    if (z && z3 && tableCell.afterSpace) {
                        tableCellWithTrackedOffset = tableCellWithTrackedOffset.withTrackedTextAdjust(1);
                    }
                } else if (z && z4 && tableCell.afterSpace) {
                    tableCellWithTrackedOffset = tableCell.withTrackedTextAdjust(1);
                }
            }
        }
        if (z && (i4 = tableCellWithTrackedOffset.trackedTextOffset) != Integer.MAX_VALUE) {
            if (i4 > basedSequenceAppend.length()) {
                tableCellWithTrackedOffset = tableCellWithTrackedOffset.withTrackedOffset(basedSequenceAppend.length());
            }
            if (tableCellWithTrackedOffset != tableCell) {
                list.set(i, tableCellWithTrackedOffset);
            }
        }
        return basedSequenceAppend;
    }

    @Nullable
    private TrackedOffset findTrackedOffset(int i) {
        for (TrackedOffset trackedOffset : this.trackedOffsets) {
            if (trackedOffset.getOffset() == i) {
                return trackedOffset;
            }
            if (trackedOffset.getOffset() > i) {
                return null;
            }
        }
        return null;
    }

    private void forAllSectionsRows(int i, int i2, TableSection[] tableSectionArr, TableRowManipulator tableRowManipulator) {
        if (i2 <= 0) {
            return;
        }
        int i4 = i2;
        int i5 = i;
        for (TableSection tableSection : tableSectionArr) {
            if (i >= tableSection.rows.size()) {
                i -= tableSection.rows.size();
            } else {
                while (i < tableSection.rows.size()) {
                    int iApply = tableRowManipulator.apply(tableSection.rows.get(i), i5, tableSection.rows, i);
                    if (iApply == Integer.MIN_VALUE) {
                        return;
                    }
                    if (iApply < 0) {
                        i5 -= iApply;
                        i4 += iApply;
                    } else {
                        i4--;
                        i = iApply + 1 + i;
                    }
                    if (i4 <= 0) {
                        return;
                    } else {
                        i5++;
                    }
                }
                i = 0;
            }
        }
    }

    public static String formattedCaption(BasedSequence basedSequence, TableFormatOptions tableFormatOptions) {
        boolean zIsNotNull = basedSequence.isNotNull();
        int i = C118532.f8372xe4309ea4[tableFormatOptions.formatTableCaption.ordinal()];
        if (i == 1) {
            zIsNotNull = true;
        } else if (i == 2) {
            zIsNotNull = !basedSequence.isBlank();
        } else if (i == 3) {
            zIsNotNull = false;
        }
        if (!zIsNotNull) {
            return null;
        }
        String str = C118532.f8371xa6c81092[tableFormatOptions.formatTableCaptionSpaces.ordinal()] != 1 ? "" : " ";
        return AbstractC0541b.m757C(str, basedSequence.toString(), str);
    }

    private List<TableRow> getAllSectionsRows(TableSection... tableSectionArr) {
        ArrayList arrayList = new ArrayList(this.body.rows.size() + this.header.rows.size());
        for (TableSection tableSection : tableSectionArr) {
            arrayList.addAll(tableSection.rows);
        }
        return arrayList;
    }

    private boolean isEmptyRowAt(int i, TableSection[] tableSectionArr) {
        boolean[] zArr = {false};
        forAllSectionsRows(i, 1, tableSectionArr, new C11861g(zArr, 1));
        return zArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$addTrackedOffset$2(int i, TrackedOffset trackedOffset) {
        return trackedOffset.getOffset() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$aggregateTotalColumnsWithoutColumns$11(int[] iArr, Integer[] numArr, BiFunction biFunction, TableRow tableRow, int i, ArrayList arrayList, int i2) {
        int size = tableRow.cells.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            if (!ArrayUtils.contained(i5, iArr)) {
                i4 += tableRow.cells.get(i5).columnSpan;
            }
        }
        if (i4 != 0) {
            numArr[0] = (Integer) biFunction.apply(numArr[0], Integer.valueOf(i4));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$aggregateTotalColumnsWithoutRows$12(int[] iArr, Integer[] numArr, BiFunction biFunction, TableRow tableRow, int i, ArrayList arrayList, int i2) {
        int totalColumns;
        if (!ArrayUtils.contained(i, iArr) && (totalColumns = tableRow.getTotalColumns()) > 0) {
            numArr[0] = (Integer) biFunction.apply(numArr[0], Integer.valueOf(totalColumns));
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$deleteColumns$4(int i, int i2, TableRow tableRow, int i4, ArrayList arrayList, int i5) {
        ((TableRow) arrayList.get(i5)).deleteColumns(i, i2);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$insertColumns$3(int i, int i2, TableRow tableRow, int i4, ArrayList arrayList, int i5) {
        ((TableRow) arrayList.get(i5)).insertColumns(i, i2);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$isEmptyColumn$6(int i, boolean[] zArr, TableRow tableRow, int i2, ArrayList arrayList, int i4) {
        if (tableRow.isEmptyColumn(i)) {
            return 0;
        }
        zArr[0] = false;
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$isEmptyRowAt$7(boolean[] zArr, TableRow tableRow, int i, ArrayList arrayList, int i2) {
        if (!tableRow.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        zArr[0] = true;
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$moveColumn$5(int i, int i2, TableRow tableRow, int i4, ArrayList arrayList, int i5) {
        ((TableRow) arrayList.get(i5)).moveColumn(i, i2);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0178  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ int lambda$sorted$10(ColumnSort[] columnSortArr, int i, int[] iArr, TextCollectingVisitor textCollectingVisitor, int i2, CellAlignment[] cellAlignmentArr, NumericSuffixPredicate numericSuffixPredicate, TableRow tableRow, TableRow tableRow2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iCompareTo;
        int i8;
        ColumnSort[] columnSortArr2 = columnSortArr;
        TableRow tableRow3 = tableRow;
        TableRow tableRow4 = tableRow2;
        int length = columnSortArr2.length;
        int i9 = 0;
        while (i9 < length) {
            ColumnSort columnSort = columnSortArr2[i9];
            int i10 = columnSort.column;
            if (i10 >= 0 && i10 < i && (i4 = iArr[i10]) > 0) {
                Sort sort = columnSort.sort;
                boolean zIsDescending = sort.isDescending();
                boolean zIsNumeric = sort.isNumeric();
                boolean zIsNumericLast = sort.isNumericLast();
                IndexSpanOffset indexSpanOffsetIndexOf = tableRow3.indexOf(i10);
                TableCell tableCell = tableRow3.cells.get(indexSpanOffsetIndexOf.index);
                IndexSpanOffset indexSpanOffsetIndexOf2 = tableRow4.indexOf(i10);
                TableCell tableCell2 = tableRow4.cells.get(indexSpanOffsetIndexOf2.index);
                int i11 = indexSpanOffsetIndexOf.index;
                if (i11 != i10 || tableCell == null || indexSpanOffsetIndexOf2.index != i10 || tableCell2 == null) {
                    i5 = (i11 != i10 || tableCell == null) ? (indexSpanOffsetIndexOf2.index != i10 || tableCell2 == null) ? 0 : -1 : 1;
                } else {
                    Node node = tableCell.tableCellNode;
                    String string = node == null ? tableCell.text.toString() : textCollectingVisitor.collectAndGetText(node, i2).trim();
                    Node node2 = tableCell2.tableCellNode;
                    String string2 = node2 == null ? tableCell2.text.toString() : textCollectingVisitor.collectAndGetText(node2, i2).trim();
                    int length2 = i4 - string.length();
                    int length3 = i4 - string2.length();
                    int i12 = C118532.$SwitchMap$com$vladsch$flexmark$util$html$CellAlignment[cellAlignmentArr[i10].ordinal()];
                    if (i12 == 2) {
                        i6 = 0;
                    } else if (i12 != 3) {
                        length2 = 0;
                        length3 = 0;
                        i6 = 0;
                    } else {
                        length2 >>= 1;
                        i6 = i4 - length2;
                        length3 >>= 1;
                        i7 = i4 - length3;
                        if (zIsNumeric) {
                            iCompareTo = (RepeatedSequence.ofSpaces(length2).toString() + string + ((Object) RepeatedSequence.ofSpaces(i6))).compareTo(RepeatedSequence.ofSpaces(length3).toString() + string2 + ((Object) RepeatedSequence.ofSpaces(i7)));
                        } else {
                            Pair<Number, String> numberPrefixOrNull = SequenceUtils.parseNumberPrefixOrNull(string, numericSuffixPredicate);
                            Pair<Number, String> numberPrefixOrNull2 = SequenceUtils.parseNumberPrefixOrNull(string2, numericSuffixPredicate);
                            if (numberPrefixOrNull == null || numberPrefixOrNull2 == null) {
                                if (numberPrefixOrNull != null) {
                                    i8 = zIsNumericLast ? 1 : -1;
                                } else if (numberPrefixOrNull2 == null) {
                                    iCompareTo = (RepeatedSequence.ofSpaces(length2).toString() + string + ((Object) RepeatedSequence.ofSpaces(i6))).compareTo(RepeatedSequence.ofSpaces(length3).toString() + string2 + ((Object) RepeatedSequence.ofSpaces(i7)));
                                } else if (zIsNumericLast) {
                                }
                                iCompareTo = i8;
                                zIsDescending = false;
                            } else {
                                iCompareTo = Utils.compare(numberPrefixOrNull.getFirst(), numberPrefixOrNull2.getFirst());
                                String second = numberPrefixOrNull.getSecond();
                                String second2 = numberPrefixOrNull2.getSecond();
                                if (iCompareTo == 0 && (numericSuffixPredicate.sortSuffix(second) || numericSuffixPredicate.sortSuffix(second2))) {
                                    if (second.isEmpty() || !numericSuffixPredicate.sortSuffix(second) || second2.isEmpty() || !numericSuffixPredicate.sortSuffix(second2)) {
                                        if (second.isEmpty() || !numericSuffixPredicate.sortSuffix(second)) {
                                            if (!second2.isEmpty() && numericSuffixPredicate.sortSuffix(second2)) {
                                                if (zIsNumericLast) {
                                                }
                                            }
                                        } else if (zIsNumericLast) {
                                        }
                                        iCompareTo = i8;
                                        zIsDescending = false;
                                    } else {
                                        iCompareTo = second.compareTo(numberPrefixOrNull2.getSecond());
                                    }
                                }
                            }
                        }
                        i5 = iCompareTo;
                    }
                    i7 = i6;
                    if (zIsNumeric) {
                    }
                    i5 = iCompareTo;
                }
                if (i5 != 0) {
                    return zIsDescending ? -i5 : i5;
                }
            }
            i9++;
            columnSortArr2 = columnSortArr;
            tableRow3 = tableRow;
            tableRow4 = tableRow2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$sorted$9(MarkdownTable markdownTable, TableRow tableRow, int i, ArrayList arrayList, int i2) {
        int size = tableRow.cells.size();
        for (int i4 = 0; i4 < size; i4++) {
            TableCell tableCell = tableRow.cells.get(i4);
            if (tableCell != TableCell.DEFAULT_CELL) {
                tableCell = new TableCell(tableCell, true, tableCell.rowSpan, tableCell.columnSpan, tableCell.alignment);
            }
            markdownTable.addCell(tableCell);
        }
        markdownTable.nextRow();
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$1(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$transposed$8(TableCell[][] tableCellArr, TableRow tableRow, int i, ArrayList arrayList, int i2) {
        TableCell[] tableCellArr2 = tableCellArr[i];
        int size = tableRow.cells.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            TableCell tableCell = tableRow.cells.get(i5);
            int i6 = 0;
            while (i6 < tableCell.columnSpan) {
                int i7 = i4 + 1;
                tableCellArr2[i4] = new TableCell(tableCell, i6 == 0, 1, 1, (CellAlignment) null);
                i6++;
                i4 = i7;
            }
        }
        return 0;
    }

    private boolean pipeNeedsSpaceAfter(TableCell tableCell) {
        return tableCell.text.equals(" ") || !tableCell.text.startsWith(" ");
    }

    private boolean pipeNeedsSpaceBefore(TableCell tableCell) {
        return tableCell.text.equals(" ") || !tableCell.text.endsWith(" ");
    }

    private boolean setTrackedOffsetIndex(int i, int i2) {
        TrackedOffset trackedOffsetFindTrackedOffset = findTrackedOffset(i);
        if (trackedOffsetFindTrackedOffset == null) {
            return false;
        }
        trackedOffsetFindTrackedOffset.setIndex(i2);
        return true;
    }

    private int spanFixedWidth(BitSet bitSet, int i, int i2) {
        if (i2 <= 1) {
            if (bitSet.get(i)) {
                return 0;
            }
            return this.columnWidths[i];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (!bitSet.get(i5)) {
                i4 += this.columnWidths[i5 + i];
            }
        }
        return i4;
    }

    private int spanWidth(int i, int i2) {
        if (i2 <= 1) {
            return this.columnWidths[i];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 += this.columnWidths[i5 + i];
        }
        return i4;
    }

    public void addCell(@NotNull TableCell tableCell) {
        boolean z = this.isSeparator;
        TableSection tableSection = z ? this.separator : this.isHeading ? this.header : this.body;
        if (z && (tableCell.columnSpan != 1 || tableCell.rowSpan != 1)) {
            throw new IllegalStateException("Separator columns cannot span rows/columns");
        }
        TableRow tableRow = tableSection.get(tableSection.row);
        while (tableSection.column < tableRow.cells.size() && tableRow.cells.get(tableSection.column) != null) {
            tableSection.column++;
        }
        for (int i = 0; i < tableCell.rowSpan; i++) {
            tableSection.get(tableSection.row + i).set(tableSection.column, tableCell);
            for (int i2 = 1; i2 < tableCell.columnSpan; i2++) {
                tableSection.expandTo(tableSection.row + i, tableSection.column + i2);
                if (tableSection.get(tableSection.row + i).cells.get(tableSection.column + i2) != null) {
                    break;
                }
                tableSection.rows.get(tableSection.row + i).set(tableSection.column + i2, TableCell.NULL);
            }
        }
        tableSection.column += tableCell.columnSpan;
    }

    @Deprecated
    public boolean addTrackedOffset(int i) {
        return addTrackedOffset(TrackedOffset.track(i, null, false));
    }

    public int appendDashes(LineAppendable lineAppendable, int i, BasedSequence basedSequence, int i2) {
        int length = basedSequence.length();
        int i4 = 0;
        int iMax = Math.max(0, length - i2);
        if (iMax >= i) {
            lineAppendable.append((CharSequence) basedSequence.subSequence(i2, i2 + i));
            i4 = iMax - i;
        } else {
            int i5 = 1;
            if (iMax > 1) {
                lineAppendable.append((CharSequence) basedSequence.subSequence(i2, i2 + 1));
                iMax--;
            } else {
                i5 = 0;
            }
            lineAppendable.append('-', i - Math.max(0, i5 + iMax));
            if (iMax > 0) {
                lineAppendable.append((CharSequence) basedSequence.subSequence(i2, iMax + i2));
            } else {
                i4 = iMax;
            }
        }
        return length - i4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x044e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01eb  */
    /* JADX WARN: Type inference failed for: r6v19, types: [T, java.lang.Integer] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void appendTable(LineAppendable lineAppendable) {
        int i;
        boolean zStartsWith;
        boolean zEndsWith;
        int i2;
        int i4;
        int iMinLimit;
        int i5;
        int i6;
        int i7;
        TableCell tableCell;
        TableCell tableCell2;
        Ref ref;
        int i8;
        char c;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = 0;
        CharSequence charSequence = this.formatTableIndentPrefix;
        this.trackedOffsets.sort(Comparator.comparing(new C11419a(14)));
        lineAppendable.pushOptions();
        lineAppendable.removeOptions(LineAppendable.F_WHITESPACE_REMOVAL);
        finalizeTable();
        int i19 = 1;
        appendRows(lineAppendable, this.header.rows, true, charSequence);
        lineAppendable.append(charSequence);
        TableRow tableRow = this.separator.rows.size() > 0 ? this.separator.rows.get(0) : null;
        if (tableRow != null && (i17 = tableRow.beforeOffset) != Integer.MAX_VALUE) {
            setTrackedOffsetIndex(i17, lineAppendable.offsetWithPending());
        }
        Ref ref2 = new Ref(0);
        CellAlignment[] cellAlignmentArr = this.alignments;
        int length = cellAlignmentArr.length;
        int i20 = 0;
        int i21 = 0;
        while (i20 < length) {
            CellAlignment cellAlignmentAdjustCellAlignment = adjustCellAlignment(cellAlignmentArr[i20]);
            CellAlignment cellAlignment = CellAlignment.LEFT;
            if (cellAlignmentAdjustCellAlignment == cellAlignment || cellAlignmentAdjustCellAlignment == CellAlignment.RIGHT) {
                i6 = i18;
                i7 = i19;
            } else if (cellAlignmentAdjustCellAlignment == CellAlignment.CENTER) {
                i6 = i18;
                i7 = 2;
            } else {
                i7 = i18;
                i6 = i7;
            }
            int i22 = this.columnWidths[i21];
            TableFormatOptions tableFormatOptions = this.options;
            int i23 = (i22 - (tableFormatOptions.colonWidth * i7)) - tableFormatOptions.pipeWidth;
            int iIntValue = ((Integer) ref2.value).intValue() + i23;
            TableFormatOptions tableFormatOptions2 = this.options;
            CellAlignment[] cellAlignmentArr2 = cellAlignmentArr;
            int i24 = iIntValue / tableFormatOptions2.dashWidth;
            int iMinLimit2 = Utils.minLimit(i24, tableFormatOptions2.minSeparatorColumnWidth - i7, tableFormatOptions2.minSeparatorDashes);
            if (i24 < iMinLimit2) {
                i24 = iMinLimit2;
            }
            int i25 = i24 + 1;
            int i26 = length;
            if (Math.abs((((Integer) ref2.value).intValue() + i23) - (this.options.dashWidth * i25)) < Math.abs((((Integer) ref2.value).intValue() + i23) - (this.options.dashWidth * i24))) {
                i24 = i25;
            }
            ref2.value = Integer.valueOf((i23 - (this.options.dashWidth * i24)) + ((Integer) ref2.value).intValue());
            if (tableRow != null) {
                List<TableCell> list = tableRow.cells;
                if (i21 < list.size()) {
                    tableCell2 = list.get(i21);
                    tableCell = i21 > 0 ? list.get(i21 - 1) : null;
                } else {
                    tableCell = null;
                    tableCell2 = null;
                }
            }
            int iMinLimit3 = tableCell2 == null ? Integer.MAX_VALUE : Utils.minLimit(tableCell2.trackedTextOffset, i6);
            BasedSequence basedSequenceTrim = tableCell2 == null ? BasedSequence.NULL : tableCell2.text.trim(COLON_TRIM_CHARS);
            if (iMinLimit3 != Integer.MAX_VALUE) {
                if (this.options.leadTrailPipes && i21 == 0) {
                    lineAppendable.append('|');
                }
                if (iMinLimit3 == 0) {
                    ref = ref2;
                    if (tableCell2.text.charAt(iMinLimit3) == ':') {
                        i9 = 1;
                    }
                    if (iMinLimit3 != 1) {
                        i8 = i20;
                        if (tableCell2.text.charAt(iMinLimit3 - 1) == ':') {
                            i10 = 1;
                        }
                        if (iMinLimit3 == tableCell2.text.length() - 1) {
                            i11 = i10;
                            if (tableCell2.text.charAt(iMinLimit3) == ':') {
                                i12 = 1;
                            }
                            if (iMinLimit3 != tableCell2.text.length()) {
                                i13 = i12;
                                if (tableCell2.text.charAt(iMinLimit3 - 1) == ':') {
                                    i14 = 1;
                                }
                                if (iMinLimit3 == tableCell2.text.length()) {
                                    i15 = i14;
                                    if (tableCell2.text.charAt(iMinLimit3 - 1) == '-') {
                                        i16 = 1;
                                    }
                                    if (cellAlignmentAdjustCellAlignment != cellAlignment || cellAlignmentAdjustCellAlignment == CellAlignment.CENTER) {
                                        if (i9 == 0) {
                                            setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                            lineAppendable.append(':');
                                        } else if (i11 != 0) {
                                            lineAppendable.append(':');
                                            setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                        } else {
                                            lineAppendable.append(':');
                                        }
                                        iMinLimit3 = Integer.MAX_VALUE;
                                    } else {
                                        i9 = i6;
                                        i11 = i9;
                                    }
                                    if (i11 == 0 || i9 != 0 || i15 != 0 || i13 != 0) {
                                        appendDashes(lineAppendable, i24, basedSequenceTrim, i6);
                                    } else if (iMinLimit3 == 0) {
                                        setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                        appendDashes(lineAppendable, i24, basedSequenceTrim, i6);
                                    } else {
                                        int i27 = i6;
                                        if (i16 != 0 || iMinLimit3 >= i24) {
                                            appendDashes(lineAppendable, i24, basedSequenceTrim, i27);
                                            setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                        } else {
                                            int iAppendDashes = appendDashes(lineAppendable, iMinLimit3, basedSequenceTrim, i27);
                                            setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                            appendDashes(lineAppendable, i24 - iMinLimit3, basedSequenceTrim, iAppendDashes);
                                        }
                                    }
                                    if (cellAlignmentAdjustCellAlignment != CellAlignment.RIGHT || cellAlignmentAdjustCellAlignment == CellAlignment.CENTER) {
                                        if (i15 == 0) {
                                            lineAppendable.append(':');
                                            setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                        } else if (i13 != 0) {
                                            setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                            lineAppendable.append(':');
                                        } else {
                                            lineAppendable.append(':');
                                        }
                                    } else if (i15 != 0 || i13 != 0) {
                                        setTrackedOffsetIndex(tableCell2.getInsideStartOffset(tableCell) + tableCell2.trackedTextOffset, lineAppendable.offsetWithPending());
                                    }
                                } else {
                                    i15 = i14;
                                }
                                i16 = i6;
                                if (cellAlignmentAdjustCellAlignment != cellAlignment) {
                                    if (i9 == 0) {
                                    }
                                    iMinLimit3 = Integer.MAX_VALUE;
                                    if (i11 == 0) {
                                        appendDashes(lineAppendable, i24, basedSequenceTrim, i6);
                                        if (cellAlignmentAdjustCellAlignment != CellAlignment.RIGHT) {
                                            if (i15 == 0) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                i13 = i12;
                            }
                            i14 = i6;
                            if (iMinLimit3 == tableCell2.text.length()) {
                            }
                            i16 = i6;
                            if (cellAlignmentAdjustCellAlignment != cellAlignment) {
                            }
                        } else {
                            i11 = i10;
                        }
                        i12 = i6;
                        if (iMinLimit3 != tableCell2.text.length()) {
                        }
                        i14 = i6;
                        if (iMinLimit3 == tableCell2.text.length()) {
                        }
                        i16 = i6;
                        if (cellAlignmentAdjustCellAlignment != cellAlignment) {
                        }
                    } else {
                        i8 = i20;
                    }
                    i10 = i6;
                    if (iMinLimit3 == tableCell2.text.length() - 1) {
                    }
                    i12 = i6;
                    if (iMinLimit3 != tableCell2.text.length()) {
                    }
                    i14 = i6;
                    if (iMinLimit3 == tableCell2.text.length()) {
                    }
                    i16 = i6;
                    if (cellAlignmentAdjustCellAlignment != cellAlignment) {
                    }
                } else {
                    ref = ref2;
                }
                i9 = i6;
                if (iMinLimit3 != 1) {
                }
                i10 = i6;
                if (iMinLimit3 == tableCell2.text.length() - 1) {
                }
                i12 = i6;
                if (iMinLimit3 != tableCell2.text.length()) {
                }
                i14 = i6;
                if (iMinLimit3 == tableCell2.text.length()) {
                }
                i16 = i6;
                if (cellAlignmentAdjustCellAlignment != cellAlignment) {
                }
            } else {
                ref = ref2;
                i8 = i20;
                if (this.options.leadTrailPipes && i21 == 0) {
                    lineAppendable.append('|');
                }
                if (cellAlignmentAdjustCellAlignment == cellAlignment || cellAlignmentAdjustCellAlignment == CellAlignment.CENTER) {
                    c = ':';
                    lineAppendable.append(':');
                } else {
                    c = ':';
                }
                appendDashes(lineAppendable, i24, basedSequenceTrim, 0);
                if (cellAlignmentAdjustCellAlignment == CellAlignment.RIGHT || cellAlignmentAdjustCellAlignment == CellAlignment.CENTER) {
                    lineAppendable.append(c);
                }
            }
            i21++;
            if (this.options.leadTrailPipes || i21 < this.alignments.length) {
                lineAppendable.append('|');
            }
            i20 = i8 + 1;
            cellAlignmentArr = cellAlignmentArr2;
            length = i26;
            ref2 = ref;
            i18 = 0;
            i19 = 1;
        }
        if (tableRow != null && (i5 = tableRow.afterOffset) != Integer.MAX_VALUE) {
            setTrackedOffsetIndex(i5, lineAppendable.offsetWithPending());
        }
        lineAppendable.line();
        appendRows(lineAppendable, this.body.rows, false, charSequence);
        TableCell captionCell = getCaptionCell();
        String str = formattedCaption(captionCell.text, this.options);
        if (str != null) {
            BasedSequence basedSequenceSubSequence = BasedSequence.m13437of(str).subSequence(0, str.length());
            if (this.caption.rows.size() > 0) {
                TableRow tableRow2 = this.caption.rows.get(0);
                if (captionCell.trackedTextOffset == Integer.MAX_VALUE && tableRow2.beforeOffset == Integer.MAX_VALUE && tableRow2.afterOffset == Integer.MAX_VALUE) {
                    lineAppendable.popOptions().pushOptions();
                    lineAppendable.line().append(charSequence).append(PropertyUtils.INDEXED_DELIM).append((CharSequence) basedSequenceSubSequence).append(PropertyUtils.INDEXED_DELIM2).line();
                } else {
                    lineAppendable.line();
                    int i28 = tableRow2.beforeOffset;
                    if (i28 != Integer.MAX_VALUE) {
                        setTrackedOffsetIndex(i28, lineAppendable.offsetWithPending());
                    }
                    TableCell tableCellWithText = captionCell.withText(captionCell.text.trim());
                    int i29 = captionCell.trackedTextOffset;
                    if (i29 != Integer.MAX_VALUE) {
                        tableCellWithText = tableCellWithText.withTrackedOffset(Utils.minLimit(i29 - captionCell.text.trimmedStart().length(), 0));
                    }
                    if (tableCellWithText.text.isBlank()) {
                        i = 1;
                    } else {
                        int i30 = C118532.f8371xa6c81092[this.options.formatTableCaptionSpaces.ordinal()];
                        i = 1;
                        if (i30 == 1) {
                            zStartsWith = true;
                            zEndsWith = true;
                        } else if (i30 != 2) {
                            zStartsWith = captionCell.text.startsWith(" ");
                            zEndsWith = captionCell.text.endsWith(" ");
                        }
                        lineAppendable.append(charSequence);
                        lineAppendable.append(PropertyUtils.INDEXED_DELIM);
                        if (zStartsWith) {
                            lineAppendable.append(' ');
                        }
                        int iOffsetWithPending = lineAppendable.offsetWithPending();
                        tableRow2.cells.set(0, tableCellWithText);
                        BasedSequence basedSequenceCellText = cellText(tableRow2.cells, 0, true, false, 0, CellAlignment.LEFT, new Ref<>(0));
                        lineAppendable.offsetWithPending();
                        if (tableRow2.cells.size() > 0) {
                            tableRow2.cells.add(captionCell);
                        } else if (captionCell.trackedTextOffset != Integer.MAX_VALUE) {
                            TableCell tableCell3 = tableRow2.cells.get(0);
                            if (tableCell3.trackedTextOffset != Integer.MAX_VALUE) {
                                int startOffset = captionCell.text.getStartOffset() + captionCell.trackedTextOffset;
                                if (basedSequenceCellText.isBlank()) {
                                    iMinLimit = i;
                                    i4 = 0;
                                } else {
                                    i4 = 0;
                                    iMinLimit = tableCell3.trackedTextAdjust + Utils.minLimit(tableCell3.trackedTextOffset, 0);
                                }
                                setTrackedOffsetIndex(startOffset, iOffsetWithPending + iMinLimit);
                            } else {
                                i4 = 0;
                            }
                            tableRow2.cells.set(i4, captionCell);
                        }
                        lineAppendable.append((CharSequence) basedSequenceCellText);
                        if (zEndsWith) {
                            lineAppendable.append(' ');
                        }
                        lineAppendable.append(PropertyUtils.INDEXED_DELIM2);
                        i2 = tableRow2.afterOffset;
                        if (i2 != Integer.MAX_VALUE) {
                            setTrackedOffsetIndex(i2, lineAppendable.offsetWithPending());
                        }
                        lineAppendable.line();
                    }
                    zStartsWith = false;
                    zEndsWith = false;
                    lineAppendable.append(charSequence);
                    lineAppendable.append(PropertyUtils.INDEXED_DELIM);
                    if (zStartsWith) {
                    }
                    int iOffsetWithPending2 = lineAppendable.offsetWithPending();
                    tableRow2.cells.set(0, tableCellWithText);
                    BasedSequence basedSequenceCellText2 = cellText(tableRow2.cells, 0, true, false, 0, CellAlignment.LEFT, new Ref<>(0));
                    lineAppendable.offsetWithPending();
                    if (tableRow2.cells.size() > 0) {
                    }
                    lineAppendable.append((CharSequence) basedSequenceCellText2);
                    if (zEndsWith) {
                    }
                    lineAppendable.append(PropertyUtils.INDEXED_DELIM2);
                    i2 = tableRow2.afterOffset;
                    if (i2 != Integer.MAX_VALUE) {
                    }
                    lineAppendable.line();
                }
            }
        }
        lineAppendable.popOptions();
    }

    public void deleteColumns(int i, int i2) {
        forAllContentRows(new C11857c(i, i2, 1));
        Iterator<TableRow> it = this.separator.rows.iterator();
        while (it.hasNext()) {
            it.next().deleteColumns(i, i2);
        }
    }

    public void deleteRows(int i, int i2) {
        if (i <= this.header.rows.size()) {
            while (true) {
                int i4 = i2 - 1;
                if (i2 <= 0 || i >= this.header.rows.size()) {
                    return;
                }
                this.header.rows.remove(i);
                i2 = i4;
            }
        } else {
            if (i < this.separator.rows.size() + this.header.rows.size()) {
                return;
            }
            int size = (i - this.header.rows.size()) - this.separator.rows.size();
            while (true) {
                int i5 = i2 - 1;
                if (i2 <= 0 || size >= this.body.rows.size()) {
                    return;
                }
                this.body.rows.remove(size);
                i2 = i5;
            }
        }
    }

    public void fillMissingColumns() {
        fillMissingColumns(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0343  */
    /* JADX WARN: Type inference failed for: r9v0, types: [T, java.lang.Integer, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void finalizeTable() {
        CellAlignment cellAlignment;
        CellAlignment cellAlignment2;
        int i = 0;
        normalize();
        TableFormatOptions tableFormatOptions = this.options;
        if (tableFormatOptions.fillMissingColumns) {
            fillMissingColumns(tableFormatOptions.formatTableFillMissingMinColumn);
        }
        int maxColumns = getMaxColumns();
        this.alignments = new CellAlignment[maxColumns];
        this.columnWidths = new int[maxColumns];
        BitSet bitSet = new BitSet(maxColumns);
        ArrayList<ColumnSpan> arrayList = new ArrayList();
        Ref<Integer> ref = new Ref<>(0);
        int i2 = 1;
        if (this.separator.rows.size() > 0) {
            TableRow tableRow = this.separator.rows.get(0);
            ref.value = 0;
            int i4 = 0;
            for (TableCell tableCell : tableRow.cells) {
                if ((this.alignments[i4] == null || (tableCell.columnSpan == 1 && bitSet.get(i4))) && (cellAlignment2 = tableCell.alignment) != CellAlignment.NONE) {
                    this.alignments[i4] = cellAlignment2;
                    if (tableCell.columnSpan > 1) {
                        bitSet.set(i4);
                    }
                }
                i4 += tableCell.columnSpan;
            }
        }
        if (this.header.rows.size() > 0) {
            for (TableRow tableRow2 : this.header.rows) {
                int size = tableRow2.cells.size();
                int i5 = i;
                int i6 = i5;
                int i7 = i6;
                while (i5 < size) {
                    TableCell tableCell2 = tableRow2.cells.get(i5);
                    if ((this.alignments[i6] == null || (tableCell2.columnSpan == i2 && bitSet.get(i6))) && (cellAlignment = tableCell2.alignment) != CellAlignment.NONE) {
                        this.alignments[i6] = cellAlignment;
                        if (tableCell2.columnSpan > i2) {
                            bitSet.set(i6);
                        }
                    }
                    ref.value = 0;
                    int i8 = size;
                    int i9 = i6;
                    int i10 = i7;
                    int stringWidth = this.options.charWidthProvider.getStringWidth(cellText(tableRow2.cells, i5, false, true, 0, null, ref));
                    TableFormatOptions tableFormatOptions2 = this.options;
                    int i11 = stringWidth + tableFormatOptions2.spacePad;
                    int i12 = tableFormatOptions2.pipeWidth;
                    int i13 = tableCell2.columnSpan;
                    int i14 = (i12 * i13) + i11;
                    if (i13 > 1) {
                        arrayList.add(new ColumnSpan(i10, i13, i14));
                    } else {
                        int[] iArr = this.columnWidths;
                        if (iArr[i9] < i14) {
                            iArr[i9] = i14;
                        }
                    }
                    i7 = i10 + 1;
                    i6 = i9 + tableCell2.columnSpan;
                    i5++;
                    size = i8;
                    i = 0;
                    i2 = 1;
                }
            }
        }
        if (this.body.rows.size() > 0) {
            for (TableRow tableRow3 : this.body.rows) {
                int size2 = tableRow3.cells.size();
                int i15 = 0;
                for (int i16 = 0; i16 < size2; i16++) {
                    TableCell tableCell3 = tableRow3.cells.get(i16);
                    ref.value = 0;
                    int stringWidth2 = this.options.charWidthProvider.getStringWidth(cellText(tableRow3.cells, i16, false, false, 0, null, ref));
                    TableFormatOptions tableFormatOptions3 = this.options;
                    int i17 = stringWidth2 + tableFormatOptions3.spacePad;
                    int i18 = tableFormatOptions3.pipeWidth;
                    int i19 = tableCell3.columnSpan;
                    int i20 = (i18 * i19) + i17;
                    if (i19 > 1) {
                        arrayList.add(new ColumnSpan(i15, i19, i20));
                    } else {
                        int[] iArr2 = this.columnWidths;
                        if (iArr2[i15] < i20) {
                            iArr2[i15] = i20;
                        }
                    }
                    i15 += tableCell3.columnSpan;
                }
            }
        }
        if (this.separator.rows.size() == 0 || this.body.rows.size() > 0 || this.header.rows.size() > 0) {
            ref.value = 0;
            int i21 = 0;
            for (CellAlignment cellAlignment3 : this.alignments) {
                CellAlignment cellAlignmentAdjustCellAlignment = adjustCellAlignment(cellAlignment3);
                int i22 = (cellAlignmentAdjustCellAlignment == CellAlignment.LEFT || cellAlignmentAdjustCellAlignment == CellAlignment.RIGHT) ? 1 : cellAlignmentAdjustCellAlignment == CellAlignment.CENTER ? 2 : 0;
                TableFormatOptions tableFormatOptions4 = this.options;
                int iMinLimit = Utils.minLimit(0, tableFormatOptions4.minSeparatorColumnWidth - i22, tableFormatOptions4.minSeparatorDashes);
                if (iMinLimit <= 0) {
                    iMinLimit = 0;
                }
                TableFormatOptions tableFormatOptions5 = this.options;
                int i23 = (i22 * tableFormatOptions5.colonWidth) + (iMinLimit * tableFormatOptions5.dashWidth) + tableFormatOptions5.pipeWidth;
                int[] iArr3 = this.columnWidths;
                if (iArr3[i21] < i23) {
                    iArr3[i21] = i23;
                }
                i21++;
            }
        } else {
            ref.value = 0;
            int i24 = 0;
            for (TableCell tableCell4 : this.separator.rows.get(0).cells) {
                CellAlignment cellAlignmentAdjustCellAlignment2 = adjustCellAlignment(tableCell4.alignment);
                int i25 = (cellAlignmentAdjustCellAlignment2 == CellAlignment.LEFT || cellAlignmentAdjustCellAlignment2 == CellAlignment.RIGHT) ? 1 : cellAlignmentAdjustCellAlignment2 == CellAlignment.CENTER ? 2 : 0;
                int length = tableCell4.text.trim(COLON_TRIM_CHARS).length();
                TableFormatOptions tableFormatOptions6 = this.options;
                int iMinLimit2 = Utils.minLimit(length, tableFormatOptions6.minSeparatorColumnWidth - i25, tableFormatOptions6.minSeparatorDashes);
                if (length < iMinLimit2) {
                    length = iMinLimit2;
                }
                TableFormatOptions tableFormatOptions7 = this.options;
                int i26 = (i25 * tableFormatOptions7.colonWidth) + (length * tableFormatOptions7.dashWidth) + tableFormatOptions7.pipeWidth;
                int[] iArr4 = this.columnWidths;
                if (iArr4[i24] < i26) {
                    iArr4[i24] = i26;
                }
                i24++;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BitSet bitSet2 = new BitSet(maxColumns);
        ArrayList<ColumnSpan> arrayList2 = new ArrayList(arrayList.size());
        for (ColumnSpan columnSpan : arrayList) {
            if (spanWidth(columnSpan.startColumn, columnSpan.columnSpan) < columnSpan.width) {
                int i27 = columnSpan.startColumn;
                bitSet2.set(i27, columnSpan.columnSpan + i27);
                arrayList2.add(columnSpan);
            }
        }
        while (!arrayList2.isEmpty()) {
            BitSet bitSet3 = new BitSet(maxColumns);
            arrayList2.clear();
            for (ColumnSpan columnSpan2 : arrayList2) {
                if (spanWidth(columnSpan2.startColumn, columnSpan2.columnSpan) <= spanFixedWidth(bitSet2, columnSpan2.startColumn, columnSpan2.columnSpan)) {
                    int i28 = columnSpan2.startColumn;
                    bitSet3.set(i28, columnSpan2.columnSpan + i28);
                } else {
                    arrayList2.add(columnSpan2);
                }
            }
            bitSet2.andNot(bitSet3);
            arrayList2.clear();
            for (ColumnSpan columnSpan3 : arrayList2) {
                int iSpanWidth = spanWidth(columnSpan3.startColumn, columnSpan3.columnSpan);
                int iSpanFixedWidth = spanFixedWidth(bitSet2, columnSpan3.startColumn, columnSpan3.columnSpan);
                if (iSpanWidth > iSpanFixedWidth) {
                    int i29 = iSpanWidth - iSpanFixedWidth;
                    int i30 = columnSpan3.startColumn;
                    int iCardinality = bitSet2.get(i30, columnSpan3.columnSpan + i30).cardinality();
                    int i31 = i29 / iCardinality;
                    int i32 = i29 - (iCardinality * i31);
                    for (int i33 = 0; i33 < columnSpan3.columnSpan; i33++) {
                        if (bitSet2.get(columnSpan3.startColumn + i33)) {
                            int[] iArr5 = this.columnWidths;
                            int i34 = columnSpan3.startColumn;
                            int i35 = i34 + i33;
                            iArr5[i35] = iArr5[i35] + i31;
                            if (i32 > 0) {
                                int i36 = i34 + i33;
                                iArr5[i36] = iArr5[i36] + 1;
                                i32--;
                            }
                        }
                    }
                    arrayList2.add(columnSpan3);
                }
            }
        }
    }

    public void forAllBodyRows(TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_BODY_ROWS, tableRowManipulator);
    }

    public void forAllContentRows(TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_CONTENT_ROWS, tableRowManipulator);
    }

    public void forAllHeaderRows(TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_HEADER_ROWS, tableRowManipulator);
    }

    public void forAllRows(TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_TABLE_ROWS, tableRowManipulator);
    }

    public void forAllSectionRows(TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_SECTIONS, tableRowManipulator);
    }

    public List<TableRow> getAllContentRows() {
        return getAllSectionsRows(this.ALL_CONTENT_ROWS);
    }

    public int getAllContentRowsCount() {
        return this.body.rows.size() + this.header.rows.size();
    }

    public List<TableRow> getAllRows() {
        return getAllSectionsRows(this.ALL_TABLE_ROWS);
    }

    public int getAllRowsCount() {
        return this.body.rows.size() + this.separator.rows.size() + this.header.rows.size();
    }

    public TableSection getAllRowsSection(int i) {
        for (TableSection tableSection : this.ALL_SECTIONS) {
            if (i < tableSection.rows.size()) {
                return tableSection;
            }
            i -= tableSection.rows.size();
        }
        return null;
    }

    public List<TableRow> getAllSectionRows() {
        return getAllSectionsRows(this.ALL_SECTIONS);
    }

    public int getAllSectionsRowsCount() {
        return this.caption.rows.size() + this.body.rows.size() + this.separator.rows.size() + this.header.rows.size();
    }

    public int getBodyRowCount() {
        return this.body.rows.size();
    }

    public BasedSequence getCaption() {
        return getCaptionCell().text;
    }

    public TableCell getCaptionCell() {
        return (this.caption.rows.size() <= 0 || this.caption.rows.get(0).cells.size() <= 0) ? TableCaptionSection.NULL_CELL : this.caption.rows.get(0).cells.get(0);
    }

    public int getCaptionRowCount() {
        return this.caption.rows.size();
    }

    public TableCellOffsetInfo getCellOffsetInfo(int i) {
        int i2 = 0;
        for (TableRow tableRow : getAllSectionRows()) {
            tableRow.normalizeIfNeeded();
            TableCell tableCell = (TableCell) AbstractC0000a.m10g(tableRow.cells, 1);
            BasedSequence lastSegment = tableCell.getLastSegment();
            int iBaseEndOfLineAnyEOL = lastSegment.baseEndOfLineAnyEOL();
            if (iBaseEndOfLineAnyEOL == -1) {
                iBaseEndOfLineAnyEOL = lastSegment.getEndOffset();
            }
            if (i <= iBaseEndOfLineAnyEOL) {
                TableCell tableCell2 = null;
                int i4 = 0;
                for (TableCell tableCell3 : tableRow.cells) {
                    if (tableCell3.closeMarker.isEmpty()) {
                        if (i <= tableCell3.text.getEndOffset()) {
                            if (i >= tableCell3.getInsideStartOffset(tableCell2)) {
                            }
                            return new TableCellOffsetInfo(i, this, getAllRowsSection(i2), tableRow, tableCell3, i2, i4, null, null);
                        }
                        tableCell2 = tableCell3;
                        i4++;
                        i = i;
                    } else {
                        if (i < tableCell3.closeMarker.getEndOffset()) {
                            if (i >= tableCell3.getInsideStartOffset(tableCell2) || i > tableCell3.getInsideEndOffset()) {
                                return new TableCellOffsetInfo(i, this, getAllRowsSection(i2), tableRow, tableCell3, i2, i4, null, null);
                            }
                            return new TableCellOffsetInfo(i, this, getAllRowsSection(i2), tableRow, tableCell3, i2, i4, Integer.valueOf(i4), Integer.valueOf(i - tableCell3.getInsideStartOffset(tableCell2)));
                        }
                        tableCell2 = tableCell3;
                        i4++;
                        i = i;
                    }
                }
                return new TableCellOffsetInfo(i, this, getAllRowsSection(i2), tableRow, tableCell, i2, i4, null, null);
            }
            i2++;
        }
        return new TableCellOffsetInfo(i, this, getAllRowsSection(i2 - 1), null, null, i2, 0, null, null);
    }

    public CharSequence getFormatTableIndentPrefix() {
        return this.formatTableIndentPrefix;
    }

    public boolean getHaveCaption() {
        return this.caption.rows.size() > 0 && this.caption.rows.get(0).cells.size() > 0 && this.caption.rows.get(0).cells.get(0).columnSpan != 0;
    }

    public boolean getHeader() {
        return this.isHeading;
    }

    public int getHeadingRowCount() {
        return this.header.rows.size();
    }

    public int getMaxBodyColumns() {
        return this.body.getMaxColumns();
    }

    public int getMaxColumns() {
        return Utils.max(this.header.getMaxColumns(), this.separator.getMaxColumns(), this.body.getMaxColumns());
    }

    public int getMaxColumnsWithoutColumns(boolean z, int... iArr) {
        return aggregateTotalColumnsWithoutColumns(z ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, MaxAggregator.INSTANCE, iArr);
    }

    public int getMaxColumnsWithoutRows(boolean z, int... iArr) {
        return aggregateTotalColumnsWithoutRows(z ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, MaxAggregator.INSTANCE, iArr);
    }

    public int getMaxHeadingColumns() {
        return this.header.getMaxColumns();
    }

    public int getMaxSeparatorColumns() {
        return this.separator.getMaxColumns();
    }

    public int getMinColumns() {
        int minColumns = this.header.getMinColumns();
        int minColumns2 = this.separator.getMinColumns();
        int minColumns3 = this.body.getMinColumns();
        if (minColumns == 0) {
            minColumns = Integer.MAX_VALUE;
        }
        if (minColumns3 == 0) {
            minColumns3 = Integer.MAX_VALUE;
        }
        return Utils.min(minColumns, minColumns2, minColumns3);
    }

    public int getMinColumnsWithoutColumns(boolean z, int... iArr) {
        return aggregateTotalColumnsWithoutColumns(z ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, MinAggregator.INSTANCE, iArr);
    }

    public int getMinColumnsWithoutRows(boolean z, int... iArr) {
        return aggregateTotalColumnsWithoutRows(z ? this.ALL_TABLE_ROWS : this.ALL_CONTENT_ROWS, MinAggregator.INSTANCE, iArr);
    }

    public int getSeparatorRowCount() {
        return this.separator.rows.size();
    }

    public CharSequence getTableChars() {
        return this.tableChars;
    }

    public int getTableStartOffset() {
        List<TableRow> allRows = getAllRows();
        if (!allRows.isEmpty()) {
            TableRow tableRow = allRows.get(0);
            tableRow.normalizeIfNeeded();
            if (tableRow.cells.size() > 0) {
                return tableRow.cells.get(0).getStartOffset(null);
            }
        }
        return 0;
    }

    @Nullable
    public TrackedOffset getTrackedOffset(int i) {
        return findTrackedOffset(i);
    }

    public int getTrackedOffsetIndex(int i) {
        TrackedOffset trackedOffsetFindTrackedOffset = findTrackedOffset(i);
        return trackedOffsetFindTrackedOffset == null ? i : trackedOffsetFindTrackedOffset.getIndex();
    }

    @NotNull
    public List<TrackedOffset> getTrackedOffsets() {
        return this.trackedOffsets;
    }

    public void insertColumns(int i, int i2) {
        forAllContentRows(new C11857c(i, i2, 2));
        Iterator<TableRow> it = this.separator.rows.iterator();
        while (it.hasNext()) {
            it.next().insertColumns(i, i2);
        }
    }

    public void insertRows(int i, int i2) {
        int maxColumns = getMaxColumns();
        if (i <= this.header.rows.size()) {
            insertRows(this.header.rows, i, i2, maxColumns);
        } else {
            insertRows(this.body.rows, Utils.rangeLimit((i - this.header.rows.size()) - this.separator.rows.size(), 0, this.body.rows.size()), i2, maxColumns);
        }
    }

    public boolean isAllRowsEmptyAt(int i) {
        return isEmptyRowAt(i, this.ALL_TABLE_ROWS);
    }

    public boolean isAllRowsSeparator(int i) {
        if (i >= this.header.rows.size()) {
            return i < this.separator.rows.size() + this.header.rows.size();
        }
        return false;
    }

    public boolean isContentRowsEmptyAt(int i) {
        return isEmptyRowAt(i, this.ALL_CONTENT_ROWS);
    }

    public boolean isEmptyColumn(int i) {
        boolean[] zArr = {true};
        forAllContentRows(new C4148a(zArr, i));
        return zArr[0];
    }

    public boolean isSeparator() {
        return this.isSeparator;
    }

    public void moveColumn(int i, int i2) {
        forAllContentRows(new C11857c(i, i2, 0));
        Iterator<TableRow> it = this.separator.rows.iterator();
        while (it.hasNext()) {
            it.next().moveColumn(i, i2);
        }
    }

    public void nextRow() {
        if (this.isSeparator) {
            throw new IllegalStateException("Only one separator row allowed");
        }
        if (this.isHeading) {
            this.header.nextRow();
        } else {
            this.body.nextRow();
        }
    }

    public void normalize() {
        this.header.normalize();
        this.separator.normalize();
        this.body.normalize();
    }

    public void setBody() {
        this.isSeparator = false;
        this.isHeading = false;
    }

    public void setCaption(CharSequence charSequence) {
        TableCell captionCell = getCaptionCell();
        setCaptionCell(captionCell.withText(captionCell.openMarker.isEmpty() ? "[" : captionCell.openMarker, charSequence, captionCell.closeMarker.isEmpty() ? "]" : captionCell.closeMarker));
    }

    public void setCaptionCell(TableCell tableCell) {
        if (this.caption.rows.size() == 0) {
            TableSection tableSection = this.caption;
            tableSection.rows.add(tableSection.defaultRow());
        }
        this.caption.rows.get(0).cells.clear();
        this.caption.rows.get(0).cells.add(tableCell);
    }

    public void setCaptionWithMarkers(Node node, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        if (this.options.formatTableCaptionSpaces != DiscretionaryText.AS_IS) {
            charSequence2 = BasedSequence.m13437of(charSequence2).trim();
        }
        setCaptionCell(new TableCell(node, charSequence, charSequence2, charSequence3, 1, 1));
    }

    public void setFormatTableIndentPrefix(CharSequence charSequence) {
        this.formatTableIndentPrefix = charSequence;
    }

    public void setHeader(boolean z) {
        this.isHeading = z;
    }

    public void setSeparator(boolean z) {
        this.isSeparator = z;
    }

    public MarkdownTable sorted(final ColumnSort[] columnSortArr, final int i, @Nullable NumericSuffixPredicate numericSuffixPredicate) {
        MarkdownTable markdownTable = new MarkdownTable(this.tableChars, this.options);
        markdownTable.trackedOffsets.addAll(this.trackedOffsets);
        markdownTable.setHeader();
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_HEADER_ROWS, new C11861g(markdownTable, 2));
        markdownTable.setSeparator();
        TableRow tableRow = this.separator.rows.get(0);
        int size = tableRow.cells.size();
        final CellAlignment[] cellAlignmentArr = new CellAlignment[size];
        for (int i2 = 0; i2 < size; i2++) {
            TableCell tableCell = tableRow.cells.get(i2);
            markdownTable.addCell(tableCell == TableCell.DEFAULT_CELL ? tableCell : new TableCell(tableCell, true, tableCell.rowSpan, tableCell.columnSpan, tableCell.alignment));
            cellAlignmentArr[i2] = tableCell.alignment;
        }
        List<TableRow> allSectionsRows = getAllSectionsRows(this.body);
        final int[] iArr = new int[size];
        int size2 = allSectionsRows.size();
        final int maxBodyColumns = getMaxBodyColumns();
        for (int i4 = 0; i4 < size2; i4++) {
            for (ColumnSort columnSort : columnSortArr) {
                int i5 = columnSort.column;
                if (i5 >= 0 && i5 < maxBodyColumns) {
                    IndexSpanOffset indexSpanOffsetIndexOf = allSectionsRows.get(i4).indexOf(i5);
                    TableCell tableCell2 = allSectionsRows.get(i4).cells.get(indexSpanOffsetIndexOf.index);
                    if (indexSpanOffsetIndexOf.index == i5 && tableCell2 != null) {
                        iArr[i5] = Math.max(iArr[i5], tableCell2.text.length());
                    }
                }
            }
        }
        final TextCollectingVisitor textCollectingVisitor = new TextCollectingVisitor();
        final NumericSuffixPredicate numericSuffixPredicate2 = numericSuffixPredicate == null ? ALL_SUFFIXES_SORT : numericSuffixPredicate;
        allSectionsRows.sort(new Comparator() { // from class: com.vladsch.flexmark.util.format.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return MarkdownTable.lambda$sorted$10(columnSortArr, maxBodyColumns, iArr, textCollectingVisitor, i, cellAlignmentArr, numericSuffixPredicate2, (TableRow) obj, (TableRow) obj2);
            }
        });
        markdownTable.setBody();
        int size3 = allSectionsRows.size();
        for (int i6 = 0; i6 < size3; i6++) {
            TableRow tableRow2 = allSectionsRows.get(i6);
            int size4 = tableRow2.cells.size();
            for (int i7 = 0; i7 < size4; i7++) {
                TableCell tableCell3 = tableRow2.cells.get(i7);
                if (tableCell3 != TableCell.DEFAULT_CELL) {
                    tableCell3 = new TableCell(tableCell3, true, tableCell3.rowSpan, tableCell3.columnSpan, tableCell3.alignment);
                }
                markdownTable.addCell(tableCell3);
            }
            markdownTable.nextRow();
        }
        markdownTable.setCaptionCell(getCaptionCell());
        return markdownTable;
    }

    public String toString() {
        return getClass().getName().substring(getClass().getPackage().getName().length() + 1) + "{header=" + this.header + ",\nseparator=" + this.separator + ",\nbody=" + this.body + ",\ncaption=" + this.caption + ",\noptions=" + this.options + ",\ntrackedOffsets=" + this.trackedOffsets + "}";
    }

    public MarkdownTable transposed(int i) {
        MarkdownTable markdownTable = new MarkdownTable(this.tableChars, this.options);
        markdownTable.trackedOffsets.addAll(this.trackedOffsets);
        int allRowsCount = getAllRowsCount() - 1;
        int maxColumns = getMaxColumns();
        TableCell[][] tableCellArr = new TableCell[allRowsCount][];
        for (int i2 = 0; i2 < allRowsCount; i2++) {
            tableCellArr[i2] = new TableCell[maxColumns];
        }
        forAllSectionsRows(0, Integer.MAX_VALUE, this.ALL_CONTENT_ROWS, new C11861g(tableCellArr, 0));
        markdownTable.setHeader();
        int iMin = Math.min(Math.max(0, i), maxColumns);
        for (int i4 = 0; i4 < iMin; i4++) {
            for (int i5 = 0; i5 < allRowsCount; i5++) {
                TableCell tableCell = tableCellArr[i5][i4];
                if (tableCell == null) {
                    tableCell = TableCell.DEFAULT_CELL;
                }
                markdownTable.addCell(tableCell);
            }
            markdownTable.nextRow();
        }
        TableRow tableRow = this.separator.rows.get(0);
        markdownTable.setSeparator();
        int size = tableRow.cells.size();
        for (int i6 = 0; i6 < allRowsCount; i6++) {
            if (i6 < size) {
                markdownTable.addCell(new TableCell(tableRow.cells.get(i6), true, 1, 1, (CellAlignment) null));
            } else {
                markdownTable.addCell(new TableCell("---", 1, 1));
            }
        }
        markdownTable.setBody();
        while (iMin < maxColumns) {
            for (int i7 = 0; i7 < allRowsCount; i7++) {
                TableCell tableCell2 = tableCellArr[i7][iMin];
                if (tableCell2 == null) {
                    tableCell2 = TableCell.DEFAULT_CELL;
                }
                markdownTable.addCell(tableCell2);
            }
            markdownTable.nextRow();
            iMin++;
        }
        markdownTable.setCaptionCell(getCaptionCell());
        return markdownTable;
    }

    public MarkdownTable(@NotNull CharSequence charSequence, @Nullable TableFormatOptions tableFormatOptions) {
        this.trackedOffsets = new ArrayList<>();
        this.tableChars = charSequence;
        this.formatTableIndentPrefix = tableFormatOptions == null ? "" : tableFormatOptions.formatTableIndentPrefix;
        TableSection tableSection = new TableSection(TableSectionType.HEADER);
        this.header = tableSection;
        TableSeparatorSection tableSeparatorSection = new TableSeparatorSection(TableSectionType.SEPARATOR);
        this.separator = tableSeparatorSection;
        TableSection tableSection2 = new TableSection(TableSectionType.BODY);
        this.body = tableSection2;
        TableCaptionSection tableCaptionSection = new TableCaptionSection(TableSectionType.CAPTION);
        this.caption = tableCaptionSection;
        this.isHeading = true;
        this.isSeparator = false;
        this.options = tableFormatOptions == null ? new TableFormatOptions(null) : tableFormatOptions;
        this.ALL_SECTIONS = new TableSection[]{tableSection, tableSeparatorSection, tableSection2, tableCaptionSection};
        this.ALL_TABLE_ROWS = new TableSection[]{tableSection, tableSeparatorSection, tableSection2};
        this.ALL_CONTENT_ROWS = new TableSection[]{tableSection, tableSection2};
        this.ALL_HEADER_ROWS = new TableSection[]{tableSection};
        this.ALL_BODY_ROWS = new TableSection[]{tableSection2};
    }

    @Deprecated
    public boolean addTrackedOffset(int i, boolean z) {
        return addTrackedOffset(TrackedOffset.track(i, z ? ' ' : null, false));
    }

    public void fillMissingColumns(Integer num) {
        int minColumns = getMinColumns();
        int maxColumns = getMaxColumns();
        if (minColumns < maxColumns) {
            Iterator<TableRow> it = this.header.rows.iterator();
            while (it.hasNext()) {
                it.next().fillMissingColumns(num, maxColumns);
            }
            Iterator<TableRow> it2 = this.body.rows.iterator();
            while (it2.hasNext()) {
                it2.next().fillMissingColumns(num, maxColumns);
            }
        }
    }

    public void forAllBodyRows(int i, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, Integer.MAX_VALUE, this.ALL_HEADER_ROWS, tableRowManipulator);
    }

    public void forAllContentRows(int i, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, Integer.MAX_VALUE, this.ALL_CONTENT_ROWS, tableRowManipulator);
    }

    public void forAllHeaderRows(int i, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, Integer.MAX_VALUE, this.ALL_HEADER_ROWS, tableRowManipulator);
    }

    public void forAllRows(int i, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, Integer.MAX_VALUE, this.ALL_TABLE_ROWS, tableRowManipulator);
    }

    public void forAllSectionRows(int i, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, Integer.MAX_VALUE, this.ALL_SECTIONS, tableRowManipulator);
    }

    public void setHeader() {
        this.isHeading = true;
        this.isSeparator = false;
    }

    public void setSeparator() {
        this.isSeparator = true;
        this.isHeading = false;
    }

    @Deprecated
    public boolean addTrackedOffset(int i, boolean z, boolean z2) {
        return addTrackedOffset(TrackedOffset.track(i, z ? ' ' : null, z2));
    }

    public void forAllBodyRows(int i, int i2, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, i2, this.ALL_HEADER_ROWS, tableRowManipulator);
    }

    public void forAllContentRows(int i, int i2, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, i2, this.ALL_CONTENT_ROWS, tableRowManipulator);
    }

    public void forAllHeaderRows(int i, int i2, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, i2, this.ALL_HEADER_ROWS, tableRowManipulator);
    }

    public void forAllRows(int i, int i2, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, i2, this.ALL_TABLE_ROWS, tableRowManipulator);
    }

    public void forAllSectionRows(int i, int i2, TableRowManipulator tableRowManipulator) {
        forAllSectionsRows(i, i2, this.ALL_SECTIONS, tableRowManipulator);
    }

    @Deprecated
    public boolean addTrackedOffset(int i, Character ch, boolean z) {
        return addTrackedOffset(TrackedOffset.track(i, ch, z));
    }

    private void insertRows(ArrayList<TableRow> arrayList, int i, int i2, int i4) {
        while (true) {
            int i5 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            TableRow tableRow = new TableRow();
            tableRow.appendColumns(i4);
            if (i >= arrayList.size()) {
                arrayList.add(tableRow);
            } else {
                arrayList.add(i, tableRow);
            }
            i2 = i5;
        }
    }

    public boolean addTrackedOffset(@NotNull TrackedOffset trackedOffset) {
        int offset = trackedOffset.getOffset();
        this.trackedOffsets.removeIf(new C0231c(offset, 6));
        this.trackedOffsets.add(trackedOffset);
        TableCellOffsetInfo cellOffsetInfo = getCellOffsetInfo(offset);
        if (cellOffsetInfo.getInsideColumn()) {
            List<TableCell> list = cellOffsetInfo.tableRow.cells;
            int i = cellOffsetInfo.column;
            TableCell tableCell = cellOffsetInfo.tableCell;
            list.set(i, tableCell.withTrackedOffset(offset - tableCell.getTextStartOffset(i == 0 ? null : list.get(i - 1)), trackedOffset.isAfterSpaceEdit(), trackedOffset.isAfterDelete()));
            return true;
        }
        if (cellOffsetInfo.isBeforeCells()) {
            cellOffsetInfo.tableRow.setBeforeOffset(offset);
            return true;
        }
        if (cellOffsetInfo.isInCellSpan()) {
            List<TableCell> list2 = cellOffsetInfo.tableRow.cells;
            int i2 = cellOffsetInfo.column;
            TableCell tableCell2 = cellOffsetInfo.tableCell;
            list2.set(i2, tableCell2.withSpanTrackedOffset(offset - tableCell2.getInsideEndOffset()));
            return true;
        }
        if (!cellOffsetInfo.isAfterCells()) {
            return false;
        }
        cellOffsetInfo.tableRow.setAfterOffset(offset);
        return true;
    }
}
