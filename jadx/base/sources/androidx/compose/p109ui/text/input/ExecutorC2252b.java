package androidx.compose.p109ui.text.input;

import android.view.Choreographer;
import io.opentelemetry.context.Context;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: androidx.compose.ui.text.input.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ExecutorC2252b implements Executor {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1202a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1203b;

    public /* synthetic */ ExecutorC2252b(Object obj, int i) {
        this.f1202a = i;
        this.f1203b = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f1202a) {
            case 0:
                TextInputServiceAndroid_androidKt.asExecutor$lambda$2((Choreographer) this.f1203b, runnable);
                break;
            default:
                Context.lambda$taskWrapping$0((Executor) this.f1203b, runnable);
                break;
        }
    }
}
