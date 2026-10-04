package com.vladsch.flexmark.ext.gfm.tasklist.internal;

import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabNodeFormatter;
import com.vladsch.flexmark.formatter.MarkdownWriter;
import com.vladsch.flexmark.formatter.NodeFormatter;
import com.vladsch.flexmark.formatter.NodeFormatterContext;
import com.vladsch.flexmark.formatter.NodeFormattingHandler;
import com.vladsch.flexmark.util.ast.Node;

/* JADX INFO: renamed from: com.vladsch.flexmark.ext.gfm.tasklist.internal.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11788a implements NodeFormattingHandler.CustomNodeFormatter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8296a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NodeFormatter f8297b;

    public /* synthetic */ C11788a(NodeFormatter nodeFormatter, int i) {
        this.f8296a = i;
        this.f8297b = nodeFormatter;
    }

    @Override // com.vladsch.flexmark.formatter.NodeFormattingHandler.CustomNodeFormatter
    public final void render(Node node, NodeFormatterContext nodeFormatterContext, MarkdownWriter markdownWriter) {
        switch (this.f8296a) {
            case 0:
                ((TaskListNodeFormatter) this.f8297b).render((TaskListItem) node, nodeFormatterContext, markdownWriter);
                break;
            case 1:
                ((TaskListNodeFormatter) this.f8297b).render((BulletList) node, nodeFormatterContext, markdownWriter);
                break;
            case 2:
                ((TaskListNodeFormatter) this.f8297b).render((OrderedList) node, nodeFormatterContext, markdownWriter);
                break;
            default:
                ((GitLabNodeFormatter) this.f8297b).render((GitLabBlockQuote) node, nodeFormatterContext, markdownWriter);
                break;
        }
    }
}
