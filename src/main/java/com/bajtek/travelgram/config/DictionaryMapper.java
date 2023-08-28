package com.bajtek.travelgram.config;

import com.bajtek.travelgram.entity.Country;
import com.bajtek.travelgram.entity.DictItem;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DictionaryMapper {

    public List<DictItem> mapCountries(Country[] countries) {
        return Arrays.stream(countries)
                .map(c -> new DictItem(c.getDisplayName(), c.name()))
                .toList();
    }
}