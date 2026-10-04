package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.textselection;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.compose.foundation.text.selection.C1462b;
import com.google.firebase.messaging.Constants;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.TextExtractionDrawHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableBlock;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableCharacter;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableEntity;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableLine;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableOcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectableWord;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data.SelectionInfo;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.helper.VibrationHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.VectorUtil;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 l2\u00020\u0001:\u0001lB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u000bJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u00100\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/J\u0018\u00101\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\"2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0018\u00106\u001a\u0002042\u0006\u00105\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u00107\u001a\u00020\"2\u0006\u0010.\u001a\u00020/J\u0018\u00108\u001a\u00020\"2\u0006\u00109\u001a\u0002042\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u0010:\u001a\u00020\u000bJ\u0010\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u0010.\u001a\u00020/J\u0012\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020/J\u0012\u0010?\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020\u001dJ\u0006\u0010C\u001a\u000204J\u0006\u0010D\u001a\u00020\u001dJ\u0006\u0010E\u001a\u00020\u001dJ\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017J\u0006\u0010G\u001a\u00020\u001dJ\u0006\u0010H\u001a\u00020\u001dJ\b\u0010I\u001a\u00020\u001dH\u0002J\u0018\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\u001dH\u0002J\b\u0010M\u001a\u00020*H\u0002J\u0006\u0010N\u001a\u00020\u0006J\u0006\u0010O\u001a\u00020\u0006J\u0010\u0010P\u001a\u00020\u00062\u0006\u0010.\u001a\u00020/H\u0002J\u0012\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0R0\u0017J\u0006\u0010S\u001a\u00020*J\u0016\u0010T\u001a\u00020*2\u0006\u0010U\u001a\u00020\u000b2\u0006\u0010V\u001a\u00020\u000bJ\u0018\u0010T\u001a\u00020*2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020XH\u0002J\u000e\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020AJ\u0018\u0010\\\u001a\u00020*2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020XH\u0002J\u0014\u0010]\u001a\u00020*2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020/0\u0017J\u0016\u0010_\u001a\u00020\u00062\u0006\u0010`\u001a\u00020X2\u0006\u0010a\u001a\u00020XJ\u0016\u0010b\u001a\u00020\u00062\u0006\u0010`\u001a\u00020X2\u0006\u0010a\u001a\u00020XJ\u000e\u0010c\u001a\u00020*2\u0006\u0010d\u001a\u00020\u0006J\u001e\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020/J\u0006\u0010k\u001a\u00020*J\f\u0010T\u001a\u00020**\u00020=H\u0002J\f\u0010T\u001a\u00020**\u00020\"H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/textselection/TextSelectionHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isTextSelectedForFirstTime", "", "()Z", "setTextSelectedForFirstTime", "(Z)V", "lastSelectedChar", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "getLastSelectedChar", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "setLastSelectedChar", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;)V", "onSelectedTextChangeListener", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnSelectedTextChangeListener;", "getOnSelectedTextChangeListener", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnSelectedTextChangeListener;", "setOnSelectedTextChangeListener", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/TextExtractionDrawHelper$OnSelectedTextChangeListener;)V", "selectableChars", "", "<set-?>", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableOcrResult;", "selectableOcrResult", "getSelectableOcrResult", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableOcrResult;", "", "selectedText", "getSelectedText", "()Ljava/lang/String;", "selectedWord", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableWord;", "getSelectedWord", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableWord;", "setSelectedWord", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableWord;)V", "vibrationHelper", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/helper/VibrationHelper;", "clearAllSelection", "", "findEndCharFromSelection", "findNearestBlock", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableBlock;", "point", "Landroid/graphics/Point;", "findNearestCharacter", "findNearestCharacterInWord", DialogConstant.BUNDLE_WORD, "findNearestLineInBlock", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableLine;", "block", "findNearestLineInBlockLineByLine", "findNearestWord", "findNearestWordInLine", "line", "findStartCharFromSelection", "findTouchedCharacter", "findTouchedEntity", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableEntity;", "findTouchedWord", "findTouchedWordStrict", "getBlockBoundingRect", "Landroid/graphics/Rect;", "getContentDescription", "getLastSelectedLine", "getLeftAdjacentStringFromSelection", "getRightAdjacentStringFromSelection", "getSelectedCharacters", "getSelectedTextForActionMode", "getSelectedTextForTextClassification", "getSelectedTextForTextSelection", "getSelectedTextWithSeparator", "lineSeparator", "blockSeparator", "hapticFeedback", "isAllTextSelected", "isTextSelected", "isTouchForDragAndDrop", "makeHighlightPolyPerBlock", "", "selectAll", "selectCharacters", Constants.MessagePayloadKeys.FROM, "to", "startIndexInclusive", "", "endIndexExclusive", "selectCharactersByRect", "rect", "selectWords", "selectWordsByPoints", "points", "setNewSelectedEntity", "x", "y", "setNewSelectedWord", "updateLastSelectedChar", "isStartHandle", "updateSelectableData", "result", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ratio", "", "centerOffset", "updateSelectedTextData", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nTextSelectionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextSelectionHelper.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/textselection/TextSelectionHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,430:1\n1747#2,3:431\n1726#2,3:434\n1855#2,2:437\n1549#2:439\n1620#2,3:440\n766#2:443\n857#2,2:444\n766#2:446\n857#2,2:447\n766#2:449\n857#2,2:450\n1549#2:452\n1620#2,3:453\n1549#2:457\n1620#2,3:458\n1855#2,2:461\n1549#2:463\n1620#2,3:464\n1855#2:467\n1864#2,2:468\n1855#2:470\n1855#2,2:471\n1856#2:473\n1866#2:474\n1856#2:475\n1#3:456\n*S KotlinDebug\n*F\n+ 1 TextSelectionHelper.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/textselection/TextSelectionHelper\n*L\n40#1:431,3\n42#1:434,3\n45#1:437,2\n53#1:439\n53#1:440,3\n54#1:443\n54#1:444,2\n68#1:446\n68#1:447,2\n97#1:449\n97#1:450,2\n101#1:452\n101#1:453,3\n131#1:457\n131#1:458,3\n137#1:461,2\n152#1:463\n152#1:464,3\n183#1:467\n184#1:468,2\n185#1:470\n186#1:471,2\n185#1:473\n184#1:474\n183#1:475\n*E\n"})
public final class TextSelectionHelper {

