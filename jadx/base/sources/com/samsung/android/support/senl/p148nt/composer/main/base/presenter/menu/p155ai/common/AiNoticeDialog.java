package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiNoticeDialog extends AiCommonNoticeDialog {
    private static final String TAG = "AiNoticeDialog";

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public int getLayoutResource() {
        return C9086R.layout.ai_notice_dialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public int getMessageResource(boolean z) {
        boolean z2 = !z && FeatureInfo.isAiDrawingS2IEnabled();
        boolean zIsNeedNoticeSolveMath = FeatureInfo.isNeedNoticeSolveMath();
        return z2 ? zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_with_solve_math_with_drawing_1 : C9086R.string.settings_notes_assist_notice_with_drawing_1 : zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_with_solve_math_1 : C9086R.string.settings_notes_assist_notice_1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public int getNotice2Resource(boolean z) {
        boolean zIsKoreaModel = SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel();
        boolean zIsTabletModel = DeviceUtils.isTabletModel();
        boolean zIsNeedNoticeSolveMath = FeatureInfo.isNeedNoticeSolveMath();
        boolean z2 = !z && FeatureInfo.isAiDrawingS2IEnabled();
        return zIsKoreaModel ? zIsTabletModel ? z2 ? zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_korea_tablet_drawing_math_2 : C9086R.string.settings_notes_assist_notice_korea_tablet_drawing_2 : zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_korea_tablet_math_2 : C9086R.string.settings_notes_assist_notice_korea_tablet_2 : z2 ? zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_korea_phone_drawing_math_2 : C9086R.string.settings_notes_assist_notice_korea_phone_drawing_2 : zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_korea_phone_math_2 : C9086R.string.settings_notes_assist_notice_korea_phone_2 : zIsTabletModel ? z2 ? zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_global_tablet_drawing_math_2 : C9086R.string.settings_notes_assist_notice_global_tablet_drawing_2 : zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_global_tablet_math_2 : C9086R.string.settings_notes_assist_notice_global_tablet_2 : z2 ? zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_global_phone_drawing_math_2 : C9086R.string.settings_notes_assist_notice_global_phone_drawing_2 : zIsNeedNoticeSolveMath ? C9086R.string.settings_notes_assist_notice_global_phone_math_2 : C9086R.string.settings_notes_assist_notice_global_phone_2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public int getNotice3Resource(boolean z) {
        boolean z2 = !z && FeatureInfo.isAiDrawingS2IEnabled();
        boolean zIsCreativeStudioSupported = Features.isCreativeStudioSupported();
        return SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel() ? z2 ? zIsCreativeStudioSupported ? C9086R.string.settings_notes_assist_notice_with_creative_studio_3_kr : C9086R.string.settings_notes_assist_notice_with_drawing_3_kr : C9086R.string.settings_notes_assist_notice_3_kr : z2 ? zIsCreativeStudioSupported ? C9086R.string.settings_notes_assist_notice_with_creative_studio_3 : C9086R.string.settings_notes_assist_notice_with_drawing_3 : C9086R.string.settings_notes_assist_notice_3;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public StringBuilder getNoticeMessage(Context context, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(context.getString(getNotice2Resource(z)));
        sb.append(MarkdownDocument.NEW_LINE);
        sb.append(context.getString(getNotice3Resource(z), "#1", "#2", "#3", "#4"));
        return sb;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonNoticeDialog
    public int getTitleResource() {
        return C9086R.string.settings_notes_assist_notice_title;
    }
}
