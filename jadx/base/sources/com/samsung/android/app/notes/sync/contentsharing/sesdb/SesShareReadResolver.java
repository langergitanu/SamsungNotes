package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.net.Uri;
import androidx.appcompat.widget.AbstractC0541b;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SesShareReadResolver extends SesShareBaseReadResolver {
    private static final String AUTHORITY_ITEM;
    private static final String AUTHORITY_SPACE;
    private static final String CONTENT_ITEM_URI;
    private static final String CONTENT_SPACE_URI;
    private static final String TAG = "SesShareReadResolver";
    private static SesShareReadResolver mInstance;

    static {
        String str = "com.samsung.android.mobileservice.social.share.note_space/" + CommonUtils.getOldNotesServiceId();
        AUTHORITY_SPACE = str;
        String str2 = "com.samsung.android.mobileservice.social.share.note_item/" + CommonUtils.getOldNotesServiceId();
        AUTHORITY_ITEM = str2;
        CONTENT_SPACE_URI = AbstractC0541b.m772n(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME, str);
        CONTENT_ITEM_URI = AbstractC0541b.m772n(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME, str2);
        mInstance = null;
    }

    private SesShareReadResolver() {
        this.mContentUri = getSharedContentUri();
    }

    public static synchronized SesShareReadResolver getInstance() {
        try {
            if (mInstance == null) {
                mInstance = new SesShareReadResolver();
            }
        } catch (Throwable th) {
            throw th;
        }
        return mInstance;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedContentUri() {
        return Uri.parse(CONTENT_SPACE_URI + "/space");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedItemContentUri() {
        return Uri.parse(CONTENT_ITEM_URI + "/item");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedItemContentUri(String str) {
        return Uri.parse(CONTENT_ITEM_URI + "/space").buildUpon().appendPath(str).build();
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.SesShareBaseReadResolver
    public Uri getSharedItemContentUri(String str, String str2) {
        return Uri.parse(CONTENT_ITEM_URI + "/space").buildUpon().appendPath(str).appendPath("item").appendPath(str2).build();
    }
}
