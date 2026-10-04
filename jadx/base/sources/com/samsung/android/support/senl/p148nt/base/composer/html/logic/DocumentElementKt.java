package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.composer.html.common.HtmlConstants;
import com.samsung.android.support.senl.p148nt.base.composer.html.logic.ListStyle;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000x\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0000\u001a4\u0010\t\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a.\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a6\u0010\u0013\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u0016\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002\u001a\u001e\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00182\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fH\u0002\u001a0\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002\u001a&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\fH\u0002\u001a6\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u0002\u001a\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010%\u001a\u00020\u001aH\u0002\u001a$\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0&2\u0006\u0010%\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u000eH\u0002\u001aD\u0010(\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\b2\n\u0010)\u001a\u00060*j\u0002`+2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\f2\u0018\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u000e0&0\fH\u0002\u001a\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u00102\u001a\u00020\n2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a\u0012\u00104\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u00066"}, m13886d2 = {SearchConstants.TargetContents.TAG, "", "LATEX_FROM_MD", "LATEX_CODE_BLOCK", "convertNodesToDocumentElements", "", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/DocumentElement;", "nodes", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/HtmlNode;", "processNodeList", "", "elements", "", "indentLevel", "", "listContext", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListContext;", "processNodeListWithStyle", "node", "flushInlineCollector", "inlineCollector", "parentNode", "addLastLineBreak", "createCodeBlock", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/CodeBlock;", "createTextBoxFromBlock", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TextBox;", "rootNode", "listStyle", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/ListStyle;", "nodesToProcess", "addRootStyle", "textContent", "spans", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/StyleSpan;", "createTextBoxAndImageFromBlock", "splitTextBox", ExternalDataConstants.Column.TEXT_BOX, "Lkotlin/Pair;", "p", "traverseAndBuild", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "tasks", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TaskObject;", "convertTableNode", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/TableObject;", "tableNode", "Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Table;", "printDocumentElements", "documentElements", "println", "str", "ntBase_release"}, m13887k = 2, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDocumentElement.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/DocumentElementKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,1110:1\n1869#2,2:1111\n1869#2,2:1113\n1869#2,2:1118\n1869#2,2:1120\n1869#2,2:1122\n808#2,11:1124\n808#2,11:1135\n808#2,11:1146\n808#2,11:1157\n774#2:1168\n865#2,2:1169\n774#2:1171\n865#2:1172\n1761#2,3:1173\n866#2:1176\n774#2:1177\n865#2:1178\n1740#2,3:1179\n866#2:1182\n1878#2,2:1183\n1869#2,2:1185\n1869#2:1187\n1869#2,2:1188\n1870#2:1190\n1880#2:1191\n439#3:1115\n439#3:1116\n1#4:1117\n384#5,7:1192\n*S KotlinDebug\n*F\n+ 1 DocumentElement.kt\ncom/samsung/android/support/senl/nt/base/composer/html/logic/DocumentElementKt\n*L\n690#1:1111,2\n751#1:1113,2\n846#1:1118,2\n873#1:1120,2\n902#1:1122,2\n993#1:1124,11\n995#1:1135,11\n997#1:1146,11\n1000#1:1157,11\n1000#1:1168\n1000#1:1169,2\n1005#1:1171\n1005#1:1172\n1005#1:1173,3\n1005#1:1176\n1007#1:1177\n1007#1:1178\n1007#1:1179,3\n1007#1:1182\n1016#1:1183,2\n1041#1:1185,2\n1074#1:1187\n1075#1:1188,2\n1074#1:1190\n1016#1:1191\n778#1:1115\n782#1:1116\n982#1:1192,7\n*E\n"})
public final class DocumentElementKt {

    @NotNull
    private static final String LATEX_CODE_BLOCK = "language-latex";

    @NotNull
    private static final String LATEX_FROM_MD = "katex";

    @NotNull
    private static final String TAG = "HtmlDocumentElement";

    private static final void addLastLineBreak(List<DocumentElement> list) {
        DocumentElement documentElement = (DocumentElement) CollectionsKt.lastOrNull((List) list);
        if (documentElement instanceof TextBox) {
            TextBox textBox = (TextBox) documentElement;
            if (StringsKt.m14167w(textBox.getText(), "\n")) {
                return;
            }
            list.set(CollectionsKt.getLastIndex(list), TextBox.copy$default(textBox, AbstractC0541b.m756B(textBox.getText(), "\n"), null, null, null, 0, false, 62, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void addRootStyle(HtmlNode htmlNode, String str, List<StyleSpan> list) {
        IntRange indices = StringsKt__StringsKt.getIndices(str);
        if (htmlNode instanceof Heading) {
            int level = ((Heading) htmlNode).getLevel();
            list.add(new StyleSpan(level != 1 ? level != 2 ? level != 3 ? level != 4 ? level != 5 ? SpanType.HEADING6 : SpanType.HEADING5 : SpanType.HEADING4 : SpanType.HEADING3 : SpanType.HEADING2 : SpanType.HEADING1, indices.getFirst(), indices.getLast() + 1, null, 8, null));
        }
        if (htmlNode instanceof StyledNode) {
            StyledNode styledNode = (StyledNode) htmlNode;
            String textColor = styledNode.getTextColor();
            if (textColor != null) {
                list.add(new StyleSpan(SpanType.TEXT_COLOR, indices.getFirst(), indices.getLast() + 1, textColor));
            }
            String backgroundColor = styledNode.getBackgroundColor();
            if (backgroundColor != null) {
                list.add(new StyleSpan(SpanType.BACKGROUND_COLOR, indices.getFirst(), indices.getLast() + 1, backgroundColor));
            }
        }
    }

    @NotNull
    public static final List<DocumentElement> convertNodesToDocumentElements(@NotNull List<? extends HtmlNode> nodes) {
        Intrinsics.checkNotNullParameter(nodes, "nodes");
        ArrayList arrayList = new ArrayList();
        processNodeList(nodes, arrayList, 0, new ListContext(0, false, 3, null));
        return arrayList;
    }

    private static final TableObject convertTableNode(Table table, int i) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Ref.IntRef intRef = new Ref.IntRef();
        List<HtmlNode> children = table.getChildren();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : children) {
            if (obj instanceof TableHead) {
                arrayList4.add(obj);
            }
        }
        TableHead tableHead = (TableHead) CollectionsKt.firstOrNull((List) arrayList4);
        if (tableHead != null) {
            convertTableNode$processRows(linkedHashMap, intRef, i, tableHead.getChildren(), arrayList);
        }
        List<HtmlNode> children2 = table.getChildren();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : children2) {
            if (obj2 instanceof TableBody) {
                arrayList5.add(obj2);
            }
        }
        TableBody tableBody = (TableBody) CollectionsKt.firstOrNull((List) arrayList5);
        if (tableBody != null) {
            convertTableNode$processRows(linkedHashMap, intRef, i, tableBody.getChildren(), arrayList2);
        }
        List<HtmlNode> children3 = table.getChildren();
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : children3) {
            if (obj3 instanceof TableFoot) {
                arrayList6.add(obj3);
            }
        }
        TableFoot tableFoot = (TableFoot) CollectionsKt.firstOrNull((List) arrayList6);
        if (tableFoot != null) {
            convertTableNode$processRows(linkedHashMap, intRef, i, tableFoot.getChildren(), arrayList3);
        }
        List<HtmlNode> children4 = table.getChildren();
        ArrayList arrayList7 = new ArrayList();
        for (Object obj4 : children4) {
            if (obj4 instanceof TableRow) {
                arrayList7.add(obj4);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object obj5 : arrayList7) {
            TableRow tableRow = (TableRow) obj5;
            if (!(tableRow.getParent() instanceof TableHead) && !(tableRow.getParent() instanceof TableBody) && !(tableRow.getParent() instanceof TableFoot)) {
                arrayList8.add(obj5);
            }
        }
        if (!arrayList8.isEmpty()) {
            ArrayList arrayList9 = new ArrayList();
            for (Object obj6 : arrayList8) {
                List<HtmlNode> children5 = ((TableRow) obj6).getChildren();
                if (!(children5 instanceof Collection) || !children5.isEmpty()) {
                    Iterator<T> it = children5.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((HtmlNode) it.next()) instanceof TableHeaderCell) {
                            arrayList9.add(obj6);
                            break;
                        }
                    }
                }
            }
            ArrayList arrayList10 = new ArrayList();
            for (Object obj7 : arrayList8) {
                List<HtmlNode> children6 = ((TableRow) obj7).getChildren();
                if (!(children6 instanceof Collection) || !children6.isEmpty()) {
                    Iterator<T> it2 = children6.iterator();
                    while (it2.hasNext()) {
                        if (((HtmlNode) it2.next()) instanceof TableHeaderCell) {
                            break;
                        }
                    }
                }
                arrayList10.add(obj7);
            }
            convertTableNode$processRows(linkedHashMap, intRef, i, arrayList9, arrayList);
            convertTableNode$processRows(linkedHashMap, intRef, i, arrayList10, arrayList2);
        }
        return new TableObject(arrayList, arrayList2, arrayList3);
    }

    private static final void convertTableNode$processRows(Map<Integer, Set<Integer>> map, Ref.IntRef intRef, int i, List<TableRow> list, List<List<TableCellInfo>> list2) {
        boolean z;
        int colSpan;
        int rowSpan;
        for (TableRow tableRow : list) {
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (HtmlNode htmlNode : tableRow.getChildren()) {
                int i4 = i2;
                while (true) {
                    Set<Integer> set = map.get(Integer.valueOf(intRef.element));
                    if (set == null || !set.contains(Integer.valueOf(i4))) {
                        break;
                    } else {
                        i4++;
                    }
                }
                TextBox textBoxCreateTextBoxFromBlock$default = createTextBoxFromBlock$default(htmlNode, i, ListStyle.NONE.INSTANCE, null, 8, null);
                if (htmlNode instanceof TableCell) {
                    TableCell tableCell = (TableCell) htmlNode;
                    int colSpan2 = tableCell.getColSpan();
                    z = false;
                    rowSpan = tableCell.getRowSpan();
                    colSpan = colSpan2;
                } else if (htmlNode instanceof TableHeaderCell) {
                    TableHeaderCell tableHeaderCell = (TableHeaderCell) htmlNode;
                    colSpan = tableHeaderCell.getColSpan();
                    rowSpan = tableHeaderCell.getRowSpan();
                    z = true;
                } else {
                    z = false;
                    colSpan = 1;
                    rowSpan = 1;
                }
                arrayList.add(new TableCellInfo(textBoxCreateTextBoxFromBlock$default, colSpan, rowSpan, intRef.element, i4, z));
                for (int i5 = 0; i5 < rowSpan; i5++) {
                    for (int i6 = 0; i6 < colSpan; i6++) {
                        Integer numValueOf = Integer.valueOf(intRef.element + i5);
                        Set<Integer> linkedHashSet = map.get(numValueOf);
                        if (linkedHashSet == null) {
                            linkedHashSet = new LinkedHashSet<>();
                            map.put(numValueOf, linkedHashSet);
                        }
                        linkedHashSet.add(Integer.valueOf(i4 + i6));
                    }
                }
                i2 = i4 + colSpan;
            }
            list2.add(arrayList);
            intRef.element++;
        }
    }

    private static final void createCodeBlock(CodeBlock codeBlock, List<DocumentElement> list) {
        String strSubstring;
        Iterator<String> it = codeBlock.getClasses().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), LATEX_CODE_BLOCK)) {
                list.add(new MathObject(codeBlock.getCode(), false, 2, null));
                return;
            }
        }
        Iterator<String> it2 = codeBlock.getClasses().iterator();
        while (true) {
            if (!it2.hasNext()) {
                strSubstring = "";
                break;
            }
            String next = it2.next();
            if (StringsKt.m14145S(next, "language-")) {
                strSubstring = next.substring(9);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                break;
            }
        }
        list.add(new CodeBlockObject(strSubstring, codeBlock.getCode()));
    }

    private static final List<DocumentElement> createTextBoxAndImageFromBlock(HtmlNode htmlNode, int i, ListStyle listStyle, List<? extends HtmlNode> list) {
        return splitTextBox(createTextBoxFromBlock(htmlNode, i, listStyle, list));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List createTextBoxAndImageFromBlock$default(HtmlNode htmlNode, int i, ListStyle listStyle, List list, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list = htmlNode instanceof ParentCapableNode ? ((ParentCapableNode) htmlNode).getChildren() : CollectionsKt.listOf(htmlNode);
        }
        return createTextBoxAndImageFromBlock(htmlNode, i, listStyle, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final TextBox createTextBoxFromBlock(HtmlNode htmlNode, int i, ListStyle listStyle, List<? extends HtmlNode> list) {
        ArrayList arrayList;
        String textAlign;
        String textAlign2;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            traverseAndBuild((HtmlNode) it.next(), sb, arrayList2, arrayList3);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (string.length() > 0) {
            addRootStyle(htmlNode, string, arrayList2);
        }
        Integer numValueOf = null;
        Integer numValueOf2 = null;
        float textSize = 15.0f;
        boolean z = false;
        Alignment alignment = Alignment.NONE;
        for (HtmlNode parent = htmlNode; parent != null; parent = parent.getParent()) {
            if (parent instanceof StyledNode) {
                StyledNode styledNode = (StyledNode) parent;
                if (styledNode.getTextAlign() == null || (textAlign2 = styledNode.getTextAlign()) == null) {
                    arrayList = arrayList2;
                } else {
                    arrayList = arrayList2;
                    int iHashCode = textAlign2.hashCode();
                    if (iHashCode != -1364013995) {
                        if (iHashCode != -1249482096) {
                            if (iHashCode == 108511772 && textAlign2.equals("right")) {
                                alignment = Alignment.RIGHT;
                            }
                        } else if (textAlign2.equals("justify")) {
                            alignment = Alignment.JUSTIFY;
                        }
                    } else if (textAlign2.equals("center")) {
                        alignment = Alignment.CENTER;
                    }
                }
            }
            if (parent instanceof TableCell) {
                TableCell tableCell = (TableCell) parent;
                if (tableCell.getTextAlign() != null && (textAlign = tableCell.getTextAlign()) != null) {
                    int iHashCode2 = textAlign.hashCode();
                    if (iHashCode2 != -1364013995) {
                        if (iHashCode2 != -1249482096) {
                            if (iHashCode2 == 108511772 && textAlign.equals("right")) {
                                alignment = Alignment.RIGHT;
                            }
                        } else if (textAlign.equals("justify")) {
                            alignment = Alignment.JUSTIFY;
                        }
                    } else if (textAlign.equals("center")) {
                        alignment = Alignment.CENTER;
                    }
                }
                if (tableCell.getTextColor() != null) {
                    numValueOf = Integer.valueOf(Color.parseColor(tableCell.getTextColor()));
                }
                if (tableCell.getBackgroundColor() != null) {
                    numValueOf2 = Integer.valueOf(Color.parseColor(tableCell.getBackgroundColor()));
                }
                textSize = tableCell.getTextSize();
            }
            if (parent instanceof Blockquote) {
                z = true;
            }
            arrayList2 = arrayList;
        }
        TextBox textBox = new TextBox(AbstractC0541b.m756B(string, (((htmlNode instanceof ListItem) || (htmlNode instanceof Paragraph) || (htmlNode instanceof Heading)) && Intrinsics.areEqual(CollectionsKt.last((List) ((ParentCapableNode) htmlNode).getChildren()), CollectionsKt.last((List) list))) ? "\n" : ""), arrayList2, alignment, listStyle, i, z);
        if (numValueOf != null) {
            textBox.setTextColor(Integer.valueOf(numValueOf.intValue()));
        }
        if (numValueOf2 != null) {
            textBox.setBackgroundColor(Integer.valueOf(numValueOf2.intValue()));
        }
        textBox.setFontSize(textSize);
        textBox.setTaskObjects(arrayList3);
        return textBox;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextBox createTextBoxFromBlock$default(HtmlNode htmlNode, int i, ListStyle listStyle, List list, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            list = htmlNode instanceof ParentCapableNode ? ((ParentCapableNode) htmlNode).getChildren() : CollectionsKt.listOf(htmlNode);
        }
        return createTextBoxFromBlock(htmlNode, i, listStyle, list);
    }

    private static final void flushInlineCollector(List<DocumentElement> list, List<HtmlNode> list2, HtmlNode htmlNode, int i) {
        List<HtmlNode> list3;
        if (list2.isEmpty()) {
            return;
        }
        if (htmlNode == null) {
            list3 = list2;
            htmlNode = new Paragraph(null, null, null, null, list3, 15, null);
        } else {
            list3 = list2;
        }
        for (DocumentElement documentElement : createTextBoxAndImageFromBlock(htmlNode, i, ListStyle.NONE.INSTANCE, CollectionsKt.toList(list3))) {
            if (documentElement instanceof TextBox) {
                TextBox textBox = (TextBox) documentElement;
                if (StringsKt.trim((CharSequence) textBox.getText()).toString().length() > 0 || StringsKt__StringsKt.contains$default((CharSequence) textBox.getText(), '\n', false, 2, (Object) null)) {
                    list.add(documentElement);
                }
            } else {
                list.add(documentElement);
            }
        }
        list3.clear();
    }

    public static final void printDocumentElements(@NotNull List<? extends DocumentElement> documentElements) {
        String strM767i;
        String strM14139M;
        Intrinsics.checkNotNullParameter(documentElements, "documentElements");
        int i = 0;
        for (Object obj : documentElements) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DocumentElement documentElement = (DocumentElement) obj;
            println(AbstractC0541b.m767i(i2, "================== [", "] ================="));
            if (documentElement instanceof TextBox) {
                println("Type         : TextBox");
                TextBox textBox = (TextBox) documentElement;
                println(AbstractC0541b.m775q("Content      : ", StringsKt__StringsJVMKt.repeat(" ", textBox.getIndentLevel() * 2), "\"", StringsKt.m14139M(textBox.getText(), "\n", "\\n"), "\""));
                println("Alignment    : " + textBox.getAlignment());
                ListStyle listStyle = textBox.getListStyle();
                if (listStyle instanceof ListStyle.BULLET) {
                    strM767i = "BULLET";
                } else if (listStyle instanceof ListStyle.NUMBERED) {
                    strM767i = AbstractC0541b.m767i(((ListStyle.NUMBERED) textBox.getListStyle()).getNumber(), "NUMBERED (number: ", ")");
                } else if (listStyle instanceof ListStyle.CHECKBOX) {
                    strM767i = "CHECKBOX " + ((ListStyle.CHECKBOX) textBox.getListStyle()).getChecked();
                } else {
                    strM767i = CoverStickerConstants.Category.NONE.NAME;
                }
                println(AbstractC0541b.m772n("List Style   : ", strM767i));
                if (textBox.isBlockQuote()) {
                    println("isBlockQuote : true");
                }
                System.out.println();
                println(AbstractC0000a.m11h(textBox.getIndentLevel(), "Indent Level : "));
                if (!textBox.getSpans().isEmpty()) {
                    println("Spans        :");
                    for (StyleSpan styleSpan : textBox.getSpans()) {
                        try {
                            String strSubstring = ((TextBox) documentElement).getText().substring(styleSpan.getStart(), styleSpan.getEnd());
                            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                            strM14139M = StringsKt.m14139M(strSubstring, "\n", "\\n");
                        } catch (IndexOutOfBoundsException unused) {
                            strM14139M = "ERROR";
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("  - Type: " + styleSpan.getType() + ", Range: [" + styleSpan.getStart() + "," + styleSpan.getEnd() + "], Text: \"" + strM14139M + "\"");
                        String value = styleSpan.getValue();
                        if (value != null) {
                            sb.append(", Value: ".concat(value));
                        }
                        println(sb.toString());
                    }
                }
            } else if (documentElement instanceof ImageObject) {
                println("Type: ImageObject");
                ImageObject imageObject = (ImageObject) documentElement;
                println(AbstractC0541b.m772n("Src : ", imageObject.getSrc()));
                println(AbstractC0541b.m772n("Alt : ", imageObject.getAlt()));
            } else if (documentElement instanceof MathObject) {
                println("Type: MathObject");
                println(AbstractC0541b.m772n("Latex : ", ((MathObject) documentElement).getLatex()));
            } else if (documentElement instanceof TableObject) {
                println("Type: TableObject");
                TableObject tableObject = (TableObject) documentElement;
                Pair<Integer, Integer> dimensions = tableObject.getDimensions();
                println(AbstractC0622a.m1164j(dimensions.component1().intValue(), dimensions.component2().intValue(), "Dimensions   : ", " rows x ", " columns"));
                List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) tableObject.getHeaders(), (Iterable) tableObject.getBody()), (Iterable) tableObject.getFooters());
                if (!listPlus.isEmpty()) {
                    println("Cells:");
                    Iterator it = listPlus.iterator();
                    while (it.hasNext()) {
                        for (TableCellInfo tableCellInfo : (List) it.next()) {
                            ArrayList arrayList = new ArrayList();
                            if (tableCellInfo.getColSpan() > 1) {
                                arrayList.add("ColSpan:" + tableCellInfo.getColSpan());
                            }
                            if (tableCellInfo.getRowSpan() > 1) {
                                arrayList.add("RowSpan:" + tableCellInfo.getRowSpan());
                            }
                            String strM773o = !arrayList.isEmpty() ? AbstractC0541b.m773o(" (", CollectionsKt.m13955n(arrayList, null, null, null, null, 63), ")") : "";
                            String string = StringsKt.trim((CharSequence) tableCellInfo.getContent().getText()).toString();
                            int rowIndex = tableCellInfo.getRowIndex();
                            int colIndex = tableCellInfo.getColIndex();
                            StringBuilder sbM780v = AbstractC0541b.m780v("  - \"", rowIndex, string, "\" at (row:", ", col:");
                            sbM780v.append(colIndex);
                            sbM780v.append(")");
                            sbM780v.append(strM773o);
                            println(sbM780v.toString());
                        }
                    }
                }
            } else {
                if (!(documentElement instanceof CodeBlockObject)) {
                    throw new NoWhenBranchMatchedException();
                }
                println("Type: CodeBlockObject");
                CodeBlockObject codeBlockObject = (CodeBlockObject) documentElement;
                println(AbstractC0541b.m772n("Title : ", codeBlockObject.getTitle()));
                println(AbstractC0541b.m772n("Code : ", codeBlockObject.getCode()));
            }
            i = i2;
        }
    }

    private static final void println(String str) {
        Logger.m8697d(TAG, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void processNodeList(List<? extends HtmlNode> list, List<DocumentElement> list2, int i, ListContext listContext) {
        ListContext listContext2;
        ListStyle numbered;
        ArrayList arrayList = new ArrayList();
        Iterator<? extends HtmlNode> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            HtmlNode next = it.next();
            if ((next instanceof Image) || (next instanceof Table) || (next instanceof HorizontalRule) || (next instanceof CodeBlock)) {
                flushInlineCollector(list2, arrayList, next.getParent(), i);
                if (next instanceof Image) {
                    Image image = (Image) next;
                    list2.add(new ImageObject(image.getSrc(), image.getAlt()));
                } else if (next instanceof Table) {
                    list2.add(convertTableNode((Table) next, i));
                } else if (next instanceof HorizontalRule) {
                    list2.add(new TextBox(HtmlConstants.HORIZONTAL_RULE, new ArrayList(0), null, null, i, false, 44, null));
                } else if (next instanceof CodeBlock) {
                    createCodeBlock((CodeBlock) next, list2);
                }
            } else if (next instanceof Div) {
                flushInlineCollector(list2, arrayList, next.getParent(), i);
                Div div = (Div) next;
                if (div.getClasses().isEmpty() || !Intrinsics.areEqual(div.getClasses().get(0), LATEX_FROM_MD)) {
                    processNodeListWithStyle(next, list2, i, listContext);
                    addLastLineBreak(list2);
                } else {
                    HtmlNode htmlNode = div.getChildren().get(0);
                    Intrinsics.checkNotNull(htmlNode, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.composer.html.logic.TextNode");
                    list2.add(new MathObject(((TextNode) htmlNode).getText(), false, 2, null));
                }
            } else if (next instanceof Pre) {
                flushInlineCollector(list2, arrayList, next.getParent(), i);
                processNodeListWithStyle(next, list2, i, listContext);
                addLastLineBreak(list2);
            } else if (next instanceof Span) {
                Span span = (Span) next;
                if (!span.getClasses().isEmpty() && Intrinsics.areEqual(span.getClasses().get(0), LATEX_FROM_MD) && !span.getChildren().isEmpty() && (span.getChildren().get(0) instanceof TextNode)) {
                    flushInlineCollector(list2, arrayList, next.getParent(), i);
                    HtmlNode htmlNode2 = span.getChildren().get(0);
                    Intrinsics.checkNotNull(htmlNode2, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.composer.html.logic.TextNode");
                    list2.add(new MathObject(((TextNode) htmlNode2).getText(), true));
                    if (Intrinsics.areEqual(CollectionsKt.last((List) list), next)) {
                        list2.add(new TextBox("\n", new ArrayList(), null, null, i, false, 44, null));
                    }
                } else if (!span.getChildren().isEmpty()) {
                    flushInlineCollector(list2, arrayList, next.getParent(), i);
                    processNodeList(span.getChildren(), list2, i, listContext);
                }
            } else if ((next instanceof Paragraph) || (next instanceof Heading) || (next instanceof Article) || (next instanceof Blockquote)) {
                flushInlineCollector(list2, arrayList, next.getParent(), i);
                processNodeListWithStyle(next, list2, next instanceof Blockquote ? i + 1 : i, listContext);
                addLastLineBreak(list2);
            } else if ((next instanceof UnorderedList) || (next instanceof OrderedList)) {
                int size = list2.size();
                flushInlineCollector(list2, arrayList, next.getParent(), i);
                if (size != list2.size() && (next.getParent() instanceof ListItem)) {
                    addLastLineBreak(list2);
                }
                if (next instanceof OrderedList) {
                    OrderedList orderedList = (OrderedList) next;
                    listContext2 = new ListContext(orderedList.getStart(), orderedList.getFixed());
                } else {
                    listContext2 = new ListContext(0, false, 3, null);
                }
                processNodeList(((ParentCapableNode) next).getChildren(), list2, i, listContext2);
            } else if (next instanceof ListItem) {
                flushInlineCollector(list2, arrayList, next.getParent(), i);
                HtmlNode parent = next.getParent();
                if (parent instanceof UnorderedList) {
                    ListItem listItem = (ListItem) next;
                    if (listItem.getChildren().isEmpty() || !(listItem.getChildren().get(0) instanceof Checkbox)) {
                        numbered = ListStyle.BULLET.INSTANCE;
                    } else {
                        HtmlNode htmlNode3 = listItem.getChildren().get(0);
                        Intrinsics.checkNotNull(htmlNode3, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.composer.html.logic.Checkbox");
                        numbered = new ListStyle.CHECKBOX(((Checkbox) htmlNode3).isChecked());
                    }
                } else if (parent instanceof OrderedList) {
                    boolean fixed = listContext.getFixed();
                    listContext.setFixed(false);
                    int counter = listContext.getCounter();
                    listContext.setCounter(counter + 1);
                    numbered = new ListStyle.NUMBERED(counter, fixed);
                } else {
                    numbered = ListStyle.NONE.INSTANCE;
                }
                ListStyle listStyle = numbered;
                ListItem listItem2 = (ListItem) next;
                int wrapCnt = (i + 1) - listItem2.getWrapCnt();
                int size2 = list2.size() > 0 ? list2.size() : 0;
                processNodeList(listItem2.getChildren(), list2, wrapCnt, listContext);
                if (size2 != list2.size()) {
                    int size3 = list2.size();
                    while (size2 < size3) {
                        DocumentElement documentElement = list2.get(size2);
                        if ((documentElement instanceof TextBox) && ((TextBox) documentElement).getIndentLevel() == wrapCnt) {
                            DocumentElement documentElement2 = list2.get(size2);
                            Intrinsics.checkNotNull(documentElement2, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.composer.html.logic.TextBox");
                            list2.set(size2, TextBox.copy$default((TextBox) documentElement2, null, null, null, listStyle, 0, false, 55, null));
                        }
                        size2++;
                    }
                }
            } else {
                arrayList.add(next);
            }
        }
        HtmlNode htmlNode4 = (HtmlNode) CollectionsKt.lastOrNull((List) list);
        flushInlineCollector(list2, arrayList, htmlNode4 != null ? htmlNode4.getParent() : null, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void processNodeListWithStyle(HtmlNode htmlNode, List<DocumentElement> list, int i, ListContext listContext) {
        int size = list.size();
        if (htmlNode instanceof ParentCapableNode) {
            processNodeList(((ParentCapableNode) htmlNode).getChildren(), list, i, listContext);
        }
        int i2 = size + 1;
        if (i2 < list.size()) {
            int size2 = list.size();
            while (i2 < size2) {
                if (list.get(i2) instanceof TextBox) {
                    DocumentElement documentElement = list.get(i2);
                    Intrinsics.checkNotNull(documentElement, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.composer.html.logic.TextBox");
                    TextBox textBox = (TextBox) documentElement;
                    addRootStyle(htmlNode, textBox.getText(), textBox.getSpans());
                }
                i2++;
            }
        }
    }

    private static final List<DocumentElement> splitTextBox(TextBox textBox) {
        if (textBox.getTaskObjects() != null) {
            List<Pair<TaskObject, Integer>> taskObjects = textBox.getTaskObjects();
            Intrinsics.checkNotNull(taskObjects);
            if (!taskObjects.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                List<Pair<TaskObject, Integer>> taskObjects2 = textBox.getTaskObjects();
                Intrinsics.checkNotNull(taskObjects2);
                Iterator<T> it = taskObjects2.iterator();
                TextBox second = textBox;
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    int iIntValue = ((Number) pair.getSecond()).intValue();
                    if (iIntValue != 0) {
                        TextBox textBox2 = second;
                        if (!TextUtils.isEmpty(textBox2.getText())) {
                            if (iIntValue > textBox.getText().length() - 2) {
                                Pair<TextBox, TextBox> pairSplitTextBox = splitTextBox(textBox2, iIntValue);
                                arrayList.add(pairSplitTextBox.getFirst());
                                arrayList.add(pair.getFirst());
                                second = pairSplitTextBox.getSecond();
                                Unit unit = Unit.INSTANCE;
                            } else {
                                Intrinsics.checkNotNullExpressionValue(textBox2.getText().substring(0, iIntValue - 1), "substring(...)");
                                Intrinsics.checkNotNullExpressionValue(textBox2.getText().substring(iIntValue), "substring(...)");
                            }
                        }
                    }
                    arrayList.add(pair.getFirst());
                }
                return arrayList;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(textBox);
        return arrayList2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void traverseAndBuild(HtmlNode htmlNode, StringBuilder sb, List<StyleSpan> list, List<Pair<TaskObject, Integer>> list2) {
        int length = sb.length();
        if (htmlNode instanceof TextNode) {
            sb.append(((TextNode) htmlNode).getText());
            return;
        }
        if (htmlNode instanceof LineBreak) {
            sb.append("\n");
            return;
        }
        if (!(htmlNode instanceof ParentCapableNode)) {
            if (!(htmlNode instanceof Code)) {
                if (htmlNode instanceof Image) {
                    Image image = (Image) htmlNode;
                    list2.add(new Pair<>(new ImageObject(image.getSrc(), image.getAlt()), Integer.valueOf(length)));
                    return;
                }
                return;
            }
            sb.append(((Code) htmlNode).getCode());
            int length2 = sb.length();
            if (length == length2) {
                return;
            }
            list.add(new StyleSpan(SpanType.Code, length, length2, null));
            return;
        }
        Iterator<T> it = ((ParentCapableNode) htmlNode).getChildren().iterator();
        while (it.hasNext()) {
            traverseAndBuild((HtmlNode) it.next(), sb, list, list2);
        }
        int length3 = sb.length();
        if (length == length3) {
            return;
        }
        SpanType spanType = htmlNode instanceof Bold ? SpanType.BOLD : htmlNode instanceof Italic ? SpanType.ITALIC : htmlNode instanceof Underline ? SpanType.UNDERLINE : htmlNode instanceof StrikeThrough ? SpanType.STRIKETHROUGH : htmlNode instanceof Subscript ? SpanType.SUBSCRIPT : htmlNode instanceof Superscript ? SpanType.SUPERSCRIPT : htmlNode instanceof Anchor ? SpanType.HREF : null;
        if (spanType != null) {
            Anchor anchor = htmlNode instanceof Anchor ? (Anchor) htmlNode : null;
            list.add(new StyleSpan(spanType, length, length3, anchor != null ? anchor.getHref() : null));
        }
        if (htmlNode instanceof StyledNode) {
            StyledNode styledNode = (StyledNode) htmlNode;
            String textColor = styledNode.getTextColor();
            if (textColor != null) {
                list.add(new StyleSpan(SpanType.TEXT_COLOR, length, length3, textColor));
            }
            String backgroundColor = styledNode.getBackgroundColor();
            if (backgroundColor != null) {
                list.add(new StyleSpan(SpanType.BACKGROUND_COLOR, length, length3, backgroundColor));
            }
        }
    }

    private static final Pair<TextBox, TextBox> splitTextBox(TextBox textBox, int i) {
        String strSubstring = textBox.getText().substring(0, i - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String strSubstring2 = textBox.getText().substring(i);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (StyleSpan styleSpan : textBox.getSpans()) {
            if (styleSpan.getStart() <= i && styleSpan.getEnd() > i) {
                arrayList.add(new StyleSpan(styleSpan.getType(), styleSpan.getStart(), i, styleSpan.getValue()));
                arrayList2.add(new StyleSpan(styleSpan.getType(), i, styleSpan.getEnd(), styleSpan.getValue()));
            } else {
                arrayList.add(styleSpan);
            }
        }
        return new Pair<>(new TextBox(strSubstring, arrayList, textBox.getAlignment(), textBox.getListStyle(), textBox.getIndentLevel(), textBox.isBlockQuote()), new TextBox(strSubstring2, arrayList2, textBox.getAlignment(), textBox.getListStyle(), textBox.getIndentLevel(), textBox.isBlockQuote()));
    }
}
