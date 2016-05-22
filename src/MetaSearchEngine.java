/**
 *
 * (c) 2013-2016 Wishtack
 *
 * $Id: $
 */

import java.util.ArrayList;
import java.util.List;

public class MetaSearchEngine {

    private ISearchEngine[] _searchEngineList;

    MetaSearchEngine(ISearchEngine[] searchEngineList) {
        this._searchEngineList = searchEngineList;
    }

    public List<String> search(String keywords) {

        List<String> resultList = new ArrayList<>();

        for(ISearchEngine searchEngine : this._searchEngineList) {
            resultList.addAll(searchEngine.search(keywords));
        }

        return resultList;

    }

}
