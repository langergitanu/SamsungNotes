package com.samsung.android.support.senl.p148nt.base.winset.app.dialog;

import android.widget.EditText;
import com.samsung.android.sdk.pen.text.inputmethod.SpenInputEmojiUtil;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.visual.p167ai.sdkcommon.image.ImageEditorConst;
import java.text.BreakIterator;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\f\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0010\u0010\u0017\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0014H\u0007J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/dialog/HashTagHelper;", "", "<init>", "()V", "basicPattern", "Ljava/util/regex/Pattern;", "getBasicPattern", "()Ljava/util/regex/Pattern;", "removeExceptLetterOrDigit", "", "filter", "getGraphemeLength", "", "source", "initEditTextInputOption", "", ImageEditorConst.KEY_PARAM_INPUT_TEXT, "Landroid/widget/EditText;", "removeInvalidCharacterForTag", "", "", "start", "end", "isInvalidCharacterForTag", "isSpecialCharacter", "character", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class HashTagHelper {

    @NotNull
    public static final HashTagHelper INSTANCE = new HashTagHelper();

    private HashTagHelper() {
    }

    private final Pattern getBasicPattern() {
        Pattern patternCompile = Pattern.compile("[\\*/\\\\\\?:<>\\|\\n\"]+");
        Intrinsics.checkNotNullExpressionValue(patternCompile, "compile(...)");
        return patternCompile;
    }

    private final int getGraphemeLength(String source) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance();
        characterInstance.setText(source);
        int i = 0;
        while (characterInstance.next() != -1) {
            i++;
        }
        return i;
    }

    @JvmStatic
    public static final void initEditTextInputOption(@NotNull EditText inputText) {
        Intrinsics.checkNotNullParameter(inputText, "inputText");
        ViewCompat.INSTANCE.getInstance().setSemSetActionModeAutoFillEnabled(inputText, false);
        inputText.setImeOptions(268435462);
        inputText.setPrivateImeOptions("disableSticker=true;disableGifKeyboard=true;disableLiveMessage=true;disableEmoticonInput=true");
        inputText.setInputType(540673);
    }

    @JvmStatic
    public static final boolean isInvalidCharacterForTag(@NotNull CharSequence source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (INSTANCE.getGraphemeLength(source.toString()) != 1 || Character.isIdentifierIgnorable(source.charAt(0))) {
            return false;
        }
        return isSpecialCharacter(source.charAt(0));
    }

    @JvmStatic
    public static final boolean isSpecialCharacter(char character) {
        return 23 == Character.getType(character) || !Character.isUnicodeIdentifierPart(character);
    }

    @JvmStatic
    @NotNull
    public static final String removeExceptLetterOrDigit(@NotNull String filter) {
        Intrinsics.checkNotNullParameter(filter, "filter");
        return new Regex("[\\W_]").replace(filter, "");
    }

    @JvmStatic
    public static final boolean removeInvalidCharacterForTag(@NotNull CharSequence source, int start, int end) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (INSTANCE.getBasicPattern().matcher(source).find() || SpenInputEmojiUtil.hasEmojiString(source)) {
            return true;
        }
        while (start < end) {
            if (Character.getType(source.charAt(start)) == 19) {
                return true;
            }
            start++;
        }
        return false;
    }
}
