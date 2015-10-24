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
 * float}.
 */

public final class UnsignedFloat
{
  private UnsignedFloat()
  {
    throw new UnreachableCodeException();
  }

  /**
   * @param x An unsigned integer value
   *
   * @return The given unsigned integer value as a {@code float}
   */

  public static float fromUnsignedInt(final int x)
  {
    return (float) ((long) x & 0xffffffffL);
  }

  /**
   * @param f A floating point value
   *
   * @return The given floating point value as an {@code int}
   */

  public static int toUnsignedInt(final float f)
  {
    if (f > 2147483647.0f) {
      final float sub = f - 2147483647.0f;
      return 1 + ((int) f) + 2147483647;
    }

    return (int) f;
  }

  /**
   * @param x An unsigned integer value
   *
   * @return The given unsigned integer value as a {@code float}
   */

  public static float fromUnsignedLong(final long x)
  {
    if ((x & 0x8000000000000000L) != 0L) {
      final long k = x & 0x7fffffffffffffffL;
      final float rf = (float) k;
      return rf + 9223372036854775807.0f;
    }

    return (float) x;
  }

  /**
   * @param f A floating point value
   *
   * @return The given floating point value as a {@code long}
   */

  public static long toUnsignedLong(final float f)
  {
    if (f > 9223372036854775807.0f) {
      final float sub = f - 9223372036854775807.0f;
      return 1L + ((long) f) + 9223372036854775807L;
    }

    return (long) f;
  }
}
