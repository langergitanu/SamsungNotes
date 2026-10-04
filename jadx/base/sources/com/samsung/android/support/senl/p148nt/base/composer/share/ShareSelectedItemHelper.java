package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fJ0\u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/share/ShareSelectedItemHelper;", "", "tag", "", "<init>", "(Ljava/lang/String;)V", "makeBaseIntent", "Landroid/content/Intent;", "plainText", "subject", "type", "isOutOfTextBounds", "", "createIntentForEmail", "contentUris", "Ljava/util/ArrayList;", "Landroid/net/Uri;", "clip", "Landroid/content/ClipData;", "htmlStringArg", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ShareSelectedItemHelper {

    @NotNull
    private final String tag;

    public ShareSelectedItemHelper(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
    }

    @NotNull
    public final Intent createIntentForEmail(@Nullable ArrayList<Uri> contentUris, @Nullable ClipData clip, @NotNull String htmlStringArg, @NotNull String subject) {
        Intrinsics.checkNotNullParameter(htmlStringArg, "htmlStringArg");
        Intrinsics.checkNotNullParameter(subject, "subject");
        if (StringsKt.m14145S(htmlStringArg, "<p")) {
            String strSubstring = htmlStringArg.substring(StringsKt.m14128B(htmlStringArg, '>', 2, 4) + 1, htmlStringArg.length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            htmlStringArg = strSubstring.substring(0, StringsKt.m14130D(strSubstring, Typography.less));
            Intrinsics.checkNotNullExpressionValue(htmlStringArg, "substring(...)");
        }
        if (!TextUtils.isEmpty(htmlStringArg)) {
            htmlStringArg = StringsKt.m14139M(htmlStringArg, "<img src=", "<img style=\"max-width: 100%;\" src=");
        }
        Intent baseIntentWithActionSend = ShareIntentCreationHelper.getBaseIntentWithActionSend();
        baseIntentWithActionSend.setType(Constants.MIME_HTML);
        baseIntentWithActionSend.setComponent(ShareComponents.getEmailComponent());
        if (TextUtils.isEmpty(htmlStringArg)) {
            htmlStringArg = "";
        }
        baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", htmlStringArg);
        if (!TextUtils.isEmpty(subject)) {
            baseIntentWithActionSend.putExtra("android.intent.extra.SUBJECT", subject);
        }
        baseIntentWithActionSend.addFlags(1);
        baseIntentWithActionSend.setClipData(clip);
        if (contentUris != null) {
            if (contentUris.size() > 1) {
                baseIntentWithActionSend.setAction("android.intent.action.SEND_MULTIPLE");
                baseIntentWithActionSend.putParcelableArrayListExtra("android.intent.extra.STREAM", contentUris);
            } else if (contentUris.size() == 1) {
                baseIntentWithActionSend.putExtra("android.intent.extra.STREAM", contentUris.get(0));
            }
        }
        Intrinsics.checkNotNull(baseIntentWithActionSend);
        return baseIntentWithActionSend;
    }

    @NotNull
    public final Intent makeBaseIntent(@NotNull String plainText, @NotNull String subject, @NotNull String type, boolean isOutOfTextBounds) {
        Intrinsics.checkNotNullParameter(plainText, "plainText");
        Intrinsics.checkNotNullParameter(subject, "subject");
        Intrinsics.checkNotNullParameter(type, "type");
        Intent baseIntentWithActionSend = ShareIntentCreationHelper.getBaseIntentWithActionSend();
        if (!TextUtils.isEmpty(subject)) {
            baseIntentWithActionSend.putExtra("android.intent.extra.SUBJECT", subject);
        }
        baseIntentWithActionSend.setType(type);
        if (Intrinsics.areEqual("*/*", type)) {
            baseIntentWithActionSend.putExtra("android.intent.extra.MIME_TYPES", new String[]{Constants.MIME_IMAGE, "audio/mp4"});
        } else if (Intrinsics.areEqual(Constants.MIME_IMAGE, type)) {
            baseIntentWithActionSend.putExtra(Constants.OCF_RESOURCE_TYPE, Constants.OCF_TYPE_MEMO);
        }
        AbstractC4539a.m3188B("shareParagraph, type: ", baseIntentWithActionSend.getType(), this.tag);
        if (!isOutOfTextBounds) {
            baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", TextUtils.isEmpty(plainText) ? "" : plainText);
        }
        if (Intrinsics.areEqual("text/plain", type) && !TextUtils.isEmpty(subject) && TextUtils.isEmpty(plainText)) {
            baseIntentWithActionSend.removeExtra("android.intent.extra.SUBJECT");
            baseIntentWithActionSend.putExtra("android.intent.extra.TEXT", subject);
        }
        Intrinsics.checkNotNull(baseIntentWithActionSend);
        return baseIntentWithActionSend;
    }
}
