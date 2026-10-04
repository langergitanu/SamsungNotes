package com.samsung.android.support.senl.addons.brush.view;

import android.R;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.fragment.app.FragmentActivity;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.settings.external.ExternalSettingsProvider;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.model.instance.IInstanceModel;
import com.samsung.android.support.senl.addons.base.utils.FileUtils;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.addons.base.utils.TabletUtil;
import com.samsung.android.support.senl.addons.base.view.common.IBindHelper;
import com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView;
import com.samsung.android.support.senl.addons.base.viewmodel.IActivityLifeCycleObserver;
import com.samsung.android.support.senl.addons.brush.model.BrushModel;
import com.samsung.android.support.senl.addons.brush.model.canvas.BrushSaveModel;
import com.samsung.android.support.senl.addons.brush.model.feature.ISupportedFeature;
import com.samsung.android.support.senl.addons.brush.model.pen.PenPluginManager;
import com.samsung.android.support.senl.addons.brush.util.SystemLogManager;
import com.samsung.android.support.senl.addons.brush.view.injector.ColorModelInjector;
import com.samsung.android.support.senl.addons.brush.view.injector.MenuSizeInjector;
import com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J(\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\rH\u0016J\u0012\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010)\u001a\u00020\rH\u0002J\b\u0010*\u001a\u00020\u0007H\u0016J\b\u0010+\u001a\u00020\u0007H\u0002J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u00020\u0007H\u0002J\b\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\u0007H\u0002J\b\u00104\u001a\u00020\rH\u0002J\u0010\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/BrushView;", "Lcom/samsung/android/support/senl/addons/base/view/fragmentbase/BaseFragmentView;", "<init>", "()V", "mBindHelper", "Lcom/samsung/android/support/senl/addons/brush/view/BrushBindHelper;", "mIsTablet", "", "createModel", "Lcom/samsung/android/support/senl/addons/base/model/instance/IInstanceModel;", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreateContextMenu", ExternalSettingsProvider.EXTRA_MENU, "Landroid/view/ContextMenu;", VPathDataCmd.RCurveTo, "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "getContextMenuId", "", "resId", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "bindingViewModel", "Lcom/samsung/android/support/senl/addons/base/view/common/IBindHelper;", "model", "onResume", "onDestroy", "mIsContextMenuRegistered", "createContextMenu", "root", "releaseContextMenu", "requestChangeView", "changeViewType", "updateViewType", "changeMenu", "coverView", Constants.IntentExtraValue.SHOW, "mRotationSettingObserver", "Landroid/database/ContentObserver;", "initRotation", "isAutoRotateEnabled", "closeRotation", "requestFinish", "isSaved", "Companion", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BrushView extends BaseFragmentView {

    @NotNull
    private static final String TAG_PERFORMANCE = "BrushPerformance";
    private static final int VIEW_CONVERTING_COVER_VIEW = 1;
    private static final int VIEW_CONVERTING_PENDING_SAVE = 0;
    public static final int VIEW_CONVERTING_RECREATE_MENU_ONLY = 3;
    public static final int VIEW_CONVERTING_RECREATE_VIEW_ONLY = 2;

    @Nullable
    private BrushBindHelper mBindHelper;
    private boolean mIsContextMenuRegistered;
    private boolean mIsTablet;

    @Nullable
    private ContentObserver mRotationSettingObserver;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = Logger.createTag("BrushView");
    private static int VIEW_CONVERTING_TYPE = 3;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/view/BrushView$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "TAG_PERFORMANCE", "VIEW_CONVERTING_PENDING_SAVE", "", "VIEW_CONVERTING_COVER_VIEW", "VIEW_CONVERTING_RECREATE_VIEW_ONLY", "VIEW_CONVERTING_RECREATE_MENU_ONLY", "VIEW_CONVERTING_TYPE", "getVIEW_CONVERTING_TYPE", "()I", "setVIEW_CONVERTING_TYPE", "(I)V", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return BrushView.TAG;
        }

        public final int getVIEW_CONVERTING_TYPE() {
            return BrushView.VIEW_CONVERTING_TYPE;
        }

        public final void setVIEW_CONVERTING_TYPE(int i) {
            BrushView.VIEW_CONVERTING_TYPE = i;
        }

        private Companion() {
        }
    }

    private final void changeMenu() {
        if (getMModel() != null) {
            BrushBindHelper brushBindHelper = this.mBindHelper;
            if (brushBindHelper != null) {
                IInstanceModel mModel = getMModel();
                Intrinsics.checkNotNull(mModel);
                brushBindHelper.updateLayouts(mModel, new MenuSizeInjector(getContext()));
            }
            SystemLogManager.INSTANCE.updateLogManager();
        }
    }

    private final boolean changeViewType() {
        TabletUtil.INSTANCE.checkTabletMode(getActivity());
        boolean zIsTabletUi = TabletUtil.isTabletUi();
        boolean z = this.mIsTablet;
        if (zIsTabletUi == z) {
            return false;
        }
        Logger.m7100d(TAG, "UI mode is changed " + z + " to " + zIsTabletUi);
        this.mIsTablet = zIsTabletUi;
        updateViewType();
        return true;
    }

    private final void closeRotation() {
        if (!ISupportedFeature.INSTANCE.getSUPPORT_LOCK_ROTATION() || this.mRotationSettingObserver == null) {
            return;
        }
        enableRotation(false);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ContentResolver contentResolver = activity.getContentResolver();
        ContentObserver contentObserver = this.mRotationSettingObserver;
        Intrinsics.checkNotNull(contentObserver);
        contentResolver.unregisterContentObserver(contentObserver);
    }

    private final void coverView(boolean show) {
        View view = getView();
        if (view != null) {
            view.setForeground(show ? getResources().getDrawable(C7944R.drawable.brush_blind_drawable, null) : null);
            view.invalidate();
        }
    }

    private final void createContextMenu(View root) {
        View viewFindViewById = root != null ? root.findViewById(C7944R.id.brush_canvas_container) : null;
        if (!DesktopModeCompat.INSTANCE.getInstance().isDexMode(getContext()) || viewFindViewById == null || this.mIsContextMenuRegistered) {
            return;
        }
        registerForContextMenu(viewFindViewById);
        this.mIsContextMenuRegistered = true;
    }

    private final void initRotation() {
        if (!ISupportedFeature.INSTANCE.getSUPPORT_LOCK_ROTATION()) {
            Logger.m7100d(TAG, "Rotation feature is off...");
            return;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        ContentResolver contentResolver = activity.getContentResolver();
        Uri uriFor = Settings.System.getUriFor("accelerometer_rotation");
        ContentObserver contentObserver = new ContentObserver() { // from class: com.samsung.android.support.senl.addons.brush.view.BrushView.initRotation.1
            {
                super(null);
            }

            @Override // android.database.ContentObserver
            public boolean deliverSelfNotifications() {
                return true;
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                boolean zIsAutoRotateEnabled = BrushView.this.isAutoRotateEnabled();
                AbstractC6670b.m4764y("Auto rotation is enabled ? - ", BrushView.INSTANCE.getTAG(), zIsAutoRotateEnabled);
                BrushView.this.enableRotation(!zIsAutoRotateEnabled);
            }
        };
        this.mRotationSettingObserver = contentObserver;
        try {
            Intrinsics.checkNotNull(contentObserver);
            contentResolver.registerContentObserver(uriFor, false, contentObserver);
            enableRotation(!isAutoRotateEnabled());
        } catch (SecurityException unused) {
            Logger.m7105w(TAG, "Failed registering observer for rotation. Rotation is not enabled.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAutoRotateEnabled() {
        if (getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        return Settings.System.getInt(activity.getContentResolver(), "accelerometer_rotation", 0) == 1;
    }

    private final void releaseContextMenu() {
        View viewFindViewById;
        View view = getView();
        if (!this.mIsContextMenuRegistered || view == null || (viewFindViewById = view.findViewById(C7944R.id.brush_canvas_container)) == null) {
            return;
        }
        unregisterForContextMenu(viewFindViewById);
        this.mIsContextMenuRegistered = false;
    }

    private final void updateViewType() {
        int i = VIEW_CONVERTING_TYPE;
        if (i == 0) {
            IInstanceModel mModel = getMModel();
            if (mModel != null) {
                mModel.pendingSaveForRecreatedView();
            }
        } else if (i == 1) {
            coverView(true);
        } else if (i == 2) {
            IInstanceModel mModel2 = getMModel();
            if (mModel2 != null) {
                mModel2.pendingSaveForRecreatedView();
            }
            coverView(true);
        } else if (i == 3) {
            changeMenu();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.recreate();
        }
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView
    @Nullable
    public IBindHelper bindingViewModel(@Nullable IInstanceModel model, @Nullable LayoutInflater inflater, @Nullable ViewGroup container) {
        Logger.m7100d(TAG, "bindingViewModel - " + Integer.toHexString(hashCode()));
        updateWindowSize();
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity);
        IInstanceModel mModel = getMModel();
        Intrinsics.checkNotNull(mModel);
        BrushBindHelper brushBindHelper = new BrushBindHelper(activity, mModel, inflater, container);
        this.mBindHelper = brushBindHelper;
        IActivityLifeCycleObserver lifeCycleObserver = brushBindHelper.getMLifeCycleObserver();
        Intrinsics.checkNotNull(lifeCycleObserver);
        setLifeCycleObserver(lifeCycleObserver);
        return this.mBindHelper;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView
    @NotNull
    public IInstanceModel createModel(@Nullable Bundle savedInstanceState) {
        String stringExtra;
        String string;
        String str;
        String str2;
        String stringExtra2;
        String stringExtra3;
        PenPluginManager.INSTANCE.initialize(new SpenPenManager(BaseUtils.getApplicationContext()));
        ColorModelInjector colorModelInjector = new ColorModelInjector(getContext());
        boolean z = savedInstanceState != null;
        BrushModel brushModel = new BrushModel(getMSDataHandler(), colorModelInjector, z);
        if (z && savedInstanceState != null) {
            stringExtra3 = savedInstanceState.getString("brush_output_painting_doc_path");
            String string2 = savedInstanceState.getString("brush_output_thumbnail_path");
            String string3 = savedInstanceState.getString("internal_path");
            Intrinsics.checkNotNull(stringExtra3);
            stringExtra = FileUtils.isExistedFile(stringExtra3) ? stringExtra3 : savedInstanceState.getString("brush_input_painting_doc_path");
            Intrinsics.checkNotNull(string2);
            stringExtra2 = string3;
            str2 = string2;
            string = FileUtils.isExistedFile(string2) ? string2 : savedInstanceState.getString("brush_input_thumbnail_path");
        } else {
            if (getActivity() == null) {
                stringExtra = null;
                string = null;
                str = null;
                str2 = null;
                stringExtra2 = null;
                brushModel.setPathInfo(stringExtra, string, str, str2, stringExtra2);
                String str3 = TAG;
                Logger.m7100d(str3, "createModel. false");
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                AbstractC6670b.m4763x("createModel. test ", activity.getIntent().getStringExtra("brush_output_painting_doc_path"), str3);
                return brushModel;
            }
            FragmentActivity activity2 = getActivity();
            Intrinsics.checkNotNull(activity2);
            Intent intent = activity2.getIntent();
            stringExtra = intent.getStringExtra("brush_input_painting_doc_path");
            String stringExtra4 = intent.getStringExtra("brush_input_thumbnail_path");
            stringExtra3 = intent.getStringExtra("brush_output_painting_doc_path");
            String stringExtra5 = intent.getStringExtra("brush_output_thumbnail_path");
            stringExtra2 = intent.getStringExtra("internal_path");
            str2 = stringExtra5;
            string = stringExtra4;
        }
        str = stringExtra3;
        brushModel.setPathInfo(stringExtra, string, str, str2, stringExtra2);
        String str32 = TAG;
        Logger.m7100d(str32, "createModel. false");
        FragmentActivity activity3 = getActivity();
        Intrinsics.checkNotNull(activity3);
        AbstractC6670b.m4763x("createModel. test ", activity3.getIntent().getStringExtra("brush_output_painting_doc_path"), str32);
        return brushModel;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView
    public int getContextMenuId(int resId) {
        if (resId == C7944R.id.brush_undo_btn) {
            Logger.m7100d(TAG, "onContextItemSelected brush_undo");
            return 3002;
        }
        if (resId != C7944R.id.brush_redo_btn) {
            return 3001;
        }
        Logger.m7100d(TAG, "onContextItemSelected brush_redo");
        return 3003;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        changeViewType();
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.m7100d(TAG_PERFORMANCE, "onCreate start");
        String str = TAG;
        Logger.m7100d(str, "onCreate : " + Integer.toHexString(hashCode()));
        Logger.m7100d(str, "onCreate, savedInstanceState: " + savedInstanceState);
        TabletUtil.INSTANCE.checkTabletMode(getActivity());
        this.mIsTablet = TabletUtil.isTabletUi();
    }

    @Override // androidx.fragment.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(@NotNull ContextMenu menu, @NotNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(v, "v");
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem menuItemAdd = menu.add(0, C7944R.id.brush_undo_btn, 0, C7944R.string.base_string_undo);
        Intrinsics.checkNotNullExpressionValue(menuItemAdd, "add(...)");
        MenuItem menuItemAdd2 = menu.add(0, C7944R.id.brush_redo_btn, 0, C7944R.string.base_string_redo);
        Intrinsics.checkNotNullExpressionValue(menuItemAdd2, "add(...)");
        IActivityLifeCycleObserver mLifeCycleObserver = getMLifeCycleObserver();
        Intrinsics.checkNotNull(mLifeCycleObserver, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel");
        menuItemAdd.setEnabled(((BrushMainViewModel) mLifeCycleObserver).getSubMenuViewModel().getUndoEnabled());
        IActivityLifeCycleObserver mLifeCycleObserver2 = getMLifeCycleObserver();
        Intrinsics.checkNotNull(mLifeCycleObserver2, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.viewmodel.BrushMainViewModel");
        menuItemAdd2.setEnabled(((BrushMainViewModel) mLifeCycleObserver2).getSubMenuViewModel().getRedoEnabled());
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        String str = TAG;
        Logger.m7100d(str, "onCreateView");
        View viewOnCreateView = super.onCreateView(inflater, container, savedInstanceState);
        if (getActivity() != null) {
            int[] iArr = new int[2];
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            activity.findViewById(R.id.content).getLocationInWindow(iArr);
            AbstractC6670b.m4761v(iArr[1], "onCreateView, y offset is : ", str);
        }
        createContextMenu(viewOnCreateView);
        initRotation();
        return viewOnCreateView;
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mBindHelper = null;
        if (getMLifeCycleObserver() != null) {
            IActivityLifeCycleObserver mLifeCycleObserver = getMLifeCycleObserver();
            Intrinsics.checkNotNull(mLifeCycleObserver);
            mLifeCycleObserver.onDestroy();
            setMLifeCycleObserver(null);
        }
        super.onDestroy();
        AbstractC6670b.m4763x("onDestroy : ", Integer.toHexString(hashCode()), TAG);
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Logger.m7100d(TAG, "onDestroyView");
        releaseContextMenu();
        closeRotation();
        super.onDestroyView();
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        coverView(false);
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public boolean requestChangeView() {
        return changeViewType();
    }

    @Override // com.samsung.android.support.senl.addons.base.view.fragmentbase.BaseFragmentView, com.samsung.android.support.senl.addons.base.model.ILifeCycleController
    public void requestFinish(boolean isSaved) {
        String str = TAG;
        Logger.m7100d(str, "requestFinish. " + isSaved);
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity);
            Intent intent = activity.getIntent();
            IInstanceModel mModel = getMModel();
            Intrinsics.checkNotNull(mModel, "null cannot be cast to non-null type com.samsung.android.support.senl.addons.brush.model.BrushModel");
            BrushSaveModel saveModel = ((BrushModel) mModel).getMSaveModel();
            if (saveModel == null) {
                super.requestFinish(isSaved);
                return;
            }
            String inputThumbnailPath = saveModel.getMInputThumbnailPath();
            String outputThumbnailPath = saveModel.getMOutputThumbnailPath();
            String inputPaintingDocPath = saveModel.getMInputPaintingDocPath();
            String outputPaintingDocPath = saveModel.getMOutputPaintingDocPath();
            if (isSaved || ((outputPaintingDocPath == null && outputThumbnailPath == null) || (outputPaintingDocPath != null && AbstractC2322a.m1607A(outputPaintingDocPath) && outputThumbnailPath != null && AbstractC2322a.m1607A(outputThumbnailPath)))) {
                intent.putExtra("brush_input_painting_doc_path", inputPaintingDocPath);
                intent.putExtra("brush_output_painting_doc_path", outputPaintingDocPath);
                intent.putExtra("brush_input_thumbnail_path", inputThumbnailPath);
                intent.putExtra("brush_output_thumbnail_path", outputThumbnailPath);
                Logger.m7100d(str, "requestFinish. thumbnailPath. " + Logger.getEncode(inputThumbnailPath) + SQLKeyword.COMMA + Logger.getEncode(outputThumbnailPath));
                Logger.m7100d(str, "requestFinish. paintingDocPath. " + Logger.getEncode(inputPaintingDocPath) + SQLKeyword.COMMA + Logger.getEncode(outputPaintingDocPath));
                requestSetResult(-1, intent);
            } else {
                requestSetResult(0, intent);
            }
        }
        super.requestFinish(isSaved);
    }
}
