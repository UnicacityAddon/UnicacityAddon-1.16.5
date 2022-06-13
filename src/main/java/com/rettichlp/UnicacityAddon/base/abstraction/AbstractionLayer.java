package com.rettichlp.UnicacityAddon.base.abstraction;

import com.rettichlp.UnicacityAddon.base.exceptions.LabymodClassCannotBeInstantiated;
import com.rettichlp.UnicacityAddon.base.exceptions.UPlayerClassCannotBeInstantiated;

import java.lang.reflect.InvocationTargetException;

/**
 * @author RettichLP
 * @see <a href="https://github.com/paulzhng/UCUtils/blob/master/src/main/java/de/fuzzlemann/ucutils/base/abstraction/AbstractionLayer.java">UCUtils by paulzhng</a>
 */
public class AbstractionLayer {

    private static final Class<? extends Labymod> labymodClass = LabymodImpl.class;
    private static final Class<? extends UPlayer> uplayerClass = UPlayerImpl.class;

    public static Labymod getLabymod() {
        try {
            return labymodClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new LabymodClassCannotBeInstantiated("Class " + labymodClass + " cannot be instantiated.", e);
        }
    }

    public static UPlayer getPlayer() {
        try {
            return uplayerClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new UPlayerClassCannotBeInstantiated("Class " + uplayerClass + " cannot be instantiated.", e);
        }
    }
}
