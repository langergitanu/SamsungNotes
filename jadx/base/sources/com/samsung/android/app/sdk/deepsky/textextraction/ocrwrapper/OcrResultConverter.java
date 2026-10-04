package com.samsung.android.app.sdk.deepsky.textextraction.ocrwrapper;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityExtractionResult;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityItem;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.EntityType;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.OcrEntityExtractor;
import com.samsung.android.app.sdk.deepsky.textextraction.entity.Underline;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.app.sdk.deepsky.textextraction.result.OcrResult;
import com.samsung.android.app.sdk.deepsky.textextraction.textclassification.TextClassificationHelper;
import com.samsung.android.app.sdk.deepsky.textextraction.util.PointUtil;
import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.sdk.ocr.OCRResult;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.param.VexFwkOcrResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u00020\u00102\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017*\u00020\u0018H\u0002J\n\u0010\u0019\u001a\u00020\u001a*\u00020\u001bJ\u001a\u0010\u001c\u001a\u00020\u001a*\u00020\u001b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0002J$\u0010\u001d\u001a\u00020\u001b*\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010 \u001a\u00020!J\u0014\u0010\"\u001a\u00020\u0015*\u00020#2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010'\u001a\u00020(*\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0014\u0010*\u001a\u00020+*\u00020,2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\n\u0010-\u001a\u00020.*\u00020\u001bJ\u0014\u0010/\u001a\u000200*\u00020\u00152\u0006\u00101\u001a\u00020\u0004H\u0002J\f\u00102\u001a\u000203*\u00020%H\u0002J\f\u00104\u001a\u000205*\u00020(H\u0002J\f\u00106\u001a\u000207*\u00020+H\u0002J*\u00108\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/OcrResultConverter;", "", "()V", "DEFAULT_IS_TABULAR", "", SearchConstants.TargetContents.TAG, "", "blockToIsTabularMap", "Ljava/util/concurrent/ConcurrentHashMap;", "clearIsTabularMap", "", "getOriginPoint", "", "Landroid/graphics/Point;", "pointArray", "validRect", "Landroid/graphics/Rect;", "([Landroid/graphics/Point;Landroid/graphics/Rect;)[Landroid/graphics/Point;", "getRectFromPointArray", "([Landroid/graphics/Point;Landroid/graphics/Rect;)Landroid/graphics/Rect;", "getBlockKey", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$BlockInfo;", "isTabularList", "", "Lcom/samsung/android/sdk/ocr/OCRResult;", "toLttOcrResult", "Lcom/samsung/android/imagetranslation/data/LttOcrResult;", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult;", "toLttOcrResultInternal", "toOcrResult", "context", "Landroid/content/Context;", "extractTextOnly", "", "toOcrResultBlockInfo", "Lcom/samsung/android/sdk/ocr/OCRResult$BlockData;", "toOcrResultCharInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$CharInfo;", "Lcom/samsung/android/sdk/ocr/OCRResult$CharData;", "toOcrResultLineInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$LineInfo;", "Lcom/samsung/android/sdk/ocr/OCRResult$LineData;", "toOcrResultWordInfo", "Lcom/samsung/android/app/sdk/deepsky/textextraction/result/OcrResult$WordInfo;", "Lcom/samsung/android/sdk/ocr/OCRResult$WordData;", "toVexFwkOcrResult", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult;", "toVexFwkOcrResultBlockInfo", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$BlockInfo;", "isTabular", "toVexFwkOcrResultCharInfo", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$CharInfo;", "toVexFwkOcrResultLineInfo", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$LineInfo;", "toVexFwkOcrResultWordInfo", "Lcom/samsung/android/vexfwk/param/VexFwkOcrResult$WordInfo;", "withEntityInfo", "entityTypes", "Lcom/samsung/android/app/sdk/deepsky/textextraction/entity/EntityType;", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nOcrResultConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OcrResultConverter.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/OcrResultConverter\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 5 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,191:1\n1549#2:192\n1620#2,3:193\n1864#2,3:196\n1549#2:199\n1620#2,3:200\n1549#2:203\n1620#2,2:204\n1549#2:210\n1620#2,3:211\n1622#2:216\n1549#2:217\n1620#2,3:218\n1549#2:221\n1620#2,3:222\n1549#2:225\n1620#2,3:226\n1549#2:236\n1620#2,3:237\n1855#2:240\n1855#2:241\n1855#2,2:242\n1856#2:244\n1856#2:245\n731#2,9:246\n1549#2:255\n1620#2,3:256\n1549#2:259\n1620#2,3:260\n1549#2:263\n1620#2,3:264\n1549#2:267\n1620#2,3:268\n1549#2:271\n1620#2,3:272\n37#3,2:206\n37#3,2:208\n37#3,2:214\n37#3,2:234\n1#4:229\n11335#5:230\n11670#5,3:231\n*S KotlinDebug\n*F\n+ 1 OcrResultConverter.kt\ncom/samsung/android/app/sdk/deepsky/textextraction/ocrwrapper/OcrResultConverter\n*L\n34#1:192\n34#1:193,3\n44#1:196,3\n50#1:199\n50#1:200,3\n66#1:203\n66#1:204,2\n72#1:210\n72#1:211,3\n66#1:216\n88#1:217\n88#1:218,3\n95#1:221\n95#1:222,3\n102#1:225\n102#1:226,3\n128#1:236\n128#1:237,3\n141#1:240\n143#1:241\n145#1:242,2\n143#1:244\n141#1:245\n159#1:246,9\n164#1:255\n164#1:256,3\n168#1:259\n168#1:260,3\n175#1:263\n175#1:264,3\n181#1:267\n181#1:268,3\n185#1:271\n185#1:272,3\n70#1:206,2\n71#1:208,2\n74#1:214,2\n125#1:234,2\n123#1:230\n123#1:231,3\n*E\n"})
public final class OcrResultConverter {
    private static final int DEFAULT_IS_TABULAR = 0;

