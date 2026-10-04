package com.samsung.android.support.senl.p148nt.base.extension.stickymemo;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.bixby2.action.ActionHandler;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.StickyMemoView;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.common.util.SmLogger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0002\u001f B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0003J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0007H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoService;", "Landroid/app/Service;", "<init>", "()V", "viewMap", "Ljava/util/HashMap;", "", "Landroid/view/View;", "Lkotlin/collections/HashMap;", "onCreate", "", "onBind", "Landroid/os/IBinder;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", "numWindow", "getNumWindow$annotations", "getNumWindow", "()I", "addView", "id", "createTouchListener", "Landroid/view/View$OnTouchListener;", "view", ActionHandler.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "createView", "WindowTouchListener", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StickyMemoService extends Service {
    public static final boolean GLOBAL_STICKY_MEMO_ENABLED = true;

    @NotNull
    public static final String GLOBAL_STICKY_MEMO_ID = "sticky_memo_id";

    @NotNull
    private final HashMap<String, View> viewMap = new HashMap<>();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = SmLogger.createTag("StickyMemoService");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoService$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "GLOBAL_STICKY_MEMO_ENABLED", "", "GLOBAL_STICKY_MEMO_ID", "getWindowManager", "Landroid/view/WindowManager;", "service", "Landroid/app/Service;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @VisibleForTesting
        @NotNull
        public final WindowManager getWindowManager(@NotNull Service service) {
            Intrinsics.checkNotNullParameter(service, "service");
            Object systemService = service.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            return (WindowManager) systemService;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/extension/stickymemo/StickyMemoService$WindowTouchListener;", "Landroid/view/View$OnTouchListener;", "target", "Landroid/view/View;", ActionHandler.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "<init>", "(Landroid/view/View;Landroid/view/WindowManager$LayoutParams;)V", "getTarget", "()Landroid/view/View;", "getParams", "()Landroid/view/WindowManager$LayoutParams;", "initialPosX", "", "initialPosY", "initialTouchX", "", "initialTouchY", "onTouch", "", VPathDataCmd.RCurveTo, "e", "Landroid/view/MotionEvent;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class WindowTouchListener implements View.OnTouchListener {
        private int initialPosX;
        private int initialPosY;
        private float initialTouchX;
        private float initialTouchY;

        @NotNull
        private final WindowManager.LayoutParams params;

        @NotNull
        private final View target;

        public WindowTouchListener(@NotNull View target, @NotNull WindowManager.LayoutParams params) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(params, "params");
            this.target = target;
            this.params = params;
        }

        @NotNull
        public final WindowManager.LayoutParams getParams() {
            return this.params;
        }

        @NotNull
        public final View getTarget() {
            return this.target;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0017  */
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouch(@Nullable View v, @Nullable MotionEvent e) {
            if (v == null || e == null) {
                return false;
            }
            int action = e.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                        switch (action) {
                            case 211:
                                break;
                            case 213:
                                this.params.x = this.initialPosX + ((int) (e.getRawX() - this.initialTouchX));
                                this.params.y = this.initialPosY + ((int) (e.getRawY() - this.initialTouchY));
                                Object systemService = v.getContext().getSystemService("window");
                                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                                ((WindowManager) systemService).updateViewLayout(this.target, this.params);
                            case 212:
                                return true;
                            default:
                                return false;
                        }
                    }
                }
                return true;
            }
            WindowManager.LayoutParams layoutParams = this.params;
            this.initialPosX = layoutParams.x;
            this.initialPosY = layoutParams.y;
            this.initialTouchX = e.getRawX();
            this.initialTouchY = e.getRawY();
            return true;
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    private final void addView(final String id) {
        final WindowManager windowManager = INSTANCE.getWindowManager(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2038, 544, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 0;
        final View viewCreateView = createView();
        this.viewMap.put(id, viewCreateView);
        windowManager.addView(viewCreateView, layoutParams);
        viewCreateView.setOnTouchListener(createTouchListener(viewCreateView, layoutParams));
        if (viewCreateView instanceof StickyMemoView) {
            StickyMemoView stickyMemoView = (StickyMemoView) viewCreateView;
            StickyMemoView.show$default(stickyMemoView, 0, 0, 800, 400, 800, null, 32, null);
            stickyMemoView.setOnActionListener(new StickyMemoView.OnActionListener() { // from class: com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoService.addView.1
                @Override // com.samsung.android.support.senl.nt.base.extension.stickymemo.StickyMemoView.OnActionListener
                public void onClosed(View v) throws IOException {
                    Intrinsics.checkNotNullParameter(v, "v");
                    ((StickyMemoView) viewCreateView).saveDoc();
                    ((StickyMemoView) viewCreateView).release();
                    windowManager.removeView(v);
                    this.viewMap.remove(id);
                    ((StickyMemoView) viewCreateView).setOnActionListener(null);
                }
            });
        }
        SmLogger.m8661d(TAG, "addWindow");
    }

    private final View createView() {
        View viewInflate = LayoutInflater.from(this).inflate(C8875R.layout.sticky_memo_view, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @VisibleForTesting
    public static /* synthetic */ void getNumWindow$annotations() {
    }

    @VisibleForTesting
    @NotNull
    public final View.OnTouchListener createTouchListener(@NotNull View view, @NotNull WindowManager.LayoutParams params) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(params, "params");
        return new WindowTouchListener(view, params);
    }

    public final int getNumWindow() {
        return this.viewMap.size();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@Nullable Intent intent) {
        throw new UnsupportedOperationException(AbstractC0541b.m756B(TAG, " : Not support binding"));
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        SpenSdkInitializer.initialize(this);
        SmLogger.m8661d(TAG, "onCreate");
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        String stringExtra;
        int i = this.viewMap.isEmpty() ? 2 : 1;
        if (intent == null || (stringExtra = intent.getStringExtra(GLOBAL_STICKY_MEMO_ID)) == null) {
            return i;
        }
        String str = TAG;
        SmLogger.m8661d(str, "onStartCommand - ".concat(stringExtra));
        if (this.viewMap.containsKey(stringExtra)) {
            SmLogger.m8661d(str, "already added");
            return 1;
        }
        addView(stringExtra);
        return 1;
    }
}
