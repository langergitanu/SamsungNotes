package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenFontSizeSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightConfig;
import com.samsung.android.sesl.visualeffect.lighteffects.processinglight.ProcessingLightEffect;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.TextStyleHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerSpenWNoteUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiViewUtils {
    public static final int APPLY_FONT_SIZE_MAX = 24;
    public static final int APPLY_FONT_SIZE_MIN = 12;
    public static final float DISABLE_ALPHA = 0.4f;
    public static final String PROGRESS_LOTTIE_FILE = "intelligence_progress_color.json";

    public static void applyDefViewerSpFontSizeAll(Context context, SpenObjectTextBox spenObjectTextBox) {
        changeFontSize(spenObjectTextBox, getDefViewerSpFontSize(context));
    }

    public static void applySmartAlignment(SpenObjectTextBox spenObjectTextBox, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split("\n");
        int i = 0;
        while (i < strArrSplit.length) {
            int i2 = i + 1;
            spenObjectTextBox.appendTextParagraph(new SpenAlignmentParagraph(i, i2, hasRtlCharacters(strArrSplit[i]) ? 1 : 0));
            i = i2;
        }
    }

    public static void applySpFontSize(Context context, SpenObjectTextBox spenObjectTextBox) {
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        if (textSpan == null) {
            return;
        }
        float spRatio = getSpRatio(context);
        ArrayList<SpenTextSpanBase> arrayList = new ArrayList<>(textSpan.size());
        for (SpenTextSpanBase spenTextSpanBase : textSpan) {
            if (spenTextSpanBase instanceof SpenFontSizeSpan) {
                ((SpenFontSizeSpan) spenTextSpanBase).setSize((int) (r3.getSize() * spRatio));
            }
            arrayList.add(spenTextSpanBase);
        }
        spenObjectTextBox.setTextSpan(arrayList);
    }

    public static Bitmap blur(Context context, Bitmap bitmap, float f) {
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * 0.5f), Math.round(bitmap.getHeight() * 0.5f), false);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
        RenderScript renderScriptCreate = RenderScript.create(context);
        ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
        Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
        Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
        scriptIntrinsicBlurCreate.setRadius(f);
        scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
        scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
        allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
        return bitmapCreateBitmap;
    }

    public static void changeFontSize(SpenObjectTextBox spenObjectTextBox, int i) {
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        if (textSpan == null) {
            return;
        }
        ArrayList<SpenTextSpanBase> arrayList = new ArrayList<>(textSpan.size());
        for (SpenTextSpanBase spenTextSpanBase : textSpan) {
            if (spenTextSpanBase instanceof SpenFontSizeSpan) {
                ((SpenFontSizeSpan) spenTextSpanBase).setSize(i);
            }
            arrayList.add(spenTextSpanBase);
        }
        spenObjectTextBox.setTextSpan(arrayList);
    }

    public static int convertPxToDp(Context context, int i) {
        return (int) (i / (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    public static int getDefApplyFontSize(@Nullable SpenObjectTextBox spenObjectTextBox, SrcContentInfo srcContentInfo) {
        if (srcContentInfo.getSrcType() == 2 || srcContentInfo.getSrcType() == 0 || spenObjectTextBox == null) {
            return 15;
        }
        return getDefaultFontSize(spenObjectTextBox.findTextSpan(srcContentInfo.mStartPos, srcContentInfo.mEndPos), srcContentInfo.mStartPos, srcContentInfo.mEndPos);
    }

    public static int getDefViewerFontSize(Context context) {
        return (ModelFeature.getFeature().isFoldableModel() || DeviceUtils.isTabletModel()) ? 17 : 15;
    }

    public static int getDefViewerSpFontSize(Context context) {
        return (int) (getSpRatio(context) * getDefViewerFontSize(context));
    }

    private static int getDefaultFontSize(ArrayList<SpenTextSpanBase> arrayList, int i, int i2) {
        int defaultFontSize = ComposerSpenWNoteUtils.getDefaultFontSize(arrayList, i, i2);
        if (defaultFontSize < 12) {
            return 12;
        }
        if (defaultFontSize > 24) {
            return 24;
        }
        return defaultFontSize;
    }

    public static float getSpRatio(Context context) {
        return 1.0f;
    }

    public static int getTextMeasuredHeight(SpenWNote spenWNote) {
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(BaseUtils.getApplicationContext());
        spenBodyTextContext.setDocument(spenWNote);
        spenBodyTextContext.measureText();
        int measuredHeight = spenBodyTextContext.getMeasuredHeight();
        spenBodyTextContext.close();
        return measuredHeight;
    }

    public static boolean hasNewStyleTag(@Nullable View view) {
        String str;
        return (view == null || (str = (String) view.getTag()) == null || !str.equals(view.getResources().getString(C9086R.string.ai_new_style_tag))) ? false : true;
    }

    public static boolean hasRtlCharacters(String str) {
        if (str != null && !str.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                byte directionality = Character.getDirectionality(str.charAt(i));
                if (directionality == 1 || directionality == 2 || directionality == 16 || directionality == 17 || directionality == 20) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isAtLeastOneUI7() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 70000;
    }

    public static boolean isAtLeastOneUI85() {
        return SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500;
    }

    public static boolean isSupportFloatingLayout() {
        return DeviceInfo.isSemDevice() && SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80000;
    }

    public static boolean isTabletLayout(Context context) {
        return ResourceUtils.isTabletLayout(context);
    }

    @RequiresApi(api = 33)
    public static ProcessingLightEffect makeAiPdfOverlayProcessingLightEffect(View view) {
        ProcessingLightConfig vi_config_default = ProcessingLightConfig.INSTANCE.getVI_CONFIG_DEFAULT();
        vi_config_default.setAngle(84.0f);
        vi_config_default.setDurationInMillis(2000L);
        vi_config_default.setBlendMode(ProcessingLightConfig.BlendMode.PREMULT);
        vi_config_default.setFrameRate(60.0f);
        return new ProcessingLightEffect(view.getContext(), view, vi_config_default);
    }

    public static void restoreDpFromSpFontSize(Context context, SpenObjectTextBox spenObjectTextBox, int i) {
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        if (textSpan == null) {
            return;
        }
        float spRatio = getSpRatio(context);
        ArrayList<SpenTextSpanBase> arrayList = new ArrayList<>(textSpan.size());
        for (SpenTextSpanBase spenTextSpanBase : textSpan) {
            if (spenTextSpanBase instanceof SpenFontSizeSpan) {
                ((SpenFontSizeSpan) spenTextSpanBase).setSize(((int) (r3.getSize() / spRatio)) + i);
            }
            arrayList.add(spenTextSpanBase);
        }
        spenObjectTextBox.setTextSpan(arrayList);
    }

    public static void setDefApplyFontSizeAll(@Nullable SpenObjectTextBox spenObjectTextBox, SpenObjectTextBox spenObjectTextBox2, SrcContentInfo srcContentInfo) {
        ComposerSpenWNoteUtils.changeFontSizeSpan(spenObjectTextBox2, getDefApplyFontSize(spenObjectTextBox, srcContentInfo));
    }

    public static void setResultTextBoxState(SpenObjectTextBox spenObjectTextBox) {
        spenObjectTextBox.setMargin(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public static void showCustomToast(Context context, String str) {
        ToastHelper.show(context, str, 0, true, Integer.valueOf(C9086R.layout.ai_custom_toast_layout));
    }

    public static void updateOriginalTextColor(Context context, SrcContentInfo srcContentInfo, SpenWNote spenWNote, ArrayList<SpenTextSpanBase> arrayList) {
        if (arrayList == null) {
            return;
        }
        spenWNote.getBodyText().setTextSpan(arrayList);
        int length = 0;
        for (int i = 0; i < srcContentInfo.getInputIndex(); i++) {
            length += srcContentInfo.getInputList().get(i).length();
        }
        if (length < spenWNote.getBodyText().getText().length()) {
            new TextStyleHelper(spenWNote.getBodyText()).setTextColor(context.getColor(C9086R.color.ai_menu_result_origin_text_dim_color), new int[]{length + 1, srcContentInfo.getSelectedText().length()});
        }
    }

    public static boolean isTabletLayout(ComposerModel composerModel) {
        return composerModel.isTabletLayout();
    }
}
