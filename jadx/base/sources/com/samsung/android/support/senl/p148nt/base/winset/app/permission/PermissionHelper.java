package com.samsung.android.support.senl.p148nt.base.winset.app.permission;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.fragment.app.Fragment;
import androidx.test.core.app.RunnableC3900b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.samsung.android.sdk.mobileservice.social.social.BundleKey;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.PermissionCompat;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.SystemPropertiesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.DialogInterfaceOnDismissListenerC8211a;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.util.AppInfoUtil;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.snackbar.SnackbarHelper;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p046K2.DialogInterfaceOnClickListenerC0161a;
import p054M1.DialogInterfaceOnKeyListenerC0175b;
import p071Q2.ViewOnClickListenerC0219a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010#\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0015\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0083\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0007J\u0006\u0010/\u001a\u00020.J\u0010\u00100\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0005H\u0002J5\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u0001062\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u00109J+\u0010:\u001a\u00020#2\b\u0010;\u001a\u0004\u0018\u00010<2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0007J\u0012\u0010?\u001a\u00020.2\b\u00103\u001a\u0004\u0018\u000104H\u0003J\u0012\u0010@\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0007J1\u0010A\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\u00072\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010CJ9\u0010A\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\u00072\u0006\u0010D\u001a\u00020#2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010EJ;\u0010A\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u0001062\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010GJC\u0010A\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\u00072\u0006\u0010D\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u0001062\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010HJ1\u0010A\u001a\u00020.2\u0006\u0010I\u001a\u00020J2\u0006\u0010B\u001a\u00020\u00072\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010KJ9\u0010A\u001a\u00020.2\u0006\u0010I\u001a\u00020J2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010D\u001a\u00020#2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010LJC\u0010A\u001a\u00020.2\u0006\u0010I\u001a\u00020J2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010D\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u0001062\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010MJC\u0010A\u001a\u00020.2\u0006\u0010N\u001a\u00020O2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010D\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u0001062\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0002¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020#2\u0006\u0010D\u001a\u00020#H\u0002J\u0010\u0010R\u001a\u00020.2\u0006\u00103\u001a\u000204H\u0002J9\u0010S\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010B\u001a\u00020\u00072\b\u0010F\u001a\u0004\u0018\u0001062\u000e\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508H\u0002¢\u0006\u0002\u0010TJ1\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005082\u0006\u0010;\u001a\u00020<2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0002¢\u0006\u0002\u0010VJ\u0010\u0010W\u001a\u00020#2\u0006\u0010B\u001a\u00020\u0007H\u0002J\"\u0010X\u001a\u00020#2\u0006\u0010B\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u00072\b\u0010Z\u001a\u0004\u0018\u000106H\u0007J3\u0010[\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010\\\u001a\u00020]2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010^J;\u0010[\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u0001042\u0006\u0010B\u001a\u00020\u00072\u0006\u0010\\\u001a\u00020]2\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0007¢\u0006\u0002\u0010_J\u0018\u0010`\u001a\u00020#2\u0006\u00103\u001a\u0002042\u0006\u0010a\u001a\u00020\u0005H\u0002J)\u0010b\u001a\u00020.2\u0006\u00103\u001a\u0002042\u0012\u00107\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000508\"\u00020\u0005H\u0002¢\u0006\u0002\u0010cJ \u0010d\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\u0006\u0010a\u001a\u00020\u00052\u0006\u0010e\u001a\u00020#H\u0002J\u0018\u0010f\u001a\u00020#2\u0006\u0010;\u001a\u00020<2\u0006\u0010a\u001a\u00020\u0005H\u0002J\u0012\u0010g\u001a\u00020#2\b\u0010a\u001a\u0004\u0018\u00010\u0005H\u0002J%\u0010h\u001a\u00020.2\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000508\"\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010iJ\u000e\u0010j\u001a\u00020#2\u0006\u0010a\u001a\u00020\u0005J%\u0010k\u001a\u00020.2\u0006\u00103\u001a\u0002042\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000508H\u0002¢\u0006\u0002\u0010cJ/\u0010l\u001a\u00020.2\u0006\u00103\u001a\u0002042\b\u0010F\u001a\u0004\u0018\u0001062\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000508H\u0002¢\u0006\u0002\u0010mJ%\u0010n\u001a\u00020.2\u0006\u00103\u001a\u0002042\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000508H\u0002¢\u0006\u0002\u0010cJ\u001a\u0010o\u001a\u00020.2\u0006\u00103\u001a\u0002042\b\u0010p\u001a\u0004\u0018\u000106H\u0002J\u001a\u0010q\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\b\u0010p\u001a\u0004\u0018\u000106H\u0002J/\u0010r\u001a\u00020.2\u0006\u00103\u001a\u0002042\b\u0010F\u001a\u0004\u0018\u0001062\u000e\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000508H\u0002¢\u0006\u0002\u0010mJ\u0010\u0010s\u001a\u00020.2\u0006\u0010;\u001a\u00020<H\u0007J\"\u0010t\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\u0006\u0010u\u001a\u00020v2\b\u0010w\u001a\u0004\u0018\u00010\u0005H\u0003J$\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010;\u001a\u00020<2\b\u0010z\u001a\u0004\u0018\u00010y2\u0006\u0010{\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u00020.2\u0006\u0010;\u001a\u00020<H\u0002J\u0016\u0010}\u001a\u00020.2\f\u0010~\u001a\b\u0012\u0002\b\u0003\u0018\u00010&H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0003\u001a\u0004\b'\u0010)R\u001a\u0010*\u001a\u00020#8FX\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010)R#\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020\u0005088FX\u0087\u0004¢\u0006\u000f\u0012\u0005\b\u0080\u0001\u0010\u0003\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001¨\u0006\u0084\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionHelper;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "REQUEST_PERMISSION_FOR_OPEN_SAMSUNG_NOTES", "", "REQUEST_PERMISSION_FOR_STORAGE", "REQUEST_PERMISSION_FOR_SYNC_SAMSUNG_ACCOUNT_ENTER", "REQUEST_PERMISSION_FOR_SYNC_MICROSOFT_ENTER", "REQUEST_PERMISSION_FOR_SYNC_MICROSOFT_TURN_ON", "REQUEST_PERMISSION_FOR_SHARED_NOTEBOOK", "REQUEST_PERMISSION_FOR_COEDIT", "REQUEST_PERMISSION_FOR_IMPORT_NOTES_LOCAL", "REQUEST_PERMISSION_FOR_IMPORT_SNOTE_ACCOUNT", "REQUEST_PERMISSION_FOR_IMPORT_SNOTE_LOCAL", "REQUEST_PERMISSION_FOR_IMPORT_SNOTE_GOOGLEDRIVE", "REQUEST_PERMISSION_FOR_IMPORT_MEMO_LOCAL", "REQUEST_PERMISSION_FOR_IMPORT_MEMO_ACCOUNT", "REQUEST_PERMISSION_FOR_IMPORT_SCRAPBOOK_ACCOUNT", "REQUEST_PERMISSION_FOR_EXTERNAL_STORAGE_PICKER", "REQUEST_PERMISSION_FOR_IMPORT_SNBAK", "PREF_PERMISSION_CLICKED_NEVER_ASK", "REQUEST_ACTIVITY_FOR_GOTO_SETTINGS", "REQUEST_APP_PERMISSION_ACTIVITY", "REQUEST_APP_PERMISSION_FOR_EXTERNAL_STORAGE_PICKER", "SNACK_BAR_LONG_DURATION_MS", "KEY_NOTICE_APP_PERMISSION_NEED", "KEY_NOTICE_APP_PERMISSION_IS_NOT_CONFIRMED", "NOTICE_PERMISSION_MAX_COUNT", "mAppPermissionNoticedActivities", "", "mPrevShouldShowRationaleMap", "", "", "mRequestedPermissonMap", "NOTICE_PERMISSION_CLASS", "Ljava/lang/Class;", "isChinaPermissionNeeded", "isChinaPermissionNeeded$annotations", "()Z", "noticeAppPermissionNeededs", "getNoticeAppPermissionNeededs$annotations", "getNoticeAppPermissionNeededs", "setDoNotShowAppPermissionNotice", "", "increaseAppPermissionNoticedCount", "getAppPermissionNoticedCount", NotesConstants.KEY_CALLER, BundleKey.IS_PERMISSION_GRANTED, Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestPermissionsIfDenied", "Ljava/lang/Runnable;", "permissions", "", "(Landroid/app/Activity;Ljava/lang/Runnable;[Ljava/lang/String;)Z", "isPermissionGrantedWithoutNotice", "context", "Landroid/content/Context;", "(Landroid/content/Context;[Ljava/lang/String;)Z", "noticeAppPermissionActivityOnLock", "noticeAppPermissionActivity", "noticeAppPermissionIfNeededs", "requestPermissions", "requestCode", "(Landroid/app/Activity;I[Ljava/lang/String;)V", "closeIfNotAllowed", "(Landroid/app/Activity;IZ[Ljava/lang/String;)V", "postActionWhenDismissed", "(Landroid/app/Activity;ILjava/lang/Runnable;[Ljava/lang/String;)V", "(Landroid/app/Activity;IZLjava/lang/Runnable;[Ljava/lang/String;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;I[Ljava/lang/String;)V", "(Landroidx/fragment/app/Fragment;IZ[Ljava/lang/String;)V", "(Landroidx/fragment/app/Fragment;IZLjava/lang/Runnable;[Ljava/lang/String;)V", "activityWrapper", "Lcom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionHelper$RequestPermissionsWrapper;", "(Lcom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionHelper$RequestPermissionsWrapper;IZLjava/lang/Runnable;[Ljava/lang/String;)V", "isCloseActivityEnabled", "closeActivity", "canRequestPermissions", "(Landroid/app/Activity;ILjava/lang/Runnable;[Ljava/lang/String;)Z", "selectPermanentDeniedPermission", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "isAppStartRequest", "onActivityResult", "resultCode", "allowRunnable", "verifyRequestResult", "grantResults", "", "(Landroid/app/Activity;[I[Ljava/lang/String;)Z", "(Landroid/app/Activity;I[I[Ljava/lang/String;)Z", "isNeverAskClicked", "permission", "updatePrevShouldShowRationaleState", "(Landroid/app/Activity;[Ljava/lang/String;)V", "setIsPermanentDeniedPermission", "value", "getIsPermanentDeniedPermission", "getShouldShowRationaleBeforeRequest", "updateRequestedPermissionState", "([Ljava/lang/String;)V", "getRequestedPermissionState", "showGotoSettingsUIForAppStart", "showGotoSettingsUI", "(Landroid/app/Activity;Ljava/lang/Runnable;[Ljava/lang/String;)V", "showGotoSettingsActivity", "showGotoSettingsSnackBar", "postActionWhenDenied", "showGotoSettingsToast", "showGotoSettingsDialog", "showAppearOnTopToast", "addPermissionItem", "parentLayout", "Landroid/widget/LinearLayout;", "strPermission", "applyTint", "Landroid/graphics/drawable/Drawable;", "icon", "attr", "startAppDetailSettings", "setNoticePermissionActivity", "executor", "permissionsForRecordAudio", "getPermissionsForRecordAudio$annotations", "getPermissionsForRecordAudio", "()[Ljava/lang/String;", "RequestPermissionsWrapper", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nPermissionHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PermissionHelper.kt\ncom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,715:1\n1#2:716\n*E\n"})
public final class PermissionHelper {

