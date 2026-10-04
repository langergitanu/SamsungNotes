package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PdfPrintDocumentAdapter extends PrintDocumentAdapter {
    private static final String TAG = "PdfPrintDocumentAdapter";
    private String mFileName;
    private String mPath;

    public PdfPrintDocumentAdapter(String str, String str2) {
        this.mPath = str;
        this.mFileName = str2;
    }

    @Override // android.print.PrintDocumentAdapter
    public void onFinish() {
        Logger.m10999d(TAG, "onFinish");
        super.onFinish();
    }

    @Override // android.print.PrintDocumentAdapter
    public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
        Logger.m10999d(TAG, "onLayout");
        if (cancellationSignal.isCanceled()) {
            layoutResultCallback.onLayoutCancelled();
        } else {
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.mFileName).setContentType(0).build(), true);
        }
    }

    @Override // android.print.PrintDocumentAdapter
    public void onStart() {
        Logger.m10999d(TAG, "onStart");
        super.onStart();
    }

    @Override // android.print.PrintDocumentAdapter
    public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        Logger.m10999d(TAG, "onWrite");
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(this.mPath));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i);
                        }
                    }
                    fileOutputStream.close();
                    fileInputStream.close();
                } finally {
                }
            } finally {
            }
        } catch (Exception e) {
            Logger.m11000e(TAG, e.getMessage());
        }
        writeResultCallback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
    }
}
