package com.samsung.android.settings.external;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.settings.external.DynamicSummaryData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class ExternalSettingsProvider extends ContentProvider {
    public static final String EXTRA_MENU = "menu";
    public static final String EXTRA_MENU_LIST = "menu_list";
    public static final String EXTRA_MENU_SUMMARY = "menu_summary";
    public static final String EXTRA_SEARCH_DATA = "search_data";
    public static final String METHOD_CHECKED_CHANGE = "checked_change";
    public static final String METHOD_GET_MENU_LIST = "get_menu_list";
    public static final String METHOD_GET_MENU_SUMMARY = "get_menu_summary";
    public static final String METHOD_GET_SEARCH_DATA = "get_search_data";
    public static final String METHOD_SELECT_MENU = "select_menu";
    public static final String TAG = "ExternalSettingsProvider";
    private String mAuthority;
    private HashMap<String, DynamicMenuData> mMenuBuilderMap = new HashMap<>();
    private HashMap<String, DynamicSearchData> mSearchBuilderMap = new HashMap<>();
    private int mSummaryOrder;
    private int mSummaryResID;

    private Uri makeUriWithKey(String str) {
        return Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.mAuthority + "/" + str);
    }

    private String updateTextResource(int i) {
        if (i == 0) {
            return null;
        }
        try {
            return getContext().getResources().getString(i);
        } catch (Exception unused) {
            return null;
        }
    }

    public void addMenuData(DynamicMenuData dynamicMenuData) {
        this.mMenuBuilderMap.put(dynamicMenuData.getKey(), dynamicMenuData);
    }

    public void addSearchData(DynamicSearchData dynamicSearchData) {
        this.mSearchBuilderMap.put(dynamicSearchData.getKey(), dynamicSearchData);
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        this.mAuthority = providerInfo.authority;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        DynamicSearchData dynamicSearchData;
        DynamicSummaryData dynamicSummaryDataBuild;
        if (METHOD_GET_MENU_LIST.equals(str)) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.addAll(this.mMenuBuilderMap.values());
            Iterator<? extends Parcelable> it = arrayList.iterator();
            while (it.hasNext()) {
                ((DynamicMenuData) it.next()).updateTextResource(getContext());
            }
            Bundle bundle2 = new Bundle();
            bundle2.setClassLoader(DynamicMenuData.class.getClassLoader());
            bundle2.putParcelableArrayList(EXTRA_MENU_LIST, arrayList);
            return bundle2;
        }
        if (METHOD_SELECT_MENU.equals(str)) {
            DynamicMenuData dynamicMenuData = this.mMenuBuilderMap.get(str2);
            if (dynamicMenuData != null) {
                dynamicMenuData.updateTextResource(getContext());
                Bundle bundle3 = new Bundle();
                bundle3.setClassLoader(DynamicMenuData.class.getClassLoader());
                bundle3.putParcelable(EXTRA_MENU, dynamicMenuData);
                return bundle3;
            }
        } else if (METHOD_CHECKED_CHANGE.equals(str)) {
            bundle.setClassLoader(DynamicMenuData.class.getClassLoader());
            DynamicMenuData dynamicMenuData2 = (DynamicMenuData) bundle.getParcelable(EXTRA_MENU);
            if (dynamicMenuData2 != null && onCheckedChanged(dynamicMenuData2.getKey(), dynamicMenuData2.getChecked())) {
                getContext().getContentResolver().notifyChange(makeUriWithKey(dynamicMenuData2.getKey()), null);
            }
        } else if (METHOD_GET_MENU_SUMMARY.equals(str)) {
            String strUpdateTextResource = updateTextResource(this.mSummaryResID);
            if (!TextUtils.isEmpty(strUpdateTextResource) && (dynamicSummaryDataBuild = new DynamicSummaryData.Builder().setOrder(this.mSummaryOrder).setSummary(strUpdateTextResource).build()) != null) {
                Bundle bundle4 = new Bundle();
                bundle4.setClassLoader(DynamicSummaryData.class.getClassLoader());
                bundle4.putParcelable(EXTRA_MENU_SUMMARY, dynamicSummaryDataBuild);
                return bundle4;
            }
        } else if (METHOD_GET_SEARCH_DATA.equals(str) && (dynamicSearchData = this.mSearchBuilderMap.get(str2)) != null) {
            dynamicSearchData.updateTextResource(getContext());
            Bundle bundle5 = new Bundle();
            bundle5.setClassLoader(DynamicSearchData.class.getClassLoader());
            bundle5.putParcelable(EXTRA_SEARCH_DATA, dynamicSearchData);
            return bundle5;
        }
        return super.call(str, str2, bundle);
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }

    public DynamicMenuData getMenuData(String str) {
        return this.mMenuBuilderMap.get(str);
    }

    public DynamicSearchData getSearchData(String str) {
        return this.mSearchBuilderMap.get(str);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    public abstract boolean onCheckedChanged(String str, boolean z);

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        onCreateData();
        return false;
    }

    public abstract void onCreateData();

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    public void reportDataChange(String str) {
        getContext().getContentResolver().notifyChange(makeUriWithKey(str), null);
    }

    public void setMenuSummary(int i, int i2) {
        this.mSummaryOrder = i;
        this.mSummaryResID = i2;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
