package com.samsung.android.support.senl.p148nt.app.main.common.handoff;

import android.text.TextUtils;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.remotefunction.RemoteConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager;", "", "<init>", "()V", "revisionOperation", "", "metaData", "Lorg/json/JSONObject;", "getVersionState", "", "revisionOperationForTagListRemovedVersion", "", "isRevisionOperationForTagListRemovedNeed", "getVersionNum", "versionCode", "", "VersionState", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nMainHandoffVersionManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainHandoffVersionManager.kt\ncom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,140:1\n739#2,9:141\n37#3:150\n36#3,3:151\n*S KotlinDebug\n*F\n+ 1 MainHandoffVersionManager.kt\ncom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager\n*L\n110#1:141,9\n110#1:150\n110#1:151,3\n*E\n"})
public final class MainHandoffVersionManager {

    @NotNull
    private static final String TAG = "MainHandoffVersionManager";
    private static final int VERSION_0_1_0 = 10000;
    private static final int VERSION_INVALID = -1;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager$VersionState;", "", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface VersionState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int DROP = 0;
        public static final int REVISION = 2;
        public static final int SAME = 1;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/handoff/MainHandoffVersionManager$VersionState$Companion;", "", "<init>", "()V", "DROP", "", "SAME", "REVISION", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int DROP = 0;
            public static final int REVISION = 2;
            public static final int SAME = 1;

            private Companion() {
            }
        }
    }

    private final int getVersionNum(String versionCode) {
        List listEmptyList;
        if (TextUtils.isEmpty(versionCode)) {
            return -1;
        }
        List listM13999t = AbstractC12991c.m13999t(0, RemoteConstant.VERSION_DIVIDE, versionCode);
        if (listM13999t.isEmpty()) {
            listEmptyList = CollectionsKt.emptyList();
        } else {
            ListIterator listIterator = listM13999t.listIterator(listM13999t.size());
            while (listIterator.hasPrevious()) {
                if (((String) listIterator.previous()).length() != 0) {
                    listEmptyList = AbstractC12991c.m14000u(listIterator, 1, listM13999t);
                    break;
                }
            }
            listEmptyList = CollectionsKt.emptyList();
        }
        String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
        if (strArr.length != 3) {
            return -1;
        }
        int i = 0;
        for (String str : strArr) {
            i = (Integer.parseInt(str) + i) * 100;
        }
        return i;
    }

    @VersionState
    private final int getVersionState(JSONObject metaData) {
        if (metaData == null) {
            return 0;
        }
        try {
            return Intrinsics.areEqual("1.0.0", metaData.getString("version")) ? 1 : 2;
        } catch (JSONException e) {
            AbstractC6670b.m4738C("getVersionState, JSONException, ", e.getMessage(), TAG);
            return 2;
        }
    }

    private final boolean isRevisionOperationForTagListRemovedNeed(JSONObject metaData) {
        if (metaData == null) {
            return false;
        }
        try {
            String string = metaData.getString("version");
            Intrinsics.checkNotNull(string);
            int versionNum = getVersionNum(string);
            int versionNum2 = getVersionNum("1.0.0");
            return versionNum != -1 && versionNum2 != -1 && versionNum + 1 <= 10000 && 10000 <= versionNum2;
        } catch (JSONException e) {
            AbstractC6670b.m4738C("isRevisionOperationForTagListRemovedNeed# JSONException: ", e.getMessage(), TAG);
            return false;
        }
    }

    private final void revisionOperationForTagListRemovedVersion(JSONObject metaData) {
        if (isRevisionOperationForTagListRemovedNeed(metaData)) {
            try {
                String string = metaData.getString("action");
                if (Intrinsics.areEqual(string, "tag_list")) {
                    metaData.put(HandoffConstant.KEY_ACTIVITY_TYPE, "Main");
                    metaData.put("action", "tag_note");
                    metaData.put("tags", new JSONArray());
                    return;
                }
                if (!Intrinsics.areEqual(string, "tag_note")) {
                    MainLogger.m7254d(TAG, "revisionOperationForTagListRemovedVersion# do not need to run revisionOperation on actionType: " + string);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                String string2 = metaData.getString("tag");
                if (!TextUtils.isEmpty(string2)) {
                    Intrinsics.checkNotNull(string2);
                    Locale locale = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                    String lowerCase = string2.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    jSONArray.put(lowerCase);
                }
                metaData.put("tags", jSONArray);
            } catch (JSONException e) {
                AbstractC6670b.m4738C("revisionOperationForTagListRemovedVersion# ", e.getMessage(), TAG);
            }
        }
    }

    public final boolean revisionOperation(@NotNull JSONObject metaData) {
        Intrinsics.checkNotNullParameter(metaData, "metaData");
        int versionState = getVersionState(metaData);
        if (versionState == 0) {
            return false;
        }
        if (1 == versionState) {
            return true;
        }
        revisionOperationForTagListRemovedVersion(metaData);
        return true;
    }
}
