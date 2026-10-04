package p122b2;

import android.app.Activity;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenHyperTextSpan;
import com.samsung.android.support.senl.p148nt.app.labs.DocumentTest;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenTextManagerActionListenerImpl;
import java.io.File;

/* JADX INFO: renamed from: b2.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4180c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1761a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f1762b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1763c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1764d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f1765e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f1766f;

    public /* synthetic */ RunnableC4180c(SpenTextManagerActionListenerImpl spenTextManagerActionListenerImpl, SpenHyperTextSpan spenHyperTextSpan, String str, int i, SpenObjectShape spenObjectShape) {
        this.f1761a = 3;
        this.f1763c = spenTextManagerActionListenerImpl;
        this.f1764d = spenHyperTextSpan;
        this.f1765e = str;
        this.f1762b = i;
        this.f1766f = spenObjectShape;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1761a) {
            case 0:
                ((ContinuityConnection) this.f1763c).lambda$sendFile$8(this.f1762b, (ContinuitySessionFileManager.FileStatusListener) this.f1764d, (byte[]) this.f1765e, (File) this.f1766f);
                break;
            case 1:
                ((ContinuitySessionManagerImpl) this.f1763c).lambda$responseConnect$3(this.f1762b, (String) this.f1764d, (ContinuityNetworkPolicy) this.f1765e, (ContinuitySessionManager.PeerStatusListener) this.f1766f);
                break;
            case 2:
                ((DocumentTest) this.f1763c).lambda$importLastData$1(this.f1762b, (String) this.f1764d, (Activity) this.f1765e, (DialogUtils.ProgressDialog) this.f1766f);
                break;
            default:
                ((SpenTextManagerActionListenerImpl) this.f1763c).lambda$showOpenLink$0((SpenHyperTextSpan) this.f1764d, (String) this.f1765e, this.f1762b, (SpenObjectShape) this.f1766f);
                break;
        }
    }

    public /* synthetic */ RunnableC4180c(Object obj, int i, Object obj2, Object obj3, Object obj4, int i2) {
        this.f1761a = i2;
        this.f1763c = obj;
        this.f1762b = i;
        this.f1764d = obj2;
        this.f1765e = obj3;
        this.f1766f = obj4;
    }
}
