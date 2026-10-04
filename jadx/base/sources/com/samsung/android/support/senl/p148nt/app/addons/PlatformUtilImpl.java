package com.samsung.android.support.senl.p148nt.app.addons;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.SViewManager;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.NotesSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FontUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.base.winset.smarttip.SmartTipsPreferenceManager;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\"\u0010\u0015\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u000bH\u0016J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u000bH\u0016J\u001a\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016J\u001a\u0010%\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010'\u001a\u00020\u000bH\u0016J\b\u0010(\u001a\u00020\u000bH\u0016J\b\u0010)\u001a\u00020\u000bH\u0016J\b\u0010*\u001a\u00020\u0011H\u0016J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\bH\u0016J\u001a\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\bH\u0016J$\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010+\u001a\u00020\u00112\b\u0010,\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\b2\u0006\u0010/\u001a\u000200H\u0016J\u001c\u00101\u001a\u0004\u0018\u00010\b2\u0006\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\bH\u0016J\b\u00104\u001a\u00020\u000fH\u0016J\"\u00105\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u000bH\u0016J\b\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000fH\u0016J\u0018\u0010=\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\b2\u0006\u0010>\u001a\u00020\u000fH\u0016J\"\u0010?\u001a\u00020\u00112\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fH\u0016J\"\u0010?\u001a\u00020\u00112\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010B\u001a\u00020\b2\u0006\u0010A\u001a\u00020\u000fH\u0016J\u001a\u0010C\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010D\u001a\u00020\u000bH\u0016J\b\u0010E\u001a\u00020\u000fH\u0016J\u0012\u0010F\u001a\u00020\u000b2\b\u0010G\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006H"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/addons/PlatformUtilImpl;", "Lcom/samsung/android/support/senl/addons/base/utils/IPlatformDelegate;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mBaseContext", "getThumbnailExtension", "", "getBrushFileExtension", "isTabletModel", "", "isSpenModel", "isShopDemoDevice", "getScreenOrientation", "", "setButtonShapeEnabledWithTextColor", "", "view", "Landroid/view/View;", "color", "changeCustomButtonBackgroundUnchangedTextColor", "btnShapeBGId1", "btnShapeBGId2", "isOnMainUIThread", "isPackageInstalledAndEnabled", "packageName", "initializePenLibrary", "isRTLMode", "applyTextSizeUntilLargeSize", "textView", "Landroid/widget/TextView;", "fontSize", "", "getColorPrimary", "convertPixelToSp", "pixel", "setFont", "fontName", "isVoiceAssistantEnabled", "isAvailableMemoryForNewDocument", "isAvailableMinimumMemory", "executeBaseLogic", "insertLog", "screenID", "event", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "value", "", "getFileNameByTime", "prefix", BundleContract.EXTRA_DATA, "getMaxTextureSize", "makeJpg", "bitmap", "Landroid/graphics/Bitmap;", "filePath", "recycle", "isShowButtonShapeEnabled", "setSmartTipsPreference", "key", "getSmartTipsPreference", "defaultValue", "showToast", "resId", XmlErrorCodes.DURATION, "message", "isCoverClosed", "cold", "getCoverType", "isActivityRunning", "name", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PlatformUtilImpl implements IPlatformDelegate {

    @NotNull
    private final Context mBaseContext;

    public PlatformUtilImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.mBaseContext = applicationContext;
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void applyTextSizeUntilLargeSize(@Nullable TextView textView, float fontSize) {
        CharUtils.applyTextSizeUntilLargeSize(this.mBaseContext, textView, fontSize);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void changeCustomButtonBackgroundUnchangedTextColor(@Nullable View view, int btnShapeBGId1, int btnShapeBGId2) {
        ButtonShapeUtil.changeCustomButtonBackgroundUnchangedTextColor(view, btnShapeBGId1, btnShapeBGId2);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public float convertPixelToSp(float pixel) {
        return ResourceUtils.convertPixelToSp(this.mBaseContext, pixel);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void executeBaseLogic() {
        PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(2);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    @NotNull
    public String getBrushFileExtension() {
        return "spp";
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public int getColorPrimary() {
        return ResourceUtils.getPrimaryColor(this.mBaseContext);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public int getCoverType() {
        return SViewManager.INSTANCE.getInstance().getCoverType();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    @Nullable
    public String getFileNameByTime(@NotNull String prefix, @Nullable String extension) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNull(extension);
        return FileExtensions.getFileNameByTime(prefix, extension);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public int getMaxTextureSize() {
        return ImageUtils.getMaxTextureSize();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public int getScreenOrientation() {
        return DisplayUtils.getScreenOrientation();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public int getSmartTipsPreference(@NotNull String key, int defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return SmartTipsPreferenceManager.getSmartTipsPreference(this.mBaseContext, key, defaultValue);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    @NotNull
    public String getThumbnailExtension() {
        return "jpg";
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void initializePenLibrary() {
        SpenSdkInitializer.initialize(this.mBaseContext);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void insertLog(@NotNull String screenID) {
        Intrinsics.checkNotNullParameter(screenID, "screenID");
        NotesSamsungAnalytics.INSTANCE.insertLog(screenID);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isActivityRunning(@Nullable String name) {
        if (name == null) {
            return false;
        }
        return ApplicationManager.INSTANCE.getInstance().getActivityTracker().isActivityRunning(name);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isAvailableMemoryForNewDocument() {
        return StorageUtils.isAvailableMemoryForNewMemo();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isAvailableMinimumMemory() {
        return StorageUtils.isAvailableMinimumMemory();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isCoverClosed(@Nullable Context context, boolean cold) {
        return SViewManager.INSTANCE.getInstance().isCoverClosed(context, cold);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isOnMainUIThread() {
        return CommonUtils.isOnMainUIThread();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isPackageInstalledAndEnabled(@NotNull String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return CommonUtils.isPackageInstalledAndEnabled(this.mBaseContext, packageName);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isRTLMode() {
        return LocaleUtils.isRTLMode();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isShopDemoDevice() {
        return DeviceUtils.isShopDemoDevice(this.mBaseContext);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isShowButtonShapeEnabled() {
        return ButtonBackgroundUtils.isShowButtonShapeEnabled(this.mBaseContext);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isSpenModel() {
        return DeviceUtils.isSpenModel();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isTabletModel() {
        return DeviceUtils.isTabletModel();
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean isVoiceAssistantEnabled() {
        return VoiceAssistantTTS.INSTANCE.isVoiceAssistantEnabled(this.mBaseContext);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public boolean makeJpg(@Nullable Bitmap bitmap, @NotNull String filePath, boolean recycle) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return ImageUtils.makeJpg(bitmap, filePath, 100, recycle);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void setButtonShapeEnabledWithTextColor(@NotNull View view, int color) {
        Intrinsics.checkNotNullParameter(view, "view");
        ButtonShapeUtil.setButtonShapeEnabledWithTextColor(view, color);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void setFont(@NotNull TextView textView, @Nullable String fontName) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        FontUtils.setFont(textView, fontName);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void setSmartTipsPreference(@NotNull String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        SmartTipsPreferenceManager.setSmartTipsPreference(this.mBaseContext, key, value);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void showToast(@Nullable Context context, int resId, int duration) {
        ToastHandler.show(context, resId, duration);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void insertLog(@Nullable String screenID, @NotNull String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void showToast(@Nullable Context context, @NotNull String message, int duration) {
        Intrinsics.checkNotNullParameter(message, "message");
        ToastHandler.show(context, message, duration);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void insertLog(@Nullable String screenID, @NotNull String event, @Nullable String detail) {
        Intrinsics.checkNotNullParameter(event, "event");
        NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event, detail);
    }

    @Override // com.samsung.android.support.senl.addons.base.utils.IPlatformDelegate
    public void insertLog(@Nullable String screenID, @NotNull String event, long value) {
        Intrinsics.checkNotNullParameter(event, "event");
        NotesSamsungAnalytics.INSTANCE.insertLog(screenID, event, value);
    }
}
