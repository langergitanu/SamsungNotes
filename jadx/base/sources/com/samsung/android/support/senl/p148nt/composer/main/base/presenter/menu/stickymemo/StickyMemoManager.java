package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.glance.AbstractC2821a;
import com.google.firebase.messaging.Constants;
import com.samsung.android.sdk.pen.worddoc.SpenStickyNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.smp.common.constants.NetworkConfig;
import com.samsung.android.support.senl.addons.brush.viewmodel.menu.RunnableC7967b;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.provider.SettingsCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.common.handoff.RunnableC8212b;
import com.samsung.android.support.senl.p148nt.base.common.WindowInsetsManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragEventDispatcher;
import com.samsung.android.support.senl.p148nt.base.composer.focus.FocusManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.SmViewConfig;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.StickyMemoSAConstants;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ControlFactory;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.SmControlManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmTaskController;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.SmWaitForSaveTask;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.document.SmDocumentManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar.SmToolbar;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.data.ComposerSaveModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.UndoRedoPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.HistoryEventListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.ActionReadonlyMode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter.StickyMemoProgressControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter.StickyMemoQuickSaveControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter.StickyMemoSipControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.stickymemo.adapter.StickyMemoToolbarControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p066P2.RunnableC0202d;
import p079T.C0287e;
import p097Y0.C0344a;
import p123b3.C4202b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000ú\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 \u0088\u00012\u00020\u0001:\u000e\u0088\u0001\u0089\u0001\u008a\u0001\u008b\u0001\u008c\u0001\u008d\u0001\u008e\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0002\u001a\u00020\u0003J6\u0010B\u001a\u00020C2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IJ\u0010\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u0003H\u0002J\u0006\u0010L\u001a\u00020CJ\u0006\u0010M\u001a\u00020CJ\u0006\u0010N\u001a\u00020CJ\u0006\u0010O\u001a\u00020CJ\n\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0014\u0010R\u001a\u00020C2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010TH\u0007J\u001c\u0010R\u001a\u00020C2\u0006\u0010U\u001a\u00020Q2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010TH\u0002J\b\u0010V\u001a\u00020CH\u0002J\u0010\u0010W\u001a\u00020C2\u0006\u0010X\u001a\u00020YH\u0002J\u0018\u0010W\u001a\u00020C2\u0006\u0010U\u001a\u00020Q2\u0006\u0010Z\u001a\u00020YH\u0002J\u0010\u0010[\u001a\u0002062\u0006\u0010\\\u001a\u00020]H\u0002J*\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020Q2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u000206H\u0002J(\u0010^\u001a\u00020_2\u0006\u0010U\u001a\u00020Q2\u0006\u0010e\u001a\u0002062\u0006\u0010f\u001a\u0002062\u0006\u0010d\u001a\u000206H\u0002J(\u0010g\u001a\u0002062\u0006\u0010h\u001a\u0002062\u0006\u0010i\u001a\u0002062\u0006\u0010j\u001a\u0002062\u0006\u0010k\u001a\u000206H\u0002J\u0010\u0010l\u001a\u00020m2\u0006\u0010U\u001a\u00020QH\u0003J\u0010\u0010n\u001a\u00020C2\u0006\u0010o\u001a\u00020mH\u0002J\b\u0010p\u001a\u00020CH\u0002J\b\u0010q\u001a\u00020CH\u0002J\b\u0010r\u001a\u00020CH\u0002J\b\u0010s\u001a\u00020CH\u0002J\u0006\u0010t\u001a\u00020\u0003J$\u0010u\u001a\u00020C2\u0006\u0010v\u001a\u00020\u00032\n\b\u0002\u0010w\u001a\u0004\u0018\u00010]2\b\b\u0002\u0010x\u001a\u00020\u0003J\u0010\u0010y\u001a\u00020\u00032\u0006\u0010v\u001a\u00020\u0003H\u0002J \u0010u\u001a\u00020C2\u0006\u0010z\u001a\u00020m2\u0006\u0010v\u001a\u00020\u00032\u0006\u0010x\u001a\u00020\u0003H\u0002J\u0012\u0010{\u001a\u00020\u00032\b\u0010|\u001a\u0004\u0018\u00010}H\u0002J\u0018\u0010~\u001a\u00020C2\u0006\u0010z\u001a\u00020m2\u0006\u0010\u007f\u001a\u00020YH\u0002J\t\u0010\u0080\u0001\u001a\u00020CH\u0002J\u0011\u0010\u0081\u0001\u001a\u00020C2\u0006\u0010z\u001a\u00020mH\u0002J\u0007\u0010\u0082\u0001\u001a\u00020\u0003J\u0011\u0010\u0083\u0001\u001a\u00020C2\u0006\u0010o\u001a\u00020mH\u0002J\u0011\u0010\u0084\u0001\u001a\u00020C2\u0006\u0010z\u001a\u00020mH\u0002J\u0014\u0010\u0085\u0001\u001a\u00020C2\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010}H\u0002J\u0013\u0010\u0087\u0001\u001a\u00020C2\b\u0010w\u001a\u0004\u0018\u00010]H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u00060'R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00060)R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082.¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u000604R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010:\u001a\u0004\u0018\u00010;8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010?8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006\u008f\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;", "", "isEnabled", "", "<init>", "(Z)V", "memoRef", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$MemoReference;", "toolShareControl", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/composer/control/ToolShareControl;", "toolbarControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoToolbarControl;", "sipControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoSipControl;", "progressControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoProgressControl;", "quickSaveControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/adapter/StickyMemoQuickSaveControl;", "composerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "getComposerViewPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "setComposerViewPresenter", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;)V", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "getControllerManager", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "setControllerManager", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;)V", "hwToolbarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;", "getHwToolbarPresenter", "()Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;", "setHwToolbarPresenter", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/hwtoolbar/HwToolbarPresenter;)V", "mGestureInsets", "Landroidx/core/graphics/Insets;", "preTouchListenerImpl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$PreTouchListenerImpl;", "onFocusChangeListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$OnFocusChangeListener;", "onCommitListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/HistoryEventListenerImpl$OnCommitListener;", "isBlockingOnCommitListener", "dragEventDispatcher", "Lcom/samsung/android/support/senl/nt/base/composer/drag/DragEventDispatcher;", "focusManager", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager;", "memoObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoObjectManager;", "saveControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$StickyMemoSaveControl;", "defWidth", "", "defHeight", "animationControl", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoAnimation;", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "init", "", "rtToolbarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/richtext/RtToolbarPresenter;", "toolbarPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/toolbar/ToolbarPresenter;", "actionManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/action/ActionManager;", "invertBackgroundColor", "invert", "onAttachView", "onDetachView", "onDestroyView", "onLayoutChangeBefore", "getContainer", "Landroid/view/ViewGroup;", "addStickyMemo", "pos", "Landroid/graphics/PointF;", "container", "updateBackground", "openStickyMemo", "memoObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "memoObj", "getStartHeight", "memoId", "", "getOpenRect", "Landroid/graphics/Rect;", "pageOffset", "Landroid/graphics/Point;", "objRect", "Landroid/graphics/RectF;", "height", "x", "y", "getOpenPos", "iconP", "size", "startP", "endP", "makeStickMemoView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;", "initStickMemo", "view", "initComposerConnection", "releaseComposerConnection", "onShowCalled", "onHideCalled", "isShowing", "hideMemo", "withAnimation", NetworkConfig.CLIENTS_FEEDBACK_DETAIL, "blockSave", "releaseHidingWork", "memoView", "isNeedHideSip", "memoObjectInfo", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;", "updateNewMemoObject", "obj", "updateMemoObjectPosition", "releaseMemoView", "onBackPressed", "detachMemoView", "releaseMemoDependency", "removeData", "objInfo", "logMinimize", "Companion", "MainFTarget", "OnFocusChangeListener", "PreTouchListenerImpl", "MemoReference", "StickyMemoSaveControl", "OnPageUpdateListenerImpl", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoManager {
    private static final String TAG = Logger.createTag("StickyMemoManager");
    public ComposerViewPresenter composerViewPresenter;
    public ControllerManager controllerManager;
    private int defHeight;
    private int defWidth;

    @Nullable
    private ExecutorService executorService;

    @Nullable
    private Handler handler;
    public HwToolbarPresenter hwToolbarPresenter;
    private boolean isBlockingOnCommitListener;
    private final boolean isEnabled;

    @Nullable
    private Insets mGestureInsets;
    private StickyMemoObjectManager memoObjectManager;
    private StickyMemoProgressControl progressControl;
    private StickyMemoQuickSaveControl quickSaveControl;
    private StickyMemoSipControl sipControl;
    private ToolShareControl toolShareControl;
    private StickyMemoToolbarControl toolbarControl;

    @NotNull
    private MemoReference memoRef = new MemoReference();

    @NotNull
    private final PreTouchListenerImpl preTouchListenerImpl = new PreTouchListenerImpl();

    @NotNull
    private final OnFocusChangeListener onFocusChangeListener = new OnFocusChangeListener();

    @NotNull
    private final HistoryEventListenerImpl.OnCommitListener onCommitListener = new C9872c(this);

    @NotNull
    private final DragEventDispatcher dragEventDispatcher = new DragEventDispatcher();

    @NotNull
    private final FocusManager focusManager = new FocusManager();

    @NotNull
    private final StickyMemoSaveControl saveControl = new StickyMemoSaveControl();

    @NotNull
    private final StickyMemoAnimation animationControl = new StickyMemoAnimation();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$MainFTarget;", "Lcom/samsung/android/support/senl/nt/base/composer/focus/FocusManager$FTarget;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;)V", "hasFocus", "", "requestFocus", "", "onLoseFocus", "onGetFocus", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class MainFTarget implements FocusManager.FTarget {
        public MainFTarget() {
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
        public boolean hasFocus() {
            return StickyMemoManager.this.getComposerViewPresenter().getView().hasFocus();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
        public void onGetFocus() {
            StickyMemoManager.this.getComposerViewPresenter().getTextManager().setCursorBlink(true);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
        public void onLoseFocus() {
            Logger.m10999d(StickyMemoManager.TAG, "onLoseFocus#");
            StickyMemoManager.this.getControllerManager().getSoftInputManager().blockToHide(true);
            StickyMemoManager.this.getComposerViewPresenter().getTextManager().setCursorBlink(false);
            StickyMemoManager.this.getControllerManager().getSoftInputManager().blockToHide(false);
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.focus.FocusManager.FTarget
        public void requestFocus() {
            if (hasFocus()) {
                return;
            }
            ModeManager modeManager = StickyMemoManager.this.getComposerViewPresenter().getComposerModel().getModeManager();
            Mode mode = Mode.Text;
            if (modeManager.isMode(mode)) {
                StickyMemoManager.this.getControllerManager().getSoftInputManager().blockToShow(true, StickyMemoManager.TAG);
            }
            StickyMemoManager.this.getComposerViewPresenter().requestFocus();
            if (StickyMemoManager.this.getComposerViewPresenter().getComposerModel().getModeManager().isMode(mode)) {
                StickyMemoManager.this.getControllerManager().getSoftInputManager().blockToShow(false, StickyMemoManager.TAG);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0015\u001a\u00020\u0016R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R(\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$MemoReference;", "", "<init>", "()V", "memoObject", "Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "showingObject", "getShowingObject", "()Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;", "setShowingObject", "(Lcom/samsung/android/sdk/pen/worddoc/SpenStickyNote;)V", "memoView", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;", "showingMemo", "getShowingMemo", "()Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;", "setShowingMemo", "(Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoView;)V", "hidingMemo", "getHidingMemo", "setHidingMemo", "clearShowingReference", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class MemoReference {

        @Nullable
        private StickyMemoView hidingMemo;

        @Nullable
        private StickyMemoView showingMemo;

        @Nullable
        private SpenStickyNote showingObject;

        public final void clearShowingReference() {
            setShowingMemo(null);
            setShowingObject(null);
        }

        @Nullable
        public final StickyMemoView getHidingMemo() {
            return this.hidingMemo;
        }

        @Nullable
        public final StickyMemoView getShowingMemo() {
            return this.showingMemo;
        }

        @Nullable
        public final SpenStickyNote getShowingObject() {
            return this.showingObject;
        }

        public final void setHidingMemo(@Nullable StickyMemoView stickyMemoView) {
            Logger.m10999d(StickyMemoManager.TAG, "setHidingMemo# " + stickyMemoView);
            this.hidingMemo = stickyMemoView;
        }

        public final void setShowingMemo(@Nullable StickyMemoView stickyMemoView) {
            Logger.m10999d(StickyMemoManager.TAG, "setShowingMemo# " + stickyMemoView);
            this.showingMemo = stickyMemoView;
        }

        public final void setShowingObject(@Nullable SpenStickyNote spenStickyNote) {
            Logger.m10999d(StickyMemoManager.TAG, "setShowingMemo# " + spenStickyNote);
            this.showingObject = spenStickyNote;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$OnFocusChangeListener;", "Landroid/view/View$OnFocusChangeListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;)V", "onFocusChange", "", VPathDataCmd.RCurveTo, "Landroid/view/View;", "hasFocus", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class OnFocusChangeListener implements View.OnFocusChangeListener {
        public OnFocusChangeListener() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(@Nullable View v, boolean hasFocus) {
            if (hasFocus) {
                StickyMemoManager.this.focusManager.updateFocusTarget(StickyMemoManager.this.focusManager.getMainTarget());
            } else if (Intrinsics.areEqual(StickyMemoManager.this.focusManager.getCurFocusTarget(), StickyMemoManager.this.focusManager.getMainTarget())) {
                StickyMemoManager.this.focusManager.updateFocusTarget(null);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0002¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$OnPageUpdateListenerImpl;", "Lcom/samsung/android/support/senl/nt/composer/main/base/page/PageManager$OnPageUpdateListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;)V", "onUpdatePage", "", "type", "", Constants.MessagePayloadKeys.FROM, "to", "state", "Lcom/samsung/android/support/senl/nt/composer/main/base/page/PageManager$PageUpdateState;", "getCurMemoObjectInfo", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/SmViewConfig$MemoObjectInfo;", "onInsertedPages", "onDeletedPages", "pageList", "", "runOnUiThread", "runnable", "Ljava/lang/Runnable;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class OnPageUpdateListenerImpl implements PageManager.OnPageUpdateListener {
        public OnPageUpdateListenerImpl() {
        }

        private final SmViewConfig.MemoObjectInfo getCurMemoObjectInfo() {
            StickyMemoView showingMemo = StickyMemoManager.this.memoRef.getShowingMemo();
            Intrinsics.checkNotNull(showingMemo);
            SmViewConfig.MemoObjectInfo memoObjectInfo = showingMemo.getViewConfig().getMemoObjectInfo();
            Intrinsics.checkNotNull(memoObjectInfo);
            return memoObjectInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onDeletedPages$lambda$2(OnPageUpdateListenerImpl onPageUpdateListenerImpl, StickyMemoManager stickyMemoManager, PageManager.PageUpdateState pageUpdateState) {
            onPageUpdateListenerImpl.getCurMemoObjectInfo().setPageIndexChanged(true);
            StickyMemoManager.hideMemo$default(stickyMemoManager, false, "9", false, 4, null);
            StickyMemoObjectManager stickyMemoObjectManager = stickyMemoManager.memoObjectManager;
            if (stickyMemoObjectManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager = null;
            }
            List<String> pageIdList = pageUpdateState.getPageIdList();
            Intrinsics.checkNotNullExpressionValue(pageIdList, "getPageIdList(...)");
            stickyMemoObjectManager.deleteEntity(pageIdList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onInsertedPages$lambda$1(OnPageUpdateListenerImpl onPageUpdateListenerImpl, StickyMemoManager stickyMemoManager) {
            onPageUpdateListenerImpl.getCurMemoObjectInfo().setPageIndexChanged(true);
            StickyMemoManager.hideMemo$default(stickyMemoManager, false, "9", false, 4, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onUpdatePage$lambda$0(OnPageUpdateListenerImpl onPageUpdateListenerImpl, int i, int i2, StickyMemoManager stickyMemoManager) {
            SmViewConfig.MemoObjectInfo curMemoObjectInfo = onPageUpdateListenerImpl.getCurMemoObjectInfo();
            int pageIndex = curMemoObjectInfo.getPageIndex();
            if (i <= pageIndex && pageIndex <= i2) {
                curMemoObjectInfo.setPageIndexChanged(true);
            }
            StickyMemoManager.hideMemo$default(stickyMemoManager, false, "9", false, 4, null);
        }

        private final void runOnUiThread(Runnable runnable) {
            StickyMemoManager.this.getComposerViewPresenter().getActivity().runOnUiThread(runnable);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
        public void onDeletedPages(@NotNull List<Integer> pageList, @NotNull PageManager.PageUpdateState state) {
            Intrinsics.checkNotNullParameter(pageList, "pageList");
            Intrinsics.checkNotNullParameter(state, "state");
            if (StickyMemoManager.this.isShowing()) {
                runOnUiThread(new RunnableC8928b(this, 9, StickyMemoManager.this, state));
                return;
            }
            StickyMemoObjectManager stickyMemoObjectManager = StickyMemoManager.this.memoObjectManager;
            if (stickyMemoObjectManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager = null;
            }
            List<String> pageIdList = state.getPageIdList();
            Intrinsics.checkNotNullExpressionValue(pageIdList, "getPageIdList(...)");
            stickyMemoObjectManager.deleteEntity(pageIdList);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
        public void onInsertedPages(@NotNull PageManager.PageUpdateState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (StickyMemoManager.this.isShowing()) {
                runOnUiThread(new RunnableC9844c(this, StickyMemoManager.this, 2));
            }
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
        public void onUpdatePage(int type, int from, int to, @NotNull PageManager.PageUpdateState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (type == 2 && StickyMemoManager.this.isShowing()) {
                runOnUiThread(new RunnableC8212b(this, from, to, StickyMemoManager.this, 3));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$PreTouchListenerImpl;", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/listener/SpenPreTouchListenerImpl$PreTouchListener;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;)V", "isTouching", "", "()Z", "setTouching", "(Z)V", "isPreBackPressSwipe", "setPreBackPressSwipe", "downX", "", "getDownX", "()F", "setDownX", "(F)V", "gestureDetector", "Landroid/view/GestureDetector;", "getGestureDetector", "()Landroid/view/GestureDetector;", "isTextMode", "setTextMode", "initialize", "", "onTouch", "view", "Landroid/view/View;", "motionEvent", "Landroid/view/MotionEvent;", "intersects", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public final class PreTouchListenerImpl implements SpenPreTouchListenerImpl.PreTouchListener {
        private float downX;

        @NotNull
        private final GestureDetector gestureDetector;
        private boolean isPreBackPressSwipe;
        private boolean isTextMode;
        private boolean isTouching;

        public PreTouchListenerImpl() {
            this.gestureDetector = new GestureDetector((Context) null, new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager$PreTouchListenerImpl$gestureDetector$1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent e) {
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (!stickyMemoManager.getComposerViewPresenter().getComposerModel().getModeManager().isMode(Mode.Text)) {
                        return true;
                    }
                    Logger.m10999d(StickyMemoManager.TAG, "onSingleTapUp# hide memo");
                    StickyMemoManager.hideMemo$default(stickyMemoManager, true, "7", false, 4, null);
                    return true;
                }
            });
        }

        private final boolean intersects(View view, MotionEvent motionEvent) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
            rect.offset(iArr[0], iArr[1]);
            return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
        }

        public final float getDownX() {
            return this.downX;
        }

        @NotNull
        public final GestureDetector getGestureDetector() {
            return this.gestureDetector;
        }

        public final void initialize() {
            this.isTouching = false;
            this.isTextMode = false;
            this.isPreBackPressSwipe = false;
            this.downX = 0.0f;
        }

        /* JADX INFO: renamed from: isPreBackPressSwipe, reason: from getter */
        public final boolean getIsPreBackPressSwipe() {
            return this.isPreBackPressSwipe;
        }

        /* JADX INFO: renamed from: isTextMode, reason: from getter */
        public final boolean getIsTextMode() {
            return this.isTextMode;
        }

        /* JADX INFO: renamed from: isTouching, reason: from getter */
        public final boolean getIsTouching() {
            return this.isTouching;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0026  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0075  */
        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPreTouchListenerImpl.PreTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
            StickyMemoView showingMemo;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
            int actionMasked = motionEvent.getActionMasked();
            boolean zOnTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
            if (actionMasked == 0) {
                this.isTouching = true;
                this.isTextMode = StickyMemoManager.this.getComposerViewPresenter().getComposerModel().getModeManager().isMode(Mode.Text);
                this.downX = motionEvent.getX();
                Context context = StickyMemoManager.this.getComposerViewPresenter().getView().getContext();
                int i = context.getResources().getDisplayMetrics().widthPixels;
                int i2 = context.getResources().getDisplayMetrics().heightPixels;
                boolean zIsHideNavigationMode = SettingsCompat.INSTANCE.getInstance().isHideNavigationMode(context);
                Insets insets = StickyMemoManager.this.mGestureInsets;
                int i4 = insets != null ? insets.left : 100;
                Insets insets2 = StickyMemoManager.this.mGestureInsets;
                int i5 = insets2 != null ? insets2.right : 100;
                if (zIsHideNavigationMode) {
                    float f = this.downX;
                    if (f < i4 || f > i - i5) {
                        String str = StickyMemoManager.TAG;
                        Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                        SmLogger.m8661d(str, "#onTouch backPress area");
                        this.isPreBackPressSwipe = true;
                    }
                }
                String str2 = StickyMemoManager.TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                StringBuilder sbM1176v = AbstractC0622a.m1176v("#onTouch down: [", motionEvent.getX(), ",", motionEvent.getY(), "], nav_gesture[");
                sbM1176v.append(zIsHideNavigationMode);
                sbM1176v.append(SQLKeyword.COMMA);
                sbM1176v.append(i4);
                sbM1176v.append(SQLKeyword.COMMA);
                AbstractC2821a.m2235z(sbM1176v, i5, i, "], screen[", SQLKeyword.COMMA);
                sbM1176v.append(i2);
                sbM1176v.append("]");
                SmLogger.m8661d(str2, sbM1176v.toString());
            } else if (actionMasked == 1) {
                if (!zOnTouchEvent && this.isTextMode && actionMasked != 3 && actionMasked != 214) {
                    Logger.m10999d(StickyMemoManager.TAG, "onTouch# fail to check SingleTapUp");
                    StickyMemoManager.hideMemo$default(StickyMemoManager.this, true, null, false, 6, null);
                }
                this.isTouching = false;
            } else if (actionMasked == 2) {
                if (!this.isPreBackPressSwipe && StickyMemoManager.this.isShowing() && (showingMemo = StickyMemoManager.this.memoRef.getShowingMemo()) != null) {
                    StickyMemoManager stickyMemoManager = StickyMemoManager.this;
                    if (intersects(showingMemo, motionEvent)) {
                        StickyMemoManager.hideMemo$default(stickyMemoManager, true, null, false, 6, null);
                    }
                }
            } else if (actionMasked != 3) {
                switch (actionMasked) {
                }
            }
            return false;
        }

        public final void setDownX(float f) {
            this.downX = f;
        }

        public final void setPreBackPressSwipe(boolean z) {
            this.isPreBackPressSwipe = z;
        }

        public final void setTextMode(boolean z) {
            this.isTextMode = z;
        }

        public final void setTouching(boolean z) {
            this.isTouching = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$StickyMemoSaveControl;", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/data/ComposerSaveModel$SubData;", "<init>", "(Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager;)V", "isEmpty", "", "isDataChanged", "saveCache", "", "release", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nStickyMemoManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StickyMemoManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$StickyMemoSaveControl\n+ 2 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,967:1\n48#2:968\n*S KotlinDebug\n*F\n+ 1 StickyMemoManager.kt\ncom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$StickyMemoSaveControl\n*L\n885#1:968\n*E\n"})
    public final class StickyMemoSaveControl implements ComposerSaveModel.SubData {
        public StickyMemoSaveControl() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.ComposerSaveModel.SubData
        public boolean isDataChanged() {
            StickyMemoView showingMemo = StickyMemoManager.this.memoRef.getShowingMemo();
            if (showingMemo != null) {
                return showingMemo.getDocManager().isDataChanged();
            }
            return false;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.ComposerSaveModel.SubData
        public boolean isEmpty() {
            StickyMemoView showingMemo = StickyMemoManager.this.memoRef.getShowingMemo();
            return showingMemo == null || showingMemo.getChildCount() == 0;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.ComposerSaveModel.SubData
        public void release() {
            StickyMemoManager.hideMemo$default(StickyMemoManager.this, false, "5", false, 4, null);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.data.ComposerSaveModel.SubData
        public void saveCache() {
            StickyMemoView showingMemo = StickyMemoManager.this.memoRef.getShowingMemo();
            if (showingMemo != null) {
                StickyMemoManager stickyMemoManager = StickyMemoManager.this;
                if (showingMemo.getDocManager().isDataChanged()) {
                    Logger.m10999d(StickyMemoManager.TAG, "saveCache#");
                    StickyMemoObjectManager stickyMemoObjectManager = stickyMemoManager.memoObjectManager;
                    StickyMemoObjectManager stickyMemoObjectManager2 = null;
                    if (stickyMemoObjectManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                        stickyMemoObjectManager = null;
                    }
                    SpenStickyNote showingObject = stickyMemoManager.memoRef.getShowingObject();
                    Intrinsics.checkNotNull(showingObject);
                    stickyMemoObjectManager.updateFile(showingMemo, showingObject);
                    StickyMemoObjectManager stickyMemoObjectManager3 = stickyMemoManager.memoObjectManager;
                    if (stickyMemoObjectManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                    } else {
                        stickyMemoObjectManager2 = stickyMemoObjectManager3;
                    }
                    SpenStickyNote showingObject2 = stickyMemoManager.memoRef.getShowingObject();
                    Intrinsics.checkNotNull(showingObject2);
                    stickyMemoObjectManager2.setDirty(showingObject2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager$initStickMemo$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, m13886d2 = {"com/samsung/android/support/senl/nt/composer/main/base/presenter/menu/stickymemo/StickyMemoManager$initStickMemo$1", "Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/toolbar/SmToolbar$ActionListener;", "onCloseClicked", "", "withAnimation", "", "onDeleteClicked", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class C98691 implements SmToolbar.ActionListener {
        final /* synthetic */ StickyMemoView $view;

        public C98691(StickyMemoView stickyMemoView) {
            this.$view = stickyMemoView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onDeleteClicked$lambda$1$lambda$0(StickyMemoManager stickyMemoManager, StickyMemoView stickyMemoView) {
            stickyMemoManager.releaseMemoView(stickyMemoView);
            return Unit.INSTANCE;
        }

        @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar.ActionListener
        public void onCloseClicked(boolean withAnimation) {
            StickyMemoManager.hideMemo$default(StickyMemoManager.this, withAnimation, null, false, 6, null);
        }

        @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.SmToolbar.ActionListener
        public void onDeleteClicked() {
            StickyMemoView showingMemo = StickyMemoManager.this.memoRef.getShowingMemo();
            if (showingMemo != null) {
                StickyMemoManager stickyMemoManager = StickyMemoManager.this;
                StickyMemoView stickyMemoView = this.$view;
                stickyMemoManager.memoRef.clearShowingReference();
                stickyMemoManager.removeData(stickyMemoView.getViewConfig().getMemoObjectInfo());
                stickyMemoManager.releaseMemoDependency(showingMemo);
                stickyMemoManager.animationControl.hidAnimation(stickyMemoView, new C0344a(stickyMemoManager, stickyMemoView, 2));
            }
        }
    }

    public StickyMemoManager(boolean z) {
        this.isEnabled = z;
    }

    public static /* synthetic */ void addStickyMemo$default(StickyMemoManager stickyMemoManager, PointF pointF, int i, Object obj) {
        if ((i & 1) != 0) {
            pointF = null;
        }
        stickyMemoManager.addStickyMemo(pointF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addStickyMemo$lambda$7(StickyMemoManager stickyMemoManager) {
        StickyMemoSipControl stickyMemoSipControl = stickyMemoManager.sipControl;
        if (stickyMemoSipControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sipControl");
            stickyMemoSipControl = null;
        }
        stickyMemoSipControl.show((View) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addStickyMemo$lambda$8(Runnable runnable, StickyMemoView stickyMemoView) {
        if (runnable != null) {
            runnable.run();
        }
        stickyMemoView.requestFocusWritingView();
    }

    private final void detachMemoView(StickyMemoView view) {
        Handler handler;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ViewGroup container = getContainer();
            if (container != null) {
                container.removeView(view);
            }
        } else if (CommonUtil.isAvailableActivity(getComposerViewPresenter().getActivity()) && (handler = getHandler()) != null) {
            handler.post(new RunnableC9870a(this, view));
        }
        this.memoRef.setHidingMemo(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void detachMemoView$lambda$23(StickyMemoManager stickyMemoManager, StickyMemoView stickyMemoView) {
        ViewGroup container = stickyMemoManager.getContainer();
        if (container != null) {
            container.removeView(stickyMemoView);
        }
    }

    private final ViewGroup getContainer() {
        return (ViewGroup) getComposerViewPresenter().getActivity().findViewById(C9086R.id.sticky_memo_view_container);
    }

    private final ExecutorService getExecutorService() {
        if (this.executorService == null) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            this.executorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG2));
        }
        return this.executorService;
    }

    private final Handler getHandler() {
        if (this.handler == null) {
            this.handler = new Handler(Looper.getMainLooper());
        }
        return this.handler;
    }

    private final int getOpenPos(int iconP, int size, int startP, int endP) {
        int iMax = Math.max(startP, iconP);
        return iMax + size > endP ? Math.max(startP, endP - size) : iMax;
    }

    private final Rect getOpenRect(ViewGroup container, Point pageOffset, RectF objRect, int height) {
        if (pageOffset == null) {
            return new Rect();
        }
        RectF rectF = new RectF(objRect);
        rectF.offset(pageOffset.x, pageOffset.y);
        RectF rectFConvertContentRectIntoViewRect = getComposerViewPresenter().getObjectManager().getNoteZoomScroller().convertContentRectIntoViewRect(rectF);
        return rectFConvertContentRectIntoViewRect != null ? getOpenRect(container, (int) (rectFConvertContentRectIntoViewRect.centerX() - (this.defWidth / 2)), ((int) rectFConvertContentRectIntoViewRect.top) - container.getContext().getResources().getDimensionPixelSize(C9086R.dimen.top_menu_top_margin), height) : new Rect();
    }

    private final int getStartHeight(String memoId) {
        StickyMemoObjectManager stickyMemoObjectManager = this.memoObjectManager;
        if (stickyMemoObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
            stickyMemoObjectManager = null;
        }
        StickyNoteEntity stickyNoteEntity = stickyMemoObjectManager.getRepository().get(memoId);
        SmDocumentManager.Companion companion = SmDocumentManager.INSTANCE;
        Activity activity = getComposerViewPresenter().getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "getActivity(...)");
        return (stickyNoteEntity == null || stickyNoteEntity.getHeight() <= 0) ? this.defHeight : Math.max(stickyNoteEntity.getHeight(), companion.getMinHeight(activity));
    }

    public static /* synthetic */ void hideMemo$default(StickyMemoManager stickyMemoManager, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        stickyMemoManager.hideMemo(z, str, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit hideMemo$lambda$20(boolean z, boolean z2, StickyMemoManager stickyMemoManager, SpenStickyNote spenStickyNote, StickyMemoView stickyMemoView, boolean z3, boolean z4) {
        if (z) {
            stickyMemoManager.releaseMemoView(stickyMemoView);
        } else {
            if (!z2) {
                StickyMemoObjectManager stickyMemoObjectManager = stickyMemoManager.memoObjectManager;
                if (stickyMemoObjectManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                    stickyMemoObjectManager = null;
                }
                if (stickyMemoObjectManager.hasDirty(spenStickyNote)) {
                }
            }
            ExecutorService executorService = stickyMemoManager.getExecutorService();
            if (executorService != null) {
                executorService.execute(new RunnableC7967b(z4, stickyMemoManager, stickyMemoView, spenStickyNote));
            }
        }
        if (z3) {
            stickyMemoManager.getControllerManager().getSoftInputManager().hide((View) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hideMemo$lambda$20$lambda$19(boolean z, StickyMemoManager stickyMemoManager, StickyMemoView stickyMemoView, SpenStickyNote spenStickyNote) {
        String str = TAG;
        Logger.m10999d(str, "run thread");
        if (!z) {
            StickyMemoObjectManager stickyMemoObjectManager = stickyMemoManager.memoObjectManager;
            if (stickyMemoObjectManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager = null;
            }
            stickyMemoObjectManager.updateFile(stickyMemoView, spenStickyNote);
        }
        stickyMemoManager.releaseMemoView(stickyMemoView);
        Logger.m10999d(str, "run thread end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(StickyMemoManager stickyMemoManager, ComposerViewPresenter composerViewPresenter, int i, boolean z, boolean z2) {
        StickyMemoView showingMemo = stickyMemoManager.memoRef.getShowingMemo();
        if (showingMemo != null) {
            showingMemo.updateDarkTheme(composerViewPresenter.isComposerViewDarkTheme());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3(StickyMemoManager stickyMemoManager, ComposerViewPresenter composerViewPresenter, boolean z) {
        if (stickyMemoManager.isShowing()) {
            stickyMemoManager.invertBackgroundColor(composerViewPresenter.getDoc().isBackgroundColorInverted());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$4(StickyMemoManager stickyMemoManager) {
        if (stickyMemoManager.isShowing()) {
            hideMemo$default(stickyMemoManager, true, "7", false, 4, null);
        }
    }

    private final void initComposerConnection() {
        this.preTouchListenerImpl.initialize();
        getComposerViewPresenter().getListenerManager().addPreTouchListener(this.preTouchListenerImpl);
        getComposerViewPresenter().getListenerManager().getOnDragListener().setDragEventDispatcher(this.dragEventDispatcher);
        getComposerViewPresenter().getListenerManager().getOnDragListener().setFocusManager(this.focusManager);
        getComposerViewPresenter().getListenerManager().addFocusChangeListener(this.onFocusChangeListener);
        getComposerViewPresenter().getComposerControllerManager().getScrollController().setOnScrollListener(new C9872c(this));
        getComposerViewPresenter().getComposerControllerManager().getCompSipController().setFocusManager(this.focusManager);
        getComposerViewPresenter().getComposerModel().getComposerSaveModel().setSubData(this.saveControl);
        getComposerViewPresenter().getListenerManager().setOnCommitListener(this.onCommitListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initComposerConnection$lambda$16(StickyMemoManager stickyMemoManager) {
        if (!stickyMemoManager.preTouchListenerImpl.getIsTouching() || stickyMemoManager.preTouchListenerImpl.getIsPreBackPressSwipe()) {
            return;
        }
        hideMemo$default(stickyMemoManager, true, "2", false, 4, null);
    }

    private final void initStickMemo(StickyMemoView view) {
        ControlFactory controlFactory = new ControlFactory();
        StickyMemoSipControl stickyMemoSipControl = this.sipControl;
        StickyMemoQuickSaveControl stickyMemoQuickSaveControl = null;
        if (stickyMemoSipControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sipControl");
            stickyMemoSipControl = null;
        }
        controlFactory.setSipController(stickyMemoSipControl);
        ToolShareControl toolShareControl = this.toolShareControl;
        if (toolShareControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl = null;
        }
        controlFactory.setToolShareControl(toolShareControl);
        ToolShareControl toolShareControl2 = controlFactory.getToolShareControl();
        if (toolShareControl2 != null) {
            StickyMemoToolbarControl stickyMemoToolbarControl = this.toolbarControl;
            if (stickyMemoToolbarControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolbarControl");
                stickyMemoToolbarControl = null;
            }
            toolShareControl2.setToolbarControl(stickyMemoToolbarControl);
        }
        controlFactory.setDragEventDispatcher(this.dragEventDispatcher);
        controlFactory.setFocusManager(this.focusManager);
        StickyMemoProgressControl stickyMemoProgressControl = this.progressControl;
        if (stickyMemoProgressControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressControl");
            stickyMemoProgressControl = null;
        }
        controlFactory.setProgressControl(stickyMemoProgressControl);
        StickyMemoQuickSaveControl stickyMemoQuickSaveControl2 = this.quickSaveControl;
        if (stickyMemoQuickSaveControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quickSaveControl");
        } else {
            stickyMemoQuickSaveControl = stickyMemoQuickSaveControl2;
        }
        controlFactory.setQuickSaveControl(stickyMemoQuickSaveControl);
        view.setControlFactory(controlFactory);
        view.setToolbarActionListener(new C98691(view));
        WindowInsetsManager.INSTANCE.getInstance().requestAndGetInsets(view, new C4202b(this, 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initStickMemo$lambda$15(StickyMemoManager stickyMemoManager, WindowInsetsCompat it) {
        Intrinsics.checkNotNullParameter(it, "it");
        stickyMemoManager.mGestureInsets = it.getInsets(WindowInsetsCompat.Type.systemGestures());
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        Insets insets = stickyMemoManager.mGestureInsets;
        Integer numValueOf = insets != null ? Integer.valueOf(insets.left) : null;
        Insets insets2 = stickyMemoManager.mGestureInsets;
        SmLogger.m8661d(TAG2, "requestAndGetInsets# ready " + numValueOf + " " + (insets2 != null ? Integer.valueOf(insets2.right) : null));
        return Unit.INSTANCE;
    }

    private final void invertBackgroundColor(boolean invert) {
        SmDocumentManager docManager;
        SpenWNote doc;
        AbstractC8014b.m7220v("invertBackgroundColor# ", TAG, invert);
        StickyMemoView showingMemo = this.memoRef.getShowingMemo();
        if (showingMemo == null || (docManager = showingMemo.getDocManager()) == null || (doc = docManager.getDoc()) == null) {
            return;
        }
        doc.invertBackgroundColor(invert);
    }

    private final boolean isNeedHideSip(SmViewConfig.MemoObjectInfo memoObjectInfo) {
        return getComposerViewPresenter().getComposerModel().getModeManager().isMode(Mode.Text) && !getComposerViewPresenter().getObjectManager().getSelectedObjectManager().isSelectedBodyText() && getControllerManager().getSoftInputManager().isInputMethodShown();
    }

    private final void logMinimize(String detail) {
        if (detail == null) {
            return;
        }
        ComposerSA.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE_MINIMIZED, "412", detail);
    }

    @SuppressLint({"RtlHardcoded"})
    private final StickyMemoView makeStickMemoView(ViewGroup container) {
        View viewInflate = LayoutInflater.from(getComposerViewPresenter().getActivity()).inflate(C9086R.layout.sticky_memo_view, container, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoView");
        StickyMemoView stickyMemoView = (StickyMemoView) viewInflate;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 3;
        container.addView(stickyMemoView, layoutParams);
        initStickMemo(stickyMemoView);
        initComposerConnection();
        return stickyMemoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachView$lambda$5(StickyMemoManager stickyMemoManager, SpenStickyNote spenStickyNote) {
        Intrinsics.checkNotNull(spenStickyNote);
        stickyMemoManager.openStickyMemo(spenStickyNote);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCommitListener$lambda$0(StickyMemoManager stickyMemoManager) {
        if (!stickyMemoManager.isBlockingOnCommitListener && stickyMemoManager.getComposerViewPresenter().getComposerModel().getModeManager().isMode(Mode.Writing)) {
            hideMemo$default(stickyMemoManager, true, null, false, 6, null);
        }
    }

    private final void onHideCalled() {
        getHwToolbarPresenter().setEyedropperEnabled(true);
    }

    private final void onShowCalled() {
        getHwToolbarPresenter().setEyedropperEnabled(false);
    }

    private final void openStickyMemo(SpenStickyNote memoObject) {
        SpenStickyNote obj;
        if (!isShowing()) {
            StickyMemoView hidingMemo = this.memoRef.getHidingMemo();
            if (hidingMemo != null) {
                String id = memoObject.getId();
                SmViewConfig.MemoObjectInfo memoObjectInfo = hidingMemo.getViewConfig().getMemoObjectInfo();
                if (Intrinsics.areEqual(id, (memoObjectInfo == null || (obj = memoObjectInfo.getObj()) == null) ? null : obj.getId())) {
                    Logger.m10999d(TAG, "openStickyMemo# failed because memo is hiding");
                    return;
                }
            }
        } else {
            if (Intrinsics.areEqual(this.memoRef.getShowingObject(), memoObject)) {
                Logger.m10999d(TAG, "openStickyMemo# try to open same memo");
                return;
            }
            hideMemo$default(this, true, "1", false, 4, null);
        }
        ViewGroup container = getContainer();
        if (container != null) {
            openStickyMemo(container, memoObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openStickyMemo$lambda$11(StickyMemoView stickyMemoView, boolean z, StickyMemoManager stickyMemoManager) {
        stickyMemoView.requestFocusWritingView();
        if (z) {
            stickyMemoManager.getControllerManager().getSoftInputManager().blockToHide(false);
            StickyMemoSipControl stickyMemoSipControl = stickyMemoManager.sipControl;
            if (stickyMemoSipControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sipControl");
                stickyMemoSipControl = null;
            }
            stickyMemoSipControl.show((View) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openStickyMemo$lambda$12(boolean z, StickyMemoManager stickyMemoManager) {
        if (z) {
            stickyMemoManager.getControllerManager().getSoftInputManager().blockToHide(false);
        }
        return Unit.INSTANCE;
    }

    private final void releaseComposerConnection() {
        getComposerViewPresenter().getListenerManager().removePreTouchListener(this.preTouchListenerImpl);
        getComposerViewPresenter().getListenerManager().getOnDragListener().setDragEventDispatcher(null);
        getComposerViewPresenter().getListenerManager().getOnDragListener().setFocusManager(null);
        getComposerViewPresenter().getListenerManager().removeFocusChangeListener(this.onFocusChangeListener);
        getComposerViewPresenter().getComposerControllerManager().getScrollController().setOnScrollListener(null);
        getComposerViewPresenter().getComposerControllerManager().getCompSipController().setFocusManager(null);
        getComposerViewPresenter().getComposerModel().getComposerSaveModel().setSubData(null);
        getComposerViewPresenter().getListenerManager().setOnCommitListener(null);
    }

    private final boolean releaseHidingWork(boolean withAnimation) {
        SmControlManager smViewControlManager;
        SmTaskController taskController;
        if (withAnimation || this.memoRef.getShowingMemo() != null || this.memoRef.getHidingMemo() == null) {
            return false;
        }
        if (this.animationControl.isHiding()) {
            Logger.m10999d(TAG, "hideMemo# isHiding");
        }
        SmTask.Callback<SmWaitForSaveTask.Results> callback = new SmTask.Callback<SmWaitForSaveTask.Results>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.StickyMemoManager$releaseHidingWork$callback$1
            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
            public void onFail(SmWaitForSaveTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = StickyMemoManager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                Exception exception = result.getException();
                SmLogger.m8661d(str, exception != null ? exception.toString() : null);
            }

            @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.composer.control.action.SmTask.Callback
            public void onSuccess(SmWaitForSaveTask.Results result) {
                Intrinsics.checkNotNullParameter(result, "result");
                String str = StickyMemoManager.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                SmLogger.m8661d(str, "Finished awaitTermination");
            }
        };
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        SmLogger.m8661d(TAG2, "Start awaitTermination");
        StickyMemoView hidingMemo = this.memoRef.getHidingMemo();
        if (hidingMemo == null || (smViewControlManager = hidingMemo.getSmViewControlManager()) == null || (taskController = smViewControlManager.getTaskController()) == null) {
            return true;
        }
        taskController.execute(new SmWaitForSaveTask(new RunnableC9874e(this, 1)), new SmWaitForSaveTask.Inputs(), callback);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseHidingWork$lambda$18(StickyMemoManager stickyMemoManager) throws InterruptedException {
        ExecutorService executorService = stickyMemoManager.getExecutorService();
        if (executorService != null) {
            executorService.awaitTermination(1L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseMemoDependency(StickyMemoView memoView) {
        memoView.releaseControl();
        releaseComposerConnection();
        this.dragEventDispatcher.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseMemoView(StickyMemoView memoView) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Logger.m10999d(TAG, "releaseMemoView#");
            memoView.release();
            detachMemoView(memoView);
        } else if (CommonUtil.isAvailableActivity(getComposerViewPresenter().getActivity())) {
            Logger.m10999d(TAG, "releaseMemoView#");
            Handler handler = getHandler();
            if (handler != null) {
                handler.post(new RunnableC9870a(memoView, this));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseMemoView$lambda$21(StickyMemoView stickyMemoView, StickyMemoManager stickyMemoManager) {
        stickyMemoView.release();
        stickyMemoManager.detachMemoView(stickyMemoView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeData(SmViewConfig.MemoObjectInfo objInfo) {
        if (objInfo == null) {
            return;
        }
        if (getComposerViewPresenter().getDoc() == null) {
            Logger.m11000e(TAG, "removeData# composer is already released ");
            return;
        }
        StickyMemoObjectManager stickyMemoObjectManager = null;
        if (objInfo.getIsPageIndexChanged()) {
            Logger.m10999d(TAG, "removeData# page index was changed");
            StickyMemoObjectManager stickyMemoObjectManager2 = this.memoObjectManager;
            if (stickyMemoObjectManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager2 = null;
            }
            SpenWNote doc = getComposerViewPresenter().getDoc();
            Intrinsics.checkNotNullExpressionValue(doc, "getDoc(...)");
            stickyMemoObjectManager2.removeMemoObject(doc, objInfo.getObj());
        } else {
            StickyMemoObjectManager stickyMemoObjectManager3 = this.memoObjectManager;
            if (stickyMemoObjectManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager3 = null;
            }
            SpenWNote doc2 = getComposerViewPresenter().getDoc();
            Intrinsics.checkNotNullExpressionValue(doc2, "getDoc(...)");
            stickyMemoObjectManager3.removeMemoObject(doc2, objInfo.getPageIndex(), objInfo.getObj());
        }
        StickyMemoObjectManager stickyMemoObjectManager4 = this.memoObjectManager;
        if (stickyMemoObjectManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
        } else {
            stickyMemoObjectManager = stickyMemoObjectManager4;
        }
        stickyMemoObjectManager.getRepository().delete(objInfo.getObj().getId());
    }

    private final void updateBackground() {
        StickyMemoView showingMemo = this.memoRef.getShowingMemo();
        if (showingMemo != null) {
            showingMemo.updateDarkTheme(getComposerViewPresenter().isComposerViewDarkTheme());
        }
        invertBackgroundColor(getComposerViewPresenter().getDoc().isBackgroundColorInverted());
    }

    private final void updateMemoObjectPosition() {
    }

    private final void updateNewMemoObject(StickyMemoView memoView, SpenStickyNote obj) {
        int pageIndex;
        SmViewConfig.MemoObjectInfo memoObjectInfo = memoView.getViewConfig().getMemoObjectInfo();
        if (memoObjectInfo == null || !memoObjectInfo.getIsNew()) {
            return;
        }
        SmViewConfig.MemoObjectInfo memoObjectInfo2 = memoView.getViewConfig().getMemoObjectInfo();
        StickyMemoObjectManager stickyMemoObjectManager = null;
        if (memoObjectInfo2 == null || !memoObjectInfo2.getUpdatePos()) {
            SmViewConfig.MemoObjectInfo memoObjectInfo3 = memoView.getViewConfig().getMemoObjectInfo();
            Intrinsics.checkNotNull(memoObjectInfo3);
            pageIndex = memoObjectInfo3.getPageIndex();
        } else {
            ObjectManager objectManager = getComposerViewPresenter().getObjectManager();
            PointF leftTop = memoView.getLeftTop();
            leftTop.offset((memoView.getWidth() - memoView.getResources().getDimensionPixelSize(C9086R.dimen.stick_memo_icon_size)) / 2, memoView.getResources().getDimensionPixelSize(C9086R.dimen.stick_memo_new_icon_top_margin));
            PointF pointFConvertViewPointIntoContentPoint = objectManager.getNoteZoomScroller().convertViewPointIntoContentPoint(leftTop);
            Intrinsics.checkNotNull(pointFConvertViewPointIntoContentPoint);
            pointFConvertViewPointIntoContentPoint.x = Math.max(0.0f, pointFConvertViewPointIntoContentPoint.x);
            float fMax = Math.max(0.0f, pointFConvertViewPointIntoContentPoint.y);
            pointFConvertViewPointIntoContentPoint.y = fMax;
            pageIndex = objectManager.findClosestPageIndexByXY(pointFConvertViewPointIntoContentPoint.x, fMax);
            StickyMemoObjectManager stickyMemoObjectManager2 = this.memoObjectManager;
            if (stickyMemoObjectManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager2 = null;
            }
            SmViewConfig.MemoObjectInfo memoObjectInfo4 = memoView.getViewConfig().getMemoObjectInfo();
            Intrinsics.checkNotNull(memoObjectInfo4);
            stickyMemoObjectManager2.updateNewMemoObject(obj, memoObjectInfo4.getPageIndex(), pageIndex, pointFConvertViewPointIntoContentPoint);
        }
        StickyMemoObjectManager stickyMemoObjectManager3 = this.memoObjectManager;
        if (stickyMemoObjectManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
        } else {
            stickyMemoObjectManager = stickyMemoObjectManager3;
        }
        stickyMemoObjectManager.insertEntity(obj, pageIndex);
    }

    @JvmOverloads
    public final void addStickyMemo() {
        addStickyMemo$default(this, null, 1, null);
    }

    @NotNull
    public final ComposerViewPresenter getComposerViewPresenter() {
        ComposerViewPresenter composerViewPresenter = this.composerViewPresenter;
        if (composerViewPresenter != null) {
            return composerViewPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("composerViewPresenter");
        return null;
    }

    @NotNull
    public final ControllerManager getControllerManager() {
        ControllerManager controllerManager = this.controllerManager;
        if (controllerManager != null) {
            return controllerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("controllerManager");
        return null;
    }

    @NotNull
    public final HwToolbarPresenter getHwToolbarPresenter() {
        HwToolbarPresenter hwToolbarPresenter = this.hwToolbarPresenter;
        if (hwToolbarPresenter != null) {
            return hwToolbarPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("hwToolbarPresenter");
        return null;
    }

    public final void hideMemo(boolean withAnimation, @Nullable String detail, boolean blockSave) {
        if (releaseHidingWork(withAnimation)) {
            return;
        }
        this.animationControl.cancelShowAnimation();
        StickyMemoView showingMemo = this.memoRef.getShowingMemo();
        if (showingMemo != null) {
            logMinimize(detail);
            hideMemo(showingMemo, withAnimation, blockSave);
        }
    }

    public final void init(@NotNull final ComposerViewPresenter composerViewPresenter, @NotNull ControllerManager controllerManager, @NotNull HwToolbarPresenter hwToolbarPresenter, @NotNull RtToolbarPresenter rtToolbarPresenter, @NotNull ToolbarPresenter toolbarPresenter, @NotNull ActionManager actionManager) {
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(hwToolbarPresenter, "hwToolbarPresenter");
        Intrinsics.checkNotNullParameter(rtToolbarPresenter, "rtToolbarPresenter");
        Intrinsics.checkNotNullParameter(toolbarPresenter, "toolbarPresenter");
        Intrinsics.checkNotNullParameter(actionManager, "actionManager");
        this.animationControl.setComposerViewPresenter(composerViewPresenter);
        setComposerViewPresenter(composerViewPresenter);
        this.memoObjectManager = new StickyMemoObjectManager(composerViewPresenter);
        setHwToolbarPresenter(hwToolbarPresenter);
        this.toolbarControl = new StickyMemoToolbarControl(toolbarPresenter, hwToolbarPresenter, rtToolbarPresenter, composerViewPresenter);
        ToolShareControl toolShareControl = new ToolShareControl();
        this.toolShareControl = toolShareControl;
        StickyMemoToolbarControl stickyMemoToolbarControl = this.toolbarControl;
        StickyMemoObjectManager stickyMemoObjectManager = null;
        if (stickyMemoToolbarControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarControl");
            stickyMemoToolbarControl = null;
        }
        toolShareControl.setToolbarControl(stickyMemoToolbarControl);
        ToolShareControl toolShareControl2 = this.toolShareControl;
        if (toolShareControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl2 = null;
        }
        toolShareControl2.setFontDelta(composerViewPresenter.getTextManager().getFontSizeDelta());
        SoftInputManager softInputManager = controllerManager.getSoftInputManager();
        Intrinsics.checkNotNullExpressionValue(softInputManager, "getSoftInputManager(...)");
        this.sipControl = new StickyMemoSipControl(softInputManager);
        ProgressController progressController = controllerManager.getProgressController();
        Intrinsics.checkNotNullExpressionValue(progressController, "getProgressController(...)");
        this.progressControl = new StickyMemoProgressControl(progressController);
        QuickSaveTimerController quickSaveTimer = controllerManager.getQuickSaveTimer();
        Intrinsics.checkNotNullExpressionValue(quickSaveTimer, "getQuickSaveTimer(...)");
        this.quickSaveControl = new StickyMemoQuickSaveControl(quickSaveTimer);
        TextManager textManager = composerViewPresenter.getTextManager();
        ToolShareControl toolShareControl3 = this.toolShareControl;
        if (toolShareControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl3 = null;
        }
        textManager.setToolShareControl(toolShareControl3);
        WritingToolManager writingToolManager = composerViewPresenter.getWritingToolManager();
        ToolShareControl toolShareControl4 = this.toolShareControl;
        if (toolShareControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl4 = null;
        }
        writingToolManager.setToolShareControl(toolShareControl4);
        ToolShareControl toolShareControl5 = this.toolShareControl;
        if (toolShareControl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl5 = null;
        }
        toolbarPresenter.setToolShareControl(toolShareControl5);
        ToolShareControl toolShareControl6 = this.toolShareControl;
        if (toolShareControl6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl6 = null;
        }
        hwToolbarPresenter.setToolShareControl(toolShareControl6);
        hwToolbarPresenter.setStickyMemoManager(new C9872c(this));
        ToolShareControl toolShareControl7 = this.toolShareControl;
        if (toolShareControl7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl7 = null;
        }
        rtToolbarPresenter.setToolShareControl(toolShareControl7);
        UndoRedoPresenter undoRedoPresenter = composerViewPresenter.getUndoRedoPresenter();
        ToolShareControl toolShareControl8 = this.toolShareControl;
        if (toolShareControl8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
            toolShareControl8 = null;
        }
        undoRedoPresenter.setToolShareControl(toolShareControl8);
        setControllerManager(controllerManager);
        this.focusManager.setMainTarget(new MainFTarget());
        AbsAction action = actionManager.getAction(ActionManager.ActionType.ReadOnlyMode);
        if (action instanceof ActionReadonlyMode) {
            ActionReadonlyMode actionReadonlyMode = (ActionReadonlyMode) action;
            ToolShareControl toolShareControl9 = this.toolShareControl;
            if (toolShareControl9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("toolShareControl");
                toolShareControl9 = null;
            }
            actionReadonlyMode.setToolShareControl(toolShareControl9);
        }
        composerViewPresenter.getPageManager().addListener(new OnPageUpdateListenerImpl());
        composerViewPresenter.getNoteManager().addBackgroundColorObserver(new NoteManager.ObserverBackgroundColor() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.d
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
            public final void onChangedBackgroundColor(int i, boolean z, boolean z2) {
                StickyMemoManager.init$lambda$2(this.f7031a, composerViewPresenter, i, z, z2);
            }
        });
        composerViewPresenter.getNoteManager().setInvertBackgroundColorListener(new C0287e(this, composerViewPresenter, 15));
        composerViewPresenter.getListenerManager().setOnBeforeTextChangedByKeyboardListener(new C9872c(this));
        ListenerManager listenerManager = composerViewPresenter.getListenerManager();
        StickyMemoObjectManager stickyMemoObjectManager2 = this.memoObjectManager;
        if (stickyMemoObjectManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
        } else {
            stickyMemoObjectManager = stickyMemoObjectManager2;
        }
        listenerManager.addCustomObjectEventListener(stickyMemoObjectManager);
    }

    public final boolean isEnabled() {
        return this.isEnabled && !getComposerViewPresenter().getComposerModel().getMdeManager().getMdeInfo().isMde();
    }

    public final boolean isShowing() {
        return this.memoRef.getShowingMemo() != null;
    }

    public final void onAttachView() {
        Activity activity = getComposerViewPresenter().getActivity();
        SmDocumentManager.Companion companion = SmDocumentManager.INSTANCE;
        Intrinsics.checkNotNull(activity);
        this.defWidth = companion.getDefWidth(activity);
        this.defHeight = companion.getDefHeight(activity);
        getComposerViewPresenter().getListenerManager().getActionListener().setStickyMemoManager(new C9872c(this));
    }

    public final boolean onBackPressed() {
        if (!isShowing()) {
            return false;
        }
        StickyMemoView showingMemo = this.memoRef.getShowingMemo();
        if (showingMemo != null && showingMemo.onBackPressed()) {
            return true;
        }
        hideMemo$default(this, true, "6", false, 4, null);
        return true;
    }

    public final void onDestroyView() {
        hideMemo$default(this, false, null, false, 6, null);
    }

    public final void onDetachView() {
        getComposerViewPresenter().getListenerManager().getActionListener().setStickyMemoManager(null);
        hideMemo$default(this, false, null, false, 6, null);
    }

    public final void onLayoutChangeBefore() {
        hideMemo$default(this, false, null, false, 6, null);
    }

    public final void setComposerViewPresenter(@NotNull ComposerViewPresenter composerViewPresenter) {
        Intrinsics.checkNotNullParameter(composerViewPresenter, "<set-?>");
        this.composerViewPresenter = composerViewPresenter;
    }

    public final void setControllerManager(@NotNull ControllerManager controllerManager) {
        Intrinsics.checkNotNullParameter(controllerManager, "<set-?>");
        this.controllerManager = controllerManager;
    }

    public final void setHwToolbarPresenter(@NotNull HwToolbarPresenter hwToolbarPresenter) {
        Intrinsics.checkNotNullParameter(hwToolbarPresenter, "<set-?>");
        this.hwToolbarPresenter = hwToolbarPresenter;
    }

    public static /* synthetic */ void addStickyMemo$default(StickyMemoManager stickyMemoManager, ViewGroup viewGroup, PointF pointF, int i, Object obj) {
        if ((i & 2) != 0) {
            pointF = null;
        }
        stickyMemoManager.addStickyMemo(viewGroup, pointF);
    }

    @JvmOverloads
    public final void addStickyMemo(@Nullable PointF pos) {
        String str = TAG;
        Logger.m10999d(str, "addStickyMemo# ");
        ViewGroup container = getContainer();
        if (container != null) {
            if (isShowing()) {
                StickyMemoView showingMemo = this.memoRef.getShowingMemo();
                Intrinsics.checkNotNull(showingMemo);
                if (showingMemo.isEmptyNewMemo()) {
                    Logger.m10999d(str, "addStickyMemo# isEmptyNewMemoShowing");
                    return;
                }
                hideMemo$default(this, true, "1", false, 4, null);
            }
            addStickyMemo(container, pos);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void hideMemo(final StickyMemoView memoView, boolean withAnimation, final boolean blockSave) {
        final SpenStickyNote showingObject = this.memoRef.getShowingObject();
        Intrinsics.checkNotNull(showingObject);
        Logger.m10999d(TAG, "hideMemo# " + showingObject.getId() + " " + withAnimation);
        this.memoRef.clearShowingReference();
        releaseMemoDependency(memoView);
        final boolean zIsNeedHideSip = isNeedHideSip(memoView.getViewConfig().getMemoObjectInfo());
        final boolean zIsEmptyNewMemo = memoView.isEmptyNewMemo();
        final boolean z = !zIsEmptyNewMemo && memoView.getDocManager().isDataChanged();
        StickyMemoObjectManager stickyMemoObjectManager = null;
        if (zIsEmptyNewMemo) {
            removeData(memoView.getViewConfig().getMemoObjectInfo());
        } else {
            updateNewMemoObject(memoView, showingObject);
            StickyMemoObjectManager stickyMemoObjectManager2 = this.memoObjectManager;
            if (stickyMemoObjectManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                stickyMemoObjectManager2 = null;
            }
            stickyMemoObjectManager2.updateLastHeight(memoView, showingObject.getId());
        }
        if (withAnimation) {
            this.memoRef.setHidingMemo(memoView);
            Function0<Unit> function0 = new Function0() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StickyMemoManager.hideMemo$lambda$20(zIsEmptyNewMemo, z, this, showingObject, memoView, zIsNeedHideSip, blockSave);
                }
            };
            if (zIsEmptyNewMemo) {
                this.animationControl.hidAnimation(memoView, function0);
                memoView.showToastNothingToSave();
            } else {
                StickyMemoObjectManager stickyMemoObjectManager3 = this.memoObjectManager;
                if (stickyMemoObjectManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                    stickyMemoObjectManager3 = null;
                }
                stickyMemoObjectManager3.updateBackgroundColor(showingObject, memoView.getDocManager().getBackgroundColor());
                StickyMemoObjectManager stickyMemoObjectManager4 = this.memoObjectManager;
                if (stickyMemoObjectManager4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                } else {
                    stickyMemoObjectManager = stickyMemoObjectManager4;
                }
                stickyMemoObjectManager.logMinimizedColor(showingObject);
                this.animationControl.minimizeAnimation(memoView, showingObject, function0);
                memoView.getDocManager().loggingContentType();
            }
        } else {
            if (!blockSave) {
                if (!z) {
                    StickyMemoObjectManager stickyMemoObjectManager5 = this.memoObjectManager;
                    if (stickyMemoObjectManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                        stickyMemoObjectManager5 = null;
                    }
                    if (stickyMemoObjectManager5.hasDirty(showingObject)) {
                    }
                } else {
                    StickyMemoObjectManager stickyMemoObjectManager6 = this.memoObjectManager;
                    if (stickyMemoObjectManager6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                        stickyMemoObjectManager6 = null;
                    }
                    stickyMemoObjectManager6.updateFile(memoView, showingObject);
                    StickyMemoObjectManager stickyMemoObjectManager7 = this.memoObjectManager;
                    if (stickyMemoObjectManager7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                        stickyMemoObjectManager7 = null;
                    }
                    stickyMemoObjectManager7.updateBackgroundColor(showingObject, memoView.getDocManager().getBackgroundColor());
                }
            }
            if (!zIsEmptyNewMemo) {
                StickyMemoObjectManager stickyMemoObjectManager8 = this.memoObjectManager;
                if (stickyMemoObjectManager8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
                    stickyMemoObjectManager8 = null;
                }
                stickyMemoObjectManager8.logMinimizedColor(showingObject);
            }
            memoView.getDocManager().loggingContentType();
            showingObject.setVisible(true);
            releaseMemoView(memoView);
            if (zIsNeedHideSip) {
                getControllerManager().getSoftInputManager().hide((View) null);
            }
        }
        onHideCalled();
    }

    private final void addStickyMemo(ViewGroup container, PointF pos) {
        int width;
        int i;
        Rect openRect;
        StickyMemoObjectManager stickyMemoObjectManager = this.memoObjectManager;
        if (stickyMemoObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
            stickyMemoObjectManager = null;
        }
        Integer addTargetPageIndex = stickyMemoObjectManager.getAddTargetPageIndex(pos);
        if (addTargetPageIndex == null) {
            Logger.m11000e(TAG, "addStickyMemo# failed to found page by position");
            return;
        }
        StickyMemoView stickyMemoViewMakeStickMemoView = makeStickMemoView(container);
        this.animationControl.setShowAnimation(stickyMemoViewMakeStickMemoView);
        StickyMemoObjectManager stickyMemoObjectManager2 = this.memoObjectManager;
        if (stickyMemoObjectManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
            stickyMemoObjectManager2 = null;
        }
        Context context = container.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenStickyNote spenStickyNoteAddNewMemoObject = stickyMemoObjectManager2.addNewMemoObject(context, addTargetPageIndex.intValue(), this.defWidth, pos);
        spenStickyNoteAddNewMemoObject.setVisible(false);
        this.memoRef.setShowingMemo(stickyMemoViewMakeStickMemoView);
        this.memoRef.setShowingObject(spenStickyNoteAddNewMemoObject);
        String attachedFile = spenStickyNoteAddNewMemoObject.getAttachedFile();
        Intrinsics.checkNotNull(attachedFile);
        SmViewConfig.MemoObjectInfo memoObjectInfo = new SmViewConfig.MemoObjectInfo(addTargetPageIndex.intValue(), spenStickyNoteAddNewMemoObject, true, pos == null);
        if (pos != null) {
            openRect = getOpenRect(container, getComposerViewPresenter().getDoc().getPage(addTargetPageIndex.intValue()).getOffset(), spenStickyNoteAddNewMemoObject.getCollapseRect(), getStartHeight(spenStickyNoteAddNewMemoObject.getId()));
            width = openRect.left;
            i = openRect.top;
        } else {
            width = (container.getWidth() / 2) - (this.defWidth / 2);
            int height = container.getHeight() / 2;
            int i2 = this.defHeight;
            i = height - (i2 / 2);
            openRect = getOpenRect(container, width, i, i2);
        }
        SmViewConfig smViewConfig = new SmViewConfig(width, i, openRect.width(), openRect.height(), this.defWidth, attachedFile, attachedFile, false, memoObjectInfo);
        updateBackground();
        stickyMemoViewMakeStickMemoView.show(smViewConfig);
        this.animationControl.showAnimation(stickyMemoViewMakeStickMemoView, new RunnableC9844c(getComposerViewPresenter().getComposerModel().getModeManager().isMode(Mode.Text) ? new RunnableC9874e(this, 0) : null, stickyMemoViewMakeStickMemoView));
        Logger.m10999d(TAG, "addStickyMemo# {" + spenStickyNoteAddNewMemoObject.getId() + " end");
        onShowCalled();
    }

    private final Rect getOpenRect(ViewGroup container, int x, int y2, int height) {
        Context context = container.getContext();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C9086R.dimen.sticky_memo_position_horizontal_margin);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C9086R.dimen.sticky_memo_position_top_margin);
        int openPos = getOpenPos(x, this.defWidth, dimensionPixelSize, container.getWidth() - dimensionPixelSize);
        int openPos2 = getOpenPos(y2, height, dimensionPixelSize2, container.getHeight());
        return new Rect(openPos, openPos2, this.defWidth + openPos, height + openPos2);
    }

    private final void openStickyMemo(ViewGroup container, SpenStickyNote memoObj) {
        String str = TAG;
        StickyMemoObjectManager stickyMemoObjectManager = this.memoObjectManager;
        if (stickyMemoObjectManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
            stickyMemoObjectManager = null;
        }
        Logger.m10999d(str, "openStickyMemo# " + stickyMemoObjectManager.toString(memoObj));
        ComposerSA.insertLog(StickyMemoSAConstants.SCREEN_STICKY_NOTE_MINIMIZED, StickyMemoSAConstants.EVENT_MEMO_OPEN);
        StickyMemoObjectManager stickyMemoObjectManager2 = this.memoObjectManager;
        if (stickyMemoObjectManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
            stickyMemoObjectManager2 = null;
        }
        SpenWNote doc = getComposerViewPresenter().getDoc();
        Intrinsics.checkNotNullExpressionValue(doc, "getDoc(...)");
        stickyMemoObjectManager2.clearDirty(doc, memoObj);
        StickyMemoView stickyMemoViewMakeStickMemoView = makeStickMemoView(container);
        this.animationControl.setShowAnimation(stickyMemoViewMakeStickMemoView);
        StickyMemoObjectManager stickyMemoObjectManager3 = this.memoObjectManager;
        if (stickyMemoObjectManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memoObjectManager");
            stickyMemoObjectManager3 = null;
        }
        SpenWNote doc2 = getComposerViewPresenter().getDoc();
        Intrinsics.checkNotNullExpressionValue(doc2, "getDoc(...)");
        Integer numFindPageIndexBy = stickyMemoObjectManager3.findPageIndexBy(doc2, memoObj);
        if (numFindPageIndexBy == null) {
            Logger.m11000e(str, "openStickyMemo# not found memo object");
            return;
        }
        Rect openRect = getOpenRect(container, getComposerViewPresenter().getDoc().getPage(numFindPageIndexBy.intValue()).getOffset(), memoObj.getCollapseRect(), getStartHeight(memoObj.getId()));
        SmViewConfig.MemoObjectInfo memoObjectInfo = new SmViewConfig.MemoObjectInfo(numFindPageIndexBy.intValue(), memoObj, false, false, 8, null);
        String attachedFile = memoObj.getAttachedFile();
        Intrinsics.checkNotNull(attachedFile);
        SmViewConfig smViewConfig = new SmViewConfig(openRect, this.defWidth, attachedFile, AbstractC0541b.m757C(getComposerViewPresenter().getObjectManager().getCachePath(), FileUtils.extractFileName(attachedFile), ".sdocx"), memoObjectInfo);
        this.memoRef.setShowingObject(memoObj);
        this.memoRef.setShowingMemo(stickyMemoViewMakeStickMemoView);
        updateBackground();
        stickyMemoViewMakeStickMemoView.show(smViewConfig);
        final boolean zIsInputMethodShown = getControllerManager().getSoftInputManager().isInputMethodShown();
        if (zIsInputMethodShown) {
            getControllerManager().getSoftInputManager().blockToHide(true);
        }
        this.animationControl.maximizeAnimation(stickyMemoViewMakeStickMemoView, memoObj, getComposerViewPresenter().getComposerModel().getModeManager().isMode(Mode.Text) ? new RunnableC0202d(stickyMemoViewMakeStickMemoView, zIsInputMethodShown, this, 9) : null, new RunnableC9767a(new Function0(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.stickymemo.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ StickyMemoManager f7036b;

            {
                this.f7036b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return StickyMemoManager.openStickyMemo$lambda$12(zIsInputMethodShown, this.f7036b);
            }
        }, 1));
        onShowCalled();
    }
}
