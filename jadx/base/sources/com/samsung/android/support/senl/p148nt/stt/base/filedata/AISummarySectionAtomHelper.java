package com.samsung.android.support.senl.p148nt.stt.base.filedata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sec.android.app.voicenote.common.util.AISummarySectionData;
import com.sec.android.app.voicenote.common.util.SecureEncryption;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class AISummarySectionAtomHelper extends M4aSerializableAtomHelper {
    private static final String TAG = "AISummarizedTitleHelper";
    private final byte[] ATOM_HEADER;
    ArrayList<AISummarySectionData> mAISummarySectionDataList;
    private int mStyle;
    private ArrayList<String>[] mSummaryLines;
    private String[] mSummaryTitle;
    private long[] mTimeStamp;

    public AISummarySectionAtomHelper(String str) {
        super(str);
        this.ATOM_HEADER = new byte[]{0, 0, 0, 0, 115, 109, 100, 116};
    }

    private void extractData() {
        ArrayList<AISummarySectionData> arrayList = read();
        this.mAISummarySectionDataList = arrayList;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.mAISummarySectionDataList.size();
        this.mSummaryTitle = new String[size];
        this.mTimeStamp = new long[size];
        this.mSummaryLines = new ArrayList[size];
        this.mStyle = this.mAISummarySectionDataList.get(0).style;
        for (int i = 0; i < size; i++) {
            AISummarySectionData aISummarySectionData = this.mAISummarySectionDataList.get(i);
            this.mTimeStamp[i] = aISummarySectionData.timeStamp;
            this.mSummaryTitle[i] = aISummarySectionData.sectionTitle;
            this.mSummaryLines[i] = aISummarySectionData.summaryList;
        }
        this.isExtracted = true;
    }

    public String getJson() {
        if (!this.isExtracted) {
            extractData();
        }
        return this.mJsonString;
    }

    public int getStyle() {
        if (!this.isExtracted) {
            extractData();
        }
        return this.mStyle;
    }

    public ArrayList<String>[] getSummaryLines() {
        if (!this.isExtracted) {
            extractData();
        }
        return this.mSummaryLines;
    }

    public String[] getSummaryTitle() {
        if (!this.isExtracted) {
            extractData();
        }
        return this.mSummaryTitle;
    }

    public long[] getTimeStamp() {
        if (!this.isExtracted) {
            extractData();
        }
        return this.mTimeStamp;
    }

    public boolean overwriteMakeFile(ArrayList<AISummarySectionData> arrayList, String str) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.ATOM_HEADER);
        long atomPosition = this.mInfo.hasAtom(M4aConsts.SMDT) ? this.mInfo.getAtomPosition(M4aConsts.SMDT) : this.mInfo.getUdtaPos() + 8;
        String strEncrypt = SecureEncryption.encrypt(new GsonBuilder().create().toJson(arrayList, new TypeToken<ArrayList<AISummarySectionData>>() { // from class: com.samsung.android.support.senl.nt.stt.base.filedata.AISummarySectionAtomHelper.2
        }.getType()));
        if (strEncrypt == null) {
            Logger.m12702e(TAG, "Cannot encrypt data");
            return false;
        }
        boolean zMakeFile = makeFile(strEncrypt, atomPosition, byteBufferWrap, str, M4aConsts.SMDT);
        Logger.m12701d(TAG, "write data result: " + zMakeFile);
        return zMakeFile;
    }

    public ArrayList<AISummarySectionData> read() {
        Serializable atom;
        M4aInfo m4aInfo = this.mInfo;
        if (m4aInfo == null || !m4aInfo.hasAtom(M4aConsts.SMDT) || (atom = readAtom(this.mInfo.getAtomPosition(M4aConsts.SMDT))) == null) {
            return null;
        }
        if (!(atom instanceof String)) {
            Logger.m12702e(TAG, "Cannot read data");
            return null;
        }
        this.mJsonString = (String) atom;
        Gson gsonCreate = new GsonBuilder().create();
        Type type = new TypeToken<ArrayList<AISummarySectionData>>() { // from class: com.samsung.android.support.senl.nt.stt.base.filedata.AISummarySectionAtomHelper.1
        }.getType();
        try {
            String strDecrypt = SecureEncryption.decrypt(this.mJsonString);
            this.mJsonString = strDecrypt;
            if (strDecrypt != null) {
                return (ArrayList) gsonCreate.fromJson(strDecrypt, type);
            }
            Logger.m12702e(TAG, "Cannot decrypt data");
            return null;
        } catch (ClassCastException e) {
            Logger.m12702e(TAG, "Cannot cast object: " + e);
            return null;
        } catch (Exception e2) {
            Logger.m12702e(TAG, "Cannot convert from json: " + e2);
            return null;
        }
    }

    public boolean removeAtom(String str) {
        return removeAtom(str, M4aConsts.SMDT, false);
    }
}
