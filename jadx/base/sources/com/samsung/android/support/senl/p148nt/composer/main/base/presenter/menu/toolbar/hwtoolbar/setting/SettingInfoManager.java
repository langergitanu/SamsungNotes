package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingAssistanceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingChangeStyleData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingColorPaletteData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingColorPickerData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingColorRecentData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingFavoritePenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingHighlighterData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingLaserPenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingPenInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingPenMiniMenuData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingQuickColorData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingQuickSizeData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingRemoverInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingSelectionInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingSmartPenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingStraightenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingToolbarItemData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.migration.AbsMigrationPolicy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.common.factory.ConfigurationFactory;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SettingInfoManager implements HwSettingContract.ISettingInfoManger {
    private final ComponentFactory mComponentFactory;
    private Context mContext;
    private final boolean mIsTablet;
    private SpenPenManager mPenManager;
    private SettingFavoritePenData mSettingFavoritePenData;
    private SettingHighlighterData mSettingHighlighterData;
    private SettingPenInfoData mSettingPenInfoData;
    private SettingToolbarItemData mSettingToolbarItemData;
    private final WritingToolManager mWritingToolManager;
    private static final String TAG = Logger.createTag("SettingInfoManager");
    private static final String SAVE_SETTING_INFO = Logger.createTag("save_setting_info");
    private final SettingRemoverInfoData mSettingRemoverInfoData = new SettingRemoverInfoData();
    private final SettingSelectionInfoData mSettingSelectionInfoData = new SettingSelectionInfoData();
    private final SettingColorPaletteData mSettingColorPaletteData = new SettingColorPaletteData();
    private final SettingColorRecentData mSettingColorRecentData = new SettingColorRecentData();
    private final SettingChangeStyleData mSettingChangeStyleData = new SettingChangeStyleData();
    private final SettingQuickColorData mSettingQuickColorData = new SettingQuickColorData();
    private final SettingQuickSizeData mSettingQuickSizeData = new SettingQuickSizeData();
    private final SettingStraightenData mSettingStraightenData = new SettingStraightenData();
    private final SettingAssistanceData mSettingAssistanceData = new SettingAssistanceData();
    private final SettingLaserPenData mSettingLaserPenData = new SettingLaserPenData();
    private final SettingSmartPenData mSettingSmartPenData = new SettingSmartPenData();
    private final SettingColorPickerData mSettingColorPickerData = new SettingColorPickerData();
    private final SettingPenMiniMenuData mSettingPenMiniMenuData = new SettingPenMiniMenuData();
    private final LinkedHashMap<String, AbsMigrationPolicy> mReplaceSettingInfoMap = new LinkedHashMap<>();
    private boolean mIsEyeDropperEnabled = true;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ComponentFactory extends ConfigurationFactory {
        @NonNull
        SettingToolbarItemData createSettingToolbarPhoneItemData();

        @NonNull
        SettingToolbarItemData createSettingToolbarTabletItemData();
    }

    @SuppressLint({"CommitPrefEdits"})
    public SettingInfoManager(Context context, WritingToolManager writingToolManager, @NonNull ComponentFactory componentFactory) {
        this.mContext = context;
        this.mWritingToolManager = writingToolManager;
        this.mComponentFactory = componentFactory;
        try {
            this.mPenManager = new SpenPenManager(context);
        } catch (UnsatisfiedLinkError e) {
            Logger.m11000e(TAG, "make SpenPenManager instance error" + e.getMessage());
        }
        this.mIsTablet = ResourceUtils.isTabletLayout(context);
        initSettingData();
    }

    private void initSettingData() {
        this.mSettingPenInfoData = new SettingPenInfoData(this);
        this.mSettingHighlighterData = new SettingHighlighterData(this);
        this.mSettingFavoritePenData = new SettingFavoritePenData(this);
        this.mReplaceSettingInfoMap.put(this.mSettingRemoverInfoData.getPreferenceKey(), this.mSettingRemoverInfoData);
        this.mReplaceSettingInfoMap.put(this.mSettingSelectionInfoData.getPreferenceKey(), this.mSettingSelectionInfoData);
        this.mReplaceSettingInfoMap.put(this.mSettingQuickColorData.getPreferenceKey(), this.mSettingQuickColorData);
        this.mReplaceSettingInfoMap.put(this.mSettingQuickSizeData.getPreferenceKey(), this.mSettingQuickSizeData);
        this.mReplaceSettingInfoMap.put(this.mSettingChangeStyleData.getPreferenceKey(), this.mSettingChangeStyleData);
        this.mReplaceSettingInfoMap.put(this.mSettingColorPaletteData.getPreferenceKey(), this.mSettingColorPaletteData);
        this.mReplaceSettingInfoMap.put(this.mSettingColorRecentData.getPreferenceKey(), this.mSettingColorRecentData);
        this.mReplaceSettingInfoMap.put(this.mSettingStraightenData.getPreferenceKey(), this.mSettingStraightenData);
        this.mReplaceSettingInfoMap.put(this.mSettingAssistanceData.getPreferenceKey(), this.mSettingAssistanceData);
        this.mReplaceSettingInfoMap.put(this.mSettingLaserPenData.getPreferenceKey(), this.mSettingLaserPenData);
        this.mReplaceSettingInfoMap.put(this.mSettingPenInfoData.getPreferenceKey(), this.mSettingPenInfoData);
        this.mReplaceSettingInfoMap.put(this.mSettingHighlighterData.getPreferenceKey(), this.mSettingHighlighterData);
        this.mReplaceSettingInfoMap.put(this.mSettingFavoritePenData.getPreferenceKey(), this.mSettingFavoritePenData);
    }

    public void close() {
        this.mSettingFavoritePenData.close();
        SpenPenManager spenPenManager = this.mPenManager;
        if (spenPenManager != null) {
            spenPenManager.close();
            this.mPenManager = null;
        }
        this.mContext = null;
    }

    public SettingChangeStyleData getChangeStyleData() {
        return this.mSettingChangeStyleData;
    }

    public SettingColorPaletteData getColorPaletteData() {
        return this.mSettingColorPaletteData;
    }

    public SettingColorPickerData getColorPickerData() {
        return this.mSettingColorPickerData;
    }

    public SettingColorRecentData getColorRecentData() {
        return this.mSettingColorRecentData;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingInfoManger
    public Context getContext() {
        return this.mContext;
    }

    public SettingFavoritePenData getFavoritePenData() {
        return this.mSettingFavoritePenData;
    }

    public SettingHighlighterData getHighlighterData() {
        return this.mSettingHighlighterData;
    }

    public SettingLaserPenData getLaserPenData() {
        return this.mSettingLaserPenData;
    }

    public SettingPenInfoData getPenInfoData() {
        return this.mSettingPenInfoData;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingInfoManger
    public SpenPenManager getPenManager() {
        return this.mPenManager;
    }

    public SettingPenMiniMenuData getPenMiniMenuData() {
        return this.mSettingPenMiniMenuData;
    }

    public SettingQuickColorData getQuickColorData() {
        return this.mSettingQuickColorData;
    }

    public SettingQuickSizeData getQuickSizeData() {
        return this.mSettingQuickSizeData;
    }

    public SettingRemoverInfoData getRemoverInfoData() {
        return this.mSettingRemoverInfoData;
    }

    public SettingSelectionInfoData getSelectionInfoData() {
        return this.mSettingSelectionInfoData;
    }

    public SettingAssistanceData getSettingAssistanceData() {
        return this.mSettingAssistanceData;
    }

    public String getSettingInfoMessage(AbsMigrationPolicy<?> absMigrationPolicy) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(absMigrationPolicy.getPreferenceKey(), absMigrationPolicy.getInfoString());
        } catch (JSONException e) {
            Logger.m11000e(TAG, "getSettingInfoMessage " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public SettingSmartPenData getSmartPenData() {
        return this.mSettingSmartPenData;
    }

    public SettingStraightenData getStraightenData() {
        return this.mSettingStraightenData;
    }

    public SettingToolbarItemData getToolbarItemData() {
        if (this.mSettingToolbarItemData == null) {
            if (this.mIsTablet) {
                this.mSettingToolbarItemData = this.mComponentFactory.createSettingToolbarTabletItemData();
            } else {
                this.mSettingToolbarItemData = this.mComponentFactory.createSettingToolbarPhoneItemData();
            }
        }
        return this.mSettingToolbarItemData;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting.HwSettingContract.ISettingInfoManger
    public WritingToolManager getWritingToolManager() {
        return this.mWritingToolManager;
    }

    public void initSettingDataForCoEdit() {
        this.mSettingRemoverInfoData.initSettingDataForCoEdit();
    }

    public boolean isEyeDropperEnabled() {
        return this.mIsEyeDropperEnabled;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m11003i(TAG, "onSaveInstanceState#");
        bundle.putString(SAVE_SETTING_INFO, getSettingInfoMessage(this.mSettingFavoritePenData.getPreferenceKey()));
    }

    public void replaceSettingInfo(String str) {
        JSONObject jSONObject;
        if (str == null || str.isEmpty()) {
            return;
        }
        Iterator<String> itKeys = null;
        try {
            jSONObject = new JSONObject(str);
            try {
                itKeys = jSONObject.keys();
            } catch (JSONException e) {
                e = e;
                Logger.m11000e(TAG, "applySettingInfo Error : " + e.getMessage());
            }
        } catch (JSONException e2) {
            e = e2;
            jSONObject = null;
        }
        while (itKeys != null && itKeys.hasNext()) {
            String next = itKeys.next();
            AbsMigrationPolicy absMigrationPolicy = this.mReplaceSettingInfoMap.get(next);
            String strOptString = jSONObject.optString(next);
            if (absMigrationPolicy != null && !strOptString.isEmpty()) {
                absMigrationPolicy.replace(strOptString);
            }
        }
    }

    public void restore(Bundle bundle) {
        Logger.m11003i(TAG, "restore#");
        replaceSettingInfo(bundle.getString(SAVE_SETTING_INFO));
    }

    public void setEyedropperEnabled(boolean z) {
        this.mIsEyeDropperEnabled = z;
    }

    public void setSaveOperation(boolean z) {
        for (Map.Entry<String, AbsMigrationPolicy> entry : this.mReplaceSettingInfoMap.entrySet()) {
            if (z) {
                entry.getValue().applySave();
            } else {
                entry.getValue().blockSave();
            }
        }
    }

    public String getSettingInfoMessage(String... strArr) {
        JSONObject jSONObject = new JSONObject();
        List listAsList = Arrays.asList(strArr);
        for (Map.Entry<String, AbsMigrationPolicy> entry : this.mReplaceSettingInfoMap.entrySet()) {
            if (listAsList.isEmpty() || !listAsList.contains(entry.getKey())) {
                try {
                    jSONObject.put(entry.getKey(), entry.getValue().getInfoString());
                } catch (JSONException e) {
                    Logger.m11000e(TAG, "getSettingInfoMessage " + e.getMessage());
                }
            }
        }
        return jSONObject.toString();
    }
}
