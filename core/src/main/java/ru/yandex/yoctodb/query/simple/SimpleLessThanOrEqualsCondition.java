/*
 * Copyright (c) 2014 Yandex
 */

package ru.yandex.yoctodb.query.simple;

import net.jcip.annotations.Immutable;
import org.jetbrains.annotations.NotNull;
import ru.yandex.yoctodb.immutable.FilterableIndex;
import ru.yandex.yoctodb.util.UnsignedByteArray;
import ru.yandex.yoctodb.util.mutable.BitSet;

import java.nio.ByteBuffer;

/**
 * Less than or equals condition
 *
 * @author incubos
 */
@Immutable
public final class SimpleLessThanOrEqualsCondition
        extends AbstractSimpleCondition {
    @NotNull
    private final ByteBuffer value;

    public SimpleLessThanOrEqualsCondition(
            @NotNull
            final String fieldName,
            @NotNull
            final UnsignedByteArray value) {
        super(fieldName);

        assert value.length() > 0;

        this.value = value.toByteBuffer();
    }

    @Override
    public boolean set(
            @NotNull
            final FilterableIndex index,
            @NotNull
            final BitSet to) {
        return index.lessThan(to, value, true);
    }
}
