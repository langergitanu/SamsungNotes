package com.samsung.android.app.sdk.deepsky.donation;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\u0006J\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation;", "", "builder", "Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation$Builder;", "(Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation$Builder;)V", "actionName", "", "paramDetailMap", "", "getActionName", "getParamDetailMap", "", "Builder", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ActionDonation {

    @NotNull
    private final String actionName;

    @NotNull
    private final Builder builder;

    @NotNull
    private final Map<String, String> paramDetailMap;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation$Builder;", "", "actionName", "", "(Ljava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "paramDetailMap", "", "getParamDetailMap", "()Ljava/util/Map;", "addParamDetails", "key", "value", "build", "Lcom/samsung/android/app/sdk/deepsky/donation/ActionDonation;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Builder {

        @NotNull
        private final String actionName;

        @NotNull
        private final Map<String, String> paramDetailMap;

        public Builder(@NotNull String actionName) {
            Intrinsics.checkNotNullParameter(actionName, "actionName");
            this.actionName = actionName;
            this.paramDetailMap = new HashMap();
        }

        @NotNull
        public final Builder addParamDetails(@NotNull String key, @Nullable String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Map<String, String> map = this.paramDetailMap;
            String json = new Gson().toJson(value);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(value)");
            map.put(key, json);
            return this;
        }

        @NotNull
        public final ActionDonation build() {
            return new ActionDonation(this, null);
        }

        @NotNull
        public final String getActionName() {
            return this.actionName;
        }

        @NotNull
        public final Map<String, String> getParamDetailMap() {
            return this.paramDetailMap;
        }
    }

    public /* synthetic */ ActionDonation(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @NotNull
    public final String getActionName() {
        return this.actionName;
    }

    @NotNull
    public final Map<String, String> getParamDetailMap() {
        return this.paramDetailMap;
    }

    private ActionDonation(Builder builder) {
        this.builder = builder;
        this.actionName = builder.getActionName();
        HashMap map = new HashMap();
        this.paramDetailMap = map;
        map.putAll(builder.getParamDetailMap());
    }
}
