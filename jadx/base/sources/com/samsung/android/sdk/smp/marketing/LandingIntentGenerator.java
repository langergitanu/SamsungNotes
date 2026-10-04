package com.samsung.android.sdk.smp.marketing;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.sdk.smp.common.constants.Constants;
import com.samsung.android.sdk.smp.common.constants.FeedbackEvent;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.sdk.smp.common.database.DBHandler;
import com.samsung.android.sdk.smp.common.exception.InternalException;
import com.samsung.android.sdk.smp.common.preference.PrefManager;
import com.samsung.android.sdk.smp.common.util.DeviceInfoUtil;
import com.samsung.android.sdk.smp.common.util.SecurityUtil;
import com.samsung.android.sdk.smp.common.util.SmpLog;
import com.samsung.android.sdk.smp.settingshelper.SystemAppProviderConnector;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@TargetApi(31)
public class LandingIntentGenerator {
    private static final String CONTENT = "content://";
    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    private static final String SMP_CONTENT = "smpcontent://";
    private static final String TAG = "LandingIntentGenerator";
    private final ILandingIntentGenerator mLandingIntentGeneratorImpl;

    /* JADX INFO: renamed from: com.samsung.android.sdk.smp.marketing.LandingIntentGenerator$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C78281 {

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$smp$marketing$LandingIntentGenerator$RunType */
        static final /* synthetic */ int[] f5252xcb4dbad9;

        /* JADX INFO: renamed from: $SwitchMap$com$samsung$android$sdk$smp$marketing$NotificationButtonNumber */
        static final /* synthetic */ int[] f5253x2401f25e;

