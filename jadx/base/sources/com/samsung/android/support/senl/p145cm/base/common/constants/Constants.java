package com.samsung.android.support.senl.p145cm.base.common.constants;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/Constants;", "", "<init>", "()V", "PKG_NAME", "", "SNote", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Constants {

    @NotNull
    public static final Constants INSTANCE = new Constants();

    @NotNull
    public static final String PKG_NAME = "com.samsung.android.app.notes";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/Constants$SNote;", "", "<init>", "()V", "SDOC_LOCKED_FILE_KEY", "", "WNOTE_LOCKED_FILE_KEY", "", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class SNote {

        @JvmField
        public static int SDOC_LOCKED_FILE_KEY;

        @NotNull
        public static final SNote INSTANCE = new SNote();

        @JvmField
        @NotNull
        public static String WNOTE_LOCKED_FILE_KEY = "0";

        private SNote() {
        }
    }

    private Constants() {
    }
}
