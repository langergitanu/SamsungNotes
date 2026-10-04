package androidx.test.core.content.p114pm;

import android.annotation.TargetApi;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.test.internal.util.Checks;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class PackageInfoBuilder {

    @Nullable
    private ApplicationInfo applicationInfo;

    @Nullable
    private String packageName;

    @Nullable
    private String versionName;
    private long longVersionCode = 0;
    private final Map<String, Integer> requestedPermissionsMap = new HashMap();

    private PackageInfoBuilder() {
    }

    public static PackageInfoBuilder newBuilder() {
        return new PackageInfoBuilder();
    }

    public PackageInfoBuilder addRequestedPermission(String str, int i) {
        this.requestedPermissionsMap.put(str, Integer.valueOf(i));
        return this;
    }

    public PackageInfo build() {
        Checks.checkNotNull(this.packageName, "Mandatory field 'packageName' missing.");
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.packageName = this.packageName;
        packageInfo.versionName = this.versionName;
        if (Build.VERSION.SDK_INT >= 28) {
            packageInfo.setLongVersionCode(this.longVersionCode);
        } else {
            packageInfo.versionCode = (int) this.longVersionCode;
        }
        if (this.applicationInfo == null) {
            this.applicationInfo = ApplicationInfoBuilder.newBuilder().setPackageName(this.packageName).build();
        }
        packageInfo.applicationInfo = this.applicationInfo;
        packageInfo.requestedPermissions = (String[]) this.requestedPermissionsMap.keySet().toArray(new String[0]);
        Integer[] numArr = (Integer[]) this.requestedPermissionsMap.values().toArray(new Integer[0]);
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        packageInfo.requestedPermissionsFlags = iArr;
        Checks.checkState(packageInfo.packageName.equals(packageInfo.applicationInfo.packageName), "Field 'packageName' must match field 'applicationInfo.packageName'");
        return packageInfo;
    }

    public PackageInfoBuilder setApplicationInfo(ApplicationInfo applicationInfo) {
        this.applicationInfo = applicationInfo;
        return this;
    }

    public PackageInfoBuilder setPackageName(String str) {
        this.packageName = str;
        return this;
    }

    @TargetApi(28)
    public PackageInfoBuilder setVersionCode(long j) {
        this.longVersionCode = j;
        return this;
    }

    public PackageInfoBuilder setVersionName(String str) {
        this.versionName = str;
        return this;
    }
}
