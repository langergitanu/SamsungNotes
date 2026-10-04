package p079T;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import com.samsung.android.sdk.mobileservice.social.social.GroupDetailRequest;
import com.samsung.android.sdk.mobileservice.social.social.OpenSessionApi;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.sync.p150ui.notification.CoeditNotificationConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.stt.common.constant.DialogConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: renamed from: T.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0294l {

    /* JADX INFO: renamed from: a */
    public static final ExecutorService f760a = AbstractC4539a.m3201k("SesGroupUtil");

    /* JADX INFO: renamed from: a */
    public static Intent m574a(String str, String str2, boolean z) {
        if (!z) {
            if (TextUtils.isEmpty(str2)) {
                str2 = BaseUtils.getApplicationContext().getString(C7943R.string.base_coedit_name);
            }
            return new OpenSessionApi().getIntentForGroupDetail(BaseUtils.getApplicationContext(), new GroupDetailRequest.Builder(CommonUtils.getNewNotesServiceId(), str, 501).setMaxGroupMemberCount(10).setSpaceName(str2).setInvitable(true).build()).setPackage("com.samsung.android.mobileservice");
        }
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.mobileservice.action.ACTION_GROUP_DELEGATE_OWNER");
        intent.putExtra("app_id", CommonUtils.getNewNotesServiceId());
        intent.putExtra("group_id", str);
        intent.putExtra("feature_id", String.valueOf(501));
        intent.putExtra("owner_leave", false);
        intent.setPackage("com.samsung.android.mobileservice");
        return intent;
    }

    /* JADX INFO: renamed from: b */
    public static Intent m575b(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("com.samsung.android.mobileservice.action.ACTION_EXTERNAL_GROUP_DETAIL");
        intent.putExtra("app_id", CommonUtils.getOldNotesServiceId());
        intent.putExtra("group_id", str);
        intent.putExtra("feature_id", 104);
        intent.putExtra("support_local_group_owner_delegation", false);
        intent.setPackage("com.samsung.android.mobileservice");
        intent.setFlags(603979776);
        if (str2 != null) {
            intent.putExtra(CoeditNotificationConstants.EXTRA_SPACE_NAME, str2);
        }
        return intent;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m576c(PackageManager packageManager) {
        PackageInfo packageInfo;
        try {
            packageInfo = packageManager.getPackageInfo("com.samsung.android.mobileservice", 1);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null || !packageInfo.applicationInfo.enabled) {
            Debugger.m8609e("SesGroupUtil", "isMobileServiceSupportGroupMemberUpdateByGroupSync# info is null or applicationInfo is not enabled");
            return false;
        }
        if (1300017000 < packageInfo.versionCode) {
            return true;
        }
        Debugger.m8609e("SesGroupUtil", "isMobileServiceSupportGroupMemberUpdateByGroupSync# minSupportedVersionCode - " + packageInfo.versionCode);
        return false;
    }

    /* JADX INFO: renamed from: d */
    public static HashMap m577d(String str) {
        HashMap map = new HashMap();
        try {
            JSONArray jSONArray = (JSONArray) new JSONTokener(str).nextValue();
            String string = jSONArray.getJSONObject(0).getString("type");
            map.put("type", string);
            if ("group".equalsIgnoreCase(string)) {
                map.put("groupId", jSONArray.getJSONObject(0).getString("value"));
                return map;
            }
            if (!"guid".equalsIgnoreCase(string) && !"account".equalsIgnoreCase(string) && !TextConst.KEY_PARAM_NUMBER.equalsIgnoreCase(string)) {
                Debugger.m8607d("SesGroupUtil", "Unknown type " + string);
                return null;
            }
            map.putAll(m578e(jSONArray));
            return map;
        } catch (JSONException e) {
            Debugger.m8609e("SesGroupUtil", "JSONException. " + e.getMessage());
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public static HashMap m578e(JSONArray jSONArray) throws JSONException {
        HashMap map = new HashMap();
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            arrayList.add(jSONObject.getString("value"));
            if (jSONObject.has("msisdn")) {
                arrayList2.add(jSONObject.getString("msisdn"));
            }
        }
        map.put(DialogConstant.BUNDLE_IDS, arrayList);
        map.put("optIds", arrayList2);
        return map;
    }
}
