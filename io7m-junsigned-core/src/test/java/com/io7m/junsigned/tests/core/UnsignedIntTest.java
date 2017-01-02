/*
 * Copyright © 2017 <code@io7m.com> http://io7m.com
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

package com.io7m.junsigned.tests.core;

import com.io7m.junsigned.core.UnsignedInt;
import org.junit.Assert;
import org.junit.Test;

public final class UnsignedIntTest
{
  @Test
  public void testModulo()
  {
    for (int pa = 1; pa < 63; pa += 1) {
      final int bound_u = (int) Math.pow(2, pa);

      for (int pb = 0; pb < 63L; pb += 1) {
        {
          final int x = (int) Math.pow(2, pb);
          final int y = bound_u;
          final int r = UnsignedInt.modulo(x, y);
          System.out.printf(
            "%d mod %d = %d\n",
            Integer.valueOf(x),
            Integer.valueOf(y),
            Integer.valueOf(r));
          Assert.assertTrue(r >= 0);
          Assert.assertTrue(r < bound_u);
        }

        {
          final int x = (int) -Math.pow(2, pb);
          final int y = bound_u;
          final int r = UnsignedInt.modulo(x, y);
          System.out.printf(
            "%d mod %d = %d\n",
            Integer.valueOf(x),
            Integer.valueOf(y),
            Integer.valueOf(r));
          Assert.assertTrue(r >= 0);
          Assert.assertTrue(r <= bound_u);
        }
      }
    }
  }

  @Test(expected = ArithmeticException.class)
  public void testModuloNegativeDivisor()
  {
    UnsignedInt.modulo(0, -1);
  }
}
