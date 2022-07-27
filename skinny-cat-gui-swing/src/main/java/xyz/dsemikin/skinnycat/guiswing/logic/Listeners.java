package xyz.dsemikin.skinnycat.guiswing.logic;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Listeners {

    private final List<WeakReference<Listener>> listeners;

    public Listeners() {
        listeners = new ArrayList<>();
    }

    public void add(final Listener listener) {
        listeners.add(new WeakReference<>(listener));
    }

    public void notifyListeners() {
        for (var listenerWeakRef : listeners) {
            final Listener listener = listenerWeakRef.get();
            if (listener != null) {
                listener.onEvent();
            } else {
                listeners.remove(listenerWeakRef);
            }
        }
    }
}
