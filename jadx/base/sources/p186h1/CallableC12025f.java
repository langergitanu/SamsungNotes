package p186h1;

import android.content.Context;
import android.os.Process;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import p069Q0.C0209d;

/* JADX INFO: renamed from: h1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class CallableC12025f implements Callable {
    @Override // java.util.concurrent.Callable
    public final Object call() {
        Process.setThreadPriority(AbstractC12027h.f8779b);
        Context context = AbstractC12027h.f8789l;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        Intrinsics.checkNotNullExpressionValue(NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository(), "createDocumentDataRepository(...)");
        String str = C0209d.f640d;
        return Long.valueOf(r0.getNotesForBackupExceptGenAi().size());
    }
}
