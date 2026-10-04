package net.lingala.zip4j.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ZipModel implements Cloneable {
    private ArchiveExtraDataRecord archiveExtraDataRecord;
    private CentralDirectory centralDirectory;
    private List dataDescriptorList;
    private long end;
    private EndCentralDirRecord endCentralDirRecord;
    private String fileNameCharset;
    private boolean isNestedZipFile;
    private boolean isZip64Format;
    private List localFileHeaderList;
    private boolean splitArchive;
    private long splitLength = -1;
    private long start;
    private Zip64EndCentralDirLocator zip64EndCentralDirLocator;
    private Zip64EndCentralDirRecord zip64EndCentralDirRecord;
    private String zipFile;

    public Object clone() {
        return super.clone();
    }

    public ArchiveExtraDataRecord getArchiveExtraDataRecord() {
        return this.archiveExtraDataRecord;
    }

    public CentralDirectory getCentralDirectory() {
        return this.centralDirectory;
    }

    public List getDataDescriptorList() {
        return this.dataDescriptorList;
    }

    public long getEnd() {
        return this.end;
    }

    public EndCentralDirRecord getEndCentralDirRecord() {
        return this.endCentralDirRecord;
    }

    public String getFileNameCharset() {
        return this.fileNameCharset;
    }

    public List getLocalFileHeaderList() {
        return this.localFileHeaderList;
    }

    public long getSplitLength() {
        return this.splitLength;
    }

    public long getStart() {
        return this.start;
    }

    public Zip64EndCentralDirLocator getZip64EndCentralDirLocator() {
        return this.zip64EndCentralDirLocator;
    }

    public Zip64EndCentralDirRecord getZip64EndCentralDirRecord() {
        return this.zip64EndCentralDirRecord;
    }

    public String getZipFile() {
        return this.zipFile;
    }

    public boolean isNestedZipFile() {
        return this.isNestedZipFile;
    }

    public boolean isSplitArchive() {
        return this.splitArchive;
    }

    public boolean isZip64Format() {
        return this.isZip64Format;
    }

    public void setArchiveExtraDataRecord(ArchiveExtraDataRecord archiveExtraDataRecord) {
        this.archiveExtraDataRecord = archiveExtraDataRecord;
    }

    public void setCentralDirectory(CentralDirectory centralDirectory) {
        this.centralDirectory = centralDirectory;
    }

    public void setDataDescriptorList(List list) {
        this.dataDescriptorList = list;
    }

    public void setEnd(long j) {
        this.end = j;
    }

    public void setEndCentralDirRecord(EndCentralDirRecord endCentralDirRecord) {
        this.endCentralDirRecord = endCentralDirRecord;
    }

    public void setFileNameCharset(String str) {
        this.fileNameCharset = str;
    }

    public void setLocalFileHeaderList(List list) {
        this.localFileHeaderList = list;
    }

    public void setNestedZipFile(boolean z) {
        this.isNestedZipFile = z;
    }

    public void setSplitArchive(boolean z) {
        this.splitArchive = z;
    }

    public void setSplitLength(long j) {
        this.splitLength = j;
    }

    public void setStart(long j) {
        this.start = j;
    }

    public void setZip64EndCentralDirLocator(Zip64EndCentralDirLocator zip64EndCentralDirLocator) {
        this.zip64EndCentralDirLocator = zip64EndCentralDirLocator;
    }

    public void setZip64EndCentralDirRecord(Zip64EndCentralDirRecord zip64EndCentralDirRecord) {
        this.zip64EndCentralDirRecord = zip64EndCentralDirRecord;
    }

    public void setZip64Format(boolean z) {
        this.isZip64Format = z;
    }

    public void setZipFile(String str) {
        this.zipFile = str;
    }
}
