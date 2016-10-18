package com.akikanellis.skyspark.performance.parsing;

import com.akikanellis.skyspark.api.algorithms.SkylineAlgorithm;
import com.akikanellis.skyspark.api.algorithms.bitmap.Bitmap;
import com.akikanellis.skyspark.api.algorithms.bnl.BlockNestedLoop;
import com.akikanellis.skyspark.api.algorithms.sfs.SortFilterSkyline;
import com.beust.jcommander.ParameterException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SkylineAlgorithmConverterTest {

    SkylineAlgorithmConverter skylineAlgorithmConverter;

    @Before
    public void setUp() {
        skylineAlgorithmConverter = new SkylineAlgorithmConverter();
    }

    @Test
    public void bnl_returnBlockNestedLoop() {
        SkylineAlgorithm skylineAlgorithm = skylineAlgorithmConverter.convert(SkylineAlgorithmConverter.ALIAS_BLOCK_NESTED_LOOP);

        assertThat(skylineAlgorithm).isExactlyInstanceOf(BlockNestedLoop.class);
    }

    @Test
    public void sfs_returnSortFilterSkyline() {
        SkylineAlgorithm skylineAlgorithm = skylineAlgorithmConverter.convert(SkylineAlgorithmConverter.ALIAS_SORT_FILTER_SKYLINE);

        assertThat(skylineAlgorithm).isExactlyInstanceOf(SortFilterSkyline.class);
    }

    @Test
    public void bitmap_returnBitmap() {
        SkylineAlgorithm skylineAlgorithm = skylineAlgorithmConverter.convert(SkylineAlgorithmConverter.ALIAS_BITMAP);

        assertThat(skylineAlgorithm).isExactlyInstanceOf(Bitmap.class);
    }

    @Test(expected = ParameterException.class)
    public void unknown_throwException() {
        skylineAlgorithmConverter.convert("random string");
    }
}