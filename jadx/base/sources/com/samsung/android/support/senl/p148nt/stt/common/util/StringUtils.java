package com.samsung.android.support.senl.p148nt.stt.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.stt.C11493R;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ)\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/common/util/StringUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "SPACE", "LINE_BREAK", "", "PERCENTAGE", "EMPTY", "formatNumber", TextConst.KEY_PARAM_NUMBER, "", "getTranscriptProgressText", "context", "Landroid/content/Context;", "progress", "convertingLanguage", "(Landroid/content/Context;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StringUtils {

    @NotNull
    public static final String EMPTY = "";

    @NotNull
    public static final StringUtils INSTANCE = new StringUtils();
    private static final char LINE_BREAK = '\n';

    @NotNull
    private static final String PERCENTAGE = "%";

    @NotNull
    private static final String SPACE = " ";

    @NotNull
    private static final String TAG = "AI$StringUtils";

    private StringUtils() {
    }

    @NotNull
    public final String formatNumber(int number) {
        String language = Locale.getDefault().getLanguage();
        if (!Intrinsics.areEqual("ar", language) && !Intrinsics.areEqual(MarketingConstants.NotificationConst.FLIPPING_ANIMATION, language)) {
            return String.valueOf(number);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        return AbstractC11014a.m12323h(new Object[]{Integer.valueOf(number)}, 1, Locale.getDefault(), TimeModel.NUMBER_FORMAT, "format(...)");
    }

    @NotNull
    public final String getTranscriptProgressText(@Nullable Context context, @Nullable Integer progress, @Nullable String convertingLanguage) {
        if (context == null) {
            return "";
        }
        String string = TextUtils.isEmpty(convertingLanguage) ? context.getResources().getString(C11493R.string.ai_stt_fast_convert_ing) : context.getResources().getString(C11493R.string.ai_stt_transcribe_into_language_button_text, convertingLanguage);
        Intrinsics.checkNotNull(string);
        if (progress != null) {
            try {
                if (progress.intValue() != -1) {
                    return string + " " + formatNumber(progress.intValue()) + PERCENTAGE;
                }
            } catch (Exception e) {
                AbstractC12991c.m14005z("Exception getting progress from map : ", e.getMessage(), TAG);
            }
        }
        return string;
    }
}
