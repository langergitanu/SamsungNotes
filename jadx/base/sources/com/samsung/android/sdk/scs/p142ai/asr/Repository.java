package com.samsung.android.sdk.scs.p142ai.asr;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerFeature;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.ServerType;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Optional;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
interface Repository {
    public static final Repository settings = new SharedPrefRepository();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SharedPrefRepository implements Repository {
        private static final String KEY_SERVER_TYPE = "server_type";
        private static final String POSTFIX_IS_DEFAULT = "_is_default";
        private static final int VERSION = 1;
        private final String TAG;
        private final String prefName;
        private final SharedPreferences sharedPrefSupplier;

        public /* synthetic */ SharedPrefRepository() {
            this("scs_asr_settings");
        }

        private String getKey(String str, ServerFeature serverFeature) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
            sbM1324q.append(serverFeature.ordinal());
            return sbM1324q.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ServerType lambda$getServerType$1(ServerFeature serverFeature, SharedPreferences sharedPreferences, String str, String str2) {
            return new ServerType(serverFeature, str2, sharedPreferences.getBoolean(str + POSTFIX_IS_DEFAULT, false));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ServerType lambda$getServerType$2(String str, ServerFeature serverFeature, SharedPreferences sharedPreferences) {
            return (ServerType) Optional.ofNullable(sharedPreferences.getString(str, null)).map(new C7693i(serverFeature, sharedPreferences, str, 0)).orElse(null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ SharedPreferences.Editor lambda$setServerType$0(ServerType serverType, String str, SharedPreferences.Editor editor) {
            if (serverType == null) {
                editor.remove(str);
                editor.remove(str + POSTFIX_IS_DEFAULT);
                return editor;
            }
            editor.putString(str, serverType.getName());
            editor.putBoolean(str + POSTFIX_IS_DEFAULT, serverType.isDefault());
            return editor;
        }

        @Override // com.samsung.android.sdk.scs.p142ai.asr.Repository
        public ServerType getServerType(ServerFeature serverFeature) {
            return (ServerType) Optional.ofNullable(this.sharedPrefSupplier).map(new C7694j(getKey("server_type", serverFeature), serverFeature)).orElse(null);
        }

        @Override // com.samsung.android.sdk.scs.p142ai.asr.Repository
        public boolean setServerType(ServerFeature serverFeature, ServerType serverType) {
            try {
                Log.m6489i(this.TAG, "setServerType " + serverFeature + SQLKeyword.COMMA + serverType);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (serverFeature == null) {
                return false;
            }
            try {
                return ((Boolean) Optional.ofNullable(this.sharedPrefSupplier).map(new C7691g(3)).map(new C7694j(serverType, getKey("server_type", serverFeature))).map(new C7691g(4)).orElse(Boolean.FALSE)).booleanValue();
            } catch (Exception e2) {
                Log.m6490w(this.TAG, "Failed to set server type " + e2.getMessage());
                return false;
            }
        }

        private SharedPrefRepository(String str) {
            String strM756B = AbstractC0541b.m756B(str, "_1");
            this.prefName = strM756B;
            String strM772n = AbstractC0541b.m772n("SharedPrefRepository@", str);
            this.TAG = strM772n;
            this.sharedPrefSupplier = Environment.getContext().getSharedPreferences(str, 0);
            Log.m6489i(strM772n, "created  " + strM756B);
        }
    }

    @Nullable
    ServerType getServerType(ServerFeature serverFeature);

    boolean setServerType(ServerFeature serverFeature, ServerType serverType);
}
