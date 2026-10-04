package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout;
import com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener;
import com.samsung.android.spen.C7932R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010*\u0003\u001a\u001d \b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001=B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010&\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010'\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010(\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010)\u001a\u00020#2\u000e\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0016J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00100\u001a\u00020.2\u0006\u00101\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010,H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u00108\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00109\u001a\u00020\bH\u0002J\b\u0010:\u001a\u00020#H\u0002J \u00105\u001a\u00020.2\u0006\u00102\u001a\u00020\b2\u0006\u0010;\u001a\u00020.2\u0006\u0010<\u001a\u00020.H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0010\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R$\u00102\u001a\u00020\b2\u0006\u00102\u001a\u00020\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006>"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel;", "Landroid/widget/FrameLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSetting;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSettingUI;", "Lcom/samsung/android/sdk/pen/setting/SpenFavoritePenSettingUIMode;", "context", "Landroid/content/Context;", "mCurrentMode", "", "mMaxCount", "<init>", "(Landroid/content/Context;II)V", "mFavoritePenLayout", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoritePenLayout;", "mAddButton", "Landroid/view/View;", "mDeleteButton", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteButtonClickListener;", "mModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenFavoriteModeChangedListener;", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteDataChangedListener;", "mViewItemClickListener", "Lcom/samsung/android/sdk/pen/setting/favoritepen/SpenFavoriteViewItemClickListener;", "mOnEventListener", "com/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel$mOnEventListener$1", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel$mOnEventListener$1;", "mFavoriteViewItemClickListener", "com/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel$mFavoriteViewItemClickListener$1", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel$mFavoriteViewItemClickListener$1;", "mFavoriteDataChangedListener", "com/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel$mFavoriteDataChangedListener$1", "Lcom/samsung/android/sdk/pen/setting/SpenSettingFavoritePenPanel$mFavoriteDataChangedListener$1;", "close", "", "setOnButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnViewItemClickListener", "setModeChangedListener", "setFavoriteDataChangedListener", "setFavoriteList", XmlErrorCodes.LIST, "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "addFavorite", "", "info", "updateFavorite", "index", "mode", "getMode", "()I", "setMode", "(I)V", "construct", "initView", "maxCount", "initButtons", "updateIfNotChanged", "isNeedAnimation", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenSettingFavoritePenPanel extends FrameLayout implements SpenFavoritePenSetting, SpenFavoritePenSettingUI, SpenFavoritePenSettingUIMode {

    @NotNull
    private static final String TAG = "SpenSettingFavoritePenPanel";
    private View mAddButton;

    @Nullable
    private SpenFavoriteButtonClickListener mButtonClickListener;
    private int mCurrentMode;

    @Nullable
    private SpenFavoriteDataChangedListener mDataChangedListener;
    private View mDeleteButton;

    @NotNull
    private final SpenSettingFavoritePenPanel$mFavoriteDataChangedListener$1 mFavoriteDataChangedListener;
    private SpenFavoritePenLayout mFavoritePenLayout;

    @NotNull
    private final SpenSettingFavoritePenPanel$mFavoriteViewItemClickListener$1 mFavoriteViewItemClickListener;
    private final int mMaxCount;

    @Nullable
    private SpenFavoriteModeChangedListener mModeChangedListener;

    @NotNull
    private final SpenSettingFavoritePenPanel$mOnEventListener$1 mOnEventListener;

    @Nullable
    private SpenFavoriteViewItemClickListener mViewItemClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenPanel$mOnEventListener$1] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenPanel$mFavoriteViewItemClickListener$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenPanel$mFavoriteDataChangedListener$1] */
    public SpenSettingFavoritePenPanel(@NotNull Context context, int i, int i2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentMode = i;
        this.mMaxCount = i2;
        this.mOnEventListener = new SpenFavoritePenLayout.OnEventListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenPanel$mOnEventListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout.OnEventListener
            public void onEditComplete(boolean isDone) {
                AbstractC4539a.m3208r("onEditComplete() isDone=", "SpenSettingFavoritePenPanel", isDone);
                this.this$0.setMode(1, true, true);
                SpenFavoriteButtonClickListener spenFavoriteButtonClickListener = this.this$0.mButtonClickListener;
                if (spenFavoriteButtonClickListener != null) {
                    if (isDone) {
                        spenFavoriteButtonClickListener.onButtonClick(4);
                    } else {
                        spenFavoriteButtonClickListener.onButtonClick(5);
                    }
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenLayout.OnEventListener
            public void onAddItemClick() {
            }
        };
        this.mFavoriteViewItemClickListener = new SpenFavoriteViewItemClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenPanel$mFavoriteViewItemClickListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteViewItemClickListener
            public void onViewItemClick(SpenSettingUIPenInfo info) {
                Intrinsics.checkNotNullParameter(info, "info");
                SpenFavoriteViewItemClickListener spenFavoriteViewItemClickListener = this.this$0.mViewItemClickListener;
                if (spenFavoriteViewItemClickListener != null) {
                    spenFavoriteViewItemClickListener.onViewItemClick(info);
                }
            }
        };
        this.mFavoriteDataChangedListener = new SpenFavoriteDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingFavoritePenPanel$mFavoriteDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteDataChangedListener
            public void onFavoriteDataChanged(List<SpenSettingUIPenInfo> list) {
                Log.i("SpenSettingFavoritePenPanel", "onFavoriteDataChanged() size=" + (list != null ? Integer.valueOf(list.size()) : null));
                SpenFavoriteDataChangedListener spenFavoriteDataChangedListener = this.this$0.mDataChangedListener;
                if (spenFavoriteDataChangedListener != null) {
                    spenFavoriteDataChangedListener.onFavoriteDataChanged(list);
                }
                SpenSettingFavoritePenPanel spenSettingFavoritePenPanel = this.this$0;
                spenSettingFavoritePenPanel.setMode(spenSettingFavoritePenPanel.mCurrentMode, false, false);
            }
        };
        construct(context);
    }

    private final void construct(Context context) {
        initView(context, this.mMaxCount);
        initButtons();
    }

    private final void initButtons() {
        View viewFindViewById = findViewById(C7932R.id.add_icon);
        this.mAddButton = viewFindViewById;
        View view = null;
        if (viewFindViewById == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddButton");
            viewFindViewById = null;
        }
        final int i = 0;
        viewFindViewById.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSettingFavoritePenPanel f5052b;

            {
                this.f5052b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i) {
                    case 0:
                        SpenSettingFavoritePenPanel.initButtons$lambda$1(this.f5052b, view2);
                        break;
                    default:
                        SpenSettingFavoritePenPanel.initButtons$lambda$2(this.f5052b, view2);
                        break;
                }
            }
        });
        View viewFindViewById2 = findViewById(C7932R.id.delete_icon);
        this.mDeleteButton = viewFindViewById2;
        if (viewFindViewById2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDeleteButton");
        } else {
            view = viewFindViewById2;
        }
        final int i2 = 1;
        view.setOnClickListener(new View.OnClickListener(this) { // from class: com.samsung.android.sdk.pen.setting.f

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ SpenSettingFavoritePenPanel f5052b;

            {
                this.f5052b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i2) {
                    case 0:
                        SpenSettingFavoritePenPanel.initButtons$lambda$1(this.f5052b, view2);
                        break;
                    default:
                        SpenSettingFavoritePenPanel.initButtons$lambda$2(this.f5052b, view2);
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$1(SpenSettingFavoritePenPanel spenSettingFavoritePenPanel, View view) {
        SpenFavoriteButtonClickListener spenFavoriteButtonClickListener = spenSettingFavoritePenPanel.mButtonClickListener;
        if (spenFavoriteButtonClickListener != null) {
            spenFavoriteButtonClickListener.onButtonClick(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initButtons$lambda$2(SpenSettingFavoritePenPanel spenSettingFavoritePenPanel, View view) {
        spenSettingFavoritePenPanel.mCurrentMode = 2;
        SpenFavoriteButtonClickListener spenFavoriteButtonClickListener = spenSettingFavoritePenPanel.mButtonClickListener;
        if (spenFavoriteButtonClickListener != null) {
            spenFavoriteButtonClickListener.onButtonClick(3);
        }
    }

    private final void initView(Context context, int maxCount) {
        View.inflate(context, C7932R.layout.setting_favorite_panel, this);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(C7932R.id.favorite_pen_list);
        SpenFavoritePenLayout spenFavoritePenLayout = null;
        this.mFavoritePenLayout = new SpenFavoritePenLayout(context, this.mCurrentMode, maxCount, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        SpenFavoritePenLayout spenFavoritePenLayout2 = this.mFavoritePenLayout;
        if (spenFavoritePenLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
            spenFavoritePenLayout2 = null;
        }
        relativeLayout.addView(spenFavoritePenLayout2, layoutParams);
        SpenFavoritePenLayout spenFavoritePenLayout3 = this.mFavoritePenLayout;
        if (spenFavoritePenLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
        } else {
            spenFavoritePenLayout = spenFavoritePenLayout3;
        }
        spenFavoritePenLayout.setAddButtonEnabled(false);
        spenFavoritePenLayout.setPanelModeEnabled(true);
        spenFavoritePenLayout.setOnEventListener(this.mOnEventListener);
        spenFavoritePenLayout.setOnViewItemClickListener(this.mFavoriteViewItemClickListener);
        spenFavoritePenLayout.setFavoriteDataChangedListener(this.mFavoriteDataChangedListener);
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean addFavorite(@Nullable SpenSettingUIPenInfo info) {
        AbstractC2322a.m1631u(this.mCurrentMode, "addFavorite() mode=", TAG);
        if (this.mCurrentMode != 1) {
            return false;
        }
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoritePenLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
            spenFavoritePenLayout = null;
        }
        if (spenFavoritePenLayout.addFavorite(info)) {
            setMode(this.mCurrentMode, true, false);
        }
        return true;
    }

    public final void close() {
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoritePenLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
            spenFavoritePenLayout = null;
        }
        spenFavoritePenLayout.close();
        this.mButtonClickListener = null;
        this.mViewItemClickListener = null;
        this.mModeChangedListener = null;
        this.mDataChangedListener = null;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    /* JADX INFO: renamed from: getMode, reason: from getter */
    public int getMCurrentMode() {
        return this.mCurrentMode;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteDataChangedListener(@Nullable SpenFavoriteDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public void setFavoriteList(@Nullable List<SpenSettingUIPenInfo> list) {
        String strValueOf = list != null ? Integer.valueOf(list.size()) : "NULL";
        Log.i(TAG, "setFavoriteList() list=" + strValueOf + " mode=" + this.mCurrentMode);
        if (this.mCurrentMode == 1) {
            SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoritePenLayout;
            if (spenFavoritePenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
                spenFavoritePenLayout = null;
            }
            spenFavoritePenLayout.setFavoriteList(list);
            setMode(this.mCurrentMode, true, false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoritePenMode
    public void setMode(int i) {
        SpenFavoriteModeChangedListener spenFavoriteModeChangedListener;
        AbstractC6670b.m4744e(i, this.mCurrentMode, "setMode() mode=", " current=", TAG);
        if (!setMode(i, false, false) || (spenFavoriteModeChangedListener = this.mModeChangedListener) == null) {
            return;
        }
        spenFavoriteModeChangedListener.onModeChanged(this.mCurrentMode);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenSettingUIMode
    public void setModeChangedListener(@Nullable SpenFavoriteModeChangedListener listener) {
        this.mModeChangedListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenSettingUI
    public void setOnButtonClickListener(@Nullable SpenFavoriteButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenFavoritePenSettingUI
    public void setOnViewItemClickListener(@Nullable SpenFavoriteViewItemClickListener listener) {
        this.mViewItemClickListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.favoritepen.SpenFavoriteData
    public boolean updateFavorite(int index, @Nullable SpenSettingUIPenInfo info) {
        AbstractC2322a.m1631u(this.mCurrentMode, "updateFavorite() mode=", TAG);
        if (this.mCurrentMode != 1) {
            return false;
        }
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoritePenLayout;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
            spenFavoritePenLayout = null;
        }
        return spenFavoritePenLayout.updateFavorite(index, info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean setMode(int mode, boolean updateIfNotChanged, boolean isNeedAnimation) {
        StringBuilder sbM1173s = AbstractC0622a.m1173s(mode, this.mCurrentMode, "setMode() mode=", " current=", " updateIfNotChanged=");
        sbM1173s.append(updateIfNotChanged);
        sbM1173s.append(" isNeedAnimation= ");
        sbM1173s.append(isNeedAnimation);
        Log.i(TAG, sbM1173s.toString());
        boolean z = mode != this.mCurrentMode;
        if (!z && !updateIfNotChanged) {
            return z;
        }
        this.mCurrentMode = mode;
        SpenFavoritePenLayout spenFavoritePenLayout = this.mFavoritePenLayout;
        SpenFavoritePenLayout spenFavoritePenLayout2 = null;
        if (spenFavoritePenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
            spenFavoritePenLayout = null;
        }
        spenFavoritePenLayout.setShowAnimation(isNeedAnimation);
        SpenFavoritePenLayout spenFavoritePenLayout3 = this.mFavoritePenLayout;
        if (spenFavoritePenLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFavoritePenLayout");
        } else {
            spenFavoritePenLayout2 = spenFavoritePenLayout3;
        }
        spenFavoritePenLayout2.setMode(this.mCurrentMode);
        return z;
    }
}
