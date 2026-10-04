package com.samsung.android.sdk.pen.setting.colorpalette;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener;", "", "onSelectItemChanged", "", "position", "", "selected", "", "onSelectItemUnchanged", "reason", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener$UnchangedReason;", "UnchangedReason", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface OnSelectItemEventListener {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/OnSelectItemEventListener$UnchangedReason;", "", "<init>", "(Ljava/lang/String;I)V", "MIN_VALUE_LIMIT", "MAX_VALUE_LIMIT", "UNKNOWN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class UnchangedReason {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UnchangedReason[] $VALUES;
        public static final UnchangedReason MIN_VALUE_LIMIT = new UnchangedReason("MIN_VALUE_LIMIT", 0);
        public static final UnchangedReason MAX_VALUE_LIMIT = new UnchangedReason("MAX_VALUE_LIMIT", 1);
        public static final UnchangedReason UNKNOWN = new UnchangedReason("UNKNOWN", 2);

        private static final /* synthetic */ UnchangedReason[] $values() {
            return new UnchangedReason[]{MIN_VALUE_LIMIT, MAX_VALUE_LIMIT, UNKNOWN};
        }

        static {
            UnchangedReason[] unchangedReasonArr$values = $values();
            $VALUES = unchangedReasonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(unchangedReasonArr$values);
        }

        private UnchangedReason(String str, int i) {
        }

        @NotNull
        public static EnumEntries<UnchangedReason> getEntries() {
            return $ENTRIES;
        }

        public static UnchangedReason valueOf(String str) {
            return (UnchangedReason) Enum.valueOf(UnchangedReason.class, str);
        }

        public static UnchangedReason[] values() {
            return (UnchangedReason[]) $VALUES.clone();
        }
    }

    void onSelectItemChanged(int position, boolean selected);

    void onSelectItemUnchanged(int position, @NotNull UnchangedReason reason);
}
