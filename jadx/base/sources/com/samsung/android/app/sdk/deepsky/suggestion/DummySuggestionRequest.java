package com.samsung.android.app.sdk.deepsky.suggestion;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J,\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J:\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0004\u0012\u00020\u000e0\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0001H\u0016J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/DummySuggestionRequest;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getCapabilities", "", "Lcom/samsung/android/app/sdk/deepsky/suggestion/Capability;", "getMaybeEventItem", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionItem;", "getSubscriptionIdList", "", "getSuggestionItem", "capability", "Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;", "isSubscribed", "", "id", "requestSuggestion", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponse;", "extras", "Landroid/os/Bundle;", "mapper", "Ljava/util/function/Function;", "subscribeSuggestion", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "test", "unsubscribeSuggestion", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class DummySuggestionRequest implements SuggestionRequest {

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_DESCRIPTION = "There is one may event";

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_ICON_URI = "android.resource://com.samsung.android.smartsuggestions/drawable/calendar";

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_ID = "_:node1fb1s26kux6";
    private static final boolean MAYBE_EVENT_KNOWLEDGE_IS_VALID = true;

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_ITEM_DESCRIPTION = "09:30 PM - 11:30 PM";

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_ITEM_TITLE = "Typhoon with Radiation City";

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_ITEM_URL = "gi://applink/action/calendar/view?startDate=1627351200000";

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_STRUCTURED_DATA = "{\n                  \"@context\": \"https://schema.org\",\n                  \"@type\": \"Event\",\n                  \"location\": {\n                    \"@type\": \"Place\",\n                    \"address\": {\n                      \"@type\": \"PostalAddress\",\n                      \"addressLocality\": \"Denver\",\n                      \"addressRegion\": \"CO\",\n                      \"postalCode\": \"80209\",\n                      \"streetAddress\": \"7 S. Broadway\"\n                    },\n                    \"name\": \"The Hi-Dive\"\n                  },\n                  \"name\": \"Typhoon with Radiation City\",\n                  \"startDate\": \"2013-09-14T21:30\",\n                  \"endDate\": \"2013-09-14T23:30\",\n                  \"attendee\": {\n                    \"@type\": \"Person\",\n                    \"name\": \"Darren R Story\"\n                  }\n                }";

    @NotNull
    private static final String MAYBE_EVENT_KNOWLEDGE_TITLE = "MAYBE EVENT";

    @NotNull
    private final Context context;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {1, 8, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CapabilityEnum.values().length];
            try {
                iArr[CapabilityEnum.MAYBE_EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public DummySuggestionRequest(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final SuggestionItem getMaybeEventItem() {
        Uri uri = Uri.parse(MAYBE_EVENT_KNOWLEDGE_ICON_URI);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SuggestionData(null, MAYBE_EVENT_KNOWLEDGE_ITEM_TITLE, MAYBE_EVENT_KNOWLEDGE_ITEM_DESCRIPTION, null, null, null, new JSONObject(MAYBE_EVENT_KNOWLEDGE_STRUCTURED_DATA), MAYBE_EVENT_KNOWLEDGE_ITEM_URL, 0L, 313, null));
        return new SuggestionItem(MAYBE_EVENT_KNOWLEDGE_ID, MAYBE_EVENT_KNOWLEDGE_TITLE, MAYBE_EVENT_KNOWLEDGE_DESCRIPTION, uri, null, arrayList, 0.0d, true, 0L, null, null, 1872, null);
    }

    private final SuggestionItem getSuggestionItem(CapabilityEnum capability) {
        if (WhenMappings.$EnumSwitchMapping$0[capability.ordinal()] == 1) {
            return getMaybeEventItem();
        }
        return null;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public List<Capability> getCapabilities() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Capability(CapabilityEnum.MAYBE_EVENT, new Bundle()));
        return arrayList;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public List<Integer> getSubscriptionIdList() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean isSubscribed(int id) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @Nullable
    public SuggestionResponse requestSuggestion(@NotNull CapabilityEnum capability, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Intrinsics.checkNotNullParameter(extras, "extras");
        SuggestionItem suggestionItem = getSuggestionItem(capability);
        if (suggestionItem != null) {
            return new SuggestionResponseImpl(this.context, suggestionItem);
        }
        return null;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean subscribeSuggestion(int id, @NotNull CapabilityEnum capability, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public SuggestionRequest test() {
        return this;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean unsubscribeSuggestion(int id, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean subscribeSuggestion(int id, @NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @Nullable
    public SuggestionResponse requestSuggestion(@NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(extras, "extras");
        CapabilityEnum capabilityEnumApply = mapper.apply(getCapabilities());
        Intrinsics.checkNotNullExpressionValue(capabilityEnumApply, "mapper.apply(getCapabilities())");
        SuggestionItem suggestionItem = getSuggestionItem(capabilityEnumApply);
        if (suggestionItem != null) {
            return new SuggestionResponseImpl(this.context, suggestionItem);
        }
        return null;
    }
}
