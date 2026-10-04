package com.samsung.android.lib.galaxyfinder.search.api.search.item;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.lib.galaxyfinder.search.api.payload.IntentResultItemPayload;
import com.samsung.android.lib.galaxyfinder.search.api.payload.ResultItemPayload;
import com.samsung.android.lib.galaxyfinder.search.util.SearchLog;
import com.samsung.android.settings.search.provider.SearchIndexablesContract;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b&\u0018\u0000 +2\u00020\u0001:\u0003*+,B7\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020 H\u0004J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\"H\u0002J\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020%J\u0010\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020%J\u0018\u0010'\u001a\u00020\u001f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010(H\u0004J\u000e\u0010)\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\"R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006-"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "", "itemKey", "", "icon", "Landroid/net/Uri;", "text", "text2", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;)V", "actions", "", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem$LabeledPayload;", "extras", "Lorg/json/JSONObject;", "getExtras", "()Lorg/json/JSONObject;", "setExtras", "(Lorg/json/JSONObject;)V", "group", "getGroup", "()Ljava/lang/String;", "getIcon", "()Landroid/net/Uri;", "getItemKey", "getPayload", "()Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "getText", "getText2", Bixby2Constants.BIXBY_ACTION_ADD_ACTION, "", "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;", "bundleToJson", "Landroid/os/Bundle;", "getActionLabel", "index", "", "getActionPayloadStr", "setActions", "", "setStringExtras", "Builder", "Companion", "LabeledPayload", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public abstract class SearchResultItem {

    @NotNull
    private static final String TAG = "SearchResultItem";

    @NotNull
    private final List<LabeledPayload> actions;

    @Nullable
    private JSONObject extras;

    @Nullable
    private final Uri icon;

    @NotNull
    private final String itemKey;

    @Nullable
    private final IntentResultItemPayload payload;

    @Nullable
    private final String text;

    @Nullable
    private final String text2;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b$\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0016H\u0016J\r\u0010\u0017\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018J\u0016\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem$Builder;", "T", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "", "itemKey", "", "(Ljava/lang/String;)V", "actions", "", "Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem$LabeledPayload;", "getActions", "()Ljava/util/List;", "getItemKey", "()Ljava/lang/String;", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "getPayload", "()Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;", "setPayload", "(Lcom/samsung/android/lib/galaxyfinder/search/api/payload/IntentResultItemPayload;)V", Bixby2Constants.BIXBY_ACTION_ADD_ACTION, "text", "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;", "build", "()Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static abstract class Builder<T extends SearchResultItem> {

        @NotNull
        private final List<LabeledPayload> actions;

        @NotNull
        private final String itemKey;

        @Nullable
        private IntentResultItemPayload payload;

        public Builder(@NotNull String itemKey) {
            Intrinsics.checkNotNullParameter(itemKey, "itemKey");
            this.actions = new ArrayList();
            if (TextUtils.isEmpty(itemKey)) {
                throw new IllegalArgumentException("itemKey must be not null or empty");
            }
            this.itemKey = itemKey;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public Builder<?> addAction(@NotNull String text, @NotNull ResultItemPayload payload) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(payload, "payload");
            this.actions.add(new LabeledPayload(text, payload));
            return this;
        }

        public abstract T build();

        @NotNull
        public final List<LabeledPayload> getActions() {
            return this.actions;
        }

        @NotNull
        public final String getItemKey() {
            return this.itemKey;
        }

        @Nullable
        public final IntentResultItemPayload getPayload() {
            return this.payload;
        }

        /* JADX INFO: renamed from: setPayload, reason: collision with other method in class */
        public final void m22155setPayload(@Nullable IntentResultItemPayload intentResultItemPayload) {
            this.payload = intentResultItemPayload;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public Builder<?> setPayload(@Nullable IntentResultItemPayload payload) {
            this.payload = payload;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/lib/galaxyfinder/search/api/search/item/SearchResultItem$LabeledPayload;", "", "label", "", SearchIndexablesContract.RawData.PAYLOAD, "Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;", "(Ljava/lang/String;Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;)V", "getLabel", "()Ljava/lang/String;", "getPayload", "()Lcom/samsung/android/lib/galaxyfinder/search/api/payload/ResultItemPayload;", "DeviceSearchLibrary_release"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class LabeledPayload {

        @Nullable
        private final String label;

        @NotNull
        private final ResultItemPayload payload;

        public LabeledPayload(@Nullable String str, @NotNull ResultItemPayload payload) {
            Intrinsics.checkNotNullParameter(payload, "payload");
            this.label = str;
            this.payload = payload;
        }

        @Nullable
        public final String getLabel() {
            return this.label;
        }

        @NotNull
        public final ResultItemPayload getPayload() {
            return this.payload;
        }
    }

    public SearchResultItem(@NotNull String itemKey, @Nullable Uri uri, @Nullable String str, @Nullable String str2, @Nullable IntentResultItemPayload intentResultItemPayload) {
        Intrinsics.checkNotNullParameter(itemKey, "itemKey");
        this.actions = new ArrayList();
        if (TextUtils.isEmpty(itemKey)) {
            throw new IllegalArgumentException("itemKey must be not null or empty");
        }
        this.itemKey = itemKey;
        this.text = str;
        this.text2 = str2;
        this.icon = uri;
        this.payload = intentResultItemPayload;
        if (intentResultItemPayload == null) {
            throw new IllegalArgumentException("view payload must be not null");
        }
    }

    private final JSONObject bundleToJson(Bundle extras) {
        JSONObject jSONObject = new JSONObject();
        try {
            Set<String> setKeySet = extras.keySet();
            Intrinsics.checkNotNullExpressionValue(setKeySet, "extras.keySet()");
            for (String str : setKeySet) {
                jSONObject.put(str, JSONObject.wrap(extras.getString(str)));
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new IllegalArgumentException("fail to convert bundle to json: " + e);
        }
    }

    public final void addAction(@NotNull String text, @NotNull ResultItemPayload payload) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (this.actions.size() >= 3) {
            throw new ArrayIndexOutOfBoundsException(AbstractC0000a.m11h(this.actions.size(), "The number of actions must not exceed "));
        }
        this.actions.add(new LabeledPayload(text, payload));
    }

    @Nullable
    public final String getActionLabel(int index) {
        if (this.actions.size() <= index) {
            return null;
        }
        try {
            return this.actions.get(index).getLabel();
        } catch (Exception e) {
            SearchLog.INSTANCE.m5532d(TAG, "fail to get action label: " + e);
            return null;
        }
    }

    @Nullable
    public final String getActionPayloadStr(int index) {
        if (this.actions.size() <= index) {
            return null;
        }
        try {
            return this.actions.get(index).getPayload().getStringFromPayload();
        } catch (Exception e) {
            SearchLog.INSTANCE.m5532d(TAG, "fail to get action payload: " + e);
            return null;
        }
    }

    @Nullable
    public final JSONObject getExtras() {
        return this.extras;
    }

    @Nullable
    public abstract String getGroup();

    @Nullable
    public final Uri getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getItemKey() {
        return this.itemKey;
    }

    @Nullable
    public final IntentResultItemPayload getPayload() {
        return this.payload;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Nullable
    public final String getText2() {
        return this.text2;
    }

    public final void setActions(@Nullable List<LabeledPayload> actions) {
        this.actions.clear();
        List<LabeledPayload> list = actions;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.actions.addAll(list);
    }

    public final void setExtras(@Nullable JSONObject jSONObject) {
        this.extras = jSONObject;
    }

    public final void setStringExtras(@NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        this.extras = bundleToJson(extras);
    }
}
