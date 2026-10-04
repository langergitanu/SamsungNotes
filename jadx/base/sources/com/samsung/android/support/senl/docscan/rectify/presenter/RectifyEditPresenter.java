package com.samsung.android.support.senl.docscan.rectify.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.common.util.DocScanUtils;
import com.samsung.android.support.senl.docscan.model.DocScanData;
import com.samsung.android.support.senl.docscan.rectify.model.RectifyImageInfo;
import com.samsung.android.support.senl.docscan.rectify.util.RectifyUtil;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b1\u0018\u0000 u2\u00020\u0001:\u0001uB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u001dJ\u0018\u0010$\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001d2\b\u0010%\u001a\u0004\u0018\u00010\nJ\b\u0010&\u001a\u00020\u0015H\u0002J\u0006\u0010'\u001a\u00020\u0015J\u0006\u0010(\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0012J\u000e\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0012J\u000e\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u0012J\u000e\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u0012J\u0010\u00108\u001a\u00020\u00152\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010;\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u0012J\u000e\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u0012J\u000e\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\nJ\u0011\u0010A\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\rJ\u000e\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nJ#\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\n2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010HJ!\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\n2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010KJ\u001f\u0010L\u001a\u00020E2\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\n¢\u0006\u0002\u0010NJ!\u0010O\u001a\u00020E2\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0002¢\u0006\u0002\u0010NJ!\u0010P\u001a\u00020E2\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0002¢\u0006\u0002\u0010NJ\u0010\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0010\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020\u0012H\u0002J1\u0010U\u001a\u00020\u00152\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u00122\u0012\u0010M\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0002¢\u0006\u0002\u0010XJ1\u0010Y\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\\J!\u0010]\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u001d2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010^J3\u0010_\u001a\u00020\n2\u0006\u0010`\u001a\u00020\u001d2\u0006\u0010a\u001a\u00020\n2\u0006\u0010b\u001a\u00020\n2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010cJ3\u0010d\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010[\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010eJ\u001b\u0010f\u001a\u00020E2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010NJ#\u0010h\u001a\u00020E2\u0006\u0010Z\u001a\u00020\u001d2\f\u0010g\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0002\u0010^J3\u0010i\u001a\u00020\u00152\u0006\u0010Z\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\n2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010>\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010jJ#\u0010k\u001a\u00020E2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010>\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010lJ\u0010\u0010m\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\nH\u0002J\b\u0010n\u001a\u0004\u0018\u00010:J\b\u0010o\u001a\u0004\u0018\u00010:J\u0010\u0010p\u001a\u00020\u00152\b\u0010q\u001a\u0004\u0018\u00010:J\u0014\u0010r\u001a\u0004\u0018\u00010:2\b\u0010s\u001a\u0004\u0018\u00010:H\u0002J\u0006\u0010t\u001a\u00020\u0015R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R(\u00103\u001a\u0004\u0018\u0001022\b\u00101\u001a\u0004\u0018\u0001028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006v"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/rectify/presenter/RectifyEditPresenter;", "", "<init>", "()V", "mImageInfo", "Lcom/samsung/android/support/senl/docscan/rectify/model/RectifyImageInfo;", "mDocScanData", "Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "value", "", "Landroid/graphics/PointF;", "previousVertexes", "getPreviousVertexes", "()[Landroid/graphics/PointF;", "[Landroid/graphics/PointF;", "mLastTouch", "mDelta", "mInterpolation", "", "mHandlerSize", "initScanLibrary", "", "deInitScanLibrary", "docScanData", "getDocScanData", "()Lcom/samsung/android/support/senl/docscan/model/DocScanData;", "setDocScanData", "(Lcom/samsung/android/support/senl/docscan/model/DocScanData;)V", "numOfAngle", "", "getNumOfAngle", "()I", "setNumOfAngle", "(I)V", "getVertex", "idx", "setVertex", "vertex", "initPrevVertexes", "resetVertexes", "sortVertexList", "setImageX", "x", "setImageY", "y", "setImageWidth", "width", "setImageHeight", "height", "path", "", DBSchema.DocumentThumbnail.IMAGE_PATH, "getImagePath", "()Ljava/lang/String;", "setImagePath", "(Ljava/lang/String;)V", "setImageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "setInterpolation", "interpolation", "setHandlerSize", "handlerSize", "setDelta", "touchedPos", "getRealPositionListFromRatio", "getRatioFromRealPosition", "pos", "isTouchedInsideOfRectifyArea", "", "dstPos", "curPosList", "(Landroid/graphics/PointF;[Landroid/graphics/PointF;)Z", "getTouchedObject", "touchPos", "(Landroid/graphics/PointF;[Landroid/graphics/PointF;)I", "canMoveAllPosition", "positions", "([Landroid/graphics/PointF;)Z", "canMoveVertical", "canMoveHorizontal", "isXPosInBound", "xPos", "isYPosInBound", "yPos", "applyOffsetToPositions", "deltaX", "deltaY", "(FF[Landroid/graphics/PointF;)V", "canMovePosition", "targetIdx", "startPos", "(ILandroid/graphics/PointF;Landroid/graphics/PointF;[Landroid/graphics/PointF;)Z", "canMoveLine", "(I[Landroid/graphics/PointF;)Z", "getStartPosIfParallel", "target", "start", "dst", "(ILandroid/graphics/PointF;Landroid/graphics/PointF;[Landroid/graphics/PointF;)Landroid/graphics/PointF;", "setHandlerConvexShape", "(ILandroid/graphics/PointF;Landroid/graphics/PointF;[Landroid/graphics/PointF;)V", "isConvexShape", "posList", "isLineConvexShape", "setHandlerNotOverlapped", "(ILandroid/graphics/PointF;[Landroid/graphics/PointF;F)V", "isLineOverlapped", "([Landroid/graphics/PointF;F)Z", "setHandlerPositionedInBounds", "saveRectifiedImageFromList", "saveRectifiedImageFromCamera", "saveRectifiedThumbnail", "rectifiedBitmap", "saveRectifiedImageToFile", "imageBitmap", "removeSavedCacheFile", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RectifyEditPresenter {

    @NotNull
    private static final String TAG = "RectifyEditPresenter";

    @Nullable
    private PointF mDelta;

    @Nullable
    private DocScanData mDocScanData;
    private float mHandlerSize;

    @NotNull
    private final RectifyImageInfo mImageInfo = new RectifyImageInfo();
    private float mInterpolation;

    @Nullable
    private PointF mLastTouch;

    @Nullable
    private PointF[] previousVertexes;

    private final void applyOffsetToPositions(float deltaX, float deltaY, PointF... positions) {
        for (PointF pointF : positions) {
            pointF.offset(deltaX, deltaY);
        }
    }

    private final boolean canMoveHorizontal(PointF... dstPos) {
        for (PointF pointF : dstPos) {
            if (!isYPosInBound(pointF.y)) {
                return false;
            }
        }
        return true;
    }

    private final boolean canMoveVertical(PointF... dstPos) {
        for (PointF pointF : dstPos) {
            if (!isXPosInBound(pointF.x)) {
                return false;
            }
        }
        return true;
    }

    private final PointF getStartPosIfParallel(int target, PointF start, PointF dst, PointF[] curPosList) {
        int length = curPosList.length;
        PointF pointF = new PointF(start.x, start.y);
        RectifyUtil rectifyUtil = RectifyUtil.INSTANCE;
        int i = ((target - 1) + length) % length;
        PointF pointF2 = curPosList[i];
        PointF pointF3 = curPosList[target];
        int i2 = (target + 1) % length;
        if (rectifyUtil.isParallel(pointF2, pointF3, pointF3, curPosList[i2])) {
            float gradient = rectifyUtil.getGradient(curPosList[i], curPosList[i2]);
            float f = curPosList[target].x;
            float f4 = pointF.x;
            float f5 = dst.x;
            float f6 = f4 < f5 ? f - this.mInterpolation : f + this.mInterpolation;
            float f7 = -gradient;
            pointF.set(f6, ((f6 / f7) + dst.y) - (f5 / f7));
        }
        return pointF;
    }

    private final void initPrevVertexes() {
        DocScanData docScanData = this.mDocScanData;
        if (docScanData == null) {
            return;
        }
        Intrinsics.checkNotNull(docScanData);
        PointF[] vertexList = docScanData.getVertexList();
        this.previousVertexes = new PointF[vertexList.length];
        int length = vertexList.length;
        for (int i = 0; i < length; i++) {
            PointF[] pointFArr = this.previousVertexes;
            Intrinsics.checkNotNull(pointFArr);
            PointF pointF = vertexList[i];
            Intrinsics.checkNotNull(pointF);
            float f = pointF.x;
            PointF pointF2 = vertexList[i];
            Intrinsics.checkNotNull(pointF2);
            pointFArr[i] = new PointF(f, pointF2.y);
        }
    }

    private final boolean isConvexShape(PointF[] posList) {
        int length = posList.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (RectifyUtil.INSTANCE.isCounterClockwise(posList[(i + 2) % length], posList[i2 % length], posList[i])) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    private final boolean isLineConvexShape(int targetIdx, PointF[] posList) {
        int length = posList.length;
        if (RectifyUtil.INSTANCE.isParallel(posList[targetIdx], posList[(targetIdx + 1) % length], posList[(targetIdx + 2) % length], posList[(targetIdx + 3) % length])) {
            return true;
        }
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (RectifyUtil.INSTANCE.isCounterClockwise(posList[(i + 2) % length], posList[i2 % length], posList[i])) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    private final boolean isLineOverlapped(PointF[] curPosList, float handlerSize) {
        int length = curPosList.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            for (int i4 = i2; i4 < length; i4++) {
                if (RectifyUtil.INSTANCE.isHandlerAreaIsOverlapped(curPosList[i], curPosList[i4], handlerSize)) {
                    return true;
                }
            }
            i = i2;
        }
        return false;
    }

    private final boolean isTouchedInsideOfRectifyArea(PointF dstPos, PointF[] curPosList) {
        int length = curPosList.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (!RectifyUtil.INSTANCE.isCounterClockwise(curPosList[i2 % length], dstPos, curPosList[i])) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    private final boolean isXPosInBound(float xPos) {
        float fRint = (float) Math.rint(this.mImageInfo.getX() - this.mInterpolation);
        float fRint2 = (float) Math.rint((this.mImageInfo.getWidth() + this.mImageInfo.getX()) - this.mInterpolation);
        float fRint3 = (float) Math.rint(xPos);
        return fRint <= fRint3 && fRint3 <= fRint2;
    }

    private final boolean isYPosInBound(float yPos) {
        float fRint = (float) Math.rint(this.mImageInfo.getY() - this.mInterpolation);
        float fRint2 = (float) Math.rint((this.mImageInfo.getHeight() + this.mImageInfo.getY()) - this.mInterpolation);
        float fRint3 = (float) Math.rint(yPos);
        return fRint <= fRint3 && fRint3 <= fRint2;
    }

    private final Bitmap saveRectifiedImageToFile(Bitmap imageBitmap) {
        if (imageBitmap == null) {
            Logger.m7146e(TAG, "saveRectifiedImageToFile# failed - imageBitmap is null");
            return null;
        }
        SmartScanRectifyWrapper smartScanRectifyWrapper = SmartScanRectifyWrapper.INSTANCE;
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        Bitmap bitmapExecute = smartScanRectifyWrapper.execute(docScanData, imageBitmap);
        if (bitmapExecute != null && !bitmapExecute.isRecycled()) {
            DocScanData docScanData2 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData2);
            if (TextUtils.isEmpty(docScanData2.getPathToSave())) {
                Logger.m7146e(TAG, "saveRectifiedImageToFile# failed - The path is empty");
                return null;
            }
            DocScanData docScanData3 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData3);
            String pathToSave = docScanData3.getPathToSave();
            File file = pathToSave != null ? new File(pathToSave) : null;
            Intrinsics.checkNotNull(file);
            if (file.getParentFile() != null) {
                File parentFile = file.getParentFile();
                Intrinsics.checkNotNull(parentFile);
                if (parentFile.exists()) {
                    if (ImageUtils.makeJpg(bitmapExecute, file, 100)) {
                        return bitmapExecute;
                    }
                    try {
                        FileUtils.deleteFile(file);
                    } catch (IOException e) {
                        Logger.m7146e(TAG, "saveRectifiedImageToFile# fail to delete savedFile: " + e.getMessage());
                    }
                    Logger.m7146e(TAG, "saveRectifiedImageToFile# fail to make jpg");
                    return null;
                }
            }
            DocScanData docScanData4 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData4);
            String pathToSave2 = docScanData4.getPathToSave();
            Intrinsics.checkNotNull(pathToSave2);
            Logger.m7146e(TAG, "saveRectifiedImageToFile# failed - getParentFile is null. path:" + Logger.getEncode(pathToSave2));
        }
        return null;
    }

    private final void setHandlerConvexShape(int targetIdx, PointF startPos, PointF dstPos, PointF[] curPosList) {
        int length = curPosList.length;
        RectifyUtil rectifyUtil = RectifyUtil.INSTANCE;
        int i = (targetIdx + 2) % length;
        int i2 = (targetIdx + 1) % length;
        if (rectifyUtil.isCounterClockwise(curPosList[i], curPosList[i2], dstPos)) {
            dstPos.set(rectifyUtil.getCrossingPosition(startPos, dstPos, curPosList[i], curPosList[i2]));
        }
        int i4 = ((targetIdx - 1) + length) % length;
        int i5 = ((targetIdx - 2) + length) % length;
        if (rectifyUtil.isCounterClockwise(dstPos, curPosList[i4], curPosList[i5])) {
            dstPos.set(rectifyUtil.getCrossingPosition(startPos, dstPos, curPosList[i4], curPosList[i5]));
        }
        if (rectifyUtil.isCounterClockwise(curPosList[i2], dstPos, curPosList[i4])) {
            dstPos.set(rectifyUtil.getCrossingPosition(startPos, dstPos, curPosList[i2], curPosList[i4]));
        }
    }

    private final void setHandlerNotOverlapped(int targetIdx, PointF pos, PointF[] curPosList, float handlerSize) {
        int length = curPosList.length;
        for (int i = 0; i < length; i++) {
            if (i != targetIdx) {
                RectifyUtil rectifyUtil = RectifyUtil.INSTANCE;
                if (rectifyUtil.isHandlerAreaIsOverlapped(pos, curPosList[i], handlerSize)) {
                    pos.set(rectifyUtil.getNotOverlappedPosition(pos, curPosList[i], handlerSize));
                }
            }
        }
    }

    private final void setHandlerPositionedInBounds(PointF pos) {
        float x = this.mImageInfo.getX() - this.mInterpolation;
        float width = (this.mImageInfo.getWidth() + this.mImageInfo.getX()) - this.mInterpolation;
        float y2 = this.mImageInfo.getY() - this.mInterpolation;
        float height = (this.mImageInfo.getHeight() + this.mImageInfo.getY()) - this.mInterpolation;
        float f = pos.x;
        if (f < x) {
            pos.x = x;
        } else if (width <= f) {
            pos.x = width;
        }
        float f4 = pos.y;
        if (f4 < y2) {
            pos.y = y2;
        } else if (height <= f4) {
            pos.y = height;
        }
    }

    public final boolean canMoveAllPosition(@NotNull PointF... positions) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        Logger.m7145d(TAG, "canMoveAllPosition# ");
        PointF pointF = this.mDelta;
        Intrinsics.checkNotNull(pointF);
        float f = pointF.x;
        PointF pointF2 = this.mDelta;
        Intrinsics.checkNotNull(pointF2);
        applyOffsetToPositions(f, pointF2.y, (PointF[]) Arrays.copyOf(positions, positions.length));
        boolean zCanMoveVertical = canMoveVertical((PointF[]) Arrays.copyOf(positions, positions.length));
        boolean zCanMoveHorizontal = canMoveHorizontal((PointF[]) Arrays.copyOf(positions, positions.length));
        if (zCanMoveVertical && zCanMoveHorizontal) {
            PointF pointF3 = this.mDelta;
            Intrinsics.checkNotNull(pointF3);
            pointF3.y = 0.0f;
            PointF pointF4 = this.mDelta;
            Intrinsics.checkNotNull(pointF4);
            PointF pointF5 = this.mDelta;
            Intrinsics.checkNotNull(pointF5);
            pointF4.x = pointF5.y;
        } else if (zCanMoveVertical) {
            PointF pointF6 = this.mDelta;
            Intrinsics.checkNotNull(pointF6);
            pointF6.x = 0.0f;
        } else {
            if (!zCanMoveHorizontal) {
                return false;
            }
            PointF pointF7 = this.mDelta;
            Intrinsics.checkNotNull(pointF7);
            pointF7.y = 0.0f;
        }
        PointF pointF8 = this.mDelta;
        Intrinsics.checkNotNull(pointF8);
        float f4 = -pointF8.x;
        PointF pointF9 = this.mDelta;
        Intrinsics.checkNotNull(pointF9);
        applyOffsetToPositions(f4, -pointF9.y, (PointF[]) Arrays.copyOf(positions, positions.length));
        return true;
    }

    public final boolean canMoveLine(int targetIdx, @NotNull PointF[] dstPos) {
        Intrinsics.checkNotNullParameter(dstPos, "dstPos");
        if (!canMoveAllPosition(dstPos[targetIdx], dstPos[(targetIdx + 1) % dstPos.length])) {
            Logger.m7145d(TAG, "canMoveLine# can not move any directions");
            return false;
        }
        if (!isLineOverlapped(dstPos, this.mHandlerSize)) {
            return isLineConvexShape(targetIdx, dstPos);
        }
        Logger.m7145d(TAG, "canMoveLine# isLineOverlapped");
        return false;
    }

    public final boolean canMovePosition(int targetIdx, @NotNull PointF startPos, @NotNull PointF dstPos, @NotNull PointF[] curPosList) {
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(dstPos, "dstPos");
        Intrinsics.checkNotNullParameter(curPosList, "curPosList");
        PointF pointF = this.mDelta;
        Intrinsics.checkNotNull(pointF);
        float f = pointF.x;
        PointF pointF2 = this.mDelta;
        Intrinsics.checkNotNull(pointF2);
        dstPos.offset(f, pointF2.y);
        setHandlerConvexShape(targetIdx, getStartPosIfParallel(targetIdx, startPos, dstPos, curPosList), dstPos, curPosList);
        setHandlerNotOverlapped(targetIdx, dstPos, curPosList, this.mHandlerSize);
        setHandlerPositionedInBounds(dstPos);
        curPosList[targetIdx] = dstPos;
        return isConvexShape(curPosList);
    }

    public final void deInitScanLibrary() {
        SmartScanRectifyWrapper.INSTANCE.deInitialize();
    }

    @Nullable
    public final synchronized DocScanData getDocScanData() {
        return this.mDocScanData;
    }

    @Nullable
    public final String getImagePath() {
        return this.mImageInfo.getImagePath();
    }

    public final int getNumOfAngle() {
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        return docScanData.getNumOfAngle();
    }

    @Nullable
    public final PointF[] getPreviousVertexes() {
        return this.previousVertexes;
    }

    @NotNull
    public final PointF getRatioFromRealPosition(@NotNull PointF pos) {
        Intrinsics.checkNotNullParameter(pos, "pos");
        return RectifyUtil.INSTANCE.getRatioFromRealPosition(pos, this.mImageInfo.getX(), this.mImageInfo.getY(), this.mImageInfo.getWidth(), this.mImageInfo.getHeight(), this.mInterpolation);
    }

    @NotNull
    public final PointF[] getRealPositionListFromRatio() {
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        PointF[] pointFArr = new PointF[docScanData.getNumOfAngle()];
        DocScanData docScanData2 = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData2);
        int numOfAngle = docScanData2.getNumOfAngle();
        for (int i = 0; i < numOfAngle; i++) {
            RectifyUtil rectifyUtil = RectifyUtil.INSTANCE;
            DocScanData docScanData3 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData3);
            pointFArr[i] = rectifyUtil.getRealPositionFromRatio(docScanData3.getVertex(i), this.mImageInfo.getX(), this.mImageInfo.getY(), this.mImageInfo.getWidth(), this.mImageInfo.getHeight(), this.mInterpolation);
        }
        return pointFArr;
    }

    public final int getTouchedObject(@NotNull PointF touchPos, @NotNull PointF[] curPosList) {
        Intrinsics.checkNotNullParameter(touchPos, "touchPos");
        Intrinsics.checkNotNullParameter(curPosList, "curPosList");
        PointF[] pointFArr = (PointF[]) curPosList.clone();
        float f = this.mInterpolation;
        applyOffsetToPositions(f, f, (PointF[]) Arrays.copyOf(pointFArr, pointFArr.length));
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        int numOfAngle = docScanData.getNumOfAngle();
        float f4 = -1.0f;
        int i = 0;
        int i2 = -1;
        float f5 = -1.0f;
        for (int i4 = 0; i4 < numOfAngle; i4++) {
            RectifyUtil rectifyUtil = RectifyUtil.INSTANCE;
            if (rectifyUtil.isOverlappedWithTouchPos(i4, touchPos, pointFArr, this.mInterpolation)) {
                float distance = rectifyUtil.getDistance(touchPos, pointFArr[i4]);
                if (f5 < 0.0f || distance < f5) {
                    i2 = i4;
                    f5 = distance;
                }
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        DocScanData docScanData2 = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData2);
        int numOfAngle2 = docScanData2.getNumOfAngle();
        int numOfAngle3 = -1;
        while (i < numOfAngle2) {
            PointF pointF = pointFArr[i];
            int i5 = i + 1;
            DocScanData docScanData3 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData3);
            PointF pointF2 = pointFArr[i5 % docScanData3.getNumOfAngle()];
            RectifyUtil rectifyUtil2 = RectifyUtil.INSTANCE;
            if (rectifyUtil2.isOverlappedOnLine(touchPos, pointF, pointF2, this.mInterpolation)) {
                float distance2 = rectifyUtil2.getDistance(touchPos, new Pair<>(pointF, pointF2));
                if (f4 < 0.0f || distance2 < f4) {
                    DocScanData docScanData4 = this.mDocScanData;
                    Intrinsics.checkNotNull(docScanData4);
                    numOfAngle3 = docScanData4.getNumOfAngle() + i;
                    f4 = distance2;
                }
            }
            i = i5;
        }
        return numOfAngle3 >= 0 ? numOfAngle3 : isTouchedInsideOfRectifyArea(touchPos, pointFArr) ? -1 : -2;
    }

    @NotNull
    public final PointF getVertex(int idx) {
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        return docScanData.getVertex(idx);
    }

    public final void initScanLibrary() {
        SmartScanRectifyWrapper.INSTANCE.initialize();
    }

    public final void removeSavedCacheFile() {
        try {
            Logger.m7145d(TAG, "removeSavedCacheFile# ");
            DocScanData docScanData = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData);
            String editingPath = docScanData.getEditingPath();
            FileUtils.deleteFile(editingPath != null ? new File(editingPath) : null);
            DocScanData docScanData2 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData2);
            String pathToSave = docScanData2.getPathToSave();
            FileUtils.deleteFile(pathToSave != null ? new File(pathToSave) : null);
            DocScanData docScanData3 = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData3);
            String thumbnailPath = docScanData3.getThumbnailPath();
            FileUtils.deleteFile(thumbnailPath != null ? new File(thumbnailPath) : null);
        } catch (Exception e) {
            Logger.m7146e(TAG, "removeSavedCacheFile#" + e.getMessage());
        }
    }

    public final synchronized void resetVertexes() {
        PointF[] pointFArr = this.previousVertexes;
        if (pointFArr == null) {
            return;
        }
        Intrinsics.checkNotNull(pointFArr);
        int length = pointFArr.length;
        for (int i = 0; i < length; i++) {
            DocScanData docScanData = this.mDocScanData;
            Intrinsics.checkNotNull(docScanData);
            PointF[] pointFArr2 = this.previousVertexes;
            Intrinsics.checkNotNull(pointFArr2);
            PointF pointF = pointFArr2[i];
            Intrinsics.checkNotNull(pointF);
            float f = pointF.x;
            PointF[] pointFArr3 = this.previousVertexes;
            Intrinsics.checkNotNull(pointFArr3);
            PointF pointF2 = pointFArr3[i];
            Intrinsics.checkNotNull(pointF2);
            docScanData.setVertex(i, new PointF(f, pointF2.y));
        }
    }

    @Nullable
    public final Bitmap saveRectifiedImageFromCamera() {
        Logger.m7145d(TAG, "saveRectifiedImageFromCamera");
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        Bitmap scanBitmap = docScanData.getScanBitmap();
        Bitmap bitmapSaveRectifiedImageToFile = saveRectifiedImageToFile(scanBitmap);
        if (bitmapSaveRectifiedImageToFile == null) {
            Logger.m7146e(TAG, "saveRectifiedImageFromCamera# saveRectifiedImageToFile fail");
            return null;
        }
        DocScanData docScanData2 = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData2);
        String editingPath = docScanData2.getEditingPath();
        File file = editingPath != null ? new File(editingPath) : null;
        boolean zMakeJpg = ImageUtils.makeJpg(scanBitmap, file, 100);
        if (!zMakeJpg) {
            try {
                FileUtils.deleteFile(file);
            } catch (IOException e) {
                Logger.m7146e(TAG, "saveRectifiedImageFromCamera# fail to delete editFile: " + e.getMessage());
            }
        }
        Intrinsics.checkNotNull(file);
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        Logger.m7148i(TAG, "saveRectifiedImageFromCamera# makeJpg : " + zMakeJpg + ", filePath : " + Logger.getEncode(path));
        DocScanData docScanData3 = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData3);
        docScanData3.setScanBitmap(null);
        return bitmapSaveRectifiedImageToFile;
    }

    @Nullable
    public final Bitmap saveRectifiedImageFromList() {
        Logger.m7145d(TAG, "saveRectifiedImageFromList");
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        if (Intrinsics.areEqual(docScanData.getPathToSave(), getImagePath())) {
            try {
                DocScanData docScanData2 = this.mDocScanData;
                Intrinsics.checkNotNull(docScanData2);
                String pathToSave = docScanData2.getPathToSave();
                File file = pathToSave != null ? new File(pathToSave) : null;
                DocScanData docScanData3 = this.mDocScanData;
                Intrinsics.checkNotNull(docScanData3);
                String editingPath = docScanData3.getEditingPath();
                FileUtils.copyFile(file, editingPath != null ? new File(editingPath) : null);
            } catch (IOException unused) {
                DocScanData docScanData4 = this.mDocScanData;
                Intrinsics.checkNotNull(docScanData4);
                String editingPath2 = docScanData4.getEditingPath();
                Intrinsics.checkNotNull(editingPath2);
                Logger.m7146e(TAG, "saveRectifiedImageFromList# copyFile failed - IOException. path:" + Logger.getEncode(editingPath2));
            }
        }
        DocScanData docScanData5 = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData5);
        return saveRectifiedImageToFile(DocScanUtils.getBitmapImageFromPath(docScanData5.getEditingPath()));
    }

    public final void saveRectifiedThumbnail(@Nullable Bitmap rectifiedBitmap) {
        Resources resources;
        if (rectifiedBitmap == null) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Integer numValueOf = (applicationContext == null || (resources = applicationContext.getResources()) == null) ? null : Integer.valueOf(resources.getDimensionPixelSize(C7976R.dimen.rectified_image_thumbnail_item_size));
        Logger.m7148i(TAG, "saveRectifiedThumbnail");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        options.inJustDecodeBounds = false;
        int width = rectifiedBitmap.getWidth();
        int height = rectifiedBitmap.getHeight();
        Matrix matrix = new Matrix();
        if (numValueOf != null) {
            matrix.setScale(numValueOf.intValue() / width, numValueOf.intValue() / height);
        }
        Intrinsics.checkNotNull(this.mDocScanData);
        matrix.postRotate(DocScanUtils.getOrientationFromPath(r0.getPathToSave()));
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rectifiedBitmap, 0, 0, width, height, matrix, false);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        DocScanData docScanData = this.mDocScanData;
        ImageUtils.makeJpg(bitmapCreateBitmap, String.valueOf(docScanData != null ? docScanData.getThumbnailPath() : null), 95, false);
    }

    public final void setDelta(@NotNull PointF touchedPos) {
        Intrinsics.checkNotNullParameter(touchedPos, "touchedPos");
        if (this.mLastTouch == null) {
            this.mLastTouch = new PointF();
        }
        PointF pointF = this.mDelta;
        if (pointF == null) {
            float f = touchedPos.x;
            PointF pointF2 = this.mLastTouch;
            Intrinsics.checkNotNull(pointF2);
            float f4 = f - pointF2.x;
            float f5 = touchedPos.y;
            PointF pointF3 = this.mLastTouch;
            Intrinsics.checkNotNull(pointF3);
            this.mDelta = new PointF(f4, f5 - pointF3.y);
        } else {
            Intrinsics.checkNotNull(pointF);
            float f6 = touchedPos.x;
            PointF pointF4 = this.mLastTouch;
            Intrinsics.checkNotNull(pointF4);
            float f7 = f6 - pointF4.x;
            float f8 = touchedPos.y;
            PointF pointF5 = this.mLastTouch;
            Intrinsics.checkNotNull(pointF5);
            pointF.set(f7, f8 - pointF5.y);
        }
        PointF pointF6 = this.mLastTouch;
        Intrinsics.checkNotNull(pointF6);
        pointF6.set(touchedPos);
    }

    public final synchronized void setDocScanData(@Nullable DocScanData docScanData) {
        Intrinsics.checkNotNull(docScanData);
        this.mDocScanData = docScanData;
        initPrevVertexes();
    }

    public final void setHandlerSize(float handlerSize) {
        this.mHandlerSize = handlerSize;
    }

    public final void setImageBitmap(@Nullable Bitmap bitmap) {
        this.mImageInfo.setBitmap(bitmap);
    }

    public final void setImageHeight(float height) {
        this.mImageInfo.setHeight(height);
    }

    public final void setImagePath(@Nullable String str) {
        this.mImageInfo.setImagePath(str);
    }

    public final void setImageWidth(float width) {
        this.mImageInfo.setWidth(width);
    }

    public final void setImageX(float x) {
        this.mImageInfo.setX(x);
    }

    public final void setImageY(float y2) {
        this.mImageInfo.setY(y2);
    }

    public final void setInterpolation(float interpolation) {
        this.mInterpolation = interpolation;
    }

    public final void setNumOfAngle(int i) {
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        docScanData.setNumOfAngle(i);
    }

    public final void setVertex(int idx, @Nullable PointF vertex) {
        DocScanData docScanData;
        if (vertex == null || (docScanData = this.mDocScanData) == null) {
            return;
        }
        docScanData.setVertex(idx, vertex);
    }

    public final synchronized void sortVertexList() {
        DocScanData docScanData = this.mDocScanData;
        Intrinsics.checkNotNull(docScanData);
        docScanData.sortVertexList();
    }
}
