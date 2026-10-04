package p182g0;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.VariableComparator;
import com.samsung.android.support.senl.p145cm.base.framework.support.LoggerBase;
import java.io.IOException;
import java.io.RandomAccessFile;
import p079T.AbstractC0299q;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;

/* JADX INFO: renamed from: g0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C11991a implements InterfaceC12019d, InterfaceC12017b, VariableComparator.Collector {

    /* JADX INFO: renamed from: a */
    public int f8608a;

    /* JADX INFO: renamed from: b */
    public final String f8609b;

    /* JADX INFO: renamed from: c */
    public String f8610c;

    /* JADX INFO: renamed from: e */
    public String f8612e;

    /* JADX INFO: renamed from: f */
    public String f8613f;

    /* JADX INFO: renamed from: g */
    public long f8614g;

    /* JADX INFO: renamed from: h */
    public long f8615h;

    /* JADX INFO: renamed from: i */
    public int f8616i;

    /* JADX INFO: renamed from: j */
    public String f8617j;

    /* JADX INFO: renamed from: k */
    public String f8618k;

    /* JADX INFO: renamed from: d */
    public boolean f8611d = false;

    /* JADX INFO: renamed from: l */
    public boolean f8619l = true;

    /* JADX INFO: renamed from: m */
    public String f8620m = "";

    /* JADX INFO: renamed from: n */
    public boolean f8621n = false;

    public C11991a(String str) {
        this.f8609b = str;
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) throws IOException {
        c6742k.m4851h("id", this.f8618k);
        c6742k.m4848d(this.f8608a, "bindNumber");
        c6742k.m4853j("name", this.f8613f);
        c6742k.m4848d(this.f8616i, CoeditServiceConstants.Attribute.KEY_REF_COUNT);
        c6742k.m4848d(0, GroupContract.Group.CREATED_TIME);
        c6742k.m4850f("modifiedTime", this.f8615h);
        c6742k.m4851h("hash", this.f8612e);
        c6742k.m4852i("isFileAttached", this.f8619l);
        if (AbstractC0299q.f768a.f318a >= 3) {
            c6742k.m4851h("uploadToken", this.f8620m);
        }
        c6742k.m4865w("fileHash", this.f8618k);
    }

    /* JADX INFO: renamed from: b */
    public final void m13584b(RandomAccessFile randomAccessFile) throws IOException {
        int iM606P = this.f8611d ? AbstractC0299q.m606P(randomAccessFile) : 0;
        long filePointer = randomAccessFile.getFilePointer();
        this.f8608a = AbstractC0299q.m606P(randomAccessFile);
        this.f8613f = AbstractC0299q.m611U(randomAccessFile, 1024);
        this.f8618k = AbstractC0299q.m610T(randomAccessFile, 64);
        this.f8616i = AbstractC0299q.m609S(randomAccessFile);
        this.f8615h = AbstractC0299q.m607Q(randomAccessFile);
        if (this.f8611d) {
            this.f8619l = randomAccessFile.readByte() == 1;
        }
        String string = this.f8618k + this.f8608a + this.f8613f + this.f8616i + this.f8615h;
        if (this.f8611d) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
            sbM1324q.append(this.f8619l);
            string = sbM1324q.toString();
            randomAccessFile.seek(filePointer + ((long) iM606P));
        }
        this.f8612e = AbstractC0299q.m597G(string.getBytes());
        this.f8610c = this.f8609b + "/media/" + this.f8613f;
    }

    /* JADX INFO: renamed from: c */
    public final void m13585c(RandomAccessFile randomAccessFile) throws IOException {
        long filePointer = randomAccessFile.getFilePointer();
        if (this.f8611d) {
            randomAccessFile.seek(filePointer + 4);
        }
        AbstractC0299q.m632h0(randomAccessFile, this.f8608a);
        AbstractC0299q.m640l0(randomAccessFile, this.f8613f);
        String str = this.f8618k;
        if (str == null) {
            throw new IOException("writeStdString() - string is invalid");
        }
        if (str.isEmpty()) {
            AbstractC0299q.m636j0(randomAccessFile, 0);
        } else {
            randomAccessFile.write(str.getBytes(), 0, 64);
        }
        AbstractC0299q.m636j0(randomAccessFile, this.f8616i);
        AbstractC0299q.m634i0(randomAccessFile, this.f8615h);
        LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() - bind   id = [" + this.f8608a + "]");
        LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() - file name = [" + LoggerBase.getEncode(this.f8613f) + "]");
        LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() - ref count = [" + this.f8616i + "]");
        LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() - hash      = [" + this.f8618k + "]");
        LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() - mt        = [" + this.f8615h + "]");
        if (this.f8611d) {
            randomAccessFile.write((byte) ((this.f8619l ? 1 : 0) & 255));
            LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() - attached  = [" + this.f8619l + "]");
            long filePointer2 = randomAccessFile.getFilePointer();
            randomAccessFile.seek(filePointer);
            AbstractC0299q.m632h0(randomAccessFile, (int) ((filePointer2 - filePointer) - 4));
            randomAccessFile.seek(filePointer2);
        }
        LoggerBase.m7130i("WCon_ContentFile", "writeMediaInfo() ------------------------------------------------");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Collector
    public final VariableComparator.List collectVariables() {
        return new VariableComparator.List().addVar(new VariableComparator.IntVar("mBindId", this.f8608a)).addVar(new VariableComparator.StringVar("mHash", this.f8612e)).addVar(new VariableComparator.StringVar("mFileHash", this.f8618k)).addVar(new VariableComparator.StringVar("mFileName", this.f8613f)).addVar(new VariableComparator.LongVar("mCreatedTime", this.f8614g)).addVar(new VariableComparator.LongVar("mModifiedTime", this.f8615h)).addVar(new VariableComparator.IntVar("mReferenceCount", this.f8616i)).addVar(new VariableComparator.StringVar("mUrl", this.f8617j)).addVar(new VariableComparator.BoolVar("mIsFileAttached", this.f8619l));
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11991a) {
            return VariableComparator.compare(this, (C11991a) obj, "WCon_ContentFile");
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("mBindId=");
        sb.append(this.f8608a);
        sb.append(", mCachePath=");
        String str = this.f8609b;
        sb.append(str);
        sb.append(", mAbsolutePath=");
        sb.append(LoggerBase.getEncode(this.f8610c));
        sb.append(", mFileHash=");
        sb.append(this.f8618k);
        sb.append(", mFileName=");
        sb.append(LoggerBase.getEncode(this.f8613f));
        sb.append(", mCreatedTime=");
        sb.append(str);
        sb.append(", mModifiedTime=");
        sb.append(this.f8615h);
        sb.append(", mReferenceCount=");
        sb.append(this.f8616i);
        sb.append(", mUrl=");
        sb.append(this.f8617j);
        sb.append(", mIsFileAttached=");
        sb.append(this.f8619l);
        return sb.toString();
    }
}
