package com.samsung.android.app.sdk.deepsky.suggestion;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.samsung.android.app.sdk.deepsky.common.AccessControl;
import com.samsung.android.app.sdk.deepsky.common.Injector;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001eB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\u0007H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nH\u0016J\b\u0010\u000e\u001a\u00020\u0001H\u0002J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J,\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J(\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J:\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u00140\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0001H\u0016J\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequestProxy;", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "Lcom/samsung/android/app/sdk/deepsky/common/AccessControl;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "testMode", "", "checkIfAccessAllowed", "getCapabilities", "", "Lcom/samsung/android/app/sdk/deepsky/suggestion/Capability;", "getSubscriptionIdList", "", "getSuggestionRequest", "isSubscribed", "id", "requestSuggestion", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponse;", "capability", "Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;", "extras", "Landroid/os/Bundle;", "mapper", "Ljava/util/function/Function;", "subscribeSuggestion", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "test", "unsubscribeSuggestion", "SuggestionRequestFactory", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class SuggestionRequestProxy implements SuggestionRequest, AccessControl {

    @NotNull
    private final Context context;
    private boolean testMode;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequestProxy$SuggestionRequestFactory;", "", "()V", "getDummySuggestionRequest", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "getSuggestionRequest", "Companion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class SuggestionRequestFactory {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private static SuggestionRequest sDefaultSuggestionRequest;
        private static SuggestionRequest sDummyCalendarSuggestionRequest;

        @Nullable
        private static volatile SuggestionRequestFactory sInstance;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequestProxy$SuggestionRequestFactory$Companion;", "", "()V", "sDefaultSuggestionRequest", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "sDummyCalendarSuggestionRequest", "sInstance", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequestProxy$SuggestionRequestFactory;", "getInstance", "context", "Landroid/content/Context;", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final SuggestionRequestFactory getInstance(@NotNull Context context) {
                SuggestionRequestFactory suggestionRequestFactory;
                Intrinsics.checkNotNullParameter(context, "context");
                SuggestionRequestFactory suggestionRequestFactory2 = SuggestionRequestFactory.sInstance;
                if (suggestionRequestFactory2 != null) {
                    return suggestionRequestFactory2;
                }
                synchronized (this) {
                    suggestionRequestFactory = SuggestionRequestFactory.sInstance;
                    if (suggestionRequestFactory == null) {
                        suggestionRequestFactory = new SuggestionRequestFactory();
                        Injector injector = Injector.INSTANCE;
                        SuggestionRequestFactory.sDefaultSuggestionRequest = new DefaultSuggestionRequest(context, injector.provideServiceCaller$deepsky_sdk_smartsuggestion_6_1_0_release(context), injector.shareSystemDatasource$deepsky_sdk_smartsuggestion_6_1_0_release(context));
                        SuggestionRequestFactory.sDummyCalendarSuggestionRequest = new DummySuggestionRequest(context);
                        SuggestionRequestFactory.sInstance = suggestionRequestFactory;
                    }
                }
                return suggestionRequestFactory;
            }

            private Companion() {
            }
        }

        @NotNull
        public final SuggestionRequest getDummySuggestionRequest() {
            SuggestionRequest suggestionRequest = sDummyCalendarSuggestionRequest;
            if (suggestionRequest != null) {
                return suggestionRequest;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sDummyCalendarSuggestionRequest");
            return null;
        }

        @NotNull
        public final SuggestionRequest getSuggestionRequest() {
            SuggestionRequest suggestionRequest = sDefaultSuggestionRequest;
            if (suggestionRequest != null) {
                return suggestionRequest;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sDefaultSuggestionRequest");
            return null;
        }
    }

    public SuggestionRequestProxy(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    private final SuggestionRequest getSuggestionRequest() {
        return this.testMode ? SuggestionRequestFactory.INSTANCE.getInstance(this.context).getDummySuggestionRequest() : SuggestionRequestFactory.INSTANCE.getInstance(this.context).getSuggestionRequest();
    }

    @Override // com.samsung.android.app.sdk.deepsky.common.AccessControl
    public boolean checkIfAccessAllowed() {
        return true;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public List<Capability> getCapabilities() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return getSuggestionRequest().getCapabilities();
        }
        throw new IllegalStateException("This should not be called on Main Thread");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public List<Integer> getSubscriptionIdList() {
        return getSuggestionRequest().getSubscriptionIdList();
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean isSubscribed(int id) {
        return getSuggestionRequest().isSubscribed(id);
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @Nullable
    public SuggestionResponse requestSuggestion(@NotNull CapabilityEnum capability, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return getSuggestionRequest().requestSuggestion(capability, extras);
        }
        throw new IllegalStateException("This should not be called on Main Thread");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean subscribeSuggestion(int id, @NotNull CapabilityEnum capability, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(capability, "capability");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return getSuggestionRequest().subscribeSuggestion(id, capability, extras, pendingIntent);
        }
        throw new IllegalStateException("This should not be called on Main Thread");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @NotNull
    public SuggestionRequest test() {
        this.testMode = true;
        return this;
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean unsubscribeSuggestion(int id, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return getSuggestionRequest().unsubscribeSuggestion(id, pendingIntent);
        }
        throw new IllegalStateException("This should not be called on Main Thread");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    @Nullable
    public SuggestionResponse requestSuggestion(@NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return getSuggestionRequest().requestSuggestion(mapper, extras);
        }
        throw new IllegalStateException("This should not be called on Main Thread");
    }

    @Override // com.samsung.android.app.sdk.deepsky.suggestion.SuggestionRequest
    public boolean subscribeSuggestion(int id, @NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(mapper, "mapper");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return getSuggestionRequest().subscribeSuggestion(id, mapper, extras, pendingIntent);
        }
        throw new IllegalStateException("This should not be called on Main Thread");
    }
}
