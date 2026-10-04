package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.FragmentManager;
import androidx.glance.AbstractC2821a;
import com.samsung.android.sdk.pdf.SpenPdfParagraph;
import com.samsung.android.sdk.pdf.SpenPdfTextConverter;
import com.samsung.android.sdk.pdf.SpenPdfWriter;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.ImageTranslator;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.extractor.ImageTranslatorManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ImageUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TextTranslator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationLanguageSelector;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TranslationOverlayManager implements PageManager.OnPageUpdateListener {
    private static final int INVALID_PAGE_INDEX = -1;
    private static final float PDF_IMAGE_RATIO;
    private static final String TAG = Logger.createTag("AI#TranslationOverlayManager");
    public static final int TRANSLATION_ERROR_TYPE_CANCELED = 2;
    public static final int TRANSLATION_ERROR_TYPE_INVALID = 1;
    public static final int TRANSLATION_ERROR_TYPE_NONE = 0;
    public static final int TRANSLATION_ERROR_TYPE_NOT_TRANSLATED = 3;
    private static final int TRANSLATION_OVERLAY_LANGUAGE_LENGTH_FOR_IDENTIFY = 500;
    public static final int TRANSLATION_OVERLAY_PAGE_STATE_COMPLETED = 2;
    public static final int TRANSLATION_OVERLAY_PAGE_STATE_NONE = -1;
    public static final int TRANSLATION_OVERLAY_PAGE_STATE_REQUESTED = 1;
    public static final int TRANSLATION_OVERLAY_PAGE_STATE_STANDBY = 0;
    private final Map<Integer, Pair<Integer, String[]>> mAiCacheMap;
    private BroadcastReceiver mBroadcastReceiverForLanguage;
    private CloseListener mCloseListener;
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;
    private ExecutorService mExecutorService;
    private ExecutorService mImageExecutorService;
    private final Map<Integer, Integer> mImageOverlayCacheMap;
    private final Deque<Integer> mImagePageIndexStack;
    private ImageTranslatorManager mImageTranslatorManager;
    private boolean mIsActivated;
    private boolean mIsCanceled;
    private boolean mIsNeedCheckLanguage;
    private boolean mIsRequestedDownloadLanguage;
    private boolean mIsTranslated;
    private LanguageIdentifier mLanguageIdentifier;
    private final TranslationLanguageModel mLanguageModel;
    private final TranslationLanguageSelector mLanguageSelector;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final Map<Integer, String> mPageIndexMap;
    private final Deque<Integer> mPageIndexStack;
    private String[] mPartialResultArray;
    private int mPartialResultStartIndex;
    private int mRequestedPage;
    private final TextTranslator.ResultListener mResultListener;
    private SpenPdfWriter mSpenPdfWriter;
    private boolean mStopImageOverlay;
    private final AtomicInteger mTranslateAllCnt;
    private TaskListener mTranslateAllListener;
    private final AtomicBoolean mTranslateAllRequested;
    private int mTranslateAllRequestedCnt;
    private final AtomicInteger mTranslateCnt;
    private final AtomicInteger mTranslateImageAllCnt;
    private int mTranslatePageIndex;
    private TaskListener mTranslatePageListener;
    private TextTranslator mTranslator;
    private final Handler mUiHandler;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C94084 implements PdfManager.PdfPageListener {
        public C94084() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.PdfManager.PdfPageListener
        public void onLoadPdfPage(final int i) {
            if (TranslationOverlayManager.this.mExecutorService == null) {
                return;
            }
            TranslationOverlayManager.this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (!TranslationOverlayManager.this.mIsActivated) {
                        Logger.m10999d(TranslationOverlayManager.TAG, "onLoadPdfPage# Ignored by invalid status.");
                        return;
                    }
                    AbstractC8014b.m7221w(new StringBuilder("onLoadPdfPage#execute pdfPageIndex : "), TranslationOverlayManager.TAG, i);
                    if (i >= TranslationOverlayManager.this.mPageIndexMap.size()) {
                        TranslationOverlayManager.this.mPageIndexMap.put(Integer.valueOf(i), "");
                    }
                    TranslationOverlayManager.this.translatePdfPage(i);
                    if (FeatureInfo.isPdfImageTranslationSupported()) {
                        TranslationOverlayManager.this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                TranslationOverlayManager.this.translateImageOverlay(i, false);
                            }
                        });
                    }
                }
            });
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.PdfManager.PdfPageListener
        public void onUnLoadPdfPage(final int i) {
            if (TranslationOverlayManager.this.mExecutorService == null) {
                return;
            }
            TranslationOverlayManager.this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.4.2
                @Override // java.lang.Runnable
                public void run() {
                    AbstractC8014b.m7221w(new StringBuilder("onUnLoadPdfPage#execute pdfPageIndex : "), TranslationOverlayManager.TAG, i);
                    if (TranslationOverlayManager.this.getStateTranslationOverlayPage(i) == 0) {
                        TranslationOverlayManager.this.removeTranslationOverlayPage(i);
                    }
                    TranslationOverlayManager.this.mPageIndexStack.remove(Integer.valueOf(i));
                    if (FeatureInfo.isPdfImageTranslationSupported()) {
                        if (TranslationOverlayManager.this.getStateImageOverlayPage(i) == 0) {
                            TranslationOverlayManager.this.removeImageOverlayPage(i);
                        }
                        TranslationOverlayManager.this.mImagePageIndexStack.remove(Integer.valueOf(i));
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RunnableC94106 implements Runnable {
        final /* synthetic */ int val$pageIndex;

        public RunnableC94106(int i) {
            this.val$pageIndex = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0(int i) {
            TranslationOverlayManager.this.finishImageOverlay(i, 0, "canceled");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1(int i) {
            TranslationOverlayManager.this.finishImageOverlay(i, 1, "STATE_COMPLETED");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$2(int i) {
            TranslationOverlayManager.this.finishImageOverlay(i, 1, "no pdf image");
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            AbstractC8014b.m7221w(new StringBuilder("executeImageOverlay# pageIndex : "), TranslationOverlayManager.TAG, this.val$pageIndex);
            if (TranslationOverlayManager.this.mIsCanceled) {
                Handler handler = TranslationOverlayManager.this.mUiHandler;
                final int i = this.val$pageIndex;
                final int i2 = 0;
                handler.post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.h

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ TranslationOverlayManager.RunnableC94106 f6860b;

                    {
                        this.f6860b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i2) {
                            case 0:
                                this.f6860b.lambda$run$0(i);
                                break;
                            case 1:
                                this.f6860b.lambda$run$1(i);
                                break;
                            default:
                                this.f6860b.lambda$run$2(i);
                                break;
                        }
                    }
                });
                return;
            }
            if (TranslationOverlayManager.this.getStateImageOverlayPage(this.val$pageIndex) == 2) {
                Handler handler2 = TranslationOverlayManager.this.mUiHandler;
                final int i4 = this.val$pageIndex;
                final int i5 = 1;
                handler2.post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.h

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ TranslationOverlayManager.RunnableC94106 f6860b;

                    {
                        this.f6860b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i5) {
                            case 0:
                                this.f6860b.lambda$run$0(i4);
                                break;
                            case 1:
                                this.f6860b.lambda$run$1(i4);
                                break;
                            default:
                                this.f6860b.lambda$run$2(i4);
                                break;
                        }
                    }
                });
                return;
            }
            Bitmap pdfPageBitmap = TranslationOverlayManager.this.getPdfPageBitmap(this.val$pageIndex);
            if (pdfPageBitmap == null) {
                Handler handler3 = TranslationOverlayManager.this.mUiHandler;
                final int i6 = this.val$pageIndex;
                final int i7 = 2;
                handler3.post(new Runnable(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.h

                    /* JADX INFO: renamed from: b */
                    public final /* synthetic */ TranslationOverlayManager.RunnableC94106 f6860b;

                    {
                        this.f6860b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i7) {
                            case 0:
                                this.f6860b.lambda$run$0(i6);
                                break;
                            case 1:
                                this.f6860b.lambda$run$1(i6);
                                break;
                            default:
                                this.f6860b.lambda$run$2(i6);
                                break;
                        }
                    }
                });
                return;
            }
            TranslationOverlayManager.this.updateImageOverlayPage(this.val$pageIndex, 1);
            if (TranslationOverlayManager.this.mImageTranslatorManager == null) {
                Logger.m11000e(TranslationOverlayManager.TAG, "executeImageOverlay# mImageTranslatorManager is null");
            } else {
                TranslationOverlayManager.this.mImageTranslatorManager.executeImageOverlay(pdfPageBitmap, new ImageTranslator.ResultListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.6.1
                    @Override // com.samsung.android.support.senl.nt.base.common.ai.extractor.ImageTranslator.ResultListener
                    public void onResult(Bitmap bitmap) {
                        Logger.m10999d(TranslationOverlayManager.TAG, "executeImageOverlay# onResult : " + RunnableC94106.this.val$pageIndex + ", ImageOverlayCacheMap : " + TranslationOverlayManager.this.mImageOverlayCacheMap);
                        if (TranslationOverlayManager.this.mIsCanceled || TranslationOverlayManager.this.mStopImageOverlay) {
                            return;
                        }
                        RunnableC94106 runnableC94106 = RunnableC94106.this;
                        if (TranslationOverlayManager.this.getStateImageOverlayPage(runnableC94106.val$pageIndex) != 1) {
                            RunnableC94106 runnableC941062 = RunnableC94106.this;
                            TranslationOverlayManager.this.finishImageOverlay(runnableC941062.val$pageIndex, 3, "retry");
                            return;
                        }
                        if (bitmap != null) {
                            if (!TranslationOverlayManager.this.mIsTranslated) {
                                TranslationOverlayManager.this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(true);
                                TranslationOverlayManager.this.mIsTranslated = true;
                            }
                            if (TranslationOverlayManager.this.mComposerViewPresenter != null && TranslationOverlayManager.this.mSpenPdfWriter == null) {
                                TranslationOverlayManager.this.mComposerViewPresenter.getPdfManager().setOverlayImage(RunnableC94106.this.val$pageIndex, bitmap);
                            } else if (TranslationOverlayManager.this.mSpenPdfWriter != null) {
                                TranslationOverlayManager.this.mSpenPdfWriter.setOverlayImage(RunnableC94106.this.val$pageIndex, bitmap);
                            }
                        } else {
                            Logger.m11000e(TranslationOverlayManager.TAG, "executeImageOverlay# onResult : overlayBitmap is null, " + RunnableC94106.this.val$pageIndex);
                        }
                        RunnableC94106 runnableC941063 = RunnableC94106.this;
                        TranslationOverlayManager.this.finishImageOverlay(runnableC941063.val$pageIndex, 2, "complete");
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CloseListener {
        void onClosed();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TaskListener {
        void onCompleted();

        void onFailed(int i, @NonNull String str);

        void onProgress(int i, int i2);
    }

    static {
        PDF_IMAGE_RATIO = DeviceUtils.isTabletModel() ? 1.0f : 1.5f;
    }

    public TranslationOverlayManager(ComposerViewPresenter composerViewPresenter, SpenPdfWriter spenPdfWriter) {
        this(composerViewPresenter, null, null);
        this.mSpenPdfWriter = spenPdfWriter;
    }

    private void addTranslationOverlayPage(int i, String[] strArr) {
        synchronized (this.mAiCacheMap) {
            if (strArr != null) {
                try {
                    Logger.m10999d(TAG, "addTranslationOverlayPage#Start key : " + i + ", data length : " + strArr.length);
                } catch (Throwable th) {
                    throw th;
                }
            }
            Pair<Integer, String[]> pair = this.mAiCacheMap.get(Integer.valueOf(i));
            this.mAiCacheMap.put(Integer.valueOf(i), new Pair<>(Integer.valueOf(pair == null ? 0 : ((Integer) pair.first).intValue()), strArr));
            Logger.m10999d(TAG, "addTranslationOverlayPage#End map size : " + this.mAiCacheMap.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canTranslate(int i) {
        return i == -1 || i == 0;
    }

    private void clearBroadcastReceiverForLanguage() {
        if (this.mBroadcastReceiverForLanguage != null) {
            AiLanguageHelper.unregisterLanguagePackReceiver(BaseUtils.getApplicationContext(), this.mBroadcastReceiverForLanguage);
            this.mBroadcastReceiverForLanguage = null;
        }
    }

    private void clearSelectionText() {
        this.mComposerViewPresenter.setAutoScrollEnabled(false);
        this.mComposerViewPresenter.getTextManager().clearSelection();
        this.mComposerViewPresenter.getPdfManager().clearSelection();
        this.mComposerViewPresenter.setAutoScrollEnabled(true);
    }

    private void deletedPage(String str) {
        int iIntValue;
        int size = this.mPageIndexMap.size();
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("deletedPage#start pageId : ", str, ", pageCount : ");
        sbM15l.append(this.mPageIndexMap.size());
        Logger.m10999d(str2, sbM15l.toString());
        Iterator<Integer> it = this.mPageIndexMap.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                iIntValue = -1;
                break;
            }
            Integer next = it.next();
            iIntValue = next.intValue();
            String str3 = this.mPageIndexMap.get(next);
            if (str3 != null && str3.equals(str)) {
                Logger.m10999d(TAG, "deletedPage# PageIndexMap remove pageIndex : " + iIntValue + ", pageId : " + str);
                this.mPageIndexMap.remove(next);
                break;
            }
        }
        if (iIntValue != -1 && !this.mPageIndexMap.containsKey(Integer.valueOf(iIntValue))) {
            for (int i = iIntValue + 1; i < Math.max(this.mComposerModel.getDoc().getPageCount(), size); i++) {
                if (this.mPageIndexMap.containsKey(Integer.valueOf(i))) {
                    String str4 = this.mPageIndexMap.get(Integer.valueOf(i));
                    this.mPageIndexMap.remove(Integer.valueOf(i));
                    this.mPageIndexMap.put(Integer.valueOf(i - 1), str4);
                }
            }
        }
        if (iIntValue != -1 && this.mAiCacheMap.containsKey(Integer.valueOf(iIntValue))) {
            this.mAiCacheMap.remove(Integer.valueOf(iIntValue));
            for (int i2 = iIntValue + 1; i2 < size; i2++) {
                Pair<Integer, String[]> pair = this.mAiCacheMap.get(Integer.valueOf(i2));
                if (pair != null) {
                    int i4 = i2 - 1;
                    AbstractC8014b.m7221w(AbstractC0541b.m778t(i2, "deletedPage# AiCacheMap replace pageIndex from : ", ", to : "), TAG, i4);
                    if (((Integer) pair.first).intValue() == 1) {
                        pair = new Pair<>(0, new String[0]);
                    }
                    this.mAiCacheMap.remove(Integer.valueOf(i2));
                    this.mAiCacheMap.put(Integer.valueOf(i4), pair);
                }
            }
        }
        if (iIntValue != -1 && this.mImageOverlayCacheMap.containsKey(Integer.valueOf(iIntValue))) {
            this.mImageOverlayCacheMap.remove(Integer.valueOf(iIntValue));
            for (int i5 = iIntValue + 1; i5 < size; i5++) {
                Integer num = this.mImageOverlayCacheMap.get(Integer.valueOf(i5));
                if (num != null) {
                    String str5 = TAG;
                    StringBuilder sbM778t = AbstractC0541b.m778t(i5, "deletedPage# ImageOverlayCacheMap replace pageIndex from : ", ", to : ");
                    int i6 = i5 - 1;
                    sbM778t.append(i6);
                    Logger.m10999d(str5, sbM778t.toString());
                    if (num.intValue() == 1) {
                        num = 0;
                    }
                    this.mImageOverlayCacheMap.remove(Integer.valueOf(i5));
                    this.mImageOverlayCacheMap.put(Integer.valueOf(i6), num);
                }
            }
        }
        this.mComposerViewPresenter.getPdfManager().deletedPage(iIntValue, size);
        String str6 = TAG;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("deletedPage#end pageIndex : ", iIntValue, ", pageId : ", str, ", pageCount : ");
        sbM1629s.append(this.mPageIndexMap.size());
        Logger.m10999d(str6, sbM1629s.toString());
    }

    private void executeImageOverlay(int i) {
        if (this.mImageExecutorService == null) {
            this.mImageExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(AbstractC0622a.m1170p(TAG, "#Image", new StringBuilder())));
        }
        this.mImageExecutorService.execute(new RunnableC94106(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeTranslate(int i, String[] strArr, TextTranslator.ResultListener resultListener) {
        if (this.mIsCanceled) {
            AbstractC0000a.m3D(i, "executeTranslate# Ignored by cancel. pageIndex : ", TAG);
            return;
        }
        if (!this.mComposerViewPresenter.getPdfManager().isAvailableAddToNoteWithTranslation()) {
            this.mComposerViewPresenter.getPdfManager().setAvailableAddToNoteWithTranslation(true);
        }
        this.mLanguageSelector.showTranslationProgress();
        this.mPartialResultArray = new String[strArr.length];
        this.mPartialResultStartIndex = -1;
        TextTranslator textTranslator = new TextTranslator(strArr);
        this.mTranslator = textTranslator;
        textTranslator.setResultListener(resultListener);
        this.mTranslator.initializeLanguage(this.mLanguageModel.getFromLanguageTag(), this.mLanguageModel.getToLanguageTag());
        this.mTranslator.execute();
        AbstractC0000a.m3D(i, "executeTranslate# pdfPageIndex : ", TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void finishImageOverlay(int i, int i2, String str) {
        String str2 = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "finishImageOverlay# pageIndex : ", ", finishType : ", SQLKeyword.COMMA);
        sbM1173s.append(str);
        sbM1173s.append(", mImagePageIndexStack : ");
        sbM1173s.append(this.mImagePageIndexStack);
        Logger.m10999d(str2, sbM1173s.toString());
        ImageTranslatorManager imageTranslatorManager = this.mImageTranslatorManager;
        if (imageTranslatorManager != null) {
            imageTranslatorManager.setTranslatorState(ImageTranslator.TranslatorState.NONE);
        }
        if (i2 != 3) {
            this.mImagePageIndexStack.remove(Integer.valueOf(i));
            updateImageOverlayPage(i, 2);
        }
        if (i2 == 0) {
            if (isTranslating()) {
                return;
            }
            this.mLanguageSelector.hideTranslationProgress();
            return;
        }
        if (!this.mImagePageIndexStack.isEmpty()) {
            Logger.m10999d(str2, "finishImageOverlay# retry translateImage, ImagePageStack : " + this.mImagePageIndexStack);
            translateImageOverlay(this.mImagePageIndexStack.removeLast().intValue(), false);
            return;
        }
        if (!isTranslating()) {
            this.mLanguageSelector.hideTranslationProgress();
        }
        if (this.mTranslateAllListener != null) {
            int i4 = this.mTranslateAllCnt.get();
            int i5 = this.mTranslateImageAllCnt.get();
            if (i4 == 0 && i5 == 0) {
                onCompletedTranslateAll();
                return;
            }
            int i6 = this.mTranslateAllRequestedCnt;
            this.mTranslateAllListener.onProgress((i6 - i4) - i5, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String[] getPageTextArray(int i) {
        if (this.mIsCanceled) {
            Logger.m10999d(TAG, "getPageTextList# Ignored by cancel");
            return null;
        }
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null && this.mSpenPdfWriter == null) {
            String[] pageTaggedTextList = composerViewPresenter.getPdfManager().getPageTaggedTextList(i);
            AbstractC8014b.m7221w(AbstractC0541b.m778t(i, "getPageTextList# pageIndex : ", " / length : "), TAG, pageTaggedTextList.length);
            String[] strArr = (String[]) pageTaggedTextList.clone();
            addTranslationOverlayPage(i, strArr);
            if (pageTaggedTextList.length == 0) {
                return null;
            }
            return strArr;
        }
        SpenPdfWriter spenPdfWriter = this.mSpenPdfWriter;
        if (spenPdfWriter == null) {
            return null;
        }
        ArrayList<SpenPdfParagraph> pageRichTextList = spenPdfWriter.getPageRichTextList(i);
        String[] strArrCompose = new String[0];
        if (pageRichTextList != null) {
            strArrCompose = SpenPdfTextConverter.compose(pageRichTextList);
            for (SpenPdfParagraph spenPdfParagraph : pageRichTextList) {
                if (spenPdfParagraph.getListPdfText() != null) {
                    spenPdfParagraph.getListPdfText().clear();
                }
            }
            pageRichTextList.clear();
        }
        AbstractC8014b.m7221w(AbstractC0541b.m778t(i, "getPageTextList# pageIndex : ", " / length : "), TAG, strArrCompose.length);
        String[] strArr2 = (String[]) strArrCompose.clone();
        addTranslationOverlayPage(i, strArr2);
        if (strArrCompose.length == 0) {
            return null;
        }
        return strArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public String[] getPageTextArrayWithDummy(int i) {
        if (this.mComposerViewPresenter == null && this.mSpenPdfWriter == null) {
            return null;
        }
        AbstractC0000a.m3D(i, "onLoadPdfPage#getPageTextList#Dummy ", TAG);
        String[] strArr = new String[0];
        addTranslationOverlayPage(i, strArr);
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getPdfPageBitmap(int i) {
        Bitmap pageImage;
        RectF pageSize;
        RectF rectF = new RectF();
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter == null || this.mSpenPdfWriter != null) {
            SpenPdfWriter spenPdfWriter = this.mSpenPdfWriter;
            if (spenPdfWriter != null) {
                pageImage = spenPdfWriter.getPageImage(i, PDF_IMAGE_RATIO);
                pageSize = this.mSpenPdfWriter.getPageSize(i);
            } else {
                pageImage = null;
                pageSize = rectF;
            }
        } else {
            pageImage = composerViewPresenter.getPdfManager().getPageImage(i, PDF_IMAGE_RATIO);
            pageSize = this.mComposerViewPresenter.getPdfManager().getPdfPageSize(i);
        }
        if (pageImage != null) {
            Logger.m10999d(TAG, "getPdfPageBitmap# bitmap : " + pageImage.getWidth() + SQLKeyword.COMMA + pageImage.getHeight() + " / pdf : " + pageSize.width() + SQLKeyword.COMMA + pageSize.height());
        }
        return pageImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStateImageOverlayPage(int i) {
        Integer num = this.mImageOverlayCacheMap.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getStateTranslationOverlayPage(int i) {
        Pair<Integer, String[]> pair = this.mAiCacheMap.get(Integer.valueOf(i));
        if (pair == null) {
            return -1;
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "getStateTranslationOverlayPage# key : ", ", state : ");
        sbM778t.append(pair.first);
        Logger.m10999d(str, sbM778t.toString());
        return ((Integer) pair.first).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FragmentManager getSupportFragmentManager() {
        Activity activity = this.mComposerViewPresenter.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return null;
        }
        return ((AppCompatActivity) activity).getSupportFragmentManager();
    }

    @NonNull
    private String getTextToIdentifyForLanguage(int i) {
        return getTextToIdentifyForLanguage(i, this.mComposerViewPresenter.getPdfManager().getPageTextList(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasAttemptedTranslate() {
        Iterator it = new ArrayList(this.mAiCacheMap.values()).iterator();
        while (it.hasNext()) {
            if (((Integer) ((Pair) it.next()).first).intValue() != 0) {
                return true;
            }
        }
        return false;
    }

    private void identifyLanguage(final int i, final String[] strArr, final TextTranslator.ResultListener resultListener) {
        this.mLanguageIdentifier = new LanguageIdentifier();
        String textToIdentifyForLanguage = getTextToIdentifyForLanguage(i);
        Logger.m10999d(TAG, "identifyLanguage# identifyText : " + textToIdentifyForLanguage.length());
        this.mLanguageSelector.animateTranslationAutoDetecting();
        this.mLanguageIdentifier.identifyLanguage(textToIdentifyForLanguage, new LanguageIdentifier.AsyncCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.7
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
            public void onCompleted(Locale locale) {
                Logger.m10999d(TranslationOverlayManager.TAG, "identifyLanguage# identifiedLocale " + locale);
                if (locale == null) {
                    TranslationOverlayManager.this.needToLanguageSelect(i, true, true, "failed to identify");
                    return;
                }
                TranslationOverlayManager.this.mLanguageModel.updateFromLanguageTag(locale);
                Logger.m10999d(TranslationOverlayManager.TAG, "identifyLanguage#onCompleted mFromLanguageTag " + TranslationOverlayManager.this.mLanguageModel.getFromLanguageTag());
                if (!AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(TranslationOverlayManager.this.mLanguageModel.getFromLanguageTag()))) {
                    TranslationOverlayManager.this.needToLanguageSelect(i, true, true, "from not supported");
                    return;
                }
                TranslationOverlayManager.this.mLanguageModel.updateToLanguageTagFromRepository();
                Logger.m10999d(TranslationOverlayManager.TAG, "identifyLanguage#onCompleted#to: " + TranslationOverlayManager.this.mLanguageModel.getToLanguageTag());
                TranslationOverlayManager.this.updateLanguage();
                if (!AiLanguageHelper.isDownloadedLanguage(locale, AiLanguageHelper.getLocale(TranslationOverlayManager.this.mLanguageModel.getToLanguageTag()), false)) {
                    TranslationOverlayManager.this.needToLanguageSelect(i, false, false, "to not supported");
                    return;
                }
                if (TranslationOverlayManager.this.mLanguageModel.isSame()) {
                    TranslationOverlayManager.this.needToLanguageSelect(i, false, false, "to from and to is same");
                    return;
                }
                TranslationOverlayManager.this.updateImageOverlayLanguage();
                ComposerSA.insertLog(TranslationOverlayManager.this.mLanguageSelector.getScreenID(), ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE, TranslationOverlayManager.this.mLanguageModel.getFromLanguageTag() + "_" + TranslationOverlayManager.this.mLanguageModel.getToLanguageTag());
                TranslationOverlayManager.this.executeTranslate(i, strArr, resultListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLanguageSelector() {
        if (this.mLanguageSelector.isToolbarContainer() && !this.mComposerViewPresenter.getTlToolbarPresenter().isInflated()) {
            Logger.m10999d(TAG, "initLanguageSelector# Wait to inflate translation language toolbar.");
            this.mComposerViewPresenter.getTlToolbarPresenter().addPendingActionAfterInflate(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.2
                @Override // java.lang.Runnable
                public void run() {
                    TranslationOverlayManager.this.initLanguageSelector();
                }
            });
            return;
        }
        this.mLanguageSelector.initLayout(this.mComposerViewPresenter, this.mIsActivated, new TranslationLanguageSelector.SelectorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onChangedIsTranslating(boolean z) {
                if (TranslationOverlayManager.this.mMenuManager != null) {
                    TranslationOverlayManager.this.mMenuManager.notifyChangedIsOverlayTranslating(z);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onCloseClicked() {
                Logger.m10999d(TranslationOverlayManager.TAG, "close# disable to translate in pdf overlay");
                int translatedPageCount = TranslationOverlayManager.this.mComposerViewPresenter.getPdfManager().getTranslatedPageCount();
                if (translatedPageCount > 0) {
                    ComposerSA.insertLog(TranslationOverlayManager.this.mLanguageSelector.getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_NUMBER_OF_TRANSLATED_PAGES, String.valueOf(translatedPageCount));
                }
                TranslationOverlayManager.this.close();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onFromLanguageClicked(float f, float f4) {
                Logger.m10999d(TranslationOverlayManager.TAG, "onFromLanguageClicked# centerX : " + f + ", posY : " + f4);
                TranslationOverlayManager.this.showLanguageSelectorDialog(true, f, f4);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onLocaleSelected() {
                TranslationOverlayManager.this.updateLanguage();
                ComposerSA.insertLog(TranslationOverlayManager.this.mLanguageSelector.getScreenID(), ComposerSAConstants.EVENT_AI_TRANSLATE_LANGUAGE, TranslationOverlayManager.this.mLanguageModel.getFromLanguageTag() + "_" + TranslationOverlayManager.this.mLanguageModel.getToLanguageTag());
                TranslationOverlayManager.this.reload();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onSaveAsNewNoteClicked() {
                if (TranslationOverlayManager.this.mMenuManager != null) {
                    TranslationOverlayManager.this.mMenuManager.onEvent(12);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onSelectLanguageDialogCancel() {
                if (TranslationOverlayManager.this.mLanguageModel.isInvalidStatus()) {
                    Logger.m10999d(TranslationOverlayManager.TAG, "onCancel# unavailable");
                    TranslationOverlayManager.this.close();
                    if (TranslationOverlayManager.this.mTranslatePageListener != null) {
                        Logger.m10999d(TranslationOverlayManager.TAG, "translate# TranslatePageListener onFailed(unavailable).");
                        TranslationOverlayManager.this.mTranslatePageListener.onFailed(1, "unavailable");
                        TranslationOverlayManager.this.mTranslatePageListener = null;
                    }
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onToLanguageClicked(float f, float f4) {
                Logger.m10999d(TranslationOverlayManager.TAG, "onToLanguageClicked# centerX : " + f + ", posY : " + f4);
                TranslationOverlayManager.this.showLanguageSelectorDialog(false, f, f4);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageSelector.SelectorListener
            public void onToggleClicked() {
                if (TranslationOverlayManager.this.mIsActivated) {
                    Logger.m10999d(TranslationOverlayManager.TAG, "toggle# deactivate to translate in pdf overlay");
                    TranslationOverlayManager.this.pauseTranslate();
                } else {
                    Logger.m10999d(TranslationOverlayManager.TAG, "toggle# activate to translate in pdf overlay");
                    TranslationOverlayManager.this.resumeTranslate();
                }
            }
        });
        if (this.mTranslateCnt.get() > 0) {
            this.mLanguageSelector.showTranslationProgress();
        }
        MenuPresenterContract.IMenuManager iMenuManager = this.mMenuManager;
        if (iMenuManager != null) {
            iMenuManager.onTranslationStateUpdated(1);
        }
    }

    private void initOverlayText() {
        if (this.mIsActivated) {
            Logger.m10999d(TAG, "initOverlayText#");
            setPdfPageListener();
            this.mIsCanceled = false;
            this.mComposerViewPresenter.getPdfManager().requestReloadOverlayPages();
        }
    }

    private void insertedPage(String str) {
        int size = this.mPageIndexMap.size();
        String str2 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("insertedPage#start pageId : ", str, ", pageCount : ");
        sbM15l.append(this.mPageIndexMap.size());
        Logger.m10999d(str2, sbM15l.toString());
        int pageIndexById = this.mComposerModel.getDoc().getPageIndexById(str);
        Logger.m10999d(str2, "insertedPage# pageIndex : " + pageIndexById + ", pageId : " + str);
        if (this.mPageIndexMap.containsKey(Integer.valueOf(pageIndexById))) {
            for (int pageCount = this.mComposerModel.getDoc().getPageCount(); pageCount >= pageIndexById; pageCount--) {
                if (this.mPageIndexMap.containsKey(Integer.valueOf(pageCount))) {
                    String str3 = this.mPageIndexMap.get(Integer.valueOf(pageCount));
                    this.mPageIndexMap.remove(Integer.valueOf(pageCount));
                    this.mPageIndexMap.put(Integer.valueOf(pageCount + 1), str3);
                }
            }
        }
        this.mPageIndexMap.put(Integer.valueOf(pageIndexById), str);
        for (int iMax = Math.max(size - 1, pageIndexById); iMax >= pageIndexById; iMax--) {
            Pair<Integer, String[]> pair = this.mAiCacheMap.get(Integer.valueOf(iMax));
            if (pair != null) {
                int i = iMax + 1;
                AbstractC8014b.m7221w(AbstractC0541b.m778t(iMax, "insertedPage# AiCacheMap replace pageIndex from : ", ", to : "), TAG, i);
                this.mAiCacheMap.remove(Integer.valueOf(iMax));
                if (((Integer) pair.first).intValue() == 1) {
                    pair = new Pair<>(0, new String[0]);
                }
                this.mAiCacheMap.put(Integer.valueOf(i), pair);
            }
            Integer num = this.mImageOverlayCacheMap.get(Integer.valueOf(iMax));
            if (num != null) {
                int i2 = iMax + 1;
                AbstractC8014b.m7221w(AbstractC0541b.m778t(iMax, "insertedPage# ImageOverlayCacheMap replace pageIndex from : ", ", to : "), TAG, i2);
                this.mImageOverlayCacheMap.remove(Integer.valueOf(iMax));
                if (num.intValue() == 1) {
                    num = 0;
                }
                this.mImageOverlayCacheMap.put(Integer.valueOf(i2), num);
            }
        }
        this.mComposerViewPresenter.getPdfManager().insertedPage(pageIndexById);
        String str4 = TAG;
        StringBuilder sbM1629s = AbstractC2322a.m1629s("insertedPage# pageIndexMap put pageIndex : ", pageIndexById, ", pageId : ", str, ", pageCount : ");
        sbM1629s.append(this.mPageIndexMap.size());
        Logger.m10999d(str4, sbM1629s.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void needToLanguageSelect(int i, boolean z, boolean z2, String str) {
        AbstractC8014b.m7196B("needToLanguageSelect# ", str, TAG);
        this.mLanguageSelector.hideTranslationProgress();
        showLanguageSelectorDialog(z);
        if (z2) {
            ToastHandler.show(BaseUtils.getApplicationContext(), C9086R.string.ai_not_supported_from_language, 1);
        }
        this.mTranslateCnt.set(0);
        updateTranslationOverlayPage(i, 0);
        updateImageOverlayLanguage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompletedTranslateAll() {
        if (this.mTranslateAllListener == null) {
            Logger.m10999d(TAG, "onCompletedTranslateAll# Ignored by invalid status.");
            return;
        }
        if (this.mIsTranslated) {
            Logger.m10999d(TAG, "onCompletedTranslateAll# onCompleted.");
            this.mTranslateAllListener.onCompleted();
            this.mTranslateAllListener = null;
        } else {
            Logger.m10999d(TAG, "onCompletedTranslateAll# Failed by not translated");
            this.mTranslateAllListener.onFailed(3, "not translated");
            this.mTranslateAllListener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseTranslate() {
        Logger.m10999d(TAG, "pauseTranslate#");
        this.mIsActivated = false;
        this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(false);
        this.mLanguageSelector.updateToggle(false);
        MenuPresenterContract.IMenuManager iMenuManager = this.mMenuManager;
        if (iMenuManager != null) {
            iMenuManager.onTranslationStateUpdated(2);
        }
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null && !executorService.isShutdown() && !this.mExecutorService.isTerminated()) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        ExecutorService executorService2 = this.mImageExecutorService;
        if (executorService2 == null || executorService2.isShutdown() || this.mImageExecutorService.isTerminated()) {
            return;
        }
        this.mImageExecutorService.shutdownNow();
        this.mImageExecutorService = null;
    }

    private void releaseImageTranslator() {
        Logger.m10999d(TAG, "releaseImageTranslator");
        setStopImageOverlay(false);
        ExecutorService executorService = this.mImageExecutorService;
        if (executorService != null && !executorService.isShutdown() && !this.mImageExecutorService.isTerminated()) {
            this.mImageExecutorService.shutdownNow();
            this.mImageExecutorService = null;
        }
        ImageTranslatorManager imageTranslatorManager = this.mImageTranslatorManager;
        if (imageTranslatorManager != null) {
            imageTranslatorManager.release();
            this.mImageTranslatorManager = null;
        }
    }

    private void releaseTranslator() {
        Logger.m10999d(TAG, "releaseTranslator");
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null && !executorService.isShutdown() && !this.mExecutorService.isTerminated()) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        TextTranslator textTranslator = this.mTranslator;
        if (textTranslator != null) {
            textTranslator.release();
            this.mTranslator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeImageOverlayPage(int i) {
        AbstractC0000a.m3D(i, "removeImageOverlayPage# key : ", TAG);
        this.mImageOverlayCacheMap.remove(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeTranslationOverlayPage(int i) {
        String str = TAG;
        AbstractC0000a.m3D(i, "removeTranslationOverlayPage#Start key : ", str);
        this.mAiCacheMap.remove(Integer.valueOf(i));
        Logger.m10999d(str, "removeTranslationOverlayPage#End map size : " + this.mAiCacheMap.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTranslate() {
        String str = TAG;
        Logger.m10999d(str, "resumeTranslate#");
        this.mIsActivated = true;
        this.mComposerViewPresenter.getPdfManager().clearSelection();
        if (this.mIsTranslated) {
            this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(true);
        }
        if (this.mExecutorService == null) {
            Logger.m10999d(str, "resumeTranslate# create ExecutorService");
            this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(str));
        }
        this.mComposerViewPresenter.getPdfManager().requestReloadOverlayPages();
        this.mLanguageSelector.updateToggle(true);
        MenuPresenterContract.IMenuManager iMenuManager = this.mMenuManager;
        if (iMenuManager != null) {
            iMenuManager.onTranslationStateUpdated(1);
        }
    }

    private void saveOcrFile(Context context, Bitmap bitmap, int i, boolean z) throws Throwable {
        File file = new File(context.getFilesDir(), "ocr");
        StringBuilder sb = new StringBuilder();
        sb.append(file.getAbsolutePath());
        sb.append(File.separator);
        sb.append(System.currentTimeMillis());
        sb.append(z ? "_origin.jpg" : ".jpg");
        String string = sb.toString();
        String str = TAG;
        StringBuilder sb2 = new StringBuilder("saveOcrFile# pageIndex : ");
        sb2.append(i);
        sb2.append(z ? ", originFile" : ", overlaidFile");
        sb2.append(", makeJpg path : ");
        sb2.append(string);
        Logger.m10999d(str, sb2.toString());
        ImageUtils.makeJpg(bitmap, string, 100, false);
    }

    private void setPdfPageListener() {
        if (this.mComposerViewPresenter == null) {
            Logger.m10999d(TAG, "setPdfPageListener# Ignored by invalid status.");
        } else {
            Logger.m10999d(TAG, "setPdfPageListener#");
            this.mComposerViewPresenter.getPdfManager().setPdfPageListener(new C94084());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTranslate(Integer num, String[] strArr) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("startTranslate# pageIndex : ");
        sb.append(num);
        sb.append(", length : ");
        AbstractC8014b.m7221w(sb, str, strArr.length);
        this.mTranslateCnt.set(1);
        this.mTranslatePageIndex = num.intValue();
        updateTranslationOverlayPage(num.intValue(), 1);
        translate(num.intValue(), strArr, this.mResultListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean translate(int i, String[] strArr, TextTranslator.ResultListener resultListener) {
        if (this.mIsCanceled) {
            AbstractC0000a.m3D(i, "translate#Ignored by canceled. pdfPageINdex : ", TAG);
            this.mTranslateCnt.set(0);
            return false;
        }
        if (strArr == null || strArr.length == 0) {
            AbstractC0000a.m3D(i, "translate#Ignored by empty data. pdfPageINdex : ", TAG);
            updateTranslationOverlayPage(i, 2);
            this.mTranslateCnt.set(0);
            return false;
        }
        String str = TAG;
        AbstractC0000a.m3D(i, "translate#Start pdfPageIndex : ", str);
        if (TextUtils.isEmpty(this.mLanguageModel.getFromLanguageTag())) {
            Logger.m10999d(str, "translate# Need to identify language. languageIdentifier " + this.mLanguageIdentifier + ", fromLanguageTag : " + this.mLanguageModel.getFromLanguageTag());
            identifyLanguage(i, strArr, resultListener);
        } else if (TextUtils.isEmpty(this.mLanguageModel.getToLanguageTag())) {
            this.mLanguageModel.updateToLanguageTagFromRepository();
            Logger.m10999d(str, "translate#identifyLanguage#to : " + this.mLanguageModel.getToLanguageTag());
            if (!AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mLanguageModel.getFromLanguageTag()), AiLanguageHelper.getLocale(this.mLanguageModel.getToLanguageTag()), true) || this.mLanguageModel.isSame()) {
                Logger.m10999d(str, "translate#identifyLanguage#to not supported or same with from");
                showLanguageSelectorDialog(false);
                this.mTranslateCnt.set(0);
                return false;
            }
            executeTranslate(i, strArr, resultListener);
        } else {
            updateLanguage();
            if (this.mLanguageModel.isSame()) {
                Logger.m10999d(str, "translate# from and to is same");
                updateTranslationOverlayPage(i, 2);
                this.mTranslateCnt.set(0);
                if (this.mTranslatePageListener != null) {
                    Logger.m10999d(str, "translate# TranslatePageListener onCompleted.");
                    this.mTranslatePageListener.onCompleted();
                    this.mTranslatePageListener = null;
                }
                return false;
            }
            if (!AiLanguageHelper.isDownloadedLanguage(AiLanguageHelper.getLocale(this.mLanguageModel.getFromLanguageTag()), AiLanguageHelper.getLocale(this.mLanguageModel.getToLanguageTag()), true)) {
                Logger.m10999d(str, "translate#identifyLanguage# not supported or not downloaded");
                this.mTranslateCnt.set(0);
                return false;
            }
            executeTranslate(i, strArr, resultListener);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translateImageOverlay(int i, boolean z) {
        int stateImageOverlayPage = getStateImageOverlayPage(i);
        String str = TAG;
        AbstractC8014b.m7215q(AbstractC0622a.m1173s(i, stateImageOverlayPage, "translateImageOverlay# pdfPageIndex : ", ", imageState : ", ", mStopImageOverlay : "), this.mStopImageOverlay, str);
        if (this.mStopImageOverlay) {
            this.mImagePageIndexStack.clear();
            return;
        }
        if (canTranslate(stateImageOverlayPage)) {
            if (this.mImageTranslatorManager == null) {
                ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
                if (composerViewPresenter == null) {
                    return;
                }
                this.mImageTranslatorManager = new ImageTranslatorManager(composerViewPresenter.getActivity());
                updateImageOverlayLanguage();
            }
            if (!this.mImageTranslatorManager.isSupported()) {
                Logger.m10999d(str, "translateImageOverlay# OCR not supported");
                finishImageOverlay(i, 0, "not supported");
                return;
            }
            this.mImagePageIndexStack.remove(Integer.valueOf(i));
            this.mImagePageIndexStack.addLast(Integer.valueOf(i));
            ImageTranslator.TranslatorState translatorState = this.mImageTranslatorManager.getTranslatorState();
            StringBuilder sb = new StringBuilder("translateImageOverlay# ImagePageStack : ");
            sb.append(this.mImagePageIndexStack);
            sb.append(", ImageTranslator state : ");
            sb.append(translatorState);
            sb.append(", isNotNeedToExecute : ");
            AbstractC8014b.m7215q(sb, z, str);
            ImageTranslator.TranslatorState translatorState2 = ImageTranslator.TranslatorState.PROCESSING;
            if (translatorState == translatorState2 || z) {
                return;
            }
            this.mImageTranslatorManager.setTranslatorState(translatorState2);
            this.mLanguageSelector.showTranslationProgress();
            executeImageOverlay(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void translatePdfPage(final int i) {
        int stateTranslationOverlayPage = getStateTranslationOverlayPage(i);
        String str = TAG;
        AbstractC8014b.m7216r(i, stateTranslationOverlayPage, "translatePdfPage#Start pdfPageIndex : ", " / state = ", str);
        if (canTranslate(stateTranslationOverlayPage)) {
            this.mPageIndexStack.remove(Integer.valueOf(i));
            this.mPageIndexStack.addLast(Integer.valueOf(i));
            if (this.mExecutorService == null) {
                Logger.m10999d(str, "translatePdfPage# create ExecutorService");
                this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(str));
                this.mTranslateCnt.set(0);
            }
            this.mExecutorService.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.5
                @Override // java.lang.Runnable
                public void run() {
                    String[] pageTextArray;
                    if (TranslationOverlayManager.this.mIsCanceled || !TranslationOverlayManager.this.mPageIndexStack.contains(Integer.valueOf(i))) {
                        AbstractC8014b.m7221w(new StringBuilder("translatePdfPage#Start skip : "), TranslationOverlayManager.TAG, i);
                        return;
                    }
                    int stateTranslationOverlayPage2 = TranslationOverlayManager.this.getStateTranslationOverlayPage(i);
                    if (TranslationOverlayManager.this.canTranslate(stateTranslationOverlayPage2)) {
                        if (stateTranslationOverlayPage2 == -1) {
                            pageTextArray = TranslationOverlayManager.this.getPageTextArrayWithDummy(i);
                            if (pageTextArray == null) {
                                if (TextUtils.isEmpty(TranslationOverlayManager.this.mLanguageModel.getFromLanguageTag()) && !TranslationOverlayManager.this.hasAttemptedTranslate()) {
                                    Logger.m10999d(TranslationOverlayManager.TAG, "translatePdfPage# show LanguageSelectorDialog");
                                    TranslationOverlayManager.this.showLanguageSelectorDialog(true);
                                }
                                TranslationOverlayManager.this.updateTranslationOverlayPage(i, 2);
                                return;
                            }
                        } else {
                            Pair pair = (Pair) TranslationOverlayManager.this.mAiCacheMap.get(Integer.valueOf(i));
                            pageTextArray = pair != null ? (String[]) pair.second : null;
                        }
                        int i2 = TranslationOverlayManager.this.mTranslateCnt.get();
                        int stateTranslationOverlayPage3 = TranslationOverlayManager.this.getStateTranslationOverlayPage(i);
                        String str2 = TranslationOverlayManager.TAG;
                        StringBuilder sb = new StringBuilder("translatePdfPage#check pdfPageIndex : ");
                        AbstractC2821a.m2235z(sb, i, i2, " / translateCnt : ", ", pageState : ");
                        AbstractC8014b.m7221w(sb, str2, stateTranslationOverlayPage3);
                        if (i2 == 0 && stateTranslationOverlayPage3 == 0) {
                            TranslationOverlayManager.this.mLanguageSelector.showTranslationProgress();
                            TranslationOverlayManager.this.mTranslateCnt.set(1);
                            TranslationOverlayManager.this.mTranslatePageIndex = i;
                            if (pageTextArray == null || pageTextArray.length == 0) {
                                pageTextArray = TranslationOverlayManager.this.getPageTextArray(i);
                            }
                            Logger.m10999d(TranslationOverlayManager.TAG, "translatePdfPage#requestTranslate pageIndex : " + TranslationOverlayManager.this.mTranslatePageIndex);
                            TranslationOverlayManager translationOverlayManager = TranslationOverlayManager.this;
                            if (translationOverlayManager.translate(i, pageTextArray, translationOverlayManager.mResultListener)) {
                                TranslationOverlayManager.this.updateTranslationOverlayPage(i, 1);
                            } else {
                                if (!TranslationOverlayManager.this.isTranslating()) {
                                    TranslationOverlayManager.this.mLanguageSelector.hideTranslationProgress();
                                }
                                if (TranslationOverlayManager.this.mTranslatePageListener != null) {
                                    Logger.m10999d(TranslationOverlayManager.TAG, "translatePdfPage#requestTranslate onFailed. pageIndex : " + TranslationOverlayManager.this.mRequestedPage);
                                    TranslationOverlayManager.this.mRequestedPage = -1;
                                    TranslationOverlayManager.this.mTranslatePageListener.onFailed(3, "Failed to translate");
                                    TranslationOverlayManager.this.mTranslatePageListener = null;
                                }
                            }
                            AbstractC8014b.m7221w(new StringBuilder("translatePdfPage#End pdfPageIndex : "), TranslationOverlayManager.TAG, i);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageOverlayLanguage() {
        if (this.mImageTranslatorManager == null) {
            this.mImageTranslatorManager = new ImageTranslatorManager(this.mComposerViewPresenter.getActivity());
        }
        Logger.m10999d(TAG, "updateImageOverlayLanguage# from : " + this.mLanguageModel.getFromLanguageTag() + ", to : " + this.mLanguageModel.getToLanguageTag());
        if (!TextUtils.isEmpty(this.mLanguageModel.getFromLanguageTag())) {
            this.mImageTranslatorManager.setSourceLanguage(AiLanguageHelper.convertToScsLanguage(this.mLanguageModel.getFromLanguageTag()));
        }
        if (TextUtils.isEmpty(this.mLanguageModel.getToLanguageTag())) {
            this.mLanguageModel.updateToLanguageTagFromRepository();
        }
        this.mImageTranslatorManager.setTargetLanguage(AiLanguageHelper.convertToScsLanguage(this.mLanguageModel.getToLanguageTag()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateImageOverlayPage(int i, int i2) {
        synchronized (this.mImageOverlayCacheMap) {
            try {
                this.mImageOverlayCacheMap.put(Integer.valueOf(i), Integer.valueOf(i2));
                if (this.mTranslateImageAllCnt.get() > 0 && i2 == 2) {
                    Logger.m10999d(TAG, "updateImageOverlayPage# TranslateImageAllCnt : " + this.mTranslateImageAllCnt.decrementAndGet());
                    if (this.mTranslateAllListener != null && this.mTranslateAllRequested.get()) {
                        int i4 = this.mTranslateAllCnt.get();
                        int i5 = this.mTranslateImageAllCnt.get();
                        if (i4 == 0 && i5 == 0) {
                            onCompletedTranslateAll();
                        } else {
                            int i6 = this.mTranslateAllRequestedCnt;
                            this.mTranslateAllListener.onProgress((i6 - i4) - i5, i6);
                        }
                    }
                }
                Logger.m10999d(TAG, "updateImageOverlayPage# key : " + i + ", state : " + i2 + ", ImageOverlayCacheMap : " + this.mImageOverlayCacheMap);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateResult(int i, @NonNull String[] strArr, String str, String str2, boolean z) {
        if (this.mIsCanceled) {
            Logger.m10999d(TAG, "ResultListener#updateResult canceled");
            TaskListener taskListener = this.mTranslateAllListener;
            if (taskListener == null) {
                return false;
            }
            taskListener.onFailed(2, "canceled");
            this.mTranslateAllListener = null;
            return false;
        }
        if (strArr.length == 0) {
            Logger.m10999d(TAG, "ResultListener#updateResult Ignored by empty result.");
            return true;
        }
        String str3 = TAG;
        Logger.m10999d(str3, "ResultListener#updateResult pageIndex : " + this.mTranslatePageIndex + ", fromLanguageTag : " + this.mLanguageModel.getFromLanguageTag() + ", toLanguageTag : " + this.mLanguageModel.getToLanguageTag());
        if (!TextUtils.equals(str, this.mLanguageModel.getFromLanguageTag()) || !TextUtils.equals(str2, this.mLanguageModel.getToLanguageTag())) {
            Logger.m10999d(str3, "ResultListener#updateResult Ignored by invalid LanguageTag. from : " + str + ", to : " + str2);
        } else if (this.mComposerViewPresenter != null && this.mSpenPdfWriter == null) {
            int stateTranslationOverlayPage = getStateTranslationOverlayPage(this.mTranslatePageIndex);
            if (stateTranslationOverlayPage != 1) {
                AbstractC0000a.m3D(stateTranslationOverlayPage, "ResultListener#updateResult Ignored by invalid state : ", str3);
                return true;
            }
            if (!this.mIsTranslated) {
                if (!this.mComposerViewPresenter.getPdfManager().isOverlayTextEnabled()) {
                    this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(true);
                }
                this.mIsTranslated = true;
            }
            if (this.mComposerViewPresenter.getPdfManager().hasSelection(this.mTranslatePageIndex)) {
                this.mComposerViewPresenter.getPdfManager().clearSelection();
            }
            this.mComposerViewPresenter.getPdfManager().setOverlayTaggedText(this.mTranslatePageIndex, strArr, this.mLanguageModel.getToLanguageTag());
            if (z) {
                updateTranslationOverlayPage(this.mTranslatePageIndex, 2);
            }
        } else if (this.mSpenPdfWriter != null) {
            ArrayList<SpenPdfParagraph> arrayList = SpenPdfTextConverter.parse(strArr);
            if (arrayList != null) {
                if (!this.mIsTranslated) {
                    this.mIsTranslated = true;
                }
                this.mSpenPdfWriter.setOverlayRichText(this.mTranslatePageIndex, arrayList, this.mLanguageModel.getToLanguageTag());
                Iterator<SpenPdfParagraph> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().getListPdfText().clear();
                }
                arrayList.clear();
            } else {
                Logger.m11000e("AI" + str3, "setOverlayTaggedText# paragraphs is null");
            }
            if (z) {
                updateTranslationOverlayPage(this.mTranslatePageIndex, 2);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTranslationOverlayPage(int i, int i2) {
        synchronized (this.mAiCacheMap) {
            try {
                String str = TAG;
                Logger.m10999d(str, "updateTranslationOverlayPage#Start key : " + i + ", state : " + i2);
                Pair<Integer, String[]> pair = this.mAiCacheMap.get(Integer.valueOf(i));
                if (pair != null) {
                    this.mAiCacheMap.put(Integer.valueOf(i), new Pair<>(Integer.valueOf(i2), (String[]) pair.second));
                }
                if (this.mTranslateAllCnt.get() > 0 && i2 == 2) {
                    Logger.m10999d(str, "updateTranslationOverlayPage# TranslateAllCnt : " + this.mTranslateAllCnt.decrementAndGet());
                    if (this.mTranslateAllListener != null && this.mTranslateAllRequested.get()) {
                        int i4 = this.mTranslateAllCnt.get();
                        int i5 = this.mTranslateImageAllCnt.get();
                        if (i4 == 0 && i5 == 0) {
                            onCompletedTranslateAll();
                        } else {
                            int i6 = this.mTranslateAllRequestedCnt;
                            this.mTranslateAllListener.onProgress((i6 - i4) - i5, i6);
                        }
                    }
                }
                Logger.m10999d(str, "updateTranslationOverlayPage#End map size : " + this.mAiCacheMap.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void cancelTranslateAll() {
        Logger.m10999d(TAG, "cancelTranslateAll#");
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null && !executorService.isShutdown() && !this.mExecutorService.isTerminated()) {
            this.mExecutorService.shutdownNow();
            this.mExecutorService = null;
        }
        ExecutorService executorService2 = this.mImageExecutorService;
        if (executorService2 != null && !executorService2.isShutdown() && !this.mImageExecutorService.isTerminated()) {
            this.mImageExecutorService.shutdownNow();
            this.mImageExecutorService = null;
        }
        if (this.mTranslateAllListener != null) {
            this.mTranslateCnt.set(0);
            this.mIsCanceled = true;
            this.mLanguageSelector.hideTranslationProgress();
            this.mAiCacheMap.clear();
            this.mImageOverlayCacheMap.clear();
            this.mTranslateAllListener.onFailed(2, "canceled");
            this.mTranslateAllListener = null;
            setStopImageOverlay(false);
        }
    }

    public void close() {
        if (this.mComposerViewPresenter.getComposerModel().getComposerState().isTranslated()) {
            Logger.m10999d(TAG, "close#");
            if (this.mTranslateCnt.get() == 1) {
                this.mTranslateCnt.set(0);
                this.mIsCanceled = true;
                this.mLanguageSelector.hideTranslationProgress();
                if (getStateTranslationOverlayPage(this.mTranslatePageIndex) != 2) {
                    updateTranslationOverlayPage(this.mTranslatePageIndex, 0);
                }
            }
            this.mIsActivated = false;
            this.mComposerViewPresenter.getComposerModel().getComposerState().setTranslated(false);
            this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(false);
            this.mLanguageSelector.hide();
            CloseListener closeListener = this.mCloseListener;
            if (closeListener != null) {
                closeListener.onClosed();
            }
            MenuPresenterContract.IMenuManager iMenuManager = this.mMenuManager;
            if (iMenuManager != null) {
                iMenuManager.onTranslationStateUpdated(0);
            }
            release();
        }
    }

    public void initBroadcastReceiverForLanguage() {
        AiLanguageHelper.updateLanguageList();
        if (this.mBroadcastReceiverForLanguage == null) {
            this.mBroadcastReceiverForLanguage = new BroadcastReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.10
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    if (context == null || intent == null) {
                        Logger.m11000e(TranslationOverlayManager.TAG, "Receiver# null");
                        return;
                    }
                    Logger.m10999d(TranslationOverlayManager.TAG, "Receiver# " + intent.getStringExtra("locale"));
                    AiLanguageHelper.updateLanguageList(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TranslationOverlayManager.this.mComposerViewPresenter == null || TranslationOverlayManager.this.mLanguageModel == null) {
                                return;
                            }
                            if (!TranslationOverlayManager.this.mLanguageModel.isInvalidStatus()) {
                                TranslationOverlayManager.this.reload();
                            } else {
                                Logger.m10999d(TranslationOverlayManager.TAG, "onReceive# invalid status.");
                                TranslationOverlayManager.this.mIsNeedCheckLanguage = true;
                            }
                        }
                    });
                }
            };
        }
        AiLanguageHelper.registerLanguagePackAddedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastReceiverForLanguage);
        AiLanguageHelper.registerLanguagePackRemovedReceiver(BaseUtils.getApplicationContext(), this.mBroadcastReceiverForLanguage);
    }

    public boolean isActivated() {
        return this.mIsActivated;
    }

    public boolean isStoppedTemporarily() {
        if (this.mComposerViewPresenter.getPdfManager().isEmptyTranslationCacheMap()) {
            return false;
        }
        Logger.m10999d(TAG, "isStoppedTemporarily# true");
        return true;
    }

    public boolean isTranslated(int i) {
        Pair<Integer, String[]> pair = this.mAiCacheMap.get(Integer.valueOf(i));
        if (pair != null) {
            String str = TAG;
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "isTranslated# key : ", ", state : ");
            sbM778t.append(pair.first);
            Logger.m10999d(str, sbM778t.toString());
            if (((Integer) pair.first).intValue() == 2) {
                return true;
            }
        }
        return false;
    }

    public boolean isTranslating() {
        return this.mImageTranslatorManager != null ? this.mTranslateCnt.get() != 0 || this.mImageTranslatorManager.getTranslatorState() == ImageTranslator.TranslatorState.PROCESSING : this.mTranslateCnt.get() != 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onDeletedPages(List<Integer> list, PageManager.PageUpdateState pageUpdateState) {
        if (pageUpdateState == null) {
            return;
        }
        Logger.m10999d(TAG, "onDeletedPages# pages count : (" + pageUpdateState.getPageIdList().size() + ") " + pageUpdateState.getPageIdList());
        Iterator<String> it = pageUpdateState.getPageIdList().iterator();
        while (it.hasNext()) {
            try {
                deletedPage(it.next());
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("Failed to getPageIndexById. "), TAG);
            }
        }
        this.mComposerViewPresenter.getPdfManager().requestReloadOverlayPages();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onInsertedPages(PageManager.PageUpdateState pageUpdateState) {
        if (pageUpdateState == null) {
            return;
        }
        Logger.m10999d(TAG, "onInsertedPages# pages count : (" + pageUpdateState.getPageIdList().size() + ") " + pageUpdateState.getPageIdList());
        Iterator<String> it = pageUpdateState.getPageIdList().iterator();
        while (it.hasNext()) {
            try {
                insertedPage(it.next());
            } catch (Exception e) {
                AbstractC8014b.m7205g(e, new StringBuilder("Failed to getPageIndexById. "), TAG);
            }
        }
        this.mComposerViewPresenter.getPdfManager().requestReloadOverlayPages();
    }

    public void onResume() {
        String str = TAG;
        StringBuilder sb = new StringBuilder("onResume# check language status : ");
        sb.append(this.mIsNeedCheckLanguage);
        sb.append(", check download language : ");
        AbstractC8014b.m7215q(sb, this.mIsRequestedDownloadLanguage, str);
        if (this.mIsNeedCheckLanguage) {
            this.mIsNeedCheckLanguage = false;
            AiLanguageHelper.updateLanguageList(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.8
                @Override // java.lang.Runnable
                public void run() {
                    if (TranslationOverlayManager.this.mComposerViewPresenter == null || TranslationOverlayManager.this.mLanguageModel == null || !TranslationOverlayManager.this.mLanguageModel.isInvalidStatus() || !TranslationOverlayManager.this.mLanguageModel.isInvalidStatus()) {
                        return;
                    }
                    Logger.m10999d(TranslationOverlayManager.TAG, "onResume# invalid status. requestDownloadLanguagePack");
                    TranslationOverlayManager.this.mIsRequestedDownloadLanguage = true;
                    Locale locale = AiLanguageHelper.getLocale(TranslationOverlayManager.this.mLanguageModel.getFromLanguageTag());
                    Locale locale2 = AiLanguageHelper.getLocale(TranslationOverlayManager.this.mLanguageModel.getToLanguageTag());
                    if (locale == null || locale2 == null) {
                        return;
                    }
                    AiLanguageHelper.requestDownloadLanguagePack(TranslationOverlayManager.this.mComposerViewPresenter.getActivity(), locale, locale2, Integer.valueOf(ComposerRequestCode.DownloadLanguage.getId()));
                }
            });
        } else if (this.mIsRequestedDownloadLanguage) {
            this.mIsRequestedDownloadLanguage = false;
            AiLanguageHelper.updateLanguageList(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.9
                @Override // java.lang.Runnable
                public void run() {
                    if (TranslationOverlayManager.this.mComposerViewPresenter == null || TranslationOverlayManager.this.mLanguageModel == null) {
                        return;
                    }
                    if (!TranslationOverlayManager.this.mLanguageModel.isInvalidStatus()) {
                        TranslationOverlayManager.this.reload();
                        return;
                    }
                    Logger.m10999d(TranslationOverlayManager.TAG, "onResume# invalid status. close & stop");
                    TranslationOverlayManager.this.close();
                    TranslationOverlayManager.this.stop();
                    TranslationOverlayManager.this.mLanguageModel.updateLanguageStatus();
                    TranslationOverlayManager.this.mLanguageSelector.clearLanguage();
                    TranslationOverlayManager.this.mIsTranslated = false;
                    if (TranslationOverlayManager.this.mTranslatePageListener != null) {
                        Logger.m10999d(TranslationOverlayManager.TAG, "translate# TranslatePageListener onFailed(unavailable).");
                        TranslationOverlayManager.this.mTranslatePageListener.onFailed(1, "unavailable");
                        TranslationOverlayManager.this.mTranslatePageListener = null;
                    }
                }
            });
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mLanguageModel.save(bundle);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onUpdatePage(int i, int i2, int i4, PageManager.PageUpdateState pageUpdateState) {
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "onUpdatePage# type : ", ", from : ", ", to : ");
        sbM1173s.append(i4);
        sbM1173s.append(", pages count : (");
        sbM1173s.append(pageUpdateState.getPageIdList().size());
        sbM1173s.append(") ");
        sbM1173s.append(pageUpdateState.getPageIdList());
        Logger.m10999d(str, sbM1173s.toString());
        if (i != 2 || i2 == i4 || this.mPageIndexMap.size() == 0) {
            return;
        }
        String str2 = this.mPageIndexMap.get(Integer.valueOf(i2));
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        deletedPage(str2);
        insertedPage(str2);
        this.mComposerViewPresenter.getPdfManager().requestReloadOverlayPages();
    }

    public void onWindowModeChanged() {
        if (!this.mIsActivated && !this.mLanguageSelector.isShowing()) {
            Logger.m10999d(TAG, "onWindowModeChanged# Ignored by inactivated.");
            return;
        }
        Logger.m10999d(TAG, "onWindowModeChanged# AiCacheMap size : " + this.mAiCacheMap.size());
        this.mComposerViewPresenter.getPdfManager().setTranslationCacheMap(this.mAiCacheMap);
    }

    public void release() {
        releaseTranslator();
        releaseImageTranslator();
    }

    public void reload() {
        String str = TAG;
        Logger.m10999d(str, "reload#");
        this.mLanguageModel.save();
        this.mPageIndexStack.clear();
        this.mAiCacheMap.clear();
        this.mImagePageIndexStack.clear();
        this.mImageOverlayCacheMap.clear();
        setStopImageOverlay(false);
        if (FeatureInfo.isPdfImageTranslationSupported()) {
            this.mComposerViewPresenter.getPdfManager().clearAllOverlayImage();
            updateImageOverlayLanguage();
        }
        if (!this.mIsActivated) {
            Logger.m10999d(str, "reload# Ignored by invalid status");
            return;
        }
        clearSelectionText();
        this.mIsTranslated = false;
        this.mComposerViewPresenter.getPdfManager().clearAllOverlayText();
        this.mComposerViewPresenter.getPdfManager().clearTranslationCacheMap();
        this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(false);
        this.mComposerViewPresenter.getPdfManager().requestReloadOverlayPages();
        this.mLanguageSelector.reload();
    }

    public void requestTranslate(int i, TaskListener taskListener) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "requestTranslate# pageIndex : ", ", from : ");
        sbM778t.append(this.mLanguageModel.getFromLanguageTag());
        sbM778t.append(", to : ");
        sbM778t.append(this.mLanguageModel.getToLanguageTag());
        Logger.m10999d(str, sbM778t.toString());
        this.mTranslatePageListener = taskListener;
        if (isTranslated(i) || this.mLanguageModel.isSame()) {
            this.mRequestedPage = -1;
            AbstractC0000a.m3D(i, "requestTranslate# onCompleted. already translated data. page : ", str);
            this.mTranslatePageListener.onCompleted();
            this.mTranslatePageListener = null;
            return;
        }
        this.mRequestedPage = i;
        int stateTranslationOverlayPage = getStateTranslationOverlayPage(i);
        if (stateTranslationOverlayPage == 0 || stateTranslationOverlayPage == 1) {
            AbstractC0000a.m3D(i, "requestTranslate# already requested data. page : ", str);
        } else {
            translatePdfPage(i);
        }
    }

    public void restoreTranslate(Bundle bundle) {
        this.mLanguageModel.restore(bundle);
    }

    public void setCloseListener(CloseListener closeListener) {
        this.mCloseListener = closeListener;
    }

    public void setStopImageOverlay(boolean z) {
        this.mStopImageOverlay = z;
    }

    public void showLanguageSelectorDialog(boolean z) {
        showLanguageSelectorDialog(z, 0.0f, 0.0f);
    }

    public void start(@Nullable String str) {
        if (this.mComposerViewPresenter == null) {
            Logger.m10999d(TAG, "start# ignored by invalid status");
            return;
        }
        if (this.mComposerModel.getComposerState().isTranslated()) {
            String str2 = TAG;
            Logger.m10999d(str2, "start# enable to translate in pdf overlay");
            this.mIsCanceled = false;
            ViewStub viewStub = (ViewStub) this.mComposerViewPresenter.getActivity().findViewById(C9086R.id.scanning_effect_view_stub);
            if (viewStub != null) {
                viewStub.inflate();
            }
            if (!isStoppedTemporarily()) {
                Logger.m10999d(str2, "start# activate");
                this.mIsActivated = true;
                if (TextUtils.isEmpty(str) && this.mIsTranslated) {
                    str = this.mLanguageModel.getToLanguageTagFromRepository();
                    AbstractC8014b.m7196B("start# getToLanguageTagFromRepository targetLanguage : ", str, str2);
                }
            }
            if (this.mExecutorService == null) {
                Logger.m10999d(str2, "start# create ExecutorService");
                this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(str2));
            }
            if (isStoppedTemporarily()) {
                this.mAiCacheMap.clear();
                this.mAiCacheMap.putAll(this.mComposerViewPresenter.getPdfManager().getTranslationCacheMap());
            }
            this.mComposerViewPresenter.getPdfManager().clearTranslationCacheMap();
            int i = this.mTranslateCnt.get();
            Logger.m10999d(str2, "start# isActivated : " + this.mIsActivated + ", isTranslated : " + this.mIsTranslated + ", translateCnt : " + i);
            if (this.mIsActivated && (this.mIsTranslated || i > 0)) {
                this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(true);
            }
            if (this.mPageIndexMap.size() == 0) {
                for (int i2 = 0; i2 < this.mComposerModel.getDoc().getPageCount(); i2++) {
                    this.mPageIndexMap.put(Integer.valueOf(i2), this.mComposerModel.getDoc().getPageIdByIndex(i2));
                }
            }
            if (!TextUtils.isEmpty(str)) {
                String toLanguageTag = this.mLanguageModel.getToLanguageTag();
                Logger.m10999d(TAG, "start# targetLanguage : " + str + ", current toLanguage : " + toLanguageTag);
                if (TextUtils.isEmpty(toLanguageTag) || !str.equals(toLanguageTag)) {
                    this.mLanguageModel.setToLanguageTag(str);
                }
                if (!TextUtils.isEmpty(toLanguageTag) && !str.equals(toLanguageTag) && this.mIsActivated) {
                    initLanguageSelector();
                    setPdfPageListener();
                    reload();
                    return;
                }
                this.mLanguageModel.save();
            }
            clearSelectionText();
            initLanguageSelector();
            initOverlayText();
            this.mLanguageSelector.showProcessingEffectView();
        } else {
            Logger.m10999d(TAG, "start# disable to translate in pdf overlay");
            this.mIsActivated = false;
            this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(false);
            this.mLanguageSelector.hide();
        }
        initBroadcastReceiverForLanguage();
    }

    public void stop() {
        if (isStoppedTemporarily()) {
            Logger.m10999d(TAG, "stop# Ignored by onConfigurationChanged");
            return;
        }
        Logger.m10999d(TAG, "stop#");
        if (this.mTranslateCnt.get() == 1) {
            this.mTranslateCnt.set(0);
            this.mIsCanceled = true;
            this.mLanguageSelector.hideTranslationProgress();
        }
        int translatedPageCount = this.mComposerViewPresenter.getPdfManager().getTranslatedPageCount();
        if (translatedPageCount > 0) {
            ComposerSA.insertLog(this.mLanguageSelector.getScreenID(), ComposerSAConstants.EVENT_PDF_VIEWER_NUMBER_OF_TRANSLATED_PAGES, String.valueOf(translatedPageCount));
        }
        this.mIsActivated = false;
        this.mComposerViewPresenter.getPdfManager().setOverlayTextEnable(false);
        this.mComposerViewPresenter.getPdfManager().setPdfPageListener(null);
        releaseTranslator();
        this.mAiCacheMap.clear();
        this.mPageIndexStack.clear();
        this.mLanguageSelector.release();
        this.mLanguageIdentifier = null;
        clearBroadcastReceiverForLanguage();
        releaseImageTranslator();
        this.mImageOverlayCacheMap.clear();
        this.mImagePageIndexStack.clear();
    }

    public void translateAll(TaskListener taskListener, @NonNull SparseArray<String[]> sparseArray, @NonNull SparseArray<Bitmap> sparseArray2) {
        String str = TAG;
        Logger.m10999d(str, "translateAll# translationMap : " + sparseArray.size());
        this.mTranslateAllListener = taskListener;
        SpenPdfWriter spenPdfWriter = this.mSpenPdfWriter;
        if (spenPdfWriter == null) {
            taskListener.onFailed(1, "invalid request");
            this.mTranslateAllListener = null;
            return;
        }
        int pageCount = spenPdfWriter.getPageCount();
        this.mLanguageModel.updateFromLanguageTagFromRepository();
        this.mLanguageModel.updateToLanguageTagFromRepository();
        Logger.m10999d(str, "translateAll# count : " + pageCount + ", from : " + this.mLanguageModel.getFromLanguageTag() + ", to : " + this.mLanguageModel.getToLanguageTag());
        if (this.mLanguageModel.isSame() && sparseArray.size() == 0 && sparseArray2.size() == 0) {
            this.mTranslateAllListener.onFailed(3, "Can't translate");
            this.mTranslateAllListener = null;
            return;
        }
        if (sparseArray.size() != 0 || sparseArray2.size() != 0) {
            this.mIsTranslated = true;
        }
        this.mTranslateAllRequested.set(false);
        this.mTranslateAllCnt.set(0);
        for (int i = 0; i < pageCount; i++) {
            String[] strArr = sparseArray.get(i);
            if (strArr != null) {
                String str2 = TAG;
                AbstractC0000a.m3D(i, "translateAll# already translated data. page : ", str2);
                ArrayList<SpenPdfParagraph> arrayList = SpenPdfTextConverter.parse(strArr);
                if (arrayList != null) {
                    this.mSpenPdfWriter.setOverlayRichText(i, arrayList, this.mLanguageModel.getToLanguageTag());
                    Iterator<SpenPdfParagraph> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().getListPdfText().clear();
                    }
                    arrayList.clear();
                } else {
                    Logger.m11000e("AI" + str2, "setOverlayTaggedText# paragraphs is null");
                }
            } else {
                this.mTranslateAllCnt.incrementAndGet();
                translatePdfPage(i);
            }
        }
        this.mTranslateImageAllCnt.set(0);
        if (FeatureInfo.isPdfImageTranslationSupported()) {
            Logger.m10999d(TAG, "translateAll# translationImageMap : " + sparseArray2.size());
            for (int i2 = 0; i2 < pageCount; i2++) {
                Bitmap bitmap = sparseArray2.get(i2);
                if (bitmap != null) {
                    AbstractC0000a.m3D(i2, "translateAll#Image already translated data. page : ", TAG);
                    this.mSpenPdfWriter.setOverlayImage(i2, bitmap);
                } else {
                    translateImageOverlay(i2, this.mTranslateImageAllCnt.incrementAndGet() > 1);
                }
            }
        }
        this.mTranslateAllRequested.set(true);
        int i4 = this.mTranslateAllCnt.get();
        int i5 = this.mTranslateImageAllCnt.get();
        if (i4 == 0 && i5 == 0) {
            onCompletedTranslateAll();
        } else {
            int i6 = i4 + i5;
            this.mTranslateAllRequestedCnt = i6;
            this.mTranslateAllListener.onProgress(0, i6);
        }
        ComposerSA.insertLog(this.mComposerViewPresenter.getComposerModel().getModeManager().isEditMode() ? ComposerSAConstants.SCREEN_PDF_VIEWER_EDIT : ComposerSAConstants.SCREEN_PDF_VIEWER, ComposerSAConstants.EVENT_PDF_VIEWER_ADD_TO_WITH_TRANSLATION, String.valueOf(pageCount));
    }

    public void updateLanguage() {
        this.mLanguageSelector.updateLanguage();
    }

    public void showLanguageSelectorDialog(final boolean z, final float f, final float f4) {
        Activity activity = this.mComposerViewPresenter.getActivity();
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        activity.runOnUiThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.11
            @Override // java.lang.Runnable
            public void run() {
                FragmentManager supportFragmentManager = TranslationOverlayManager.this.getSupportFragmentManager();
                if (supportFragmentManager == null || supportFragmentManager.isDestroyed()) {
                    return;
                }
                TranslationOverlayManager.this.mLanguageSelector.showLanguageSelectorDialog(z, f, f4, supportFragmentManager);
            }
        });
    }

    public TranslationOverlayManager(ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, MenuPresenterContract.IMenuManager iMenuManager) {
        this.mPageIndexMap = new ConcurrentHashMap();
        this.mAiCacheMap = new ConcurrentHashMap();
        this.mRequestedPage = -1;
        this.mTranslateCnt = new AtomicInteger(0);
        this.mTranslateAllCnt = new AtomicInteger(0);
        this.mTranslateImageAllCnt = new AtomicInteger(0);
        this.mTranslateAllRequested = new AtomicBoolean(false);
        this.mPageIndexStack = new ConcurrentLinkedDeque();
        String str = TAG;
        this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(str));
        TranslationLanguageModel translationLanguageModel = new TranslationLanguageModel();
        this.mLanguageModel = translationLanguageModel;
        this.mImageOverlayCacheMap = new ConcurrentHashMap();
        this.mImagePageIndexStack = new ConcurrentLinkedDeque();
        this.mStopImageOverlay = false;
        this.mIsActivated = false;
        this.mIsTranslated = false;
        this.mIsCanceled = false;
        this.mIsNeedCheckLanguage = false;
        this.mIsRequestedDownloadLanguage = false;
        Logger.m10999d(str, "TranslationOverlayManager# created");
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
        this.mMenuManager = iMenuManager;
        TranslationLanguageSelector translationLanguageSelector = new TranslationLanguageSelector(translationLanguageModel);
        this.mLanguageSelector = translationLanguageSelector;
        this.mUiHandler = new Handler(Looper.getMainLooper());
        if (composerViewPresenter != null && composerModel != null) {
            composerViewPresenter.getPageManager().addListener(this);
            composerViewPresenter.getNoteManager().addBackgroundColorObserver(translationLanguageSelector);
        }
        this.mResultListener = new TextTranslator.ResultListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TextTranslator.ResultListener
            public void onResult(@NonNull String[] strArr, String str2, String str3) {
                if (!TranslationOverlayManager.this.updateResult(0, strArr, str2, str3, true)) {
                    if (TranslationOverlayManager.this.isTranslating()) {
                        return;
                    }
                    TranslationOverlayManager.this.mLanguageSelector.hideTranslationProgress();
                    return;
                }
                int i = TranslationOverlayManager.this.mTranslateCnt.get();
                Logger.m10999d(TranslationOverlayManager.TAG, "ResultListener#onResult pageIndex : " + TranslationOverlayManager.this.mTranslatePageIndex + ", translateCnt : " + i);
                if (i == 1) {
                    synchronized (TranslationOverlayManager.this.mAiCacheMap) {
                        while (true) {
                            try {
                                if (!TranslationOverlayManager.this.mPageIndexStack.isEmpty()) {
                                    Integer num = (Integer) TranslationOverlayManager.this.mPageIndexStack.removeLast();
                                    Pair pair = (Pair) TranslationOverlayManager.this.mAiCacheMap.get(num);
                                    Logger.m10999d(TranslationOverlayManager.TAG, "ResultListener#onResult key : " + num);
                                    if (pair != null) {
                                        if (((Integer) pair.first).intValue() == 0) {
                                            Object obj = pair.second;
                                            if (obj == null || ((String[]) obj).length == 0) {
                                                if (TranslationOverlayManager.this.getPageTextArray(num.intValue()) == null) {
                                                    TranslationOverlayManager.this.updateTranslationOverlayPage(num.intValue(), 2);
                                                } else {
                                                    pair = (Pair) TranslationOverlayManager.this.mAiCacheMap.get(num);
                                                }
                                            }
                                            if (pair != null) {
                                                TranslationOverlayManager.this.startTranslate(num, (String[]) pair.second);
                                                break;
                                            }
                                            TranslationOverlayManager.this.updateTranslationOverlayPage(num.intValue(), 2);
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        String[] pageTextArray = TranslationOverlayManager.this.getPageTextArray(num.intValue());
                                        if (pageTextArray != null) {
                                            TranslationOverlayManager.this.startTranslate(num, pageTextArray);
                                            break;
                                        }
                                        TranslationOverlayManager.this.updateTranslationOverlayPage(num.intValue(), 2);
                                    }
                                } else {
                                    TranslationOverlayManager.this.mTranslateCnt.set(0);
                                    break;
                                }
                            } finally {
                            }
                        }
                    }
                }
                if (!TranslationOverlayManager.this.isTranslating()) {
                    TranslationOverlayManager.this.mLanguageSelector.hideTranslationProgress();
                }
                if (TranslationOverlayManager.this.mTranslateAllListener != null) {
                    int i2 = TranslationOverlayManager.this.mTranslateAllCnt.get();
                    int i4 = TranslationOverlayManager.this.mTranslateImageAllCnt.get();
                    AbstractC8014b.m7216r(i2, i4, "ResultListener#onResult check translateAllCnt : ", ", translateImageAllCnt : ", TranslationOverlayManager.TAG);
                    if (i2 == 0 && i4 == 0) {
                        TranslationOverlayManager.this.onCompletedTranslateAll();
                    }
                }
                if (TranslationOverlayManager.this.mTranslatePageListener != null) {
                    Logger.m10999d(TranslationOverlayManager.TAG, "ResultListener#onResult check requestedPage : " + TranslationOverlayManager.this.mRequestedPage);
                    if (TranslationOverlayManager.this.mRequestedPage == TranslationOverlayManager.this.mTranslatePageIndex) {
                        TranslationOverlayManager.this.mRequestedPage = -1;
                        Logger.m10999d(TranslationOverlayManager.TAG, "translate# TranslatePageListener onCompleted.");
                        TranslationOverlayManager.this.mTranslatePageListener.onCompleted();
                        TranslationOverlayManager.this.mTranslatePageListener = null;
                    }
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TextTranslator.ResultListener
            public void onUpdate(int i, @NonNull String[] strArr, String str2, String str3) {
                String str4 = TranslationOverlayManager.TAG;
                StringBuilder sb = new StringBuilder("ResultListener#onUpdate pageIndex : ");
                sb.append(TranslationOverlayManager.this.mTranslatePageIndex);
                sb.append(", startIndex : ");
                sb.append(i);
                sb.append(", length : ");
                AbstractC8014b.m7221w(sb, str4, strArr.length);
                if (TranslationOverlayManager.this.mPartialResultArray == null || TranslationOverlayManager.this.mPartialResultArray.length < strArr.length + i) {
                    Logger.m10999d(TranslationOverlayManager.TAG, "ResultListener#onUpdate Ignored by invalid data.");
                    return;
                }
                System.arraycopy(strArr, 0, TranslationOverlayManager.this.mPartialResultArray, i, strArr.length);
                if (TranslationOverlayManager.this.mPartialResultStartIndex + 1 == i) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = i; i2 < TranslationOverlayManager.this.mPartialResultArray.length && !TextUtils.isEmpty(TranslationOverlayManager.this.mPartialResultArray[i2]); i2++) {
                        arrayList.add(TranslationOverlayManager.this.mPartialResultArray[i2]);
                    }
                    TranslationOverlayManager.this.updateResult(i, (String[]) arrayList.toArray(new String[0]), str2, str3, false);
                    TranslationOverlayManager translationOverlayManager = TranslationOverlayManager.this;
                    translationOverlayManager.mPartialResultStartIndex = arrayList.size() + translationOverlayManager.mPartialResultStartIndex;
                }
            }
        };
    }

    public static String getTextToIdentifyForLanguage(int i, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("http") && TextTranslator.isValidText(str2)) {
                    if (str2.length() > str.length()) {
                        str = str2;
                    }
                    if (sb.length() <= 500) {
                        sb.append(str2);
                    }
                }
            }
            return sb.length() <= 500 ? sb.toString() : str;
        }
        Logger.m11000e(TAG, "getTextToIdentifyForLanguage : is empty ");
        return "";
    }
}
