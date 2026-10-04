package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.common.Policy;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.AIAssistPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.AlignmentRecognitionPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.AssistancePolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.CleanUpAndConvertTextPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.ConvertTextPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.DirectWritePolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.EasyWritingPadPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.EmptyPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.EraserPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.HighLighterPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.LaserPenPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.LockCanvasPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.MoveOnlyModePolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.PenPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.RedoPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.SelectionPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.ShapeRecognitionPolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.StylePolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.TextModePolicyCreator;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.policy.creator.UndoPolicyCreator;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HWToolbarPolicyManager {
    private Map<Integer, Policy> mPolicyMap = new HashMap();

    private Policy createPolicy(int i) {
        switch (i) {
            case 2:
                return new PenPolicyCreator().createPolicy();
            case 4:
                return new EraserPolicyCreator().createPolicy();
            case 8:
                return new SelectionPolicyCreator().createPolicy();
            case 16:
                return new StylePolicyCreator().createPolicy();
            case 32:
                return new ConvertTextPolicyCreator().createPolicy();
            case 64:
                return new ShapeRecognitionPolicyCreator().createPolicy();
            case 128:
                return new AlignmentRecognitionPolicyCreator().createPolicy();
            case 256:
                return new UndoPolicyCreator().createPolicy();
            case 512:
                return new RedoPolicyCreator().createPolicy();
            case 1024:
                return new EasyWritingPadPolicyCreator().createPolicy();
            case 2048:
                return new HighLighterPolicyCreator().createPolicy();
            case 4096:
                return new LockCanvasPolicyCreator().createPolicy();
            case 8192:
                return new DirectWritePolicyCreator().createPolicy();
            case 65536:
                return new TextModePolicyCreator().createPolicy();
            case 131072:
                return new AssistancePolicyCreator().createPolicy();
            case 262144:
                return new LaserPenPolicyCreator().createPolicy();
            case 524288:
                return new CleanUpAndConvertTextPolicyCreator().createPolicy();
            case 1048576:
                return new AIAssistPolicyCreator().createPolicy();
            case 2097152:
                return new MoveOnlyModePolicyCreator().createPolicy();
            default:
                return new EmptyPolicyCreator().createPolicy();
        }
    }

    public Policy getPolicy(int i) {
        Policy policy = this.mPolicyMap.get(Integer.valueOf(i));
        return policy == null ? new EmptyPolicyCreator().createPolicy() : policy;
    }

    public void setPolicy(int i) {
        this.mPolicyMap.put(Integer.valueOf(i), createPolicy(i));
    }
}
