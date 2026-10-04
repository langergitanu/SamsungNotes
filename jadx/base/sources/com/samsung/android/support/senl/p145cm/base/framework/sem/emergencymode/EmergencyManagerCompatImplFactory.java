package com.samsung.android.support.senl.p145cm.base.framework.sem.emergencymode;

import android.content.Context;
import com.samsung.android.emergencymode.SemEmergencyManager;
import com.samsung.android.support.senl.p145cm.base.framework.sem.emergencymode.AbsEmergencyManagerCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/EmergencyManagerCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/AbsEmergencyManagerCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/AbsEmergencyManagerCompatImplFactory$IEmergencyManagerCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "EmergencyManagerCompatSemImpl", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class EmergencyManagerCompatImplFactory extends AbsEmergencyManagerCompatImplFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/EmergencyManagerCompatImplFactory$EmergencyManagerCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/emergencymode/AbsEmergencyManagerCompatImplFactory$IEmergencyManagerCompatImpl;", "<init>", "()V", "isEmergencyMode", "", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class EmergencyManagerCompatSemImpl implements AbsEmergencyManagerCompatImplFactory.IEmergencyManagerCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.emergencymode.AbsEmergencyManagerCompatImplFactory.IEmergencyManagerCompatImpl
        public boolean isEmergencyMode(@Nullable Context context) {
            try {
                return SemEmergencyManager.isEmergencyMode(context);
            } catch (NoClassDefFoundError e) {
                AbstractC0000a.m23t("isEmergencyMode: NoClassDefFoundError] ", e.getMessage(), LoggerBase.INSTANCE, "EmergencyManagerCompat");
                return false;
            } catch (NoSuchMethodError e2) {
                AbstractC0000a.m23t("isEmergencyMode: NoSuchMethodError] ", e2.getMessage(), LoggerBase.INSTANCE, "EmergencyManagerCompat");
                return false;
            }
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.emergencymode.AbsEmergencyManagerCompatImplFactory
    @NotNull
    public AbsEmergencyManagerCompatImplFactory.IEmergencyManagerCompatImpl create(int deviceType) {
        return deviceType == 2 ? new EmergencyManagerCompatSemImpl() : super.create(deviceType);
    }
}
