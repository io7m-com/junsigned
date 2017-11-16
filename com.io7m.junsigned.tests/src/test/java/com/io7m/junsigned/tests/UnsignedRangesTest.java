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

import com.io7m.junsigned.ranges.UnsignedRanges;
import org.junit.Assert;
import org.junit.Test;

public final class UnsignedRangesTest
{
  @Test
  public void testNaturalInteger()
  {
    Assert.assertEquals(
      0L, (long) UnsignedRanges.UNSIGNED_NATURAL_INTEGER.lower());
    Assert.assertEquals(
      (long) Integer.parseUnsignedInt("4294967295"),
      (long) UnsignedRanges.UNSIGNED_NATURAL_INTEGER.upper());
  }

  @Test
  public void testNaturalLong()
  {
    Assert.assertEquals(
      0L, UnsignedRanges.UNSIGNED_NATURAL_LONG.lower());
    Assert.assertEquals(
      Long.parseUnsignedLong("18446744073709551615"),
      UnsignedRanges.UNSIGNED_NATURAL_LONG.upper());
  }

  @Test
  public void testPositiveInteger()
  {
    Assert.assertEquals(
      1L, (long) UnsignedRanges.UNSIGNED_POSITIVE_INTEGER.lower());
    Assert.assertEquals(
      (long) Integer.parseUnsignedInt("4294967295"),
      (long) UnsignedRanges.UNSIGNED_POSITIVE_INTEGER.upper());
  }

  @Test
  public void testPositiveLong()
  {
    Assert.assertEquals(
      1L, UnsignedRanges.UNSIGNED_POSITIVE_LONG.lower());
    Assert.assertEquals(
      Long.parseUnsignedLong("18446744073709551615"),
      UnsignedRanges.UNSIGNED_POSITIVE_LONG.upper());
  }
}
