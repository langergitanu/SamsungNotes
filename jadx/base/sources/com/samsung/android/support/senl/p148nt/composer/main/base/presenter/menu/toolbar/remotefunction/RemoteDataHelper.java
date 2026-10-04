package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.sdk.pen.SpenSettingRemoverInfo;
import com.samsung.android.sdk.pen.SpenSettingSelectionInfo;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingChangeStyleData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingLaserPenData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingRemoverInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.p154hw.setting.data.SettingSelectionInfoData;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class RemoteDataHelper {
    public static final String TAG = Logger.createTag("RemoteDataHelper");

    private Class<?> parseType(String str) {
        str.getClass();
        switch (str) {
            case "double":
                return Double.TYPE;
            case "int":
                return Integer.TYPE;
            case "byte":
                return Byte.TYPE;
            case "char":
                return Character.TYPE;
            case "long":
                return Long.TYPE;
            case "void":
                return Void.TYPE;
            case "boolean":
                return Boolean.TYPE;
            case "float":
                return Float.TYPE;
            case "short":
                return Short.TYPE;
            default:
                if (str.isEmpty()) {
                    return null;
                }
                if (str.contains(":")) {
                    str = str.split(":")[0];
                }
                return Class.forName(str);
        }
    }

    public String convertChangeStyleToString(SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
        return SettingChangeStyleData.convertToString(spenSettingUIChangeStyleInfo);
    }

    public String convertLaserPenInfoToString(SpenSettingUILaserPenInfo spenSettingUILaserPenInfo) {
        return SettingLaserPenData.convertToString(spenSettingUILaserPenInfo);
    }

    public Pair<String, String> convertListToString(List list) {
        JSONArray jSONArray = new JSONArray();
        String str = null;
        for (Object obj : list) {
            jSONArray.put(parseToString(obj).second);
            if (str == null) {
                str = (String) parseToString(obj).first;
            }
        }
        return new Pair<>(str, jSONArray.toString());
    }

    public String convertPenInfoToString(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(spenSettingUIPenInfo.color);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.isCurvable);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.name);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.size);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.sizeLevel);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.hsv[0]);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.hsv[1]);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.hsv[2]);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.colorUIInfo);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.isFixedWidth);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.isFixedOpacity);
        sb.append(":");
        sb.append(spenSettingUIPenInfo.isAutoSizeEnabled);
        sb.append(":");
        return AbstractC1038a.m1217r(sb, ":", spenSettingUIPenInfo.fitRatio);
    }

    public String convertRemoverInfoToString(SpenSettingRemoverInfo spenSettingRemoverInfo) {
        return SettingRemoverInfoData.convertToString(spenSettingRemoverInfo);
    }

    public String convertSelectionInfoToString(SpenSettingSelectionInfo spenSettingSelectionInfo) {
        return SettingSelectionInfoData.convertToString(spenSettingSelectionInfo);
    }

    public SpenSettingUIChangeStyleInfo convertStringToChangeStyleInfo(String str) {
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = new SpenSettingUIChangeStyleInfo();
        SettingChangeStyleData.convertToSpenSettingChangeStyleInfo(spenSettingUIChangeStyleInfo, str);
        return spenSettingUIChangeStyleInfo;
    }

    public SpenSettingUILaserPenInfo convertStringToLaserPenInfo(String str) {
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = new SpenSettingUILaserPenInfo();
        SettingLaserPenData.convertToSpenSettingLaserPenInfo(spenSettingUILaserPenInfo, str);
        return spenSettingUILaserPenInfo;
    }

    @Nullable
    public List<Object> convertStringToList(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str2);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(parseToObject(str, (String) jSONArray.get(i)));
            }
            return arrayList;
        } catch (ClassCastException | JSONException e) {
            AbstractC8014b.m7205g(e, new StringBuilder("convertStringToList"), TAG);
            return arrayList;
        }
    }

    public SpenSettingUIPenInfo convertStringToPenInfo(String str) {
        String[] strArrSplit = str.split(":");
        SpenSettingUIPenInfo spenSettingUIPenInfo = new SpenSettingUIPenInfo();
        spenSettingUIPenInfo.color = Integer.parseInt(strArrSplit[0]);
        spenSettingUIPenInfo.isCurvable = Boolean.parseBoolean(strArrSplit[1]);
        spenSettingUIPenInfo.name = strArrSplit[2];
        spenSettingUIPenInfo.size = Float.parseFloat(strArrSplit[3]);
        spenSettingUIPenInfo.sizeLevel = Integer.parseInt(strArrSplit[4]);
        spenSettingUIPenInfo.hsv[0] = Float.parseFloat(strArrSplit[5]);
        spenSettingUIPenInfo.hsv[1] = Float.parseFloat(strArrSplit[6]);
        spenSettingUIPenInfo.hsv[2] = Float.parseFloat(strArrSplit[7]);
        spenSettingUIPenInfo.colorUIInfo = Integer.parseInt(strArrSplit[8]);
        spenSettingUIPenInfo.isFixedWidth = Boolean.parseBoolean(strArrSplit[9]);
        spenSettingUIPenInfo.isFixedOpacity = Boolean.parseBoolean(strArrSplit[10]);
        spenSettingUIPenInfo.isAutoSizeEnabled = Boolean.parseBoolean(strArrSplit[11]);
        spenSettingUIPenInfo.fitRatio = Float.parseFloat(strArrSplit[12]);
        return spenSettingUIPenInfo;
    }

    @Nullable
    public <T> List<T> convertStringToPrimitiveTypeList(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.get(i));
            }
            return arrayList;
        } catch (ClassCastException | JSONException e) {
            AbstractC8014b.m7205g(e, new StringBuilder("convertStringToPrimitiveTypeList"), TAG);
            return arrayList;
        }
    }

    public SpenSettingRemoverInfo convertStringToRemoverInfo(String str) {
        SpenSettingRemoverInfo spenSettingRemoverInfo = new SpenSettingRemoverInfo();
        SettingRemoverInfoData.convertToSpenSettingRemoverInfo(spenSettingRemoverInfo, str);
        return spenSettingRemoverInfo;
    }

    public SpenSettingSelectionInfo convertStringToSelectionInfo(String str) {
        SpenSettingSelectionInfo spenSettingSelectionInfo = new SpenSettingSelectionInfo();
        SettingSelectionInfoData.convertToSpenSettingSelectionInfo(spenSettingSelectionInfo, str);
        return spenSettingSelectionInfo;
    }

    public String createJsonByMultiParam(String str, String str2, Object... objArr) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(RemoteConstant.KEY_CLASS, str);
        jSONObject.put(RemoteConstant.KEY_METHOD, str2);
        if (objArr != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : objArr) {
                Pair<String, String> toString = parseToString(obj);
                arrayList.add((String) toString.first);
                arrayList2.add((String) toString.second);
            }
            String str3 = (String) convertListToString(arrayList).second;
            String str4 = (String) convertListToString(arrayList2).second;
            jSONObject.put(RemoteConstant.KEY_PARAM_TYPE, str3);
            jSONObject.put(RemoteConstant.KEY_PARAM_VALUE, str4);
        }
        return jSONObject.toString();
    }

    public String createJsonBySingleParam(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key_action", str);
        Pair<String, String> toString = parseToString(obj);
        jSONObject.put("key_type", toString.first);
        jSONObject.put(RemoteConstant.KEY_MESSAGE, toString.second);
        return jSONObject.toString();
    }

    public String getJSONObject(String str, String str2) {
        return new JSONObject(str).optString(str2);
    }

    public String getKeyClass(String str) {
        return getJSONObject(str, RemoteConstant.KEY_CLASS);
    }

    public String getKeyMethod(String str) {
        return getJSONObject(str, RemoteConstant.KEY_METHOD);
    }

    public String getParamType(String str) {
        return getJSONObject(str, RemoteConstant.KEY_PARAM_TYPE);
    }

    public String getParamValue(String str) {
        return getJSONObject(str, RemoteConstant.KEY_PARAM_VALUE);
    }

    public Class<?>[] getParameterTypes(String str) {
        List listConvertStringToPrimitiveTypeList = convertStringToPrimitiveTypeList(getParamType(str));
        if (listConvertStringToPrimitiveTypeList == null || listConvertStringToPrimitiveTypeList.isEmpty()) {
            return new Class[0];
        }
        Class<?>[] clsArr = new Class[listConvertStringToPrimitiveTypeList.size()];
        for (int i = 0; i < listConvertStringToPrimitiveTypeList.size(); i++) {
            clsArr[i] = parseType((String) listConvertStringToPrimitiveTypeList.get(i));
        }
        return clsArr;
    }

    public Object[] getParameterValues(String str) {
        List listConvertStringToPrimitiveTypeList = convertStringToPrimitiveTypeList(getParamType(str));
        List listConvertStringToPrimitiveTypeList2 = convertStringToPrimitiveTypeList(getParamValue(str));
        if (listConvertStringToPrimitiveTypeList == null || listConvertStringToPrimitiveTypeList.isEmpty() || listConvertStringToPrimitiveTypeList2 == null) {
            return new Object[0];
        }
        int size = listConvertStringToPrimitiveTypeList.size();
        if (size != listConvertStringToPrimitiveTypeList2.size()) {
            StringBuilder sbM778t = AbstractC0541b.m778t(size, "size mismatched, param type : ", " param value : ");
            sbM778t.append(listConvertStringToPrimitiveTypeList2.size());
            throw new InvalidParameterException(sbM778t.toString());
        }
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = parseToObject((String) listConvertStringToPrimitiveTypeList.get(i), (String) listConvertStringToPrimitiveTypeList2.get(i));
        }
        return objArr;
    }

    public Class<?>[] getParseType(String str) {
        return new Class[]{parseType(str)};
    }

    public Object[] getParseValue(String str, String str2) {
        return new Object[]{parseToObject(str, str2)};
    }

    public Object parseToObject(String str, String str2) {
        if (str.startsWith(List.class.getName())) {
            return convertStringToList(str.replace(List.class.getName().concat(":"), ""), str2);
        }
        if (SpenSettingUIPenInfo.class.getName().equals(str)) {
            return convertStringToPenInfo(str2);
        }
        if (SpenSettingRemoverInfo.class.getName().equals(str)) {
            return convertStringToRemoverInfo(str2);
        }
        if (SpenSettingUILaserPenInfo.class.getName().equals(str)) {
            return convertStringToLaserPenInfo(str2);
        }
        if (SpenSettingSelectionInfo.class.getName().equals(str)) {
            return convertStringToSelectionInfo(str2);
        }
        if (SpenSettingUIChangeStyleInfo.class.getName().equals(str)) {
            return convertStringToChangeStyleInfo(str2);
        }
        if (RemoteQuickColorInfo.class.getName().equals(str)) {
            return new RemoteQuickColorInfo(str2);
        }
        if (Integer.TYPE.getName().equals(str)) {
            return Integer.valueOf(Integer.parseInt(str2));
        }
        if (Boolean.TYPE.getName().equals(str)) {
            return Boolean.valueOf(Boolean.parseBoolean(str2));
        }
        if (String.class.getName().equals(str)) {
            return str2;
        }
        return null;
    }

    public Pair<String, String> parseToString(Object obj) {
        String name;
        String string;
        if (obj instanceof List) {
            String name2 = List.class.getName();
            Pair<String, String> pairConvertListToString = convertListToString((List) obj);
            StringBuilder sbM781w = AbstractC0541b.m781w(name2, ":");
            sbM781w.append((String) pairConvertListToString.first);
            name = sbM781w.toString();
            string = (String) pairConvertListToString.second;
        } else if (obj instanceof SpenSettingUIPenInfo) {
            name = SpenSettingUIPenInfo.class.getName();
            string = convertPenInfoToString((SpenSettingUIPenInfo) obj);
        } else if (obj instanceof SpenSettingRemoverInfo) {
            name = SpenSettingRemoverInfo.class.getName();
            string = convertRemoverInfoToString((SpenSettingRemoverInfo) obj);
        } else if (obj instanceof SpenSettingUILaserPenInfo) {
            name = SpenSettingUILaserPenInfo.class.getName();
            string = convertLaserPenInfoToString((SpenSettingUILaserPenInfo) obj);
        } else if (obj instanceof SpenSettingSelectionInfo) {
            name = SpenSettingSelectionInfo.class.getName();
            string = convertSelectionInfoToString((SpenSettingSelectionInfo) obj);
        } else if (obj instanceof SpenSettingUIChangeStyleInfo) {
            name = SpenSettingUIChangeStyleInfo.class.getName();
            string = convertChangeStyleToString((SpenSettingUIChangeStyleInfo) obj);
        } else if (obj instanceof RemoteQuickColorInfo) {
            name = RemoteQuickColorInfo.class.getName();
            string = ((RemoteQuickColorInfo) obj).getString();
        } else if (obj instanceof Integer) {
            name = Integer.TYPE.getName();
            string = ((Integer) obj).toString();
        } else if (obj instanceof Boolean) {
            name = Boolean.TYPE.getName();
            string = ((Boolean) obj).toString();
        } else if (obj instanceof String) {
            name = String.class.getName();
            string = (String) obj;
        } else {
            name = "";
            string = "";
        }
        return new Pair<>(name, string);
    }
}
