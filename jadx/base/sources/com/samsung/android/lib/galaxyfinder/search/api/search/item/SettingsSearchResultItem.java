package com.samsung.android.lib.galaxyfinder.search.api.search.item;

import android.net.Uri;
import com.samsung.android.lib.galaxyfinder.search.api.payload.IntentResultItemPayload;
import com.samsung.android.lib.galaxyfinder.search.api.payload.ResultItemPayload;
import com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fBC\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\u0010\rB\u000f\b\u0012\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SettingsSearchResultItem;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "itemKey", "", "menuIcon", "Landroid/net/Uri;", "menuName", "menuDescription", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "actions", "", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem$LabeledPayload;", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;Ljava/util/List;)V", "builder", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SettingsSearchResultItem$Builder;", "(Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SettingsSearchResultItem$Builder;)V", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "group", "getGroup", "getMenuIcon", "()Landroid/net/Uri;", "getMenuName", "menuPath", "getMenuPath", "setMenuPath", "Builder", "Companion", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class SettingsSearchResultItem extends SearchResultItem {

    @NotNull
    private static final String TAG = "SettingsSearchResultItem";

    @Nullable
    private String description;

    @Nullable
    private final Uri menuIcon;

    @Nullable
    private final String menuName;

    @Nullable
    private String menuPath;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001b\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\b\"\u0004\b\u0012\u0010\u0005R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\b\"\u0004\b\u0015\u0010\u0005¨\u0006\u001d"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SettingsSearchResultItem$Builder;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem$Builder;", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SettingsSearchResultItem;", "itemKey", "", "(Ljava/lang/String;)V", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "icon", "Landroid/net/Uri;", "getIcon", "()Landroid/net/Uri;", "setIcon", "(Landroid/net/Uri;)V", "menuName", "getMenuName", "setMenuName", "menuPath", "getMenuPath", "setMenuPath", Bixby2Constants.BIXBY_ACTION_ADD_ACTION, "text", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;", "build", "setPayload", "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Builder extends SearchResultItem.Builder<SettingsSearchResultItem> {

        @Nullable
        private String description;

        @Nullable
        private Uri icon;

        @NotNull
        private String menuName;

        @Nullable
        private String menuPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull String itemKey) {
            super(itemKey);
            Intrinsics.checkNotNullParameter(itemKey, "itemKey");
            this.menuName = "";
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final Uri getIcon() {
            return this.icon;
        }

        @NotNull
        public final String getMenuName() {
            return this.menuName;
        }

        @Nullable
        public final String getMenuPath() {
            return this.menuPath;
        }

        /* JADX INFO: renamed from: setDescription, reason: collision with other method in class */
        public final void m22156setDescription(@Nullable String str) {
            this.description = str;
        }

        /* JADX INFO: renamed from: setIcon, reason: collision with other method in class */
        public final void m22157setIcon(@Nullable Uri uri) {
            this.icon = uri;
        }

        /* JADX INFO: renamed from: setMenuName, reason: collision with other method in class */
        public final void m22158setMenuName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.menuName = str;
        }

        /* JADX INFO: renamed from: setMenuPath, reason: collision with other method in class */
        public final void m22159setMenuPath(@Nullable String str) {
            this.menuPath = str;
        }

        @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem.Builder
        @NotNull
        public Builder addAction(@NotNull String text, @NotNull ResultItemPayload payload) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(payload, "payload");
            super.addAction(text, payload);
            return this;
        }

        @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem.Builder
        @NotNull
        public SettingsSearchResultItem build() {
            return new SettingsSearchResultItem(this, null);
        }

        @NotNull
        public final Builder setDescription(@Nullable String description) {
            this.description = description;
            return this;
        }

        @NotNull
        public final Builder setIcon(@Nullable Uri icon) {
            this.icon = icon;
            return this;
        }

        @NotNull
        public final Builder setMenuName(@NotNull String menuName) {
            Intrinsics.checkNotNullParameter(menuName, "menuName");
            this.menuName = menuName;
            return this;
        }

        @NotNull
        public final Builder setMenuPath(@Nullable String menuPath) {
            this.menuPath = menuPath;
            return this;
        }

        @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem.Builder
        @NotNull
        public Builder setPayload(@Nullable IntentResultItemPayload payload) {
            super.setPayload(payload);
            return this;
        }
    }

    public /* synthetic */ SettingsSearchResultItem(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Override // com.samsung.android.lib.galaxyfinder.search.api.search.item.SearchResultItem
    @Nullable
    /* JADX INFO: renamed from: getGroup, reason: from getter */
    public String getMenuPath() {
        return this.menuPath;
    }

    @Nullable
    public final Uri getMenuIcon() {
        return this.menuIcon;
    }

    @Nullable
    public final String getMenuName() {
        return this.menuName;
    }

    @Nullable
    public final String getMenuPath() {
        return this.menuPath;
    }

    public final void setDescription(@Nullable String str) {
        this.description = str;
    }

    public final void setMenuPath(@Nullable String str) {
        this.menuPath = str;
    }

    private SettingsSearchResultItem(String str, Uri uri, String str2, String str3, IntentResultItemPayload intentResultItemPayload, List<SearchResultItem.LabeledPayload> list) {
        super(str, uri, str2, null, intentResultItemPayload);
        this.menuIcon = uri;
        this.menuName = str2;
        this.description = str3;
        setActions(list);
    }

    private SettingsSearchResultItem(Builder builder) {
        super(builder.getItemKey(), builder.getIcon(), builder.getMenuName(), builder.getDescription(), builder.getPayload());
        this.menuIcon = builder.getIcon();
        this.menuName = builder.getMenuName();
        this.menuPath = builder.getMenuPath();
        this.description = builder.getDescription();
        setActions(builder.getActions());
    }
}
