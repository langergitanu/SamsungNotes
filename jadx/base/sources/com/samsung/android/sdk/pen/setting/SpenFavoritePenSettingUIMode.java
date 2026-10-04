package com.samsung.android.sdk.pen.setting;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSettingUIMode;", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenMode;", "setModeChangedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteModeChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenFavoritePenSettingUIMode extends SpenFavoritePenMode {
    void setModeChangedListener(@Nullable SpenFavoriteModeChangedListener listener);
}
