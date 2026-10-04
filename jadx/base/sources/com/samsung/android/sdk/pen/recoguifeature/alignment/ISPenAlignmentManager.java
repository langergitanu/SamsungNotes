package com.samsung.android.sdk.pen.recoguifeature.alignment;

import android.graphics.RectF;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0007\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\rH&J\u0012\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\b\u0010\u0017\u001a\u00020\u0003H&J\b\u0010\u0018\u001a\u00020\u0003H&J\b\u0010\u0019\u001a\u00020\u0003H&J(\u0010\u0019\u001a\u00020\u00032\u001e\u0010\u001a\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u0001`\u001dH&J\b\u0010\u001e\u001a\u00020\u0003H&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u0012\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010#H&J \u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H&J(\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0004R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0004¨\u0006*"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager;", "", "isRunning", "", "()Z", "isBeautificationSupported", "letterCorrectionEnabled", "getLetterCorrectionEnabled", "lineCorrectionEnabled", "getLineCorrectionEnabled", "wordSpacingEnabled", "getWordSpacingEnabled", "setNativeHandle", "", "handle", "", "close", "setListener", "l", "Lcom/samsung/android/sdk/pen/recoguifeature/alignment/SPenAlignmentListener;", "setEnabled", "enable", "executeAlignment", "executeSelectionAlignment", "cancelAlignment", "executeCleanUp", "resultRectList", "Ljava/util/ArrayList;", "Landroid/graphics/RectF;", "Lkotlin/collections/ArrayList;", "executeSelectionCleanUp", "cancel", "confirm", "updateLanguage", "text", "", "setBeautificationOptions", "fixShapeOfLetters", "alignLetters", "evenlySpaceWords", "straighten", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface ISPenAlignmentManager {
    public static final int CLEANUP_OPTION_FLAG_BASELINE_OF_LETTERS = 8;
    public static final int CLEANUP_OPTION_FLAG_LETTER = 4;
    public static final int CLEANUP_OPTION_FLAG_STRAIGHTEN = 32;
    public static final int CLEANUP_OPTION_FLAG_WORD = 16;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/alignment/ISPenAlignmentManager$Companion;", "", "<init>", "()V", "CLEANUP_OPTION_FLAG_LETTER", "", "CLEANUP_OPTION_FLAG_BASELINE_OF_LETTERS", "CLEANUP_OPTION_FLAG_WORD", "CLEANUP_OPTION_FLAG_STRAIGHTEN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int CLEANUP_OPTION_FLAG_BASELINE_OF_LETTERS = 8;
        public static final int CLEANUP_OPTION_FLAG_LETTER = 4;
        public static final int CLEANUP_OPTION_FLAG_STRAIGHTEN = 32;
        public static final int CLEANUP_OPTION_FLAG_WORD = 16;

        private Companion() {
        }
    }

    boolean cancel();

    boolean cancelAlignment();

    void close();

    boolean confirm();

    boolean executeAlignment();

    boolean executeCleanUp();

    boolean executeCleanUp(@Nullable ArrayList<RectF> resultRectList);

    boolean executeSelectionAlignment();

    boolean executeSelectionCleanUp();

    boolean getLetterCorrectionEnabled();

    boolean getLineCorrectionEnabled();

    boolean getWordSpacingEnabled();

    boolean isBeautificationSupported();

    boolean isRunning();

    void setBeautificationOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean evenlySpaceWords);

    void setBeautificationOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean evenlySpaceWords, boolean straighten);

    void setEnabled(boolean enable);

    void setListener(@Nullable SPenAlignmentListener l);

    void setNativeHandle(long handle);

    void updateLanguage(@Nullable CharSequence text);
}
