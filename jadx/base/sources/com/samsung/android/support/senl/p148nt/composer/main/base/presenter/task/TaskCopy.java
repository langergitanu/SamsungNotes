package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectCodeBlock;
import com.samsung.android.sdk.pen.document.SpenObjectImage;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.ClipboardManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.CopyResult;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.ObjectCopy;
import com.samsung.android.support.senl.p148nt.base.composer.action.copy.TextCopy;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleCodeBlock;
import com.samsung.android.support.senl.p148nt.base.composer.share.HandleTable;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.ImageUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCopy extends SingleThreadTask<InputValues, ResultValues> {
    public static final int CLIP_DATA_MAXIMUM_STRING_LENGTH = 40000;
    private static final String TAG = Logger.createTag("TaskCopy");
    private String mBackupPath;
    private Context mContext;
    private CopyResult mCopyResult = new CopyResult();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ImageTypeCopy {
        private static final String TAG = Logger.createTag("TaskCopy$ImageTypeCopy");
        protected String baseName;
        protected Context context;
        protected int count = 1;

        public ImageTypeCopy(Context context, String str) {
            this.context = context;
            this.baseName = str;
        }

        public String saveAsImage(SpenObjectBase spenObjectBase) {
            return saveAsImage(spenObjectBase, this.baseName);
        }

        public String saveAsImage(SpenObjectBase spenObjectBase, String str) {
            String clipboardFileName = ClipboardCacheManager.getClipboardFileName(this.context, str, "");
            HandleImage handleImage = new HandleImage();
            int i = this.count + 1;
            this.count = i;
            String strSaveAsImage = handleImage.saveAsImage(spenObjectBase, clipboardFileName, String.valueOf(i), true);
            if (TextUtils.isEmpty(strSaveAsImage)) {
                Logger.m11000e(TAG, "saveAsImage# newPath is null");
                return null;
            }
            String str2 = TAG;
            Logger.m11003i(str2, "saveAsImage# newPath: " + Logger.getEncode(strSaveAsImage));
            if (new File(strSaveAsImage).exists()) {
                return strSaveAsImage;
            }
            Logger.m11000e(str2, "saveAsImage# fail to save file");
            return null;
        }

        public ImageTypeCopy(Context context) {
            this.context = context;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context context;

        public ResultValues() {
        }

        public void showErrorToast() {
            Context context = this.context;
            if (context == null) {
                return;
            }
            ToastHandler.show(context, C9086R.string.composer_failed_to_copy, 0);
        }

        public ResultValues(Context context) {
            this.context = context;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addPdfImageObject(Context context, PdfManager pdfManager, String str, ArrayList<SpenObjectBase> arrayList) {
        if (pdfManager == null) {
            return;
        }
        Logger.m11003i(TAG, "addPdfImageObject#" + pdfManager.hasSelectedImage());
        if (pdfManager.hasSelectedImage()) {
            RectF selectedImageRect = pdfManager.getSelectedImageRect();
            Bitmap bitmapCreateBitmap = (selectedImageRect == null || selectedImageRect.width() <= 0.0f || selectedImageRect.height() <= 0.0f) ? null : Bitmap.createBitmap((int) selectedImageRect.width(), (int) selectedImageRect.height(), Bitmap.Config.ARGB_8888);
            if (bitmapCreateBitmap == null || !pdfManager.getSelectedImage(bitmapCreateBitmap)) {
                return;
            }
            String clipboardFileName = ClipboardCacheManager.getClipboardFileName(context, str, "pdf.png");
            ImageUtil.saveBitmapToFileCache(bitmapCreateBitmap, clipboardFileName, Bitmap.CompressFormat.PNG, 95);
            SpenObjectImage spenObjectImage = new SpenObjectImage();
            spenObjectImage.setImage(clipboardFileName);
            spenObjectImage.setRect(selectedImageRect, false);
            arrayList.add(spenObjectImage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<ClipData.Item, String[]> copy(InputValues inputValues) {
        if (inputValues.textBox == null) {
            copyObject(inputValues.context, inputValues.objectManager, inputValues.pdfManager, inputValues.selectedList);
        } else if (!inputValues.objectManager.getSelectedObjectManager().isSelectedTable() || inputValues.objectManager.getSelectedObjectManager().isFocusedTable()) {
            copyText(inputValues.context, inputValues.objectManager, inputValues.textBox, inputValues.startPos, inputValues.endPos);
        } else {
            copyObject(inputValues.context, inputValues.objectManager, inputValues.pdfManager, new ArrayList<>(inputValues.objectManager.getSelectedObjectManager().getSelectedObjectList()));
        }
        return makeClipData();
    }

    private void copyObject(Context context, final ObjectManager objectManager, final PdfManager pdfManager, ArrayList<SpenObjectBase> arrayList) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("copyObject# size :  ");
        sb.append(arrayList == null ? 0 : arrayList.size());
        Logger.m11003i(str, sb.toString());
        final ImageTypeCopy imageTypeCopy = new ImageTypeCopy(context);
        ObjectCopy objectCopy = new ObjectCopy(str, new ObjectCopy.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopy.2
            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.ObjectCopy.Contract
            public void addPdfImageObject(@NonNull Context context2, @NonNull String str2, @NonNull ArrayList<SpenObjectBase> arrayList2) {
                TaskCopy.this.addPdfImageObject(context2, pdfManager, str2, arrayList2);
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.ObjectCopy.Contract
            @Nullable
            public Bitmap getSelectedObjectBitmap() {
                return objectManager.getSelectedObjectBitmap();
            }

            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.ObjectCopy.Contract
            @Nullable
            public String saveAsImage(@NonNull SpenObjectBase spenObjectBase, @NonNull String str2) {
                return imageTypeCopy.saveAsImage(spenObjectBase, str2);
            }
        });
        this.mCopyResult = objectCopy.copyObject(context, objectManager.getNote(), arrayList);
        this.mBackupPath = objectCopy.getBackupPath();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        super.clear();
        if (this.mContext != null && !TextUtils.isEmpty(this.mBackupPath)) {
            Logger.m11003i(TAG, "clear# removeCache");
            try {
                SpenWNoteFile.removeClosedCache(this.mContext, this.mBackupPath);
            } catch (IOException unused) {
                Logger.m11000e(TAG, "clear# fail to remove cache.");
            }
        }
        this.mContext = null;
    }

    public void copyText(Context context, ObjectManager objectManager, SpenObjectShape spenObjectShape, int i, int i2) {
        TextCopy textCopy = new TextCopy(TAG, new TextCopy.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopy.3
            @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.Contract
            @NonNull
            public TextCopy.IObjectSpanConverter makeObjectSpanConverter(@NonNull Context context2, @NonNull String str) {
                return new ObjectSpanConverter(context2, str);
            }
        });
        this.mCopyResult = textCopy.copyText(context, objectManager.getNote(), spenObjectShape, i, i2);
        this.mBackupPath = textCopy.getBackupPath();
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopy.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                resultValues.showErrorToast();
            }
        };
    }

    public void handleResult(Pair<ClipData.Item, String[]> pair, Context context) {
        Object obj = pair.first;
        if (obj == null || (TextUtils.isEmpty(((ClipData.Item) obj).getText()) && TextUtils.isEmpty(((ClipData.Item) pair.first).getHtmlText()))) {
            notifyCallback(false, new ResultValues(context));
        } else if (ClipboardManagerCompat.INSTANCE.getInstance().setClip(context, (ClipData.Item) pair.first, (String[]) pair.second, "")) {
            notifyCallback(true, new ResultValues());
        } else {
            notifyCallback(false, new ResultValues(context));
        }
    }

    public Pair<ClipData.Item, String[]> makeClipData() {
        return new Pair<>(this.mCopyResult.makeClipDataItem(), this.mCopyResult.getMimeType());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopy.1
            @Override // java.lang.Runnable
            public void run() {
                TaskCopy.this.mContext = inputValues.context;
                try {
                    final Pair pairCopy = TaskCopy.this.copy(inputValues);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCopy.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RunnableC99901 runnableC99901 = RunnableC99901.this;
                            TaskCopy.this.handleResult(pairCopy, inputValues.context);
                        }
                    });
                } catch (Exception e) {
                    Logger.m11001e(TaskCopy.TAG, "err: " + e.getMessage(), e);
                    TaskCopy.this.notifyCallback(false, new ResultValues(inputValues.context));
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context context;
        private int endPos;
        private final ObjectManager objectManager;
        private PdfManager pdfManager;
        private ArrayList<SpenObjectBase> selectedList;
        private int startPos;
        private SpenObjectShape textBox;

        public InputValues(Context context, ObjectManager objectManager, ArrayList<SpenObjectBase> arrayList) {
            this.context = context;
            this.objectManager = objectManager;
            this.selectedList = arrayList;
        }

        public int[] getCursor() {
            return new int[]{this.startPos, this.endPos};
        }

        public ObjectManager getObjectManager() {
            return this.objectManager;
        }

        public SpenObjectShape getTextBox() {
            return this.textBox;
        }

        public InputValues(Context context, ObjectManager objectManager, SpenObjectShape spenObjectShape, int i, int i2) {
            this.context = context;
            this.objectManager = objectManager;
            this.textBox = spenObjectShape;
            this.startPos = i;
            this.endPos = i2;
        }

        public InputValues(Context context, ObjectManager objectManager, PdfManager pdfManager) {
            this.context = context;
            this.objectManager = objectManager;
            this.pdfManager = pdfManager;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ObjectSpanConverter extends ImageTypeCopy implements TextCopy.IObjectSpanConverter {
        String[] mMimeType;
        Uri mThumbnailUri;

        public ObjectSpanConverter(Context context, String str) {
            super(context, str);
            this.mMimeType = new String[]{Constants.MIME_HTML};
            this.mThumbnailUri = null;
        }

        private void replaceObjectSpanChar(SpannableStringBuilder spannableStringBuilder, int i, CharSequence charSequence) {
            spannableStringBuilder.replace(i, i + 1, charSequence);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.IObjectSpanConverter, com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
        public void convert(@NonNull List<SpenObjectSpan> list, @NonNull SpannableStringBuilder spannableStringBuilder) {
            int size = list.size();
            for (int i = size - 1; i >= 0; i--) {
                convert(list.get(i), spannableStringBuilder);
            }
            if (size == 1 && this.mThumbnailUri != null && spannableStringBuilder.toString().equals(" ")) {
                this.mMimeType = new String[]{UriFileUtils.getMimeType(this.context, this.mThumbnailUri), Constants.MIME_HTML};
            }
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.IObjectSpanConverter
        @NonNull
        public String[] getMimeType() {
            return this.mMimeType;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.action.copy.TextCopy.IObjectSpanConverter
        public Uri getThumbnailUri() {
            return this.mThumbnailUri;
        }

        private void convert(SpenObjectSpan spenObjectSpan, SpannableStringBuilder spannableStringBuilder) {
            SpenObjectBase object = spenObjectSpan.getObject();
            int type = object.getType();
            if (type != 3) {
                if (type == 10) {
                    replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), ((SpenObjectVoice) object).getTitle() + '\n');
                    return;
                }
                if (type == 17) {
                    replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), ((SpenObjectLink) object).getTitle() + '\n');
                    return;
                }
                if (type == 13) {
                    replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), ((SpenObjectWeb) object).getUri() + '\n');
                    return;
                }
                if (type != 14) {
                    if (type != 22) {
                        if (type == 23 && (object instanceof SpenObjectCodeBlock)) {
                            replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), new HandleCodeBlock().handleObject((SpenObjectCodeBlock) object));
                            return;
                        }
                        return;
                    }
                    if (object instanceof SpenObjectTable) {
                        replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), new HandleTable().handleObject((SpenObjectTable) object));
                        return;
                    }
                    return;
                }
            }
            String strSaveAsImage = saveAsImage(object);
            if (strSaveAsImage == null) {
                return;
            }
            if (spannableStringBuilder.length() == spenObjectSpan.getTextIndex() + 1) {
                spannableStringBuilder.append(" ", spenObjectSpan.getTextIndex(), spenObjectSpan.getTextIndex());
            }
            SpannableString spannableString = new SpannableString(" ");
            Uri uri = ClipDataContentProvider.getUri(strSaveAsImage);
            spannableString.setSpan(new ImageSpan(this.context, uri), 0, 1, 33);
            replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), spannableString);
            if (uri == null || this.mThumbnailUri != null) {
                return;
            }
            this.mThumbnailUri = uri;
        }
    }
}
