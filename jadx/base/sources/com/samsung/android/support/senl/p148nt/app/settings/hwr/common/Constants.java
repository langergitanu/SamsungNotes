package com.samsung.android.support.senl.p148nt.app.settings.hwr.common;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/common/Constants;", "", "<init>", "()V", "HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER", "", "KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION", "KEY_HANDWRITING_LANGUAGE_DELETED_INSTANCE", "KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE", "KEY_DOWNLOADING_HANDWRITING_LANGUAGE", "KEY_DOWNLOADING_HANDWRITING_LANGUAGE_MAX", "KEY_DOWNLOADING_HANDWRITING_LANGUAGE_PROGRESS", "ChangeAction", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constants {

    @NotNull
    public static final String HANDWRITING_LANGUAGE_CHANGED_NOTIFICATION_INTENT_FILTER = "com.samsung.android.app.notes.hwLanguage.CHANGED_NOTIFICATION";

    @NotNull
    public static final Constants INSTANCE = new Constants();

    @NotNull
    public static final String KEY_DOWNLOADING_HANDWRITING_LANGUAGE = "key_downloading_handwriting_language";

    @NotNull
    public static final String KEY_DOWNLOADING_HANDWRITING_LANGUAGE_MAX = "key_downloading_handwriting_language_max";

    @NotNull
    public static final String KEY_DOWNLOADING_HANDWRITING_LANGUAGE_PROGRESS = "key_downloading_handwriting_language_progress";

    @NotNull
    public static final String KEY_HANDWRITING_LANGUAGE_CHANGE_ACTION = "key_handwriting_language_change_action";

    @NotNull
    public static final String KEY_HANDWRITING_LANGUAGE_DELETED_INSTANCE = "key_handwriting_language_deleted_instance";

    @NotNull
    public static final String KEY_HANDWRITING_LANGUAGE_DOWNLOADED_INSTANCE = "key_handwriting_language_downloaded_instance";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/hwr/common/Constants$ChangeAction;", "", "<init>", "(Ljava/lang/String;I)V", CoverStickerConstants.Category.NONE.NAME, "DOWNLOAD_PROGRESS", "DOWNLOAD_SUCCESS", "DOWNLOAD_CANCELLED", "DOWNLOAD_FAILED", "DELETED", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ChangeAction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ChangeAction[] $VALUES;
        public static final ChangeAction NONE = new ChangeAction(CoverStickerConstants.Category.NONE.NAME, 0);
        public static final ChangeAction DOWNLOAD_PROGRESS = new ChangeAction("DOWNLOAD_PROGRESS", 1);
        public static final ChangeAction DOWNLOAD_SUCCESS = new ChangeAction("DOWNLOAD_SUCCESS", 2);
        public static final ChangeAction DOWNLOAD_CANCELLED = new ChangeAction("DOWNLOAD_CANCELLED", 3);
        public static final ChangeAction DOWNLOAD_FAILED = new ChangeAction("DOWNLOAD_FAILED", 4);
        public static final ChangeAction DELETED = new ChangeAction("DELETED", 5);

        private static final /* synthetic */ ChangeAction[] $values() {
            return new ChangeAction[]{NONE, DOWNLOAD_PROGRESS, DOWNLOAD_SUCCESS, DOWNLOAD_CANCELLED, DOWNLOAD_FAILED, DELETED};
        }

        static {
            ChangeAction[] changeActionArr$values = $values();
            $VALUES = changeActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(changeActionArr$values);
        }

        private ChangeAction(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ChangeAction> getEntries() {
            return $ENTRIES;
        }

        public static ChangeAction valueOf(String str) {
            return (ChangeAction) Enum.valueOf(ChangeAction.class, str);
        }

        public static ChangeAction[] values() {
            return (ChangeAction[]) $VALUES.clone();
        }
    }

    private Constants() {
    }
}
