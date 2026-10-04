package p099Y2;

import android.content.Context;
import android.os.IBinder;
import android.text.Editable;
import android.view.View;
import androidx.arch.core.util.Function;
import androidx.compose.p109ui.geometry.Rect;
import androidx.compose.p109ui.graphics.colorspace.ColorSpaces;
import androidx.compose.p109ui.graphics.colorspace.DoubleFunction;
import androidx.compose.p109ui.graphics.colorspace.Rgb;
import androidx.compose.p109ui.text.AnnotatedString;
import androidx.compose.p109ui.text.TextInclusionStrategy;
import androidx.compose.p109ui.text.input.TransformedText;
import androidx.compose.p109ui.text.input.VisualTransformation;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.glance.session.TimeSource;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.internal.platform.ServiceLoaderWrapper;
import androidx.test.internal.platform.p117os.ControlledLooper;
import androidx.test.internal.platform.util.TestOutputEmitter;
import androidx.test.platform.p118io.FileTestStorage;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.PreferenceUtils;
import com.google.android.datatransport.Transformer;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.samsung.android.aicore.sdkcommon.IOnDeviceService;
import com.samsung.android.app.sdk.deepsky.search.GraphqlQueryExecutorImpl;
import com.samsung.android.app.sdk.deepsky.search.Logger;
import com.samsung.android.kmxservice.sdk.util.KmxFaultBarrier;
import com.samsung.android.kmxservice.sdk.util.SksAttestation;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorSettingPopup;
import com.samsung.android.sdk.scs.p142ai.gateway.AiServiceExecutorFactory;
import com.samsung.android.support.senl.p148nt.app.settings.hwr.SettingsHWRFragment;
import com.samsung.android.visual.p167ai.sdkcommon.IImageEditorService;
import java.util.List;

/* JADX INFO: renamed from: Y2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C0347a implements RecyclerView.SeslOnGoToTopClickListener, DoubleFunction, TextInclusionStrategy, VisualTransformation, OnApplyWindowInsetsListener, TimeSource, ServiceLoaderWrapper.Factory, Function, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter, LibraryVersionComponent.VersionExtractor, Continuation, Transformer, Logger, KmxFaultBarrier.ThrowableSupplier, AiServiceExecutorFactory.ServiceStubFactory {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f871a;

    public /* synthetic */ C0347a(int i) {
        this.f871a = i;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    @Override // androidx.test.internal.platform.ServiceLoaderWrapper.Factory
    public Object create() {
        switch (this.f871a) {
            case 10:
                return ActivityScenario.lambda$new$0();
            case 11:
                return ControlledLooper.NO_OP_CONTROLLED_LOOPER;
            case 12:
                return TestOutputEmitter.lambda$static$0();
            default:
                return new FileTestStorage();
        }
    }

    @Override // com.samsung.android.sdk.scs.ai.gateway.AiServiceExecutorFactory.ServiceStubFactory
    public Object createStub(IBinder iBinder) {
        switch (this.f871a) {
            case 28:
                return IOnDeviceService.Stub.asInterface(iBinder);
            default:
                return IImageEditorService.Stub.asInterface(iBinder);
        }
    }

    @Override // com.google.firebase.platforminfo.LibraryVersionComponent.VersionExtractor
    public String extract(Object obj) {
        Context context = (Context) obj;
        switch (this.f871a) {
            case 18:
                return FirebaseCommonRegistrar.lambda$getComponents$0(context);
            case 19:
                return FirebaseCommonRegistrar.lambda$getComponents$1(context);
            case 20:
                return FirebaseCommonRegistrar.lambda$getComponents$2(context);
            default:
                return FirebaseCommonRegistrar.lambda$getComponents$3(context);
        }
    }

    @Override // androidx.compose.p109ui.text.input.VisualTransformation
    public TransformedText filter(AnnotatedString annotatedString) {
        return VisualTransformation.Companion.None$lambda$0(annotatedString);
    }

    @Override // com.samsung.android.kmxservice.sdk.util.KmxFaultBarrier.ThrowableSupplier
    public Object get() {
        switch (this.f871a) {
            case 25:
                return SksAttestation.getInstance();
            default:
                return SksAttestation.m5530a();
        }
    }

    @Override // androidx.compose.p109ui.graphics.colorspace.DoubleFunction
    public double invoke(double d) {
        switch (this.f871a) {
            case 1:
                return ColorSpaces.ExtendedSrgb$lambda$0(d);
            case 2:
                return ColorSpaces.ExtendedSrgb$lambda$1(d);
            default:
                return Rgb.DoubleIdentity$lambda$12(d);
        }
    }

    @Override // androidx.compose.p109ui.text.TextInclusionStrategy
    public boolean isIncluded(Rect rect, Rect rect2) {
        switch (this.f871a) {
            case 4:
                return rect.overlaps(rect2);
            case 5:
                return TextInclusionStrategy.Companion.ContainsAll$lambda$1(rect, rect2);
            default:
                return TextInclusionStrategy.Companion.ContainsCenter$lambda$2(rect, rect2);
        }
    }

    @Override // com.samsung.android.app.sdk.deepsky.search.Logger
    public void log(int i, String str, Throwable th, Object[] objArr) {
        GraphqlQueryExecutorImpl.logger$lambda$0(i, str, th, objArr);
    }

    @Override // androidx.glance.session.TimeSource
    public long markNow() {
        return System.currentTimeMillis();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        switch (this.f871a) {
            case 8:
                return DrawerLayout.lambda$new$1(view, windowInsetsCompat);
            default:
                return SpenColorSettingPopup.applyWindowInsets$lambda$8$lambda$7(view, windowInsetsCompat);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SeslOnGoToTopClickListener
    public boolean onGoToTopClick(RecyclerView recyclerView) {
        return SettingsHWRFragment.onCreateRecyclerView$lambda$0(recyclerView);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return FcmBroadcastProcessor.lambda$startMessagingService$1(task);
    }

    @Override // androidx.arch.core.util.Function
    /* JADX INFO: renamed from: apply */
    public Object mo22196apply(Object obj) {
        switch (this.f871a) {
            case 14:
                return WorkSpec.WORK_INFO_MAPPER$lambda$1((List) obj);
            case 15:
                return PreferenceUtils.lambda$getLastCancelAllTimeMillisLiveData$0((Long) obj);
            default:
                return ((MessagingClientEventExtension) obj).toByteArray();
        }
    }
}
