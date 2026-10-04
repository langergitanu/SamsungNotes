package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.utils;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.utils.MarkdownTableParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0007J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\r\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/utils/MarkdownTableParser;", "", "<init>", "()V", "tablePattern", "Lkotlin/text/Regex;", "PLACEHOLDER", "", "extractTables", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/utils/MarkdownTableParser$TableInfo;", "text", "parseRowCells", "line", "replaceTablesWithPlaceholder", "tables", "TableInfo", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMarkdownTableParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MarkdownTableParser.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/utils/MarkdownTableParser\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,97:1\n774#2:98\n865#2,2:99\n1563#2:101\n1634#2,3:102\n1869#2,2:105\n1563#2:107\n1634#2,3:108\n1056#2:111\n1#3:112\n*S KotlinDebug\n*F\n+ 1 MarkdownTableParser.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/utils/MarkdownTableParser\n*L\n40#1:98\n40#1:99,2\n41#1:101\n41#1:102,3\n54#1:105,2\n73#1:107\n73#1:108,3\n89#1:111\n*E\n"})
public final class MarkdownTableParser {

    @NotNull
    private static final String PLACEHOLDER = "";

    @NotNull
    public static final MarkdownTableParser INSTANCE = new MarkdownTableParser();

    @NotNull
    private static final Regex tablePattern = new Regex("(?m)(^\\|[^\\r\\n]*\\|[ \\t]*\\r?\\n)(^\\|[ \\t]*[-:]+(?:[ \\t]*\\|[ \\t]*[-:]+)*[ \\t]*\\|[ \\t]*\\r?\\n)((?:^\\|[^\\r\\n]*\\|[ \\t]*\\r?\\n)+)?");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/result/presenter/utils/MarkdownTableParser$TableInfo;", "", "rowCount", "", "columnCount", "cells", "", "", "start", "end", "<init>", "(IILjava/util/List;II)V", "getRowCount", "()I", "getColumnCount", "getCells", "()Ljava/util/List;", "getStart", "getEnd", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class TableInfo {

        @NotNull
        private final List<List<String>> cells;
        private final int columnCount;
        private final int end;
        private final int rowCount;
        private final int start;

