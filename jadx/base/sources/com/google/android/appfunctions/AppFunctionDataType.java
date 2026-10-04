package com.google.android.appfunctions;

import com.samsung.android.scs.p140ai.sdkcommon.text.TextConst;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionDataType;", "", "Companion", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface AppFunctionDataType {
    public static final int BOOLEAN = 1;
    public static final int BYTES = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int DOCUMENT = 3;
    public static final int DOUBLE = 4;
    public static final int FLOAT = 5;
    public static final int INT = 7;
    public static final int LONG = 6;
    public static final int PENDING_INTENT = 9;
    public static final int REMOTE_VIEWS = 10;
    public static final int STRING = 8;
    public static final int UNIT = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0003¨\u0006\u0011"}, m13886d2 = {"Lcom/google/android/appfunctions/AppFunctionDataType$Companion;", "", "<init>", "()V", TextConst.ENTITY_TYPE_UNIT, "", "BOOLEAN", "BYTES", "DOCUMENT", "DOUBLE", "FLOAT", "LONG", "INT", "STRING", "PENDING_INTENT", "REMOTE_VIEWS", "getREMOTE_VIEWS$annotations", "java.com.google.android.libraries.llm.appfunctions.appfunctions_common_appfunctions_common"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BOOLEAN = 1;
        public static final int BYTES = 2;
        public static final int DOCUMENT = 3;
        public static final int DOUBLE = 4;
        public static final int FLOAT = 5;
        public static final int INT = 7;
        public static final int LONG = 6;
        public static final int PENDING_INTENT = 9;
        public static final int REMOTE_VIEWS = 10;
        public static final int STRING = 8;
        public static final int UNIT = 0;

        private Companion() {
        }

        @AppFunctionExperimental
        public static /* synthetic */ void getREMOTE_VIEWS$annotations() {
        }
    }
}
