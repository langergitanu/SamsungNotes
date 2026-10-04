package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model;

import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.widget.EdgeEffect;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.google.common.util.concurrent.ListenableFuture;
import com.samsung.android.sdk.pen.engine.edgeEffect.SpenStretchEdgeEffect;
import com.samsung.android.support.senl.p148nt.base.common.jobscheduler.INoteJob;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.NotesDocEntityManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.control.sip.ClipboardController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task.PwTaskConvertToNote;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.ReadyStateCollectExecutor;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenWordDocRepository;
import com.samsung.android.support.senl.p148nt.model.restore.document.DuplicatedDatabaseDetector;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import com.vladsch.flexmark.ast.BlockQuote;
import com.vladsch.flexmark.ast.BulletList;
import com.vladsch.flexmark.ast.Heading;
import com.vladsch.flexmark.ast.OrderedList;
import com.vladsch.flexmark.ast.Paragraph;
import com.vladsch.flexmark.ext.gitlab.GitLabBlockQuote;
import com.vladsch.flexmark.ext.gitlab.GitLabDel;
import com.vladsch.flexmark.ext.gitlab.GitLabIns;
import com.vladsch.flexmark.ext.tables.TableBlock;
import com.vladsch.flexmark.ext.tables.TableBody;
import com.vladsch.flexmark.ext.tables.TableCaption;
import com.vladsch.flexmark.ext.tables.TableHead;
import com.vladsch.flexmark.ext.tables.TableRow;
import com.vladsch.flexmark.html.HtmlWriter;
import com.vladsch.flexmark.html.renderer.NodeRendererContext;
import com.yubico.yubikit.android.p170ui.YubiKeyPromptActivity;
import com.yubico.yubikit.android.transport.nfc.NfcYubiKeyDevice;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.pdfwriter.model.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10960a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7342a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7343b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7344c;

    public /* synthetic */ RunnableC10960a(Object obj, Object obj2, int i) {
        this.f7342a = i;
        this.f7343b = obj;
        this.f7344c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7342a) {
            case 0:
                PwFileManager.lambda$deleteCacheFile$4((File) this.f7343b, (String) this.f7344c);
                break;
            case 1:
                ((PwTaskConvertToNote) this.f7343b).lambda$executeTask$1((PwTaskConvertToNote.InputValues) this.f7344c);
                break;
            case 2:
                ((ReadyStateCollectExecutor) this.f7343b).lambda$execute$1((INoteJob.INoteJobFinishCallback) this.f7344c);
                break;
            case 3:
                ((SpenWordDocRepository) this.f7343b).lambda$createLoadDatabaseRunnable$0((Context) this.f7344c);
                break;
            case 4:
                ((DuplicatedDatabaseDetector) this.f7343b).lambda$deleteDuplicated$0((ArrayList) this.f7344c);
                break;
            case 5:
                DocumentWriteResolver.lambda$deleteRelatedNoteDbEntries$0((NotesDataRepositoryFactory) this.f7343b, (List) this.f7344c);
                break;
            case 6:
                ((NodeRendererContext) this.f7343b).renderChildren((GitLabIns) this.f7344c);
                break;
            case 7:
                ((NodeRendererContext) this.f7343b).renderChildren((GitLabDel) this.f7344c);
                break;
            case 8:
                ((NodeRendererContext) this.f7343b).renderChildren((GitLabBlockQuote) this.f7344c);
                break;
            case 9:
                ((NodeRendererContext) this.f7343b).renderChildren((TableHead) this.f7344c);
                break;
            case 10:
                ((NodeRendererContext) this.f7343b).renderChildren((TableBody) this.f7344c);
                break;
            case 11:
                ((NodeRendererContext) this.f7343b).renderChildren((TableRow) this.f7344c);
                break;
            case 12:
                ((NodeRendererContext) this.f7343b).renderChildren((TableCaption) this.f7344c);
                break;
            case 13:
                ((NodeRendererContext) this.f7343b).renderChildren((TableBlock) this.f7344c);
                break;
            case 14:
                ((NodeRendererContext) this.f7343b).renderChildren((OrderedList) this.f7344c);
                break;
            case 15:
                ((NodeRendererContext) this.f7343b).renderChildren((Paragraph) this.f7344c);
                break;
            case 16:
                ((HtmlWriter) this.f7343b).text((CharSequence) ((String) this.f7344c));
                break;
            case 17:
                ((NodeRendererContext) this.f7343b).renderChildren((BulletList) this.f7344c);
                break;
            case 18:
                ((NodeRendererContext) this.f7343b).renderChildren((BlockQuote) this.f7344c);
                break;
            case 19:
                ((NodeRendererContext) this.f7343b).renderChildren((Heading) this.f7344c);
                break;
            case 20:
                ((NfcYubiKeyDevice) this.f7343b).lambda$remove$0((Runnable) this.f7344c);
                break;
            case 21:
                ((YubiKeyPromptActivity) this.f7343b).lambda$onResume$9((NfcYubiKeyDevice) this.f7344c);
                break;
            case 22:
                FragmentStrictMode.handlePolicyViolation$lambda$0((FragmentStrictMode.Policy) this.f7343b, (Violation) this.f7344c);
                break;
            case 23:
                FragmentStrictMode.handlePolicyViolation$lambda$1((String) this.f7344c, (Violation) this.f7343b);
                break;
            case 24:
                SpenStretchEdgeEffect.onPull$lambda$3$lambda$2((EdgeEffect) this.f7343b, (SpenStretchEdgeEffect) this.f7344c);
                break;
            case 25:
                ((NotesDocEntityManager) this.f7343b).lambda$setOpenedTime$0((String) this.f7344c);
                break;
            case 26:
                ((io.opentelemetry.context.Context) this.f7343b).lambda$wrap$1((Runnable) this.f7344c);
                break;
            case 27:
                ClipboardController.setClipboardFilter$lambda$1$lambda$0((ClipboardController) this.f7343b, (ClipData) this.f7344c);
                break;
            case 28:
                ConstraintTrackingWorker.setupAndRunConstraintTrackingWork$lambda$3((ConstraintTrackingWorker) this.f7343b, (ListenableFuture) this.f7344c);
                break;
            default:
                ((RtToolbarPresenter) this.f7343b).lambda$showAiMenu$2((View) this.f7344c);
                break;
        }
    }

    public /* synthetic */ RunnableC10960a(String str, Violation violation) {
        this.f7342a = 23;
        this.f7344c = str;
        this.f7343b = violation;
    }
}
