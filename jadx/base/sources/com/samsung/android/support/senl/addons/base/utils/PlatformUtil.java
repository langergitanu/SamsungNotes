package com.samsung.android.support.senl.addons.base.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J\b\u0010\r\u001a\u00020\fH\u0007J\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0007J\"\u0010\u0015\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0010H\u0007J\b\u0010\u0018\u001a\u00020\fH\u0007J\b\u0010\u0019\u001a\u00020\u0007H\u0007J\b\u0010\u001a\u001a\u00020\fH\u0007J\u001a\u0010\u001b\u001a\u00020\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\b\u0010 \u001a\u00020\u0010H\u0007J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0007J\u001a\u0010#\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010%\u001a\u00020\fH\u0007J\b\u0010&\u001a\u00020\fH\u0007J\b\u0010'\u001a\u00020\fH\u0007J\b\u0010(\u001a\u00020\u0007H\u0007J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\nH\u0007J\u001a\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\nH\u0007J$\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\nH\u0007J\"\u0010)\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010-\u001a\u00020.H\u0007J\u0018\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\nH\u0007J\b\u00102\u001a\u00020\u0010H\u0007J\b\u00103\u001a\u00020\fH\u0007J\u0018\u00104\u001a\u00020\u00072\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0010H\u0007J\u0018\u00107\u001a\u00020\u00102\u0006\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0010H\u0007J\u0010\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\nH\u0007J\"\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\n2\u0006\u0010>\u001a\u00020\fH\u0007J\"\u0010?\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u0010H\u0007J\"\u0010?\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010D\u001a\u00020\u00102\u0006\u0010C\u001a\u00020\u0010H\u0007J\u001a\u0010E\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010F\u001a\u00020\fH\u0007J\b\u0010G\u001a\u00020\u0010H\u0007J\u0012\u0010H\u001a\u00020\f2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0007J\n\u0010J\u001a\u0004\u0018\u00010\nH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/utils/PlatformUtil;", "", "<init>", "()V", "mDelegate", "Lcom/samsung/android/support/senl/addons/base/utils/IPlatformDelegate;", "setDelegate", "", "delegate", "getThumbnailExtension", "", "isTabletModel", "", "isSpenModel", "isShopDemoDevice", "getScreenOrientation", "", "setButtonShapeEnabledWithTextColor", "view", "Landroid/view/View;", "color", "changeCustomButtonBackgroundUnchangedTextColor", "btnShapeBGId1", "btnShapeBGId2", "isOnMainUIThread", "initializePenLibrary", "isRTLMode", "applyTextSizeUntilLargeSize", "textView", "Landroid/widget/TextView;", "fontSize", "", "getColorPrimary", "convertPixelToSp", "pixel", "setFont", "fontName", "isVoiceAssistantEnabled", "isAvailableMemoryForNewDocument", "isAvailableMinimumMemory", "executeBaseLogic", "insertLog", "screenID", "event", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "value", "", "getFileNameByTime", "prefix", BundleContract.EXTRA_DATA, "getMaxTextureSize", "isShowButtonShapeEnabled", "setSmartTipsPreference", "key", "defaultValue", "getSmartTipsPreference", "isPackageInstalledAndEnabled", "packageName", "makeJpg", "bitmap", "Landroid/graphics/Bitmap;", "filePath", "recycle", "showToast", "context", "Landroid/content/Context;", "message", XmlErrorCodes.DURATION, "resId", "isCoverClosed", "cold", "getCoverType", "isActivityRunning", "name", "getBrushFileExtension", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PlatformUtil {

    @NotNull
    public static final PlatformUtil INSTANCE = new PlatformUtil();

    @Nullable
    private static IPlatformDelegate mDelegate;

    private PlatformUtil() {
    }

    @JvmStatic
    public static final void applyTextSizeUntilLargeSize(@Nullable TextView textView, float fontSize) {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.applyTextSizeUntilLargeSize(textView, fontSize);
        }
    }

    @JvmStatic
    public static final void changeCustomButtonBackgroundUnchangedTextColor(@Nullable View view, int btnShapeBGId1, int btnShapeBGId2) {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.changeCustomButtonBackgroundUnchangedTextColor(view, btnShapeBGId1, btnShapeBGId2);
        }
    }

    @JvmStatic
    public static final float convertPixelToSp(float pixel) {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        return iPlatformDelegate != null ? iPlatformDelegate.convertPixelToSp(pixel) : pixel;
    }

    @JvmStatic
    public static final void executeBaseLogic() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.executeBaseLogic();
        }
    }

    @JvmStatic
    @Nullable
    public static final String getBrushFileExtension() {
        String brushFileExtension;
        IPlatformDelegate iPlatformDelegate = mDelegate;
        return (iPlatformDelegate == null || (brushFileExtension = iPlatformDelegate.getBrushFileExtension()) == null) ? ".spp" : brushFileExtension;
    }

    @JvmStatic
    public static final int getColorPrimary() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.getColorPrimary();
        }
        return 0;
    }

    @JvmStatic
    public static final int getCoverType() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.getCoverType();
        }
        return 2;
    }

    @JvmStatic
    @NotNull
    public static final String getFileNameByTime(@NotNull String prefix, @NotNull String extension) {
        String fileNameByTime;
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(extension, "extension");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        return (iPlatformDelegate == null || (fileNameByTime = iPlatformDelegate.getFileNameByTime(prefix, extension)) == null) ? AbstractC0541b.m756B(prefix, extension) : fileNameByTime;
    }

    @JvmStatic
    public static final int getMaxTextureSize() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.getMaxTextureSize();
        }
        return 1;
    }

    @JvmStatic
    public static final int getScreenOrientation() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.getScreenOrientation();
        }
        return 0;
    }

    @JvmStatic
    public static final int getSmartTipsPreference(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.getSmartTipsPreference(key, defaultValue);
        }
        return 0;
    }

    @JvmStatic
    @NotNull
    public static final String getThumbnailExtension() {
        String thumbnailExtension;
        IPlatformDelegate iPlatformDelegate = mDelegate;
        return (iPlatformDelegate == null || (thumbnailExtension = iPlatformDelegate.getThumbnailExtension()) == null) ? "" : thumbnailExtension;
    }

    @JvmStatic
    public static final void initializePenLibrary() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.initializePenLibrary();
        }
    }

    @JvmStatic
    public static final void insertLog(@NotNull String screenID) {
        Intrinsics.checkNotNullParameter(screenID, "screenID");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.insertLog(screenID);
        }
    }

    @JvmStatic
    public static final boolean isActivityRunning(@Nullable String name) {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isActivityRunning(name);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isAvailableMemoryForNewDocument() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isAvailableMemoryForNewDocument();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isAvailableMinimumMemory() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isAvailableMinimumMemory();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isCoverClosed(@Nullable Context context, boolean cold) {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isCoverClosed(context, cold);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isOnMainUIThread() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isOnMainUIThread();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isPackageInstalledAndEnabled(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isPackageInstalledAndEnabled(packageName);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isRTLMode() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isRTLMode();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isShopDemoDevice() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isShopDemoDevice();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isShowButtonShapeEnabled() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isShowButtonShapeEnabled();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isSpenModel() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isSpenModel();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isTabletModel() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isTabletModel();
        }
        return false;
    }

    @JvmStatic
    public static final boolean isVoiceAssistantEnabled() {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.isVoiceAssistantEnabled();
        }
        return false;
    }

    @JvmStatic
    public static final boolean makeJpg(@Nullable Bitmap bitmap, @NotNull String filePath, boolean recycle) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            return iPlatformDelegate.makeJpg(bitmap, filePath, recycle);
        }
        return false;
    }

    @JvmStatic
    public static final void setButtonShapeEnabledWithTextColor(@NotNull View view, int color) {
        Intrinsics.checkNotNullParameter(view, "view");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.setButtonShapeEnabledWithTextColor(view, color);
        }
    }

    @JvmStatic
    public static final void setDelegate(@Nullable IPlatformDelegate delegate) {
        mDelegate = delegate;
    }

    @JvmStatic
    public static final void setFont(@NotNull TextView textView, @Nullable String fontName) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.setFont(textView, fontName);
        }
    }

    @JvmStatic
    public static final void setSmartTipsPreference(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.setSmartTipsPreference(key, defaultValue);
        }
    }

    @JvmStatic
    public static final void showToast(@Nullable Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.showToast(context, message, duration);
        }
    }

    @JvmStatic
    public static final void insertLog(@Nullable String screenID, @NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.insertLog(screenID, event);
        }
    }

    @JvmStatic
    public static final void showToast(@Nullable Context context, int resId, int duration) {
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.showToast(context, resId, duration);
        }
    }

    @JvmStatic
    public static final void insertLog(@Nullable String screenID, @NotNull String event, @Nullable String detail) {
        Intrinsics.checkNotNullParameter(event, "event");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.insertLog(screenID, event, detail);
        }
    }

    @JvmStatic
    public static final void insertLog(@Nullable String screenID, @NotNull String event, long value) {
        Intrinsics.checkNotNullParameter(event, "event");
        IPlatformDelegate iPlatformDelegate = mDelegate;
        if (iPlatformDelegate != null) {
            iPlatformDelegate.insertLog(screenID, event, value);
        }
    }
}
