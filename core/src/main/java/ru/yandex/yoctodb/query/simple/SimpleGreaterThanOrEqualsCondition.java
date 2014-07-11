/*
 * Copyright © 2014 Yandex
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file or
 * http://www.wtfpl.net/ for more details.
 */

package com.yandex.yoctodb.query.simple;

import net.jcip.annotations.Immutable;
import org.jetbrains.annotations.NotNull;
import com.yandex.yoctodb.immutable.FilterableIndex;
import com.yandex.yoctodb.util.UnsignedByteArray;
import com.yandex.yoctodb.util.mutable.BitSet;

import java.nio.ByteBuffer;

/**
 * Greater than or equals condition
 *
 * @author incubos
 */
@Immutable
public final class SimpleGreaterThanOrEqualsCondition
        extends AbstractSimpleCondition {
    @NotNull
    private final ByteBuffer value;

    public SimpleGreaterThanOrEqualsCondition(
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
        return index.greaterThan(to, value, true);
    }
}
