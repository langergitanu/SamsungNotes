package com.samsung.android.app.sdk.deepsky.suggestion;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.List;
import java.util.function.Function;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH'J,\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u000e\u001a\u00020\u000fH'J(\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H'J:\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0018\u0010\u0010\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\r0\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H'J\b\u0010\u0015\u001a\u00020\u0000H'J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014H'¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionRequest;", "", "getCapabilities", "", "Lcom/samsung/android/app/sdk/deepsky/suggestion/Capability;", "getSubscriptionIdList", "", "isSubscribed", "", "id", "requestSuggestion", "Lcom/samsung/android/app/sdk/deepsky/suggestion/SuggestionResponse;", "capability", "Lcom/samsung/android/app/sdk/deepsky/suggestion/CapabilityEnum;", "extras", "Landroid/os/Bundle;", "mapper", "Ljava/util/function/Function;", "subscribeSuggestion", BaseGmsClient.KEY_PENDING_INTENT, "Landroid/app/PendingIntent;", "test", "unsubscribeSuggestion", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface SuggestionRequest {
    @NonNull
    @WorkerThread
    @NotNull
    List<Capability> getCapabilities();

    @NotNull
    List<Integer> getSubscriptionIdList();

    boolean isSubscribed(int id);

    @Nullable
    @WorkerThread
    @org.jetbrains.annotations.Nullable
    SuggestionResponse requestSuggestion(@NotNull CapabilityEnum capability, @NotNull Bundle extras);

    @Nullable
    @WorkerThread
    @org.jetbrains.annotations.Nullable
    SuggestionResponse requestSuggestion(@NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras);

    @WorkerThread
    boolean subscribeSuggestion(int id, @NotNull CapabilityEnum capability, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent);

    @WorkerThread
    boolean subscribeSuggestion(int id, @NotNull Function<List<Capability>, CapabilityEnum> mapper, @NotNull Bundle extras, @NotNull PendingIntent pendingIntent);

    @NonNull
    @NotNull
    SuggestionRequest test();

    @WorkerThread
    boolean unsubscribeSuggestion(int id, @NotNull PendingIntent pendingIntent);
}
