/*
 * MIT License
 *
 * Copyright (c) 2019 Choko (choko@curioswitch.org)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
/*
 * This file is generated by jOOQ.
 */
package org.curioswitch.database.cafemapdb.tables.interfaces;


import java.io.Serializable;
import java.time.LocalDateTime;

import javax.annotation.Generated;

import org.jooq.types.ULong;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.9"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public interface ILandmark extends Serializable {

    /**
     * Getter for <code>cafemapdb.landmark.id</code>.
     */
    public ULong getId();

    /**
     * Getter for <code>cafemapdb.landmark.google_place_id</code>.
     */
    public String getGooglePlaceId();

    /**
     * Getter for <code>cafemapdb.landmark.s2_cell</code>.
     */
    public String getS2Cell();

    /**
     * Getter for <code>cafemapdb.landmark.type</code>.
     */
    public String getType();

    /**
     * Getter for <code>cafemapdb.landmark.created_at</code>.
     */
    public LocalDateTime getCreatedAt();

    /**
     * Getter for <code>cafemapdb.landmark.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt();
}
