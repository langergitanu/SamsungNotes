package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u0000 &2\u00020\u0001:\u0003$%&Bi\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011BS\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0013\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0015J\r\u0010 \u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!J\r\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!J\r\u0010#\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006'"}, m13886d2 = {"Landroidx/credentials/provider/CreateEntry;", "", "accountName", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "description", "lastUsedTime", "Ljava/time/Instant;", "icon", "Landroid/graphics/drawable/Icon;", "passwordCredentialCount", "", "publicKeyCredentialCount", "totalCredentialCount", "isAutoSelectAllowed", "", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Z)V", "credentialCountInformationMap", "", "", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroid/graphics/drawable/Icon;Ljava/lang/CharSequence;Ljava/time/Instant;Ljava/util/Map;Z)V", "getAccountName", "()Ljava/lang/CharSequence;", "getDescription", "getIcon", "()Landroid/graphics/drawable/Icon;", "()Z", "getLastUsedTime", "()Ljava/time/Instant;", "getPendingIntent", "()Landroid/app/PendingIntent;", "getPasswordCredentialCount", "()Ljava/lang/Integer;", "getPublicKeyCredentialCount", "getTotalCredentialCount", "Api28Impl", "Builder", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCreateEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateEntry.kt\nandroidx/credentials/provider/CreateEntry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
public final class CreateEntry {

    @NotNull
    private static final String AUTO_SELECT_FALSE_STRING = "false";

    @NotNull
    private static final String AUTO_SELECT_TRUE_STRING = "true";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DESCRIPTION_MAX_CHAR_LIMIT = 300;
    private static final int REVISION_ID = 1;

    @NotNull
    private static final String SLICE_HINT_ACCOUNT_NAME = "androidx.credentials.provider.createEntry.SLICE_HINT_USER_PROVIDER_ACCOUNT_NAME";

    @NotNull
    private static final String SLICE_HINT_AUTO_SELECT_ALLOWED = "androidx.credentials.provider.createEntry.SLICE_HINT_AUTO_SELECT_ALLOWED";

    @NotNull
    private static final String SLICE_HINT_CREDENTIAL_COUNT_INFORMATION = "androidx.credentials.provider.createEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION";

    @NotNull
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.createEntry.SLICE_HINT_PROFILE_ICON";

    @NotNull
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.createEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";

    @NotNull
    private static final String SLICE_HINT_NOTE = "androidx.credentials.provider.createEntry.SLICE_HINT_NOTE";

    @NotNull
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.createEntry.SLICE_HINT_PENDING_INTENT";

    @NotNull
    private static final String SLICE_SPEC_TYPE = "CreateEntry";

    @NotNull
    private static final String TAG = "CreateEntry";

    @NotNull
    public static final String TYPE_TOTAL_CREDENTIAL = "TOTAL_CREDENTIAL_COUNT_TYPE";

    @NotNull
    private final CharSequence accountName;

    @NotNull
    private final Map<String, Integer> credentialCountInformationMap;

    @Nullable
    private final CharSequence description;

    @Nullable
    private final Icon icon;
    private final boolean isAutoSelectAllowed;

    @Nullable
    private final Instant lastUsedTime;

    @NotNull
    private final PendingIntent pendingIntent;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0002\b\tJ%\u0010\n\u001a\u0004\u0018\u00010\b2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0001¢\u0006\u0002\b\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000eH\u0007¨\u0006\u0013"}, m13886d2 = {"Landroidx/credentials/provider/CreateEntry$Api28Impl;", "", "()V", "convertBundleToCredentialCountInfo", "", "", "", "bundle", "Landroid/os/Bundle;", "convertBundleToCredentialCountInfo$credentials_release", "convertCredentialCountInfoToBundle", "credentialCountInformationMap", "convertCredentialCountInfoToBundle$credentials_release", "fromSlice", "Landroidx/credentials/provider/CreateEntry;", AzureActiveDirectorySlice.SLICE_PARAMETER, "Landroid/app/slice/Slice;", "toSlice", "createEntry", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RequiresApi(28)
    @SourceDebugExtension({"SMAP\nCreateEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CreateEntry.kt\nandroidx/credentials/provider/CreateEntry$Api28Impl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,487:1\n1855#2,2:488\n1855#2,2:490\n215#3,2:492\n*S KotlinDebug\n*F\n+ 1 CreateEntry.kt\nandroidx/credentials/provider/CreateEntry$Api28Impl\n*L\n347#1:488,2\n388#1:490,2\n404#1:492,2\n*E\n"})
    public static final class Api28Impl {

