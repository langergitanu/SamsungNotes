package com.samsung.android.support.senl.p145cm.base.framework.sem.p147os;

import android.os.SemSystemProperties;
import com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsSystemPropertiesCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/SystemPropertiesCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$ISystemPropertiesCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "SystemPropertiesCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SystemPropertiesCompatImplFactory extends AbsSystemPropertiesCompatImplFactory {

    @NotNull
    private static final String TAG = "SystemPropertiesCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/os/SystemPropertiesCompatImplFactory$SystemPropertiesCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/os/AbsSystemPropertiesCompatImplFactory$SystemPropertiesCompatSemBaseImpl;", "<init>", "()V", "salesCode", "", "getSalesCode", "()Ljava/lang/String;", IdentityApiContract.Parameter.COUNTRY_CODE, "getCountryCode", "countryIsoCode", "getCountryIsoCode", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SystemPropertiesCompatSemImpl extends AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatSemBaseImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getCountryCode() {
            try {
                return SemSystemProperties.getCountryCode();
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("getCountryCode: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, SystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getCountryCode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, SystemPropertiesCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getCountryIsoCode() {
            try {
                return SemSystemProperties.getCountryIso();
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("getCountryIsoCode: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, SystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("getCountryIsoCode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, SystemPropertiesCompatImplFactory.TAG);
                return null;
            }
        }

        @Override // com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.SystemPropertiesCompatPureImpl, com.samsung.android.support.senl.cm.base.framework.sem.os.AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl
        @Nullable
        public String getSalesCode() {
            try {
                return SemSystemProperties.getSalesCode();
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("readSalesCode: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, SystemPropertiesCompatImplFactory.TAG);
                return null;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("readSalesCode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, SystemPropertiesCompatImplFactory.TAG);
                return null;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.p147os.AbsSystemPropertiesCompatImplFactory
    @NotNull
    public AbsSystemPropertiesCompatImplFactory.ISystemPropertiesCompatImpl create(int deviceType) {
        return deviceType == 2 ? new SystemPropertiesCompatSemImpl() : super.create(deviceType);
    }
}
