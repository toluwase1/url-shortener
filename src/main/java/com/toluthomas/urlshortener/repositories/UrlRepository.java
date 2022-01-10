package com.toluthomas.urlshortener.repositories;

import com.toluthomas.urlshortener.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UrlRepository extends JpaRepository<Url, Integer> {

    @Query(value = "select originalUrl from Url where shortUrl = ?1", nativeQuery = true)
    String findByShortUrl(String id);
//    String findByShortUrl(String id);
}
