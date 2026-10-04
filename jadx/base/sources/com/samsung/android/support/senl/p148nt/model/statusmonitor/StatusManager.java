package com.samsung.android.support.senl.p148nt.model.statusmonitor;

import androidx.annotation.VisibleForTesting;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.IStatusMonitor;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.MemoryStateMonitor;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.ThermalStateMonitor;
import com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors.UIStatusMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\nH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager;", "", "<init>", "()V", "monitors", "", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$Types;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor;", "observerMap", "", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/IStatusObserver;", "attach", "", "observer", "type", "detach", "Value", "Types", "MonitorFactory", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nStatusManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StatusManager.kt\ncom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1869#2,2:87\n1869#2,2:89\n*S KotlinDebug\n*F\n+ 1 StatusManager.kt\ncom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager\n*L\n31#1:87,2\n53#1:89,2\n*E\n"})
public final class StatusManager {

    @NotNull
    private final Map<Types, IStatusMonitor> monitors;

    @NotNull
    private final Map<Types, List<IStatusObserver>> observerMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$MonitorFactory;", "", "<init>", "()V", "Companion", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @VisibleForTesting
    public static final class MonitorFactory {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$MonitorFactory$Companion;", "", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor;", "type", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$Types;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {

            /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
            @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Types.values().length];
                    try {
                        iArr[Types.Thermal.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Types.Memory.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Types.f7761UI.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final IStatusMonitor create(@NotNull Types type) {
                Intrinsics.checkNotNullParameter(type, "type");
                int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i == 1) {
                    return new ThermalStateMonitor();
                }
                if (i == 2) {
                    return new MemoryStateMonitor();
                }
                if (i == 3) {
                    return new UIStatusMonitor();
                }
                throw new NoWhenBranchMatchedException();
            }

            private Companion() {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$Types;", "", "<init>", "(Ljava/lang/String;I)V", "Thermal", "Memory", "UI", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Types {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Types[] $VALUES;
        public static final Types Thermal = new Types("Thermal", 0);
        public static final Types Memory = new Types("Memory", 1);

        /* JADX INFO: renamed from: UI */
        public static final Types f7761UI = new Types("UI", 2);

        private static final /* synthetic */ Types[] $values() {
            return new Types[]{Thermal, Memory, f7761UI};
        }

        static {
            Types[] typesArr$values = $values();
            $VALUES = typesArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typesArr$values);
        }

        private Types(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Types> getEntries() {
            return $ENTRIES;
        }

        public static Types valueOf(String str) {
            return (Types) Enum.valueOf(Types.class, str);
        }

        public static Types[] values() {
            return (Types[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/StatusManager$Value;", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Value extends IStatusMonitor.Value {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void setIntValue(@NotNull Value value, int i) {
                IStatusMonitor.Value.DefaultImpls.setIntValue(value, i);
            }
        }
    }

    public StatusManager() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.monitors = linkedHashMap;
        this.observerMap = new LinkedHashMap();
        Types types = Types.Thermal;
        MonitorFactory.Companion companion = MonitorFactory.INSTANCE;
        linkedHashMap.put(types, companion.create(types));
        Types types2 = Types.Memory;
        linkedHashMap.put(types2, companion.create(types2));
        Types types3 = Types.f7761UI;
        linkedHashMap.put(types3, companion.create(types3));
    }

    public final boolean attach(@NotNull IStatusObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = observer.getRequestedTypes().iterator();
        boolean zAttach = false;
        while (it.hasNext()) {
            zAttach |= attach((Types) it.next(), observer);
        }
        return zAttach;
    }

    public final boolean detach(@NotNull IStatusObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = observer.getRequestedTypes().iterator();
        boolean zDetach = false;
        while (it.hasNext()) {
            zDetach |= detach((Types) it.next(), observer);
        }
        return zDetach;
    }

    private final boolean attach(Types type, IStatusObserver observer) {
        List<IStatusObserver> arrayList = this.observerMap.get(type);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.observerMap.put(type, arrayList);
        }
        if (arrayList.contains(observer)) {
            return false;
        }
        return arrayList.add(observer);
    }

    private final boolean detach(Types type, IStatusObserver observer) {
        List<IStatusObserver> list = this.observerMap.get(type);
        if (list == null || !list.contains(observer)) {
            return false;
        }
        boolean zRemove = list.remove(observer);
        if (list.isEmpty()) {
            this.observerMap.remove(type);
        }
        return zRemove;
    }
}
