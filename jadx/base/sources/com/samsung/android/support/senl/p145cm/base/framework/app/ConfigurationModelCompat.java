package com.samsung.android.support.senl.p145cm.base.framework.app;

import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsConfigurationModelCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.ConfigurationModelCompatImplFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\b¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/ConfigurationModelCompat;", "", "mImpl", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;", "<init>", "(Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsConfigurationModelCompatImplFactory$IConfigurationModelCompatImpl;)V", "isAOPAlwaysSupported", "", "()Z", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ConfigurationModelCompat {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static ConfigurationModelCompat sInstance;

    @NotNull
    private final AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl mImpl;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/app/ConfigurationModelCompat$Companion;", "", "<init>", "()V", "sInstance", "Lcom/samsung/android/support/senl/cm/base/framework/app/ConfigurationModelCompat;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/cm/base/framework/app/ConfigurationModelCompat;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized ConfigurationModelCompat getInstance() {
            ConfigurationModelCompat configurationModelCompat;
            try {
                if (ConfigurationModelCompat.sInstance == null) {
                    ConfigurationModelCompat.sInstance = new ConfigurationModelCompat(new ConfigurationModelCompatImplFactory().create(DeviceInfo.getDeviceType()), null);
                }
                configurationModelCompat = ConfigurationModelCompat.sInstance;
                Intrinsics.checkNotNull(configurationModelCompat, "null cannot be cast to non-null type com.samsung.android.support.senl.cm.base.framework.app.ConfigurationModelCompat");
            } catch (Throwable th) {
                throw th;
            }
            return configurationModelCompat;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ConfigurationModelCompat(AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl iConfigurationModelCompatImpl, DefaultConstructorMarker defaultConstructorMarker) {
        this(iConfigurationModelCompatImpl);
    }

    public final boolean isAOPAlwaysSupported() {
        return this.mImpl.isAOPAlwaysSupported();
    }

    private ConfigurationModelCompat(AbsConfigurationModelCompatImplFactory.IConfigurationModelCompatImpl iConfigurationModelCompatImpl) {
        this.mImpl = iConfigurationModelCompatImpl;
    }
}
