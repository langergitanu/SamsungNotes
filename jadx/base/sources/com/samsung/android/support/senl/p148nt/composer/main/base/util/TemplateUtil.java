package com.samsung.android.support.senl.p148nt.composer.main.base.util;

import android.content.Intent;
import androidx.core.util.Pair;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\"\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/util/TemplateUtil;", "", "<init>", "()V", "getPageTypeAndPathFromIntentForComposer", "Landroidx/core/util/Pair;", "", "", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "getPageTypeAndPathFromIntent", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class TemplateUtil {

    @NotNull
    public static final TemplateUtil INSTANCE = new TemplateUtil();

    private TemplateUtil() {
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ae  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Pair<Integer, String> getPageTypeAndPathFromIntent(@Nullable Intent intent) {
        int iMax = 17;
        String stringExtra = null;
        if (intent != null && intent.hasExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT)) {
            Intent intent2 = (Intent) intent.getParcelableExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT);
            if (intent2 == null) {
                Pair<Integer, String> defaultTemplate = new DocumentStyleRepository().getDefaultTemplate();
                Intrinsics.checkNotNullExpressionValue(defaultTemplate, "getDefaultTemplate(...)");
                return defaultTemplate;
            }
            int intExtra = intent2.getIntExtra("template_type", 10);
            if (TemplateViewType.isDefaultImageType(intExtra)) {
                iMax = (int) Math.max(intent2.getIntExtra(ChangeTemplateConstants.ARG_TEMPLATE_DEFAULT_IMAGE_RESULT, 0), 0.0d);
            } else if (TemplateViewType.isCustomImageType(intExtra)) {
                stringExtra = intent2.getStringExtra(ChangeTemplateConstants.ARG_TEMPLATE_IMAGE_RESULT);
                iMax = 12;
            } else if (TemplateViewType.isPdfType(intExtra)) {
                stringExtra = intent2.getStringExtra(ChangeTemplateConstants.ARG_TEMPLATE_PDF_RESULT);
                iMax = 16;
            } else if (TemplateViewType.isDynamicType(intExtra)) {
                stringExtra = "";
            } else {
                iMax = 0;
            }
            return new Pair<>(Integer.valueOf(iMax), stringExtra);
        }
        if (intent == null || !intent.hasExtra(SettingsConstants.SETTINGS_PAGE_SIZE)) {
            Pair<Integer, String> defaultTemplate2 = new DocumentStyleRepository().getDefaultTemplate();
            Intrinsics.checkNotNullExpressionValue(defaultTemplate2, "getDefaultTemplate(...)");
            return defaultTemplate2;
        }
        int intExtra2 = intent.getIntExtra(SettingsConstants.SETTINGS_TEMPLATE_TYPE, 10);
        String stringExtra2 = intent.getStringExtra(SettingsConstants.SETTINGS_PAGE_TEMPLATE);
        if (intExtra2 == 3) {
            stringExtra = stringExtra2;
            iMax = 12;
        } else if (intExtra2 != 5) {
            switch (intExtra2) {
                case 10:
                case 13:
                case 16:
                case 19:
                case 22:
                    int i = stringExtra2 != null ? Integer.parseInt(stringExtra2) : 0;
                    iMax = i >= 0 ? i : 0;
                    break;
                case 11:
                case 14:
                case 17:
                case 20:
                case 23:
                    stringExtra = stringExtra2;
                    iMax = 16;
                    break;
                case 12:
                case 15:
                case 18:
                case 21:
                case 24:
                    stringExtra = stringExtra2;
                    break;
                default:
                    stringExtra = stringExtra2;
                    break;
            }
        }
        return new Pair<>(Integer.valueOf(iMax), stringExtra);
    }

    @JvmStatic
    @NotNull
    public static final Pair<Integer, String> getPageTypeAndPathFromIntentForComposer(@Nullable Intent intent) {
        Intent intent2 = new Intent();
        intent2.putExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT, intent);
        return getPageTypeAndPathFromIntent(intent2);
    }
}
