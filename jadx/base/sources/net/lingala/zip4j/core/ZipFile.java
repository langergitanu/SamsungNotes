package net.lingala.zip4j.core;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipModel;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.p210io.ZipInputStream;
import net.lingala.zip4j.progress.ProgressMonitor;
import net.lingala.zip4j.unzip.Unzip;
import net.lingala.zip4j.util.ArchiveMaintainer;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;
import net.lingala.zip4j.zip.ZipEngine;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipFile {
    private String file;
    private String fileNameCharset;
    private boolean isEncrypted;
    private int mode;
    private ProgressMonitor progressMonitor;
    private boolean runInThread;
    private ZipModel zipModel;

    public ZipFile(String str) {
        this(new File(str));
    }

    private void checkZipModel() throws Throwable {
        if (this.zipModel == null) {
            if (Zip4jUtil.checkFileExists(this.file)) {
                readZipInfo();
            } else {
                createNewZipModel();
            }
        }
    }

    private void createNewZipModel() {
        ZipModel zipModel = new ZipModel();
        this.zipModel = zipModel;
        zipModel.setZipFile(this.file);
        this.zipModel.setFileNameCharset(this.fileNameCharset);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void readZipInfo() throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileNotFoundException e;
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist");
        }
        if (!Zip4jUtil.checkFileReadAccess(this.file)) {
            throw new ZipException("no read access for the input zip file");
        }
        if (this.mode != 2) {
            throw new ZipException("Invalid mode");
        }
        try {
            randomAccessFile = new RandomAccessFile(new File(this.file), "r");
            try {
                try {
                    if (this.zipModel == null) {
                        ZipModel allHeaders = new HeaderReader(randomAccessFile).readAllHeaders(this.fileNameCharset);
                        this.zipModel = allHeaders;
                        if (allHeaders != null) {
                            allHeaders.setZipFile(this.file);
                        }
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused) {
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    throw new ZipException(e);
                }
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            randomAccessFile = null;
            e = e3;
        } catch (Throwable th3) {
            randomAccessFile = null;
            th = th3;
            if (randomAccessFile != null) {
            }
            throw th;
        }
    }

    public void addFile(File file, ZipParameters zipParameters) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        addFiles(arrayList, zipParameters);
    }

    public void addFiles(ArrayList arrayList, ZipParameters zipParameters) throws Throwable {
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (arrayList == null) {
            throw new ZipException("input file ArrayList is null, cannot add files");
        }
        if (!Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
            throw new ZipException("One or more elements in the input ArrayList is not of type File");
        }
        if (zipParameters == null) {
            throw new ZipException("input parameters are null, cannot add files to zip");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        if (Zip4jUtil.checkFileExists(this.file) && this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addFiles(arrayList, zipParameters, this.progressMonitor, this.runInThread);
    }

    public void addFolder(String str, ZipParameters zipParameters) throws Throwable {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input path is null or empty, cannot add folder to zip file");
        }
        addFolder(new File(str), zipParameters);
    }

    public void addStream(InputStream inputStream, ZipParameters zipParameters) throws Throwable {
        if (inputStream == null) {
            throw new ZipException("inputstream is null, cannot add file to zip");
        }
        if (zipParameters == null) {
            throw new ZipException("zip parameters are null");
        }
        setRunInThread(false);
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("internal error: zip model is null");
        }
        if (Zip4jUtil.checkFileExists(this.file) && this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file already exists. Zip file format does not allow updating split/spanned files");
        }
        new ZipEngine(this.zipModel).addStreamToZip(inputStream, zipParameters);
    }

    public void createZipFile(File file, ZipParameters zipParameters) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        createZipFile(arrayList, zipParameters, false, -1L);
    }

    public void createZipFileFromFolder(String str, ZipParameters zipParameters, boolean z, long j) throws Throwable {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("folderToAdd is empty or null, cannot create Zip File from folder");
        }
        createZipFileFromFolder(new File(str), zipParameters, z, j);
    }

    public void extractAll(String str) throws Throwable {
        extractAll(str, null);
    }

    public void extractFile(FileHeader fileHeader, String str) throws Throwable {
        extractFile(fileHeader, str, (UnzipParameters) null);
    }

    public String getComment() {
        return getComment(null);
    }

    public File getFile() {
        return new File(this.file);
    }

    public FileHeader getFileHeader(String str) throws Throwable {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("input file name is emtpy or null, cannot get FileHeader");
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return Zip4jUtil.getFileHeader(this.zipModel, str);
    }

    public List getFileHeaders() throws Throwable {
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null || zipModel.getCentralDirectory() == null) {
            return null;
        }
        return this.zipModel.getCentralDirectory().getFileHeaders();
    }

    public ZipInputStream getInputStream(FileHeader fileHeader) throws Throwable {
        if (fileHeader == null) {
            throw new ZipException("FileHeader is null, cannot get InputStream");
        }
        checkZipModel();
        ZipModel zipModel = this.zipModel;
        if (zipModel != null) {
            return new Unzip(zipModel).getInputStream(fileHeader);
        }
        throw new ZipException("zip model is null, cannot get inputstream");
    }

    public ProgressMonitor getProgressMonitor() {
        return this.progressMonitor;
    }

    public ArrayList getSplitZipFiles() throws Throwable {
        checkZipModel();
        return Zip4jUtil.getSplitZipFiles(this.zipModel);
    }

    public boolean isEncrypted() throws Throwable {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() == null || this.zipModel.getCentralDirectory().getFileHeaders() == null) {
            throw new ZipException("invalid zip file");
        }
        ArrayList fileHeaders = this.zipModel.getCentralDirectory().getFileHeaders();
        int i = 0;
        while (true) {
            if (i >= fileHeaders.size()) {
                break;
            }
            FileHeader fileHeader = (FileHeader) fileHeaders.get(i);
            if (fileHeader != null && fileHeader.isEncrypted()) {
                this.isEncrypted = true;
                break;
            }
            i++;
        }
        return this.isEncrypted;
    }

    public boolean isRunInThread() {
        return this.runInThread;
    }

    public boolean isSplitArchive() throws Throwable {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        return this.zipModel.isSplitArchive();
    }

    public boolean isValidZipFile() throws Throwable {
        try {
            readZipInfo();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void mergeSplitFiles(File file) throws Throwable {
        if (file == null) {
            throw new ZipException("outputZipFile is null, cannot merge split files");
        }
        if (file.exists()) {
            throw new ZipException("output Zip File already exists");
        }
        checkZipModel();
        if (this.zipModel == null) {
            throw new ZipException("zip model is null, corrupt zip file?");
        }
        ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
        archiveMaintainer.initProgressMonitorForMergeOp(this.zipModel, this.progressMonitor);
        archiveMaintainer.mergeSplitZipFiles(this.zipModel, file, this.progressMonitor, this.runInThread);
    }

    public void removeFile(String str) throws Throwable {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("file name is empty or null, cannot remove file");
        }
        if (this.zipModel == null && Zip4jUtil.checkFileExists(this.file)) {
            readZipInfo();
        }
        if (this.zipModel.isSplitArchive()) {
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, str);
        if (fileHeader == null) {
            throw new ZipException(AbstractC14516b.m15113a("could not find file header for file: ", str));
        }
        removeFile(fileHeader);
    }

    public void setComment(String str) throws Throwable {
        if (str == null) {
            throw new ZipException("input comment is null, cannot update zip file");
        }
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist, cannot set comment for zip file");
        }
        readZipInfo();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new ZipException("zipModel is null, cannot update zip file");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            throw new ZipException("end of central directory is null, cannot set comment");
        }
        new ArchiveMaintainer().setComment(this.zipModel, str);
    }

    public void setFileNameCharset(String str) throws ZipException {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("null or empty charset name");
        }
        if (!Zip4jUtil.isSupportedCharset(str)) {
            throw new ZipException(AbstractC14516b.m15113a("unsupported charset: ", str));
        }
        this.fileNameCharset = str;
    }

    public void setPassword(String str) throws Throwable {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw null;
        }
        setPassword(str.toCharArray());
    }

    public void setRunInThread(boolean z) {
        this.runInThread = z;
    }

    public ZipFile(File file) throws ZipException {
        if (file == null) {
            throw new ZipException("Input zip file parameter is not null", 1);
        }
        this.file = file.getPath();
        this.mode = 2;
        this.progressMonitor = new ProgressMonitor();
        this.runInThread = false;
    }

    public void extractAll(String str, UnzipParameters unzipParameters) throws Throwable {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            throw new ZipException("output path is null or invalid");
        }
        if (!Zip4jUtil.checkOutputFolder(str)) {
            throw new ZipException("invalid output path");
        }
        if (this.zipModel == null) {
            readZipInfo();
        }
        if (this.zipModel == null) {
            throw new ZipException("Internal error occurred when extracting zip file");
        }
        if (this.progressMonitor.getState() == 1) {
            throw new ZipException("invalid operation - Zip4j is in busy state");
        }
        new Unzip(this.zipModel).extractAll(unzipParameters, str, this.progressMonitor, this.runInThread);
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters) throws Throwable {
        extractFile(fileHeader, str, unzipParameters, (String) null);
    }

    public String getComment(String str) throws Throwable {
        if (str == null) {
            str = InternalZipConstants.CHARSET_COMMENTS_DEFAULT;
            if (!Zip4jUtil.isSupportedCharset(InternalZipConstants.CHARSET_COMMENTS_DEFAULT)) {
                str = InternalZipConstants.CHARSET_DEFAULT;
            }
        }
        if (!Zip4jUtil.checkFileExists(this.file)) {
            throw new ZipException("zip file does not exist, cannot read comment");
        }
        checkZipModel();
        ZipModel zipModel = this.zipModel;
        if (zipModel == null) {
            throw new ZipException("zip model is null, cannot read comment");
        }
        if (zipModel.getEndCentralDirRecord() == null) {
            throw new ZipException("end of central directory record is null, cannot read comment");
        }
        if (this.zipModel.getEndCentralDirRecord().getCommentBytes() == null || this.zipModel.getEndCentralDirRecord().getCommentBytes().length <= 0) {
            return null;
        }
        try {
            return new String(this.zipModel.getEndCentralDirRecord().getCommentBytes(), str);
        } catch (UnsupportedEncodingException e) {
            throw new ZipException(e);
        }
    }

    public void extractFile(FileHeader fileHeader, String str, UnzipParameters unzipParameters, String str2) throws Throwable {
        if (fileHeader != null) {
            if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
                readZipInfo();
                if (this.progressMonitor.getState() != 1) {
                    fileHeader.extractFile(this.zipModel, str, unzipParameters, str2, this.progressMonitor, this.runInThread);
                    return;
                }
                throw new ZipException("invalid operation - Zip4j is in busy state");
            }
            throw new ZipException("destination path is empty or null, cannot extract file");
        }
        throw new ZipException("input file header is null, cannot extract file");
    }

    public void addFolder(File file, ZipParameters zipParameters) throws Throwable {
        if (file == null) {
            throw new ZipException("input path is null, cannot add folder to zip file");
        }
        if (zipParameters != null) {
            addFolder(file, zipParameters, true);
            return;
        }
        throw new ZipException("input parameters are null, cannot add folder to zip file");
    }

    public void createZipFile(File file, ZipParameters zipParameters, boolean z, long j) throws Throwable {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file);
        createZipFile(arrayList, zipParameters, z, j);
    }

    public void createZipFileFromFolder(File file, ZipParameters zipParameters, boolean z, long j) throws Throwable {
        if (file == null) {
            throw new ZipException("folderToAdd is null, cannot create zip file from folder");
        }
        if (zipParameters != null) {
            if (!Zip4jUtil.checkFileExists(this.file)) {
                createNewZipModel();
                this.zipModel.setSplitArchive(z);
                if (z) {
                    this.zipModel.setSplitLength(j);
                }
                addFolder(file, zipParameters, false);
                return;
            }
            throw new ZipException(AbstractC8014b.m7199a(new StringBuffer("zip file: "), this.file, " already exists. To add files to existing zip file use addFolder method"));
        }
        throw new ZipException("input parameters are null, cannot create zip file from folder");
    }

    public void setPassword(char[] cArr) throws Throwable {
        if (this.zipModel == null) {
            readZipInfo();
            if (this.zipModel == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.zipModel.getCentralDirectory() != null && this.zipModel.getCentralDirectory().getFileHeaders() != null) {
            for (int i = 0; i < this.zipModel.getCentralDirectory().getFileHeaders().size(); i++) {
                if (this.zipModel.getCentralDirectory().getFileHeaders().get(i) != null && ((FileHeader) this.zipModel.getCentralDirectory().getFileHeaders().get(i)).isEncrypted()) {
                    ((FileHeader) this.zipModel.getCentralDirectory().getFileHeaders().get(i)).setPassword(cArr);
                }
            }
            return;
        }
        throw new ZipException("invalid zip file");
    }

    private void addFolder(File file, ZipParameters zipParameters, boolean z) throws Throwable {
        checkZipModel();
        ZipModel zipModel = this.zipModel;
        if (zipModel != null) {
            if (z && zipModel.isSplitArchive()) {
                throw new ZipException("This is a split archive. Zip file format does not allow updating split/spanned files");
            }
            new ZipEngine(this.zipModel).addFolderToZip(file, zipParameters, this.progressMonitor, this.runInThread);
            return;
        }
        throw new ZipException("internal error: zip model is null");
    }

    public void createZipFile(ArrayList arrayList, ZipParameters zipParameters) throws Throwable {
        createZipFile(arrayList, zipParameters, false, -1L);
    }

    public void createZipFile(ArrayList arrayList, ZipParameters zipParameters, boolean z, long j) throws Throwable {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(this.file)) {
            if (Zip4jUtil.checkFileExists(this.file)) {
                throw new ZipException(AbstractC8014b.m7199a(new StringBuffer("zip file: "), this.file, " already exists. To add files to existing zip file use addFile method"));
            }
            if (arrayList != null) {
                if (Zip4jUtil.checkArrayListTypes(arrayList, 1)) {
                    createNewZipModel();
                    this.zipModel.setSplitArchive(z);
                    this.zipModel.setSplitLength(j);
                    addFiles(arrayList, zipParameters);
                    return;
                }
                throw new ZipException("One or more elements in the input ArrayList is not of type File");
            }
            throw new ZipException("input file ArrayList is null, cannot create zip file");
        }
        throw new ZipException("zip file path is empty");
    }

    public void extractFile(String str, String str2) throws Throwable {
        extractFile(str, str2, (UnzipParameters) null);
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters) throws Throwable {
        extractFile(str, str2, unzipParameters, (String) null);
    }

    public void extractFile(String str, String str2, UnzipParameters unzipParameters, String str3) throws Throwable {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            if (Zip4jUtil.isStringNotNullAndNotEmpty(str2)) {
                readZipInfo();
                FileHeader fileHeader = Zip4jUtil.getFileHeader(this.zipModel, str);
                if (fileHeader != null) {
                    if (this.progressMonitor.getState() != 1) {
                        fileHeader.extractFile(this.zipModel, str2, unzipParameters, str3, this.progressMonitor, this.runInThread);
                        return;
                    }
                    throw new ZipException("invalid operation - Zip4j is in busy state");
                }
                throw new ZipException("file header not found for given file name, cannot extract file");
            }
            throw new ZipException("destination string path is empty or null, cannot extract file");
        }
        throw new ZipException("file to extract is null or empty, cannot extract file");
    }

    public void removeFile(FileHeader fileHeader) throws Throwable {
        if (fileHeader != null) {
            if (this.zipModel == null && Zip4jUtil.checkFileExists(this.file)) {
                readZipInfo();
            }
            if (!this.zipModel.isSplitArchive()) {
                ArchiveMaintainer archiveMaintainer = new ArchiveMaintainer();
                archiveMaintainer.initProgressMonitorForRemoveOp(this.zipModel, fileHeader, this.progressMonitor);
                archiveMaintainer.removeZipFile(this.zipModel, fileHeader, this.progressMonitor, this.runInThread);
                return;
            }
            throw new ZipException("Zip file format does not allow updating split/spanned files");
        }
        throw new ZipException("file header is null, cannot remove file");
    }
}
