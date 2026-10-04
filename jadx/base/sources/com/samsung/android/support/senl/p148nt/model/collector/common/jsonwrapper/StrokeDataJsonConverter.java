package com.samsung.android.support.senl.p148nt.model.collector.common.jsonwrapper;

import android.graphics.Rect;
import com.samsung.android.sdk.composer.document.sdoc.SpenContentHandWriting;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.CollectLogger;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class StrokeDataJsonConverter {
    private static final String NAME_FIRST_CHAR_RECT_BOTTOM = "firstCharRectBottom";
    private static final String NAME_FIRST_CHAR_RECT_LEFT = "firstCharRectLeft";
    private static final String NAME_FIRST_CHAR_RECT_RIGHT = "firstCharRectRight";
    private static final String NAME_FIRST_CHAR_RECT_TOP = "firstCharRectTop";
    private static final String NAME_HANDLE_LIST = "handleList";
    private static final String NAME_LAST_CHAR_RECT_BOTTOM = "lastCharRectBottom";
    private static final String NAME_LAST_CHAR_RECT_LEFT = "lastCharRectLeft";
    private static final String NAME_LAST_CHAR_RECT_RIGHT = "lastCharRectRight";
    private static final String NAME_LAST_CHAR_RECT_TOP = "lastCharRectTop";
    private static final String NAME_LINK_STR = "linkStr";
    private static final String NAME_LINK_TYPE = "linkType";
    private static final String NAME_PAGE_WIDTH = "pageWidth";
    private static final String NAME_REP_OBJECT_UUID = "repObjectUuid";
    private static final String NAME_STROKE_RECT_BOTTOM = "strokeRectBottom";
    private static final String NAME_STROKE_RECT_LEFT = "strokeRectLeft";
    private static final String NAME_STROKE_RECT_RIGHT = "strokeRectRight";
    private static final String NAME_STROKE_RECT_TOP = "strokeRectTop";
    private static final String TAG = CollectLogger.createTag("StrokeDataJsonConverter");

    public static SpenWPage.ActionLinkData getActionLinkDataFromJsonStr(String str) {
        SpenWPage.ActionLinkData actionLinkData = new SpenWPage.ActionLinkData();
        try {
            JSONObject jSONObjectCreateJsonObject = JsonFactory.createJsonObject(str);
            actionLinkData.linkType = jSONObjectCreateJsonObject.getInt(NAME_LINK_TYPE);
            actionLinkData.linkStr = jSONObjectCreateJsonObject.getString(NAME_LINK_STR);
            actionLinkData.pageWidth = jSONObjectCreateJsonObject.getInt("pageWidth");
            Rect rect = new Rect();
            actionLinkData.strokeRect = rect;
            rect.set(getStrokeRect(jSONObjectCreateJsonObject));
            Rect rect2 = new Rect();
            actionLinkData.firstCharRect = rect2;
            rect2.set(getFirstCharRect(jSONObjectCreateJsonObject));
            Rect rect3 = new Rect();
            actionLinkData.lastCharRect = rect3;
            rect3.set(getLastCharRect(jSONObjectCreateJsonObject));
            ArrayList<Integer> arrayList = new ArrayList<>();
            actionLinkData.handleList = arrayList;
            arrayList.addAll(getHandleList(jSONObjectCreateJsonObject));
            return actionLinkData;
        } catch (JSONException e) {
            DataLogger.m12303e(TAG, "getSdocLinkDataFromJsonStr : " + e.getMessage());
            return actionLinkData;
        }
    }

    private static Rect getFirstCharRect(JSONObject jSONObject) {
        return new Rect(jSONObject.getInt(NAME_FIRST_CHAR_RECT_LEFT), jSONObject.getInt(NAME_FIRST_CHAR_RECT_TOP), jSONObject.getInt(NAME_FIRST_CHAR_RECT_RIGHT), jSONObject.getInt(NAME_FIRST_CHAR_RECT_BOTTOM));
    }

    private static ArrayList<Integer> getHandleList(JSONObject jSONObject) throws JSONException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        JSONArray jSONArray = jSONObject.getJSONArray(NAME_HANDLE_LIST);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
        }
        return arrayList;
    }

    public static String getJsonStrFromActionLinkData(SpenWPage.ActionLinkData actionLinkData) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NAME_LINK_TYPE, actionLinkData.linkType);
            jSONObject.put(NAME_LINK_STR, actionLinkData.linkStr);
            jSONObject.put("pageWidth", actionLinkData.pageWidth);
            jSONObject.put(NAME_REP_OBJECT_UUID, actionLinkData.repObjectUuid);
            jSONObject.put(NAME_STROKE_RECT_LEFT, actionLinkData.strokeRect.left);
            jSONObject.put(NAME_STROKE_RECT_RIGHT, actionLinkData.strokeRect.right);
            jSONObject.put(NAME_STROKE_RECT_TOP, actionLinkData.strokeRect.top);
            jSONObject.put(NAME_STROKE_RECT_BOTTOM, actionLinkData.strokeRect.bottom);
            jSONObject.put(NAME_FIRST_CHAR_RECT_LEFT, actionLinkData.firstCharRect.left);
            jSONObject.put(NAME_FIRST_CHAR_RECT_RIGHT, actionLinkData.firstCharRect.right);
            jSONObject.put(NAME_FIRST_CHAR_RECT_TOP, actionLinkData.firstCharRect.top);
            jSONObject.put(NAME_FIRST_CHAR_RECT_BOTTOM, actionLinkData.firstCharRect.bottom);
            jSONObject.put(NAME_LAST_CHAR_RECT_LEFT, actionLinkData.lastCharRect.left);
            jSONObject.put(NAME_LAST_CHAR_RECT_RIGHT, actionLinkData.lastCharRect.right);
            jSONObject.put(NAME_LAST_CHAR_RECT_TOP, actionLinkData.lastCharRect.top);
            jSONObject.put(NAME_LAST_CHAR_RECT_BOTTOM, actionLinkData.lastCharRect.bottom);
            JSONArray jSONArray = new JSONArray();
            if (actionLinkData.handleList == null) {
                actionLinkData.handleList = new ArrayList<>();
            }
            Iterator<Integer> it = actionLinkData.handleList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            jSONObject.put(NAME_HANDLE_LIST, jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            DataLogger.m12303e(TAG, "getJson, exception: " + e.getMessage());
            return null;
        }
    }

    private static Rect getLastCharRect(JSONObject jSONObject) {
        return new Rect(jSONObject.getInt(NAME_LAST_CHAR_RECT_LEFT), jSONObject.getInt(NAME_LAST_CHAR_RECT_TOP), jSONObject.getInt(NAME_LAST_CHAR_RECT_RIGHT), jSONObject.getInt(NAME_LAST_CHAR_RECT_BOTTOM));
    }

    private static Rect getStrokeRect(JSONObject jSONObject) {
        return new Rect(jSONObject.getInt(NAME_STROKE_RECT_LEFT), jSONObject.getInt(NAME_STROKE_RECT_TOP), jSONObject.getInt(NAME_STROKE_RECT_RIGHT), jSONObject.getInt(NAME_STROKE_RECT_BOTTOM));
    }

    public static SpenContentHandWriting.ActionLinkData getActionLinkDataFromJsonStr(String str, int i) {
        SpenContentHandWriting.ActionLinkData actionLinkData = new SpenContentHandWriting.ActionLinkData();
        try {
            JSONObject jSONObjectCreateJsonObject = JsonFactory.createJsonObject(str);
            actionLinkData.linkStr = jSONObjectCreateJsonObject.getString(NAME_LINK_STR);
            actionLinkData.linkType = jSONObjectCreateJsonObject.getInt(NAME_LINK_TYPE);
            actionLinkData.pageWidth = i;
            Rect rect = new Rect();
            actionLinkData.strokeRect = rect;
            rect.set(getStrokeRect(jSONObjectCreateJsonObject));
            Rect rect2 = new Rect();
            actionLinkData.firstCharRect = rect2;
            rect2.set(getFirstCharRect(jSONObjectCreateJsonObject));
            Rect rect3 = new Rect();
            actionLinkData.lastCharRect = rect3;
            rect3.set(getLastCharRect(jSONObjectCreateJsonObject));
            ArrayList<Integer> arrayList = new ArrayList<>();
            actionLinkData.handleList = arrayList;
            arrayList.addAll(getHandleList(jSONObjectCreateJsonObject));
            return actionLinkData;
        } catch (JSONException e) {
            DataLogger.m12303e(TAG, "getSdocLinkDataFromJsonStr : " + e.getMessage());
            return actionLinkData;
        }
    }
}
