package com.google.android.play.core.splitinstall;

import android.util.Log;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.az */
/* JADX INFO: loaded from: classes5.dex */
final class C5299az {

    /* JADX INFO: renamed from: a */
    private final XmlPullParser f3111a;

    /* JADX INFO: renamed from: b */
    private final C5305g f3112b = new C5305g();

    public C5299az(XmlPullParser xmlPullParser) {
        this.f3111a = xmlPullParser;
    }

    /* JADX INFO: renamed from: b */
    private final void m4125b() throws XmlPullParserException, IOException {
        int i = 1;
        while (i != 0) {
            int next = this.f3111a.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final C5306h m4126a() {
        String strM4124a;
        while (this.f3111a.next() != 1) {
            try {
                if (this.f3111a.getEventType() == 2) {
                    if (this.f3111a.getName().equals("splits")) {
                        while (this.f3111a.next() != 3) {
                            if (this.f3111a.getEventType() == 2) {
                                if (!this.f3111a.getName().equals("module") || (strM4124a = m4124a("name")) == null) {
                                    m4125b();
                                } else {
                                    while (this.f3111a.next() != 3) {
                                        if (this.f3111a.getEventType() == 2) {
                                            if (this.f3111a.getName().equals("language")) {
                                                while (this.f3111a.next() != 3) {
                                                    if (this.f3111a.getEventType() == 2) {
                                                        if (this.f3111a.getName().equals("entry")) {
                                                            String strM4124a2 = m4124a("key");
                                                            String strM4124a3 = m4124a("split");
                                                            m4125b();
                                                            if (strM4124a2 != null && strM4124a3 != null) {
                                                                this.f3112b.m4136a(strM4124a, strM4124a2, strM4124a3);
                                                            }
                                                        } else {
                                                            m4125b();
                                                        }
                                                    }
                                                }
                                            } else {
                                                m4125b();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        m4125b();
                    }
                }
            } catch (IOException e) {
                e = e;
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            } catch (IllegalStateException e2) {
                e = e2;
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            } catch (XmlPullParserException e3) {
                e = e3;
                Log.e("SplitInstall", "Error while parsing splits.xml", e);
                return null;
            }
        }
        return this.f3112b.m4135a();
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    private final String m4124a(String str) {
        for (int i = 0; i < this.f3111a.getAttributeCount(); i++) {
            if (this.f3111a.getAttributeName(i).equals(str)) {
                return this.f3111a.getAttributeValue(i);
            }
        }
        return null;
    }
}
