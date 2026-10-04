package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "IConfigurationModelCompatImpl", "ConfigurationModelCompatPureImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class AbsConfigurationModelCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$ConfigurationModelCompatPureImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;", "<init>", "()V", "isAOPAlwaysSupported", "", "()Z", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConfigurationModelCompatPureImpl implements IConfigurationModelCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl
        public boolean isAOPAlwaysSupported() {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;", "", "isAOPAlwaysSupported", "", "()Z", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IConfigurationModelCompatImpl {
        boolean isAOPAlwaysSupported();
    }

    @NotNull
    public IConfigurationModelCompatImpl create(int deviceType) {
        return new ConfigurationModelCompatPureImpl();
    }
}
