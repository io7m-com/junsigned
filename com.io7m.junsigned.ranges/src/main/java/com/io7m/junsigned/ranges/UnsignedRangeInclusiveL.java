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

import com.io7m.jnull.NullCheck;
import com.io7m.jnull.Nullable;
import net.jcip.annotations.Immutable;

/**
 * <p> Immutable type representing an inclusive range with {@code long}
 * components. </p>
 */

@Immutable public final class UnsignedRangeInclusiveL
{
  private final long interval;
  private final long lower;
  private final long upper;

  /**
   * Construct an inclusive range. The constructor enforces the invariant {@code
   * lower <= upper}.
   *
   * @param in_lower The lower bound
   * @param in_upper The upper bound
   */

  public UnsignedRangeInclusiveL(
    final long in_lower,
    final long in_upper)
  {
    UnsignedRangeCheck.checkLessEqualLong(in_lower, "lower", in_upper, "upper");
    this.lower = in_lower;
    this.upper = in_upper;
    this.interval = (this.upper - this.lower) + 1L;
  }

  @Override public boolean equals(
    final @Nullable Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    final UnsignedRangeInclusiveL other = (UnsignedRangeInclusiveL) obj;
    return this.lower == other.lower && this.upper == other.upper;
  }

  /**
   * <p> Retrieve the number of values in the range {@code [lower, upper]}. That
   * is, {@code (upper - lower) + 1}. <p>
   *
   * @return The number of values in the range
   */

  public long getInterval()
  {
    return this.interval;
  }

  /**
   * @return The lower bound of the inclusive range.
   */

  public long getLower()
  {
    return this.lower;
  }

  /**
   * @return The upper bound of the inclusive range.
   */

  public long getUpper()
  {
    return this.upper;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + Long.hashCode(this.lower);
    result = (prime * result) + Long.hashCode(this.upper);
    return result;
  }

  /**
   * <p> Determine if the given value is included in this range. </p>
   *
   * @param value The given value
   *
   * @return {@code true} iff {@code value >= this.getLower() && value <=
   * this.getUpper()} .
   */

  public boolean includesValue(
    final long value)
  {
    return Long.compareUnsigned(value, this.lower) >= 0
           && Long.compareUnsigned(value, this.upper) <= 0;
  }

  /**
   * <p> Determine if the given range is included in this range. </p>
   *
   * @param other The given range
   *
   * @return {@code true} iff {@code this.getLower() >= other.getLower() &&
   * this.getUpper() <= other.getUpper()} .
   */

  public boolean isIncludedIn(
    final UnsignedRangeInclusiveL other)
  {
    NullCheck.notNull(other, "Other range");

    return Long.compareUnsigned(this.lower, other.lower) >= 0
           && Long.compareUnsigned(this.upper, other.upper) <= 0;
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder(32);
    builder.append("[UnsignedRangeInclusiveL ");
    builder.append(Long.toUnsignedString(this.lower));
    builder.append(" ");
    builder.append(Long.toUnsignedString(this.upper));
    builder.append("]");
    return NullCheck.notNull(builder.toString());
  }
}
