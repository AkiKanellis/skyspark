package com.akikanellis.skyspark.api.test_utils.assertions;

import com.akikanellis.skyspark.api.algorithms.Point;
import org.apache.spark.api.java.JavaRDD;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import java.util.List;

public class PointRddAssert extends AbstractAssert<PointRddAssert, JavaRDD<Point>> {

    PointRddAssert(JavaRDD<Point> actual) { super(actual, PointRddAssert.class); }

    static PointRddAssert assertThat(JavaRDD<Point> actual) { return new PointRddAssert(actual); }

    /**
     * Verifies that the actual RDD contains only the given values and nothing else, <b>in any order</b>.
     *
     * @param values the given values.
     * @return {@code this} assertion object.
     * @throws NullPointerException     if the given argument is {@code null}.
     * @throws IllegalArgumentException if the given argument is an empty array.
     * @throws AssertionError           if the actual RDD is {@code null}.
     * @throws AssertionError           if the actual RDD does not contain the given values, i.e. the actual RDD
     *                                  contains some or none of the given values, or the actual RDD contains more
     *                                  values than the given ones.
     * @see org.assertj.core.api.AbstractIterableAssert#containsOnly(Object[])
     */
    public PointRddAssert containsOnly(Point... values) {
        isNotNull();

        List<Point> actualList = actual.collect();

        Assertions.assertThat(actualList).containsOnly(values);

        return this;
    }

    /**
     * Same semantic as {@link #containsOnly(Point[])} : verifies that actual contains all the elements of the given
     * RDD and nothing else, <b>in any order</b>.
     *
     * @param expected the given {@code JavaRDD<Point>} we will get elements from.
     * @see org.assertj.core.api.AbstractIterableAssert#containsOnlyElementsOf(Iterable)
     */
    public PointRddAssert containsOnlyElementsOf(JavaRDD<Point> expected) {
        isNotNull();

        List<Point> actualList = actual.collect();
        List<Point> expectedList = expected.collect();

        Assertions.assertThat(actualList).containsOnlyElementsOf(expectedList);

        return this;
    }

    /**
     * Verifies that the actual RDD contains only the given values and nothing else, <b>in order</b>.<br>
     * This assertion should only be used with RDDs that have a consistent iteration order, prefer
     * {@link #containsOnly(Point...)} in that case).
     *
     * @param values the given values.
     * @return {@code this} assertion object.
     * @throws NullPointerException if the given argument is {@code null}.
     * @throws AssertionError       if the actual RDD is {@code null}.
     * @throws AssertionError       if the actual RDD does not contain the given values with same order, i.e. the
     *                              actual RDD contains some or none of the given values, or the actual RDD contains
     *                              more values than the given ones or values are the same but the order is not.
     * @see org.assertj.core.api.AbstractIterableAssert#containsExactly(Object[])
     */
    public PointRddAssert containsExactly(@SuppressWarnings("unchecked") Point... values) {
        isNotNull();

        List<Point> actualList = actual.collect();

        Assertions.assertThat(actualList).containsExactly(values);

        return this;
    }

    /**
     * Same as {@link #containsExactly(Point...)} but handle the {@link Iterable} to array conversion : verifies that
     * actual contains all the elements of the given RDD and nothing else <b>in the same order</b>.
     *
     * @param expected the given {@code JavaRDD<Point2D>} we will get elements from.
     * @see org.assertj.core.api.AbstractIterableAssert#containsExactlyElementsOf(Iterable)
     */
    public PointRddAssert containsExactlyElementsOf(JavaRDD<Point> expected) {
        isNotNull();

        List<Point> actualList = actual.collect();
        List<Point> expectedList = expected.collect();

        Assertions.assertThat(actualList).containsExactlyElementsOf(expectedList);

        return this;
    }
}