    @NotNull
    private static final String TAG = "TextSelectionHelper";
    private boolean isTextSelectedForFirstTime;

    @Nullable
    private SelectableCharacter lastSelectedChar;

    @Nullable
    private TextExtractionDrawHelper.OnSelectedTextChangeListener onSelectedTextChangeListener;

    @NotNull
    private List<SelectableCharacter> selectableChars;

    @NotNull
    private SelectableOcrResult selectableOcrResult;

    @NotNull
    private String selectedText;

    @Nullable
    private SelectableWord selectedWord;

    @NotNull
    private final VibrationHelper vibrationHelper;

    public TextSelectionHelper(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.vibrationHelper = new VibrationHelper(context);
        this.selectableChars = CollectionsKt.emptyList();
        this.selectableOcrResult = new SelectableOcrResult();
        this.selectedText = "";
    }

    private final SelectableBlock findNearestBlock(Point point) {
        List<SelectableBlock> selectableBlocks = this.selectableOcrResult.getSelectableBlocks();
        SelectableBlock selectableBlock = (SelectableBlock) CollectionsKt.first((List) selectableBlocks);
        float f = Float.MAX_VALUE;
        for (SelectableBlock selectableBlock2 : selectableBlocks) {
            float fCalcDistanceFromPointToPoly = VectorUtil.INSTANCE.calcDistanceFromPointToPoly(point, selectableBlock2.getPoly());
            if (fCalcDistanceFromPointToPoly < f) {
                selectableBlock = selectableBlock2;
                f = fCalcDistanceFromPointToPoly;
            }
        }
        return selectableBlock;
    }

