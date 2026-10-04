package p194k0;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6906i;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.support.senl.p148nt.base.common.util.Base64Utils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p079T.AbstractC0299q;
import p178f0.C11979b;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;

/* JADX INFO: renamed from: k0.z */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12968z implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: d */
    public long f9302d;

    /* JADX INFO: renamed from: e */
    public long f9303e;

    /* JADX INFO: renamed from: f */
    public final C11979b f9304f;

    /* JADX INFO: renamed from: a */
    public int f9299a = -1;

    /* JADX INFO: renamed from: g */
    public final ArrayList f9305g = new ArrayList();

    /* JADX INFO: renamed from: b */
    public String f9300b = "";

    /* JADX INFO: renamed from: c */
    public String f9301c = "";

    public C12968z(C6906i c6906i) {
        this.f9304f = (C11979b) c6906i.f4483b;
    }

    @Override // p185h0.InterfaceC12019d
    /* JADX INFO: renamed from: a */
    public final void mo47a(C6742k c6742k) {
        c6742k.m4846F("voiceData");
        c6742k.m4851h("attachFile", this.f9304f.m13559e(this.f9299a));
        c6742k.m4851h("name", Base64Utils.encodeBase64(this.f9300b));
        c6742k.m4851h(DBSchema.DocumentThumbnail.PLAY_TIME, Base64Utils.encodeBase64(this.f9301c));
        c6742k.m4850f(GroupContract.Group.CREATED_TIME, this.f9302d);
        c6742k.m4850f("recordingTime", this.f9303e);
        ArrayList<C12967y> arrayList = this.f9305g;
        if (!arrayList.isEmpty()) {
            c6742k.m4846F("propertyList");
            for (C12967y c12967y : arrayList) {
                c6742k.m4846F("property");
                try {
                    c6742k.m4848d(c12967y.f9297a, "action");
                    c6742k.m4850f("timeStamp", c12967y.f9298b);
                } catch (Exception e) {
                    AbstractC0000a.m21r(e, new StringBuilder("WCon_VoiceData.composeXml"), "WCon_VoiceData");
                }
                c6742k.m4856m("property");
            }
            c6742k.m4856m("propertyList");
        }
        c6742k.m4856m("voiceData");
    }

    @Override // com.samsung.android.support.senl.cm.base.common.util.VariableComparator.Comparison
    public final boolean isSame(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12968z)) {
            return false;
        }
        C12968z c12968z = (C12968z) obj;
        if (this.f9299a != c12968z.f9299a) {
            StringBuilder sb = new StringBuilder(" !! equals - NE - mAttachedFileId[");
            sb.append(this.f9299a);
            sb.append(" - ");
            AbstractC11014a.m12329n(c12968z.f9299a, "]", "WCon_VoiceData", sb);
            return false;
        }
        if (!TextUtils.equals(this.f9300b, c12968z.f9300b)) {
            StringBuilder sb2 = new StringBuilder(" !! equals - NE - mName[");
            sb2.append(this.f9300b);
            sb2.append(" - ");
            AbstractC4539a.m3209s(sb2, c12968z.f9300b, "]", "WCon_VoiceData");
            return false;
        }
        if (TextUtils.equals(this.f9301c, c12968z.f9301c)) {
            if (AbstractC0299q.m631h(this.f9305g, c12968z.f9305g)) {
                return true;
            }
            Log.i("WCon_VoiceData", " !! equals() - NE - mVoicePropertyList check");
            return false;
        }
        StringBuilder sb3 = new StringBuilder(" !! equals - NE - mPlayTime[");
        sb3.append(this.f9301c);
        sb3.append(" - ");
        AbstractC4539a.m3209s(sb3, c12968z.f9301c, "]", "WCon_VoiceData");
        return false;
    }
}
