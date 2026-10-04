package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Pair;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLine;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.TypedArrayCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.PageSizeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p005A3.C0016a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001b\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0010J\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\u0010J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u000eH\u0007J\b\u0010\u0015\u001a\u00020\u000eH\u0007J0\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J \u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u0007J\n\u0010#\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010$\u001a\u00020\u0005H\u0007J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u000eH\u0007J\u0010\u0010'\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020\u0005H\u0007J\u001e\u0010)\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010*\u001a\u00020\u0005H\u0007J8\u0010+\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010*\u001a\u00020\u0005H\u0007J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u000200H\u0007J\u0018\u00101\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u000eH\u0002J \u00103\u001a\u00020-2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c04j\b\u0012\u0004\u0012\u00020\u001c`5H\u0007J\u0010\u00106\u001a\u00020-2\u0006\u0010 \u001a\u00020\u001cH\u0002J \u00107\u001a\u00020-2\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c04j\b\u0012\u0004\u0012\u00020\u001c`5H\u0007J$\u00108\u001a\u00020-2\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u000104j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`5H\u0007J\u0010\u00109\u001a\u00020-2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0012\u00109\u001a\u00020-2\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002J&\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010>\u001a\u0004\u0018\u00010\u001e2\u0006\u0010?\u001a\u00020@H\u0007J,\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020@H\u0007J\b\u0010C\u001a\u00020\u000eH\u0007J\u0010\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0007J\u0010\u0010G\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0007J\u0010\u0010H\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0007J\u0010\u0010I\u001a\u00020-2\u0006\u0010E\u001a\u00020FH\u0007J\u001a\u0010J\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010K\u001a\u0004\u0018\u00010\u001eH\u0007J\u0018\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0002J \u0010O\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u000e\u0010P\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010QH\u0007J.\u0010S\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u001a\u0010T\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u000104j\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`5H\u0007J,\u0010U\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0017\u001a\u00020\u00182\u0018\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u000e0X0WH\u0002J\b\u0010Y\u001a\u00020-H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006Z"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/AiDrawingUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mImageStyleList", "", "[Ljava/lang/String;", "initImageStyleList", "", "context", "Landroid/content/Context;", "getImageStyleCount", "", "getImageStyleList", "(Landroid/content/Context;)[Ljava/lang/String;", "getImageStyleNameList", "getImageStyleResources", "Landroid/content/res/TypedArray;", "getLastRowStartIndex", "getLastRowEndIndex", "getLowPriorityObjectType", FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE, "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "currentPageIndex", "objectList", "", "Lcom/samsung/android/sdk/pen/document/SpenObjectBase;", "contentRect", "Landroid/graphics/RectF;", "getPageOfObject", CoeditServiceConstants.Element.NAME_OBJECT, "saveLastUsedGenerateStyle", "generateTheme", "getLastUsedGenerateTheme", "getDefaultGenerateStyle", "getGenerateStyle", "position", "getGenerateStyleIndex", "generateStyle", "removeUnsupportedObjects", NotesConstants.KEY_CALLER, "removeLowPriorityObjects", "hasSupportedObjectsInScreen", "", "spenWNote", "objectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "hasSupportedObjectsInPage", "pageIndex", "hasUnsupportedObjects", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "isSupportedObject", "hasHighlighterObjects", "hasHighlighterObjectsOnly", "isHighlighterPen", "penName", "getScaledImage", "Landroid/graphics/Bitmap;", "originalImage", "size", "saturation", "", "width", "height", "getGeneratingImageCount", "isPopupShowingState", "state", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/menu/ai/drawing/AiDrawingState;", "isIgnoreContextState", "isRemoteFavoritePenChangedNotAllowedState", "isFocusEnabledState", "getMaxIntersectPageIdxFromTargetRect", "targetRect", "calculateIntersectAreaSize", "rect1", "rect2", "getRectFromPageObjectsInfos", "pageObjectsInfos", "", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/PageObjectsInfo;", "getBoundFromObjects", "objects", "getObjectsBound", "objectInfos", "", "Landroid/util/Pair;", "isDrawingToolkitUsed", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nAiDrawingUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiDrawingUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/AiDrawingUtil\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 Bitmap.kt\nandroidx/core/graphics/BitmapKt\n*L\n1#1,578:1\n37#2:579\n36#2,3:580\n84#3,6:583\n*S KotlinDebug\n*F\n+ 1 AiDrawingUtil.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/ai/drawing/common/AiDrawingUtil\n*L\n296#1:579\n296#1:580,3\n416#1:583,6\n*E\n"})
public final class AiDrawingUtil {