        static {
            int[] iArr = new int[NotificationButtonNumber.values().length];
            f5253x2401f25e = iArr;
            try {
                iArr[NotificationButtonNumber.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5253x2401f25e[NotificationButtonNumber.SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5253x2401f25e[NotificationButtonNumber.THIRD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[RunType.values().length];
            f5252xcb4dbad9 = iArr2;
            try {
                iArr2[RunType.RUN_VIA_NOTIFICATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5252xcb4dbad9[RunType.RUN_DIRECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ILandingIntentGenerator {
        Intent getLandingIntentForRedirectionUrl(Context context, String str, NotificationButtonNumber notificationButtonNumber, MarketingLink marketingLink, Intent intent, boolean z);

        void putSmpClickFeedbackPathToExtra(Context context, String str, Intent intent, String str2, boolean z);

        void setFlags(Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class RunDirect implements ILandingIntentGenerator {
        private RunDirect() {
        }

        @Override // com.samsung.android.sdk.smp.marketing.LandingIntentGenerator.ILandingIntentGenerator
        public Intent getLandingIntentForRedirectionUrl(Context context, String str, NotificationButtonNumber notificationButtonNumber, MarketingLink marketingLink, Intent intent, boolean z) {
            return null;
        }

        @Override // com.samsung.android.sdk.smp.marketing.LandingIntentGenerator.ILandingIntentGenerator
        public void putSmpClickFeedbackPathToExtra(Context context, String str, Intent intent, String str2, boolean z) {
        }

        @Override // com.samsung.android.sdk.smp.marketing.LandingIntentGenerator.ILandingIntentGenerator
        public void setFlags(Intent intent) {
            intent.setFlags(268435456);
        }

        public /* synthetic */ RunDirect(C78281 c78281) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum RunType {
        RUN_VIA_NOTIFICATION,
        RUN_DIRECT
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunViaNotification implements ILandingIntentGenerator {
        private static final int MIN_SMP_SDK_VERSION_CLICK_EVENT_FOR_S = 3020200;
        private static final String PARAM_REDIRECT_FEEDBACK_ID = "fbid";
        private static final String PARAM_REDIRECT_MCC = "mcc";
        private static final String PARAM_REDIRECT_WEB_ID = "webid";
        private static final String QUERY_PARAM_URL = "url";

        private RunViaNotification() {
        }

        private Uri appendMccToRedirectionUri(Context context, Uri uri) {
            String simMcc = DeviceInfoUtil.getSimMcc(context);
            return !TextUtils.isEmpty(simMcc) ? uri.buildUpon().appendQueryParameter("mcc", simMcc).build() : uri;
        }

        private Uri appendReferrerToRedirectionUri(String str, Uri uri, MarketingLink marketingLink) throws InternalException.WrongMarketingDataException {
            String queryParameter = uri.getQueryParameter("url");
            if (TextUtils.isEmpty(queryParameter)) {
                SmpLog.m6495e(LandingIntentGenerator.TAG, str, "invalid redirection url. no url query parameter in redirection url");
                throw new InternalException.WrongMarketingDataException();
            }
            String string = LandingIntentGenerator.this.appendReferrerToUrl(queryParameter, marketingLink).toString();
            return queryParameter.equals(string) ? uri : replaceUriQueryParameter(uri, "url", string);
        }

        private Uri appendSmpPKToRedirectionUri(Context context, String str, Uri uri, boolean z) throws InternalException.WrongMarketingDataException {
            if (!z) {
                return uri;
            }
            String queryParameter = uri.getQueryParameter("url");
            if (!TextUtils.isEmpty(queryParameter)) {
                return replaceUriQueryParameter(uri, "url", LandingIntentGenerator.this.appendSmpPKToUrl(context, str, Uri.parse(queryParameter), z).toString());
            }
            SmpLog.m6495e(LandingIntentGenerator.TAG, str, "invalid redirection url. no url query parameter in redirection url");
            throw new InternalException.WrongMarketingDataException();
        }

        private Uri appendWebIdToRedirectionUri(Uri uri, String str) {
            return uri.buildUpon().appendQueryParameter("webid", str).build();
        }

        private Uri getRedirectionUri(Context context, MarketingLink marketingLink, NotificationButtonNumber notificationButtonNumber, Intent intent, String str, String str2, boolean z) {
            if (LandingIntentGenerator.this.isSmpProviderUri(marketingLink.getUrl())) {
                return appendWebIdToRedirectionUri(replaceUriQueryParameter(Uri.parse(marketingLink.getRedirectionUrl()), "url", intent.getDataString()), str2);
            }
            return LandingIntentGenerator.this.appendFbIdToRedirectionUri(notificationButtonNumber, appendMccToRedirectionUri(context, appendSmpPKToRedirectionUri(context, str, appendReferrerToRedirectionUri(str, appendWebIdToRedirectionUri(Uri.parse(marketingLink.getRedirectionUrl()), str2), marketingLink), z)));
        }

        private boolean isIntentLaunchableWithBrowsable(Context context, Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.addCategory("android.intent.category.BROWSABLE");
            return LandingIntentGenerator.this.isIntentLaunchable(context, intent2);
        }

        private Uri replaceUriQueryParameter(Uri uri, String str, String str2) {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            for (String str3 : queryParameterNames) {
                builderClearQuery.appendQueryParameter(str3, str3.equals(str) ? str2 : uri.getQueryParameter(str3));
            }
            return builderClearQuery.build();
        }

        @Override // com.samsung.android.sdk.smp.marketing.LandingIntentGenerator.ILandingIntentGenerator
        public Intent getLandingIntentForRedirectionUrl(Context context, String str, NotificationButtonNumber notificationButtonNumber, MarketingLink marketingLink, Intent intent, boolean z) {
            if (TextUtils.isEmpty(marketingLink.getRedirectionUrl())) {
                return null;
            }
            String webId = PrefManager.getInstance(context).getWebId();
            if (TextUtils.isEmpty(webId)) {
                SmpLog.m6502w(LandingIntentGenerator.TAG, str, "fail to get redirection intent. webid is null");
                return null;
            }
            if (LandingIntentGenerator.this.isCustomDeeplink(marketingLink.getUrl()) && !isIntentLaunchableWithBrowsable(context, intent)) {
                SmpLog.m6502w(LandingIntentGenerator.TAG, str, "fail to get redirection intent. not launchable when adding browsable category");
                return null;
            }
            Uri redirectionUri = getRedirectionUri(context, marketingLink, notificationButtonNumber, intent, str, webId, z);
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(redirectionUri);
            setFlags(intent2);
            SmpLog.m6498i(LandingIntentGenerator.TAG, "redirect : " + redirectionUri.toString());
            DBHandler dBHandlerOpen = DBHandler.open(context);
            if (dBHandlerOpen != null) {
                dBHandlerOpen.updateMarketingLandingRedirected(str, Boolean.TRUE);
                dBHandlerOpen.close();
            }
            return intent2;
        }

        @Override // com.samsung.android.sdk.smp.marketing.LandingIntentGenerator.ILandingIntentGenerator
        public void putSmpClickFeedbackPathToExtra(Context context, String str, Intent intent, String str2, boolean z) {
            if (z) {
                return;
            }
            PrefManager prefManager = PrefManager.getInstance(context);
            String aid = prefManager.getAID();
            if (TextUtils.isEmpty(aid)) {
                SmpLog.m6494e(LandingIntentGenerator.TAG, "fail to put click feedback path. aid is null");
                return;
            }
            Uri.Builder builderBuildUpon = Uri.parse("").buildUpon();
            builderBuildUpon.appendPath(NetworkConfig.API_VERSION);
            builderBuildUpon.appendPath("feedback");
            builderBuildUpon.appendQueryParameter(NetworkConfig.FEEDBACK_AID, aid);
            builderBuildUpon.appendQueryParameter("mid", str);
            int smpSdkVersionInt = DeviceInfoUtil.getSmpSdkVersionInt(context, intent.getPackage());
            SmpLog.m6498i(LandingIntentGenerator.TAG, "sdk version of " + intent.getPackage() + " : " + smpSdkVersionInt);
            if (smpSdkVersionInt < MIN_SMP_SDK_VERSION_CLICK_EVENT_FOR_S) {
                String webId = prefManager.getWebId();
                if (TextUtils.isEmpty(webId)) {
                    SmpLog.m6494e(LandingIntentGenerator.TAG, "fail to put click feedback path. webid is null");
                    return;
                }
                builderBuildUpon.appendQueryParameter("webid", webId);
            } else {
                String smpID = prefManager.getSmpID();
                if (TextUtils.isEmpty(smpID)) {
                    SmpLog.m6494e(LandingIntentGenerator.TAG, "fail to put click feedback path. smpid is null");
                    return;
                }
                builderBuildUpon.appendQueryParameter("smpid", smpID);
            }
            String string = builderBuildUpon.toString();
            SmpLog.m6498i(LandingIntentGenerator.TAG, "put click feedback path extra : " + string);
            intent.putExtra(Constants.EXTRA_SMP_FEEDBACK_PATH, string);
            intent.putExtra(Constants.EXTRA_SMP_SENDER_PACKAGE, context.getPackageName());
            intent.putExtra(Constants.EXTRA_SMP_MID, str);
            intent.putExtra(Constants.EXTRA_SMP_LINK_TYPE, str2);
        }

        @Override // com.samsung.android.sdk.smp.marketing.LandingIntentGenerator.ILandingIntentGenerator
        public void setFlags(Intent intent) {
            intent.setFlags(335544320);
        }

        public /* synthetic */ RunViaNotification(LandingIntentGenerator landingIntentGenerator, C78281 c78281) {
            this();
        }
    }

    public LandingIntentGenerator(RunType runType) throws InternalException.InvalidArgumentException {
        int i = C78281.f5252xcb4dbad9[runType.ordinal()];
        C78281 c78281 = null;
        if (i == 1) {
            this.mLandingIntentGeneratorImpl = new RunViaNotification(this, c78281);
            return;
        }
        if (i == 2) {
            this.mLandingIntentGeneratorImpl = new RunDirect(c78281);
            return;
        }
        SmpLog.m6494e(TAG, "invalid runtype : " + runType);
        throw new InternalException.InvalidArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri appendFbIdToRedirectionUri(NotificationButtonNumber notificationButtonNumber, Uri uri) {
        FeedbackEvent feedbackEvent = FeedbackEvent.CLICKED;
        int i = C78281.f5253x2401f25e[notificationButtonNumber.ordinal()];
        if (i == 1) {
            feedbackEvent = FeedbackEvent.CLICKED_BUTTON_1;
        } else if (i == 2) {
            feedbackEvent = FeedbackEvent.CLICKED_BUTTON_2;
        } else if (i == 3) {
            feedbackEvent = FeedbackEvent.CLICKED_BUTTON_3;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter(NetworkConfig.CLIENTS_FEEDBACK_FBID, String.valueOf(feedbackEvent.value()));
        return builderBuildUpon.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Uri appendSmpPKToUrl(Context context, String str, Uri uri, boolean z) {
        String smpPK = z ? getSmpPK(context, str) : null;
        if (TextUtils.isEmpty(smpPK)) {
            return uri;
        }
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.appendQueryParameter(SmpConstants.SMP_PK, smpPK);
        return builderBuildUpon.build();
    }

    private Intent getLandingIntentForApp(Context context, String str, MarketingLink marketingLink, boolean z, boolean z2) {
        if (TextUtils.isEmpty(marketingLink.getPackageName())) {
            SmpLog.m6502w(TAG, str, "fail to get landing intent(type:app). pkg null");
            return null;
        }
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(marketingLink.getPackageName());
        if (launchIntentForPackage == null) {
            SmpLog.m6502w(TAG, str, "fail to get landing intent(type:app) : " + marketingLink.getPackageName());
            return null;
        }
        this.mLandingIntentGeneratorImpl.setFlags(launchIntentForPackage);
        this.mLandingIntentGeneratorImpl.putSmpClickFeedbackPathToExtra(context, str, launchIntentForPackage, marketingLink.getType(), z);
        putReferrerToExtra(launchIntentForPackage, marketingLink);
        putSmpPKToExtra(context, str, launchIntentForPackage, z2);
        SmpLog.m6499i(TAG, str, "landing intent : app");
        return launchIntentForPackage;
    }

    private Intent getLandingIntentForIntent(Context context, String str, MarketingLink marketingLink, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(marketingLink.getPackageName())) {
            SmpLog.m6502w(TAG, str, "fail to get landing intent(type:intent). pkg null");
            return null;
        }
        if (marketingLink.getComponent() != 1) {
            SmpLog.m6502w(TAG, str, "fail to get landing intent(type:intent). invalid component");
            return null;
        }
        Intent intent = new Intent();
        intent.setPackage(marketingLink.getPackageName());
        if (!TextUtils.isEmpty(marketingLink.getData())) {
            intent.setData(Uri.parse(marketingLink.getData()));
            intent.setAction("android.intent.action.VIEW");
        }
        if (!TextUtils.isEmpty(marketingLink.getAction())) {
            intent.setAction(marketingLink.getAction());
        }
        if (!TextUtils.isEmpty(marketingLink.getClassName())) {
            intent.setComponent(new ComponentName(marketingLink.getPackageName(), marketingLink.getClassName()));
        }
        if (marketingLink.getExtra() != null && !marketingLink.getExtra().isEmpty()) {
            intent.putExtras(marketingLink.getExtra());
        }
        this.mLandingIntentGeneratorImpl.setFlags(intent);
        if (!z || isIntentLaunchable(context, intent)) {
            SmpLog.m6499i(TAG, str, "landing intent : intent");
            this.mLandingIntentGeneratorImpl.putSmpClickFeedbackPathToExtra(context, str, intent, marketingLink.getType(), z2);
            putReferrerToExtra(intent, marketingLink);
            putSmpPKToExtra(context, str, intent, z3);
            return intent;
        }
        SmpLog.m6502w(TAG, str, "fail to get landing intent(type:intent). " + marketingLink.getPackageName() + " is not launchable");
        return null;
    }

    private Intent getLandingIntentForUrl(Context context, String str, NotificationButtonNumber notificationButtonNumber, MarketingLink marketingLink, boolean z, boolean z2, boolean z3) {
        if (TextUtils.isEmpty(marketingLink.getUrl())) {
            SmpLog.m6502w(TAG, str, "fail to get landing intent(type:url). url null");
            return null;
        }
        Intent landingIntentForOriginalUrl = getLandingIntentForOriginalUrl(context, str, marketingLink, z, z2, z3);
        if (landingIntentForOriginalUrl == null) {
            SmpLog.m6501w(TAG, "fail to get landing intent(type:url). it is not able to launch");
            return null;
        }
        Intent landingIntentForRedirectionUrl = this.mLandingIntentGeneratorImpl.getLandingIntentForRedirectionUrl(context, str, notificationButtonNumber, marketingLink, landingIntentForOriginalUrl, z3);
        if (landingIntentForRedirectionUrl == null) {
            SmpLog.m6499i(TAG, str, "landing intent : url (original)");
        } else {
            SmpLog.m6499i(TAG, str, "landing intent : url (redirect)");
            landingIntentForOriginalUrl = landingIntentForRedirectionUrl;
        }
        SmpLog.m6493d(TAG, str, "landing uri : " + landingIntentForOriginalUrl.getDataString());
        return landingIntentForOriginalUrl;
    }

    private String getSmpPK(Context context, String str) {
        String strMakeSHA256Hash;
        String smpID = PrefManager.getInstance(context).getSmpID();
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(smpID)) {
            strMakeSHA256Hash = null;
        } else {
            strMakeSHA256Hash = SecurityUtil.makeSHA256Hash(smpID + str);
        }
        SmpLog.m6498i(TAG, "smpPK:" + strMakeSHA256Hash);
        return strMakeSHA256Hash;
    }

    private void putReferrerToExtra(Intent intent, MarketingLink marketingLink) {
        String referrerStrForLandingPage = marketingLink.getReferrerStrForLandingPage();
        if (TextUtils.isEmpty(referrerStrForLandingPage)) {
            return;
        }
        SmpLog.m6498i(TAG, "append referrer to extra");
        intent.putExtra(SmpConstants.REFERRER_KEY, referrerStrForLandingPage);
    }

    private void putSmpPKToExtra(Context context, String str, Intent intent, boolean z) {
        String smpPK = z ? getSmpPK(context, str) : null;
        if (TextUtils.isEmpty(smpPK)) {
            return;
        }
        SmpLog.m6498i(TAG, "put smpPK to extra");
        intent.putExtra(SmpConstants.SMP_PK, smpPK);
    }

    public Uri appendReferrerToUrl(String str, MarketingLink marketingLink) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        String referrerStrForLandingPage = marketingLink.getReferrerStrForLandingPage();
        if (!TextUtils.isEmpty(referrerStrForLandingPage)) {
            SmpLog.m6498i(TAG, "append referrer to url");
            builderBuildUpon.appendQueryParameter(SmpConstants.REFERRER_KEY, referrerStrForLandingPage);
        }
        return builderBuildUpon.build();
    }

    public Intent getLandingIntentByLinkType(Context context, String str, NotificationButtonNumber notificationButtonNumber, MarketingLink marketingLink, boolean z, boolean z2, boolean z3) {
        if (marketingLink == null) {
            SmpLog.m6495e(TAG, str, "fail to get landing intent. link is null");
            return null;
        }
        if ("app".equals(marketingLink.getType())) {
            return getLandingIntentForApp(context, str, marketingLink, z2, z3);
        }
        if ("url".equals(marketingLink.getType())) {
            return getLandingIntentForUrl(context, str, notificationButtonNumber, marketingLink, z, z2, z3);
        }
        if (MarketingConstants.LINK_TYPE_INTENT.equals(marketingLink.getType())) {
            return getLandingIntentForIntent(context, str, marketingLink, z, z2, z3);
        }
        SmpLog.m6495e(TAG, str, "fail to get landing intent. invalid type : " + marketingLink.getType());
        return null;
    }

    public Intent getLandingIntentForOriginalUrl(Context context, String str, MarketingLink marketingLink, boolean z, boolean z2, boolean z3) {
        String url = marketingLink.getUrl();
        Intent intent = new Intent("android.intent.action.VIEW");
        this.mLandingIntentGeneratorImpl.setFlags(intent);
        if (isSmpProviderUri(url)) {
            return getLandingIntentFromSmpProvider(context, url, intent);
        }
        intent.setData(appendSmpPKToUrl(context, str, appendReferrerToUrl(url, marketingLink), z3));
        if (isCustomDeeplink(url)) {
            if (z && !isIntentLaunchable(context, intent)) {
                SmpLog.m6502w(TAG, str, "fail to get landing intent(type:url). " + url + " is not launchable");
                return null;
            }
            this.mLandingIntentGeneratorImpl.putSmpClickFeedbackPathToExtra(context, str, intent, marketingLink.getType(), z2);
        }
        return intent;
    }

    public Intent getLandingIntentFromSmpProvider(Context context, String str, Intent intent) throws Throwable {
        String uriData = SystemAppProviderConnector.getUriData(context, str.replaceFirst(SMP_CONTENT, "content://"));
        if (uriData == null) {
            return null;
        }
        intent.setData(Uri.parse(uriData));
        return intent;
    }

    public boolean isCustomDeeplink(String str) {
        String lowerCase = str.toLowerCase();
        return (lowerCase.startsWith("http://") || lowerCase.startsWith("https://") || lowerCase.startsWith("content://")) ? false : true;
    }

    public boolean isIntentLaunchable(Context context, Intent intent) {
        return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public boolean isSmpProviderUri(String str) {
        return str.startsWith(SMP_CONTENT);
    }
}
