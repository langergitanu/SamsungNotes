package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.p109ui.geometry.Offset;
import androidx.compose.p109ui.geometry.OffsetKt;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.layout.LayoutCoordinates;
import androidx.compose.p109ui.platform.ViewConfiguration;
import androidx.compose.p109ui.text.MultiParagraph;
import androidx.compose.p109ui.text.TextGranularity;
import androidx.compose.p109ui.text.TextInclusionStrategy;
import androidx.compose.p109ui.text.TextLayoutResult;
import androidx.compose.p109ui.text.TextRange;
import androidx.compose.p109ui.text.TextRangeKt;
import androidx.compose.p109ui.text.input.EditCommand;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0006\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0007\u001a\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000e\u001a\u00020\t*\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a&\u0010\u001b\u001a\u00020\u0001*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u001b\u001a\u00020\u0001*\u00020 2\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010!\u001a2\u0010\u001b\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a<\u0010&\u001a\u00020\t*\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a.\u0010,\u001a\u00020\t*\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a.\u0010,\u001a\u00020\t*\u00020 2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00105\u001a:\u0010,\u001a\u00020\t*\u0004\u0018\u00010\u00142\u0006\u0010-\u001a\u00020.2\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b6\u00107\u001a6\u00108\u001a\u00020\t*\u00020\u001c2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001a6\u00108\u001a\u00020\t*\u00020 2\u0006\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010=\u001a\u0014\u0010>\u001a\u00020?*\u00020'2\u0006\u0010@\u001a\u00020\u0001H\u0002\u001a\f\u0010A\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010B\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010C\u001a\u00020?*\u00020\u0001H\u0002\u001a\f\u0010D\u001a\u00020?*\u00020\u0001H\u0002\u001a\u0019\u0010E\u001a\u00020\t*\u00020\u00102\u0006\u0010@\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010F\u001a\u0011\u0010G\u001a\u00020\u0016*\u00020HH\u0002¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, m13886d2 = {"LINE_FEED_CODE_POINT", "", "NBSP_CODE_POINT", "compoundEditCommand", "Landroidx/compose/ui/text/input/EditCommand;", "editCommands", "", "([Landroidx/compose/ui/text/input/EditCommand;)Landroidx/compose/ui/text/input/EditCommand;", "enclosure", "Landroidx/compose/ui/text/TextRange;", "a", "b", "enclosure-pWDy79M", "(JJ)J", "adjustHandwritingDeleteGestureRange", "text", "", "adjustHandwritingDeleteGestureRange-72CqOWE", "(JLjava/lang/CharSequence;)J", "getLineForHandwritingGesture", "Landroidx/compose/ui/text/MultiParagraph;", "localPoint", "Landroidx/compose/ui/geometry/Offset;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getLineForHandwritingGesture-d-4ec7I", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "getOffsetForHandwritingGesture", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "pointInScreen", "getOffsetForHandwritingGesture-d-4ec7I", "(Landroidx/compose/foundation/text/LegacyTextFieldState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;JLandroidx/compose/ui/platform/ViewConfiguration;)I", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getOffsetForHandwritingGesture-ubNVwUQ", "(Landroidx/compose/ui/text/MultiParagraph;JLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)I", "getRangeForRemoveSpaceGesture", "Landroidx/compose/ui/text/TextLayoutResult;", "startPointInScreen", "endPointerInScreen", "getRangeForRemoveSpaceGesture-5iVPX68", "(Landroidx/compose/ui/text/TextLayoutResult;JJLandroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/platform/ViewConfiguration;)J", "getRangeForScreenRect", "rectInScreen", "Landroidx/compose/ui/geometry/Rect;", "granularity", "Landroidx/compose/ui/text/TextGranularity;", "inclusionStrategy", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getRangeForScreenRect-OH9lIzo", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRect-O048IG0", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/layout/LayoutCoordinates;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "getRangeForScreenRects", "startRectInScreen", "endRectInScreen", "getRangeForScreenRects-O048IG0", "(Landroidx/compose/foundation/text/LegacyTextFieldState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILandroidx/compose/ui/text/TextInclusionStrategy;)J", "isBiDiBoundary", "", TypedValues.Cycle.S_WAVE_OFFSET, "isNewline", "isPunctuation", "isWhitespace", "isWhitespaceExceptNewline", "rangeOfWhitespaces", "(Ljava/lang/CharSequence;I)J", "toOffset", "Landroid/graphics/PointF;", "(Landroid/graphics/PointF;)J", "foundation_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class HandwritingGesture_androidKt {
    private static final int LINE_FEED_CODE_POINT = 10;
    private static final int NBSP_CODE_POINT = 160;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: adjustHandwritingDeleteGestureRange-72CqOWE, reason: not valid java name */
    public static final long m16330adjustHandwritingDeleteGestureRange72CqOWE(long j, CharSequence charSequence) {
        int iM20456getStartimpl = TextRange.m20456getStartimpl(j);
        int iM20451getEndimpl = TextRange.m20451getEndimpl(j);
        int iCodePointBefore = iM20456getStartimpl > 0 ? Character.codePointBefore(charSequence, iM20456getStartimpl) : 10;
        int iCodePointAt = iM20451getEndimpl < charSequence.length() ? Character.codePointAt(charSequence, iM20451getEndimpl) : 10;
        if (isWhitespaceExceptNewline(iCodePointBefore) && (isWhitespace(iCodePointAt) || isPunctuation(iCodePointAt))) {
            do {
                iM20456getStartimpl -= Character.charCount(iCodePointBefore);
                if (iM20456getStartimpl == 0) {
                    break;
                }
                iCodePointBefore = Character.codePointBefore(charSequence, iM20456getStartimpl);
            } while (isWhitespaceExceptNewline(iCodePointBefore));
            return TextRangeKt.TextRange(iM20456getStartimpl, iM20451getEndimpl);
        }
        if (!isWhitespaceExceptNewline(iCodePointAt)) {
            return j;
        }
        if (!isWhitespace(iCodePointBefore) && !isPunctuation(iCodePointBefore)) {
            return j;
        }
        do {
            iM20451getEndimpl += Character.charCount(iCodePointAt);
            if (iM20451getEndimpl == charSequence.length()) {
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, iM20451getEndimpl);
        } while (isWhitespaceExceptNewline(iCodePointAt));
        return TextRangeKt.TextRange(iM20456getStartimpl, iM20451getEndimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditCommand compoundEditCommand(final EditCommand... editCommandArr) {
        return new EditCommand() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt.compoundEditCommand.1
            @Override // androidx.compose.p109ui.text.input.EditCommand
            public void applyTo(@NotNull androidx.compose.p109ui.text.input.EditingBuffer buffer) {
                for (EditCommand editCommand : editCommandArr) {
                    editCommand.applyTo(buffer);
                }
            }
        };
    }

    /* JADX INFO: renamed from: enclosure-pWDy79M, reason: not valid java name */
    private static final long m16331enclosurepWDy79M(long j, long j2) {
        return TextRangeKt.TextRange(Math.min(TextRange.m20456getStartimpl(j), TextRange.m20456getStartimpl(j)), Math.max(TextRange.m20451getEndimpl(j2), TextRange.m20451getEndimpl(j2)));
    }

    /* JADX INFO: renamed from: getLineForHandwritingGesture-d-4ec7I, reason: not valid java name */
    private static final int m16332getLineForHandwritingGestured4ec7I(MultiParagraph multiParagraph, long j, ViewConfiguration viewConfiguration) {
        float handwritingGestureLineMargin = viewConfiguration != null ? viewConfiguration.getHandwritingGestureLineMargin() : 0.0f;
        int lineForVerticalPosition = multiParagraph.getLineForVerticalPosition(Offset.m18285getYimpl(j));
        if (Offset.m18285getYimpl(j) < multiParagraph.getLineTop(lineForVerticalPosition) - handwritingGestureLineMargin || Offset.m18285getYimpl(j) > multiParagraph.getLineBottom(lineForVerticalPosition) + handwritingGestureLineMargin || Offset.m18284getXimpl(j) < (-handwritingGestureLineMargin) || Offset.m18284getXimpl(j) > multiParagraph.getWidth() + handwritingGestureLineMargin) {
            return -1;
        }
        return lineForVerticalPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m16334getOffsetForHandwritingGestured4ec7I(TextLayoutState textLayoutState, long j, ViewConfiguration viewConfiguration) {
        MultiParagraph multiParagraph;
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        if (layoutResult == null || (multiParagraph = layoutResult.getMultiParagraph()) == null) {
            return -1;
        }
        return m16335getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j, textLayoutState.getTextLayoutNodeCoordinates(), viewConfiguration);
    }

    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-ubNVwUQ, reason: not valid java name */
    private static final int m16335getOffsetForHandwritingGestureubNVwUQ(MultiParagraph multiParagraph, long j, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        long jMo19869screenToLocalMKHz9U;
        int iM16332getLineForHandwritingGestured4ec7I;
        if (layoutCoordinates == null || (iM16332getLineForHandwritingGestured4ec7I = m16332getLineForHandwritingGestured4ec7I(multiParagraph, (jMo19869screenToLocalMKHz9U = layoutCoordinates.mo19869screenToLocalMKHz9U(j)), viewConfiguration)) == -1) {
            return -1;
        }
        return multiParagraph.m20322getOffsetForPositionk4lQ0M(Offset.m18278copydBAh8RU$default(jMo19869screenToLocalMKHz9U, 0.0f, (multiParagraph.getLineBottom(iM16332getLineForHandwritingGestured4ec7I) + multiParagraph.getLineTop(iM16332getLineForHandwritingGestured4ec7I)) / 2.0f, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForRemoveSpaceGesture-5iVPX68, reason: not valid java name */
    public static final long m16336getRangeForRemoveSpaceGesture5iVPX68(TextLayoutResult textLayoutResult, long j, long j2, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        if (textLayoutResult == null || layoutCoordinates == null) {
            return TextRange.INSTANCE.m20461getZerod9O1mEE();
        }
        long jMo19869screenToLocalMKHz9U = layoutCoordinates.mo19869screenToLocalMKHz9U(j);
        long jMo19869screenToLocalMKHz9U2 = layoutCoordinates.mo19869screenToLocalMKHz9U(j2);
        int iM16332getLineForHandwritingGestured4ec7I = m16332getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), jMo19869screenToLocalMKHz9U, viewConfiguration);
        int iM16332getLineForHandwritingGestured4ec7I2 = m16332getLineForHandwritingGestured4ec7I(textLayoutResult.getMultiParagraph(), jMo19869screenToLocalMKHz9U2, viewConfiguration);
        if (iM16332getLineForHandwritingGestured4ec7I != -1) {
            if (iM16332getLineForHandwritingGestured4ec7I2 != -1) {
                iM16332getLineForHandwritingGestured4ec7I = Math.min(iM16332getLineForHandwritingGestured4ec7I, iM16332getLineForHandwritingGestured4ec7I2);
            }
            iM16332getLineForHandwritingGestured4ec7I2 = iM16332getLineForHandwritingGestured4ec7I;
        } else if (iM16332getLineForHandwritingGestured4ec7I2 == -1) {
            return TextRange.INSTANCE.m20461getZerod9O1mEE();
        }
        float lineBottom = (textLayoutResult.getLineBottom(iM16332getLineForHandwritingGestured4ec7I2) + textLayoutResult.getLineTop(iM16332getLineForHandwritingGestured4ec7I2)) / 2;
        return textLayoutResult.getMultiParagraph().m20323getRangeForRect86BmAI(new Rect(Math.min(Offset.m18284getXimpl(jMo19869screenToLocalMKHz9U), Offset.m18284getXimpl(jMo19869screenToLocalMKHz9U2)), lineBottom - 0.1f, Math.max(Offset.m18284getXimpl(jMo19869screenToLocalMKHz9U), Offset.m18284getXimpl(jMo19869screenToLocalMKHz9U2)), lineBottom + 0.1f), TextGranularity.INSTANCE.m20420getCharacterDRrd7Zo(), TextInclusionStrategy.INSTANCE.getAnyOverlap());
    }

    /* JADX INFO: renamed from: getRangeForScreenRect-O048IG0, reason: not valid java name */
    private static final long m16337getRangeForScreenRectO048IG0(MultiParagraph multiParagraph, Rect rect, LayoutCoordinates layoutCoordinates, int i, TextInclusionStrategy textInclusionStrategy) {
        return (multiParagraph == null || layoutCoordinates == null) ? TextRange.INSTANCE.m20461getZerod9O1mEE() : multiParagraph.m20323getRangeForRect86BmAI(rect.m18321translatek4lQ0M(layoutCoordinates.mo19869screenToLocalMKHz9U(Offset.INSTANCE.m18300getZeroF1C5BW0())), i, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m16339getRangeForScreenRectOH9lIzo(TextLayoutState textLayoutState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult layoutResult = textLayoutState.getLayoutResult();
        return m16337getRangeForScreenRectO048IG0(layoutResult != null ? layoutResult.getMultiParagraph() : null, rect, textLayoutState.getTextLayoutNodeCoordinates(), i, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m16341getRangeForScreenRectsO048IG0(TextLayoutState textLayoutState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long jM16339getRangeForScreenRectOH9lIzo = m16339getRangeForScreenRectOH9lIzo(textLayoutState, rect, i, textInclusionStrategy);
        if (TextRange.m20450getCollapsedimpl(jM16339getRangeForScreenRectOH9lIzo)) {
            return TextRange.INSTANCE.m20461getZerod9O1mEE();
        }
        long jM16339getRangeForScreenRectOH9lIzo2 = m16339getRangeForScreenRectOH9lIzo(textLayoutState, rect2, i, textInclusionStrategy);
        return TextRange.m20450getCollapsedimpl(jM16339getRangeForScreenRectOH9lIzo2) ? TextRange.INSTANCE.m20461getZerod9O1mEE() : m16331enclosurepWDy79M(jM16339getRangeForScreenRectOH9lIzo, jM16339getRangeForScreenRectOH9lIzo2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isBiDiBoundary(TextLayoutResult textLayoutResult, int i) {
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        return (i == textLayoutResult.getLineStart(lineForOffset) || i == TextLayoutResult.getLineEnd$default(textLayoutResult, lineForOffset, false, 2, null)) ? textLayoutResult.getParagraphDirection(i) != textLayoutResult.getBidiRunDirection(i) : textLayoutResult.getBidiRunDirection(i) != textLayoutResult.getBidiRunDirection(i - 1);
    }

    private static final boolean isNewline(int i) {
        int type = Character.getType(i);
        return type == 14 || type == 13 || i == 10;
    }

    private static final boolean isPunctuation(int i) {
        int type = Character.getType(i);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    private static final boolean isWhitespace(int i) {
        return Character.isWhitespace(i) || i == 160;
    }

    private static final boolean isWhitespaceExceptNewline(int i) {
        return isWhitespace(i) && !isNewline(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long rangeOfWhitespaces(CharSequence charSequence, int i) {
        int iCharCount = i;
        while (iCharCount > 0) {
            int iCodePointBefore = CodepointHelpers_jvmKt.codePointBefore(charSequence, iCharCount);
            if (!isWhitespace(iCodePointBefore)) {
                break;
            }
            iCharCount -= Character.charCount(iCodePointBefore);
        }
        while (i < charSequence.length()) {
            int iCodePointAt = CodepointHelpers_jvmKt.codePointAt(charSequence, i);
            if (!isWhitespace(iCodePointAt)) {
                break;
            }
            i += CodepointHelpers_jvmKt.charCount(iCodePointAt);
        }
        return TextRangeKt.TextRange(iCharCount, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long toOffset(PointF pointF) {
        return OffsetKt.Offset(pointF.x, pointF.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getOffsetForHandwritingGesture-d-4ec7I, reason: not valid java name */
    public static final int m16333getOffsetForHandwritingGestured4ec7I(LegacyTextFieldState legacyTextFieldState, long j, ViewConfiguration viewConfiguration) {
        TextLayoutResult value;
        MultiParagraph multiParagraph;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        if (layoutResult == null || (value = layoutResult.getValue()) == null || (multiParagraph = value.getMultiParagraph()) == null) {
            return -1;
        }
        return m16335getOffsetForHandwritingGestureubNVwUQ(multiParagraph, j, legacyTextFieldState.getLayoutCoordinates(), viewConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRect-OH9lIzo, reason: not valid java name */
    public static final long m16338getRangeForScreenRectOH9lIzo(LegacyTextFieldState legacyTextFieldState, Rect rect, int i, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult value;
        TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
        return m16337getRangeForScreenRectO048IG0((layoutResult == null || (value = layoutResult.getValue()) == null) ? null : value.getMultiParagraph(), rect, legacyTextFieldState.getLayoutCoordinates(), i, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getRangeForScreenRects-O048IG0, reason: not valid java name */
    public static final long m16340getRangeForScreenRectsO048IG0(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i, TextInclusionStrategy textInclusionStrategy) {
        long jM16338getRangeForScreenRectOH9lIzo = m16338getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect, i, textInclusionStrategy);
        if (TextRange.m20450getCollapsedimpl(jM16338getRangeForScreenRectOH9lIzo)) {
            return TextRange.INSTANCE.m20461getZerod9O1mEE();
        }
        long jM16338getRangeForScreenRectOH9lIzo2 = m16338getRangeForScreenRectOH9lIzo(legacyTextFieldState, rect2, i, textInclusionStrategy);
        return TextRange.m20450getCollapsedimpl(jM16338getRangeForScreenRectOH9lIzo2) ? TextRange.INSTANCE.m20461getZerod9O1mEE() : m16331enclosurepWDy79M(jM16338getRangeForScreenRectOH9lIzo, jM16338getRangeForScreenRectOH9lIzo2);
    }
}
