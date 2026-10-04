package androidx.credentials.provider;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.credentials.C2511R;
import androidx.credentials.CredentialOption;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectorySlice;
import com.samsung.android.settings.external.DynamicActionBar.DynamicActionBarProvider;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.poi.java.awt.GridBagConstraints;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(26)
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0007\u0018\u0000 '2\u00020\u0001:\u0003%&'B_\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012Bi\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u001aR\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0014\u0010\u0013\u001a\u00020\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 ¨\u0006("}, m13886d2 = {"Landroidx/credentials/provider/CustomCredentialEntry;", "Landroidx/credentials/provider/CredentialEntry;", "context", "Landroid/content/Context;", "title", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "subtitle", "typeDisplayName", "lastUsedTime", "Ljava/time/Instant;", "icon", "Landroid/graphics/drawable/Icon;", "isAutoSelectAllowed", "", "(Landroid/content/Context;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/time/Instant;Landroid/graphics/drawable/Icon;Z)V", "type", "", "autoSelectAllowedFromOption", "isDefaultIcon", "(Ljava/lang/String;Ljava/lang/CharSequence;Landroid/app/PendingIntent;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;Landroid/graphics/drawable/Icon;Ljava/time/Instant;Landroidx/credentials/provider/BeginGetCredentialOption;ZZ)V", "getIcon", "()Landroid/graphics/drawable/Icon;", "()Z", "getLastUsedTime", "()Ljava/time/Instant;", "getPendingIntent", "()Landroid/app/PendingIntent;", "getSubtitle", "()Ljava/lang/CharSequence;", DynamicActionBarProvider.METHOD_GET_DATA, "getType", "()Ljava/lang/String;", "getTypeDisplayName", "Api28Impl", "Builder", "Companion", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCustomCredentialEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomCredentialEntry.kt\nandroidx/credentials/provider/CustomCredentialEntry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,458:1\n1#2:459\n*E\n"})
public final class CustomCredentialEntry extends CredentialEntry {

    @NotNull
    private static final String AUTO_SELECT_FALSE_STRING = "false";

    @NotNull
    private static final String AUTO_SELECT_TRUE_STRING = "true";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int REVISION_ID = 1;

    @NotNull
    private static final String SLICE_HINT_AUTO_ALLOWED = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_ALLOWED";

    @NotNull
    private static final String SLICE_HINT_AUTO_SELECT_FROM_OPTION = "androidx.credentials.provider.credentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION";

    @NotNull
    private static final String SLICE_HINT_DEFAULT_ICON_RES_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID";

    @NotNull
    private static final String SLICE_HINT_ICON = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PROFILE_ICON";

    @NotNull
    private static final String SLICE_HINT_LAST_USED_TIME_MILLIS = "androidx.credentials.provider.credentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS";

    @NotNull
    private static final String SLICE_HINT_OPTION_ID = "androidx.credentials.provider.credentialEntry.SLICE_HINT_OPTION_ID";

    @NotNull
    private static final String SLICE_HINT_PENDING_INTENT = "androidx.credentials.provider.credentialEntry.SLICE_HINT_PENDING_INTENT";

    @NotNull
    private static final String SLICE_HINT_SUBTITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_CREDENTIAL_TYPE_DISPLAY_NAME";

    @NotNull
    private static final String SLICE_HINT_TITLE = "androidx.credentials.provider.credentialEntry.SLICE_HINT_USER_NAME";

    @NotNull
    private static final String SLICE_HINT_TYPE_DISPLAY_NAME = "androidx.credentials.provider.credentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME";

    @NotNull
    private static final String TAG = "CredentialEntry";
    private final boolean autoSelectAllowedFromOption;

    @NotNull
    private final Icon icon;
    private final boolean isAutoSelectAllowed;
    private final boolean isDefaultIcon;

    @Nullable
    private final Instant lastUsedTime;

    @NotNull
    private final PendingIntent pendingIntent;

    @Nullable
    private final CharSequence subtitle;

    @NotNull
    private final CharSequence title;

    @NotNull
    private final String type;