        @NotNull
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        @NotNull
        public static final Map<String, Integer> convertBundleToCredentialCountInfo$credentials_release(@Nullable Bundle bundle) {
            HashMap map = new HashMap();
            if (bundle != null) {
                Set<String> setKeySet = bundle.keySet();
                Intrinsics.checkNotNullExpressionValue(setKeySet, "bundle.keySet()");
                for (String it : setKeySet) {
                    try {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        map.put(it, Integer.valueOf(bundle.getInt(it)));
                    } catch (Exception e) {
                        Log.i("CreateEntry", "Issue unpacking credential count info bundle: " + e.getMessage());
                    }
                }
            }
            return map;
        }

        @JvmStatic
        @Nullable
        public static final Bundle convertCredentialCountInfoToBundle$credentials_release(@NotNull Map<String, Integer> credentialCountInformationMap) {
            Intrinsics.checkNotNullParameter(credentialCountInformationMap, "credentialCountInformationMap");
            Bundle bundle = new Bundle();
            boolean z = false;
            for (Map.Entry<String, Integer> entry : credentialCountInformationMap.entrySet()) {
                if (entry.getValue() != null) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    Intrinsics.checkNotNull(value);
                    bundle.putInt(key, value.intValue());
                    z = true;
                }
            }
            if (z) {
                return bundle;
            }
            return null;
        }

