package net.lingala.zip4j.unzip;

import java.io.File;
import java.util.ArrayList;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.CentralDirectory;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.p210io.ZipInputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Unzip {
    private ZipModel zipModel;

    public Unzip(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("ZipModel is null");
        }
        this.zipModel = zipModel;
    }

    private long calculateTotalWork(ArrayList arrayList) throws ZipException {
        if (arrayList == null) {
            throw new ZipException("fileHeaders is null, cannot calculate total work");
        }
        long compressedSize = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            FileHeader fileHeader = (FileHeader) arrayList.get(i);
            compressedSize = ((fileHeader.getZip64ExtendedInfo() == null || fileHeader.getZip64ExtendedInfo().getUnCompressedSize() <= 0) ? fileHeader.getCompressedSize() : fileHeader.getZip64ExtendedInfo().getCompressedSize()) + compressedSize;
        }
        return compressedSize;
    }

    private void checkOutputDirectoryStructure(FileHeader fileHeader, String str, String str2) throws ZipException {
        if (fileHeader == null || !Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("Cannot check output directory structure...one of the parameters was null");
        }
        String fileName = fileHeader.getFileName();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            str2 = fileName;
        }
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
            StringBuffer stringBuffer = new StringBuffer(String.valueOf(str));
            stringBuffer.append(str2);
            try {
                File file = new File(new File(stringBuffer.toString()).getParent());
                if (file.exists()) {
                    return;
                }
                file.mkdirs();
            } catch (Exception e) {
                throw new ZipException(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExtractAll(ArrayList arrayList, UnzipParameters unzipParameters, ProgressMonitor progressMonitor, String str) throws ZipException {
        int i = 0;
        while (i < arrayList.size()) {
            UnzipParameters unzipParameters2 = unzipParameters;
            ProgressMonitor progressMonitor2 = progressMonitor;
            String str2 = str;
            initExtractFile((FileHeader) arrayList.get(i), str2, unzipParameters2, null, progressMonitor2);
            if (progressMonitor2.isCancelAllTasks()) {
                progressMonitor2.setResult(3);
                progressMonitor2.setState(0);
                return;
            } else {
                i++;
                str = str2;
                unzipParameters = unzipParameters2;
                progressMonitor = progressMonitor2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initExtractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters, String str2, ProgressMonitor progressMonitor) throws ZipException {
        if (fileHeader == null) {
            throw new ZipException("fileHeader is null");
        }
        try {
            progressMonitor.setFileName(fileHeader.getFileName());
            String str3 = InternalZipConstants.FILE_SEPARATOR;
            if (!str.endsWith(str3)) {
                StringBuffer stringBuffer = new StringBuffer(str);
                stringBuffer.append(str3);
                str = stringBuffer.toString();
            }
            if (!fileHeader.isDirectory()) {
                checkOutputDirectoryStructure(fileHeader, str, str2);
                try {
                    new UnzipEngine(this.zipModel, fileHeader).unzipFile(progressMonitor, str, str2, unzipParameters);
                    return;
                } catch (Exception e) {
                    progressMonitor.endProgressMonitorError(e);
                    throw new ZipException(e);
                }
            }
            try {
                String fileName = fileHeader.getFileName();
                if (Zip4jUtil.isStringNotNullAndNotEmpty(fileName)) {
                    StringBuffer stringBuffer2 = new StringBuffer(String.valueOf(str));
                    stringBuffer2.append(fileName);
                    File file = new File(stringBuffer2.toString());
                    if (file.exists()) {
                        return;
                    }
                    file.mkdirs();
                }
            } catch (Exception e2) {
                progressMonitor.endProgressMonitorError(e2);
                throw new ZipException(e2);
            }
        } catch (ZipException e3) {
            progressMonitor.endProgressMonitorError(e3);
            throw e3;
        } catch (Exception e5) {
            progressMonitor.endProgressMonitorError(e5);
            throw new ZipException(e5);
        }
    }

    public void extractAll(final UnzipParameters unzipParameters, final String str, final ProgressMonitor progressMonitor, boolean z) throws ZipException {
        CentralDirectory centralDirectory = this.zipModel.getCentralDirectory();
        if (centralDirectory == null || centralDirectory.getFileHeaders() == null) {
            throw new ZipException("invalid central directory in zipModel");
        }
        final ArrayList fileHeaders = centralDirectory.getFileHeaders();
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(calculateTotalWork(fileHeaders));
        progressMonitor.setState(1);
        if (z) {
            new Thread(this, InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.unzip.Unzip.1
                final /* synthetic */ Unzip this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        this.this$0.initExtractAll(fileHeaders, unzipParameters, progressMonitor, str);
                        progressMonitor.endProgressMonitorSuccess();
                    } catch (ZipException unused) {
                    }
                }
            }.start();
        } else {
            initExtractAll(fileHeaders, unzipParameters, progressMonitor, str);
        }
    }

    public void extractFile(final FileHeader fileHeader, final String str, final UnzipParameters unzipParameters, final String str2, final ProgressMonitor progressMonitor, boolean z) {
        if (fileHeader == null) {
            throw new ZipException("fileHeader is null");
        }
        progressMonitor.setCurrentOperation(1);
        progressMonitor.setTotalWork(fileHeader.getCompressedSize());
        progressMonitor.setState(1);
        progressMonitor.setPercentDone(0);
        progressMonitor.setFileName(fileHeader.getFileName());
        if (z) {
            new Thread(this, InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.unzip.Unzip.2
                final /* synthetic */ Unzip this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        this.this$0.initExtractFile(fileHeader, str, unzipParameters, str2, progressMonitor);
                        progressMonitor.endProgressMonitorSuccess();
                    } catch (ZipException unused) {
                    }
                }
            }.start();
        } else {
            initExtractFile(fileHeader, str, unzipParameters, str2, progressMonitor);
            progressMonitor.endProgressMonitorSuccess();
        }
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) {
        return new UnzipEngine(this.zipModel, fileHeader).getInputStream();
    }
}
