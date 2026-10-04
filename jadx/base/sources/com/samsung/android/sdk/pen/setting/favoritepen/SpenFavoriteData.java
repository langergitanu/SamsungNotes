package com.samsung.android.sdk.pen.setting.favoritepen;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import java.util.List;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteData;", "", "setFavoriteList", "", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setFavoriteDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataChangedListener;", "addFavorite", "", "info", "updateFavorite", "index", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenFavoriteData {
    boolean addFavorite(@Nullable SpenSettingUIPenInfo info);

    void setFavoriteDataChangedListener(@Nullable SpenFavoriteDataChangedListener listener);

    void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list);

    boolean updateFavorite(int index, @Nullable SpenSettingUIPenInfo info);
}
