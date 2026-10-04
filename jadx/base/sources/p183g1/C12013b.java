package p183g1;

import android.content.Context;
import com.samsung.android.app.notes.sync.synchronization.managers.C6900c;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.model.importer.task.CreateSdocXTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import java.util.concurrent.Executors;
import kotlin.jvm.internal.Intrinsics;
import p042J1.AbstractC0147e;
import p042J1.C0148f;
import p079T.AbstractC0299q;
import p087V0.CallableC0323a;
import p179f1.AbstractC11983c;

/* JADX INFO: renamed from: g1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12013b extends AbstractC11983c {

    /* JADX INFO: renamed from: v */
    public static final String f8766v = "SS$".concat("OSmosisRestoreTask");

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: e */
    public final void mo13546e() {
        String str = f8766v;
        AbstractC0299q.m643n(str, "doInBackground");
        for (int i = 0; i < 100; i++) {
            Context context = BaseUtils.getContext();
            String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(BaseUtils.getApplicationContext(), ".sdocx");
            Intrinsics.checkNotNullExpressionValue(strCreateSavedPath, "createSavedPath(...)");
            CreateSdocXTask createSdocXTask = new CreateSdocXTask(new ImportSdocXParam().setContext(context).setUuid(UUIDUtils.newUUID(context)).setExternalPath(strCreateSavedPath).setIsCoEditNote(false).setCaller(str));
            createSdocXTask.setInjectedCallable(new CallableC0323a(this, createSdocXTask)).setImported(true).setImportTaskListener(new C12012a());
            DataRepositoryScheduler.callable(createSdocXTask).executeOn(Executors.newFixedThreadPool(1, new SenlThreadFactory("saveToDevice"))).observe(new C6900c()).execute();
        }
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: g */
    public final void mo13547g() {
        AbstractC0299q.m643n(f8766v, "onPostExecute");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m356l(100);
        m13551k(0, this.f8558h);
    }

    @Override // p176e1.AbstractC11975a
    /* JADX INFO: renamed from: h */
    public final void mo13548h() {
        AbstractC0299q.m643n(f8766v, "onPreExecute");
        String str = C0148f.f420k;
        AbstractC0147e.f419a.getClass();
        C0148f.m356l(1);
    }
}
