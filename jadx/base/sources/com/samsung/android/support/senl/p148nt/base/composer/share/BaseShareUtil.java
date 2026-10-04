package com.samsung.android.support.senl.p148nt.base.composer.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputEmojiUtil;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.constants.BaseComposerConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0003J*\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J*\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\b\u0010\u001a\u001a\u00020\u0015H\u0007J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/share/BaseShareUtil;", "", "<init>", "()V", "DEFAULT_PREFIX_TITLE", "", "sEmojiPattern", "Ljava/util/regex/Pattern;", "getDocumentTimeName", "title", "getCleanTitle", "removeUnsupportedChar", "src", "makeImageSpan", "Landroid/text/SpannableString;", "tag", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "isLast", "", "getAudioClipDataContentUri", "baseFileName", "contentBase", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "isNotSupportedFileProviderForChina", "startChooserActivity", "", "chooserIntent", "Landroid/content/Intent;", "anchorType", "", "requestCode", "loggingAction", "Ljava/lang/Runnable;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BaseShareUtil {

    @NotNull
    public static final String DEFAULT_PREFIX_TITLE = "Notes";

    @NotNull
    public static final BaseShareUtil INSTANCE = new BaseShareUtil();

    @NotNull
    private static Pattern sEmojiPattern;

    static {
        Pattern pattern = SpenInputEmojiUtil.getPattern();
        Intrinsics.checkNotNull(pattern);
        sEmojiPattern = pattern;
    }

    private BaseShareUtil() {
    }

    @JvmStatic
    @Nullable
    public static final Uri getAudioClipDataContentUri(@NotNull String tag, @NotNull Context context, @NotNull String baseFileName, @NotNull SpenObjectVoice contentBase) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(baseFileName, "baseFileName");
        Intrinsics.checkNotNullParameter(contentBase, "contentBase");
        String attachedFile = contentBase.getAttachedFile();
        Intrinsics.checkNotNull(attachedFile);
        String clipboardFileName = ClipboardCacheManager.getClipboardFileName(context, baseFileName, FileUtils.getFileNameFromFilePath(attachedFile));
        try {
            Intrinsics.checkNotNull(clipboardFileName);
            BaseUtils.copyFile(attachedFile, clipboardFileName);
            return ClipDataContentProvider.INSTANCE.getUri(clipboardFileName);
        } catch (IOException e) {
            Logger.m8699e(tag, "getAudioClipDataContentUri#", e);
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final String getCleanTitle(@Nullable String title) {
        if (title != null) {
            Matcher matcher = sEmojiPattern.matcher(title);
            Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
            if (matcher.find()) {
                title = matcher.replaceAll("");
            }
            Matcher matcher2 = Pattern.compile(BaseComposerConstants.PATTERN_FILE_NAME_INVALID_CHARS).matcher(title.toString());
            Intrinsics.checkNotNullExpressionValue(matcher2, "matcher(...)");
            if (matcher2.find()) {
                title = matcher2.replaceAll("");
            }
            Intrinsics.checkNotNull(title);
            title = removeUnsupportedChar(title);
        }
        return TextUtils.isEmpty(title) ? "Notes" : title;
    }

    @JvmStatic
    @NotNull
    public static final String getDocumentTimeName(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        String cleanTitle = getCleanTitle(title);
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strSubstring = string.substring(string.length() - 3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return AbstractC2322a.m1622l(cleanTitle, "_", new SimpleDateFormat("yyMMdd_HHmmss", Locale.ENGLISH).format(new Date()), "_", strSubstring);
    }

    @JvmStatic
    public static final boolean isNotSupportedFileProviderForChina() {
        return Build.VERSION.SDK_INT <= 28 && SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel();
    }

    @JvmStatic
    @NotNull
    public static final SpannableString makeImageSpan(@NotNull String tag, @NotNull Context context, @Nullable Uri uri, boolean isLast) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableString spannableString = new SpannableString(isLast ? " " : " \n\n");
        if (uri == null) {
            Logger.m8703w(tag, "makeImageSpan# uri is null");
            return spannableString;
        }
        spannableString.setSpan(new ImageSpan(context, uri), 0, 1, 33);
        return spannableString;
    }

    @JvmStatic
    private static final String removeUnsupportedChar(String src) {
        int length = src.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (Character.getType(src.charAt(i)) != 19) {
                sb.append(src.charAt(i));
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static final void startChooserActivity(@NotNull String tag, @Nullable Context context, @Nullable Intent chooserIntent, int anchorType, int requestCode, @Nullable Runnable loggingAction) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Logger.m8697d(tag, "startChooserActivity");
        try {
            if (context == null || chooserIntent == null) {
                Logger.m8698e(tag, "startChooserActivity failed, context : " + context + ", chooserIntent : " + chooserIntent);
            } else if (context instanceof Activity) {
                if (loggingAction != null) {
                    loggingAction.run();
                }
                PopOverActivityWrapper.startChooserActivityForResult(context, chooserIntent, requestCode, anchorType);
            } else {
                PopOverActivityWrapper.startChooserActivity(context, chooserIntent, anchorType);
            }
        } catch (ActivityNotFoundException e) {
            Logger.m8699e(tag, "startChooserActivity", e);
        }
        UserInputSkipper.releaseHoldingEventTimeByTag(UserInputSkipper.Tag.ShareViaChooser);
    }
}
