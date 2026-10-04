package p178f0;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import io.netty.handler.codec.http.multipart.DiskFileUpload;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p079T.AbstractC0299q;
import p182g0.C11991a;
import p185h0.InterfaceC12017b;

/* JADX INFO: renamed from: f0.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11979b implements InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public String f8573a;

    /* JADX INFO: renamed from: b */
    public String f8574b;

    /* JADX INFO: renamed from: c */
    public HashMap f8575c;

    /* JADX INFO: renamed from: d */
    public HashMap f8576d;

    /* JADX INFO: renamed from: e */
    public ArrayList f8577e;

    /* JADX INFO: renamed from: f */
    public ArrayList f8578f;

    /* JADX INFO: renamed from: a */
    public final void m13555a(C11991a c11991a) {
        C11978a c11978a = new C11978a();
        c11978a.f8571c = c11991a.f8618k;
        c11978a.f8569a = c11991a.f8608a;
        c11978a.f8570b = c11991a.f8613f;
        c11978a.f8572d = c11991a.f8616i;
        LoggerBase.m7130i("WCon_ContentFileManager", "addContentFile - add hash[" + c11978a.f8571c + ", id[" + c11978a.f8569a + "], name[" + LoggerBase.getEncode(c11978a.f8570b) + "], refCount[" + c11978a.f8572d + "]");
        this.f8576d.put(Integer.valueOf(c11978a.f8569a), c11978a);
        this.f8575c.put(c11978a.f8571c, c11978a);
        this.f8577e.add(c11991a);
    }

    /* JADX INFO: renamed from: b */
    public final void m13556b(String str, C11991a c11991a) throws IOException {
        StringBuilder sbM1324q = AbstractC1974b.m1324q(str);
        String str2 = File.separator;
        AbstractC1974b.m1332y(sbM1324q, str2, "media", str2);
        sbM1324q.append(c11991a.f8613f);
        String string = sbM1324q.toString();
        if (!AbstractC2322a.m1607A(string)) {
            throw new IOException("addContentFile - original file[" + LoggerBase.getEncode(string) + "] is not exist.");
        }
        if (!new File(c11991a.f8610c).exists()) {
            BaseUtils.copyFile(string, c11991a.f8610c);
            m13555a(c11991a);
        } else {
            throw new IOException("addContentFile - dest file[" + LoggerBase.getEncode(string) + "] is already exist.");
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m13557c() throws IOException {
        for (String str : this.f8578f) {
            String strM756B = AbstractC0541b.m756B(str, DiskFileUpload.postfix);
            File file = new File(strM756B);
            if (!file.exists()) {
                throw new IOException("finishDownSync - temp file [" + LoggerBase.getEncode(strM756B) + "] is not exist.");
            }
            File file2 = new File(str);
            if (file2.exists()) {
                LoggerBase.m7126e("WCon_ContentFileManager", "finishDownSync - dest file [" + LoggerBase.getEncode(str) + "] is exist. delete it.");
                if (!file2.delete()) {
                    throw new IOException("finishDownSync - fail to delete dest file [" + LoggerBase.getEncode(str) + "].");
                }
            }
            if (!file.renameTo(file2)) {
                throw new IOException("finishDownSync - fail to rename [" + LoggerBase.getEncode(strM756B) + "] to [" + LoggerBase.getEncode(str) + "]");
            }
        }
        this.f8576d.clear();
        Iterator it = this.f8575c.entrySet().iterator();
        while (it.hasNext()) {
            C11978a c11978a = (C11978a) ((Map.Entry) it.next()).getValue();
            this.f8576d.put(Integer.valueOf(c11978a.f8569a), c11978a);
        }
    }

    /* JADX INFO: renamed from: d */
    public final int m13558d(String str) throws SyncException {
        if (str == null) {
            throw new IllegalArgumentException("hash can not be null.");
        }
        if (this.f8575c.containsKey(str) && this.f8575c.get(str) != null) {
            return ((C11978a) this.f8575c.get(str)).f8569a;
        }
        LoggerBase.m7126e("WCon_ContentFileManager", "There are no related file info, hash[" + str + "]");
        for (C11991a c11991a : this.f8577e) {
            LoggerBase.m7130i("WCon_ContentFileManager", "contentFile file hash = [" + c11991a.f8618k + "], name = [" + LoggerBase.getEncode(c11991a.f8613f) + "], hash = [" + c11991a.f8612e + "]");
        }
        throw new SyncException(327, AbstractC0541b.m773o("There are no related file info, hash[", str, "]"));
    }

    /* JADX INFO: renamed from: e */
    public final String m13559e(int i) {
        if (i == -1) {
            throw new IllegalArgumentException("bindId is invalid.");
        }
        if (!this.f8576d.containsKey(Integer.valueOf(i)) || this.f8576d.get(Integer.valueOf(i)) == null) {
            throw new IllegalStateException(AbstractC0541b.m767i(i, "There are no related file info, bindId[", "]"));
        }
        return ((C11978a) this.f8576d.get(Integer.valueOf(i))).f8571c;
    }

    public final boolean equals(Object obj) {
        return isSame(obj);
    }

    /* JADX INFO: renamed from: f */
    public final void m13560f(C11991a c11991a) throws IOException {
        this.f8576d.remove(Integer.valueOf(c11991a.f8608a));
        this.f8575c.remove(c11991a.f8618k);
        this.f8577e.remove(c11991a);
        File file = new File(c11991a.f8610c);
        if (!file.exists()) {
            LoggerBase.m7126e("WCon_ContentFileManager", "removeContentFile - [" + LoggerBase.getEncode(c11991a.f8610c) + "] is not exist.");
            return;
        }
        if (file.delete()) {
            return;
        }
        throw new IOException("removeContentFile - fail to delete, exist file [" + LoggerBase.getEncode(c11991a.f8610c) + "]");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11979b)) {
            return false;
        }
        C11979b c11979b = (C11979b) obj;
        return AbstractC0299q.m631h(this.f8577e, c11979b.f8577e) && AbstractC0299q.m633i(this.f8575c, c11979b.f8575c) && AbstractC0299q.m633i(this.f8576d, c11979b.f8576d);
    }
}
