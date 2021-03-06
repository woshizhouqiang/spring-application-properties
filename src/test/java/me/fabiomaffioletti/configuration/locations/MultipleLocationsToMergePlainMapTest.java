package me.fabiomaffioletti.configuration.locations;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by fmaffioletti on 12/19/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MultipleLocationsToMergePlainMapTest {

    @Autowired
    private MultipleLocationsToMergePlainMap multipleLocationsToMergePlainMap;

    @Test
    public void testItShouldLoadWithSuccess() {
        Map<String, MultipleLocationsToMergeLink> links = multipleLocationsToMergePlainMap.getLinks();
        MultipleLocationsToMergeLink category1 = links.get("category1");
        assertThat(category1.getAllKeys().entrySet(), hasSize(3));
        assertThat(category1.getAllValues().entrySet(), hasSize(3));

        MultipleLocationsToMergeLink category2 = links.get("category2");
        assertThat(category2.getAllKeys().entrySet(), hasSize(3));
        assertThat(category2.getAllValues().entrySet(), hasSize(3));
    }

}
