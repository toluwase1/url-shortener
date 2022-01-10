package com.toluthomas.urlshortener.services;

import com.toluthomas.urlshortener.model.Url;
import com.toluthomas.urlshortener.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public String getOriginalUrl(String id) {
        return urlRepository.findByShortUrl(id);
    }

    public Url generateShortUrl(String url) {
        Url urlObject = new Url();
        urlObject.setShortUrl(getOriginalUrl(url));
        urlObject.setOriginalUrl(url);
        return urlRepository.save(urlObject);
    }
}
