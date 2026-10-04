package com.samsung.android.lib.galaxyfinder.search.api;

import android.R;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.app.NotificationCompat;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.app.notes.widget.util.AbstractC7011a;
import com.samsung.android.lib.galaxyfinder.search.api.search.SearchResult;
import com.samsung.android.lib.galaxyfinder.search.util.SearchLog;
import com.samsung.android.lib.galaxyfinder.search.util.SearchQueryUtils;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Keep
@Metadata(m13885d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b'\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0018H\u0016J/\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"H\u0016¢\u0006\u0002\u0010#J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010'\u001a\u00020\u000fH\u0016J\n\u0010(\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010)\u001a\u0006\u0012\u0002\b\u00030*2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u001d2\b\u0010-\u001a\u0004\u0018\u00010.H&J\u0012\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u00100\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\n\u00103\u001a\u0004\u0018\u000104H&J\n\u00105\u001a\u0004\u0018\u000104H&JK\u0010+\u001a\u0004\u0018\u0001062\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\b\u00108\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0002\u00109JU\u0010+\u001a\u0004\u0018\u0001062\u0006\u0010\u001e\u001a\u00020\u001f2\u000e\u00107\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"2\b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0002\u0010:J9\u0010;\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u00101\u001a\u0004\u0018\u0001022\b\u0010 \u001a\u0004\u0018\u00010\u000f2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\"H\u0016¢\u0006\u0002\u0010<R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/SamsungSearchProvider;", "Landroid/content/ContentProvider;", "()V", "info", "Landroid/content/pm/ProviderInfo;", "isSupportSearch", "", "()Z", "matcher", "Landroid/content/UriMatcher;", "moduleIconInternal", "Landroid/graphics/drawable/Icon;", "getModuleIconInternal", "()Landroid/graphics/drawable/Icon;", "moduleLabelInternal", "", "getModuleLabelInternal", "()Ljava/lang/String;", "providerKey", "attachInfo", "", "context", "Landroid/content/Context;", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "arg", "extras", OpenSessionApi.ITEM_LIMIT_DELETE, "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getLegacySearchActivity", "Landroid/content/ComponentName;", "getModuleIcon", "getModuleKey", "getModuleLabel", "getSearchResult", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/SearchResult;", "query", "limit", "cancellationSignal", "Landroid/os/CancellationSignal;", "getType", "insert", "values", "Landroid/content/ContentValues;", "makeAppLaunchIntent", "Landroid/content/Intent;", "makeInAppSearchIntent", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", Constants.ARG_UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class SamsungSearchProvider extends ContentProvider {
    private static final int MATCH_SEARCH_CODE = 1;

    @NotNull
    private static final String TAG = "SamsungSearchProvider";
    private ProviderInfo info;
    private UriMatcher matcher;
    private String providerKey;

    @NotNull
    private static final String apiVersion = "2.1.7";

    private final Icon getModuleIconInternal() {
        PackageManager packageManager;
        Icon moduleIcon = getModuleIcon();
        if (moduleIcon != null) {
            return moduleIcon;
        }
        ProviderInfo providerInfo = this.info;
        ProviderInfo providerInfo2 = null;
        if (providerInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            providerInfo = null;
        }
        if (providerInfo.icon != 0) {
            Context context = getContext();
            ProviderInfo providerInfo3 = this.info;
            if (providerInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("info");
            } else {
                providerInfo2 = providerInfo3;
            }
            Icon iconCreateWithResource = Icon.createWithResource(context, providerInfo2.icon);
            Intrinsics.checkNotNullExpressionValue(iconCreateWithResource, "createWithResource(context, info.icon)");
            return iconCreateWithResource;
        }
        Intent intentMakeAppLaunchIntent = makeAppLaunchIntent();
        if (intentMakeAppLaunchIntent != null) {
            try {
                Context context2 = getContext();
                ResolveInfo resolveInfoResolveActivity = (context2 == null || (packageManager = context2.getPackageManager()) == null) ? null : packageManager.resolveActivity(intentMakeAppLaunchIntent, 0);
                if (resolveInfoResolveActivity != null) {
                    Icon iconCreateWithResource2 = Icon.createWithResource(getContext(), resolveInfoResolveActivity.getIconResource());
                    Intrinsics.checkNotNullExpressionValue(iconCreateWithResource2, "createWithResource(conte…resolveInfo.iconResource)");
                    return iconCreateWithResource2;
                }
            } catch (Exception e) {
                SearchLog.INSTANCE.m5535e(TAG, "Fail to get Icon from AppLaunchIntent", e);
            }
        }
        ProviderInfo providerInfo4 = this.info;
        if (providerInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            providerInfo4 = null;
        }
        if (providerInfo4.getIconResource() == 0) {
            Icon iconCreateWithResource3 = Icon.createWithResource(TelemetryEventStrings.C6439Os.OS_NAME, R.drawable.sym_def_app_icon);
            Intrinsics.checkNotNullExpressionValue(iconCreateWithResource3, "createWithResource(\"andr…rawable.sym_def_app_icon)");
            return iconCreateWithResource3;
        }
        Context context3 = getContext();
        ProviderInfo providerInfo5 = this.info;
        if (providerInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
        } else {
            providerInfo2 = providerInfo5;
        }
        Icon iconCreateWithResource4 = Icon.createWithResource(context3, providerInfo2.getIconResource());
        Intrinsics.checkNotNullExpressionValue(iconCreateWithResource4, "{\n                Icon.c…onResource)\n            }");
        return iconCreateWithResource4;
    }

    private final String getModuleLabelInternal() {
        ActivityInfo activityInfo;
        Locale locale;
        String moduleLabel = getModuleLabel();
        if (moduleLabel != null && moduleLabel.length() != 0) {
            return getModuleLabel();
        }
        ProviderInfo providerInfo = this.info;
        ProviderInfo providerInfo2 = null;
        if (providerInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            providerInfo = null;
        }
        if (providerInfo.labelRes != 0) {
            ProviderInfo providerInfo3 = this.info;
            if (providerInfo3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("info");
            } else {
                providerInfo2 = providerInfo3;
            }
            Context context = getContext();
            Intrinsics.checkNotNull(context);
            CharSequence charSequenceLoadLabel = providerInfo2.loadLabel(context.getPackageManager());
            Intrinsics.checkNotNull(charSequenceLoadLabel, "null cannot be cast to non-null type kotlin.String");
            return (String) charSequenceLoadLabel;
        }
        Intent intentMakeAppLaunchIntent = makeAppLaunchIntent();
        if (intentMakeAppLaunchIntent != null) {
            try {
                Context context2 = getContext();
                Intrinsics.checkNotNull(context2);
                ResolveInfo resolveInfoResolveActivity = context2.getPackageManager().resolveActivity(intentMakeAppLaunchIntent, 0);
                if (resolveInfoResolveActivity != null && (activityInfo = resolveInfoResolveActivity.activityInfo) != null) {
                    int i = activityInfo.labelRes;
                    Context context3 = getContext();
                    Intrinsics.checkNotNull(context3);
                    Configuration configuration = new Configuration(context3.getResources().getConfiguration());
                    if (Build.VERSION.SDK_INT >= 33) {
                        Context context4 = getContext();
                        Intrinsics.checkNotNull(context4);
                        locale = AbstractC7011a.m5271a(context4.getSystemService(AbstractC7011a.m5279i())).getSystemLocales().get(0);
                    } else {
                        locale = Locale.getDefault();
                    }
                    configuration.setLocale(locale);
                    Context context5 = getContext();
                    Intrinsics.checkNotNull(context5);
                    return context5.createConfigurationContext(configuration).getText(i).toString();
                }
            } catch (Exception e) {
                SearchLog.INSTANCE.m5535e(TAG, "Fail to get Label from AppLaunchIntent", e);
            }
        }
        ProviderInfo providerInfo4 = this.info;
        if (providerInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
        } else {
            providerInfo2 = providerInfo4;
        }
        Context context6 = getContext();
        Intrinsics.checkNotNull(context6);
        CharSequence charSequenceLoadLabel2 = providerInfo2.loadLabel(context6.getPackageManager());
        Intrinsics.checkNotNull(charSequenceLoadLabel2, "null cannot be cast to non-null type kotlin.String");
        return (String) charSequenceLoadLabel2;
    }

    private final boolean isSupportSearch() {
        return true;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@NotNull Context context, @NotNull ProviderInfo info) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        this.info = info;
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.matcher = uriMatcher;
        ProviderInfo providerInfo = this.info;
        if (providerInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            providerInfo = null;
        }
        uriMatcher.addURI(providerInfo.authority, "v1/search", 1);
        UriMatcher uriMatcher2 = this.matcher;
        if (uriMatcher2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matcher");
            uriMatcher2 = null;
        }
        ProviderInfo providerInfo2 = this.info;
        if (providerInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            providerInfo2 = null;
        }
        uriMatcher2.addURI(providerInfo2.authority, null, 1);
        if (!info.exported) {
            throw new SecurityException("Provider must be exported");
        }
        if (!info.grantUriPermissions) {
            throw new SecurityException("Provider must grantUriPermissions");
        }
        if (info.readPermission == null) {
            throw new SecurityException("Provider must be protected by permission");
        }
        if (TextUtils.isEmpty(getModuleKey())) {
            throw new IllegalArgumentException("This key should be set.");
        }
        this.providerKey = getModuleKey();
        if (!isSupportSearch()) {
            throw new IllegalStateException("One or more features must be supported.");
        }
        super.attachInfo(context, info);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NotNull String method, @Nullable String arg, @Nullable Bundle extras) {
        Intrinsics.checkNotNullParameter(method, "method");
        SearchLog.INSTANCE.m5532d(TAG, "call method: " + method);
        if (extras == null) {
            extras = new Bundle();
        }
        String str = null;
        if (!Intrinsics.areEqual(method, "getInfo")) {
            return null;
        }
        String str2 = this.providerKey;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("providerKey");
        } else {
            str = str2;
        }
        extras.putString("module_key", str);
        extras.putString("api_version", apiVersion);
        extras.putString("label", getModuleLabelInternal());
        extras.putParcelable("icon", getModuleIconInternal());
        extras.putParcelable("launchIntent", makeAppLaunchIntent());
        extras.putParcelable("legacySearchActivity", getLegacySearchActivity());
        extras.putParcelable("inAppSearchActivity", makeInAppSearchIntent());
        return extras;
    }

    @Override // android.content.ContentProvider
    public int delete(@NotNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("Delete not supported");
    }

    @Nullable
    public ComponentName getLegacySearchActivity() {
        return null;
    }

    @Nullable
    public Icon getModuleIcon() {
        return null;
    }

    @NotNull
    public String getModuleKey() {
        ProviderInfo providerInfo = this.info;
        if (providerInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("info");
            providerInfo = null;
        }
        String str = providerInfo.packageName;
        Intrinsics.checkNotNullExpressionValue(str, "info.packageName");
        return str;
    }

    @Nullable
    public String getModuleLabel() {
        return null;
    }

    @NotNull
    public abstract SearchResult<?> getSearchResult(@NotNull String query, int limit, @Nullable CancellationSignal cancellationSignal);

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        UriMatcher uriMatcher = this.matcher;
        if (uriMatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matcher");
            uriMatcher = null;
        }
        if (uriMatcher.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.search";
        }
        throw new IllegalArgumentException(AbstractC0541b.m771m("Unknown URI ", uri));
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues values) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("Insert not supported");
    }

    @Nullable
    public abstract Intent makeAppLaunchIntent();

    @Nullable
    public abstract Intent makeInAppSearchIntent();

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return query(uri, projection, selection, selectionArgs, sortOrder, null);
    }

    @Override // android.content.ContentProvider
    public int update(@NotNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        throw new UnsupportedOperationException("Update not supported");
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder, @Nullable CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        UriMatcher uriMatcher = this.matcher;
        if (uriMatcher == null) {
            Intrinsics.throwUninitializedPropertyAccessException("matcher");
            uriMatcher = null;
        }
        if (uriMatcher.match(uri) != 1) {
            throw new UnsupportedOperationException(AbstractC0541b.m771m("Unknown Uri ", uri));
        }
        if (!isSupportSearch()) {
            throw new UnsupportedOperationException(AbstractC0541b.m771m("Unsupported Uri ", uri));
        }
        SearchQueryUtils searchQueryUtils = SearchQueryUtils.INSTANCE;
        String query = searchQueryUtils.getQuery(uri);
        String queryParameter = uri.getQueryParameter("requestId");
        Integer limit = searchQueryUtils.getLimit(uri);
        if (query != null && query.length() != 0 && queryParameter != null && queryParameter.length() != 0 && limit != null) {
            try {
                return getSearchResult(query, limit.intValue(), cancellationSignal).toResultCursor();
            } catch (Exception e) {
                SearchLog.INSTANCE.m5537f(TAG, "SearchResult is fail", e);
            }
        }
        return null;
    }
}
