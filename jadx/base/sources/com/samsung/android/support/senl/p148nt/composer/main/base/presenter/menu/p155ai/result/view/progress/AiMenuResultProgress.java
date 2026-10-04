package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.progress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.SeslProgressBar;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiViewUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiMenuResultProgress {
    private static final String TAG = Logger.createTag("AiMenuResultProgress", AiConstants.PREFIX_TAG);
    private final AiProgressingView mAiProgressingView;
    private final Context mContext;
    private final TextView mDummyTextView;
    private Integer mLastType;
    private AnimatedHelpTextView mProgressInfoTextSwitcher;
    private final TextView mProgressPercentText;
    private final SeslProgressBar mSeslProgressBar;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class AiProgressingView {
        final LottieAnimationView mProgressBar;
        final AtomicInteger mTranscribeVICount = new AtomicInteger(0);

        public AiProgressingView(View view) {
            this.mProgressBar = (LottieAnimationView) view.findViewById(C9086R.id.ai_menu_result_progress);
        }

        public void clearAnimation() {
            AiMenuResultProgress.this.mProgressInfoTextSwitcher.disappear();
            this.mProgressBar.cancelAnimation();
        }

        public void setAiProgressState(LottieAnimationView lottieAnimationView) {
            lottieAnimationView.setAnimation(AiViewUtils.PROGRESS_LOTTIE_FILE);
            lottieAnimationView.setRepeatCount(-1);
        }

        public void setNoneType() {
            this.mProgressBar.setVisibility(8);
        }

        public void setProgressInfoText(List<String> list) {
            startTranscribeProgressTextVI(list);
        }

        public void startProgress(List<String> list) {
            startProgressIconAnimation();
            if (list == null || list.isEmpty()) {
                Logger.m11003i(AiMenuResultProgress.TAG, "empty loading message, do not display progress info");
                AiMenuResultProgress.this.mProgressInfoTextSwitcher.setVisibility(8);
            } else {
                Collections.shuffle(list);
                this.mTranscribeVICount.set(0);
                startTranscribeProgressTextVI(list);
            }
        }

        public void startProgressIconAnimation() {
            this.mProgressBar.setVisibility(0);
            setAiProgressState(this.mProgressBar);
            this.mProgressBar.playAnimation();
        }

        public void startTranscribeProgressTextVI(List<String> list) {
            int size = list.size();
            String[] strArr = new String[size];
            list.toArray(strArr);
            String str = "";
            for (int i = 0; i < size; i++) {
                String str2 = strArr[i];
                if (str.length() < str2.length()) {
                    str = str2;
                }
            }
            AiMenuResultProgress.this.mDummyTextView.setText(str);
            AiMenuResultProgress.this.mProgressInfoTextSwitcher.setHelpText(strArr);
            AiMenuResultProgress.this.mProgressInfoTextSwitcher.appear();
        }

        public void stopProgress() {
            if (AiMenuResultProgress.this.mSeslProgressBar.getVisibility() == 0) {
                AiMenuResultProgress.this.mSeslProgressBar.setVisibility(8);
                AiMenuResultProgress.this.mProgressInfoTextSwitcher.setVisibility(0);
            }
            clearAnimation();
        }
    }

    public AiMenuResultProgress(View view) {
        this.mContext = view.getContext();
        this.mProgressPercentText = (TextView) view.findViewById(C9086R.id.ai_menu_result_progress_percent);
        this.mSeslProgressBar = (SeslProgressBar) view.findViewById(C9086R.id.ai_menu_result_normal_progress);
        this.mDummyTextView = (TextView) view.findViewById(C9086R.id.ai_menu_result_progress_dummy_text);
        initTextSwitcher(view);
        this.mAiProgressingView = new AiProgressingView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatPercentNumber(int i) {
        String language = Locale.getDefault().getLanguage();
        return ("ar".equals(language) || MarketingConstants.NotificationConst.FLIPPING_ANIMATION.equals(language)) ? String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i)).concat("%") : AbstractC2322a.m1615e(i, "%");
    }

    private List<String> getLoadingMessageList(Context context, int i) {
        switch (i) {
            case 1:
                return new ArrayList(Arrays.asList(context.getResources().getStringArray(C9086R.array.ai_progress_message_translate)));
            case 2:
                return new ArrayList(Arrays.asList(context.getResources().getStringArray(C9086R.array.ai_progress_message_summarize)));
            case 3:
            case 4:
                return new ArrayList(Arrays.asList(context.getResources().getStringArray(C9086R.array.ai_progress_message_auto_formatting)));
            case 5:
                return new ArrayList(Arrays.asList(context.getResources().getStringArray(C9086R.array.ai_progress_message_correction_spelling)));
            case 6:
            default:
                return new ArrayList();
            case 7:
                String string = SharedPreferencesCompat.getInstance("Settings").getString(SettingsConstants.SETTINGS_TRANSCRIBE_AUTO_DETECTED_LANGUAGE, "");
                return TextUtils.isEmpty(string) ? new ArrayList(Arrays.asList(context.getResources().getStringArray(C9086R.array.ai_progress_message_stt_fast_convert))) : new ArrayList(Arrays.asList(context.getResources().getString(C9086R.string.ai_stt_transcribing_into_language, string), context.getResources().getString(C9086R.string.ai_stt_analyze_recording)));
            case 8:
                return new ArrayList(Arrays.asList(context.getResources().getStringArray(C9086R.array.ai_processing_message_create_image)));
        }
    }

    private void initTextSwitcher(View view) {
        AnimatedHelpTextView animatedHelpTextView = (AnimatedHelpTextView) view.findViewById(C9086R.id.ai_menu_result_progress_text_switcher);
        this.mProgressInfoTextSwitcher = animatedHelpTextView;
        if (animatedHelpTextView == null) {
            Logger.m11000e(TAG, "mProgressInfoTextSwitcher is null");
            return;
        }
        final Context applicationContext = view.getContext().getApplicationContext();
        this.mProgressInfoTextSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiMenuResultProgress.1
            @Override // android.widget.ViewSwitcher.ViewFactory
            public View makeView() {
                TextView textView = new TextView(applicationContext);
                textView.setTextSize(1, 15.0f);
                textView.setTextColor(applicationContext.getColor(C9086R.color.change_template_menu_button_tint_color));
                textView.setGravity(17);
                textView.setTextAppearance(C9086R.style.RobotoRegularStyle);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                return textView;
            }
        });
        int childCount = this.mProgressInfoTextSwitcher.getChildCount();
        for (int i = 0; i < childCount; i++) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mProgressInfoTextSwitcher.getChildAt(i).getLayoutParams();
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.gravity = 1;
        }
        this.mProgressInfoTextSwitcher.requestLayout();
    }

    public void clear() {
        this.mAiProgressingView.clearAnimation();
        AnimatedHelpTextView animatedHelpTextView = this.mProgressInfoTextSwitcher;
        if (animatedHelpTextView != null) {
            animatedHelpTextView.clear();
        }
    }

    public Integer getLastType() {
        return this.mLastType;
    }

    public void setProgressInfoText(String str, Context context) {
        this.mAiProgressingView.setProgressInfoText(new ArrayList(Arrays.asList(context.getResources().getString(C9086R.string.ai_stt_transcribing_into_language, str), context.getResources().getString(DeviceUtils.isTabletModel() ? C9086R.string.ai_stt_analyze_recording_tablet : C9086R.string.ai_stt_analyze_recording))));
    }

    public void startProgress(int i) {
        Logger.m11003i(TAG, "startProgress# " + i);
        this.mLastType = Integer.valueOf(i);
        if (i == 0) {
            this.mSeslProgressBar.setVisibility(0);
            this.mAiProgressingView.setNoneType();
            this.mProgressInfoTextSwitcher.setVisibility(8);
            this.mProgressPercentText.setVisibility(8);
            return;
        }
        TextView textView = this.mProgressPercentText;
        if (textView != null) {
            if (i == 7) {
                textView.setVisibility(0);
                this.mProgressPercentText.setText("");
            } else {
                textView.setVisibility(8);
            }
        }
        this.mProgressInfoTextSwitcher.setVisibility(0);
        this.mAiProgressingView.clearAnimation();
        this.mAiProgressingView.startProgress(getLoadingMessageList(this.mContext, i));
    }

    public void stopProgress() {
        Logger.m11003i(TAG, "stopProgress#");
        this.mAiProgressingView.stopProgress();
        this.mLastType = null;
    }

    public void updatePercentProgress(final int i) {
        TextView textView = this.mProgressPercentText;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.mProgressPercentText.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.progress.AiMenuResultProgress.2
            @Override // java.lang.Runnable
            public void run() {
                AiMenuResultProgress.this.mProgressPercentText.setText(AiMenuResultProgress.this.formatPercentNumber(i));
            }
        });
    }

    public void updateProgress(int i) {
        Logger.m11003i(TAG, "updateProgress#");
        stopProgress();
        startProgress(i);
    }
}
