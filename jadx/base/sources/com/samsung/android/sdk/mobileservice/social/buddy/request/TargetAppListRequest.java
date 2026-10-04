package com.samsung.android.sdk.mobileservice.social.buddy.request;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class TargetAppListRequest {
    private ArrayList<TargetApp> mAppUpdateRequestList;
    private String mGuid;
    private String mMsisdn;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface BundleKey {
        public static final String APPS = "apps";
        public static final String APP_ID = "app_id";
        public static final String APP_NAME = "app_name";
        public static final String FEATURES = "features";
        public static final String GUID = "guid";
        public static final String MSISDN = "msisdn";
        public static final String PACKAGE_NAME = "package_name";
    }

    public TargetAppListRequest(String str, List<TargetApp> list) {
        this.mGuid = str;
        this.mAppUpdateRequestList = new ArrayList<>(list);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<TargetApp> it = this.mAppUpdateRequestList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        bundle.putParcelableArrayList(BundleKey.APPS, arrayList);
        bundle.putString("guid", this.mGuid);
        if (!TextUtils.isEmpty(this.mMsisdn)) {
            bundle.putString("msisdn", this.mMsisdn);
        }
        return bundle;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TargetApp {
        private String mAppId;
        private String mAppName;
        private List<Integer> mFeatureList;
        private String mPackageName;

        public TargetApp(String str, String str2) {
            this.mAppId = str;
            this.mAppName = str2;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", this.mAppId);
            bundle.putString("app_name", this.mAppName);
            String str = this.mPackageName;
            if (str != null) {
                bundle.putString(BundleKey.PACKAGE_NAME, str);
            }
            if (this.mFeatureList != null) {
                bundle.putIntegerArrayList("features", new ArrayList<>(this.mFeatureList));
            }
            return bundle;
        }

        public TargetApp(String str, String str2, String str3) {
            this.mAppId = str;
            this.mAppName = str2;
            this.mPackageName = str3;
        }

        public TargetApp(String str, String str2, String str3, List<Integer> list) {
            this.mAppId = str;
            this.mAppName = str2;
            this.mPackageName = str3;
            this.mFeatureList = new ArrayList(list);
        }
    }

    public TargetAppListRequest(String str, String str2, List<TargetApp> list) {
        this.mMsisdn = str;
        this.mGuid = str2;
        this.mAppUpdateRequestList = new ArrayList<>(list);
    }
}
