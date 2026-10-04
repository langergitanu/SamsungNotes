package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Pair;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.ExtraDataHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.quicknote.LinkCardFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.DownloadObjectHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.WebCardUtil;
import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.contextawareness.ContextAwarenessCreator;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.MessageSuggestionInfo;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.result.SuggestionInfo;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionSendHelperText extends ActionSendHelperCommon {
    private static final String TAG = Logger.createTag("ActionSendHelperText");
    private static final String WEB_RANGE_END_OFFSET = "web_range_end_offset";
    private static final String WEB_RANGE_START_OFFSET = "web_range_start_offset";

    public ActionSendHelperText(String str) {
        super(str);
    }

    private JSONObject createJSONObjectByIntentForWebAppCard(Intent intent, CharSequence charSequence) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        new ExtraDataHelper().createJson(jSONObject, "android.intent.action.VIEW", charSequence.toString(), null);
        ExtraDataHelper.ExtraPutter extraPutter = new ExtraDataHelper.ExtraPutter(0);
        extraPutter.put(jSONObject, new Pair(WEB_RANGE_START_OFFSET, Integer.valueOf(intent.getIntExtra(WEB_RANGE_START_OFFSET, 0))));
        extraPutter.put(jSONObject, new Pair(WEB_RANGE_END_OFFSET, Integer.valueOf(intent.getIntExtra(WEB_RANGE_END_OFFSET, 0))));
        new ExtraDataHelper.ExtraPutter(1).put(jSONObject, new Pair(ComposerConstants.APP_CARD_EXTRA, intent.getStringExtra(ComposerConstants.APP_CARD_EXTRA)));
        return jSONObject;
    }

    private boolean executeDownloadWebCardTask(Context context, Content.WebCard webCard) {
        boolean zBooleanValue;
        try {
            zBooleanValue = new DownloadObjectHelper.DownloadWebCardTask(context, webCard, this.mCachePath, WebCardUtil.isShowWebPreviewsEnabled()).call().booleanValue();
        } catch (Exception e) {
            Logger.m11000e(TAG, e.getMessage());
            zBooleanValue = false;
        }
        if (zBooleanValue) {
            return false;
        }
        Logger.m11000e(TAG, "DownloadWebCardTask fail");
        return true;
    }

    private boolean handleMessageAppCard(Intent intent) {
        if (!ContextAwarenessFeature.MESSAGE_PACKAGE_NAME.equals(intent.getStringExtra(ComposerConstants.ACTION_SEND_ADDITION))) {
            return false;
        }
        String stringExtra = intent.getStringExtra(ComposerConstants.ACTION_SEND_ADDITION_URI);
        if (TextUtils.isEmpty(stringExtra)) {
            Logger.m11000e(TAG, "handleMessageAppCard# uri empty ");
            return false;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("type", "Message");
        intent2.putExtra("url", stringExtra);
        intent2.putExtra("source", ContextAwarenessFeature.MESSAGE_PACKAGE_NAME);
        SuggestionInfo suggestionInfoCreateSuggestionInfo = new ContextAwarenessCreator().createSuggestionInfo(intent2);
        if (!(suggestionInfoCreateSuggestionInfo instanceof MessageSuggestionInfo)) {
            Logger.m11000e(TAG, "handleMessageAppCard# type error ");
            return false;
        }
        try {
            this.mContentList.add(LinkCardFactory.createMessageCard((MessageSuggestionInfo) suggestionInfoCreateSuggestionInfo, this.mCachePath));
            Logger.m11003i(TAG, "add handleMessageAppCard");
            return true;
        } catch (JSONException e) {
            Logger.m11000e(TAG, "handleMessageAppCard# JSONException " + e.getMessage());
            return false;
        }
    }

    private int handleText(Context context, Intent intent) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText(intent));
        ArrayList<WebCardUtil.SubText> subTextForURL = intent.getBooleanExtra(ComposerConstants.ARG_WEB_CLIP, false) ? WebCardUtil.getSubTextForURL(spannableStringBuilder) : WebCardUtil.getSubTextList(spannableStringBuilder);
        if (!handleWebClip(intent, subTextForURL) && !handleWebAppCard(context, intent, subTextForURL)) {
            String subject = getSubject(intent);
            Iterator<WebCardUtil.SubText> it = subTextForURL.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WebCardUtil.SubText next = it.next();
                CharSequence data = next.getData();
                if (!TextUtils.isEmpty(data)) {
                    int type = next.getType();
                    if (type == 1) {
                        this.mContentList.add(new Content.Text(data));
                    } else if (type == 2) {
                        Content.WebCard webCard = new Content.WebCard(this.mContentList.isEmpty() ? subject : "", data.toString());
                        this.mContentList.add(webCard);
                        this.mDownloadObjList.add(webCard);
                        this.mCallableList.add(new DownloadObjectHelper.DownloadWebCardTask(context, webCard, this.mCachePath, WebCardUtil.isShowWebPreviewsEnabled()));
                    }
                }
            }
            if (this.mContentList.isEmpty()) {
                this.mContentList.add(new Content.Text(""));
            }
            if (((Uri) intent.getParcelableExtra("android.intent.extra.STREAM")) != null) {
                return 256;
            }
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        r4 = new com.samsung.android.support.senl.nt.model.base.utils.data.Content.LinkCard("", r3.toString(), r7.getStringExtra(com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants.ACTION_SEND_ADDITION), createJSONObjectByIntentForWebAppCard(r7, r3).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
    
        if (executeDownloadWebCardTask(r6, r4) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004a, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004b, code lost:
    
        r5.mContentList.clear();
        r5.mContentList.add(r4);
        r6 = r7.getStringExtra(com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants.APP_CARD_EXTRA);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005f, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        r6 = com.samsung.android.support.senl.p148nt.composer.main.base.util.IntentParser.removeUnicodeObj(r6);
        r4.setDescription(r6.replace("\n", ""));
        r4.setLinkIconType();
        r5.mContentList.add(new com.samsung.android.support.senl.nt.model.base.utils.data.Content.Text(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean handleWebAppCard(Context context, Intent intent, ArrayList<WebCardUtil.SubText> arrayList) {
        if (!IntentParser.hasWebAppCard(intent)) {
            return false;
        }
        Iterator<WebCardUtil.SubText> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WebCardUtil.SubText next = it.next();
            CharSequence data = next.getData();
            if (!TextUtils.isEmpty(data) && next.getType() == 2) {
                try {
                    break;
                } catch (JSONException e) {
                    Logger.m11000e(TAG, "handleWebAppCard# " + e.getMessage());
                    return false;
                }
            }
        }
    }

    private boolean handleWebClip(Intent intent, ArrayList<WebCardUtil.SubText> arrayList) {
        if (!IntentParser.hasWebClip(intent)) {
            return false;
        }
        for (WebCardUtil.SubText subText : arrayList) {
            CharSequence data = subText.getData();
            if (!TextUtils.isEmpty(data) && subText.getType() == 2) {
                Content.WebClip webClip = new Content.WebClip(data.toString());
                this.mContentList.clear();
                this.mContentList.add(webClip);
                return true;
            }
        }
        return false;
    }

    public String getUrlForWebClip() {
        return ((Content.WebClip) this.mContentList.get(0)).getUrl();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.actionsend.ActionSendHelperCommon
    public int handleIntent(Context context, Intent intent) {
        if (handleMessageAppCard(intent)) {
            return 0;
        }
        return handleText(context, intent);
    }

    public boolean hasWebClip() {
        return this.mContentList.size() == 1 && this.mContentList.get(0).getType() == 5;
    }
}
