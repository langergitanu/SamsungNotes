package p038I1;

import android.content.Context;
import com.samsung.android.support.notes.sync.C7943R;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCard;
import com.samsung.android.support.senl.p148nt.base.common.tipcard.TipCardListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p042J1.AbstractC0155m;
import p042J1.C0145c;
import p086V.C0322h;

/* JADX INFO: renamed from: I1.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0137m {

    /* JADX INFO: renamed from: c */
    public static final ArrayList f389c = new ArrayList();

    /* JADX INFO: renamed from: d */
    public static C0137m f390d;

    /* JADX INFO: renamed from: a */
    public final ArrayList f391a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public ArrayList f392b;

    public C0137m() {
        int i = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("TipCardFlags", 0);
        Context appContext = C0322h.m670a().f815a.getAppContext();
        ArrayList<TipCard> arrayList = new ArrayList();
        if (i != 0) {
            if ((i & 16) == 16) {
                arrayList.add(new C0138n(appContext));
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardNotEnoughCloudStorage added");
            }
            if ((i & 8192) == 8192) {
                arrayList.add(new C0127c(14, C7943R.string.sync_tipcard_cloud_server_storage_exceeds_title, CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C7943R.string.sync_tipcard_cloud_server_storage_exceeds_body_jp : CommonUtils.hasSaSetting(appContext) ? C7943R.string.sync_tipcard_cloud_server_storage_exceeds_body_na : C7943R.string.sync_tipcard_cloud_server_storage_exceeds_body, 0, 0, 1));
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardCloudServerStorageExceeds added");
            }
            if ((i & 32) == 32) {
                arrayList.add(new C0135k(appContext));
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardFailToSyncServerError added");
            }
            if ((i & 64) == 64) {
                arrayList.add(new C0132h());
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardFailToSyncNetworkError added");
            }
            if ((i & 2) == 2) {
                arrayList.add(new C0130f());
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardFailToImportServerError added");
            }
            if ((i & 8) == 8) {
                arrayList.add(new C0128d());
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardFailToImportDeviceStorageFull added");
            }
            if ((i & 1024) == 1024) {
                arrayList.add(new C0134j());
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardFailToSyncPermission added");
            }
            if ((i & 2048) == 2048) {
                arrayList.add(new C0139o());
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardNotEnoughCloudStorageInSettings added");
            }
            if ((i & 128) == 128) {
                arrayList.add(new C0133i());
                Debugger.m8607d("TipCardUtils", "onCreate() : TipCardFailToSyncNotEnoughDeviceStorage added");
            }
        }
        for (TipCard tipCard : arrayList) {
            if (tipCard.getType() == 4 && AbstractC0155m.m401p()) {
                C0145c.m306N(SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("TipCardFlags", 0) & (-9), Constants.APP_LAUNCH_PREFERENCE, "TipCardFlags");
            } else {
                m283a(tipCard);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static TipCard m279c(int i, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TipCard tipCard = (TipCard) it.next();
            if (i == tipCard.getType()) {
                return tipCard;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static C0137m m280d() {
        C0137m c0137m;
        synchronized (C0137m.class) {
            try {
                if (f390d == null) {
                    f390d = new C0137m();
                }
                c0137m = f390d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0137m;
    }

    /* JADX INFO: renamed from: f */
    public static int m281f(int i) {
        switch (i) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 8;
            case 5:
                return 16;
            case 6:
                return 32;
            case 7:
                return 64;
            case 8:
                return 128;
            case 9:
                return 256;
            case 10:
                return 512;
            case 11:
                return 1024;
            case 12:
                return 2048;
            case 13:
                return 4096;
            case 14:
                return 8192;
            case 15:
                return 16384;
            case 16:
                return 32768;
            case 17:
                return 65536;
            default:
                return 0;
        }
    }

    /* JADX INFO: renamed from: j */
    public static String m282j(int i) {
        switch (i) {
            case 1:
                return "[Tip] import downloading ";
            case 2:
                return "[Tip] Import server error ";
            case 3:
                return "[Tip] Import network error ";
            case 4:
                return "[Tip] Import device storage full error ";
            case 5:
                return "[Tip] Not enough cloud storage ";
            case 6:
                return "[Tip] sync server error ";
            case 7:
                return "[Tip] sync network error ";
            case 8:
                return "[Tip] sync not enough device storage ";
            case 9:
                return "[Tip] Sync server blocking ";
            case 10:
                return "[Tip] Can't sync over 1Gb ";
            case 11:
                return "[Tip] sync permission error ";
            case 12:
                return "[Tip] sync not enough cloud storage in settings ";
            case 13:
                return "[Tip] share fail to share note ";
            case 14:
                return "[Tip] Cloud server storage exceeds ";
            case 15:
                return "[Tip] Sync WiFi Only error ";
            default:
                return "none ";
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m283a(TipCard tipCard) {
        switch (tipCard.getType()) {
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 11:
            case 12:
            case 13:
            case 14:
                synchronized (this.f391a) {
                    try {
                        Iterator it = this.f391a.iterator();
                        while (it.hasNext()) {
                            if (((TipCard) it.next()).getType() == tipCard.getType()) {
                                return false;
                            }
                        }
                        this.f391a.add(tipCard);
                        Debugger.m8615i("TipCardManager", "Add TipCard " + m282j(tipCard.getType()) + ": size = " + Integer.toString(this.f391a.size()));
                        if (tipCard.getType() != 1) {
                            int iM281f = m281f(tipCard.getType());
                            if (iM281f != 0 && iM281f != 1 && iM281f != 2) {
                                switch (iM281f) {
                                    case 4:
                                    case 8:
                                    case 16:
                                    case 32:
                                    case 64:
                                    case 128:
                                    case 256:
                                    case 512:
                                    case 1024:
                                    case 2048:
                                    case 4096:
                                    case 8192:
                                    case 16384:
                                    case 32768:
                                    case 65536:
                                        break;
                                    default:
                                        C0145c.m306N(iM281f | SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("TipCardFlagsExt1", 0), Constants.APP_LAUNCH_PREFERENCE, "TipCardFlagsExt1");
                                        return true;
                                }
                            }
                            C0145c.m306N(iM281f | SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("TipCardFlags", 0), Constants.APP_LAUNCH_PREFERENCE, "TipCardFlags");
                        }
                        return true;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            case 3:
            case 10:
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m284b(TipCard tipCard) {
        synchronized (this) {
            try {
                Iterator it = f389c.iterator();
                while (it.hasNext()) {
                    ((TipCardListener) it.next()).onCreate(tipCard);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public final List m285e() {
        if (this.f392b == null) {
            ArrayList arrayList = new ArrayList();
            this.f392b = arrayList;
            arrayList.add(7);
            this.f392b.add(6);
            this.f392b.add(5);
            this.f392b.add(14);
            this.f392b.add(11);
            this.f392b.add(12);
            this.f392b.add(8);
            this.f392b.add(9);
        }
        return this.f392b;
    }

    /* JADX INFO: renamed from: g */
    public final void m286g(int i) {
        synchronized (this.f391a) {
            try {
                Iterator it = this.f391a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((TipCard) it.next()).getType() == i) {
                        it.remove();
                        Debugger.m8607d("TipCardManager", "removed TipCard - " + m282j(i) + ": size = " + Integer.toString(this.f391a.size()));
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int iM281f = m281f(i);
        if (iM281f != 0 && iM281f != 1 && iM281f != 2) {
            switch (iM281f) {
                case 4:
                case 8:
                case 16:
                case 32:
                case 64:
                case 128:
                case 256:
                case 512:
                case 1024:
                case 2048:
                case 4096:
                case 8192:
                case 16384:
                case 32768:
                case 65536:
                    break;
                default:
                    C0145c.m306N((~iM281f) & SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("TipCardFlagsExt1", 0), Constants.APP_LAUNCH_PREFERENCE, "TipCardFlagsExt1");
                    return;
            }
        }
        C0145c.m306N((~iM281f) & SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt("TipCardFlags", 0), Constants.APP_LAUNCH_PREFERENCE, "TipCardFlags");
    }

    /* JADX INFO: renamed from: h */
    public final void m287h() {
        Debugger.m8607d("TipCardManager", "removeTipCardsBeforeSyncing() : " + this.f391a.size());
        ArrayList arrayList = new ArrayList();
        synchronized (this.f391a) {
            for (TipCard tipCard : this.f391a) {
                if (((ArrayList) m285e()).contains(Integer.valueOf(tipCard.getType()))) {
                    ArrayList<TipCardListener> arrayList2 = f389c;
                    synchronized (arrayList2) {
                        try {
                            for (TipCardListener tipCardListener : arrayList2) {
                                Debugger.m8607d("TipCardManager", "Remove TipCard for Listener : " + m282j(tipCard.getType()));
                                tipCardListener.onEnd(tipCard);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    arrayList.add(tipCard);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            m286g(((TipCard) it.next()).getType());
        }
    }

    /* JADX INFO: renamed from: i */
    public final boolean m288i(C0136l c0136l) {
        Debugger.m8607d("TipCardManager", "TipCard onCreate() " + c0136l.getType());
        int type = c0136l.getType();
        ArrayList arrayList = this.f391a;
        if (m279c(type, arrayList) == null) {
            arrayList.add(c0136l);
        }
        boolean z = false;
        for (TipCardListener tipCardListener : f389c) {
            Debugger.m8607d("TipCardManager", "TipCard onCreate() listener");
            tipCardListener.onCreate(c0136l);
            z = true;
        }
        return z;
    }
}
