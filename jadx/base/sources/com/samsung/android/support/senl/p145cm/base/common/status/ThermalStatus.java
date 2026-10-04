package com.samsung.android.support.senl.p145cm.base.common.status;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus;", "", "Types", "ThermalStatusListener", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface ThermalStatus {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$ThermalStatusListener;", "", "onThermalStatusChanged", "", "status", "Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface ThermalStatusListener {
        void onThermalStatusChanged(@NotNull Types status);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/status/ThermalStatus$Types;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "LIGHT", "MODERATE", "SEVERE", "CRITICAL", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Types {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Types[] $VALUES;
        public static final Types NONE = new Types(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final Types LIGHT = new Types("LIGHT", 1);
        public static final Types MODERATE = new Types("MODERATE", 2);
        public static final Types SEVERE = new Types("SEVERE", 3);
        public static final Types CRITICAL = new Types("CRITICAL", 4);

        private static final /* synthetic */ Types[] $values() {
            return new Types[]{NONE, LIGHT, MODERATE, SEVERE, CRITICAL};
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
}
