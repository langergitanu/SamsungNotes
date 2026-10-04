package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import kotlin.Metadata;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH&J\"\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH&J\b\u0010\u0013\u001a\u00020\u0006H&J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\u0006H&J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\nH&J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001cH&J\u001a\u0010 \u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\"\u001a\u00020\u0006H&J\b\u0010#\u001a\u00020\u0006H&J\b\u0010$\u001a\u00020\u0006H&J\b\u0010%\u001a\u00020\fH&J\u0010\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0003H&J\u001a\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u0003H&J$\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0003H&J\"\u0010&\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010*\u001a\u00020+H&J\u001c\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020\u00032\b\u0010.\u001a\u0004\u0018\u00010\u0003H&J\b\u0010/\u001a\u00020\nH&J\"\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0006H&J\b\u00105\u001a\u00020\u0006H&J\u0018\u00106\u001a\u00020\f2\u0006\u00107\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\nH&J\u0018\u00108\u001a\u00020\n2\u0006\u00107\u001a\u00020\u00032\u0006\u00109\u001a\u00020\nH&J\"\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\nH&J\"\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020\n2\u0006\u0010>\u001a\u00020\nH&J\u001a\u0010@\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010A\u001a\u00020\u0006H&J\b\u0010B\u001a\u00020\nH&J\u0012\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u0003H&¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/IPlatformDelegate;", "", "getThumbnailExtension", "", "getBrushFileExtension", "isTabletModel", "", "isSpenModel", "isShopDemoDevice", "getScreenOrientation", "", "setButtonShapeEnabledWithTextColor", "", "view", "Landroid/view/View;", "color", "changeCustomButtonBackgroundUnchangedTextColor", "btnShapeBGId1", "btnShapeBGId2", "isOnMainUIThread", "isPackageInstalledAndEnabled", "packageName", "initializePenLibrary", "isRTLMode", "applyTextSizeUntilLargeSize", "textView", "Landroid/widget/TextView;", "fontSize", "", "getColorPrimary", "convertPixelToSp", "pixel", "setFont", "fontName", "isVoiceAssistantEnabled", "isAvailableMemoryForNewDocument", "isAvailableMinimumMemory", "executeBaseLogic", "insertLog", "screenID", "event", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "value", "", "getFileNameByTime", "prefix", BundleContract.EXTRA_DATA, "getMaxTextureSize", "makeJpg", "bitmap", "Landroid/graphics/Bitmap;", "filePath", "recycle", "isShowButtonShapeEnabled", "setSmartTipsPreference", "key", "getSmartTipsPreference", "defaultValue", "showToast", "context", "Landroid/content/Context;", "message", XmlErrorCodes.DURATION, "resId", "isCoverClosed", "cold", "getCoverType", "isActivityRunning", "name", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public interface IPlatformDelegate {
    void applyTextSizeUntilLargeSize(@Nullable TextView textView, float fontSize);

    void changeCustomButtonBackgroundUnchangedTextColor(@Nullable View view, int btnShapeBGId1, int btnShapeBGId2);

    float convertPixelToSp(float pixel);

    void executeBaseLogic();

    @Nullable
    String getBrushFileExtension();

    int getColorPrimary();

    int getCoverType();

    @Nullable
    String getFileNameByTime(@NotNull String prefix, @Nullable String extension);

    int getMaxTextureSize();

    int getScreenOrientation();

    int getSmartTipsPreference(@NotNull String key, int defaultValue);

    @Nullable
    String getThumbnailExtension();

    void initializePenLibrary();

    void insertLog(@NotNull String screenID);

    void insertLog(@Nullable String screenID, @NotNull String event);

    void insertLog(@Nullable String screenID, @NotNull String event, long value);

    void insertLog(@Nullable String screenID, @NotNull String event, @Nullable String detail);

    boolean isActivityRunning(@Nullable String name);

    boolean isAvailableMemoryForNewDocument();

    boolean isAvailableMinimumMemory();

    boolean isCoverClosed(@Nullable Context context, boolean cold);

    boolean isOnMainUIThread();

    boolean isPackageInstalledAndEnabled(@NotNull String packageName);

    boolean isRTLMode();

    boolean isShopDemoDevice();

    boolean isShowButtonShapeEnabled();

    boolean isSpenModel();

    boolean isTabletModel();

    boolean isVoiceAssistantEnabled();

    boolean makeJpg(@Nullable Bitmap bitmap, @NotNull String filePath, boolean recycle);

    void setButtonShapeEnabledWithTextColor(@NotNull View view, int color);

    void setFont(@NotNull TextView textView, @Nullable String fontName);

    void setSmartTipsPreference(@NotNull String key, int value);

    void showToast(@Nullable Context context, int resId, int duration);

    void showToast(@Nullable Context context, @NotNull String message, int duration);
}
