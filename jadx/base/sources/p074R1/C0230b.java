package p074R1;

import android.view.textclassifier.TextClassification;
import com.samsung.android.app.sdk.deepsky.classifier.TextClassifierExtraUtils;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuityServerSocket;
import com.samsung.android.mcf.continuity.impl.ProtoContinuityPacket;
import com.samsung.scsp.common.JournalItem;
import java.lang.reflect.TypeVariable;
import java.net.Socket;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.sequences.Sequence;
import kotlin.streams.jdk8.StreamsKt;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableSupplier;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

/* JADX INFO: renamed from: R1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0230b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f675a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f676b;

    public /* synthetic */ C0230b(Object obj, int i) {
        this.f675a = i;
        this.f676b = obj;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f675a) {
            case 0:
                return TextClassifierExtraUtils.lambda$getEntityText$2((TextClassification) this.f676b);
            case 1:
                return ContinuityConnection.lambda$sendMessage$4((ProtoContinuityPacket.ContinuityPacket) this.f676b);
            case 2:
                return ContinuityServerSocket.lambda$accept$0((Socket) this.f676b);
            case 3:
                return ((JournalItem) this.f676b).toString();
            case 4:
                return ((Map.Entry) this.f676b).getValue();
            case 5:
                return StreamsKt.asStream$lambda$4((Sequence) this.f676b);
            case 6:
                return Functions.get((Functions.FailableSupplier) this.f676b);
            case 7:
                return Failable.get((FailableSupplier) this.f676b);
            case 8:
                return MethodUtils.lambda$getVarArgs$8((Class[]) this.f676b);
            case 9:
                return TypeUtils.lambda$extractTypeArgumentsFrom$3((TypeVariable) this.f676b);
            case 10:
                return LogFactory.lambda$newFactory$27((LogConfigurationException) this.f676b);
            case 11:
                return LogFactory.lambda$getFactory$7((RuntimeException) this.f676b);
            case 12:
                return LogFactory.lambda$getFactory$8((Error) this.f676b);
            case 13:
                return LogFactory.lambda$getFactory$9((Exception) this.f676b);
            default:
                return LogFactory.lambda$implementsLogFactory$22((LinkageError) this.f676b);
        }
    }
}
