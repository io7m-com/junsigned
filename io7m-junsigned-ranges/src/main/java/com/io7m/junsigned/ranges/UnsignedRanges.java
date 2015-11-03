/*
 * Copyright © 2015 <code@io7m.com> http://io7m.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF OR
 * IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

package com.io7m.junsigned.ranges;

import com.io7m.junreachable.UnreachableCodeException;

/**
 * Predefined unsigned ranges.
 */

public final class UnsignedRanges
{
  /**
   * The inclusive range of natural unsigned long integers, {@code [0,
   * 18446744073709551615]}.
   */

  public static final UnsignedRangeInclusiveL UNSIGNED_NATURAL_LONG;

  /**
   * The inclusive range of natural unsigned integers, {@code [0, 4294967295]}.
   */

  public static final UnsignedRangeInclusiveI UNSIGNED_NATURAL_INTEGER;

  /**
   * The inclusive range of positive unsigned long integers, {@code [1,
   * 18446744073709551615]}.
   */

  public static final UnsignedRangeInclusiveL UNSIGNED_POSITIVE_LONG;

  /**
   * The inclusive range of  positive integers, {@code [1, 4294967295]}.
   */

  public static final UnsignedRangeInclusiveI UNSIGNED_POSITIVE_INTEGER;

  static {
    UNSIGNED_POSITIVE_LONG = new UnsignedRangeInclusiveL(
      1L, 0b1111111111111111111111111111111111111111111111111111111111111111L);
    UNSIGNED_NATURAL_LONG = new UnsignedRangeInclusiveL(
      0L, 0b1111111111111111111111111111111111111111111111111111111111111111L);
    UNSIGNED_POSITIVE_INTEGER =
      new UnsignedRangeInclusiveI(1, 0b11111111111111111111111111111111);
    UNSIGNED_NATURAL_INTEGER =
      new UnsignedRangeInclusiveI(0, 0b11111111111111111111111111111111);
  }

  private UnsignedRanges()
  {
    throw new UnreachableCodeException();
  }
}
