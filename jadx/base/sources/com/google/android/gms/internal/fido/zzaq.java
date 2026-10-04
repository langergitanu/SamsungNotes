package com.google.android.gms.internal.fido;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaq {
    public static String zza(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String strM775q;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                strM775q = "null";
            } else {
                try {
                    strM775q = obj.toString();
                } catch (Exception e) {
                    String strM757C = AbstractC0541b.m757C(obj.getClass().getName(), Log.TAG_SEPARATOR, Integer.toHexString(System.identityHashCode(obj)));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(strM757C), (Throwable) e);
                    strM775q = AbstractC0541b.m775q("<", strM757C, " threw ", e.getClass().getName(), ">");
                }
            }
            objArr[i2] = strM775q;
            i2++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i4 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (iIndexOf = str.indexOf("%s", i4)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i4, iIndexOf);
            sb.append(objArr[i]);
            i++;
            i4 = iIndexOf + 2;
        }
        sb.append((CharSequence) str, i4, str.length());
        if (i < length2) {
            sb.append(" [");
            sb.append(objArr[i]);
            for (int i5 = i + 1; i5 < objArr.length; i5++) {
                sb.append(SQLKeyword.COMMA);
                sb.append(objArr[i5]);
            }
            sb.append(PropertyUtils.INDEXED_DELIM2);
        }
        return sb.toString();
    }
}
