package com.example.dbtry.DAO;

import com.example.dbtry.entity.MyArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<MyArtist, Long> {
    MyArtist findByNameIgnoreCase (String name);
    List<MyArtist> findTop8ByOrderByListenersDesc();
}