    @NotNull
    public static final String KEY_NOTICE_APP_PERMISSION_IS_NOT_CONFIRMED = "key_notice_app_permision_is_not_confirmed";

    @NotNull
    private static final String KEY_NOTICE_APP_PERMISSION_NEED = "key_notice_app_permision_need";

    @Nullable
    private static Class<?> NOTICE_PERMISSION_CLASS = null;
    private static final int NOTICE_PERMISSION_MAX_COUNT = 3;

    @NotNull
    private static final String PREF_PERMISSION_CLICKED_NEVER_ASK = "pref_permission_clicked_never_ask";
    public static final int REQUEST_ACTIVITY_FOR_GOTO_SETTINGS = 51;
    public static final int REQUEST_APP_PERMISSION_ACTIVITY = 52;
    public static final int REQUEST_APP_PERMISSION_FOR_EXTERNAL_STORAGE_PICKER = 53;
    public static final int REQUEST_PERMISSION_FOR_COEDIT = 204;
    public static final int REQUEST_PERMISSION_FOR_EXTERNAL_STORAGE_PICKER = 307;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_MEMO_ACCOUNT = 305;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_MEMO_LOCAL = 304;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_NOTES_LOCAL = 300;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_SCRAPBOOK_ACCOUNT = 306;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_SNBAK = 308;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_SNOTE_ACCOUNT = 301;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_SNOTE_GOOGLEDRIVE = 303;
    public static final int REQUEST_PERMISSION_FOR_IMPORT_SNOTE_LOCAL = 302;
    public static final int REQUEST_PERMISSION_FOR_OPEN_SAMSUNG_NOTES = 101;
    public static final int REQUEST_PERMISSION_FOR_SHARED_NOTEBOOK = 203;
    public static final int REQUEST_PERMISSION_FOR_STORAGE = 102;
    public static final int REQUEST_PERMISSION_FOR_SYNC_MICROSOFT_ENTER = 201;
    public static final int REQUEST_PERMISSION_FOR_SYNC_MICROSOFT_TURN_ON = 202;
    public static final int REQUEST_PERMISSION_FOR_SYNC_SAMSUNG_ACCOUNT_ENTER = 200;
    private static final int SNACK_BAR_LONG_DURATION_MS = 2750;

