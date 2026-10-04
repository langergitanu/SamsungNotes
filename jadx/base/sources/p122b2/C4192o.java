package p122b2;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.C11561g;
import com.samsung.scpm.pam.kps.ScpmKps;
import java.util.function.BiFunction;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.future.FutureKt;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableBiFunction;

/* JADX INFO: renamed from: b2.o */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C4192o implements BiFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1804a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1805b;

    public /* synthetic */ C4192o(Object obj, int i) {
        this.f1804a = i;
        this.f1805b = obj;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f1804a) {
            case 0:
                return ContinuitySession.lambda$notifyPeerConnected$3((String) this.f1805b, (String) obj, (ContinuitySessionManager.PeerStatusListener) obj2);
            case 1:
                return ScpmKps.lambda$new$0((Context) this.f1805b, (String) obj, (Bundle) obj2);
            case 2:
                return ((C11561g) this.f1805b).invoke(obj, (Throwable) obj2);
            case 3:
                return FutureKt.setupCancellation$lambda$3((Function2) this.f1805b, obj, (Throwable) obj2);
            case 4:
                return Functions.apply((Functions.FailableBiFunction) this.f1805b, obj, obj2);
            default:
                return Failable.apply((FailableBiFunction) this.f1805b, obj, obj2);
        }
    }
}
