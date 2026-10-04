package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.constants.MarketingState;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class NotificationMarketing extends Marketing {
    private static final String TAG = "NotificationManager";
    private String mBannerPicturePath;
    private String mBigPicturePath;
    private ArrayList<MarketingButton> mButtonLinks;
    private String mContentText;
    private String mContentTitle;
    private int mExpandedFlipAnim;
    private int mExpandedFlipPeriod;
    private final ArrayList<String> mExpandedFlipperPaths;
    private int mExpandedType;
    private int mFoldedFlipAnim;
    private int mFoldedFlipPeriod;
    private final ArrayList<String> mFoldedFlipperPaths;
    private int mFoldedType;
    private boolean mIcon;
    private String mLargeIconPath;
    private ArrayList<MarketingLink> mMarketingLinks;
    private String mSmallIconPath;
    private String mSubContentText;
    private String mTicker;

    public NotificationMarketing(String str, String str2, String str3, int i) {
        super(str, str2, str3, i);
        this.mFoldedFlipperPaths = new ArrayList<>();
        this.mExpandedFlipperPaths = new ArrayList<>();
    }

    public boolean checkNotificationVisible(Context context) {
        return DeviceInfoUtil.isNotificationVisible(context, getDisplayId());
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public void clearDisplayedMarketing(Context context) {
        DBHandler dBHandlerOpen = DBHandler.open(context);
        if (dBHandlerOpen == null) {
            SmpLog.m6494e(TAG, "fail to clear. db open fail");
            return;
        }
        if (MarketingState.DISPLAYED.equals(dBHandlerOpen.getMarketingState(getMid()))) {
            if (DeviceInfoUtil.getTargetSdkVersion(context) < 31 || Build.VERSION.SDK_INT < 31) {
                SmpLog.m6499i(TAG, getMid(), "clearDisplayedMarketing. generate none_reaction feedback");
                FeedbackManager.addFeedback(context, getMid(), FeedbackEvent.NONE_REACTION, null);
            } else {
                boolean zCheckNotificationVisible = checkNotificationVisible(context);
                boolean zIsMarketingLandingRedirected = dBHandlerOpen.isMarketingLandingRedirected(getMid());
                SmpLog.m6499i(TAG, getMid(), "clearDisplayedMarketing. visible to user:" + zCheckNotificationVisible + ", isRedirected:" + zIsMarketingLandingRedirected);
                if (zCheckNotificationVisible) {
                    FeedbackManager.addFeedback(context, getMid(), FeedbackEvent.NONE_REACTION, null);
                } else if (!dBHandlerOpen.isMarketingLandingRedirected(getMid())) {
                    FeedbackManager.addFeedback(context, getMid(), FeedbackEvent.CLICKED, null);
                }
            }
        }
        super.clearDisplayedMarketing(context);
        dBHandlerOpen.close();
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean filterBeforeDisplay(Context context) {
        return super.filterBeforeDisplay(context) && checkNotificationSettingOption(context, getChannelType()) && !checkNotificationVisible(context);
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean filterBeforeGetMarketingStatus(Context context) {
        return super.filterBeforeGetMarketingStatus(context);
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean filterBeforeResourceDownload(Context context) {
        return super.filterBeforeResourceDownload(context) && checkNotificationSettingOption(context, getChannelType());
    }

    public String getBannerPicturePath() {
        return this.mBannerPicturePath;
    }

    public String getBigPicturePath() {
        return this.mBigPicturePath;
    }

    public String getContentText() {
        return this.mContentText;
    }

    public String getContentTitle() {
        return this.mContentTitle;
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing, com.samsung.android.sdk.smp.display.DisplayMeta
    public Bundle getDisplayMeta() {
        Bundle displayMeta = super.getDisplayMeta();
        displayMeta.putString("ticker", getTicker());
        displayMeta.putInt(MarketingConstants.DisplayConst.NOTIF_F_TYPE, getFoldedType());
        displayMeta.putInt(MarketingConstants.DisplayConst.NOTIF_E_TYPE, getExpandedType());
        displayMeta.putString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TITLE, getContentTitle());
        displayMeta.putString(MarketingConstants.DisplayConst.NOTIF_CONTENT_TEXT, getContentText());
        displayMeta.putString(MarketingConstants.DisplayConst.NOTIF_SUB_CONTENT_TEXT, getSubContentText());
        displayMeta.putString(MarketingConstants.DisplayConst.NOTIF_SMALL_ICON_PATH, getSmallIconPath());
        displayMeta.putString(MarketingConstants.DisplayConst.NOTIF_LARGE_ICON_PATH, getLargeIconPath());
        displayMeta.putString(MarketingConstants.DisplayConst.NOTIF_BIG_PICTURE_PATH, getBigPicturePath());
        displayMeta.putString("banner", getBannerPicturePath());
        displayMeta.putBoolean(MarketingConstants.DisplayConst.NOTIF_ICON, getIcon());
        if (!getFoldedFlipperPaths().isEmpty()) {
            displayMeta.putStringArrayList(MarketingConstants.DisplayConst.NOTIF_F_FLIPPER_PATH, getFoldedFlipperPaths());
            displayMeta.putInt(MarketingConstants.DisplayConst.NOTIF_F_FLIPPER_PERIOD, getFoldedFlipPeriod());
            displayMeta.putInt(MarketingConstants.DisplayConst.NOTIF_F_FLIPPER_ANIMATION, getFoldedFlipAnim());
        }
        if (!getExpandedFlipperPaths().isEmpty()) {
            displayMeta.putStringArrayList(MarketingConstants.DisplayConst.NOTIF_E_FLIPPER_PATH, getExpandedFlipperPaths());
            displayMeta.putInt(MarketingConstants.DisplayConst.NOTIF_E_FLIPPER_PERIOD, getExpandedFlipPeriod());
            displayMeta.putInt(MarketingConstants.DisplayConst.NOTIF_E_FLIPPER_ANIMATION, getExpandedFlipAnim());
        }
        if (getMarketingLinks() != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 5 && i < getMarketingLinks().size(); i++) {
                MarketingLink marketingLink = getMarketingLinks().get(i);
                displayMeta.putBundle(AbstractC0000a.m11h(i, "click_link"), marketingLink.toBundle());
                String linkUri = marketingLink.getLinkUri();
                if (!TextUtils.isEmpty(linkUri)) {
                    arrayList.add(linkUri);
                }
            }
            if (!arrayList.isEmpty()) {
                displayMeta.putStringArray(MarketingConstants.DisplayConst.CLICK_LINK_URIS, (String[]) arrayList.toArray(new String[0]));
            }
        }
        if (getMarketingButton() != null) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 3 && i2 < getMarketingButton().size(); i2++) {
                MarketingButton marketingButton = getMarketingButton().get(i2);
                displayMeta.putBundle(AbstractC0000a.m11h(i2, MarketingConstants.DisplayConst.NOTIF_BUTTON), marketingButton.toBundle());
                for (int i4 = 0; i4 < marketingButton.getMarketingLinks().size(); i4++) {
                    String linkUri2 = marketingButton.getMarketingLinks().get(i4).getLinkUri();
                    if (!TextUtils.isEmpty(linkUri2)) {
                        arrayList2.add(linkUri2);
                    }
                }
            }
        }
        return displayMeta;
    }

    public int getExpandedFlipAnim() {
        return this.mExpandedFlipAnim;
    }

    public int getExpandedFlipPeriod() {
        return this.mExpandedFlipPeriod;
    }

    public ArrayList<String> getExpandedFlipperPaths() {
        return this.mExpandedFlipperPaths;
    }

    public int getExpandedType() {
        return this.mExpandedType;
    }

    public int getFoldedFlipAnim() {
        return this.mFoldedFlipAnim;
    }

    public int getFoldedFlipPeriod() {
        return this.mFoldedFlipPeriod;
    }

    public ArrayList<String> getFoldedFlipperPaths() {
        return this.mFoldedFlipperPaths;
    }

    public int getFoldedType() {
        return this.mFoldedType;
    }

    public boolean getIcon() {
        return this.mIcon;
    }

    public String getLargeIconPath() {
        return this.mLargeIconPath;
    }

    public ArrayList<MarketingButton> getMarketingButton() {
        return this.mButtonLinks;
    }

    public ArrayList<MarketingLink> getMarketingLinks() {
        return this.mMarketingLinks;
    }

    public String getSmallIconPath() {
        return this.mSmallIconPath;
    }

    public String getSubContentText() {
        return this.mSubContentText;
    }

    public String getTicker() {
        return this.mTicker;
    }

    @Override // com.samsung.android.sdk.smp.marketing.Marketing
    public boolean isSupportType() {
        return super.isSupportType() && MarketingConstants.NotificationConst.isSupportType(this.mFoldedType, this.mExpandedType);
    }

    public void putExpandedFlipperPaths(String str) {
        this.mExpandedFlipperPaths.add(str);
    }

    public void putFoldedFlipperPaths(String str) {
        this.mFoldedFlipperPaths.add(str);
    }

    public void setBannerPicturePath(String str) {
        this.mBannerPicturePath = str;
    }

    public void setBigPicturePath(String str) {
        this.mBigPicturePath = str;
    }

    public void setContentText(String str) {
        this.mContentText = str;
    }

    public void setContentTitle(String str) {
        this.mContentTitle = str;
    }

    public void setExpandedFlipAnim(int i) {
        this.mExpandedFlipAnim = i;
    }

    public void setExpandedFlipPeriod(int i) {
        this.mExpandedFlipPeriod = i;
    }

    public void setExpandedType(int i) {
        this.mExpandedType = i;
    }

    public void setFoldedFlipAnim(int i) {
        this.mFoldedFlipAnim = i;
    }

    public void setFoldedFlipPeriod(int i) {
        this.mFoldedFlipPeriod = i;
    }

    public void setFoldedType(int i) {
        this.mFoldedType = i;
    }

    public void setIcon(boolean z) {
        this.mIcon = z;
    }

    public void setLargeIconPath(String str) {
        this.mLargeIconPath = str;
    }

    public void setMarketingButtons(ArrayList<MarketingButton> arrayList) {
        this.mButtonLinks = arrayList;
    }

    public void setMarketingLinks(ArrayList<MarketingLink> arrayList) {
        this.mMarketingLinks = arrayList;
    }

    public void setSmallIconPath(String str) {
        this.mSmallIconPath = str;
    }

    public void setSubContentText(String str) {
        this.mSubContentText = str;
    }

    public void setTicker(String str) {
        this.mTicker = str;
    }
}
