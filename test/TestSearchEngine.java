/**
 *
 * (c) 2013-2016 Wishtack
 *
 * $Id: $
 */

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class TestSearchEngine {

    @Test
    public void testSearch() {

        ISearchEngine mockSearchEngine = Mockito.mock(ISearchEngine.class);
        ISearchEngine[] searchEngineList = new ISearchEngine[2];
        List<String> resultList = new ArrayList<>();

        searchEngineList[0] = mockSearchEngine;
        searchEngineList[1] = mockSearchEngine;

        resultList.add("RESULT_1");
        resultList.add("RESULT_2");
        when(mockSearchEngine.search("test")).thenReturn(resultList);

        resultList = new MetaSearchEngine(searchEngineList).search("test");

        assertEquals(4, resultList.size());
        assertEquals("RESULT_1", resultList.get(0));
        assertEquals("RESULT_2", resultList.get(1));
        assertEquals("RESULT_1", resultList.get(2));
        assertEquals("RESULT_2", resultList.get(3));

    }

}
