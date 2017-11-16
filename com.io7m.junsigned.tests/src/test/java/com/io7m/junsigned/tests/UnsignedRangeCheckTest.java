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

import com.io7m.jranges.RangeCheckException;
import com.io7m.junsigned.ranges.UnsignedRangeCheck;
import com.io7m.junsigned.ranges.UnsignedRangeInclusiveI;
import com.io7m.junsigned.ranges.UnsignedRangeInclusiveL;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public final class UnsignedRangeCheckTest
{
  @Test(expected = RangeCheckException.class)
  public void testGreaterLong_0()
  {
    UnsignedRangeCheck.checkGreaterLong(0L, "x", 0L, "lower");
  }

  @Test
  public void testGreaterLong_1()
  {
    Assert.assertEquals(
      2L, UnsignedRangeCheck.checkGreaterLong(
        2L, "x", 1L, "lower"));
  }

  @Test
  public void testGreaterLong_2()
  {
    final long q = Long.parseUnsignedLong("10000000000000000000");
    Assert.assertEquals(
      q, UnsignedRangeCheck.checkGreaterLong(
        q, "x", 1L, "lower"));
  }

  @Test
  public void testGreaterEqualLong_2()
  {
    final long q = Long.parseUnsignedLong("10000000000000000000");
    Assert.assertEquals(
      q, UnsignedRangeCheck.checkGreaterEqualLong(
        q, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterInteger_0()
  {
    UnsignedRangeCheck.checkGreaterInteger(0, "x", 0, "lower");
  }

  @Test
  public void testGreaterInteger_1()
  {
    Assert.assertEquals(
      2L, (long) UnsignedRangeCheck.checkGreaterInteger(
        2, "x", 1, "lower"));
  }

  @Test
  public void testGreaterInteger_2()
  {
    final int q = Integer.parseUnsignedInt("3000000000");
    Assert.assertEquals(
      q, (long) UnsignedRangeCheck.checkGreaterInteger(
        q, "x", 1, "lower"));
  }

  @Test
  public void testGreaterEqualInteger_2()
  {
    final int q = Integer.parseUnsignedInt("3000000000");
    Assert.assertEquals(
      q, (long) UnsignedRangeCheck.checkGreaterInteger(
        q, "x", 1, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualLong_0()
  {
    UnsignedRangeCheck.checkGreaterEqualLong(0L, "x", 1L, "lower");
  }

  @Test
  public void testGreaterEqualLong_1()
  {
    Assert.assertEquals(
      1L, UnsignedRangeCheck.checkGreaterEqualLong(1L, "x", 1L, "lower"));
  }

  @Test(expected = RangeCheckException.class)
  public void testGreaterEqualInteger_0()
  {
    UnsignedRangeCheck.checkGreaterEqualInteger(0, "x", 1, "lower");
  }

  @Test
  public void testGreaterEqualInteger_1()
  {
    Assert.assertEquals(
      1L,
      (long) UnsignedRangeCheck.checkGreaterEqualInteger(1, "x", 1, "lower"));
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullLong_0()
  {
    UnsignedRangeCheck.checkGreaterEqualLong(
      0L, TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullLong_1()
  {
    UnsignedRangeCheck.checkGreaterEqualLong(
      0L, "x", 1L, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullInteger_0()
  {
    UnsignedRangeCheck.checkGreaterEqualInteger(
      0, TestUtilities.actuallyNull(), 1, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterEqualNullInteger_1()
  {
    UnsignedRangeCheck.checkGreaterEqualInteger(
      0, "x", 1, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullLong_0()
  {
    UnsignedRangeCheck.checkGreaterLong(
      0L, TestUtilities.actuallyNull(), 1L, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullLong_1()
  {
    UnsignedRangeCheck.checkGreaterLong(
      0L, "x", 1L, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullInteger_0()
  {
    UnsignedRangeCheck.checkGreaterInteger(
      0, TestUtilities.actuallyNull(), 1, "lower");
  }

  @Test(expected = NullPointerException.class)
  public void testGreaterNullInteger_1()
  {
    UnsignedRangeCheck.checkGreaterInteger(
      0, "x", 1, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullLong_0()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(0L, 9L);
    UnsignedRangeCheck.checkIncludedInLong(
      0L, TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullLong_1()
  {
    UnsignedRangeCheck.checkIncludedInLong(
      0L, "name", TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullLong_2()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(0L, 9L);
    UnsignedRangeCheck.checkIncludedInLong(
      0L, "name", range, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullInteger_0()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(
      0, TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullInteger_1()
  {
    UnsignedRangeCheck.checkIncludedInInteger(
      0, "name", TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedNullInteger_2()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(
      0, "name", range, TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeLong_0()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(0L, 9L);
    UnsignedRangeCheck.checkIncludedInLong(-1L, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeLong_1()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(0L, 9L);
    UnsignedRangeCheck.checkIncludedInLong(10L, "Value", range, "Range");
  }

  @Test
  public void testIncludedRangeLong_2()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(0L, 9L);
    Assert.assertEquals(
      0L, UnsignedRangeCheck.checkIncludedInLong(0L, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeLong_3()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(0L, 9L);
    Assert.assertEquals(
      9L, UnsignedRangeCheck.checkIncludedInLong(9L, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeLong_4()
  {
    final UnsignedRangeInclusiveL range = UnsignedRangeInclusiveL.of(
      0L, Long.parseUnsignedLong(
        "18446744073709551615"));

    final BigInteger two = BigInteger.valueOf(2L);
    for (int pow = 0; pow <= 64; ++pow) {
      final BigInteger result = two.pow(pow).subtract(BigInteger.ONE);
      final long q = Long.parseUnsignedLong(result.toString());
      Assert.assertEquals(
        q, UnsignedRangeCheck.checkIncludedInLong(
          q, "Value", range, "Range"));
    }
  }

  @Test(expected = RangeCheckException.class)
  public void testLessLong_0()
  {
    UnsignedRangeCheck.checkLessLong(0L, "x", 0L, "upper");
  }

  @Test
  public void testLessLong_1()
  {
    Assert.assertEquals(
      0L, UnsignedRangeCheck.checkLessLong(0L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeInteger_0()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(-1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedRangeInteger_1()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(10, "Value", range, "Range");
  }

  @Test
  public void testIncludedRangeInteger_2()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      0L, (long) UnsignedRangeCheck.checkIncludedInInteger(
        0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedRangeInteger_3()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      9L, (long) UnsignedRangeCheck.checkIncludedInInteger(
        9, "Value", range, "Range"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessInteger_0()
  {
    UnsignedRangeCheck.checkLessInteger(0, "x", 0, "upper");
  }

  @Test
  public void testLessInteger_1()
  {
    Assert.assertEquals(
      0L, (long) UnsignedRangeCheck.checkLessInteger(
        0, "x", 1, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessEqualLong_0()
  {
    UnsignedRangeCheck.checkLessEqualLong(1L, "x", 0L, "upper");
  }

  @Test
  public void testLessEqualLong_1()
  {
    Assert.assertEquals(
      1L, UnsignedRangeCheck.checkLessEqualLong(1L, "x", 1L, "upper"));
  }

  @Test(expected = RangeCheckException.class)
  public void testLessEqualInteger_0()
  {
    UnsignedRangeCheck.checkLessEqualInteger(1, "x", 0, "upper");
  }

  @Test
  public void testLessEqualInteger_1()
  {
    Assert.assertEquals(
      1L, (long) UnsignedRangeCheck.checkLessEqualInteger(1, "x", 1, "upper"));
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullLong_0()
  {
    UnsignedRangeCheck.checkLessEqualLong(
      0L, TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullLong_1()
  {
    UnsignedRangeCheck.checkLessEqualLong(
      0L, "x", 1L, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullInteger_0()
  {
    UnsignedRangeCheck.checkLessEqualInteger(
      0, TestUtilities.actuallyNull(), 1, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessEqualNullInteger_1()
  {
    UnsignedRangeCheck.checkLessEqualInteger(
      0, "x", 1, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullLong_0()
  {
    UnsignedRangeCheck.checkLessLong(
      0L, TestUtilities.actuallyNull(), 1L, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullLong_1()
  {
    UnsignedRangeCheck.checkLessLong(
      0L, "x", 1L, TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullInteger_0()
  {
    UnsignedRangeCheck.checkLessInteger(
      0, TestUtilities.actuallyNull(), 1, "upper");
  }

  @Test(expected = NullPointerException.class)
  public void testLessNullInteger_1()
  {
    UnsignedRangeCheck.checkLessInteger(
      0, "x", 1, TestUtilities.actuallyNull());
  }

  @Test
  public void testRangeIncludedLong_0()
  {
    Assert.assertEquals(
      UnsignedRangeInclusiveL.of(0L, 0L),
      UnsignedRangeCheck.checkRangeIncludedInLong(
        UnsignedRangeInclusiveL.of(0L, 0L),
        "Inner",
        UnsignedRangeInclusiveL.of(0L, 0L),
        "Outer"));
  }

  @Test(expected = RangeCheckException.class)
  public void testRangeIncludedLong_1()
  {
    UnsignedRangeCheck.checkRangeIncludedInLong(
      UnsignedRangeInclusiveL.of(1L, 1L), "Inner", UnsignedRangeInclusiveL.of(
        0L, 0L), "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_0()
  {
    UnsignedRangeCheck.checkRangeIncludedInLong(
      TestUtilities.actuallyNull(),
      "Inner",
      UnsignedRangeInclusiveL.of(0L, 0L),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_1()
  {
    UnsignedRangeCheck.checkRangeIncludedInLong(
      UnsignedRangeInclusiveL.of(0L, 0L),
      TestUtilities.actuallyNull(),
      UnsignedRangeInclusiveL.of(0L, 0L),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_2()
  {
    UnsignedRangeCheck.checkRangeIncludedInLong(
      UnsignedRangeInclusiveL.of(0L, 0L),
      "Inner",
      TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullLong_3()
  {
    UnsignedRangeCheck.checkRangeIncludedInLong(
      UnsignedRangeInclusiveL.of(0L, 0L),
      "Inner",
      UnsignedRangeInclusiveL.of(0L, 0L),
      TestUtilities.actuallyNull());
  }

  @Test
  public void testRangeIncludedInteger_0()
  {
    Assert.assertEquals(
      UnsignedRangeInclusiveI.of(0, 0),
      UnsignedRangeCheck.checkRangeIncludedInInteger(
        UnsignedRangeInclusiveI.of(0, 0),
        "Inner",
        UnsignedRangeInclusiveI.of(0, 0),
        "Outer"));
  }

  @Test(expected = RangeCheckException.class)
  public void testRangeIncludedInteger_1()
  {
    UnsignedRangeCheck.checkRangeIncludedInInteger(
      UnsignedRangeInclusiveI.of(1, 1),
      "Inner",
      UnsignedRangeInclusiveI.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_0()
  {
    UnsignedRangeCheck.checkRangeIncludedInInteger(
      TestUtilities.actuallyNull(),
      "Inner",
      UnsignedRangeInclusiveI.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_1()
  {
    UnsignedRangeCheck.checkRangeIncludedInInteger(
      UnsignedRangeInclusiveI.of(0, 0),
      TestUtilities.actuallyNull(),
      UnsignedRangeInclusiveI.of(0, 0),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_2()
  {
    UnsignedRangeCheck.checkRangeIncludedInInteger(
      UnsignedRangeInclusiveI.of(0, 0),
      "Inner",
      TestUtilities.actuallyNull(),
      "Outer");
  }

  @Test(expected = NullPointerException.class)
  public void testRangeIncluded_NullInteger_3()
  {
    UnsignedRangeCheck.checkRangeIncludedInInteger(
      UnsignedRangeInclusiveI.of(0, 0),
      "Inner",
      UnsignedRangeInclusiveI.of(0, 0),
      TestUtilities.actuallyNull());
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedIntNull_1()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(
      0, TestUtilities.actuallyNull(), range, "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedIntNull_2()
  {
    UnsignedRangeCheck.checkIncludedInInteger(
      0, "name", TestUtilities.actuallyNull(), "range");
  }

  @Test(expected = NullPointerException.class)
  public void testIncludedIntNull_3()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(
      0, "name", range, TestUtilities.actuallyNull());
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedIntRange_0()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(
      -1, "Value", range, "Range");
  }

  @Test(expected = RangeCheckException.class)
  public void testIncludedIntRange_1()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    UnsignedRangeCheck.checkIncludedInInteger(10, "Value", range, "Range");
  }

  @Test
  public void testIncludedIntRange_2()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      0L, (long) UnsignedRangeCheck.checkIncludedInInteger(
        0, "Value", range, "Range"));
  }

  @Test
  public void testIncludedIntRange_3()
  {
    final UnsignedRangeInclusiveI range = UnsignedRangeInclusiveI.of(0, 9);
    Assert.assertEquals(
      9L, (long) UnsignedRangeCheck.checkIncludedInInteger(
        9, "Value", range, "Range"));
  }

  @Test
  public void testIncludedIntRange_4()
  {
    final UnsignedRangeInclusiveI range =
      UnsignedRangeInclusiveI.of(0, Integer.parseUnsignedInt("4294967295"));

    final BigInteger two = BigInteger.valueOf(2L);
    for (int pow = 0; pow <= 32; ++pow) {
      final BigInteger result = two.pow(pow).subtract(BigInteger.ONE);
      final int q = Integer.parseUnsignedInt(result.toString());
      Assert.assertEquals(
        q, (long) UnsignedRangeCheck.checkIncludedInInteger(
          q, "Value", range, "Range"));
    }
  }
}
