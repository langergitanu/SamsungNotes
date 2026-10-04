package com.samsung.android.app.notes.tools;

import android.app.ActivityOptions;
import android.content.Context;
import android.graphics.Rect;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.mobileservice.profile.Profile;
import com.samsung.android.support.senl.p145cm.base.framework.content.ContextCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.FoldStateCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/app/notes/tools/FoldedPopupUtil;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "POSTURE_LAUNCHED_KEY", "getFoldedActivityOptions", "", "context", "Landroid/content/Context;", Profile.PhoneNumberData.TYPE_CALLBACK, "Lcom/samsung/android/app/notes/tools/FoldedPopupUtil$IFoldedActivityOptionsCallback;", "createActivityOptionsForHalfBottom", "Landroid/app/ActivityOptions;", "IFoldedActivityOptionsCallback", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FoldedPopupUtil {

    @NotNull
    public static final FoldedPopupUtil INSTANCE = new FoldedPopupUtil();

    @NotNull
    public static final String POSTURE_LAUNCHED_KEY = "posture_launched_key";

    @NotNull
    private static final String TAG = "FoldedPopupUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/app/notes/tools/FoldedPopupUtil$IFoldedActivityOptionsCallback;", "", "onCompleted", "", "opt", "Landroid/app/ActivityOptions;", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface IFoldedActivityOptionsCallback {
        void onCompleted(@Nullable ActivityOptions opt);
    }

    private FoldedPopupUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ActivityOptions createActivityOptionsForHalfBottom(Context context) {
        Rect screenSize = DisplayUtils.getScreenSize(context);
        int statusBarHeight = WindowManagerCompat.INSTANCE.getInstance().getStatusBarHeight(context);
        int iWidth = screenSize.width() - statusBarHeight;
        int iHeight = screenSize.height();
        int i = (iHeight >> 1) + ((int) (((double) statusBarHeight) / 1.4d));
        InputMethodCompat.Companion companion = InputMethodCompat.INSTANCE;
        int navigationBarHeight = iHeight - (companion.getInstance().isNavigationBarHidden(context) ? 0 : companion.getInstance().getNavigationBarHeight(context));
        StringBuilder sbM1173s = AbstractC0622a.m1173s(statusBarHeight, i, "Haf opened : ", SQLKeyword.COMMA, SQLKeyword.COMMA);
        sbM1173s.append(iWidth);
        sbM1173s.append(SQLKeyword.COMMA);
        sbM1173s.append(navigationBarHeight);
        Logger.m8702i(TAG, sbM1173s.toString());
        return ContextCompat.INSTANCE.getInstance().makeLaunchBoundOption(statusBarHeight, i, iWidth, navigationBarHeight);
    }

    public final void getFoldedActivityOptions(@NotNull final Context context, @NotNull final IFoldedActivityOptionsCallback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FoldStateCompat.Companion companion = FoldStateCompat.INSTANCE;
        final int foldDirection = companion.getInstance().getFoldDirection(context);
        if (foldDirection == 0) {
            callback.onCompleted(null);
        } else {
            companion.getInstance().getFoldState(new FoldStateCompat.FolderStateCallback() { // from class: com.samsung.android.app.notes.tools.FoldedPopupUtil.getFoldedActivityOptions.1
                @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FolderStateCallback
                public void onFailed() {
                    callback.onCompleted(null);
                }

                @Override // com.samsung.android.support.senl.cm.base.framework.sem.view.AbsFoldStateCompatImplFactory.FolderStateCallback
                public void onSuccess(int foldState) {
                    callback.onCompleted((foldState == 2 && foldDirection == 8) ? FoldedPopupUtil.INSTANCE.createActivityOptionsForHalfBottom(context) : null);
                }
            });
        }
    }
}
