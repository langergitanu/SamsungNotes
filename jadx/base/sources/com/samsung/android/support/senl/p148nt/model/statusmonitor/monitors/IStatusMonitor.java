package com.samsung.android.support.senl.p148nt.model.statusmonitor.monitors;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002\n\u000bJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor;", "", "setListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$OnStatusChangeListener;", "value", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "getValue", "()Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "Value", "OnStatusChangeListener", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IStatusMonitor {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$OnStatusChangeListener;", "", "onStateChanged", "", "value", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnStatusChangeListener {
        void onStateChanged(@NotNull Value value);
    }

    @NotNull
    Value getValue();

    void setListener(@Nullable OnStatusChangeListener listener);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value;", "", "type", "Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "getType", "()Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "getIntValue", "", "setIntValue", "", "value", "getFloatValue", "", "Types", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Value {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/model/statusmonitor/monitors/IStatusMonitor$Value$Types;", "", "<init>", "(Ljava/lang/String;I)V", "Integer", "Float", "ntModel_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Types {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ Types[] $VALUES;
            public static final Types Integer = new Types("Integer", 0);
            public static final Types Float = new Types("Float", 1);

            private static final /* synthetic */ Types[] $values() {
                return new Types[]{Integer, Float};
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

        float getFloatValue();

        int getIntValue();

        @NotNull
        Types getType();

        void setIntValue(int value);

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class DefaultImpls {
            public static void setIntValue(@NotNull Value value, int i) {
            }
        }
    }
}
