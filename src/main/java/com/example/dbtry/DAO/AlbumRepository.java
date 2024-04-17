package com.example.dbtry.DAO;

import com.example.dbtry.entity.MyAlbum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<MyAlbum, Long> {
    MyAlbum findByNameIgnoreCase (String name);

}
