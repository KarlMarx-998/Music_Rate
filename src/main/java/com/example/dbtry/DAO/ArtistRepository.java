package com.example.dbtry.DAO;

import com.example.dbtry.entity.MyArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<MyArtist, Long> {
}