        @JvmStatic
        @SuppressLint({"WrongConstant"})
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static final CreateEntry fromSlice(@NotNull Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            Map mapAsMutableMap = linkedHashMap;
            CharSequence text = null;
            PendingIntent action = null;
            Icon icon = null;
            CharSequence text2 = null;
            Instant instantOfEpochMilli = null;
            boolean z = false;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(CreateEntry.SLICE_HINT_ACCOUNT_NAME)) {
                    text = sliceItem.getText();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_PENDING_INTENT)) {
                    action = sliceItem.getAction();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION)) {
                    Map<String, Integer> mapConvertBundleToCredentialCountInfo$credentials_release = convertBundleToCredentialCountInfo$credentials_release(sliceItem.getBundle());
                    Intrinsics.checkNotNull(mapConvertBundleToCredentialCountInfo$credentials_release, "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Int?>");
                    mapAsMutableMap = TypeIntrinsics.asMutableMap(mapConvertBundleToCredentialCountInfo$credentials_release);
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_NOTE)) {
                    text2 = sliceItem.getText();
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CreateEntry.SLICE_HINT_AUTO_SELECT_ALLOWED) && Intrinsics.areEqual(sliceItem.getText(), "true")) {
                    z = true;
                }
            }
            try {
                Intrinsics.checkNotNull(text);
                Intrinsics.checkNotNull(action);
                return new CreateEntry(text, action, icon, text2, instantOfEpochMilli, mapAsMutableMap, z);
            } catch (Exception e) {
                Log.i("CreateEntry", "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @NotNull
        public static final Slice toSlice(@NotNull CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "createEntry");
            CharSequence accountName = createEntry.getAccountName();
            Icon icon = createEntry.getIcon();
            CharSequence description = createEntry.getDescription();
            Instant lastUsedTime = createEntry.getLastUsedTime();
            Map map = createEntry.credentialCountInformationMap;
            PendingIntent pendingIntent = createEntry.getPendingIntent();
            Slice.Builder builder = new Slice.Builder(Uri.EMPTY, new SliceSpec("CreateEntry", 1));
            String str = createEntry.getIsAutoSelectAllowed() ? "true" : "false";
            builder.addText(accountName, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_ACCOUNT_NAME));
            if (lastUsedTime != null) {
                builder.addLong(lastUsedTime.toEpochMilli(), null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            if (description != null) {
                builder.addText(description, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_NOTE));
            }
            if (icon != null) {
                builder.addIcon(icon, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_ICON));
            }
            if (convertCredentialCountInfoToBundle$credentials_release(map) != null) {
                builder.addBundle(convertCredentialCountInfoToBundle$credentials_release(map), null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_CREDENTIAL_COUNT_INFORMATION));
            }
            builder.addAction(pendingIntent, new Slice.Builder(builder).addHints(Collections.singletonList(CreateEntry.SLICE_HINT_PENDING_INTENT)).build(), null).addText(str, null, CollectionsKt.listOf(CreateEntry.SLICE_HINT_AUTO_SELECT_ALLOWED));
            Slice sliceBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006 "}, m13886d2 = {"Landroidx/credentials/provider/CreateEntry$Builder;", "", "accountName", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "(Ljava/lang/CharSequence;Landroid/app/PendingIntent;)V", "autoSelectAllowed", "", "credentialCountInformationMap", "", "", "", "description", "icon", "Landroid/graphics/drawable/Icon;", "lastUsedTime", "Ljava/time/Instant;", "passwordCredentialCount", "Ljava/lang/Integer;", "publicKeyCredentialCount", "totalCredentialCount", "build", "Landroidx/credentials/provider/CreateEntry;", "setAutoSelectAllowed", "setDescription", "setIcon", "setLastUsedTime", "setPasswordCredentialCount", "count", "setPublicKeyCredentialCount", "setTotalCredentialCount", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Builder {

        @NotNull
        private final CharSequence accountName;
        private boolean autoSelectAllowed;

        @NotNull
        private Map<String, Integer> credentialCountInformationMap;

        @Nullable
        private CharSequence description;

        @Nullable
        private Icon icon;

        @Nullable
        private Instant lastUsedTime;

        @Nullable
        private Integer passwordCredentialCount;

        @NotNull
        private final PendingIntent pendingIntent;

        @Nullable
        private Integer publicKeyCredentialCount;

        @Nullable
        private Integer totalCredentialCount;

        public Builder(@NotNull CharSequence accountName, @NotNull PendingIntent pendingIntent) {
            Intrinsics.checkNotNullParameter(accountName, "accountName");
            Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
            this.accountName = accountName;
            this.pendingIntent = pendingIntent;
            this.credentialCountInformationMap = new LinkedHashMap();
        }

        @NotNull
        public final CreateEntry build() {
            return new CreateEntry(this.accountName, this.pendingIntent, this.icon, this.description, this.lastUsedTime, this.credentialCountInformationMap, this.autoSelectAllowed);
        }

        @NotNull
        public final Builder setAutoSelectAllowed(boolean autoSelectAllowed) {
            this.autoSelectAllowed = autoSelectAllowed;
            return this;
        }

        @NotNull
        public final Builder setDescription(@Nullable CharSequence description) {
            if ((description != null ? Integer.valueOf(description.length()) : null) != null && description.length() > 300) {
                throw new IllegalArgumentException("Description must follow a limit of 300 characters.");
            }
            this.description = description;
            return this;
        }

        @NotNull
        public final Builder setIcon(@Nullable Icon icon) {
            this.icon = icon;
            return this;
        }

        @NotNull
        public final Builder setLastUsedTime(@Nullable Instant lastUsedTime) {
            this.lastUsedTime = lastUsedTime;
            return this;
        }

        @NotNull
        public final Builder setPasswordCredentialCount(int count) {
            this.passwordCredentialCount = Integer.valueOf(count);
            this.credentialCountInformationMap.put(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, Integer.valueOf(count));
            return this;
        }

        @NotNull
        public final Builder setPublicKeyCredentialCount(int count) {
            this.publicKeyCredentialCount = Integer.valueOf(count);
            this.credentialCountInformationMap.put(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, Integer.valueOf(count));
            return this;
        }

        @NotNull
        public final Builder setTotalCredentialCount(int count) {
            this.totalCredentialCount = Integer.valueOf(count);
            this.credentialCountInformationMap.put(CreateEntry.TYPE_TOTAL_CREDENTIAL, Integer.valueOf(count));
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Landroidx/credentials/provider/CreateEntry$Companion;", "", "()V", "AUTO_SELECT_FALSE_STRING", "", "AUTO_SELECT_TRUE_STRING", "DESCRIPTION_MAX_CHAR_LIMIT", "", "REVISION_ID", "SLICE_HINT_ACCOUNT_NAME", "SLICE_HINT_AUTO_SELECT_ALLOWED", "SLICE_HINT_CREDENTIAL_COUNT_INFORMATION", "SLICE_HINT_ICON", "SLICE_HINT_LAST_USED_TIME_MILLIS", "SLICE_HINT_NOTE", "SLICE_HINT_PENDING_INTENT", "SLICE_SPEC_TYPE", SearchConstants.TargetContents.TAG, "TYPE_TOTAL_CREDENTIAL", "fromSlice", "Landroidx/credentials/provider/CreateEntry;", AzureActiveDirectorySlice.SLICE_PARAMETER, "Landroid/app/slice/Slice;", "toSlice", "createEntry", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Nullable
        public final CreateEntry fromSlice(@NotNull Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Nullable
        public final Slice toSlice(@NotNull CreateEntry createEntry) {
            Intrinsics.checkNotNullParameter(createEntry, "createEntry");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(createEntry);
            }
            return null;
        }

        private Companion() {
        }
    }

    public CreateEntry(@NotNull CharSequence accountName, @NotNull PendingIntent pendingIntent, @Nullable Icon icon, @Nullable CharSequence charSequence, @Nullable Instant instant, @NotNull Map<String, Integer> credentialCountInformationMap, boolean z) {
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(credentialCountInformationMap, "credentialCountInformationMap");
        this.accountName = accountName;
        this.pendingIntent = pendingIntent;
        this.icon = icon;
        this.description = charSequence;
        this.lastUsedTime = instant;
        this.credentialCountInformationMap = credentialCountInformationMap;
        this.isAutoSelectAllowed = z;
        if (accountName.length() <= 0) {
            throw new IllegalArgumentException("accountName must not be empty");
        }
        if (charSequence != null && charSequence.length() > 300) {
            throw new IllegalArgumentException("Description must follow a limit of 300 characters.");
        }
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    public static final CreateEntry fromSlice(@NotNull Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    public static final Slice toSlice(@NotNull CreateEntry createEntry) {
        return INSTANCE.toSlice(createEntry);
    }

    @NotNull
    public final CharSequence getAccountName() {
        return this.accountName;
    }

    @Nullable
    public final CharSequence getDescription() {
        return this.description;
    }

    @Nullable
    public final Icon getIcon() {
        return this.icon;
    }

    @Nullable
    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    @Nullable
    public final Integer getPasswordCredentialCount() {
        return this.credentialCountInformationMap.get(PasswordCredential.TYPE_PASSWORD_CREDENTIAL);
    }

    @NotNull
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    @Nullable
    public final Integer getPublicKeyCredentialCount() {
        return this.credentialCountInformationMap.get(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL);
    }

    @Nullable
    public final Integer getTotalCredentialCount() {
        return this.credentialCountInformationMap.get(TYPE_TOTAL_CREDENTIAL);
    }

    /* JADX INFO: renamed from: isAutoSelectAllowed, reason: from getter */
    public final boolean getIsAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    public /* synthetic */ CreateEntry(CharSequence charSequence, PendingIntent pendingIntent, CharSequence charSequence2, Instant instant, Icon icon, Integer num, Integer num2, Integer num3, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(charSequence, pendingIntent, (i & 4) != 0 ? null : charSequence2, (i & 8) != 0 ? null : instant, (i & 16) != 0 ? null : icon, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : num2, (i & 128) != 0 ? null : num3, (i & 256) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateEntry(@NotNull CharSequence accountName, @NotNull PendingIntent pendingIntent, @Nullable CharSequence charSequence, @Nullable Instant instant, @Nullable Icon icon, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, boolean z) {
        this(accountName, pendingIntent, icon, charSequence, instant, MapsKt.mutableMapOf(TuplesKt.m13893to(PasswordCredential.TYPE_PASSWORD_CREDENTIAL, num), TuplesKt.m13893to(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL, num2), TuplesKt.m13893to(TYPE_TOTAL_CREDENTIAL, num3)), z);
        Intrinsics.checkNotNullParameter(accountName, "accountName");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
    }
}
