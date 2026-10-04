package com.samsung.android.support.senl.p148nt.app.sync.providers;

import android.content.UriMatcher;
import android.net.Uri;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
class DocProviderMatchUtil {
    private static final String INSIGHT_PATH = "/#";
    public static final int URI_DOCUMENT_CODE = 400;
    public static final int URI_FINDER_SEARCH_CODE = 19;
    public static final int URI_TAGBOARD_SDOC_CODE = 201;
    public static final int URI_THUMBNAIL_CODE = 300;
    public static final int URI_THUMBNAIL_FINDER_CODE = 302;
    public static final int URI_THUMBNAIL_TAG_CODE = 301;
    private static final UriMatcher sUriMatcher = new UriMatcher(-1);

    static {
        addURI(ExternalDataConstants.URI_PATH_FINDER, 19);
        addURI(ExternalDataConstants.URI_PATH_TAG, 201);
        addURI("content", 300);
        addURI(ExternalDataConstants.URI_PATH_TAG_THUMBNAIL, 301);
        addURI(ExternalDataConstants.URI_PATH_FINDER_THUMBNAIL, 302);
        addURI(ExternalDataConstants.URI_PATH_SINGLE_DOCUMENT_UPDATED, 400);
        addURI(ExternalDataConstants.URI_PATH_MULTIPLE_DOCUMENTS_UPDATED, 400);
    }

    private static void addURI(String str, int i) {
        UriMatcher uriMatcher = sUriMatcher;
        uriMatcher.addURI("com.samsung.android.app.notes", str, i);
        uriMatcher.addURI("com.samsung.android.app.notes", str + INSIGHT_PATH, i);
    }

    public static int matchID(Uri uri) {
        int iMatch = sUriMatcher.match(uri);
        if (iMatch != -1) {
            return iMatch;
        }
        List<String> pathSegments = uri.getPathSegments();
        int size = pathSegments.size();
        if (size == 1 || size == 2) {
            String str = pathSegments.get(0);
            if ("content".equals(str)) {
                return 300;
            }
            if (ExternalDataConstants.URI_PATH_TAG_THUMBNAIL.equals(str)) {
                return 301;
            }
            if (ExternalDataConstants.URI_PATH_FINDER_THUMBNAIL.equals(str)) {
                return 302;
            }
            if (ExternalDataConstants.URI_PATH_SINGLE_DOCUMENT_UPDATED.equals(str) || ExternalDataConstants.URI_PATH_MULTIPLE_DOCUMENTS_UPDATED.equals(str)) {
                return 400;
            }
        }
        return -1;
    }
}
