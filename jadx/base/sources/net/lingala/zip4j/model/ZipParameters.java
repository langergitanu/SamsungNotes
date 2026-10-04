package net.lingala.zip4j.model;

import java.util.TimeZone;
import net.lingala.zip4j.util.InternalZipConstants;
import net.lingala.zip4j.util.Zip4jUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipParameters implements Cloneable {
    private int compressionLevel;
    private String defaultFolderPath;
    private String fileNameInZip;
    private boolean isSourceExternalStream;
    private char[] password;
    private String rootFolderInZip;
    private int sourceFileCRC;
    private int compressionMethod = 8;
    private boolean encryptFiles = false;
    private boolean readHiddenFiles = true;
    private int encryptionMethod = -1;
    private int aesKeyStrength = -1;
    private boolean includeRootFolder = true;
    private TimeZone timeZone = TimeZone.getDefault();

    public Object clone() {
        return super.clone();
    }

    public int getAesKeyStrength() {
        return this.aesKeyStrength;
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public int getCompressionMethod() {
        return this.compressionMethod;
    }

    public String getDefaultFolderPath() {
        return this.defaultFolderPath;
    }

    public int getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public String getFileNameInZip() {
        return this.fileNameInZip;
    }

    public char[] getPassword() {
        return this.password;
    }

    public String getRootFolderInZip() {
        return this.rootFolderInZip;
    }

    public int getSourceFileCRC() {
        return this.sourceFileCRC;
    }

    public TimeZone getTimeZone() {
        return this.timeZone;
    }

    public boolean isEncryptFiles() {
        return this.encryptFiles;
    }

    public boolean isIncludeRootFolder() {
        return this.includeRootFolder;
    }

    public boolean isReadHiddenFiles() {
        return this.readHiddenFiles;
    }

    public boolean isSourceExternalStream() {
        return this.isSourceExternalStream;
    }

    public void setAesKeyStrength(int i) {
        this.aesKeyStrength = i;
    }

    public void setCompressionLevel(int i) {
        this.compressionLevel = i;
    }

    public void setCompressionMethod(int i) {
        this.compressionMethod = i;
    }

    public void setDefaultFolderPath(String str) {
        this.defaultFolderPath = str;
    }

    public void setEncryptFiles(boolean z) {
        this.encryptFiles = z;
    }

    public void setEncryptionMethod(int i) {
        this.encryptionMethod = i;
    }

    public void setFileNameInZip(String str) {
        this.fileNameInZip = str;
    }

    public void setIncludeRootFolder(boolean z) {
        this.includeRootFolder = z;
    }

    public void setPassword(String str) {
        if (str == null) {
            return;
        }
        setPassword(str.toCharArray());
    }

    public void setReadHiddenFiles(boolean z) {
        this.readHiddenFiles = z;
    }

    public void setRootFolderInZip(String str) {
        if (Zip4jUtil.isStringNotNullAndNotEmpty(str)) {
            if (!str.endsWith("\\") && !str.endsWith("/")) {
                StringBuffer stringBuffer = new StringBuffer(str);
                stringBuffer.append(InternalZipConstants.FILE_SEPARATOR);
                str = stringBuffer.toString();
            }
            str = str.replaceAll("\\\\", "/");
        }
        this.rootFolderInZip = str;
    }

    public void setSourceExternalStream(boolean z) {
        this.isSourceExternalStream = z;
    }

    public void setSourceFileCRC(int i) {
        this.sourceFileCRC = i;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public void setPassword(char[] cArr) {
        this.password = cArr;
    }
}
