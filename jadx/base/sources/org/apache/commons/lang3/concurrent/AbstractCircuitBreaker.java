package org.apache.commons.lang3.concurrent;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractCircuitBreaker<T> implements CircuitBreaker<T> {
    public static final String PROPERTY_NAME = "open";
    protected final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum State {
        CLOSED { // from class: org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.1
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return State.OPEN;
            }
        },
        OPEN { // from class: org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State.2
            @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker.State
            public State oppositeState() {
                return State.CLOSED;
            }
        };

        public abstract State oppositeState();
    }

    public static boolean isOpen(State state) {
        return state == State.OPEN;
    }

    public void addChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.addPropertyChangeListener(propertyChangeListener);
    }

    public void changeState(State state) {
        AtomicReference<State> atomicReference = this.state;
        State stateOppositeState = state.oppositeState();
        while (!atomicReference.compareAndSet(stateOppositeState, state)) {
            if (atomicReference.get() != stateOppositeState) {
                return;
            }
        }
        this.changeSupport.firePropertyChange(PROPERTY_NAME, !isOpen(state), isOpen(state));
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public abstract boolean checkState();

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        changeState(State.CLOSED);
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public abstract boolean incrementAndCheckState(T t);

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean isClosed() {
        return !isOpen();
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public void open() {
        changeState(State.OPEN);
    }

    public void removeChangeListener(PropertyChangeListener propertyChangeListener) {
        this.changeSupport.removePropertyChangeListener(propertyChangeListener);
    }

    @Override // org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean isOpen() {
        return isOpen(this.state.get());
    }
}
