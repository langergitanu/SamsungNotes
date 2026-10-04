package androidx.compose.p109ui.graphics.layer;

import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.composer.writing.math.textmath.SpenTextMathManager;
import com.samsung.android.sdk.pen.recoguifeature.math.SpenMathManager;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizerListener;

/* JADX INFO: renamed from: androidx.compose.ui.graphics.layer.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C2061c implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1103a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1104b;

    public /* synthetic */ C2061c(Object obj, int i) {
        this.f1103a = i;
        this.f1104b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (this.f1103a) {
            case 0:
                return LayerManager.handler$lambda$0((LayerManager) this.f1104b, message);
            case 1:
                return SpenTextMathManager.mDialerHandler$lambda$0((SpenTextMathManager) this.f1104b, message);
            case 2:
                return SpenMathManager.mMathDialerHandler$lambda$8((SpenMathManager) this.f1104b, message);
            default:
                return ScsRecognizerListener.mHandler$lambda$0((ScsRecognizerListener) this.f1104b, message);
        }
    }
}
