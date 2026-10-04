package androidx.core.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.util.Base64;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import androidx.annotation.RestrictTo;
import androidx.core.content.p110pm.PackageInfoCompat;
import androidx.core.remoteviews.C2399R;
import androidx.core.widget.RemoteViewsCompat;
import androidx.core.widget.RemoteViewsCompatService;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0003\u0007\b\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, m13886d2 = {"Landroidx/core/widget/RemoteViewsCompatService;", "Landroid/widget/RemoteViewsService;", "()V", "onGetViewFactory", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "Companion", "RemoteViewsCompatServiceData", "RemoteViewsCompatServiceViewFactory", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@SourceDebugExtension({"SMAP\nRemoteViewsCompatService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteViewsCompatService.kt\nandroidx/core/widget/RemoteViewsCompatService\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,319:1\n1#2:320\n*E\n"})
public final class RemoteViewsCompatService extends RemoteViewsService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String EXTRA_VIEW_ID = "androidx.core.widget.extra.view_id";

    @NotNull
    private static final String TAG = "RemoteViewsCompatServic";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m13886d2 = {"Landroidx/core/widget/RemoteViewsCompatService$Companion;", "", "()V", "EXTRA_VIEW_ID", "", SearchConstants.TargetContents.TAG, "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "saveItems", "", "items", "Landroidx/core/widget/RemoteViewsCompat$RemoteCollectionItems;", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Intent createIntent(@NotNull Context context, int appWidgetId, int viewId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent(context, (Class<?>) RemoteViewsCompatService.class).putExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, appWidgetId).putExtra(RemoteViewsCompatService.EXTRA_VIEW_ID, viewId);
            Intrinsics.checkNotNullExpressionValue(intentPutExtra, "Intent(context, RemoteVi…ra(EXTRA_VIEW_ID, viewId)");
            intentPutExtra.setData(Uri.parse(intentPutExtra.toUri(1)));
            return intentPutExtra;
        }

        public final void saveItems(@NotNull Context context, int appWidgetId, int viewId, @NotNull RemoteViewsCompat.RemoteCollectionItems items) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(items, "items");
            RemoteViewsCompatServiceData.INSTANCE.create(context, items).save(context, appWidgetId, viewId);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Landroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceData;", "", "itemsBytes", "", "buildVersion", "", "appVersion", "", "([BLjava/lang/String;J)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mAppVersion", "mBuildVersion", "mItemsBytes", "save", "", "context", "Landroid/content/Context;", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "writeToParcel", "dest", "Companion", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class RemoteViewsCompatServiceData {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private static final String PREFS_FILENAME = "androidx.core.widget.prefs.RemoteViewsCompat";
        private final long mAppVersion;

        @NotNull
        private final String mBuildVersion;

        @NotNull
        private final byte[] mItemsBytes;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ1\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\f0\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0014\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\f0\u0010H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001cJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001fJ\u0019\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0004\b\"\u0010#J'\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0002\b%J'\u0010&\u001a\u00020\u000e2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020)0(H\u0000¢\u0006\u0002\b*J'\u0010+\u001a\u00020\u00042\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020)0(H\u0000¢\u0006\u0002\b,R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006-"}, m13886d2 = {"Landroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion;", "", "()V", "PREFS_FILENAME", "", "create", "Landroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceData;", "context", "Landroid/content/Context;", "items", "Landroidx/core/widget/RemoteViewsCompat$RemoteCollectionItems;", "deserializeFromBytes", "P", "bytes", "", "creator", "Lkotlin/Function1;", "Landroid/os/Parcel;", "deserializeFromBytes$core_remoteviews_release", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "deserializeFromHexString", "hexString", "deserializeFromHexString$core_remoteviews_release", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getKey", BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, "", "viewId", "getKey$core_remoteviews_release", "getPrefs", "Landroid/content/SharedPreferences;", "getPrefs$core_remoteviews_release", "getVersionCode", "", "getVersionCode$core_remoteviews_release", "(Landroid/content/Context;)Ljava/lang/Long;", "load", "load$core_remoteviews_release", "serializeToBytes", "parcelable", "Lkotlin/Function2;", "", "serializeToBytes$core_remoteviews_release", "serializeToHexString", "serializeToHexString$core_remoteviews_release", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        @SourceDebugExtension({"SMAP\nRemoteViewsCompatService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteViewsCompatService.kt\nandroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,319:1\n1#2:320\n*E\n"})
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final RemoteViewsCompatServiceData create(@NotNull Context context, @NotNull RemoteViewsCompat.RemoteCollectionItems items) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(items, "items");
                Long versionCode$core_remoteviews_release = getVersionCode$core_remoteviews_release(context);
                if (versionCode$core_remoteviews_release == null) {
                    throw new IllegalStateException("Couldn't obtain version code for app");
                }
                byte[] bArrSerializeToBytes$core_remoteviews_release = serializeToBytes$core_remoteviews_release(new C2484xa6c0a158(items));
                String INCREMENTAL = Build.VERSION.INCREMENTAL;
                Intrinsics.checkNotNullExpressionValue(INCREMENTAL, "INCREMENTAL");
                return new RemoteViewsCompatServiceData(bArrSerializeToBytes$core_remoteviews_release, INCREMENTAL, versionCode$core_remoteviews_release.longValue(), null);
            }

            public final <P> P deserializeFromBytes$core_remoteviews_release(@NotNull byte[] bytes, @NotNull Function1<? super Parcel, ? extends P> creator) {
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                Intrinsics.checkNotNullParameter(creator, "creator");
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
                try {
                    parcelObtain.unmarshall(bytes, 0, bytes.length);
                    parcelObtain.setDataPosition(0);
                    return creator.invoke(parcelObtain);
                } finally {
                    parcelObtain.recycle();
                }
            }

            public final <P> P deserializeFromHexString$core_remoteviews_release(@NotNull String hexString, @NotNull Function1<? super Parcel, ? extends P> creator) {
                Intrinsics.checkNotNullParameter(hexString, "hexString");
                Intrinsics.checkNotNullParameter(creator, "creator");
                byte[] bArrDecode = Base64.decode(hexString, 0);
                Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(hexString, Base64.DEFAULT)");
                return (P) deserializeFromBytes$core_remoteviews_release(bArrDecode, creator);
            }

            @NotNull
            public final String getKey$core_remoteviews_release(int appWidgetId, int viewId) {
                StringBuilder sb = new StringBuilder();
                sb.append(appWidgetId);
                sb.append(':');
                sb.append(viewId);
                return sb.toString();
            }

            @NotNull
            public final SharedPreferences getPrefs$core_remoteviews_release(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                SharedPreferences sharedPreferences = context.getSharedPreferences(RemoteViewsCompatServiceData.PREFS_FILENAME, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…S_FILENAME, MODE_PRIVATE)");
                return sharedPreferences;
            }

            @Nullable
            public final Long getVersionCode$core_remoteviews_release(@NotNull Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                try {
                    return Long.valueOf(PackageInfoCompat.getLongVersionCode(context.getPackageManager().getPackageInfo(context.getPackageName(), 0)));
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e(RemoteViewsCompatService.TAG, "Couldn't retrieve version code for " + context.getPackageManager(), e);
                    return null;
                }
            }

            @Nullable
            public final RemoteViewsCompat.RemoteCollectionItems load$core_remoteviews_release(@NotNull Context context, int appWidgetId, int viewId) {
                Intrinsics.checkNotNullParameter(context, "context");
                String string = getPrefs$core_remoteviews_release(context).getString(getKey$core_remoteviews_release(appWidgetId, viewId), null);
                if (string == null) {
                    Log.w(RemoteViewsCompatService.TAG, "No collection items were stored for widget " + appWidgetId);
                    return null;
                }
                RemoteViewsCompatServiceData remoteViewsCompatServiceData = (RemoteViewsCompatServiceData) deserializeFromHexString$core_remoteviews_release(string, new Function1<Parcel, RemoteViewsCompatServiceData>() { // from class: androidx.core.widget.RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion$load$data$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final RemoteViewsCompatService.RemoteViewsCompatServiceData invoke(@NotNull Parcel it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return new RemoteViewsCompatService.RemoteViewsCompatServiceData(it);
                    }
                });
                if (!Intrinsics.areEqual(Build.VERSION.INCREMENTAL, remoteViewsCompatServiceData.mBuildVersion)) {
                    Log.w(RemoteViewsCompatService.TAG, "Android version code has changed, not using stored collection items for widget " + appWidgetId);
                    return null;
                }
                Long versionCode$core_remoteviews_release = getVersionCode$core_remoteviews_release(context);
                if (versionCode$core_remoteviews_release == null) {
                    Log.w(RemoteViewsCompatService.TAG, "Couldn't get version code, not using stored collection items for widget " + appWidgetId);
                    return null;
                }
                if (versionCode$core_remoteviews_release.longValue() != remoteViewsCompatServiceData.mAppVersion) {
                    Log.w(RemoteViewsCompatService.TAG, "App version code has changed, not using stored collection items for widget " + appWidgetId);
                    return null;
                }
                try {
                    return (RemoteViewsCompat.RemoteCollectionItems) deserializeFromBytes$core_remoteviews_release(remoteViewsCompatServiceData.mItemsBytes, new Function1<Parcel, RemoteViewsCompat.RemoteCollectionItems>() { // from class: androidx.core.widget.RemoteViewsCompatService$RemoteViewsCompatServiceData$Companion$load$1
                        @Override // kotlin.jvm.functions.Function1
                        @NotNull
                        public final RemoteViewsCompat.RemoteCollectionItems invoke(@NotNull Parcel it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return new RemoteViewsCompat.RemoteCollectionItems(it);
                        }
                    });
                } catch (Throwable th) {
                    Log.e(RemoteViewsCompatService.TAG, "Unable to deserialize stored collection items for widget " + appWidgetId, th);
                    return null;
                }
            }

            @NotNull
            public final byte[] serializeToBytes$core_remoteviews_release(@NotNull Function2<? super Parcel, ? super Integer, Unit> parcelable) {
                Intrinsics.checkNotNullParameter(parcelable, "parcelable");
                Parcel parcelObtain = Parcel.obtain();
                Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain()");
                try {
                    parcelObtain.setDataPosition(0);
                    parcelable.invoke(parcelObtain, 0);
                    byte[] bArrMarshall = parcelObtain.marshall();
                    Intrinsics.checkNotNullExpressionValue(bArrMarshall, "{\n                    pa…shall()\n                }");
                    return bArrMarshall;
                } finally {
                    parcelObtain.recycle();
                }
            }

            @NotNull
            public final String serializeToHexString$core_remoteviews_release(@NotNull Function2<? super Parcel, ? super Integer, Unit> parcelable) {
                Intrinsics.checkNotNullParameter(parcelable, "parcelable");
                String strEncodeToString = Base64.encodeToString(serializeToBytes$core_remoteviews_release(parcelable), 0);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(serialize…celable), Base64.DEFAULT)");
                return strEncodeToString;
            }

            private Companion() {
            }
        }

        public /* synthetic */ RemoteViewsCompatServiceData(byte[] bArr, String str, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(bArr, str, j);
        }

        public final void save(@NotNull Context context, int appWidgetId, int viewId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Companion companion = INSTANCE;
            companion.getPrefs$core_remoteviews_release(context).edit().putString(companion.getKey$core_remoteviews_release(appWidgetId, viewId), companion.serializeToHexString$core_remoteviews_release(new Function2<Parcel, Integer, Unit>() { // from class: androidx.core.widget.RemoteViewsCompatService$RemoteViewsCompatServiceData$save$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Parcel parcel, Integer num) {
                    invoke(parcel, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    this.this$0.writeToParcel(parcel);
                }
            })).apply();
        }

        public final void writeToParcel(@NotNull Parcel dest) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeInt(this.mItemsBytes.length);
            dest.writeByteArray(this.mItemsBytes);
            dest.writeString(this.mBuildVersion);
            dest.writeLong(this.mAppVersion);
        }

        private RemoteViewsCompatServiceData(byte[] bArr, String str, long j) {
            this.mItemsBytes = bArr;
            this.mBuildVersion = str;
            this.mAppVersion = j;
        }

        public RemoteViewsCompatServiceData(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            byte[] bArr = new byte[parcel.readInt()];
            this.mItemsBytes = bArr;
            parcel.readByteArray(bArr);
            String string = parcel.readString();
            Intrinsics.checkNotNull(string);
            this.mBuildVersion = string;
            this.mAppVersion = parcel.readLong();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Landroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceViewFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "mContext", "Landroid/content/Context;", "mAppWidgetId", "", "mViewId", "(Landroid/content/Context;II)V", "mItems", "Landroidx/core/widget/RemoteViewsCompat$RemoteCollectionItems;", "getCount", "getItemId", "", "position", "getLoadingView", "", "getViewAt", "Landroid/widget/RemoteViews;", "getViewTypeCount", "hasStableIds", "", "loadData", "", "onCreate", "onDataSetChanged", "onDestroy", "Companion", "core-remoteviews_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRemoteViewsCompatService.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteViewsCompatService.kt\nandroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceViewFactory\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n*L\n1#1,319:1\n26#2:320\n*S KotlinDebug\n*F\n+ 1 RemoteViewsCompatService.kt\nandroidx/core/widget/RemoteViewsCompatService$RemoteViewsCompatServiceViewFactory\n*L\n95#1:320\n*E\n"})
    public static final class RemoteViewsCompatServiceViewFactory implements RemoteViewsService.RemoteViewsFactory {

        @NotNull
        private static final RemoteViewsCompat.RemoteCollectionItems EMPTY = new RemoteViewsCompat.RemoteCollectionItems(new long[0], new RemoteViews[0], false, 1);
        private final int mAppWidgetId;

        @NotNull
        private final Context mContext;

        @NotNull
        private RemoteViewsCompat.RemoteCollectionItems mItems;
        private final int mViewId;

        public RemoteViewsCompatServiceViewFactory(@NotNull Context mContext, int i, int i2) {
            Intrinsics.checkNotNullParameter(mContext, "mContext");
            this.mContext = mContext;
            this.mAppWidgetId = i;
            this.mViewId = i2;
            this.mItems = EMPTY;
        }

        private final void loadData() {
            RemoteViewsCompat.RemoteCollectionItems remoteCollectionItemsLoad$core_remoteviews_release = RemoteViewsCompatServiceData.INSTANCE.load$core_remoteviews_release(this.mContext, this.mAppWidgetId, this.mViewId);
            if (remoteCollectionItemsLoad$core_remoteviews_release == null) {
                remoteCollectionItemsLoad$core_remoteviews_release = EMPTY;
            }
            this.mItems = remoteCollectionItemsLoad$core_remoteviews_release;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getCount() {
            return this.mItems.getItemCount();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public long getItemId(int position) {
            try {
                return this.mItems.getItemId(position);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return -1L;
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @Nullable
        public Void getLoadingView() {
            return null;
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        @NotNull
        public RemoteViews getViewAt(int position) {
            try {
                return this.mItems.getItemView(position);
            } catch (ArrayIndexOutOfBoundsException unused) {
                return new RemoteViews(this.mContext.getPackageName(), C2399R.layout.invalid_list_item);
            }
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public int getViewTypeCount() {
            return this.mItems.getMViewTypeCount();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public boolean hasStableIds() {
            return this.mItems.getMHasStableIds();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onCreate() {
            loadData();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDataSetChanged() {
            loadData();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public /* bridge */ /* synthetic */ RemoteViews getLoadingView() {
            return (RemoteViews) getLoadingView();
        }

        @Override // android.widget.RemoteViewsService.RemoteViewsFactory
        public void onDestroy() {
        }
    }

    @Override // android.widget.RemoteViewsService
    @NotNull
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        int intExtra = intent.getIntExtra(BaseWidgetConstant.EXTRA_KEY_FROM_WIDGET_ID, -1);
        if (intExtra == -1) {
            throw new IllegalStateException("No app widget id was present in the intent");
        }
        int intExtra2 = intent.getIntExtra(EXTRA_VIEW_ID, -1);
        if (intExtra2 != -1) {
            return new RemoteViewsCompatServiceViewFactory(this, intExtra, intExtra2);
        }
        throw new IllegalStateException("No view id was present in the intent");
    }
}
