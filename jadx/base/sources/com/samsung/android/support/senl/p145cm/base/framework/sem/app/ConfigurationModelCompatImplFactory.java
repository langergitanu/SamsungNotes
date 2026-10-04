package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.os.Build;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsConfigurationModelCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/ConfigurationModelCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "ConfigurationModelCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConfigurationModelCompatImplFactory extends AbsConfigurationModelCompatImplFactory {

    @NotNull
    private static final String TAG = "ConfigurationModelCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/ConfigurationModelCompatImplFactory$ConfigurationModelCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;", "<init>", "()V", "isAOPAlwaysSupported", "", "()Z", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ConfigurationModelCompatSemImpl implements AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl
        public boolean isAOPAlwaysSupported() {
            try {
                if (Build.VERSION.SDK_INT >= 34) {
                    return Build.VERSION.SEM_FIRST_SDK_INT >= 34;
                }
                return false;
            } catch (Exception e) {
                AbstractC0000a.m23t("isAOPAlwaysSupported# ", e.getMessage(), LoggerBase.INSTANCE, ConfigurationModelCompatImplFactory.TAG);
                return false;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsConfigurationModelCompatImplFactory
    @NotNull
    public AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl create(int deviceType) {
        return (deviceType == 2 || deviceType == 3) ? new ConfigurationModelCompatSemImpl() : super.create(deviceType);
    }
}
