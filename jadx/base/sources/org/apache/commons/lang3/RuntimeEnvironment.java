package org.apache.commons.lang3;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.stt.summarize.C9478c;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RuntimeEnvironment {
    @Deprecated
    public RuntimeEnvironment() {
    }

    private static boolean fileExists(String str) {
        return Files.exists(Paths.get(str, new String[0]), new LinkOption[0]);
    }

    public static Boolean inContainer() {
        return Boolean.valueOf(inContainer(""));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$readFile$0(String str, String str2) {
        return str2.startsWith(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String[] lambda$readFile$1(String str) {
        return str.split(MarketingConstants.REFERRER_DELIMITER_U003D, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$readFile$2(String[] strArr) {
        return strArr[1];
    }

    private static String readFile(String str, String str2) {
        try {
            return (String) Arrays.stream(new String(Files.readAllBytes(Paths.get(str, new String[0])), Charset.defaultCharset()).split(String.valueOf((char) 0))).filter(new C9478c(str2 + MarketingConstants.REFERRER_DELIMITER_U003D, 4)).map(new C13791b(14)).map(new C13791b(15)).findFirst().orElse(null);
        } catch (IOException unused) {
            return null;
        }
    }

    public static boolean inContainer(String str) {
        return readFile(AbstractC0541b.m756B(str, "/proc/1/environ"), "container") != null ? !r0.isEmpty() : fileExists(AbstractC0541b.m756B(str, "/.dockerenv")) || fileExists(AbstractC0541b.m756B(str, "/run/.containerenv"));
    }
}
