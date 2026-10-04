package p194k0;

import com.samsung.android.app.notes.sync.p135db.C6742k;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import p185h0.InterfaceC12017b;
import p185h0.InterfaceC12019d;

/* JADX INFO: renamed from: k0.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC12946d implements InterfaceC12019d, InterfaceC12017b {

    /* JADX INFO: renamed from: a */
    public final int f9154a;

    public AbstractC12946d(int i) {
        this.f9154a = i;
    }

    /* JADX INFO: renamed from: b */
    public void m13847b(C6742k c6742k) throws IOException {
        int i = this.f9154a;
        c6742k.m4851h("type", i == 1 ? "color" : i == 2 ? "image" : i == 3 ? "pattern" : i == 4 ? "background" : null);
    }

    /* JADX INFO: renamed from: c */
    public abstract int mo13844c();

    /* JADX INFO: renamed from: d */
    public abstract void mo13845d(XmlPullParser xmlPullParser);
}
