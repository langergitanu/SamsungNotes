package com.samsung.android.support.senl.p145cm.base.framework.sem.app;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsAiActionStatusCompatImplFactory;
import com.samsung.android.support.senl.p148nt.base.common.mcf.handoff.common.HandoffConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\b\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AiActionStatusCompatImplFactory;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsAiActionStatusCompatImplFactory;", "<init>", "()V", "create", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsAiActionStatusCompatImplFactory$IAiActionStatusCompatImpl;", HandoffConstant.KEY_DEVICE_TYPE, "", "AiActionStatusCompatSemImpl", "Companion", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class AiActionStatusCompatImplFactory extends AbsAiActionStatusCompatImplFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int KNOX_FALSE = 0;
    private static final int KNOX_NULL = -1;
    private static final int KNOX_TRUE = 1;

    @NotNull
    private static final String TAG = "AiActionStatusCompatImpl";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AiActionStatusCompatImplFactory$AiActionStatusCompatSemImpl;", "Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AbsAiActionStatusCompatImplFactory$IAiActionStatusCompatImpl;", "<init>", "()V", "showToastIfOnlineProcessingDisallowed", "", "context", "Landroid/content/Context;", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nAiActionStatusCompatImplFactory.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AiActionStatusCompatImplFactory.kt\ncom/samsung/android/support/senl/cm/base/framework/sem/app/AiActionStatusCompatImplFactory$AiActionStatusCompatSemImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,57:1\n1#2:58\n*E\n"})
    public static final class AiActionStatusCompatSemImpl implements AbsAiActionStatusCompatImplFactory.IAiActionStatusCompatImpl {
        @Override // com.samsung.android.support.senl.cm.base.framework.sem.app.AbsAiActionStatusCompatImplFactory.IAiActionStatusCompatImpl
        public boolean showToastIfOnlineProcessingDisallowed(@Nullable Context context) {
            return context != null && 1 == AiActionStatusCompatImplFactory.INSTANCE.getKnoxPolicy(context, "content://com.sec.knox.provider/RestrictionPolicy", "showToastIfIntelligenceOnlineProcessingDisallowed");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/support/senl/cm/base/framework/sem/app/AiActionStatusCompatImplFactory$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "KNOX_NULL", "", "KNOX_FALSE", "KNOX_TRUE", "getKnoxPolicy", "context", "Landroid/content/Context;", "edmUri", "projectionArgs", "cmBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int getKnoxPolicy(Context context, String edmUri, String projectionArgs) {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse(edmUri), null, projectionArgs, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                try {
                    int columnIndex = cursorQuery.getColumnIndex(projectionArgs);
                    boolean zAreEqual = Intrinsics.areEqual(columnIndex != -1 ? cursorQuery.getString(columnIndex) : "", "true");
                    cursorQuery.close();
                    return zAreEqual ? 1 : 0;
                } catch (Exception unused) {
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return -1;
        }

        private Companion() {
        }
    }

    @Override // com.samsung.android.support.senl.p145cm.base.framework.sem.app.AbsAiActionStatusCompatImplFactory
    @NotNull
    public AbsAiActionStatusCompatImplFactory.IAiActionStatusCompatImpl create(int deviceType) {
        return (deviceType == 2 || deviceType == 3) ? new AiActionStatusCompatSemImpl() : super.create(deviceType);
    }
}
