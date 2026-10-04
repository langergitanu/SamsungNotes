package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.FileIOUtil;
import com.samsung.android.sdk.smp.common.util.FilePathUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class NotificationMarketingParser extends MarketingParser {
    private void setImgData(String str, NotificationMarketing notificationMarketing, String str2) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (TextUtils.isEmpty(str) || notificationMarketing == null || TextUtils.isEmpty(str2)) {
            throw new InternalException.InvalidArgumentException();
        }
        if (MarketingConstants.NotificationConst.FLIPPER_FOLDED.equals(str2) || MarketingConstants.NotificationConst.FLIPPER_EXPANDED.equals(str2)) {
            for (int i = 1; i <= 10; i++) {
                String strFindCertainExtension = FileIOUtil.findCertainExtension(str, str2 + i, MarketingConstants.IMAGE_FILE_EXTENSIONS);
                if (strFindCertainExtension == null) {
                    if (i == 1) {
                        throw new InternalException.WrongMarketingDataException();
                    }
                    return;
                } else {
                    if (MarketingConstants.NotificationConst.FLIPPER_FOLDED.equals(str2)) {
                        notificationMarketing.putFoldedFlipperPaths(strFindCertainExtension);
                    } else {
                        notificationMarketing.putExpandedFlipperPaths(strFindCertainExtension);
                    }
                }
            }
            return;
        }
        String strFindCertainExtension2 = FileIOUtil.findCertainExtension(str, str2, MarketingConstants.IMAGE_FILE_EXTENSIONS);
        if (MarketingConstants.NotificationConst.LARGEICON.equals(str2)) {
            notificationMarketing.setLargeIconPath(strFindCertainExtension2);
            return;
        }
        if (MarketingConstants.NotificationConst.SMALLICON.equals(str2)) {
            notificationMarketing.setSmallIconPath(strFindCertainExtension2);
            return;
        }
        if (strFindCertainExtension2 == null) {
            throw new InternalException.WrongMarketingDataException();
        }
        if (MarketingConstants.NotificationConst.BIGPICTURE.equals(str2)) {
            notificationMarketing.setBigPicturePath(strFindCertainExtension2);
        } else if ("banner".equals(str2)) {
            notificationMarketing.setBannerPicturePath(strFindCertainExtension2);
        }
    }

    private void setTxtData(NotificationMarketing notificationMarketing, JSONObject jSONObject, String str) throws InternalException.InvalidArgumentException {
        if (notificationMarketing == null || jSONObject == null || TextUtils.isEmpty(str)) {
            throw new InternalException.InvalidArgumentException();
        }
        str.getClass();
        switch (str) {
            case "subContentText":
                notificationMarketing.setSubContentText(applyLRMUnicode(jSONObject.optString(str, null), false));
                return;
            case "contentText":
                notificationMarketing.setContentText(applyLRMUnicode(jSONObject.getString(str), false));
                return;
            case "contentTitle":
                notificationMarketing.setContentTitle(applyLRMUnicode(jSONObject.getString(str), false));
                return;
            default:
                return;
        }
    }

    @Override // com.samsung.android.sdk.smp.marketing.MarketingParser
    public void parseImageContents(Context context, Marketing marketing) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (context == null || marketing == null) {
            throw new InternalException.InvalidArgumentException();
        }
        String imgDirectory = FilePathUtil.getImgDirectory(context, marketing.getMid());
        NotificationMarketing notificationMarketing = (NotificationMarketing) marketing;
        int foldedType = notificationMarketing.getFoldedType() - 1;
        int expandedType = notificationMarketing.getExpandedType() - 1;
        int i = 0;
        int i2 = 0;
        while (true) {
            String[] strArr = MarketingConstants.NotificationConst.FOLDED_IMG_RES[foldedType];
            if (i2 >= strArr.length) {
                break;
            }
            setImgData(imgDirectory, notificationMarketing, strArr[i2]);
            i2++;
        }
        while (true) {
            String[] strArr2 = MarketingConstants.NotificationConst.EXPANDED_IMG_RES[expandedType];
            if (i >= strArr2.length) {
                return;
            }
            setImgData(imgDirectory, notificationMarketing, strArr2[i]);
            i++;
        }
    }

    @Override // com.samsung.android.sdk.smp.marketing.MarketingParser
    public void parseTextContents(Context context, Marketing marketing, JSONObject jSONObject) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (marketing == null || jSONObject == null) {
            throw new InternalException.InvalidArgumentException();
        }
        NotificationMarketing notificationMarketing = (NotificationMarketing) marketing;
        try {
            notificationMarketing.setTicker(jSONObject.getString("ticker").replaceAll("\n", " "));
            int foldedType = notificationMarketing.getFoldedType() - 1;
            int expandedType = notificationMarketing.getExpandedType() - 1;
            int i = 0;
            int i2 = 0;
            while (true) {
                String[] strArr = MarketingConstants.NotificationConst.FOLDED_TXT_RES[foldedType];
                if (i2 >= strArr.length) {
                    break;
                }
                setTxtData(notificationMarketing, jSONObject, strArr[i2]);
                i2++;
            }
            while (true) {
                String[] strArr2 = MarketingConstants.NotificationConst.EXPANDED_TXT_RES[expandedType];
                if (i >= strArr2.length) {
                    break;
                }
                setTxtData(notificationMarketing, jSONObject, strArr2[i]);
                i++;
            }
            ArrayList<MarketingLink> arrayList = MarketingLink.parse(context, marketing.getMid(), jSONObject);
            if (!MarketingLink.isValid(arrayList, "1")) {
                SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "fail to parse resource. invalid landing page");
                throw new InternalException.WrongMarketingDataException();
            }
            notificationMarketing.setMarketingLinks(arrayList);
            notificationMarketing.setMarketingButtons(MarketingButton.parse(context, marketing.getMid(), jSONObject));
        } catch (JSONException e) {
            SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "fail to parse resource. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }

    @Override // com.samsung.android.sdk.smp.marketing.MarketingParser
    public void parseUserData(Context context, Marketing marketing, JSONObject jSONObject) throws InternalException.WrongMarketingDataException {
        super.parseUserData(context, marketing, jSONObject);
        NotificationMarketing notificationMarketing = (NotificationMarketing) marketing;
        try {
            JSONObject style = notificationMarketing.getStyle();
            notificationMarketing.setFoldedType(style.getInt("f"));
            notificationMarketing.setExpandedType(style.getInt("e"));
            notificationMarketing.setIcon(jSONObject.optBoolean("icon", true));
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MarketingConstants.NotificationConst.FLIPPING_ANIMATION);
            if (notificationMarketing.getExpandedType() == 5) {
                notificationMarketing.setExpandedFlipPeriod(jSONObject.getJSONObject(MarketingConstants.NotificationConst.FLIPPING_PERIOD).getInt("e"));
                if (notificationMarketing.getExpandedFlipPeriod() <= 0) {
                    SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "invalid flipping period");
                    throw new InternalException.WrongMarketingDataException();
                }
                if (jSONObjectOptJSONObject != null) {
                    notificationMarketing.setExpandedFlipAnim(jSONObjectOptJSONObject.optInt("e"));
                }
            }
            if (notificationMarketing.getFoldedType() == 3) {
                notificationMarketing.setFoldedFlipPeriod(jSONObject.getJSONObject(MarketingConstants.NotificationConst.FLIPPING_PERIOD).getInt("f"));
                if (notificationMarketing.getFoldedFlipPeriod() <= 0) {
                    SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "invalid flipping period");
                    throw new InternalException.WrongMarketingDataException();
                }
                if (jSONObjectOptJSONObject != null) {
                    notificationMarketing.setFoldedFlipAnim(jSONObjectOptJSONObject.optInt("f"));
                }
            }
        } catch (Exception e) {
            SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "invalid userdata. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }
}