    private final SelectableCharacter findNearestCharacterInWord(SelectableWord word, Point point) {
        List<SelectableCharacter> selectableCharacters = word.getSelectableCharacters();
        SelectableCharacter selectableCharacter = (SelectableCharacter) CollectionsKt.first((List) selectableCharacters);
        float f = Float.MAX_VALUE;
        for (SelectableCharacter selectableCharacter2 : selectableCharacters) {
            float fCalcDistanceFromPointToPoly = VectorUtil.INSTANCE.calcDistanceFromPointToPoly(point, selectableCharacter2.getPoly());
            if (fCalcDistanceFromPointToPoly < f) {
                selectableCharacter = selectableCharacter2;
                f = fCalcDistanceFromPointToPoly;
            }
        }
        return selectableCharacter;
    }

    private final SelectableLine findNearestLineInBlock(SelectableBlock block, Point point) {
        List<SelectableLine> selectableLines = block.getSelectableLines();
        SelectableLine selectableLine = (SelectableLine) CollectionsKt.first((List) selectableLines);
        float f = Float.MAX_VALUE;
        for (SelectableLine selectableLine2 : selectableLines) {
            float fCalcDistanceFromPointToPoly = VectorUtil.INSTANCE.calcDistanceFromPointToPoly(point, selectableLine2.getPoly());
            if (fCalcDistanceFromPointToPoly < f) {
                selectableLine = selectableLine2;
                f = fCalcDistanceFromPointToPoly;
            }
        }
        return selectableLine;
    }

