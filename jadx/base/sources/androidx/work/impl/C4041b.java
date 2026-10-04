package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;
import androidx.work.impl.WorkDatabase;
import com.samsung.scsp.common.FeatureConfigurator;
import com.samsung.scsp.error.FaultBarrier;
import com.samsung.scsp.framework.core.util.DeviceUtil;

/* JADX INFO: renamed from: androidx.work.impl.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C4041b implements SupportSQLiteOpenHelper.Factory, FaultBarrier.ThrowableSupplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1726a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f1727b;

    public /* synthetic */ C4041b(Context context, int i) {
        this.f1726a = i;
        this.f1727b = context;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        return WorkDatabase.Companion.create$lambda$0(this.f1727b, configuration);
    }

    @Override // com.samsung.scsp.error.FaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f1726a) {
            case 1:
                return FeatureConfigurator.lambda$checkConfigurator$3(this.f1727b);
            case 2:
                return DeviceUtil.lambda$getSimMcc$6(this.f1727b);
            case 3:
                return DeviceUtil.lambda$getSsdid$1(this.f1727b);
            case 4:
                return DeviceUtil.lambda$getAndroidDeviceName$12(this.f1727b);
            case 5:
                return DeviceUtil.lambda$getAndroidDeviceName$13(this.f1727b);
            case 6:
                return DeviceUtil.lambda$isDoMode$17(this.f1727b);
            case 7:
                return DeviceUtil.lambda$getNetworkMcc$5(this.f1727b);
            case 8:
                return DeviceUtil.lambda$getSimMnc$8(this.f1727b);
            case 9:
                return DeviceUtil.lambda$isPoMode$16(this.f1727b);
            default:
                return DeviceUtil.lambda$getNetworkMnc$7(this.f1727b);
        }
    }
}
