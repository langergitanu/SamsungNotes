package p183g1;

import android.util.Pair;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask;
import kotlin.jvm.internal.Intrinsics;
import p079T.AbstractC0299q;

/* JADX INFO: renamed from: g1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12012a extends ImportTask.ListerImpl {
    @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onFail(String uuid, String path, int i, String str) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(path, "path");
        AbstractC0299q.m643n(C12013b.f8766v, "restoreDoc CreateSdocXTask, onFail " + i);
    }

    @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
    public final void onSuccess(String srcPath, String destUuid, String destPath, Pair pair) {
        Intrinsics.checkNotNullParameter(srcPath, "srcPath");
        Intrinsics.checkNotNullParameter(destUuid, "destUuid");
        Intrinsics.checkNotNullParameter(destPath, "destPath");
        AbstractC0299q.m643n(C12013b.f8766v, "restoreDoc CreateSdocXTask, onSuccess");
    }
}
