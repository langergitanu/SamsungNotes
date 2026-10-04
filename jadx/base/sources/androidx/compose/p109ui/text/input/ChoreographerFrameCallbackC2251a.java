package androidx.compose.p109ui.text.input;

import android.view.Choreographer;
import com.samsung.android.sesl.visualeffect.lighteffects.common.runtimshader.VibeRenderEffectBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.title.TitleEditor;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.android.HandlerDispatcherKt;

/* JADX INFO: renamed from: androidx.compose.ui.text.input.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ChoreographerFrameCallbackC2251a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1200a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1201b;

    public /* synthetic */ ChoreographerFrameCallbackC2251a(Object obj, int i) {
        this.f1200a = i;
        this.f1201b = obj;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        switch (this.f1200a) {
            case 0:
                ((Runnable) this.f1201b).run();
                break;
            case 1:
                ((VibeRenderEffectBase) this.f1201b).updateOnFrameCallback();
                break;
            case 2:
                ((TitleEditor) this.f1201b).lambda$init$0(j);
                break;
            default:
                HandlerDispatcherKt.postFrameCallback$lambda$6((CancellableContinuation) this.f1201b, j);
                break;
        }
    }
}
