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
 * <p> Immutable type representing an inclusive range with {@code int}
 * components.</p>
 */

@Immutable public final class UnsignedRangeInclusiveI
{
  private final int interval;
  private final int lower;
  private final int upper;

  /**
   * Construct an inclusive range. The constructor enforces the invariant {@code
   * lower <= upper}.
   *
   * @param in_lower The lower bound
   * @param in_upper The upper bound
   */

  public UnsignedRangeInclusiveI(
    final int in_lower,
    final int in_upper)
  {
    UnsignedRangeCheck.checkLessEqualInteger(
      in_lower, "lower", in_upper, "upper");
    this.lower = in_lower;
    this.upper = in_upper;
    this.interval = (this.upper - this.lower) + 1;
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
    final UnsignedRangeInclusiveI other = (UnsignedRangeInclusiveI) obj;
    return this.lower == other.lower && this.upper == other.upper;
  }

  /**
   * <p> Retrieve the number of values in the range {@code [lower, upper]}. That
   * is, {@code (upper - lower) + 1}. <p>
   *
   * @return The number of values in the range
   */

  public int getInterval()
  {
    return this.interval;
  }

  /**
   * @return The lower bound of the inclusive range.
   */

  public int getLower()
  {
    return this.lower;
  }

  /**
   * @return The upper bound of the inclusive range.
   */

  public int getUpper()
  {
    return this.upper;
  }

  @Override public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = (prime * result) + Integer.hashCode(this.lower);
    result = (prime * result) + Integer.hashCode(this.upper);
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
    final int value)
  {
    return Integer.compareUnsigned(value, this.lower) >= 0
           && Integer.compareUnsigned(value, this.upper) <= 0;
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
    final UnsignedRangeInclusiveI other)
  {
    NullCheck.notNull(other, "Other range");

    return Integer.compareUnsigned(this.lower, other.lower) >= 0
           && Integer.compareUnsigned(this.upper, other.upper) <= 0;
  }

  @Override public String toString()
  {
    final StringBuilder builder = new StringBuilder(32);
    builder.append("[UnsignedRangeInclusiveI ");
    builder.append(Integer.toUnsignedString(this.lower));
    builder.append(" ");
    builder.append(Integer.toUnsignedString(this.upper));
    builder.append("]");
    return NullCheck.notNull(builder.toString());
  }
}
