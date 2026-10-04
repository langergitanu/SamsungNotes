package com.samsung.android.app.sdk.deepsky.textextraction.selectionui.data;

import android.graphics.Point;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.selectionui.util.DrawUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import com.samsung.android.app.sdk.deepsky.textextraction.util.VectorUtil;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 32\u00020\u0001:\u00013B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J0\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010$\u001a\u00020%H\u0002J&\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J4\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0002J\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u000e\u0010/\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u0010J\u0018\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0016H\u0002R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000e¨\u00064"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableOcrResult;", "", "()V", "ocrResult", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "ratio", "", "centerOffset", "Landroid/graphics/Point;", "(Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;FLandroid/graphics/Point;)V", "selectableBlocks", "", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableBlock;", "getSelectableBlocks", "()Ljava/util/List;", "selectableCharacters", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "getSelectableCharacters", "selectableEntities", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableEntity;", "getSelectableEntities", "selectableLines", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableLine;", "getSelectableLines", "selectableWords", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableWord;", "getSelectableWords", "adjustSelectableLines", "", "adjustSelectableRegionOfWordsAndChars", "adjustSelectableRegions", "adjustSelectableRegionsOfEntities", "createEmptySpaceBetweenWords", DialogConstant.BUNDLE_WORD, "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "nextWord", "isLineVertical", "", "createSelectableBlocks", "result", "createSelectableEntities", "selectableChars", "getContentDescription", "", "getLineContainingCharacter", "char", "blocks", "getWordContainingCharacter", "isLineParallel", "line0", "line1", "Companion", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSelectableOcrResult.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SelectableOcrResult.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableOcrResult\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,336:1\n1864#2,3:337\n1864#2,3:340\n3433#2,7:357\n37#3,2:343\n37#3,2:345\n37#3,2:347\n37#3,2:349\n37#3,2:351\n37#3,2:353\n37#3,2:355\n*S KotlinDebug\n*F\n+ 1 SelectableOcrResult.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableOcrResult\n*L\n39#1:337,3\n40#1:340,3\n316#1:357,7\n106#1:343,2\n111#1:345,2\n118#1:347,2\n124#1:349,2\n154#1:351,2\n155#1:353,2\n199#1:355,2\n*E\n"})
public final class SelectableOcrResult {
    private static final int ADJUST_LINE_ANGLE_THRESHOLD = 5;
    private static final double ADJUST_LINE_HEIGHT_THRESHOLD = 0.3d;
    private static final float ADJUST_LINE_TILT_THRESHOLD = 5.0f;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final SelectableCharacter EMPTY_CHARACTER = new SelectableCharacter("", new Point[]{new Point(0, 0), new Point(0, 0), new Point(0, 0), new Point(0, 0)}, false);

    @NotNull
    private static final String TAG = "SelectableOcrResult";

    @NotNull
    private final List<SelectableBlock> selectableBlocks;

    @NotNull
    private final List<SelectableCharacter> selectableCharacters;

    @NotNull
    private final List<SelectableEntity> selectableEntities;

    @NotNull
    private final List<SelectableLine> selectableLines;

