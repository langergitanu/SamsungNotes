package com.vladsch.flexmark.ext.gfm.tasklist.internal;

import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;

/* JADX INFO: renamed from: com.vladsch.flexmark.ext.gfm.tasklist.internal.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC11789b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8298a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TaskListNodeRenderer f8299b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ HtmlWriter f8300c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ TaskListItem f8301d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ NodeRendererContext f8302e;

    public /* synthetic */ RunnableC11789b(TaskListNodeRenderer taskListNodeRenderer, HtmlWriter htmlWriter, TaskListItem taskListItem, NodeRendererContext nodeRendererContext, int i) {
        this.f8298a = i;
        this.f8299b = taskListNodeRenderer;
        this.f8300c = htmlWriter;
        this.f8301d = taskListItem;
        this.f8302e = nodeRendererContext;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8298a) {
            case 0:
                this.f8299b.lambda$render$1(this.f8300c, this.f8301d, this.f8302e);
                break;
            default:
                this.f8299b.lambda$render$0(this.f8300c, this.f8301d, this.f8302e);
                break;
        }
    }
}
