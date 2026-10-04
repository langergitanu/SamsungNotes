package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.presenter.data;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.composer.view.zoomScroller.ISpenNoteZoomScroller;
import com.samsung.android.sdk.pen.document.SpenNoteDoc;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLine;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.document.SpenPageDoc;
import com.samsung.android.sdk.pen.document.shapeeffect.SpenLineColorEffect;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ShareFileProvider;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.p153ai.drawing.AiDrawingState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.PageSizeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.PageObjectsInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.p160hw.common.HwToolbarState;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingDataController {
    private static final String TAG = "AiDrawingDataController";
    private String mBaseFolderPath;
    private final ComposerViewPresenter mComposerViewPresenter;
    private ExecutorService mDataLoadExecutor;
    private int mHWObjectCount;
    private int mHandledColorCount;
    private final Handler mHandler;
    private Map<Integer, PageObjectsInfo> mPageObjectsInfos;
    private HwToolbarState mPrevHwToolbarState;
    private float mRestoreZoomScale;
    private RectF mResultHandledContentRect;
    private RectF mTargetContentRect;
    private RectF mTargetViewRect;
    private int mTotalObjectCount;
    private final String mUuid;
    private int mLowPriorityObjectType = 3;
    private SrcContentInfo mSrcContentInfo = new SrcContentInfo(-1);

    public AiDrawingDataController(Handler handler, ComposerViewPresenter composerViewPresenter) {
        this.mHandler = handler;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mUuid = composerViewPresenter.getComposerModel().getDocInfo().getUuid();
        initGenerateTheme();
    }

    private void adjustContentRectForSpenObject(RectF rectF) {
        resizeContentRectForSPenObject(rectF);
        updateContentRectAbovePages(rectF);
        updateContentRectInPage(rectF);
    }

    private ExecutorService getDataLoadExecutor() {
        if (this.mDataLoadExecutor == null) {
            this.mDataLoadExecutor = Executors.newFixedThreadPool(2, new SenlThreadFactory("AiDrawingDataController_DataLoad"));
        }
        return this.mDataLoadExecutor;
    }

    private SpenWPage getNextPage(SpenWNote spenWNote, int i) {
        int i2 = i + 1;
        StringBuilder sbM778t = AbstractC0541b.m778t(i2, "getNextPage, ", "/");
        sbM778t.append(spenWNote.getPageCount());
        Logger.m10999d(TAG, sbM778t.toString());
        if (i2 < spenWNote.getPageCount() - 1) {
            Logger.m10999d(TAG, "getNextPage, bound is not in targetPage, use next page");
            return spenWNote.getPage(i2);
        }
        Logger.m10999d(TAG, "getNextPage, bound is not in targetPage, add new page");
        return this.mComposerViewPresenter.getNoteManager().insertPage(i2);
    }

    private ISpenNoteZoomScroller getNoteZoomScroller() {
        return this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller();
    }

    private Map<Integer, PageObjectsInfo> getPageObjectInfos(ArrayList<SpenObjectBase> arrayList) {
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        HashMap map = new HashMap();
        for (int i = 0; i < arrayList.size(); i++) {
            SpenObjectBase spenObjectBase = arrayList.get(i);
            int objectPageIndex = getObjectPageIndex(doc, spenObjectBase);
            PageObjectsInfo pageObjectsInfo = (PageObjectsInfo) map.get(Integer.valueOf(objectPageIndex));
            if (pageObjectsInfo == null) {
                pageObjectsInfo = new PageObjectsInfo();
                pageObjectsInfo.setPageIndex(objectPageIndex);
                pageObjectsInfo.setContentRect(null);
            }
            pageObjectsInfo.getObjectInfos().add(Pair.create(spenObjectBase, Integer.valueOf(i)));
            map.put(Integer.valueOf(objectPageIndex), pageObjectsInfo);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLowPriorityObjects(SpenWNote spenWNote, int i, ArrayList<SpenObjectBase> arrayList, @Nullable RectF rectF, String str) {
        if (Features.isCreativeStudioSupported()) {
            removeLowPriorityObjects(spenWNote, i, arrayList, rectF, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleUnsupportedObjects(ArrayList<SpenObjectBase> arrayList, String str) {
        if (AiDrawingUtil.hasUnsupportedObjects(arrayList)) {
            removeUnsupportedObjects(arrayList, str);
        }
    }

    private void initGenerateTheme() {
        AiDrawingUtil.initImageStyleList(this.mComposerViewPresenter.getActivity());
        this.mSrcContentInfo.setGenerateTheme(AiDrawingUtil.getLastUsedGenerateTheme());
        Logger.m10999d(TAG, "initImageStyle, generateTheme: " + this.mSrcContentInfo.getGenerateStyle());
    }

    private boolean isIgnoreSPenObjectsImageContents() {
        return !isViewInitState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSPenObjectsFile$2(String str, int i, Runnable runnable) {
        loadSPenObjectsFile(str, i + 1, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSPenObjectsFile$3(int i, Runnable runnable, String str) {
        if (makeInputSpdFile()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (6 >= i) {
            this.mHandler.postDelayed(new RunnableC9382a(this, str, i, runnable, 0), 50L);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSPenObjectsImageContents$0(String str, int i, Runnable runnable) {
        loadSPenObjectsImageContents(str, i + 1, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadSPenObjectsImageContents$1(int i, Runnable runnable, String str) {
        ArrayList arrayList = (ArrayList) this.mComposerViewPresenter.getObjectManager().getSelectedObjectList();
        if (AiDrawingUtil.hasUnsupportedObjects(arrayList)) {
            AiDrawingUtil.removeUnsupportedObjects(arrayList, "loadSPenObjectsImageContents");
        }
        if (arrayList.isEmpty()) {
            Logger.m11004w(TAG, "loadSPenObjectsImageContents, tryCount: " + i + ", failed, selected object is empty");
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        AbstractC0000a.m3D(i, "loadSPenObjectsImageContents, tryCount: ", TAG);
        RectF boundFromObjects = AiDrawingUtil.getBoundFromObjects(this.mComposerViewPresenter.getDoc(), arrayList);
        adjustContentRectForSpenObject(boundFromObjects);
        if (makeInputImageBitmap(boundFromObjects)) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (6 >= i) {
            this.mHandler.postDelayed(new RunnableC9382a(this, str, i, runnable, 1), 50L);
        } else if (runnable != null) {
            runnable.run();
        }
    }

    private boolean makeInputImageBitmap(RectF rectF) {
        if (this.mComposerViewPresenter.getObjectManager().getSelectedObjectList().isEmpty()) {
            Logger.m11004w(TAG, "makeInputImageBitmap# there is no selected object");
            return false;
        }
        RectF selectedRect = this.mComposerViewPresenter.getObjectManager().getSelectedRect();
        float fWidth = selectedRect.width();
        float fHeight = selectedRect.height();
        if (fWidth <= 0.0f || fHeight <= 0.0f) {
            return false;
        }
        Rect windowSize = DisplayUtils.getWindowSize(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getConfiguration());
        int iMin = Math.min((int) Math.max(fWidth, fHeight), Math.min(windowSize.width(), windowSize.height()));
        StringBuilder sbM1176v = AbstractC0622a.m1176v("makeInputImageBitmap# selected object width : ", fWidth, ", height : ", fHeight, ", windowSize : ");
        sbM1176v.append(windowSize);
        sbM1176v.append(", targetSize : ");
        sbM1176v.append(iMin);
        Logger.m10999d(TAG, sbM1176v.toString());
        float f = fWidth > fHeight ? iMin / fWidth : iMin / fHeight;
        Logger.m10999d(TAG, "makeInputImageBitmap# before load scaledBitmap");
        Bitmap selectedData = this.mComposerViewPresenter.getObjectManager().getSelectedData(f, f);
        Bitmap bitmapCopy = f == 1.0f ? selectedData.copy(selectedData.getConfig(), true) : this.mComposerViewPresenter.getObjectManager().getSelectedData();
        Logger.m10999d(TAG, "makeInputImageBitmap# after load scaledBitmap");
        Bitmap scaledImage = AiDrawingUtil.getScaledImage(selectedData, iMin, iMin, shouldUseImageInputFileForCreativeStudio() ? 1.0f : 0.0f);
        Bitmap scaledImage2 = AiDrawingUtil.getScaledImage(bitmapCopy, rectF, shouldUseImageInputFileForCreativeStudio() ? 1.0f : 0.0f);
        try {
            selectedData.recycle();
            bitmapCopy.recycle();
        } catch (NullPointerException e) {
            Logger.m11000e(TAG, "makeInputImageBitmap, e: " + e.getMessage());
        }
        String inputFilePath = getInputFilePath();
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
        ImageUtil.saveBitmapToFileCache(scaledImage, inputFilePath, compressFormat, 100, 0, true);
        ImageUtil.saveBitmapToFileCache(scaledImage2, getOriginalFilePath(), compressFormat, 95, 0, true);
        Logger.m10999d(TAG, "makeInputImageBitmap# finalBitmap width : " + scaledImage.getWidth() + ", height : " + scaledImage.getHeight() + ", fileSize: " + FileUtils.getFileSize(inputFilePath));
        scaledImage.recycle();
        scaledImage2.recycle();
        return true;
    }

    private boolean makeInputSpdFile() {
        String inputSpdFilePath = getInputSpdFilePath();
        Logger.m11004w(TAG, "makeInputSpdFile, start, " + Logger.getEncode(inputSpdFilePath));
        ArrayList<SpenObjectBase> arrayList = (ArrayList) this.mComposerViewPresenter.getObjectManager().getSelectedObjectList();
        if (AiDrawingUtil.hasUnsupportedObjects(arrayList)) {
            AiDrawingUtil.removeUnsupportedObjects(arrayList, "makeInputSpdFile");
        }
        RectF boundFromObjects = AiDrawingUtil.getBoundFromObjects(this.mComposerViewPresenter.getDoc(), arrayList);
        boolean zIsFileExists = false;
        try {
            int iMax = (int) Math.max(32.0f, Math.max(boundFromObjects.width(), boundFromObjects.height()));
            SpenNoteDoc spenNoteDoc = new SpenNoteDoc(this.mComposerViewPresenter.getActivity(), iMax, iMax);
            SpenPageDoc spenPageDocAppendPage = spenNoteDoc.appendPage();
            if (spenPageDocAppendPage != null) {
                spenPageDocAppendPage.copyNAppendObject(arrayList);
                float fM1155a = -boundFromObjects.left;
                float fM1155a2 = -boundFromObjects.top;
                if (boundFromObjects.width() < boundFromObjects.height()) {
                    fM1155a = AbstractC0622a.m1155a(boundFromObjects.height(), boundFromObjects.width(), 2.0f, fM1155a);
                } else {
                    fM1155a2 = AbstractC0622a.m1155a(boundFromObjects.width(), boundFromObjects.height(), 2.0f, fM1155a2);
                }
                spenPageDocAppendPage.moveAllObject(fM1155a, fM1155a2);
                ArrayList<SpenObjectBase> objectList = spenPageDocAppendPage.getObjectList();
                if (objectList != null) {
                    for (SpenObjectBase spenObjectBase : objectList) {
                        if (spenObjectBase instanceof SpenObjectStroke) {
                            ((SpenObjectStroke) spenObjectBase).setColor(-16777216);
                        } else if (spenObjectBase instanceof SpenObjectLine) {
                            SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
                            spenLineColorEffect.setSolidColor(-16777216);
                            ((SpenObjectLine) spenObjectBase).setLineColorEffect(spenLineColorEffect);
                        }
                    }
                }
            }
            spenNoteDoc.save(inputSpdFilePath, false);
            spenNoteDoc.close(true);
            zIsFileExists = FileUtils.isFileExists(inputSpdFilePath);
        } catch (IOException e) {
            AbstractC8014b.m7204f(e, new StringBuilder("makeInputSpdFile, "), TAG);
        }
        Logger.m11004w(TAG, "makeInputSpdFile, end, " + zIsFileExists);
        return zIsFileExists;
    }

    private void removeLowPriorityObjects(SpenWNote spenWNote, int i, ArrayList<SpenObjectBase> arrayList, @Nullable RectF rectF, String str) {
        Logger.m10999d(TAG, "removeLowPriorityObjects, caller: " + str + ", lowPriorityObject, remove objects with lower priority");
        this.mLowPriorityObjectType = AiDrawingUtil.removeLowPriorityObjects(spenWNote, i, arrayList, rectF, str);
    }

    private void removeUnsupportedObjects(ArrayList<SpenObjectBase> arrayList, String str) {
        if (AiDrawingUtil.hasUnsupportedObjects(arrayList)) {
            Logger.m10999d(TAG, "removeUnsupportedObjects, caller: " + str + ", unsupportedObject exist, clear and select supported object again");
            AiDrawingUtil.removeUnsupportedObjects(arrayList, str);
        }
    }

    private void resizeContentRectForSPenObject(@NonNull RectF rectF) {
        Logger.m10999d(TAG, "resizeContentRectForSPenObject, before rect: " + rectF + ", width: " + rectF.width() + ", height: " + rectF.height());
        float width = (float) (this.mComposerViewPresenter.getDoc().getWidth() >> 2);
        if (rectF.width() < width) {
            float fWidth = (width - rectF.width()) / 2.0f;
            rectF.left -= fWidth;
            rectF.right += fWidth;
        }
        if (rectF.height() < width) {
            float fHeight = (width - rectF.height()) / 2.0f;
            rectF.top -= fHeight;
            rectF.bottom += fHeight;
        }
        Logger.m10999d(TAG, "resizeContentRectForSPenObject, after rect: " + rectF + ", width: " + rectF.width() + ", height: " + rectF.height());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNoticeFromObjects(ArrayList<SpenObjectBase> arrayList) {
        if (AiDrawingUtil.hasHighlighterObjectsOnly(arrayList)) {
            showToast(C9086R.string.ai_drawing_can_not_use_sketch_to_image_with_highlighter);
        } else if (AiDrawingUtil.hasHighlighterObjects(arrayList)) {
            showToast(C9086R.string.f6716x928bc21f);
        }
    }

    private void showToast(@StringRes final int i) {
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.data.AiDrawingDataController.3
            @Override // java.lang.Runnable
            public void run() {
                ToastHandler.show(AiDrawingDataController.this.mComposerViewPresenter.getActivity(), i, 0);
            }
        });
    }

    private void updateContentRectAbovePages(@NonNull RectF rectF) {
        int maxIntersectPageIdxFromTargetRect = AiDrawingUtil.getMaxIntersectPageIdxFromTargetRect(this.mComposerViewPresenter.getDoc(), rectF);
        if (maxIntersectPageIdxFromTargetRect < 0) {
            Logger.m11004w(TAG, "updateTargetRectAbovePages, invalid targetPageIndex");
            return;
        }
        Logger.m10999d(TAG, "updateTargetRectAbovePages, before rect: " + rectF);
        int firstPageIndex = getFirstPageIndex(rectF);
        int lastPageIndex = getLastPageIndex(rectF);
        RectF pageBound = PageSizeUtil.getPageBound(this.mComposerViewPresenter.getDoc(), maxIntersectPageIdxFromTargetRect);
        boolean zIsTwoPage = this.mComposerViewPresenter.getComposerControllerManager().getCvPageSettingController().getPageLayoutState().isTwoPage();
        if (firstPageIndex + 1 == maxIntersectPageIdxFromTargetRect && maxIntersectPageIdxFromTargetRect == lastPageIndex) {
            if (zIsTwoPage) {
                float f = pageBound.left;
                float f4 = rectF.left;
                float f5 = f - f4;
                rectF.left = f4 + f5;
                rectF.right += f5;
            } else {
                float f6 = pageBound.top;
                float f7 = rectF.top;
                float f8 = f6 - f7;
                rectF.top = f7 + f8;
                rectF.bottom += f8;
            }
        } else if (maxIntersectPageIdxFromTargetRect == firstPageIndex && maxIntersectPageIdxFromTargetRect == lastPageIndex - 1) {
            if (zIsTwoPage) {
                float f9 = pageBound.right;
                float f10 = rectF.right;
                float f11 = f9 - f10;
                rectF.left += f11;
                rectF.right = f10 + f11;
            } else {
                float f12 = pageBound.bottom;
                float f13 = rectF.bottom;
                float f14 = f12 - f13;
                rectF.top += f14;
                rectF.bottom = f13 + f14;
            }
        } else if (firstPageIndex < maxIntersectPageIdxFromTargetRect && maxIntersectPageIdxFromTargetRect < lastPageIndex) {
            if (zIsTwoPage) {
                rectF.left = pageBound.left;
                rectF.right = pageBound.right;
            } else {
                rectF.top = pageBound.top;
                rectF.bottom = pageBound.bottom;
            }
        }
        Logger.m10999d(TAG, "updateTargetRectAbovePages, after rect: " + rectF);
    }

    private void updateContentRectInPage(@NonNull RectF rectF) {
        int maxIntersectPageIdxFromTargetRect = AiDrawingUtil.getMaxIntersectPageIdxFromTargetRect(this.mComposerViewPresenter.getDoc(), rectF);
        if (maxIntersectPageIdxFromTargetRect < 0) {
            Logger.m11004w(TAG, "updateContentRectInPage, invalid targetPageIndex");
            return;
        }
        int pageCount = this.mComposerViewPresenter.getDoc().getPageCount();
        if (maxIntersectPageIdxFromTargetRect != 0 && maxIntersectPageIdxFromTargetRect != pageCount - 1) {
            Logger.m11004w(TAG, "updateContentRectInPage, page index is not valid, targetPageIndex: " + maxIntersectPageIdxFromTargetRect + ", pageCount: " + pageCount);
            return;
        }
        Logger.m10999d(TAG, "updateContentRectInPage, before rect: " + rectF);
        RectF pageBound = PageSizeUtil.getPageBound(this.mComposerViewPresenter.getDoc(), maxIntersectPageIdxFromTargetRect);
        if (pageBound.width() < rectF.width()) {
            rectF.left = pageBound.left;
            rectF.right = pageBound.right;
        } else {
            float f = rectF.left;
            float f4 = pageBound.left;
            if (f < f4) {
                float f5 = f4 - f;
                rectF.left = f + f5;
                rectF.right = Math.min(pageBound.right, rectF.right + f5);
            }
            float f6 = pageBound.right;
            float f7 = rectF.right;
            if (f6 < f7) {
                float f8 = f7 - f6;
                rectF.left = Math.max(pageBound.left, rectF.left - f8);
                rectF.right -= f8;
            }
        }
        if (pageBound.height() < rectF.height()) {
            rectF.top = pageBound.top;
            rectF.bottom = pageBound.bottom;
        } else {
            float f9 = rectF.top;
            float f10 = pageBound.top;
            if (f9 < f10) {
                float f11 = f10 - f9;
                rectF.top = f9 + f11;
                rectF.bottom = Math.min(pageBound.bottom, rectF.bottom + f11);
            }
            float f12 = pageBound.bottom;
            float f13 = rectF.bottom;
            if (f12 < f13) {
                float f14 = f13 - f12;
                rectF.top = Math.max(pageBound.top, rectF.top - f14);
                rectF.bottom -= f14;
            }
        }
        Logger.m10999d(TAG, "updateContentRectInPage, after rect: " + rectF + ", pageBound: " + pageBound);
    }

    private void updateHandledColorCount() {
        HashSet hashSet = new HashSet();
        Iterator<PageObjectsInfo> it = getPageObjectsInfos().iterator();
        while (it.hasNext()) {
            for (Pair<SpenObjectBase, Integer> pair : it.next().getObjectInfos()) {
                if (1 == ((SpenObjectBase) pair.first).getType()) {
                    hashSet.add(Integer.valueOf(((SpenObjectStroke) pair.first).getColor()));
                } else if (8 == ((SpenObjectBase) pair.first).getType()) {
                    SpenObjectLine spenObjectLine = (SpenObjectLine) pair.first;
                    SpenLineColorEffect spenLineColorEffect = new SpenLineColorEffect();
                    spenObjectLine.getLineColorEffect(spenLineColorEffect);
                    hashSet.add(Integer.valueOf(spenLineColorEffect.getSolidColor()));
                } else if (((SpenObjectBase) pair.first).getType() == 7 && ((SpenObjectBase) pair.first).getExtraDataInt("extra_key_converted_type") != 1) {
                    SpenObjectShape spenObjectShape = (SpenObjectShape) pair.first;
                    SpenLineColorEffect spenLineColorEffect2 = new SpenLineColorEffect();
                    spenObjectShape.getLineColorEffect(spenLineColorEffect2);
                    hashSet.add(Integer.valueOf(spenLineColorEffect2.getSolidColor()));
                }
            }
        }
        this.mHandledColorCount = hashSet.size();
    }

    private void updateRectToSquare(RectF rectF) {
        if (rectF == null) {
            return;
        }
        if (rectF.width() < rectF.height()) {
            rectF.right = rectF.height() + rectF.left;
        } else {
            rectF.bottom = rectF.width() + rectF.top;
        }
    }

    public void addOutputFilePath() {
        List<String> outputFilePaths = this.mSrcContentInfo.getOutputFilePaths();
        if (outputFilePaths.isEmpty()) {
            return;
        }
        this.mSrcContentInfo.getOutputFilePaths().add(getOutputFilePath(getIndexFromFilePath((String) AbstractC0000a.m10g(outputFilePaths, 1)) + 1));
    }

    public RectF adjustRect(RectF rectF, Bitmap bitmap) {
        if (rectF == null || bitmap == null) {
            Logger.m10999d(TAG, "adjustRect# bound or resultImage is null");
            return rectF;
        }
        double dWidth = rectF.width();
        double dHeight = rectF.height();
        double width = bitmap.getWidth();
        double height = bitmap.getHeight();
        Logger.m10999d(TAG, "adjustRect# before objectWidth: " + dWidth + ", objectHeight: " + dHeight + ", resultWidth:" + width + ", resultHeight: " + height);
        RectF rectF2 = new RectF(rectF);
        if (width < height) {
            rectF2.right = (float) (((double) rectF2.right) - (dWidth - ((width * dWidth) / height)));
        } else {
            rectF2.bottom = (float) (((double) rectF2.bottom) - (dHeight - ((height * dHeight) / width)));
        }
        Logger.m10999d(TAG, "adjustRect# after objectWidth: " + dWidth + ", objectHeight: " + dHeight + ", adjustedWidth:" + rectF2.width() + ", adjustedHeight: " + rectF2.height());
        return rectF2;
    }

    public Bitmap adjustResultImage(RectF rectF, Bitmap bitmap) {
        Bitmap bitmapCreateBitmap;
        if (bitmap == null) {
            Logger.m10999d(TAG, "adjustResultImage, resultImage is null");
            return null;
        }
        double dWidth = rectF.width();
        double dHeight = rectF.height();
        double width = bitmap.getWidth();
        double height = bitmap.getHeight();
        Logger.m10999d(TAG, "adjustResultImage, before objectWidth: " + dWidth + ", objectHeight: " + dHeight + ", resultWidth:" + width + ", resultHeight: " + height);
        if (dWidth < dHeight) {
            double dMin = Math.min((height * dWidth) / dHeight, width);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, Math.abs((int) ((dMin - width) / 2.0d)), 0, (int) dMin, (int) height);
        } else {
            double dMin2 = Math.min((width * dHeight) / dWidth, height);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, Math.abs((int) ((dMin2 - height) / 2.0d)), (int) width, (int) dMin2);
        }
        Logger.m10999d(TAG, "adjustResultImage, after objectWidth: " + dWidth + ", objectHeight: " + dHeight + ", adjustedWidth:" + bitmapCreateBitmap.getWidth() + ", adjustedHeight: " + bitmapCreateBitmap.getHeight());
        return bitmapCreateBitmap;
    }

    public RectF calculateContentRectForSpenObjects() {
        RectF objectSelectionRect = getObjectSelectionRect();
        adjustContentRectForSpenObject(objectSelectionRect);
        return objectSelectionRect;
    }

    public RectF convertContentRectIntoViewRect(RectF rectF) {
        return getNoteZoomScroller().convertContentRectIntoViewRect(rectF);
    }

    public RectF convertViewRectIntoContentRect(RectF rectF) {
        return getNoteZoomScroller().convertViewRectIntoContentRect(rectF);
    }

    public void deleteDrawingFiles() {
        FileUtils.deleteFile(getOriginalFilePath());
        FileUtils.deleteFile(getInputFilePath());
        FileUtils.deleteFile(getInputSpdFilePath());
        deleteDrawingOutputFiles();
    }

    public void deleteDrawingOutputFiles() {
        for (int i = 0; i < 10; i++) {
            FileUtils.deleteFile(getOutputFilePath(i));
        }
    }

    public RectF getContentRectInView() {
        return getNoteZoomScroller().getContentRectInView();
    }

    public int getFirstPageIndex(RectF rectF) {
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        int pageCount = doc.getPageCount();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < pageCount; i2++) {
            if (PageSizeUtil.getPageBound(doc, i2).intersect(rectF) && i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    public String getGenerateTheme() {
        String generateStyle = this.mSrcContentInfo.getGenerateStyle();
        AbstractC8014b.m7196B("getGenerateTheme, generateTheme: ", generateStyle, TAG);
        return generateStyle;
    }

    public int getHandledColorCount() {
        return this.mHandledColorCount;
    }

    @NonNull
    public Map<Integer, ArrayList<SpenObjectBase>> getHandledObjectInfos() {
        HashMap map = new HashMap();
        for (PageObjectsInfo pageObjectsInfo : getPageObjectsInfos()) {
            ArrayList arrayList = new ArrayList();
            Iterator<Pair<SpenObjectBase, Integer>> it = pageObjectsInfo.getObjectInfos().iterator();
            while (it.hasNext()) {
                arrayList.add((SpenObjectBase) it.next().first);
            }
            map.put(Integer.valueOf(pageObjectsInfo.getPageIndex()), arrayList);
        }
        return map;
    }

    public ArrayList<SpenObjectBase> getHandledObjects() {
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>();
        Iterator<PageObjectsInfo> it = getPageObjectsInfos().iterator();
        while (it.hasNext()) {
            Iterator<Pair<SpenObjectBase, Integer>> it2 = it.next().getObjectInfos().iterator();
            while (it2.hasNext()) {
                arrayList.add((SpenObjectBase) it2.next().first);
            }
        }
        return arrayList;
    }

    public int getIndexFromFilePath(String str) {
        return Integer.parseInt(str.substring(str.lastIndexOf(95) + 1, str.lastIndexOf(46)));
    }

    public String getInputFilePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mBaseFolderPath);
        sb.append(Constant.AI_DRAWING_INPUT_FILE_PREFIX);
        return AbstractC0622a.m1170p(this.mUuid, ".png", sb);
    }

    public Uri getInputImageFileUri() {
        return ShareFileProvider.getUri(BaseUtils.getContext(), getInputFilePath());
    }

    public String getInputSpdFilePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mBaseFolderPath);
        sb.append(Constant.AI_DRAWING_INPUT_FILE_PREFIX);
        return AbstractC0622a.m1170p(this.mUuid, ".spd", sb);
    }

    public Uri getInputSpdFileUri() {
        return ShareFileProvider.getUri(BaseUtils.getContext(), getInputSpdFilePath());
    }

    public int getLastPageIndex(RectF rectF) {
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        int pageCount = doc.getPageCount();
        int i = -1;
        for (int i2 = 0; i2 < pageCount; i2++) {
            if (PageSizeUtil.getPageBound(doc, i2).intersect(rectF) && i < i2) {
                i = i2;
            }
        }
        return i;
    }

    public int getObjectPageIndex(SpenWNote spenWNote, SpenObjectBase spenObjectBase) {
        ArrayList<SpenWPage> pageList = spenWNote.getPageList();
        for (int i = 0; i < pageList.size(); i++) {
            SpenWPage spenWPage = pageList.get(i);
            if (spenWPage.isObjectContained(spenObjectBase)) {
                return spenWNote.getPageIndex(spenWPage);
            }
        }
        return -1;
    }

    public RectF getObjectPasteRect(String str) {
        return getObjectPasteRectForSketchToImage(str);
    }

    public RectF getObjectPasteRectForSketchToImage(String str) {
        RectF targetContentRect = getTargetContentRect();
        updateRectToSquare(targetContentRect);
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        int maxIntersectPageIdxFromTargetRect = AiDrawingUtil.getMaxIntersectPageIdxFromTargetRect(doc, targetContentRect);
        if (targetContentRect != null && doc.getPageCount() > maxIntersectPageIdxFromTargetRect && maxIntersectPageIdxFromTargetRect >= 0) {
            RectF pageBound = PageSizeUtil.getPageBound(doc, maxIntersectPageIdxFromTargetRect);
            float fWidth = targetContentRect.width();
            float dimension = BaseUtils.getApplicationContext().getResources().getDimension(C9086R.dimen.ai_drawing_result_paste_margin);
            float f = targetContentRect.right;
            if (f + fWidth < pageBound.right) {
                targetContentRect.left += fWidth;
                targetContentRect.right = f + fWidth;
                return targetContentRect;
            }
            if (targetContentRect.bottom + fWidth + dimension >= pageBound.bottom && !this.mComposerViewPresenter.getWritingToolManager().isSinglePageMode()) {
                RectF pageBound2 = PageSizeUtil.getPageBound(getNextPage(doc, maxIntersectPageIdxFromTargetRect));
                float f4 = fWidth / 2.0f;
                targetContentRect.left = (pageBound2.centerX() - f4) + dimension;
                targetContentRect.right = pageBound2.centerX() + f4 + dimension;
                targetContentRect.top = pageBound2.top + dimension;
                targetContentRect.bottom = pageBound2.top + fWidth + dimension;
                return targetContentRect;
            }
            float f5 = fWidth / 2.0f;
            targetContentRect.left = (pageBound.centerX() - f5) + dimension;
            targetContentRect.right = pageBound.centerX() + f5 + dimension;
            float f6 = targetContentRect.bottom;
            targetContentRect.top = f6 + dimension;
            targetContentRect.bottom = f6 + fWidth + dimension;
        }
        return targetContentRect;
    }

    public RectF getObjectReplaceRect() {
        RectF targetContentRect = getTargetContentRect();
        updateRectToSquare(targetContentRect);
        return targetContentRect;
    }

    public RectF getObjectSelectionRect() {
        return AiDrawingUtil.getRectFromPageObjectsInfos(this.mComposerViewPresenter.getDoc(), getPageObjectsInfos());
    }

    public String getOriginalFilePath() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.mBaseFolderPath);
        sb.append(Constant.AI_DRAWING_ORIGINAL_FILE_PREFIX);
        return AbstractC0622a.m1170p(this.mUuid, ".png", sb);
    }

    public String getOutputFilePath(int i) {
        return this.mBaseFolderPath + Constant.AI_DRAWING_OUTPUT_FILE_PREFIX + this.mUuid + "_" + i + ".png";
    }

    public List<String> getOutputFilePaths() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < AiDrawingUtil.getGeneratingImageCount(); i++) {
            arrayList.add(getOutputFilePath(i));
        }
        return arrayList;
    }

    public Collection<PageObjectsInfo> getPageObjectsInfos() {
        Map<Integer, PageObjectsInfo> map = this.mPageObjectsInfos;
        return map == null ? Collections.EMPTY_LIST : map.values();
    }

    public HwToolbarState getPrevHwToolbarState() {
        return this.mPrevHwToolbarState;
    }

    public SrcContentInfo getSrcContentInfo() {
        this.mSrcContentInfo.setSrcType(3);
        return this.mSrcContentInfo;
    }

    public AiDrawingState getState() {
        return this.mComposerViewPresenter.getComposerModel().getAiDrawingState();
    }

    public RectF getTargetContentRect() {
        return this.mTargetContentRect;
    }

    public RectF getTargetViewRect() {
        if (this.mTargetViewRect == null) {
            updateTargetViewRect("getTargetViewRect");
        }
        return this.mTargetViewRect;
    }

    public float getZoomScale() {
        return getNoteZoomScroller().getZoomScale();
    }

    public boolean hasSupportedObjects() {
        return hasSupportedObjects(new ArrayList<>(this.mComposerViewPresenter.getObjectManager().getSelectedObjectList()));
    }

    public void init() {
        initBaseFolderPath();
        releaseData();
        releaseSrcContentInfo();
    }

    public void initBaseFolderPath() {
        if (BaseUtils.getApplicationContext() == null) {
            Logger.m11000e(TAG, "initBaseFolderPath, context is null");
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(ShareFileProvider.getShareDir(BaseUtils.getApplicationContext()).getCanonicalPath());
            String str = File.separator;
            sb.append(str);
            sb.append("ai_drawing");
            sb.append(str);
            String string = sb.toString();
            this.mBaseFolderPath = string;
            FileUtils.makeDirectory(string);
        } catch (IOException e) {
            Logger.m10999d(TAG, "initBaseFolderPath, e: " + e.getMessage());
        }
        SrcContentInfo srcContentInfo = this.mSrcContentInfo;
        if (srcContentInfo != null) {
            srcContentInfo.setInputFilePath(getInputFilePath()).setOutputFilePaths(getOutputFilePaths());
        }
    }

    public void initRestoreZoomScrollInfo() {
        this.mRestoreZoomScale = getZoomScale();
    }

    public boolean isDataLoaded() {
        return FileUtils.isFileExists(getInputFilePath()) || FileUtils.isFileExists(getInputSpdFilePath());
    }

    public boolean isFinishedState() {
        return AiDrawingState.FINISHED.equals(getState());
    }

    public boolean isGuideState() {
        return AiDrawingState.GUIDE.equals(getState());
    }

    public boolean isNoneState() {
        return AiDrawingState.NONE.equals(getState());
    }

    public boolean isReadyState() {
        return AiDrawingState.READY.equals(getState());
    }

    public boolean isRunningState() {
        return AiDrawingState.RUNNING.equals(getState());
    }

    public boolean isViewInitState() {
        return AiDrawingState.VIEW_INIT.equals(getState());
    }

    public void loadObjectInfos(final ArrayList<SpenObjectBase> arrayList, final Runnable runnable, final Runnable runnable2, final String str) {
        getDataLoadExecutor().execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.data.AiDrawingDataController.1
            @Override // java.lang.Runnable
            public void run() {
                if (AiDrawingDataController.this.loadObjectInfos(arrayList, str)) {
                    if (runnable != null) {
                        AiDrawingDataController.this.mHandler.post(runnable);
                    }
                } else {
                    AiDrawingDataController.this.mComposerViewPresenter.getObjectManager().clearSelection();
                    if (runnable2 != null) {
                        AiDrawingDataController.this.mHandler.post(runnable2);
                    }
                }
            }
        });
    }

    public void loadSPenObjectsFile(String str, int i, Runnable runnable) {
        Logger.m10999d(TAG, "loadSPenObjectsFile, caller: " + str);
        deleteDrawingFiles();
        if (!isIgnoreSPenObjectsImageContents()) {
            getDataLoadExecutor().execute(new RunnableC9382a(this, i, runnable, str, 2));
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void loadSPenObjectsImageContents(String str, int i, Runnable runnable) {
        Logger.m10999d(TAG, "loadSPenObjectsImageContents, caller: " + str);
        deleteDrawingFiles();
        if (!isIgnoreSPenObjectsImageContents()) {
            getDataLoadExecutor().execute(new RunnableC9382a(this, i, runnable, str, 3));
        } else if (runnable != null) {
            runnable.run();
        }
    }

    public void loadSpenObjectContents(final SpenWNote spenWNote, final int i, final ArrayList<SpenObjectBase> arrayList, @Nullable final RectF rectF, final Runnable runnable, final String str) {
        getDataLoadExecutor().execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.data.AiDrawingDataController.2
            @Override // java.lang.Runnable
            public void run() {
                AiDrawingDataController.this.showNoticeFromObjects(arrayList);
                AiDrawingDataController.this.handleUnsupportedObjects(arrayList, "handleUnsupportedObjects, caller: " + str);
                AiDrawingDataController.this.handleLowPriorityObjects(spenWNote, i, arrayList, rectF, "handleLowPriorityObjects, caller: " + str);
                AiDrawingDataController.this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.drawing.presenter.data.AiDrawingDataController.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AiDrawingDataController.this.mComposerViewPresenter.getObjectManager().selectObjectList(arrayList);
                        AiDrawingDataController.this.mHandler.post(runnable);
                    }
                });
            }
        });
    }

    public void releaseData() {
        deleteDrawingFiles();
        releasePageObjectsInfos();
        releaseTargetViewRect();
        releaseTargetContentRect();
    }

    public void releaseDataLoadExecutor() {
        ExecutorService executorService = this.mDataLoadExecutor;
        if (executorService != null) {
            executorService.shutdown();
            this.mDataLoadExecutor = null;
        }
    }

    public void releasePageObjectsInfos() {
        Map<Integer, PageObjectsInfo> map = this.mPageObjectsInfos;
        if (map != null) {
            map.clear();
        }
        this.mPageObjectsInfos = null;
    }

    public void releasePrevHwToolbarState() {
        setPrevHwToolbarState(null);
    }

    public void releaseSrcContentInfo() {
        this.mSrcContentInfo.getOutputFilePaths().clear();
        this.mSrcContentInfo.setInputFilePath(getInputFilePath()).setOutputFilePaths(getOutputFilePaths());
    }

    public void releaseTargetContentRect() {
        this.mTargetContentRect = null;
    }

    public void releaseTargetViewRect() {
        this.mTargetViewRect = null;
    }

    public void removeLastFilePath() {
        List<String> outputFilePaths = this.mSrcContentInfo.getOutputFilePaths();
        if (outputFilePaths.isEmpty()) {
            return;
        }
        outputFilePaths.remove(outputFilePaths.size() - 1);
    }

    public void removeOldFile() {
        List<String> outputFilePaths = this.mSrcContentInfo.getOutputFilePaths();
        if (outputFilePaths.isEmpty()) {
            return;
        }
        new File(outputFilePaths.remove(0)).delete();
    }

    public void restoreInstanceState(Bundle bundle) {
        this.mRestoreZoomScale = bundle.getFloat(Constant.KEY_AI_DRAWING_RESTORE_ZOOM_SCALE);
        this.mResultHandledContentRect = (RectF) bundle.getParcelable(Constant.KEY_AI_DRAWING_RESULT_HANDLED_CONTENT_RECT);
        this.mPrevHwToolbarState = (HwToolbarState) bundle.getParcelable(Constant.KEY_AI_DRAWING_PREV_HW_SELECTION_STATE);
        this.mSrcContentInfo = (SrcContentInfo) bundle.getParcelable(Constant.KEY_AI_DRAWING_SRC_CONTENT_INFO);
        this.mTotalObjectCount = bundle.getInt(Constant.KEY_AI_DRAWING_TOTAL_OBJECT_COUNT, 0);
        this.mHWObjectCount = bundle.getInt(Constant.KEY_AI_DRAWING_HW_OBJECT_COUNT, 0);
    }

    public void saveInstanceState(Bundle bundle) {
        bundle.putFloat(Constant.KEY_AI_DRAWING_RESTORE_ZOOM_SCALE, this.mRestoreZoomScale);
        bundle.putParcelable(Constant.KEY_AI_DRAWING_RESULT_HANDLED_CONTENT_RECT, this.mResultHandledContentRect);
        bundle.putParcelable(Constant.KEY_AI_DRAWING_PREV_HW_SELECTION_STATE, this.mPrevHwToolbarState);
        bundle.putParcelable(Constant.KEY_AI_DRAWING_SRC_CONTENT_INFO, this.mSrcContentInfo);
        bundle.putInt(Constant.KEY_AI_DRAWING_TOTAL_OBJECT_COUNT, this.mTotalObjectCount);
        bundle.putInt(Constant.KEY_AI_DRAWING_HW_OBJECT_COUNT, this.mHWObjectCount);
    }

    public void setGenerateTheme(String str) {
        AbstractC8014b.m7196B("setGenerateTheme, generateTheme: ", str, TAG);
        this.mSrcContentInfo.setGenerateTheme(str);
    }

    public void setPrevHwToolbarState(HwToolbarState hwToolbarState) {
        this.mPrevHwToolbarState = hwToolbarState;
    }

    public void setResultHandledContentRect(RectF rectF) {
        this.mResultHandledContentRect = rectF;
    }

    public void setState(AiDrawingState aiDrawingState) {
        this.mComposerViewPresenter.getComposerModel().setAiDrawingState(aiDrawingState);
    }

    public boolean setTargetContentRect(RectF rectF) {
        if (rectF == null || rectF.equals(this.mTargetContentRect) || rectF.left == rectF.right || rectF.top == rectF.bottom) {
            return false;
        }
        this.mTargetContentRect = rectF;
        return true;
    }

    public boolean shouldUseImageInputFileForCreativeStudio() {
        if (!Features.isCreativeStudioSupported() || this.mLowPriorityObjectType == 3) {
            return false;
        }
        Logger.m10999d(TAG, "shouldUseImageInputFileForCreativeStudio, true");
        return true;
    }

    public void updateTargetViewRect(String str) {
        RectF rectFConvertContentRectIntoViewRect = convertContentRectIntoViewRect(this.mTargetContentRect);
        if (rectFConvertContentRectIntoViewRect.equals(this.mTargetViewRect)) {
            return;
        }
        this.mTargetViewRect = rectFConvertContentRectIntoViewRect;
        StringBuilder sbM15l = AbstractC0000a.m15l("updateTargetViewRect# caller: ", str, " targetContentRect: ");
        sbM15l.append(this.mTargetContentRect);
        sbM15l.append(" targetViewRect: ");
        sbM15l.append(this.mTargetViewRect);
        sbM15l.append(", width: ");
        sbM15l.append(this.mTargetViewRect.width());
        sbM15l.append(", height: ");
        sbM15l.append(this.mTargetViewRect.height());
        Logger.m10999d(TAG, sbM15l.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean loadObjectInfos(ArrayList<SpenObjectBase> arrayList, String str) {
        StringBuilder sbM15l = AbstractC0000a.m15l("loadObjectInfos, start caller: ", str, ", objectListSize: ");
        sbM15l.append(arrayList.size());
        Logger.m10999d(TAG, sbM15l.toString());
        boolean z = true;
        boolean z2 = this.mPageObjectsInfos != null;
        Map<Integer, PageObjectsInfo> pageObjectInfos = getPageObjectInfos(arrayList);
        if (this.mPageObjectsInfos == null || pageObjectInfos.isEmpty() || !this.mPageObjectsInfos.equals(pageObjectInfos)) {
            this.mPageObjectsInfos = pageObjectInfos;
            updateHandledColorCount();
        } else {
            z = false;
        }
        StringBuilder sbM2229t = AbstractC2821a.m2229t("loadObjectInfos, end caller: ", str, ", isChanged: ", z, ", isReselect: ");
        sbM2229t.append(z2);
        sbM2229t.append(", handledColorCount: ");
        sbM2229t.append(getHandledColorCount());
        Logger.m10999d(TAG, sbM2229t.toString());
        if (z2) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_AI_DRAWING_POPUP_REQUEST, ComposerSAConstants.EVENT_AI_DRAWING_REQUEST_RESELECT);
        }
        return z;
    }

    public boolean hasSupportedObjects(ArrayList<SpenObjectBase> arrayList) {
        return (arrayList.isEmpty() || (arrayList.size() == 1 && this.mComposerViewPresenter.getDoc().getBodyText().hashCode() == arrayList.get(0).hashCode())) ? false : true;
    }
}
