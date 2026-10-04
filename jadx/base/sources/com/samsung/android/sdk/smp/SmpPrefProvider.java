package com.samsung.android.sdk.smp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.samsung.android.sdk.smp.common.preference.PrefInteractor;
import com.samsung.android.sdk.smp.common.sharedvariable.SharedMemoryVariable;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SmpPrefProvider extends ContentProvider {
    public static final String KEY = "key";
    private static final String TAG = "SmpPrefProvider";
    private static final int URI_MATCHER_INVALID = -1;
    private static final int URI_MATCHER_PREF_BOOLEAN = 2;
    private static final int URI_MATCHER_PREF_DELETE = 5;
    private static final int URI_MATCHER_PREF_INTEGER = 3;
    private static final int URI_MATCHER_PREF_LONG = 4;
    private static final int URI_MATCHER_PREF_STRING = 1;
    private static final int URI_MATCHER_VARIABLE_BOOLEAN = 8;
    private static final int URI_MATCHER_VARIABLE_DELETE_STRING_SET = 7;
    private static final int URI_MATCHER_VARIABLE_INTEGER = 9;
    private static final int URI_MATCHER_VARIABLE_STRING_SET = 6;
    public static final String VALUE = "value";

    private <T> MatrixCursor createCursor(T t) {
        if (t == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"value"}, 1);
        matrixCursor.newRow().add(t);
        return matrixCursor;
    }

    private int matchUri(Context context, Uri uri) {
        if (!(context.getPackageName() + ".smp.provider").equals(uri.getAuthority())) {
            SmpLog.m6494e(TAG, "Error : invalid authority");
            return -1;
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2 || pathSegments.size() == 3) {
            String str = pathSegments.get(0);
            str.getClass();
            switch (str) {
            }
            return -1;
        }
        return -1;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Context context = getContext();
        if (context == null) {
            SmpLog.m6494e(TAG, "delete error : context is null");
            return 0;
        }
        if (uri == null) {
            SmpLog.m6494e(TAG, "delete error : uri is null");
            return 0;
        }
        int iMatchUri = matchUri(context, uri);
        if (iMatchUri == 5) {
            PrefInteractor.getInstance(getContext()).remove(uri.getPathSegments().get(1));
            return 1;
        }
        if (iMatchUri == 7) {
            SharedMemoryVariable.getInstance().removeStringSet(uri.getPathSegments().get(1), uri.getPathSegments().get(2));
            return 1;
        }
        SmpLog.m6494e(TAG, "delete error : not supported uri - " + uri.toString());
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Context context = getContext();
        if (context == null) {
            SmpLog.m6494e(TAG, "query error : context is null");
            return null;
        }
        if (uri == null) {
            SmpLog.m6494e(TAG, "query error : uri is null");
            return null;
        }
        PrefInteractor prefInteractor = PrefInteractor.getInstance(context);
        int iMatchUri = matchUri(context, uri);
        if (iMatchUri == 1) {
            return createCursor(prefInteractor.getString(uri.getPathSegments().get(1), null));
        }
        if (iMatchUri == 2) {
            return createCursor(prefInteractor.getBoolean(uri.getPathSegments().get(1), "true".equals(uri.getPathSegments().get(2))));
        }
        if (iMatchUri == 3) {
            Integer integer = prefInteractor.getInteger(uri.getPathSegments().get(1), -99999999);
            return createCursor(integer.intValue() != -99999999 ? integer : null);
        }
        if (iMatchUri == 4) {
            Long l = prefInteractor.getLong(uri.getPathSegments().get(1), -99999999L);
            return createCursor(l.longValue() != -99999999 ? l : null);
        }
        if (iMatchUri == 6) {
            return createCursor((Set) SharedMemoryVariable.getInstance().getStringSet(uri.getPathSegments().get(1)));
        }
        if (iMatchUri == 8) {
            return createCursor(Boolean.valueOf(SharedMemoryVariable.getInstance().getBoolean(uri.getPathSegments().get(1), "true".equals(uri.getPathSegments().get(2)))));
        }
        if (iMatchUri == 9) {
            return createCursor(Integer.valueOf(SharedMemoryVariable.getInstance().getInteger(uri.getPathSegments().get(1), -1)));
        }
        SmpLog.m6494e(TAG, "query error : not supported uri - " + uri.toString());
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Integer asInteger;
        Context context = getContext();
        if (context == null) {
            SmpLog.m6494e(TAG, "update error : context is null");
            return 0;
        }
        if (uri == null) {
            SmpLog.m6494e(TAG, "update error : uri is null");
            return 0;
        }
        if (contentValues == null) {
            SmpLog.m6494e(TAG, "update error : values are null");
            return 0;
        }
        PrefInteractor prefInteractor = PrefInteractor.getInstance(context);
        String asString = contentValues.getAsString("key");
        int iMatchUri = matchUri(context, uri);
        if (iMatchUri == 1) {
            prefInteractor.putString(asString, contentValues.getAsString("value"));
            return 1;
        }
        if (iMatchUri == 2) {
            Boolean asBoolean = contentValues.getAsBoolean("value");
            if (asBoolean != null) {
                prefInteractor.putBoolean(asString, asBoolean.booleanValue());
                return 1;
            }
        } else if (iMatchUri == 3) {
            Integer asInteger2 = contentValues.getAsInteger("value");
            if (asInteger2 != null) {
                prefInteractor.putInteger(asString, asInteger2.intValue());
                return 1;
            }
        } else if (iMatchUri == 4) {
            Long asLong = contentValues.getAsLong("value");
            if (asLong != null) {
                prefInteractor.putLong(asString, asLong.longValue());
                return 1;
            }
        } else {
            if (iMatchUri == 6) {
                SharedMemoryVariable.getInstance().putStringSet(asString, contentValues.getAsString("value"));
                return 1;
            }
            if (iMatchUri == 8) {
                Boolean asBoolean2 = contentValues.getAsBoolean("value");
                if (asBoolean2 != null) {
                    SharedMemoryVariable.getInstance().putBoolean(asString, asBoolean2.booleanValue());
                    return 1;
                }
            } else if (iMatchUri == 9 && (asInteger = contentValues.getAsInteger("value")) != null) {
                SharedMemoryVariable.getInstance().putInteger(asString, asInteger.intValue());
                return 1;
            }
        }
        SmpLog.m6494e(TAG, "update error : not supported uri - " + uri.toString());
        return 0;
    }

    private <T> MatrixCursor createCursor(Set<T> set) {
        if (set == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"value"}, 1);
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            matrixCursor.newRow().add(it.next());
        }
        return matrixCursor;
    }
}
