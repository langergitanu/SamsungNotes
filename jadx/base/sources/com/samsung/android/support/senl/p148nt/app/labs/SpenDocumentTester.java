package com.samsung.android.support.senl.p148nt.app.labs;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfSearch;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener;
import com.samsung.android.support.senl.p148nt.data.repository.external.ExternalDataRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.helper.BaseDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.helper.CreateDocumentHelper;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportPDFTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportPdfParam;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
class SpenDocumentTester {
    private static final String TAG = "SpenDocumentTester";
    private final WeakReference<Context> mContext;
    private String mDestFolderPath;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private DialogUtils.ProgressDialog mProgressDialog;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.labs.SpenDocumentTester$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class CallableC80892 implements Callable<Boolean> {
        final /* synthetic */ Context val$context;

        public CallableC80892(Context context) {
            this.val$context = context;
        }

        private String extractTitle(@NonNull String str) {
            int iLastIndexOf = str.lastIndexOf(Extension.DOT);
            return iLastIndexOf < 0 ? str : str.substring(0, iLastIndexOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$call$0(File file, String str) {
            return str.endsWith(Constants.TEXT_EXTENSION_WITH_DOT) || str.endsWith(Constants.PDF_EXTENSION_WITH_DOT);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            File upTestDirectory = SpenDocumentTester.this.setUpTestDirectory("importText");
            if (upTestDirectory == null) {
                SpenDocumentTester.this.hideProgressDialog();
                return Boolean.FALSE;
            }
            File[] fileArrListFiles = upTestDirectory.listFiles(new C8099d());
            if (fileArrListFiles == null || fileArrListFiles.length == 0) {
                Logger.m11000e(SpenDocumentTester.TAG, "there is no files");
                return Boolean.FALSE;
            }
            AtomicInteger atomicInteger = new AtomicInteger(0);
            SpenDocumentTester.this.updateProgressMessage(atomicInteger.get() + "/" + fileArrListFiles.length);
            for (File file : fileArrListFiles) {
                final String path = file.getPath();
                Logger.m10999d(SpenDocumentTester.TAG, "importPdfTxtFiles, path: " + Logger.getEncode(path));
                String strNewUUID = UUIDUtils.newUUID(this.val$context);
                if (path.endsWith(Constants.TEXT_EXTENSION_WITH_DOT)) {
                    new CreateDocumentHelper(this.val$context, DocumentSubscriptionId.BACKGROUND_DOCUMENT_SERVICE_ID).setUuid(strNewUUID).setListener(new BaseDocumentHelper.Listener() { // from class: com.samsung.android.support.senl.nt.app.labs.SpenDocumentTester.2.1
                        private String loadTextFromFile(String str) {
                            FileInputStream fileInputStream;
                            InputStreamReader inputStreamReader;
                            Charset charsetDetectEncoding = CharEncodingGuesser.detectEncoding(new File(str));
                            StringBuilder sb = new StringBuilder();
                            try {
                                fileInputStream = new FileInputStream(str);
                                try {
                                    inputStreamReader = new InputStreamReader(fileInputStream, charsetDetectEncoding);
                                } finally {
                                }
                            } catch (IOException e) {
                                AbstractC8014b.m7204f(e, new StringBuilder("loadTextFromFile# fail e: "), SpenDocumentTester.TAG);
                            }
                            try {
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        sb.append(line);
                                        sb.append('\n');
                                    } finally {
                                    }
                                }
                                bufferedReader.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                                return sb.toString();
                            } finally {
                            }
                        }

                        @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
                        public void onFailed(@NonNull String str) {
                        }

                        @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
                        public void onOpen(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                            notesDocument.getDoc().insertBody(loadTextFromFile(path));
                        }

                        @Override // com.samsung.android.support.senl.nt.model.helper.BaseDocumentHelper.Listener
                        public void onSave(@NonNull NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
                        }
                    }).execute();
                } else if (path.endsWith(Constants.PDF_EXTENSION_WITH_DOT)) {
                    new ImportPDFTask(new ImportPdfParam().setIsNew(true).setContext(this.val$context).setUuid(strNewUUID).setExternalPath(path).setTitle(extractTitle(file.getName())).setCaller(SpenDocumentTester.TAG)).setImported(true).call();
                }
                SpenDocumentTester.this.updateProgressMessage(atomicInteger.incrementAndGet() + "/" + fileArrListFiles.length);
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.labs.SpenDocumentTester$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C80914 implements OnCompletionListener<Boolean> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$msg;

        public C80914(String str, Context context) {
            this.val$msg = str;
            this.val$context = context;
        }

        private void finish(String str) {
            SpenDocumentTester.this.mHandler.post(new RunnableC8097b(this.val$context, str));
            SpenDocumentTester.this.hideProgressDialog();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$finish$0(Context context, String str) {
            Toast.makeText(context, str, 1).show();
        }

        @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
        public void onFail(@NonNull Exception exc) {
            finish(AbstractC2322a.m1619i(exc, new StringBuilder("fail, e: ")));
        }

        @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
        public void onComplete(@Nullable Boolean bool) {
            StringBuilder sb = new StringBuilder();
            sb.append((bool == null || !bool.booleanValue()) ? "Fail" : "Success");
            sb.append(this.val$msg);
            finish(sb.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class CopyDocumentRunnable implements Callable<String> {
        private final String mDestFolderPath;
        private final String mDocumentCacheFolder;
        private final String mDocumentFileFolder;
        private final String mDocumentFolder;
        private final String mSyncLogFolder;

        public CopyDocumentRunnable(@NonNull Context context, @NonNull String str) {
            this.mDestFolderPath = str;
            this.mDocumentFolder = WDocUtils.getNoteFilePath(context);
            StringBuilder sb = new StringBuilder();
            sb.append(context.getFilesDir());
            String str2 = File.separator;
            this.mDocumentFileFolder = AbstractC0622a.m1170p(str2, ExternalDataConstants.DOCUMENT_TABLE_NAME, sb);
            this.mDocumentCacheFolder = context.getFilesDir() + str2 + "SPenSDK30";
            this.mSyncLogFolder = Environment.getExternalStorageDirectory() + str2 + "SyncLogs";
        }

        private void copy(@NonNull File file, @NonNull File file2) {
            FileUtils.copyFile(file, file2, true, false);
        }

        private void delete(@NonNull File file) {
            FileUtils.deleteFile(file);
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            File file = new File(this.mDestFolderPath);
            delete(file);
            copy(new File(this.mDocumentFolder), new File(this.mDestFolderPath, Constants.DOCUMENT_DIR_NAME));
            copy(new File(this.mDocumentFileFolder), new File(this.mDestFolderPath, ExternalDataConstants.DOCUMENT_TABLE_NAME));
            copy(new File(this.mDocumentCacheFolder), new File(this.mDestFolderPath, "SPenSDK30"));
            copy(new File(this.mSyncLogFolder), new File(this.mDestFolderPath, "SyncLogs"));
            return file.getAbsolutePath();
        }
    }

    public SpenDocumentTester(@NonNull Context context) {
        this.mContext = new WeakReference<>(context);
    }

    private OnCompletionListener<Boolean> createCompletionListener(@NonNull Context context, @NonNull String str) {
        return new C80914(str, context);
    }

    private String getDestFolderPath() {
        return this.mDestFolderPath;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideProgressDialog() {
        this.mHandler.post(new RunnableC8092a(this, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$hideProgressDialog$1() {
        DialogUtils.ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateProgressMessage$0(String str) {
        DialogUtils.ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.setMessage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public File setUpTestDirectory(@NonNull String str) {
        if (!SpenSdkInitializer.initialize(this.mContext.get())) {
            return null;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), str);
        if (file.exists() || file.mkdir()) {
            return file;
        }
        Logger.m11000e(TAG, "fail to create dir");
        return null;
    }

    private void showProgressDialog(Context context, String str) {
        DialogUtils.ProgressDialog progressDialog = new DialogUtils.ProgressDialog(context);
        this.mProgressDialog = progressDialog;
        progressDialog.setTitle(str);
        this.mProgressDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgressMessage(String str) {
        this.mHandler.post(new RunnableC8097b(this, str, 1));
    }

    public void copyToSdcard() {
        final Context context = this.mContext.get();
        showProgressDialog(context, "Copying to external storage...");
        DataRepositoryScheduler.callable(new CopyDocumentRunnable(context, getDestFolderPath())).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).observe(new OnCompletionListener<String>() { // from class: com.samsung.android.support.senl.nt.app.labs.SpenDocumentTester.1
            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onFail(@NonNull Exception exc) {
                Toast.makeText(context, "fail to copy, e: " + exc.getMessage(), 1).show();
            }

            @Override // com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.callback.OnCompletionListener
            public void onComplete(@Nullable String str) {
                if (!TextUtils.isEmpty(str)) {
                    Toast.makeText(context, "Success to copy to : " + str, 1).show();
                }
                SpenDocumentTester.this.hideProgressDialog();
            }
        }).execute();
    }

    public void extractBodyPdfHwText() {
        final Context context = this.mContext.get();
        showProgressDialog(context, "Extract Body,PDF,Hw Text...");
        DataRepositoryScheduler.callable(new Callable<Boolean>() { // from class: com.samsung.android.support.senl.nt.app.labs.SpenDocumentTester.3
            private String getFileName(String str) {
                if (TextUtils.isEmpty(str)) {
                    str = "no_title";
                }
                StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
                sbM1324q.append(new SimpleDateFormat("_yy_MM_dd-HH_mm_ss", Locale.getDefault()).format(new Date()));
                return sbM1324q.toString();
            }

            private void printBodyText(File file, String str, SpenWNote spenWNote) {
                try {
                    writeToFile(spenWNote.getBodyText().getText(), file, str + "_bodyText");
                } catch (IOException e) {
                    AbstractC8014b.m7204f(e, new StringBuilder("fail to extract bodyText, e: "), SpenDocumentTester.TAG);
                }
            }

            private void printHwText(File file, String str, String str2) {
                int columnIndex;
                try {
                    Cursor documentData = new ExternalDataRepository(NotesDatabaseManager.getInstance()).getDocumentData(new String[]{ExternalDataConstants.Column.HANDWRITING_TEXT}, str2, "", null, null);
                    if (documentData != null) {
                        try {
                            if (documentData.moveToFirst() && (columnIndex = documentData.getColumnIndex(ExternalDataConstants.Column.HANDWRITING_TEXT)) >= 0) {
                                writeToFile(documentData.getString(columnIndex), file, str + "_hwText");
                            }
                        } finally {
                        }
                    }
                    if (documentData != null) {
                        documentData.close();
                    }
                } catch (Exception e) {
                    AbstractC8014b.m7205g(e, new StringBuilder("fail to extract hwText, e: "), SpenDocumentTester.TAG);
                }
            }

            private void printPdfText(File file, String str, SpenWNote spenWNote) throws Throwable {
                SpenNotePdfSearch spenNotePdfSearch;
                SpenNotePdfSearch spenNotePdfSearch2 = null;
                try {
                    try {
                        spenNotePdfSearch = new SpenNotePdfSearch();
                    } catch (Exception e) {
                        e = e;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    spenNotePdfSearch.setDocument(spenWNote);
                    StringBuilder sb = new StringBuilder();
                    Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
                    while (it.hasNext()) {
                        String pageText = spenNotePdfSearch.getPageText(it.next());
                        if (pageText != null && !pageText.isEmpty()) {
                            sb.append(pageText);
                            sb.append('\n');
                        }
                    }
                    writeToFile(sb.toString(), file, str + "_pdfText");
                    spenNotePdfSearch.close();
                } catch (Exception e2) {
                    e = e2;
                    spenNotePdfSearch2 = spenNotePdfSearch;
                    Logger.m11000e(SpenDocumentTester.TAG, "fail to extract pdfText, e: " + e.getMessage());
                    if (spenNotePdfSearch2 != null) {
                        spenNotePdfSearch2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    spenNotePdfSearch2 = spenNotePdfSearch;
                    if (spenNotePdfSearch2 != null) {
                        spenNotePdfSearch2.close();
                    }
                    throw th;
                }
            }

            private static void writeToFile(String str, File file, String str2) throws IOException {
                File file2 = new File(file, AbstractC0541b.m756B(str2, Constants.TEXT_EXTENSION_WITH_DOT));
                if (file2.exists() && !file2.delete()) {
                    throw new IOException("Fail to delete dest file. [" + file2.getPath() + "]");
                }
                StringBuilder sbM15l = AbstractC0000a.m15l("writeToFile, fileName: ", str2, " / size: [");
                sbM15l.append(str == null ? 0 : str.length());
                sbM15l.append("]");
                Logger.m10999d(SpenDocumentTester.TAG, sbM15l.toString());
                if (str == null || str.isEmpty()) {
                    return;
                }
                if (!file2.createNewFile()) {
                    throw new IOException("Fail to create dest file. [" + file2.getPath() + "]");
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    PrintStream printStream = new PrintStream((OutputStream) fileOutputStream, false, StandardCharsets.UTF_8.name());
                    try {
                        printStream.print(str);
                        printStream.close();
                        fileOutputStream.close();
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Boolean call() {
                File upTestDirectory = SpenDocumentTester.this.setUpTestDirectory("extractText");
                if (upTestDirectory == null) {
                    SpenDocumentTester.this.hideProgressDialog();
                    return Boolean.FALSE;
                }
                boolean z = false;
                List<NotesDocumentEntity> allDataList = NotesDataRepositoryFactory.newInstance((Context) SpenDocumentTester.this.mContext.get()).createDocumentDataRepository().getAllDataList(false);
                AtomicInteger atomicInteger = new AtomicInteger(0);
                SpenDocumentTester.this.updateProgressMessage(atomicInteger.get() + "/" + allDataList.size());
                Iterator<NotesDocumentEntity> it = allDataList.iterator();
                while (it.hasNext()) {
                    NotesDocumentEntity next = it.next();
                    if (!next.isSdoc() && TextUtils.isEmpty(next.getMdeSpaceId()) && new File(next.getFilePath()).exists()) {
                        SpenWNote spenWNoteOpen = null;
                        try {
                            try {
                                spenWNoteOpen = DocumentFileManager.getInstance().open(context, next.getFilePath(), SpenDocumentDisplayUtils.getScreenWidth(context), 20000, false, false);
                                String fileName = getFileName(next.getTitle());
                                printBodyText(upTestDirectory, fileName, spenWNoteOpen);
                                printPdfText(upTestDirectory, fileName, spenWNoteOpen);
                                printHwText(upTestDirectory, fileName, next.getUuid());
                                if (spenWNoteOpen != null && !spenWNoteOpen.isClosed()) {
                                    try {
                                        DocumentFileManager.getInstance().close(next.getFilePath(), spenWNoteOpen, true);
                                    } catch (IOException e) {
                                        AbstractC8014b.m7204f(e, new StringBuilder("close error: "), SpenDocumentTester.TAG);
                                    }
                                }
                                z = true;
                            } catch (Exception e2) {
                                Logger.m11000e(SpenDocumentTester.TAG, "error: " + e2.getMessage());
                                if (spenWNoteOpen != null && !spenWNoteOpen.isClosed()) {
                                    try {
                                        DocumentFileManager.getInstance().close(next.getFilePath(), spenWNoteOpen, true);
                                    } catch (IOException e3) {
                                        AbstractC8014b.m7204f(e3, new StringBuilder("close error: "), SpenDocumentTester.TAG);
                                    }
                                }
                            }
                            SpenDocumentTester.this.updateProgressMessage(atomicInteger.incrementAndGet() + "/" + allDataList.size());
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException unused) {
                            }
                        } finally {
                        }
                    } else {
                        SpenDocumentTester.this.updateProgressMessage(atomicInteger.incrementAndGet() + "/" + allDataList.size());
                    }
                }
                return Boolean.valueOf(z);
            }
        }).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).observe(createCompletionListener(context, " to extract text")).execute();
    }

    public void importPdfTxtFiles() {
        Context context = this.mContext.get();
        showProgressDialog(context, "Import PDF and TXT files...");
        DataRepositoryScheduler.callable(new CallableC80892(context)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).observeOn(NotesDataTaskExecutor.getMainThreadExecutor()).observe(createCompletionListener(context, " to import PDF and TXT files")).execute();
    }

    public SpenDocumentTester setDestFolder(String str) {
        this.mDestFolderPath = str;
        return this;
    }
}
