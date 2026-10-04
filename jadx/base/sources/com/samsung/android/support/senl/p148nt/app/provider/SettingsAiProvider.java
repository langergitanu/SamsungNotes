package com.samsung.android.support.senl.p148nt.app.provider;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.settings.external.DynamicMenuData;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SettingsAiProvider extends ExternalSettingsProvider {
    private String SAMSUNG_NOTES_KEY = "samsung_note_assist";
    private String GET_FEATURES = "get_features";
    private String ONLINE_LIST_KEY = "key_online_ai_features";
    private String OFFLINE_LIST_KEY = "key_offline_ai_features";

    private String[] getOfflineList() {
        Resources resources = getContext().getResources();
        ArrayList arrayList = new ArrayList();
        arrayList.add(resources.getString(C8003R.string.ai_translate_name));
        arrayList.add(resources.getString(C8003R.string.ai_result_transcribe_btn));
        if (Features.isSupportOnDeviceSummaryFunction()) {
            arrayList.add(resources.getString(C8003R.string.ai_summarize_name));
        }
        if (FeatureInfo.isNeedNoticeSolveMath()) {
            arrayList.add(resources.getString(C8003R.string.ai_notes_solve_math));
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private String[] getOnlineList() {
        Resources resources = getContext().getResources();
        ArrayList arrayList = new ArrayList();
        arrayList.add(resources.getString(C8003R.string.ai_auto_format_name));
        if (!Features.isSupportOnDeviceSummaryFunction()) {
            arrayList.add(resources.getString(C8003R.string.ai_summarize_name));
        }
        arrayList.add(resources.getString(C8003R.string.ai_spelling_correction));
        arrayList.add(resources.getString(C8003R.string.note_style_cover_suggested_button));
        if (FeatureInfo.isAiDrawingS2IEnabled()) {
            arrayList.add(resources.getString(AiDrawingUtil.isDrawingToolkitUsed() ? Features.isCreativeStudioSupported() ? C8003R.string.ai_creative_studio : C8003R.string.ai_drawing_assist : C8003R.string.ai_drawing_sketch_to_image_name));
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    private int getSummaryRes() {
        return (FeatureInfo.isAiDrawingS2IEnabled() && FeatureInfo.isNeedNoticeSolveMath()) ? C8003R.string.settings_notes_assist_notice_with_solve_math_with_drawing_1 : FeatureInfo.isAiDrawingS2IEnabled() ? C8003R.string.settings_notes_assist_notice_with_drawing_1 : FeatureInfo.isNeedNoticeSolveMath() ? C8003R.string.settings_notes_assist_notice_with_solve_math_1 : C8003R.string.settings_notes_assist_notice_1;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable Bundle bundle) {
        if (!this.GET_FEATURES.equals(str2)) {
            return super.call(str, str2, str3, bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putStringArray(this.ONLINE_LIST_KEY, getOnlineList());
        bundle2.putStringArray(this.OFFLINE_LIST_KEY, getOfflineList());
        return bundle2;
    }

    @Override // com.samsung.android.settings.external.ExternalSettingsProvider
    public boolean onCheckedChanged(String str, boolean z) {
        return false;
    }

    @Override // com.samsung.android.settings.external.ExternalSettingsProvider
    public void onCreateData() {
        MainLogger.m7258i(ExternalSettingsProvider.TAG, "onCreateData");
        BaseUtils.setProviderContext(getContext());
        addMenuData(new DynamicMenuData.Builder().setKey(this.SAMSUNG_NOTES_KEY).setTitleRes(C8003R.string.settings_notes_assist).setSummaryRes(getSummaryRes()).setVisible(true).build());
        BaseUtils.setProviderContext(null);
    }

    @Override // com.samsung.android.settings.external.ExternalSettingsProvider, android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, @Nullable String str2, @Nullable Bundle bundle) {
        if (this.GET_FEATURES.equals(str)) {
            Bundle bundle2 = new Bundle();
            bundle2.putStringArray(this.ONLINE_LIST_KEY, getOnlineList());
            bundle2.putStringArray(this.OFFLINE_LIST_KEY, getOfflineList());
            return bundle2;
        }
        return super.call(str, str2, bundle);
    }
}
