/*
 * Copyright © 2014 <code@io7m.com> http://io7m.com
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

import com.io7m.jranges.RangeCheckException;
import com.io7m.junsigned.ranges.UnsignedRangeInclusiveL;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public final class UnsignedRangeInclusiveLTest
{
  @Test
  public void testEquals_0()
  {
    final UnsignedRangeInclusiveL r00 = UnsignedRangeInclusiveL.of(0L, 0L);
    final UnsignedRangeInclusiveL r00a = UnsignedRangeInclusiveL.of(0L, 0L);
    final UnsignedRangeInclusiveL r01 = UnsignedRangeInclusiveL.of(0L, 1L);
    final UnsignedRangeInclusiveL r12 = UnsignedRangeInclusiveL.of(1L, 2L);

    Assert.assertEquals(r00, r00);
    Assert.assertEquals(r00a, r00);

    Assert.assertNotEquals(r00, null);
    Assert.assertNotEquals(r00, BigInteger.ZERO);
    Assert.assertNotEquals(r01, r00);
    Assert.assertNotEquals(r12, r00);
  }

  @Test
  public void testHashCode_0()
  {
    final UnsignedRangeInclusiveL r00 = UnsignedRangeInclusiveL.of(0L, 0L);
    final UnsignedRangeInclusiveL r00a = UnsignedRangeInclusiveL.of(0L, 0L);
    final UnsignedRangeInclusiveL r01 = UnsignedRangeInclusiveL.of(0L, 1L);
    final UnsignedRangeInclusiveL r12 = UnsignedRangeInclusiveL.of(1L, 2L);

    Assert.assertEquals((long) r00.hashCode(), (long) r00.hashCode());
    Assert.assertEquals((long) r00a.hashCode(), (long) r00.hashCode());
    Assert.assertNotEquals((long) r01.hashCode(), (long) r00.hashCode());
    Assert.assertNotEquals((long) r12.hashCode(), (long) r00.hashCode());
    Assert.assertNotEquals((long) r00.hashCode(), (long) r01.hashCode());
    Assert.assertNotEquals((long) r00.hashCode(), (long) r12.hashCode());
  }

  @Test
  public void testToString_0()
  {
    final UnsignedRangeInclusiveL r00 = UnsignedRangeInclusiveL.of(0L, 0L);
    final UnsignedRangeInclusiveL r00a = UnsignedRangeInclusiveL.of(0L, 0L);
    final UnsignedRangeInclusiveL r01 = UnsignedRangeInclusiveL.of(0L, 1L);
    final UnsignedRangeInclusiveL r12 = UnsignedRangeInclusiveL.of(1L, 2L);

    Assert.assertEquals(r00.toString(), r00.toString());
    Assert.assertEquals(r00a.toString(), r00.toString());
    Assert.assertNotEquals(r01.toString(), r00.toString());
    Assert.assertNotEquals(r12.toString(), r00.toString());
    Assert.assertNotEquals(r00.toString(), r01.toString());
    Assert.assertNotEquals(r00.toString(), r12.toString());
  }

  @Test
  public void testIncluded()
  {
    Assert.assertTrue(
      UnsignedRangeInclusiveL.of(
        0L,
        10L).isIncludedIn(
        UnsignedRangeInclusiveL.of(
          0L,
          10L)));

    Assert.assertFalse(
      UnsignedRangeInclusiveL.of(
        0L,
        10L).isIncludedIn(
        UnsignedRangeInclusiveL.of(
          0L,
          9L)));
    Assert.assertFalse(
      UnsignedRangeInclusiveL.of(
        0L,
        10L).isIncludedIn(
        UnsignedRangeInclusiveL.of(
          1L,
          10L)));
  }

  @Test
  public void testRange_0()
  {
    final UnsignedRangeInclusiveL r = UnsignedRangeInclusiveL.of(0L, 9L);
    Assert.assertEquals(0L, r.lower());
    Assert.assertEquals(9L, r.upper());
    Assert.assertEquals(10L, r.interval());
  }

  @Test
  public void testRange_1()
  {
    final UnsignedRangeInclusiveL r = UnsignedRangeInclusiveL.of(0L, 9L);
    Assert.assertFalse(r.includesValue(-1L));
    Assert.assertFalse(r.includesValue(10L));
    Assert.assertTrue(r.includesValue(0L));
    Assert.assertTrue(r.includesValue(9L));
  }

  @SuppressWarnings("unused")
  @Test(expected = RangeCheckException.class)
  public void testRangeBad_0()
  {
    UnsignedRangeInclusiveL.of(1L, 0L);
  }
}
