package android.print;

import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintDocumentAdapter;
import com.google.android.gms.drive.DriveFile;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class PdfPrint {
    private static final String TAG = Logger.createTag("PdfPrint");
    private ParcelFileDescriptor outputFile;
    private final PrintAttributes printAttributes;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CallBack {
        void onLayoutCancelled();

        void onLayoutFailed(CharSequence charSequence);

        void onWriteFinished(String str);
    }

    public PdfPrint(PrintAttributes printAttributes) {
        this.printAttributes = printAttributes;
    }

    private ParcelFileDescriptor getOutputFile(File file, String str) {
        if (!file.exists() && !file.mkdirs()) {
            Logger.m11000e(TAG, "getOutputFile, mkdirs is fail");
            return null;
        }
        File file2 = new File(file, str);
        try {
            file2.createNewFile();
            return ParcelFileDescriptor.open(file2, DriveFile.MODE_READ_WRITE);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$print$0(CancellationSignal cancellationSignal, CallBack callBack) {
        if (cancellationSignal.isCanceled()) {
            callBack.onLayoutCancelled();
        }
    }

    public void print(final PrintDocumentAdapter printDocumentAdapter, final File file, final String str, final CallBack callBack) {
        this.outputFile = getOutputFile(file, str);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: android.print.a
            @Override // android.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                PdfPrint.lambda$print$0(cancellationSignal, callBack);
            }
        });
        printDocumentAdapter.onLayout(null, this.printAttributes, cancellationSignal, new PrintDocumentAdapter.LayoutResultCallback() { // from class: android.print.PdfPrint.1
            @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
            public void onLayoutCancelled() {
                Logger.m11003i(PdfPrint.TAG, "onLayoutCancelled");
                CallBack callBack2 = callBack;
                if (callBack2 != null) {
                    callBack2.onLayoutCancelled();
                }
            }

            @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
            public void onLayoutFailed(CharSequence charSequence) {
                Logger.m11003i(PdfPrint.TAG, "onLayoutFailed");
                CallBack callBack2 = callBack;
                if (callBack2 != null) {
                    callBack2.onLayoutFailed(charSequence);
                }
            }

            @Override // android.print.PrintDocumentAdapter.LayoutResultCallback
            public void onLayoutFinished(PrintDocumentInfo printDocumentInfo, boolean z) {
                printDocumentAdapter.onWrite(new PageRange[]{PageRange.ALL_PAGES}, PdfPrint.this.outputFile, new CancellationSignal(), new PrintDocumentAdapter.WriteResultCallback() { // from class: android.print.PdfPrint.1.1
                    @Override // android.print.PrintDocumentAdapter.WriteResultCallback
                    public void onWriteCancelled() {
                        super.onWriteCancelled();
                        Logger.m11003i(PdfPrint.TAG, "onWriteCancelled");
                        CallBack callBack2 = callBack;
                        if (callBack2 != null) {
                            callBack2.onLayoutCancelled();
                        }
                    }

                    @Override // android.print.PrintDocumentAdapter.WriteResultCallback
                    public void onWriteFailed(CharSequence charSequence) {
                        super.onWriteFailed(charSequence);
                        Logger.m11003i(PdfPrint.TAG, "onWriteFailed");
                        CallBack callBack2 = callBack;
                        if (callBack2 != null) {
                            callBack2.onLayoutFailed(charSequence);
                        }
                    }

                    @Override // android.print.PrintDocumentAdapter.WriteResultCallback
                    public void onWriteFinished(PageRange[] pageRangeArr) {
                        super.onWriteFinished(pageRangeArr);
                        Logger.m11003i(PdfPrint.TAG, "onWriteFinished");
                        CallBack callBack2 = callBack;
                        if (callBack2 != null) {
                            callBack2.onWriteFinished(file.getPath() + "/" + str);
                        }
                    }
                });
            }
        }, null);
    }
}
