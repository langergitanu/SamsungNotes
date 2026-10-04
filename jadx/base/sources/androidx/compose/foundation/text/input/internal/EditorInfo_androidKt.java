package androidx.compose.foundation.text.input.internal;

import android.view.inputmethod.EditorInfo;
import androidx.compose.foundation.text.handwriting.StylusHandwriting_androidKt;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.p109ui.text.input.ImeOptions;
import androidx.compose.p109ui.text.input.KeyboardCapitalization;
import androidx.compose.p109ui.text.input.KeyboardType;
import androidx.compose.p109ui.text.input.PlatformImeOptions;
import androidx.core.view.inputmethod.EditorInfoCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a@\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, m13886d2 = {"hasFlag", "", "bits", "", "flag", Constants.ARG_UPDATE, "", "Landroid/view/inputmethod/EditorInfo;", "text", "", "selection", "Landroidx/compose/ui/text/TextRange;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "contentMimeTypes", "", "", "update-pLxbY9I", "(Landroid/view/inputmethod/EditorInfo;Ljava/lang/CharSequence;JLandroidx/compose/ui/text/input/ImeOptions;[Ljava/lang/String;)V", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class EditorInfo_androidKt {
    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    /* JADX INFO: renamed from: update-pLxbY9I, reason: not valid java name */
    public static final void m16315updatepLxbY9I(@NotNull EditorInfo editorInfo, @NotNull CharSequence charSequence, long j, @NotNull ImeOptions imeOptions, @Nullable String[] strArr) {
        String privateImeOptions;
        int imeAction = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i = 3;
        int i2 = 6;
        if (ImeAction.m20620equalsimpl0(imeAction, companion.m20633getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i2 = 0;
            }
        } else if (ImeAction.m20620equalsimpl0(imeAction, companion.m20637getNoneeUduSuo())) {
            i2 = 1;
        } else if (ImeAction.m20620equalsimpl0(imeAction, companion.m20635getGoeUduSuo())) {
            i2 = 2;
        } else if (ImeAction.m20620equalsimpl0(imeAction, companion.m20636getNexteUduSuo())) {
            i2 = 5;
        } else if (ImeAction.m20620equalsimpl0(imeAction, companion.m20638getPreviouseUduSuo())) {
            i2 = 7;
        } else if (ImeAction.m20620equalsimpl0(imeAction, companion.m20639getSearcheUduSuo())) {
            i2 = 3;
        } else if (ImeAction.m20620equalsimpl0(imeAction, companion.m20640getSendeUduSuo())) {
            i2 = 4;
        } else if (!ImeAction.m20620equalsimpl0(imeAction, companion.m20634getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i2;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        LocaleListHelper.INSTANCE.setHintLocales(editorInfo, imeOptions.getHintLocales());
        int keyboardType = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20694getTextPjHm6EE())) {
            i = 1;
        } else if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20687getAsciiPjHm6EE())) {
            editorInfo.imeOptions |= Integer.MIN_VALUE;
            i = 1;
        } else if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20690getNumberPjHm6EE())) {
            i = 2;
        } else if (!KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20693getPhonePjHm6EE())) {
            if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20696getUriPjHm6EE())) {
                i = 17;
            } else if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20689getEmailPjHm6EE())) {
                i = 33;
            } else if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20692getPasswordPjHm6EE())) {
                i = 129;
            } else if (KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20691getNumberPasswordPjHm6EE())) {
                i = 18;
            } else {
                if (!KeyboardType.m20673equalsimpl0(keyboardType, companion2.m20688getDecimalPjHm6EE())) {
                    throw new IllegalStateException("Invalid Keyboard Type");
                }
                i = 8194;
            }
        }
        editorInfo.inputType = i;
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m20620equalsimpl0(imeOptions.getImeAction(), companion.m20633getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int capitalization = imeOptions.getCapitalization();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
            if (KeyboardCapitalization.m20656equalsimpl0(capitalization, companion3.m20665getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m20656equalsimpl0(capitalization, companion3.m20669getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m20656equalsimpl0(capitalization, companion3.m20667getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m20456getStartimpl(j);
        editorInfo.initialSelEnd = TextRange.m20451getEndimpl(j);
        EditorInfoCompat.setInitialSurroundingText(editorInfo, charSequence);
        if (strArr != null) {
            EditorInfoCompat.setContentMimeTypes(editorInfo, strArr);
        }
        editorInfo.imeOptions |= 33554432;
        if (!StylusHandwriting_androidKt.isStylusHandwritingSupported() || KeyboardType.m20673equalsimpl0(imeOptions.getKeyboardType(), companion2.m20692getPasswordPjHm6EE()) || KeyboardType.m20673equalsimpl0(imeOptions.getKeyboardType(), companion2.m20691getNumberPasswordPjHm6EE())) {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, false);
        } else {
            EditorInfoCompat.setStylusHandwritingEnabled(editorInfo, true);
            EditorInfoApi34.INSTANCE.setHandwritingGestures(editorInfo);
        }
    }

    /* JADX INFO: renamed from: update-pLxbY9I$default, reason: not valid java name */
    public static /* synthetic */ void m16316updatepLxbY9I$default(EditorInfo editorInfo, CharSequence charSequence, long j, ImeOptions imeOptions, String[] strArr, int i, Object obj) {
        if ((i & 8) != 0) {
            strArr = null;
        }
        m16315updatepLxbY9I(editorInfo, charSequence, j, imeOptions, strArr);
    }
}
