package io.opentelemetry.context;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import javax.annotation.Nullable;
import opennlp.tools.parser.Parse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class ArrayBasedContext implements Context {
    private static final Context ROOT = new ArrayBasedContext(new Object[0]);
    private final Object[] entries;

    private ArrayBasedContext(Object[] objArr) {
        this.entries = objArr;
    }

    public static Context root() {
        return ROOT;
    }

    @Override // io.opentelemetry.context.Context
    @Nullable
    public <V> V get(ContextKey<V> contextKey) {
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                return null;
            }
            if (objArr[i] == contextKey) {
                return (V) objArr[i + 1];
            }
            i += 2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Parse.BRACKET_LCB);
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                break;
            }
            sb.append(objArr[i]);
            sb.append('=');
            sb.append(this.entries[i + 1]);
            sb.append(SQLKeyword.COMMA);
            i += 2;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // io.opentelemetry.context.Context
    public <V> Context with(ContextKey<V> contextKey, V v) {
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 2);
                objArrCopyOf[objArrCopyOf.length - 2] = contextKey;
                objArrCopyOf[objArrCopyOf.length - 1] = v;
                return new ArrayBasedContext(objArrCopyOf);
            }
            if (objArr[i] == contextKey) {
                int i2 = i + 1;
                if (objArr[i2] == v) {
                    return this;
                }
                Object[] objArr2 = (Object[]) objArr.clone();
                objArr2[i2] = v;
                return new ArrayBasedContext(objArr2);
            }
            i += 2;
        }
    }
}
