package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class PopupMarketing extends Marketing {
    private static final String TAG = "PopupMarketing";
    private int mBackgroudColor;
    private CharSequence mBodyText;
    private int mBottomColor;
    private ArrayList<MarketingLink> mButton1Links;
    private String mButton1Text;
    private ArrayList<MarketingLink> mButton2Links;
    private String mButton2Text;
    private int mButtonAlign;
    private int mButtonTextColor;
    private boolean mIsBottomVisible;
    private boolean mIsCloseButtonVisible;
    private boolean mIsDisturbOn;
    private int mLineColor;
    private String mMainImagePath;
    private int mTemplateType;
    private int mTextColor;
    private String mWebUrl;

    public PopupMarketing(String str, String str2, String str3, int i) {
        super(str, str2, str3, i);
    }

    private boolean isPopupOverlayAvailable(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            return true;
        }
        if (!DeviceInfoUtil.isWindowOverlayOpAllowed(context)) {
            SmpLog.m6495e(TAG, getMid(), "cannot show popup : disabled window overlay option");
            setToFail(context, FeedbackEvent.DISABLE_POPUP_OPTION, null);
            return false;
        }
        if (DeviceInfoUtil.getTargetSdkVersion(context) < 28 || context.getPackageManager().checkPermission("android.permission.FOREGROUND_SERVICE", context.getPackageName()) == 0) {
            return checkNotificationSettingOption(context, getChannelType());
        }
        SmpLog.m6495e(TAG, getMid(), "cannot show popup : disabled fourground service");
        setToFail(context, FeedbackEvent.DISABLE_POPUP_OPTION, null);
        return false;
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean filterBeforeDisplay(Context context) {
        return super.filterBeforeDisplay(context) && isPopupOverlayAvailable(context);
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean filterBeforeResourceDownload(Context context) {
        return super.filterBeforeResourceDownload(context) && isPopupOverlayAvailable(context);
    }

    public int getBackgroudColor() {
        return this.mBackgroudColor;
    }

    public CharSequence getBodyText() {
        return this.mBodyText;
    }

    public int getBottomColor() {
        return this.mBottomColor;
    }

    public ArrayList<MarketingLink> getButton1Links() {
        return this.mButton1Links;
    }

    public String getButton1Text() {
        return this.mButton1Text;
    }

    public ArrayList<MarketingLink> getButton2Links() {
        return this.mButton2Links;
    }

    public String getButton2Text() {
        return this.mButton2Text;
    }

    public int getButtonAlign() {
        return this.mButtonAlign;
    }

    public int getButtonTextColor() {
        return this.mButtonTextColor;
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing, com.samsung.android.sdk.smp.display.DisplayMeta
    public Bundle getDisplayMeta() {
        Bundle displayMeta = super.getDisplayMeta();
        displayMeta.putInt("template_type", getTemplateType());
        displayMeta.putBoolean(MarketingConstants.DisplayConst.POP_BOTTOM_VISIBLE, isBottomVisible());
        displayMeta.putBoolean(MarketingConstants.DisplayConst.POP_CLOSE_BUTTON_VISIBLE, isCloseButtonVisible());
        displayMeta.putInt(MarketingConstants.DisplayConst.POP_BUTTON_ALIGN, getButtonAlign());
        displayMeta.putInt(MarketingConstants.DisplayConst.POP_COLOR_BG, getBackgroudColor());
        displayMeta.putInt(MarketingConstants.DisplayConst.POP_COLOR_BOTTOM, getBottomColor());
        displayMeta.putInt(MarketingConstants.DisplayConst.POP_COLOR_BUTTON_TEXT, getButtonTextColor());
        displayMeta.putInt(MarketingConstants.DisplayConst.POP_COLOR_BODY_TEXT, getTextColor());
        displayMeta.putInt(MarketingConstants.DisplayConst.POP_COLOR_LINE, getLineColor());
        displayMeta.putCharSequence(MarketingConstants.DisplayConst.POP_BODY_TEXT, getBodyText());
        displayMeta.putString("web", getWebUrl());
        displayMeta.putString(MarketingConstants.DisplayConst.POP_BUTTON1_TEXT, getButton1Text());
        displayMeta.putString(MarketingConstants.DisplayConst.POP_BUTTON2_TEXT, getButton2Text());
        displayMeta.putString(MarketingConstants.DisplayConst.POP_MAIN_IMAGE, getMainImagePath());
        ArrayList arrayList = new ArrayList();
        if (getButton1Links() != null) {
            for (int i = 0; i < 5 && i < getButton1Links().size(); i++) {
                MarketingLink marketingLink = getButton1Links().get(i);
                displayMeta.putBundle(AbstractC0000a.m11h(i, MarketingConstants.DisplayConst.POP_BUTTON1_LINK), marketingLink.toBundle());
                String linkUri = marketingLink.getLinkUri();
                if (!TextUtils.isEmpty(linkUri)) {
                    arrayList.add(linkUri);
                }
            }
        }
        if (getButton2Links() != null) {
            for (int i2 = 0; i2 < 5 && i2 < getButton2Links().size(); i2++) {
                MarketingLink marketingLink2 = getButton2Links().get(i2);
                displayMeta.putBundle(AbstractC0000a.m11h(i2, MarketingConstants.DisplayConst.POP_BUTTON2_LINK), marketingLink2.toBundle());
                String linkUri2 = marketingLink2.getLinkUri();
                if (!TextUtils.isEmpty(linkUri2)) {
                    arrayList.add(linkUri2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            displayMeta.putStringArray(MarketingConstants.DisplayConst.CLICK_LINK_URIS, (String[]) arrayList.toArray(new String[0]));
        }
        displayMeta.putBoolean("disturb", isDisturbOn());
        return displayMeta;
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public String getMainImagePath() {
        return this.mMainImagePath;
    }

    public int getTemplateType() {
        return this.mTemplateType;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public boolean isBottomVisible() {
        return this.mIsBottomVisible;
    }

    public boolean isCloseButtonVisible() {
        return this.mIsCloseButtonVisible;
    }

    public boolean isDisturbOn() {
        return this.mIsDisturbOn;
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean isSupportType() {
        return super.isSupportType() && MarketingConstants.PopupConst.isSupportType(this.mTemplateType);
    }

    public void setBackgroudColor(int i) {
        this.mBackgroudColor = i;
    }

    public void setBodyText(CharSequence charSequence) {
        this.mBodyText = charSequence;
    }

    public void setBottomColor(int i) {
        this.mBottomColor = i;
    }

    public void setButton1Links(ArrayList<MarketingLink> arrayList) {
        this.mButton1Links = arrayList;
    }

    public void setButton1Text(String str) {
        this.mButton1Text = str;
    }

    public void setButton2Links(ArrayList<MarketingLink> arrayList) {
        this.mButton2Links = arrayList;
    }

    public void setButton2Text(String str) {
        this.mButton2Text = str;
    }

    public void setButtonAlign(int i) {
        this.mButtonAlign = i;
    }

    public void setButtonTextColor(int i) {
        this.mButtonTextColor = i;
    }

    public void setIsBottomVisible(boolean z) {
        this.mIsBottomVisible = z;
    }

    public void setIsCloseButtonVisible(boolean z) {
        this.mIsCloseButtonVisible = z;
    }

    public void setIsDisturbOn(boolean z) {
        this.mIsDisturbOn = z;
    }

    public void setLineColor(int i) {
        this.mLineColor = i;
    }

    public void setMainImagePath(String str) {
        this.mMainImagePath = str;
    }

    public void setTemplateType(int i) {
        this.mTemplateType = i;
    }

    public void setTextColor(int i) {
        this.mTextColor = i;
    }

    public void setWebUrl(String str) {
        this.mWebUrl = str;
    }
}
