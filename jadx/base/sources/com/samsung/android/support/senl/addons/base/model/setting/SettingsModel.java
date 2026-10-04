package com.samsung.android.support.senl.addons.base.model.setting;

import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.addons.base.model.common.IBaseModel;
import com.samsung.android.support.senl.addons.base.model.mode.IMode;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PlatformUtil;
import com.samsung.android.support.senl.p145cm.base.common.util.SpenUtils;
import com.samsung.android.support.senl.p145cm.base.framework.observer.SettingsContentObserver;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0019\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0005HIJKLB\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\fH\u0016J\b\u0010&\u001a\u00020\fH\u0016J\u0010\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\fH\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\u0010H\u0016J\u0006\u0010+\u001a\u00020\fJ\b\u00100\u001a\u00020\u0013H\u0016J\u000e\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020-J\u0016\u00103\u001a\u00020\u00132\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/J\b\u00105\u001a\u0004\u0018\u00010-J\u000e\u00106\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u000107J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:H\u0016J\u0010\u0010;\u001a\u00020\u00132\u0006\u0010<\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002J\b\u0010?\u001a\u00020\u0013H\u0016J\u0012\u0010@\u001a\u00020\u00132\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020\u0013H\u0002J\u0006\u0010D\u001a\u00020\u0013J\u0006\u0010E\u001a\u00020\u0013J\u0006\u0010F\u001a\u00020\u0013J\u0006\u0010G\u001a\u00020\u0013R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SpenOnlyModeModel;", "Lcom/samsung/android/support/senl/addons/base/model/setting/ISettingPropertyNotification;", "Lcom/samsung/android/support/senl/addons/base/model/mode/IMode;", "Lcom/samsung/android/support/senl/addons/base/model/setting/ISettingShow;", "handler", "Lcom/samsung/android/support/senl/addons/base/model/setting/ISPenOnlyModeHandler;", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/ISPenOnlyModeHandler;)V", "mSettingsContentChangedCallback", "Lcom/samsung/android/support/senl/cm/base/framework/observer/SettingsContentObserver$SettingsContentChangedCallback;", "mPopupType", "", "prevMode", "currentMode", "isShowPopup", "", "type", "setAttachSheetVisibility", "", "visibility", "getAttachSheetVisibility", "setPaletteSettingVisibility", "getPaletteSettingVisibility", "setColorGradationVisibility", "getColorGradationVisibility", "setColorPickerVisibility", "getColorPickerVisibility", "setPenSettingVisibility", "getPenSettingVisibility", "setEraserSettingVisibility", "getEraserSettingVisibility", "setSelectionSettingVisibility", "getSelectionSettingVisibility", "clearAllPopupVisibility", "clearPopupsExceptPen", "hideShowingPopup", "getPrevMode", "getCurrentMode", "setMode", "mode", "isMode", "hasShown", "getCurrentPopup", "mHSV", "", "mPaletteList", "", "storeSettingPopupData", "storeHSV", "hsv", "storePaletteList", XmlErrorCodes.LIST, "restoreHSV", "restorePaletteList", "", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "Landroid/os/Bundle;", "onLoadFromInstanceState", "inState", "loadInstanceData", "data", "close", "addObserver", "observer", "Lcom/samsung/android/support/senl/addons/base/model/common/IBaseModel$Observer;", "sendCurrentPopupNotificationId", "registerSpenActivationObserver", "unregisterSpenActivationObserver", "recreateSetting", "updateToolType", "SettingUpdateCmd", "PaletteSettingUpdateCmd", "GradationSettingUpdateCmd", "ColorPickerSettingUpdateCmd", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSettingsModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingsModel.kt\ncom/samsung/android/support/senl/addons/base/model/setting/SettingsModel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,402:1\n1#2:403\n*E\n"})
public class SettingsModel extends SpenOnlyModeModel implements ISettingPropertyNotification, IMode, ISettingShow {

    @NotNull
    private static final String SAVE_INSTANCE_KEY_CURRENT_MODE = "current_mode";

    @NotNull
    private static final String SAVE_INSTANCE_KEY_POPUP = "popup_type";

    @NotNull
    private static final String SAVE_INSTANCE_KEY_PREV_MODE = "prev_mode";
    private int currentMode;

    @Nullable
    private float[] mHSV;

    @Nullable
    private List<Integer> mPaletteList;
    private int mPopupType;

