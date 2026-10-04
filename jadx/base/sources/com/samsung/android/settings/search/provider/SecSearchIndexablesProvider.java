package com.samsung.android.settings.search.provider;

import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.settings.search.provider.SecSearchIndexablesContract;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class SecSearchIndexablesProvider extends SearchIndexablesProvider {
    private static final String SEC_EXTRA_KEY_FINGERPRINT = "key_fingerprint";
    private static final String SEC_EXTRA_KEY_VERSION = "key_version";
    private static final int SEC_MATCH_NON_INDEXABLE_KEYS_CODE = 300;
    private static final int SEC_MATCH_VARIABLE_RAW_DATA_CODE = 301;
    private static final String SEC_METHOD_GET_AVAILABILITY = "secGetAvailability";
    private static final String SEC_METHOD_GET_FINGERPRINT = "secGetFingerprint";
    private static final String SEC_METHOD_GET_PROVIDER_VERSION = "secGetVersion";
    private static final int SEC_SETTING_SEARCH_VERSION = 1;
    private static final String TAG = "SecSearchIndexablesProvider";
    private String mAuthority;
    private Bundle mExtraInfo = new Bundle();
    private UriMatcher mMatcher;

    private int getValueAsInt(Uri uri, String str, int i) {
        try {
            return Integer.parseInt(uri.getQueryParameter(str));
        } catch (NullPointerException | NumberFormatException e) {
            Log.e(TAG, "getValueAsInt() " + uri + " / " + e);
            return i;
        }
    }

    private boolean isNonIndexableKey(String str, Cursor cursor) {
        if (cursor != null && cursor.getCount() >= 1) {
            while (cursor.moveToNext()) {
                if (str.equals(cursor.getString(0))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void migrateExtraInfoFromBundle(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.mExtraInfo.putInt(SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, bundle.getInt(SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, -1));
    }

    private void migrateExtraInfoFromUri(Uri uri) {
        Set<String> queryParameterNames;
        if (uri == null || (queryParameterNames = uri.getQueryParameterNames()) == null || queryParameterNames.isEmpty()) {
            return;
        }
        for (String str : queryParameterNames) {
            str.getClass();
            if (str.equals(SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE)) {
                this.mExtraInfo.putInt(SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, getValueAsInt(uri, SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, -1));
            }
        }
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (TextUtils.isEmpty(secQueryGetFingerprint())) {
            throw new ClassCastException("secQueryGetFingerprint must implement");
        }
        this.mAuthority = providerInfo.authority;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.mMatcher = uriMatcher;
        uriMatcher.addURI(this.mAuthority, SecSearchIndexablesContract.SEC_VARIABLE_RAW_DATA_PATH, 301);
        this.mMatcher.addURI(this.mAuthority, SecSearchIndexablesContract.SEC_NON_INDEXABLES_KEYS_PATH, 300);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        migrateExtraInfoFromBundle(bundle);
        str.getClass();
        switch (str) {
            case "secGetVersion":
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString(SEC_EXTRA_KEY_VERSION, String.valueOf(1));
                return bundle;
            case "secGetAvailability":
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putInt(SecSearchIndexablesContract.SEC_EXTRA_KEY_AVAILABILITY, secQueryAvailability(bundle));
                return bundle;
            case "secGetFingerprint":
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString(SEC_EXTRA_KEY_FINGERPRINT, secQueryGetFingerprint());
                return bundle;
            default:
                return super.call(str, str2, bundle);
        }
    }

    public Context getSearchContext() {
        return getSearchContext(getContext());
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider, android.content.ContentProvider
    public String getType(Uri uri) {
        int iMatch = this.mMatcher.match(uri);
        return iMatch != 300 ? iMatch != 301 ? super.getType(uri) : SecSearchIndexablesContract.SecRawData.MIME_TYPE : SecSearchIndexablesContract.SecNonIndexableKey.MIME_TYPE;
    }

    public boolean isDexMode() {
        return this.mExtraInfo.getInt(SecSearchIndexablesContract.ExtraInfo.EXTRA_KEY_DEX_MODE, -1) == 1;
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider, android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Bundle bundle;
        migrateExtraInfoFromUri(uri);
        int iMatch = this.mMatcher.match(uri);
        if (iMatch != 300) {
            return iMatch != 301 ? super.query(uri, strArr, str, strArr2, str2) : secQueryVariableRawData(null);
        }
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames == null || queryParameterNames.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            for (String str3 : queryParameterNames) {
                bundle.putString(str3, uri.getQueryParameter(str3));
            }
        }
        return secQueryNonIndexableKeys(null, bundle);
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider
    public /* bridge */ /* synthetic */ Cursor queryDynamicRawData(String[] strArr) {
        return super.queryDynamicRawData(strArr);
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider
    public /* bridge */ /* synthetic */ Cursor querySiteMapPairs() {
        return super.querySiteMapPairs();
    }

    @Override // com.samsung.android.settings.search.provider.SearchIndexablesProvider
    public /* bridge */ /* synthetic */ Cursor querySliceUriPairs() {
        return super.querySliceUriPairs();
    }

    public int secQueryAvailability(Bundle bundle) {
        String string = bundle.getString(SecSearchIndexablesContract.SEC_EXTRA_KEY_PREFERENCE_KEY, "");
        if (TextUtils.isEmpty(string)) {
            return 1;
        }
        return isNonIndexableKey(string, bundle.containsKey(SecSearchIndexablesContract.SEC_EXTRA_KEY_REQUIRING_CONFIG_INFO) ? secQueryNonIndexableKeys(SearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS, bundle) : queryNonIndexableKeys(SearchIndexablesContract.NON_INDEXABLES_KEYS_COLUMNS)) ? 1 : 0;
    }

    @NonNull
    public abstract String secQueryGetFingerprint();

    public Cursor secQueryNonIndexableKeys(String[] strArr, @Nullable Bundle bundle) {
        return queryNonIndexableKeys(strArr);
    }

    @Deprecated
    public Cursor secQueryVariableRawData(String[] strArr) {
        return null;
    }

    public Context getSearchContext(Context context) {
        if (context == null) {
            return null;
        }
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        if (isDexMode()) {
        }
        return context.createConfigurationContext(configuration);
    }
}
