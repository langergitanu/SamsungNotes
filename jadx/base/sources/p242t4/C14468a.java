package p242t4;

import com.vladsch.flexmark.ext.gfm.strikethrough.Strikethrough;
import com.vladsch.flexmark.ext.gfm.strikethrough.Subscript;
import com.vladsch.flexmark.ext.gfm.strikethrough.internal.StrikethroughJiraRenderer;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeRenderer;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRenderer;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.html.renderer.NodeRenderingHandler;
import com.vladsch.flexmark.util.ast.Node;

/* JADX INFO: renamed from: t4.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C14468a implements NodeRenderingHandler.CustomNodeRenderer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f10268a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NodeRenderer f10269b;

    public /* synthetic */ C14468a(NodeRenderer nodeRenderer, int i) {
        this.f10268a = i;
        this.f10269b = nodeRenderer;
    }

    @Override // com.vladsch.flexmark.html.renderer.NodeRenderingHandler.CustomNodeRenderer
    public final void render(Node node, NodeRendererContext nodeRendererContext, HtmlWriter htmlWriter) {
        switch (this.f10268a) {
            case 0:
                ((StrikethroughJiraRenderer) this.f10269b).render((Strikethrough) node, nodeRendererContext, htmlWriter);
                break;
            case 1:
                ((StrikethroughJiraRenderer) this.f10269b).render((Subscript) node, nodeRendererContext, htmlWriter);
                break;
            default:
                ((TaskListNodeRenderer) this.f10269b).render((TaskListItem) node, nodeRendererContext, htmlWriter);
                break;
        }
    }
}
