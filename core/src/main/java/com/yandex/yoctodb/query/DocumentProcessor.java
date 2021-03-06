/*
 * (C) YANDEX LLC, 2014-2016
 *
 * The Source Code called "YoctoDB" available at
 * https://github.com/yandex/yoctodb is subject to the terms of the
 * Mozilla Public License, v. 2.0 (hereinafter referred to as the "License").
 *
 * A copy of the License is also available at http://mozilla.org/MPL/2.0/.
 */

package com.yandex.yoctodb.query;

import net.jcip.annotations.NotThreadSafe;
import org.jetbrains.annotations.NotNull;
import com.yandex.yoctodb.immutable.Database;

/**
 * Processor of immutable database documents
 *
 * @author incubos
 */
@NotThreadSafe
public interface DocumentProcessor {
    /**
     * Process the document payload
     *
     * @param document document id
     * @param database database to get document payload from
     * @return whether the processing should continue
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    boolean process(
            int document,
            @NotNull
            Database database);
}
