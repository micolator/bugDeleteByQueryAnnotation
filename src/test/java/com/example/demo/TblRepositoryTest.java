package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TblRepositoryTest {

	@Autowired
	private TblRepository repo;

	@Test
	public void purge() {
		Tbl t1 = new Tbl("a", new Date(0));
		Date d = new Date(1000);
		Tbl t2 = new Tbl("b", new Date(2000));
		repo.save(t1);
		repo.save(t2);

		repo.purge(d);

		assertNull(repo.findById("a").orElse(null));
	}
}