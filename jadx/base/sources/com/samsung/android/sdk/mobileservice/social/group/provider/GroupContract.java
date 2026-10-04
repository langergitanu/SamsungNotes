package com.samsung.android.sdk.mobileservice.social.group.provider;

import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class GroupContract {
    public static final String AUTHORITY = "com.samsung.android.mobileservice.social.group";
    private static final String AUTHORITY_URI = "content://com.samsung.android.mobileservice.social.group";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Group {
        public static final String AUTHORITY_MANAGE = "authorityManage";
        public static final String CONTENTS_UPDATE_TIME = "contents_update_time";
        public static final Uri CONTENT_URI = Uri.parse("content://com.samsung.android.mobileservice.social.group/");
        public static final String COVER_IMAGE = "groupCoverImage";
        public static final String COVER_THUMBNAIL_CONTENT_URI = "coverThumbnailContentUri";
        public static final String CREATED_TIME = "createdTime";
        public static final String EXPIRE_TIME = "expireTime";
        public static final String GROUP_ID = "groupId";
        public static final String GROUP_NAME = "groupName";
        public static final String LAST_SPACE_SYNCED_TIME = "last_space_synced_time";
        public static final String LEADER_ID = "ownerId";
        public static final String MAX_MEMBER_COUNT = "maxMemberCount";
        public static final String MEMBERS_COUNT = "membersCount";
        public static final String MEMBER_STATUS = "memberStatus";
        public static final String META_DATA = "metadata";
        public static final String PATTERN_WITH_DUMMY_FAMILY = "with_family";
        public static final String SERVICE_ID = "serviceId";
        public static final String THUMBNAIL_LOCAL_PATH = "thumbnail_local_path";
        public static final String TYPE = "type";
        public static final String UPDATED_TIME = "updatedTime";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Status {
            public static final int NORMAL = 2;
            public static final int PENDING = 1;

            private Status() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static class Type {
            public static final String AUTO_HOTSPOT = "AHSP";
            public static final String DUMMY_FAMILY = "DMFM";
            public static final String FAMILY = "FMLY";
            public static final String GENERAL = "GNRL";
            public static final String UNNAMED = "UNM1";

            private Type() {
            }
        }

        private Group() {
        }
    }

    private GroupContract() {
    }
}
