package com.samsung.android.app.sdk.deepsky.suggestion;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.samsung.android.app.sdk.deepsky.BuildConfig;
import com.samsung.android.app.sdk.deepsky.common.ContentProviderCaller;
import com.samsung.android.app.sdk.deepsky.common.SystemDataSource;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionItem;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 !2\u00020\u0001:\u0001!B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J,\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J:\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0018\u0010\u001a\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00180\u001b2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0001H\u0016J\u0018\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/DefaultSuggestionRequest;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "context", "Landroid/content/Context;", "contentProviderCaller", "Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;", "systemDatasource", "Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;", "(Landroid/content/Context;Lcom/samsung/android/app/sdk/deepsky/common/ContentProviderCaller;Lcom/samsung/android/app/sdk/deepsky/common/SystemDataSource;)V", "getCapabilities", "", "Lcom/samsung/android/app/sdk/deepsky/suggestion/Capability;", "getSubscriptionIdList", "", "getSuggestionResponseImpl", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponseImpl;", "suggestionParam", "Landroid/os/Bundle;", "isSubscribed", "", "id", "requestSuggestion", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponse;", "capability", "Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;", DefaultSuggestionRequest.KEY_EXTRAS, "mapper", "Ljava/util/function/Function;", "subscribeSuggestion", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "test", "unsubscribeSuggestion", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nDefaultSuggestionRequest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultSuggestionRequest.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/DefaultSuggestionRequest\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,156:1\n1#2:157\n1#2:168\n11653#3,9:158\n13579#3:167\n13580#3:169\n11662#3:170\n819#4:171\n847#4,2:172\n1549#4:174\n1620#4,3:175\n819#4:178\n847#4,2:179\n*S KotlinDebug\n*F\n+ 1 DefaultSuggestionRequest.kt\ncom/samsung/android/app/sdk/deepsky/suggestion/DefaultSuggestionRequest\n*L\n24#1:168\n24#1:158,9\n24#1:167\n24#1:169\n24#1:170\n25#1:171\n25#1:172,2\n26#1:174\n26#1:175,3\n32#1:178\n32#1:179,2\n*E\n"})
public final class DefaultSuggestionRequest implements SuggestionRequest {

    @NotNull
    private static final String GET_CAPABILITIES = "get_capabilities";

    @NotNull
    private static final String GET_SUBSCRIPTION_ID_LIST = "get_subscription_id_list";

    @NotNull
    private static final String IS_SUBSCRIBED = "is_subscribed";

    @NotNull
    private static final String KEY_CAPABILITY_ID = "suggestion_capability_id";

    @NotNull
    private static final String KEY_CAPABILITY_RESULT = "key_capability_result";

    @NotNull
    private static final String KEY_EXTRAS = "extras";

    @NotNull
    private static final String KEY_ID = "capabilityId";

    @NotNull
    private static final String KEY_IS_SUPPORTED = "key_is_supported";

    @NotNull
    private static final String KEY_NAME = "name";

    @NotNull
    private static final String KEY_NOTIFICATION_INTENT = "notification_intent";

    @NotNull
    private static final String KEY_SDK_VERSION_NAME = "sdk_version_name";

    @NotNull
    private static final String KEY_SUBSCRIPTION_ID = "suggestion_subscription_id";

    @NotNull
    private static final String KEY_SUGGESTION_PARAMETER = "suggestion_parameter";

    @NotNull
    private static final String KEY_SUGGESTION_RESULT = "key_suggestion_result";

    @NotNull
    private static final String REQUEST_SUGGESTION = "request_suggestion";

    @NotNull
    private static final String SUBSCRIBE_SUGGESTION = "subscribe_suggestion";

    @NotNull
    private static final String TAG = "SuggestionApi";

    @NotNull
    private static final String UNSUBSCRIBE_SUGGESTION = "unsubscribe_suggestion";

    @NotNull
    private final ContentProviderCaller contentProviderCaller;

    @NotNull
    private final Context context;

    @NotNull
    private final SystemDataSource systemDatasource;

