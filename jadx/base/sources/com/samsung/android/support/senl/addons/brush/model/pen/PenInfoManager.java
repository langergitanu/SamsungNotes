package com.samsung.android.support.senl.addons.brush.model.pen;

import android.content.SharedPreferences;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.addons.base.model.pen.IPenModel;
import com.samsung.android.support.senl.addons.base.model.screen.IScreenModel;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.PreferenceUtils;
import com.samsung.android.support.senl.addons.brush.model.canvas.IBrushCanvasModel;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.Hashtable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J*\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0013J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenInfoManager;", "", "<init>", "()V", "mConvertPenData", "Ljava/util/Hashtable;", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "loadPenModel", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenModel;", "penName", "i", "", "brushCanvasModel", "Lcom/samsung/android/support/senl/addons/brush/model/canvas/IBrushCanvasModel;", "screenModel", "Lcom/samsung/android/support/senl/addons/base/model/screen/IScreenModel;", "getPenInfo", "saveCurrentPenName", "", "savePrevPenName", "prevPenName", "savePenInfo", "penModel", "Lcom/samsung/android/support/senl/addons/base/model/pen/IPenModel;", "clearPrevPreference", "isExistPrevPreference", "", "getSelectedPenName", "getPrevSelectedPenName", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenInfoManager {

    @NotNull
    private static final String BRUSH_V6 = "_brush_v6";

    @NotNull
    private static final String COLOR = "_COLOR";

    @NotNull
    private static final String CURRENT_PEN_NAME = "CURRENT_PEN_NAME";

    @NotNull
    private static final String DRAWING_V5 = "_spensettings_drawing_v5";

    @NotNull
    private static final String KEY_SETTING_PEN_INFO = "KEY_SETTING_PEN_INFO";

    @NotNull
    private static final String NAME = "_NAME";

    @NotNull
    private static final String POSITION = "_POSITION";

    @NotNull
    private static final String PREVIOUS_PEN_NAME = "PREVIOUS_PEN_NAME";

    @NotNull
    private static final String SIZE = "_SIZE";
    private static final int SMUDGE_PEN_COLOR = -9013642;

    @Nullable
    private Hashtable<String, SpenSettingUIPenInfo> mConvertPenData;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenInfoManager");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenInfoManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DRAWING_V5", "BRUSH_V6", "NAME", "SIZE", "COLOR", "POSITION", PenInfoManager.CURRENT_PEN_NAME, PenInfoManager.PREVIOUS_PEN_NAME, "KEY_SETTING_PEN_INFO", "SMUDGE_PEN_COLOR", "", "getInstance", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenInfoManager;", "PenInfoManagerHolder", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\b\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenInfoManager$Companion$PenInfoManagerHolder;", "", "<init>", "()V", "INSTANCE", "Lcom/samsung/android/support/senl/addons/brush/model/pen/PenInfoManager;", "getINSTANCE", "()Lcom/samsung/android/support/senl/addons/brush/model/pen/PenInfoManager;", "INSTANCE$1", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class PenInfoManagerHolder {

            @NotNull
            public static final PenInfoManagerHolder INSTANCE = new PenInfoManagerHolder();

            /* JADX INFO: renamed from: INSTANCE$1, reason: from kotlin metadata */
            @NotNull
            private static final PenInfoManager INSTANCE = new PenInfoManager(null);

            private PenInfoManagerHolder() {
            }

            @NotNull
            public final PenInfoManager getINSTANCE() {
                return INSTANCE;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PenInfoManager getInstance() {
            return PenInfoManagerHolder.INSTANCE.getINSTANCE();
        }

        private Companion() {
        }
    }

    public /* synthetic */ PenInfoManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final SpenSettingUIPenInfo getPenInfo(String penName) {
        Hashtable<String, SpenSettingUIPenInfo> hashtable = this.mConvertPenData;
        if (hashtable == null) {
            return null;
        }
        Intrinsics.checkNotNull(hashtable);
        return hashtable.get(penName);
    }

    public final void clearPrevPreference() {
        SharedPreferences preference = PreferenceUtils.getPreference(DRAWING_V5);
        if (preference == null || !preference.contains("KEY_SETTING_PEN_INFO")) {
            return;
        }
        PreferenceUtils.clearPreference(DRAWING_V5);
    }

    @Nullable
    public final String getPrevSelectedPenName() {
        String string = PreferenceUtils.getString(BRUSH_V6, PREVIOUS_PEN_NAME, IPenModelList.INSTANCE.getPEN_NAMES()[0]);
        AbstractC6670b.m4763x("selected prev pen name: ", string, TAG);
        return string;
    }

    @Nullable
    public final String getSelectedPenName() {
        String string = PreferenceUtils.getString(BRUSH_V6, CURRENT_PEN_NAME, IPenModelList.INSTANCE.getPEN_NAMES()[0]);
        AbstractC6670b.m4763x("selected pen name: ", string, TAG);
        return string;
    }

    public final boolean isExistPrevPreference() {
        SharedPreferences preference = PreferenceUtils.getPreference(DRAWING_V5);
        if (preference == null || !preference.contains("KEY_SETTING_PEN_INFO")) {
            Logger.m7100d(TAG, "isExistPrevPreference. BRUSH_V6");
            return false;
        }
        this.mConvertPenData = BrushSettingViewInforManager.INSTANCE.loadData();
        Logger.m7100d(TAG, "isExistPrevPreference. DRAWING_V5");
        return true;
    }

    @NotNull
    public final PenModel loadPenModel(@NotNull String penName, int i, @Nullable IBrushCanvasModel brushCanvasModel, @Nullable IScreenModel screenModel) {
        Intrinsics.checkNotNullParameter(penName, "penName");
        int i2 = StringsKt.m14162r(penName, "Smudge") ? SMUDGE_PEN_COLOR : PreferenceUtils.getInt(BRUSH_V6, AbstractC0541b.m756B(penName, COLOR), PenDefaultInfo.INSTANCE.getINFO_PEN_COLORS()[i]);
        PenModel penModel = new PenModel(penName, i2, PreferenceUtils.getInt(BRUSH_V6, AbstractC0541b.m756B(penName, SIZE), ((int) PenDefaultInfo.INSTANCE.getINFO_PEN_SIZES()[i]) - 1), PreferenceUtils.getInt(BRUSH_V6, penName + POSITION, -1048576), brushCanvasModel, screenModel);
        String str = TAG;
        String mPenType = penModel.getMPenType();
        String hexString = Integer.toHexString(penModel.getAlphaColor());
        int mPenThickness = penModel.getMPenThickness();
        String hexString2 = Integer.toHexString(penModel.getMPosition());
        StringBuilder sbM16m = AbstractC0000a.m16m("loadPen. name: ", mPenType, " , color: ", hexString, " , size: ");
        sbM16m.append(mPenThickness);
        sbM16m.append(", position:  ");
        sbM16m.append(hexString2);
        Logger.m7100d(str, sbM16m.toString());
        return penModel;
    }

    public final void saveCurrentPenName(@Nullable String penName) {
        PreferenceUtils.putString(BRUSH_V6, CURRENT_PEN_NAME, penName);
    }

    public final void savePenInfo(@NotNull IPenModel penModel) {
        Intrinsics.checkNotNullParameter(penModel, "penModel");
        String mPenClassName = penModel.getMPenClassName();
        Intrinsics.checkNotNull(mPenClassName);
        int alphaColor = StringsKt.m14162r(mPenClassName, "Smudge") ? SMUDGE_PEN_COLOR : penModel.getAlphaColor();
        PreferenceUtils.putString(BRUSH_V6, AbstractC0541b.m756B(penModel.getMPenType(), NAME), penModel.getMPenClassName());
        PreferenceUtils.putInt(BRUSH_V6, penModel.getMPenType() + COLOR, alphaColor);
        PreferenceUtils.putInt(BRUSH_V6, AbstractC0541b.m756B(penModel.getMPenType(), SIZE), penModel.getMPenThickness());
        PreferenceUtils.putInt(BRUSH_V6, AbstractC0541b.m756B(penModel.getMPenType(), POSITION), penModel.getMPosition());
        String str = TAG;
        String mPenType = penModel.getMPenType();
        String hexString = Integer.toHexString(alphaColor);
        int mPenThickness = penModel.getMPenThickness();
        String hexString2 = Integer.toHexString(penModel.getMPosition());
        StringBuilder sbM16m = AbstractC0000a.m16m("loadPen. name: ", mPenType, " , color: ", hexString, " , size: ");
        sbM16m.append(mPenThickness);
        sbM16m.append(", position:  ");
        sbM16m.append(hexString2);
        Logger.m7100d(str, sbM16m.toString());
    }

    public final void savePrevPenName(@Nullable String prevPenName) {
        PreferenceUtils.putString(BRUSH_V6, PREVIOUS_PEN_NAME, prevPenName);
    }

    private PenInfoManager() {
    }

    @NotNull
    public final PenModel loadPenModel(int i, @NotNull String penName, @Nullable IBrushCanvasModel brushCanvasModel, @Nullable IScreenModel screenModel) {
        PenModel penModel;
        Intrinsics.checkNotNullParameter(penName, "penName");
        SpenSettingUIPenInfo penInfo = getPenInfo(penName);
        if (penInfo != null) {
            penModel = new PenModel(penName, penInfo.color, ((int) PenDefaultInfo.INSTANCE.getINFO_PEN_SIZES()[i]) - 1, penInfo.size, -1048576, brushCanvasModel, screenModel);
        } else {
            penModel = new PenModel(penName, PenDefaultInfo.INSTANCE.getINFO_PEN_COLORS()[i], ((int) r13.getINFO_PEN_SIZES()[i]) - 1, -1.0f, -1048576, brushCanvasModel, screenModel);
        }
        String str = TAG;
        String mPenType = penModel.getMPenType();
        String hexString = Integer.toHexString(penModel.getAlphaColor());
        int mPenThickness = penModel.getMPenThickness();
        String hexString2 = Integer.toHexString(penModel.getMPosition());
        StringBuilder sbM16m = AbstractC0000a.m16m("loadPen. name: ", mPenType, " , color: ", hexString, " , size: ");
        sbM16m.append(mPenThickness);
        sbM16m.append(", position:  ");
        sbM16m.append(hexString2);
        Logger.m7100d(str, sbM16m.toString());
        return penModel;
    }
}