    @Nullable
    private SettingsContentObserver.SettingsContentChangedCallback mSettingsContentChangedCallback;
    private int prevMode;

    @NotNull
    private static final String TAG = Logger.createTag("SettingsModel");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$ColorPickerSettingUpdateCmd;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$SettingUpdateCmd;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "visibility", "", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;Z)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class ColorPickerSettingUpdateCmd extends SettingUpdateCmd {
        public ColorPickerSettingUpdateCmd(boolean z) {
            super(SettingsModel.this, z, 8, 505, "Color Picker Popup");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$GradationSettingUpdateCmd;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$SettingUpdateCmd;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "visibility", "", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;Z)V", "preProcessToShow", "", "preProcessToHide", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class GradationSettingUpdateCmd extends SettingUpdateCmd {
        public GradationSettingUpdateCmd(boolean z) {
            super(SettingsModel.this, z, 4, 504, "Gradation Setting");
        }

        @Override // com.samsung.android.support.senl.addons.base.model.setting.SettingsModel.SettingUpdateCmd
        public void preProcessToHide() {
            if (SettingsModel.this.mHSV != null) {
                SettingsModel.this.mHSV = null;
            }
        }

        @Override // com.samsung.android.support.senl.addons.base.model.setting.SettingsModel.SettingUpdateCmd
        public void preProcessToShow() {
            SettingsModel.this.clearPopupsExceptPen();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$PaletteSettingUpdateCmd;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$SettingUpdateCmd;", "Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;", "visibility", "", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;Z)V", "preProcessToShow", "", "preProcessToHide", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class PaletteSettingUpdateCmd extends SettingUpdateCmd {
        public PaletteSettingUpdateCmd(boolean z) {
            super(SettingsModel.this, z, 32, 506, "Pallet Setting");
        }

        @Override // com.samsung.android.support.senl.addons.base.model.setting.SettingsModel.SettingUpdateCmd
        public void preProcessToHide() {
            if (SettingsModel.this.mPaletteList != null) {
                List list = SettingsModel.this.mPaletteList;
                Intrinsics.checkNotNull(list);
                list.clear();
                SettingsModel.this.mPaletteList = null;
            }
        }

        @Override // com.samsung.android.support.senl.addons.base.model.setting.SettingsModel.SettingUpdateCmd
        public void preProcessToShow() {
            SettingsModel.this.clearPopupsExceptPen();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0090\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel$SettingUpdateCmd;", "", "mVisibility", "", "mMask", "", "mNotificationId", "mLog", "", "<init>", "(Lcom/samsung/android/support/senl/addons/base/model/setting/SettingsModel;ZIILjava/lang/String;)V", Constants.ARG_UPDATE, "", "preProcessToShow", "preProcessToHide", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public class SettingUpdateCmd {

        @NotNull
        private final String mLog;
        private final int mMask;
        private final int mNotificationId;
        private final boolean mVisibility;
        final /* synthetic */ SettingsModel this$0;

        public SettingUpdateCmd(SettingsModel settingsModel, boolean z, int i, @NotNull int i2, String mLog) {
            Intrinsics.checkNotNullParameter(mLog, "mLog");
            this.this$0 = settingsModel;
            this.mVisibility = z;
            this.mMask = i;
            this.mNotificationId = i2;
            this.mLog = mLog;
        }

        public void preProcessToHide() {
        }

        public void preProcessToShow() {
            this.this$0.clearAllPopupVisibility();
        }

        public final void update() {
            if (this.mVisibility != this.this$0.isShowPopup(this.mMask)) {
                if (this.mVisibility) {
                    preProcessToShow();
                    this.this$0.mPopupType |= this.mMask;
                } else {
                    preProcessToHide();
                    this.this$0.mPopupType -= this.mMask;
                }
                String str = SettingsModel.TAG;
                String str2 = this.mVisibility ? "show " : "hide ";
                Logger.m7100d(str, "update : " + str2 + this.mLog);
                this.this$0.notifyChanged(Integer.valueOf(this.mNotificationId));
            }
        }
    }

    public SettingsModel(@Nullable ISPenOnlyModeHandler iSPenOnlyModeHandler) {
        super(iSPenOnlyModeHandler);
        this.prevMode = 2;
        this.currentMode = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPopupsExceptPen() {
        if (isShowPopup(2)) {
            setEraserSettingVisibility(false);
        }
        if (isShowPopup(4)) {
            setColorGradationVisibility(false);
        }
        if (isShowPopup(8)) {
            setColorPickerVisibility(false);
        }
        if (isShowPopup(32)) {
            setPaletteSettingVisibility(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isShowPopup(int type) {
        return (type & this.mPopupType) != 0;
    }

    private final void loadInstanceData(int data) {
        setPenSettingVisibility((data & 1) != 0);
        setEraserSettingVisibility((data & 2) != 0);
        setColorGradationVisibility((data & 4) != 0);
        setColorPickerVisibility((data & 8) != 0);
        setSelectionSettingVisibility((data & 16) != 0);
        setPaletteSettingVisibility((data & 32) != 0);
        setAttachSheetVisibility((data & 64) != 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerSpenActivationObserver$lambda$0(SettingsModel settingsModel, boolean z, Uri uri) {
        boolean zIsSpenActivated = SpenUtils.isSpenActivated();
        Logger.m7100d(TAG, "onChanged, uri/isSpenActivated");
        settingsModel.setSpenActivated(zIsSpenActivated);
        settingsModel.notifyChanged(401);
    }

    private final void sendCurrentPopupNotificationId() {
        if ((this.mPopupType & 1) == 1) {
            notifyChanged(501);
        }
        if ((this.mPopupType & 2) == 2) {
            notifyChanged(502);
        }
        if ((this.mPopupType & 4) == 4) {
            notifyChanged(504);
        }
        if ((this.mPopupType & 8) == 8) {
            notifyChanged(505);
        }
        if ((this.mPopupType & 32) == 32) {
            notifyChanged(506);
        }
        if ((this.mPopupType & 16) == 16) {
            notifyChanged(503);
        }
        if ((this.mPopupType & 64) == 64) {
            notifyChanged(507);
        }
    }

    public void clearAllPopupVisibility() {
        Logger.m7100d(TAG, "clearAllPopupVisibility");
        if (isShowPopup(1)) {
            setPenSettingVisibility(false);
        }
        clearPopupsExceptPen();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.SpenOnlyModeModel
    public void close() {
        this.mHSV = null;
        this.mPaletteList = null;
        super.close();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getAttachSheetVisibility() {
        return isShowPopup(64);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getColorGradationVisibility() {
        return isShowPopup(4);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getColorPickerVisibility() {
        return isShowPopup(8);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.mode.IMode
    public int getCurrentMode() {
        return this.currentMode;
    }

    public final int getCurrentPopup() {
        int i = this.mPopupType;
        if ((i & 2) == 2) {
            return 2;
        }
        if ((i & 4) == 4) {
            return 4;
        }
        if ((i & 8) == 8) {
            return 8;
        }
        if ((i & 32) == 32) {
            return 32;
        }
        if ((i & 16) == 16) {
            return 16;
        }
        if ((i & 1) == 1) {
            return 1;
        }
        return (i & 64) == 64 ? 64 : 0;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getEraserSettingVisibility() {
        return isShowPopup(2);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getPaletteSettingVisibility() {
        return isShowPopup(32);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getPenSettingVisibility() {
        return isShowPopup(1);
    }

    @Override // com.samsung.android.support.senl.addons.base.model.mode.IMode
    public int getPrevMode() {
        return this.prevMode;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public boolean getSelectionSettingVisibility() {
        return isShowPopup(16);
    }

    public boolean hasShown() {
        return this.mPopupType != 0;
    }

    public boolean hideShowingPopup() {
        AbstractC6670b.m4763x("onBack(), popup is = ", Integer.toBinaryString(this.mPopupType & 127), TAG);
        if (isShowPopup(64)) {
            setAttachSheetVisibility(false);
            return true;
        }
        if (isShowPopup(8)) {
            setColorPickerVisibility(false);
            return true;
        }
        if (isShowPopup(4)) {
            setColorGradationVisibility(false);
            return true;
        }
        if (isShowPopup(1)) {
            setPenSettingVisibility(false);
            return true;
        }
        if (isShowPopup(2)) {
            setEraserSettingVisibility(false);
            return true;
        }
        if (isShowPopup(16)) {
            setSelectionSettingVisibility(false);
            return true;
        }
        if (!isShowPopup(32)) {
            return false;
        }
        setPaletteSettingVisibility(false);
        return true;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.mode.IMode
    public boolean isMode(int mode) {
        return this.currentMode == mode;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.SpenOnlyModeModel, com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onLoadFromInstanceState(@NotNull Bundle inState) {
        Intrinsics.checkNotNullParameter(inState, "inState");
        loadInstanceData(inState.getInt(SAVE_INSTANCE_KEY_POPUP, 0));
        this.prevMode = inState.getInt("prev_mode");
        this.currentMode = inState.getInt("current_mode");
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.SpenOnlyModeModel, com.samsung.android.support.senl.addons.base.model.common.ISavableModel
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putInt(SAVE_INSTANCE_KEY_POPUP, this.mPopupType);
        outState.putInt("prev_mode", this.prevMode);
        outState.putInt("current_mode", this.currentMode);
    }

    public final void recreateSetting() {
        if (this.currentMode != 0) {
            Logger.m7100d(TAG, "request recreate popup");
            notifyChanged(509);
        }
    }

    public final void registerSpenActivationObserver() {
        if (PlatformUtil.isSpenModel()) {
            SettingsContentObserver companion = SettingsContentObserver.INSTANCE.getInstance();
            C7956a c7956a = new C7956a(this, 0);
            this.mSettingsContentChangedCallback = c7956a;
            companion.addSettingsContentChangedCallback(c7956a, SpenUtils.SETTINGS_SPEN_ACTIVATED, 0);
        }
    }

    @Nullable
    public final float[] restoreHSV() {
        AbstractC6670b.m4763x("restoreHSV : ", Arrays.toString(this.mHSV), TAG);
        float[] fArr = this.mHSV;
        this.mHSV = null;
        return fArr;
    }

    @Nullable
    public final List<Integer> restorePaletteList() {
        Logger.m7100d(TAG, "restorePaletteList : " + this.mPaletteList);
        List<Integer> list = this.mPaletteList;
        this.mPaletteList = null;
        return list;
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setAttachSheetVisibility(boolean visibility) {
        new SettingUpdateCmd(this, visibility, 64, 507, "Attach Sheet").update();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setColorGradationVisibility(boolean visibility) {
        new GradationSettingUpdateCmd(visibility).update();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setColorPickerVisibility(boolean visibility) {
        new ColorPickerSettingUpdateCmd(visibility).update();
        if (visibility) {
            setMode(5);
        } else if (this.currentMode != 4) {
            setMode(2);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setEraserSettingVisibility(boolean visibility) {
        new SettingUpdateCmd(this, visibility, 2, 502, "Eraser Setting Popup").update();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.mode.IMode
    public void setMode(int mode) {
        int i = this.currentMode;
        if (i != mode) {
            this.prevMode = i;
            this.currentMode = mode;
            Logger.m7100d(TAG, "Mode Changed : " + mode);
            notifyChanged(402);
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setPaletteSettingVisibility(boolean visibility) {
        new PaletteSettingUpdateCmd(visibility).update();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setPenSettingVisibility(boolean visibility) {
        new SettingUpdateCmd(this, visibility, 1, 501, "Pen Setting Popup").update();
    }

    @Override // com.samsung.android.support.senl.addons.base.model.setting.ISettingPropertyNotification
    public void setSelectionSettingVisibility(boolean visibility) {
        new SettingUpdateCmd(this, visibility, 16, 503, "Selection Setting Popup").update();
    }

    public final void storeHSV(@NotNull float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        Logger.m7100d(TAG, "storeHSV");
        this.mHSV = hsv;
    }

    public final void storePaletteList(@Nullable List<Integer> list) {
        Logger.m7100d(TAG, "storePaletteList");
        List<Integer> list2 = this.mPaletteList;
        if (list2 != null) {
            Intrinsics.checkNotNull(list2);
            list2.clear();
        }
        this.mPaletteList = list;
    }

    public void storeSettingPopupData() {
        String str = TAG;
        Logger.m7100d(str, "storeSettingPopupData");
        if (isShowPopup(36)) {
            Logger.m7100d(str, "storeSettingPopupData - send notify");
            notifyChanged(508);
        }
    }

    public final void unregisterSpenActivationObserver() {
        if (PlatformUtil.isSpenModel()) {
            SettingsContentObserver.INSTANCE.getInstance().removeSettingsContentChangedCallback(this.mSettingsContentChangedCallback);
        }
    }

    public final void updateToolType() {
        notifyChanged(403);
    }

    @Override // com.samsung.android.support.senl.addons.base.common.AbsObservable, com.samsung.android.support.senl.addons.base.common.IObservable
    public void addObserver(@Nullable IBaseModel.Observer observer) {
        super.addObserver(observer);
        sendCurrentPopupNotificationId();
    }
}
