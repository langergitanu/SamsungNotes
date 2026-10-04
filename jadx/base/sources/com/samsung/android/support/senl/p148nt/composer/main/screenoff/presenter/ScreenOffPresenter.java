package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.util.DisplayUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.ScreenOffActivity;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.close.CloseModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.AODCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.StartCommandFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.IStartCommand;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.LoadNoteByDoubleTapOnAOD;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.command.start.PenButtonHoverTap;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.controller.pin.LegacyPinnedNoteConverter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.executor.ExecutorFactory;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.fold.FoldModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.fold.IFoldModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.loadednote.LoadedNote;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.loadedpin.LoadedPinModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation.IRotationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation.RotationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.save.SaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IState;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IStateSetter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateClosing;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateHiding;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateNone;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.StateShowing;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.ConfigurationModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.StaticalModelInitializer;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.SOMBasePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.ScreenOffContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.closing.ClosingAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.closing.IClosingAnimationListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.pin.IPinAnimationListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.pin.PinAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.showing.IShowingAnimationListener;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.showing.ShowingAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.IStartingAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.StartingPenHoverAnimation;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.controller.PinController;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.covered.CoveredPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.PinNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.SaveNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.dialog.SelectNoteDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.guide.GuidePresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.scroll.ScrollPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.PowerManagerHandler;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.feature.KeepScreenOnFlagFeature;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.p164sa.SAManager;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog.DialogCreator;
import com.samsung.android.support.senl.p148nt.data.common.utils.NotesDocumentFileUtils;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentDeleteUtils;
import java.io.File;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u009c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ²\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f:\u0004±\u0001²\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010O\u001a\u00020MH\u0016J\b\u0010P\u001a\u00020MH\u0016J\u0012\u0010Q\u001a\u00020M2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u00020MH\u0016J\b\u0010U\u001a\u00020MH\u0016J\b\u0010V\u001a\u00020MH\u0016J\b\u0010W\u001a\u00020MH\u0016J\u0010\u0010X\u001a\u00020M2\u0006\u0010Y\u001a\u00020ZH\u0016J\n\u0010[\u001a\u0004\u0018\u00010\\H\u0016J\b\u0010]\u001a\u00020^H\u0016J\b\u0010_\u001a\u00020MH\u0016J\b\u0010`\u001a\u00020MH\u0016J\b\u0010a\u001a\u00020MH\u0016J\u0010\u0010b\u001a\u00020M2\u0006\u0010c\u001a\u00020:H\u0016J\b\u0010d\u001a\u00020MH\u0016J\b\u0010e\u001a\u00020MH\u0016J\b\u0010f\u001a\u00020MH\u0016J\u0010\u0010g\u001a\u00020M2\u0006\u0010h\u001a\u00020:H\u0016J\u0010\u0010i\u001a\u00020M2\u0006\u0010j\u001a\u00020SH\u0016J\u0012\u0010k\u001a\u00020M2\b\u0010l\u001a\u0004\u0018\u00010SH\u0016J\u0010\u0010m\u001a\u00020M2\u0006\u0010n\u001a\u00020>H\u0016J\b\u0010r\u001a\u00020:H\u0016J\u0010\u0010s\u001a\u00020M2\u0006\u0010n\u001a\u00020>H\u0016J\b\u0010t\u001a\u00020MH\u0016J\b\u0010u\u001a\u00020MH\u0002J\b\u0010v\u001a\u00020MH\u0016J\b\u0010w\u001a\u00020MH\u0016J\b\u0010x\u001a\u00020MH\u0016J\b\u0010y\u001a\u00020MH\u0016J\b\u0010z\u001a\u00020MH\u0016J\b\u0010{\u001a\u00020MH\u0017J\b\u0010|\u001a\u00020MH\u0017J\u001c\u0010}\u001a\u00020M2\b\u0010j\u001a\u0004\u0018\u00010S2\b\u0010~\u001a\u0004\u0018\u00010SH\u0002J\b\u0010\u007f\u001a\u00020MH\u0016J\t\u0010\u0080\u0001\u001a\u00020MH\u0016J\t\u0010\u0081\u0001\u001a\u00020MH\u0016J&\u0010\u0082\u0001\u001a\u00020M2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020:2\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0017J\t\u0010\u0088\u0001\u001a\u00020MH\u0016J\t\u0010\u0089\u0001\u001a\u00020MH\u0016J\t\u0010\u008a\u0001\u001a\u00020MH\u0016J\u0012\u0010\u008b\u0001\u001a\u00020M2\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0018J\u0011\u0010\u008d\u0001\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u008e\u0001\u001a\u00020M2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0016J\t\u0010\u0090\u0001\u001a\u00020MH\u0002J\u001d\u0010\u0091\u0001\u001a\u00020M2\b\u0010@\u001a\u0004\u0018\u00010A2\n\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001J\t\u0010\u0094\u0001\u001a\u00020MH\u0016J)\u0010\u0095\u0001\u001a\u00020M2\b\u0010j\u001a\u0004\u0018\u00010S2\t\u0010\u0096\u0001\u001a\u0004\u0018\u00010S2\t\b\u0001\u0010\u0097\u0001\u001a\u00020>H\u0002J\t\u0010\u0098\u0001\u001a\u00020MH\u0016J\t\u0010\u0099\u0001\u001a\u00020MH\u0016J\u0012\u0010\u009a\u0001\u001a\u00020M2\u0007\u0010\u009b\u0001\u001a\u00020:H\u0016J\u0010\u0010\u009c\u0001\u001a\u00020M2\u0007\u0010\u009d\u0001\u001a\u00020:J\t\u0010\u009e\u0001\u001a\u00020MH\u0002J\t\u0010\u009f\u0001\u001a\u00020MH\u0002J\u000f\u0010 \u0001\u001a\u00020M2\u0006\u0010c\u001a\u00020:J\t\u0010¡\u0001\u001a\u00020MH\u0002J\u0010\u0010¢\u0001\u001a\u00020M2\u0007\u0010£\u0001\u001a\u00020>J\u0007\u0010¤\u0001\u001a\u00020MJ\u0007\u0010¥\u0001\u001a\u00020MJ\u0007\u0010¦\u0001\u001a\u00020MJ\u0007\u0010§\u0001\u001a\u00020MJ\t\u0010¨\u0001\u001a\u00020MH\u0016J\t\u0010©\u0001\u001a\u00020MH\u0016J\u0012\u0010ª\u0001\u001a\u00020M2\u0007\u0010«\u0001\u001a\u00020>H\u0002J\t\u0010¬\u0001\u001a\u00020MH\u0002J\t\u0010\u00ad\u0001\u001a\u00020MH\u0002J\t\u0010®\u0001\u001a\u00020:H\u0002R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u0004\u0018\u000104X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010@\u001a\u0004\u0018\u00010A8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020E8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010H\u001a\u00020I8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010o\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0014\u0010q\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bq\u0010pR\u0014\u0010¯\u0001\u001a\u00070°\u0001R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006³\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter$Contract;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IStateSetter;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/navigator/Navigator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter$IMenuBarNavigator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SaveNoteDialogPresenter$ISaveNoteDialogNavigator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/SelectNoteDialogPresenter$ISelectNoteDialogNavigator;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/PinNoteDialogPresenter$IPinNoteDialogPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/IShowingAnimationListener;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/closing/IClosingAnimationListener;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/pin/IPinAnimationListener;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/rotation/IRotationModel;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/fold/IFoldModel;", "mSOMBasePresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter;)V", "getMSOMBasePresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/SOMBasePresenter;", "mState", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/state/IState;", "mLoadedNote", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadednote/LoadedNote;", "mSOMView", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffContract$IScreenOffView;", "mSaveModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/save/SaveModel;", "mLoadedPinModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/loadedpin/LoadedPinModel;", "mRotationModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/rotation/RotationModel;", "mFoldModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/fold/FoldModel;", "mCloseModel", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/model/close/CloseModel;", "mMenuBarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/menubar/MenuBarPresenter;", "mGuidePresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/guide/GuidePresenter;", "mScrollPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/scroll/ScrollPresenter;", "mCoveredPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/covered/CoveredPresenter;", "mControllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/controller/ControllerManager;", "mDialogCreator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogContract$IDialogCreator;", "mDialogPresenterManager", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/dialog/DialogPresenterManager;", "mStartingPenHoverAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/IStartingAnimation;", "mShowingAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/showing/ShowingAnimation;", "mPinAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/pin/PinAnimation;", "mClosingAnimation", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/closing/ClosingAnimation;", "mInitFinished", "", "isNoteChanged", "mIsReserveRestart", "mPreHideOrientation", "", "mPreShowOrientation", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "compViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "getCompViewPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "getComposerModel", "()Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "onSetState", "", "state", "onSave", "onSaveNoteCache", "onSavePinCache", "uri", "", "onFinish", "reserveRestart", "requestShowSaveNoteDialog", "requestShowSelectNoteDialog", "requestShowPinNoteDialog", "pinnedNoteUri", "Landroid/net/Uri;", "getWindow", "Landroid/view/Window;", "getIntent", "Landroid/content/Intent;", "resetIntent", "onPreHide", "onPreShow", "requestReadyToShow", "withAnimation", "requestResetZoomScaleToDefault", "onShowingAnimation", "onClosingAnimationPenAttach", "blockUserInput", "enable", "setLoadedPinUuid", "uuid", "setLoadedPinNotePath", "notePath", "setCloseReason", "closeReason", "isEmptyNote", "()Z", "isEditedNote", "hasCachedNote", "onSetCloseReason", "onStartAnimationClosing", "onStartAnimationPin", "onPin", "onSaveNoteDialogDiscard", "onSaveNoteDialogSave", "onSelectNoteDialogDiscard", "onSelectNoteDialogSave", "onPinNoteDialogDiscard", "onPinNoteDialogSave", "changeNote", "path", "onShowingAnimationHalfProgressed", "onShowingAnimationEnd", "onClosingAnimationEnd", "onPinToAOD", "capturedComposerView", "Landroid/graphics/Bitmap;", Constants.IntentExtraName.IS_EDITED, "scrollPanY", "", "onPinAnimationEnd", "onHalfWheelRotationChanged", "onFolded", "setView", "view", "setState", "setLoadedNote", "loadedNote", "handleExceptionalCase", "onActivityCreated", "dialogCreator", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/view/dialog/DialogCreator;", "onInitFinished", "deleteNoteFile", "filePath", "deletedBy", "onResume", "onPause", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "halfWheelRotation", "onPreNoteChanged", "onPostNoteChanged", "onReadyToShow", "onFocused", "onDisplayStateChanged", "displayState", "onHomeKeyPressed", "onDispatchActionDownEvent", "onDispatchActionUpEvent", "onInterrupted", "onBackPressed", "onDetachView", "onWaitToInitFinished", "delay", "onWaitToOnFinish", "onWaitToGetWindowFocused", "needToWaitToShowUntilNavigationShown", "mHandler", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffPresenter$MessageHandler;", "MessageHandler", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScreenOffPresenter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScreenOffPresenter.kt\ncom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffPresenter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1031:1\n1#2:1032\n*E\n"})
public final class ScreenOffPresenter implements SOMBasePresenter.Contract, IStateSetter, Navigator, MenuBarPresenter.IMenuBarNavigator, SaveNoteDialogPresenter.ISaveNoteDialogNavigator, SelectNoteDialogPresenter.ISelectNoteDialogNavigator, PinNoteDialogPresenter.IPinNoteDialogPresenter, IShowingAnimationListener, IClosingAnimationListener, IPinAnimationListener, IRotationModel, IFoldModel {
    private static final int MESSAGE_WAIT_TO_GET_WINDOW_FOCUSED = 3;
    private static final int MESSAGE_WAIT_TO_INIT_FINISHED = 1;
    private static final int MESSAGE_WAIT_TO_ON_FINISH = 2;
    private static final int MESSAGE_WAIT_TO_SHOW_UNTIL_NAVIGATION_SHOWN = 4;
    private static final int WAIT_TO_INIT_FINISHED_DELAY = 500;
    private static final int WAIT_TO_ON_FINISH_DELAY = 1000;
    private static final int WAIT_TO_ON_GET_WINDOW_FOCUSED_DELAY = 500;
    private static final int WAIT_TO_SHOW_UNTIL_NAVIGATION_SHOWN_DELAY = 700;
    private boolean isNoteChanged;

    @Nullable
    private CloseModel mCloseModel;

    @Nullable
    private ClosingAnimation mClosingAnimation;

    @Nullable
    private ControllerManager mControllerManager;

    @NotNull
    private final CoveredPresenter mCoveredPresenter;

    @Nullable
    private DialogContract.IDialogCreator mDialogCreator;

    @Nullable
    private DialogPresenterManager mDialogPresenterManager;

    @Nullable
    private FoldModel mFoldModel;

    @NotNull
    private final GuidePresenter mGuidePresenter;

    @NotNull
    private final MessageHandler mHandler;
    private boolean mInitFinished;
    private boolean mIsReserveRestart;

    @Nullable
    private LoadedNote mLoadedNote;

    @Nullable
    private LoadedPinModel mLoadedPinModel;

    @NotNull
    private final MenuBarPresenter mMenuBarPresenter;

    @Nullable
    private PinAnimation mPinAnimation;
    private int mPreHideOrientation;
    private int mPreShowOrientation;

    @NotNull
    private final RotationModel mRotationModel;

    @NotNull
    private final SOMBasePresenter mSOMBasePresenter;

    @Nullable
    private ScreenOffContract.IScreenOffView mSOMView;

    @Nullable
    private SaveModel mSaveModel;

    @NotNull
    private final ScrollPresenter mScrollPresenter;

    @Nullable
    private ShowingAnimation mShowingAnimation;

    @Nullable
    private IStartingAnimation mStartingPenHoverAnimation;

    @Nullable
    private IState mState;

    @NotNull
    private static final String TAG = SOLogger.createTag("ScreenOffPresenter");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffPresenter$MessageHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/ScreenOffPresenter;Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class MessageHandler extends Handler {
        final /* synthetic */ ScreenOffPresenter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MessageHandler(@NotNull ScreenOffPresenter screenOffPresenter, Looper looper) {
            super(looper);
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.this$0 = screenOffPresenter;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            AbstractC8014b.m7206h("handleMessage# ", msg.what, SOLogger.INSTANCE, ScreenOffPresenter.TAG);
            int i = msg.what;
            if (i == 1) {
                if (this.this$0.mInitFinished) {
                    this.this$0.onReadyToShow(true);
                    return;
                } else {
                    this.this$0.onWaitToInitFinished(500);
                    return;
                }
            }
            if (i == 2) {
                this.this$0.onFinish();
                return;
            }
            if (i == 3) {
                this.this$0.onWindowFocusChanged(true);
            } else {
                if (i != 4) {
                    return;
                }
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.view.View");
                ((View) obj).setVisibility(0);
            }
        }
    }

    public ScreenOffPresenter(@NotNull SOMBasePresenter mSOMBasePresenter) {
        Intrinsics.checkNotNullParameter(mSOMBasePresenter, "mSOMBasePresenter");
        this.mSOMBasePresenter = mSOMBasePresenter;
        this.mRotationModel = new RotationModel();
        this.mMenuBarPresenter = new MenuBarPresenter();
        this.mGuidePresenter = new GuidePresenter();
        this.mScrollPresenter = new ScrollPresenter();
        this.mCoveredPresenter = new CoveredPresenter();
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper = looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper;
        Intrinsics.checkNotNull(looperMyLooper);
        this.mHandler = new MessageHandler(this, looperMyLooper);
        mSOMBasePresenter.setContract(this);
        this.mState = new StateNone(this);
    }

    private final void changeNote(String uuid, String path) {
        this.mSOMBasePresenter.changeNote(uuid, path, false);
    }

    private final void deleteNoteFile(String uuid, String filePath, @DataBaseConstants.DeletedBy int deletedBy) {
        NotesDocumentDeleteUtils.deleteDocumentFile(BaseUtils.getApplicationContext(), uuid, filePath, null, null, deletedBy);
    }

    private final Activity getActivity() {
        return this.mSOMBasePresenter.getActivity();
    }

    private final ComposerViewPresenter getCompViewPresenter() {
        return this.mSOMBasePresenter.getCompViewPresenter();
    }

    private final ComposerModel getComposerModel() {
        return this.mSOMBasePresenter.getComposerModel();
    }

    private final void handleExceptionalCase() {
        CloseModel closeModel = new CloseModel();
        this.mCloseModel = closeModel;
        closeModel.setCloseReason(9);
        this.mState = new StateClosing(this);
        this.mSaveModel = new SaveModel();
        onFinish();
    }

    private final boolean needToWaitToShowUntilNavigationShown() {
        int i = this.mPreShowOrientation;
        boolean z = i == 2 || this.mPreHideOrientation != i;
        AbstractC8014b.m7211m("needToWaitToShowUntilNavigationShown# ", z, SOLogger.INSTANCE, TAG);
        return z;
    }

    private final void onFocused() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFocused#");
        this.mMenuBarPresenter.onFocused();
        this.mGuidePresenter.onFocused();
        this.mScrollPresenter.onFocused();
    }

    private final void onPostNoteChanged() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPostNoteChanged#");
        getCompViewPresenter().getView().setVisibility(0);
        onFocused();
        this.isNoteChanged = false;
    }

    private final void onPreNoteChanged() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPreNoteChanged#");
        this.isNoteChanged = true;
        this.mMenuBarPresenter.onDestroy();
        this.mGuidePresenter.onDestroy();
        this.mScrollPresenter.onDestroy();
        this.mCoveredPresenter.onDestroy();
    }

    private final void onStartAnimationPin() {
        Window window;
        View decorView;
        PinController pinController;
        boolean z = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommandUri().length() > 0;
        AbstractC8014b.m7211m("onStartAnimationPin# isEdited ", z, SOLogger.INSTANCE, TAG);
        this.mMenuBarPresenter.onWindowFocusChanged(false);
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager != null && (pinController = controllerManager.getPinController()) != null) {
            pinController.setEdited(z);
        }
        Activity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        PinAnimation pinAnimation = this.mPinAnimation;
        if (pinAnimation != null) {
            pinAnimation.init(decorView, this, getCompViewPresenter(), z);
        }
        PinAnimation pinAnimation2 = this.mPinAnimation;
        if (pinAnimation2 != null) {
            pinAnimation2.start();
        }
    }

    private final void onWaitToGetWindowFocused() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWaitToGetWindowFocused# delay 500");
        this.mHandler.removeMessages(3);
        this.mHandler.sendEmptyMessageDelayed(3, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onWaitToInitFinished(int delay) {
        AbstractC8014b.m7206h("onWaitToInitFinished# delay ", delay, SOLogger.INSTANCE, TAG);
        this.mHandler.removeMessages(1);
        this.mHandler.sendEmptyMessageDelayed(1, delay);
    }

    private final void onWaitToOnFinish() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onWaitToOnFinish# delay 1000");
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessageDelayed(2, 1000L);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void blockUserInput(boolean enable) {
        AbstractC8014b.m7211m("blockUserInput# ", enable, SOLogger.INSTANCE, TAG);
        if (enable) {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(16, 16);
                return;
            }
            return;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.clearFlags(16);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    @NotNull
    public Intent getIntent() {
        Intent intent;
        SOLogger.INSTANCE.SOLoggerD(TAG, "getIntent#");
        Activity activity = getActivity();
        return (activity == null || (intent = activity.getIntent()) == null) ? new Intent() : intent;
    }

    @NotNull
    public final SOMBasePresenter getMSOMBasePresenter() {
        return this.mSOMBasePresenter;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    @Nullable
    public Window getWindow() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "getWindow#");
        Activity activity = getActivity();
        if (activity != null) {
            return activity.getWindow();
        }
        return null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public boolean hasCachedNote() {
        String strLoadCachedNoteUuid = new SaveModel().loadCachedNoteUuid();
        SOLogger.INSTANCE.SOLoggerD(TAG, "hasCachedNote# " + strLoadCachedNoteUuid);
        return !TextUtils.isEmpty(strLoadCachedNoteUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public boolean isEditedNote() {
        return this.mMenuBarPresenter.getObjectChanged();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public boolean isEmptyNote() {
        SaveModel saveModel = this.mSaveModel;
        if (saveModel != null) {
            return saveModel.isEmpty();
        }
        return false;
    }

    public final void onActivityCreated(@Nullable Activity activity, @Nullable DialogCreator dialogCreator) {
        Intent intent;
        AbstractC8014b.m7208j("onActivityCreated# uuid ", (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra("sdoc_uuid"), SOLogger.INSTANCE, TAG);
        this.mDialogCreator = dialogCreator;
        this.mSaveModel = new SaveModel();
        this.mLoadedPinModel = new LoadedPinModel();
        this.mCloseModel = new CloseModel();
        this.mDialogPresenterManager = new DialogPresenterManager();
        ControllerManager controllerManager = new ControllerManager();
        this.mControllerManager = controllerManager;
        controllerManager.onActivityCreated(getActivity());
        this.mStartingPenHoverAnimation = new StartingPenHoverAnimation();
        this.mShowingAnimation = new ShowingAnimation();
        this.mPinAnimation = new PinAnimation();
        this.mClosingAnimation = new ClosingAnimation();
        this.mFoldModel = new FoldModel(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.SOMBasePresenter.Contract
    public void onBackPressed() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onBackPressed#");
        SAManager.INSTANCE.getINSTANCE().setExitReason(1);
        IState iState = this.mState;
        if (iState != null) {
            iState.onBackKeyPressed(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.closing.IClosingAnimationListener
    public void onClosingAnimationEnd() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onClosingAnimationEnd#");
        onSave();
        onWaitToOnFinish();
        PowerManagerHandler.INSTANCE.requestGoToSleep(0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onClosingAnimationPenAttach() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onClosingAnimationPenAttach#");
        SAManager.INSTANCE.getINSTANCE().setExitReason(0);
        Window window = getWindow();
        if ((window != null ? window.getCurrentFocus() : null) == null) {
            getCompViewPresenter().getView().requestFocus();
        }
        onStartAnimationClosing();
    }

    public final void onConfigurationChanged(boolean halfWheelRotation) {
        PinController pinController;
        boolean zIsIsMainDisplay = DisplayUtils.isIsMainDisplay();
        SOLogger.INSTANCE.SOLoggerD(TAG, "onConfigurationChanged# halfWheelRotation/isMainDisplay " + halfWheelRotation + "/" + zIsIsMainDisplay);
        if (StartCommandFactory.INSTANCE.getInstance().makeStartCommand(getIntent()) instanceof PenButtonHoverTap) {
            this.mMenuBarPresenter.onConfigurationChanged(4, halfWheelRotation);
            this.mGuidePresenter.onConfigurationChanged(4, halfWheelRotation);
            this.mScrollPresenter.onConfigurationChanged(4, halfWheelRotation);
        } else {
            this.mMenuBarPresenter.onConfigurationChanged(0, halfWheelRotation);
            this.mGuidePresenter.onConfigurationChanged(0, halfWheelRotation);
            this.mScrollPresenter.onConfigurationChanged(0, halfWheelRotation);
        }
        ControllerManager controllerManager = this.mControllerManager;
        Uri uri = Uri.parse((controllerManager == null || (pinController = controllerManager.getPinController()) == null) ? null : pinController.getCurrentPinnedNoteUri());
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager != null) {
            Intrinsics.checkNotNull(uri);
            dialogPresenterManager.onConfigurationChanged(uri);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.SOMBasePresenter.Contract
    public void onDetachView() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDetachView# state/initFinished/isReserveRestart " + this.mState + "/" + this.mInitFinished + "/" + this.mIsReserveRestart);
        if (!(this.mState instanceof StateNone)) {
            IStartingAnimation iStartingAnimation = this.mStartingPenHoverAnimation;
            if (iStartingAnimation != null) {
                iStartingAnimation.release();
            }
            ShowingAnimation showingAnimation = this.mShowingAnimation;
            if (showingAnimation != null) {
                showingAnimation.release();
            }
            PinAnimation pinAnimation = this.mPinAnimation;
            if (pinAnimation != null) {
                pinAnimation.release();
            }
            ClosingAnimation closingAnimation = this.mClosingAnimation;
            if (closingAnimation != null) {
                closingAnimation.release();
            }
            FoldModel foldModel = this.mFoldModel;
            if (foldModel != null) {
                foldModel.release();
            }
            if (this.mInitFinished) {
                this.mMenuBarPresenter.onDetachView();
                this.mGuidePresenter.onDetachView();
                this.mScrollPresenter.onDetachView();
                this.mCoveredPresenter.onDetachView();
            }
            ControllerManager controllerManager = this.mControllerManager;
            if (controllerManager != null) {
                controllerManager.onDetachView();
            }
            DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
            if (dialogPresenterManager != null) {
                dialogPresenterManager.onDetachView();
            }
        }
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        this.mHandler.removeMessages(4);
        if (this.mIsReserveRestart) {
            ExecutorFactory.INSTANCE.createExecutor(getIntent()).execute(BaseUtils.getApplicationContext(), getIntent());
            this.mIsReserveRestart = false;
        }
        LegacyPinnedNoteConverter.INSTANCE.getInstance().release();
        ToastHandler.INSTANCE.cancelAll();
        this.mInitFinished = false;
    }

    public final void onDispatchActionDownEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionDownEvent#");
        IState iState = this.mState;
        if (iState == null || iState == null) {
            return;
        }
        iState.onDispatchActionDownEvent();
    }

    public final void onDispatchActionUpEvent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onDispatchActionUpEvent#");
        IState iState = this.mState;
        if (iState == null || iState == null) {
            return;
        }
        iState.onDispatchActionUpEvent();
    }

    public final void onDisplayStateChanged(int displayState) {
        IState iState;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        AbstractC8014b.m7206h("onDisplayStateChanged# ", displayState, sOLogger, str);
        if (displayState != 1) {
            if (displayState == 2 && (iState = this.mState) != null) {
                iState.onScreenOn(this);
                return;
            }
            return;
        }
        AbstractC8014b.m7211m("onDisplayStateChanged# has MESSAGE_WAIT_TO_ON_FINISH ", this.mHandler.hasMessages(2), sOLogger, str);
        AbstractC8014b.m7211m("onDisplayStateChanged# has MESSAGE_WAIT_TO_GET_WINDOW_FOCUSED ", this.mHandler.hasMessages(3), sOLogger, str);
        IState iState2 = this.mState;
        if (iState2 != null) {
            iState2.onScreenOff(this);
        }
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onFinish();
        }
        if (this.mHandler.hasMessages(3)) {
            this.mHandler.removeMessages(3);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onFinish() {
        SaveModel saveModel;
        SaveModel saveModel2;
        SAManager instance = SAManager.INSTANCE.getINSTANCE();
        boolean zIsEmpty = this.mSOMBasePresenter.getComposerModel().isEmpty();
        int pageLengthInSingleMode = this.mSOMBasePresenter.getComposerModel().getComposerSpenDocModel().getPageLengthInSingleMode();
        PenInfoModel penInfoModel = PenInfoModel.INSTANCE;
        instance.onExit(zIsEmpty, pageLengthInSingleMode, penInfoModel.getSizeLevel(), penInfoModel.getCurrentPairedColorCode(), penInfoModel.getEnabledWritingColorSwitch(), SharedPreferencesCompat.INSTANCE.getInstance("Settings").getInt(SettingsConstants.SETTINGS_SCREEN_OFF_MEMO_STYLE, 0));
        CloseModel closeModel = this.mCloseModel;
        Integer numValueOf = closeModel != null ? Integer.valueOf(closeModel.getCloseReason()) : null;
        AbstractC8014b.m7208j("onFinish# ", Constants.CloseReason.INSTANCE.toStringCloseReason(numValueOf != null ? numValueOf.intValue() : -1), SOLogger.INSTANCE, TAG);
        if ((numValueOf == null || numValueOf.intValue() != 6) && ((numValueOf == null || numValueOf.intValue() != 7) && (numValueOf == null || numValueOf.intValue() != 8))) {
            SaveModel saveModel3 = this.mSaveModel;
            if (saveModel3 != null) {
                saveModel3.removeCachedNoteUuid();
            }
            SaveModel saveModel4 = this.mSaveModel;
            if (saveModel4 != null) {
                saveModel4.removeCachedNotePath();
            }
        }
        if (numValueOf != null && numValueOf.intValue() == 0 && (saveModel = this.mSaveModel) != null && !saveModel.getSaveResult() && (saveModel2 = this.mSaveModel) != null) {
            saveModel2.save();
        }
        if (CommonUtil.isAvailableActivity(getActivity())) {
            Activity activity = getActivity();
            ScreenOffActivity screenOffActivity = activity instanceof ScreenOffActivity ? (ScreenOffActivity) activity : null;
            if (screenOffActivity != null) {
                screenOffActivity.onFinish();
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.fold.IFoldModel
    public void onFolded() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onFolded#");
        SAManager.INSTANCE.getINSTANCE().setExitReason(8);
        IState iState = this.mState;
        if (iState != null) {
            iState.onFolded(this);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.rotation.IRotationModel
    public void onHalfWheelRotationChanged() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onHalfWheelRotationChanged#");
        onConfigurationChanged(true);
    }

    public final void onHomeKeyPressed() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onHomeKeyPressed#");
        SAManager.INSTANCE.getINSTANCE().setExitReason(5);
        IState iState = this.mState;
        if (iState != null) {
            iState.onHomeKeyPressed(this);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.SOMBasePresenter.Contract
    public void onInitFinished() {
        SaveModel saveModel;
        Window window;
        Resources resources;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onInitFinished# uuid/docPath ", getIntent().getStringExtra("sdoc_uuid"), "/", Logger.getEncode(getIntent().getStringExtra("doc_path"))));
        try {
            sOLogger.SOLoggerD(str, "onInitFinished# object count " + getComposerModel().getDoc().getPage(0).getObjectCount(false));
        } catch (Exception e) {
            AbstractC8014b.m7208j("onInitFinished# ", e.getMessage(), SOLogger.INSTANCE, TAG);
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext != null) {
            StaticalModelInitializer.INSTANCE.initialize(applicationContext);
        }
        ScreenOffContract.IScreenOffView iScreenOffView = this.mSOMView;
        if (iScreenOffView != null) {
            iScreenOffView.attachMenuBar(this.mMenuBarPresenter);
        }
        ScreenOffContract.IScreenOffView iScreenOffView2 = this.mSOMView;
        if (iScreenOffView2 != null) {
            iScreenOffView2.attachGuide(this.mGuidePresenter);
        }
        ScreenOffContract.IScreenOffView iScreenOffView3 = this.mSOMView;
        if (iScreenOffView3 != null) {
            iScreenOffView3.attachScroll(this.mScrollPresenter);
        }
        ScreenOffContract.IScreenOffView iScreenOffView4 = this.mSOMView;
        if (iScreenOffView4 != null) {
            iScreenOffView4.attachCovered(this.mCoveredPresenter);
        }
        SaveModel saveModel2 = this.mSaveModel;
        if (saveModel2 != null) {
            ComposerViewPresenter compViewPresenter = getCompViewPresenter();
            ComposerModel composerModel = getComposerModel();
            Activity activity = getActivity();
            saveModel2.init(compViewPresenter, composerModel, (activity == null || (resources = activity.getResources()) == null) ? 0 : resources.getColor(C9086R.color.composer_main_background_light, null));
        }
        LoadedPinModel loadedPinModel = this.mLoadedPinModel;
        if (loadedPinModel != null) {
            loadedPinModel.init(getComposerModel());
        }
        RotationModel rotationModel = this.mRotationModel;
        Activity activity2 = getActivity();
        rotationModel.init(this, (activity2 == null || (window = activity2.getWindow()) == null) ? null : window.getDecorView());
        CloseModel closeModel = this.mCloseModel;
        if (closeModel != null) {
            closeModel.init(-1);
        }
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager != null) {
            dialogPresenterManager.init(this.mDialogCreator, this, this, this);
        }
        DialogPresenterManager dialogPresenterManager2 = this.mDialogPresenterManager;
        if (dialogPresenterManager2 != null) {
            dialogPresenterManager2.onAttachView(getActivity());
        }
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager != null) {
            controllerManager.init(getComposerModel(), this.mSaveModel);
        }
        ControllerManager controllerManager2 = this.mControllerManager;
        if (controllerManager2 != null) {
            controllerManager2.onAttachView();
        }
        this.mGuidePresenter.init(getCompViewPresenter(), getComposerModel());
        this.mGuidePresenter.onAttachView();
        this.mGuidePresenter.initView();
        this.mScrollPresenter.init(getCompViewPresenter(), this.mRotationModel);
        this.mScrollPresenter.onAttachView(getActivity());
        this.mScrollPresenter.initView(this.isNoteChanged ? 0 : 4);
        this.mCoveredPresenter.init();
        this.mCoveredPresenter.onAttachView(getIntent());
        this.mCoveredPresenter.initView(8, false);
        this.mMenuBarPresenter.init(getCompViewPresenter(), this.mRotationModel, this);
        this.mMenuBarPresenter.onAttachView();
        this.mMenuBarPresenter.initView(this.isNoteChanged ? 0 : 4);
        ScreenOffContract.IScreenOffView iScreenOffView5 = this.mSOMView;
        if (iScreenOffView5 != null) {
            iScreenOffView5.requestRelayout();
        }
        if (this.isNoteChanged) {
            onPostNoteChanged();
        } else {
            LoadedNote loadedNote = this.mLoadedNote;
            if ((loadedNote != null ? loadedNote.getMLoadedNoteType() : null) != LoadedNote.Type.NONE) {
                LoadedNote loadedNote2 = this.mLoadedNote;
                String mUuid = loadedNote2 != null ? loadedNote2.getMUuid() : null;
                LoadedNote loadedNote3 = this.mLoadedNote;
                String mNotePath = loadedNote3 != null ? loadedNote3.getMNotePath() : null;
                SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("onInitFinished# deleteDocumentFile uuid/notePath ", mUuid, "/", Logger.getEncode(mNotePath)));
                deleteNoteFile(mUuid, mNotePath, 6);
            }
        }
        if ((StartCommandFactory.INSTANCE.getInstance().makeStartCommand(getIntent()) instanceof LoadNoteByDoubleTapOnAOD) && (saveModel = this.mSaveModel) != null) {
            saveModel.saveCache();
        }
        this.mInitFinished = true;
        if (this.mHandler.hasMessages(1)) {
            SOLogger.INSTANCE.SOLoggerD(TAG, "onInitFinished# has MESSAGE_WAIT_TO_INIT_FINISHED");
            onWaitToInitFinished(0);
        }
        SAManager.INSTANCE.getINSTANCE().setExitReason(-1);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onInitialized() {
        Navigator.DefaultImpls.onInitialized(this);
    }

    public final void onInterrupted() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onInterrupted#");
        SAManager.INSTANCE.getINSTANCE().setExitReason(7);
        IState iState = this.mState;
        if (iState != null) {
            iState.onInterrupted(this);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.SOMBasePresenter.Contract
    public void onPause() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPause#");
        IState iState = this.mState;
        if (iState != null) {
            iState.onPause(this);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter.IMenuBarNavigator
    public void onPin() {
        String aODPinnedContent;
        PinController pinController;
        PinController pinController2;
        if (getComposerModel().isEmpty()) {
            ToastHandler.show(BaseUtils.getApplicationContext(), C9086R.string.screenoff_nothing_to_pin_to_always_on_display, 1);
            return;
        }
        if (ConfigurationModel.INSTANCE.getAODPinnedPreviewVersion() < 1) {
            onStartAnimationPin();
            return;
        }
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        ControllerManager controllerManager = this.mControllerManager;
        String currentPinnedNoteUri = null;
        if (controllerManager == null || (pinController2 = controllerManager.getPinController()) == null) {
            aODPinnedContent = null;
        } else {
            ContentResolver contentResolver = activity.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
            aODPinnedContent = pinController2.getAODPinnedContent(contentResolver);
        }
        ControllerManager controllerManager2 = this.mControllerManager;
        if (controllerManager2 != null && (pinController = controllerManager2.getPinController()) != null) {
            currentPinnedNoteUri = pinController.getCurrentPinnedNoteUri();
        }
        Uri uri = Uri.parse(currentPinnedNoteUri);
        boolean zIsValid = UriFileUtils.isValid(activity, uri);
        IStartCommand primitiveStartCommand = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand();
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPin# aodPinnedContent/pinnedNote/primitiveStartCommand " + aODPinnedContent + "/" + uri + "/" + primitiveStartCommand);
        if (TextUtils.isEmpty(aODPinnedContent) || !zIsValid || (primitiveStartCommand instanceof LoadNoteByDoubleTapOnAOD)) {
            onStartAnimationPin();
        } else {
            Intrinsics.checkNotNull(uri);
            requestShowPinNoteDialog(uri);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.pin.IPinAnimationListener
    public void onPinAnimationEnd() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPinAnimationEnd#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.PinNoteDialogPresenter.IPinNoteDialogPresenter
    @RequiresApi(29)
    public void onPinNoteDialogDiscard() {
        PinController pinController;
        PinController pinController2;
        PinController pinController3;
        PinController pinController4;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPinNoteDialogDiscard#");
        ControllerManager controllerManager = this.mControllerManager;
        String strLoadPinnedNotePathByUri = null;
        String currentPinnedNoteUri = (controllerManager == null || (pinController4 = controllerManager.getPinController()) == null) ? null : pinController4.getCurrentPinnedNoteUri();
        ControllerManager controllerManager2 = this.mControllerManager;
        String strLoadPinnedNoteUuidByUri = (controllerManager2 == null || (pinController3 = controllerManager2.getPinController()) == null) ? null : pinController3.loadPinnedNoteUuidByUri(currentPinnedNoteUri);
        ControllerManager controllerManager3 = this.mControllerManager;
        if (controllerManager3 != null && (pinController2 = controllerManager3.getPinController()) != null) {
            strLoadPinnedNotePathByUri = pinController2.loadPinnedNotePathByUri(currentPinnedNoteUri);
        }
        ControllerManager controllerManager4 = this.mControllerManager;
        if (controllerManager4 != null && (pinController = controllerManager4.getPinController()) != null) {
            pinController.deleteExistingPinnedDataByExceptedUri(currentPinnedNoteUri);
        }
        deleteNoteFile(strLoadPinnedNoteUuidByUri, strLoadPinnedNotePathByUri, 1);
        onStartAnimationPin();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.PinNoteDialogPresenter.IPinNoteDialogPresenter
    @RequiresApi(29)
    public void onPinNoteDialogSave() {
        PinController pinController;
        PinController pinController2;
        PinController pinController3;
        PinController pinController4;
        ControllerManager controllerManager = this.mControllerManager;
        String strLoadPinnedNoteUuidByUri = null;
        String currentPinnedNoteUri = (controllerManager == null || (pinController4 = controllerManager.getPinController()) == null) ? null : pinController4.getCurrentPinnedNoteUri();
        ControllerManager controllerManager2 = this.mControllerManager;
        if (controllerManager2 != null && (pinController3 = controllerManager2.getPinController()) != null) {
            strLoadPinnedNoteUuidByUri = pinController3.loadPinnedNoteUuidByUri(currentPinnedNoteUri);
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onPinNoteDialogSave# pinnedNoteUri/existingUuid ", Logger.getEncode(currentPinnedNoteUri), "/", Logger.getEncode(strLoadPinnedNoteUuidByUri)));
        if (strLoadPinnedNoteUuidByUri != null && strLoadPinnedNoteUuidByUri.length() > 0 && !StringsKt.m14162r(strLoadPinnedNoteUuidByUri, "null")) {
            ToastHandler.show(BaseUtils.getApplicationContext(), CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.screenoff_saved_in_notes_jp : C9086R.string.screenoff_saved_in_notes, 1);
            SaveModel saveModel = this.mSaveModel;
            if (saveModel != null) {
                saveModel.savePinCache(strLoadPinnedNoteUuidByUri);
            }
            ControllerManager controllerManager3 = this.mControllerManager;
            if (controllerManager3 != null && (pinController2 = controllerManager3.getPinController()) != null) {
                pinController2.deleteExistingPinnedDataByExceptedUri(currentPinnedNoteUri);
            }
        }
        IStartCommand primitiveStartCommand = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand();
        sOLogger.SOLoggerD(str, "onPinNoteDialogSave# primitiveStartCommand ".concat(primitiveStartCommand.getClass().getSimpleName()));
        if (primitiveStartCommand instanceof LoadNoteByDoubleTapOnAOD) {
            sOLogger.SOLoggerD(str, "onPinNoteDialogSave# savePrimitiveDocument by LoadNoteByDoubleTapOnAOD");
            SaveModel saveModel2 = this.mSaveModel;
            if (saveModel2 != null) {
                saveModel2.savePrimitiveDocument();
            }
        }
        LegacyPinnedNoteConverter.INSTANCE.getInstance().setReleaseType(LegacyPinnedNoteConverter.ReleaseType.SAVE_PUSHED);
        ControllerManager controllerManager4 = this.mControllerManager;
        if (controllerManager4 != null && (pinController = controllerManager4.getPinController()) != null) {
            pinController.savePinCache();
        }
        onStartAnimationPin();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.pin.IPinAnimationListener
    @RequiresApi(29)
    public void onPinToAOD(@NotNull Bitmap capturedComposerView, boolean isEdited, float scrollPanY) {
        PinController pinController;
        Intrinsics.checkNotNullParameter(capturedComposerView, "capturedComposerView");
        SOLogger.INSTANCE.SOLoggerD(TAG, "onPin#");
        ControllerManager controllerManager = this.mControllerManager;
        if (controllerManager == null || (pinController = controllerManager.getPinController()) == null) {
            return;
        }
        pinController.pinToAOD(capturedComposerView, isEdited, scrollPanY);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onPreHide() {
        IStateSetter stateSetter;
        Resources resources;
        Configuration configuration;
        Activity activity = getActivity();
        int i = (activity == null || (resources = activity.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.orientation;
        this.mPreHideOrientation = i;
        AbstractC8014b.m7206h("onPreHide# ", i, SOLogger.INSTANCE, TAG);
        IState iState = this.mState;
        if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
            IState iState2 = this.mState;
            stateSetter.onSetState(new StateHiding(iState2 != null ? iState2.getStateSetter() : null));
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            View viewFindViewById = activity2.findViewById(C9086R.id.main_layout_container);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(4);
            }
            View viewFindViewById2 = activity2.findViewById(C9086R.id.menu_bar_layout);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(4);
            }
            View viewFindViewById3 = activity2.findViewById(C9086R.id.scroll_layout);
            if (viewFindViewById3 != null) {
                viewFindViewById3.setVisibility(4);
            }
            View viewFindViewById4 = activity2.findViewById(C9086R.id.guide_layout);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(4);
            }
        }
        if (getCompViewPresenter().getView() != null) {
            getCompViewPresenter().getView().setVisibility(4);
        }
        this.mCoveredPresenter.onPreHide();
        IState iState3 = this.mState;
        if (iState3 != null) {
            iState3.onWindowFocusChanged(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPreShow() {
        boolean z;
        IStateSetter stateSetter;
        IStateSetter stateSetter2;
        Resources resources;
        Configuration configuration;
        Activity activity = getActivity();
        boolean z2 = false;
        this.mPreShowOrientation = (activity == null || (resources = activity.getResources()) == null || (configuration = resources.getConfiguration()) == null) ? 0 : configuration.orientation;
        IStartingAnimation iStartingAnimation = this.mStartingPenHoverAnimation;
        if (iStartingAnimation != null ? iStartingAnimation.isAnimating() : false) {
            z = true;
        } else {
            ShowingAnimation showingAnimation = this.mShowingAnimation;
            if (!(showingAnimation != null ? showingAnimation.getIsAnimating() : false)) {
                z = false;
            }
        }
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        IStartCommand iStartCommandMakeStartCommand = companion.getInstance().makeStartCommand(getIntent());
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onPreShow# mInitFinished/orientation/isAnimating/startCommand " + this.mInitFinished + "/" + this.mPreShowOrientation + "/" + z + "/" + iStartCommandMakeStartCommand.getClass().getSimpleName());
        if (this.mInitFinished) {
            if (companion.getInstance().makeStartCommand(getIntent()) instanceof PenButtonHoverTap) {
                sOLogger.SOLoggerD(str, "onPreShow# WAIT_TO_ON_GET_WINDOW_FOCUSED_DELAY");
                onWaitToGetWindowFocused();
            } else {
                if (z) {
                    sOLogger.SOLoggerD(str, "onPreShow# stop animation");
                    IState iState = this.mState;
                    if (iState != null && (stateSetter2 = iState.getStateSetter()) != null) {
                        IState iState2 = this.mState;
                        stateSetter2.onSetState(new StateShowing(iState2 != null ? iState2.getStateSetter() : null));
                    }
                    IStartingAnimation iStartingAnimation2 = this.mStartingPenHoverAnimation;
                    if (iStartingAnimation2 != null && iStartingAnimation2.isAnimating()) {
                        z2 = true;
                    }
                    if (z2) {
                        IStartingAnimation iStartingAnimation3 = this.mStartingPenHoverAnimation;
                        if (iStartingAnimation3 != null) {
                            iStartingAnimation3.stop();
                        }
                    } else {
                        ShowingAnimation showingAnimation2 = this.mShowingAnimation;
                        if (showingAnimation2 != null) {
                            showingAnimation2.stop();
                        }
                    }
                } else {
                    IState iState3 = this.mState;
                    if (iState3 != null && (stateSetter = iState3.getStateSetter()) != null) {
                        IState iState4 = this.mState;
                        stateSetter.onSetState(new StateShowing(iState4 != null ? iState4.getStateSetter() : null));
                    }
                    Activity activity2 = getActivity();
                    if (activity2 != null) {
                        View viewFindViewById = activity2.findViewById(C9086R.id.main_layout_container);
                        if (viewFindViewById != null) {
                            viewFindViewById.setVisibility(0);
                        }
                        View viewFindViewById2 = activity2.findViewById(C9086R.id.menu_bar_layout);
                        if (viewFindViewById2 != null) {
                            viewFindViewById2.setVisibility(0);
                        }
                        View viewFindViewById3 = activity2.findViewById(C9086R.id.scroll_layout);
                        if (viewFindViewById3 != null) {
                            viewFindViewById3.setVisibility(0);
                        }
                        View viewFindViewById4 = activity2.findViewById(C9086R.id.guide_layout);
                        if (viewFindViewById4 != null) {
                            viewFindViewById4.setVisibility(0);
                        }
                    }
                    if (needToWaitToShowUntilNavigationShown()) {
                        this.mHandler.removeMessages(4);
                        this.mHandler.sendMessageDelayed(Message.obtain(this.mHandler, 4, getCompViewPresenter().getView()), 700L);
                    } else if (getCompViewPresenter().getView() != null) {
                        getCompViewPresenter().getView().setVisibility(0);
                    }
                    IState iState5 = this.mState;
                    if (iState5 != null) {
                        iState5.onWindowFocusChanged(this);
                    }
                }
            }
            this.mCoveredPresenter.onPreShow();
        }
    }

    public final void onReadyToShow(boolean withAnimation) {
        Activity activity;
        Window window;
        View decorView;
        ScreenOffPresenter screenOffPresenter;
        Intent intent;
        IStateSetter stateSetter;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onReadyToShow# initFinished/withAnimation " + this.mInitFinished + "/" + withAnimation);
        if (!this.mInitFinished) {
            onWaitToInitFinished(500);
            return;
        }
        if (getCompViewPresenter().getView() == null) {
            sOLogger.SOLoggerW(str, "onReadyToShow# ComposerView isn't set!");
            IState iState = this.mState;
            if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
                IState iState2 = this.mState;
                stateSetter.onSetState(new StateClosing(iState2 != null ? iState2.getStateSetter() : null));
            }
            onFinish();
            return;
        }
        this.mMenuBarPresenter.onReadyToShow();
        this.mGuidePresenter.onReadyToShow();
        this.mScrollPresenter.onReadyToShow();
        if ((StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand() instanceof LoadNoteByDoubleTapOnAOD) && !this.mScrollPresenter.getPanIsSet()) {
            ScrollPresenter scrollPresenter = this.mScrollPresenter;
            Activity activity2 = getActivity();
            float floatExtra = 0.0f;
            if (activity2 != null && (intent = activity2.getIntent()) != null) {
                floatExtra = intent.getFloatExtra(ComposerConstants.ARG_SDOC_SCROLL_PAN_Y, 0.0f);
            }
            scrollPresenter.onSetScrollPanY(floatExtra);
            this.mScrollPresenter.setPanIsSet(true);
        }
        IState iState3 = this.mState;
        if (iState3 != null) {
            iState3.onReadyToShow(this);
        }
        if (!withAnimation || (activity = getActivity()) == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ShowingAnimation showingAnimation = this.mShowingAnimation;
        if (showingAnimation != null) {
            screenOffPresenter = this;
            showingAnimation.init(decorView, getCompViewPresenter().getView(), PenInfoModel.INSTANCE.getColor(), needToWaitToShowUntilNavigationShown(), screenOffPresenter);
        } else {
            screenOffPresenter = this;
        }
        ShowingAnimation showingAnimation2 = screenOffPresenter.mShowingAnimation;
        if (showingAnimation2 != null) {
            showingAnimation2.start();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.SOMBasePresenter.Contract
    public void onResume() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onResume#");
        StartCommandFactory companion = StartCommandFactory.INSTANCE.getInstance();
        Activity activity = getActivity();
        companion.makeStartCommand(activity != null ? activity.getIntent() : null).executeOnResume(this, this.mState);
        AODCommandFactory companion2 = AODCommandFactory.INSTANCE.getInstance();
        Activity activity2 = getActivity();
        companion2.makeAODCommand(activity2 != null ? activity2.getIntent() : null).executeOnResume(this, this.mState);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onSave() {
        PinController pinController;
        IStartCommand primitiveStartCommand = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onSave# primitiveStartCommand ".concat(primitiveStartCommand.getClass().getSimpleName()));
        SaveModel saveModel = this.mSaveModel;
        if (saveModel == null || saveModel.isEmpty()) {
            return;
        }
        if ((primitiveStartCommand instanceof LoadNoteByDoubleTapOnAOD) && !LegacyPinnedNoteConverter.INSTANCE.getInstance().isConverted()) {
            sOLogger.SOLoggerD(str, "onSave# saveCachePrimitiveDocument by LoadNoteByDoubleTapOnAOD");
            String strM756B = AbstractC0541b.m756B(UUIDUtils.newUUID(BaseUtils.getApplicationContext()), "_screenoff");
            String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(BaseUtils.getApplicationContext(), ".sdocx");
            Intrinsics.checkNotNullExpressionValue(strCreateSavedPath, "createSavedPath(...)");
            ControllerManager controllerManager = this.mControllerManager;
            if (controllerManager != null && (pinController = controllerManager.getPinController()) != null) {
                pinController.replacePinnedNoteData(((LoadNoteByDoubleTapOnAOD) primitiveStartCommand).getMUri(), strM756B, strCreateSavedPath);
            }
            SaveModel saveModel2 = this.mSaveModel;
            if (saveModel2 != null) {
                saveModel2.saveCachePrimitiveDocument(strM756B, strCreateSavedPath);
            }
            SaveModel saveModel3 = this.mSaveModel;
            if (saveModel3 != null) {
                saveModel3.setSaveModelDiscard(false);
            }
        }
        LegacyPinnedNoteConverter.INSTANCE.getInstance().setReleaseType(LegacyPinnedNoteConverter.ReleaseType.SAVE);
        SaveModel saveModel4 = this.mSaveModel;
        if (saveModel4 != null) {
            saveModel4.save();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onSaveNoteCache() throws Throwable {
        SaveModel saveModel;
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        sOLogger.SOLoggerD(str, "onSaveNoteCache# " + companion.getInstance().getPrimitiveStartCommand());
        if (!this.mInitFinished || (saveModel = this.mSaveModel) == null || saveModel.isEmpty()) {
            return;
        }
        LegacyPinnedNoteConverter.INSTANCE.getInstance().setReleaseType(LegacyPinnedNoteConverter.ReleaseType.SAVE_CACHE);
        CloseModel closeModel = this.mCloseModel;
        Integer numValueOf = closeModel != null ? Integer.valueOf(closeModel.getCloseReason()) : null;
        if (!(companion.getInstance().getPrimitiveStartCommand() instanceof LoadNoteByDoubleTapOnAOD) || numValueOf == null || numValueOf.intValue() != 6) {
            SaveModel saveModel2 = this.mSaveModel;
            if (saveModel2 != null) {
                saveModel2.saveCache();
                return;
            }
            return;
        }
        sOLogger.SOLoggerD(str, "onSaveNoteCache# saveCacheEditedPinDocument by LoadNoteByDoubleTapOnAOD and HOME pressed");
        String strM756B = AbstractC0541b.m756B(UUIDUtils.newUUID(BaseUtils.getApplicationContext()), "_screenoff");
        String strCreateSavedPath = NotesDocumentFileUtils.createSavedPath(BaseUtils.getApplicationContext(), ".sdocx");
        Intrinsics.checkNotNullExpressionValue(strCreateSavedPath, "createSavedPath(...)");
        SaveModel saveModel3 = this.mSaveModel;
        if (saveModel3 != null) {
            saveModel3.saveCacheEditedPinDocument(strM756B, strCreateSavedPath);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.SaveNoteDialogPresenter.ISaveNoteDialogNavigator
    public void onSaveNoteDialogDiscard() {
        SaveModel saveModel;
        IStateSetter stateSetter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onSaveNoteDialogDiscard#");
        IState iState = this.mState;
        if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
            IState iState2 = this.mState;
            stateSetter.onSetState(new StateClosing(iState2 != null ? iState2.getStateSetter() : null));
        }
        setCloseReason(2);
        SaveModel saveModel2 = this.mSaveModel;
        if (saveModel2 != null && !saveModel2.isEmpty() && (saveModel = this.mSaveModel) != null) {
            saveModel.discard();
        }
        LegacyPinnedNoteConverter.INSTANCE.getInstance().setReleaseType(LegacyPinnedNoteConverter.ReleaseType.DISCARD);
        onFinish();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.SaveNoteDialogPresenter.ISaveNoteDialogNavigator
    public void onSaveNoteDialogSave() {
        IStateSetter stateSetter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onSaveNoteDialogSave#");
        IState iState = this.mState;
        if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
            IState iState2 = this.mState;
            stateSetter.onSetState(new StateClosing(iState2 != null ? iState2.getStateSetter() : null));
        }
        setCloseReason(3);
        onStartAnimationClosing();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onSavePinCache(@Nullable String uri) {
        String strLoadExistingPinnedLegacyNotePathByPath;
        PinController pinController;
        PinController pinController2;
        File filesDir;
        PinController pinController3;
        File filesDir2;
        ControllerManager controllerManager = this.mControllerManager;
        String absolutePath = null;
        if (controllerManager == null || (pinController3 = controllerManager.getPinController()) == null) {
            strLoadExistingPinnedLegacyNotePathByPath = null;
        } else {
            Activity activity = getActivity();
            strLoadExistingPinnedLegacyNotePathByPath = pinController3.loadExistingPinnedLegacyNotePathByPath((activity == null || (filesDir2 = activity.getFilesDir()) == null) ? null : filesDir2.getAbsolutePath(), uri);
        }
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        AbstractC8014b.m7208j("onSavePinCache# legacyPinPath ", Logger.getEncode(strLoadExistingPinnedLegacyNotePathByPath), sOLogger, str);
        if (strLoadExistingPinnedLegacyNotePathByPath != null && strLoadExistingPinnedLegacyNotePathByPath.length() != 0) {
            String strNewUUID = UUIDUtils.newUUID(getActivity());
            Activity activity2 = getActivity();
            sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onSavePinCache# uuid/path ", strNewUUID, "/", Logger.getEncode(activity2 != null ? LegacyPinnedNoteConverter.INSTANCE.getInstance().convert(activity2, strNewUUID, strLoadExistingPinnedLegacyNotePathByPath) : null)));
            ControllerManager controllerManager2 = this.mControllerManager;
            if (controllerManager2 != null && (pinController2 = controllerManager2.getPinController()) != null) {
                if (activity2 != null && (filesDir = activity2.getFilesDir()) != null) {
                    absolutePath = filesDir.getAbsolutePath();
                }
                pinController2.deleteExistingPinnedLegacyNoteByExceptedPath(absolutePath, uri);
            }
        } else if (ConfigurationModel.INSTANCE.getAODPinnedPreviewVersion() < 1) {
            IStartCommand primitiveStartCommand = StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand();
            sOLogger.SOLoggerD(str, "onSavePinCache# primitiveStartCommand ".concat(primitiveStartCommand.getClass().getSimpleName()));
            if (primitiveStartCommand instanceof LoadNoteByDoubleTapOnAOD) {
                sOLogger.SOLoggerD(str, "onSavePinCache# savePrimitiveDocument by LoadNoteByDoubleTapOnAOD");
                SaveModel saveModel = this.mSaveModel;
                if (saveModel != null) {
                    saveModel.savePrimitiveDocument();
                }
            }
        }
        LegacyPinnedNoteConverter.INSTANCE.getInstance().setReleaseType(LegacyPinnedNoteConverter.ReleaseType.SAVE_PUSHED);
        ControllerManager controllerManager3 = this.mControllerManager;
        if (controllerManager3 == null || (pinController = controllerManager3.getPinController()) == null) {
            return;
        }
        pinController.savePinCache();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.SelectNoteDialogPresenter.ISelectNoteDialogNavigator
    public void onSelectNoteDialogDiscard() {
        onPreNoteChanged();
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        String mUri = companion.getInstance().getPrimitiveStartCommand().getMUri();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onSelectNoteDialogDiscard# uri " + Logger.getEncode(mUri));
        LoadNoteByDoubleTapOnAOD loadNoteByDoubleTapOnAOD = new LoadNoteByDoubleTapOnAOD();
        loadNoteByDoubleTapOnAOD.setUri(mUri);
        companion.getInstance().setPrimitiveStartCommand(loadNoteByDoubleTapOnAOD);
        SaveModel saveModel = this.mSaveModel;
        String uuid = saveModel != null ? saveModel.getUuid() : null;
        SaveModel saveModel2 = this.mSaveModel;
        deleteNoteFile(uuid, saveModel2 != null ? saveModel2.getMNotePath() : null, 1);
        SaveModel saveModel3 = this.mSaveModel;
        if (saveModel3 != null) {
            saveModel3.discard();
        }
        LoadedPinModel loadedPinModel = this.mLoadedPinModel;
        String uuid2 = loadedPinModel != null ? loadedPinModel.getUuid() : null;
        LoadedPinModel loadedPinModel2 = this.mLoadedPinModel;
        String notePath = loadedPinModel2 != null ? loadedPinModel2.getNotePath() : null;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onSelectNoteDialogDiscard# selectionUuid/selectionNotePath ", uuid2, "/", Logger.getEncode(notePath)));
        getIntent().putExtra("sdoc_uuid", uuid2);
        getIntent().putExtra("doc_path", notePath);
        changeNote(uuid2, notePath);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.dialog.SelectNoteDialogPresenter.ISelectNoteDialogNavigator
    public void onSelectNoteDialogSave() {
        onPreNoteChanged();
        StartCommandFactory.Companion companion = StartCommandFactory.INSTANCE;
        String mUri = companion.getInstance().getPrimitiveStartCommand().getMUri();
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        sOLogger.SOLoggerD(str, "onSelectNoteDialogSave# uri " + Logger.getEncode(mUri));
        LoadNoteByDoubleTapOnAOD loadNoteByDoubleTapOnAOD = new LoadNoteByDoubleTapOnAOD();
        loadNoteByDoubleTapOnAOD.setUri(mUri);
        companion.getInstance().setPrimitiveStartCommand(loadNoteByDoubleTapOnAOD);
        SaveModel saveModel = this.mSaveModel;
        if (saveModel != null) {
            saveModel.saveChanged();
        }
        LoadedPinModel loadedPinModel = this.mLoadedPinModel;
        String uuid = loadedPinModel != null ? loadedPinModel.getUuid() : null;
        LoadedPinModel loadedPinModel2 = this.mLoadedPinModel;
        String notePath = loadedPinModel2 != null ? loadedPinModel2.getNotePath() : null;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onSelectNoteDialogSave# selectionUuid/selectionNotePath ", uuid, "/", Logger.getEncode(notePath)));
        getIntent().putExtra("sdoc_uuid", uuid);
        getIntent().putExtra("doc_path", notePath);
        changeNote(uuid, notePath);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter.IMenuBarNavigator
    public void onSetCloseReason(int closeReason) {
        setCloseReason(closeReason);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.state.IStateSetter
    public void onSetState(@Nullable IState state) {
        SOLogger sOLogger = SOLogger.INSTANCE;
        String str = TAG;
        IState iState = this.mState;
        sOLogger.SOLoggerD(str, AbstractC0541b.m774p("onSetState before/after# ", iState != null ? iState.getClass().getSimpleName() : null, "/", state != null ? state.getClass().getSimpleName() : null));
        this.mState = state;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onShowingAnimation() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "onShowingAnimation#");
        onReadyToShow(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.showing.IShowingAnimationListener
    public void onShowingAnimationEnd() {
        IStateSetter stateSetter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onShowingAnimationEnd#");
        IState iState = this.mState;
        if (!(iState instanceof StateShowing)) {
            if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
                IState iState2 = this.mState;
                stateSetter.onSetState(new StateShowing(iState2 != null ? iState2.getStateSetter() : null));
            }
            IState iState3 = this.mState;
            if (iState3 != null) {
                iState3.onWindowFocusChanged(this);
            }
        }
        SAManager.INSTANCE.getINSTANCE().onShow(StartCommandFactory.INSTANCE.getInstance().getPrimitiveStartCommand().getClass().getSimpleName());
        onFocused();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.showing.IShowingAnimationListener
    public void onShowingAnimationHalfProgressed() {
        IStateSetter stateSetter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onShowingAnimationHalfProgressed#");
        IState iState = this.mState;
        if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
            IState iState2 = this.mState;
            stateSetter.onSetState(new StateShowing(iState2 != null ? iState2.getStateSetter() : null));
        }
        IState iState3 = this.mState;
        if (iState3 != null) {
            iState3.onWindowFocusChanged(this);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.menubar.MenuBarPresenter.IMenuBarNavigator
    public void onStartAnimationClosing() {
        Window window;
        View decorView;
        ScreenOffPresenter screenOffPresenter;
        IStateSetter stateSetter;
        SOLogger.INSTANCE.SOLoggerD(TAG, "onStartAnimationClosing#");
        this.mMenuBarPresenter.onWindowFocusChanged(false);
        boolean zIsEmpty = getComposerModel().isEmpty();
        if (zIsEmpty) {
            ToastHandler.show(BaseUtils.getApplicationContext(), C9086R.string.screenoff_no_content_to_save_note_discarded, 1);
        } else {
            ToastHandler.show(BaseUtils.getApplicationContext(), CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy() ? C9086R.string.screenoff_saved_in_notes_jp : C9086R.string.screenoff_saved_in_notes, 1);
        }
        IState iState = this.mState;
        if (iState != null && (stateSetter = iState.getStateSetter()) != null) {
            IState iState2 = this.mState;
            stateSetter.onSetState(new StateClosing(iState2 != null ? iState2.getStateSetter() : null));
        }
        IState iState3 = this.mState;
        if (iState3 != null) {
            iState3.onWindowFocusChanged(this);
        }
        Activity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ClosingAnimation closingAnimation = this.mClosingAnimation;
        if (closingAnimation != null) {
            screenOffPresenter = this;
            closingAnimation.init(decorView, screenOffPresenter, getCompViewPresenter().getView(), getCompViewPresenter().captureCurrentView(), this.mRotationModel.getRotation(), zIsEmpty);
        } else {
            screenOffPresenter = this;
        }
        ClosingAnimation closingAnimation2 = screenOffPresenter.mClosingAnimation;
        if (closingAnimation2 != null) {
            closingAnimation2.start();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void onStarted() {
        Navigator.DefaultImpls.onStarted(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.screenoff.presenter.SOMBasePresenter.Contract
    public void onWindowFocusChanged(boolean hasFocus) {
        AbstractC8014b.m7211m("onWindowFocusChanged# hasFocus ", hasFocus, SOLogger.INSTANCE, TAG);
        IState iState = this.mState;
        if (iState != null) {
            iState.onWindowFocusChanged(this);
        }
        this.mMenuBarPresenter.onWindowFocusChanged(hasFocus);
        if (!hasFocus) {
            IState iState2 = this.mState;
            if (iState2 != null) {
                iState2.onNotifyExecution(this, "close", false);
                return;
            }
            return;
        }
        IState iState3 = this.mState;
        if (iState3 != null) {
            iState3.onNotifyExecution(this, Constants.IntentExtraValue.SHOW, false);
        }
        if (this.mHandler.hasMessages(3)) {
            this.mHandler.removeMessages(3);
        }
        StartCommandFactory companion = StartCommandFactory.INSTANCE.getInstance();
        Activity activity = getActivity();
        companion.makeStartCommand(activity != null ? activity.getIntent() : null).executeOnWindowFocusChanged(this, this.mState);
        if (KeepScreenOnFlagFeature.INSTANCE.needToAddKeepScreenOnFlag()) {
            PowerManagerHandler.INSTANCE.requestGoToSleep(ConfigurationModel.INSTANCE.getScreenTimeOut());
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestReadyToShow(boolean withAnimation) {
        AbstractC8014b.m7211m("requestReadyToShow# ", withAnimation, SOLogger.INSTANCE, TAG);
        onReadyToShow(withAnimation);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestResetZoomScaleToDefault() {
        getCompViewPresenter().requestResetZoomScaleToDefault();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestRestart() {
        Navigator.DefaultImpls.requestRestart(this);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestShowPinNoteDialog(@NotNull Uri pinnedNoteUri) {
        Intrinsics.checkNotNullParameter(pinnedNoteUri, "pinnedNoteUri");
        SOLogger.INSTANCE.SOLoggerD(TAG, "requestShowPinNoteDialog#");
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager != null) {
            dialogPresenterManager.showPinNoteDialog(pinnedNoteUri);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestShowSaveNoteDialog() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "requestShowSaveNoteDialog#");
        DialogPresenterManager dialogPresenterManager = this.mDialogPresenterManager;
        if (dialogPresenterManager != null) {
            dialogPresenterManager.showSaveNoteDialog();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void requestShowSelectNoteDialog() {
        DialogPresenterManager dialogPresenterManager;
        SaveModel saveModel = this.mSaveModel;
        String uuid = saveModel != null ? saveModel.getUuid() : null;
        LoadedPinModel loadedPinModel = this.mLoadedPinModel;
        String uuid2 = loadedPinModel != null ? loadedPinModel.getUuid() : null;
        SOLogger.INSTANCE.SOLoggerD(TAG, AbstractC0541b.m774p("requestShowSelectNoteDialog# uuid/loadedPinUuid ", uuid, "/", uuid2));
        if (Intrinsics.areEqual(uuid, uuid2) || (dialogPresenterManager = this.mDialogPresenterManager) == null) {
            return;
        }
        dialogPresenterManager.showSelectNoteDialog();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void reserveRestart() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "reserveRestart#");
        this.mIsReserveRestart = true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void resetIntent() {
        SOLogger.INSTANCE.SOLoggerD(TAG, "resetIntent#");
        Intent intent = getIntent();
        intent.removeExtra(Constants.BooleanExtraKey.PRE_INITIALIZED_COM);
        intent.removeExtra(Constants.StringExtraKey.PEN_INTENT_COM);
        intent.removeExtra("pin_com_load");
        intent.removeExtra(Constants.StringExtraKey.AOD_INTENT_PIN_COM_DELETE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void setCloseReason(int closeReason) {
        CloseModel closeModel = this.mCloseModel;
        if (closeModel != null) {
            closeModel.setCloseReason(closeReason);
        }
    }

    public final void setLoadedNote(@Nullable LoadedNote loadedNote) {
        this.mLoadedNote = loadedNote;
        SOLogger.INSTANCE.SOLoggerD(TAG, "setLoadedNote " + (loadedNote != null ? loadedNote.getMLoadedNoteType() : null));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void setLoadedPinNotePath(@Nullable String notePath) {
        LoadedPinModel loadedPinModel = this.mLoadedPinModel;
        if (loadedPinModel != null) {
            loadedPinModel.setNotePath(notePath);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.navigator.Navigator
    public void setLoadedPinUuid(@NotNull String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        LoadedPinModel loadedPinModel = this.mLoadedPinModel;
        if (loadedPinModel != null) {
            loadedPinModel.setUuid(uuid);
        }
    }

    public final void setState(@Nullable IState state) {
        Constructor<?> constructor;
        try {
            IState iState = null;
            SOLogger.INSTANCE.SOLoggerD(TAG, "setState# " + (state != null ? state.getClass().getSimpleName() : null));
            if (state != null && (constructor = state.getClass().getConstructor(IStateSetter.class)) != null) {
                iState = (IState) constructor.newInstance(this);
            }
            this.mState = iState;
        } catch (Exception e) {
            SOLogger.INSTANCE.SOLoggerW(TAG, "setState, exception " + e);
            handleExceptionalCase();
        }
    }

    public final void setView(@Nullable ScreenOffContract.IScreenOffView view) {
        SOLogger.INSTANCE.SOLoggerD(TAG, "setView#");
        this.mSOMView = view;
    }
}
