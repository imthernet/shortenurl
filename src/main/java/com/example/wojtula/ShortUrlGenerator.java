package com.example.wojtula;

import java.util.ArrayList;
import com.google.common.io.BaseEncoding;
import com.google.common.primitives.Ints;

public class ShortUrlGenerator {

    private final ArrayList<String> urlList;

    public ShortUrlGenerator() {
        this.urlList = new ArrayList<>();
    }

    public String shortenUrl(String longUrl) {
       urlList.add(longUrl);
       int urlId = urlList.size()-1;
       return BaseEncoding.base32().lowerCase().omitPadding().encode(Ints.toByteArray(urlId));
    }

    public String decode(String shortUrl) {
        int urlId = Ints.fromByteArray(BaseEncoding.base32().lowerCase().omitPadding().decode(shortUrl));
        return urlList.get(urlId);
    }
}
