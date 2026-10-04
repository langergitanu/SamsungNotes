package androidx.compose.p109ui.text.input;

import android.view.Choreographer;
import android.view.inputmethod.EditorInfo;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.input.ImeAction;
import androidx.compose.p109ui.text.input.KeyboardCapitalization;
import androidx.compose.p109ui.text.input.KeyboardType;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.emoji2.text.EmojiCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(m13885d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0000\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\f\u0010\u0011\u001a\u00020\u000b*\u00020\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"DEBUG_CLASS", "", "hasFlag", "", "bits", "", "flag", "asExecutor", "Ljava/util/concurrent/Executor;", "Landroid/view/Choreographer;", Constants.ARG_UPDATE, "", "Landroid/view/inputmethod/EditorInfo;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "updateWithEmojiCompat", "ui_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class TextInputServiceAndroid_androidKt {

    @NotNull
    private static final String DEBUG_CLASS = "TextInputServiceAndroid";

    @NotNull
    public static final Executor asExecutor(@NotNull Choreographer choreographer) {
        return new ExecutorC2252b(choreographer, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asExecutor$lambda$2(Choreographer choreographer, Runnable runnable) {
        choreographer.postFrameCallback(new ChoreographerFrameCallbackC2251a(runnable, 0));
    }

    private static final boolean hasFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    public static final void update(@NotNull EditorInfo editorInfo, @NotNull ImeOptions imeOptions, @NotNull TextFieldValue textFieldValue) {
        String privateImeOptions;
        int iM20649getImeActioneUduSuo = imeOptions.getImeAction();
        ImeAction.Companion companion = ImeAction.INSTANCE;
        int i = 6;
        if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20633getDefaulteUduSuo())) {
            if (!imeOptions.getSingleLine()) {
                i = 0;
            }
        } else if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20637getNoneeUduSuo())) {
            i = 1;
        } else if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20635getGoeUduSuo())) {
            i = 2;
        } else if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20636getNexteUduSuo())) {
            i = 5;
        } else if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20638getPreviouseUduSuo())) {
            i = 7;
        } else if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20639getSearcheUduSuo())) {
            i = 3;
        } else if (ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20640getSendeUduSuo())) {
            i = 4;
        } else if (!ImeAction.m20620equalsimpl0(iM20649getImeActioneUduSuo, companion.m20634getDoneeUduSuo())) {
            throw new IllegalStateException("invalid ImeAction");
        }
        editorInfo.imeOptions = i;
        PlatformImeOptions platformImeOptions = imeOptions.getPlatformImeOptions();
        if (platformImeOptions != null && (privateImeOptions = platformImeOptions.getPrivateImeOptions()) != null) {
            editorInfo.privateImeOptions = privateImeOptions;
        }
        int iM20650getKeyboardTypePjHm6EE = imeOptions.getKeyboardType();
        KeyboardType.Companion companion2 = KeyboardType.INSTANCE;
        if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20694getTextPjHm6EE())) {
            editorInfo.inputType = 1;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20687getAsciiPjHm6EE())) {
            editorInfo.inputType = 1;
            editorInfo.imeOptions |= Integer.MIN_VALUE;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20690getNumberPjHm6EE())) {
            editorInfo.inputType = 2;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20693getPhonePjHm6EE())) {
            editorInfo.inputType = 3;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20696getUriPjHm6EE())) {
            editorInfo.inputType = 17;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20689getEmailPjHm6EE())) {
            editorInfo.inputType = 33;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20692getPasswordPjHm6EE())) {
            editorInfo.inputType = 129;
        } else if (KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20691getNumberPasswordPjHm6EE())) {
            editorInfo.inputType = 18;
        } else {
            if (!KeyboardType.m20673equalsimpl0(iM20650getKeyboardTypePjHm6EE, companion2.m20688getDecimalPjHm6EE())) {
                throw new IllegalStateException("Invalid Keyboard Type");
            }
            editorInfo.inputType = 8194;
        }
        if (!imeOptions.getSingleLine() && hasFlag(editorInfo.inputType, 1)) {
            editorInfo.inputType |= 131072;
            if (ImeAction.m20620equalsimpl0(imeOptions.getImeAction(), companion.m20633getDefaulteUduSuo())) {
                editorInfo.imeOptions |= 1073741824;
            }
        }
        if (hasFlag(editorInfo.inputType, 1)) {
            int iM20648getCapitalizationIUNYP9k = imeOptions.getCapitalization();
            KeyboardCapitalization.Companion companion3 = KeyboardCapitalization.INSTANCE;
            if (KeyboardCapitalization.m20656equalsimpl0(iM20648getCapitalizationIUNYP9k, companion3.m20665getCharactersIUNYP9k())) {
                editorInfo.inputType |= 4096;
            } else if (KeyboardCapitalization.m20656equalsimpl0(iM20648getCapitalizationIUNYP9k, companion3.m20669getWordsIUNYP9k())) {
                editorInfo.inputType |= 8192;
            } else if (KeyboardCapitalization.m20656equalsimpl0(iM20648getCapitalizationIUNYP9k, companion3.m20667getSentencesIUNYP9k())) {
                editorInfo.inputType |= 16384;
            }
            if (imeOptions.getAutoCorrect()) {
                editorInfo.inputType |= 32768;
            }
        }
        editorInfo.initialSelStart = TextRange.m20456getStartimpl(textFieldValue.getSelection());
        editorInfo.initialSelEnd = TextRange.m20451getEndimpl(textFieldValue.getSelection());
        EditorInfoCompat.setInitialSurroundingText(editorInfo, textFieldValue.getText());
        editorInfo.imeOptions |= 33554432;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateWithEmojiCompat(EditorInfo editorInfo) {
        if (EmojiCompat.isConfigured()) {
            EmojiCompat.get().updateEditorInfo(editorInfo);
        }
    }
}
