package com.samsung.android.support.senl.p148nt.stt.base.filedata;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.sec.android.app.voicenote.common.util.AiSpeakerData;
import com.sec.android.app.voicenote.common.util.SecureEncryption;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class AISpeakerAtomHelper extends M4aSerializableAtomHelper {
    private static final String TAG = "AISpeakerAtomHelper";
    private final byte[] ATOM_HEADER;
    private AiSpeakerData speakerData;

    public AISpeakerAtomHelper(String str) {
        super(str);
        this.ATOM_HEADER = new byte[]{0, 0, 0, 0, 115, SprAttributeBase.TYPE_SHADOW, 100, 116};
    }

    private void extractData() {
        this.speakerData = read();
        this.isExtracted = true;
    }

    public String getJson() {
        if (!this.isExtracted) {
            extractData();
        }
        return this.mJsonString;
    }

    public Map<Integer, String> getSpeakerData() {
        if (!this.isExtracted) {
            extractData();
        }
        AiSpeakerData aiSpeakerData = this.speakerData;
        if (aiSpeakerData == null) {
            return null;
        }
        return aiSpeakerData.mSpeakerNameMap;
    }

    public boolean overwriteMakeFile(AiSpeakerData aiSpeakerData, String str) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.ATOM_HEADER);
        long atomPosition = this.mInfo.hasAtom(M4aConsts.SPDT) ? this.mInfo.getAtomPosition(M4aConsts.SPDT) : this.mInfo.getUdtaPos() + 8;
        String json = new GsonBuilder().create().toJson(aiSpeakerData, new TypeToken<AiSpeakerData>() { // from class: com.samsung.android.support.senl.nt.stt.base.filedata.AISpeakerAtomHelper.2
        }.getType());
        this.mJsonString = json;
        String strEncrypt = SecureEncryption.encrypt(json);
        this.mJsonString = strEncrypt;
        if (strEncrypt == null) {
            Logger.m12702e(TAG, "Cannot encrypt data");
            return false;
        }
        boolean zMakeFile = makeFile(strEncrypt, atomPosition, byteBufferWrap, str, M4aConsts.SPDT);
        Logger.m12701d(TAG, "write data result: " + zMakeFile);
        return zMakeFile;
    }

    public AiSpeakerData read() {
        Serializable atom;
        M4aInfo m4aInfo = this.mInfo;
        if (m4aInfo == null || !m4aInfo.hasAtom(M4aConsts.SPDT) || (atom = readAtom(this.mInfo.getAtomPosition(M4aConsts.SPDT))) == null) {
            return null;
        }
        if (!(atom instanceof String)) {
            Logger.m12702e(TAG, "Cannot read data");
            return null;
        }
        this.mJsonString = (String) atom;
        Gson gsonCreate = new GsonBuilder().create();
        Type type = new TypeToken<AiSpeakerData>() { // from class: com.samsung.android.support.senl.nt.stt.base.filedata.AISpeakerAtomHelper.1
        }.getType();
        try {
            String strDecrypt = SecureEncryption.decrypt(this.mJsonString);
            this.mJsonString = strDecrypt;
            if (strDecrypt != null) {
                return (AiSpeakerData) gsonCreate.fromJson(strDecrypt, type);
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
        return removeAtom(str, M4aConsts.SPDT, false);
    }
}