    @NotNull
    private final List<SelectableWord> selectableWords;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableOcrResult$Companion;", "", "()V", "ADJUST_LINE_ANGLE_THRESHOLD", "", "ADJUST_LINE_HEIGHT_THRESHOLD", "", "ADJUST_LINE_TILT_THRESHOLD", "", "EMPTY_CHARACTER", "Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", "getEMPTY_CHARACTER", "()Lcom/samsung/android/app/sdk/deepsky/textextraction/selectionui/data/SelectableCharacter;", SearchConstants.TargetContents.TAG, "", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableCharacter getEMPTY_CHARACTER() {
            return SelectableOcrResult.EMPTY_CHARACTER;
        }

        private Companion() {
        }
    }

    public SelectableOcrResult() {
        this.selectableBlocks = CollectionsKt.emptyList();
        this.selectableLines = CollectionsKt.emptyList();
        this.selectableWords = CollectionsKt.emptyList();
        this.selectableCharacters = CollectionsKt.emptyList();
        this.selectableEntities = CollectionsKt.emptyList();
    }

    private final void adjustSelectableLines() {
        for (SelectableBlock selectableBlock : this.selectableBlocks) {
            int i = 0;
            for (SelectableLine selectableLine : selectableBlock.getSelectableLines()) {
                int i2 = i + 1;
                if (i != selectableBlock.getSelectableLines().size() - 1) {
                    SelectableLine selectableLine2 = selectableBlock.getSelectableLines().get(i2);
                    if (isLineParallel(selectableLine, selectableLine2)) {
                        Point[] pointArr = {selectableLine.getPoly()[1], selectableLine.getPoly()[2]};
                        Point[] pointArr2 = {selectableLine.getPoly()[0], selectableLine.getPoly()[3]};
                        Point[] pointArr3 = {selectableLine2.getPoly()[0], selectableLine2.getPoly()[1]};
                        Point[] poly = selectableLine.getPoly();
                        VectorUtil vectorUtil = VectorUtil.INSTANCE;
                        Point pointCalcIntersectionOfLines = vectorUtil.calcIntersectionOfLines(pointArr, pointArr3);
                        if (pointCalcIntersectionOfLines == null) {
                            pointCalcIntersectionOfLines = selectableLine.getPoly()[2];
                        }
                        poly[2] = pointCalcIntersectionOfLines;
                        Point[] poly2 = selectableLine.getPoly();
                        Point pointCalcIntersectionOfLines2 = vectorUtil.calcIntersectionOfLines(pointArr2, pointArr3);
                        if (pointCalcIntersectionOfLines2 == null) {
                            pointCalcIntersectionOfLines2 = selectableLine.getPoly()[3];
                        }
                        poly2[3] = pointCalcIntersectionOfLines2;
                    }
                }
                i = i2;
            }
        }
    }

    private final void adjustSelectableRegionOfWordsAndChars() {
        Iterator<SelectableBlock> it = this.selectableBlocks.iterator();
        while (it.hasNext()) {
            for (SelectableLine selectableLine : it.next().getSelectableLines()) {
                Point point = new Point(-1, -1);
                Point point2 = new Point(-1, -1);
                int i = 0;
                for (SelectableWord selectableWord : selectableLine.getSelectableWords()) {
                    int i2 = i + 1;
                    Point[] pointArrCalcMinAreaPoly = VectorUtil.INSTANCE.calcMinAreaPoly(selectableWord.getPoly(), selectableLine.getPoly());
                    char c = 2;
                    if (i != 0) {
                        Point[] poly = selectableLine.getSelectableWords().get(i - 1).getPoly();
                        pointArrCalcMinAreaPoly[0] = poly[1];
                        pointArrCalcMinAreaPoly[3] = poly[2];
                    }
                    selectableWord.setPoly(pointArrCalcMinAreaPoly);
                    for (SelectableCharacter selectableCharacter : selectableWord.getSelectableCharacters()) {
                        char c2 = c;
                        Point[] pointArrCalcMinAreaPoly2 = VectorUtil.INSTANCE.calcMinAreaPoly(selectableCharacter.getPoly(), selectableLine.getPoly());
                        if (Intrinsics.areEqual(point, new Point(-1, -1)) && Intrinsics.areEqual(point2, new Point(-1, -1))) {
                            point = pointArrCalcMinAreaPoly2[0];
                            point2 = pointArrCalcMinAreaPoly2[3];
                        }
                        pointArrCalcMinAreaPoly2[0] = point;
                        pointArrCalcMinAreaPoly2[3] = point2;
                        selectableCharacter.setPoly(pointArrCalcMinAreaPoly2);
                        point = pointArrCalcMinAreaPoly2[1];
                        point2 = pointArrCalcMinAreaPoly2[c2];
                        c = c2;
                    }
                    i = i2;
                }
            }
        }
    }

    private final void adjustSelectableRegions() {
        adjustSelectableRegionOfWordsAndChars();
        adjustSelectableRegionsOfEntities();
    }

    private final void adjustSelectableRegionsOfEntities() {
        for (SelectableEntity selectableEntity : this.selectableEntities) {
            ArrayList arrayList = new ArrayList();
            List<Point[]> polyList = selectableEntity.getPolyList();
            List<SelectableLine> overlappingLines = selectableEntity.getOverlappingLines();
            Iterator<T> it = polyList.iterator();
            Iterator<T> it2 = overlappingLines.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.m13952k(polyList), CollectionsKt.m13952k(overlappingLines)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                SelectableLine selectableLine = (SelectableLine) it2.next();
                arrayList2.add(Boolean.valueOf(arrayList.add(VectorUtil.INSTANCE.calcMinAreaPoly((Point[]) next, selectableLine.getPoly()))));
            }
            selectableEntity.setPolyList(arrayList);
        }
    }

    private final SelectableWord createEmptySpaceBetweenWords(OcrResult.WordInfo word, OcrResult.WordInfo nextWord, float ratio, Point centerOffset, boolean isLineVertical) {
        Point[] pointArr;
        DrawUtil drawUtil = DrawUtil.INSTANCE;
        Point[] pointArr2 = (Point[]) drawUtil.fixDimensions(word.getPoly(), ratio, centerOffset).toArray(new Point[0]);
        Point[] pointArr3 = (Point[]) drawUtil.fixDimensions(nextWord.getPoly(), ratio, centerOffset).toArray(new Point[0]);
        if (PointUtil.INSTANCE.isPolyOverlapsPoly(pointArr2, pointArr3, 0.0d)) {
            Point point = pointArr2[1];
            pointArr = new Point[]{point, point, pointArr2[2], pointArr2[2]};
        } else {
            pointArr = new Point[]{pointArr2[1], pointArr3[0], pointArr3[3], pointArr2[2]};
        }
        SelectableWord selectableWord = new SelectableWord(" ", pointArr);
        selectableWord.getSelectableCharacters().add(new SelectableCharacter(" ", pointArr, isLineVertical));
        return selectableWord;
    }

    private final List<SelectableBlock> createSelectableBlocks(OcrResult result, float ratio, Point centerOffset) {
        float f = ratio;
        Point point = centerOffset;
        ArrayList arrayList = new ArrayList();
        for (OcrResult.BlockInfo blockInfo : result.getBlockInfoList()) {
            int i = 0;
            SelectableBlock selectableBlock = new SelectableBlock(blockInfo.getString(), (Point[]) DrawUtil.INSTANCE.fixDimensions(blockInfo.getPoly(), f, point).toArray(new Point[0]));
            arrayList.add(selectableBlock);
            for (OcrResult.LineInfo lineInfo : blockInfo.getLineInfo()) {
                Point[] pointArr = (Point[]) DrawUtil.INSTANCE.fixDimensions(lineInfo.getPoly(), f, point).toArray(new Point[i]);
                boolean zIsVertical = PointUtil.INSTANCE.isVertical(pointArr);
                SelectableLine selectableLine = new SelectableLine(lineInfo.getString(), pointArr, zIsVertical);
                selectableBlock.getSelectableLines().add(selectableLine);
                Iterator<OcrResult.WordInfo> it = lineInfo.getWordInfo().iterator();
                int i2 = i;
                while (it.hasNext()) {
                    int i4 = i2 + 1;
                    OcrResult.WordInfo next = it.next();
                    SelectableWord selectableWord = new SelectableWord(next.getString(), (Point[]) DrawUtil.INSTANCE.fixDimensions(next.getPoly(), f, point).toArray(new Point[i]));
                    selectableLine.getSelectableWords().add(selectableWord);
                    Iterator<OcrResult.CharInfo> it2 = next.getCharInfo().iterator();
                    while (it2.hasNext()) {
                        OcrResult.CharInfo next2 = it2.next();
                        OcrResult.WordInfo wordInfo = next;
                        Iterator<OcrResult.CharInfo> it3 = it2;
                        Point[] pointArr2 = (Point[]) DrawUtil.INSTANCE.fixDimensions(next2.getPoly(), f, point).toArray(new Point[0]);
                        String string = next2.getString();
                        if (string == null) {
                            string = "";
                        }
                        selectableWord.getSelectableCharacters().add(new SelectableCharacter(string, pointArr2, zIsVertical));
                        f = ratio;
                        next = wordInfo;
                        it2 = it3;
                    }
                    OcrResult.WordInfo wordInfo2 = next;
                    if (i2 != lineInfo.getWordInfo().size() - 1) {
                        i = 0;
                        selectableLine.getSelectableWords().add(createEmptySpaceBetweenWords(wordInfo2, lineInfo.getWordInfo().get(i4), ratio, point, zIsVertical));
                    } else {
                        i = 0;
                    }
                    f = ratio;
                    point = centerOffset;
                    i2 = i4;
                }
                f = ratio;
                point = centerOffset;
            }
            f = ratio;
            point = centerOffset;
        }
        return arrayList;
    }

    private final List<SelectableEntity> createSelectableEntities(OcrResult result, float ratio, Point centerOffset, List<SelectableCharacter> selectableChars) {
        ArrayList arrayList = new ArrayList();
        for (OcrResult.EntityInfo entityInfo : result.getEntityInfoList()) {
            ArrayList arrayList2 = new ArrayList();
            boolean zIsVertical = false;
            for (Point[] pointArr : entityInfo.getPolys()) {
                if (pointArr.length == 4) {
                    Point[] pointArr2 = (Point[]) DrawUtil.INSTANCE.fixDimensions(pointArr, ratio, centerOffset).toArray(new Point[0]);
                    zIsVertical |= PointUtil.INSTANCE.isVertical(pointArr2);
                    arrayList2.add(pointArr2);
                }
            }
            SelectableEntity selectableEntity = new SelectableEntity(entityInfo.getText(), entityInfo.getType(), arrayList2, zIsVertical);
            for (Point[] pointArr3 : selectableEntity.getPolyList()) {
                for (SelectableCharacter selectableCharacter : selectableChars) {
                    if (PointUtil.isPolyOverlapsPoly$default(PointUtil.INSTANCE, pointArr3, selectableCharacter.getPoly(), 0.0d, 4, null)) {
                        SelectableLine lineContainingCharacter = getLineContainingCharacter(selectableCharacter);
                        if (!selectableEntity.getOverlappingLines().contains(lineContainingCharacter)) {
                            selectableEntity.getOverlappingLines().add(lineContainingCharacter);
                        }
                        selectableEntity.getSelectableCharacters().add(selectableCharacter);
                    }
                }
            }
            if (selectableEntity.getSelectableCharacters().isEmpty()) {
                LibLogger.m5432i(TAG, "Selectable characters not detected, entity " + entityInfo.getText() + " is skipped");
            } else if (selectableEntity.getPolyList().size() != selectableEntity.getOverlappingLines().size()) {
                int size = selectableEntity.getPolyList().size();
                int size2 = selectableEntity.getOverlappingLines().size();
                String text = entityInfo.getText();
                StringBuilder sbM1173s = AbstractC0622a.m1173s(size, size2, "size of polyList(", ") and overlappingLines(", ") does not match, entity ");
                sbM1173s.append(text);
                sbM1173s.append(" is skipped");
                LibLogger.m5432i(TAG, sbM1173s.toString());
            } else {
                arrayList.add(selectableEntity);
            }
        }
        return arrayList;
    }

    private final boolean isLineParallel(SelectableLine line0, SelectableLine line1) {
        Point[] pointArr = {line0.getPoly()[3], line0.getPoly()[2]};
        Point[] pointArr2 = {line1.getPoly()[0], line1.getPoly()[1]};
        VectorUtil vectorUtil = VectorUtil.INSTANCE;
        return !vectorUtil.isTilted(line0.getPoly(), ADJUST_LINE_TILT_THRESHOLD) && vectorUtil.calcAngleBetweenLines(pointArr, pointArr2) < 5 && ((double) Math.abs(pointArr[0].y - pointArr2[0].y)) < ((double) vectorUtil.calcDistanceFromPointToPoint(line0.getPoly()[0], line0.getPoly()[3])) * ADJUST_LINE_HEIGHT_THRESHOLD && ((double) Math.abs(pointArr[1].y - pointArr2[1].y)) < ((double) vectorUtil.calcDistanceFromPointToPoint(line0.getPoly()[1], line0.getPoly()[2])) * ADJUST_LINE_HEIGHT_THRESHOLD;
    }

    @NotNull
    public final String getContentDescription() {
        StringBuilder sb = new StringBuilder();
        Iterator<SelectableWord> it = this.selectableWords.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getData());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
        return StringsKt.trim((CharSequence) string).toString();
    }

    @NotNull
    public final SelectableLine getLineContainingCharacter(@NotNull SelectableCharacter selectableCharacter) {
        Intrinsics.checkNotNullParameter(selectableCharacter, "char");
        for (SelectableLine selectableLine : this.selectableLines) {
            if (selectableLine.getSelectableCharacters().contains(selectableCharacter)) {
                return selectableLine;
            }
        }
        return (SelectableLine) CollectionsKt.first((List) this.selectableLines);
    }

    @NotNull
    public final List<SelectableBlock> getSelectableBlocks() {
        return this.selectableBlocks;
    }

    @NotNull
    public final List<SelectableCharacter> getSelectableCharacters() {
        return this.selectableCharacters;
    }

    @NotNull
    public final List<SelectableEntity> getSelectableEntities() {
        return this.selectableEntities;
    }

    @NotNull
    public final List<SelectableLine> getSelectableLines() {
        return this.selectableLines;
    }

    @NotNull
    public final List<SelectableWord> getSelectableWords() {
        return this.selectableWords;
    }

    @NotNull
    public final SelectableWord getWordContainingCharacter(@NotNull SelectableCharacter selectableCharacter) {
        Intrinsics.checkNotNullParameter(selectableCharacter, "char");
        for (SelectableWord selectableWord : this.selectableWords) {
            if (selectableWord.getSelectableCharacters().contains(selectableCharacter)) {
                return selectableWord;
            }
        }
        return (SelectableWord) CollectionsKt.first((List) this.selectableWords);
    }

    private final List<SelectableCharacter> getSelectableCharacters(List<SelectableBlock> blocks) {
        ArrayList arrayList = new ArrayList();
        Iterator<SelectableBlock> it = blocks.iterator();
        while (it.hasNext()) {
            Iterator<SelectableLine> it2 = it.next().getSelectableLines().iterator();
            while (it2.hasNext()) {
                Iterator<SelectableWord> it3 = it2.next().getSelectableWords().iterator();
                while (it3.hasNext()) {
                    arrayList.addAll(it3.next().getSelectableCharacters());
                }
            }
        }
        return arrayList;
    }

    private final List<SelectableLine> getSelectableLines(List<SelectableBlock> blocks) {
        ArrayList arrayList = new ArrayList();
        Iterator<SelectableBlock> it = blocks.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getSelectableLines());
        }
        return arrayList;
    }

    private final List<SelectableWord> getSelectableWords(List<SelectableBlock> blocks) {
        ArrayList arrayList = new ArrayList();
        Iterator<SelectableBlock> it = blocks.iterator();
        while (it.hasNext()) {
            Iterator<SelectableLine> it2 = it.next().getSelectableLines().iterator();
            while (it2.hasNext()) {
                arrayList.addAll(it2.next().getSelectableWords());
            }
        }
        return arrayList;
    }

    public SelectableOcrResult(@NotNull OcrResult ocrResult, float f, @NotNull Point centerOffset) {
        Intrinsics.checkNotNullParameter(ocrResult, "ocrResult");
        Intrinsics.checkNotNullParameter(centerOffset, "centerOffset");
        List<SelectableBlock> listCreateSelectableBlocks = createSelectableBlocks(ocrResult, f, centerOffset);
        this.selectableBlocks = listCreateSelectableBlocks;
        this.selectableLines = getSelectableLines(listCreateSelectableBlocks);
        List<SelectableWord> selectableWords = getSelectableWords(listCreateSelectableBlocks);
        this.selectableWords = selectableWords;
        List<SelectableCharacter> selectableCharacters = getSelectableCharacters(listCreateSelectableBlocks);
        this.selectableCharacters = selectableCharacters;
        adjustSelectableLines();
        this.selectableEntities = createSelectableEntities(ocrResult, f, centerOffset, selectableCharacters);
        adjustSelectableRegions();
        int i = 0;
        int i2 = 0;
        for (Object obj : selectableWords) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((SelectableWord) obj).setIndex(i2);
            i2 = i4;
        }
        for (Object obj2 : this.selectableCharacters) {
            int i5 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ((SelectableCharacter) obj2).setIndex(i);
            i = i5;
        }
    }
}
