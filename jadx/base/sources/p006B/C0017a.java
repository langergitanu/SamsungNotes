package p006B;

import com.samsung.android.app.notes.reflect.DocumentDataContractImpl;
import com.samsung.android.support.senl.p148nt.app.updater.restore.DummyDocumentDetector;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.scsp.common.PushVoFactory;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.DeviceUtil;

/* JADX INFO: renamed from: B.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C0017a implements DocumentFileManager.IOAction, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f91a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f92b;

    public /* synthetic */ C0017a(String str, int i) {
        this.f91a = i;
        this.f92b = str;
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f91a) {
            case 2:
                return PushVoFactory.lambda$create$1(this.f92b);
            default:
                return DeviceUtil.lambda$getSystemProperties$14(this.f92b);
        }
    }

    @Override // com.samsung.android.support.senl.nt.model.documents.file.DocumentFileManager.IOAction
    public Object operate() {
        switch (this.f91a) {
            case 0:
                return DocumentDataContractImpl.lambda$saveDoc$0(this.f92b);
            default:
                return DummyDocumentDetector.lambda$findRestorePath$0(this.f92b);
        }
    }
}
