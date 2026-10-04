package com.samsung.android.support.senl.p148nt.stt.base.filedata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.sec.android.app.voicenote.common.util.ParagraphInfo;
import com.sec.android.app.voicenote.common.util.SecureEncryption;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class AIParagraphAtomHelper extends M4aSerializableAtomHelper {
    private static final String TAG = "AIParagraphAtomHelper";
    private final byte[] ATOM_HEADER;
    private ParagraphInfo paragraphData;

    public AIParagraphAtomHelper(String str) {
        super(str);
        this.ATOM_HEADER = new byte[]{0, 0, 0, 0, SprAttributeBase.TYPE_SHADOW, 103, 100, 116};
    }

    private void extractData() {
        this.paragraphData = read();
        this.isExtracted = true;
    }

    public long[] getEndTimeList() {
        if (!this.isExtracted) {
            extractData();
        }
        ParagraphInfo paragraphInfo = this.paragraphData;
        if (paragraphInfo == null) {
            return null;
        }
        return paragraphInfo.endTime;
    }

    public int getSize() {
        if (!this.isExtracted) {
            extractData();
        }
        ParagraphInfo paragraphInfo = this.paragraphData;
        if (paragraphInfo == null) {
            return -1;
        }
        return paragraphInfo.size;
    }

    public int[] getSpeakerIdList() {
        if (!this.isExtracted) {
            extractData();
        }
        ParagraphInfo paragraphInfo = this.paragraphData;
        if (paragraphInfo == null) {
            return null;
        }
        return paragraphInfo.speakerId;
    }

    public long[] getStartTimeList() {
        if (!this.isExtracted) {
            extractData();
        }
        ParagraphInfo paragraphInfo = this.paragraphData;
        if (paragraphInfo == null) {
            return null;
        }
        return paragraphInfo.startTime;
    }

    public boolean overwriteMakeFile(ParagraphInfo paragraphInfo, String str) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.ATOM_HEADER);
        long atomPosition = this.mInfo.hasAtom(M4aConsts.PGDT) ? this.mInfo.getAtomPosition(M4aConsts.PGDT) : this.mInfo.getUdtaPos() + 8;
        String strEncrypt = SecureEncryption.encrypt(new GsonBuilder().create().toJson(paragraphInfo, new TypeToken<ParagraphInfo>() { // from class: com.samsung.android.support.senl.nt.stt.base.filedata.AIParagraphAtomHelper.2
        }.getType()));
        if (strEncrypt == null) {
            Logger.m12702e(TAG, "Cannot encrypt data");
            return false;
        }
        boolean zMakeFile = makeFile(strEncrypt, atomPosition, byteBufferWrap, str, M4aConsts.PGDT);
        Logger.m12701d(TAG, "write data result: " + zMakeFile);
        return zMakeFile;
    }

    public ParagraphInfo read() {
        Serializable atom;
        M4aInfo m4aInfo = this.mInfo;
        if (m4aInfo == null || !m4aInfo.hasAtom(M4aConsts.PGDT) || (atom = readAtom(this.mInfo.getAtomPosition(M4aConsts.PGDT))) == null) {
            return null;
        }
        if (!(atom instanceof String)) {
            Logger.m12702e(TAG, "Cannot read data");
            return null;
        }
        String str = (String) atom;
        Gson gsonCreate = new GsonBuilder().create();
        Type type = new TypeToken<ParagraphInfo>() { // from class: com.samsung.android.support.senl.nt.stt.base.filedata.AIParagraphAtomHelper.1
        }.getType();
        try {
            String strDecrypt = SecureEncryption.decrypt(str);
            if (strDecrypt != null) {
                return (ParagraphInfo) gsonCreate.fromJson(strDecrypt, type);
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
        return removeAtom(str, M4aConsts.PGDT, false);
    }
}
