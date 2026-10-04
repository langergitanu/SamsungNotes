package com.samsung.android.support.senl.p148nt.app.settings.common.utils;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.StringRes;
import androidx.core.graphics.ColorUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.importing.core.types.MemoLocalSync;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.support.senl.p145cm.base.common.util.EnvironmentUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.common.util.UnicodeUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.PackageManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.desktopmode.DesktopModeCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserHandleCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.biometrics.fingerprint.FingerprintApi;
import com.samsung.android.support.senl.p148nt.app.biometrics.iris.IrisApi;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.settings.external.ContactUs;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.AppInfoContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.inapp.ContinuityServiceManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.mcf.utils.MCFUtil;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.Features;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.DeveloperMode;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.ScsUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiActionStatus;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.collector.util.RecognitionUtil;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.ContextAwarenessFeature;
import com.samsung.android.support.senl.p148nt.model.contextawareness.common.permission.DeepSkyPermissionHelper;
import com.samsung.android.support.senl.p148nt.model.converter.ConvertTaskManager;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.C0158a;
import p086V.C0322h;
import p207n1.C13540g;
import p207n1.C13541h;
import p211o0.C13567a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0015\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0012\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001a\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001b\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u001d\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u001c\u0010\u001f\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u001a\u0010\"\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010 \u001a\u0004\u0018\u00010!J\u001c\u0010#\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u001a\u0010&\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010$\u001a\u0004\u0018\u00010%J\u0012\u0010'\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u00108\u001a\u00020\u0007H\u0007J\u0012\u0010I\u001a\u00020J2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010K\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010L\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010M\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010U\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010_\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010`\u001a\u00020\u000eH\u0007J\u0012\u0010a\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010b\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010c\u001a\u00020d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010e\u001a\u00020\u0005J\u0012\u0010f\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010i\u001a\u00020\u0007H\u0007J\u0010\u0010m\u001a\u00020\u00052\u0006\u0010n\u001a\u00020oH\u0007J\u0012\u0010y\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010z\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\b\u0010{\u001a\u00020\u000eH\u0007J\u001c\u0010\u0080\u0001\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0081\u0001\u001a\u00020\u000eH\u0007J%\u0010\u0080\u0001\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0007\u0010\u0081\u0001\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020\u000eH\u0007J\u0013\u0010\u0083\u0001\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003J\u0013\u0010\u0084\u0001\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\r\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0018\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010)\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0003\u001a\u0004\b)\u0010\u0010R\u001a\u0010,\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0003\u001a\u0004\b,\u0010\u0010R\u0011\u0010.\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b.\u0010\u0010R\u0011\u0010/\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b/\u0010\u0010R\u0011\u00100\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b0\u0010\u0010R\u0011\u00101\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b1\u0010\u0010R\u0011\u00102\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b2\u0010\u0010R\u0011\u00103\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b3\u0010\u0010R\u001a\u00104\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0003\u001a\u0004\b4\u0010\u0010R\u0011\u00106\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b6\u0010\u0010R\u0011\u00107\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b7\u0010\u0010R\u0011\u00109\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b9\u0010\u0010R\u001a\u0010:\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0003\u001a\u0004\b:\u0010\u0010R\u0011\u0010<\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b<\u0010\u0010R\u001a\u0010=\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0003\u001a\u0004\b=\u0010\u0010R\u001a\u0010?\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0003\u001a\u0004\b?\u0010\u0010R\u001a\u0010A\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bB\u0010\u0003\u001a\u0004\bA\u0010\u0010R\u001a\u0010C\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bD\u0010\u0003\u001a\u0004\bC\u0010\u0010R\u001a\u0010E\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0003\u001a\u0004\bE\u0010\u0010R\u001a\u0010G\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0003\u001a\u0004\bG\u0010\u0010R\u001a\u0010N\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0003\u001a\u0004\bN\u0010\u0010R\u0011\u0010P\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bP\u0010\u0010R\u001a\u0010Q\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010\u0003\u001a\u0004\bQ\u0010\u0010R\u001a\u0010S\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0003\u001a\u0004\bS\u0010\u0010R\u001a\u0010V\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bW\u0010\u0003\u001a\u0004\bV\u0010\u0010R\u001a\u0010X\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bY\u0010\u0003\u001a\u0004\bX\u0010\u0010R\u001a\u0010Z\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\u0003\u001a\u0004\bZ\u0010\u0010R\u0011\u0010\\\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0010R\u001a\u0010]\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\b^\u0010\u0003\u001a\u0004\b]\u0010\u0010R\u001a\u0010g\u001a\u00020\u000e8FX\u0087\u0004¢\u0006\f\u0012\u0004\bh\u0010\u0003\u001a\u0004\bg\u0010\u0010R\u001a\u0010j\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\bk\u0010\u0003\u001a\u0004\bl\u0010\tR\u001a\u0010p\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\bq\u0010\u0003\u001a\u0004\br\u0010\tR\u001a\u0010s\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\bt\u0010\u0003\u001a\u0004\bu\u0010\tR\u001a\u0010v\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\bw\u0010\u0003\u001a\u0004\bx\u0010\tR\u0011\u0010|\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b|\u0010\u0010R\u001a\u0010}\u001a\u00020\u00078GX\u0087\u0004¢\u0006\f\u0012\u0004\b~\u0010\u0003\u001a\u0004\b\u007f\u0010\t¨\u0006\u0085\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/settings/common/utils/SettingsMenuUtils;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "samsungNotesAppLabelRes", "", "getSamsungNotesAppLabelRes", "()I", "samsungNotesSettingTitleRes", "getSamsungNotesSettingTitleRes$annotations", "getSamsungNotesSettingTitleRes", "isSamsungCloudSyncSupported", "", "isSamsungCloudSyncSupported$annotations", "()Z", "getSamsungCloudSyncMenuTitleRes", "context", "Landroid/content/Context;", "isMicrosoftSyncSupported", "isMicrosoftSyncSupported$annotations", "isSharedNotesSyncSupported", "isScreenOffMemoStyleSupported", "isScreenOffMemoStyleVisible", "isScreenOffMemoStyleVisible$annotations", "getLockNotesTitleRes", "isLockNotesSupported", "isLockNotesAccessEnabled", "isLockNoteSetPasswordEnabled", "getLockNotesSetPasswordTitleRes", "isLockNotesUsingFingerprintSupported", "fingerprintApi", "Lcom/samsung/android/support/senl/nt/app/biometrics/fingerprint/FingerprintApi;", "isFingerprintDeviceSupported", "isLockNotesUsingIrisSupported", "irisApi", "Lcom/samsung/android/support/senl/nt/app/biometrics/iris/IrisApi;", "isIrisDeviceSupported", "isBiometricSupported", "isConvertYourNoteVisible", "isConvertYourNoteEnabled", "isConvertYourNoteEnabled$annotations", "isImportDataSupported", "isEnableTrashVisible", "isEnableTrashVisible$annotations", "isNotesAssistSupported", "isAutoDetectLanguageSupported", "isSupportSTTAutoDetectLanguage", "isQuickToolsSupported", "isDefaultEditingModeSupported", "isAutoDetectLanguageVisible", "isNotesAssistVisible", "isNotesAssistVisible$annotations", "isDrawingAssistSupported", "isDrawingAssistVisible", "getDrawingAssistTitleRes", "isNotesAssistOnDeviceSummaryVisible", "isAutoTranscribeVisible", "isAutoTranscribeVisible$annotations", "isAutoTranscribeSupported", "isAutoSaveNoteChecked", "isAutoSaveNoteChecked$annotations", "isShowLinksInNoteChecked", "isShowLinksInNoteChecked$annotations", "isShowWebPreviewsChecked", "isShowWebPreviewsChecked$annotations", "isClippingOptionsSupported", "isClippingOptionsSupported$annotations", "isClippingOptionsEnabled", "isClippingOptionsEnabled$annotations", "isClippingOptionsChecked", "isClippingOptionsChecked$annotations", "getClippingOptionsSummary", "", "isActionIconsSupported", "isActionIconsEnabled", "getActionIconsSummaryRes", "isActionIconsChecked", "isActionIconsChecked$annotations", "isHideScrollBarWhileEditingSupported", "isHideScrollBarWhileEditingChecked", "isHideScrollBarWhileEditingChecked$annotations", "isHideNavigationBarWhileWritingSupported", "isHideNavigationBarWhileWritingSupported$annotations", "isHWRLanguageSupported", "isHideNavigationBarWhileEditingChecked", "isHideNavigationBarWhileEditingChecked$annotations", "isBlockBackKeyWhileEditing", "isBlockBackKeyWhileEditing$annotations", "isQuickToolEnabled", "isQuickToolEnabled$annotations", "isSTTLanguageSupported", "isUsePhoneAsToolbarSupported", "isUsePhoneAsToolbarSupported$annotations", "isUsePhoneAsToolbarEnabled", "isUsePhoneAsToolbarVisible", "getUsePhoneAsToolbarSummaryRes", "getDefaultEditingMode", "setDefaultEditingMode", "", "defaultEditingMode", "isContactUsSupported", "isImportNotesSupported", "isImportNotesSupported$annotations", "getSamsungInternetTitleRes", "importNotesCategoryTitleRes", "getImportNotesCategoryTitleRes$annotations", "getImportNotesCategoryTitleRes", "addLayoutDirectionMarkToString", "title", "", "importFromDeviceTitleRes", "getImportFromDeviceTitleRes$annotations", "getImportFromDeviceTitleRes", "importFromDeviceSummaryRes", "getImportFromDeviceSummaryRes$annotations", "getImportFromDeviceSummaryRes", "importFromSamsungAccountTitleRes", "getImportFromSamsungAccountTitleRes$annotations", "getImportFromSamsungAccountTitleRes", "isImportSNotesFromGoogleDriveSupported", "isImportMemosFromPhoneSupported", "isImportFromSamsungAccountSupported", "isPermissionsSupported", "aboutSamsungNotesTitleRes", "getAboutSamsungNotesTitleRes$annotations", "getAboutSamsungNotesTitleRes", "getSummaryColor", "isPrimary", "enabled", "getPrimarySummaryColor", "getDefaultSummaryColor", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SettingsMenuUtils {

    @NotNull
    public static final SettingsMenuUtils INSTANCE = new SettingsMenuUtils();

    @NotNull
    private static final String TAG = "SettingsMenuUtils";

    private SettingsMenuUtils() {
    }

    @JvmStatic
    @NotNull
    public static final String addLayoutDirectionMarkToString(@NotNull CharSequence title) {
        Intrinsics.checkNotNullParameter(title, "title");
        return (LocaleUtils.isRTLMode() ? UnicodeUtils.RLM : "\u200e") + ((Object) title);
    }

    @StringRes
    public static final int getAboutSamsungNotesTitleRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.about_note_jp : C8003R.string.about_note;
    }

    @JvmStatic
    public static /* synthetic */ void getAboutSamsungNotesTitleRes$annotations() {
    }

    @JvmStatic
    @StringRes
    public static final int getActionIconsSummaryRes(@Nullable Context context) {
        return PackageManagerCompat.INSTANCE.getInstance().isPackageInstalled(context, Constants.CALCULATOR_PACKAGE_NAME, Constants.CALCULATOR_PACKAGE_MIN_VERSIONCODE) ? C8003R.string.settings_action_icons_summary : C8003R.string.settings_action_icons_summary_without_equations;
    }

    @JvmStatic
    @StringRes
    @NotNull
    public static final int[] getClippingOptionsSummary(@Nullable Context context) {
        PackageManagerCompat.Companion companion = PackageManagerCompat.INSTANCE;
        boolean zIsPackageInstalled = companion.getInstance().isPackageInstalled(context, ContextAwarenessFeature.MESSAGE_PACKAGE_NAME);
        boolean zIsPackageInstalled2 = companion.getInstance().isPackageInstalled(context, ContextAwarenessFeature.BROWSER_PACKAGE_NAME);
        int[] iArr = new int[2];
        if (zIsPackageInstalled2) {
            if (zIsPackageInstalled) {
                iArr[0] = C8003R.string.settings_clipping_options_summary;
            } else {
                iArr[0] = C8003R.string.settings_clipping_options_summary_without_message;
            }
            iArr[1] = INSTANCE.getSamsungInternetTitleRes();
            return iArr;
        }
        if (zIsPackageInstalled) {
            iArr[0] = C8003R.string.settings_clipping_options_summary_without_internet;
            iArr[1] = -1;
            return iArr;
        }
        iArr[0] = C8003R.string.settings_clipping_options_summary_without_message_and_internet;
        iArr[1] = -1;
        return iArr;
    }

    @ColorInt
    private final int getDefaultSummaryColor(Context context) {
        return context == null ? Color.argb(255, 140, 140, 145) : context.getColor(C8003R.color.settings_list_summary_text_color);
    }

    @JvmStatic
    @StringRes
    public static final int getDrawingAssistTitleRes() {
        return Features.isCreativeStudioSupported() ? C8003R.string.settings_creative_studio : C8003R.string.settings_drawing_assist;
    }

    @StringRes
    public static final int getImportFromDeviceSummaryRes() {
        return DeviceUtils.isTabletModel() ? C8003R.string.settings_import_details_tablet : C8003R.string.settings_import_details_phone;
    }

    @JvmStatic
    public static /* synthetic */ void getImportFromDeviceSummaryRes$annotations() {
    }

    @StringRes
    public static final int getImportFromDeviceTitleRes() {
        return DeviceUtils.isTabletModel() ? C8003R.string.settings_import_tablet : C8003R.string.settings_import_device;
    }

    @JvmStatic
    public static /* synthetic */ void getImportFromDeviceTitleRes$annotations() {
    }

    @StringRes
    public static final int getImportFromSamsungAccountTitleRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_import_samsung_account_jp : C8003R.string.settings_import_samsung_account;
    }

    @JvmStatic
    public static /* synthetic */ void getImportFromSamsungAccountTitleRes$annotations() {
    }

    @StringRes
    public static final int getImportNotesCategoryTitleRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes;
    }

    @JvmStatic
    public static /* synthetic */ void getImportNotesCategoryTitleRes$annotations() {
    }

    @JvmStatic
    @StringRes
    public static final int getLockNotesSetPasswordTitleRes(@Nullable Context context) {
        return LockUtils.isSetPassword(context) ? C8003R.string.settings_change_password : C8003R.string.settings_create_password;
    }

    @JvmStatic
    @StringRes
    public static final int getLockNotesTitleRes(@Nullable Context context) {
        return (new FingerprintApi(FingerprintApi.ImplType.FINGERPRINT_MANAGER).isDeviceAvailable(context) || new IrisApi(IrisApi.ImplType.IRIS_MANAGER).isDeviceAvailable(context)) ? C8003R.string.settings_password_and_biometrics : C8003R.string.settings_category_password;
    }

    @ColorInt
    private final int getPrimarySummaryColor(Context context) {
        return context == null ? Color.argb(255, 242, 84, 73) : SettingsCompat.INSTANCE.getInstance().isHighTextContrastEnabled(context) ? context.getColor(C8003R.color.settings_list_summary_text_color) : ResourceUtils.getPrimaryColor(context);
    }

    @JvmStatic
    @StringRes
    public static final int getSamsungCloudSyncMenuTitleRes(@Nullable Context context) {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_sync_accounts_jp : CommonUtils.hasSaSetting(context) ? C8003R.string.settings_sync_accounts_na : C8003R.string.settings_sync_accounts;
    }

    @StringRes
    public static final int getSamsungNotesSettingTitleRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.settings_title_jp : C8003R.string.settings_title;
    }

    @JvmStatic
    public static /* synthetic */ void getSamsungNotesSettingTitleRes$annotations() {
    }

    @JvmStatic
    @ColorInt
    public static final int getSummaryColor(@Nullable Context context, boolean isPrimary) {
        return INSTANCE.getSummaryColor(context, isPrimary, true);
    }

    public static final boolean isActionIconsChecked() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_ACTION_ICONS, true);
    }

    @JvmStatic
    public static /* synthetic */ void isActionIconsChecked$annotations() {
    }

    @JvmStatic
    public static final boolean isActionIconsEnabled(@Nullable Context context) {
        if (DeviceUtils.isPowerManageMode(context)) {
            return false;
        }
        DesktopModeCompat.Companion companion = DesktopModeCompat.INSTANCE;
        return !companion.getInstance().isDexMode(context) || companion.getInstance().isDexStandAloneMode(context);
    }

    @JvmStatic
    public static final boolean isActionIconsSupported(@Nullable Context context) {
        return RecognitionUtil.isSupported(context) && PackageManagerCompat.INSTANCE.getInstance().isSupportedActionLink(context) && DeviceUtils.isSpenModel();
    }

    public static final boolean isAutoSaveNoteChecked() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_AUTO_SAVE_NOTES, true);
    }

    @JvmStatic
    public static /* synthetic */ void isAutoSaveNoteChecked$annotations() {
    }

    public static final boolean isAutoTranscribeVisible() {
        return DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) || !AiActionStatus.isKidsAccountBlocked();
    }

    @JvmStatic
    public static /* synthetic */ void isAutoTranscribeVisible$annotations() {
    }

    @JvmStatic
    public static final boolean isBiometricSupported(@Nullable Context context) {
        return LockUtils.isSetPassword(context) && !LockUtils.isBiometricDisabledMode(context);
    }

    public static final boolean isBlockBackKeyWhileEditing() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_BLOCK_BACK_KEY_WHILE_EDITING, false);
    }

    @JvmStatic
    public static /* synthetic */ void isBlockBackKeyWhileEditing$annotations() {
    }

    public static final boolean isClippingOptionsChecked() {
        return DeepSkyPermissionHelper.isAllGrantedPermission() && SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_CLIPPING_OPTIONS, true);
    }

    @JvmStatic
    public static /* synthetic */ void isClippingOptionsChecked$annotations() {
    }

    public static final boolean isClippingOptionsEnabled() {
        return ContextAwarenessFeature.isSupportedMode();
    }

    @JvmStatic
    public static /* synthetic */ void isClippingOptionsEnabled$annotations() {
    }

    public static final boolean isClippingOptionsSupported() {
        return ContextAwarenessFeature.isContextAwarenessSupported();
    }

    @JvmStatic
    public static /* synthetic */ void isClippingOptionsSupported$annotations() {
    }

    @JvmStatic
    public static final boolean isContactUsSupported(@Nullable Context context) {
        return ContactUs.isAvailableContactUs(context) && !DeviceUtils.isPowerManageMode(context);
    }

    public static final boolean isConvertYourNoteEnabled() {
        return !ConvertTaskManager.getInstance().findConvertTaskGroup(2, 4, null);
    }

    @JvmStatic
    public static /* synthetic */ void isConvertYourNoteEnabled$annotations() {
    }

    @JvmStatic
    public static final boolean isConvertYourNoteVisible(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean zHasOldNoteInUse = NotesDataRepositoryFactory.newInstance(context).createNotesOldDocumentRepository().hasOldNoteInUse();
        AbstractC8014b.m7210l("isConvertYourNoteVisible, hasOldNoteInUse : ", TAG, zHasOldNoteInUse);
        return zHasOldNoteInUse;
    }

    public static final boolean isEnableTrashVisible() {
        return DeveloperMode.isOnDeveloperMode();
    }

    @JvmStatic
    public static /* synthetic */ void isEnableTrashVisible$annotations() {
    }

    @JvmStatic
    public static final boolean isHWRLanguageSupported(@Nullable Context context) {
        return RecognitionUtil.isSDKRecognitionSupported(context);
    }

    public static final boolean isHideNavigationBarWhileEditingChecked() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_NAVIGATION_BAR_WHILE_WRITING, CommonUtils.isDefaultHideNavigationOptionEnabled());
    }

    @JvmStatic
    public static /* synthetic */ void isHideNavigationBarWhileEditingChecked$annotations() {
    }

    public static final boolean isHideNavigationBarWhileWritingSupported() {
        return CommonUtils.isSupportHideNavigationOption();
    }

    @JvmStatic
    public static /* synthetic */ void isHideNavigationBarWhileWritingSupported$annotations() {
    }

    public static final boolean isHideScrollBarWhileEditingChecked() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_HIDE_SCROLL_BAR_WHILE_EDITING, false);
    }

    @JvmStatic
    public static /* synthetic */ void isHideScrollBarWhileEditingChecked$annotations() {
    }

    @JvmStatic
    public static final boolean isImportDataSupported(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (DeviceUtils.isDemoDevice(context)) {
            Debugger.INSTANCE.m8627i(TAG, "isImportDataSupported, demo device return false");
            return false;
        }
        if (DeviceInfo.isOtherCorpDevice()) {
            Debugger.INSTANCE.m8627i(TAG, "isImportDataSupported, other corp device return false");
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        C13541h.f9587g = applicationContext;
        C6875b.f4373v = applicationContext;
        C0322h c0322hM670a = C0322h.m670a();
        if (c0322hM670a.f815a == null) {
            Debugger.INSTANCE.m8627i(TAG, "isImportDataSupported, AppInfoContract is null!");
            c0322hM670a.f815a = new AppInfoContractImpl(context.getApplicationContext());
        }
        C0158a.m407a().getClass();
        if (C0158a.m411g()) {
            return true;
        }
        Debugger.INSTANCE.m8627i(TAG, "isImportDataSupported, import feature is not supported return false");
        return false;
    }

    @JvmStatic
    public static final boolean isImportFromSamsungAccountSupported() {
        return !C13541h.m14287e().m14292f();
    }

    @JvmStatic
    public static final boolean isImportMemosFromPhoneSupported(@Nullable Context context) {
        return context != null && MemoLocalSync.isAppInstalled(context);
    }

    public static final boolean isImportNotesSupported() {
        return DeviceInfo.getSemPlatformVersionInt(0) < 110500;
    }

    @JvmStatic
    public static /* synthetic */ void isImportNotesSupported$annotations() {
    }

    @JvmStatic
    public static final boolean isImportSNotesFromGoogleDriveSupported(@Nullable Context context) {
        return (context == null || Build.VERSION.SDK_INT > 34 || SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() || UserHandleCompat.INSTANCE.getInstance().isKnoxMode() || EnvironmentUtils.isRunningUnderKnox(context)) ? false : true;
    }

    @JvmStatic
    public static final boolean isLockNoteSetPasswordEnabled(@Nullable Context context) {
        return DeviceUtils.isSupportedSetLockPassword(context);
    }

    @JvmStatic
    public static final boolean isLockNotesAccessEnabled(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        C13541h.f9587g = applicationContext;
        C6875b.f4373v = applicationContext;
        return ((C13540g) C13541h.m14287e().f9588a).m14285a();
    }

    @JvmStatic
    public static final boolean isLockNotesSupported(@Nullable Context context) {
        return DeviceUtils.isSupportedLock(context);
    }

    @JvmStatic
    public static final boolean isLockNotesUsingFingerprintSupported(@Nullable Context context, @Nullable FingerprintApi fingerprintApi) {
        if (isBiometricSupported(context)) {
            return INSTANCE.isFingerprintDeviceSupported(context, fingerprintApi);
        }
        return false;
    }

    @JvmStatic
    public static final boolean isLockNotesUsingIrisSupported(@Nullable Context context, @Nullable IrisApi irisApi) {
        if (isBiometricSupported(context)) {
            return INSTANCE.isIrisDeviceSupported(context, irisApi);
        }
        return false;
    }

    public static final boolean isMicrosoftSyncSupported() {
        if (!NotesUtils.isMsSyncSupported() || C13541h.m14287e().m14292f() || UserManagerCompat.INSTANCE.getInstance().isDigitalLegacyMode(BaseUtils.getApplicationContext())) {
            return false;
        }
        return (C13567a.m14371a().m14372c() && AbstractC4539a.m3210t()) ? false : true;
    }

    @JvmStatic
    public static /* synthetic */ void isMicrosoftSyncSupported$annotations() {
    }

    public static final boolean isNotesAssistVisible() {
        return DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) || !AiActionStatus.isKidsAccountBlocked();
    }

    @JvmStatic
    public static /* synthetic */ void isNotesAssistVisible$annotations() {
    }

    public static final boolean isQuickToolEnabled() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_QUICK_TOOLS, true);
    }

    @JvmStatic
    public static /* synthetic */ void isQuickToolEnabled$annotations() {
    }

    public static final boolean isSamsungCloudSyncSupported() {
        return DeviceUtils.isSupportedSync(C0158a.m407a().f492a) && !C13541h.m14287e().m14292f();
    }

    @JvmStatic
    public static /* synthetic */ void isSamsungCloudSyncSupported$annotations() {
    }

    @JvmStatic
    public static final boolean isScreenOffMemoStyleSupported(@Nullable Context context) {
        UserHandleCompat.Companion companion = UserHandleCompat.INSTANCE;
        return (companion.getInstance().isSecureFolderMode() || companion.getInstance().isKnoxMode() || !SettingsCompat.INSTANCE.getInstance().isScreenOffMemoEnabled(context)) ? false : true;
    }

    public static final boolean isScreenOffMemoStyleVisible() {
        return ComposerSpenUtils.isSpenActivated();
    }

    @JvmStatic
    public static /* synthetic */ void isScreenOffMemoStyleVisible$annotations() {
    }

    public static final boolean isShowLinksInNoteChecked() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_LINKS_IN_NOTES, true);
    }

    @JvmStatic
    public static /* synthetic */ void isShowLinksInNoteChecked$annotations() {
    }

    public static final boolean isShowWebPreviewsChecked() {
        return SharedPreferencesCompat.INSTANCE.getInstance("Settings").getBoolean(SettingsConstants.SETTINGS_SHOW_WEB_PREVIEWS, false);
    }

    @JvmStatic
    public static /* synthetic */ void isShowWebPreviewsChecked$annotations() {
    }

    @JvmStatic
    public static final boolean isUsePhoneAsToolbarEnabled(@Nullable Context context) {
        return !ContextUtils.isNightMode(context);
    }

    public static final boolean isUsePhoneAsToolbarSupported() {
        if (!DeviceUtils.isTabletModel()) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false not TabletModel");
            return false;
        }
        if (DesktopModeCompat.INSTANCE.getInstance().isDexMode(BaseUtils.getApplicationContext())) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false DexMode");
            return false;
        }
        if (Build.VERSION.SDK_INT <= 30) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false Below R OS");
            return false;
        }
        ContinuityServiceManager.Companion companion = ContinuityServiceManager.INSTANCE;
        if (!companion.isContinuityFeatureEnabled()) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false ContinuityFeatureEnabled");
            return false;
        }
        if (!companion.isContinuityServiceVersionSupported()) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false ContinuityServiceVersionSupported");
            return false;
        }
        UserHandleCompat.Companion companion2 = UserHandleCompat.INSTANCE;
        if (companion2.getInstance().isSecureFolderMode()) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false SecureFolderMode");
            return false;
        }
        if (companion2.getInstance().isKnoxMode()) {
            MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# false KnoxMode");
            return false;
        }
        boolean zIsSupportInAppServer = ModelFeature.getFeature().getIsSupportInAppServer();
        boolean z = SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 40100;
        MainLogger.m7254d(TAG, "isUsePhoneAsToolbarSupported# modelFeatureEnabled: " + zIsSupportInAppServer + ", isSupportedOnUiVersion: " + z);
        return zIsSupportInAppServer || z;
    }

    @JvmStatic
    public static /* synthetic */ void isUsePhoneAsToolbarSupported$annotations() {
    }

    @JvmStatic
    public static final boolean isUsePhoneAsToolbarVisible() {
        return ((C13540g) C13541h.m14287e().f9588a).m14285a();
    }

    @NotNull
    public final String getDefaultEditingMode(@Nullable Context context) {
        if (context == null) {
            MainLogger.m7255e(TAG, "getDefaultEditingMode() : context is null!");
            return SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO;
        }
        String string = SharedPreferencesCompat.INSTANCE.getInstance("Settings").getString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE_AUTO);
        Intrinsics.checkNotNull(string);
        AbstractC0000a.m25v("SETTINGS_DEFAULT_EDITING_MODE is ", string, TAG);
        return string;
    }

    @StringRes
    public final int getSamsungInternetTitleRes() {
        return (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() || SystemPropertiesCompat.INSTANCE.getInstance().getOneUIVersion() >= 50100) ? C8003R.string.settings_internet : C8003R.string.settings_samsung_internet;
    }

    @StringRes
    public final int getSamsungNotesAppLabelRes() {
        return CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8003R.string.notes_jp : C8003R.string.notes;
    }

    @StringRes
    public final int getUsePhoneAsToolbarSummaryRes(@Nullable Context context) {
        return MCFUtil.isContinuitySettingEnabled(context) ? C8003R.string.settings_use_phone_as_toolbar_global_setting_on_summary : DeviceInfo.getSemPlatformVersionInt(0) < 140000 ? C8003R.string.settings_use_phone_as_toolbar_global_setting_off_summary : C8003R.string.settings_use_phone_as_toolbar_global_setting_off_summary_sep_14;
    }

    public final boolean isAutoDetectLanguageSupported() {
        return Features.isSupportSTTFunction();
    }

    public final boolean isAutoDetectLanguageVisible() {
        return DeviceUtils.isAiShopDemoDevice(BaseUtils.getApplicationContext()) || !AiActionStatus.isKidsAccountBlocked();
    }

    public final boolean isAutoTranscribeSupported() {
        return Features.isSupportAiFunction() && Features.isSupportAutoTranscribeFunction();
    }

    public final boolean isDefaultEditingModeSupported() {
        return DeviceUtils.isSpenModel();
    }

    public final boolean isDrawingAssistSupported() {
        return isNotesAssistSupported() && Features.isSupportSketchToImageFunction();
    }

    public final boolean isDrawingAssistVisible() {
        return isNotesAssistVisible() && Features.isSupportSketchToImageFunction();
    }

    public final boolean isFingerprintDeviceSupported(@Nullable Context context, @Nullable FingerprintApi fingerprintApi) {
        return fingerprintApi != null && fingerprintApi.isDeviceAvailable(context);
    }

    public final boolean isHideScrollBarWhileEditingSupported() {
        return !DeviceInfo.isVSTModel();
    }

    public final boolean isIrisDeviceSupported(@Nullable Context context, @Nullable IrisApi irisApi) {
        return irisApi != null && irisApi.isDeviceAvailable(context);
    }

    public final boolean isNotesAssistOnDeviceSummaryVisible() {
        return isNotesAssistVisible() && Features.isSupportOnDeviceSummaryFunction() && !SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel();
    }

    public final boolean isNotesAssistSupported() {
        return Features.isSupportAiFunction();
    }

    public final boolean isPermissionsSupported() {
        SystemPropertiesCompat.Companion companion = SystemPropertiesCompat.INSTANCE;
        return companion.getInstance().isKoreaModel() || companion.getInstance().isChinaModel();
    }

    public final boolean isQuickToolsSupported() {
        return Features.isQuickToolsSupported();
    }

    public final boolean isSTTLanguageSupported() {
        return FeatureInfo.isSupportSTTFunction() && ScsUtils.isUseScs();
    }

    public final boolean isSharedNotesSyncSupported(@Nullable Context context) {
        return NotesUtils.isCoeditFeatureEnabled(context) && !C0145c.m339x(context);
    }

    public final boolean isSupportSTTAutoDetectLanguage() {
        return Features.isSupportSTTAutoDetectLanguage();
    }

    public final void setDefaultEditingMode(@Nullable Context context, @NotNull String defaultEditingMode) {
        Intrinsics.checkNotNullParameter(defaultEditingMode, "defaultEditingMode");
        if (context == null) {
            MainLogger.m7255e(TAG, "setDefaultEditingMode() : context is null!");
            return;
        }
        SharedPreferencesCompat.INSTANCE.getInstance("Settings").putString(SettingsConstants.SETTINGS_DEFAULT_EDITING_MODE, defaultEditingMode);
        MainLogger.m7254d(TAG, "save as settings_default_editing_mode= " + defaultEditingMode);
    }

    @ColorInt
    public final int getSummaryColor(@Nullable Context context, boolean isPrimary, boolean enabled) {
        int primarySummaryColor = isPrimary ? getPrimarySummaryColor(context) : getDefaultSummaryColor(context);
        return enabled ? primarySummaryColor : ColorUtils.setAlphaComponent(primarySummaryColor, 128);
    }
}
