package com.vladsch.flexmark.ext.gfm.tasklist.internal;

import androidx.work.impl.RunnableC4054d;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.AttributablePart;
import com.vladsch.flexmark.html.renderer.CoreNodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRendererFactory;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.parser.ListOptions;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.html.Attribute;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.HashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import p242t4.C14468a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class TaskListNodeRenderer implements NodeRenderer {
    public static final AttributablePart TASK_ITEM_PARAGRAPH = new AttributablePart("TASK_ITEM_PARAGRAPH");
    final String doneMarker;
    private final String itemDoneClass;
    private final String itemNotDoneClass;
    private final ListOptions listOptions;
    private final String looseItemClass;
    final String notDoneMarker;
    final String paragraphClass;
    private final String tightItemClass;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Factory implements NodeRendererFactory {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.vladsch.flexmark.html.renderer.NodeRendererFactory, java.util.function.Function
        @NotNull
        public NodeRenderer apply(@NotNull DataHolder dataHolder) {
            return new TaskListNodeRenderer(dataHolder);
        }
    }

    public TaskListNodeRenderer(DataHolder dataHolder) {
        this.doneMarker = TaskListExtension.ITEM_DONE_MARKER.get(dataHolder);
        this.notDoneMarker = TaskListExtension.ITEM_NOT_DONE_MARKER.get(dataHolder);
        this.tightItemClass = TaskListExtension.TIGHT_ITEM_CLASS.get(dataHolder);
        this.looseItemClass = TaskListExtension.LOOSE_ITEM_CLASS.get(dataHolder);
        this.itemDoneClass = TaskListExtension.ITEM_DONE_CLASS.get(dataHolder);
        this.itemNotDoneClass = TaskListExtension.ITEM_NOT_DONE_CLASS.get(dataHolder);
        this.paragraphClass = TaskListExtension.PARAGRAPH_CLASS.get(dataHolder);
        this.listOptions = ListOptions.get(dataHolder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$0(HtmlWriter htmlWriter, TaskListItem taskListItem, NodeRendererContext nodeRendererContext) {
        htmlWriter.raw((CharSequence) (taskListItem.isItemDoneMarker() ? this.doneMarker : this.notDoneMarker));
        nodeRendererContext.renderChildren(taskListItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$1(HtmlWriter htmlWriter, TaskListItem taskListItem, NodeRendererContext nodeRendererContext) {
        htmlWriter.raw((CharSequence) (taskListItem.isItemDoneMarker() ? this.doneMarker : this.notDoneMarker));
        nodeRendererContext.renderChildren(taskListItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$render$2(HtmlWriter htmlWriter, BasedSequence basedSequence, TaskListItem taskListItem, NodeRendererContext nodeRendererContext) {
        if (!this.paragraphClass.isEmpty()) {
            htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) this.paragraphClass);
        }
        htmlWriter.srcPos(basedSequence.getStartOffset(), basedSequence.getEndOffset()).withAttr(TASK_ITEM_PARAGRAPH).tagLine("p", (Runnable) new RunnableC11789b(this, htmlWriter, taskListItem, nodeRendererContext, 0));
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderer
    public Set<NodeRenderingHandler<?>> getNodeRenderingHandlers() {
        HashSet hashSet = new HashSet();
        hashSet.add(new NodeRenderingHandler(TaskListItem.class, new C14468a(this, 2)));
        return hashSet;
    }

    public void render(TaskListItem taskListItem, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        BasedSequence chars = (nodeRendererContext.getHtmlOptions().sourcePositionParagraphLines || taskListItem.getFirstChild() == null) ? taskListItem.getChars() : taskListItem.getFirstChild().getChars();
        String str = taskListItem.isItemDoneMarker() ? this.itemDoneClass : this.itemNotDoneClass;
        if (this.listOptions.isTightListItem(taskListItem)) {
            if (!this.tightItemClass.isEmpty()) {
                htmlWriter.attr(Attribute.CLASS_ATTR, this.tightItemClass);
            }
            if (!str.isEmpty() && !str.equals(this.tightItemClass)) {
                htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) str);
            }
            htmlWriter.srcPos(chars.getStartOffset(), chars.getEndOffset()).withAttr(CoreNodeRenderer.TIGHT_LIST_ITEM).withCondIndent().tagLine((CharSequence) "li", (Runnable) new RunnableC11789b(this, htmlWriter, taskListItem, nodeRendererContext, 1));
            return;
        }
        if (!this.looseItemClass.isEmpty()) {
            htmlWriter.attr(Attribute.CLASS_ATTR, this.looseItemClass);
        }
        if (!str.isEmpty() && !str.equals(this.looseItemClass)) {
            htmlWriter.attr(Attribute.CLASS_ATTR, (CharSequence) str);
        }
        htmlWriter.withAttr(CoreNodeRenderer.LOOSE_LIST_ITEM).tagIndent("li", new RunnableC4054d(this, htmlWriter, chars, taskListItem, nodeRendererContext, 6));
    }
}
