package com.samsung.android.app.sdk.deepsky.suggestion.view;

import android.view.SurfaceControlViewHost;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.SuggestionData;
import com.samsung.android.app.sdk.deepsky.contract.suggestion.view.SurfaceViewInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JN\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052<\u0010\u0006\u001a8\u0012\u0004\u0012\u00020\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\u0007H&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JB\u0010\u0014\u001a\u00020\u000328\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H&J-\u0010\u0019\u001a\u00020\u00032#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH&J\u0018\u0010\u001d\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001eH&JB\u0010\u001f\u001a\u00020\u000328\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0015H&J-\u0010 \u001a\u00020\u00032#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aH&¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SurfacePackageUpdater;", "", "getSurfacePackage", "", "info", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/view/SurfaceViewInfo;", "consumer", "Lkotlin/Function3;", "Landroid/view/SurfaceControlViewHost$SurfacePackage;", "", "Lkotlin/ParameterName;", "name", "width", "height", "isAlreadyConnected", "", ExternalDataConstants.EmbeddingConfig.KEY, "Lcom/samsung/android/app/sdk/deepsky/suggestion/view/SuggestionViewConfig;", "onSurfacePackageReleased", "relayout", "setOnClickListener", "Lkotlin/Function2;", "Lcom/samsung/android/app/sdk/deepsky/contract/suggestion/SuggestionData;", "data", "viewId", "setOnDisconnectedListener", "Lkotlin/Function1;", "", "cause", "setOnDismissedListener", "Lkotlin/Function0;", "setOnLayoutChangedListener", "setOnMotionEventListener", "actionId", "deepsky-sdk-smartsuggestion-6.1.0_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public interface SurfacePackageUpdater {
    void getSurfacePackage(@NotNull SurfaceViewInfo info, @NotNull Function3<? super SurfaceControlViewHost.SurfacePackage, ? super Integer, ? super Integer, Unit> consumer);

    boolean isAlreadyConnected(@NotNull SuggestionViewConfig config);

    void onSurfacePackageReleased(@NotNull SurfaceViewInfo info);

    void relayout(@NotNull SurfaceViewInfo info);

    void setOnClickListener(@Nullable Function2<? super SuggestionData, ? super Integer, Unit> consumer);

    void setOnDisconnectedListener(@Nullable Function1<? super String, Unit> consumer);

    void setOnDismissedListener(@Nullable Function0<Unit> consumer);

    void setOnLayoutChangedListener(@Nullable Function2<? super Integer, ? super Integer, Unit> consumer);

    void setOnMotionEventListener(@Nullable Function1<? super Integer, Unit> consumer);
}
