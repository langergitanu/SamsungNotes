package com.samsung.android.support.senl.p148nt.base.common.service;

import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/service/ServiceType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", BundleContract.FOREGROUND, "BACKGROUND", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ServiceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ServiceType[] $VALUES;
    public static final ServiceType DEFAULT = new ServiceType("DEFAULT", 0);
    public static final ServiceType FOREGROUND = new ServiceType(BundleContract.FOREGROUND, 1);
    public static final ServiceType BACKGROUND = new ServiceType("BACKGROUND", 2);

    private static final /* synthetic */ ServiceType[] $values() {
        return new ServiceType[]{DEFAULT, FOREGROUND, BACKGROUND};
    }

    static {
        ServiceType[] serviceTypeArr$values = $values();
        $VALUES = serviceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(serviceTypeArr$values);
    }

    private ServiceType(String str, int i) {
    }

    @NotNull
    public static EnumEntries<ServiceType> getEntries() {
        return $ENTRIES;
    }

    public static ServiceType valueOf(String str) {
        return (ServiceType) Enum.valueOf(ServiceType.class, str);
    }

    public static ServiceType[] values() {
        return (ServiceType[]) $VALUES.clone();
    }
}