    @NotNull
    private static final String TAG = "OcrResultConverter";

    @NotNull
    public static final OcrResultConverter INSTANCE = new OcrResultConverter();

    @NotNull
    private static final ConcurrentHashMap<String, Integer> blockToIsTabularMap = new ConcurrentHashMap<>();

    private OcrResultConverter() {
    }

    private final String getBlockKey(OcrResult.BlockInfo blockInfo) {
        return AbstractC0541b.m757C(blockInfo.getString(), ",", PointUtil.INSTANCE.polyToString(blockInfo.getPoly()));
    }

    private final Point[] getOriginPoint(Point[] pointArray, Rect validRect) {
        ArrayList arrayList = new ArrayList(pointArray.length);
        for (Point point : pointArray) {
            arrayList.add(new Point(point.x + validRect.left, point.y + validRect.top));
        }
        return (Point[]) arrayList.toArray(new Point[0]);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    private final Rect getRectFromPointArray(Point[] pointArray, Rect validRect) {
        if (pointArray.length == 0) {
            throw new NoSuchElementException();
        }
        int i = pointArray[0].x;
        ?? it = new IntRange(1, ArraysKt.getLastIndex(pointArray)).iterator();
        while (it.hasNext()) {
            int i2 = pointArray[it.nextInt()].x;
            if (i > i2) {
                i = i2;
            }
        }
        int i4 = i + validRect.left;
        if (pointArray.length == 0) {
            throw new NoSuchElementException();
        }
        int i5 = pointArray[0].y;
        ?? it2 = new IntRange(1, ArraysKt.getLastIndex(pointArray)).iterator();
        while (it2.hasNext()) {
            int i6 = pointArray[it2.nextInt()].y;
            if (i5 > i6) {
                i5 = i6;
            }
        }
        int i7 = i5 + validRect.top;
        if (pointArray.length == 0) {
            throw new NoSuchElementException();
        }
        int i8 = pointArray[0].x;
        ?? it3 = new IntRange(1, ArraysKt.getLastIndex(pointArray)).iterator();
        while (it3.hasNext()) {
            int i9 = pointArray[it3.nextInt()].x;
            if (i8 < i9) {
                i8 = i9;
            }
        }
        int i10 = i8 + validRect.left;
        if (pointArray.length == 0) {
            throw new NoSuchElementException();
        }
        int i11 = pointArray[0].y;
        ?? it4 = new IntRange(1, ArraysKt.getLastIndex(pointArray)).iterator();
        while (it4.hasNext()) {
            int i12 = pointArray[it4.nextInt()].y;
            if (i11 < i12) {
                i11 = i12;
            }
        }
        return new Rect(i4, i7, i10, i11 + validRect.top);
    }

    private final List<Integer> isTabularList(OCRResult oCRResult) {
        ArrayList<OCRResult.BlockData> blockDataList = oCRResult.getBlockDataList();
        Intrinsics.checkNotNullExpressionValue(blockDataList, "blockDataList");
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(blockDataList));
        Iterator<T> it = blockDataList.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((OCRResult.BlockData) it.next()).isTabular()));
        }
        return arrayList;
    }

    private final LttOcrResult toLttOcrResultInternal(OcrResult ocrResult, List<Integer> list) {
        List listEmptyList;
        ArrayList arrayList = new ArrayList();
        Iterator it = CollectionsKt.zip(ocrResult.getBlockInfoList(), list).iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            OcrResult.BlockInfo blockInfo = (OcrResult.BlockInfo) pair.component1();
            int iIntValue = ((Number) pair.component2()).intValue();
            ArrayList arrayList2 = new ArrayList();
            for (OcrResult.LineInfo lineInfo : blockInfo.getLineInfo()) {
                ArrayList arrayList3 = new ArrayList();
                for (OcrResult.WordInfo wordInfo : lineInfo.getWordInfo()) {
                    ArrayList arrayList4 = new ArrayList();
                    for (OcrResult.CharInfo charInfo : wordInfo.getCharInfo()) {
                        String string = charInfo.getString();
                        if (string == null) {
                            string = "";
                        }
                        arrayList4.add(new LttOcrResult.CharInfo(string, charInfo.getRect(), charInfo.getPoly()));
                        it = it;
                    }
                    arrayList4.add(new LttOcrResult.CharInfo(" ", null, null));
                    arrayList3.add(new LttOcrResult.WordInfo(arrayList4, wordInfo.getRect(), wordInfo.getPoly(), ""));
                    it = it;
                }
                arrayList2.add(new LttOcrResult.LineInfo(arrayList3, lineInfo.getRect(), lineInfo.getPoly(), ""));
                it = it;
            }
            arrayList.add(new LttOcrResult.BlockInfo(arrayList2, blockInfo.getRect(), blockInfo.getPoly(), "", iIntValue));
        }
        List listM13999t = AbstractC12991c.m13999t(0, ",", ocrResult.getLanguageTags());
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        return new LttOcrResult(arrayList, listEmptyList);
    }

    public static /* synthetic */ OcrResult toOcrResult$default(OcrResultConverter ocrResultConverter, OCRResult oCRResult, Context context, Rect rect, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return ocrResultConverter.toOcrResult(oCRResult, context, rect, z);
    }

    private final OcrResult.BlockInfo toOcrResultBlockInfo(OCRResult.BlockData blockData, Rect rect) {
        ArrayList<OCRResult.LineData> lineDataList = blockData.getLineDataList();
        Intrinsics.checkNotNullExpressionValue(lineDataList, "lineDataList");
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(lineDataList));
        for (OCRResult.LineData it : lineDataList) {
            OcrResultConverter ocrResultConverter = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(ocrResultConverter.toOcrResultLineInfo(it, rect));
        }
        Point[] rect2 = blockData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect2, "rect");
        Rect rectFromPointArray = getRectFromPointArray(rect2, rect);
        Point[] rect3 = blockData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect3, "rect");
        return new OcrResult.BlockInfo(arrayList, rectFromPointArray, getOriginPoint(rect3, rect));
    }

    private final OcrResult.CharInfo toOcrResultCharInfo(OCRResult.CharData charData, Rect rect) {
        String text = charData.getText();
        Intrinsics.checkNotNullExpressionValue(text, "text");
        Point[] rect2 = charData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect2, "rect");
        Rect rectFromPointArray = getRectFromPointArray(rect2, rect);
        Point[] rect3 = charData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect3, "rect");
        return new OcrResult.CharInfo(text, rectFromPointArray, getOriginPoint(rect3, rect));
    }

    private final OcrResult.LineInfo toOcrResultLineInfo(OCRResult.LineData lineData, Rect rect) {
        ArrayList<OCRResult.WordData> wordDataList = lineData.getWordDataList();
        Intrinsics.checkNotNullExpressionValue(wordDataList, "wordDataList");
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(wordDataList));
        for (OCRResult.WordData it : wordDataList) {
            OcrResultConverter ocrResultConverter = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(ocrResultConverter.toOcrResultWordInfo(it, rect));
        }
        Point[] rect2 = lineData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect2, "rect");
        Rect rectFromPointArray = getRectFromPointArray(rect2, rect);
        Point[] rect3 = lineData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect3, "rect");
        return new OcrResult.LineInfo(arrayList, rectFromPointArray, getOriginPoint(rect3, rect));
    }

    private final OcrResult.WordInfo toOcrResultWordInfo(OCRResult.WordData wordData, Rect rect) {
        ArrayList<OCRResult.CharData> charDataList = wordData.getCharDataList();
        Intrinsics.checkNotNullExpressionValue(charDataList, "charDataList");
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(charDataList));
        for (OCRResult.CharData it : charDataList) {
            OcrResultConverter ocrResultConverter = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(ocrResultConverter.toOcrResultCharInfo(it, rect));
        }
        Point[] rect2 = wordData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect2, "rect");
        Rect rectFromPointArray = getRectFromPointArray(rect2, rect);
        Point[] rect3 = wordData.getRect();
        Intrinsics.checkNotNullExpressionValue(rect3, "rect");
        return new OcrResult.WordInfo(arrayList, rectFromPointArray, getOriginPoint(rect3, rect));
    }

    private final VexFwkOcrResult.BlockInfo toVexFwkOcrResultBlockInfo(OcrResult.BlockInfo blockInfo, int i) {
        List<OcrResult.LineInfo> lineInfo = blockInfo.getLineInfo();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(lineInfo));
        Iterator<T> it = lineInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toVexFwkOcrResultLineInfo((OcrResult.LineInfo) it.next()));
        }
        return new VexFwkOcrResult.BlockInfo(arrayList, blockInfo.getRect(), blockInfo.getPoly(), i, null, 16, null);
    }

    private final VexFwkOcrResult.CharInfo toVexFwkOcrResultCharInfo(OcrResult.CharInfo charInfo) {
        String string = charInfo.getString();
        if (string == null) {
            string = "";
        }
        return new VexFwkOcrResult.CharInfo(string, charInfo.getRect(), charInfo.getPoly());
    }

    private final VexFwkOcrResult.LineInfo toVexFwkOcrResultLineInfo(OcrResult.LineInfo lineInfo) {
        List<OcrResult.WordInfo> wordInfo = lineInfo.getWordInfo();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(wordInfo));
        Iterator<T> it = wordInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toVexFwkOcrResultWordInfo((OcrResult.WordInfo) it.next()));
        }
        return new VexFwkOcrResult.LineInfo(arrayList, lineInfo.getRect(), lineInfo.getPoly());
    }

    private final VexFwkOcrResult.WordInfo toVexFwkOcrResultWordInfo(OcrResult.WordInfo wordInfo) {
        List<OcrResult.CharInfo> charInfo = wordInfo.getCharInfo();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(charInfo));
        Iterator<T> it = charInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.toVexFwkOcrResultCharInfo((OcrResult.CharInfo) it.next()));
        }
        return new VexFwkOcrResult.WordInfo(arrayList, wordInfo.getRect(), wordInfo.getPoly());
    }

    public final void clearIsTabularMap() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = blockToIsTabularMap;
        concurrentHashMap.clear();
        LibLogger.m5432i(TAG, "clear blockToIsTabularMap of size: " + concurrentHashMap.size());
    }

    @NotNull
    public final LttOcrResult toLttOcrResult(@NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(ocrResult, "<this>");
        List<OcrResult.BlockInfo> blockInfoList = ocrResult.getBlockInfoList();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(blockInfoList));
        Iterator<T> it = blockInfoList.iterator();
        while (it.hasNext()) {
            Integer num = blockToIsTabularMap.get(INSTANCE.getBlockKey((OcrResult.BlockInfo) it.next()));
            if (num == null) {
                num = 0;
            }
            arrayList.add(num);
        }
        LttOcrResult lttOcrResultInternal = toLttOcrResultInternal(ocrResult, arrayList);
        LibLogger.m5432i(TAG, AbstractC0622a.m1164j(ocrResult.getBlockInfoList().size(), arrayList.size(), "convert to LttOcrResult with ", " blocks and ", " isTabular"));
        return lttOcrResultInternal;
    }

    @NotNull
    public final OcrResult toOcrResult(@NotNull OCRResult oCRResult, @NotNull Context context, @NotNull Rect validRect, boolean z) {
        Intrinsics.checkNotNullParameter(oCRResult, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(validRect, "validRect");
        ArrayList<OCRResult.BlockData> blockDataList = oCRResult.getBlockDataList();
        Intrinsics.checkNotNullExpressionValue(blockDataList, "blockDataList");
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(blockDataList));
        for (OCRResult.BlockData it : blockDataList) {
            OcrResultConverter ocrResultConverter = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.add(ocrResultConverter.toOcrResultBlockInfo(it, validRect));
        }
        OcrResult ocrResult = new OcrResult(arrayList, null, null, 6, null);
        if (!z) {
            ocrResult = withEntityInfo(ocrResult, context, EntityType.INSTANCE.listOfEntityType(), validRect);
        }
        int i = 0;
        for (Object obj : ocrResult.getBlockInfoList()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ConcurrentHashMap<String, Integer> concurrentHashMap = blockToIsTabularMap;
            OcrResultConverter ocrResultConverter2 = INSTANCE;
            concurrentHashMap.put(ocrResultConverter2.getBlockKey((OcrResult.BlockInfo) obj), ocrResultConverter2.isTabularList(oCRResult).get(i));
            i = i2;
        }
        return ocrResult;
    }

    @NotNull
    public final VexFwkOcrResult toVexFwkOcrResult(@NotNull OcrResult ocrResult) {
        Intrinsics.checkNotNullParameter(ocrResult, "<this>");
        List<OcrResult.BlockInfo> blockInfoList = ocrResult.getBlockInfoList();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(blockInfoList));
        Iterator<T> it = blockInfoList.iterator();
        while (it.hasNext()) {
            Integer num = blockToIsTabularMap.get(INSTANCE.getBlockKey((OcrResult.BlockInfo) it.next()));
            if (num == null) {
                num = 0;
            }
            arrayList.add(num);
        }
        List<Pair> listZip = CollectionsKt.zip(ocrResult.getBlockInfoList(), arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(listZip));
        for (Pair pair : listZip) {
            OcrResult.BlockInfo blockInfo = (OcrResult.BlockInfo) pair.component1();
            Integer isTabular = (Integer) pair.component2();
            OcrResultConverter ocrResultConverter = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(isTabular, "isTabular");
            arrayList2.add(ocrResultConverter.toVexFwkOcrResultBlockInfo(blockInfo, isTabular.intValue()));
        }
        return new VexFwkOcrResult(arrayList2);
    }

    @NotNull
    public final OcrResult withEntityInfo(@NotNull OcrResult ocrResult, @NotNull Context context, @NotNull List<? extends EntityType> entityTypes, @Nullable Rect rect) {
        Intrinsics.checkNotNullParameter(ocrResult, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entityTypes, "entityTypes");
        EntityExtractionResult entityExtractionResultExtractEntity = OcrEntityExtractor.INSTANCE.extractEntity(ocrResult, entityTypes, rect, new TextClassificationHelper(context));
        List<EntityItem> items = entityExtractionResultExtractEntity.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt.m13952k(items));
        for (EntityItem entityItem : items) {
            String text = entityItem.getText();
            String typeId = entityItem.getType().getTypeId();
            Rect[] rectArr = (Rect[]) entityItem.getRectList().toArray(new Rect[0]);
            Point[][] pointArr = (Point[][]) entityItem.getPolyList().toArray(new Point[0][]);
            List<Underline> underlines = entityItem.getUnderlines();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.m13952k(underlines));
            for (Underline underline : underlines) {
                arrayList2.add(new OcrResult.UnderlineInfo(underline.getStart(), underline.getStop()));
            }
            arrayList.add(new OcrResult.EntityInfo(text, typeId, rectArr, pointArr, (OcrResult.UnderlineInfo[]) arrayList2.toArray(new OcrResult.UnderlineInfo[0]), entityItem.getScore(), entityItem.getActions()));
        }
        return new OcrResult(ocrResult.getBlockInfoList(), CollectionsKt.toMutableList((Collection) arrayList), entityExtractionResultExtractEntity.getLanguageTags());
    }
}
