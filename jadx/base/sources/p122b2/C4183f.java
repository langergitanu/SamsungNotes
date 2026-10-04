package p122b2;

import android.graphics.Bitmap;
import com.samsung.android.mcf.continuity.api.ContinuityFileId;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import com.samsung.android.vexfwk.sdk.docscan.VexFwkDocDetector;
import com.samsung.android.vexfwk.sdk.imgclipper.VexFwkImageClipper;
import com.samsung.android.vexfwk.sdk.objeraser.VexFwkObjSegmentor;
import com.samsung.android.vexfwk.sdk.winedetector.VexFwkWineDetector;
import com.samsung.scsp.framework.core.api.ResponsiveJob;
import com.samsung.scsp.framework.core.network.HttpRequest;
import io.opentelemetry.context.Context;
import java.io.IOException;
import java.net.Socket;
import java.util.function.Supplier;
import org.apache.commons.lang3.Validate;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: renamed from: b2.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C4183f implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1774a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1775b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1776c;

    public /* synthetic */ C4183f(Object obj, Object obj2, int i) {
        this.f1774a = i;
        this.f1775b = obj;
        this.f1776c = obj2;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f1774a) {
            case 0:
                return ((ContinuityConnection) this.f1775b).lambda$handleFileInfoReceived$10((ContinuityFileId) this.f1776c);
            case 1:
                return ((ContinuityConnection) this.f1775b).lambda$setControlSocket$1((Socket) this.f1776c);
            case 2:
                return ContinuitySession.C71985.lambda$onPacketReceived$1((String) this.f1775b, (byte[]) this.f1776c);
            case 3:
                return VexFwkDocDetector.detectDocumentImpl$lambda$7(this.f1775b, (VexFwkDocDetector) this.f1776c);
            case 4:
                return VexFwkImageClipper.objectCapture$lambda$6((Bitmap) this.f1775b, (VexFwkImageClipper) this.f1776c);
            case 5:
                return VexFwkObjSegmentor.segmentObject$lambda$4((Bitmap) this.f1775b, (VexFwkObjSegmentor) this.f1776c);
            case 6:
                return VexFwkWineDetector.detectWineImpl$lambda$6(this.f1775b, (VexFwkWineDetector) this.f1776c);
            case 7:
                return ResponsiveJob.lambda$onStream$0((HttpRequest) this.f1775b, (String) this.f1776c);
            case 8:
                return ((Context) this.f1775b).lambda$wrapSupplier$8((Supplier) this.f1776c);
            case 9:
                return Validate.getMessage((String) this.f1775b, (Object[]) this.f1776c);
            case 10:
                return LogFactory.lambda$getResources$16((String) this.f1775b, (IOException) this.f1776c);
            case 11:
                return LogFactory.lambda$isClassAvailable$24((String) this.f1775b, (ClassLoader) this.f1776c);
            case 12:
                return LogFactory.lambda$newFactory$28(this.f1775b, (ClassLoader) this.f1776c);
            default:
                return LogFactory.lambda$getClassLoader$0((Class) this.f1775b, (SecurityException) this.f1776c);
        }
    }
}
