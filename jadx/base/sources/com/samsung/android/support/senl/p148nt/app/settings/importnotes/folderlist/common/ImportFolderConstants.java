package com.samsung.android.support.senl.p148nt.app.settings.importnotes.folderlist.common;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/common/ImportFolderConstants;", "", "<init>", "()V", "ITEM_TYPE_FOLDER", "", "ITEM_TYPE_FILE", "REQUEST_ACCOUNT_PICKER", "REQUEST_AUTHORIZATION", "REQUEST_IMPORT_SNOTE_LOCAL", "REQUEST_IMPORT_SDOCX_CLOUD", "SnotePickerType", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportFolderConstants {

    @NotNull
    public static final ImportFolderConstants INSTANCE = new ImportFolderConstants();
    public static final int ITEM_TYPE_FILE = 2;
    public static final int ITEM_TYPE_FOLDER = 1;
    public static final int REQUEST_ACCOUNT_PICKER = 1;
    public static final int REQUEST_AUTHORIZATION = 2;
    public static final int REQUEST_IMPORT_SDOCX_CLOUD = 4;
    public static final int REQUEST_IMPORT_SNOTE_LOCAL = 3;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/folderlist/common/ImportFolderConstants$SnotePickerType;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "LOCAL", "MY_FILES", "RESTRICTED_LOCAL", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SnotePickerType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SnotePickerType[] $VALUES;
        public static final SnotePickerType NONE = new SnotePickerType(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final SnotePickerType LOCAL = new SnotePickerType("LOCAL", 1);
        public static final SnotePickerType MY_FILES = new SnotePickerType("MY_FILES", 2);
        public static final SnotePickerType RESTRICTED_LOCAL = new SnotePickerType("RESTRICTED_LOCAL", 3);

        private static final /* synthetic */ SnotePickerType[] $values() {
            return new SnotePickerType[]{NONE, LOCAL, MY_FILES, RESTRICTED_LOCAL};
        }

        static {
            SnotePickerType[] snotePickerTypeArr$values = $values();
            $VALUES = snotePickerTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(snotePickerTypeArr$values);
        }

        private SnotePickerType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<SnotePickerType> getEntries() {
            return $ENTRIES;
        }

        public static SnotePickerType valueOf(String str) {
            return (SnotePickerType) Enum.valueOf(SnotePickerType.class, str);
        }

        public static SnotePickerType[] values() {
            return (SnotePickerType[]) $VALUES.clone();
        }
    }

    private ImportFolderConstants() {
    }
}
