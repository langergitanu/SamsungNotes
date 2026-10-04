package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.net.Uri;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupMemberContract;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SesGroupReadResolver extends SesGroupBaseReadResolver {
    private static final String TAG = "SesGroupReadResolver";
    private static SesGroupReadResolver mInstance;

    private SesGroupReadResolver() {
        this.mContentUri = getGroupContentUri();
    }

    public static synchronized SesGroupReadResolver getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new SesGroupReadResolver();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupContentUri() {
        return C0158a.m409d(BaseUtils.getApplicationContext()) ? GroupContract.Group.CONTENT_URI.buildUpon().appendPath("app_id").appendPath(CommonUtils.getOldNotesServiceId()).appendPath("feature_id").appendPath(String.valueOf(104)).appendPath("group").build() : GroupContract.Group.CONTENT_URI.buildUpon().appendPath("group").build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupMemberContentUri() {
        return C0158a.m409d(BaseUtils.getApplicationContext()) ? GroupMemberContract.GroupMember.CONTENT_URI.buildUpon().appendPath("app_id").appendPath(CommonUtils.getOldNotesServiceId()).appendPath("feature_id").appendPath(String.valueOf(104)).appendPath("group").build() : GroupMemberContract.GroupMember.CONTENT_URI.buildUpon().appendPath("group").build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupContentUri(String str) {
        return getGroupContentUri().buildUpon().appendPath(str).build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesGroupBaseReadResolver
    public Uri getGroupMemberContentUri(String str) {
        return getGroupMemberContentUri().buildUpon().appendPath(str).build();
    }
}
