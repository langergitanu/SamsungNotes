package com.samsung.android.support.senl.p148nt.base.common.constants;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/CoeditBaseConstants;", "", "<init>", "()V", "PAGE_WIDTH", "", "STANDALONE_DEFAULT_TITLE", "", "STANDALONE_DEFAULT_TITLE_OLD", "COEDIT_IMPORT_MAX_OBJECT", "COEDIT_IMPORT_MAX_STROKE_OBJECT", "COEDIT_IMPORT_MAX_LARGE_ITEMS", "EXTRA_GROUP_ID", "COEDIT_RECYCLEBIN_ENABLED", "", "RESULT_BASE", "SPACE_DELTE_RECEIVED_INTENT_FILTER", CoeditBaseConstants.COEDIT_DELETED_GROUP_ID, CoeditBaseConstants.COEDIT_DELETED_SPACE_ID, CoeditBaseConstants.COEDIT_DELETED_GROUP_NAME, "EXTRA_GROUP_NAME", "CoeditCopyResult", "DeleteCoeditNoteResult", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CoeditBaseConstants {

    @NotNull
    public static final String COEDIT_DELETED_GROUP_ID = "COEDIT_DELETED_GROUP_ID";

    @NotNull
    public static final String COEDIT_DELETED_GROUP_NAME = "COEDIT_DELETED_GROUP_NAME";

    @NotNull
    public static final String COEDIT_DELETED_SPACE_ID = "COEDIT_DELETED_SPACE_ID";
    public static final int COEDIT_IMPORT_MAX_LARGE_ITEMS = 100;
    public static final int COEDIT_IMPORT_MAX_OBJECT = 30000;
    public static final int COEDIT_IMPORT_MAX_STROKE_OBJECT = 15000;
    public static final boolean COEDIT_RECYCLEBIN_ENABLED = true;

    @NotNull
    public static final String EXTRA_GROUP_ID = "group_id";

    @NotNull
    public static final String EXTRA_GROUP_NAME = "group_name";

    @NotNull
    public static final CoeditBaseConstants INSTANCE = new CoeditBaseConstants();
    public static final int PAGE_WIDTH = 2160;
    public static final int RESULT_BASE = 0;

    @NotNull
    public static final String SPACE_DELTE_RECEIVED_INTENT_FILTER = "COEDIT_SPACE_DELTE_RECEIVED_INTENT_FILTER";

    @NotNull
    public static final String STANDALONE_DEFAULT_TITLE = "Group://Standalone";

    @NotNull
    public static final String STANDALONE_DEFAULT_TITLE_OLD = "Coedit://StandaloneNote";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/CoeditBaseConstants$CoeditCopyResult;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CoeditCopyResult {
        public static final int ALLOWED = 101;
        public static final int COPY_RESULT_BASE = 100;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int ERROR_FAIL_TO_COPY_NOTE = 110;
        public static final int ERROR_LARGE_ITEM_COUNT = 113;
        public static final int ERROR_LARGE_STROKE_COUNT = 112;
        public static final int ERROR_LARGE_XML_SIZE = 111;
        public static final int SUCCESS = 100;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/CoeditBaseConstants$CoeditCopyResult$Companion;", "", "<init>", "()V", "COPY_RESULT_BASE", "", "SUCCESS", "ALLOWED", "ERROR_FAIL_TO_COPY_NOTE", "ERROR_LARGE_XML_SIZE", "ERROR_LARGE_STROKE_COUNT", "ERROR_LARGE_ITEM_COUNT", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int ALLOWED = 101;
            public static final int COPY_RESULT_BASE = 100;
            public static final int ERROR_FAIL_TO_COPY_NOTE = 110;
            public static final int ERROR_LARGE_ITEM_COUNT = 113;
            public static final int ERROR_LARGE_STROKE_COUNT = 112;
            public static final int ERROR_LARGE_XML_SIZE = 111;
            public static final int SUCCESS = 100;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/CoeditBaseConstants$DeleteCoeditNoteResult;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DeleteCoeditNoteResult {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int DELETE_RESULT_BASE = 300;
        public static final int ERROR_FAIL_TO_DELETE_NOTE = 310;
        public static final int SUCCESS = 300;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/constants/CoeditBaseConstants$DeleteCoeditNoteResult$Companion;", "", "<init>", "()V", "DELETE_RESULT_BASE", "", "SUCCESS", "ERROR_FAIL_TO_DELETE_NOTE", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DELETE_RESULT_BASE = 300;
            public static final int ERROR_FAIL_TO_DELETE_NOTE = 310;
            public static final int SUCCESS = 300;

            private Companion() {
            }
        }
    }

    private CoeditBaseConstants() {
    }
}
