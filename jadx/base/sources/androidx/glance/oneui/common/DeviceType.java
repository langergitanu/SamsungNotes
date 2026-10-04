package androidx.glance.oneui.common;

import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m13886d2 = {"Landroidx/glance/oneui/common/DeviceType;", "", "type", "", "(Ljava/lang/String;II)V", "getType", "()I", "toString", "", "Phone", "FoldMain", "FoldSub", "Flip", "Tablet", "MultiFoldMain", "MultiFoldSub", "glance-oneui-common_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DeviceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DeviceType[] $VALUES;
    private final int type;
    public static final DeviceType Phone = new DeviceType("Phone", 0, -1);
    public static final DeviceType FoldMain = new DeviceType("FoldMain", 1, 0);
    public static final DeviceType FoldSub = new DeviceType("FoldSub", 2, 5);
    public static final DeviceType Flip = new DeviceType("Flip", 3, 100);
    public static final DeviceType Tablet = new DeviceType("Tablet", 4, 101);
    public static final DeviceType MultiFoldMain = new DeviceType("MultiFoldMain", 5, 102);
    public static final DeviceType MultiFoldSub = new DeviceType("MultiFoldSub", 6, 103);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 9, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceType.values().length];
            try {
                iArr[DeviceType.FoldMain.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceType.FoldSub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeviceType.Flip.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeviceType.Tablet.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeviceType.MultiFoldMain.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeviceType.MultiFoldSub.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ DeviceType[] $values() {
        return new DeviceType[]{Phone, FoldMain, FoldSub, Flip, Tablet, MultiFoldMain, MultiFoldSub};
    }

    static {
        DeviceType[] deviceTypeArr$values = $values();
        $VALUES = deviceTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deviceTypeArr$values);
    }

    private DeviceType(String str, int i, int i2) {
        this.type = i2;
    }

    @NotNull
    public static EnumEntries<DeviceType> getEntries() {
        return $ENTRIES;
    }

    public static DeviceType valueOf(String str) {
        return (DeviceType) Enum.valueOf(DeviceType.class, str);
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "fold-main";
            case 2:
                return "fold-sub";
            case 3:
                return "flip";
            case 4:
                return "tablet";
            case 5:
                return "multi-fold-main";
            case 6:
                return "multi-fold-sub";
            default:
                return "phone";
        }
    }
}