    @NotNull
    public static final AiDrawingUtil INSTANCE = new AiDrawingUtil();

    @NotNull
    private static final String TAG = "AiDrawingUtil";

    @Nullable
    private static String[] mImageStyleList;

    private AiDrawingUtil() {
    }

    private final float calculateIntersectAreaSize(RectF rect1, RectF rect2) {
        float fMax = (float) Math.max(rect1.left, rect2.left);
        float fMax2 = (float) Math.max(rect1.top, rect2.top);
        float fMin = (float) Math.min(rect1.right, rect2.right);
        float fMin2 = (float) Math.min(rect1.bottom, rect2.bottom);
        if (fMax >= fMin || fMax2 >= fMin2) {
            return 0.0f;
        }
        return (fMin2 - fMax2) * (fMin - fMax);
    }

    @JvmStatic
    @Nullable
    public static final RectF getBoundFromObjects(@NotNull SpenWNote note, @Nullable ArrayList<SpenObjectBase> objects) {
        Intrinsics.checkNotNullParameter(note, "note");
        if (objects == null || objects.isEmpty()) {
            return null;
        }
        int size = objects.size();
        if (size == 1 && note.getBodyText().hashCode() == objects.get(0).hashCode()) {
            return null;
        }
        RectF drawnRect = objects.get(0).getDrawnRect();
        for (int i = 1; i < size; i++) {
            Intrinsics.checkNotNull(drawnRect);
            RectF drawnRect2 = objects.get(i).getDrawnRect();
            Intrinsics.checkNotNull(drawnRect2);
            drawnRect.union(drawnRect2);
        }
        return drawnRect;
    }

    @JvmStatic
    @NotNull
    public static final String getDefaultGenerateStyle() {
        return getGenerateStyle(0);
    }

    @JvmStatic
    @NotNull
    public static final String getGenerateStyle(int position) {
        String[] strArr = mImageStyleList;
        Intrinsics.checkNotNull(strArr);
        return strArr[position];
    }