    private final SelectableLine findNearestLineInBlockLineByLine(SelectableBlock block, final Point point) {
        return (SelectableLine) CollectionsKt.first(CollectionsKt.sortedWith(block.getSelectableLines(), new C1462b(new Function2<SelectableLine, SelectableLine, Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.selectionui.textselection.TextSelectionHelper$findNearestLineInBlockLineByLine$sortedSelectableLines$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(SelectableLine selectableLine, SelectableLine selectableLine2) {
                VectorUtil vectorUtil = VectorUtil.INSTANCE;
                float fCalcVerticalDistanceFromPointToPoly = vectorUtil.calcVerticalDistanceFromPointToPoly(point, selectableLine.getPoly());
                float fCalcVerticalDistanceFromPointToPoly2 = vectorUtil.calcVerticalDistanceFromPointToPoly(point, selectableLine2.getPoly());
                return Integer.valueOf(fCalcVerticalDistanceFromPointToPoly == fCalcVerticalDistanceFromPointToPoly2 ? Float.compare(vectorUtil.calcHorizontalDistanceFromPointToPoly(point, selectableLine.getPoly()), vectorUtil.calcHorizontalDistanceFromPointToPoly(point, selectableLine2.getPoly())) : Float.compare(fCalcVerticalDistanceFromPointToPoly, fCalcVerticalDistanceFromPointToPoly2));
            }
        }, 1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findNearestLineInBlockLineByLine$lambda$25(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final SelectableWord findNearestWordInLine(SelectableLine line, Point point) {
        List<SelectableWord> selectableWords = line.getSelectableWords();
        SelectableWord selectableWord = (SelectableWord) CollectionsKt.first((List) selectableWords);
        float f = Float.MAX_VALUE;
        for (SelectableWord selectableWord2 : selectableWords) {
            float fCalcDistanceFromPointToPoly = VectorUtil.INSTANCE.calcDistanceFromPointToPoly(point, selectableWord2.getPoly());
            if (fCalcDistanceFromPointToPoly < f && StringsKt.trim((CharSequence) selectableWord2.getData()).toString().length() > 0) {
                selectableWord = selectableWord2;
                f = fCalcDistanceFromPointToPoly;
            }
        }
        return selectableWord;
    }

    private final SelectableEntity findTouchedEntity(Point point) {
        for (SelectableEntity selectableEntity : this.selectableOcrResult.getSelectableEntities()) {
            Iterator<Point[]> it = selectableEntity.getPolyList().iterator();
            while (it.hasNext()) {
                if (PointUtil.INSTANCE.isPointInsidePoly(point, it.next())) {
                    return selectableEntity;
                }
            }
        }
        return null;
    }

    private final SelectableWord findTouchedWordStrict(Point point) {
        Object next;
        Iterator<T> it = this.selectableOcrResult.getSelectableWords().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (PointUtil.INSTANCE.isPointInsidePoly(point, ((SelectableWord) next).getPoly())) {
                break;
            }
        }
        return (SelectableWord) next;
    }

    private final String getSelectedTextForTextSelection() {
        return getSelectedTextWithSeparator("\n", "\n");
    }

    private final String getSelectedTextWithSeparator(String lineSeparator, String blockSeparator) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (SelectableBlock selectableBlock : this.selectableOcrResult.getSelectableBlocks()) {
            int i = 0;
            for (Object obj : selectableBlock.getSelectableLines()) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Iterator<T> it = ((SelectableLine) obj).getSelectableWords().iterator();
                while (it.hasNext()) {
                    for (SelectableCharacter selectableCharacter : ((SelectableWord) it.next()).getSelectableCharacters()) {
                        if (selectableCharacter.getIsSelected()) {
                            if (!z) {
                                z = true;
                            }
                            sb.append(selectableCharacter.getData());
                        }
                        if (!selectableCharacter.getIsSelected() && z) {
                            z = false;
                        }
                    }
                }
                if (z && i < selectableBlock.getSelectableLines().size() - 1) {
                    sb.append(lineSeparator);
                }
                i = i2;
            }
            if (z) {
                sb.append(blockSeparator);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return StringsKt.trim((CharSequence) string).toString();
    }

    private final void hapticFeedback() {
        if (this.vibrationHelper.isVibrationOff()) {
            LibLogger.m5433w(TAG, "Vibration is off");
        } else {
            this.vibrationHelper.doVibrate(false);
        }
    }

    private final boolean isTouchForDragAndDrop(Point point) {
        SelectableCharacter selectableCharacterFindTouchedCharacter = findTouchedCharacter(point);
        if (selectableCharacterFindTouchedCharacter == null || !selectableCharacterFindTouchedCharacter.getIsSelected()) {
            return false;
        }
        this.isTextSelectedForFirstTime = false;
        return true;
    }

    private final void selectCharacters(int startIndexInclusive, int endIndexExclusive) {
        while (startIndexInclusive < endIndexExclusive) {
            this.selectableChars.get(startIndexInclusive).setSelected(true);
            startIndexInclusive++;
        }
    }

    private final void selectWords(int startIndexInclusive, int endIndexExclusive) {
        List<SelectableWord> selectableWords = this.selectableOcrResult.getSelectableWords();
        while (startIndexInclusive < endIndexExclusive) {
            selectCharacters(selectableWords.get(startIndexInclusive));
            startIndexInclusive++;
        }
    }

    public final void clearAllSelection() {
        Iterator<T> it = this.selectableChars.iterator();
        while (it.hasNext()) {
            ((SelectableCharacter) it.next()).setSelected(false);
        }
    }

    @NotNull
    public final SelectableCharacter findEndCharFromSelection() {
        SelectableCharacter selectableCharacterPrevious;
        List<SelectableCharacter> list = this.selectableChars;
        ListIterator<SelectableCharacter> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                selectableCharacterPrevious = null;
                break;
            }
            selectableCharacterPrevious = listIterator.previous();
            if (selectableCharacterPrevious.getIsSelected()) {
                break;
            }
        }
        SelectableCharacter selectableCharacter = selectableCharacterPrevious;
        return selectableCharacter == null ? SelectableOcrResult.INSTANCE.getEMPTY_CHARACTER() : selectableCharacter;
    }

    @NotNull
    public final SelectableCharacter findNearestCharacter(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        return findNearestCharacterInWord(findNearestWord(point), point);
    }

    @NotNull
    public final SelectableWord findNearestWord(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        return findNearestWordInLine(findNearestLineInBlockLineByLine(findNearestBlock(point), point), point);
    }

    @NotNull
    public final SelectableCharacter findStartCharFromSelection() {
        Object next;
        Iterator<T> it = this.selectableChars.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((SelectableCharacter) next).getIsSelected()) {
                break;
            }
        }
        SelectableCharacter selectableCharacter = (SelectableCharacter) next;
        return selectableCharacter == null ? SelectableOcrResult.INSTANCE.getEMPTY_CHARACTER() : selectableCharacter;
    }

    @Nullable
    public final SelectableCharacter findTouchedCharacter(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        SelectableWord selectableWordFindTouchedWord = findTouchedWord(point);
        Object obj = null;
        if (selectableWordFindTouchedWord == null) {
            return null;
        }
        Iterator<T> it = selectableWordFindTouchedWord.getSelectableCharacters().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (PointUtil.INSTANCE.isPointInsidePoly(point, ((SelectableCharacter) next).getPoly())) {
                obj = next;
                break;
            }
        }
        return (SelectableCharacter) obj;
    }

    @Nullable
    public final SelectableWord findTouchedWord(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        for (SelectableWord selectableWord : findNearestLineInBlock(findNearestBlock(point), point).getSelectableWords()) {
            if (PointUtil.INSTANCE.isPointInsidePoly(point, selectableWord.getPoly())) {
                return StringsKt.trim((CharSequence) selectableWord.getData()).toString().length() == 0 ? findNearestWord(point) : selectableWord;
            }
        }
        return null;
    }

    @NotNull
    public final Rect getBlockBoundingRect() {
        VectorUtil vectorUtil = VectorUtil.INSTANCE;
        List<SelectableBlock> selectableBlocks = this.selectableOcrResult.getSelectableBlocks();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(selectableBlocks));
        Iterator<T> it = selectableBlocks.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectableBlock) it.next()).getPoly());
        }
        return vectorUtil.calcBoundingRect(arrayList);
    }

    @NotNull
    public final String getContentDescription() {
        return this.selectableOcrResult.getContentDescription();
    }

    @Nullable
    public final SelectableCharacter getLastSelectedChar() {
        return this.lastSelectedChar;
    }

    @NotNull
    public final SelectableLine getLastSelectedLine() {
        SelectableOcrResult selectableOcrResult = this.selectableOcrResult;
        SelectableCharacter selectableCharacter = this.lastSelectedChar;
        Intrinsics.checkNotNull(selectableCharacter);
        return selectableOcrResult.getLineContainingCharacter(selectableCharacter);
    }

    @NotNull
    public final String getLeftAdjacentStringFromSelection() {
        if (!isTextSelected()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = findStartCharFromSelection().getIndex();
        for (int i = 0; i < index; i++) {
            sb.append(this.selectableChars.get(i).getData());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return StringsKt.trim((CharSequence) string).toString();
    }

    @Nullable
    public final TextExtractionDrawHelper.OnSelectedTextChangeListener getOnSelectedTextChangeListener() {
        return this.onSelectedTextChangeListener;
    }

    @NotNull
    public final String getRightAdjacentStringFromSelection() {
        if (!isTextSelected()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int size = this.selectableChars.size();
        for (int index = findEndCharFromSelection().getIndex() + 1; index < size; index++) {
            sb.append(this.selectableChars.get(index).getData());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return StringsKt.trim((CharSequence) string).toString();
    }

    @NotNull
    public final SelectableOcrResult getSelectableOcrResult() {
        return this.selectableOcrResult;
    }

    @NotNull
    public final List<SelectableCharacter> getSelectedCharacters() {
        List<SelectableCharacter> list = this.selectableChars;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((SelectableCharacter) obj).getIsSelected()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final String getSelectedText() {
        return this.selectedText;
    }

    @NotNull
    public final String getSelectedTextForActionMode() {
        return getSelectedTextWithSeparator(" ", "\n");
    }

    @NotNull
    public final String getSelectedTextForTextClassification() {
        return getSelectedTextWithSeparator("\n", MarkdownDocument.NEW_LINE);
    }

    @Nullable
    public final SelectableWord getSelectedWord() {
        return this.selectedWord;
    }

    public final boolean isAllTextSelected() {
        List<SelectableCharacter> list = this.selectableChars;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((SelectableCharacter) it.next()).getIsSelected()) {
                return false;
            }
        }
        return true;
    }

    public final boolean isTextSelected() {
        List<SelectableCharacter> list = this.selectableChars;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((SelectableCharacter) it.next()).getIsSelected()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isTextSelectedForFirstTime, reason: from getter */
    public final boolean getIsTextSelectedForFirstTime() {
        return this.isTextSelectedForFirstTime;
    }

    @NotNull
    public final List<Point[]> makeHighlightPolyPerBlock() {
        List<SelectableBlock> selectableBlocks = this.selectableOcrResult.getSelectableBlocks();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(selectableBlocks));
        Iterator<T> it = selectableBlocks.iterator();
        while (it.hasNext()) {
            arrayList.add(((SelectableBlock) it.next()).getPoly());
        }
        return arrayList;
    }

    public final void selectAll() {
        Iterator<T> it = this.selectableChars.iterator();
        while (it.hasNext()) {
            ((SelectableCharacter) it.next()).setSelected(true);
        }
        updateLastSelectedChar(true);
    }

    public final void selectCharactersByRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        clearAllSelection();
        List<SelectableCharacter> selectableCharacters = this.selectableOcrResult.getSelectableCharacters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : selectableCharacters) {
            if (rect.contains(PointUtil.INSTANCE.polyToRect(((SelectableCharacter) obj).getPoly()))) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((SelectableCharacter) it.next()).setSelected(true);
        }
    }

    public final void selectWordsByPoints(@NotNull List<? extends Point> points) {
        Intrinsics.checkNotNullParameter(points, "points");
        clearAllSelection();
        List<SelectableWord> selectableWords = this.selectableOcrResult.getSelectableWords();
        List<? extends Point> list = points;
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(list));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            SelectableWord selectableWordFindTouchedWordStrict = findTouchedWordStrict((Point) it.next());
            arrayList.add(Integer.valueOf(selectableWordFindTouchedWordStrict != null ? selectableWordFindTouchedWordStrict.getIndex() : -1));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue >= 0 && iIntValue < selectableWords.size()) {
                arrayList2.add(obj);
            }
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.minOrNull((Iterable) arrayList2);
        Integer num2 = (Integer) CollectionsKt___CollectionsKt.maxOrNull((Iterable) arrayList2);
        if (num == null || num2 == null) {
            return;
        }
        selectWords(num.intValue(), num2.intValue() + 1);
        updateLastSelectedChar(true);
    }

    public final void setLastSelectedChar(@Nullable SelectableCharacter selectableCharacter) {
        this.lastSelectedChar = selectableCharacter;
    }

    public final boolean setNewSelectedEntity(int x, int y2) {
        if (this.selectableOcrResult.getSelectableBlocks().isEmpty()) {
            LibLogger.m5433w(TAG, "setNewSelectedEntity - no selectable blocks");
            return false;
        }
        Point point = new Point(x, y2);
        SelectableEntity selectableEntityFindTouchedEntity = findTouchedEntity(point);
        this.selectedWord = selectableEntityFindTouchedEntity != null ? this.selectableOcrResult.getWordContainingCharacter((SelectableCharacter) CollectionsKt.first((List) selectableEntityFindTouchedEntity.getSelectableCharacters())) : null;
        if (isTouchForDragAndDrop(point)) {
            return true;
        }
        if (selectableEntityFindTouchedEntity != null) {
            clearAllSelection();
            selectCharacters(selectableEntityFindTouchedEntity);
            this.lastSelectedChar = (SelectableCharacter) CollectionsKt.first((List) selectableEntityFindTouchedEntity.getSelectableCharacters());
        }
        updateSelectedTextData();
        return selectableEntityFindTouchedEntity != null;
    }

    public final boolean setNewSelectedWord(int x, int y2) {
        if (this.selectableOcrResult.getSelectableBlocks().isEmpty()) {
            LibLogger.m5433w(TAG, "setNewSelectedWord - no selectable blocks");
            return false;
        }
        Point point = new Point(x, y2);
        SelectableWord selectableWordFindTouchedWord = findTouchedWord(point);
        this.selectedWord = selectableWordFindTouchedWord;
        if (isTouchForDragAndDrop(point)) {
            return true;
        }
        this.isTextSelectedForFirstTime = true;
        if (selectableWordFindTouchedWord != null) {
            clearAllSelection();
            selectCharacters(selectableWordFindTouchedWord);
            this.lastSelectedChar = (SelectableCharacter) CollectionsKt.first((List) selectableWordFindTouchedWord.getSelectableCharacters());
        }
        updateSelectedTextData();
        return selectableWordFindTouchedWord != null;
    }

    public final void setOnSelectedTextChangeListener(@Nullable TextExtractionDrawHelper.OnSelectedTextChangeListener onSelectedTextChangeListener) {
        this.onSelectedTextChangeListener = onSelectedTextChangeListener;
    }

    public final void setSelectedWord(@Nullable SelectableWord selectableWord) {
        this.selectedWord = selectableWord;
    }

    public final void setTextSelectedForFirstTime(boolean z) {
        this.isTextSelectedForFirstTime = z;
    }

    public final void updateLastSelectedChar(boolean isStartHandle) {
        this.lastSelectedChar = isStartHandle ? findStartCharFromSelection() : findEndCharFromSelection();
    }

    public final void updateSelectableData(@NotNull OcrResult result, float ratio, @NotNull Point centerOffset) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(centerOffset, "centerOffset");
        SelectableOcrResult selectableOcrResult = new SelectableOcrResult(result, ratio, centerOffset);
        this.selectableOcrResult = selectableOcrResult;
        this.selectableChars = selectableOcrResult.getSelectableCharacters();
    }

    public final void updateSelectedTextData() {
        String str = this.selectedText;
        String selectedTextForTextSelection = getSelectedTextForTextSelection();
        this.selectedText = selectedTextForTextSelection;
        if (Intrinsics.areEqual(str, selectedTextForTextSelection)) {
            return;
        }
        if (str.length() > 0 && this.selectedText.length() > 0) {
            hapticFeedback();
        }
        TextExtractionDrawHelper.OnSelectedTextChangeListener onSelectedTextChangeListener = this.onSelectedTextChangeListener;
        if (onSelectedTextChangeListener != null) {
            onSelectedTextChangeListener.onChanged(this.selectedText);
            String str2 = this.selectedText;
            List<SelectableCharacter> selectedCharacters = getSelectedCharacters();
            ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(selectedCharacters));
            Iterator<T> it = selectedCharacters.iterator();
            while (it.hasNext()) {
                arrayList.add(((SelectableCharacter) it.next()).getPoly());
            }
            onSelectedTextChangeListener.onChanged(new SelectionInfo(str2, arrayList));
        }
    }

    public final void selectCharacters(@NotNull SelectableCharacter from, @NotNull SelectableCharacter to) {
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        selectCharacters(from.getIndex(), to.getIndex() + 1);
    }

    private final void selectCharacters(SelectableEntity selectableEntity) {
        selectCharacters((SelectableCharacter) CollectionsKt.first((List) selectableEntity.getSelectableCharacters()), (SelectableCharacter) CollectionsKt.last((List) selectableEntity.getSelectableCharacters()));
    }

    private final void selectCharacters(SelectableWord selectableWord) {
        selectCharacters((SelectableCharacter) CollectionsKt.first((List) selectableWord.getSelectableCharacters()), (SelectableCharacter) CollectionsKt.last((List) selectableWord.getSelectableCharacters()));
    }
}
