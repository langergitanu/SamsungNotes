package com.vladsch.flexmark.ext.gfm.tasklist.internal;

import androidx.appcompat.widget.AbstractC0541b;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.ListBlock;
import com.vladsch.flexmark.ast.ListItem;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemCase;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemPlacement;
import com.vladsch.flexmark.formatter.FormatterUtils;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeFormattingHandler;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.ast.BlankLine;
import com.vladsch.flexmark.util.ast.Block;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.Nullable;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskListNodeFormatter implements NodeFormatter {
    private final ListOptions listOptions;
    private final TaskListFormatOptions taskListFormatOptions;

    /* JADX INFO: renamed from: com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeFormatter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C117871 {

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$ext$gfm$tasklist$TaskListItemCase */
        static final /* synthetic */ int[] f8294x9c41e978;

        /* JADX INFO: renamed from: $SwitchMap$com$vladsch$flexmark$ext$gfm$tasklist$TaskListItemPlacement */
        static final /* synthetic */ int[] f8295x929c519d;

        static {
            int[] iArr = new int[TaskListItemPlacement.values().length];
            f8295x929c519d = iArr;
            try {
                iArr[TaskListItemPlacement.AS_IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8295x929c519d[TaskListItemPlacement.INCOMPLETE_FIRST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8295x929c519d[TaskListItemPlacement.INCOMPLETE_NESTED_FIRST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8295x929c519d[TaskListItemPlacement.COMPLETE_TO_NON_TASK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8295x929c519d[TaskListItemPlacement.COMPLETE_NESTED_TO_NON_TASK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[TaskListItemCase.values().length];
            f8294x9c41e978 = iArr2;
            try {
                iArr2[TaskListItemCase.AS_IS.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8294x9c41e978[TaskListItemCase.LOWERCASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8294x9c41e978[TaskListItemCase.UPPERCASE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public TaskListNodeFormatter(DataHolder dataHolder) {
        this.taskListFormatOptions = new TaskListFormatOptions(dataHolder);
        this.listOptions = ListOptions.get(dataHolder);
    }

    public static boolean hasIncompleteDescendants(Node node) {
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if ((firstChild instanceof TaskListItem) && !((TaskListItem) firstChild).isItemDoneMarker()) {
                return true;
            }
            if ((firstChild instanceof Block) && !(firstChild instanceof Paragraph) && hasIncompleteDescendants(firstChild)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$renderList$0(ListItem listItem, ListItem listItem2) {
        return Integer.compare(listItem2.getPriority(), listItem.getPriority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(TaskListItem taskListItem, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        int i;
        if (nodeFormatterContext.isTransformingText()) {
            FormatterUtils.renderListItem(taskListItem, nodeFormatterContext, markdownWriter, this.listOptions, taskListItem.getMarkerSuffix(), false);
            return;
        }
        BasedSequence markerSuffix = taskListItem.getMarkerSuffix();
        int i2 = C117871.f8294x9c41e978[this.taskListFormatOptions.taskListItemCase.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                markerSuffix = markerSuffix.toLowerCase();
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException(AbstractC0541b.m772n("Missing case for TaskListItemCase ", this.taskListFormatOptions.taskListItemCase.name()));
                }
                markerSuffix = markerSuffix.toUpperCase();
            }
        }
        if (taskListItem.isItemDoneMarker() && (i = C117871.f8295x929c519d[this.taskListFormatOptions.taskListItemPlacement.ordinal()]) != 1 && i != 2 && i != 3) {
            if (i != 4 && i != 5) {
                throw new IllegalStateException(AbstractC0541b.m772n("Missing case for ListItemPlacement ", this.taskListFormatOptions.taskListItemPlacement.name()));
            }
            markerSuffix = markerSuffix.getEmptySuffix();
        }
        boolean z = false;
        if (markerSuffix.isNotEmpty() && this.taskListFormatOptions.formatPrioritizedTaskItems) {
            taskListItem.setCanChangeMarker(false);
        }
        if (taskListItem.isLoose() && taskListItem.hasChildren() && taskListItem.getFirstChildAnyNot(BlankLine.class) != null) {
            z = true;
        }
        ListOptions listOptions = this.listOptions;
        if (!markerSuffix.isEmpty()) {
            markerSuffix = markerSuffix.getBuilder().append((CharSequence) markerSuffix).append((CharSequence) " ").append((CharSequence) markerSuffix.baseSubSequence(markerSuffix.getEndOffset() + 1, markerSuffix.getEndOffset() + 1)).toSequence();
        }
        FormatterUtils.renderListItem(taskListItem, nodeFormatterContext, markdownWriter, listOptions, markerSuffix, z);
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<Class<?>> getNodeClasses() {
        return null;
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormatter
    @Nullable
    public Set<NodeFormattingHandler<?>> getNodeFormattingHandlers() {
        return new HashSet(Arrays.asList(new NodeFormattingHandler(TaskListItem.class, new C11788a(this, 0)), new NodeFormattingHandler(BulletList.class, new C11788a(this, 1)), new NodeFormattingHandler(OrderedList.class, new C11788a(this, 2))));
    }

    public int itemPriority(Node node) {
        int iMax = Integer.MIN_VALUE;
        if ((node instanceof TaskListItem) && !((TaskListItem) node).isItemDoneMarker()) {
            iMax = Math.max(Integer.MIN_VALUE, taskItemPriority(node));
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
            if ((firstChild instanceof TaskListItem) && !((TaskListItem) firstChild).isItemDoneMarker()) {
                iMax = Math.max(iMax, taskItemPriority(firstChild));
            }
            if ((firstChild instanceof Block) && !(firstChild instanceof Paragraph)) {
                iMax = Math.max(iMax, itemPriority(firstChild));
            }
        }
        return iMax;
    }

    public void renderList(ListBlock listBlock, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        if (nodeFormatterContext.isTransformingText()) {
            nodeFormatterContext.renderChildren(listBlock);
            return;
        }
        ArrayList arrayList = new ArrayList();
        TaskListItemPlacement taskListItemPlacement = this.taskListFormatOptions.taskListItemPlacement;
        if (taskListItemPlacement != TaskListItemPlacement.AS_IS) {
            ArrayList<ListItem> arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            boolean z = taskListItemPlacement == TaskListItemPlacement.INCOMPLETE_NESTED_FIRST || taskListItemPlacement == TaskListItemPlacement.COMPLETE_NESTED_TO_NON_TASK;
            for (Node firstChild = listBlock.getFirstChild(); firstChild != null; firstChild = firstChild.getNext()) {
                if (firstChild instanceof TaskListItem) {
                    if (!((TaskListItem) firstChild).isItemDoneMarker() || (z && hasIncompleteDescendants(firstChild))) {
                        arrayList2.add((ListItem) firstChild);
                    } else {
                        arrayList3.add((ListItem) firstChild);
                    }
                } else if (firstChild instanceof ListItem) {
                    if (z && hasIncompleteDescendants(firstChild)) {
                        arrayList2.add((ListItem) firstChild);
                    } else {
                        arrayList3.add((ListItem) firstChild);
                    }
                }
            }
            if (this.taskListFormatOptions.formatPrioritizedTaskItems) {
                for (ListItem listItem : arrayList2) {
                    listItem.setPriority(itemPriority(listItem));
                }
                arrayList2.sort(new C0016a(15));
                arrayList.addAll(arrayList2);
            } else {
                arrayList.addAll(arrayList2);
            }
            arrayList.addAll(arrayList3);
        } else {
            for (Node firstChild2 = listBlock.getFirstChild(); firstChild2 != null; firstChild2 = firstChild2.getNext()) {
                arrayList.add(firstChild2);
            }
        }
        FormatterUtils.renderList(listBlock, nodeFormatterContext, markdownWriter, arrayList);
    }

    public int taskItemPriority(Node node) {
        if (!(node instanceof TaskListItem)) {
            return Integer.MIN_VALUE;
        }
        if (((TaskListItem) node).isOrderedItem()) {
            return this.taskListFormatOptions.formatOrderedTaskItemPriority;
        }
        BasedSequence openingMarker = ((ListItem) node).getOpeningMarker();
        if (openingMarker.length() <= 0) {
            return Integer.MIN_VALUE;
        }
        Integer num = this.taskListFormatOptions.formatTaskItemPriorities.get(Character.valueOf(openingMarker.charAt(0)));
        return num != null ? num.intValue() : this.taskListFormatOptions.formatDefaultTaskItemPriority;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(BulletList bulletList, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        renderList(bulletList, nodeFormatterContext, markdownWriter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void render(OrderedList orderedList, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        renderList(orderedList, nodeFormatterContext, markdownWriter);
    }
}
