/*
 * (C) YANDEX LLC, 2014-2016
 *
 * The Source Code called "YoctoDB" available at
 * https://github.com/yandex/yoctodb is subject to the terms of the
 * Mozilla Public License, v. 2.0 (hereinafter referred to as the "License").
 *
 * A copy of the License is also available at http://mozilla.org/MPL/2.0/.
 */

package com.yandex.yoctodb.query.simple;

import net.jcip.annotations.Immutable;
import org.jetbrains.annotations.NotNull;
import com.yandex.yoctodb.immutable.Database;
import com.yandex.yoctodb.query.ScoredDocument;

/**
 * {@link ScoredDocument} implementation for simple queries
 *
 * @author incubos
 */
@Immutable
final class SimpleScoredDocument
        implements ScoredDocument<SimpleScoredDocument> {
    @NotNull
    private final Database database;
    @NotNull
    private final SimpleDocumentMultiScore score;
    private final int document;

    SimpleScoredDocument(
            @NotNull
            final Database database,
            @NotNull
            final SimpleDocumentMultiScore score,
            final int document) {
        assert 0 <= document && document < database.getDocumentCount();

        this.database = database;
        this.score = score;
        this.document = document;
    }

    @NotNull
    @Override
    public Database getDatabase() {
        return database;
    }

    @Override
    public int getDocument() {
        return document;
    }

    @Override
    public int compareTo(
            @NotNull
            final SimpleScoredDocument o) {
        return score.compareTo(o.score);
    }
}