    public DefaultSuggestionRequest(@NotNull Context context, @NotNull ContentProviderCaller contentProviderCaller, @NotNull SystemDataSource systemDatasource) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(contentProviderCaller, "contentProviderCaller");
        Intrinsics.checkNotNullParameter(systemDatasource, "systemDatasource");
        this.context = context;
        this.contentProviderCaller = contentProviderCaller;
        this.systemDatasource = systemDatasource;
    }

    private final SuggestionResponseImpl getSuggestionResponseImpl(Bundle suggestionParam) {
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("request_suggestion", suggestionParam);
        if (bundleSendCommand == null) {
            return null;
        }
        bundleSendCommand.setClassLoader(SuggestionItem.class.getClassLoader());
        SuggestionItem suggestionItem = (SuggestionItem) bundleSendCommand.getParcelable(KEY_SUGGESTION_RESULT);
        if (suggestionItem == null) {
            return null;
        }
        Context context = this.context;
        Intrinsics.checkNotNullExpressionValue(suggestionItem, "suggestionItem");
        return new SuggestionResponseImpl(context, suggestionItem);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public List<Capability> getCapabilities() {
        Parcelable[] parcelableArray;
        Object objM22215constructorimpl;
        Bundle bundleNewBundle = this.systemDatasource.newBundle();
        bundleNewBundle.putString(KEY_SDK_VERSION_NAME, BuildConfig.DeepSkyLibraryVersionName);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("get_capabilities", bundleNewBundle);
        if (bundleSendCommand == null || (parcelableArray = bundleSendCommand.getParcelableArray(KEY_CAPABILITY_RESULT)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : parcelableArray) {
            Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type android.os.Bundle");
            arrayList.add((Bundle) parcelable);
        }
        ArrayList<Bundle> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            Bundle bundle = ((Bundle) obj).getBundle(KEY_EXTRAS);
            if (bundle == null || bundle.getBoolean(KEY_IS_SUPPORTED)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(CollectionsKt.m13952k(arrayList2));
        for (Bundle bundle2 : arrayList2) {
            try {
                Result.Companion companion = Result.INSTANCE;
                String string = bundle2.getString("name", "UNKNOWN");
                Intrinsics.checkNotNullExpressionValue(string, "it.getString(KEY_NAME, C…abilityEnum.UNKNOWN.name)");
                objM22215constructorimpl = Result.m22215constructorimpl(CapabilityEnum.valueOf(string));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                objM22215constructorimpl = null;
            }
            CapabilityEnum capabilityEnum = (CapabilityEnum) objM22215constructorimpl;
            if (capabilityEnum == null) {
                capabilityEnum = CapabilityEnum.UNKNOWN;
            }
            arrayList3.add(new Capability(capabilityEnum, bundle2.getBundle(KEY_EXTRAS)));
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (((Capability) obj2).getCapability() != CapabilityEnum.UNKNOWN) {
                arrayList4.add(obj2);
            }
        }
        return arrayList4;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public List<Integer> getSubscriptionIdList() {
        int[] intArray;
        List<Integer> list;
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("get_subscription_id_list", this.systemDatasource.newBundle());
        return (bundleSendCommand == null || (intArray = bundleSendCommand.getIntArray(KEY_SUGGESTION_RESULT)) == null || (list = ArraysKt.toList(intArray)) == null) ? CollectionsKt.emptyList() : list;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean isSubscribed(int id) {
        Bundle bundleNewBundle = this.systemDatasource.newBundle();
        bundleNewBundle.putInt(KEY_SUBSCRIPTION_ID, id);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("is_subscribed", bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(KEY_SUGGESTION_RESULT);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @Nullable
    public SuggestionResponse requestSuggestion(@NotNull CapabilityEnum capability, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Log.i(TAG, "requestSuggestion " + capability);
        Bundle bundleNewBundle = this.systemDatasource.newBundle();
        bundleNewBundle.putBundle(KEY_SUGGESTION_PARAMETER, extras);
        bundleNewBundle.putInt(KEY_CAPABILITY_ID, capability.getId());
        return getSuggestionResponseImpl(bundleNewBundle);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean subscribeSuggestion(int id, @NotNull CapabilityEnum capability, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Log.i(TAG, "subscribeSuggestion " + id + SQLKeyword.COMMA + capability);
        Bundle bundleNewBundle = this.systemDatasource.newBundle();
        bundleNewBundle.putInt(KEY_SUBSCRIPTION_ID, id);
        bundleNewBundle.putInt(KEY_CAPABILITY_ID, capability.getId());
        bundleNewBundle.putBundle(KEY_SUGGESTION_PARAMETER, extras);
        bundleNewBundle.putParcelable(KEY_NOTIFICATION_INTENT, pendingIntent);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("subscribe_suggestion", bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(KEY_SUGGESTION_RESULT);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public SuggestionRequest test() {
        return this;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean unsubscribeSuggestion(int id, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Log.i(TAG, "unsubscribeSuggestion " + id);
        Bundle bundleNewBundle = this.systemDatasource.newBundle();
        bundleNewBundle.putInt(KEY_SUBSCRIPTION_ID, id);
        bundleNewBundle.putParcelable(KEY_NOTIFICATION_INTENT, pendingIntent);
        Bundle bundleSendCommand = this.contentProviderCaller.sendCommand("unsubscribe_suggestion", bundleNewBundle);
        if (bundleSendCommand != null) {
            return bundleSendCommand.getBoolean(KEY_SUGGESTION_RESULT);
        }
        return false;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @Nullable
    public SuggestionResponse requestSuggestion(@NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Log.i(TAG, "requestSuggestion mapper");
        CapabilityEnum capabilityEnumApply = mapper.apply(getCapabilities());
        Intrinsics.checkNotNullExpressionValue(capabilityEnumApply, "mapper.apply(getCapabilities())");
        return requestSuggestion(capabilityEnumApply, extras);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean subscribeSuggestion(int id, @NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        Log.i(TAG, "subscribeSuggestion mapper " + id);
        CapabilityEnum capabilityEnumApply = mapper.apply(getCapabilities());
        Intrinsics.checkNotNullExpressionValue(capabilityEnumApply, "mapper.apply(getCapabilities())");
        return subscribeSuggestion(id, capabilityEnumApply, extras, pendingIntent);
    }
}
