package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.util.NotesUtils;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo.NotesHolderInfo;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.NotesHolderUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\"\u0010\u000f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/utils/ThumbnailColorUtils;", "", "<init>", "()V", "setThumbnailColorFilter", "", "imageContentView", "Landroid/widget/ImageView;", "notesHolderInfo", "Lcom/samsung/android/support/senl/nt/app/main/noteslist/adapter/holderinfo/NotesHolderInfo;", "color", "", "getBackgroundColor", "resources", "Landroid/content/res/Resources;", "setSimpleViewBackgroundColor", "isLock", "", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class ThumbnailColorUtils {

    @NotNull
    public static final ThumbnailColorUtils INSTANCE = new ThumbnailColorUtils();

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils$setThumbnailColorFilter$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m13886d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    @DebugMetadata(m14020c = "com.samsung.android.support.senl.nt.app.main.noteslist.adapter.utils.ThumbnailColorUtils$setThumbnailColorFilter$1", m14021f = "ThumbnailColorUtils.kt", m14022i = {}, m14023l = {}, m14024m = "invokeSuspend", m14025n = {}, m14026s = {})
    public static final class C83521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $color;
        final /* synthetic */ ImageView $imageContentView;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83521(ImageView imageView, int i, Continuation<? super C83521> continuation) {
            super(2, continuation);
            this.$imageContentView = imageView;
            this.$color = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C83521(this.$imageContentView, this.$color, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ImageView imageView = this.$imageContentView;
            if (imageView != null) {
                imageView.clearColorFilter();
            }
            ImageView imageView2 = this.$imageContentView;
            if (imageView2 != null) {
                imageView2.setColorFilter(this.$color);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C83521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private ThumbnailColorUtils() {
    }

    @JvmStatic
    public static final int getBackgroundColor(@NotNull NotesHolderInfo notesHolderInfo, @Nullable Resources resources) {
        Intrinsics.checkNotNullParameter(notesHolderInfo, "notesHolderInfo");
        return NotesHolderUtil.getNoteBackgroundColor(resources, notesHolderInfo.hasBackgroundColor(), notesHolderInfo.isSupportInvertedBGColor(), notesHolderInfo.isSdoc(), notesHolderInfo.getBackgroundColor());
    }

    @JvmStatic
    public static final void setSimpleViewBackgroundColor(@Nullable ImageView imageContentView, @NotNull NotesHolderInfo notesHolderInfo, boolean isLock) {
        Intrinsics.checkNotNullParameter(notesHolderInfo, "notesHolderInfo");
        Drawable background = imageContentView != null ? imageContentView.getBackground() : null;
        GradientDrawable gradientDrawable = background instanceof GradientDrawable ? (GradientDrawable) background : null;
        if (gradientDrawable != null) {
            if (isLock) {
                gradientDrawable.setColor(imageContentView.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.basic_list_item_bg_color), null));
            } else {
                gradientDrawable.setColor(getBackgroundColor(notesHolderInfo, imageContentView.getResources()));
            }
        }
    }

    @JvmStatic
    public static final void setThumbnailColorFilter(@NotNull ImageView imageContentView, @NotNull NotesHolderInfo notesHolderInfo) {
        Intrinsics.checkNotNullParameter(imageContentView, "imageContentView");
        Intrinsics.checkNotNullParameter(notesHolderInfo, "notesHolderInfo");
        if (!notesHolderInfo.isSdoc()) {
            if (notesHolderInfo.getBackgroundColor() == imageContentView.getContext().getColor(C8003R.color.composer_main_background_dark) || (notesHolderInfo.isSupportInvertedBGColor() && notesHolderInfo.isDarkMode())) {
                setThumbnailColorFilter(imageContentView, imageContentView.getResources().getColor(NotesUtils.getAntiGreenisFilteredColor(C8003R.color.noteslist_thumbnail_opacity), null));
                return;
            }
            return;
        }
        if (notesHolderInfo.hasOnlyHandwritingSdoc() && notesHolderInfo.getBackgroundColor() == 0 && notesHolderInfo.isDarkMode()) {
            setThumbnailColorFilter(imageContentView, -1);
        } else {
            setThumbnailColorFilter(imageContentView, 0);
        }
    }

    @JvmStatic
    private static final void setThumbnailColorFilter(ImageView imageContentView, int color) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C83521(imageContentView, color, null), 3, null);
    }
}
