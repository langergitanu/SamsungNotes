package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsetsController;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.p109ui.graphics.Color;
import androidx.compose.p109ui.graphics.ColorKt;
import androidx.core.graphics.Insets;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.SemBlurCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.material.snackbar.C4892a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7004e;
import com.samsung.android.app.notes.widget.glance.single.setting.view.ViewOnTouchListenerC7005f;
import com.samsung.android.app.sdk.deepsky.textextraction.capsule.data.p137ui.C7051a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.DisplayCutoutCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.common.ApplicationManager;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.TemplateViewType;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.common.util.ButtonBackgroundUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.SystemUi;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.cover.AiCoverDataCreatorManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.NoteStyleConfirmDialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.presenter.CoverStylePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.util.CoverStyleUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.util.p158sa.SAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.PageTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.QuickToolSA;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.composer.main.cover.presenter.CoverEditorUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001$\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u0002:\u0004\u0080\u0001\u0081\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\u0012\u0010*\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0012\u0010,\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010-\u001a\u00020'H\u0002J\b\u0010.\u001a\u00020'H\u0002J\u0010\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u0016H\u0003J\u0012\u00104\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u00105\u001a\u00020'H\u0003J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020\u0012H\u0002J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020'H\u0002J\u0006\u0010:\u001a\u00020'J\b\u0010;\u001a\u00020\u0012H\u0002J\u0006\u0010<\u001a\u00020'J\u0012\u0010=\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\b\u0010>\u001a\u00020'H\u0002J\b\u0010?\u001a\u00020'H\u0002J\b\u0010@\u001a\u00020\fH\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\u0010\u0010B\u001a\u00020'2\u0006\u0010C\u001a\u00020)H\u0014J\b\u0010D\u001a\u00020'H\u0014J\u0010\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020'H\u0002J\b\u0010I\u001a\u00020'H\u0003J\b\u0010J\u001a\u00020'H\u0002J\b\u0010K\u001a\u00020\u0016H\u0002J\b\u0010L\u001a\u00020\u0016H\u0002J\b\u0010M\u001a\u00020'H\u0002J\u0010\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020\u0016H\u0002J\u000e\u0010P\u001a\u00020\u00162\u0006\u00100\u001a\u000201J\b\u0010Q\u001a\u00020'H\u0002J\u0010\u0010R\u001a\u00020'2\u0006\u0010S\u001a\u00020\u0016H\u0007J\u0006\u0010T\u001a\u00020'J\"\u0010U\u001a\u00020'2\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u000101H\u0014J&\u0010Y\u001a\u00020'2\u0006\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u001f2\u0006\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u001fJ\u0006\u0010^\u001a\u00020'J\u0006\u0010_\u001a\u00020'J\b\u0010`\u001a\u00020'H\u0014J\u001a\u0010a\u001a\u00020'2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010!J\u001a\u0010e\u001a\u00020'2\b\u0010b\u001a\u0004\u0018\u00010c2\b\u0010d\u001a\u0004\u0018\u00010!J\b\u0010f\u001a\u00020'H\u0016J\b\u0010g\u001a\u00020'H\u0002J\u0010\u0010h\u001a\u00020'2\u0006\u0010i\u001a\u00020jH\u0002J\u0010\u0010k\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0014J\b\u0010l\u001a\u00020\u0016H\u0002J\b\u0010m\u001a\u00020'H\u0002J\b\u0010n\u001a\u00020'H\u0002J\b\u0010o\u001a\u00020'H\u0002J\b\u0010p\u001a\u00020\u0016H\u0002J\b\u0010q\u001a\u00020'H\u0002J\u000e\u0010r\u001a\u00020'2\u0006\u0010s\u001a\u00020\u0012J\u0006\u0010t\u001a\u00020'J\u0018\u0010u\u001a\u00020'2\u0006\u0010v\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020\u001fH\u0002J\u0018\u0010x\u001a\u00020'2\u0006\u0010v\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020\u001fH\u0002J\u0018\u0010y\u001a\u00020'2\u0006\u0010v\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020\u001fH\u0002J\u001c\u0010z\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010{j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`|H\u0002J\u0010\u0010}\u001a\u00020\u001f2\u0006\u0010~\u001a\u00020\u001fH\u0002J\u0006\u0010\u007f\u001a\u00020\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%¨\u0006\u0082\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter$Contract;", "<init>", "()V", "mCloseBtn", "Landroid/view/View;", "mConfirm", "Landroid/widget/TextView;", "mNoteStyleLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/NoteStyleLayout;", "mTemplateStyleFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/template/view/common/BaseTemplateStyleFragment;", "mCoverStyleFragment", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/CoverStyleFragment;", "mCoverPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/presenter/CoverStylePresenter;", "mGravity", "", "mType", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "mIsCoeditNote", "", "mPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "mPageThumbnail", "Landroid/graphics/Bitmap;", "mOriginCoverData", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverData;", "mEditedCoverData", "mExtractText", "", "mExtractTextReceiver", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$CoverExtractTextReceiver;", "mIsDismissRequested", "mConfirmDialogCallback", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$mConfirmDialogCallback$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$mConfirmDialogCallback$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "initParams", "initCoverExtractListener", "initCoverData", "initCoverPresenter", "setCoverData", "autoGenerateCover", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "enableEditor", "isEnable", "initLayout", "initContainerLayout", "initTitle", "getTitleRes", "initCloseBtn", "initConfirmBtn", "updateConfirmBtnBg", "getConfirmButtonRes", "updateConfirmBtn", "initNoteStyleLayout", "initTemplateStyleFragment", "initCoverStyleFragment", "getBaseTemplateStyleFragment", "getTemplateFragmentTag", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "onResume", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "initActivityContainer", "updateActivityContainer", "updateBackgroundColor", "isPortraitLayout", "isPopOverSupportLayout", "applyWindowInsetsToContainer", "enableConfirmBtn", "isEnabled", "updateCoverResultIntent", "loggingSACoverChanged", "setAvailableGenerateCover", "isAvailable", "onClickCoverGenerate", "onActivityResult", "requestCode", "resultCode", "data", "onCompleteAndUpdateView", DBSchema.DocumentCover.SUMMARY, "templateUuid", "colorUuid", "stickerUuid", "requestCoverGenerate", "cancelCoverGenerate", "onDestroy", "registerReceiver", "context", "Landroid/content/Context;", "receivedReceiver", "unregisterReceiver", "finish", "showSheet", "dismissSheet", "endAction", "Ljava/lang/Runnable;", "onNewIntent", "isLandscapeLayoutRequired", "setBackPressedListener", "onBackKeyDown", "showConfirmDialogFragment", "needShowDialogFragment", "updateCallbackForDialog", "logPageToApplySA", "pageToApply", "logTemplateStyleSA", "logFabSA", "categoryDetail", "templateDetail", "logPageStyleSA", "logPageSorterSA", "getLoggingDetails", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPdfTemplateDetail", "selectedTemplate", "getType", "CoverExtractTextReceiver", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNoteStyleActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteStyleActivity.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 View.kt\nandroidx/core/view/ViewKt\n+ 5 ColorDrawable.kt\nandroidx/core/graphics/drawable/ColorDrawableKt\n*L\n1#1,1544:1\n37#2:1545\n36#2,3:1546\n1#3:1549\n81#4:1550\n81#4:1551\n28#5:1552\n28#5:1553\n*S KotlinDebug\n*F\n+ 1 NoteStyleActivity.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity\n*L\n149#1:1545\n149#1:1546,3\n1127#1:1550\n1167#1:1551\n1260#1:1552\n1298#1:1553\n*E\n"})
public final class NoteStyleActivity extends AppCompatActivity implements CoverStylePresenter.Contract {

    @NotNull
    public static final String ACTION_EXTRACT_TEXT = "action_extract_text";

    @NotNull
    public static final String ARG_SDOC_UUID = "sdoc_uuid";
    private static final int HEIGHT_FOR_PORTRAIT_NOTE_STYLE = 720;

    @NotNull
    public static final String KEY_EDITED_COVER = "edited_cover";

    @NotNull
    public static final String KEY_EXTRACT_UUID = "extract_uuid";

    @NotNull
    public static final String KEY_ORIGIN_COVER = "origin_cover";

    @NotNull
    public static final String TAG = "NoteStyleActivity";
    private static final int WIDTH_FOR_PORTRAIT_NOTE_STYLE = 400;

    @Nullable
    private View mCloseBtn;

    @Nullable
    private TextView mConfirm;

    @Nullable
    private CoverStylePresenter mCoverPresenter;

    @Nullable
    private CoverStyleFragment mCoverStyleFragment;

    @Nullable
    private CoverData mEditedCoverData;

    @Nullable
    private String mExtractText;

    @Nullable
    private CoverExtractTextReceiver mExtractTextReceiver;
    private int mGravity;
    private boolean mIsCoeditNote;
    private boolean mIsDismissRequested;

    @Nullable
    private NoteStyleLayout mNoteStyleLayout;

    @Nullable
    private CoverData mOriginCoverData;

    @Nullable
    private Bitmap mPageThumbnail;

    @Nullable
    private BaseTemplateStyleFragment mTemplateStyleFragment;

    @NotNull
    private Constant.Type mType = Constant.Type.CREATE_NOTE;

    @NotNull
    private DocumentPageRatio.PageRatioType mPageRatioType = DocumentPageRatio.PageRatioType.A4_PORTRAIT;

    @NotNull
    private final NoteStyleActivity$mConfirmDialogCallback$1 mConfirmDialogCallback = new NoteStyleConfirmDialogFragment.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$mConfirmDialogCallback$1
        @Override // com.samsung.android.support.senl.nt.composer.main.base.view.dialog.NoteStyleConfirmDialogFragment.Callback
        public void onLeave() {
            this.this$0.finish();
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$CoverExtractTextReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "IReceiver", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class CoverExtractTextReceiver extends BroadcastReceiver {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @Nullable
        private static IReceiver mResult;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$CoverExtractTextReceiver$Companion;", "", "<init>", "()V", "mResult", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$CoverExtractTextReceiver$IReceiver;", "setResultListener", "", "resultListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final void setResultListener(@Nullable IReceiver resultListener) {
                Logger.m10999d(NoteStyleActivity.TAG, "CoverExtractTextReceiver# setResultListener");
                CoverExtractTextReceiver.mResult = resultListener;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/NoteStyleActivity$CoverExtractTextReceiver$IReceiver;", "", "onResult", "", "result", "", "noteUuid", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public interface IReceiver {
            void onResult(@Nullable String result, @Nullable String noteUuid);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            Logger.m10999d(NoteStyleActivity.TAG, "CoverExtractTextReceiver# onReceive");
            if (!Intrinsics.areEqual(NoteStyleActivity.ACTION_EXTRACT_TEXT, intent.getAction()) || mResult == null) {
                Logger.m10999d(NoteStyleActivity.TAG, "CoverExtractTextReceiver# return");
                return;
            }
            String stringExtra = intent.getStringExtra(CoverData.KEY_EXTRACT_TEXT);
            String stringExtra2 = intent.getStringExtra(NoteStyleActivity.KEY_EXTRACT_UUID);
            IReceiver iReceiver = mResult;
            if (iReceiver != null) {
                iReceiver.onResult(stringExtra, stringExtra2);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Constant.Type.values().length];
            try {
                iArr[Constant.Type.CREATE_NOTE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Constant.Type.TEMPLATE_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Constant.Type.STYLE_CHANGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Constant.Type.COVER_EDIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Constant.Type.SETTINGS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$setAvailableGenerateCover$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$setAvailableGenerateCover$1", m14021f = "NoteStyleActivity.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C103481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isAvailable;
        int label;
        final /* synthetic */ NoteStyleActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103481(boolean z, NoteStyleActivity noteStyleActivity, Continuation<? super C103481> continuation) {
            super(2, continuation);
            this.$isAvailable = z;
            this.this$0 = noteStyleActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C103481(this.$isAvailable, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoverData coverData;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            AbstractC8014b.m7220v("setAvailableGenerateCover# isAvailable : ", NoteStyleActivity.TAG, this.$isAvailable);
            CoverStylePresenter coverStylePresenter = this.this$0.mCoverPresenter;
            if (coverStylePresenter != null && (coverData = coverStylePresenter.getCoverData()) != null) {
                coverData.setAvailableAutoCover(this.$isAvailable);
            }
            NoteStyleLayout noteStyleLayout = this.this$0.mNoteStyleLayout;
            if (noteStyleLayout != null) {
                noteStyleLayout.updateCoverAIButton(this.$isAvailable);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C103481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private final void applyWindowInsetsToContainer() {
        View viewFindViewById;
        if (Build.VERSION.SDK_INT > 34 && (viewFindViewById = findViewById(C9086R.id.container)) != null) {
            ViewCompat.setOnApplyWindowInsetsListener(viewFindViewById, new C0287e(this, viewFindViewById, 17));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat applyWindowInsetsToContainer$lambda$9$lambda$8(NoteStyleActivity noteStyleActivity, View view, View v, WindowInsetsCompat windowInsets) {
        int iSystemBars;
        int iDisplayCutout;
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        if (noteStyleActivity.isLandscapeLayoutRequired()) {
            iSystemBars = WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout();
            iDisplayCutout = WindowInsetsCompat.Type.ime();
        } else {
            iSystemBars = WindowInsetsCompat.Type.systemBars();
            iDisplayCutout = WindowInsetsCompat.Type.displayCutout();
        }
        Insets insets = windowInsets.getInsets(iSystemBars | iDisplayCutout);
        Intrinsics.checkNotNullExpressionValue(insets, "getInsets(...)");
        view.setPadding(insets.left, insets.top, insets.right, insets.bottom);
        return WindowInsetsCompat.CONSUMED;
    }

    private final void autoGenerateCover(Intent intent) {
        Logger.m10999d(TAG, "autoGenerateCover");
        if (intent.getBooleanExtra(CoverData.KEY_GENERATE_COVER, false) && !TextUtils.isEmpty(this.mExtractText)) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC10350a(this, 2), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void autoGenerateCover$lambda$1(NoteStyleActivity noteStyleActivity) {
        if (!noteStyleActivity.getIntent().getBooleanExtra(CoverData.KEY_GENERATE_COVER, false)) {
            Logger.m10999d(TAG, "autoGenerateCover, ignore, generated by other side");
        } else {
            noteStyleActivity.getIntent().putExtra(CoverData.KEY_GENERATE_COVER, false);
            noteStyleActivity.onClickCoverGenerate();
        }
    }

    private final void dismissSheet(final Runnable endAction) {
        if (this.mIsDismissRequested) {
            return;
        }
        this.mIsDismissRequested = true;
        View viewFindViewById = findViewById(C9086R.id.container);
        View viewFindViewById2 = findViewById(C9086R.id.activity_container);
        if (viewFindViewById == null || viewFindViewById2 == null) {
            endAction.run();
            return;
        }
        float f = ContextUtils.isNightMode(this) ? 0.8f : 0.4f;
        int i = 2;
        if (!isPopOverSupportLayout()) {
            viewFindViewById2.setAlpha(1.0f);
            SpringAnimation springAnimationAddEndListener = new SpringAnimation(viewFindViewById2, DynamicAnimation.TRANSLATION_Y).setSpring(new SpringForce(ResourceUtils.convertDpToPixel(this, 10.0f) + getWindow().getDecorView().getHeight()).setDampingRatio(1.0f).setStiffness(361.0f)).addEndListener(new C4892a(endAction, i));
            ViewPropertyAnimator interpolator = viewFindViewById2.animate().alpha(0.0f).setDuration(350L).setInterpolator(new LinearInterpolator());
            Intrinsics.checkNotNullExpressionValue(interpolator, "setInterpolator(...)");
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, 0.0f);
            valueAnimatorOfFloat.setDuration(350L);
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            valueAnimatorOfFloat.addUpdateListener(new C7051a(viewFindViewById, 5));
            springAnimationAddEndListener.start();
            interpolator.start();
            valueAnimatorOfFloat.start();
            return;
        }
        ViewPropertyAnimator listener = viewFindViewById2.animate().scaleX(0.95f).scaleY(0.95f).setDuration(350L).setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f)).setListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$dismissSheet$scaleAnimator$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                endAction.run();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        Intrinsics.checkNotNullExpressionValue(listener, "setListener(...)");
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat2.setDuration(350L);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new C7051a(viewFindViewById2, 6));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(f, 0.0f);
        valueAnimatorOfFloat3.setDuration(350L);
        valueAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat3.addUpdateListener(new C7051a(viewFindViewById, 7));
        listener.start();
        valueAnimatorOfFloat2.start();
        valueAnimatorOfFloat3.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissSheet$lambda$21$lambda$20(View view, ValueAnimator valueAnimator) {
        view.setAlpha(((Float) AbstractC6670b.m4742c(valueAnimator, "animator", "null cannot be cast to non-null type kotlin.Float")).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissSheet$lambda$23$lambda$22(View view, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setBackground(new ColorDrawable(ColorKt.m18579toArgb8_81llA(ColorKt.Color(0, 0, 0, (int) (((Float) animatedValue).floatValue() * 255)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissSheet$lambda$26$lambda$25(View view, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        Object animatedValue = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setBackground(new ColorDrawable(ColorKt.m18579toArgb8_81llA(ColorKt.Color(0, 0, 0, (int) (((Float) animatedValue).floatValue() * 255)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enableConfirmBtn(boolean isEnabled) {
        AbstractC8014b.m7220v("updateCreateBtn# ", TAG, isEnabled);
        TextView textView = this.mConfirm;
        if (textView != null) {
            textView.setAlpha(isEnabled ? 1.0f : 0.4f);
        }
        TextView textView2 = this.mConfirm;
        if (textView2 != null) {
            textView2.setEnabled(isEnabled);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public final void enableEditor(boolean isEnable) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator interpolator;
        AbstractC8014b.m7220v("enableEditor# ", TAG, isEnable);
        View viewFindViewById = findViewById(C9086R.id.style_container);
        if (viewFindViewById != null && (viewPropertyAnimatorAnimate = viewFindViewById.animate()) != null) {
            ViewPropertyAnimator viewPropertyAnimatorAlpha = viewPropertyAnimatorAnimate.alpha(isEnable ? 1.0f : 0.4f);
            if (viewPropertyAnimatorAlpha != null && (duration = viewPropertyAnimatorAlpha.setDuration(200L)) != null && (interpolator = duration.setInterpolator(new LinearInterpolator())) != null) {
                interpolator.start();
            }
        }
        findViewById(C9086R.id.block_view).setVisibility(isEnable ? 8 : 0);
        findViewById(C9086R.id.block_view).setOnTouchListener(isEnable ? null : new ViewOnTouchListenerC7005f(13));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableEditor$lambda$2(View view, MotionEvent motionEvent) {
        Logger.m10999d(TAG, "enableEditor# touch blocked");
        return true;
    }

    private final BaseTemplateStyleFragment getBaseTemplateStyleFragment() {
        return this.mType == Constant.Type.CREATE_NOTE ? new PickerTemplateStyleFragment() : new PageTemplateStyleFragment();
    }

    private final int getConfirmButtonRes() {
        Constant.Type type = this.mType;
        return (type == Constant.Type.COVER_EDIT || type == Constant.Type.STYLE_CHANGE) ? C9086R.string.note_style_apply_btn : C9086R.string.note_style_create_btn;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final ArrayList<String> getLoggingDetails() {
        BaseTemplateStyleFragment baseTemplateStyleFragment = this.mTemplateStyleFragment;
        Integer selectedTemplateType = baseTemplateStyleFragment != null ? baseTemplateStyleFragment.getSelectedTemplateType() : null;
        BaseTemplateStyleFragment baseTemplateStyleFragment2 = this.mTemplateStyleFragment;
        String selectedTemplate = baseTemplateStyleFragment2 != null ? baseTemplateStyleFragment2.getSelectedTemplate() : null;
        if (selectedTemplateType != null && selectedTemplate != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            if (TemplateViewType.isBasicType(selectedTemplateType.intValue())) {
                arrayList.add("a");
                int iHashCode = selectedTemplate.hashCode();
                if (iHashCode != 1568) {
                    switch (iHashCode) {
                        case 48:
                            if (selectedTemplate.equals("0")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_BLANK);
                                return arrayList;
                            }
                            break;
                        case 49:
                            if (selectedTemplate.equals("1")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_LINED_NARROW);
                                return arrayList;
                            }
                            break;
                        case 50:
                            if (selectedTemplate.equals("2")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_LINED);
                                return arrayList;
                            }
                            break;
                        case 51:
                            if (selectedTemplate.equals("3")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_LINED_WIDE);
                                return arrayList;
                            }
                            break;
                        case 52:
                            if (selectedTemplate.equals("4")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_GRID_NARROW);
                                return arrayList;
                            }
                            break;
                        case 53:
                            if (selectedTemplate.equals("5")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_GRID);
                                return arrayList;
                            }
                            break;
                        case 54:
                            if (selectedTemplate.equals("6")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_GRID_WIDE);
                                return arrayList;
                            }
                            break;
                        case 55:
                            if (selectedTemplate.equals("7")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_DOT_NARROW);
                                return arrayList;
                            }
                            break;
                        case 56:
                            if (selectedTemplate.equals("8")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_DOT);
                                return arrayList;
                            }
                            break;
                        case 57:
                            if (selectedTemplate.equals("9")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_DOT_WIDE);
                                return arrayList;
                            }
                            break;
                    }
                } else if (selectedTemplate.equals(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON)) {
                    arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_OXFORD);
                    return arrayList;
                }
            } else if (TemplateViewType.isAcademicType(selectedTemplateType.intValue())) {
                arrayList.add("b");
                String pdfTemplateDetail = getPdfTemplateDetail(FileUtils.getFileNameFromFilePath(selectedTemplate));
                if (pdfTemplateDetail != null) {
                    switch (pdfTemplateDetail.hashCode()) {
                        case 1537:
                            if (pdfTemplateDetail.equals("01")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_PLANNER_1);
                                return arrayList;
                            }
                            break;
                        case 1538:
                            if (pdfTemplateDetail.equals("02")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_PLANNER_2);
                                return arrayList;
                            }
                            break;
                        case 1539:
                            if (pdfTemplateDetail.equals("03")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_PLANNER_3);
                                return arrayList;
                            }
                            break;
                        case 1542:
                            if (pdfTemplateDetail.equals("06")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_PLANNER_4);
                                return arrayList;
                            }
                            break;
                        case 1543:
                            if (pdfTemplateDetail.equals("07")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_NOTEBOOK);
                                return arrayList;
                            }
                            break;
                        case 1544:
                            if (pdfTemplateDetail.equals("08")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_SCHOOL_SCHEDULE);
                                return arrayList;
                            }
                            break;
                    }
                }
            } else if (TemplateViewType.isPlanType(selectedTemplateType.intValue())) {
                arrayList.add("c");
                if (selectedTemplateType.intValue() == 16) {
                    int iHashCode2 = selectedTemplate.hashCode();
                    if (iHashCode2 != 1567) {
                        if (iHashCode2 != 1570) {
                            if (iHashCode2 == 1571 && selectedTemplate.equals("14")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_MONTHLY_PLAN);
                                return arrayList;
                            }
                        } else if (selectedTemplate.equals("13")) {
                            arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_WEEKLY_PLAN);
                            return arrayList;
                        }
                    } else if (selectedTemplate.equals(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING)) {
                        arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_CHECKLIST);
                        return arrayList;
                    }
                } else {
                    String pdfTemplateDetail2 = getPdfTemplateDetail(FileUtils.getFileNameFromFilePath(selectedTemplate));
                    if (pdfTemplateDetail2 != null) {
                        int iHashCode3 = pdfTemplateDetail2.hashCode();
                        if (iHashCode3 != 1541) {
                            if (iHashCode3 != 1545) {
                                if (iHashCode3 != 1567) {
                                    if (iHashCode3 != 1569) {
                                        if (iHashCode3 == 1570 && pdfTemplateDetail2.equals("13")) {
                                            arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_MONTHLY_BUDGET);
                                            return arrayList;
                                        }
                                    } else if (pdfTemplateDetail2.equals("12")) {
                                        arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_TRAVEL_PLAN);
                                        return arrayList;
                                    }
                                } else if (pdfTemplateDetail2.equals(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_TAPPING)) {
                                    arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_MONTHLY_PLANNER);
                                    return arrayList;
                                }
                            } else if (pdfTemplateDetail2.equals("09")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_WORK_PLANNER);
                                return arrayList;
                            }
                        } else if (pdfTemplateDetail2.equals("05")) {
                            arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_HEALTH_PLANNER);
                            return arrayList;
                        }
                    }
                }
            } else if (TemplateViewType.isJournalType(selectedTemplateType.intValue())) {
                arrayList.add("d");
                String pdfTemplateDetail3 = getPdfTemplateDetail(FileUtils.getFileNameFromFilePath(selectedTemplate));
                if (pdfTemplateDetail3 != null) {
                    int iHashCode4 = pdfTemplateDetail3.hashCode();
                    if (iHashCode4 != 1540) {
                        if (iHashCode4 != 1568) {
                            if (iHashCode4 == 1571 && pdfTemplateDetail3.equals("14")) {
                                arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_PET_CARE_LOG);
                                return arrayList;
                            }
                        } else if (pdfTemplateDetail3.equals(QuickToolSA.DETAIL_QT_FIRST_BEHAVIOR_CLOSE_BY_PEN_BUTTON)) {
                            arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_MOVIE_BOOK_REVIEW);
                            return arrayList;
                        }
                    } else if (pdfTemplateDetail3.equals("04")) {
                        arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_DAILY_JOURNAL);
                    }
                }
            } else {
                if (TemplateViewType.isCreativeType(selectedTemplateType.intValue())) {
                    arrayList.add("e");
                    if (selectedTemplateType.intValue() == 22) {
                        arrayList.add(SAConstants.DETAIL_DEFAULT_IMAGE_MUSIC);
                        return arrayList;
                    }
                    arrayList.add(SAConstants.DETAIL_DEFAULT_PDF_RECIPES_AND_MEAL_PLAN);
                    return arrayList;
                }
                if (TemplateViewType.isCustomType(selectedTemplateType.intValue())) {
                    arrayList.add("f");
                    if (selectedTemplateType.intValue() == 3) {
                        arrayList.add("c");
                        return arrayList;
                    }
                    arrayList.add("d");
                    return arrayList;
                }
            }
            return arrayList;
        }
        return null;
    }

    private final String getPdfTemplateDetail(String selectedTemplate) {
        int iM14129C = StringsKt.m14129C("_", 0, 6, selectedTemplate);
        if (iM14129C < 0) {
            return "";
        }
        String strSubstring = selectedTemplate.substring(0, iM14129C);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    private final String getTemplateFragmentTag() {
        return this.mType == Constant.Type.CREATE_NOTE ? PickerTemplateStyleFragment.TAG : PageTemplateStyleFragment.TAG;
    }

    private final int getTitleRes() {
        Constant.Type type = this.mType;
        return type == Constant.Type.COVER_EDIT ? C9086R.string.note_style_cover_edit_title : type == Constant.Type.TEMPLATE_PICKER ? C9086R.string.settings_template_style : C9086R.string.note_style_create_note_title;
    }

    private final void initActivityContainer() {
        updateActivityContainer();
        showSheet();
    }

    private final void initCloseBtn() {
        View viewFindViewById = findViewById(C9086R.id.close_btn);
        this.mCloseBtn = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new ViewOnClickListenerC10351b(this, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCloseBtn$lambda$4(NoteStyleActivity noteStyleActivity, View view) {
        noteStyleActivity.setResult(0);
        noteStyleActivity.finish();
    }

    private final void initConfirmBtn() {
        CoverData coverData;
        TextView textView = (TextView) findViewById(C9086R.id.confirm_btn_for_landscape);
        TextView textView2 = (TextView) findViewById(C9086R.id.confirm_btn);
        if (isLandscapeLayoutRequired()) {
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
            this.mConfirm = textView;
        } else {
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.mConfirm = textView2;
        }
        TextView textView3 = this.mConfirm;
        if (textView3 != null) {
            textView3.setOnClickListener(new ViewOnClickListenerC10351b(this, 1));
        }
        TextView textView4 = this.mConfirm;
        if (textView4 != null) {
            textView4.setText(getConfirmButtonRes());
        }
        if (this.mType == Constant.Type.COVER_EDIT) {
            CoverData coverData2 = this.mEditedCoverData;
            if (coverData2 == null || (coverData = this.mOriginCoverData) == null || coverData.equals(coverData2)) {
                enableConfirmBtn(false);
            } else {
                enableConfirmBtn(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void initConfirmBtn$lambda$5(final NoteStyleActivity noteStyleActivity, View view) {
        final Intent intent = new Intent();
        intent.putExtras(noteStyleActivity.getIntent());
        boolean zUpdateCoverResultIntent = noteStyleActivity.updateCoverResultIntent(intent);
        BaseTemplateStyleFragment baseTemplateStyleFragment = noteStyleActivity.mTemplateStyleFragment;
        Boolean boolValueOf = baseTemplateStyleFragment != null ? Boolean.valueOf(baseTemplateStyleFragment.updateResultIntent(intent)) : null;
        if (zUpdateCoverResultIntent) {
            noteStyleActivity.loggingSACoverChanged();
        }
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(boolValueOf, bool)) {
            noteStyleActivity.logTemplateStyleSA();
        }
        BaseTemplateStyleFragment baseTemplateStyleFragment2 = noteStyleActivity.mTemplateStyleFragment;
        if (baseTemplateStyleFragment2 != null && baseTemplateStyleFragment2.isAdditionalDialogRequired()) {
            BaseTemplateStyleFragment baseTemplateStyleFragment3 = noteStyleActivity.mTemplateStyleFragment;
            if (baseTemplateStyleFragment3 != null) {
                baseTemplateStyleFragment3.showAdditionalDialog(noteStyleActivity, new BaseTemplateStyleFragment.PageToApplyCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$initConfirmBtn$1$1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.PageToApplyCallback
                    public void onResult(Intent data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                        int intExtra = data.getIntExtra(ChangeTemplateConstants.KEY_PAGE_TO_APPLY_SELECTED_OPTION, 0);
                        BaseTemplateStyleFragment baseTemplateStyleFragment4 = this.this$0.mTemplateStyleFragment;
                        if (baseTemplateStyleFragment4 != null) {
                            baseTemplateStyleFragment4.updateAdditionalDialogResultIntent(intent, intExtra);
                        }
                        Intent intent2 = new Intent();
                        intent2.putExtras(intent);
                        intent.putExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT, intent2);
                        this.this$0.setResult(-1, intent);
                        this.this$0.logPageToApplySA(intExtra);
                        this.this$0.finish();
                    }
                });
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(boolValueOf, bool)) {
            Intent intent2 = new Intent();
            intent2.putExtras(intent);
            intent.putExtra(ChangeTemplateConstants.ARG_NOTE_STYLE_RESULT, intent2);
        }
        noteStyleActivity.setResult(-1, intent);
        noteStyleActivity.finish();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void initContainerLayout() {
        Ref.LongRef longRef = new Ref.LongRef();
        ViewGroup viewGroup = (ViewGroup) findViewById(C9086R.id.container);
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new ViewOnTouchListenerC7004e(longRef, this, 3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initContainerLayout$lambda$3(Ref.LongRef longRef, NoteStyleActivity noteStyleActivity, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            longRef.element = System.currentTimeMillis();
        } else if (action == 1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - longRef.element;
            if (jCurrentTimeMillis <= 100) {
                Logger.m10999d(TAG, "initContainerLayout# touchDuration : " + jCurrentTimeMillis + " -> finish");
                noteStyleActivity.setResult(0);
                noteStyleActivity.finish();
            }
        }
        return true;
    }

    private final void initCoverData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        if (intent == null) {
            return;
        }
        CoverData coverDataClone = (CoverData) intent.getParcelableExtra(CoverData.KEY_COVER_DATA);
        String stringExtra = intent.getStringExtra(CoverData.KEY_EXTRACT_TEXT);
        if (coverDataClone == null) {
            Logger.m10999d(TAG, "initCoverData# coverData is null");
            coverDataClone = new CoverData(intent.getStringExtra("sdoc_uuid"));
        }
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = coverDataClone.getExtractStr();
        }
        if (savedInstanceState == null) {
            try {
                coverDataClone = coverDataClone.m22192clone();
            } catch (CloneNotSupportedException e) {
                AbstractC8014b.m7198D("initCoverData# ", e.getMessage(), TAG);
            }
        } else {
            coverDataClone = (CoverData) savedInstanceState.getParcelable(KEY_ORIGIN_COVER);
            stringExtra = savedInstanceState.getString(CoverData.KEY_EXTRACT_TEXT);
            this.mEditedCoverData = (CoverData) savedInstanceState.getParcelable(KEY_EDITED_COVER);
        }
        this.mOriginCoverData = coverDataClone;
        this.mExtractText = stringExtra;
        StringBuilder sb = new StringBuilder();
        CoverData coverData = this.mOriginCoverData;
        sb.append("initCoverData# noteUuid : " + (coverData != null ? coverData.getNoteUuid() : null));
        CoverData coverData2 = this.mOriginCoverData;
        sb.append(", state : " + (coverData2 != null ? Integer.valueOf(coverData2.getState()) : null));
        CoverData coverData3 = this.mOriginCoverData;
        sb.append(", templateUuid : " + (coverData3 != null ? coverData3.getTemplateUuid() : null));
        CoverData coverData4 = this.mOriginCoverData;
        sb.append(", colorUuid : " + (coverData4 != null ? coverData4.getColorId() : null));
        CoverData coverData5 = this.mOriginCoverData;
        sb.append(", stickerUuid : " + (coverData5 != null ? coverData5.getCategoryUuid() : null));
        CoverData coverData6 = this.mOriginCoverData;
        sb.append(", isEnabled : " + (coverData6 != null ? Boolean.valueOf(coverData6.isEnabled()) : null));
        CoverStyleUtils coverStyleUtils = CoverStyleUtils.INSTANCE;
        CoverData coverData7 = this.mOriginCoverData;
        Intrinsics.checkNotNull(coverData7);
        String templateUuid = coverData7.getTemplateUuid();
        Intrinsics.checkNotNullExpressionValue(templateUuid, "getTemplateUuid(...)");
        sb.append(", coverType : " + coverStyleUtils.getCoverType(templateUuid));
        sb.append(", mExtractText : " + this.mExtractText);
        Logger.m10999d(TAG, Logger.getEncode(sb.toString()));
        autoGenerateCover(intent);
    }

    private final void initCoverExtractListener() {
        CoverExtractTextReceiver coverExtractTextReceiver = new CoverExtractTextReceiver();
        this.mExtractTextReceiver = coverExtractTextReceiver;
        registerReceiver(this, coverExtractTextReceiver);
        CoverExtractTextReceiver.INSTANCE.setResultListener(new CoverExtractTextReceiver.IReceiver() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity.initCoverExtractListener.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity.CoverExtractTextReceiver.IReceiver
            public void onResult(String result, String noteUuid) {
                CoverStylePresenter coverStylePresenter;
                CoverData coverData;
                CoverStyleFragment coverStyleFragment;
                NoteStyleLayout noteStyleLayout;
                CoverData coverData2;
                CoverData coverData3;
                CoverData coverData4;
                Integer numValueOf = result != null ? Integer.valueOf(result.length()) : null;
                CoverStylePresenter coverStylePresenter2 = NoteStyleActivity.this.mCoverPresenter;
                Logger.m10999d(NoteStyleActivity.TAG, "initCoverExtractListener# onResult# noteUuid : " + noteUuid + ", extractStr length : " + numValueOf + ", isEnabled : " + ((coverStylePresenter2 == null || (coverData4 = coverStylePresenter2.getCoverData()) == null) ? null : Boolean.valueOf(coverData4.isEnabled())));
                CoverData coverData5 = NoteStyleActivity.this.mOriginCoverData;
                if (!Intrinsics.areEqual(noteUuid, coverData5 != null ? coverData5.getNoteUuid() : null)) {
                    CoverData coverData6 = NoteStyleActivity.this.mOriginCoverData;
                    AbstractC8014b.m7198D("onResult# original uuid is ", coverData6 != null ? coverData6.getNoteUuid() : null, NoteStyleActivity.TAG);
                    return;
                }
                NoteStyleActivity.this.mExtractText = result;
                CoverStylePresenter coverStylePresenter3 = NoteStyleActivity.this.mCoverPresenter;
                if (coverStylePresenter3 != null && (coverData3 = coverStylePresenter3.getCoverData()) != null) {
                    coverData3.setExtractStr(result);
                }
                CoverStylePresenter coverStylePresenter4 = NoteStyleActivity.this.mCoverPresenter;
                if (coverStylePresenter4 != null && (coverData2 = coverStylePresenter4.getCoverData()) != null) {
                    extractStr = coverData2.getExtractStr();
                }
                Intrinsics.checkNotNull(extractStr);
                if (extractStr.length() <= 100 || (coverStylePresenter = NoteStyleActivity.this.mCoverPresenter) == null || (coverData = coverStylePresenter.getCoverData()) == null || !coverData.isEnabled()) {
                    NoteStyleLayout noteStyleLayout2 = NoteStyleActivity.this.mNoteStyleLayout;
                    if (noteStyleLayout2 != null) {
                        noteStyleLayout2.updateCoverAILayoutVisibility(8);
                        return;
                    }
                    return;
                }
                NoteStyleActivity.this.setAvailableGenerateCover(true);
                NoteStyleLayout noteStyleLayout3 = NoteStyleActivity.this.mNoteStyleLayout;
                if (noteStyleLayout3 == null || !noteStyleLayout3.isCoverPreviewSelected() || (coverStyleFragment = NoteStyleActivity.this.mCoverStyleFragment) == null || !coverStyleFragment.isTextTab() || (noteStyleLayout = NoteStyleActivity.this.mNoteStyleLayout) == null) {
                    return;
                }
                noteStyleLayout.updateCoverAILayoutVisibility(0);
            }
        });
    }

    private final void initCoverPresenter() {
        CoverData coverDataClone;
        Logger.m10999d(TAG, "initCoverPresenter");
        CoverStylePresenter coverStylePresenter = new CoverStylePresenter(this);
        this.mCoverPresenter = coverStylePresenter;
        Intrinsics.checkNotNull(coverStylePresenter);
        CoverData coverData = this.mEditedCoverData;
        if (coverData == null) {
            coverData = this.mOriginCoverData;
            if (coverData == null) {
                coverDataClone = null;
            }
            coverStylePresenter.initialize(coverDataClone);
            CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter2);
            coverStylePresenter2.setContract(this);
            setCoverData();
        }
        Intrinsics.checkNotNull(coverData);
        coverDataClone = coverData.m22192clone();
        coverStylePresenter.initialize(coverDataClone);
        CoverStylePresenter coverStylePresenter22 = this.mCoverPresenter;
        Intrinsics.checkNotNull(coverStylePresenter22);
        coverStylePresenter22.setContract(this);
        setCoverData();
    }

    private final void initCoverStyleFragment() {
        CoverStylePresenter coverStylePresenter;
        CoverData coverData;
        CoverStylePresenter coverStylePresenter2;
        CoverData coverData2;
        NoteStyleLayout noteStyleLayout;
        CoverData coverData3;
        CoverData coverData4;
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(CoverStyleFragment.TAG);
        String extractStr = null;
        CoverStyleFragment coverStyleFragment = fragmentFindFragmentByTag instanceof CoverStyleFragment ? (CoverStyleFragment) fragmentFindFragmentByTag : null;
        this.mCoverStyleFragment = coverStyleFragment;
        if (coverStyleFragment == null) {
            CoverStyleFragment coverStyleFragment2 = new CoverStyleFragment();
            this.mCoverStyleFragment = coverStyleFragment2;
            coverStyleFragment2.setArguments(new Bundle());
        }
        CoverStyleFragment coverStyleFragment3 = this.mCoverStyleFragment;
        if (coverStyleFragment3 != null) {
            coverStyleFragment3.setPresenter(this.mCoverPresenter);
        }
        CoverStyleFragment coverStyleFragment4 = this.mCoverStyleFragment;
        if (coverStyleFragment4 != null) {
            coverStyleFragment4.setContract(new CoverStyleFragment.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity.initCoverStyleFragment.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment.Contract
                public void updateCoverAILayout(int visibility) {
                    NoteStyleLayout noteStyleLayout2 = NoteStyleActivity.this.mNoteStyleLayout;
                    if (noteStyleLayout2 != null) {
                        noteStyleLayout2.updateCoverAILayoutVisibility(visibility);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment.Contract
                public void updateCoverPreview() {
                    NoteStyleLayout noteStyleLayout2 = NoteStyleActivity.this.mNoteStyleLayout;
                    if (noteStyleLayout2 != null) {
                        noteStyleLayout2.updateCoverPreviewLayout();
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment.Contract
                public void updateCoverSticker(int stickerPosition, int stickerPrevPosition) {
                    NoteStyleLayout noteStyleLayout2 = NoteStyleActivity.this.mNoteStyleLayout;
                    if (noteStyleLayout2 != null) {
                        noteStyleLayout2.updateCoverSticker(stickerPosition, stickerPrevPosition);
                    }
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.CoverStyleFragment.Contract
                public void updateCreateBtn() {
                    NoteStyleActivity.this.enableConfirmBtn(true);
                }
            });
        }
        if (this.mType != Constant.Type.COVER_EDIT || TextUtils.isEmpty(this.mExtractText) || (coverStylePresenter = this.mCoverPresenter) == null || (coverData = coverStylePresenter.getCoverData()) == null || coverData.getGenerateState() != 0) {
            return;
        }
        CoverStylePresenter coverStylePresenter3 = this.mCoverPresenter;
        if (coverStylePresenter3 != null && (coverData4 = coverStylePresenter3.getCoverData()) != null) {
            coverData4.setExtractStr(this.mExtractText);
        }
        CoverStylePresenter coverStylePresenter4 = this.mCoverPresenter;
        if (coverStylePresenter4 != null && (coverData3 = coverStylePresenter4.getCoverData()) != null) {
            extractStr = coverData3.getExtractStr();
        }
        Intrinsics.checkNotNull(extractStr);
        if (extractStr.length() <= 100) {
            setAvailableGenerateCover(false);
            NoteStyleLayout noteStyleLayout2 = this.mNoteStyleLayout;
            if (noteStyleLayout2 != null) {
                noteStyleLayout2.updateCoverAILayoutVisibility(8);
                return;
            }
            return;
        }
        setAvailableGenerateCover(true);
        NoteStyleLayout noteStyleLayout3 = this.mNoteStyleLayout;
        if (noteStyleLayout3 == null || !noteStyleLayout3.isCoverPreviewSelected() || (coverStylePresenter2 = this.mCoverPresenter) == null || (coverData2 = coverStylePresenter2.getCoverData()) == null || !coverData2.isEnabled() || (noteStyleLayout = this.mNoteStyleLayout) == null) {
            return;
        }
        noteStyleLayout.updateCoverAILayoutVisibility(0);
    }

    private final void initLayout(Bundle savedInstanceState) {
        initContainerLayout();
        initTitle();
        initCloseBtn();
        initConfirmBtn();
        updateConfirmBtnBg();
        initNoteStyleLayout(savedInstanceState);
    }

    private final void initNoteStyleLayout(Bundle savedInstanceState) {
        this.mNoteStyleLayout = (NoteStyleLayout) findViewById(C9086R.id.note_style_layout);
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        NoteStyleLayout noteStyleLayout = this.mNoteStyleLayout;
        if (noteStyleLayout != null) {
            int styleContainerResId = noteStyleLayout.getStyleContainerResId();
            initTemplateStyleFragment();
            initCoverStyleFragment();
            if (this.mTemplateStyleFragment == null || this.mCoverStyleFragment == null) {
                return;
            }
            if (savedInstanceState == null) {
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "beginTransaction(...)");
                FragmentTransaction reorderingAllowed = fragmentTransactionBeginTransaction.setCustomAnimations(C9086R.anim.note_style_fragment_enter, C9086R.anim.note_style_fragment_exit).setReorderingAllowed(true);
                BaseTemplateStyleFragment baseTemplateStyleFragment = this.mTemplateStyleFragment;
                Intrinsics.checkNotNull(baseTemplateStyleFragment);
                FragmentTransaction fragmentTransactionAdd = reorderingAllowed.add(styleContainerResId, baseTemplateStyleFragment, getTemplateFragmentTag());
                CoverStyleFragment coverStyleFragment = this.mCoverStyleFragment;
                Intrinsics.checkNotNull(coverStyleFragment);
                FragmentTransaction fragmentTransactionAdd2 = fragmentTransactionAdd.add(styleContainerResId, coverStyleFragment, CoverStyleFragment.TAG);
                CoverStyleFragment coverStyleFragment2 = this.mCoverStyleFragment;
                Intrinsics.checkNotNull(coverStyleFragment2);
                fragmentTransactionAdd2.hide(coverStyleFragment2).commit();
            }
            NoteStyleLayout noteStyleLayout2 = this.mNoteStyleLayout;
            if (noteStyleLayout2 != null) {
                noteStyleLayout2.initialize(new NoteStyleLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity.initNoteStyleLayout.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void cancelGenerateCover() {
                        NoteStyleActivity.this.cancelCoverGenerate();
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void enableEditor(boolean isEnable) {
                        NoteStyleActivity.this.enableEditor(isEnable);
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public CoverData getCoverData() {
                        CoverStylePresenter coverStylePresenter = NoteStyleActivity.this.mCoverPresenter;
                        if (coverStylePresenter != null) {
                            return coverStylePresenter.getCoverData();
                        }
                        return null;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public DocumentPageRatio.PageRatioType getPageRatioType() {
                        return NoteStyleActivity.this.mPageRatioType;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public Bitmap getPageThumbnail() {
                        return NoteStyleActivity.this.mPageThumbnail;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public FragmentManager getSupportFragmentManager() {
                        FragmentManager supportFragmentManager2 = NoteStyleActivity.this.getSupportFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                        return supportFragmentManager2;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public Constant.Type getType() {
                        return NoteStyleActivity.this.mType;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public boolean isCoeditNote() {
                        return NoteStyleActivity.this.mIsCoeditNote;
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public boolean isLandscapeLayoutRequired() {
                        return NoteStyleActivity.this.isLandscapeLayoutRequired();
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void onClickAiButton() {
                        NoteStyleActivity.this.onClickCoverGenerate();
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void requestApplyCover() {
                        NoteStyleLayout noteStyleLayout3;
                        CoverStylePresenter coverStylePresenter = NoteStyleActivity.this.mCoverPresenter;
                        if (coverStylePresenter != null) {
                            NoteStyleActivity noteStyleActivity = NoteStyleActivity.this;
                            Logger.m10999d(NoteStyleActivity.TAG, "requestApplyCover# enable : " + coverStylePresenter.getEnabled());
                            if (!coverStylePresenter.getEnabled() && (noteStyleLayout3 = noteStyleActivity.mNoteStyleLayout) != null) {
                                noteStyleLayout3.showCoverNewPreview();
                            }
                            coverStylePresenter.setEnabled(true);
                            enableEditor(true);
                            String extractStr = coverStylePresenter.getCoverData().getExtractStr();
                            if ((extractStr != null ? extractStr.length() : 0) <= 100) {
                                NoteStyleLayout noteStyleLayout4 = noteStyleActivity.mNoteStyleLayout;
                                if (noteStyleLayout4 != null) {
                                    noteStyleLayout4.updateCoverAILayoutVisibility(8);
                                    return;
                                }
                                return;
                            }
                            noteStyleActivity.setAvailableGenerateCover(true);
                            boolean z = coverStylePresenter.getTypeIndex(coverStylePresenter.getTemplateUuid()) == CoverStyleConstants.CoverType.TEXT.ordinal();
                            NoteStyleLayout noteStyleLayout5 = noteStyleActivity.mNoteStyleLayout;
                            if (noteStyleLayout5 != null) {
                                noteStyleLayout5.updateCoverAILayoutVisibility(z ? 0 : 8);
                            }
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void requestClearCover() {
                        Logger.m10999d(NoteStyleActivity.TAG, "requestClearCover");
                        NoteStyleActivity.this.cancelCoverGenerate();
                        enableEditor(getType() == Constant.Type.STYLE_CHANGE || getType() == Constant.Type.CREATE_NOTE);
                        CoverStyleFragment coverStyleFragment3 = NoteStyleActivity.this.mCoverStyleFragment;
                        if (coverStyleFragment3 != null) {
                            coverStyleFragment3.updateTitleVisibility(false);
                        }
                        CoverStylePresenter coverStylePresenter = NoteStyleActivity.this.mCoverPresenter;
                        if (coverStylePresenter != null) {
                            coverStylePresenter.setEnabled(false);
                        }
                        CoverStylePresenter coverStylePresenter2 = NoteStyleActivity.this.mCoverPresenter;
                        if (coverStylePresenter2 != null) {
                            coverStylePresenter2.setIsGeneratedCover(false);
                        }
                        CoverStylePresenter coverStylePresenter3 = NoteStyleActivity.this.mCoverPresenter;
                        if (coverStylePresenter3 != null) {
                            coverStylePresenter3.setIsGeneratedTitle(false);
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void requestShowCoverStyle() {
                        Logger.m10999d(NoteStyleActivity.TAG, "requestShowCoverStyle");
                        CoverStyleFragment coverStyleFragment3 = NoteStyleActivity.this.mCoverStyleFragment;
                        if (coverStyleFragment3 != null) {
                            FragmentManager fragmentManager = supportFragmentManager;
                            NoteStyleActivity noteStyleActivity = NoteStyleActivity.this;
                            FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager.beginTransaction();
                            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                            FragmentTransaction fragmentTransactionShow = fragmentTransactionBeginTransaction2.setCustomAnimations(C9086R.anim.note_style_fragment_enter, C9086R.anim.note_style_fragment_exit).setReorderingAllowed(true).show(coverStyleFragment3);
                            BaseTemplateStyleFragment baseTemplateStyleFragment2 = noteStyleActivity.mTemplateStyleFragment;
                            Intrinsics.checkNotNull(baseTemplateStyleFragment2);
                            fragmentTransactionShow.hide(baseTemplateStyleFragment2).commit();
                            CoverStylePresenter coverStylePresenter = noteStyleActivity.mCoverPresenter;
                            Intrinsics.checkNotNull(coverStylePresenter);
                            enableEditor(coverStylePresenter.getEnabled());
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void requestShowPageStyle() {
                        View view;
                        final BaseTemplateStyleFragment baseTemplateStyleFragment2 = NoteStyleActivity.this.mTemplateStyleFragment;
                        if (baseTemplateStyleFragment2 != null) {
                            NoteStyleActivity noteStyleActivity = NoteStyleActivity.this;
                            FragmentManager supportFragmentManager2 = noteStyleActivity.getSupportFragmentManager();
                            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
                            FragmentTransaction fragmentTransactionBeginTransaction2 = supportFragmentManager2.beginTransaction();
                            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction2, "beginTransaction(...)");
                            FragmentTransaction fragmentTransactionShow = fragmentTransactionBeginTransaction2.setCustomAnimations(C9086R.anim.note_style_fragment_enter, C9086R.anim.note_style_fragment_exit).setReorderingAllowed(true).show(baseTemplateStyleFragment2);
                            CoverStyleFragment coverStyleFragment3 = noteStyleActivity.mCoverStyleFragment;
                            Intrinsics.checkNotNull(coverStyleFragment3);
                            fragmentTransactionShow.hide(coverStyleFragment3).commit();
                            BaseTemplateStyleFragment baseTemplateStyleFragment3 = noteStyleActivity.mTemplateStyleFragment;
                            if (baseTemplateStyleFragment3 == null || (view = baseTemplateStyleFragment3.getView()) == null) {
                                return;
                            }
                            if (!view.isLaidOut() || view.isLayoutRequested()) {
                                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$initNoteStyleLayout$1$requestShowPageStyle$lambda$1$$inlined$doOnLayout$1
                                    @Override // android.view.View.OnLayoutChangeListener
                                    public void onLayoutChange(View view2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                                        view2.removeOnLayoutChangeListener(this);
                                        baseTemplateStyleFragment2.updatePagerHeight();
                                    }
                                });
                            } else {
                                baseTemplateStyleFragment2.updatePagerHeight();
                            }
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void setCoverSummary(String summary) {
                        Intrinsics.checkNotNullParameter(summary, "summary");
                        TextView textView = NoteStyleActivity.this.mConfirm;
                        if (textView != null && !textView.isEnabled()) {
                            CoverStylePresenter coverStylePresenter = NoteStyleActivity.this.mCoverPresenter;
                            if (!StringsKt.m14169y(coverStylePresenter != null ? coverStylePresenter.getSummary() : null, summary)) {
                                NoteStyleActivity.this.enableConfirmBtn(true);
                            }
                        }
                        CoverStylePresenter coverStylePresenter2 = NoteStyleActivity.this.mCoverPresenter;
                        if (coverStylePresenter2 != null) {
                            coverStylePresenter2.setSummary(summary);
                        }
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout.Contract
                    public void updateCreateBtn() {
                        if (NoteStyleActivity.this.mType == Constant.Type.COVER_EDIT) {
                            AbstractC8014b.m7220v("updateCreateBtn# ", NoteStyleActivity.TAG, !Intrinsics.areEqual(NoteStyleActivity.this.mOriginCoverData, getCoverData()));
                            if (Intrinsics.areEqual(NoteStyleActivity.this.mOriginCoverData, getCoverData())) {
                                NoteStyleActivity.this.enableConfirmBtn(false);
                            } else {
                                NoteStyleActivity.this.enableConfirmBtn(true);
                            }
                        }
                    }
                });
            }
            NoteStyleLayout noteStyleLayout3 = this.mNoteStyleLayout;
            if (noteStyleLayout3 != null) {
                noteStyleLayout3.initParams(savedInstanceState);
            }
            NoteStyleLayout noteStyleLayout4 = this.mNoteStyleLayout;
            if (noteStyleLayout4 != null) {
                noteStyleLayout4.initLayout();
            }
        }
    }

    private final void initParams(Bundle savedInstanceState) {
        this.mGravity = savedInstanceState != null ? savedInstanceState.getInt(Constant.KEY_GRAVITY, 0) : getIntent().getIntExtra(Constant.KEY_GRAVITY, 0);
        this.mType = ((Constant.Type[]) Constant.Type.getEntries().toArray(new Constant.Type[0]))[savedInstanceState != null ? savedInstanceState.getInt("key_type") : getIntent().getIntExtra("key_type", Constant.Type.CREATE_NOTE.ordinal())];
        this.mIsCoeditNote = getIntent().getBooleanExtra(Constant.KEY_IS_COEDIT_NOTE, false);
    }

    private final void initTemplateStyleFragment() {
        BaseTemplateStyleFragment baseTemplateStyleFragment = (BaseTemplateStyleFragment) getSupportFragmentManager().findFragmentByTag(getTemplateFragmentTag());
        this.mTemplateStyleFragment = baseTemplateStyleFragment;
        if (baseTemplateStyleFragment == null) {
            this.mTemplateStyleFragment = getBaseTemplateStyleFragment();
            Bundle bundle = new Bundle();
            int i = WhenMappings.$EnumSwitchMapping$0[this.mType.ordinal()];
            if (i == 1) {
                bundle.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 3);
            } else if (i == 2) {
                bundle.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 2);
            } else if (i == 3) {
                bundle.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 1);
            } else if (i == 4) {
                bundle.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 4);
            } else {
                if (i != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                bundle.putInt(ChangeTemplateConstants.ARG_PAGE_TEMPLATE_CALLER, 0);
            }
            BaseTemplateStyleFragment baseTemplateStyleFragment2 = this.mTemplateStyleFragment;
            if (baseTemplateStyleFragment2 != null) {
                baseTemplateStyleFragment2.setArguments(bundle);
            }
        }
        BaseTemplateStyleFragment baseTemplateStyleFragment3 = this.mTemplateStyleFragment;
        if (baseTemplateStyleFragment3 != null) {
            baseTemplateStyleFragment3.setContract(new BaseTemplateStyleFragment.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity.initTemplateStyleFragment.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.Contract
                public void enableConfirmBtn(boolean isEnabled) {
                    NoteStyleActivity.this.enableConfirmBtn(isEnabled);
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.Contract
                public Constant.Type getCaller() {
                    return NoteStyleActivity.this.mType;
                }

                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.common.BaseTemplateStyleFragment.Contract
                public void onSelectedTemplateChanged(DocumentPageRatio.PageRatioType pageRatioType, String templatePath, Integer templateRes) {
                    Bitmap bitmap$default;
                    Drawable drawable;
                    Intrinsics.checkNotNullParameter(pageRatioType, "pageRatioType");
                    NoteStyleActivity.this.mPageRatioType = pageRatioType;
                    NoteStyleActivity noteStyleActivity = NoteStyleActivity.this;
                    if (TextUtils.isEmpty(templatePath)) {
                        bitmap$default = null;
                        if (templateRes != null && templateRes.intValue() > 0 && (drawable = BaseUtils.getContext().getDrawable(templateRes.intValue())) != null) {
                            bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
                        }
                    } else {
                        bitmap$default = BitmapFactory.decodeFile(templatePath);
                    }
                    noteStyleActivity.mPageThumbnail = bitmap$default;
                    NoteStyleLayout noteStyleLayout = NoteStyleActivity.this.mNoteStyleLayout;
                    if (noteStyleLayout != null) {
                        noteStyleLayout.updatePagePreview();
                    }
                    if (NoteStyleActivity.this.mType == Constant.Type.STYLE_CHANGE) {
                        NoteStyleActivity.this.updateConfirmBtn();
                    }
                }
            });
        }
    }

    private final void initTitle() {
        TextView textView = (TextView) findViewById(C9086R.id.title);
        if (textView != null) {
            textView.setText(getTitleRes());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLandscapeLayoutRequired() {
        return (com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils.isTabletLayout(getBaseContext()) || getBaseContext().getResources().getConfiguration().orientation != 2 || this.mType == Constant.Type.TEMPLATE_PICKER) ? false : true;
    }

    private final boolean isPopOverSupportLayout() {
        return PopOverUtils.isPopOverSupportLayout(this);
    }

    private final boolean isPortraitLayout() {
        return isPopOverSupportLayout() || getResources().getConfiguration().orientation == 1;
    }

    private final void logFabSA(String categoryDetail, String templateDetail) {
        CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
        companion.insertLog("101", AssistSAConstants.EVENT_TEMPLATE_CATEGORY, categoryDetail);
        companion.insertLog("101", AssistSAConstants.EVENT_SELECTED_TEMPLATE_TYPE, templateDetail);
        BaseTemplateStyleFragment baseTemplateStyleFragment = this.mTemplateStyleFragment;
        Intrinsics.checkNotNull(baseTemplateStyleFragment, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.PickerTemplateStyleFragment");
        ((PickerTemplateStyleFragment) baseTemplateStyleFragment).loggingSATemplateChanged();
    }

    private final void logPageSorterSA(String categoryDetail, String templateDetail) {
        CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
        companion.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_TEMPLATE_CATEGORY, categoryDetail);
        companion.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_SELECTED_TEMPLATE, templateDetail);
    }

    private final void logPageStyleSA(String categoryDetail, String templateDetail) {
        CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
        companion.insertLog("411", SAConstants.EVENT_SELECT_TEMPLATE_CATEGORY, categoryDetail);
        companion.insertLog("411", SAConstants.EVENT_COMP_SELECT_TEMPLATE, templateDetail);
    }

    private final void loggingSACoverChanged() {
        String str;
        String str2;
        String str3;
        String str4;
        CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
        String str5 = null;
        String templateUuid = coverStylePresenter != null ? coverStylePresenter.getTemplateUuid() : null;
        CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
        String colorUuid = coverStylePresenter2 != null ? coverStylePresenter2.getColorUuid() : null;
        CoverStylePresenter coverStylePresenter3 = this.mCoverPresenter;
        String stickerUuid = coverStylePresenter3 != null ? coverStylePresenter3.getStickerUuid() : null;
        CoverStylePresenter coverStylePresenter4 = this.mCoverPresenter;
        boolean enabled = coverStylePresenter4 != null ? coverStylePresenter4.getEnabled() : false;
        int i = WhenMappings.$EnumSwitchMapping$0[this.mType.ordinal()];
        if (i == 1) {
            str5 = "101";
        } else if (i == 3 || i == 4) {
            str5 = AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER;
        }
        if (str5 != null) {
            if (Intrinsics.areEqual(str5, "101")) {
                str = AssistSAConstants.EVENT_LIST_COVER_IMAGE;
            } else if (!Intrinsics.areEqual(str5, AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER)) {
                return;
            } else {
                str = AssistSAConstants.EVENT_COMPOSER_COVER_IMAGE;
            }
            ComposerSA.insertLog(str5, str, CoverEditorUtils.getSATemplateDetail(templateUuid));
            if (Intrinsics.areEqual(str5, "101")) {
                str2 = AssistSAConstants.EVENT_LIST_COVER_COLOR;
            } else if (!Intrinsics.areEqual(str5, AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER)) {
                return;
            } else {
                str2 = AssistSAConstants.EVENT_COMPOSER_COVER_COLOR;
            }
            ComposerSA.insertLog(str5, str2, CoverEditorUtils.getSAColorDetail(colorUuid));
            if (Intrinsics.areEqual(str5, "101")) {
                str3 = AssistSAConstants.EVENT_LIST_COVER_STICKER;
            } else if (!Intrinsics.areEqual(str5, AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER)) {
                return;
            } else {
                str3 = AssistSAConstants.EVENT_COMPOSER_COVER_STICKER;
            }
            ComposerSA.insertLog(str5, str3, CoverEditorUtils.getSACategoryDetail(stickerUuid));
            CommonSamsungAnalytics.Companion companion = CommonSamsungAnalytics.INSTANCE;
            if (Intrinsics.areEqual(str5, "101")) {
                str4 = AssistSAConstants.EVENT_LIST_ADD_NEW_COVER;
            } else if (!Intrinsics.areEqual(str5, AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER)) {
                return;
            } else {
                str4 = AssistSAConstants.EVENT_COMPOSER_ADD_NEW_COVER;
            }
            companion.insertLog(str5, str4, enabled ? "a" : "b");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean needShowDialogFragment() {
        boolean z;
        boolean z2 = this.mType == Constant.Type.CREATE_NOTE;
        CoverData coverData = this.mOriginCoverData;
        if (coverData == null) {
            z = false;
        } else {
            CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
            if (!coverData.equals(coverStylePresenter != null ? coverStylePresenter.getCoverData() : null)) {
                z = true;
            }
        }
        BaseTemplateStyleFragment baseTemplateStyleFragment = this.mTemplateStyleFragment;
        return (this.mIsDismissRequested || z2 || (!z && !(baseTemplateStyleFragment != null && baseTemplateStyleFragment.isTemplateChanged()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBackKeyDown() {
        Logger.m10999d(TAG, "onBackKeyDown#");
        if (needShowDialogFragment()) {
            showConfirmDialogFragment();
        } else {
            finish();
        }
    }

    private final void setBackPressedListener() {
        getOnBackPressedDispatcher().addCallback(new OnBackPressedCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$setBackPressedListener$backPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                this.this$0.onBackKeyDown();
            }
        });
    }

    private final void setCoverData() {
        CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
        Intrinsics.checkNotNull(coverStylePresenter);
        if (coverStylePresenter.getCoverData().getSelectedTemplateList() == null) {
            CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter2);
            CoverStylePresenter coverStylePresenter3 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter3);
            coverStylePresenter2.setSelectedTemplateList(coverStylePresenter3.createSelectedTemplateList());
            CoverStylePresenter coverStylePresenter4 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter4);
            CoverStylePresenter coverStylePresenter5 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter5);
            CoverStylePresenter coverStylePresenter6 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter6);
            int typeIndex = coverStylePresenter5.getTypeIndex(coverStylePresenter6.getTemplateUuid());
            CoverStylePresenter coverStylePresenter7 = this.mCoverPresenter;
            Intrinsics.checkNotNull(coverStylePresenter7);
            coverStylePresenter4.setSelectedTemplateUuid(typeIndex, coverStylePresenter7.getTemplateUuid());
        }
    }

    private final void showConfirmDialogFragment() {
        NoteStyleConfirmDialogFragment noteStyleConfirmDialogFragment = new NoteStyleConfirmDialogFragment();
        noteStyleConfirmDialogFragment.setCallback(this.mConfirmDialogCallback);
        noteStyleConfirmDialogFragment.show(getSupportFragmentManager(), NoteStyleConfirmDialogFragment.INSTANCE.getTAG());
    }

    private final void showSheet() {
        final View viewFindViewById;
        final View viewFindViewById2;
        if (SettingsCompat.INSTANCE.getInstance().isHighTextContrastEnabled(this) || (viewFindViewById = findViewById(C9086R.id.container)) == null || (viewFindViewById2 = findViewById(C9086R.id.activity_container)) == null) {
            return;
        }
        final float f = ContextUtils.isNightMode(this) ? 0.8f : 0.4f;
        if (isPopOverSupportLayout()) {
            OneShotPreDrawListener.add(viewFindViewById2, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$showSheet$$inlined$doOnPreDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewPropertyAnimator interpolator = viewFindViewById2.animate().scaleX(1.0f).scaleY(1.0f).setDuration(400L).setInterpolator(new PathInterpolator(0.22f, 0.25f, 0.0f, 1.0f));
                    Intrinsics.checkNotNullExpressionValue(interpolator, "setInterpolator(...)");
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.setDuration(400L);
                    valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    final View view = viewFindViewById2;
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$showSheet$1$alphaAnimator$1$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator animator) {
                            Intrinsics.checkNotNullParameter(animator, "animator");
                            View view2 = view;
                            Object animatedValue = animator.getAnimatedValue();
                            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                            view2.setAlpha(((Float) animatedValue).floatValue());
                        }
                    });
                    ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, f);
                    valueAnimatorOfFloat2.setDuration(400L);
                    valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
                    final View view2 = viewFindViewById;
                    valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$showSheet$1$dimAnimator$1$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator animator) {
                            Intrinsics.checkNotNullParameter(animator, "animator");
                            View view3 = view2;
                            Object animatedValue = animator.getAnimatedValue();
                            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                            view3.setBackground(new ColorDrawable(ColorKt.m18579toArgb8_81llA(ColorKt.Color(0, 0, 0, (int) (((Float) animatedValue).floatValue() * 255)))));
                        }
                    });
                    View view3 = viewFindViewById2;
                    view3.setAlpha(0.0f);
                    view3.setScaleX(0.95f);
                    view3.setScaleY(0.95f);
                    valueAnimatorOfFloat2.start();
                    interpolator.start();
                    valueAnimatorOfFloat.start();
                }
            });
        } else {
            viewFindViewById2.setVisibility(4);
            OneShotPreDrawListener.add(viewFindViewById2, new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$showSheet$$inlined$doOnPreDraw$2
                @Override // java.lang.Runnable
                public final void run() {
                    viewFindViewById2.setVisibility(0);
                    viewFindViewById2.setTranslationY(ResourceUtils.convertDpToPixel(this, 10.0f) + this.getWindow().getDecorView().getHeight());
                    viewFindViewById2.setAlpha(0.0f);
                    SpringAnimation spring = new SpringAnimation(viewFindViewById2, DynamicAnimation.TRANSLATION_Y).setSpring(new SpringForce(0.0f).setDampingRatio(1.0f).setStiffness(361.0f));
                    ViewPropertyAnimator interpolator = viewFindViewById2.animate().alpha(1.0f).setDuration(150L).setInterpolator(new LinearInterpolator());
                    Intrinsics.checkNotNullExpressionValue(interpolator, "setInterpolator(...)");
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, f);
                    valueAnimatorOfFloat.setDuration(400L);
                    valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    final View view = viewFindViewById;
                    valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity$showSheet$2$dimAnimator$1$1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator animator) {
                            Intrinsics.checkNotNullParameter(animator, "animator");
                            View view2 = view;
                            Object animatedValue = animator.getAnimatedValue();
                            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                            view2.setBackground(new ColorDrawable(ColorKt.m18579toArgb8_81llA(ColorKt.Color(0, 0, 0, (int) (((Float) animatedValue).floatValue() * 255)))));
                        }
                    });
                    valueAnimatorOfFloat.start();
                    spring.start();
                    interpolator.start();
                }
            });
        }
    }

    @SuppressLint({"RestrictedApi"})
    private final void updateActivityContainer() {
        ViewGroup viewGroup = (ViewGroup) findViewById(C9086R.id.activity_container);
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new ViewOnTouchListenerC7005f(12));
            boolean zIsPopOverSupportLayout = isPopOverSupportLayout();
            Logger.m10999d(TAG, "updateActivityContainer, " + zIsPopOverSupportLayout + SQLKeyword.COMMA + isPortraitLayout());
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            if (zIsPopOverSupportLayout) {
                ViewGroup.LayoutParams layoutParams3 = viewGroup.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams3;
                float fConvertDpToPixel = ResourceUtils.convertDpToPixel(this, 400.0f);
                float widthPx = DisplayUtils.getWidthPx(this);
                int navigationBarHeightIgnoreHasSoftKey = InputMethodCompat.INSTANCE.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this) + marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
                WindowManagerCompat.Companion companion = WindowManagerCompat.INSTANCE;
                layoutParams2.width = (int) RangesKt.coerceAtMost(fConvertDpToPixel, widthPx - (companion.getInstance().getStatusBarHeight(this) + navigationBarHeightIgnoreHasSoftKey));
                layoutParams2.height = (int) RangesKt.coerceAtMost(ResourceUtils.convertDpToPixel(this, 720.0f), DisplayUtils.getHeightPx(this) - (companion.getInstance().getStatusBarHeight(this) + (r4.getInstance().getNavigationBarHeightIgnoreHasSoftKey(this) + (marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart()))));
                viewGroup.setBackground(null);
                viewGroup.setForeground(null);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(new NoteStyleActivity$updateActivityContainer$1$2(viewGroup, this));
            } else {
                layoutParams2.width = -1;
                layoutParams2.height = -1;
                viewGroup.setForeground(getResources().getDrawable(C9086R.drawable.note_style_activity_border));
                viewGroup.setBackground(getDrawable(C9086R.drawable.note_style_round_corner_bg));
                if (Build.VERSION.SDK_INT >= 35) {
                    SemBlurCompat.setBlurEffectPreset$default(viewGroup, 0, ContextUtils.isNightMode(this) ? 120 : 105, (Integer) null, Float.valueOf(getResources().getDimension(C9086R.dimen.note_style_corner_radius)), (Integer) null, 32, (Object) null);
                    viewGroup.setForeground(getResources().getDrawable(C9086R.drawable.note_style_activity_border));
                }
            }
            layoutParams2.gravity = this.mGravity;
            viewGroup.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateActivityContainer$lambda$7$lambda$6(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void updateBackgroundColor() {
        WindowInsetsController insetsController;
        View decorView = getWindow().getDecorView();
        Color.Companion companion = Color.INSTANCE;
        decorView.setBackgroundColor(ColorKt.m18579toArgb8_81llA(companion.m18560getTransparent0d7_KjU()));
        SystemUi.setNavigationBarTheme(this, ColorKt.m18579toArgb8_81llA(companion.m18560getTransparent0d7_KjU()), !ContextUtils.isNightMode(this));
        if (Build.VERSION.SDK_INT >= 30 && (insetsController = getWindow().getInsetsController()) != null) {
            insetsController.setSystemBarsAppearance(0, 24);
        }
        SystemUi systemUi = SystemUi.INSTANCE;
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        systemUi.setNavigationBarContrastEnforced(window, false);
        DisplayCutoutCompat.INSTANCE.getInstance().setDisplayCutoutBGColor(this, ColorKt.m18579toArgb8_81llA(companion.m18560getTransparent0d7_KjU()));
    }

    private final void updateCallbackForDialog() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(NoteStyleConfirmDialogFragment.INSTANCE.getTAG());
        if (fragmentFindFragmentByTag instanceof NoteStyleConfirmDialogFragment) {
            ((NoteStyleConfirmDialogFragment) fragmentFindFragmentByTag).setCallback(this.mConfirmDialogCallback);
        }
    }

    public final void cancelCoverGenerate() {
        CoverData coverData;
        CoverData coverData2;
        CoverData coverData3;
        CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
        if (coverStylePresenter == null || (coverData = coverStylePresenter.getCoverData()) == null || coverData.getGenerateState() != 1) {
            return;
        }
        Logger.m10999d(TAG, "cancelCoverGenerate#");
        AiCoverDataCreatorManager aiCoverDataCreatorManager = AiCoverDataCreatorManager.getInstance();
        CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
        aiCoverDataCreatorManager.cancelCreateCover((coverStylePresenter2 == null || (coverData3 = coverStylePresenter2.getCoverData()) == null) ? null : coverData3.getNoteUuid());
        NoteStyleLayout noteStyleLayout = this.mNoteStyleLayout;
        if (noteStyleLayout != null) {
            noteStyleLayout.stopAnimation(false);
        }
        CoverStylePresenter coverStylePresenter3 = this.mCoverPresenter;
        if (coverStylePresenter3 == null || (coverData2 = coverStylePresenter3.getCoverData()) == null) {
            return;
        }
        coverData2.setGenerateState(0);
    }

    @Override // android.app.Activity
    public void finish() {
        dismissSheet(new RunnableC10350a(this, 1));
    }

    @NotNull
    /* JADX INFO: renamed from: getType, reason: from getter */
    public final Constant.Type getMType() {
        return this.mType;
    }

    public final void logPageToApplySA(int pageToApply) {
        CommonSamsungAnalytics.INSTANCE.insertLog("411", SAConstants.EVENT_APPLY_TEMPLATE_TO, pageToApply != 1 ? pageToApply != 2 ? pageToApply != 3 ? pageToApply != 4 ? pageToApply != 5 ? "f" : "b" : "a" : "e" : "d" : "c");
    }

    public final void logTemplateStyleSA() {
        ArrayList<String> loggingDetails = getLoggingDetails();
        if (loggingDetails == null || loggingDetails.size() < 2) {
            return;
        }
        Constant.Type type = this.mType;
        if (type == Constant.Type.CREATE_NOTE) {
            String str = loggingDetails.get(0);
            Intrinsics.checkNotNullExpressionValue(str, "get(...)");
            String str2 = loggingDetails.get(1);
            Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
            logFabSA(str, str2);
            return;
        }
        if (type == Constant.Type.STYLE_CHANGE) {
            String str3 = loggingDetails.get(0);
            Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
            String str4 = loggingDetails.get(1);
            Intrinsics.checkNotNullExpressionValue(str4, "get(...)");
            logPageStyleSA(str3, str4);
            return;
        }
        String str5 = loggingDetails.get(0);
        Intrinsics.checkNotNullExpressionValue(str5, "get(...)");
        String str6 = loggingDetails.get(1);
        Intrinsics.checkNotNullExpressionValue(str6, "get(...)");
        logPageSorterSA(str5, str6);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        AiCommonUtil.onActivityResult(this, requestCode, resultCode, data);
        Logger.m10999d(TAG, "onActivityResult# requestCode:" + requestCode + ", resultCode:" + resultCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    public final void onClickCoverGenerate() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
            if ((coverStylePresenter != null ? coverStylePresenter.getCoverData() : null) == null) {
                Logger.m11000e(NoteStyleLayout.TAG, "onClickCoverGenerate# coverData is null");
                return;
            }
            CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
            CoverData coverData = coverStylePresenter2 != null ? coverStylePresenter2.getCoverData() : null;
            Intrinsics.checkNotNull(coverData);
            if (coverData.getGenerateState() == 1) {
                Logger.m10999d(NoteStyleLayout.TAG, "onClickCoverGenerate# generating a cover");
                return;
            }
            CoverStylePresenter coverStylePresenter3 = this.mCoverPresenter;
            CoverData coverData2 = coverStylePresenter3 != null ? coverStylePresenter3.getCoverData() : null;
            Intrinsics.checkNotNull(coverData2);
            if (coverData2.getExtractStr() == null) {
                Logger.m11000e(NoteStyleLayout.TAG, "onClickCoverGenerate# extractStr is null");
                return;
            }
            CoverStylePresenter coverStylePresenter4 = this.mCoverPresenter;
            CoverData coverData3 = coverStylePresenter4 != null ? coverStylePresenter4.getCoverData() : null;
            Intrinsics.checkNotNull(coverData3);
            if (coverData3.getAvailableAutoCover()) {
                AiCommonUtil.executeActionByServer(this, new RunnableC10350a(this, 0));
            } else {
                Logger.m10999d(NoteStyleLayout.TAG, "onClickCoverGenerate# Generate cover not available");
            }
        }
    }

    public final void onCompleteAndUpdateView(@NotNull String summary, @NotNull String templateUuid, @NotNull String colorUuid, @NotNull String stickerUuid) {
        Intrinsics.checkNotNullParameter(summary, "summary");
        Intrinsics.checkNotNullParameter(templateUuid, "templateUuid");
        Intrinsics.checkNotNullParameter(colorUuid, "colorUuid");
        Intrinsics.checkNotNullParameter(stickerUuid, "stickerUuid");
        Logger.m10999d(TAG, "onCompleteAndUpdateView#");
        CoverStyleFragment coverStyleFragment = this.mCoverStyleFragment;
        if (coverStyleFragment != null && coverStyleFragment != null) {
            coverStyleFragment.updateCover(templateUuid, colorUuid, stickerUuid);
        }
        NoteStyleLayout noteStyleLayout = this.mNoteStyleLayout;
        if (noteStyleLayout != null) {
            noteStyleLayout.onCompleteAndUpdateView(summary);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Logger.m10999d(TAG, "onConfigurationChanged# ");
        applyWindowInsetsToContainer();
        updateActivityContainer();
        updateBackgroundColor();
        updateCallbackForDialog();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateBackgroundColor();
        initParams(savedInstanceState);
        initCoverExtractListener();
        initCoverData(savedInstanceState);
        initCoverPresenter();
        AbstractC0000a.m3D(this.mGravity, "onCreate# ", TAG);
        setContentView(C9086R.layout.note_style_activity);
        initLayout(savedInstanceState);
        applyWindowInsetsToContainer();
        initActivityContainer();
        setBackPressedListener();
        WindowManagerCompat.controllIndicatorBar$default(WindowManagerCompat.INSTANCE.getInstance(), this, getResources().getConfiguration().orientation, false, 4, null);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy");
        cancelCoverGenerate();
        NoteStyleLayout noteStyleLayout = this.mNoteStyleLayout;
        if (noteStyleLayout != null) {
            noteStyleLayout.destroyView();
        }
        AiCommonUtil.releaseActionStatus(this);
        CoverExtractTextReceiver.INSTANCE.setResultListener(null);
        unregisterReceiver(this, this.mExtractTextReceiver);
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        if (intent.getBooleanExtra(ComposerConstants.ARG_COVER_EDITOR_FORCE_FINISH, false)) {
            Logger.m10999d(TAG, "onNewIntent# force finish");
            setResult(0);
            finish();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Logger.m10999d(TAG, "onResume# ");
        applyWindowInsetsToContainer();
        updateActivityContainer();
        updateBackgroundColor();
        updateConfirmBtnBg();
        updateCallbackForDialog();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(Constant.KEY_GRAVITY, this.mGravity);
        outState.putInt("key_type", this.mType.ordinal());
        outState.putParcelable(KEY_ORIGIN_COVER, this.mOriginCoverData);
        CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
        outState.putParcelable(KEY_EDITED_COVER, coverStylePresenter != null ? coverStylePresenter.getCoverData() : null);
        outState.putString(CoverData.KEY_EXTRACT_TEXT, this.mExtractText);
        NoteStyleLayout noteStyleLayout = this.mNoteStyleLayout;
        if (noteStyleLayout != null) {
            noteStyleLayout.onSaveInstanceState(outState);
        }
    }

    public final void registerReceiver(@Nullable Context context, @Nullable CoverExtractTextReceiver receivedReceiver) {
        Logger.m10999d(TAG, "registerReceiver");
        if (context == null || receivedReceiver == null) {
            return;
        }
        LocalBroadcastManager.getInstance(context).registerReceiver(receivedReceiver, new IntentFilter(ACTION_EXTRACT_TEXT));
    }

    public final void requestCoverGenerate() {
        Logger.m10999d(TAG, "requestCoverGenerate");
        AiCoverDataCreatorManager aiCoverDataCreatorManager = AiCoverDataCreatorManager.getInstance();
        CoverStylePresenter coverStylePresenter = this.mCoverPresenter;
        CoverData coverData = coverStylePresenter != null ? coverStylePresenter.getCoverData() : null;
        Intrinsics.checkNotNull(coverData);
        String noteUuid = coverData.getNoteUuid();
        CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
        CoverData coverData2 = coverStylePresenter2 != null ? coverStylePresenter2.getCoverData() : null;
        Intrinsics.checkNotNull(coverData2);
        aiCoverDataCreatorManager.requestCreateCoverData(noteUuid, coverData2.getExtractStr(), new AiCoverDataCreator.ProcessCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.NoteStyleActivity.requestCoverGenerate.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
            public void onCompleted(String title, String summary, String category) {
                Intrinsics.checkNotNullParameter(title, "title");
                Intrinsics.checkNotNullParameter(summary, "summary");
                Intrinsics.checkNotNullParameter(category, "category");
                AbstractC8014b.m7213o(AbstractC0000a.m16m("requestCoverGenerate# onCompleted# title : ", Logger.getEncode(title), ", summary : ", Logger.getEncode(summary), ", category : "), category, NoteStyleActivity.TAG);
                Context appContext = ApplicationManager.INSTANCE.getInstance().getAppContext();
                CoverStyleUtils coverStyleUtils = CoverStyleUtils.INSTANCE;
                String randomTemplate = coverStyleUtils.getRandomTemplate();
                String randomColor = coverStyleUtils.getRandomColor();
                CoverData coverData3 = NoteStyleActivity.this.mOriginCoverData;
                if (TextUtils.isEmpty(coverData3 != null ? coverData3.getTitle() : null)) {
                    if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                        CoverStyleFragment coverStyleFragment = NoteStyleActivity.this.mCoverStyleFragment;
                        if (coverStyleFragment != null) {
                            String aiGeneratedLabelText = CoverEditorUtils.getAiGeneratedLabelText(appContext, title, 4);
                            Intrinsics.checkNotNullExpressionValue(aiGeneratedLabelText, "getAiGeneratedLabelText(...)");
                            coverStyleFragment.setTitle(aiGeneratedLabelText);
                        }
                    } else {
                        CoverStyleFragment coverStyleFragment2 = NoteStyleActivity.this.mCoverStyleFragment;
                        if (coverStyleFragment2 != null) {
                            coverStyleFragment2.setTitle(title);
                        }
                    }
                    CoverStylePresenter coverStylePresenter3 = NoteStyleActivity.this.mCoverPresenter;
                    if (coverStylePresenter3 != null) {
                        coverStylePresenter3.setIsGeneratedTitle(true);
                    }
                }
                if (CscFeature.INSTANCE.getInstance().isChinaAiFeature()) {
                    CoverStylePresenter coverStylePresenter4 = NoteStyleActivity.this.mCoverPresenter;
                    if (coverStylePresenter4 != null) {
                        coverStylePresenter4.setGenerateState(4);
                    }
                    CoverStylePresenter coverStylePresenter5 = NoteStyleActivity.this.mCoverPresenter;
                    if (coverStylePresenter5 != null) {
                        coverStylePresenter5.setSummary(CoverEditorUtils.getAiGeneratedLabelText(appContext, summary, 4));
                    }
                } else {
                    CoverStylePresenter coverStylePresenter6 = NoteStyleActivity.this.mCoverPresenter;
                    if (coverStylePresenter6 != null) {
                        coverStylePresenter6.setSummary(summary);
                    }
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NoteStyleActivity$requestCoverGenerate$1$onCompleted$1(NoteStyleActivity.this, randomTemplate, randomColor, category, null), 3, null);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.Callback
            public void onFailed(String errorCode) {
                Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                Logger.m10999d(NoteStyleActivity.TAG, "requestCoverGenerate# onFailed# errorCode : " + errorCode);
                if (Intrinsics.areEqual("RESTRICTED_USER_ERROR", errorCode)) {
                    return;
                }
                String errorMessage = AiCoverDataCreator.getErrorMessage(errorCode);
                Logger.m10999d(NoteStyleActivity.TAG, "requestCoverGenerate# onFailed : " + errorMessage);
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new NoteStyleActivity$requestCoverGenerate$1$onFailed$1(NoteStyleActivity.this, errorMessage, null), 3, null);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.cover.AiCoverDataCreator.ProcessCallback
            public void onStart() {
                Logger.m10999d(NoteStyleActivity.TAG, "requestCoverGenerate# onStart");
                NoteStyleActivity.this.enableEditor(false);
                NoteStyleActivity.this.setAvailableGenerateCover(false);
                NoteStyleLayout noteStyleLayout = NoteStyleActivity.this.mNoteStyleLayout;
                if (noteStyleLayout != null) {
                    noteStyleLayout.startAnimation();
                }
                CoverStylePresenter coverStylePresenter3 = NoteStyleActivity.this.mCoverPresenter;
                if (coverStylePresenter3 != null) {
                    coverStylePresenter3.setGenerateState(1);
                }
            }
        });
    }

    @MainThread
    public final void setAvailableGenerateCover(boolean isAvailable) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C103481(isAvailable, this, null), 3, null);
    }

    public final void unregisterReceiver(@Nullable Context context, @Nullable CoverExtractTextReceiver receivedReceiver) {
        Logger.m10999d(TAG, "unregisterReceiver");
        if (context == null || receivedReceiver == null) {
            return;
        }
        LocalBroadcastManager.getInstance(context).unregisterReceiver(receivedReceiver);
    }

    public final void updateConfirmBtn() {
        CoverData coverData;
        CoverData coverData2 = this.mEditedCoverData;
        boolean z = (coverData2 == null || (coverData = this.mOriginCoverData) == null || coverData.equals(coverData2)) ? false : true;
        BaseTemplateStyleFragment baseTemplateStyleFragment = this.mTemplateStyleFragment;
        Intrinsics.checkNotNull(baseTemplateStyleFragment, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.PageTemplateStyleFragment");
        boolean zHasSelectedTemplate = ((PageTemplateStyleFragment) baseTemplateStyleFragment).hasSelectedTemplate();
        if (z || zHasSelectedTemplate) {
            enableConfirmBtn(true);
        } else {
            enableConfirmBtn(false);
        }
    }

    public final void updateConfirmBtnBg() {
        if (ButtonBackgroundUtils.isShowButtonShapeEnabled(this) || SettingsCompat.INSTANCE.getInstance().isHighTextContrastEnabled(this)) {
            TextView textView = this.mConfirm;
            if (textView != null) {
                textView.setTextColor(getResources().getColor(C9086R.color.highlight_btn_text));
            }
            TextView textView2 = this.mConfirm;
            if (textView2 != null) {
                textView2.setBackgroundColor(getResources().getColor(C9086R.color.highlight_btn_bg));
                return;
            }
            return;
        }
        TextView textView3 = this.mConfirm;
        if (textView3 != null) {
            textView3.setTextColor(getResources().getColor(C9086R.color.highlight_btn_bg));
        }
        TextView textView4 = this.mConfirm;
        if (textView4 != null) {
            textView4.setBackgroundColor(getResources().getColor(C9086R.color.transparent));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean updateCoverResultIntent(@NotNull Intent intent) {
        boolean z;
        CoverStylePresenter coverStylePresenter;
        CoverData coverData;
        Intrinsics.checkNotNullParameter(intent, "intent");
        CoverStylePresenter coverStylePresenter2 = this.mCoverPresenter;
        if (coverStylePresenter2 != null) {
            coverStylePresenter2.saveCoverData("saveResult");
        }
        CoverStylePresenter coverStylePresenter3 = this.mCoverPresenter;
        if (!TextUtils.isEmpty(coverStylePresenter3 != null ? coverStylePresenter3.getNoteUuid() : null) && WidgetAccessHandler.getWidgetAccessContract() != null) {
            WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
            Intrinsics.checkNotNull(widgetAccessContract);
            CoverStylePresenter coverStylePresenter4 = this.mCoverPresenter;
            widgetAccessContract.sendUpdateUuidWidgetBroadcast(this, coverStylePresenter4 != null ? coverStylePresenter4.getNoteUuid() : null);
        }
        CoverData coverData2 = this.mOriginCoverData;
        boolean z2 = false;
        if (coverData2 == null) {
            z = false;
        } else {
            CoverStylePresenter coverStylePresenter5 = this.mCoverPresenter;
            if (Intrinsics.areEqual(coverData2, coverStylePresenter5 != null ? coverStylePresenter5.getCoverData() : null)) {
                z = true;
            }
        }
        boolean z3 = !z;
        CoverData coverData3 = this.mOriginCoverData;
        if (TextUtils.isEmpty(coverData3 != null ? coverData3.getTitle() : null)) {
            CoverStylePresenter coverStylePresenter6 = this.mCoverPresenter;
            if (!TextUtils.isEmpty((coverStylePresenter6 == null || (coverData = coverStylePresenter6.getCoverData()) == null) ? null : coverData.getTitle())) {
                z2 = true;
            }
        }
        intent.putExtra(CoverData.KEY_IS_CHANGED, z3);
        intent.putExtra(CoverData.KEY_IS_TITLE_CHANGED, z2);
        CoverStylePresenter coverStylePresenter7 = this.mCoverPresenter;
        intent.putExtra(CoverData.KEY_COVER_DATA, coverStylePresenter7 != null ? coverStylePresenter7.getCoverData() : null);
        CoverStylePresenter coverStylePresenter8 = this.mCoverPresenter;
        if (coverStylePresenter8 != null && coverStylePresenter8.getEnabled()) {
            CoverStylePresenter coverStylePresenter9 = this.mCoverPresenter;
            if (!TextUtils.isEmpty(coverStylePresenter9 != null ? coverStylePresenter9.getNoteUuid() : null) && (coverStylePresenter = this.mCoverPresenter) != null) {
                coverStylePresenter.savePreviewJpgWithView();
            }
        }
        return z3;
    }
}
