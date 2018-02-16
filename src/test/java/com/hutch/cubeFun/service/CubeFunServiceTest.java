package com.hutch.cubeFun.service;

import com.hutch.cubeFun.model.Cublet;
import com.hutch.cubeFun.model.Row;
import com.hutch.cubeFun.model.Slice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

@RunWith(BlockJUnit4ClassRunner.class)
public class CubeFunServiceTest {
    public CubeFunService cubeFunService;

    @Before
    public void setUp() throws Exception {
        cubeFunService = new CubeFunService();
    }

    @Test
    public void analyze_returnsFour_whenInputisFirstTest(){
        Cublet[] cublets = new Cublet[]{Cublet.builder().id(0).value(1).build(), Cublet.builder().id(1).value(0).build(), Cublet.builder().id(2).value(3).build()};
        Row[] rows = new Row[]{Row.builder().id(0).column(cublets).build()};
        Slice[] slice = new Slice[]{Slice.builder().id(0).row(rows).build()};

        int actual = cubeFunService.analyze(slice);

        assertThat(actual, equalTo(4));
    }

    @Test
    public void analyze_returns12_whenInputIsSecondTest(){
        Cublet[] cublets1 = new Cublet[]{Cublet.builder().id(0).value(1).build(),
                Cublet.builder().id(1).value(2).build(),
                Cublet.builder().id(2).value(3).build()};
        Cublet[] cublets2 = new Cublet[]{Cublet.builder().id(0).value(4).build(),
                Cublet.builder().id(1).value(0).build(),
                Cublet.builder().id(2).value(6).build()};
        Row[] rows = new Row[]{Row.builder().id(0).column(cublets1).build(),
                Row.builder().id(1).column(cublets2).build()};
        Slice[] slice = new Slice[]{Slice.builder().id(0).row(rows).build()};

        int actual = cubeFunService.analyze(slice);

        assertThat(actual, equalTo(12));
    }


}