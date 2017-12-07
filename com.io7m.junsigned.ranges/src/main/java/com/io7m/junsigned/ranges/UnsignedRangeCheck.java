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

import com.io7m.jranges.RangeCheckException;
import com.io7m.junreachable.UnreachableCodeException;

import java.util.Objects;

/**
 * <p>Functions for enforcing range constraints at run time.</p>
 *
 * <p> The functions are intended for use in the manner of assertions. That is,
 * the program should behave identically if all of the checks are removed. The
 * functions raise {@link RangeCheckException} upon failure. Exceptions of this
 * type are <i>not</i> intended to be caught and handled; they indicate program
 * bugs.</p>
 *
 * @see RangeCheckException
 */

public final class UnsignedRangeCheck
{
  private UnsignedRangeCheck()
  {
    throw new UnreachableCodeException();
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is greater than {@code
   * in_lower} (named {@code lower_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static long checkGreaterLong(
    final long x,
    final String x_name,
    final long in_lower,
    final String lower_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(lower_name, "Lower bound name");

    if (Long.compareUnsigned(x, in_lower) > 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) <= %s (%s)",
      x_name,
      Long.toUnsignedString(x),
      lower_name,
      Long.toUnsignedString(in_lower));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is greater than or equal to
   * {@code in_lower} (named {@code lower_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of x
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static long checkGreaterEqualLong(
    final long x,
    final String x_name,
    final long in_lower,
    final String lower_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(lower_name, "Lower bound name");

    if (Long.compareUnsigned(x, in_lower) >= 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) < %s (%s)",
      x_name,
      Long.toUnsignedString(x),
      lower_name,
      Long.toUnsignedString(in_lower));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is less than {@code
   * in_upper} (named {@code upper_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static long checkLessLong(
    final long x,
    final String x_name,
    final long in_upper,
    final String upper_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(upper_name, "Upper bound name");

    if (Long.compareUnsigned(x, in_upper) < 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) >= %s (%s)",
      x_name,
      Long.toUnsignedString(x),
      upper_name,
      Long.toUnsignedString(in_upper));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is less than or equal to
   * {@code in_upper} (named {@code upper_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of x
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static long checkLessEqualLong(
    final long x,
    final String x_name,
    final long in_upper,
    final String upper_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(upper_name, "Upper bound name");

    if (Long.compareUnsigned(x, in_upper) <= 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) > %s (%s)",
      x_name,
      Long.toUnsignedString(x),
      upper_name,
      Long.toUnsignedString(in_upper));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is greater than {@code
   * in_lower} (named {@code lower_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of the checked value
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static int checkGreaterInteger(
    final int x,
    final String x_name,
    final int in_lower,
    final String lower_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(lower_name, "Lower bound name");

    if (Integer.compareUnsigned(x, in_lower) > 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) <= %s (%s)",
      x_name,
      Integer.toUnsignedString(x),
      lower_name,
      Integer.toUnsignedString(in_lower));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is greater than or equal to
   * {@code in_lower} (named {@code lower_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_lower   The lower bound
   * @param x_name     The name of x
   * @param lower_name The name of the lower bound
   *
   * @return x
   */

  public static int checkGreaterEqualInteger(
    final int x,
    final String x_name,
    final int in_lower,
    final String lower_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(lower_name, "Lower bound name");

    if (Integer.compareUnsigned(x, in_lower) >= 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) < %s (%s)",
      x_name,
      Integer.toUnsignedString(x),
      lower_name,
      Integer.toUnsignedString(in_lower));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is less than {@code
   * in_upper} (named {@code upper_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of the checked value
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static int checkLessInteger(
    final int x,
    final String x_name,
    final int in_upper,
    final String upper_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(upper_name, "Upper bound name");

    if (Integer.compareUnsigned(x, in_upper) < 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) >= %s (%s)",
      x_name,
      Integer.toUnsignedString(x),
      upper_name,
      Integer.toUnsignedString(in_upper));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p>Assert that {@code x} (named {@code x_name}) is less than or equal to
   * {@code in_upper} (named {@code upper_name}).</p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param in_upper   The upper bound
   * @param x_name     The name of x
   * @param upper_name The name of the upper bound
   *
   * @return x
   */

  public static int checkLessEqualInteger(
    final int x,
    final String x_name,
    final int in_upper,
    final String upper_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(upper_name, "Upper bound name");

    if (Integer.compareUnsigned(x, in_upper) <= 0) {
      return x;
    }

    final String message = String.format(
      "%s (%s) > %s (%s)",
      x_name,
      Integer.toUnsignedString(x),
      upper_name,
      Integer.toUnsignedString(in_upper));
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in the given
   * range {@code range} (named {@code range_name}). </p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   */

  public static long checkIncludedInLong(
    final long x,
    final String x_name,
    final UnsignedRangeInclusiveL range,
    final String range_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(range, "Range");
    Objects.requireNonNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final String message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      Long.toUnsignedString(range.lower()),
      x_name,
      Long.toUnsignedString(x),
      Long.toUnsignedString(range.upper()),
      range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code x} (named {@code x_name}) is included in the given
   * range {@code range} (named {@code range_name}). </p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param x          The checked value
   * @param x_name     The name of the checked value
   * @param range      The inclusive range
   * @param range_name The name of the inclusive range
   *
   * @return x
   */

  public static int checkIncludedInInteger(
    final int x,
    final String x_name,
    final UnsignedRangeInclusiveI range,
    final String range_name)
  {
    Objects.requireNonNull(x_name, "Value name");
    Objects.requireNonNull(range, "Range");
    Objects.requireNonNull(range_name, "Range name");

    if (range.includesValue(x)) {
      return x;
    }

    final String message = String.format(
      "%s <= %s (%s) <= %s (%s) == false",
      Integer.toUnsignedString(range.lower()),
      x_name,
      Integer.toUnsignedString(x),
      Integer.toUnsignedString(range.upper()),
      range_name);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is included in the
   * given range {@code outer} (named {@code outer_name}). </p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   */

  public static UnsignedRangeInclusiveL checkRangeIncludedInLong(
    final UnsignedRangeInclusiveL inner,
    final String inner_name,
    final UnsignedRangeInclusiveL outer,
    final String outer_name)
  {
    Objects.requireNonNull(inner, "Inner range");
    Objects.requireNonNull(inner_name, "Inner range name");
    Objects.requireNonNull(outer, "Outer range");
    Objects.requireNonNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final String message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);
    assert message != null;
    throw new RangeCheckException(message);
  }

  /**
   * <p> Assert that {@code inner} (named {@code inner_name}) is included in the
   * given range {@code outer} (named {@code outer_name}). </p>
   *
   * <p>The values in question are assumed to be unsigned when performing the
   * comparison.</p>
   *
   * @param inner      The checked range
   * @param inner_name The name of the checked range
   * @param outer      The outer range
   * @param outer_name The name of the outer range
   *
   * @return inner
   */

  public static UnsignedRangeInclusiveI checkRangeIncludedInInteger(
    final UnsignedRangeInclusiveI inner,
    final String inner_name,
    final UnsignedRangeInclusiveI outer,
    final String outer_name)
  {
    Objects.requireNonNull(inner, "Inner range");
    Objects.requireNonNull(inner_name, "Inner range name");
    Objects.requireNonNull(outer, "Outer range");
    Objects.requireNonNull(outer_name, "Outer range name");

    if (inner.isIncludedIn(outer)) {
      return inner;
    }

    final String message = String.format(
      "Inner range %s (%s) not included in outer range %s (%s)",
      inner_name,
      inner,
      outer_name,
      outer);
    assert message != null;
    throw new RangeCheckException(message);
  }
}
