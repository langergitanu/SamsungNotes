package com.samsung.android.support.senl.p148nt.app.main.common;

import com.samsung.android.support.senl.p148nt.app.C8003R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GcsConstants {
    public static final String COEDIT_PREFS_NAME = "SharedCoeditInvitation";
    public static final String GCS_PREFS_NAME = "SharedInvitation";
    public static final String INTENT_EXTRA_SOCIAL_PICKER_RESULT = "jsonResult";
    public static final String KEY_COEDIT_INVITATION_LIST = "key_invitation_list";
    public static final String KEY_COEDIT_UNREAD_COUNT = "key_coedit_unread_count";
    public static final String KEY_COEIDT_HAS_BADGE = "key_coedit_has_badge";
    public static final String KEY_GCS_HAS_DRAWER_BADGE = "key_gcs_drawer_has_badge";
    public static final String KEY_GCS_HAS_MORE_BADGE = "key_gcs_more_has_badge";
    public static final String KEY_GCS_INVITATION_LIST_HAS_BADGE = "key_invitation_list_has_badge";
    public static final String KEY_GCS_UNREAD_COUNT = "PREF_KEY_GCS_UNREAD_COUNT";
    public static final String KEY_IS_LEADER = "is_leader";
    public static final String KEY_SELECTED_GROUP_ID = "selected_group_id";
    public static final String KEY_SELECTED_SPACE_ID = "selected_space_id";
    public static final String MEET = "meet";
    public static final String NOTIFICATION = "noti";
    public static final int REQUEST_CODE_LAUNCH_SOCIAL_PICKER = 104;
    public static final int REQUEST_INTENT_INVITATION_LIST = 10;
    public static final int REQUEST_INTENT_SOCIAL_SIGN_UP = 8;
    public static final int REQUEST_INTENT_SPACE_NOTE_LIST = 9;
    public static final int RESULT_ERROR = 1;
    public static final String SES_ACCEPTED_BY_NOTIFICATION = "accepted_by_notification";
    public static final String SES_GROUP_ID = "group_id";
    public static final String SES_GROUP_NAME = "group_name";
    public static final String SES_SPACE_ID = "space_id";
    public static final String SOCIAL_LINK = "social";
    public static final String STANDALONE_DEFAULT_TITLE = "Group://Standalone";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DialogTag {
        public static final String ADD_NOTEBOOK = "add_notebook_dialog";
        public static final String DELETE_NOTEBOOK = "delete_notebook_dialog";
        public static final String LEAVE_NOTEBOOK = "leave_notebook_dialog";
        public static final String RENAME_NOTEBOOK = "rename_notebook_dialog";
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'Invite' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class RequestType {
        private static final /* synthetic */ RequestType[] $VALUES;
        public static final RequestType Invite;
        public static final RequestType Member;
        public final int spaceNetworkFail;
        public final int spaceServerFail;
        public final int standaloneNetworkFail;
        public final int standaloneServerFail;
        public static final RequestType None = new RequestType("None", 0, -1, -1, -1, -1);
        public static final RequestType Create = new RequestType("Create", 1, C8003R.string.co_edit_standalone_create_network_fail, C8003R.string.gcs_group_create_network_fail, C8003R.string.co_edit_standalone_create_unknown_fail, C8003R.string.gcs_group_create_unknown_fail);
        public static final RequestType Delete = new RequestType("Delete", 2, C8003R.string.co_edit_standalone_delete_network_fail, C8003R.string.gcs_group_delete_network_fail, C8003R.string.co_edit_standalone_delete_unknown_fail, C8003R.string.gcs_group_delete_unknown_fail);
        public static final RequestType Leave = new RequestType("Leave", 3, C8003R.string.co_edit_standalone_leave_network_fail, C8003R.string.coedit_leave_network_fail, C8003R.string.co_edit_standalone_leave_unknown_fail, C8003R.string.coedit_leave_unknown_fail);
        public static final RequestType Rename = new RequestType("Rename", 4, C8003R.string.co_edit_standalone_rename_network_fail, C8003R.string.gcs_group_rename_network_fail, C8003R.string.co_edit_standalone_rename_unknown_fail, C8003R.string.gcs_group_rename_unknown_fail);

        private static /* synthetic */ RequestType[] $values() {
            return new RequestType[]{None, Create, Delete, Leave, Rename, Invite, Member};
        }

        static {
            int i = C8003R.string.gcs_invitations_network_fail;
            Invite = new RequestType("Invite", 5, i, i, -1, -1);
            int i2 = C8003R.string.network_error_check_your_network_connection_and_try_again;
            Member = new RequestType("Member", 6, i2, i2, -1, -1);
            $VALUES = $values();
        }

        private RequestType(String str, int i, int i2, int i4, int i5, int i6) {
            this.standaloneNetworkFail = i2;
            this.spaceNetworkFail = i4;
            this.standaloneServerFail = i5;
            this.spaceServerFail = i6;
        }

        public static RequestType valueOf(String str) {
            return (RequestType) Enum.valueOf(RequestType.class, str);
        }

        public static RequestType[] values() {
            return (RequestType[]) $VALUES.clone();
        }
    }
}
