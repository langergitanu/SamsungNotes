package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.FragmentManager;
import com.nimbusds.jose.jwk.JWKParameterNames;
import com.samsung.android.support.senl.p145cm.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view.CoverAILayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout;
import com.samsung.android.support.senl.p148nt.composer.main.cover.model.CoverData;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.model.assist.llm.p166sa.AssistSAConstants;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \\2\u00020\u0001:\u0002[\\B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aJ\u0010\u0010 \u001a\u00020\u001e2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010\"J\b\u0010%\u001a\u00020\u0018H\u0002J\u0006\u0010&\u001a\u00020\u001eJ0\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020\n2\u0006\u0010-\u001a\u00020\nH\u0014J\b\u0010.\u001a\u00020\u001eH\u0002J\b\u0010/\u001a\u00020\u001eH\u0002J\b\u00100\u001a\u00020\u001eH\u0002J\b\u00101\u001a\u00020\u001eH\u0002J\u0006\u00102\u001a\u00020\u001eJ\b\u00103\u001a\u00020\u001eH\u0002J\b\u00104\u001a\u00020\u001eH\u0002J\b\u00105\u001a\u00020\u001eH\u0002J\b\u00106\u001a\u00020\u001eH\u0002J\u0010\u00105\u001a\u00020\u001e2\u0006\u00107\u001a\u000208H\u0002J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nH\u0002J\u0006\u0010<\u001a\u00020\nJ\b\u0010=\u001a\u00020\u001eH\u0002J\b\u0010>\u001a\u00020\u001eH\u0002J\b\u0010?\u001a\u00020@H\u0002J\n\u0010A\u001a\u0004\u0018\u00010BH\u0002J\b\u0010C\u001a\u00020DH\u0002J\b\u0010E\u001a\u00020)H\u0002J\b\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0002J\u0006\u0010H\u001a\u00020)J\u0006\u0010I\u001a\u00020\u001eJ\u0016\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020\n2\u0006\u0010L\u001a\u00020\nJ\u0006\u0010M\u001a\u00020\u001eJ\u000e\u0010N\u001a\u00020\u001e2\u0006\u0010O\u001a\u00020)J\u000e\u0010P\u001a\u00020\u001e2\u0006\u0010Q\u001a\u00020RJ\b\u0010S\u001a\u00020\u001eH\u0002J\u0010\u0010T\u001a\u00020\u001e2\u0006\u0010U\u001a\u00020\nH\u0007J\u0006\u0010V\u001a\u00020\u001eJ\u000e\u0010W\u001a\u00020\u001e2\u0006\u0010X\u001a\u00020)J\u0006\u0010Y\u001a\u00020\u001eJ\b\u0010Z\u001a\u00020)H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006]"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/NoteStyleLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPageStyleContainer", "Landroid/view/View;", "mPagePreviewContainer", "mPagePreview", "Landroid/widget/ImageView;", "mPageText", "Landroid/widget/TextView;", "mCoverPreview", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverPreviewLayout;", "mCoverAILayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/cover/view/CoverAILayout;", "mSelectedPreviewType", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$PreviewType;", "mContract", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/NoteStyleLayout$Contract;", "mCaller", "Ljava/lang/Integer;", "initialize", "", "contract", "initParams", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "outState", "defaultPreviewType", "initLayout", "onLayout", "changed", "", "left", "top", "right", "bottom", "initPreviewLayout", "initPagePreview", "onSelectedPreviewTypeChanged", "updatePreview", "updatePagePreview", "initStyleContainer", "updateStyleContainer", "updateStyleContainerLayout", "showBothPreviewLayout", JWKParameterNames.RSA_FIRST_FACTOR_CRT_EXPONENT, "", "showOnlyPreviewLayout", "targetId", "hideId", "getStyleContainerResId", "requestShowPageStyle", "requestShowCoverStyle", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "getPageThumbnail", "Landroid/graphics/Bitmap;", "getType", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "isCoeditNote", "initCoverPreview", "updateCoverPreview", "isCoverPreviewSelected", "updateCoverPreviewLayout", "updateCoverSticker", "stickerPosition", "stickerPrevPosition", "startAnimation", "stopAnimation", "withAnimation", "onCompleteAndUpdateView", DBSchema.DocumentCover.SUMMARY, "", "initCoverAILayout", "updateCoverAILayoutVisibility", "visibility", "showCoverNewPreview", "updateCoverAIButton", "activate", "destroyView", "isLandscapeLayoutRequired", "Contract", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nNoteStyleLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NoteStyleLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/NoteStyleLayout\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,509:1\n37#2:510\n36#2,3:511\n276#3:514\n*S KotlinDebug\n*F\n+ 1 NoteStyleLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/NoteStyleLayout\n*L\n63#1:510\n63#1:511,3\n192#1:514\n*E\n"})
public final class NoteStyleLayout extends FrameLayout {

    @NotNull
    private static final String KEY_SELECTED_PREVIEW_INDEX = "key_selected_preview_index";
    private static final float STYLE_CONTAINER_COVER_TOP_MARGIN = 0.0f;
    private static final float STYLE_CONTAINER_PAGE_TOP_MARGIN = 28.0f;

    @NotNull
    public static final String TAG = "NoteStyleLayout";

    @Nullable
    private Integer mCaller;

    @Nullable
    private Contract mContract;

    @Nullable
    private CoverAILayout mCoverAILayout;

    @Nullable
    private CoverPreviewLayout mCoverPreview;

    @Nullable
    private ImageView mPagePreview;

    @Nullable
    private View mPagePreviewContainer;

    @Nullable
    private View mPageStyleContainer;

    @Nullable
    private TextView mPageText;

    @Nullable
    private Constant.PreviewType mSelectedPreviewType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\fH&J\b\u0010\u0019\u001a\u00020\u0003H&J\b\u0010\u001a\u001a\u00020\fH&J\b\u0010\u001b\u001a\u00020\u0003H&¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/view/NoteStyleLayout$Contract;", "", "requestShowPageStyle", "", "requestShowCoverStyle", "getPageRatioType", "Lcom/samsung/android/support/senl/nt/model/base/document/DocumentPageRatio$PageRatioType;", "getPageThumbnail", "Landroid/graphics/Bitmap;", "getType", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/notestyle/common/Constant$Type;", "isCoeditNote", "", "getCoverData", "Lcom/samsung/android/support/senl/nt/composer/main/cover/model/CoverData;", "getSupportFragmentManager", "Landroidx/fragment/app/FragmentManager;", "setCoverSummary", DBSchema.DocumentCover.SUMMARY, "", "requestApplyCover", "requestClearCover", "cancelGenerateCover", "enableEditor", "isEnable", "onClickAiButton", "isLandscapeLayoutRequired", "updateCreateBtn", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void cancelGenerateCover();

        void enableEditor(boolean isEnable);

        @Nullable
        CoverData getCoverData();

        @NotNull
        DocumentPageRatio.PageRatioType getPageRatioType();

        @Nullable
        Bitmap getPageThumbnail();

        @NotNull
        FragmentManager getSupportFragmentManager();

        @NotNull
        Constant.Type getType();

        boolean isCoeditNote();

        boolean isLandscapeLayoutRequired();

        void onClickAiButton();

        void requestApplyCover();

        void requestClearCover();

        void requestShowCoverStyle();

        void requestShowPageStyle();

        void setCoverSummary(@NotNull String summary);

        void updateCreateBtn();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Constant.Type.values().length];
            try {
                iArr[Constant.Type.COVER_EDIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Constant.Type.STYLE_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout$updateCoverAILayoutVisibility$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout$updateCoverAILayoutVisibility$1", m14021f = "NoteStyleLayout.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C103661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $visibility;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103661(int i, Continuation<? super C103661> continuation) {
            super(2, continuation);
            this.$visibility = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(NoteStyleLayout noteStyleLayout, int i) {
            CoverAILayout coverAILayout = noteStyleLayout.mCoverAILayout;
            if (coverAILayout != null) {
                coverAILayout.setVisibility(i);
            }
            CoverAILayout coverAILayout2 = noteStyleLayout.mCoverAILayout;
            noteStyleLayout.updateStyleContainerLayout((coverAILayout2 == null || coverAILayout2.getVisibility() != 0) ? NoteStyleLayout.STYLE_CONTAINER_PAGE_TOP_MARGIN : 0.0f);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NoteStyleLayout.this.new C103661(this.$visibility, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoverAILayout coverAILayout = NoteStyleLayout.this.mCoverAILayout;
            if (coverAILayout != null) {
                final NoteStyleLayout noteStyleLayout = NoteStyleLayout.this;
                final int i = this.$visibility;
                Boxing.boxBoolean(coverAILayout.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        NoteStyleLayout.C103661.invokeSuspend$lambda$0(noteStyleLayout, i);
                    }
                }));
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C103661) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteStyleLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Constant.PreviewType defaultPreviewType() {
        return getType() == Constant.Type.COVER_EDIT ? Constant.PreviewType.COVER : Constant.PreviewType.PAGE;
    }

    private final DocumentPageRatio.PageRatioType getPageRatioType() {
        DocumentPageRatio.PageRatioType pageRatioType;
        Contract contract = this.mContract;
        return (contract == null || (pageRatioType = contract.getPageRatioType()) == null) ? DocumentPageRatio.PageRatioType.A4_PORTRAIT : pageRatioType;
    }

    private final Bitmap getPageThumbnail() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.getPageThumbnail();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Constant.Type getType() {
        Constant.Type type;
        Contract contract = this.mContract;
        return (contract == null || (type = contract.getType()) == null) ? Constant.Type.CREATE_NOTE : type;
    }

    private final void initCoverAILayout() {
        CoverData coverData;
        Logger.m10999d(TAG, "initCoverAILayout");
        CoverAILayout coverAILayout = (CoverAILayout) findViewById(C9086R.id.cover_ai_layout);
        coverAILayout.setContract(new CoverAILayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout$initCoverAILayout$1$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverAILayout.Contract
            public FragmentManager getSupportFragmentManager() {
                FragmentManager supportFragmentManager;
                NoteStyleLayout.Contract contract = this.this$0.mContract;
                if (contract == null || (supportFragmentManager = contract.getSupportFragmentManager()) == null) {
                    throw new IllegalStateException("contract is not initialized");
                }
                return supportFragmentManager;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverAILayout.Contract
            public void onClickAiButton() {
                NoteStyleLayout.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    contract.onClickAiButton();
                }
                CommonSamsungAnalytics.INSTANCE.insertLog(AssistSAConstants.SCREEN_NOTE_STYLE_COMPOSER, AssistSAConstants.EVENT_COMPOSER_SUGGEST_NEW_COVER);
            }
        });
        Contract contract = this.mContract;
        if (contract != null && (coverData = contract.getCoverData()) != null && coverData.getIsGeneratedCover()) {
            coverAILayout.setDisclaimerVisibility(0);
        }
        this.mCoverAILayout = coverAILayout;
    }

    private final void initCoverPreview() {
        Logger.m10999d(TAG, "initCoverPreview");
        CoverPreviewLayout coverPreviewLayout = (CoverPreviewLayout) findViewById(C9086R.id.cover_style);
        coverPreviewLayout.setContract(new CoverPreviewLayout.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.view.NoteStyleLayout$initCoverPreview$1$1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.Contract
            public CoverData getCoverData() {
                NoteStyleLayout.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    return contract.getCoverData();
                }
                return null;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.Contract
            public boolean isCoverPreviewSelect() {
                return this.this$0.isCoverPreviewSelected();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.Contract
            public void onClickClearButton() {
                NoteStyleLayout.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    contract.requestClearCover();
                }
                this.this$0.updateCoverAIButton(false);
                NoteStyleLayout.Contract contract2 = this.this$0.mContract;
                if (contract2 != null) {
                    contract2.updateCreateBtn();
                }
                CoverAILayout coverAILayout = this.this$0.mCoverAILayout;
                if (coverAILayout != null) {
                    coverAILayout.setDisclaimerVisibility(4);
                }
                if (this.this$0.getType() == Constant.Type.STYLE_CHANGE || this.this$0.getType() == Constant.Type.CREATE_NOTE) {
                    this.this$0.mSelectedPreviewType = Constant.PreviewType.PAGE;
                    this.this$0.onSelectedPreviewTypeChanged();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.Contract
            public void onClickCoverPreview() {
                Logger.m10999d(NoteStyleLayout.TAG, "onClickCoverPreview");
                CoverData coverData = getCoverData();
                if (coverData == null || coverData.getGenerateState() != 1) {
                    this.this$0.mSelectedPreviewType = Constant.PreviewType.COVER;
                    NoteStyleLayout.Contract contract = this.this$0.mContract;
                    if (contract != null) {
                        contract.requestApplyCover();
                    }
                    NoteStyleLayout.Contract contract2 = this.this$0.mContract;
                    if (contract2 != null) {
                        contract2.updateCreateBtn();
                    }
                    this.this$0.onSelectedPreviewTypeChanged();
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.notestyle.cover.view.CoverPreviewLayout.Contract
            public void setCoverSummary(String summary) {
                Intrinsics.checkNotNullParameter(summary, "summary");
                NoteStyleLayout.Contract contract = this.this$0.mContract;
                if (contract != null) {
                    contract.setCoverSummary(summary);
                }
            }
        });
        coverPreviewLayout.initCoverPreview();
        this.mCoverPreview = coverPreviewLayout;
    }

    private final void initPagePreview() {
        this.mPageStyleContainer = findViewById(C9086R.id.page_style);
        this.mPagePreviewContainer = findViewById(C9086R.id.page_preview_container);
        ImageView imageView = (ImageView) findViewById(C9086R.id.page_preview);
        this.mPagePreview = imageView;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        this.mPageText = (TextView) findViewById(C9086R.id.page_text);
        View view = this.mPagePreviewContainer;
        if (view != null) {
            view.setOnClickListener(new ViewOnClickListenerC8556a(this, 15));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPagePreview$lambda$0(NoteStyleLayout noteStyleLayout, View view) {
        noteStyleLayout.mSelectedPreviewType = Constant.PreviewType.PAGE;
        noteStyleLayout.onSelectedPreviewTypeChanged();
    }

    private final void initPreviewLayout() {
        Constant.Type type = getType();
        if (type == Constant.Type.TEMPLATE_PICKER) {
            ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C9086R.id.preview_area);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
                return;
            }
            return;
        }
        initPagePreview();
        initCoverPreview();
        initCoverAILayout();
        updateCoverPreview();
        Logger.m10999d(TAG, "initPreviewLayout# type : " + type + ", isCoeditNote : " + isCoeditNote());
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            showOnlyPreviewLayout(C9086R.id.cover_style, C9086R.id.page_style);
            return;
        }
        if (i != 2) {
            showBothPreviewLayout();
        } else if (isCoeditNote()) {
            showOnlyPreviewLayout(C9086R.id.page_style, C9086R.id.cover_style);
        } else {
            showBothPreviewLayout();
        }
    }

    private final void initStyleContainer() {
        updateStyleContainer();
    }

    private final boolean isCoeditNote() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.isCoeditNote();
        }
        return false;
    }

    private final boolean isLandscapeLayoutRequired() {
        Contract contract = this.mContract;
        if (contract != null) {
            return contract.isLandscapeLayoutRequired();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelectedPreviewTypeChanged() {
        updatePreview();
        updateStyleContainer();
    }

    private final void requestShowCoverStyle() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.requestShowCoverStyle();
        }
    }

    private final void requestShowPageStyle() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.requestShowPageStyle();
        }
    }

    private final void showBothPreviewLayout() {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C9086R.id.preview_area);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.setVisibility(C9086R.id.page_style, 0);
        constraintSet.clear(C9086R.id.cover_style, 6);
        constraintSet.clear(C9086R.id.cover_style, 7);
        constraintSet.clear(C9086R.id.page_style, 6);
        constraintSet.clear(C9086R.id.page_style, 7);
        constraintSet.connect(C9086R.id.cover_style, 6, 0, 6, 0);
        constraintSet.connect(C9086R.id.cover_style, 7, C9086R.id.page_style, 6, (int) ResourceUtils.convertDpToPixel(getContext(), 6.0f));
        constraintSet.connect(C9086R.id.page_style, 6, C9086R.id.cover_style, 7, (int) ResourceUtils.convertDpToPixel(getContext(), 6.0f));
        constraintSet.connect(C9086R.id.page_style, 7, 0, 7, 0);
        constraintSet.constrainWidth(C9086R.id.cover_style, 0);
        constraintSet.constrainWidth(C9086R.id.page_style, 0);
        constraintSet.setHorizontalWeight(C9086R.id.cover_style, 1.0f);
        constraintSet.setHorizontalWeight(C9086R.id.page_style, 1.0f);
        constraintSet.setHorizontalChainStyle(C9086R.id.cover_style, 0);
        constraintSet.applyTo(constraintLayout);
        updateStyleContainerLayout(STYLE_CONTAINER_PAGE_TOP_MARGIN);
    }

    private final void showOnlyPreviewLayout(int targetId, int hideId) {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C9086R.id.preview_area);
        int iConvertDpToPixel = (int) ResourceUtils.convertDpToPixel(getContext(), 14.0f);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        constraintSet.setVisibility(targetId, 0);
        constraintSet.setVisibility(hideId, 8);
        constraintSet.clear(targetId, 6);
        constraintSet.clear(targetId, 7);
        constraintSet.connect(targetId, 6, 0, 6, iConvertDpToPixel);
        constraintSet.connect(targetId, 7, 0, 7, iConvertDpToPixel);
        constraintSet.constrainWidth(targetId, 0);
        constraintSet.constrainDefaultWidth(targetId, 2);
        constraintSet.constrainPercentWidth(targetId, 0.5f);
        constraintSet.setHorizontalBias(targetId, 0.5f);
        constraintSet.applyTo(constraintLayout);
        CoverAILayout coverAILayout = this.mCoverAILayout;
        updateStyleContainerLayout((coverAILayout == null || coverAILayout.getVisibility() != 0) ? STYLE_CONTAINER_PAGE_TOP_MARGIN : 0.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateCoverPreview() {
        boolean z;
        Contract contract;
        CoverData coverData;
        Logger.m10999d(TAG, "updateCoverPreview#");
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            if (!isCoverPreviewSelected() || (contract = this.mContract) == null || (coverData = contract.getCoverData()) == null) {
                z = false;
                coverPreviewLayout.updateCoverPreviewContainer(z);
            } else {
                z = true;
                if (!coverData.isEnabled()) {
                }
                coverPreviewLayout.updateCoverPreviewContainer(z);
            }
        }
        if (isCoverPreviewSelected()) {
            updateCoverPreviewLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updatePagePreview$lambda$3$lambda$2(View view, NoteStyleLayout noteStyleLayout, DocumentPageRatio.PageRatioType pageRatioType) {
        int measuredHeight = view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        ImageView imageView = noteStyleLayout.mPagePreview;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int pageRatio = measuredHeight - (marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            int pageRatio2 = measuredWidth - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
            if (DocumentPageRatio.PageRatioType.A4_LANDSCAPE == pageRatioType) {
                pageRatio = (int) (noteStyleLayout.getPageRatioType().getPageRatio() * pageRatio2);
            } else {
                pageRatio2 = (int) (pageRatio / noteStyleLayout.getPageRatioType().getPageRatio());
            }
            marginLayoutParams.height = pageRatio;
            marginLayoutParams.width = pageRatio2;
            imageView.setLayoutParams(marginLayoutParams);
            imageView.setImageBitmap(noteStyleLayout.getPageThumbnail());
            if (imageView.getVisibility() == 4) {
                imageView.setVisibility(0);
            }
        }
    }

    private final void updatePreview() {
        Logger.m10999d(TAG, "updatePreview# type : " + getType());
        if (getType() == Constant.Type.TEMPLATE_PICKER) {
            return;
        }
        updateCoverPreview();
        updatePagePreview();
    }

    private final void updateStyleContainer() {
        if (this.mSelectedPreviewType != Constant.PreviewType.PAGE) {
            requestShowCoverStyle();
        } else {
            requestShowPageStyle();
            updateCoverAILayoutVisibility(8);
        }
    }

    private final void updateStyleContainerLayout() {
        if (getType() == Constant.Type.TEMPLATE_PICKER) {
            return;
        }
        View viewFindViewById = findViewById(C9086R.id.contents_container);
        viewFindViewById.post(new RunnableC8928b(findViewById(C9086R.id.style_container_layout), 16, this, viewFindViewById));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateStyleContainerLayout$lambda$4(View view, NoteStyleLayout noteStyleLayout, View view2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        float fConvertDpToPixel = ResourceUtils.convertDpToPixel(noteStyleLayout.getContext(), 500.0f);
        float fConvertDpToPixel2 = ResourceUtils.convertDpToPixel(noteStyleLayout.getContext(), 200.0f);
        boolean z = WindowManagerCompat.INSTANCE.getInstance().getMultiWindowMode(noteStyleLayout.getContext().getResources().getConfiguration()) == 0;
        if (noteStyleLayout.isLandscapeLayoutRequired()) {
            layoutParams.height = -1;
        } else if (view2.getMeasuredHeight() < fConvertDpToPixel || view.getMeasuredHeight() < fConvertDpToPixel2 || !z) {
            layoutParams.height = 0;
        } else {
            layoutParams.height = view.getMeasuredHeight() / 2;
        }
        view.setLayoutParams(layoutParams);
    }

    public final void destroyView() {
        CoverAILayout coverAILayout = this.mCoverAILayout;
        if (coverAILayout != null) {
            coverAILayout.clearGuidingLightEffect();
        }
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.stopGenerateAnimation(false);
        }
    }

    public final int getStyleContainerResId() {
        return C9086R.id.style_container;
    }

    public final void initLayout() {
        LayoutInflater.from(getContext()).inflate(isLandscapeLayoutRequired() ? C9086R.layout.note_style_layout_land : C9086R.layout.note_style_layout, (ViewGroup) this, true);
        initPreviewLayout();
        initStyleContainer();
    }

    public final void initParams(@Nullable Bundle savedInstanceState) {
        this.mSelectedPreviewType = ((Constant.PreviewType[]) Constant.PreviewType.getEntries().toArray(new Constant.PreviewType[0]))[savedInstanceState != null ? savedInstanceState.getInt(KEY_SELECTED_PREVIEW_INDEX, defaultPreviewType().ordinal()) : defaultPreviewType().ordinal()];
    }

    public final void initialize(@NotNull Contract contract) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        this.mContract = contract;
    }

    public final boolean isCoverPreviewSelected() {
        return this.mSelectedPreviewType == Constant.PreviewType.COVER;
    }

    public final void onCompleteAndUpdateView(@NotNull String summary) {
        Intrinsics.checkNotNullParameter(summary, "summary");
        Logger.m10999d(TAG, "onCompleteAndUpdateView#");
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.updateCoverPreviewLayout();
        }
        CoverPreviewLayout coverPreviewLayout2 = this.mCoverPreview;
        if (coverPreviewLayout2 != null) {
            coverPreviewLayout2.updateCoverSummary(summary);
        }
        CoverAILayout coverAILayout = this.mCoverAILayout;
        if (coverAILayout != null) {
            coverAILayout.setDisclaimerVisibility(0);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            updateCoverPreview();
            updateStyleContainerLayout();
        }
    }

    public final void onSaveInstanceState(@Nullable Bundle outState) {
        if (outState != null) {
            Constant.PreviewType previewTypeDefaultPreviewType = this.mSelectedPreviewType;
            if (previewTypeDefaultPreviewType == null) {
                previewTypeDefaultPreviewType = defaultPreviewType();
            }
            outState.putInt(KEY_SELECTED_PREVIEW_INDEX, previewTypeDefaultPreviewType.ordinal());
        }
    }

    public final void showCoverNewPreview() {
        Logger.m10999d(TAG, "showCoverNewPreview");
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.onClickAddButton();
        }
    }

    public final void startAnimation() {
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.startGenerateAnimation();
        }
    }

    public final void stopAnimation(boolean withAnimation) {
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.stopGenerateAnimation(withAnimation);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateCoverAIButton(boolean activate) {
        boolean z;
        Contract contract;
        CoverData coverData;
        CoverAILayout coverAILayout = this.mCoverAILayout;
        if (coverAILayout != null) {
            if (!activate || (contract = this.mContract) == null || (coverData = contract.getCoverData()) == null) {
                z = false;
            } else {
                z = true;
                if (!coverData.isEnabled()) {
                }
            }
            coverAILayout.setAiButtonAlpha(z);
        }
    }

    @MainThread
    public final void updateCoverAILayoutVisibility(int visibility) {
        Logger.m10999d(TAG, "updateCoverAILayoutVisibility# visibility : " + visibility);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C103661(visibility, null), 3, null);
    }

    public final void updateCoverPreviewLayout() {
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.updateCoverPreviewLayout();
        }
    }

    public final void updateCoverSticker(int stickerPosition, int stickerPrevPosition) {
        CoverPreviewLayout coverPreviewLayout = this.mCoverPreview;
        if (coverPreviewLayout != null) {
            coverPreviewLayout.updateCoverSticker(stickerPosition, stickerPrevPosition);
        }
    }

    public final void updatePagePreview() {
        boolean z = this.mSelectedPreviewType == Constant.PreviewType.PAGE;
        View view = this.mPagePreviewContainer;
        if (view != null) {
            view.setSelected(z);
        }
        TextView textView = this.mPageText;
        if (textView != null) {
            textView.setTextAppearance(!z ? C9086R.style.RobotoRegularStyle : C9086R.style.RobotoMediumStyle);
        }
        DocumentPageRatio.PageRatioType pageRatioType = getPageRatioType();
        View view2 = this.mPagePreviewContainer;
        if (view2 != null) {
            view2.post(new RunnableC8928b(view2, 17, this, pageRatioType));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteStyleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoteStyleLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStyleContainerLayout(float dp) {
        if (isLandscapeLayoutRequired()) {
            return;
        }
        View viewFindViewById = findViewById(C9086R.id.style_container_layout);
        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.topMargin = (int) ResourceUtils.convertDpToPixel(getContext(), dp);
        viewFindViewById.setLayoutParams(marginLayoutParams);
    }
}
