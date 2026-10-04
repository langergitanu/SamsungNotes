package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectLink;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.document.SpenObjectWeb;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.ConvertSpenTextToSpannable;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DropContent;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DropContentMaker;
import com.samsung.android.support.senl.p148nt.base.composer.share.BaseShareUtil;
import com.samsung.android.support.senl.p148nt.base.framework.provider.ClipDataContentProvider;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.HandleImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskCreationDropContent extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskCreationDropContent");
    private String mBackupPath;
    private Context mContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DropContentMakerContract implements DropContentMaker.Contract {
        ObjectManager mObjectManager;

        public DropContentMakerContract(ObjectManager objectManager) {
            this.mObjectManager = objectManager;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
        public void copyObjectSpanText(@NonNull SpenWNote spenWNote, @NonNull SpenObjectBase spenObjectBase, @NonNull DropContent dropContent) {
            List<SpenObjectSpan> listFindObjectSpan = new ObjectSpanHelper(this.mObjectManager.getNote()).findObjectSpan(Collections.singletonList(spenObjectBase));
            if (listFindObjectSpan.isEmpty()) {
                Logger.m11000e(TaskCreationDropContent.TAG, "copyObjectSpanText# fail to find object span");
                return;
            }
            int textIndex = listFindObjectSpan.get(0).getTextIndex();
            dropContent.contentList.add(ObjectTextFactory.copyText(this.mObjectManager.getNote().getBodyText(), textIndex, textIndex));
            dropContent.selection = new int[]{textIndex, textIndex + 1};
            dropContent.contentType = 3;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
        @Nullable
        public ConvertSpenTextToSpannable.IObjectSpanConverter createObjectSpanConverter(@NonNull Context context, @NonNull String str, @NonNull DropContent dropContent) {
            return new ObjectSpanConverterImpl(context, str, dropContent);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
        @Nullable
        public Bitmap getSelectedObjectBitmap() {
            return this.mObjectManager.getSelectedObjectBitmap();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
        public boolean isFocusedTextBox() {
            return this.mObjectManager.isFocusedTextBox();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DropContentMaker.Contract
        @NonNull
        public String saveAsImage(@Nullable SpenObjectBase spenObjectBase, @Nullable String str, @Nullable String str2) {
            return new HandleImage().saveAsImage(spenObjectBase, str, str2, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private final ObjectManager mObjectManager;
        private final PdfManager mPdfManager;

        public InputValues(Context context, ObjectManager objectManager, PdfManager pdfManager) {
            this.mContext = context;
            this.mObjectManager = objectManager;
            this.mPdfManager = pdfManager;
        }
    }

    private DropContent createDropContentWithContentList(List<SpenObjectBase> list, ObjectManager objectManager, PdfManager pdfManager) {
        return new DropContentMaker(TAG, new DropContentMakerContract(objectManager)).createDropContentWithContentList(objectManager.getNote(), list, pdfManager.getSelectedText());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        super.clear();
        if (this.mContext != null && !TextUtils.isEmpty(this.mBackupPath)) {
            Logger.m10999d(TAG, "clear# removeCache");
            try {
                SpenWNoteFile.removeClosedCache(this.mContext, this.mBackupPath);
            } catch (IOException unused) {
                Logger.m10999d(TAG, "clear# - fail to remove cache");
            }
        }
        this.mContext = null;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private DropContent mDropContent;

        public ResultValues(Context context) {
            this.mContext = context;
        }

        public DropContent getDropContent() {
            return this.mDropContent;
        }

        public void showErrorToast() {
            Context context = this.mContext;
            if (context == null) {
                return;
            }
            ToastHandler.show(context, C9086R.string.composer_failed_to_copy, 0);
        }

        public ResultValues(DropContent dropContent) {
            this.mDropContent = dropContent;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        final DropContent dropContentCreateDropContentWithContentList = createDropContentWithContentList(inputValues.mObjectManager.getSelectedObjectList(), inputValues.mObjectManager, inputValues.mPdfManager);
        if (dropContentCreateDropContentWithContentList.contentList.isEmpty()) {
            Logger.m11000e(TAG, "fail to create content list");
            notifyCallback(false, new ResultValues(inputValues.mContext));
        } else {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            this.mExecutorService = executorServiceNewSingleThreadExecutor;
            executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskCreationDropContent.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    StringBuilder sb;
                    Logger.m10999d(TaskCreationDropContent.TAG, "executeTask# thread start - " + System.currentTimeMillis());
                    TaskCreationDropContent.this.mContext = inputValues.mContext;
                    DropContent dropContent = dropContentCreateDropContentWithContentList;
                    try {
                        try {
                            ClipboardCacheManager.trimCache(TaskCreationDropContent.this.mContext);
                            DropContentMaker dropContentMaker = new DropContentMaker(TaskCreationDropContent.TAG, new DropContentMakerContract(inputValues.mObjectManager));
                            dropContentMaker.makeBackupNote(TaskCreationDropContent.this.mContext, inputValues.mObjectManager.getNote(), dropContentCreateDropContentWithContentList.contentList);
                            TaskCreationDropContent.this.mBackupPath = dropContentMaker.getBackupPath();
                            dropContentMaker.fillDropContent(TaskCreationDropContent.this.mContext, dropContentCreateDropContentWithContentList, dropContentMaker.getBackupFileName(), TaskCreationDropContent.this.mBackupPath);
                            if (TextUtils.isEmpty(dropContent.plainText)) {
                                TaskCreationDropContent taskCreationDropContent = TaskCreationDropContent.this;
                                taskCreationDropContent.notifyCallback(false, new ResultValues(taskCreationDropContent.mContext));
                            } else {
                                TaskCreationDropContent.this.notifyCallback(true, new ResultValues(dropContent));
                            }
                            str = TaskCreationDropContent.TAG;
                            sb = new StringBuilder("executeTask# thread done - ");
                        } catch (Exception e) {
                            Logger.m11001e(TaskCreationDropContent.TAG, "err: " + e.getMessage(), e);
                            if (TextUtils.isEmpty(dropContent.plainText)) {
                                TaskCreationDropContent taskCreationDropContent2 = TaskCreationDropContent.this;
                                taskCreationDropContent2.notifyCallback(false, new ResultValues(taskCreationDropContent2.mContext));
                            } else {
                                TaskCreationDropContent.this.notifyCallback(true, new ResultValues(dropContent));
                            }
                            str = TaskCreationDropContent.TAG;
                            sb = new StringBuilder("executeTask# thread done - ");
                        }
                        sb.append(System.currentTimeMillis());
                        Logger.m10999d(str, sb.toString());
                    } catch (Throwable th) {
                        if (TextUtils.isEmpty(dropContent.plainText)) {
                            TaskCreationDropContent taskCreationDropContent3 = TaskCreationDropContent.this;
                            taskCreationDropContent3.notifyCallback(false, new ResultValues(taskCreationDropContent3.mContext));
                        } else {
                            TaskCreationDropContent.this.notifyCallback(true, new ResultValues(dropContent));
                        }
                        Logger.m10999d(TaskCreationDropContent.TAG, "executeTask# thread done - " + System.currentTimeMillis());
                        throw th;
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ObjectSpanConverterImpl implements ConvertSpenTextToSpannable.IObjectSpanConverter {
        private final String baseName;
        private final Context context;
        private final DropContent dropContent;
        private final String TAG = Logger.createTag("TaskCreationDropContent$ImageTypeCopy");
        private int count = 0;

        public ObjectSpanConverterImpl(Context context, String str, DropContent dropContent) {
            this.context = context;
            this.baseName = str;
            this.dropContent = dropContent;
        }

        private void replaceObjectSpanChar(SpannableStringBuilder spannableStringBuilder, int i, CharSequence charSequence) {
            spannableStringBuilder.replace(i, i + 1, charSequence);
        }

        @Override // com.samsung.android.support.senl.nt.base.common.util.ConvertSpenTextToSpannable.IObjectSpanConverter
        public void convert(@NonNull List<SpenObjectSpan> list, @NonNull SpannableStringBuilder spannableStringBuilder) {
            for (int size = list.size() - 1; size >= 0; size--) {
                convert(list.get(size), spannableStringBuilder);
            }
        }

        private void convert(SpenObjectSpan spenObjectSpan, SpannableStringBuilder spannableStringBuilder) {
            SpenObjectBase object = spenObjectSpan.getObject();
            int type = object.getType();
            if (type != 3) {
                if (type == 10) {
                    SpenObjectVoice spenObjectVoice = (SpenObjectVoice) object;
                    Uri audioClipDataContentUri = BaseShareUtil.getAudioClipDataContentUri(this.TAG, this.context, this.baseName, spenObjectVoice);
                    if (audioClipDataContentUri != null) {
                        this.dropContent.uriList.add(audioClipDataContentUri);
                    }
                    replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), spenObjectVoice.getTitle() + "\n");
                    return;
                }
                if (type == 17) {
                    replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), ((SpenObjectLink) object).getTitle() + "\n");
                    return;
                }
                if (type != 19) {
                    if (type == 13) {
                        replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), ((SpenObjectWeb) object).getUri() + "\n");
                        return;
                    }
                    if (type != 14) {
                        return;
                    }
                }
            }
            String clipboardFileName = ClipboardCacheManager.getClipboardFileName(this.context, this.baseName, "");
            HandleImage handleImage = new HandleImage();
            int i = this.count + 1;
            this.count = i;
            String strSaveAsImage = handleImage.saveAsImage(object, clipboardFileName, String.valueOf(i), true);
            if (!TextUtils.isEmpty(strSaveAsImage) && AbstractC2322a.m1607A(strSaveAsImage)) {
                if (spannableStringBuilder.length() == spenObjectSpan.getTextIndex() + 1) {
                    spannableStringBuilder.append(" ", spenObjectSpan.getTextIndex(), spenObjectSpan.getTextIndex());
                }
                Uri uri = ClipDataContentProvider.getUri(strSaveAsImage);
                SpannableString spannableStringMakeImageSpan = BaseShareUtil.makeImageSpan(this.TAG, this.context, uri, false);
                this.dropContent.uriList.add(uri);
                replaceObjectSpanChar(spannableStringBuilder, spenObjectSpan.getTextIndex(), spannableStringMakeImageSpan);
                return;
            }
            Logger.m10999d(this.TAG, "convertTextToDropContent# ImageContent, path is invalid");
        }
    }
}
