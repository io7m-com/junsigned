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

package com.io7m.junsigned.tests;

import com.io7m.junsigned.core.UnsignedFloat;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public final class UnsignedFloatTest
{
  @Test public void testIntUpperBound()
  {
    final BigInteger x =
      BigInteger.valueOf(2L).pow(32).subtract(BigInteger.ONE);
    System.out.printf("value:          %s\n", x);
    final int k = Integer.parseUnsignedInt(x.toString());
    System.out.printf("unsigned value: %s\n", Integer.toUnsignedString(k));
    final float f = UnsignedFloat.fromUnsignedInt(k);
    System.out.printf("unsigned float: %s\n", Float.toString(f));
    Assert.assertEquals(4294967295.0f, f, 0.0);
    final int r = UnsignedFloat.toUnsignedInt(f);
    System.out.printf("unsigned int r: %s\n", Integer.toUnsignedString(r));
    Assert.assertEquals(r, k);
  }

  @Test public void testIntExhaustive()
  {
    for (int e = 0; e <= 32; ++e) {
      final BigInteger x =
        BigInteger.valueOf(2L).pow(e).subtract(BigInteger.ONE);
      System.out.printf("[%d] value:          %s\n", Integer.valueOf(e), x);
      final int k = Integer.parseUnsignedInt(x.toString());
      System.out.printf(
        "[%d] unsigned value: %s\n",
        Integer.valueOf(e),
        Integer.toUnsignedString(k));
      final float f = UnsignedFloat.fromUnsignedInt(k);
      System.out.printf(
        "[%d] unsigned float: %s\n", Integer.valueOf(e), Float.toString(f));
      Assert.assertEquals(x.floatValue(), f, 2.0);
      final int r = UnsignedFloat.toUnsignedInt(f);
      System.out.printf(
        "[%d] unsigned result: %s\n",
        Integer.valueOf(e),
        Integer.toUnsignedString(r));
      Assert.assertTrue(Math.abs(r - k) < 2);
    }
  }

  @Test public void testLongExhaustive()
  {
    for (int e = 0; e <= 64; ++e) {
      final BigInteger x =
        BigInteger.valueOf(2L).pow(e).subtract(BigInteger.ONE);
      System.out.printf("[%d] value:          %s\n", Integer.valueOf(e), x);
      final long k = Long.parseUnsignedLong(x.toString());
      System.out.printf(
        "[%d] unsigned value: %s\n",
        Integer.valueOf(e),
        Long.toUnsignedString(k));
      final float f = UnsignedFloat.fromUnsignedLong(k);
      System.out.printf(
        "[%d] unsigned float: %s\n", Integer.valueOf(e), Float.toString(f));
      Assert.assertEquals(x.floatValue(), f, 2.0);
      final long r = UnsignedFloat.toUnsignedLong(f);
      System.out.printf(
        "[%d] unsigned result: %s\n",
        Integer.valueOf(e),
        Long.toUnsignedString(r));
      Assert.assertTrue(Math.abs(r - k) < 2);
    }
  }

  @Test public void testLongUpperBound()
  {
    final BigInteger x =
      BigInteger.valueOf(2L).pow(64).subtract(BigInteger.ONE);
    System.out.printf("value:          %s\n", x);
    final long k = Long.parseUnsignedLong(x.toString());
    System.out.printf("unsigned value: %s\n", Long.toUnsignedString(k));
    final float f = UnsignedFloat.fromUnsignedLong(k);
    System.out.printf("unsigned float: %s\n", Float.toString(f));
    Assert.assertEquals(18446744073709551615.0f, f, 0.0);
    final long r = UnsignedFloat.toUnsignedLong(f);
    System.out.printf("unsigned long r: %s\n", Long.toUnsignedString(r));
    Assert.assertEquals(r, k);
  }

  @Test
  public void testModulo()
  {
    for (float pa = 1.0f; pa < 64.0f; pa += 1.0f) {
      final float bound_u = (float) Math.pow(2.0, pa);

      for (float pb = 0.0f; pb < 64.0f; pb += 1.0f) {
        {
          final float x = (float) Math.pow(2.0, pb);
          final float y = bound_u;
          final float r = UnsignedFloat.modulo(x, y);
          System.out.printf(
            "%f mod %f = %f\n",
            Double.valueOf(x),
            Double.valueOf(y),
            Double.valueOf(r));
          Assert.assertTrue(r >= 0.0);
          Assert.assertTrue(r < bound_u);
        }

        {
          final float x = (float) -Math.pow(2.0, pb);
          final float y = bound_u;
          final float r = UnsignedFloat.modulo(x, y);
          System.out.printf(
            "%f mod %f = %f\n",
            Double.valueOf(x),
            Double.valueOf(y),
            Double.valueOf(r));
          Assert.assertTrue(r >= 0.0);
          Assert.assertTrue(r <= bound_u);
        }
      }
    }
  }

  @Test(expected = ArithmeticException.class)
  public void testModuloNegativeDivisor()
  {
    UnsignedFloat.modulo(0.0f, -1.0f);
  }
}
