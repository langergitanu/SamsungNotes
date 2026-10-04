package com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.core.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.tipcard.type.TipCardMeet;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardProgress;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistAsButton;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class TipCardView extends FrameLayout {
    private static final String TAG = "TipCardView";
    private Contract mContract;
    private int mLastProgressAreaWidth;
    private int mLastProgressRateWidth;
    private int mLastProgressTypeWidth;
    private int mPageTag;
    private final TipCard mTipCard;
    private LinearLayout mTipCardButtonBar;
    private TextView mTipCardButtonNegative;
    private TextView mTipCardButtonNeutral;
    private TextView mTipCardButtonPositive;
    private LinearLayout mTipCardLayout;
    private TextView mTipCardMessage;
    private final View.OnClickListener mTipCardNegativeButtonClickListener;
    private final View.OnClickListener mTipCardNeutralButtonClickListener;
    private final View.OnClickListener mTipCardPositiveButtonClickListener;
    private LinearLayout mTipCardProgressArea;
    private ProgressBar mTipCardProgressBar;
    private TextView mTipCardProgressRate;
    private RelativeLayout mTipCardProgressRateTypeArea;
    private TextView mTipCardProgressType;
    private TextView mTipCardTitle;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onTipCardAppUpdate();

        void onTipCardCancel(int i);

        void onTipCardCheckConvertedNotes();

        void onTipCardClose(int i);

        void onTipCardImportAccount();

        void onTipCardManageCloudStorage();

        void onTipCardMdeTryAgain();

        void onTipCardMeetEntering(boolean z);

        void onTipCardMeetNewNote(boolean z);

        void onTipCardOpenSettingsMicrosoftLogin();

        void onTipCardOpenSettingsMicrosoftLoginAgain();

        void onTipCardPermissionNotGranted(int i);

        void onTipCardRetry(int i);

        void onTipCardSyncWithSamsungCloud(int i);

        void onTipCardTryAgain(int i);

        void onTipcardEnterCode();
    }

    public TipCardView(Context context, TipCard tipCard) {
        super(context);
        this.mLastProgressAreaWidth = -1;
        this.mLastProgressRateWidth = -1;
        this.mLastProgressTypeWidth = -1;
        this.mTipCardPositiveButtonClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int type = TipCardView.this.mTipCard.getType();
                MainLogger.m7258i(TipCardView.TAG, "mTipCardPositiveButtonClickListener type " + type);
                if (view.getVisibility() == 8) {
                }
                if (type == 2) {
                    CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_IMPORT_TIPCARD_ERROR_RETRY_BUTTON);
                    TipCardView.this.mContract.onTipCardRetry(type);
                    return;
                }
                if (type == 18) {
                    TipCardView.this.mContract.onTipCardImportAccount();
                    return;
                }
                if (type == 25) {
                    TipCardView.this.mContract.onTipCardPermissionNotGranted(25);
                    return;
                }
                if (type == 6 || type == 7) {
                    TipCardView.this.mContract.onTipCardTryAgain(type);
                    return;
                }
                if (type == 22) {
                    TipCardView.this.mContract.onTipCardClose(type);
                    return;
                }
                if (type == 23) {
                    TipCardView.this.mContract.onTipCardOpenSettingsMicrosoftLogin();
                    return;
                }
                if (type == 27) {
                    TipCardView.this.mContract.onTipCardOpenSettingsMicrosoftLoginAgain();
                    return;
                }
                if (type == 28) {
                    TipCardView.this.mContract.onTipCardMeetEntering(((TipCardMeet) TipCardView.this.mTipCard).isHost());
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, ((TipCardMeet) TipCardView.this.mTipCard).isHost() ? "7680" : "7681");
                    return;
                }
                if (type == 30) {
                    TipCardView.this.mContract.onTipCardAppUpdate();
                    return;
                }
                if (type == 31) {
                    TipCardView.this.mContract.onTipcardEnterCode();
                    return;
                }
                switch (type) {
                    case 11:
                        TipCardView.this.mContract.onTipCardPermissionNotGranted(11);
                        break;
                    case 12:
                        TipCardView.this.mContract.onTipCardManageCloudStorage();
                        break;
                    case 13:
                        TipCardView.this.mContract.onTipCardMdeTryAgain();
                        break;
                    default:
                        switch (type) {
                            case 34:
                            case 35:
                            case 37:
                                TipCardView.this.mContract.onTipCardSyncWithSamsungCloud(type);
                                break;
                            case 36:
                                TipCardView.this.mContract.onTipCardCheckConvertedNotes();
                                break;
                            default:
                                AbstractC8014b.m7201c(type, "Unknown tipCard type: ", TipCardView.TAG);
                                break;
                        }
                        break;
                }
            }
        };
        this.mTipCardNegativeButtonClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int type = TipCardView.this.mTipCard.getType();
                MainLogger.m7258i(TipCardView.TAG, "mTipCardNegativeButtonClickListener type " + type);
                if (view.getVisibility() == 8) {
                    return;
                }
                if (type == 1 || type == 2) {
                    CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_IMPORT_TIPCARD_CANCEL_BUTTON);
                } else if (type != 21 && type != 24 && type != 26) {
                    AbstractC8014b.m7201c(type, "Unknown tipCard type: ", TipCardView.TAG);
                }
                TipCardView.this.mContract.onTipCardCancel(type);
            }
        };
        this.mTipCardNeutralButtonClickListener = new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.tipcard.view.TipCardView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int type = TipCardView.this.mTipCard.getType();
                MainLogger.m7258i(TipCardView.TAG, "mTipCardNeutralButtonClickListener type " + type);
                if (view.getVisibility() == 8) {
                    return;
                }
                if (type == 2 || type == 4) {
                    CommonSamsungAnalytics.insertLog("101", NotesSAConstants.EVENT_IMPORT_TIPCARD_ERROR_CLOSE_BUTTON);
                } else if (type != 11 && type != 18 && type != 23 && type != 37 && type != 6 && type != 7 && type != 27) {
                    if (type == 28) {
                        TipCardView.this.mContract.onTipCardMeetNewNote(((TipCardMeet) TipCardView.this.mTipCard).isHost());
                        CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_COEDIT_MAIN, "7679");
                        return;
                    } else if (type != 34 && type != 35) {
                        AbstractC8014b.m7201c(type, "Unknown tipCard type: ", TipCardView.TAG);
                    }
                }
                TipCardView.this.mContract.onTipCardClose(type);
            }
        };
        this.mTipCard = tipCard;
        initLayout(context);
    }

    private void decorateButtonBar() {
        int i = getResources().getConfiguration().screenWidthDp;
        boolean z = this.mTipCard.getType() == 36 || i < 340;
        LinearLayout linearLayout = this.mTipCardButtonBar;
        if (linearLayout != null) {
            if (z && linearLayout.getOrientation() == 1) {
                return;
            }
            if (!z && this.mTipCardButtonBar.getOrientation() == 0) {
                return;
            }
        }
        AbstractC8014b.m7201c(i, "decorateButtonBar# screenWidth: ", TAG);
        LinearLayout linearLayout2 = this.mTipCardButtonBar;
        if (linearLayout2 != null) {
            this.mTipCardLayout.removeView(linearLayout2);
            this.mTipCardButtonBar = null;
            this.mTipCardButtonPositive = null;
            this.mTipCardButtonNegative = null;
            this.mTipCardButtonNeutral = null;
        }
        LinearLayout linearLayout3 = (LinearLayout) LayoutInflater.from(getContext()).inflate(z ? C8003R.layout.tipcard_button_bar_layout_vertical : C8003R.layout.tipcard_button_bar_layout_horizontal, (ViewGroup) this, false);
        this.mTipCardButtonBar = linearLayout3;
        this.mTipCardLayout.addView(linearLayout3);
        decoratePositiveButton();
        decorateNegativeButton();
        decorateNeutralButton();
    }

    private void decorateMessage() {
        String message = this.mTipCard.getMessage();
        if (TextUtils.isEmpty(message)) {
            this.mTipCardMessage.setVisibility(8);
        } else {
            this.mTipCardMessage.setVisibility(0);
            this.mTipCardMessage.setText(message);
        }
    }

    private void decorateNegativeButton() {
        if (this.mTipCardButtonNegative == null) {
            TextView textView = (TextView) findViewById(C8003R.id.tipcard_button_negative);
            this.mTipCardButtonNegative = textView;
            textView.setOnClickListener(this.mTipCardNegativeButtonClickListener);
            CharUtils.applyTextSizeUntilLargeSize(getContext(), this.mTipCardButtonNegative, 15.0f);
        }
        int negativeButtonResource = this.mTipCard.getNegativeButtonResource();
        if (negativeButtonResource <= 0) {
            this.mTipCardButtonNegative.setVisibility(8);
            return;
        }
        this.mTipCardButtonNegative.setVisibility(0);
        this.mTipCardButtonNegative.setText(negativeButtonResource);
        this.mTipCardButtonNegative.setAccessibilityDelegate(new VoiceAssistAsButton());
        highlightButtonShape(this.mTipCardButtonNegative);
    }

    private void decorateNeutralButton() {
        if (this.mTipCardButtonNeutral == null) {
            TextView textView = (TextView) findViewById(C8003R.id.tipcard_button_neutral);
            this.mTipCardButtonNeutral = textView;
            textView.setOnClickListener(this.mTipCardNeutralButtonClickListener);
            CharUtils.applyTextSizeUntilLargeSize(getContext(), this.mTipCardButtonNeutral, 15.0f);
        }
        int neutralButtonResourceId = this.mTipCard.getNeutralButtonResourceId();
        if (neutralButtonResourceId <= 0) {
            this.mTipCardButtonNeutral.setVisibility(8);
            return;
        }
        this.mTipCardButtonNeutral.setVisibility(0);
        this.mTipCardButtonNeutral.setText(neutralButtonResourceId);
        this.mTipCardButtonNeutral.setAccessibilityDelegate(new VoiceAssistAsButton());
        highlightButtonShape(this.mTipCardButtonNeutral);
    }

    private void decoratePositiveButton() {
        if (this.mTipCardButtonPositive == null) {
            TextView textView = (TextView) findViewById(C8003R.id.tipcard_button_positive);
            this.mTipCardButtonPositive = textView;
            textView.setOnClickListener(this.mTipCardPositiveButtonClickListener);
            CharUtils.applyTextSizeUntilLargeSize(getContext(), this.mTipCardButtonPositive, 15.0f);
        }
        int positiveButtonResource = this.mTipCard.getPositiveButtonResource();
        if (positiveButtonResource <= 0) {
            this.mTipCardButtonPositive.setVisibility(8);
            return;
        }
        this.mTipCardButtonPositive.setVisibility(0);
        this.mTipCardButtonPositive.setText(positiveButtonResource);
        this.mTipCardButtonPositive.setAccessibilityDelegate(new VoiceAssistAsButton());
        highlightButtonShape(this.mTipCardButtonPositive);
    }

    private void decorateProgressRateTypeArea() {
        if (this.mTipCardProgressRateTypeArea.getVisibility() != 0) {
            return;
        }
        int measuredWidth = this.mTipCardProgressRateTypeArea.getMeasuredWidth();
        int measuredWidth2 = this.mTipCardProgressRate.getMeasuredWidth();
        int measuredWidth3 = this.mTipCardProgressType.getMeasuredWidth();
        if (this.mLastProgressAreaWidth == measuredWidth && this.mLastProgressRateWidth == measuredWidth2 && this.mLastProgressTypeWidth == measuredWidth3) {
            return;
        }
        this.mLastProgressAreaWidth = measuredWidth;
        this.mLastProgressRateWidth = measuredWidth2;
        this.mLastProgressTypeWidth = measuredWidth3;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(measuredWidth, measuredWidth2, "decorateProgressRateTypeArea, areaWidth: ", ", rateWidth: ", ", typeWidth: ");
        sbM1173s.append(measuredWidth3);
        MainLogger.m7254d(TAG, sbM1173s.toString());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTipCardProgressType.getLayoutParams();
        if (measuredWidth < measuredWidth2 + measuredWidth3 + 100) {
            layoutParams.removeRule(21);
            layoutParams.addRule(20);
            layoutParams.addRule(3, C8003R.id.tipcard_progress_rate);
        } else {
            layoutParams.addRule(21);
            layoutParams.removeRule(20);
            layoutParams.removeRule(3);
        }
        this.mTipCardProgressType.setLayoutParams(layoutParams);
    }

    private void decorateTitle() {
        int titleResource = this.mTipCard.getTitleResource();
        if (titleResource <= 0) {
            this.mTipCardTitle.setVisibility(8);
        } else {
            this.mTipCardTitle.setVisibility(0);
            this.mTipCardTitle.setText(titleResource);
        }
    }

    private void highlightButtonShape(TextView textView) {
        if (!ButtonBackgroundUtils.isShowButtonShapeEnabled(textView.getContext())) {
            textView.setTextColor(textView.getContext().getResources().getColor(C8003R.color.tip_card_button_text_color, null));
        } else {
            textView.setBackgroundResource(C8003R.drawable.tip_card_button_shape_bg);
            textView.setTextColor(textView.getContext().getResources().getColor(C8003R.color.tip_card_background, null));
        }
    }

    private void initLayout(Context context) {
        addView(LayoutInflater.from(context).inflate(C8003R.layout.tipcard_layout, (ViewGroup) this, false));
        this.mTipCardLayout = (LinearLayout) findViewById(C8003R.id.tipcard_layout);
        this.mTipCardTitle = (TextView) findViewById(C8003R.id.tipcard_title);
        this.mTipCardMessage = (TextView) findViewById(C8003R.id.tipcard_message);
        this.mTipCardButtonBar = (LinearLayout) findViewById(C8003R.id.tipcard_button_bar);
        this.mTipCardProgressArea = (LinearLayout) findViewById(C8003R.id.tipcard_progress_area);
        this.mTipCardProgressRateTypeArea = (RelativeLayout) findViewById(C8003R.id.tipcard_progress_rate_type_area);
        this.mTipCardProgressBar = (ProgressBar) findViewById(C8003R.id.tipcard_progress_bar);
        this.mTipCardProgressRate = (TextView) findViewById(C8003R.id.tipcard_progress_rate);
        this.mTipCardProgressType = (TextView) findViewById(C8003R.id.tipcard_progress_type);
        CharUtils.applyTextSizeUntilLargeSize(context, this.mTipCardTitle, 19.0f);
        CharUtils.applyTextSizeUntilLargeSize(context, this.mTipCardMessage, 15.0f);
        CharUtils.applyTextSizeUntilLargeSize(context, this.mTipCardProgressRate, 14.0f);
        CharUtils.applyTextSizeUntilLargeSize(context, this.mTipCardProgressType, 14.0f);
    }

    private void setBackgroundResources() {
        if (DeviceInfo.isVSTModel()) {
            GradientDrawable gradientDrawable = (GradientDrawable) ContextCompat.getDrawable(getContext(), C8003R.drawable.tipcard_background);
            gradientDrawable.setColor(ContextCompat.getColor(getContext(), C8003R.color.tip_card_background_for_vst));
            this.mTipCardLayout.setBackground(gradientDrawable);
        }
    }

    public void decorateProgress() {
        if (!this.mTipCard.isProgressTipCard()) {
            this.mTipCardProgressArea.setVisibility(8);
            this.mTipCardProgressRateTypeArea.setVisibility(8);
            return;
        }
        TipCardProgress tipCardProgress = (TipCardProgress) this.mTipCard;
        if (this.mTipCardProgressBar.getProgress() == tipCardProgress.getProgressValue()) {
            return;
        }
        this.mTipCardProgressArea.setVisibility(0);
        this.mTipCardProgressRateTypeArea.setVisibility(0);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTipCardButtonBar.getLayoutParams();
        layoutParams.topMargin = getResources().getDimensionPixelSize(C8003R.dimen.tipcard_button_bar_margin_top_when_progress_bar_showing);
        this.mTipCardButtonBar.setLayoutParams(layoutParams);
        this.mTipCardProgressRate.setText(tipCardProgress.getProgressRate());
        this.mTipCardProgressBar.setProgress(tipCardProgress.getProgressValue());
        this.mTipCardProgressBar.setIndeterminate(tipCardProgress.isFinished());
        this.mTipCardProgressRateTypeArea.setVisibility(tipCardProgress.isNotInitialized() ? 8 : 0);
        MainLogger.m7258i(TAG, "TipCardView progress... " + tipCardProgress.getProgressValue());
    }

    public void decorateProgressType() {
        if (this.mTipCard.isProgressTipCard()) {
            TipCardProgress tipCardProgress = (TipCardProgress) this.mTipCard;
            if (tipCardProgress.getProgressTypeResId() > 0) {
                this.mTipCardProgressType.setText(tipCardProgress.getProgressTypeResId());
            } else {
                this.mTipCardProgressType.setText("");
            }
        }
    }

    public int getPageTag() {
        return this.mPageTag;
    }

    public TipCard getTipCard() {
        return this.mTipCard;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        decorateButtonBar();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        decorateProgressRateTypeArea();
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void setPageTag(int i) {
        this.mPageTag = i;
    }

    public void updateLayout() {
        MainLogger.m7258i(TAG, "updateLayout# type : " + this.mTipCard.getType());
        decorateTitle();
        decorateMessage();
        decorateButtonBar();
        decorateProgress();
        decorateProgressType();
        setBackgroundResources();
    }
}
