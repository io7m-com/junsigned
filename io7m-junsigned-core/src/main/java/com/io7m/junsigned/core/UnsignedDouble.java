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

package com.io7m.junsigned.core;

import com.io7m.junreachable.UnreachableCodeException;

/**
 * Functions to convert unsigned integer values to/from values of {@code
 * double}.
 */

public final class UnsignedDouble
{
  private UnsignedDouble()
  {
    throw new UnreachableCodeException();
  }

  /**
   * @param x An unsigned integer value
   *
   * @return The given unsigned integer value as a {@code double}
   */

  public static double fromUnsignedInt(
    final int x)
  {
    return (double) ((long) x & 0xffffffffL);
  }

  /**
   * @param f A floating point value
   *
   * @return The given floating point value as an {@code int}
   */

  public static int toUnsignedInt(
    final double f)
  {
    if (f > 2147483647.0) {
      return 1 + ((int) f) + 2147483647;
    }

    return (int) f;
  }

  /**
   * @param x An unsigned integer value
   *
   * @return The given unsigned integer value as a {@code double}
   */

  public static double fromUnsignedLong(
    final long x)
  {
    if ((x & 0x8000000000000000L) != 0L) {
      final long k = x & 0x7fffffffffffffffL;
      final double rf = (double) k;
      return rf + 9223372036854775807.0;
    }

    return (double) x;
  }

  /**
   * @param f A floating point value
   *
   * @return The given floating point value as a {@code long}
   */

  public static long toUnsignedLong(
    final double f)
  {
    if (f > 9223372036854775807.0) {
      return 1L + ((long) f) + 9223372036854775807L;
    }

    return (long) f;
  }

  /**
   * Calculate the unsigned modulo {@code x % y}.
   *
   * @param x The dividend
   * @param y The divisor
   *
   * @return The unsigned modulo {@code x % y}
   *
   * @throws ArithmeticException Iff {@code y < 0}
   */

  public static double modulo(
    final double x,
    final double y)
    throws ArithmeticException
  {
    if (y < 0.0) {
      throw new ArithmeticException("Divisor must be positive: " + y);
    }

    final double r = x % y;
    return r < 0.0 ? r + y : r;
  }
}
