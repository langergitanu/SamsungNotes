package com.samsung.android.sdk.scs.p142ai.asr;

import android.os.Build;
import androidx.appcompat.widget.AbstractC0541b;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.scsp.framework.core.identity.IdentityApiContract;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class ASRLog extends Log {
    public static final boolean isDevelop = !IdentityApiContract.Token.USER.equals(Build.TYPE);

    private static String createMsg(Object[] objArr) {
        if (objArr == null) {
            return "null";
        }
        int length = objArr.length - 1;
        if (length == -1) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        int i = 0;
        if (length == 0) {
            return String.valueOf(objArr[0]);
        }
        StringBuilder sb = new StringBuilder("[");
        while (true) {
            sb.append(objArr[i]);
            if (i == length) {
                sb.append(PropertyUtils.INDEXED_DELIM2);
                return sb.toString();
            }
            sb.append(SQLKeyword.COMMA);
            i++;
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m6137d(String str, Object... objArr) {
        Log.m6485d(str, createMsg(objArr));
    }

    /* JADX INFO: renamed from: e */
    public static void m6138e(String str, Object... objArr) {
        Log.m6487e(str, createMsg(objArr));
    }

    /* JADX INFO: renamed from: i */
    public static void m6139i(String str, Object... objArr) {
        Log.m6489i(str, createMsg(objArr));
    }

    public static void secure(String str, Object... objArr) {
        if (isDevelop) {
            Log.m6485d(AbstractC0541b.m756B(str, "@Dbg"), createMsg(objArr));
        }
    }

    /* JADX INFO: renamed from: w */
    public static void m6140w(String str, Object... objArr) {
        Log.m6490w(str, createMsg(objArr));
    }
}
