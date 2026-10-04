package com.samsung.android.sdk.smp.marketing;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.util.FileIOUtil;
import com.samsung.android.sdk.smp.common.util.FilePathUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class PopupMarketingParser extends MarketingParser {
    private int parseColor(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return i;
        }
    }

    private void setImgData(String str, PopupMarketing popupMarketing, String str2) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (TextUtils.isEmpty(str) || popupMarketing == null || TextUtils.isEmpty(str2)) {
            throw new InternalException.InvalidArgumentException();
        }
        if (MarketingConstants.PopupConst.MAIN_IMG.equals(str2)) {
            String strFindCertainExtension = FileIOUtil.findCertainExtension(str, str2, MarketingConstants.IMAGE_FILE_EXTENSIONS);
            if (strFindCertainExtension == null) {
                throw new InternalException.WrongMarketingDataException();
            }
            popupMarketing.setMainImagePath(strFindCertainExtension);
        }
    }

    private void setTxtData(PopupMarketing popupMarketing, JSONObject jSONObject, String str) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (popupMarketing == null || jSONObject == null || TextUtils.isEmpty(str)) {
            throw new InternalException.InvalidArgumentException();
        }
        if ("body".equals(str)) {
            try {
                popupMarketing.setBodyText(Html.fromHtml(applyLRMUnicode(jSONObject.getString("body"), true)));
            } catch (Exception unused) {
                throw new InternalException.WrongMarketingDataException();
            }
        } else if ("web".equals(str)) {
            popupMarketing.setWebUrl(jSONObject.getString(str));
        }
    }

    @Override // com.samsung.android.sdk.smp.marketing.MarketingParser
    public void parseImageContents(Context context, Marketing marketing) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (context == null || marketing == null) {
            throw new InternalException.InvalidArgumentException();
        }
        String imgDirectory = FilePathUtil.getImgDirectory(context, marketing.getMid());
        PopupMarketing popupMarketing = (PopupMarketing) marketing;
        int templateType = popupMarketing.getTemplateType() - 1;
        int i = 0;
        while (true) {
            String[] strArr = MarketingConstants.PopupConst.IMG_RES[templateType];
            if (i >= strArr.length) {
                return;
            }
            setImgData(imgDirectory, popupMarketing, strArr[i]);
            i++;
        }
    }

    @Override // com.samsung.android.sdk.smp.marketing.MarketingParser
    public void parseTextContents(Context context, Marketing marketing, JSONObject jSONObject) throws InternalException.WrongMarketingDataException, InternalException.InvalidArgumentException {
        if (marketing == null || jSONObject == null) {
            throw new InternalException.InvalidArgumentException();
        }
        PopupMarketing popupMarketing = (PopupMarketing) marketing;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("pop");
            int templateType = popupMarketing.getTemplateType() - 1;
            int i = 0;
            while (true) {
                String[] strArr = MarketingConstants.PopupConst.TXT_RES[templateType];
                if (i >= strArr.length) {
                    break;
                }
                setTxtData(popupMarketing, jSONObject2, strArr[i]);
                i++;
            }
            if (popupMarketing.isBottomVisible()) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(MarketingConstants.PopupConst.BUTTON1);
                String string = jSONObject3.getString("text");
                if (string.length() > 10) {
                    string = string.substring(0, 10);
                }
                popupMarketing.setButton1Text(string);
                popupMarketing.setButton1Links(MarketingLink.parse(context, marketing.getMid(), jSONObject3));
                if (!MarketingLink.isValid(popupMarketing.getButton1Links(), "2")) {
                    SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "fail to parse resource. invalid landing page");
                    throw new InternalException.WrongMarketingDataException();
                }
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(MarketingConstants.PopupConst.BUTTON2);
                if (jSONObjectOptJSONObject != null) {
                    String string2 = jSONObjectOptJSONObject.getString("text");
                    if (string2.length() > 10) {
                        string2 = string2.substring(0, 10);
                    }
                    popupMarketing.setButton2Text(string2);
                    popupMarketing.setButton2Links(MarketingLink.parse(context, marketing.getMid(), jSONObjectOptJSONObject));
                    if (MarketingLink.isValid(popupMarketing.getButton2Links(), "2")) {
                        return;
                    }
                    SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "fail to parse resource. invalid landing page");
                    throw new InternalException.WrongMarketingDataException();
                }
            }
        } catch (JSONException e) {
            SmpLog.m6495e(MarketingParser.TAG, marketing.getMid(), "invalid resource file. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }

    @Override // com.samsung.android.sdk.smp.marketing.MarketingParser
    public void parseUserData(Context context, Marketing marketing, JSONObject jSONObject) throws InternalException.WrongMarketingDataException {
        super.parseUserData(context, marketing, jSONObject);
        PopupMarketing popupMarketing = (PopupMarketing) marketing;
        try {
            popupMarketing.setIsDisturbOn(1 == jSONObject.optInt("disturb", 0));
            if (popupMarketing.isTestMsg()) {
                popupMarketing.setIsDisturbOn(true);
            }
            JSONObject style = popupMarketing.getStyle();
            popupMarketing.setTemplateType(style.getInt("pop"));
            popupMarketing.setIsBottomVisible(1 == style.optInt("bottom", 1));
            popupMarketing.setIsCloseButtonVisible(1 == style.optInt("close", 1));
            popupMarketing.setButtonAlign(style.optInt(MarketingConstants.PopupConst.STYLE_BUTTON_ALIGN, 1));
            JSONObject jSONObjectOptJSONObject = style.optJSONObject("color");
            if (jSONObjectOptJSONObject == null) {
                popupMarketing.setBackgroudColor(MarketingConstants.PopupConst.DEFAULT_COLOR_BACKGROUND);
                popupMarketing.setBottomColor(MarketingConstants.PopupConst.DEFAULT_COLOR_BOTTOM);
                popupMarketing.setTextColor(-570425344);
                popupMarketing.setButtonTextColor(-570425344);
                popupMarketing.setLineColor(MarketingConstants.PopupConst.DEFAULT_COLOR_LINE);
                return;
            }
            popupMarketing.setBackgroudColor(parseColor(jSONObjectOptJSONObject.optString(MarketingConstants.PopupConst.COLOR_BACKGROUND), MarketingConstants.PopupConst.DEFAULT_COLOR_BACKGROUND));
            popupMarketing.setBottomColor(parseColor(jSONObjectOptJSONObject.optString("bottom"), MarketingConstants.PopupConst.DEFAULT_COLOR_BOTTOM));
            popupMarketing.setTextColor(parseColor(jSONObjectOptJSONObject.optString("text"), -570425344));
            popupMarketing.setButtonTextColor(parseColor(jSONObjectOptJSONObject.optString(MarketingConstants.PopupConst.COLOR_BUTTON_TEXT), -570425344));
            popupMarketing.setLineColor(parseColor(jSONObjectOptJSONObject.optString("line"), MarketingConstants.PopupConst.DEFAULT_COLOR_LINE));
        } catch (Exception e) {
            SmpLog.m6502w(MarketingParser.TAG, marketing.getMid(), "invalid userdata. " + e.toString());
            throw new InternalException.WrongMarketingDataException();
        }
    }
}
