package com.vladsch.flexmark.ext.gfm.tasklist.internal;

import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemCase;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemPlacement;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSetter;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskListFormatOptions implements MutableDataSetter {
    public final int formatDefaultTaskItemPriority;
    public final int formatOrderedTaskItemPriority;
    public final boolean formatPrioritizedTaskItems;
    public final Map<Character, Integer> formatTaskItemPriorities;
    public final TaskListItemCase taskListItemCase;
    public final TaskListItemPlacement taskListItemPlacement;

    public TaskListFormatOptions() {
        this(null);
    }

    @Override // com.vladsch.flexmark.util.data.MutableDataSetter
    @NotNull
    public MutableDataHolder setIn(@NotNull MutableDataHolder mutableDataHolder) {
        mutableDataHolder.set(TaskListExtension.FORMAT_LIST_ITEM_CASE, this.taskListItemCase);
        mutableDataHolder.set(TaskListExtension.FORMAT_LIST_ITEM_PLACEMENT, this.taskListItemPlacement);
        mutableDataHolder.set(TaskListExtension.FORMAT_ORDERED_TASK_ITEM_PRIORITY, Integer.valueOf(this.formatOrderedTaskItemPriority));
        mutableDataHolder.set(TaskListExtension.FORMAT_TASK_ITEM_PRIORITIES, this.formatTaskItemPriorities);
        mutableDataHolder.set(TaskListExtension.FORMAT_PRIORITIZED_TASK_ITEMS, Boolean.valueOf(this.formatPrioritizedTaskItems));
        return mutableDataHolder;
    }

    public TaskListFormatOptions(DataHolder dataHolder) {
        this.taskListItemCase = TaskListExtension.FORMAT_LIST_ITEM_CASE.get(dataHolder);
        this.taskListItemPlacement = TaskListExtension.FORMAT_LIST_ITEM_PLACEMENT.get(dataHolder);
        this.formatOrderedTaskItemPriority = TaskListExtension.FORMAT_ORDERED_TASK_ITEM_PRIORITY.get(dataHolder).intValue();
        this.formatDefaultTaskItemPriority = TaskListExtension.FORMAT_DEFAULT_TASK_ITEM_PRIORITY.get(dataHolder).intValue();
        this.formatTaskItemPriorities = TaskListExtension.FORMAT_TASK_ITEM_PRIORITIES.get(dataHolder);
        this.formatPrioritizedTaskItems = TaskListExtension.FORMAT_PRIORITIZED_TASK_ITEMS.get(dataHolder).booleanValue();
    }
}