    @NotNull
    private static final String TAG = "PermissionHelper";

    @Nullable
    private static Map<String, Boolean> mPrevShouldShowRationaleMap;

    @Nullable
    private static Map<String, Boolean> mRequestedPermissonMap;

    @NotNull
    public static final PermissionHelper INSTANCE = new PermissionHelper();

    @NotNull
    private static final Set<Integer> mAppPermissionNoticedActivities = new HashSet();

    private PermissionHelper() {
    }

    @SuppressLint({"InflateParams"})
    private final void addPermissionItem(Context context, LinearLayout parentLayout, String strPermission) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View viewInflate = ((LayoutInflater) systemService).inflate(C8875R.layout.permission_dialog_list_item, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        ImageView imageView = (ImageView) viewInflate.findViewById(C8875R.id.icon);
        TextView textView = (TextView) viewInflate.findViewById(C8875R.id.name);
        imageView.setImageDrawable(applyTint(context, strPermission != null ? PermissionCompat.getPermissionIcon(context, strPermission) : null, R.attr.colorControlNormal));
        textView.setText(strPermission != null ? PermissionCompat.getPermissionGroupName(context, strPermission) : null);
        parentLayout.addView(viewInflate, layoutParams);
    }

    private final Drawable applyTint(Context context, Drawable icon, int attr) {
        if (icon == null) {
            return null;
        }
        Resources.Theme theme = context.getTheme();
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(attr, typedValue, true);
        Drawable drawableMutate = icon.mutate();
        drawableMutate.setTint(context.getColor(typedValue.resourceId));
        return drawableMutate;
    }

