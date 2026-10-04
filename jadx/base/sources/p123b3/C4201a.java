package p123b3;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.app.notes.widget.WidgetListProvider;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p148nt.app.common.util.WidgetInsetUtils;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolContainer;
import com.samsung.android.support.senl.p148nt.word.base.FileInsertHelper;
import java.io.File;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.android.HandlerContext;
import kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1;
import kotlinx.coroutines.future.FutureKt;

/* JADX INFO: renamed from: b3.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C4201a implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1828a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1829b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1830c;

    public /* synthetic */ C4201a(Object obj, Object obj2, int i) {
        this.f1828a = i;
        this.f1829b = obj;
        this.f1830c = obj2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f1828a) {
            case 0:
                return SCSOperator.identifyLanguageOnThread$lambda$2((CountDownLatch) this.f1829b, (Ref.ObjectRef) this.f1830c, (Task) obj);
            case 1:
                return WidgetListProvider.startNotePicker$lambda$1((Context) this.f1829b, (Intent) this.f1830c, (Display) obj);
            case 2:
                return WidgetInsetUtils.applyWindowInsetsForMs$lambda$9((Window) this.f1829b, (View) this.f1830c, (WindowInsetsCompat) obj);
            case 3:
                return QuickToolContainer.moveOutDocking$lambda$2((QuickToolContainer) this.f1829b, (Function1) this.f1830c, (Animation) obj);
            case 4:
                return FileInsertHelper.insertBackground$lambda$7((FileInsertHelper) this.f1829b, (File) this.f1830c, (Map.Entry) obj);
            case 5:
                return Boolean.valueOf(SequencesKt___SequencesKt.C132271.iterator$lambda$0((Ref.BooleanRef) this.f1829b, this.f1830c, obj));
            case 6:
                return HandlerContext.scheduleResumeAfterDelay$lambda$2((HandlerContext) this.f1829b, (HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1) this.f1830c, (Throwable) obj);
            default:
                return FutureKt.asCompletableFuture$lambda$1((CompletableFuture) this.f1829b, (Deferred) this.f1830c, (Throwable) obj);
        }
    }
}