    @JvmStatic
    public static final int getGenerateStyleIndex(@NotNull String generateStyle) {
        Intrinsics.checkNotNullParameter(generateStyle, "generateStyle");
        Logger.m10999d(TAG, "getGenerateStyleIndex, generateStyle: " + generateStyle);
        String[] strArr = mImageStyleList;
        Intrinsics.checkNotNull(strArr);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String[] strArr2 = mImageStyleList;
            Intrinsics.checkNotNull(strArr2);
            if (Intrinsics.areEqual(strArr2[i], generateStyle)) {
                return i;
            }
        }
        return 0;
    }

    @JvmStatic
    public static final int getGeneratingImageCount() {
        return 1;
    }

    @JvmStatic
    public static final int getImageStyleCount(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return INSTANCE.getImageStyleList(context).length;
    }

    private final String[] getImageStyleList(Context context) {
        Resources resources = context.getResources();
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            String[] stringArray = resources.getStringArray(C9086R.array.ai_drawing_generate_style_image_china);
            Intrinsics.checkNotNull(stringArray);
            return stringArray;
        }
        String[] stringArray2 = resources.getStringArray(C9086R.array.ai_drawing_generate_style_image);
        Intrinsics.checkNotNull(stringArray2);
        return stringArray2;
    }

    @JvmStatic
    @NotNull
    public static final String[] getImageStyleNameList(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
            String[] stringArray = resources.getStringArray(C9086R.array.ai_drawing_generate_style_image_string_china);
            Intrinsics.checkNotNull(stringArray);
            return stringArray;
        }
        String[] stringArray2 = resources.getStringArray(C9086R.array.ai_drawing_generate_style_image_string);
        Intrinsics.checkNotNull(stringArray2);
        return stringArray2;
    }

    @JvmStatic
    @Nullable
    public static final TypedArray getImageStyleResources() {
        return CscFeature.INSTANCE.getInstance().isChinaAiFeature() ? TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.ai_drawing_style_image_resource_china) : TypedArrayCompat.INSTANCE.getInstance().obtainTypedArray(C9086R.array.ai_drawing_style_image_resource);
    }

    @JvmStatic
    public static final int getLastRowEndIndex() {
        if (BaseUtils.getApplicationContext() == null) {
            return 0;
        }
        return getImageStyleCount(r0) - 1;
    }

    @JvmStatic
    public static final int getLastRowStartIndex() {
        if (BaseUtils.getApplicationContext() == null) {
            return 0;
        }
        return ((getImageStyleCount(r0) - 1) / 3) * 3;
    }

    @JvmStatic
    @Nullable
    public static final String getLastUsedGenerateTheme() {
        return SharedPreferencesCompat.INSTANCE.getInstance(Constant.AI_DRAWING_PREF).getString(Constant.AI_DRAWING_LAST_STYLE, getDefaultGenerateStyle());
    }

    @JvmStatic
    public static final int getLowPriorityObjectType(@NotNull SpenWNote note, int currentPageIndex, @NotNull List<SpenObjectBase> objectList, @Nullable RectF contentRect) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Logger.m10999d(TAG, "getLowPriorityObjectType");
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        for (SpenObjectBase spenObjectBase : objectList) {
            Intrinsics.checkNotNullExpressionValue(spenObjectBase, "next(...)");
            SpenObjectBase spenObjectBase2 = spenObjectBase;
            if (spenObjectBase2.getDrawnRect() != null && (spenObjectBase2.getType() == 1 || spenObjectBase2.getType() == 8 || spenObjectBase2.getType() == 3)) {
                int pageOfObject = INSTANCE.getPageOfObject(note, currentPageIndex, spenObjectBase2);
                Point point = (pageOfObject < 0 || pageOfObject > note.getPageCount() - 1) ? new Point() : note.getPage(pageOfObject).getOffset();
                RectF drawnRect = spenObjectBase2.getDrawnRect();
                Intrinsics.checkNotNull(drawnRect);
                drawnRect.offset(point.x, point.y);
                if (spenObjectBase2.getType() == 1 || spenObjectBase2.getType() == 8) {
                    if (rectF.isEmpty()) {
                        rectF.set(drawnRect);
                    } else {
                        rectF.union(drawnRect);
                    }
                } else if (rectF2.isEmpty()) {
                    rectF2.set(drawnRect);
                } else {
                    rectF2.union(drawnRect);
                }
            }
        }
        if (contentRect != null) {
            RectF rectF3 = new RectF();
            rectF3.setIntersect(contentRect, rectF);
            RectF rectF4 = new RectF();
            rectF4.setIntersect(contentRect, rectF2);
            float fHeight = rectF3.height() * rectF3.width();
            float fHeight2 = rectF4.height() * rectF4.width();
            Logger.m10999d(TAG, "getLowPriorityObjectType# strokeIntersection: " + fHeight + ", imageIntersection: " + fHeight2);
            if (fHeight < fHeight2) {
                return 1;
            }
        } else {
            float fHeight3 = rectF.height() * rectF.width();
            float fHeight4 = rectF2.height() * rectF2.width();
            Logger.m10999d(TAG, "getLowPriorityObjectType# strokeRectSize: " + fHeight3 + ", imageRectSize: " + fHeight4);
            if (fHeight3 < fHeight4) {
                return 1;
            }
        }
        return 3;
    }

    @JvmStatic
    public static final int getMaxIntersectPageIdxFromTargetRect(@NotNull SpenWNote note, @Nullable RectF targetRect) {
        Intrinsics.checkNotNullParameter(note, "note");
        if (targetRect == null) {
            Logger.m10999d(TAG, "getMaxIntersectPageIdxFromTargetRect, lastEditedPageIndex: " + note.getLastEditedPageIndex());
            return note.getLastEditedPageIndex();
        }
        int pageCount = note.getPageCount();
        float f = 0.0f;
        int i = 0;
        for (int i2 = 0; i2 < pageCount; i2++) {
            float fCalculateIntersectAreaSize = INSTANCE.calculateIntersectAreaSize(PageSizeUtil.getPageBound(note, i2), targetRect);
            if (f < fCalculateIntersectAreaSize) {
                i = i2;
                f = fCalculateIntersectAreaSize;
            }
        }
        return i;
    }

    private final RectF getObjectsBound(SpenWNote note, List<? extends Pair<SpenObjectBase, Integer>> objectInfos) {
        if (objectInfos.isEmpty()) {
            return null;
        }
        RectF rectF = new RectF(note.getPageLayoutWidth(), note.getPageLayoutHeight(), 0.0f, 0.0f);
        Iterator<? extends Pair<SpenObjectBase, Integer>> it = objectInfos.iterator();
        while (it.hasNext()) {
            if (((SpenObjectBase) it.next().first).getDrawnRect() != null) {
                rectF.set((float) Math.min(rectF.left, r10.left), (float) Math.min(rectF.top, r10.top), (float) Math.max(rectF.right, r10.right), (float) Math.max(rectF.bottom, r10.bottom));
            }
        }
        return rectF;
    }

    private final int getPageOfObject(SpenWNote note, int currentPageIndex, SpenObjectBase object) {
        int pageCount = note.getPageCount();
        int type = object.getType();
        ArrayList<Pair> arrayList = new ArrayList();
        int i = pageCount - 1;
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(new Pair(Integer.valueOf(Math.abs(i2 - currentPageIndex)), Integer.valueOf(i2)));
        }
        Collections.sort(arrayList, new C0016a(18));
        int i4 = type == 3 ? 4 : 129;
        for (Pair pair : arrayList) {
            Object second = pair.second;
            Intrinsics.checkNotNullExpressionValue(second, "second");
            Iterator<SpenObjectBase> it = note.getPage(((Number) second).intValue()).getObjectList(i4).iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                SpenObjectBase next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                if (next.getMHandle() == object.getMHandle()) {
                    Object second2 = pair.second;
                    Intrinsics.checkNotNullExpressionValue(second2, "second");
                    return ((Number) second2).intValue();
                }
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getPageOfObject$lambda$0(Pair pair, Pair pair2) {
        if (Intrinsics.areEqual(pair.first, pair2.first)) {
            return 0;
        }
        return ((Number) pair.first).intValue() < ((Number) pair2.first).intValue() ? -1 : 1;
    }

    @JvmStatic
    @NotNull
    public static final RectF getRectFromPageObjectsInfos(@NotNull SpenWNote note, @Nullable Collection<PageObjectsInfo> pageObjectsInfos) {
        Intrinsics.checkNotNullParameter(note, "note");
        RectF rectF = new RectF(note.getPageLayoutWidth(), note.getPageLayoutHeight(), 0.0f, 0.0f);
        if (pageObjectsInfos != null && !pageObjectsInfos.isEmpty()) {
            for (PageObjectsInfo pageObjectsInfo : pageObjectsInfos) {
                if (pageObjectsInfo.getObjectInfos().size() == 1 && note.getBodyText().hashCode() == pageObjectsInfo.getObjectInfos().get(0).hashCode()) {
                    break;
                }
                if (pageObjectsInfo.getContentRect() == null) {
                    pageObjectsInfo.setContentRect(INSTANCE.getObjectsBound(note, pageObjectsInfo.getObjectInfos()));
                }
                try {
                    SpenWPage page = note.getPage(pageObjectsInfo.getPageIndex());
                    double d = rectF.left;
                    Intrinsics.checkNotNull(pageObjectsInfo.getContentRect());
                    float fMin = (float) Math.min(d, r5.left + page.getOffset().x);
                    double d2 = rectF.top;
                    Intrinsics.checkNotNull(pageObjectsInfo.getContentRect());
                    float fMin2 = (float) Math.min(d2, r6.top + page.getOffset().y);
                    double d3 = rectF.right;
                    Intrinsics.checkNotNull(pageObjectsInfo.getContentRect());
                    float fMax = (float) Math.max(d3, r7.right + page.getOffset().x);
                    double d4 = rectF.bottom;
                    Intrinsics.checkNotNull(pageObjectsInfo.getContentRect());
                    rectF.set(fMin, fMin2, fMax, (float) Math.max(d4, r1.bottom + page.getOffset().y));
                } catch (IndexOutOfBoundsException e) {
                    Logger.m11004w(TAG, "getRectFromPageObjectsInfos# IndexOutOfBoundsException, " + e.getMessage());
                }
            }
        }
        return rectF;
    }

    @JvmStatic
    @Nullable
    public static final Bitmap getScaledImage(@Nullable Bitmap originalImage, @Nullable RectF size, float saturation) {
        if (size == null) {
            return null;
        }
        return getScaledImage(originalImage, (int) size.width(), (int) size.height(), saturation);
    }

    @JvmStatic
    public static final boolean hasHighlighterObjects(@NotNull ArrayList<SpenObjectBase> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (INSTANCE.isHighlighterPen(next)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean hasHighlighterObjectsOnly(@Nullable ArrayList<SpenObjectBase> objectList) {
        if (objectList == null || objectList.isEmpty()) {
            return false;
        }
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (!INSTANCE.isHighlighterPen(next)) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasSupportedObjectsInPage(SpenWNote spenWNote, int pageIndex) {
        if (pageIndex < 0 || spenWNote.getPageCount() <= pageIndex) {
            return false;
        }
        SpenWPage page = spenWNote.getPage(pageIndex);
        if (page.getObjectList(4).isEmpty() && page.getObjectList(1).isEmpty() && page.getObjectList(64).isEmpty()) {
            return !page.getObjectList(128).isEmpty();
        }
        return true;
    }

    @JvmStatic
    public static final boolean hasSupportedObjectsInScreen(@NotNull SpenWNote spenWNote, @NotNull ObjectManager objectManager) {
        Intrinsics.checkNotNullParameter(spenWNote, "spenWNote");
        Intrinsics.checkNotNullParameter(objectManager, "objectManager");
        ArrayList<Integer> pageIndexListByRect = objectManager.getPageIndexListByRect(objectManager.getNoteZoomScroller().getContentRectInView());
        if (pageIndexListByRect == null) {
            Logger.m10999d(TAG, "hasSupportedObjectsInScreen# pageIndexListByRect is null");
            return false;
        }
        String string = Arrays.toString(pageIndexListByRect.toArray(new Integer[0]));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.m10999d(TAG, "hasSupportedObjectsInScreen# pageIndexListByRect : " + string);
        Iterator<Integer> it = pageIndexListByRect.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Integer next = it.next();
            AiDrawingUtil aiDrawingUtil = INSTANCE;
            Intrinsics.checkNotNull(next);
            if (aiDrawingUtil.hasSupportedObjectsInPage(spenWNote, next.intValue())) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final boolean hasUnsupportedObjects(@NotNull ArrayList<SpenObjectBase> objectList) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Iterator<SpenObjectBase> it = objectList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            SpenObjectBase next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (!INSTANCE.isSupportedObject(next)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final void initImageStyleList(@Nullable Context context) {
        if (context == null || mImageStyleList != null) {
            return;
        }
        mImageStyleList = INSTANCE.getImageStyleList(context);
    }

    @JvmStatic
    public static final boolean isDrawingToolkitUsed() {
        return Features.isSupportDrawingAssistFunction();
    }

    @JvmStatic
    public static final boolean isFocusEnabledState(@NotNull AiDrawingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return (AiDrawingState.NONE == state || AiDrawingState.TRIGGERED == state || AiDrawingState.GUIDE == state) ? false : true;
    }

    private final boolean isHighlighterPen(SpenObjectBase object) {
        if (1 == object.getType()) {
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectStroke");
            return isHighlighterPen(((SpenObjectStroke) object).getPenName());
        }
        if (8 == object.getType()) {
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLine");
            return isHighlighterPen(((SpenObjectLine) object).getPenName());
        }
        if (object.getType() != 7 || object.getExtraDataInt("extra_key_converted_type") == 1) {
            return false;
        }
        Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
        return isHighlighterPen(((SpenObjectShape) object).getPenName());
    }

    @JvmStatic
    public static final boolean isIgnoreContextState(@NotNull AiDrawingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return AiDrawingState.VIEW_INIT == state || AiDrawingState.READY == state || AiDrawingState.GUIDE == state || AiDrawingState.TRIGGERED == state;
    }

    @JvmStatic
    public static final boolean isPopupShowingState(@NotNull AiDrawingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return AiDrawingState.VIEW_INIT == state || AiDrawingState.READY == state || AiDrawingState.GUIDE == state;
    }

    @JvmStatic
    public static final boolean isRemoteFavoritePenChangedNotAllowedState(@NotNull AiDrawingState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return AiDrawingState.NONE != state;
    }

    private final boolean isSupportedObject(SpenObjectBase object) {
        boolean zIsHighlighterPen;
        if (1 == object.getType()) {
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectStroke");
            zIsHighlighterPen = isHighlighterPen(((SpenObjectStroke) object).getPenName());
        } else if (8 == object.getType()) {
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectLine");
            zIsHighlighterPen = isHighlighterPen(((SpenObjectLine) object).getPenName());
        } else {
            if (Features.isCreativeStudioSupported() && 3 == object.getType()) {
                return true;
            }
            if (isDrawingToolkitUsed() || object.getType() != 7 || object.getExtraDataInt("extra_key_converted_type") == 1) {
                return false;
            }
            Intrinsics.checkNotNull(object, "null cannot be cast to non-null type com.samsung.android.sdk.pen.document.SpenObjectShape");
            zIsHighlighterPen = isHighlighterPen(((SpenObjectShape) object).getPenName());
        }
        return !zIsHighlighterPen;
    }

    @JvmStatic
    public static final int removeLowPriorityObjects(@NotNull SpenWNote note, int currentPageIndex, @NotNull List<SpenObjectBase> objectList, @Nullable RectF contentRect, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(note, "note");
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Intrinsics.checkNotNullParameter(caller, "caller");
        ArrayList arrayList = new ArrayList();
        int lowPriorityObjectType = getLowPriorityObjectType(note, currentPageIndex, objectList, contentRect);
        for (SpenObjectBase spenObjectBase : objectList) {
            Intrinsics.checkNotNullExpressionValue(spenObjectBase, "next(...)");
            SpenObjectBase spenObjectBase2 = spenObjectBase;
            if (spenObjectBase2.getType() == lowPriorityObjectType) {
                arrayList.add(spenObjectBase2);
            }
        }
        objectList.removeAll(arrayList);
        StringBuilder sb = new StringBuilder("removeLowPriorityObjects, caller: ");
        sb.append(caller);
        sb.append(", lowPriorityObjectType: ");
        AbstractC8014b.m7221w(sb, TAG, lowPriorityObjectType);
        return lowPriorityObjectType;
    }

    @JvmStatic
    public static final void removeUnsupportedObjects(@NotNull List<SpenObjectBase> objectList, @NotNull String caller) {
        Intrinsics.checkNotNullParameter(objectList, "objectList");
        Intrinsics.checkNotNullParameter(caller, "caller");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (SpenObjectBase spenObjectBase : objectList) {
            Intrinsics.checkNotNullExpressionValue(spenObjectBase, "next(...)");
            SpenObjectBase spenObjectBase2 = spenObjectBase;
            if (!INSTANCE.isSupportedObject(spenObjectBase2)) {
                arrayList.add(spenObjectBase2);
                hashSet.add(Integer.valueOf(spenObjectBase2.getType()));
            }
        }
        objectList.removeAll(arrayList);
        Logger.m10999d(TAG, "removeUnsupportedObjects, caller: " + caller + ", unsupportedObjectList: " + hashSet);
    }

    @JvmStatic
    public static final void saveLastUsedGenerateStyle(@Nullable String generateTheme) {
        SharedPreferencesCompat.INSTANCE.getInstance(Constant.AI_DRAWING_PREF).putString(Constant.AI_DRAWING_LAST_STYLE, generateTheme);
    }

    @JvmStatic
    @Nullable
    public static final Bitmap getScaledImage(@Nullable Bitmap originalImage, int width, int height, float saturation) {
        if (originalImage == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(saturation);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(originalImage, (width - originalImage.getWidth()) / 2, (height - originalImage.getHeight()) / 2, paint);
        return bitmapCreateBitmap;
    }

    private final boolean isHighlighterPen(String penName) {
        return Intrinsics.areEqual(SpenPenManager.SPEN_MARKER, penName) || Intrinsics.areEqual(SpenPenManager.SPEN_MARKER2, penName) || Intrinsics.areEqual(SpenPenManager.SPEN_MARKER3, penName) || Intrinsics.areEqual(SpenPenManager.SPEN_MARKER4, penName) || Intrinsics.areEqual(SpenPenManager.SPEN_STRAIGHT_MARKER, penName) || Intrinsics.areEqual(SpenPenManager.SPEN_STRAIGHT_HIGHLIGHTER, penName);
    }
}
