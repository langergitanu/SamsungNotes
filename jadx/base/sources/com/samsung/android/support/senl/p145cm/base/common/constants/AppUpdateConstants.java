package com.samsung.android.support.senl.p145cm.base.common.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/AppUpdateConstants;", "", "<init>", "()V", "PRODUCT_DETAIL", "", "PRODUCT_DATA", "UPDATE_TYPE", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AppUpdateConstants {

    @NotNull
    public static final AppUpdateConstants INSTANCE = new AppUpdateConstants();

    @NotNull
    public static final String PRODUCT_DATA = "/?source=SamsungNotes&fsOrigin=stubUpdateCheck&fsUpdateType=";

    @NotNull
    public static final String PRODUCT_DETAIL = "samsungapps://ProductDetail/";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/common/constants/AppUpdateConstants$UPDATE_TYPE;", "", "<init>", "()V", "SELF", "", "OND", "OCD", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class UPDATE_TYPE {

        @NotNull
        public static final UPDATE_TYPE INSTANCE = new UPDATE_TYPE();

        @NotNull
        public static final String OCD = "ocd";

        @NotNull
        public static final String OND = "ond";

        @NotNull
        public static final String SELF = "self";

        private UPDATE_TYPE() {
        }
    }

    private AppUpdateConstants() {
    }
}
