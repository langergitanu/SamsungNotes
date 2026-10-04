package p094X0;

import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import java.io.File;
import java.io.IOException;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: X0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0339a {

    /* JADX INFO: renamed from: a */
    public static final String f859a = "SS$".concat("PageTemplateDataMover");

    /* JADX INFO: renamed from: a */
    public static void m671a(String str, String str2) {
        try {
            FileUtils.copyDirectory(new File(str), new File(str2));
        } catch (IOException e) {
            AbstractC0000a.m1B(e, new StringBuilder("backupMove failed "), f859a);
        }
    }
}