    @Nullable
    private final CharSequence typeDisplayName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0007¨\u0006\t"}, m13886d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Api28Impl;", "", "()V", "fromSlice", "Landroidx/credentials/provider/CustomCredentialEntry;", AzureActiveDirectorySlice.SLICE_PARAMETER, "Landroid/app/slice/Slice;", "toSlice", "entry", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    @RequiresApi(28)
    @SourceDebugExtension({"SMAP\nCustomCredentialEntry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomCredentialEntry.kt\nandroidx/credentials/provider/CustomCredentialEntry$Api28Impl\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,458:1\n1855#2,2:459\n*S KotlinDebug\n*F\n+ 1 CustomCredentialEntry.kt\nandroidx/credentials/provider/CustomCredentialEntry$Api28Impl\n*L\n243#1:459,2\n*E\n"})
    public static final class Api28Impl {

        @NotNull
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        @SuppressLint({"WrongConstant"})
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static final CustomCredentialEntry fromSlice(@NotNull Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            SliceSpec spec = slice.getSpec();
            Intrinsics.checkNotNull(spec);
            String type = spec.getType();
            Intrinsics.checkNotNullExpressionValue(type, "slice.spec!!.type");
            List<SliceItem> items = slice.getItems();
            Intrinsics.checkNotNullExpressionValue(items, "slice.items");
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            CharSequence text = null;
            CharSequence text2 = null;
            PendingIntent action = null;
            CharSequence text3 = null;
            CharSequence text4 = null;
            Icon icon = null;
            Instant instantOfEpochMilli = null;
            for (SliceItem sliceItem : items) {
                if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)) {
                    text4 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_TITLE)) {
                    text2 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_SUBTITLE)) {
                    text3 = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_ICON)) {
                    icon = sliceItem.getIcon();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_PENDING_INTENT)) {
                    action = sliceItem.getAction();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_OPTION_ID)) {
                    text = sliceItem.getText();
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS)) {
                    instantOfEpochMilli = Instant.ofEpochMilli(sliceItem.getLong());
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AUTO_ALLOWED)) {
                    if (Intrinsics.areEqual(sliceItem.getText(), "true")) {
                        z = true;
                    }
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION)) {
                    z2 = true;
                } else if (sliceItem.hasHint(CustomCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID)) {
                    z3 = true;
                }
            }
            try {
                Intrinsics.checkNotNull(text2);
                Intrinsics.checkNotNull(action);
                Intrinsics.checkNotNull(icon);
                Intrinsics.checkNotNull(text);
                return new CustomCredentialEntry(type, text2, action, z, text3, text4, icon, instantOfEpochMilli, new BeginGetCustomCredentialOption(text.toString(), type, new Bundle()), z2, z3);
            } catch (Exception e) {
                Log.i(CustomCredentialEntry.TAG, "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @NotNull
        public static final Slice toSlice(@NotNull CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            String type = entry.getType();
            CharSequence title = entry.getTitle();
            CharSequence subtitle = entry.getSubtitle();
            PendingIntent pendingIntent = entry.getPendingIntent();
            CharSequence typeDisplayName = entry.getTypeDisplayName();
            Instant lastUsedTime = entry.getLastUsedTime();
            Icon icon = entry.getIcon();
            boolean isAutoSelectAllowed = entry.getIsAutoSelectAllowed();
            BeginGetCredentialOption beginGetCredentialOption = entry.getBeginGetCredentialOption();
            Slice.Builder builderAddIcon = new Slice.Builder(Uri.EMPTY, new SliceSpec(type, 1)).addText(typeDisplayName, null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_TYPE_DISPLAY_NAME)).addText(title, null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_TITLE)).addText(subtitle, null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_SUBTITLE)).addText(isAutoSelectAllowed ? "true" : "false", null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_AUTO_ALLOWED)).addText(beginGetCredentialOption.getId(), null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_OPTION_ID)).addIcon(icon, null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_ICON));
            try {
                if (icon.getResId() == C2511R.drawable.ic_other_sign_in) {
                    builderAddIcon.addInt(1, null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_DEFAULT_ICON_RES_ID));
                }
            } catch (IllegalStateException unused) {
            }
            if (CredentialOption.INSTANCE.extractAutoSelectValue$credentials_release(beginGetCredentialOption.getCandidateQueryData())) {
                builderAddIcon.addInt(1, null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_AUTO_SELECT_FROM_OPTION));
            }
            if (lastUsedTime != null) {
                builderAddIcon.addLong(lastUsedTime.toEpochMilli(), null, CollectionsKt.listOf(CustomCredentialEntry.SLICE_HINT_LAST_USED_TIME_MILLIS));
            }
            builderAddIcon.addAction(pendingIntent, new Slice.Builder(builderAddIcon).addHints(Collections.singletonList(CustomCredentialEntry.SLICE_HINT_PENDING_INTENT)).build(), null);
            Slice sliceBuild = builderAddIcon.build();
            Intrinsics.checkNotNullExpressionValue(sliceBuild, "sliceBuilder.build()");
            return sliceBuild;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Builder;", "", "context", "Landroid/content/Context;", "type", "", "title", "", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "beginGetCredentialOption", "Landroidx/credentials/provider/BeginGetCredentialOption;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/CharSequence;Landroid/app/PendingIntent;Landroidx/credentials/provider/BeginGetCredentialOption;)V", "autoSelectAllowed", "", "icon", "Landroid/graphics/drawable/Icon;", "lastUsedTime", "Ljava/time/Instant;", "subtitle", "typeDisplayName", "build", "Landroidx/credentials/provider/CustomCredentialEntry;", "setAutoSelectAllowed", "setIcon", "setLastUsedTime", "setSubtitle", "setTypeDisplayName", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Builder {
        private boolean autoSelectAllowed;

        @NotNull
        private final BeginGetCredentialOption beginGetCredentialOption;

        @NotNull
        private final Context context;

        @Nullable
        private Icon icon;

        @Nullable
        private Instant lastUsedTime;

        @NotNull
        private final PendingIntent pendingIntent;

        @Nullable
        private CharSequence subtitle;

        @NotNull
        private final CharSequence title;

        @NotNull
        private final String type;

        @Nullable
        private CharSequence typeDisplayName;

        public Builder(@NotNull Context context, @NotNull String type, @NotNull CharSequence title, @NotNull PendingIntent pendingIntent, @NotNull BeginGetCredentialOption beginGetCredentialOption) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
            Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
            this.context = context;
            this.type = type;
            this.title = title;
            this.pendingIntent = pendingIntent;
            this.beginGetCredentialOption = beginGetCredentialOption;
        }

        @NotNull
        public final CustomCredentialEntry build() {
            if (this.icon == null) {
                this.icon = Icon.createWithResource(this.context, C2511R.drawable.ic_other_sign_in);
            }
            String str = this.type;
            CharSequence charSequence = this.title;
            PendingIntent pendingIntent = this.pendingIntent;
            boolean z = this.autoSelectAllowed;
            CharSequence charSequence2 = this.subtitle;
            CharSequence charSequence3 = this.typeDisplayName;
            Icon icon = this.icon;
            Intrinsics.checkNotNull(icon);
            return new CustomCredentialEntry(str, charSequence, pendingIntent, z, charSequence2, charSequence3, icon, this.lastUsedTime, this.beginGetCredentialOption, false, false, GridBagConstraints.ABOVE_BASELINE_TRAILING, null);
        }

        @NotNull
        public final Builder setAutoSelectAllowed(boolean autoSelectAllowed) {
            this.autoSelectAllowed = autoSelectAllowed;
            return this;
        }

        @NotNull
        public final Builder setIcon(@NotNull Icon icon) {
            Intrinsics.checkNotNullParameter(icon, "icon");
            this.icon = icon;
            return this;
        }

        @NotNull
        public final Builder setLastUsedTime(@Nullable Instant lastUsedTime) {
            this.lastUsedTime = lastUsedTime;
            return this;
        }

        @NotNull
        public final Builder setSubtitle(@Nullable CharSequence subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        @NotNull
        public final Builder setTypeDisplayName(@Nullable CharSequence typeDisplayName) {
            this.typeDisplayName = typeDisplayName;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Landroidx/credentials/provider/CustomCredentialEntry$Companion;", "", "()V", "AUTO_SELECT_FALSE_STRING", "", "AUTO_SELECT_TRUE_STRING", "REVISION_ID", "", "SLICE_HINT_AUTO_ALLOWED", "SLICE_HINT_AUTO_SELECT_FROM_OPTION", "SLICE_HINT_DEFAULT_ICON_RES_ID", "SLICE_HINT_ICON", "SLICE_HINT_LAST_USED_TIME_MILLIS", "SLICE_HINT_OPTION_ID", "SLICE_HINT_PENDING_INTENT", "SLICE_HINT_SUBTITLE", "SLICE_HINT_TITLE", "SLICE_HINT_TYPE_DISPLAY_NAME", SearchConstants.TargetContents.TAG, "fromSlice", "Landroidx/credentials/provider/CustomCredentialEntry;", AzureActiveDirectorySlice.SLICE_PARAMETER, "Landroid/app/slice/Slice;", "toSlice", "entry", "credentials_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @SuppressLint({"WrongConstant"})
        @Nullable
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public final CustomCredentialEntry fromSlice(@NotNull Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.fromSlice(slice);
            }
            return null;
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Nullable
        public final Slice toSlice(@NotNull CustomCredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.toSlice(entry);
            }
            return null;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CustomCredentialEntry(String str, CharSequence charSequence, PendingIntent pendingIntent, boolean z, CharSequence charSequence2, CharSequence charSequence3, Icon icon, Instant instant, BeginGetCredentialOption beginGetCredentialOption, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, charSequence, pendingIntent, z, charSequence2, charSequence3, icon, instant, beginGetCredentialOption, (i & 512) != 0 ? false : z2, (i & 1024) != 0 ? false : z3);
    }

    @JvmStatic
    @SuppressLint({"WrongConstant"})
    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final CustomCredentialEntry fromSlice(@NotNull Slice slice) {
        return INSTANCE.fromSlice(slice);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    public static final Slice toSlice(@NotNull CustomCredentialEntry customCredentialEntry) {
        return INSTANCE.toSlice(customCredentialEntry);
    }

    @NotNull
    public final Icon getIcon() {
        return this.icon;
    }

    @Nullable
    public final Instant getLastUsedTime() {
        return this.lastUsedTime;
    }

    @NotNull
    public final PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    @Nullable
    public final CharSequence getSubtitle() {
        return this.subtitle;
    }

    @NotNull
    public final CharSequence getTitle() {
        return this.title;
    }

    @Override // androidx.credentials.provider.CredentialEntry
    @NotNull
    public String getType() {
        return this.type;
    }

    @Nullable
    public final CharSequence getTypeDisplayName() {
        return this.typeDisplayName;
    }

    /* JADX INFO: renamed from: isAutoSelectAllowed, reason: from getter */
    public final boolean getIsAutoSelectAllowed() {
        return this.isAutoSelectAllowed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(@NotNull String type, @NotNull CharSequence title, @NotNull PendingIntent pendingIntent, boolean z, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @NotNull Icon icon, @Nullable Instant instant, @NotNull BeginGetCredentialOption beginGetCredentialOption, boolean z2, boolean z3) {
        super(type, beginGetCredentialOption);
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        this.type = type;
        this.title = title;
        this.pendingIntent = pendingIntent;
        this.isAutoSelectAllowed = z;
        this.subtitle = charSequence;
        this.typeDisplayName = charSequence2;
        this.icon = icon;
        this.lastUsedTime = instant;
        this.autoSelectAllowedFromOption = z2;
        this.isDefaultIcon = z3;
        if (getType().length() <= 0) {
            throw new IllegalArgumentException("type must not be empty");
        }
        if (title.length() <= 0) {
            throw new IllegalArgumentException("title must not be empty");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomCredentialEntry(Context context, CharSequence charSequence, PendingIntent pendingIntent, BeginGetCredentialOption beginGetCredentialOption, CharSequence charSequence2, CharSequence charSequence3, Instant instant, Icon icon, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        charSequence2 = (i & 16) != 0 ? null : charSequence2;
        charSequence3 = (i & 32) != 0 ? null : charSequence3;
        instant = (i & 64) != 0 ? null : instant;
        if ((i & 128) != 0) {
            icon = Icon.createWithResource(context, C2511R.drawable.ic_other_sign_in);
            Intrinsics.checkNotNullExpressionValue(icon, "createWithResource(conte…rawable.ic_other_sign_in)");
        }
        this(context, charSequence, pendingIntent, beginGetCredentialOption, charSequence2, charSequence3, instant, icon, (i & 256) != 0 ? false : z);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomCredentialEntry(@NotNull Context context, @NotNull CharSequence title, @NotNull PendingIntent pendingIntent, @NotNull BeginGetCredentialOption beginGetCredentialOption, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2, @Nullable Instant instant, @NotNull Icon icon, boolean z) {
        this(beginGetCredentialOption.getType(), title, pendingIntent, z, charSequence, charSequence2, icon, instant, beginGetCredentialOption, false, false, GridBagConstraints.ABOVE_BASELINE_TRAILING, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        Intrinsics.checkNotNullParameter(icon, "icon");
    }
}
