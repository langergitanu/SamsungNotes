package com.samsung.android.support.senl.p148nt.base.common.cms;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/cms/ExternalLinkUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "linkPersonalInfoPolicy", "", "context", "Landroid/content/Context;", "linkPrivacyNotice", "linkTermsAndCondition", "getLinkTypefaceSpan", "Landroid/text/style/MetricAffectingSpan;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ExternalLinkUtil {

    @NotNull
    public static final ExternalLinkUtil INSTANCE = new ExternalLinkUtil();

    @NotNull
    private static final String TAG = "ExternalLinkUtil";

    private ExternalLinkUtil() {
    }

    @JvmStatic
    @NotNull
    public static final MetricAffectingSpan getLinkTypefaceSpan() {
        int i = Build.VERSION.SDK_INT;
        if (i < 34) {
            return i >= 28 ? AbstractC7150s.m5510n(Typeface.create("sec-roboto-light", 1)) : new StyleSpan(1);
        }
        Typeface typefaceCreate = Typeface.create(Typeface.create("sec", 0), 600, false);
        Intrinsics.checkNotNullExpressionValue(typefaceCreate, "create(...)");
        return AbstractC7150s.m5510n(typefaceCreate);
    }

    @JvmStatic
    public static final void linkPrivacyNotice(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(new SamsungAccountConsentHelper().getConsentUrl(SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel() ? 3 : 1)));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            Logger.m8703w(TAG, "linkPrivacyNotice, intent do not have component");
            ToastHandler.show(context, C8875R.string.settings_privacy_notice_no_browser, 1);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).semOverridePendingTransition(C8875R.anim.samsung_activity_open_enter, C8875R.anim.samsung_activity_open_exit);
        }
    }

    @JvmStatic
    public static final void linkTermsAndCondition(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(new SamsungAccountConsentHelper().getConsentUrl(2)));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            Logger.m8703w(TAG, "linkPersonalInfoNotice, intent do not have component");
            ToastHandler.show(context, C8875R.string.settings_privacy_notice_no_browser, 1);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).semOverridePendingTransition(C8875R.anim.samsung_activity_open_enter, C8875R.anim.samsung_activity_open_exit);
        }
    }

    public final void linkPersonalInfoPolicy(@Nullable Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(new SamsungAccountConsentHelper().getConsentUrl(SystemPropertiesCompat.INSTANCE.getInstance().isKoreaModel() ? 3 : 1)));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            Logger.m8703w(TAG, "linkPersonalInfoPolicy, intent do not have component");
            ToastHandler.show(context, C8875R.string.settings_privacy_notice_no_browser, 1);
            return;
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).semOverridePendingTransition(C8875R.anim.samsung_activity_open_enter, C8875R.anim.samsung_activity_open_exit);
        }
    }
}
