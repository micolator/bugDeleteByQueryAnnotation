package com.example.demo;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	@Modifying
	@Query("delete from Student where date < :date")
	int delete(@Param("date") Date date);

	int deleteAllByDateLessThan(Date date);
}