        /* JADX WARN: Multi-variable type inference failed */
        public TableInfo(int i, int i2, @NotNull List<? extends List<String>> cells, int i4, int i5) {
            Intrinsics.checkNotNullParameter(cells, "cells");
            this.rowCount = i;
            this.columnCount = i2;
            this.cells = cells;
            this.start = i4;
            this.end = i5;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TableInfo copy$default(TableInfo tableInfo, int i, int i2, List list, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                i = tableInfo.rowCount;
            }
            if ((i6 & 2) != 0) {
                i2 = tableInfo.columnCount;
            }
            if ((i6 & 4) != 0) {
                list = tableInfo.cells;
            }
            if ((i6 & 8) != 0) {
                i4 = tableInfo.start;
            }
            if ((i6 & 16) != 0) {
                i5 = tableInfo.end;
            }
            int i7 = i5;
            List list2 = list;
            return tableInfo.copy(i, i2, list2, i4, i7);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getRowCount() {
            return this.rowCount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getColumnCount() {
            return this.columnCount;
        }

        @NotNull
        public final List<List<String>> component3() {
            return this.cells;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getStart() {
            return this.start;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getEnd() {
            return this.end;
        }

        @NotNull
        public final TableInfo copy(int rowCount, int columnCount, @NotNull List<? extends List<String>> cells, int start, int end) {
            Intrinsics.checkNotNullParameter(cells, "cells");
            return new TableInfo(rowCount, columnCount, cells, start, end);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TableInfo)) {
                return false;
            }
            TableInfo tableInfo = (TableInfo) other;
            return this.rowCount == tableInfo.rowCount && this.columnCount == tableInfo.columnCount && Intrinsics.areEqual(this.cells, tableInfo.cells) && this.start == tableInfo.start && this.end == tableInfo.end;
        }

        @NotNull
        public final List<List<String>> getCells() {
            return this.cells;
        }

        public final int getColumnCount() {
            return this.columnCount;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getRowCount() {
            return this.rowCount;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return Integer.hashCode(this.end) + AbstractC0622a.m1157c(this.start, AbstractC0622a.m1159e(this.cells, AbstractC0622a.m1157c(this.columnCount, Integer.hashCode(this.rowCount) * 31, 31), 31), 31);
        }

        @NotNull
        public String toString() {
            int i = this.rowCount;
            int i2 = this.columnCount;
            List<List<String>> list = this.cells;
            int i4 = this.start;
            int i5 = this.end;
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "TableInfo(rowCount=", ", columnCount=", ", cells=");
            sbM1173s.append(list);
            sbM1173s.append(", start=");
            sbM1173s.append(i4);
            sbM1173s.append(", end=");
            return AbstractC2821a.m2223n(sbM1173s, ")", i5);
        }
    }

    private MarkdownTableParser() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v16, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v1 */
    @JvmStatic
    @NotNull
    public static final List<TableInfo> extractTables(@NotNull String text) {
        ?? EmptyList;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (MatchResult matchResult : Regex.findAll$default(tablePattern, text, 0, 2, null)) {
            IntRange range = matchResult.getRange();
            String str = matchResult.getGroupValues().get(1);
            String str2 = (String) CollectionsKt.getOrNull(matchResult.getGroupValues(), 3);
            if (str2 == null) {
                str2 = "";
            }
            List<String> rowCells = INSTANCE.parseRowCells(StringsKt.trimEnd(str, '\r', '\n'));
            if (str2.length() > 0) {
                List listM13999t = AbstractC12991c.m13999t(0, "\\r?\\n", str2);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listM13999t) {
                    if (((String) obj).length() > 0) {
                        arrayList2.add(obj);
                    }
                }
                EmptyList = new ArrayList(CollectionsKt.m13952k(arrayList2));
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    EmptyList.add(INSTANCE.parseRowCells((String) it.next()));
                }
            } else {
                EmptyList = CollectionsKt.emptyList();
            }
            Integer num = (Integer) SequencesKt.maxOrNull(SequencesKt.map(SequencesKt.plus(SequencesKt.sequenceOf(rowCells), CollectionsKt.asSequence((Iterable) EmptyList)), new C0348a(25)));
            int iIntValue = num != null ? num.intValue() : 0;
            ArrayList arrayList3 = new ArrayList(EmptyList.size() + 1);
            arrayList3.add(extractTables$pad(iIntValue, rowCells));
            Iterator it2 = ((Iterable) EmptyList).iterator();
            while (it2.hasNext()) {
                arrayList3.add(extractTables$pad(iIntValue, (List) it2.next()));
            }
            arrayList.add(new TableInfo(arrayList3.size(), iIntValue, arrayList3, range.getFirst(), range.getLast() + 1));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int extractTables$lambda$2(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.size();
    }

    private static final List<String> extractTables$pad(int i, List<String> list) {
        if (list.size() >= i) {
            return list;
        }
        List<String> list2 = list;
        int size = i - list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add("");
        }
        return CollectionsKt.plus((Collection) list2, (Iterable) arrayList);
    }

    private final List<String> parseRowCells(String line) {
        List listM13999t = AbstractC12991c.m13999t(0, "(?<!\\\\)\\|", StringsKt.trimEnd(line, '\r', '\n'));
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(listM13999t));
        Iterator it = listM13999t.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.m14139M(StringsKt.m14139M(StringsKt.trim((CharSequence) it.next()).toString(), "\\|", "|"), "\\\\", "\\"));
        }
        boolean zIsEmpty = arrayList.isEmpty();
        List<String> listDrop = arrayList;
        if (!zIsEmpty) {
            int length = ((CharSequence) CollectionsKt.first((List) arrayList)).length();
            listDrop = arrayList;
            if (length == 0) {
                listDrop = CollectionsKt.drop(arrayList, 1);
            }
        }
        return (listDrop.isEmpty() || ((CharSequence) CollectionsKt.last((List) listDrop)).length() != 0) ? listDrop : CollectionsKt___CollectionsKt.dropLast(listDrop, 1);
    }

    @JvmStatic
    @NotNull
    public static final String replaceTablesWithPlaceholder(@NotNull String text, @Nullable List<TableInfo> tables) {
        List<TableInfo> list;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0 || (list = tables) == null || list.isEmpty()) {
            return text;
        }
        StringBuilder sb = new StringBuilder();
        int end = 0;
        for (TableInfo tableInfo : CollectionsKt.sortedWith(tables, new Comparator() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.utils.MarkdownTableParser$replaceTablesWithPlaceholder$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((MarkdownTableParser.TableInfo) t).getStart()), Integer.valueOf(((MarkdownTableParser.TableInfo) t2).getStart()));
            }
        })) {
            if (tableInfo.getStart() > end) {
                sb.append((CharSequence) text, end, tableInfo.getStart());
            }
            sb.append("");
            end = tableInfo.getEnd();
        }
        if (end < text.length()) {
            String strSubstring = text.substring(end);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            sb.append(strSubstring);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
