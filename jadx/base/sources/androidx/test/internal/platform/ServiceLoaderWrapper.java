package androidx.test.internal.platform;

import android.os.StrictMode;
import androidx.annotation.RestrictTo;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ServiceLoaderWrapper {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Factory<T> {
        T create();
    }

    private ServiceLoaderWrapper() {
    }

    public static <T> List<T> loadService(Class<T> cls) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        ArrayList arrayList = new ArrayList();
        Iterator it = ServiceLoader.load(cls).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
        return arrayList;
    }

    public static <T> T loadSingleService(Class<T> cls, Factory<T> factory) {
        T t = (T) loadSingleServiceOrNull(cls);
        return t == null ? factory.create() : t;
    }

    public static <T> T loadSingleServiceOrNull(Class<T> cls) {
        List listLoadService = loadService(cls);
        String string = null;
        if (listLoadService.isEmpty()) {
            return null;
        }
        if (listLoadService.size() == 1) {
            return (T) listLoadService.get(0);
        }
        for (Object obj : listLoadService) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string != null ? string.concat(SQLKeyword.COMMA) : ": ");
            sbM1324q.append(obj.getClass().getName());
            string = sbM1324q.toString();
        }
        throw new IllegalStateException(AbstractC2322a.m1618h(cls, new StringBuilder("Found more than one implementation for "), string));
    }
}
