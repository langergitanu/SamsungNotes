package com.samsung.scsp.framework.core.network;

import java.util.Arrays;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ResponseUtil {
    private static final int MULTI_STATUS = 207;
    private static final int RESUMABLE_INCOMPLETE_UPLOAD_V1 = 308;
    private static final int TEMPORARY_REDIRECT = 307;
    private static final int RESUMABLE_INCOMPLETE_UPLOAD_V2 = 251;
    private static final int[] RESPONSIBLE_STATUS_ARRAY = {200, 201, 202, 204, 206, 207, 308, RESUMABLE_INCOMPLETE_UPLOAD_V2, 304};
    private static final int[] REDIRECTED_STATUS_ARRAY = {302, 301, 303, 307};
    private static final Predicate<Integer> RESPONSIBLE_STATUS = new C11682c(1);
    private static final Predicate<Integer> REDIRECTED_STATUS = new C11682c(2);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(Integer num, int i) {
        return num.intValue() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$1(Integer num) {
        return Arrays.stream(RESPONSIBLE_STATUS_ARRAY).anyMatch(new C11684e(num, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$2(Integer num, int i) {
        return num.intValue() == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$3(Integer num) {
        return Arrays.stream(REDIRECTED_STATUS_ARRAY).anyMatch(new C11684e(num, 1));
    }

    public static Predicate<Integer> redirected() {
        return REDIRECTED_STATUS;
    }

    public static Predicate<Integer> responsible() {
        return RESPONSIBLE_STATUS;
    }
}