    private final boolean canRequestPermissions(Activity activity, int requestCode, Runnable postActionWhenDismissed, String[] permissions) {
        if (activity == null) {
            return false;
        }
        String[] strArrSelectPermanentDeniedPermission = selectPermanentDeniedPermission(activity, (String[]) Arrays.copyOf(permissions, permissions.length));
        if (strArrSelectPermanentDeniedPermission.length == 0) {
            Logger.m8702i(TAG, "permanentDeniedPermissions size 0");
            return true;
        }
        if (isAppStartRequest(requestCode)) {
            showGotoSettingsUIForAppStart(activity, strArrSelectPermanentDeniedPermission);
        } else {
            showGotoSettingsUI(activity, postActionWhenDismissed, strArrSelectPermanentDeniedPermission);
        }
        return false;
    }

    private final void closeActivity(Activity activity) {
        new Handler().postDelayed(new RunnableC3900b(activity, 6), 2750L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void closeActivity$lambda$0(Activity activity) {
        if (activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        Logger.m8702i(TAG, "closeActivity() : " + activity);
        activity.finish();
    }

    private final int getAppPermissionNoticedCount(String caller) {
        int i = SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).getInt(KEY_NOTICE_APP_PERMISSION_NEED, 0);
        Logger.m8702i(TAG, "getAppPermissionNoticedCount: " + i + ", caller: " + caller);
        return i;
    }

    private final boolean getIsPermanentDeniedPermission(Context context, String permission) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_PERMISSION_CLICKED_NEVER_ASK, 0);
        return sharedPreferences.getBoolean(permission, false) || (Intrinsics.areEqual("android.permission.WRITE_EXTERNAL_STORAGE", permission) ? sharedPreferences.getBoolean("android.permission.READ_EXTERNAL_STORAGE", false) : Intrinsics.areEqual("android.permission.READ_EXTERNAL_STORAGE", permission) ? sharedPreferences.getBoolean("android.permission.WRITE_EXTERNAL_STORAGE", false) : false);
    }

    public static final boolean getNoticeAppPermissionNeededs() {
        return isChinaPermissionNeeded() && INSTANCE.getAppPermissionNoticedCount("getNoticeAppPermissionNeededs") < 3;
    }

    @JvmStatic
    public static /* synthetic */ void getNoticeAppPermissionNeededs$annotations() {
    }

    @NotNull
    public static final String[] getPermissionsForRecordAudio() {
        return PermissionCompat.getPermissionsForRecordAudio();
    }

    @JvmStatic
    public static /* synthetic */ void getPermissionsForRecordAudio$annotations() {
    }

