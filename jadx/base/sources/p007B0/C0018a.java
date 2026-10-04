package p007B0;

import androidx.collection.AbstractC0622a;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: B0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0018a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f93a;

    /* JADX INFO: renamed from: b */
    public String f94b;

    /* JADX INFO: renamed from: c */
    public String f95c;

    /* JADX INFO: renamed from: d */
    public String f96d;

    /* JADX INFO: renamed from: e */
    public String f97e;

    /* JADX INFO: renamed from: f */
    public boolean f98f;

    public final String toString() {
        switch (this.f93a) {
            case 0:
                StringBuilder sb = new StringBuilder("[mServerId = ");
                sb.append(this.f94b);
                sb.append(", mRequestid = ");
                sb.append(this.f95c);
                sb.append(", mTimeStamp = ");
                sb.append(this.f96d);
                sb.append(", mIsAlreadyCreated = ");
                return AbstractC0000a.m14k(sb, this.f98f, "]");
            default:
                StringBuilder sb2 = new StringBuilder("[mServerId = ");
                sb2.append(this.f94b);
                sb2.append(", mRequestid = ");
                sb2.append(this.f95c);
                sb2.append(", mTimeStamp = ");
                sb2.append(this.f96d);
                sb2.append(", mCommitId = ");
                return AbstractC0622a.m1170p(this.f97e, "]", sb2);
        }
    }
}
