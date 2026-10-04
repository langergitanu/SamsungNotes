package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import com.google.android.material.oneui.floatingdock.C4797h;
import com.samsung.android.sdk.smp.SmpConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p145cm.base.framework.view.ViewCompat;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.util.CharUtils;
import com.samsung.android.support.senl.p148nt.base.winset.util.ButtonShapeUtil;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.RunnableC9844c;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u0000 E2\u00020\u0001:\u0001EB\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\u0006\u0010+\u001a\u00020$J\b\u0010,\u001a\u00020$H\u0002J\u000e\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020\"J\u000e\u0010/\u001a\u00020$2\u0006\u00100\u001a\u000201J\u0006\u00102\u001a\u00020$J\u0006\u00103\u001a\u00020$J\u000e\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\"J\u001e\u00106\u001a\u00020$2\u0006\u00107\u001a\u0002012\u0006\u00108\u001a\u0002012\u0006\u00109\u001a\u000201J\u000e\u0010:\u001a\u00020$2\u0006\u00100\u001a\u000201J\u0006\u0010;\u001a\u00020$J\u0018\u0010<\u001a\u00020$2\u0006\u0010.\u001a\u00020\"2\u0006\u0010=\u001a\u000201H\u0002J\u0010\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u000201H\u0002J\u000e\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020\"J\u0006\u0010B\u001a\u00020$J\u0006\u0010C\u001a\u00020$R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010(\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0011\u0010D\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bD\u0010)¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/VoiceRecordExpandOptionMenu;", "", "mActivity", "Landroid/app/Activity;", "mPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;", "<init>", "(Landroid/app/Activity;Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuPresenter;)V", "mPlayListContainer", "Landroid/view/View;", "mRecordLisTitleView", "Landroid/widget/TextView;", "mRecordingListDivider", "Landroid/widget/ImageView;", "mShareButton", "mTrashButton", "mItemMoreButton", "mEditMoreButton", "mSTTConvertButton", "mRenameButton", "mEditShareButton", "Landroid/widget/Button;", "mSelectAll", "Landroid/widget/CheckBox;", "mSelectAllText", "mSelectAllContainer", "mOptionPopupMenu", "Landroidx/appcompat/widget/PopupMenu;", "value", "Landroid/widget/PopupWindow;", SmpConstants.MARKETING_TYPE_POPUP, "getPopup", "()Landroid/widget/PopupWindow;", "initPopupWindow", "", "initOptionView", "", "setToolTipText", "initClickListener", "onEditMoreClick", "isUserSkip", "()Z", "setMaxFontSize", "hidePopUpMenu", "showOptionMenu", "changeMode", "isEditMode", "showEditView", "selectedItem", "", "hideEditView", "initRecordingList", "setListContainerVisibility", "visible", "updateBackground", "textIconColor", "bgColor", "dividerColor", "updateSelectedItemText", "updateView", "updateOptionButtons", "selectedItemCount", "setSTTBtnVisibility", "isVisibility", "updateSelectAll", "selectMode", "showPopUp", "hidePopup", "isShowing", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordExpandOptionMenu {

    @NotNull
    private static final String TAG;

    @Nullable
    private final Activity mActivity;

    @Nullable
    private ImageView mEditMoreButton;

    @Nullable
    private Button mEditShareButton;

    @Nullable
    private ImageView mItemMoreButton;

    @Nullable
    private PopupMenu mOptionPopupMenu;

    @Nullable
    private View mPlayListContainer;

    @NotNull
    private final VoiceRecordMenuPresenter mPresenter;

    @Nullable
    private TextView mRecordLisTitleView;

    @Nullable
    private ImageView mRecordingListDivider;

    @Nullable
    private ImageView mRenameButton;

    @Nullable
    private ImageView mSTTConvertButton;

    @Nullable
    private CheckBox mSelectAll;

    @Nullable
    private View mSelectAllContainer;

    @Nullable
    private TextView mSelectAllText;

    @Nullable
    private ImageView mShareButton;

    @Nullable
    private ImageView mTrashButton;

    @Nullable
    private PopupWindow popup;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordExpandOptionMenu");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    public VoiceRecordExpandOptionMenu(@Nullable Activity activity, @NotNull VoiceRecordMenuPresenter mPresenter) {
        Intrinsics.checkNotNullParameter(mPresenter, "mPresenter");
        this.mActivity = activity;
        this.mPresenter = mPresenter;
    }

    private final void initClickListener() {
        ImageView imageView = this.mShareButton;
        if (imageView != null) {
            final int i = 3;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        ImageView imageView2 = this.mTrashButton;
        if (imageView2 != null) {
            final int i2 = 4;
            imageView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i2) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        ImageView imageView3 = this.mItemMoreButton;
        if (imageView3 != null) {
            final int i4 = 5;
            imageView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i4) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        Button button = this.mEditShareButton;
        if (button != null) {
            final int i5 = 6;
            button.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i5) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        ImageView imageView4 = this.mRenameButton;
        if (imageView4 != null) {
            final int i6 = 7;
            imageView4.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i6) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        ImageView imageView5 = this.mSTTConvertButton;
        if (imageView5 != null) {
            final int i7 = 0;
            imageView5.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i7) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        CheckBox checkBox = this.mSelectAll;
        if (checkBox != null) {
            final int i8 = 1;
            checkBox.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i8) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
        ImageView imageView6 = this.mEditMoreButton;
        if (imageView6 != null) {
            final int i9 = 2;
            imageView6.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.g

                /* JADX INFO: renamed from: b */
                public final /* synthetic */ VoiceRecordExpandOptionMenu f7301b;

                {
                    this.f7301b = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    switch (i9) {
                        case 0:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$6(this.f7301b, view);
                            break;
                        case 1:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$7(this.f7301b, view);
                            break;
                        case 2:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$8(this.f7301b, view);
                            break;
                        case 3:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$1(this.f7301b, view);
                            break;
                        case 4:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$2(this.f7301b, view);
                            break;
                        case 5:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$3(this.f7301b, view);
                            break;
                        case 6:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$4(this.f7301b, view);
                            break;
                        default:
                            VoiceRecordExpandOptionMenu.initClickListener$lambda$5(this.f7301b, view);
                            break;
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$1(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (!voiceRecordExpandOptionMenu.isUserSkip() || voiceRecordExpandOptionMenu.mPresenter.isDeleted()) {
            return;
        }
        voiceRecordExpandOptionMenu.mPresenter.onShareClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$2(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.isUserSkip()) {
            voiceRecordExpandOptionMenu.mPresenter.showDeleteConfirmDialog(voiceRecordExpandOptionMenu.mTrashButton);
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_RECORDING, ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_DELETE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$3(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.mPresenter.isDeleted()) {
            return;
        }
        voiceRecordExpandOptionMenu.showOptionMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$4(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.isUserSkip()) {
            voiceRecordExpandOptionMenu.mPresenter.onEditClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$5(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.isUserSkip()) {
            voiceRecordExpandOptionMenu.mPresenter.onRenameClick(voiceRecordExpandOptionMenu.mRenameButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$6(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.isUserSkip()) {
            voiceRecordExpandOptionMenu.mPresenter.convertSelectedVoiceList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$7(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (view instanceof CheckBox) {
            voiceRecordExpandOptionMenu.mPresenter.checkAllItem(((CheckBox) view).isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initClickListener$lambda$8(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.mPresenter.isDeleted()) {
            return;
        }
        voiceRecordExpandOptionMenu.onEditMoreClick();
    }

    private final void initOptionView() {
        View contentView;
        PopupWindow popupWindow;
        LayoutInflater layoutInflater;
        Activity activity = this.mActivity;
        PopupWindow popupWindow2 = new PopupWindow((activity == null || (layoutInflater = activity.getLayoutInflater()) == null) ? null : layoutInflater.inflate(C9086R.layout.comp_voice_record_list, (ViewGroup) null), -2, -2);
        this.popup = popupWindow2;
        popupWindow2.setTouchable(true);
        if (!DeviceInfo.isVSTModel() && (popupWindow = this.popup) != null) {
            popupWindow.setOutsideTouchable(true);
        }
        PopupWindow popupWindow3 = this.popup;
        if (popupWindow3 != null) {
            popupWindow3.setClippingEnabled(true);
        }
        PopupWindow popupWindow4 = this.popup;
        if (popupWindow4 != null) {
            popupWindow4.setFocusable(true);
        }
        PopupWindow popupWindow5 = this.popup;
        if (popupWindow5 != null) {
            popupWindow5.setInputMethodMode(2);
        }
        PopupWindow popupWindow6 = this.popup;
        if (popupWindow6 != null) {
            popupWindow6.setOverlapAnchor(true);
        }
        PopupWindow popupWindow7 = this.popup;
        if (popupWindow7 != null) {
            popupWindow7.setAnimationStyle(C9086R.style.MorePopupEnterExitAnimation);
        }
        PopupWindow popupWindow8 = this.popup;
        if (popupWindow8 != null) {
            popupWindow8.setOnDismissListener(new C4797h(this, 3));
        }
        PopupWindow popupWindow9 = this.popup;
        View viewFindViewById = (popupWindow9 == null || (contentView = popupWindow9.getContentView()) == null) ? null : contentView.findViewById(C9086R.id.voice_record_list_container);
        this.mPlayListContainer = viewFindViewById;
        this.mRecordLisTitleView = viewFindViewById != null ? (TextView) viewFindViewById.findViewById(C9086R.id.voice_record_list_title) : null;
        View view = this.mPlayListContainer;
        ImageView imageView = view != null ? (ImageView) view.findViewById(C9086R.id.voice_item_list_divider) : null;
        this.mRecordingListDivider = imageView;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view2 = this.mPlayListContainer;
        this.mShareButton = view2 != null ? (ImageView) view2.findViewById(C9086R.id.voice_record_share) : null;
        View view3 = this.mPlayListContainer;
        this.mTrashButton = view3 != null ? (ImageView) view3.findViewById(C9086R.id.voice_record_trash) : null;
        View view4 = this.mPlayListContainer;
        this.mItemMoreButton = view4 != null ? (ImageView) view4.findViewById(C9086R.id.voice_record_more) : null;
        View view5 = this.mPlayListContainer;
        this.mEditShareButton = view5 != null ? (Button) view5.findViewById(C9086R.id.voice_record_edit_share) : null;
        View view6 = this.mPlayListContainer;
        this.mSTTConvertButton = view6 != null ? (ImageView) view6.findViewById(C9086R.id.voice_record_stt_convert) : null;
        View view7 = this.mPlayListContainer;
        this.mRenameButton = view7 != null ? (ImageView) view7.findViewById(C9086R.id.voice_record_rename) : null;
        View view8 = this.mPlayListContainer;
        this.mSelectAll = view8 != null ? (CheckBox) view8.findViewById(C9086R.id.voice_record_list_select_all_checkbox) : null;
        View view9 = this.mPlayListContainer;
        this.mSelectAllContainer = view9 != null ? view9.findViewById(C9086R.id.voice_record_list_select_all) : null;
        View view10 = this.mPlayListContainer;
        this.mSelectAllText = view10 != null ? (TextView) view10.findViewById(C9086R.id.voice_record_list_select_all_text) : null;
        View view11 = this.mPlayListContainer;
        this.mEditMoreButton = view11 != null ? (ImageView) view11.findViewById(C9086R.id.voice_record_edit_more) : null;
        ButtonShapeUtil.setButtonShapeEnabled(this.mEditShareButton);
        updateView();
        setToolTipText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initOptionView$lambda$0(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu) {
        voiceRecordExpandOptionMenu.mPresenter.hideRecordingListView();
        voiceRecordExpandOptionMenu.mPresenter.hideDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecordingList$lambda$13(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu) {
        View view = voiceRecordExpandOptionMenu.mSelectAllContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private final boolean isUserSkip() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.VoiceRecorder;
        if (!UserInputSkipper.isValidSingleActionEvent(false, tag)) {
            return false;
        }
        UserInputSkipper.setHoldingSingleActionEventTime(300L, tag);
        return true;
    }

    private final void onEditMoreClick() {
        ImageView imageView;
        this.mPresenter.clearSelectionObject();
        Activity activity = this.mActivity;
        if (activity == null || (imageView = this.mEditMoreButton) == null) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(activity, imageView);
        popupMenu.inflate(C9086R.menu.composer_voice_more_edit_menu);
        popupMenu.setOnMenuItemClickListener(new C10882h(this, 1));
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onEditMoreClick$lambda$9(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C9086R.id.action_voice_delete) {
            voiceRecordExpandOptionMenu.mPresenter.showDeleteConfirmDialog(voiceRecordExpandOptionMenu.mTrashButton);
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_RECORDING, ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_DELETE);
        } else {
            if (itemId != C9086R.id.action_voice_save_to_device) {
                return false;
            }
            voiceRecordExpandOptionMenu.mPresenter.saveToDevice(true);
        }
        return true;
    }

    private final void setMaxFontSize() {
        Activity activity = this.mActivity;
        if (activity != null) {
            CharUtils.applyTextSizeUntilLargeSize(activity, this.mEditShareButton, activity.getResources().getInteger(C9086R.integer.voice_record_text_size));
        }
    }

    private final void setSTTBtnVisibility(int isVisibility) {
        ImageView imageView;
        if (!FeatureInfo.isSupportSTTFunction() || (imageView = this.mSTTConvertButton) == null) {
            return;
        }
        imageView.setVisibility(isVisibility);
    }

    private final void setToolTipText() {
        ViewCompat.Companion companion = ViewCompat.INSTANCE;
        companion.getInstance().setTooltipText(this.mShareButton);
        companion.getInstance().setTooltipText(this.mTrashButton);
        companion.getInstance().setTooltipText(this.mItemMoreButton);
        companion.getInstance().setTooltipText(this.mSTTConvertButton);
        companion.getInstance().setTooltipText(this.mRenameButton);
        companion.getInstance().setTooltipText(this.mEditMoreButton);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEditView$lambda$12(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu) {
        View view = voiceRecordExpandOptionMenu.mSelectAllContainer;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private final void showOptionMenu() {
        ImageView imageView;
        MenuItem menuItemFindItem;
        MenuItem menuItemFindItem2;
        MenuItem menuItemFindItem3;
        MenuItem menuItemFindItem4;
        Activity activity = this.mActivity;
        if (activity == null || (imageView = this.mItemMoreButton) == null) {
            return;
        }
        this.mPresenter.clearSelectionObject();
        PopupMenu popupMenu = new PopupMenu(activity, imageView);
        this.mOptionPopupMenu = popupMenu;
        popupMenu.inflate(C9086R.menu.composer_voice_more_menu);
        PopupMenu popupMenu2 = this.mOptionPopupMenu;
        if (popupMenu2 != null) {
            popupMenu2.setOnMenuItemClickListener(new C10882h(this, 0));
        }
        PopupMenu popupMenu3 = this.mOptionPopupMenu;
        Menu menu = popupMenu3 != null ? popupMenu3.getMenu() : null;
        if (this.mPresenter.getSyncOption()) {
            if (menu != null && (menuItemFindItem4 = menu.findItem(C9086R.id.action_note_replay)) != null) {
                menuItemFindItem4.setVisible(false);
            }
            if (menu != null && (menuItemFindItem3 = menu.findItem(C9086R.id.action_recording_replay)) != null) {
                menuItemFindItem3.setVisible(true);
            }
        } else {
            if (menu != null && (menuItemFindItem2 = menu.findItem(C9086R.id.action_recording_replay)) != null) {
                menuItemFindItem2.setVisible(false);
            }
            if (menu != null && (menuItemFindItem = menu.findItem(C9086R.id.action_note_replay)) != null) {
                menuItemFindItem.setVisible(true);
            }
        }
        PopupMenu popupMenu4 = this.mOptionPopupMenu;
        if (popupMenu4 != null) {
            popupMenu4.show();
        }
        Logger.m11003i(TAG, "showOptionMenu");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showOptionMenu$lambda$11(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, MenuItem menuItem) {
        boolean z = menuItem.getItemId() != C9086R.id.action_recording_replay;
        voiceRecordExpandOptionMenu.mPresenter.changeSyncOption(z);
        ComposerSA.insertLog(voiceRecordExpandOptionMenu.mPresenter.isEditMode() ? ComposerSAConstants.SCREEN_RECORDING : ComposerSAConstants.SCREEN_VIEW_303, voiceRecordExpandOptionMenu.mPresenter.isEditMode() ? ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_REPLAY : ComposerSAConstants.EVENT_VOICE_VIEW_PANEL_REPLAY, z ? "a" : "b");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPopUp$lambda$15(VoiceRecordExpandOptionMenu voiceRecordExpandOptionMenu, View view) {
        if (voiceRecordExpandOptionMenu.mActivity.isFinishing() || voiceRecordExpandOptionMenu.mActivity.isDestroyed()) {
            return;
        }
        int i = -voiceRecordExpandOptionMenu.mActivity.getResources().getDimensionPixelSize(C9086R.dimen.voice_recording_list_layout_margin_end);
        int height = view.getHeight();
        PopupWindow popupWindow = voiceRecordExpandOptionMenu.popup;
        if (popupWindow != null) {
            popupWindow.showAsDropDown(view, i, height, 8388613);
        }
    }

    private final void updateOptionButtons(boolean isEditMode, int selectedItemCount) {
        setSTTBtnVisibility(8);
        if (selectedItemCount == 0) {
            ImageView imageView = this.mShareButton;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.mRenameButton;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = this.mTrashButton;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
            ImageView imageView4 = this.mEditMoreButton;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
                return;
            }
            return;
        }
        if (selectedItemCount != 1) {
            ImageView imageView5 = this.mShareButton;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
            ImageView imageView6 = this.mRenameButton;
            if (imageView6 != null) {
                imageView6.setVisibility(8);
            }
            if (isEditMode) {
                ImageView imageView7 = this.mEditMoreButton;
                if (imageView7 != null) {
                    imageView7.setVisibility(8);
                }
                ImageView imageView8 = this.mTrashButton;
                if (imageView8 != null) {
                    imageView8.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView9 = this.mTrashButton;
            if (imageView9 != null) {
                imageView9.setVisibility(8);
            }
            ImageView imageView10 = this.mEditMoreButton;
            if (imageView10 != null) {
                imageView10.setVisibility(8);
                return;
            }
            return;
        }
        ImageView imageView11 = this.mShareButton;
        if (imageView11 != null) {
            imageView11.setVisibility(0);
        }
        if (isEditMode) {
            ImageView imageView12 = this.mRenameButton;
            if (imageView12 != null) {
                imageView12.setVisibility(0);
            }
            ImageView imageView13 = this.mEditMoreButton;
            if (imageView13 != null) {
                imageView13.setVisibility(8);
            }
            ImageView imageView14 = this.mTrashButton;
            if (imageView14 != null) {
                imageView14.setVisibility(0);
                return;
            }
            return;
        }
        ImageView imageView15 = this.mRenameButton;
        if (imageView15 != null) {
            imageView15.setVisibility(8);
        }
        ImageView imageView16 = this.mTrashButton;
        if (imageView16 != null) {
            imageView16.setVisibility(8);
        }
        ImageView imageView17 = this.mEditMoreButton;
        if (imageView17 != null) {
            imageView17.setVisibility(8);
        }
    }

    public final void changeMode(boolean isEditMode) {
        if (isEditMode) {
            Button button = this.mEditShareButton;
            if (button != null) {
                Activity activity = this.mActivity;
                button.setText(activity != null ? activity.getString(C9086R.string.action_edit) : null);
            }
        } else {
            Button button2 = this.mEditShareButton;
            if (button2 != null) {
                Activity activity2 = this.mActivity;
                button2.setText(activity2 != null ? activity2.getString(C9086R.string.composer_ctx_menu_share) : null);
            }
        }
        if (this.mPresenter.getSelectMode()) {
            updateOptionButtons(isEditMode, this.mPresenter.getSelectListSize());
        }
    }

    @Nullable
    public final PopupWindow getPopup() {
        return this.popup;
    }

    public final void hideEditView() {
        initRecordingList();
        ImageView imageView = this.mItemMoreButton;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        PopupWindow popupWindow = this.popup;
        if (popupWindow != null) {
            popupWindow.setFocusable(true);
        }
    }

    public final void hidePopUpMenu() {
        PopupMenu popupMenu = this.mOptionPopupMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    public final void hidePopup() {
        PopupWindow popupWindow;
        if (isShowing() && (popupWindow = this.popup) != null) {
            popupWindow.dismiss();
        }
    }

    public final boolean initPopupWindow() {
        if (this.popup != null) {
            hidePopup();
            return true;
        }
        initOptionView();
        initClickListener();
        setMaxFontSize();
        return false;
    }

    public final void initRecordingList() {
        TextView textView = this.mRecordLisTitleView;
        if (textView != null) {
            Activity activity = this.mActivity;
            textView.setText(activity != null ? activity.getString(C9086R.string.composer_voice_record_recording_list) : null);
        }
        Button button = this.mEditShareButton;
        if (button != null) {
            button.setVisibility(0);
        }
        ImageView imageView = this.mItemMoreButton;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.mRenameButton;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.mSTTConvertButton;
        if (imageView3 != null) {
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = this.mShareButton;
        if (imageView4 != null) {
            imageView4.setVisibility(8);
        }
        ImageView imageView5 = this.mTrashButton;
        if (imageView5 != null) {
            imageView5.setVisibility(8);
        }
        ImageView imageView6 = this.mEditMoreButton;
        if (imageView6 != null) {
            imageView6.setVisibility(8);
        }
        View view = this.mSelectAllContainer;
        if (view != null) {
            view.post(new RunnableC10880f(this, 1));
        }
    }

    public final boolean isShowing() {
        PopupWindow popupWindow = this.popup;
        return popupWindow != null && popupWindow.isShowing();
    }

    public final void setListContainerVisibility(boolean visible) {
        View view = this.mPlayListContainer;
        if (view != null) {
            view.setVisibility(visible ? 0 : 8);
        }
    }

    public final void showEditView(int selectedItem) {
        updateSelectedItemText(selectedItem);
        View view = this.mSelectAllContainer;
        if (view != null) {
            view.post(new RunnableC10880f(this, 0));
        }
        Button button = this.mEditShareButton;
        if (button != null) {
            button.setVisibility(8);
        }
        ImageView imageView = this.mItemMoreButton;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.mPresenter.setViewStateType(VoiceViewState.Type.EDIT);
        PopupWindow popupWindow = this.popup;
        if (popupWindow != null) {
            popupWindow.setFocusable(false);
        }
    }

    public final void showPopUp() {
        hidePopup();
        Activity activity = this.mActivity;
        View viewFindViewById = activity != null ? activity.findViewById(C9086R.id.voice_menu_expand_simple) : null;
        if (viewFindViewById != null) {
            viewFindViewById.post(new RunnableC9844c(this, viewFindViewById, 28));
        }
    }

    public final void updateBackground(int textIconColor, int bgColor, int dividerColor) {
        ImageView imageView = this.mShareButton;
        if (imageView != null) {
            imageView.setColorFilter(textIconColor);
        }
        ImageView imageView2 = this.mTrashButton;
        if (imageView2 != null) {
            imageView2.setColorFilter(textIconColor);
        }
        ImageView imageView3 = this.mItemMoreButton;
        if (imageView3 != null) {
            imageView3.setColorFilter(textIconColor);
        }
        ImageView imageView4 = this.mRenameButton;
        if (imageView4 != null) {
            imageView4.setColorFilter(textIconColor);
        }
        ImageView imageView5 = this.mSTTConvertButton;
        if (imageView5 != null) {
            imageView5.setColorFilter(textIconColor);
        }
        ImageView imageView6 = this.mEditMoreButton;
        if (imageView6 != null) {
            imageView6.setColorFilter(textIconColor);
        }
        TextView textView = this.mRecordLisTitleView;
        if (textView != null) {
            textView.setTextColor(textIconColor);
        }
        Button button = this.mEditShareButton;
        if (button != null) {
            button.setTextColor(textIconColor);
        }
        ImageView imageView7 = this.mRecordingListDivider;
        if (imageView7 != null) {
            imageView7.setBackgroundColor(dividerColor);
        }
        TextView textView2 = this.mSelectAllText;
        if (textView2 != null) {
            textView2.setTextColor(textIconColor);
        }
        if (this.mActivity != null) {
            View view = this.mPlayListContainer;
            GradientDrawable gradientDrawable = (GradientDrawable) (view != null ? view.getBackground() : null);
            if (this.mPresenter.isBackgroundDarkTheme()) {
                bgColor = ContextCompat.getColor(this.mActivity, C9086R.color.composer_voice_menu_list_dark_background);
            }
            if (gradientDrawable != null) {
                gradientDrawable.setColor(bgColor);
            }
            View view2 = this.mPlayListContainer;
            if (view2 != null) {
                view2.setBackground(gradientDrawable);
            }
        }
    }

    public final void updateSelectAll(boolean selectMode) {
        if (selectMode) {
            return;
        }
        CheckBox checkBox = this.mSelectAll;
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        CheckBox checkBox2 = this.mSelectAll;
        if (checkBox2 != null) {
            checkBox2.jumpDrawablesToCurrentState();
        }
    }

    public final void updateSelectedItemText(int selectedItem) {
        CheckBox checkBox;
        TextView textView = this.mRecordLisTitleView;
        if (textView != null) {
            Activity activity = this.mActivity;
            textView.setText(activity != null ? activity.getString(C9086R.string.selected_check_info, Integer.valueOf(selectedItem)) : null);
        }
        CheckBox checkBox2 = this.mSelectAll;
        boolean z = false;
        if (checkBox2 != null && checkBox2.isChecked()) {
            z = true;
        }
        int size = this.mPresenter.getItemList().size();
        boolean zIsEditMode = this.mPresenter.isEditMode();
        if (((z && selectedItem != size) || (!z && selectedItem == size)) && (checkBox = this.mSelectAll) != null) {
            checkBox.toggle();
        }
        updateOptionButtons(zIsEditMode, selectedItem);
    }

    public final void updateView() {
        if (this.mPresenter.isNotSupportedRecording()) {
            CoeditState coeditState = CoeditState.INSTANCE;
            coeditState.setDisable(this.mRenameButton);
            coeditState.setDisable(this.mSTTConvertButton);
        }
    }
}
