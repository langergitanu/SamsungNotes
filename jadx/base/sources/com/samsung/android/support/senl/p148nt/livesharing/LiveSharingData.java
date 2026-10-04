package com.samsung.android.support.senl.p148nt.livesharing;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.meet.addons.CoDoingState;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public class LiveSharingData {
    public static final int INVALID_VERSION = -1;
    private static final String KEY_HOST_NAME = "host_name";
    private static final String KEY_NOTE_LINK = "note_link";
    private static final String KEY_VERSION = "LSKeyVer";
    private static final String TAG = "LS$LiveSharingData";
    public static final int VERSION = 1;
    private JSONObject mJSONObject;

    public LiveSharingData() {
        JSONObject jSONObject = new JSONObject();
        this.mJSONObject = jSONObject;
        try {
            jSONObject.put(KEY_VERSION, 1);
        } catch (JSONException e) {
            Log.e(TAG, "fail to put version: " + e.getMessage());
        }
    }

    public void combine(LiveSharingData liveSharingData) {
        JSONObject jSONObject = liveSharingData.getJSONObject();
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (this.mJSONObject.has(next)) {
                    Object obj = this.mJSONObject.get(next);
                    Object obj2 = jSONObject.get(next);
                    if (!obj.equals(obj2)) {
                        Log.i(TAG, "combine# conflict " + obj + " " + obj2);
                    }
                } else {
                    this.mJSONObject.put(next, jSONObject.get(next));
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "combine# " + e.getMessage(), e);
        }
    }

    public byte[] convertBytes() {
        return this.mJSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    public CoDoingState getCoDoingState() {
        return CoDoingState.builder().setState(this.mJSONObject.toString().getBytes(StandardCharsets.UTF_8)).build();
    }

    public String getHostName() {
        try {
            return this.mJSONObject.getString(KEY_HOST_NAME);
        } catch (JSONException e) {
            Log.e(TAG, "getNoteLink: " + e.getMessage());
            return "";
        }
    }

    public JSONObject getJSONObject() {
        return this.mJSONObject;
    }

    public String getNoteLink() {
        try {
            return this.mJSONObject.getString(KEY_NOTE_LINK);
        } catch (JSONException e) {
            Log.e(TAG, "getNoteLink: " + e.getMessage());
            return "";
        }
    }

    public int getVersion() {
        try {
            return this.mJSONObject.getInt(KEY_VERSION);
        } catch (JSONException e) {
            Log.e(TAG, "getVersion# " + e.getMessage());
            return -1;
        }
    }

    public boolean isValidSize() {
        return convertBytes().length < 1024;
    }

    public void setHostName(String str) {
        try {
            this.mJSONObject.put(KEY_HOST_NAME, str);
        } catch (JSONException e) {
            Log.e(TAG, "setNoteLink: " + e.getMessage());
        }
    }

    public void setNoteLink(String str) {
        try {
            this.mJSONObject.put(KEY_NOTE_LINK, str);
        } catch (JSONException e) {
            Log.e(TAG, "setNoteLink: " + e.getMessage());
        }
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = this.mJSONObject;
        return jSONObject == null ? "null" : jSONObject.toString();
    }

    public LiveSharingData(CoDoingState coDoingState) {
        this(coDoingState.state());
    }

    public LiveSharingData(byte[] bArr) {
        try {
            this.mJSONObject = new JSONObject(new String(bArr));
        } catch (JSONException e) {
            Log.e(TAG, "create error# " + e.getMessage());
            this.mJSONObject = new JSONObject();
        }
    }
}
