package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.print.PdfPrint;
import android.print.PrintAttributes;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.core.widget.NestedScrollView;
import androidx.work.impl.RunnableC4054d;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskDownloadAudio;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskWebClip extends SingleThreadTask<InputValues, ResultValues> {
    private static final String AUDIO_TYPE = "audio";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final int ERROR_CREATE_PDF_TIMEOUT = 3;
    private static final int ERROR_CREATE_PDF_WRITE_FAILED = 4;
    private static final int ERROR_LOAD_FAIL = 1;
    private static final int ERROR_UNSUPPORTED_FILE = 2;
    private static final String EXCEPTION_URL = "samsung.com";
    private static final String IMAGE_TYPE = "image";
    private static final long MAX_TIME_LOAD = 60000;
    private static final int MAX_TRY_COUNT_FOR_CONVERT_WEB_TO_PDF = 1;
    private static final long MIN_TIME_LOAD = 3000;
    private static final String TAG = Logger.createTag("TaskWebClip");
    private static final long TIME_DELAY_EXPORT = 5000;
    private static final String WWW = "www.";
    private boolean mAddImageAudioDone;
    private State mCurrentState;
    private Handler mHandlerWeb;
    private int mHeight;
    private TaskAddPdf mTaskAddPdf;
    private long mTimeInfo;
    private int mWidth;
    private ViewGroup mParent = null;
    private NestedScrollView mNestScroll = null;
    private WebView mWebView = null;
    private String mPathPdf = null;
    private ArrayList<String> mTmpPath = null;
    private String mTitle = null;
    private boolean mCreatePdfDone = false;
    private boolean mIsLoadFail = false;
    private boolean mPageFinish = false;
    private boolean mPageFinishTmp = false;
    private final AtomicBoolean mIsConvert = new AtomicBoolean(false);
    private long mTimeStart = 0;
    private boolean mIsCanceled = false;
    private boolean mIsLongRatio = false;
    private boolean mIsLandscape = false;
    private boolean mIsInfinite = false;
    private List<Uri> mPdfUriList = null;
    private List<String> mPdfUriPath = null;
    private int mError = 0;
    boolean enableJS = true;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClip$6 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C100456 implements Task.Callback<TaskAddPdf.ResultValues> {
        final /* synthetic */ boolean[] val$addPdfDone;
        final /* synthetic */ int val$curPageIndex;
        final /* synthetic */ InputValues val$inputValues;

        public C100456(boolean[] zArr, int i, InputValues inputValues) {
            this.val$addPdfDone = zArr;
            this.val$curPageIndex = i;
            this.val$inputValues = inputValues;
        }

        private void goToInsertedPage(int i, int i2) {
            if (this.val$inputValues.mNoteManager.getNote().getPageMode() != SpenWNote.PageMode.LIST || i == i2) {
                return;
            }
            this.val$inputValues.mPageScroller.goToPage(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public /* synthetic */ void lambda$notifyViewUpdate$0(TaskAddPdf.ResultValues resultValues, int i) {
            resultValues.notifyPageUpdate();
            ((InputValues) TaskWebClip.this.getInputValue()).mNoteManager.updateInvertBackgroundColor();
            if (((InputValues) TaskWebClip.this.getInputValue()).mTextManager != null && !TextUtils.isEmpty(TaskWebClip.this.mTitle) && TextUtils.isEmpty(((InputValues) TaskWebClip.this.getInputValue()).mTextManager.getTitle())) {
                ((InputValues) TaskWebClip.this.getInputValue()).mTextManager.setTitle(TaskWebClip.this.mTitle);
            }
            goToInsertedPage(i, resultValues.getFirstPageIndex().intValue());
        }

        private void notifyViewUpdate(TaskAddPdf.ResultValues resultValues) {
            TaskWebClip.this.mHandlerWeb.post(new RunnableC10049b(this, resultValues, this.val$curPageIndex));
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(TaskAddPdf.ResultValues resultValues) {
            TaskWebClip taskWebClip = TaskWebClip.this;
            taskWebClip.mError = resultValues.mErrorCode | taskWebClip.mError;
            TaskWebClip taskWebClip2 = TaskWebClip.this;
            taskWebClip2.notifyCallback(false, new ResultValues(taskWebClip2.mError));
            this.val$addPdfDone[0] = true;
            Logger.m11003i(TaskWebClip.TAG, "addPdf finish: error | " + (System.currentTimeMillis() - TaskWebClip.this.mTimeInfo) + "ms |mError " + TaskWebClip.this.mError);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(TaskAddPdf.ResultValues resultValues) {
            TaskWebClip.this.mError |= resultValues.mErrorCode;
            notifyViewUpdate(resultValues);
            TaskWebClip taskWebClip = TaskWebClip.this;
            taskWebClip.notifyCallback(true, new ResultValues(taskWebClip.mError));
            this.val$addPdfDone[0] = true;
            Logger.m11003i(TaskWebClip.TAG, "addPdf finish: success | " + (System.currentTimeMillis() - TaskWebClip.this.mTimeInfo) + "ms |mError " + TaskWebClip.this.mError);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private final boolean mIsLimitPdfFileSize;
        private final NoteManager mNoteManager;
        private final ObjectManager mObjectManager;
        private final PageManager mPageManager;
        private final TaskContract.IPageScroller mPageScroller;
        private final PdfManager mPdfManager;
        private final TextManager mTextManager;
        private final String mUrl;

        public InputValues(Context context, NoteManager noteManager, PdfManager pdfManager, PageManager pageManager, TextManager textManager, TaskContract.IPageScroller iPageScroller, String str, boolean z, ObjectManager objectManager, ComposerModel composerModel) {
            this.mContext = context;
            this.mNoteManager = noteManager;
            this.mPdfManager = pdfManager;
            this.mPageManager = pageManager;
            this.mTextManager = textManager;
            this.mPageScroller = iPageScroller;
            this.mUrl = str;
            this.mIsLimitPdfFileSize = z;
            this.mObjectManager = objectManager;
            this.mComposerModel = composerModel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        int mErrorCode;

        public ResultValues(int i) {
            this.mErrorCode = i;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        LOAD_WEB,
        EXPORT_PDF,
        ADD_PDF
    }

    private void addImage(InputValues inputValues, Uri uri) {
        boolean[] zArr = {false};
        Logger.m10999d(TAG, "addImage start");
        long currentTime = TimeManager.getCurrentTime();
        this.mHandlerWeb.post(new RunnableC10051d(this, uri, inputValues, zArr));
        while (!zArr[0] && !this.mIsCanceled) {
            waitForDownloadImageOrAudio();
        }
        long currentTime2 = TimeManager.getCurrentTime() - currentTime;
        Logger.m10999d(TAG, "addImage end time = " + currentTime2);
    }

    private void addPdf(InputValues inputValues, List<Uri> list, List<String> list2) {
        if (this.mIsCanceled || this.mIsLoadFail) {
            return;
        }
        changeState(State.ADD_PDF);
        boolean[] zArr = {false};
        Logger.m10999d(TAG, "addPdf start");
        this.mHandlerWeb.post(new RunnableC4054d(this, inputValues, list, list2, zArr, 4));
        while (!zArr[0] && !this.mIsCanceled) {
            waitForPdf();
        }
        Logger.m10999d(TAG, "addPdf end");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void checkLongRatio() {
        double dSqrt;
        SpenWNote note = ((InputValues) getInputValue()).mNoteManager.getNote();
        if (note.getPageMode() == SpenWNote.PageMode.SINGLE) {
            this.mIsLongRatio = true;
            this.mIsInfinite = true;
        } else if (note.getPageMode() == SpenWNote.PageMode.LIST) {
            int width = note.getPage(0).getWidth();
            int height = note.getPage(0).getHeight();
            if (DocumentPageRatio.PageRatioType.LONG.equal(note.getOrientation() == SpenWNote.Orientation.LANDSCAPE ? width / height : height / width)) {
                this.mIsLongRatio = true;
            }
            if (note.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW) {
                this.mIsLandscape = true;
            }
        }
        DisplayMetrics displayMetrics = ((InputValues) getInputValue()).mContext.getResources().getDisplayMetrics();
        if (this.mIsLandscape) {
            dSqrt = 1.0d / Math.sqrt(2.0d);
        } else {
            dSqrt = this.mIsLongRatio ? 2.0d : Math.sqrt(2.0d);
        }
        float f = displayMetrics.density;
        this.mHeight = (int) (((double) (f * 788.0f)) * dSqrt);
        this.mWidth = (int) (f * 788.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearWeb() {
        Logger.m11003i(TAG, "clearWeb#");
        NestedScrollView nestedScrollView = this.mNestScroll;
        if (nestedScrollView != null) {
            this.mParent.removeView(nestedScrollView);
            WebView webView = this.mWebView;
            if (webView != null) {
                this.mNestScroll.removeView(webView);
            }
            this.mNestScroll = null;
        }
        WebView webView2 = this.mWebView;
        if (webView2 != null) {
            this.mParent.removeView(webView2);
            this.mWebView.setWebViewClient(null);
            this.mWebView.setWebChromeClient(null);
            this.mWebView.loadUrl("about:blank");
            this.mWebView.clearCache(true);
            this.mWebView.stopLoading();
            this.mWebView.getSettings().setJavaScriptEnabled(false);
            this.mWebView.clearHistory();
            this.mWebView.removeAllViews();
            this.mWebView.destroyDrawingCache();
            this.mWebView.destroy();
            this.mWebView = null;
            WebStorage.getInstance().deleteAllData();
        }
        ArrayList<String> arrayList = this.mTmpPath;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (String str : this.mTmpPath) {
                File file = new File(str);
                if (file.exists()) {
                    String str2 = TAG;
                    StringBuilder sbM15l = AbstractC0000a.m15l("delete: ", str, " | ");
                    sbM15l.append(file.delete());
                    Logger.m11003i(str2, sbM15l.toString());
                }
            }
            this.mTmpPath.clear();
            Logger.m11003i(TAG, "total time web = " + (System.currentTimeMillis() - this.mTimeStart) + "ms");
        }
        if (this.mPathPdf != null) {
            File file2 = new File(this.mPathPdf);
            if (file2.exists()) {
                Logger.m11003i(TAG, "delete: " + this.mPathPdf + " | " + file2.delete());
            }
            this.mPathPdf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertWebToPdf, reason: merged with bridge method [inline-methods] */
    public void lambda$tryToConvertWebToPDF$5(final Context context, final int i) {
        PrintAttributes.MediaSize mediaSize;
        if (this.mIsCanceled || this.mIsLoadFail || i > 1) {
            return;
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "convertWebToPdf start: count = ", " | web = ");
        sbM778t.append(this.mWebView.getProgress());
        Logger.m11003i(str, sbM778t.toString());
        changeState(State.EXPORT_PDF);
        String str2 = "pdf_" + System.currentTimeMillis() + Constants.PDF_EXTENSION_WITH_DOT;
        String strM772n = AbstractC0541b.m772n("Notes", str2);
        if (this.mIsLandscape) {
            mediaSize = PrintAttributes.MediaSize.ISO_A4.asLandscape();
        } else if (this.mIsLongRatio) {
            PrintAttributes.MediaSize mediaSize2 = PrintAttributes.MediaSize.ISO_A4;
            mediaSize = new PrintAttributes.MediaSize("2A4", "2A4", mediaSize2.getWidthMils(), mediaSize2.getWidthMils() * 2);
        } else {
            mediaSize = PrintAttributes.MediaSize.ISO_A4;
        }
        PrintAttributes printAttributesBuild = new PrintAttributes.Builder().setMediaSize(mediaSize).setResolution(new PrintAttributes.Resolution(Constants.PDF_EXTENSION, Constants.PDF_EXTENSION, 600, 600)).setMinMargins(PrintAttributes.Margins.NO_MARGINS).build();
        if (context == null || context.getCacheDir() == null) {
            this.mIsLoadFail = true;
            Logger.m11000e(str, "savePdfToFileCache# failed - The path is null");
            return;
        }
        File file = new File(context.getCacheDir().toString() + "/pdf/");
        this.mTmpPath.add(file.getPath() + File.separator + str2);
        StringBuilder sb = new StringBuilder("convertWebToPdf attributes: ");
        sb.append(printAttributesBuild);
        Logger.m11003i(str, sb.toString());
        new PdfPrint(printAttributesBuild).print(this.mWebView.createPrintDocumentAdapter(strM772n), file, str2, new PdfPrint.CallBack() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClip.5
            @Override // android.print.PdfPrint.CallBack
            public void onLayoutCancelled() {
                Logger.m11003i(TaskWebClip.TAG, "convertWebToPdf Cancelled");
                TaskWebClip.this.mIsLoadFail = true;
                TaskWebClip.this.mError |= 3;
                ToastHandler.show(context, C9086R.string.webclip_connect_error, 0);
            }

            @Override // android.print.PdfPrint.CallBack
            public void onLayoutFailed(CharSequence charSequence) {
                Logger.m11003i(TaskWebClip.TAG, "convertWebToPdf Failed: " + ((Object) charSequence));
                if (TaskWebClip.this.mIsCanceled) {
                    return;
                }
                if (i < 1) {
                    Logger.m11003i(TaskWebClip.TAG, "convertWebToPdf try to convert again");
                    TaskWebClip.this.tryToConvertWebToPDF(context, i + 1);
                } else {
                    TaskWebClip.this.mIsLoadFail = true;
                    TaskWebClip.this.mError |= 4;
                    ToastHandler.show(context, C9086R.string.webclip_connect_error, 0);
                }
            }

            @Override // android.print.PdfPrint.CallBack
            public void onWriteFinished(String str3) {
                TaskWebClip.this.mWebView.stopLoading();
                TaskWebClip.this.mPathPdf = str3;
                TaskWebClip.this.mCreatePdfDone = true;
                if (TaskWebClip.this.mIsCanceled) {
                    TaskWebClip.this.clearWeb();
                }
                if (ContextUtils.isNightMode(context)) {
                    ToastHandler.show(context, C9086R.string.dark_mode_not_applied_has_pdf_toast_msg, 0);
                }
                Logger.m11003i(TaskWebClip.TAG, "convertWebToPdf end: time = " + (System.currentTimeMillis() - TaskWebClip.this.mTimeInfo) + "ms | path: " + str3);
            }
        });
    }

    @SuppressLint({"SetJavaScriptEnabled", "SdCardPath", "WrongConstant"})
    private void createPdf(Context context, String str) {
        changeState(State.LOAD_WEB);
        checkLongRatio();
        this.mHandlerWeb.post(new RunnableC8928b(this, 15, context, str));
        while (true) {
            if (!this.mIsCanceled && !this.mIsLoadFail && (this.mWebView == null || !this.mCreatePdfDone)) {
                State state = this.mCurrentState;
                if (state != State.LOAD_WEB) {
                    if (state != State.EXPORT_PDF) {
                        Logger.m11003i(TAG, "other state: " + this.mCurrentState);
                        break;
                    }
                    waitForPdf();
                } else if (System.currentTimeMillis() - this.mTimeInfo >= 60000) {
                    if (this.mWebView == null) {
                        this.mIsLoadFail = true;
                        break;
                    }
                    if (!this.mPageFinish) {
                        Logger.m11003i(TAG, "loading web timeout");
                        loadFinish();
                    }
                    waitForPdf();
                } else {
                    waitForPdf();
                }
            } else {
                break;
            }
        }
        if (this.mIsCanceled || this.mIsLoadFail) {
            notifyCallback(false, new ResultValues(this.mError));
            return;
        }
        if (this.mPathPdf != null) {
            this.mPdfUriList = new ArrayList();
            this.mPdfUriPath = new ArrayList();
            String mimeType = UriFileUtils.getMimeType(context, Uri.parse(this.mPathPdf));
            if (mimeType == null || !mimeType.startsWith(Constants.MIME_PDF)) {
                this.mError |= 2;
            } else {
                this.mPdfUriList.add(Uri.parse(this.mPathPdf));
                this.mPdfUriPath.add(this.mPathPdf);
            }
        }
    }

    private void downloadAudio(Uri uri, InputValues inputValues) {
        boolean[] zArr = {false};
        Logger.m10999d(TAG, "addAudio start");
        long currentTime = TimeManager.getCurrentTime();
        this.mHandlerWeb.post(new RunnableC10051d(this, inputValues, uri, zArr));
        while (!zArr[0] && !this.mIsCanceled) {
            waitForDownloadImageOrAudio();
        }
        long currentTime2 = TimeManager.getCurrentTime() - currentTime;
        Logger.m10999d(TAG, "addAudio end time = " + currentTime2);
    }

    private String getMediaJavascript(String str) {
        return AbstractC0541b.m773o("javascript:(function () { try {var videoEs = document.getElementsByTagName('video');if (videoEs != null && videoEs.length > 0) {for (var i = 0; i < videoEs.length; i++) {if(videoEs[i].autoplay) { videoEs[i].autoplay = false; }if (videoEs[i].currentTime > 0 && !videoEs[i].paused) { videoEs[i].pause(); }", str, "}}} catch (e) {}})()");
    }

    private void includeView(Context context) {
        this.mParent = (ViewGroup) ((Activity) context).getWindow().getDecorView();
        this.mNestScroll = new NestedScrollView(context);
        WebView webView = new WebView(context);
        this.mWebView = webView;
        this.mNestScroll.addView(webView, new ViewGroup.LayoutParams(this.mWidth, -2));
        this.mParent.addView(this.mNestScroll, 0, new ViewGroup.LayoutParams(this.mWidth, this.mHeight));
        this.mNestScroll.setVisibility(4);
    }

    private void insertPdf(InputValues inputValues) {
        setEnableJS(inputValues.mUrl);
        createPdf(inputValues.mContext, inputValues.mUrl);
        addPdf(inputValues, this.mPdfUriList, this.mPdfUriPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addImage$1(Uri uri, InputValues inputValues, final boolean[] zArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(uri);
        TaskAddImage.InputValues inputValues2 = new TaskAddImage.InputValues(inputValues.mContext, inputValues.mPageManager.getDocPageInfo().getCurrentPageIndex(), arrayList, inputValues.mObjectManager, inputValues.mComposerModel);
        TaskAddImage taskAddImage = new TaskAddImage();
        taskAddImage.setStorageChecker(this.mStorageChecker);
        taskAddImage.setTaskCallback(new Task.Callback<TaskAddImage.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClip.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskAddImage.ResultValues resultValues) {
                Logger.m11003i(TaskWebClip.TAG, "TaskWebClip# addImage # onSuccess# " + resultValues.getErrorCode());
                TaskWebClip.this.mAddImageAudioDone = false;
                zArr[0] = true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskAddImage.ResultValues resultValues) {
                Logger.m11003i(TaskWebClip.TAG, "TaskWebClip# addImage # onSuccess# ");
                TaskWebClip.this.mAddImageAudioDone = true;
                zArr[0] = true;
            }
        });
        taskAddImage.setInputValue(inputValues2);
        taskAddImage.executeTask(inputValues2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addPdf$6(InputValues inputValues, List list, List list2, boolean[] zArr) {
        if (this.mIsInfinite) {
            inputValues.mNoteManager.getNote().setPageVerticalPadding(0);
        }
        int currentPageIndex = inputValues.mPageManager.getDocPageInfo().getCurrentPageIndex();
        TaskAddPdf.InputValues inputValues2 = new TaskAddPdf.InputValues(inputValues.mContext, inputValues.mNoteManager, inputValues.mPdfManager, inputValues.mPageManager, inputValues.mTextManager, null, list, list2, currentPageIndex, inputValues.mIsLimitPdfFileSize);
        TaskAddPdf taskAddPdf = new TaskAddPdf();
        this.mTaskAddPdf = taskAddPdf;
        taskAddPdf.setStorageChecker(this.mStorageChecker);
        this.mTaskAddPdf.setTaskCallback(new C100456(zArr, currentPageIndex, inputValues));
        this.mTaskAddPdf.setInputValue(inputValues2);
        this.mTaskAddPdf.executeTask(inputValues2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$downloadAudio$0(final InputValues inputValues, Uri uri, final boolean[] zArr) {
        TaskDownloadAudio.InputValues inputValues2 = new TaskDownloadAudio.InputValues(inputValues.mContext, inputValues.mObjectManager.getCachePath(), uri);
        TaskDownloadAudio taskDownloadAudio = new TaskDownloadAudio();
        taskDownloadAudio.setStorageChecker(this.mStorageChecker);
        taskDownloadAudio.setTaskCallback(new Task.Callback<TaskDownloadAudio.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClip.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskDownloadAudio.ResultValues resultValues) {
                Logger.m11000e(TaskWebClip.TAG, "TaskWebClip# addAudio # onError# ");
                TaskWebClip.this.mAddImageAudioDone = false;
                zArr[0] = true;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskDownloadAudio.ResultValues resultValues) {
                Logger.m11003i(TaskWebClip.TAG, "TaskWebClip# addAudio # #onSuccess# ");
                TaskWebClip.this.mAddImageAudioDone = inputValues.mObjectManager.insertObjectVoice(inputValues.mPageManager.getDocPageInfo().getCurrentPageIndex(), resultValues.getContentPath(), resultValues.getFileName());
                zArr[0] = true;
            }
        });
        taskDownloadAudio.setInputValue(inputValues2);
        taskDownloadAudio.executeTask(inputValues2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$loadFinish$4() {
        if (this.mIsConvert.get()) {
            return;
        }
        resizeLayout(((InputValues) getInputValue()).mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pauseMediaPlayer$3() {
        if (this.mWebView == null || this.mCurrentState == State.EXPORT_PDF) {
            return;
        }
        pauseVideoPlayer();
    }

    private void lastGetThumbnail() {
        this.mWebView.loadUrl(getMediaJavascript("if (videoEs[i].readyState >= 4 && videoEs[i].currentTime > 0) {" + getThumbnail() + "}"));
    }

    private void pauseMediaPlayer() {
        this.mHandlerWeb.post(new RunnableC10052e(this, 0));
    }

    private void pauseVideoPlayer() {
        this.mWebView.loadUrl(getMediaJavascript(""));
    }

    private void setDesktopMode(WebSettings webSettings, boolean z) {
        AbstractC8014b.m7224z("setDesktopMode: ", TAG, z);
        webSettings.setUserAgentString(z ? webSettings.getUserAgentString().replace("Mobile", "eliboM").replace(AuthenticationConstants.AAD.ADAL_ID_PLATFORM_VALUE, "diordnA") : webSettings.getUserAgentString().replace("eliboM", "Mobile").replace("diordnA", AuthenticationConstants.AAD.ADAL_ID_PLATFORM_VALUE));
        webSettings.setUseWideViewPort(z);
        webSettings.setLoadWithOverviewMode(z);
    }

    private void setEnableJS(String str) {
        this.enableJS = (str.startsWith("https://samsung.com") || str.startsWith("http://samsung.com") || str.startsWith("https://www.samsung.com") || str.startsWith("http://www.samsung.com")) ? false : true;
    }

    private void setWebChromeClient() {
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClip.4
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                AbstractC8014b.m7217s(i, "onProgressChanged: ", TaskWebClip.TAG);
                if (TaskWebClip.this.mWebView == null || TaskWebClip.this.mCurrentState != State.LOAD_WEB) {
                    return;
                }
                WebView webView2 = TaskWebClip.this.mWebView;
                StringBuilder sb = new StringBuilder("javascript:(function() {try {  var parent = document.getElementsByTagName('head')[0];  var style = document.createElement('style');  style.type = 'text/css';  style.innerHTML = 'body {min-height: ");
                sb.append(TaskWebClip.this.mIsLongRatio ? 1500 : 1100);
                sb.append("px;}';  style.innerHTML += '@page {       margin-top: 0px;       margin-bottom: -1px;       padding: 0px;  }';  parent.appendChild(style);} catch(e) {}try {  var images = document.getElementsByTagName('img');  if (images != null && images.length > 0) {  for (var i = 0; i < images.length; i++){  images[i].setAttribute('loading', 'eager');}}} catch( e) {}})()");
                webView2.loadUrl(sb.toString());
                if (i != 100 || !TaskWebClip.this.mPageFinishTmp || TaskWebClip.this.mPageFinish || TaskWebClip.this.mIsCanceled) {
                    return;
                }
                TaskWebClip.this.loadFinish();
            }

            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView webView, String str) {
                super.onReceivedTitle(webView, str);
                if (TextUtils.isEmpty(webView.getTitle())) {
                    return;
                }
                TaskWebClip.this.mTitle = webView.getTitle();
            }
        });
    }

    private void setWebViewClient(final Context context, final String str) {
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskWebClip.3
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str2) {
                super.onPageFinished(webView, str2);
                if (TaskWebClip.this.mPageFinish || TaskWebClip.this.mIsCanceled) {
                    return;
                }
                if (webView.getProgress() < 100) {
                    TaskWebClip.this.mPageFinishTmp = true;
                } else {
                    TaskWebClip.this.loadFinish();
                }
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                if (webResourceRequest.getUrl().equals(Uri.parse(str))) {
                    Logger.m11003i(TaskWebClip.TAG, "onReceivedError: " + webResourceRequest.getUrl());
                    TaskWebClip.this.mIsLoadFail = true;
                    TaskWebClip.this.mError |= 1;
                    ToastHandler.show(context, C9086R.string.webclip_connect_error, 0);
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                if (renderProcessGoneDetail.didCrash()) {
                    Logger.m11000e(TaskWebClip.TAG, "The WebView rendering process crashed!");
                    TaskWebClip.this.clear();
                    TaskWebClip.this.mIsLoadFail = true;
                    return true;
                }
                Logger.m11000e(TaskWebClip.TAG, "System killed the WebView rendering process to reclaim memory. Recreating...");
                TaskWebClip.this.clear();
                TaskWebClip.this.mIsLoadFail = true;
                return true;
            }

            @Override // android.webkit.WebViewClient
            @Nullable
            public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                Uri url = webResourceRequest.getUrl();
                String string = url.toString();
                String scheme = url.getScheme();
                Logger.m11003i(TaskWebClip.TAG, "shouldOverrideUrlLoading: " + string + " | " + scheme);
                if (MarketingConstants.LINK_TYPE_INTENT.equals(scheme)) {
                    try {
                        String stringExtra = Intent.parseUri(string, 1).getStringExtra("browser_fallback_url");
                        if (stringExtra != null) {
                            webView.loadUrl(stringExtra);
                        }
                    } catch (Exception unused) {
                    }
                } else if ("http".equals(scheme) || com.microsoft.identity.common.java.AuthenticationConstants.HTTPS_PROTOCOL_STRING.equals(scheme)) {
                    if (url.getQueryParameter("url") != null) {
                        String queryParameter = url.getQueryParameter("url");
                        if (queryParameter != null) {
                            try {
                                webView.loadUrl(URLDecoder.decode(queryParameter, "UTF-8"));
                            } catch (Exception e) {
                                Logger.m11003i(TaskWebClip.TAG, "Error decoding URL: " + e.getMessage());
                            }
                        }
                    } else {
                        webView.loadUrl(string);
                    }
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* JADX INFO: renamed from: setupWebView, reason: merged with bridge method [inline-methods] */
    public void lambda$createPdf$2(Context context, String str) {
        includeView(context);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(this.enableJS);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSupportZoom(false);
        settings.setMixedContentMode(2);
        settings.setCacheMode(2);
        settings.setMediaPlaybackRequiresUserGesture(true);
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(context) || DeviceUtils.isTabletModel()) {
            Logger.m11003i(TAG, "isTablet | isDexMode");
            setDesktopMode(settings, true);
        } else {
            Logger.m11003i(TAG, "isMobile");
            setDesktopMode(settings, false);
        }
        setWebChromeClient();
        setWebViewClient(context, str);
        Logger.m10999d(TAG, "create web done: " + (System.currentTimeMillis() - this.mTimeStart) + "ms | start load: " + str);
        this.mWebView.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryToConvertWebToPDF(Context context, int i) {
        this.mHandlerWeb.postDelayed(new RunnableC10049b(this, context, i), 500L);
    }

    private void waitForDownloadImageOrAudio() {
        synchronized (this) {
            try {
                try {
                    wait(50L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void waitForPdf() {
        synchronized (this) {
            try {
                pauseMediaPlayer();
                wait(300L);
            } catch (InterruptedException e) {
                Logger.m11000e(TAG, e.toString());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel#");
        this.mIsCanceled = true;
        clearWeb();
        TaskAddPdf taskAddPdf = this.mTaskAddPdf;
        if (taskAddPdf != null) {
            taskAddPdf.cancel(iCancelCallback);
        }
        Handler handler = this.mHandlerWeb;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void changeState(State state) {
        this.mCurrentState = state;
        this.mTimeInfo = System.currentTimeMillis();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear#");
        cancel(null);
        TaskAddPdf taskAddPdf = this.mTaskAddPdf;
        if (taskAddPdf != null) {
            taskAddPdf.clear();
        }
        super.clear();
    }

    public HttpURLConnection getConnection(String str) {
        try {
            return (HttpURLConnection) new URL(str).openConnection();
        } catch (MalformedURLException unused) {
            Logger.m11003i(TAG, "getConnection() - MalformedURLException");
            return null;
        } catch (IOException unused2) {
            Logger.m11003i(TAG, "getConnection() - IOException");
            return null;
        }
    }

    public String getThumbnail() {
        return "if (videoEs[i].poster == null || videoEs[i].poster == \"\") { var canvas = document.createElement('canvas');var context = canvas.getContext('2d');var ratio = videoEs[i].videoWidth / videoEs[i].videoHeight;canvas.width = videoEs[i].getBoundingClientRect().width;canvas.height = parseInt(canvas.width / ratio, 10);context.fillRect(0, 0, canvas.width, canvas.height);context.drawImage(videoEs[i], 0, 0, canvas.width, canvas.height);videoEs[i].poster = \"webclip\";videoEs[i].pause();var parent = videoEs[i].parentElement;  parent.parentElement.replaceChild(canvas, parent);}";
    }

    public void loadFinish() {
        this.mPageFinish = true;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.mTimeInfo;
        long jMin = Math.min(3000L, 3000 - jCurrentTimeMillis);
        String str = TAG;
        StringBuilder sbM1323p = AbstractC1974b.m1323p(jCurrentTimeMillis, "load web time = ", "ms | delay = ");
        sbM1323p.append(jMin);
        Logger.m11003i(str, sbM1323p.toString());
        Handler handler = this.mHandlerWeb;
        RunnableC10052e runnableC10052e = new RunnableC10052e(this, 1);
        if (jMin <= 0) {
            jMin = 0;
        }
        handler.postDelayed(runnableC10052e, jMin + 5000);
    }

    public void resizeLayout(Context context) {
        if (this.mIsConvert.getAndSet(true) || this.mIsCanceled || this.mIsLoadFail) {
            return;
        }
        Logger.m11003i(TAG, "resizeLayout");
        lastGetThumbnail();
        this.mNestScroll.removeView(this.mWebView);
        this.mParent.removeView(this.mNestScroll);
        ViewGroup.LayoutParams layoutParams = this.mWebView.getLayoutParams();
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        this.mWebView.setLayoutParams(layoutParams);
        this.mWebView.setAlpha(0.0f);
        this.mParent.addView(this.mWebView, 0);
        this.mTmpPath = new ArrayList<>();
        tryToConvertWebToPDF(context, 0);
    }

    public void setTimeStart(long j) {
        this.mTimeStart = j;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        this.mHandlerWeb = new Handler(Looper.getMainLooper());
        HttpURLConnection connection = getConnection(inputValues.mUrl);
        if (connection != null) {
            String headerField = connection.getHeaderField("Content-Type");
            this.mAddImageAudioDone = false;
            if (headerField != null) {
                Uri uri = Uri.parse(inputValues.mUrl);
                if (headerField.startsWith("image")) {
                    addImage(inputValues, uri);
                } else if (headerField.startsWith(AUDIO_TYPE)) {
                    downloadAudio(uri, inputValues);
                }
            }
        }
        if (this.mAddImageAudioDone) {
            return;
        }
        insertPdf(inputValues);
    }
}