    private final boolean getShouldShowRationaleBeforeRequest(String permission) {
        Map<String, Boolean> map = mPrevShouldShowRationaleMap;
        if (map != null && (map == null || !map.isEmpty())) {
            Map<String, Boolean> map2 = mPrevShouldShowRationaleMap;
            Boolean bool = map2 != null ? map2.get(permission) : null;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    private final boolean isAppStartRequest(int requestCode) {
        return false;
    }

    public static final boolean isChinaPermissionNeeded() {
        return (DeviceUtils.isSpenModel() || !SystemPropertiesCompat.INSTANCE.getInstance().isChinaModel() || SettingsCompat.INSTANCE.getInstance().isRDUModel(BaseUtils.getApplicationContext())) ? false : true;
    }

    @JvmStatic
    public static /* synthetic */ void isChinaPermissionNeeded$annotations() {
    }

    private final boolean isCloseActivityEnabled(boolean closeIfNotAllowed) {
        return closeIfNotAllowed && Build.VERSION.SDK_INT >= 28;
    }

    private final boolean isNeverAskClicked(Activity activity, String permission) {
        boolean shouldShowRationaleBeforeRequest = getShouldShowRationaleBeforeRequest(permission);
        boolean zShouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(permission);
        Logger.m8697d(TAG, "hasChangedNeverAsk prevShouldShowRationale : " + shouldShowRationaleBeforeRequest);
        Logger.m8697d(TAG, "hasChangedNeverAsk nowShouldShowRationale : " + zShouldShowRequestPermissionRationale);
        return !zShouldShowRequestPermissionRationale && shouldShowRationaleBeforeRequest;
    }

    @JvmStatic
    public static final boolean isPermissionGranted(@Nullable Activity activity, @Nullable Runnable requestPermissionsIfDenied, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        boolean zIsPermissionGrantedWithoutNotice = isPermissionGrantedWithoutNotice(activity, (String[]) Arrays.copyOf(permissions, permissions.length));
        if (!zIsPermissionGrantedWithoutNotice && requestPermissionsIfDenied != null) {
            requestPermissionsIfDenied.run();
        }
        noticeAppPermissionIfNeededs(activity);
        return zIsPermissionGrantedWithoutNotice;
    }

    @JvmStatic
    public static final boolean isPermissionGrantedWithoutNotice(@Nullable Context context, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        AbstractC4539a.m3188B("isPermissionGrantedWithoutNotice : ", context != null ? context.toString() : null, TAG);
        if (context == null) {
            return false;
        }
        if (permissions.length == 0) {
            return true;
        }
        for (String str : permissions) {
            if ((DeviceInfo.isOtherCorpDevice() || !(Intrinsics.areEqual("android.permission.GET_ACCOUNTS", str) || Intrinsics.areEqual("android.permission.READ_PHONE_STATE", str))) && !PermissionCompat.checkPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    private static final void noticeAppPermissionActivity(Activity activity) {
        if (NOTICE_PERMISSION_CLASS == null) {
            return;
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            Logger.m8697d(TAG, "noticeAppPermissionActivity, ignore, activity is invalid");
            return;
        }
        Set<Integer> set = mAppPermissionNoticedActivities;
        if (set.contains(Integer.valueOf(activity.hashCode()))) {
            Logger.m8697d(TAG, "noticeAppPermissionActivity, ignore, same activity already noticed");
            return;
        }
        set.add(Integer.valueOf(activity.hashCode()));
        Logger.m8697d(TAG, "noticeAppPermissionActivity show");
        Intent intent = new Intent(activity, NOTICE_PERMISSION_CLASS);
        intent.setFlags(131072);
        intent.putExtra(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PERMISSION_NOTICE_BUTTON, true);
        activity.startActivityForResult(intent, 52);
    }

    @JvmStatic
    public static final boolean noticeAppPermissionActivityOnLock(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!getNoticeAppPermissionNeededs()) {
            return false;
        }
        if (NOTICE_PERMISSION_CLASS == null) {
            PostLaunchManager.INSTANCE.getInstance().executeBaseLogic(1);
        }
        Logger.m8697d(TAG, "noticeAppPermissionActivityOnLock, show");
        Intent intent = new Intent(context, NOTICE_PERMISSION_CLASS);
        intent.addFlags(268435456);
        intent.putExtra(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.PERMISSION_NOTICE_BUTTON, true);
        context.startActivity(intent);
        return true;
    }

    @JvmStatic
    public static final boolean noticeAppPermissionIfNeededs(@Nullable Activity activity) {
        boolean noticeAppPermissionNeededs = getNoticeAppPermissionNeededs();
        Logger.m8697d(TAG, "noticeAppPermissionIfNeededs " + noticeAppPermissionNeededs);
        if (!noticeAppPermissionNeededs) {
            return false;
        }
        noticeAppPermissionActivity(activity);
        return true;
    }

    @JvmStatic
    public static final boolean onActivityResult(int requestCode, int resultCode, @Nullable Runnable allowRunnable) {
        Logger.m8697d(TAG, "onActivityResult# requestCode : " + requestCode + " resultCode : " + resultCode);
        if (requestCode != 52) {
            return false;
        }
        if (resultCode == 0) {
            return true;
        }
        if (allowRunnable == null) {
            return false;
        }
        allowRunnable.run();
        return false;
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Activity activity, int requestCode, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        requestPermissions(activity, requestCode, false, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    private final String[] selectPermanentDeniedPermission(Context context, String... permissions) {
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (!PermissionCompat.checkPermission(context, str) && getIsPermanentDeniedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        String[] strArr = new String[arrayList.size()];
        arrayList.toArray(strArr);
        return strArr;
    }

    @JvmStatic
    public static final void setDoNotShowAppPermissionNotice() {
        Logger.m8702i(TAG, "setDoNotShowAppPermissionNotice");
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putInt(KEY_NOTICE_APP_PERMISSION_NEED, 3);
    }

    private final void setIsPermanentDeniedPermission(Context context, String permission, boolean value) {
        Logger.m8697d(TAG, "setIsPermanentDeniedPermission : " + permission + " / " + value);
        context.getSharedPreferences(PREF_PERMISSION_CLICKED_NEVER_ASK, 0).edit().putBoolean(permission, value).apply();
    }

    @JvmStatic
    public static final void setNoticePermissionActivity(@Nullable Class<?> executor) {
        if (NOTICE_PERMISSION_CLASS == null) {
            NOTICE_PERMISSION_CLASS = executor;
        } else {
            Logger.m8698e(TAG, "setPermissionExplainActivity, twice access! only first trial is accepted");
        }
    }

    @JvmStatic
    public static final void showAppearOnTopToast(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(C8875R.string.permission_appear_on_top);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getResources().getString(C8875R.string.need_to_allow_permission, string);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ToastHelper.show(applicationContext, string2, 1, true);
    }

    private final void showGotoSettingsActivity(Activity activity, String[] permissions) {
        Logger.m8697d(TAG, "showGotoSettingsActivity");
        Intent intent = new Intent(activity, (Class<?>) GoToSettingsActivity.class);
        intent.putExtra(GoToSettingsActivity.EXTRA_KEY_REQUIRED_PERMISSION_LIST, permissions);
        activity.startActivityForResult(intent, 51);
    }

    private final void showGotoSettingsDialog(Activity activity, Runnable postActionWhenDismissed, String[] permissions) {
        int i;
        Logger.m8697d(TAG, "showGotoSettingsDialog");
        View viewInflate = activity.getLayoutInflater().inflate(C8875R.layout.permission_dialog, (ViewGroup) null);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewInflate;
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(activity, 0, 2, null);
        alertDialogBuilderForAppCompat.setTitle(C8875R.string.permission_dialog_title);
        Object systemService = activity.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        alertDialogBuilderForAppCompat.setView(((LayoutInflater) systemService).inflate(C8875R.layout.permission_dialog, (ViewGroup) null));
        TextView textView = (TextView) linearLayout.findViewById(C8875R.id.description);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(C8875R.id.permission_dialog_listview);
        String string = activity.getString(C8875R.string.permission_dialog_others_body_when_execute_app, AbstractC0541b.m773o("<b>", activity.getString(CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C8875R.string.notes_jp : C8875R.string.notes), "</b>"));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textView.setText(CharUtils.fromHtml(string));
        int length = permissions.length;
        String[] strArr = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = permissions[i2];
            strArr[i2] = str != null ? PermissionCompat.getPermissionGroupName(activity, str) : null;
            while (true) {
                if (i >= i2) {
                    Intrinsics.checkNotNull(linearLayout2);
                    addPermissionItem(activity, linearLayout2, permissions[i2]);
                    break;
                } else {
                    String str2 = strArr[i2];
                    i = (str2 == null || !Intrinsics.areEqual(str2, strArr[i])) ? i + 1 : 0;
                }
            }
        }
        alertDialogBuilderForAppCompat.setView(linearLayout);
        alertDialogBuilderForAppCompat.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        alertDialogBuilderForAppCompat.setPositiveButton(C8875R.string.permission_notification_button, new DialogInterfaceOnClickListenerC0161a(activity, 10));
        alertDialogBuilderForAppCompat.setOnDismissListener(new DialogInterfaceOnDismissListenerC8211a(postActionWhenDismissed, activity, 1));
        alertDialogBuilderForAppCompat.setCancelable(false);
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnKeyListener(new DialogInterfaceOnKeyListenerC0175b(2));
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showGotoSettingsDialog$lambda$10(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        return i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGotoSettingsDialog$lambda$8(Activity activity, DialogInterface dialogInterface, int i) {
        INSTANCE.startAppDetailSettings(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGotoSettingsDialog$lambda$9(Runnable runnable, Activity activity, DialogInterface dialogInterface) {
        if (runnable != null) {
            activity.runOnUiThread(runnable);
        }
    }

    private final void showGotoSettingsSnackBar(final Activity activity, Runnable postActionWhenDenied) {
        Logger.m8697d(TAG, "showGotoSettingsSnackBar");
        String string = activity.getString(C8875R.string.permission_toast_settings_body);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = activity.getString(C8875R.string.permission_toast_settings_action);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        final Runnable[] runnableArr = {postActionWhenDenied};
        SnackbarHelper.show(activity, string, string2, 0, new ViewOnClickListenerC0219a(runnableArr, activity, 10), new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: com.samsung.android.support.senl.nt.base.winset.app.permission.PermissionHelper.showGotoSettingsSnackBar.1
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                Runnable runnable = runnableArr[0];
                if (runnable == null || runnable == null) {
                    return;
                }
                new Handler(activity.getMainLooper()).post(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGotoSettingsSnackBar$lambda$5(Runnable[] runnableArr, Activity activity, View view) {
        runnableArr[0] = null;
        AppInfoUtil.showDetailsSettings$default(activity, null, 2, null);
    }

    private final void showGotoSettingsToast(Context context, Runnable postActionWhenDenied) {
        Logger.m8697d(TAG, "showGotoSettingsToast");
        String string = context.getString(C8875R.string.permission_toast_settings_body);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C8875R.string.permission_toast_settings_action);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        ViewOnClickListenerC8556a viewOnClickListenerC8556a = new ViewOnClickListenerC8556a(context, 9);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        ToastHelper.showActionToast(applicationContext, string, 1, string2, viewOnClickListenerC8556a);
        if (postActionWhenDenied != null) {
            new Handler(context.getMainLooper()).post(postActionWhenDenied);
        }
    }

    private final void showGotoSettingsUI(Activity activity, Runnable postActionWhenDismissed, String[] permissions) {
        Logger.m8697d(TAG, "showGotoSettingsUI");
        updateRequestedPermissionState((String[]) Arrays.copyOf(permissions, permissions.length));
        int i = Build.VERSION.SDK_INT;
        if (i > 29) {
            showGotoSettingsSnackBar(activity, postActionWhenDismissed);
        } else if (i >= 28) {
            showGotoSettingsToast(activity, postActionWhenDismissed);
        } else {
            showGotoSettingsDialog(activity, new RunnableC3900b(activity, 5), permissions);
        }
    }

    private final void showGotoSettingsUIForAppStart(Activity activity, String[] permissions) {
        Logger.m8697d(TAG, "showGotoSettingsUIForAppStart");
        int i = Build.VERSION.SDK_INT;
        if (i > 29) {
            showGotoSettingsActivity(activity, permissions);
        } else if (i >= 28) {
            showGotoSettingsToast(activity, new RunnableC3900b(activity, 2));
        } else {
            showGotoSettingsDialog(activity, new RunnableC3900b(activity, 3), permissions);
        }
    }

    private final void startAppDetailSettings(Context context) {
        Logger.m8697d(TAG, "startAppDetailSettings : " + context);
        AppInfoUtil.showDetailsSettings$default(context, null, 2, null);
    }

    private final void updatePrevShouldShowRationaleState(Activity activity, String... permissions) {
        if (mPrevShouldShowRationaleMap == null) {
            mPrevShouldShowRationaleMap = new HashMap();
        }
        for (String str : permissions) {
            boolean zShouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
            Map<String, Boolean> map = mPrevShouldShowRationaleMap;
            if (map != null) {
                map.put(str, Boolean.valueOf(zShouldShowRequestPermissionRationale));
            }
            if (zShouldShowRequestPermissionRationale) {
                setIsPermanentDeniedPermission(activity, str, false);
            }
        }
    }

    private final void updateRequestedPermissionState(String... permissions) {
        if (mRequestedPermissonMap == null) {
            mRequestedPermissonMap = new HashMap();
        }
        for (String str : permissions) {
            Map<String, Boolean> map = mRequestedPermissonMap;
            if (map != null) {
                map.put(String.valueOf(str), Boolean.TRUE);
            }
        }
    }

    @JvmStatic
    public static final boolean verifyRequestResult(@Nullable Activity activity, @NotNull int[] grantResults, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return verifyRequestResult(activity, -1, grantResults, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    public final boolean getRequestedPermissionState(@NotNull String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Map<String, Boolean> map = mRequestedPermissonMap;
        if (map != null && (map == null || !map.isEmpty())) {
            Map<String, Boolean> map2 = mRequestedPermissonMap;
            Boolean bool = map2 != null ? map2.get(permission) : null;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    public final void increaseAppPermissionNoticedCount() {
        int appPermissionNoticedCount = getAppPermissionNoticedCount("increaseAppPermissionNoticedCount");
        int iMin = (int) Math.min(appPermissionNoticedCount + 1, 3.0d);
        Logger.m8702i(TAG, "increaseAppPermissionNoticedCount, noticedCount changed " + appPermissionNoticedCount + " to " + iMin);
        SharedPreferencesCompat.INSTANCE.getInstance(com.samsung.android.support.senl.p148nt.base.common.constants.Constants.APP_LAUNCH_PREFERENCE).putInt(KEY_NOTICE_APP_PERMISSION_NEED, iMin);
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Activity activity, int requestCode, boolean closeIfNotAllowed, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        requestPermissions(activity, requestCode, closeIfNotAllowed, (Runnable) null, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @JvmStatic
    public static final boolean verifyRequestResult(@Nullable Activity activity, int requestCode, @NotNull int[] grantResults, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (activity == null) {
            Logger.m8703w(TAG, "verifyRequestResult, acitivity is null");
            return false;
        }
        Logger.m8697d(TAG, "verifyRequestResult : " + activity);
        if (grantResults.length == 0 || permissions.length == 0) {
            return false;
        }
        int length = permissions.length;
        boolean z = true;
        for (int i = 0; i < length; i++) {
            if (grantResults[i] != 0) {
                PermissionHelper permissionHelper = INSTANCE;
                if (permissionHelper.isNeverAskClicked(activity, permissions[i])) {
                    permissionHelper.setIsPermanentDeniedPermission(activity, permissions[i], true);
                }
                z = false;
            }
        }
        if (!z && INSTANCE.isAppStartRequest(requestCode)) {
            activity.runOnUiThread(new RunnableC3900b(activity, 4));
        }
        return z;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ#\u0010\f\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/winset/app/permission/PermissionHelper$RequestPermissionsWrapper;", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "getActivity", "()Landroid/app/Activity;", "mFragment", "requestPermissions", "", "permissions", "", "", "requestCode", "", "([Ljava/lang/String;I)V", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class RequestPermissionsWrapper {

        @Nullable
        private final Activity activity;

        @Nullable
        private final Fragment mFragment;

        public RequestPermissionsWrapper(@Nullable Activity activity) {
            this.activity = activity;
            this.mFragment = null;
        }

        @Nullable
        public final Activity getActivity() {
            return this.activity;
        }

        public final void requestPermissions(@NotNull String[] permissions, int requestCode) {
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            Fragment fragment = this.mFragment;
            if (fragment != null) {
                fragment.requestPermissions(permissions, requestCode);
                return;
            }
            Activity activity = this.activity;
            if (activity != null) {
                activity.requestPermissions(permissions, requestCode);
            }
        }

        public RequestPermissionsWrapper(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.mFragment = fragment;
            this.activity = fragment.getActivity();
        }
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Activity activity, int requestCode, @Nullable Runnable postActionWhenDismissed, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        requestPermissions(activity, requestCode, false, postActionWhenDismissed, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Activity activity, int requestCode, boolean closeIfNotAllowed, @Nullable Runnable postActionWhenDismissed, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        INSTANCE.requestPermissions(new RequestPermissionsWrapper(activity), requestCode, closeIfNotAllowed, postActionWhenDismissed, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Fragment fragment, int requestCode, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        requestPermissions(fragment, requestCode, false, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Fragment fragment, int requestCode, boolean closeIfNotAllowed, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        requestPermissions(fragment, requestCode, closeIfNotAllowed, (Runnable) null, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    @JvmStatic
    public static final void requestPermissions(@NotNull Fragment fragment, int requestCode, boolean closeIfNotAllowed, @Nullable Runnable postActionWhenDismissed, @NotNull String... permissions) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        INSTANCE.requestPermissions(new RequestPermissionsWrapper(fragment), requestCode, closeIfNotAllowed, postActionWhenDismissed, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    private final void requestPermissions(RequestPermissionsWrapper activityWrapper, int requestCode, boolean closeIfNotAllowed, Runnable postActionWhenDismissed, String... permissions) {
        Activity activity = activityWrapper.getActivity();
        if (activity == null) {
            Logger.m8698e(TAG, "requestPermissions# activity is null");
            return;
        }
        Logger.m8697d(TAG, "requestPermissions : " + activity);
        updatePrevShouldShowRationaleState(activity, (String[]) Arrays.copyOf(permissions, permissions.length));
        if (canRequestPermissions(activity, requestCode, postActionWhenDismissed, permissions)) {
            activityWrapper.requestPermissions(permissions, requestCode);
        } else if (isCloseActivityEnabled(closeIfNotAllowed)) {
            closeActivity(activity);
        }
    }
}
