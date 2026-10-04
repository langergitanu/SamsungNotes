package p123b3;

import android.animation.ValueAnimator;
import androidx.core.view.WindowInsetsCompat;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.sdk.scs.p142ai.visual.c2pa.C2paError;
import com.samsung.android.sesl.visualeffect.C7844a;
import com.samsung.android.sesl.visualeffect.RevealImageEffectView;
import com.samsung.android.sesl.visualeffect.lighteffects.guidinglight.C7854f;
import com.samsung.android.sesl.visualeffect.surfaceeffects.ripple.RippleAnimation;
import com.samsung.android.sesl.visualeffect.utils.WeakViewHashSet;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.SCSOperator;
import com.samsung.android.support.senl.p148nt.base.composer.html.HtmlConverter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickTool;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeReference;
import kotlin.reflect.KTypeProjection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.future.FutureKt;

/* JADX INFO: renamed from: b3.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C4202b implements Function1 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1831a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1832b;

    public /* synthetic */ C4202b(Object obj, int i) {
        this.f1831a = i;
        this.f1832b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.f1831a) {
            case 0:
                return SCSOperator.initTranslateConfig$lambda$4((SCSOperator) this.f1832b, (Task) obj);
            case 1:
                return C2paError.Companion.fromErrorString$lambda$0((C2paError) this.f1832b, (MatchResult) obj);
            case 2:
                return RevealImageEffectView.startCircularAnimation$lambda$4$lambda$3$lambda$2((C7844a) this.f1832b, (ValueAnimator) obj);
            case 3:
                return RevealImageEffectView.startRoundRectAnimation$lambda$9$lambda$8$lambda$7((C7844a) this.f1832b, (ValueAnimator) obj);
            case 4:
                return RippleAnimation.play$lambda$3((C7854f) this.f1832b, (ValueAnimator) obj);
            case 5:
                return WeakViewHashSet.forEachAlive$lambda$2((Consumer) this.f1832b, (WeakReference) obj);
            case 6:
                return WorkerTask.run$lambda$0((WorkerTask) this.f1832b, (Throwable) obj);
            case 7:
                return StickyMemoManager.initStickMemo$lambda$15((StickyMemoManager) this.f1832b, (WindowInsetsCompat) obj);
            case 8:
                return QuickTool.setupMode$lambda$7((QuickTool) this.f1832b, ((Integer) obj).intValue());
            case 9:
                return HtmlConverter.preprocessMathSyntax$lambda$3((Ref.IntRef) this.f1832b, "$", (MatchResult) obj);
            case 10:
                ArrayList arrayList = (ArrayList) this.f1832b;
                String line = (String) obj;
                Intrinsics.checkNotNullParameter(line, "line");
                arrayList.add(Long.valueOf(Long.parseLong(new Regex("\t").split(line, 0).get(0))));
                return Unit.INSTANCE;
            case 11:
                return TypeReference.asString$lambda$0((TypeReference) this.f1832b, (KTypeProjection) obj);
            default:
                return FutureKt.asCompletableFuture$lambda$2((CompletableFuture) this.f1832b, (Throwable) obj);
        }
    }
}
