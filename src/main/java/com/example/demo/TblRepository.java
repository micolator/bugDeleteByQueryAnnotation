package com.example.demo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRepository extends JpaRepository<Tbl, String> {

	@Modifying
	@Query("delete from Tbl where date < :date")
	int purge(@Param("date") Date date);
}
