package com.samsung.android.support.senl.p148nt.app.settings.importnotes.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/importnotes/common/ImportConstants;", "", "<init>", "()V", "MB", "", "LIMIT_DOWNLOAD_AVAILABLE_SIZE", "", "LIMIT_DATA_UNIT", "", "TASK_TYPE_MEMO", "TASK_TYPE_SCRAPBOOK", "DATA_TYPE_IMPORT_ITEM", "DATA_TYPE_MEMO_METADATA_ITEM", "CATEGORY_TYPE_ALL_NOTE", "CATEGORY_TYPE_UNCATEGORISED", "CATEGORY_TYPE_USER", "KEY_TYPE", "KEY_ACCOUNT_NAME", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ImportConstants {
    public static final int CATEGORY_TYPE_ALL_NOTE = 11;
    public static final int CATEGORY_TYPE_UNCATEGORISED = 12;
    public static final int CATEGORY_TYPE_USER = 13;
    public static final int DATA_TYPE_IMPORT_ITEM = 1;
    public static final int DATA_TYPE_MEMO_METADATA_ITEM = 2;

    @NotNull
    public static final ImportConstants INSTANCE = new ImportConstants();

    @NotNull
    public static final String KEY_ACCOUNT_NAME = "account_name";

    @NotNull
    public static final String KEY_TYPE = "import_type";

    @NotNull
    public static final String LIMIT_DATA_UNIT = "MB";
    public static final int LIMIT_DOWNLOAD_AVAILABLE_SIZE = 100;
    public static final long MB = 1048576;
    public static final int TASK_TYPE_MEMO = 200;
    public static final int TASK_TYPE_SCRAPBOOK = 201;

    private ImportConstants() {
    }
}
