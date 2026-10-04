package com.samsung.android.support.senl.addons.base.model.canvas.view.settings;

import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/SettingPopupBuilder;", "", "<init>", "()V", "Factory", "SettingPopupInfo", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public class SettingPopupBuilder {

    /* JADX INFO: renamed from: Factory, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.samsung.android.support.senl.addons.base.model.canvas.view.settings.SettingPopupBuilder$Factory, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0005¨\u0006\u0011"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/SettingPopupBuilder$Factory;", "", "<init>", "()V", "createNonePopup", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopup;", "createPenPopup", Constants.IntentExtraValue.SHOW, "", "createErasePopup", "createGradationPopup", "data", "createColorPickerPopup", "createSelectionPopup", "createColorPalletPopup", "createAttachSheetPopup", "createRecreatePopup", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ISettingPopup createAttachSheetPopup(boolean show) {
            return new SettingPopupInfo(show, 64);
        }

        @NotNull
        public final ISettingPopup createColorPalletPopup(boolean show, @Nullable Object data) {
            return new SettingPopupInfo(show, 32, data);
        }

        @NotNull
        public final ISettingPopup createColorPickerPopup(boolean show) {
            return new SettingPopupInfo(show, 8);
        }

        @NotNull
        public final ISettingPopup createErasePopup(boolean show) {
            return new SettingPopupInfo(show, 2);
        }

        @NotNull
        public final ISettingPopup createGradationPopup(boolean show, @Nullable Object data) {
            return new SettingPopupInfo(show, 4, data);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final ISettingPopup createNonePopup() {
            return new SettingPopupInfo(false, 0 == true ? 1 : 0, 3, null);
        }

        @NotNull
        public final ISettingPopup createPenPopup(boolean show) {
            return new SettingPopupInfo(show, 1);
        }

        @NotNull
        public final ISettingPopup createRecreatePopup() {
            return new SettingPopupInfo(true, 65536);
        }

        @NotNull
        public final ISettingPopup createSelectionPopup(boolean show) {
            return new SettingPopupInfo(show, 16);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B#\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u000b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/SettingPopupBuilder$SettingPopupInfo;", "Lcom/samsung/android/support/senl/addons/base/model/canvas/view/settings/ISettingPopup;", "isShow", "", "type", "", "<init>", "(ZI)V", "data", "", "(ZILjava/lang/Object;)V", "mIsShow", "mType", "mData", "getType", "getData", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SettingPopupInfo implements ISettingPopup {

        @Nullable
        private Object mData;
        private boolean mIsShow;
        private int mType;

        /* JADX WARN: Multi-variable type inference failed */
        @JvmOverloads
        public SettingPopupInfo() {
            this(false, 0 == true ? 1 : 0, 3, null);
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopup
        @Nullable
        /* JADX INFO: renamed from: getData, reason: from getter */
        public Object getMData() {
            return this.mData;
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopup
        /* JADX INFO: renamed from: getType, reason: from getter */
        public int getMType() {
            return this.mType;
        }

        @Override // com.samsung.android.support.senl.addons.base.model.canvas.view.settings.ISettingPopup
        /* JADX INFO: renamed from: isShow, reason: from getter */
        public boolean getMIsShow() {
            return this.mIsShow;
        }

        @JvmOverloads
        public SettingPopupInfo(boolean z) {
            this(z, 0, 2, null);
        }

        public /* synthetic */ SettingPopupInfo(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? 0 : i);
        }

        @JvmOverloads
        public SettingPopupInfo(boolean z, int i) {
            this.mIsShow = z;
            this.mType = i;
        }

        public SettingPopupInfo(boolean z, int i, @Nullable Object obj) {
            this.mIsShow = z;
            this.mType = i;
            this.mData = obj;
        }
    }
}
