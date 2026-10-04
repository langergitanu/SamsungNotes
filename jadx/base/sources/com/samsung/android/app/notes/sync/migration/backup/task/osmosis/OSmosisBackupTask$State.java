package com.samsung.android.app.notes.sync.migration.backup.task.osmosis;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"com/samsung/android/app/notes/sync/migration/backup/task/osmosis/OSmosisBackupTask$State", "", "Lcom/samsung/android/app/notes/sync/migration/backup/task/osmosis/OSmosisBackupTask$State;", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "NOTES_TRANSFERRING", "ATTACHMENT_TRANSFERRING", "ntSync_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
final class OSmosisBackupTask$State {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OSmosisBackupTask$State[] $VALUES;
    public static final OSmosisBackupTask$State NONE = new OSmosisBackupTask$State(CoverStickerConstants.Category.NONE.NAME, 0);
    public static final OSmosisBackupTask$State NOTES_TRANSFERRING = new OSmosisBackupTask$State("NOTES_TRANSFERRING", 1);
    public static final OSmosisBackupTask$State ATTACHMENT_TRANSFERRING = new OSmosisBackupTask$State("ATTACHMENT_TRANSFERRING", 2);

    private static final /* synthetic */ OSmosisBackupTask$State[] $values() {
        return new OSmosisBackupTask$State[]{NONE, NOTES_TRANSFERRING, ATTACHMENT_TRANSFERRING};
    }

    static {
        OSmosisBackupTask$State[] oSmosisBackupTask$StateArr$values = $values();
        $VALUES = oSmosisBackupTask$StateArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(oSmosisBackupTask$StateArr$values);
    }

    private OSmosisBackupTask$State(String str, int i) {
    }

    @NotNull
    public static EnumEntries<OSmosisBackupTask$State> getEntries() {
        return $ENTRIES;
    }

    public static OSmosisBackupTask$State valueOf(String str) {
        return (OSmosisBackupTask$State) Enum.valueOf(OSmosisBackupTask$State.class, str);
    }

    public static OSmosisBackupTask$State[] values() {
        return (OSmosisBackupTask$State[]) $VALUES.clone();
    }
}
