package androidx.work.impl;

import android.app.Activity;
import android.graphics.RectF;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.work.WorkRequest;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter.AiDrawingManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.AiMenuResultViewSTT;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub.ServiceContractImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskWebClip;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.model.document.save.WDocSaveOperation;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItem;
import com.vladsch.flexmark.ext.gfm.tasklist.internal.TaskListNodeRenderer;
import com.vladsch.flexmark.ext.gitlab.internal.GitLabNodeRenderer;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.work.impl.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC4054d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1737a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1738b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1739c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1740d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f1741e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f1742f;

    public /* synthetic */ RunnableC4054d(ServiceContractImpl serviceContractImpl, ComposerModel composerModel, String str, String str2, Activity activity) {
        this.f1737a = 3;
        this.f1739c = serviceContractImpl;
        this.f1740d = composerModel;
        this.f1738b = str;
        this.f1741e = str2;
        this.f1742f = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1737a) {
            case 0:
                WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$4((WorkManagerImpl) this.f1739c, (String) this.f1738b, (OperationImpl) this.f1740d, (Function0) this.f1741e, (WorkRequest) this.f1742f);
                break;
            case 1:
                ((AiDrawingManager) this.f1739c).lambda$handleSelectionPositionUpdate$7((String) this.f1738b, (ArrayList) this.f1740d, (RectF) this.f1741e, (Runnable) this.f1742f);
                break;
            case 2:
                ((AiMenuResultViewSTT) this.f1739c).lambda$toggleModeBottomMenu$25((TextView) this.f1738b, (TextView) this.f1740d, (TextView) this.f1741e, (ViewGroup) this.f1742f);
                break;
            case 3:
                ((ServiceContractImpl) this.f1739c).lambda$restoreNoteSaveFailed$0((ComposerModel) this.f1740d, (String) this.f1738b, (String) this.f1741e, (Activity) this.f1742f);
                break;
            case 4:
                ((TaskWebClip) this.f1739c).lambda$addPdf$6((TaskWebClip.InputValues) this.f1738b, (List) this.f1740d, (List) this.f1741e, (boolean[]) this.f1742f);
                break;
            case 5:
                ((WDocSaveOperation) this.f1739c).lambda$setDocumentContentEntity$0((NotesDocumentEntity) this.f1738b, (ArrayList) this.f1740d, (ArrayList) this.f1741e, (List) this.f1742f);
                break;
            case 6:
                ((TaskListNodeRenderer) this.f1739c).lambda$render$2((HtmlWriter) this.f1738b, (BasedSequence) this.f1740d, (TaskListItem) this.f1741e, (NodeRendererContext) this.f1742f);
                break;
            default:
                ((GitLabNodeRenderer) this.f1739c).lambda$renderVideoImage$3((HtmlWriter) this.f1740d, (Node) this.f1741e, (String) this.f1738b, (String) this.f1742f);
                break;
        }
    }

    public /* synthetic */ RunnableC4054d(GitLabNodeRenderer gitLabNodeRenderer, HtmlWriter htmlWriter, Node node, String str, String str2) {
        this.f1737a = 7;
        this.f1739c = gitLabNodeRenderer;
        this.f1740d = htmlWriter;
        this.f1741e = node;
        this.f1738b = str;
        this.f1742f = str2;
    }

    public /* synthetic */ RunnableC4054d(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i) {
        this.f1737a = i;
        this.f1739c = obj;
        this.f1738b = obj2;
        this.f1740d = obj3;
        this.f1741e = obj4;
        this.f1742f = obj5;
    }
}
