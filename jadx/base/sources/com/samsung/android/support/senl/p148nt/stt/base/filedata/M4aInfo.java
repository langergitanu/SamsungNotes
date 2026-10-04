package com.samsung.android.support.senl.p148nt.stt.base.filedata;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class M4aInfo {
    private static final String TAG = "M4aInfo";
    private String mPath;
    private int recordingMode;
    private int mFileMoovLength = -1;
    private int mFileUdtaLength = -1;
    private long mMoovPos = -1;
    private long mUdtaPos = -1;
    public HashMap<String, Long> customAtomPosition = new HashMap<>();
    private final HashMap<String, AtomProperties> mAtomMap = new HashMap<>();

    public M4aInfo(String str) {
        this.mPath = str;
        this.customAtomPosition.put(M4aConsts.STTD, -1L);
        this.customAtomPosition.put(M4aConsts.SMTA, -1L);
        this.customAtomPosition.put(M4aConsts.SAUT, -1L);
    }

    public int getAtomLength(String str) {
        AtomProperties atomProperties = this.mAtomMap.get(str);
        if (atomProperties != null) {
            return atomProperties.getLength();
        }
        return 0;
    }

    public long getAtomPosition(String str) {
        AtomProperties atomProperties = this.mAtomMap.get(str);
        if (atomProperties != null) {
            return atomProperties.getPosition();
        }
        return 0L;
    }

    public int getFileMoovLength() {
        return this.mFileMoovLength;
    }

    public int getFileUdtaLength() {
        return this.mFileUdtaLength;
    }

    public long getMoovPos() {
        return this.mMoovPos;
    }

    public String getPath() {
        return this.mPath;
    }

    public int getRecordingMode() {
        return this.recordingMode;
    }

    public long getUdtaPos() {
        return this.mUdtaPos;
    }

    public boolean hasAtom(String str) {
        return this.mAtomMap.get(str) != null;
    }

    public void putAtom(String str, int i, long j) {
        this.mAtomMap.put(str, new AtomProperties(i, j));
    }

    public void setFileMoovLength(int i) {
        this.mFileMoovLength = i;
    }

    public void setFileUdtaLength(int i) {
        this.mFileUdtaLength = i;
    }

    public void setMoovPos(long j) {
        this.mMoovPos = j;
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setRecordingMode(int i) {
        this.recordingMode = i;
    }

    public void setUdtaPos(long j) {
        this.mUdtaPos = j;
    }
}
