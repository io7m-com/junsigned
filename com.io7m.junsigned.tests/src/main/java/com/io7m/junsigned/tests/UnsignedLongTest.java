/*
 * Copyright © 2017 Mark Raynsford <code@io7m.com> https://www.io7m.com
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

package com.io7m.junsigned.tests;

import com.io7m.junsigned.core.UnsignedLong;
import org.junit.Assert;
import org.junit.Test;

public final class UnsignedLongTest
{
  @Test
  public void testModulo()
  {
    for (long pa = 1L; pa < 63L; pa += 1L) {
      final long bound_u = (long) Math.pow(2, pa);

      for (long pb = 0L; pb < 63L; pb += 1L) {
        {
          final long x = (long) Math.pow(2, pb);
          final long y = bound_u;
          final long r = UnsignedLong.modulo(x, y);
          System.out.printf(
            "%d mod %d = %d\n",
            Long.valueOf(x),
            Long.valueOf(y),
            Long.valueOf(r));
          Assert.assertTrue(r >= 0);
          Assert.assertTrue(r < bound_u);
        }

        {
          final long x = (long) -Math.pow(2, pb);
          final long y = bound_u;
          final long r = UnsignedLong.modulo(x, y);
          System.out.printf(
            "%d mod %d = %d\n",
            Long.valueOf(x),
            Long.valueOf(y),
            Long.valueOf(r));
          Assert.assertTrue(r >= 0);
          Assert.assertTrue(r <= bound_u);
        }
      }
    }
  }

  @Test(expected = ArithmeticException.class)
  public void testModuloNegativeDivisor()
  {
    UnsignedLong.modulo(0L, -1L);
  }
}
