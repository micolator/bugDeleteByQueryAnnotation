package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Commit
public class StudentRepositoryTest {

	@Autowired
	private StudentRepository repo;

	@Test
	public void delete_byQueryAnnotation() {
		delete(repo::delete);
	}

	@Test
	public void delete_byMethodName() {
		delete(repo::deleteAllByDateLessThan);
	}

	private void delete(final Function<Date, Integer> deleteFunct) {
		Student t1 = new Student("a", "john", new Date(0));
		Date d = new Date(1000);
		Student t2 = new Student("b", "paul", new Date(2000));
		repo.save(t1);
		repo.save(t2);

		deleteFunct.apply(d);

		assertNull(repo.findById("a").orElse(null));
	}
}