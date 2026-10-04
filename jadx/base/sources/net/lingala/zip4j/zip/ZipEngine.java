package net.lingala.zip4j.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.EndCentralDirRecord;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.p210io.SplitOutputStream;
import net.lingala.zip4j.p210io.ZipOutputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.CRCUtil;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipEngine {
    private ZipModel zipModel;

    public ZipEngine(ZipModel zipModel) throws ZipException {
        if (zipModel == null) {
            throw new ZipException("zip model is null in ZipEngine constructor");
        }
        this.zipModel = zipModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private long calculateTotalWork(ArrayList arrayList, ZipParameters zipParameters) throws ZipException {
        if (arrayList == null) {
            throw new ZipException("file list is null, cannot calculate total work");
        }
        long fileLengh = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if ((arrayList.get(i) instanceof File) && ((File) arrayList.get(i)).exists()) {
                long fileLengh2 = ((zipParameters.isEncryptFiles() && zipParameters.getEncryptionMethod() == 0) ? Zip4jUtil.getFileLengh((File) arrayList.get(i)) * 2 : Zip4jUtil.getFileLengh((File) arrayList.get(i))) + fileLengh;
                if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null || this.zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
                    fileLengh = fileLengh2;
                } else {
                    FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, Zip4jUtil.getRelativeFileName(((File) arrayList.get(i)).getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        fileLengh = (Zip4jUtil.getFileLengh(new File(this.zipModel.getZipFile())) - fileHeader.getCompressedSize()) + fileLengh2;
                    }
                }
            }
        }
        return fileLengh;
    }

    private void checkParameters(ZipParameters zipParameters) throws ZipException {
        if (zipParameters == null) {
            throw new ZipException("cannot validate zip parameters");
        }
        if (zipParameters.getCompressionMethod() != 0 && zipParameters.getCompressionMethod() != 8) {
            throw new ZipException("unsupported compression type");
        }
        if (zipParameters.getCompressionMethod() == 8 && zipParameters.getCompressionLevel() < 0 && zipParameters.getCompressionLevel() > 9) {
            throw new ZipException("invalid compression level. compression level dor deflate should be in the range of 0-9");
        }
        if (!zipParameters.isEncryptFiles()) {
            zipParameters.setAesKeyStrength(-1);
            zipParameters.setEncryptionMethod(-1);
        } else {
            if (zipParameters.getEncryptionMethod() != 0 && zipParameters.getEncryptionMethod() != 99) {
                throw new ZipException("unsupported encryption method");
            }
            if (zipParameters.getPassword() == null || zipParameters.getPassword().length <= 0) {
                throw new ZipException("input password is empty or null");
            }
        }
    }

    private EndCentralDirRecord createEndOfCentralDirectoryRecord() {
        EndCentralDirRecord endCentralDirRecord = new EndCentralDirRecord();
        endCentralDirRecord.setSignature(InternalZipConstants.ENDSIG);
        endCentralDirRecord.setNoOfThisDisk(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDir(0);
        endCentralDirRecord.setTotNoOfEntriesInCentralDirOnThisDisk(0);
        endCentralDirRecord.setOffsetOfStartOfCentralDir(0L);
        return endCentralDirRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initAddFiles(ArrayList arrayList, ZipParameters zipParameters, ProgressMonitor progressMonitor) throws Throwable {
        ZipOutputStream zipOutputStream;
        if (arrayList == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null when adding files");
        }
        if (arrayList.size() <= 0) {
            throw new ZipException("no files to add");
        }
        if (this.zipModel.getEndCentralDirRecord() == null) {
            this.zipModel.setEndCentralDirRecord(createEndOfCentralDirectoryRecord());
        }
        ?? r02 = 0;
        ?? r03 = 0;
        r02 = 0;
        try {
            try {
                checkParameters(zipParameters);
                removeFilesIfExists(arrayList, zipParameters, progressMonitor);
                boolean zCheckFileExists = Zip4jUtil.checkFileExists(this.zipModel.getZipFile());
                SplitOutputStream splitOutputStream = new SplitOutputStream(new File(this.zipModel.getZipFile()), this.zipModel.getSplitLength());
                zipOutputStream = new ZipOutputStream(splitOutputStream, this.zipModel);
                if (zCheckFileExists) {
                    try {
                        if (this.zipModel.getEndCentralDirRecord() == null) {
                            throw new ZipException("invalid end of central directory record");
                        }
                        splitOutputStream.seek(this.zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                    } catch (ZipException e) {
                        e = e;
                        progressMonitor.endProgressMonitorError(e);
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        progressMonitor.endProgressMonitorError(e);
                        throw new ZipException(e);
                    } catch (Throwable th) {
                        th = th;
                        if (r02 != 0) {
                            try {
                                r02.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (zipOutputStream != null) {
                            throw th;
                        }
                        try {
                            zipOutputStream.close();
                            throw th;
                        } catch (IOException unused2) {
                            throw th;
                        }
                    }
                }
                byte[] bArr = new byte[4096];
                for (int i = 0; i < arrayList.size(); i++) {
                    ZipParameters zipParameters2 = (ZipParameters) zipParameters.clone();
                    progressMonitor.setFileName(((File) arrayList.get(i)).getAbsolutePath());
                    if (!((File) arrayList.get(i)).isDirectory()) {
                        if (zipParameters2.isEncryptFiles() && zipParameters2.getEncryptionMethod() == 0) {
                            progressMonitor.setCurrentOperation(3);
                            zipParameters2.setSourceFileCRC((int) CRCUtil.computeFileCRC(((File) arrayList.get(i)).getAbsolutePath(), progressMonitor));
                            progressMonitor.setCurrentOperation(0);
                        }
                        if (Zip4jUtil.getFileLengh((File) arrayList.get(i)) == 0) {
                            zipParameters2.setCompressionMethod(0);
                        }
                    }
                    zipOutputStream.putNextEntry((File) arrayList.get(i), zipParameters2);
                    ?? IsDirectory = ((File) arrayList.get(i)).isDirectory();
                    if (IsDirectory != 0) {
                        zipOutputStream.closeEntry();
                    } else {
                        IsDirectory = new FileInputStream((File) arrayList.get(i));
                        while (true) {
                            try {
                                int i2 = IsDirectory.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, i2);
                                progressMonitor.updateWorkCompleted(i2);
                            } catch (ZipException e3) {
                                e = e3;
                                progressMonitor.endProgressMonitorError(e);
                                throw e;
                            } catch (Exception e5) {
                                e = e5;
                                progressMonitor.endProgressMonitorError(e);
                                throw new ZipException(e);
                            } catch (Throwable th2) {
                                th = th2;
                                r02 = IsDirectory;
                                if (r02 != 0) {
                                }
                                if (zipOutputStream != null) {
                                }
                            }
                        }
                        zipOutputStream.closeEntry();
                        IsDirectory.close();
                        r03 = IsDirectory;
                    }
                }
                zipOutputStream.finish();
                progressMonitor.endProgressMonitorSuccess();
                if (r03 != 0) {
                    try {
                        r03.close();
                    } catch (IOException unused3) {
                    }
                }
                try {
                    zipOutputStream.close();
                } catch (IOException unused4) {
                }
            } catch (Throwable th3) {
                th = th3;
                zipOutputStream = null;
            }
        } catch (ZipException e6) {
            e = e6;
        } catch (Exception e7) {
            e = e7;
        } catch (Throwable th4) {
            th = th4;
            zipOutputStream = null;
        }
    }

    private RandomAccessFile prepareFileOutputStream() throws ZipException {
        String zipFile = this.zipModel.getZipFile();
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(zipFile)) {
            throw new ZipException("invalid output path");
        }
        try {
            File file = new File(zipFile);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            return new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
        } catch (FileNotFoundException e) {
            throw new ZipException(e);
        }
    }

    private void removeFilesIfExists(ArrayList arrayList, ZipParameters zipParameters, ProgressMonitor progressMonitor) {
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null || this.zipModel.getCentralDirectory().getFileHeaders().size() <= 0) {
            return;
        }
        RandomAccessFile randomAccessFilePrepareFileOutputStream = null;
        for (int i = 0; i < arrayList.size(); i++) {
            try {
                try {
                    FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, Zip4jUtil.getRelativeFileName(((File) arrayList.get(i)).getAbsolutePath(), zipParameters.getRootFolderInZip(), zipParameters.getDefaultFolderPath()));
                    if (fileHeader != null) {
                        if (randomAccessFilePrepareFileOutputStream != null) {
                            randomAccessFilePrepareFileOutputStream.close();
                            randomAccessFilePrepareFileOutputStream = null;
                        }
                        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
                        progressMonitor.setCurrentOperation(2);
                        HashMap mapInitRemoveZipFile = archiveMaintainer.initRemoveZipFile(this.zipModel, fileHeader, progressMonitor);
                        if (progressMonitor.isCancelAllTasks()) {
                            progressMonitor.setResult(3);
                            progressMonitor.setState(0);
                            if (randomAccessFilePrepareFileOutputStream != null) {
                                try {
                                    randomAccessFilePrepareFileOutputStream.close();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                            return;
                        }
                        progressMonitor.setCurrentOperation(0);
                        if (randomAccessFilePrepareFileOutputStream == null) {
                            randomAccessFilePrepareFileOutputStream = prepareFileOutputStream();
                            if (mapInitRemoveZipFile != null && mapInitRemoveZipFile.get(InternalZipConstants.OFFSET_CENTRAL_DIR) != null) {
                                try {
                                    long j = Long.parseLong((String) mapInitRemoveZipFile.get(InternalZipConstants.OFFSET_CENTRAL_DIR));
                                    if (j >= 0) {
                                        randomAccessFilePrepareFileOutputStream.seek(j);
                                    }
                                } catch (NumberFormatException unused2) {
                                    throw new ZipException("NumberFormatException while parsing offset central directory. Cannot update already existing file header");
                                } catch (Exception unused3) {
                                    throw new ZipException("Error while parsing offset central directory. Cannot update already existing file header");
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (IOException e) {
                    throw new ZipException(e);
                }
            } catch (Throwable th) {
                if (randomAccessFilePrepareFileOutputStream != null) {
                    try {
                        randomAccessFilePrepareFileOutputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        }
        if (randomAccessFilePrepareFileOutputStream != null) {
            try {
                randomAccessFilePrepareFileOutputStream.close();
            } catch (IOException unused5) {
            }
        }
    }

    public void addFiles(final ArrayList arrayList, final ZipParameters zipParameters, final ProgressMonitor progressMonitor, boolean z) throws Throwable {
        if (arrayList == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null when adding files");
        }
        if (arrayList.size() <= 0) {
            throw new ZipException("no files to add");
        }
        progressMonitor.setTotalWork(calculateTotalWork(arrayList, zipParameters));
        progressMonitor.setCurrentOperation(0);
        progressMonitor.setState(1);
        progressMonitor.setResult(1);
        if (z) {
            new Thread(this, InternalZipConstants.THREAD_NAME) { // from class: net.lingala.zip4j.zip.ZipEngine.1
                final /* synthetic */ ZipEngine this$0;

                {
                    this.this$0 = this;
                }

                @Override // java.lang.Thread, java.lang.Runnable
                public void run() throws Throwable {
                    try {
                        this.this$0.initAddFiles(arrayList, zipParameters, progressMonitor);
                    } catch (ZipException unused) {
                    }
                }
            }.start();
        } else {
            initAddFiles(arrayList, zipParameters, progressMonitor);
        }
    }

    public void addFolderToZip(File file, ZipParameters zipParameters, ProgressMonitor progressMonitor, boolean z) throws Throwable {
        String absolutePath;
        if (file == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null, cannot add folder to zip");
        }
        if (!Zip4jUtil.checkFileExists(file.getAbsolutePath())) {
            throw new ZipException("input folder does not exist");
        }
        if (!file.isDirectory()) {
            throw new ZipException("input file is not a folder, user addFileToZip method to add files");
        }
        if (!Zip4jUtil.checkFileReadAccess(file.getAbsolutePath())) {
            StringBuffer stringBuffer = new StringBuffer("cannot read folder: ");
            stringBuffer.append(file.getAbsolutePath());
            throw new ZipException(stringBuffer.toString());
        }
        if (zipParameters.isIncludeRootFolder()) {
            absolutePath = "";
            if (file.getAbsolutePath() != null) {
                if (file.getAbsoluteFile().getParentFile() != null) {
                    absolutePath = file.getAbsoluteFile().getParentFile().getAbsolutePath();
                }
            } else if (file.getParentFile() != null) {
                absolutePath = file.getParentFile().getAbsolutePath();
            }
        } else {
            absolutePath = file.getAbsolutePath();
        }
        zipParameters.setDefaultFolderPath(absolutePath);
        ArrayList filesInDirectoryRec = Zip4jUtil.getFilesInDirectoryRec(file, zipParameters.isReadHiddenFiles());
        if (zipParameters.isIncludeRootFolder()) {
            if (filesInDirectoryRec == null) {
                filesInDirectoryRec = new ArrayList();
            }
            filesInDirectoryRec.add(file);
        }
        addFiles(filesInDirectoryRec, zipParameters, progressMonitor, z);
    }

    public void addStreamToZip(InputStream inputStream, ZipParameters zipParameters) throws Throwable {
        if (inputStream == null || zipParameters == null) {
            throw new ZipException("one of the input parameters is null, cannot add stream to zip");
        }
        ZipOutputStream zipOutputStream = null;
        try {
            try {
                checkParameters(zipParameters);
                boolean zCheckFileExists = Zip4jUtil.checkFileExists(this.zipModel.getZipFile());
                SplitOutputStream splitOutputStream = new SplitOutputStream(new File(this.zipModel.getZipFile()), this.zipModel.getSplitLength());
                ZipOutputStream zipOutputStream2 = new ZipOutputStream(splitOutputStream, this.zipModel);
                if (zCheckFileExists) {
                    try {
                        if (this.zipModel.getEndCentralDirRecord() == null) {
                            throw new ZipException("invalid end of central directory record");
                        }
                        splitOutputStream.seek(this.zipModel.getEndCentralDirRecord().getOffsetOfStartOfCentralDir());
                    } catch (ZipException e) {
                        throw e;
                    } catch (Exception e2) {
                        e = e2;
                        throw new ZipException(e);
                    } catch (Throwable th) {
                        th = th;
                        zipOutputStream = zipOutputStream2;
                        if (zipOutputStream != null) {
                            try {
                                zipOutputStream.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                }
                byte[] bArr = new byte[4096];
                zipOutputStream2.putNextEntry(null, zipParameters);
                if (!zipParameters.getFileNameInZip().endsWith("/") && !zipParameters.getFileNameInZip().endsWith("\\")) {
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            break;
                        } else {
                            zipOutputStream2.write(bArr, 0, i);
                        }
                    }
                }
                zipOutputStream2.closeEntry();
                zipOutputStream2.finish();
                try {
                    zipOutputStream2.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (ZipException e3) {
        } catch (Exception e5) {
            e = e5;
        }
    }
}
