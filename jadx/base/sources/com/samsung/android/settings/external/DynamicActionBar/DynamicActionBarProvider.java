package com.samsung.android.settings.external.DynamicActionBar;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class DynamicActionBarProvider extends ContentProvider {
    public static final String EXTRA_ACTION_ERROR = "action_error";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_LATER_ERROR = "later_error";
    public static final String META_DATA_ACTION_BUTTON_TEXT = "com.android.settings.action_button_text";
    public static final String META_DATA_ACTION_BUTTON_URI = "com.android.settings.action_button_uri";
    public static final String META_DATA_CATEGORY_KEY = "com.android.settings.category";
    public static final String META_DATA_KEYHINT = "com.android.settings.keyhint";
    public static final String META_DATA_KEY_ORDER = "com.android.settings.order";
    public static final String META_DATA_LATER_BUTTON_TEXT = "com.android.settings.later_button_text";
    public static final String META_DATA_LATER_BUTTON_URI = "com.android.settings.later_button_uri";
    public static final String META_DATA_TITLE = "com.android.settings.title";
    public static final String META_DATA_TITLE_URI = "com.android.settings.title_uri";
    public static final String METHOD_GET_DATA = "getTitle";
    public static final String METHOD_GET_DYNAMIC_ACTION_BUTTON_TEXT = "getDynamicActionButtonText";
    public static final String METHOD_GET_DYNAMIC_LATER_BUTTON_TEXT = "getDynamicLaterButtonText";
    public static final String METHOD_GET_DYNAMIC_TITLE = "getDynamicTitle";
    public static final String METHOD_ON_ACTION_BUTTON_CLICKED = "onActionButtonClicked";
    public static final String METHOD_ON_LATER_BUTTON_CLICKED = "onLaterButtonClicked";
    private static final String TAG = "DynamicTitleProvider";
    private String mAuthority;
    private final Map<String, DynamicActionBarController> mControllerMap = new LinkedHashMap();
    private final ArrayList<Bundle> mDataList = new ArrayList<>();

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        String str = providerInfo.authority;
        this.mAuthority = str;
        Log.i(TAG, str);
        super.attachInfo(context, providerInfo);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c6  */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        String string = bundle != null ? bundle.getString(META_DATA_KEYHINT) : null;
        if (TextUtils.isEmpty(string)) {
            if (!METHOD_GET_DATA.equals(str)) {
                return null;
            }
            bundle2.putParcelableArrayList("data", this.mDataList);
            return bundle2;
        }
        DynamicActionBarController dynamicActionBarController = this.mControllerMap.get(string);
        if (dynamicActionBarController == 0) {
            return null;
        }
        str.getClass();
        switch (str) {
            case "getDynamicTitle":
                if (dynamicActionBarController instanceof DynamicTitle) {
                    bundle2.putString(META_DATA_TITLE, ((DynamicTitle) dynamicActionBarController).getDynamicTitle());
                }
                return bundle2;
            case "getDynamicLaterButtonText":
                if (dynamicActionBarController instanceof DynamicLaterButton) {
                    bundle2.putString(META_DATA_LATER_BUTTON_TEXT, ((DynamicLaterButton) dynamicActionBarController).getDynamicLaterButtonText());
                    return bundle2;
                }
                return bundle2;
            case "onLaterButtonClicked":
                if (dynamicActionBarController instanceof DynamicLaterButton) {
                    bundle2.putBoolean(EXTRA_LATER_ERROR, ((DynamicLaterButton) dynamicActionBarController).onLaterButtonClicked());
                    return bundle2;
                }
                throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown Uri format: ", str2));
            case "onActionButtonClicked":
                if (dynamicActionBarController instanceof DynamicActionButton) {
                    bundle2.putBoolean(EXTRA_ACTION_ERROR, ((DynamicActionButton) dynamicActionBarController).onActionButtonClicked());
                    return bundle2;
                }
                if (dynamicActionBarController instanceof DynamicLaterButton) {
                }
                return bundle2;
            case "getDynamicActionButtonText":
                if (dynamicActionBarController instanceof DynamicActionButton) {
                    bundle2.putString(META_DATA_ACTION_BUTTON_TEXT, ((DynamicActionButton) dynamicActionBarController).getDynamicActionButtonText());
                    return bundle2;
                }
                return bundle2;
            case "getTitle":
                return dynamicActionBarController.getBundle();
            default:
                throw new IllegalArgumentException(AbstractC0541b.m772n("Unknown Uri format: ", str2));
        }
    }

    public abstract List<DynamicActionBarController> createDynamicActionBarControllers();

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        return 0;
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

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        List<DynamicActionBarController> listCreateDynamicActionBarControllers = createDynamicActionBarControllers();
        if (listCreateDynamicActionBarControllers == null || listCreateDynamicActionBarControllers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (DynamicActionBarController dynamicActionBarController : listCreateDynamicActionBarControllers) {
            String key = dynamicActionBarController.getKey();
            if (TextUtils.isEmpty(key)) {
                throw new NullPointerException("Key cannot be null: ".concat(dynamicActionBarController.getClass().getSimpleName()));
            }
            if (this.mControllerMap.containsKey(key)) {
                StringBuilder sbM15l = AbstractC0000a.m15l("Key ", key, " is duplicated by: ");
                sbM15l.append(dynamicActionBarController.getClass().getSimpleName());
                throw new IllegalArgumentException(sbM15l.toString());
            }
            dynamicActionBarController.setAuthority(this.mAuthority);
            this.mControllerMap.put(key, dynamicActionBarController);
            this.mDataList.add(dynamicActionBarController.getBundle());
        }
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        return 0;
    }
}
