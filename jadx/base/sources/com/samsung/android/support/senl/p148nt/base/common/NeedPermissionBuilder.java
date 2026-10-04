package com.samsung.android.support.senl.p148nt.base.common;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ \u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0005j\b\u0012\u0004\u0012\u00020\n`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/NeedPermissionBuilder;", "", "<init>", "()V", "mList", "Ljava/util/ArrayList;", "Lcom/samsung/android/support/senl/nt/base/common/NeedPermissionBuilder$permissionData;", "Lkotlin/collections/ArrayList;", "add", "normalPermission", "", "privilegedPermission", "build", "context", "Landroid/content/Context;", "permissionData", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NeedPermissionBuilder {

    @NotNull
    private final ArrayList<permissionData> mList = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/NeedPermissionBuilder$permissionData;", "", "normalPermission", "", "privilegedPermission", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNormalPermission", "()Ljava/lang/String;", "setNormalPermission", "(Ljava/lang/String;)V", "getPrivilegedPermission", "setPrivilegedPermission", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class permissionData {

        @NotNull
        private String normalPermission;

        @Nullable
        private String privilegedPermission;

        public permissionData(@NotNull String normalPermission, @Nullable String str) {
            Intrinsics.checkNotNullParameter(normalPermission, "normalPermission");
            this.normalPermission = normalPermission;
            this.privilegedPermission = str;
        }

        @NotNull
        public final String getNormalPermission() {
            return this.normalPermission;
        }

        @Nullable
        public final String getPrivilegedPermission() {
            return this.privilegedPermission;
        }

        public final void setNormalPermission(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.normalPermission = str;
        }

        public final void setPrivilegedPermission(@Nullable String str) {
            this.privilegedPermission = str;
        }
    }

    @NotNull
    public final NeedPermissionBuilder add(@NotNull String normalPermission, @Nullable String privilegedPermission) {
        Intrinsics.checkNotNullParameter(normalPermission, "normalPermission");
        this.mList.add(new permissionData(normalPermission, privilegedPermission));
        return this;
    }

    @NotNull
    public final ArrayList<String> build(@Nullable Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (context != null && !this.mList.isEmpty()) {
            Iterator<permissionData> it = this.mList.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                permissionData next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                permissionData permissiondata = next;
                if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, permissiondata.getNormalPermission())) {
                    if (!TextUtils.isEmpty(permissiondata.getPrivilegedPermission())) {
                        String privilegedPermission = permissiondata.getPrivilegedPermission();
                        Intrinsics.checkNotNull(privilegedPermission);
                        if (!PermissionHelper.isPermissionGrantedWithoutNotice(context, privilegedPermission)) {
                        }
                    }
                    arrayList.add(permissiondata.getNormalPermission());
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final NeedPermissionBuilder add(@NotNull String normalPermission) {
        Intrinsics.checkNotNullParameter(normalPermission, "normalPermission");
        this.mList.add(new permissionData(normalPermission, null));
        return this;
    }
}
