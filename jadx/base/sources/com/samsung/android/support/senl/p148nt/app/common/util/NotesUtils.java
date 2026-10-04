package com.samsung.android.support.senl.p148nt.app.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.WorkerThread;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocInvalidPasswordException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedFileException;
import com.samsung.android.sdk.composer.document.sdoc.exception.SpenSDocUnsupportedVersionException;
import com.samsung.android.sdk.mobileservice.social.group.provider.GroupContract;
import com.samsung.android.sdk.pen.document.SpenUnsupportedTypeException;
import com.samsung.android.sdk.pen.document.SpenUnsupportedVersionException;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.MultiTaskManager;
import com.samsung.android.support.senl.p148nt.base.common.access.notelist.NoteListAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesLockDocumentRepository;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.AutoTitleCreator;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileUtil;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.utils.SpenDocumentDisplayUtils;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p044K.C0158a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0007J\u001b\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bH\u0007¢\u0006\u0002\u0010\u001cJ\b\u0010&\u001a\u00020'H\u0007J\u0012\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\tH\u0007J\b\u0010C\u001a\u00020'H\u0007J \u0010U\u001a\u00020'2\u0010\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010X\u0018\u00010W2\u0006\u0010Y\u001a\u00020ZJ\u0016\u0010U\u001a\u00020'2\u0006\u0010[\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZJ&\u0010\\\u001a\u0004\u0018\u00010]2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010^\u001a\u0004\u0018\u00010\u00052\u0006\u0010_\u001a\u00020\u0007H\u0007J&\u0010`\u001a\u0004\u0018\u00010a2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010^\u001a\u0004\u0018\u00010\u00052\u0006\u0010b\u001a\u00020\u0007H\u0007J\u001e\u0010c\u001a\u0004\u0018\u00010d2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010^\u001a\u0004\u0018\u00010\u0005H\u0007J$\u0010e\u001a\u0004\u0018\u00010a2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010^\u001a\u00020\u00052\u0006\u0010f\u001a\u00020\u0007H\u0007J.\u0010e\u001a\u0004\u0018\u00010a2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010^\u001a\u0004\u0018\u00010\u00052\u0006\u0010b\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\tH\u0007J\u0012\u0010h\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*H\u0007J\u0018\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020nH\u0007J\u0010\u0010q\u001a\u00020\t2\u0006\u0010r\u001a\u00020\tH\u0007J\"\u0010u\u001a\u00020\u00072\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020\u00052\b\u0010x\u001a\u0004\u0018\u00010yH\u0007J\u0010\u0010z\u001a\u00020\u00172\u0006\u0010{\u001a\u00020|H\u0002J\u0012\u0010}\u001a\u00020\u00072\b\u0010{\u001a\u0004\u0018\u00010|H\u0007J.\u0010~\u001a\u00020\u007f2\u0006\u0010)\u001a\u00020*2\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u007f2\u0007\u0010\u0083\u0001\u001a\u00020\u0017H\u0007J\u0012\u0010\u0084\u0001\u001a\u00020\u00052\u0007\u0010\u0085\u0001\u001a\u00020\u0017H\u0007J\u0012\u0010\u0086\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\tH\u0007J\u001b\u0010\u0088\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\t2\u0007\u0010\u0089\u0001\u001a\u00020\u0017H\u0007J\u0012\u0010\u008a\u0001\u001a\u00020\u00172\u0007\u0010\u0087\u0001\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001d\u0010\u001fR*\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00078F@BX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010%R*\u0010-\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b.\u0010\u0003\u001a\u0004\b/\u00100\"\u0004\b1\u00102R*\u00103\u001a\u00020\t2\u0006\u00103\u001a\u00020\t8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b4\u0010\u0003\u001a\u0004\b5\u00100\"\u0004\b6\u00102R*\u00107\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00078F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\u0003\u001a\u0004\b7\u0010\u001f\"\u0004\b9\u0010%R*\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\u00058F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\u0003\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0003\u001a\u0004\bA\u0010\u001fR\u001a\u0010D\u001a\u00020E8FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0003\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020E8FX\u0087\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0003\u001a\u0004\bK\u0010HR\u001a\u0010L\u001a\u00020E8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0003\u001a\u0004\bN\u0010HR\u001a\u0010O\u001a\u00020E8FX\u0087\u0004¢\u0006\f\u0012\u0004\bP\u0010\u0003\u001a\u0004\bQ\u0010HR\u001a\u0010R\u001a\u00020E8FX\u0087\u0004¢\u0006\f\u0012\u0004\bS\u0010\u0003\u001a\u0004\bT\u0010HR\u0010\u0010o\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u00020\u00078FX\u0087\u0004¢\u0006\f\u0012\u0004\bt\u0010\u0003\u001a\u0004\bs\u0010\u001f¨\u0006\u008b\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/common/util/NotesUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mIsOpenedTrashByOtherApps", "", "MAX_BUNDLE_SIZE", "", "isStaggeredGridLayout", "layoutMode", "isGridLayout", "isLinearLayout", "hasMsSyncIcon", "folder", "Lcom/samsung/android/support/senl/nt/data/database/core/document/folder/NotesFolder;", "isLock", "lockType", "isWarning", DBSchema.Document.CORRUPTED, "isSyncNotSupported", SyncDBSchema.SyncInfo.SYNC_STATE, "", "isDeletableWithoutVerify", "isLockedNotes", "uuidList", "", "([Ljava/lang/String;)I", "isMDEFeatureEnabled", "isMDEFeatureEnabled$annotations", "()Z", "enabled", "preferenceMDESupported", "getPreferenceMDESupported$annotations", "getPreferenceMDESupported", "setPreferenceMDESupported", "(Z)V", "initPreferenceMDESupported", "", "isCoeditFeatureEnabled", "context", "Landroid/content/Context;", "isNeedToDeletePermanently", "modeIndex", "sortType", "getSortType$annotations", "getSortType", "()I", "setSortType", "(I)V", "orderType", "getOrderType$annotations", "getOrderType", "setOrderType", "isPinFavorites", "isPinFavorites$annotations", "setPinFavorites", NotesConstants.KEY_FOLDER_UUID, "lastSelectedFolder", "getLastSelectedFolder$annotations", "getLastSelectedFolder", "()Ljava/lang/String;", "setLastSelectedFolder", "(Ljava/lang/String;)V", "isOpenedTrashByOtherApps", "isOpenedTrashByOtherApps$annotations", "openTrashByOtherApps", "sortParam", "Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SortParam;", "getSortParam$annotations", "getSortParam", "()Lcom/samsung/android/support/senl/nt/data/database/core/query/param/SortParam;", "sOMRecognizedCardSortParam", "getSOMRecognizedCardSortParam$annotations", "getSOMRecognizedCardSortParam", "deleteSortParam", "getDeleteSortParam$annotations", "getDeleteSortParam", "recentlyImportedSortParam", "getRecentlyImportedSortParam$annotations", "getRecentlyImportedSortParam", "spaceSortParam", "getSpaceSortParam$annotations", "getSpaceSortParam", "backToNoteList", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "data", "Landroid/content/Intent;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "getSpenWordDocument", "Lcom/samsung/android/support/senl/nt/model/documents/spen/SpenWordDocument;", "docPath", "isCoEdit", "getSpenWNoteForExportOffice", "Lcom/samsung/android/sdk/pen/worddoc/SpenWNote;", "isCoeditMode", "getSpenSDoc", "Lcom/samsung/android/sdk/composer/document/sdoc/SpenSDoc;", "getSpenWNote", "isCoEditMode", "width", "isTabletLayout", "getTouchPositionFromDragEvent", "Landroid/graphics/Point;", "item", "Landroid/view/View;", "e", "Landroid/view/DragEvent;", "isSupportREImageFilter", "isSupportDitheringFilter", "getAntiGreenisFilteredColor", "color", "isMsSyncSupported", "isMsSyncSupported$annotations", "needToHidePickDisplayData", NotesConstants.KEY_CALLER, "currentFolderUuid", "documentData", "Lcom/samsung/android/support/senl/nt/data/database/core/document/data/MainListDocumentData;", "getBundleSize", "bundle", "Landroid/os/Bundle;", "isExceedBundleSize", "getRecommendedTitle", "", "recommendedType", "Lcom/samsung/android/support/senl/nt/model/document/save/autotitle/AutoTitleCreator$CreationPriority;", DBSchema.Document.RECOMMENDED_TITLE, GroupContract.Group.CREATED_TIME, "getTitleTime", "createdAt", "getFromTime", "timeFilter", "getToTime", "currentSystemTime", "getTimeInMillis", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class NotesUtils {

    @NotNull
    public static final NotesUtils INSTANCE = new NotesUtils();
    public static final int MAX_BUNDLE_SIZE = 409600;

    @NotNull
    private static final String TAG = "NotesUtils";

    @JvmField
    public static final boolean isSupportDitheringFilter;

    @ChecksSdkIntAtLeast(api = 31)
    @JvmField
    public static final boolean isSupportREImageFilter;
    private static boolean mIsOpenedTrashByOtherApps;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AutoTitleCreator.CreationPriority.values().length];
            try {
                iArr[AutoTitleCreator.CreationPriority.RECORDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AutoTitleCreator.CreationPriority.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AutoTitleCreator.CreationPriority.DRAWING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AutoTitleCreator.CreationPriority.TABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        isSupportREImageFilter = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 80500 && Build.VERSION.SDK_INT >= 31;
        isSupportDitheringFilter = Build.VERSION.SDK_INT >= 33;
    }

    private NotesUtils() {
    }

    @JvmStatic
    public static final int getAntiGreenisFilteredColor(int color) {
        return (ModelFeature.getFeature().needAntiGreenish() && ContextUtils.isNightMode(BaseUtils.getApplicationContext())) ? (color == C8003R.color.basic_list_item_bg_color || color == C8003R.color.drawer_list_bg_color || color == C8003R.color.settings_list_background_color) ? C8003R.color.notes_anti_greenish_color : color == C8003R.color.noteslist_card_view_bg_color_black ? C8003R.color.notes_anti_greenish_color : color == C8003R.color.noteslist_thumbnail_opacity ? C8003R.color.notes_anti_greenish_thumbnail_opacity : color : color;
    }

    private final long getBundleSize(Bundle bundle) {
        Parcel parcelObtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(parcelObtain, "obtain(...)");
        try {
            parcelObtain.writeBundle(bundle);
            return parcelObtain.dataSize();
        } finally {
            parcelObtain.recycle();
        }
    }

    @NotNull
    public static final SortParam getDeleteSortParam() {
        SortParam sortParamBuild = new SortParam.SortParamBuilder().setSortType(3).setLastSortTimeType(2).setLastIsDesc(true).setIsDesc(true).build();
        Intrinsics.checkNotNullExpressionValue(sortParamBuild, "build(...)");
        return sortParamBuild;
    }

    @JvmStatic
    public static /* synthetic */ void getDeleteSortParam$annotations() {
    }

    @JvmStatic
    public static final long getFromTime(int timeFilter) {
        if (timeFilter == 0) {
            return INSTANCE.getTimeInMillis(1);
        }
        if (timeFilter == 1) {
            return INSTANCE.getTimeInMillis(7);
        }
        if (timeFilter != 2) {
            return 0L;
        }
        return INSTANCE.getTimeInMillis(30);
    }

    @NotNull
    public static final String getLastSelectedFolder() {
        String string = SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getString(NotesConstants.KEY_FOLDER_UUID, "");
        MainLogger.m7258i(TAG, "getLastSelectedFolder# folderUuid : " + string);
        if (TextUtils.isEmpty(string)) {
            string = FolderConstants.AllNotes.UUID;
        }
        Intrinsics.checkNotNull(string);
        return string;
    }

    @JvmStatic
    public static /* synthetic */ void getLastSelectedFolder$annotations() {
    }

    public static final int getOrderType() {
        return SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getInt(NotesConstants.KEY_ORDER_BY, 5);
    }

    @JvmStatic
    public static /* synthetic */ void getOrderType$annotations() {
    }

    public static final boolean getPreferenceMDESupported() {
        boolean z = SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getBoolean(NotesConstants.KEY_MDE_FEATURE_ENABLED, true);
        AbstractC6670b.m4739D("getPreferenceMDESupported result : ", TAG, z);
        return z;
    }

    @JvmStatic
    public static /* synthetic */ void getPreferenceMDESupported$annotations() {
    }

    @NotNull
    public static final SortParam getRecentlyImportedSortParam() {
        SortParam sortParamBuild = new SortParam.SortParamBuilder().setSortType(5).setIsDesc(true).build();
        Intrinsics.checkNotNullExpressionValue(sortParamBuild, "build(...)");
        return sortParamBuild;
    }

    @JvmStatic
    public static /* synthetic */ void getRecentlyImportedSortParam$annotations() {
    }

    @JvmStatic
    @NotNull
    public static final CharSequence getRecommendedTitle(@NotNull Context context, @Nullable AutoTitleCreator.CreationPriority recommendedType, @NotNull CharSequence recommendedTitle, long createdTime) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recommendedTitle, "recommendedTitle");
        if (recommendedType != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[recommendedType.ordinal()];
            if (i == 1) {
                String string = context.getString(C8003R.string.noteslist_title_voice_recording_ps, getTitleTime(createdTime));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                return string;
            }
            if (i == 2) {
                String string2 = context.getString(C8003R.string.noteslist_title_image_ps, getTitleTime(createdTime));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            if (i == 3) {
                String string3 = context.getString(C8003R.string.noteslist_title_drawing_ps, getTitleTime(createdTime));
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                return string3;
            }
            if (i == 4) {
                String string4 = context.getString(C8003R.string.noteslist_title_table_ps, getTitleTime(createdTime));
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                return string4;
            }
        }
        return recommendedTitle;
    }

    @NotNull
    public static final SortParam getSOMRecognizedCardSortParam() {
        SortParam sortParamBuild = new SortParam.SortParamBuilder().setSortType(2).setLastSortTimeType(2).setIsDesc(NotesConstants.Sort.isDescType(5)).setLastIsDesc(NotesConstants.Sort.isDescType(5)).build();
        Intrinsics.checkNotNullExpressionValue(sortParamBuild, "build(...)");
        return sortParamBuild;
    }

    @JvmStatic
    public static /* synthetic */ void getSOMRecognizedCardSortParam$annotations() {
    }

    @NotNull
    public static final SortParam getSortParam() {
        int sortType = getSortType();
        int orderType = getOrderType();
        SortParam sortParamBuild = new SortParam.SortParamBuilder().setSortType(sortType).setLastSortTimeType(sortType).setIsDesc(NotesConstants.Sort.isDescType(orderType)).setLastIsDesc(NotesConstants.Sort.isDescType(orderType)).setIsPinFavorite(isPinFavorites()).build();
        Intrinsics.checkNotNullExpressionValue(sortParamBuild, "build(...)");
        return sortParamBuild;
    }

    @JvmStatic
    public static /* synthetic */ void getSortParam$annotations() {
    }

    public static final int getSortType() {
        return SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getInt(NotesConstants.KEY_SORT_BY, 2);
    }

    @JvmStatic
    public static /* synthetic */ void getSortType$annotations() {
    }

    @NotNull
    public static final SortParam getSpaceSortParam() {
        int sortType = getSortType();
        int orderType = getOrderType();
        SortParam sortParamBuild = new SortParam.SortParamBuilder().setSortType(sortType).setLastSortTimeType(sortType).setIsDesc(NotesConstants.Sort.isDescType(orderType)).setLastIsDesc(NotesConstants.Sort.isDescType(orderType)).setIsPinFavorite(false).build();
        Intrinsics.checkNotNullExpressionValue(sortParamBuild, "build(...)");
        return sortParamBuild;
    }

    @JvmStatic
    public static /* synthetic */ void getSpaceSortParam$annotations() {
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final SpenWNote getSpenWNote(@Nullable Context context, @NotNull String docPath, boolean isCoEditMode) {
        Intrinsics.checkNotNullParameter(docPath, "docPath");
        return INSTANCE.getSpenWNote(context, docPath, isCoEditMode, DocumentFileUtil.getSize(docPath, isCoEditMode ? DocumentFileUtil.DocumentFileSizeType.CoEdit : DocumentFileUtil.DocumentFileSizeType.Document, 0).getWidth());
    }

    @JvmStatic
    @WorkerThread
    @Nullable
    public static final SpenWNote getSpenWNoteForExportOffice(@Nullable Context context, @Nullable String docPath, boolean isCoeditMode) {
        return INSTANCE.getSpenWNote(context, docPath, isCoeditMode, SpenDocumentDisplayUtils.getScreenWidth(context));
    }

    private final long getTimeInMillis(int timeFilter) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        calendar.add(6, -timeFilter);
        return calendar.getTimeInMillis();
    }

    @JvmStatic
    @NotNull
    public static final String getTitleTime(long createdAt) {
        return LocaleUtils.getTitleTime(createdAt);
    }

    @JvmStatic
    public static final long getToTime(int timeFilter, long currentSystemTime) {
        if (timeFilter == 0) {
            return INSTANCE.getTimeInMillis(0);
        }
        if (timeFilter == 1 || timeFilter == 2) {
            return currentSystemTime;
        }
        return 0L;
    }

    @JvmStatic
    @NotNull
    public static final Point getTouchPositionFromDragEvent(@NotNull View item, @NotNull DragEvent e) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(e, "e");
        int[] iArr = new int[2];
        item.getLocationInWindow(iArr);
        return new Point(MathKt.roundToInt(e.getX()) + iArr[0], MathKt.roundToInt(e.getY()) + iArr[1]);
    }

    @JvmStatic
    public static final boolean hasMsSyncIcon(@NotNull NotesFolder folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        return AbstractC6784f.f4180a.f4186f && C0158a.m407a().m416i() && folder.isSyncWithMS() != 0;
    }

    @JvmStatic
    public static final void initPreferenceMDESupported() {
        setPreferenceMDESupported(false);
    }

    @JvmStatic
    public static final boolean isCoeditFeatureEnabled(@Nullable Context context) {
        if (DeviceUtils.isOldSepLiteModel() || !C0158a.m412j(context)) {
            return false;
        }
        return C0158a.m408b(context);
    }

    @JvmStatic
    public static final boolean isDeletableWithoutVerify(int lockType) {
        return lockType == 0 || lockType == 2 || lockType == 3 || lockType == 4;
    }

    @JvmStatic
    public static final boolean isExceedBundleSize(@Nullable Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        long bundleSize = INSTANCE.getBundleSize(bundle);
        if (bundleSize > 409600) {
            MainLogger.m7255e(TAG, "isExceedBundleSize true : " + bundleSize);
            return true;
        }
        MainLogger.m7258i(TAG, "isExceedBundleSize false : " + bundleSize);
        return false;
    }

    @JvmStatic
    public static final boolean isGridLayout(int layoutMode) {
        return (layoutMode & 4) > 0;
    }

    @JvmStatic
    public static final boolean isLinearLayout(int layoutMode) {
        return (layoutMode & 1) > 0;
    }

    @JvmStatic
    public static final boolean isLock(int lockType) {
        return lockType == -2 || lockType > 0;
    }

    @JvmStatic
    public static final int isLockedNotes(@NotNull String[] uuidList) {
        Intrinsics.checkNotNullParameter(uuidList, "uuidList");
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        NotesLockDocumentRepository notesLockDocumentRepositoryCreateNotesLockDocumentRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createNotesLockDocumentRepository();
        Intrinsics.checkNotNullExpressionValue(notesLockDocumentRepositoryCreateNotesLockDocumentRepository, "createNotesLockDocumentRepository(...)");
        for (String str : uuidList) {
            int lockType = notesLockDocumentRepositoryCreateNotesLockDocumentRepository.getLockType(str);
            if (!LockUtils.isUnLockedDocType(lockType)) {
                return lockType;
            }
        }
        return 0;
    }

    public static final boolean isMDEFeatureEnabled() {
        if (PostLaunchManager.INSTANCE.getInstance().hasBaseLogic(1)) {
            MainLogger.m7258i(TAG, "isMDEFeatureEnabled saved value return");
            return SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getBoolean(NotesConstants.KEY_MDE_FEATURE_ENABLED, false);
        }
        boolean zM415h = C0158a.m407a().m415h();
        setPreferenceMDESupported(zM415h);
        return zM415h;
    }

    @JvmStatic
    public static /* synthetic */ void isMDEFeatureEnabled$annotations() {
    }

    public static final boolean isMsSyncSupported() {
        return !SettingsCompat.INSTANCE.getInstance().isUPSM(BaseUtils.getApplicationContext()) && DeviceUtils.isSupportedSync(C0158a.m407a().f492a) && C0158a.m407a().m416i();
    }

    @JvmStatic
    public static /* synthetic */ void isMsSyncSupported$annotations() {
    }

    @JvmStatic
    public static final boolean isNeedToDeletePermanently(int modeIndex) {
        MainLogger.m7258i(TAG, "isNeedToDeletePermanently modeIndex : " + modeIndex);
        return FeatureUtils.isRecyclebinMode(modeIndex) || FeatureUtils.isOldMode(modeIndex);
    }

    public static final boolean isOpenedTrashByOtherApps() {
        if (!mIsOpenedTrashByOtherApps) {
            return false;
        }
        mIsOpenedTrashByOtherApps = false;
        return true;
    }

    @JvmStatic
    public static /* synthetic */ void isOpenedTrashByOtherApps$annotations() {
    }

    public static final boolean isPinFavorites() {
        return SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getBoolean(NotesConstants.KEY_PIN_FAVORITES, false);
    }

    @JvmStatic
    public static /* synthetic */ void isPinFavorites$annotations() {
    }

    @JvmStatic
    public static final boolean isStaggeredGridLayout(int layoutMode) {
        return (layoutMode & 2) > 0;
    }

    @JvmStatic
    public static final boolean isSyncNotSupported(long syncState) {
        return (syncState & 512) == 512;
    }

    @JvmStatic
    public static final boolean isTabletLayout(@Nullable Context context) {
        return ResourceUtils.isTabletLayout(context);
    }

    @JvmStatic
    public static final boolean isWarning(int corrupted) {
        return (corrupted & 1) > 0;
    }

    @JvmStatic
    public static final boolean needToHidePickDisplayData(int caller, @NotNull String currentFolderUuid, @Nullable MainListDocumentData documentData) {
        Intrinsics.checkNotNullParameter(currentFolderUuid, "currentFolderUuid");
        if (documentData != null) {
            return UUIDUtils.isGenUuid(documentData.getUuid()) || UUIDUtils.isDynamicTemplateUuid(documentData.getUuid()) || FeatureUtils.needToHideDisplayData(caller, documentData) || isWarning(documentData.getCorrupted()) || !(Intrinsics.areEqual(currentFolderUuid, FolderConstants.AllNotes.UUID) || Intrinsics.areEqual(documentData.getCategoryUuid(), currentFolderUuid));
        }
        MainLogger.m7255e(TAG, "needToHidePickDisplayData documentData is null");
        return true;
    }

    @JvmStatic
    public static final void openTrashByOtherApps() {
        mIsOpenedTrashByOtherApps = true;
    }

    public static final void setLastSelectedFolder(@NotNull String folderUuid) {
        Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
        MainLogger.m7254d(TAG, "setLastSelectedFolder# folderUuid : " + folderUuid);
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putString(NotesConstants.KEY_FOLDER_UUID, folderUuid);
    }

    public static final void setOrderType(int i) {
        AbstractC8014b.m7201c(i, "setOrderType : ", TAG);
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putInt(NotesConstants.KEY_ORDER_BY, i);
    }

    public static final void setPinFavorites(boolean z) {
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putBoolean(NotesConstants.KEY_PIN_FAVORITES, z);
    }

    private static final void setPreferenceMDESupported(boolean z) {
        AbstractC6670b.m4739D("setPreferenceMDESupported : ", TAG, z);
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putBoolean(NotesConstants.KEY_MDE_FEATURE_ENABLED, z);
    }

    public static final void setSortType(int i) {
        AbstractC8014b.m7201c(i, "setSortType : ", TAG);
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putInt(NotesConstants.KEY_SORT_BY, i);
    }

    public final void backToNoteList(@Nullable WeakReference<Activity> activityRef, @NotNull Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (activityRef == null) {
            return;
        }
        Activity activity = activityRef.get();
        Intrinsics.checkNotNull(activity);
        backToNoteList(activity, data);
        activityRef.clear();
    }

    @WorkerThread
    @Nullable
    public final SpenSDoc getSpenSDoc(@Nullable Context context, @Nullable String docPath) {
        Object objM22215constructorimpl;
        SpenSDoc spenSDoc;
        SpenSDoc spenSDoc2 = null;
        if (context == null || !CommonUtil.initSpenSdk(context)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            spenSDoc = new SpenSDoc(context, docPath, (String) null, (String[]) null);
            try {
                objM22215constructorimpl = Result.m22215constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                th = th;
                spenSDoc2 = spenSDoc;
                Result.Companion companion2 = Result.INSTANCE;
                objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                spenSDoc = spenSDoc2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(objM22215constructorimpl);
        if (thM22218exceptionOrNullimpl != null && ((thM22218exceptionOrNullimpl instanceof IOException) || (thM22218exceptionOrNullimpl instanceof SpenSDocUnsupportedFileException) || (thM22218exceptionOrNullimpl instanceof SpenSDocInvalidPasswordException) || (thM22218exceptionOrNullimpl instanceof SpenSDocUnsupportedVersionException) || (thM22218exceptionOrNullimpl instanceof RuntimeException))) {
            AbstractC6670b.m4738C("getSpenSDoc, e : ", thM22218exceptionOrNullimpl.getMessage(), TAG);
        }
        return spenSDoc;
    }

    @WorkerThread
    @Nullable
    public final SpenWordDocument getSpenWordDocument(@Nullable Context context, @Nullable String docPath, boolean isCoEdit) {
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(docPath)) {
            MainLogger.m7255e(TAG, "getSpenWordDocument, docPath isEmpty");
            return null;
        }
        if (!FileUtils.exists(docPath)) {
            MainLogger.m7255e(TAG, "getSpenWordDocument, docPath not exists");
            return null;
        }
        if (!CommonUtil.initSpenSdk(context)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
            Intrinsics.checkNotNull(docPath);
            return documentFileManager.openWordDocument(context, docPath, 1080, 5000, true, isCoEdit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(Result.m22215constructorimpl(ResultKt.createFailure(th)));
            if (thM22218exceptionOrNullimpl != null && ((thM22218exceptionOrNullimpl instanceof IOException) || (thM22218exceptionOrNullimpl instanceof SpenUnsupportedTypeException) || (thM22218exceptionOrNullimpl instanceof SpenUnsupportedVersionException) || (thM22218exceptionOrNullimpl instanceof RuntimeException))) {
                AbstractC6670b.m4738C("getSpenWordDocument, e : ", thM22218exceptionOrNullimpl.getMessage(), TAG);
            }
            return null;
        }
    }

    public final void backToNoteList(@NotNull Activity activity, @NotNull Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        Class<?> noteListClass = NoteListAccessHandler.getNoteListClass();
        if (noteListClass == null) {
            MainLogger.m7258i(TAG, "backToNoteList(), class is null");
            return;
        }
        MainLogger.m7258i(TAG, "backToNoteList()");
        data.setClass(activity, noteListClass);
        data.setFlags(335544320);
        MultiTaskManager.INSTANCE.getInstance().startActivityOfSameTask(activity, data);
    }

    @WorkerThread
    @Nullable
    public final SpenWNote getSpenWNote(@Nullable Context context, @Nullable String docPath, boolean isCoeditMode, int width) {
        if (context == null) {
            MainLogger.m7255e(TAG, "getSpenWNote, context is null");
            return null;
        }
        if (TextUtils.isEmpty(docPath)) {
            MainLogger.m7255e(TAG, "getSpenWNote, docPath isEmpty");
            return null;
        }
        if (!FileUtils.exists(docPath)) {
            MainLogger.m7255e(TAG, "getSpenWNote, docPath not exists");
            return null;
        }
        if (!CommonUtil.initSpenSdk(context)) {
            MainLogger.m7255e(TAG, "getSpenWNote, fail to initialize sdk");
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            DocumentFileManager documentFileManager = DocumentFileManager.getInstance();
            Intrinsics.checkNotNull(docPath);
            return documentFileManager.open(context, docPath, width, 5000, true, true, isCoeditMode);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Throwable thM22218exceptionOrNullimpl = Result.m22218exceptionOrNullimpl(Result.m22215constructorimpl(ResultKt.createFailure(th)));
            if (thM22218exceptionOrNullimpl != null && ((thM22218exceptionOrNullimpl instanceof IOException) || (thM22218exceptionOrNullimpl instanceof SpenUnsupportedTypeException) || (thM22218exceptionOrNullimpl instanceof SpenUnsupportedVersionException) || (thM22218exceptionOrNullimpl instanceof RuntimeException))) {
                AbstractC6670b.m4738C("getSpenWNote# e : ", thM22218exceptionOrNullimpl.getMessage(), TAG);
            }
            return null;
        }
    }
}
