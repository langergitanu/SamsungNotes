package com.vladsch.flexmark.ext.gfm.tasklist;

import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListItemBlockPreProcessor;
import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeRenderer;
import com.vladsch.flexmark.formatter.Formatter;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.DataKey;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskListExtension implements Parser.ParserExtension, HtmlRenderer.HtmlRendererExtension, Formatter.FormatterExtension {
    public static final Map<Character, Integer> DEFAULT_PRIORITIES;
    public static final DataKey<Integer> FORMAT_DEFAULT_TASK_ITEM_PRIORITY;
    public static final DataKey<TaskListItemCase> FORMAT_LIST_ITEM_CASE;
    public static final DataKey<TaskListItemPlacement> FORMAT_LIST_ITEM_PLACEMENT;
    public static final DataKey<Integer> FORMAT_ORDERED_TASK_ITEM_PRIORITY;
    public static final DataKey<Boolean> FORMAT_PRIORITIZED_TASK_ITEMS;
    public static final DataKey<Map<Character, Integer>> FORMAT_TASK_ITEM_PRIORITIES;
    public static final DataKey<String> ITEM_DONE_CLASS;
    public static final DataKey<String> ITEM_DONE_MARKER;
    public static final DataKey<String> ITEM_NOT_DONE_CLASS;
    public static final DataKey<String> ITEM_NOT_DONE_MARKER;
    public static final DataKey<String> LOOSE_ITEM_CLASS;
    public static final DataKey<String> PARAGRAPH_CLASS;
    public static final DataKey<String> TIGHT_ITEM_CLASS;

    static {
        HashMap map = new HashMap();
        DEFAULT_PRIORITIES = map;
        map.put('+', 1);
        map.put('*', 0);
        map.put('-', -1);
        ITEM_DONE_MARKER = new DataKey<>("ITEM_DONE_MARKER", "<input type=\"checkbox\" class=\"task-list-item-checkbox\" checked=\"checked\" disabled=\"disabled\" readonly=\"readonly\" />&nbsp;");
        ITEM_NOT_DONE_MARKER = new DataKey<>("ITEM_NOT_DONE_MARKER", "<input type=\"checkbox\" class=\"task-list-item-checkbox\" disabled=\"disabled\" readonly=\"readonly\" />&nbsp;");
        DataKey<String> dataKey = new DataKey<>("TIGHT_ITEM_CLASS", "task-list-item");
        TIGHT_ITEM_CLASS = dataKey;
        LOOSE_ITEM_CLASS = new DataKey<>("LOOSE_ITEM_CLASS", (DataKey) dataKey);
        PARAGRAPH_CLASS = new DataKey<>("PARAGRAPH_CLASS", "");
        ITEM_DONE_CLASS = new DataKey<>("ITEM_DONE_CLASS", "");
        ITEM_NOT_DONE_CLASS = new DataKey<>("ITEM_NOT_DONE_CLASS", "");
        FORMAT_LIST_ITEM_CASE = new DataKey<>("FORMAT_LIST_ITEM_CASE", TaskListItemCase.AS_IS);
        FORMAT_LIST_ITEM_PLACEMENT = new DataKey<>("FORMAT_LIST_ITEM_PLACEMENT", TaskListItemPlacement.AS_IS);
        FORMAT_ORDERED_TASK_ITEM_PRIORITY = new DataKey<>("FORMAT_ORDERED_TASK_ITEM_PRIORITY", 0);
        FORMAT_DEFAULT_TASK_ITEM_PRIORITY = new DataKey<>("FORMAT_DEFAULT_TASK_ITEM_PRIORITY", 0);
        FORMAT_PRIORITIZED_TASK_ITEMS = new DataKey<>("FORMAT_PRIORITIZED_TASK_ITEMS", Boolean.FALSE);
        FORMAT_TASK_ITEM_PRIORITIES = new DataKey<>("FORMAT_TASK_ITEM_PRIORITIES", map);
    }

    private TaskListExtension() {
    }

    public static TaskListExtension create() {
        return new TaskListExtension();
    }

    @Override // com.vladsch.flexmark.formatter.Formatter.FormatterExtension
    public void extend(Formatter.Builder builder) {
        builder.nodeFormatterFactory(new C11786a());
    }

    @Override // com.vladsch.flexmark.parser.Parser.ParserExtension
    public void parserOptions(MutableDataHolder mutableDataHolder) {
        ListOptions.addItemMarkerSuffixes(mutableDataHolder, "[ ]", "[x]", "[X]");
    }

    @Override // com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension
    public void rendererOptions(@NotNull MutableDataHolder mutableDataHolder) {
    }

    @Override // com.vladsch.flexmark.parser.Parser.ParserExtension
    public void extend(Parser.Builder builder) {
        builder.blockPreProcessorFactory(new TaskListItemBlockPreProcessor.Factory());
    }

    @Override // com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension
    public void extend(@NotNull HtmlRenderer.Builder builder, @NotNull String str) {
        if (builder.isRendererType("HTML")) {
            builder.nodeRendererFactory(new TaskListNodeRenderer.Factory());
        } else {
            builder.isRendererType("JIRA");
        }
    }
}
